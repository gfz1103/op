package com.buit.his.op.infusion.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpCf02Dao;
import com.buit.commons.dao.SkinDjmxDao;
import com.buit.commons.dao.SkinDjzbDao;
import com.buit.commons.dao.SkinPsjlDao;
import com.buit.commons.model.SkinDjmx;
import com.buit.commons.model.SkinDjzb;
import com.buit.commons.model.SkinPsjl;
import com.buit.commons.model.SyJydjUser;
import com.buit.commons.request.*;
import com.buit.commons.response.*;
import com.buit.constans.TableName;
import com.buit.op.response.OpCf02;
import com.buit.utill.MzUtil;
import com.buit.utill.RedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <br>
 *
 * @author WY
 */
@Service
public class SkinDjzbSer extends BaseManagerImp<SkinDjzb, Integer> {

	static final Logger logger = LoggerFactory.getLogger(SkinDjzbSer.class);

	@Autowired
	private SkinDjzbDao skinDjzbDao;

	@Autowired
	private SyJydjzbSer syJydjzbSer;

	@Autowired
	private SkinDjmxDao skinDjmxDao;

	@Autowired
	private OpCf02Dao opCf02Dao;

	@Autowired
	private RedisFactory redisFactory;

	@Autowired
	private SkinPsjlDao skinPsjlDao;

	@Override
	public SkinDjzbDao getEntityMapper() {
		return skinDjzbDao;
	}

	/**
	 * 查询病人已收费、未执行的皮试项目
	 *
	 * @param req
	 * @return
	 */
	public QueryUnSkinTestResp doQueryUnSkinTest(QueryUnSkinTestReq req) {
		QueryUnSkinTestResp resp = new QueryUnSkinTestResp();
		SkinDjzb skinDjzb = new SkinDjzb();
		if (req.getBeginDay() != null && req.getEndDay() != null) {
			skinDjzb.setBeginDay(DateUtil.beginOfDay(req.getBeginDay()).toTimestamp());
			skinDjzb.setEndDay(DateUtil.endOfDay(req.getEndDay()).toTimestamp());
			req.setSfrq(DateUtil.date().toSqlDate());
		}
		BeanUtils.copyProperties(req, skinDjzb);
		// 查询登记用户信息
		List<SyJydjUser> syJydjUser = skinDjzbDao.doQuerySyDjUser(skinDjzb);
		if (syJydjUser == null || syJydjUser.isEmpty()) {
			return resp;
		}
		Map<String, Object> agMap = MzUtil.getPersonAge(syJydjUser.get(0).getCsny(), null);
		if (agMap != null && !agMap.isEmpty()) {
			syJydjUser.get(0).setAge(agMap.get("ages") != null ? agMap.get("ages").toString() : "");
		}
		// 查询皮试项目
		skinDjzb.setIsQueryPsxm(1);
		List<QueryUnPsxmResp> cfList = skinDjzbDao.doQueryUnPsxmList(skinDjzb);

		//处理存在皮试但是未取药的就诊人，给出合理化提示
		List<QueryUnPsxmResp> collect = new ArrayList<>();
		if (CollUtil.isNotEmpty(cfList)){
			collect = cfList.stream().filter(o -> o.getFybz() == 1).collect(Collectors.toList());

			if (CollUtil.isEmpty(collect)){
				throw BaseException.create("ERROR_SKINTEST_0011");
			}
		}

		// 信息返回
		resp.setSyJydjUser(syJydjUser.get(0));
		resp.setCfList(collect);
		return resp;
	}

