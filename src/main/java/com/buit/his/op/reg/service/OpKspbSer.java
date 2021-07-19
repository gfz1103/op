package com.buit.his.op.reg.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
import com.buit.commons.dao.OpGhmxDao;
import com.buit.commons.dao.OpYspbDao;
import com.buit.commons.model.OpGhmxInfo;
import com.buit.commons.model.OpYspb;
import com.buit.commons.response.CzdbSbbResp;
import com.buit.his.op.reg.enums.PbCzEnum;
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
import com.buit.commons.dao.OpGhksDao;
import com.buit.commons.dao.OpKspbDao;
import com.buit.commons.model.OpGhks;
import com.buit.commons.model.OpKspb;
import com.buit.commons.request.OpKspbReq;
import com.buit.commons.response.OpZblbResp;
import com.buit.his.op.queuing.model.OpBcsj;
import com.buit.his.op.queuing.service.OpBcsjService;
import com.buit.his.op.reg.enums.BcsjEnum;

import cn.hutool.core.date.DateUtil;

/**
 * 门诊_科室排班<br>
 * 
 * @author wangyang
 */
@Service
public class OpKspbSer extends BaseManagerImp<OpKspb, Timestamp> {

	static final Logger logger = LoggerFactory.getLogger(OpKspbSer.class);

	@Autowired
	private OpKspbDao opKspbDao;

	@Autowired
	private OpGhksDao opGhksDao;

	@Autowired
	private OpGhmxDao opGhmxDao;

	@Autowired
	private OpYspbDao opYspbDao;
	
	@DubboReference
	private OpBcsjService opBcsjService;

	@Override
	public OpKspbDao getEntityMapper() {
		return opKspbDao;
	}

	/**
	 * 科室排班分页查询
	 * 
	 * @param req
	 * @return
	 */
	public List<OpKspb> getKspbList(OpKspbReq req) {
		OpKspb opKspb = new OpKspb();
		req.setBeginOfDay(DateUtil.beginOfDay(req.getGhrq()).toTimestamp());
		req.setEndOfDay(DateUtil.endOfDay(req.getGhrq()).toTimestamp());
		BeanUtils.copyProperties(req, opKspb);
		return opKspbDao.getKspbList(opKspb);
	}

	/**
	 * 保存
	 */
	@Transactional(rollbackFor = Exception.class)
	public void add(List<OpKspb> list, Integer jgid) {
		if(CollUtil.isNotEmpty(list)) {
			OpKspb kspbReq = list.get(0);
			kspbReq.setBeginOfDay(DateUtil.beginOfDay(kspbReq.getGhrq()).toTimestamp());
			kspbReq.setEndOfDay(DateUtil.endOfDay(kspbReq.getGhrq()).toTimestamp());
			List<OpKspb> exitKspbList = opKspbDao.doQueryKspbByDate(kspbReq);
			List<String> ksdmList = exitKspbList.stream().map(OpKspb::getGhks).collect(Collectors.toList());
			for (OpKspb opKspb : list) {
				// 根据GHKS、ZBLB、GHRQ、JGID条件删除
				opKspb.setBeginOfDay(DateUtil.beginOfDay(opKspb.getGhrq()).toTimestamp());
				opKspb.setEndOfDay(DateUtil.endOfDay(opKspb.getGhrq()).toTimestamp());
				opKspb.setJgid(jgid);
				if (opKspb.getKspb() == 0) {
					if(ksdmList.contains(opKspb.getGhks())) {
						if(!BcsjEnum.QT.getCode().equals(opKspb.getZblb())){
							checkGhmx(opKspb, PbCzEnum.CANCEL.getKey());
						}else {
							OpGhmxInfo opGhmxInfo = new OpGhmxInfo();
							opGhmxInfo.setKsdm(Integer.parseInt(opKspb.getGhks()));
							opGhmxInfo.setBeginOfDay(DateUtil.beginOfDay(opKspb.getGhrq()).toTimestamp());
							opGhmxInfo.setEndOfDay(DateUtil.endOfDay(opKspb.getGhrq()).toTimestamp());
							opGhmxInfo.setGhsj(DateUtil.beginOfDay(opKspb.getGhrq()).toTimestamp());
							opGhmxInfo.setThbz(0);
							opGhmxInfo.setJzjs(0);
							Integer count = opGhmxDao.getGhmxCount(opGhmxInfo);
							if(count > 0){
								OpBcsj opBcsj = opBcsjService.getBySddm(opKspb.getZblb());
								opGhmxInfo.setGhlb(null);
								OpGhks opGhks = Objects.isNull(opKspb.getGhks()) ? opGhmxDao.getGhKsByGhmx(opGhmxInfo) : opGhksDao.getById(Integer.parseInt(opKspb.getGhks()));
								if(opGhmxInfo.getEndOfDay().before(DateUtil.endOfDay(DateUtil.date()))) {
									throw BaseException.create("ERROR_REG_0102", new String[] { opGhks.getKsmc(),
											HisUtil.getDate(DatePattern.NORM_DATE_PATTERN, opKspb.getGhrq()), opBcsj.getSdmc(), PbCzEnum.CANCEL.getValue()});
								}else {
									throw BaseException.create("ERROR_REG_0103", new String[]{ opGhks.getKsmc(),
											HisUtil.getDate(DatePattern.NORM_DATE_PATTERN, opKspb.getGhrq()), opBcsj.getSdmc(), PbCzEnum.CANCEL.getValue()});
								}
							}
						}
					}
				} else {
					checkKspb(opKspb);
				}
				opKspbDao.delKspbByCondition(opKspb);
				if (opKspb.getKspb() > 0) {
					// 如果是已排班记录，则新增
					opKspbDao.insert(opKspb);
				}
			}
		}
	}

