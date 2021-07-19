package com.buit.his.op.reg.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
import com.buit.commons.dao.OpGhksDao;
import com.buit.commons.dao.OpGhmxDao;
import com.buit.commons.dao.OpKspbDao;
import com.buit.commons.model.OpGhks;
import com.buit.commons.model.OpGhmxInfo;
import com.buit.commons.model.OpKspb;
import com.buit.his.op.reg.enums.PbCzEnum;
import com.buit.system.response.HrPersonnelModel;
import com.buit.utill.HisUtil;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpYspbDao;
import com.buit.commons.model.OpYspb;
import com.buit.commons.request.OpYspbAddReq;
import com.buit.commons.request.OpYspbCopyReq;
import com.buit.commons.request.OpYspbDelReq;
import com.buit.commons.request.OpYspbReq;
import com.buit.commons.response.OpZblbResp;
import com.buit.his.op.queuing.model.OpBcsj;
import com.buit.his.op.queuing.service.OpBcsjService;
import com.buit.his.op.reg.enums.BcsjEnum;
import com.buit.system.response.OpKspbPerson;
import com.buit.system.service.HrPersonnelService;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

/**
 * 门诊_门诊医生排班<br>
 * 
 * @author wangyang
 */
@Service
public class OpYspbSer extends BaseManagerImp<OpYspb, Timestamp> {

	static final Logger logger = LoggerFactory.getLogger(OpYspbSer.class);

	@Autowired
	private OpYspbDao opYspbDao;
	@Autowired
	private OpGhmxDao opGhmxDao;
	@Autowired
	private OpKspbDao opKspbDao;
	@Autowired
	private OpGhksDao opGhksDao;

	@DubboReference
	private HrPersonnelService hrPersonnelService;
	@DubboReference
	private OpBcsjService opBcsjService;

	@Override
	public OpYspbDao getEntityMapper() {
		return opYspbDao;
	}

	/**
	 * 医生排班信息
	 * 
	 * @param req
	 * @return
	 */
	public List<OpYspb> getYspbList(OpYspbReq req) {
		OpYspb opYspb = new OpYspb();
		req.setBeginOfDay(DateUtil.beginOfDay(req.getGzrq()).toTimestamp());
		req.setEndOfDay(DateUtil.endOfDay(req.getGzrq()).toTimestamp());
		BeanUtils.copyProperties(req, opYspb);
		opYspb.setGzrq(DateUtil.beginOfDay(DateUtil.date()).toTimestamp());
		return opYspbDao.getYspbList(opYspb);
	}

	/**
	 * 当日科室排班信息
	 * 
	 * @param req
	 * @return
	 */
	public List<OpKspbPerson> getKspbList(OpYspbReq req) {
		OpKspbPerson opYspb = new OpKspbPerson();
//		req.setBeginOfDay(DateUtil.beginOfDay(req.getGzrq()).toTimestamp());
//		req.setEndOfDay(DateUtil.endOfDay(req.getGzrq()).toTimestamp());
		BeanUtils.copyProperties(req, opYspb);
		opYspb.setOrganizCode(req.getJgid().toString());
		return hrPersonnelService.getKspbList(opYspb);
	}