	/**
	 * 皮试登记
	 *
	 * @param req
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doPsSaveRegist(SavePsRegistReq req) {
		SkinDjzb skinDjzb = new SkinDjzb();
		BeanUtils.copyProperties(req, skinDjzb);
		skinDjzb.setZt("0");
		for (SavePsCfRegistReq psCfRegist : req.getCfList()) {
			skinDjzb.setPsid(psCfRegist.getPsid());
			skinDjzb.setPsmc(psCfRegist.getPsmc());
			skinDjzb.setBeginDay(DateUtil.beginOfDay(DateUtil.date()).toTimestamp());
			skinDjzb.setEndDay(DateUtil.endOfDay(DateUtil.date()).toTimestamp());
			// 获取皮试序号 每日从1开始
			Integer maxPsxh = skinDjzbDao.getMaxPsxhByDay(skinDjzb);
			skinDjzb.setPsxh(maxPsxh);
			skinDjzb.setDjsj(DateUtil.date().toTimestamp());
			// 生成登记单号
			String djdh = syJydjzbSer.getDjdh(req.getJgid(), req.getKsdm(), "2");
			skinDjzb.setDjdh(djdh);
			skinDjzbDao.insert(skinDjzb);

			// 循环插入皮试明细
			List<QueryUnPsdjmxResp> skindjmxList = skinDjzbDao.doQueryUnPsdjmxList(psCfRegist);
			for (QueryUnPsdjmxResp skinDjmxResp : skindjmxList) {
				SkinDjmx skinDjmx = new SkinDjmx();
				skinDjmx.setJgid(req.getJgid());
				skinDjmx.setKsdm(req.getKsdm());
				skinDjmx.setDjdh(djdh);
				skinDjmx.setCfhm(skinDjmxResp.getCfhm());
				skinDjmx.setCfzh(skinDjmxResp.getCfzh());
				skinDjmx.setYpxh(skinDjmxResp.getYpxh());
				skinDjmx.setMzhm(psCfRegist.getMzhm());
				skinDjmx.setFphm(psCfRegist.getFphm());
				skinDjmxDao.insert(skinDjmx);
				// 更新皮试执行状态
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("pszxzt", "1");
				params.put("cfsb", skinDjmx.getCfhm());
				params.put("ypzh", skinDjmx.getCfzh());
				params.put("ypxh", skinDjmx.getYpxh());
				opCf02Dao.updatePszxzt(params);
			}
			// 科室顺序号加1
			syJydjzbSer.getNextSxh(req.getJgid(), req.getKsdm(), "2");
		}
	}

	/**
	 * 皮试列表分页查询
	 *
	 * @param req
	 * @return
	 */
	public List<PsDjResp> doQueryPsDjList(PsDjReq req) {
		SkinDjzb skinDjzb = new SkinDjzb();
		BeanUtils.copyProperties(req, skinDjzb);
		List<PsDjResp> resp = skinDjzbDao.doQueryPsDjList(skinDjzb);
		for (PsDjResp psdj : resp) {
			if (psdj.getCsny() != null) {
				Map<String, Object> agMap = MzUtil.getPersonAge(psdj.getCsny(), null);
				if (agMap != null && !agMap.isEmpty()) {
					psdj.setAges(agMap.get("ages").toString());
				}
			}

		}
		return resp;
	}

	/**
	 * 开始皮试
	 *
	 * @param req
	 */
	public void doPsProcess(PsProcessReq req) {
		// 根据登记单号查询皮试信息
		SkinDjzb skinDjzbInfo = skinDjzbDao.doQueryPsDjByDjdh(req.getJgid(), req.getKsdm(), req.getDjdh());
		if (skinDjzbInfo == null) {
			throw BaseException.create("ERROR_SKINTEST_0008");
		}
		SkinDjzb skinDjzb = new SkinDjzb();
		BeanUtils.copyProperties(req, skinDjzb);
		skinDjzb.setKssj(DateUtil.date().toTimestamp());
		skinDjzb.setZt("1");
		skinDjzbDao.updateZt(skinDjzb);
	}

	/**
	 * 取消皮试
	 *
	 * @param req
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doPsCancel(PsProcessReq req) {
		// 根据登记单号查询皮试信息
		SkinDjzb skinDjzbInfo = skinDjzbDao.doQueryPsDjByDjdh(req.getJgid(), req.getKsdm(), req.getDjdh());
		if (skinDjzbInfo != null) {
			if (!"0".equals(skinDjzbInfo.getZt())) {
				throw BaseException.create("ERROR_SKINTEST_0007");
			}
		}
		SkinDjmx djmx = new SkinDjmx();
		BeanUtils.copyProperties(req, djmx);
		List<SkinDjmx> skinDjmxList = skinDjmxDao.doQuerySkinDjmxByDjdh(djmx);
		for (SkinDjmx djmxInfo : skinDjmxList) {
			// 更新皮试执行状态
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("pszxzt", "0");
			params.put("cfsb", djmxInfo.getCfhm());
			params.put("ypzh", djmxInfo.getCfzh());
			params.put("ypxh", djmxInfo.getYpxh());
			opCf02Dao.updatePszxzt(params);
		}

		// 删除登记明细表
		SkinDjmx skinDjmx = new SkinDjmx();
		BeanUtils.copyProperties(req, skinDjmx);
		skinDjmxDao.deleteByDjdh(skinDjmx);

		// 删除登记主表
		SkinDjzb skinDjzb = new SkinDjzb();
		BeanUtils.copyProperties(req, skinDjzb);
		skinDjzbDao.deleteByDjdh(skinDjzb);
	}

	/**
	 * 结束皮试
	 *
	 * @param req
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doPsFinish(PsProcessReq req) {
		if (req.getPsjg() == null) {
			throw BaseException.create("ERROR_SKINTEST_0010");
		}
		SkinDjzb skinDjzb = new SkinDjzb();
		BeanUtils.copyProperties(req, skinDjzb);
		skinDjzb.setJssj(DateUtil.date().toTimestamp());
		// 根据登记单号查询皮试信息
		SkinDjzb skinDjzbInfo = skinDjzbDao.doQueryPsDjByDjdh(req.getJgid(), req.getKsdm(), req.getDjdh());
		if (skinDjzbInfo != null) {
			if (!"1".equals(skinDjzbInfo.getZt())) {
				throw BaseException.create("ERROR_SKINTEST_0009");
			}
			int sjpssc = (int) DateUtil.between(skinDjzb.getJssj(), skinDjzbInfo.getKssj(), DateUnit.MINUTE);
			skinDjzb.setSjpssc(sjpssc);
			skinDjzb.setTxrdm(String.valueOf(req.getTxrdm()));
			skinDjzb.setZt("2");
			skinDjzbDao.updateZt(skinDjzb);

			// 更新处方表皮试结果
			SkinDjmx skinDjmx = new SkinDjmx();
			skinDjmx.setJgid(req.getJgid());
			skinDjmx.setKsdm(req.getKsdm());
			skinDjmx.setDjdh(req.getDjdh());
			List<SkinDjmx> skinDjmxList = skinDjmxDao.doQuerySkinDjmxByDjdh(skinDjmx);
			for (SkinDjmx djmx : skinDjmxList) {
				OpCf02 opcf02 = new OpCf02();
				opcf02.setPsjg(req.getPsjg());
				opcf02.setCfsb(djmx.getCfhm());
				opcf02.setYpzh(djmx.getCfzh());
				opcf02.setYpxh(djmx.getYpxh());
				opCf02Dao.updatePsjg(opcf02);
				// 增加病人皮试记录
				SkinPsjl skinPsjl = new SkinPsjl();
				skinPsjl.setBrid(skinDjzbInfo.getBrid());
				skinPsjl.setYpxh(djmx.getYpxh());
				skinPsjl.setJgid(req.getJgid());
				skinPsjl.setPsjg(req.getPsjg());
				skinPsjl.setPsly(1);
				skinPsjl.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.SKIN_PSJL));
				skinPsjlDao.insert(skinPsjl);
			}
		} else {
			throw BaseException.create("ERROR_SKINTEST_0008");
		}
	}

	/**
	 * 根据登记单号查询登记明细
	 *
	 * @param req
	 * @return
	 */
	public List<QueryUnRegistResp> doQueryDjmx(QueryDjmxReq req) {
		SkinDjzb skinDjzb = new SkinDjzb();
		BeanUtils.copyProperties(req, skinDjzb);
		return skinDjzbDao.doQueryPsdjmxList(skinDjzb);
	}

