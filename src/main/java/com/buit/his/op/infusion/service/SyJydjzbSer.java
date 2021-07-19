package com.buit.his.op.infusion.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.*;
import com.buit.commons.model.SyCfzxqk;
import com.buit.commons.model.SyJydjUser;
import com.buit.commons.model.SyJydjmx;
import com.buit.commons.model.SyJydjzb;
import com.buit.commons.request.*;
import com.buit.commons.response.*;
import com.buit.his.op.reg.enums.SydjConsts;
import com.buit.utill.MzUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 输液/注射接药登记主表<br>
 * 
 * @author WY
 */
@Service
public class SyJydjzbSer extends BaseManagerImp<SyJydjzb, String> {

	static final Logger logger = LoggerFactory.getLogger(SyJydjzbSer.class);

	@Autowired
	private SyJydjzbDao syJydjzbDao;

	@Autowired
	private SyKsDao syKsDao;

	@Autowired
	private SyJydjmxDao syJydjmxDao;

	@Autowired
	private SyCfzxqkDao syCfzxqkDao;

	@Autowired
	private OpCf02Dao opCf02Dao;

	@Override
	public SyJydjzbDao getEntityMapper() {
		return syJydjzbDao;
	}

	/**
	 * 输液接药分页查询
	 * 
	 * @param req
	 * @return
	 */
	public List<QuerySyJydjzbResp> doQuerySyJydjList(QuerySyJydjzbReq req) {
		SyJydjzb syJydjzb = new SyJydjzb();
		BeanUtils.copyProperties(req, syJydjzb);
		List<QuerySyJydjzbResp> resultList = syJydjzbDao.doQuerySyJydjList(syJydjzb);
		for (QuerySyJydjzbResp resp : resultList) {
			if (resp.getCsny() != null) {
				Map<String, Object> agMap = MzUtil.getPersonAge(resp.getCsny(), null);
				if (agMap != null && !agMap.isEmpty()) {
					resp.setAge(agMap.get("ages").toString());
				}
			}
		}
		return resultList;
	}

	/**
	 * 查询病人已收费、已发药、未输液的输液处方
	 * 
	 * @param req
	 * @return
	 */
	public UnRegistResp doQueryUnregistList(QueryUnregistReq req) {
		UnRegistResp resp = new UnRegistResp();
		SyJydjzb syJydjzb = new SyJydjzb();
		if (req.getBeginDay() != null && req.getEndDay() != null) {
			syJydjzb.setBeginDay(DateUtil.beginOfDay(req.getBeginDay()).toTimestamp());
			syJydjzb.setEndDay(DateUtil.endOfDay(req.getEndDay()).toTimestamp());
			req.setSyrq(DateUtil.date().toSqlDate());
		}
		BeanUtils.copyProperties(req, syJydjzb);
		// 查询登记用户信息
		List<SyJydjUser> syJydjUser = syJydjzbDao.doQuerySyDjUser(syJydjzb);
		if (syJydjUser == null || syJydjUser.isEmpty()) {
			return resp;
		}

		Map<String, Object> agMap = MzUtil.getPersonAge(syJydjUser.get(0).getCsny(), null);
		if (agMap != null && !agMap.isEmpty()) {
			syJydjUser.get(0).setAge(agMap.get("ages") != null ? agMap.get("ages").toString() : "");
		}

		// 查询用户已开处方信息
		List<QueryUnRegistResp> resultList = syJydjzbDao.doQueryUnregistList(syJydjzb);

		// 数据根据发票号码分组重组
//		List<List<QueryUnRegistResp>> result = new ArrayList<List<QueryUnRegistResp>>();
//		Map<String, List<QueryUnRegistResp>> fphmMap = new TreeMap<String, List<QueryUnRegistResp>>();
//		for (QueryUnRegistResp registResp : resultList) {
//			if (fphmMap.containsKey(registResp.getFphm())) {
//				List<QueryUnRegistResp> t = fphmMap.get(registResp.getFphm());
//				t.add(registResp);
//				new ArrayList<QueryUnRegistResp>().add(registResp);
//				fphmMap.put(registResp.getFphm(), t);
//			} else {
//				List<QueryUnRegistResp> t = new ArrayList<QueryUnRegistResp>();
//				t.add(registResp);
//				fphmMap.put(registResp.getFphm(), t);
//			}
//		}
//		for (Entry<String, List<QueryUnRegistResp>> entry : fphmMap.entrySet()) {
//			result.add(entry.getValue());
//		}

		// 返回信息
		resp.setSyJydjUser(syJydjUser.get(0));
		resp.setResultList(resultList);
//		resp.setResultList(result);
		return resp;
	}