	/**
	 * 医生排班维护-复制一条
	 * 
	 * @param req
	 */
	public void addCopy(OpYspbCopyReq req) {
		boolean isValid = req.getBeginDay().after(req.getEndDay());
		if (isValid) {
			throw BaseException.create("ERROR_REG_0051");
		}
		// 计算开始时间和结束时间之间的天数
		int betweenDay = (int) DateUtil.between(req.getBeginDay(), req.getEndDay(), DateUnit.DAY);
		for (int i = 0; i < betweenDay + 1; i++) {
			OpYspb opYspb = new OpYspb();
			DateTime date = DateUtil.offsetDay(req.getBeginDay(), i);
			Timestamp beginDay = date.toTimestamp();
			req.setBeginOfDay(DateUtil.beginOfDay(beginDay).toTimestamp());
			req.setEndOfDay(DateUtil.endOfDay(beginDay).toTimestamp());
			BeanUtils.copyProperties(req, opYspb);
			opYspb.setGzrq(beginDay);
			List<OpYspb> dataAmList = opYspbDao.findByEntity(opYspb);
			if (CollUtil.isEmpty(dataAmList)) {
				checkKspb(opYspb);
				opYspb.setKsdm(null);
				if (BcsjEnum.QT.getCode().equals(opYspb.getZblb())) {
					for (BcsjEnum bcsjEnum : BcsjEnum.values()) {
						if (BcsjEnum.QT.getCode().equals(bcsjEnum.getCode())) {
							opYspb.setZblb(bcsjEnum.getCode());
							checkGhmx(opYspb, PbCzEnum.COPY.getValue());
							opYspbDao.delYspbByCondition(opYspb);
						}
					}
				} else {
					opYspb.setZblb(BcsjEnum.QT.getCode());
					checkGhmx(opYspb, PbCzEnum.COPY.getValue());
					opYspbDao.delYspbByCondition(opYspb);
				}


				// 如果上午/下午/夜班/全天数据不存在，插入一条
				opYspb.setZsid("0");
				opYspb.setSftz("0");
				opYspb.setTgbz(0);
				opYspb.setJzxh(0);
				opYspb.setYgrs(0);
				opYspb.setYyrs(0);
				opYspb.setZblb(req.getZblb());
				opYspb.setKsdm(req.getKsdm());
				opYspbDao.insert(opYspb);
			}
		}

	}

	/**
	 * 医生排班维护-复制一周
	 * 
	 * @param req
	 */
	@Transactional(rollbackFor = Exception.class)
	public void addCopyWeeks(OpYspbCopyReq req) {
		for (int i = 1; i < 5; i++) {
			OpYspb opYspb = new OpYspb();
			Timestamp beginDay = DateUtil.offsetDay(req.getBeginDay(), 7 * i).toTimestamp();
			Timestamp endDay = DateUtil.offsetDay(req.getEndDay(), 7 * i).toTimestamp();
			req.setBeginOfDay(beginDay);
			req.setEndOfDay(endDay);
			BeanUtils.copyProperties(req, opYspb);
			opYspb.setGzrq(beginDay);
			List<OpYspb> opYspbNextWeekList = opYspbDao.findByEntity(opYspb);

			Map<String, OpYspb> opYspbMap = opYspbNextWeekList.stream()
					.collect(Collectors.toMap(k -> k.getKsdm() + k.getYsdm() + k.getZblb() + k.getGzrq(), v -> v));

			// 循环删除后4周医生排班信息
			opYspbDao.delYspbByCondition(opYspb);

			opYspb.setBeginOfDay(DateUtil.beginOfDay(req.getBeginDay()).toTimestamp());
			opYspb.setEndOfDay(DateUtil.endOfDay(req.getEndDay()).toTimestamp());
			List<OpYspb> opYspbList = opYspbDao.findByEntity(opYspb);
			List<String> keyList = opYspbList.stream().map(k -> k.getKsdm() + k.getYsdm() + k.getZblb() + k.getGzrq()).collect(Collectors.toList());
			opYspbNextWeekList.forEach( o -> {
				String key = o.getKsdm() + o.getYsdm() + o.getZblb() + o.getGzrq();
				if(!keyList.contains(key)){
					checkGhmx(opYspbMap.get(key), PbCzEnum.COPY.getValue());
				}
			});
			for (OpYspb yspb : opYspbList) {
				yspb.setGzrq(DateUtil.offsetDay(yspb.getGzrq(), 7 * i).toTimestamp());
			}
			// 批量插入后四周医生排班信息
			opYspbDao.insertForEach(opYspbList);
		}

	}

	/**
	 * 保存
	 * 
	 * @param opKspb
	 */
	@Transactional(rollbackFor = Exception.class)
	public void add(List<OpYspbAddReq> list, Integer jgid) {
		for (OpYspbAddReq req : list) {
			OpYspb opYspb = new OpYspb();
			// 根据GHKS、ZBLB、GHRQ、JGID条件删除
			opYspb.setBeginOfDay(DateUtil.beginOfDay(req.getGzrq()).toTimestamp());
			opYspb.setEndOfDay(DateUtil.endOfDay(req.getGzrq()).toTimestamp());
			opYspb.setGzrq(DateUtil.beginOfDay(req.getGzrq()).toTimestamp());
			BeanUtils.copyProperties(req, opYspb);
			opYspb.setJgid(jgid);
			opYspbDao.delYspbByCondition(opYspb);
			opYspb.setJzxh(0);
			opYspb.setTgbz(0);
			opYspb.setYgrs(0);
			opYspb.setYyrs(0);
			opYspbDao.insert(opYspb);
		}
	}