	/**
	 * 皮试工作量统计人次
	 *
	 * @param req
	 * @return
	 */
	public List<QueryAllPsDjCountResp> doQueryAllDjCount(QueryAllPsDjCountReq req) {
		SkinDjzb skinDjzb = new SkinDjzb();
		BeanUtils.copyProperties(req, skinDjzb);
		skinDjzb.setBeginDay(DateUtil.beginOfDay(DateUtil.date(req.getBeginDay())).toTimestamp());
		skinDjzb.setEndDay(DateUtil.endOfDay(DateUtil.date(req.getEndDay())).toTimestamp());
		List<QueryAllPsDjCountResp> resp = skinDjzbDao.doQueryAllDjCount(skinDjzb);
		return resp;
	}

	/**
	 * 皮试工作量统计每日输液数据
	 *
	 * @param req
	 * @return
	 */
	public List<QueryPsDjListResp> doQueryDjList(QueryPsDjCfListReq req) {
		SkinDjzb skinDjzb = new SkinDjzb();
		BeanUtils.copyProperties(req, skinDjzb);
		skinDjzb.setBeginDay(DateUtil.beginOfDay(DateUtil.date(req.getPsrq())).toTimestamp());
		skinDjzb.setEndDay(DateUtil.endOfDay(DateUtil.date(req.getPsrq())).toTimestamp());
		List<QueryPsDjListResp> resp = skinDjzbDao.doQueryDjList(skinDjzb);
		for (QueryPsDjListResp psDjResp : resp) {
			psDjResp.setAge(DateUtil.ageOfNow(psDjResp.getCsny()));
		}
		return resp;
	}

	/**
	 * 皮试阳性率统计
	 *
	 * @param req
	 * @return
	 */
	public List<QueryPsAllergyResp> doQueryPsAllergy(QueryPsAllergyReq req) {
		SkinDjzb skinDjzb = new SkinDjzb();
		BeanUtils.copyProperties(req, skinDjzb);
		skinDjzb.setBeginDay(DateUtil.beginOfDay(DateUtil.date(req.getBeginDay())).toTimestamp());
		skinDjzb.setEndDay(DateUtil.endOfDay(DateUtil.date(req.getEndDay())).toTimestamp());
		List<QueryPsAllergyResp> resp = skinDjzbDao.doQueryPsAllergy(skinDjzb);
		for (QueryPsAllergyResp psResp : resp) {
			int allCount = psResp.getYxCount() + psResp.getYyxCount() == 0 ? 1
					: psResp.getYxCount() + psResp.getYyxCount();
			float result = (float) psResp.getYxCount() / allCount * 100;
			DecimalFormat df = new DecimalFormat("0.00");
			String resultStr = df.format(result);
			float resultFloat = Float.parseFloat(resultStr);
			String rate = resultFloat + "%";
			psResp.setYxRate(rate);
		}
		return resp;
	}

}