	/**
	 * 输液登记
	 * 
	 * @param req
	 */
	@Transactional(rollbackFor = Exception.class)
	public String doSySaveRegist(SaveRegistReq req) {
		// 判断是否有同组药品正在输液中
		if (req.getCfList() != null && !req.getCfList().isEmpty()) {
			for (SaveCfRegistReq cfRegist : req.getCfList()) {
				SyJydjmx syJydjmx = new SyJydjmx();
				BeanUtils.copyProperties(cfRegist, syJydjmx);
				syJydjmx.setKslb(req.getKslb());
				Integer isExist = syJydjmxDao.doExistSyProcessing(syJydjmx);
				if (isExist != null && isExist.intValue() > 0) {
					throw BaseException.create("ERROR_INFUSION_0002");
				}
			}
		}

		// 插入登记主表
		SyJydjzb syJydjzb = new SyJydjzb();
		syJydjzb.setJgid(req.getJgid());
		syJydjzb.setKsdm(req.getKsdm());
		syJydjzb.setKslb(req.getKslb());
		syJydjzb.setBrid(req.getBrid());
		syJydjzb.setJzkh(req.getJzkh());
		syJydjzb.setDjrdm(req.getDjrdm());
		syJydjzb.setDjsj(DateUtil.date().toTimestamp());
		syJydjzb.setSyrq(DateUtil.date().toSqlDate());
		syJydjzb.setZt(SydjConsts.SYDJZT.WAITTING.getKey());
		// 生成登记单号
		String djdh = getDjdh(req.getJgid(), req.getKsdm(), req.getKslb());
		syJydjzb.setDjdh(djdh);
		syJydjzbDao.insert(syJydjzb);

		// 插入明细表
		if (req.getCfList() != null && !req.getCfList().isEmpty()) {
			//输液条码
			//key: 处方号码-处方组号, value: 输液条码
			Map<String, String> sytmMap = new HashMap<>();

			//分组，输液登记明细xh
			Map<String, Integer> symxxhMap = new HashMap<>();

			for (SaveCfRegistReq cfRegist : req.getCfList()) {

				//输液条码
				String sytmMapKey = StrUtil.join("-", cfRegist.getCfhm(), cfRegist.getCfzh());

				//首次循环时候map为空
				if(CollUtil.isEmpty(sytmMap)){
					sytmMap.put(sytmMapKey, djdh);
					// 科室顺序号加1
					getNextSxh(req.getJgid(), req.getKsdm(), req.getKslb());

				}else if(!sytmMap.containsKey(sytmMapKey)){
					sytmMap.put(sytmMapKey, getDjdh(req.getJgid(), req.getKsdm(), req.getKslb()));
					// 科室顺序号加1
					getNextSxh(req.getJgid(), req.getKsdm(), req.getKslb());
				}

				SyJydjmx syJydjmx = new SyJydjmx();
				BeanUtils.copyProperties(cfRegist, syJydjmx);
				syJydjmx.setDjdh(djdh);
				syJydjmx.setSytm(sytmMap.get(sytmMapKey));
				syJydjmx.setJgid(req.getJgid());
				syJydjmx.setKsdm(req.getKsdm());
				// 每日输液序号从1开始 每次登记同组处方加1
				syJydjmx.setBeginDay(DateUtil.beginOfDay(DateUtil.date()).toTimestamp());
				syJydjmx.setEndDay(DateUtil.endOfDay(DateUtil.date()).toTimestamp());
				syJydjmx.setKslb(req.getKslb());
				Integer syxh = syJydjmxDao.getMaxSyxh(syJydjmx);


				if (CollUtil.isEmpty(symxxhMap) || !symxxhMap.containsKey(sytmMapKey)) {
					syJydjmx.setXh(syxh + 1);
					symxxhMap.put(sytmMapKey, syJydjmx.getXh());
				} else {
					syJydjmx.setXh(syxh);
				}

				// 插入明细表
				syJydjmxDao.insert(syJydjmx);

				// 插入处方执行情况表
				SyCfzxqk syCfzxqk = new SyCfzxqk();
				BeanUtils.copyProperties(syJydjmx, syCfzxqk);
				// 更新执行次数
				int xyzxzcs = cfRegist.getXyzxzcs() != null ? Integer.parseInt(cfRegist.getXyzxzcs().toString()) : 0;
				int yzxcs = cfRegist.getYzxcs() != null ? Integer.parseInt(cfRegist.getYzxcs().toString()) : 0;
				syCfzxqk.setYzxcs(yzxcs);
				syCfzxqk.setXyzxzcs(xyzxzcs);
				// 查询处方是否登记过 有则更新 没有则插入
				Integer zxqkCount = syCfzxqkDao.getZxqkCountByCondition(req.getJgid(), cfRegist.getCfhm(),
						cfRegist.getCfzh());
				if (zxqkCount != null && zxqkCount.intValue() > 0) {
					if (xyzxzcs > yzxcs) {
						syCfzxqkDao.updateZxcs(syCfzxqk);
					}
				} else {
					syCfzxqk.setYzxcs(yzxcs + 1);
					syCfzxqkDao.insert(syCfzxqk);
				}
				// 更新处方表输液次数+1
				opCf02Dao.updateZxcs(yzxcs, cfRegist.getCfhm(), cfRegist.getCfzh(), cfRegist.getYpxh());
			}
		}

		return djdh;
	}