	/**
	 * 医生排班删除
	 * 
	 * @param req
	 */
	public void delete(OpYspbDelReq req) {
		if (req.getGzrq() == null) {
			throw BaseException.create("ERROR_REG_0051");
		}
		OpYspb opYspb = new OpYspb();
		req.setBeginOfDay(DateUtil.beginOfDay(req.getGzrq()).toTimestamp());
		req.setEndOfDay(DateUtil.endOfDay(req.getGzrq()).toTimestamp());
		BeanUtils.copyProperties(req, opYspb);
		opYspb.setGzrq(DateUtil.date(req.getGzrq()).toTimestamp());
		opYspb.setYsdm(req.getYsdm().toString());
		if(!BcsjEnum.QT.getCode().equals(opYspb.getZblb())){
			checkGhmx(opYspb, PbCzEnum.CANCEL.getValue());
		}else {
			OpGhmxInfo opGhmxInfo = new OpGhmxInfo();
			opGhmxInfo.setKsdm(opYspb.getKsdm());
			opGhmxInfo.setYsdm(opYspb.getYsdm());
			opGhmxInfo.setBeginOfDay(DateUtil.beginOfDay(opYspb.getGzrq()).toTimestamp());
			opGhmxInfo.setEndOfDay(DateUtil.endOfDay(opYspb.getGzrq()).toTimestamp());
			opGhmxInfo.setGhsj(opYspb.getGzrq());
			opGhmxInfo.setThbz(0);
			opGhmxInfo.setJzjs(0);
			Integer count = opGhmxDao.getGhmxCount(opGhmxInfo);
			if(count > 0){
				OpGhks opGhks = Objects.isNull(opYspb.getKsdm()) ? opGhmxDao.getGhKsByGhmx(opGhmxInfo) : opGhksDao.getById(opYspb.getKsdm());
				HrPersonnelModel hrPersonnelModel = hrPersonnelService.getPersonnelById(Integer.parseInt(opYspb.getYsdm()));
				OpBcsj opBcsj = opBcsjService.getBySddm(opYspb.getZblb());
				if(opGhmxInfo.getEndOfDay().after(DateUtil.endOfDay(DateUtil.date()))){
					throw BaseException.create("ERROR_REG_0105", new String[]{opGhks.getKsmc(), hrPersonnelModel.getPersonname(), HisUtil.getDate(DatePattern.NORM_DATE_PATTERN, opYspb.getGzrq()), opBcsj.getSdmc(), PbCzEnum.CANCEL.getValue()});
				}else {
					throw BaseException.create("ERROR_REG_0104", new String[]{opGhks.getKsmc(), hrPersonnelModel.getPersonname(), HisUtil.getDate(DatePattern.NORM_DATE_PATTERN, opYspb.getGzrq()), opBcsj.getSdmc(), PbCzEnum.CANCEL.getValue()});
				}
			}
		}

		opYspbDao.delYspbByCondition(opYspb);
	}