	/**
	 * 条件查询科室排班列表
	 * 
	 * @param req
	 * @return
	 */
	public List<OpKspb> getDeptList(OpKspbReq req) {
		OpKspb opKspb = new OpKspb();
		req.setBeginOfDay(DateUtil.beginOfDay(req.getGhrq()).toTimestamp());
		req.setEndOfDay(DateUtil.endOfDay(req.getGhrq()).toTimestamp());
		BeanUtils.copyProperties(req, opKspb);
		return opKspbDao.getDeptList(opKspb);
	}

	/**
	 * 复制到下一天
	 *
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doSaveCopy(Date currDate, Date nextDate, String zblb, Integer jgid) {
		OpKspb kspbToday = new OpKspb();
		kspbToday.setGhrq(currDate);
		kspbToday.setBeginOfDay(DateUtil.beginOfDay(DateUtil.date(currDate)).toTimestamp());
		kspbToday.setEndOfDay(DateUtil.endOfDay(DateUtil.date(currDate)).toTimestamp());
		kspbToday.setJgid(jgid);
		kspbToday.setZblb(zblb);
		// 查询当天排班信息
		List<OpKspb> opKspbList = opKspbDao.doQueryKspbByDate(kspbToday);
		opKspbList.forEach( o -> o.setGhrq(nextDate));
//		kspbToday.setGhrq(nextDate);
//		kspbToday.setBeginOfDay(DateUtil.beginOfDay(DateUtil.date(nextDate)).toTimestamp());
//		kspbToday.setEndOfDay(DateUtil.endOfDay(DateUtil.date(nextDate)).toTimestamp());
//		List<OpKspb> opKspbNextDayList = opKspbDao.doQueryKspbByDate(kspbToday);
//		Map<String, OpKspb> opKspbMap = opKspbNextDayList.stream().collect(Collectors.toMap(OpKspb::getGhks, o -> o));
//		if(opKspbList.isEmpty()){
//			opKspbNextDayList.forEach( o -> {
//				checkGhmx(opKspbMap.get(o.getGhks()), 2);
//			});
//		}else {
//			List<String> ghksList = opKspbList.stream().map(OpKspb::getGhks).collect(Collectors.toList());
//			opKspbNextDayList.forEach( o -> {
//				if(!ghksList.contains(o.getGhks())){
//					checkGhmx(opKspbMap.get(o.getGhks()), 2);
//				}
//			});
//		}
		doVaildCheck(currDate, nextDate, zblb, jgid, 1);
		// 删除下一天排班信息
		OpKspb kspbNext = new OpKspb();
		kspbNext.setGhrq(nextDate);
		kspbNext.setBeginOfDay(DateUtil.beginOfDay(DateUtil.date(nextDate)).toTimestamp());
		kspbNext.setEndOfDay(DateUtil.endOfDay(DateUtil.date(nextDate)).toTimestamp());
		kspbNext.setJgid(jgid);
		if(BcsjEnum.QT.getCode().equals(zblb)){
			for (BcsjEnum bcsjEnum: BcsjEnum.values()) {
				if(BcsjEnum.QT.getCode().equals(bcsjEnum.getCode())){
					kspbNext.setZblb(bcsjEnum.getCode());
					opKspbDao.delKspbByCondition(kspbNext);
				}
			}
		}else {
			kspbNext.setZblb(BcsjEnum.QT.getCode());
			opKspbDao.delKspbByCondition(kspbNext);
		}
		kspbNext.setZblb(zblb);
		opKspbDao.delKspbByCondition(kspbNext);
		// 批量插入
		opKspbDao.insertForEach(opKspbList);
	}

	public void doModifyCheck(List<OpKspb> opKspb) {
		if(CollUtil.isEmpty(opKspb)){
			throw BaseException.create("ERROR_REG_0106");
		}
		opKspb.forEach(o -> {
			if(o.getKspb() == 0){
				checkYspb(o);
				checkGhmx(o, PbCzEnum.CANCEL.getKey());
			}else {
				checkKspb(o);
			}
		});
	}

	private void checkYspb(OpKspb opKspb) {
		OpYspb opYspb = new OpYspb();
		opYspb.setZblb(opKspb.getZblb());
		opYspb.setKsdm(Integer.parseInt(opKspb.getGhks()));
		opYspb.setGzrq(DateUtil.beginOfDay(opKspb.getGhrq()).toTimestamp());
		opYspb.setBeginOfDay(DateUtil.beginOfDay(opKspb.getGhrq()).toTimestamp());
		opYspb.setEndOfDay(DateUtil.endOfDay(opKspb.getGhrq()).toTimestamp());
		List<OpYspb> opYspbList = opYspbDao.getYspbList(opYspb);
		if(CollUtil.isNotEmpty(opYspbList)){
			OpBcsj opBcsj = opBcsjService.getBySddm(opKspb.getZblb());
			OpGhks opGhks = opGhksDao.getById(Integer.parseInt(opKspb.getGhks()));
			throw BaseException.create("ERROR_REG_0109",  new String[] { opGhks.getKsmc(),
					HisUtil.getDate(DatePattern.NORM_DATE_PATTERN, opKspb.getGhrq()), opBcsj.getSdmc()});
		}
	}

	private void checkGhmx(OpKspb opKspb, Integer type){
		OpGhmxInfo opGhmxInfo = new OpGhmxInfo();
		opGhmxInfo.setKsdm(Objects.isNull(opKspb.getGhks()) ? null : Integer.parseInt(opKspb.getGhks()));
		opGhmxInfo.setBeginOfDay(DateUtil.beginOfDay(opKspb.getGhrq()).toTimestamp());
		opGhmxInfo.setEndOfDay(DateUtil.endOfDay(opKspb.getGhrq()).toTimestamp());
		opGhmxInfo.setGhsj(DateUtil.beginOfDay(opKspb.getGhrq()).toTimestamp());
		opGhmxInfo.setThbz(0);
		opGhmxInfo.setGhlb(opKspb.getZblb());
		opGhmxInfo.setJzjs(0);
		Integer count = opGhmxDao.getGhmxCount(opGhmxInfo);
		if(count > 0){
			OpBcsj opBcsj = opBcsjService.getBySddm(opKspb.getZblb());
			opGhmxInfo.setGhlb(null);
			OpGhks opGhks = Objects.isNull(opKspb.getGhks()) ? opGhmxDao.getGhKsByGhmx(opGhmxInfo) : opGhksDao.getById(Integer.parseInt(opKspb.getGhks()));
			if(opGhmxInfo.getEndOfDay().before(DateUtil.endOfDay(DateUtil.date()))) {
				throw BaseException.create("ERROR_REG_0102", new String[] { opGhks.getKsmc(),
						HisUtil.getDate(DatePattern.NORM_DATE_PATTERN, opKspb.getGhrq()), opBcsj.getSdmc(), PbCzEnum.getPbCzValue(type)});
			}else {
				throw BaseException.create("ERROR_REG_0103", new String[]{ opGhks.getKsmc(),
						HisUtil.getDate(DatePattern.NORM_DATE_PATTERN, opKspb.getGhrq()), opBcsj.getSdmc(),  PbCzEnum.getPbCzValue(type)});
			}
		}
	}



	private void checkKspb(OpKspb opKspb){
		OpKspb kspb = new OpKspb();
		kspb.setGhrq(opKspb.getGhrq());
		kspb.setBeginOfDay(DateUtil.beginOfDay(opKspb.getGhrq()).toTimestamp());
		kspb.setEndOfDay(DateUtil.endOfDay(opKspb.getGhrq()).toTimestamp());
		kspb.setGhks(opKspb.getGhks());
		kspb.setJgid(opKspb.getJgid());
		List<OpZblbResp> opkspbList = opKspbDao.doValidKspbZblb(kspb);
		if (opkspbList != null && !opkspbList.isEmpty()) {
			for (OpZblbResp pb : opkspbList) {
				OpBcsj opBcsj = opBcsjService.getBySddm(pb.getZblb());
				if (opKspb.getZblb().equals(BcsjEnum.QT.getCode())) {
					if (pb.getZblb().equals(BcsjEnum.SW.getCode()) || pb.getZblb().equals(BcsjEnum.XW.getCode())
							|| pb.getZblb().equals(BcsjEnum.YB.getCode())) {
						throw BaseException.create("ERROR_REG_0091",
								new String[] { pb.getKsmc(), opBcsj.getSdmc() });
					}
				} else {
					if (pb.getZblb().equals(BcsjEnum.QT.getCode())) {
						OpBcsj bcsj = opBcsjService.getBySddm(opKspb.getZblb());
						throw BaseException.create("ERROR_REG_0092",
								new String[] { pb.getKsmc(), bcsj.getSdmc() });
					}
				}
			}
		}
	}

	public void doVaildCheck(Date currDate, Date nextDate, String zblb, Integer hospitalId, Integer type) {
		OpKspb kspbToday = new OpKspb();
		kspbToday.setGhrq(currDate);
		kspbToday.setBeginOfDay(DateUtil.beginOfDay(DateUtil.date(currDate)).toTimestamp());
		kspbToday.setEndOfDay(DateUtil.endOfDay(DateUtil.date(currDate)).toTimestamp());
		kspbToday.setJgid(hospitalId);
		kspbToday.setZblb(zblb);
		// 查询当天排班信息
		List<OpKspb> opKspbList = opKspbDao.doQueryKspbByDate(kspbToday);

		kspbToday.setGhrq(nextDate);
		kspbToday.setBeginOfDay(DateUtil.beginOfDay(DateUtil.date(nextDate)).toTimestamp());
		kspbToday.setEndOfDay(DateUtil.endOfDay(DateUtil.date(nextDate)).toTimestamp());
		List<OpKspb> opKspbNextDayList = opKspbDao.doQueryKspbByDate(kspbToday);

		Map<String, OpKspb> opKspbMap = opKspbNextDayList.stream().collect(Collectors.toMap(OpKspb::getGhks, o -> o));
		if (opKspbList.isEmpty()) {
			opKspbNextDayList.forEach(o -> {
				OpKspb opKspb = opKspbMap.get(o.getGhks());
				checkYspb(o);
				checkGhmx(opKspb, PbCzEnum.COPY.getKey());
			});
		} else {
			List<String> ghksList = opKspbList.stream().map(OpKspb::getGhks).collect(Collectors.toList());
			opKspbNextDayList.forEach(o -> {
				if (!ghksList.contains(o.getGhks())) {
					checkYspb(o);
					checkGhmx(opKspbMap.get(o.getGhks()), PbCzEnum.COPY.getKey());
				}
			});
		}
		if (CollUtil.isNotEmpty(opKspbList) && type == 2) {
			opKspbList.forEach(o -> {
				o.setGhrq(nextDate);
				if(BcsjEnum.QT.getCode().equals(zblb)){
					for (BcsjEnum bcsjEnum: BcsjEnum.values()) {
						if(BcsjEnum.QT.getCode().equals(bcsjEnum.getCode())){
							kspbToday.setZblb(bcsjEnum.getCode());
							checkYspb(o);
							checkGhmx(kspbToday, PbCzEnum.COPY.getKey());
						}
					}
				}else {
					kspbToday.setZblb(BcsjEnum.QT.getCode());
					checkYspb(o);
					checkGhmx(kspbToday, PbCzEnum.COPY.getKey());
				}
				checkKspb(o);
			});
		}
	}
}