	/**
	 * 获取登记单号
	 * 
	 * @param ksdm
	 * @param tmscgz
	 * @param qz
	 * @param sxhws
	 * @param xysxh
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public String getDjdh(Integer jgid, Integer ksdm, String kslb) {
		String djdh = null;
		// 根据机构ID和输液科室代码确定一条输液科室规则
		List<SyKsResp> syksList = syKsDao.doQuerySyksList(jgid, ksdm, kslb, "0");
		if (syksList != null && !syksList.isEmpty()) {
			SyKsResp syks = syksList.get(0);
			// 下一顺序号
			String xysxh = syks.getXysxh();
			// 顺序号位数
			int length = syks.getSxhws();
			StringBuffer sb = new StringBuffer(xysxh);
			sb = sb.reverse();
			String xysxhNew = sb.toString();
			int slen = length;
			for (int i = 0; i < length; i++) {
				char n = xysxhNew.charAt(i);
				if (n < 48 || n > 57) {
					slen = i;
					break;
				}
			}
			String sz = xysxh.substring(xysxh.length() - slen);
			long intnewsz = Long.parseLong(sz);
			String sxh = String.format("%0" + (slen) + "d", intnewsz);

			if (syks.getTmscgz() != null) {
				if ("1".equals(syks.getTmscgz())) {
					djdh = StrUtil.join("", DateUtil.year(DateUtil.date()), sxh);
				} else if ("2".equals(syks.getTmscgz())) {
					djdh = StrUtil.join("", DateUtil.year(DateUtil.date()) , DateUtil.month(DateUtil.date()) +1 , sxh);
				} else if ("3".equals(syks.getTmscgz())) {
					djdh = StrUtil.join("",DateUtil.year(DateUtil.date()) , DateUtil.month(DateUtil.date()) +1,
							MzUtil.toString(DateUtil.date().toSqlDate(), "yyyyMMdd") , sxh);
				} else if ("4".equals(syks.getTmscgz())) {
					djdh = StrUtil.join("",syks.getQz() , sxh);
				}
			}
		} else {
			throw BaseException.create("ERROR_INFUSION_0003");
		}
		return djdh;
	}

	/**
	 * 输液科室顺序号加1
	 * 
	 * @param jgid
	 * @param ksdm
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public void getNextSxh(Integer jgid, Integer ksdm, String kslb) {
		// 根据机构ID和输液科室代码确定一条输液科室规则
		List<SyKsResp> syksList = syKsDao.doQuerySyksList(jgid, ksdm, kslb, "0");
		if (syksList != null && !syksList.isEmpty()) {
			SyKsResp syks = syksList.get(0);
			// 下一顺序号
			String xysxh = syks.getXysxh();
			// 顺序号位数
			int length = syks.getSxhws();
			StringBuffer sb = new StringBuffer(xysxh);
			sb = sb.reverse();
			String xysxhNew = sb.toString();
			int slen = length;
			for (int i = 0; i < length; i++) {
				char n = xysxhNew.charAt(i);
				if (n < 48 || n > 57) {
					slen = i;
					break;
				}
			}
			String sz = xysxh.substring(xysxh.length() - slen);
			long intnewsz = Long.parseLong(sz) + 1;
			String sxh = String.format("%0" + (slen) + "d", intnewsz);
			syKsDao.doUpdateNextSxh(jgid, ksdm, sxh, kslb);
		} else {
			throw BaseException.create("ERROR_INFUSION_0003");
		}

	}

	/**
	 * 查询病人的输液处方
	 * 
	 * @param djdh
	 * @param jgid
	 * @return
	 */
	public List<QueryUnRegistResp> doQueryRegistList(String djdh, Integer ksdm, Integer jgid) {
		return syJydjmxDao.doQueryRegistList(djdh, ksdm, jgid);
	}