	/**
	 * 医生排班时校验医生的值班类别
	 * 
	 * @param gzrq
	 * @param zblb
	 * @param ysdm
	 * @param ksdm
	 * @param jgid
	 */
	public void doVaildYspbByZblb(Date gzrq, String zblb, Integer ysdm, Integer ksdm, Integer jgid) {
		OpYspb opYspb = new OpYspb();
		opYspb.setBeginOfDay(DateUtil.beginOfDay(gzrq).toTimestamp());
		opYspb.setEndOfDay(DateUtil.endOfDay(gzrq).toTimestamp());
		opYspb.setGzrq(DateUtil.date(gzrq).toTimestamp());
		opYspb.setYsdm(String.valueOf(ysdm));
//		opYspb.setKsdm(ksdm);
		opYspb.setJgid(jgid);
		List<OpZblbResp> opYspbList = opYspbDao.doVaildYspbByZblb(opYspb);
		for (OpZblbResp yspb : opYspbList) {
			OpBcsj opBcsj = opBcsjService.getBySddm(yspb.getZblb());
			if (zblb.equals(BcsjEnum.QT.getCode())) {
				if (yspb.getZblb().equals(BcsjEnum.SW.getCode()) || yspb.getZblb().equals(BcsjEnum.XW.getCode())
						|| yspb.getZblb().equals(BcsjEnum.YB.getCode())) {
					throw BaseException.create("ERROR_REG_0090",
							new String[] { yspb.getPersonName(), opBcsj.getSdmc() });
				}
			} else {
				OpBcsj bcsj = opBcsjService.getBySddm(zblb);
				if (yspb.getZblb().equals(BcsjEnum.QT.getCode())) {
					throw BaseException.create("ERROR_REG_0093", new String[] { yspb.getPersonName(), bcsj.getSdmc() });
				}
			}

		}

	}

	private void checkGhmx(OpYspb opYspb, String type){
		OpGhmxInfo opGhmxInfo = new OpGhmxInfo();
		opGhmxInfo.setKsdm(Objects.isNull(opYspb.getKsdm()) ? null : opYspb.getKsdm());
		opGhmxInfo.setYsdm(opYspb.getYsdm());
		opGhmxInfo.setBeginOfDay(DateUtil.beginOfDay(opYspb.getGzrq()).toTimestamp());
		opGhmxInfo.setEndOfDay(DateUtil.endOfDay(opYspb.getGzrq()).toTimestamp());
		opGhmxInfo.setGhsj(opYspb.getGzrq());
		opGhmxInfo.setThbz(0);
		opGhmxInfo.setJzjs(0);
		opGhmxInfo.setGhlb(Objects.isNull(opYspb.getZblb()) ? null : opYspb.getZblb());
		Integer count = opGhmxDao.getGhmxCount(opGhmxInfo);
		if(count > 0){
			OpGhks opGhks = Objects.isNull(opYspb.getKsdm()) ? opGhmxDao.getGhKsByGhmx(opGhmxInfo) : opGhksDao.getById(opYspb.getKsdm());
			HrPersonnelModel hrPersonnelModel = hrPersonnelService.getPersonnelById(Integer.parseInt(opYspb.getYsdm()));
			OpBcsj opBcsj = opBcsjService.getBySddm(opYspb.getZblb());
			if(opGhmxInfo.getEndOfDay().after(DateUtil.endOfDay(DateUtil.date()))){
				throw BaseException.create("ERROR_REG_0105", new String[]{opGhks.getKsmc(), hrPersonnelModel.getPersonname(), HisUtil.getDate(DatePattern.NORM_DATE_PATTERN, opYspb.getGzrq()), opBcsj.getSdmc(), type});
			}else {
				throw BaseException.create("ERROR_REG_0104", new String[]{opGhks.getKsmc(), hrPersonnelModel.getPersonname(), HisUtil.getDate(DatePattern.NORM_DATE_PATTERN, opYspb.getGzrq()), opBcsj.getSdmc(), type});
			}
		}
	}

	private void checkKspb(OpYspb opYspb){
		OpKspb opKspb = new OpKspb();
		opKspb.setBeginOfDay(DateUtil.beginOfDay(opYspb.getGzrq()).toTimestamp());
		opKspb.setEndOfDay(DateUtil.endOfDay(opYspb.getGzrq()).toTimestamp());
		opKspb.setJgid(opYspb.getJgid());
		opKspb.setZblb(opYspb.getZblb());
		opKspb.setGhks(String.valueOf(opYspb.getKsdm()));
		List<OpKspb> opKspbList = opKspbDao.doQueryKspbByDate(opKspb);
		if(CollUtil.isEmpty(opKspbList)){
			OpGhks opGhks = opGhksDao.getById(opYspb.getKsdm());
			OpBcsj opBcsj = opBcsjService.getBySddm(opYspb.getZblb());
			throw BaseException.create("ERROR_REG_0107", new String[] {opGhks.getKsmc(), HisUtil.getDate(DatePattern.NORM_DATE_PATTERN, opYspb.getGzrq()), opBcsj.getSdmc()});
		}
	}

}