	/**
	 * 开始输液
	 */
	@Transactional
	public void startShuYe(String djdhs, Integer jgid, Integer userId) {
		syJydjzbDao.startShuYe(djdhs, jgid, userId, DateUtil.date().toTimestamp());
	}

	/**
	 * 输液完成
	 * @param djdhs
	 * @param jgid
	 */
	public void doUpdateSyZt(String djdhs, Integer jgid, Integer userId) {
		List<QuerySyJydjzbResp> list = syJydjzbDao.findByDjdhs(jgid, djdhs);
		if(CollUtil.isEmpty(list)){
			return;
		}

		//如果是注射,同步更新开始时间和开始人
		List<String> zhusheDjdhs = new ArrayList<>();
		for (QuerySyJydjzbResp resp : list) {
			if(resp.getKslb().equals(SydjConsts.KSLB.ZHUSHE.getKey())){
				zhusheDjdhs.add(resp.getDjdh());
			}
		}

		if(CollUtil.isNotEmpty(zhusheDjdhs)){
			syJydjzbDao.startShuYe(String.join(",", zhusheDjdhs), jgid, userId, DateUtil.date().toTimestamp());
		}

		syJydjzbDao.doUpdateSyZt(djdhs, jgid, userId, DateUtil.date().toTimestamp());
	}

	/**
	 * 输液注射工作量统计人次
	 * 
	 * @param req
	 * @return
	 */
	public List<QueryAllDjCountResp> doQueryAllDjCount(@Valid QueryAllDjCountReq req) {
		SyJydjzb syJydjzb = new SyJydjzb();
		BeanUtils.copyProperties(req, syJydjzb);
		syJydjzb.setBeginDay(DateUtil.beginOfDay(req.getBeginDay()).toTimestamp());
		syJydjzb.setEndDay(DateUtil.endOfDay(req.getEndDay()).toTimestamp());
		return syJydjzbDao.doQueryAllDjCount(syJydjzb);
	}

	/**
	 * 输液注射工作量统计每日输液数据
	 * 
	 * @param req
	 * @return
	 */
	public List<QueryDjCfListResp> doQueryDjCfList(@Valid QueryDjCfListReq req) {
		SyJydjzb syJydjzb = new SyJydjzb();
		BeanUtils.copyProperties(req, syJydjzb);
		syJydjzb.setBeginDay(DateUtil.beginOfDay(DateUtil.date(req.getSyrq())).toTimestamp());
		syJydjzb.setEndDay(DateUtil.endOfDay(DateUtil.date(req.getSyrq())).toTimestamp());
		return syJydjzbDao.doQueryDjCfList(syJydjzb);
	}

	/**
	 * 输液瓶贴打印
	 * 
	 * @param djdh
	 * @param jgid
	 * @return
	 */
	public QuerySyptdyResp doPrintSyptdy(String djdh, String kslb, Integer ksdm, Integer jgid) {
		QuerySyptdyResp syptdy = syJydjzbDao.doQuerySyptdy(djdh, kslb, ksdm, jgid);
		if (syptdy !=null && syptdy.getCsny() != null) {
			Map<String, Object> agMap = MzUtil.getPersonAge(syptdy.getCsny(), null);
			if (agMap != null && !agMap.isEmpty()) {
				syptdy.setAges(agMap.get("ages").toString());
			}
			syptdy.setBrzd(syJydjzbDao.queryBrzd(djdh, kslb, ksdm, jgid));
		}

		if (syptdy != null) {
			List<QueryUnRegistResp> syypList = syJydjmxDao.doQueryRegistList(djdh, ksdm, jgid);
			// 根据序号分组
			Map<Integer, List<QueryUnRegistResp>> maps = syypList.stream()
					.collect(Collectors.groupingBy(QueryUnRegistResp::getXh));
			syptdy.setMaps(maps);
//			syptdy.setList(syypList);
		}

		return syptdy;
	}
}
