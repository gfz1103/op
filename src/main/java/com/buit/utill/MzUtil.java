package com.buit.utill;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseException;
import com.buit.commons.dao.OpYgpjDao;
import com.buit.commons.dao.WlWzkcDao;
import com.buit.commons.dao.WlXhmxDao;
import com.buit.commons.model.OpYgpj;
import com.buit.commons.model.WlWzkc;
import com.buit.commons.model.WlXhmx;
import com.buit.drug.request.QueryDjYpslReq;
import com.buit.drug.response.DrugsTypkDetailResp;
import com.buit.drug.service.DrugService;
import com.buit.drug.service.DrugsTypkOutSer;
import com.buit.his.op.queuing.model.OpBcsj;
import com.buit.his.op.queuing.service.OpBcsjService;
import com.buit.system.request.FeeYpxzApiReq;
import com.buit.system.request.PubFyxzApiReq;
import com.buit.system.response.FeeSfdlzfbl;
import com.buit.system.response.FeeYlsfxmOutResp;
import com.buit.system.service.DicGbsj02Service;
import com.buit.system.service.FeeSfdlzfblOutSer;
import com.buit.system.service.FeeYlsfxmOutSer;
import com.buit.system.service.FeeYpxzService;
import com.buit.system.service.PubFyxzService;
import com.buit.system.service.SysXtcsCacheSer;
import com.buit.system.utill.AgeUtil;
import com.buit.system.utill.ObjectToTypes;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.CaseInsensitiveMap;

@Service
public class MzUtil {

	static final Logger logger = LoggerFactory.getLogger(MzUtil.class);

	@Autowired
	private WlXhmxDao wlXhmxDao;
	@Autowired
	private WlWzkcDao wlWzkcDao;
//	@Autowired
//	private OpYjcf02Dao opYjcf02Dao;
//	@Autowired
//	private DicKszdDao dicKszdDao;
//	@Autowired
//	private OpGhmxDao opGhmxDao;
//	@Autowired
//	private WlKfdzDao wlKfdzDao;
//	@Autowired
//	private FeeXmzxksDao feeXmzxksDao;
//	@Autowired
//	private RedisFactory redisFactory;
//	@Autowired
//	private CisHzyzDao cisHzyzDao;
//	@Autowired
//	private ImHzryDao imHzryDao;
//	@Autowired
//	private DrugsTypkDao drugsTypkDao;
//	@Autowired
//	private FeeYlsfxmDao feeYlsfxmDao;
//	@DubboReference
//	private FeeYpxzDao feeYpxzDao;
//	@DubboReference
//	private FeeSfdlzfblDao feeSfdlzfblDao;
	@DubboReference
	private FeeYpxzService feeYpxzService;
//	@Autowired
//	private ImTbkkDao imTbkkDao;
//	@Autowired
//	private ImZyjsDao imZyjsDao;
//	@Autowired
//	private ImFeeFymxDao imFeeFymxDao;
//	@Autowired
//	private ImRcjlDao imRcjlDao;
//	@Autowired
//	private ImCyjlDao imCyjlDao;
	@Autowired
	private OpYgpjDao opYgpjDao;
	@DubboReference
	private PubFyxzService pubFyxzService;
	@DubboReference
	private FeeYpxzService feeYpxzDao;
	@DubboReference
	private FeeSfdlzfblOutSer feeSfdlzfblOutSer;
	@DubboReference
	private SysXtcsCacheSer sysXtcsCacheSer;
	@DubboReference
	private FeeYlsfxmOutSer feeYlsfxmOutSer;
	@DubboReference
	private DrugsTypkOutSer drugsTypkOutSer;
//	@Autowired
//	private DicSypcDao dicSypcDao;
	@DubboReference
	private DrugService drugService;

	@DubboReference
	private DrugService pharKcdjDao;
	@DubboReference
	private DicGbsj02Service dicGbsj02Dao;

	@DubboReference
	private OpBcsjService opBcsjService;

	/**
	 * ??????sbxh????????????????????????????????????
	 *
	 * @param hospitalId ??????ID
	 * @param sbxh       ????????????
	 */
	public void deleteSupplies(Integer hospitalId, Integer sbxh) {
		// deleteSuppliesJG(sbxh, "1", hospitalId);
	} // ????????????????????????????????????????????????????????????

//	/**
//	 * ??????sbxh????????????????????????????????????
//	 *
//	 * @param hospitalId ????????????
//	 * @param jlxh       ????????????
//	 */
	public void deleteSuppliesZY(Integer hospitalId, Integer jlxh) {
		deleteSuppliesJG(jlxh, "2", hospitalId);
	} // ????????????????????????????????????????????????????????????

	public void deleteSuppliesJG(Integer sbxh, String brly, Integer jgid) {
		Map<String, Object> parametersxhmx = new HashMap<String, Object>(16);
		Map<String, Object> parameterswzkc = new HashMap<String, Object>(16);
		Map<String, Object> parameterswzkcupdate = new HashMap<String, Object>(16);
		parametersxhmx.put("JGID", jgid);
		parametersxhmx.put("MZXH", sbxh);
		parametersxhmx.put("BRLY", brly);

		// ??????fyxh????????????wzxh
		WlXhmx wlXhmxQuery = new WlXhmx();
		wlXhmxQuery.setMzxh(sbxh);
		wlXhmxQuery.setJgid(jgid);
		wlXhmxQuery.setBrly(brly);
		List<WlXhmx> wlXhmxList = wlXhmxDao.findByEntity(wlXhmxQuery);
		for (WlXhmx wlXhmx : wlXhmxList) {
			Integer kcxh = wlXhmx.getKcxh();
			Integer kfxh = wlXhmx.getKfxh();
			BigDecimal wzsl = wlXhmx.getWzsl();

			WlWzkc wlWzkcQuery = new WlWzkc();
			wlWzkcQuery.setKcxh(kcxh);
			wlWzkcQuery.setJgid(jgid);
			wlWzkcQuery.setKfxh(kfxh);
			List<WlWzkc> wlWzkcList = wlWzkcDao.findByEntity(wlWzkcQuery);

			if (!wlWzkcList.isEmpty()) {
				WlWzkc wlWzkc = wlWzkcList.get(0);
				BigDecimal yksl = wlWzkc.getYksl();
				kcxh = wlWzkc.getKcxh();
				Integer kfxf = wlWzkc.getKfxh();
				yksl = yksl.subtract(wzsl);

				WlWzkc wlWzkcUpdate = new WlWzkc();
				wlWzkcUpdate.setYksl(yksl);
				wlWzkcUpdate.setKcxh(kcxh);
				wlWzkcUpdate.setJgid(jgid);
				wlWzkcUpdate.setKfxh(kfxh);
				wlWzkcDao.updateYjsl(wlWzkcUpdate);
			}
		}

		WlXhmx xhmxDel = new WlXhmx();
		xhmxDel.setMzxh(sbxh);
		xhmxDel.setJgid(jgid);
		xhmxDel.setBrly(brly);
		wlXhmxDao.removeByEntity(xhmxDel);
	}

//	/**
//	 * ????????????????????????????????????????????????????????????????????????
//	 *
//	 * @param sbxhs ????????????
//	 * @param ghgl  ????????????
//	 * @param jgid  ??????ID
//	 * @param ksdm  ????????????
//	 */
//	public void setSupplies(Integer sbxhs, Integer ghgl, Integer jgid, Integer ksdm) {
//		Map<String, Object> parameters = new HashMap<String, Object>(16);
//		Map<String, Object> parameterskfxh = new HashMap<String, Object>(16);
//		String hql = "select a.SBXH as SBXH,a.YLXH as FYXH,a.YLSL as CZSL,d.BZJG as BZJG,f.JGBZ as JGBZ,b.BRID as BRID,c.BRXM as BRXM,b.JGID as JGID from OP_YJCF02 a,OP_YJCF01 b,MPI_BRDA c,FEE_YLSFXM d,FEE_YLSFXMDJ f where a.YJXH=b.YJXH and b.BRID=c.BRID and a.YLXH=d.FYXH and d.FYXH=f.FYXH and f.JGID=:JGID and a.SBXH=:SBXH and b.MZXH is null";
//
//		parameters.put("SBXH", sbxhs);
//		parameters.put("JGID", jgid);
//
//		Map<String, Object> lisFYXX = opYjcf02Dao.findObjByObj(parameters);
//
//		Integer deptId = 0;
//		String ksmc = "";
//
//		if (ksdm != null) {
//			deptId = ksdm;
//			ksmc = dicKszdDao.getById(deptId).getOfficename();
//		}
//		if (deptId == 0) {
//			StringBuffer hqlksdm = new StringBuffer();
//			Map<String, Object> parametersmzks = new HashMap<String, Object>(16);
//			parametersmzks.put("sbxh", ghgl);
//			Map<String, Object> map_ghxx = opGhmxDao.findDeptInfo(parametersmzks);
//			if (map_ghxx != null && map_ghxx.get("MZKS") != null) {
//				deptId = Integer.parseInt(map_ghxx.get("MZKS") + "");
//				ksmc = map_ghxx.get("KSMC") + "";
//			}
//		}
//		parameterskfxh.put("ejkf", deptId);
//
//		Map<String, Object> kfxhMap = wlKfdzDao.findKfxh(parameterskfxh);
//
//		int kfxh = 0;
//		if (kfxhMap != null) {
//			if (kfxhMap.get("KFXH") != null) {
//				kfxh = Integer.parseInt(kfxhMap.get("KFXH") + "");
//			}
//		} else {
//			throw BaseException.create("ERROR_DCTWORK_OP_0038");
//		}
//		if (lisFYXX != null) {
//			double czsl = Double.parseDouble(lisFYXX.get("CZSL") + "");
//			Long sbxh = Long.parseLong(lisFYXX.get("SBXH") + "");
//			Long fyxh = Long.parseLong(lisFYXX.get("FYXH") + "");
//			Long brid = Long.parseLong(lisFYXX.get("BRID") + "");
//			int jgbz = 0;
//			if (lisFYXX.get("JGBZ") != null) {
//				jgbz = Integer.parseInt(lisFYXX.get("JGBZ") + "");
//			}
//			double bzjg = 0;
//			if (lisFYXX.get("BZJG") != null) {
//				bzjg = Double.parseDouble(lisFYXX.get("BZJG") + "");
//			}
//			String brxm = lisFYXX.get("BRXM") + "";
//			String lisFyxxJgid = lisFYXX.get("JGID") + "";
//			setSuppliesJG(sbxh, fyxh, kfxh, czsl, brid, "1", deptId, brxm, ksmc, -2, lisFyxxJgid, jgbz, bzjg, null);
//		}
//
//	}
//
//	// ????????????????????????????????????????????????????????????
//	public void setSuppliesJG(Long sbxh, Long fyxh, int kfxh, double czsl, Long brid, String brly, Integer ksdm,
//			String brxm, String ksmc, int ztbz, String jgid, int jgbz, double bzjg, String zyhm) {
//		Map<String, Object> parameterswzxh = new HashMap<String, Object>(16);
//		Map<String, Object> parameterswzjg = new HashMap<String, Object>(16);
//		Map<String, Object> parametersupd = new HashMap<String, Object>(16);
//		Map<String, Object> parametersykslupd = new HashMap<String, Object>(16);
//		parameterswzxh.put("FYXH", fyxh);
//		parameterswzxh.put("JGID", jgid);
//		parametersupd.put("SBXH", sbxh);
//
//		// ??????fyxh????????????wzxh
//		List<Map<String, Object>> lisWZXH = feeXmzxksDao.findSuppliesInfo(parameterswzxh);
//
//		double wzjg = 0.00;
//		double czje = 0.00;
//		for (int i = 0; i < lisWZXH.size(); i++) {
//			double wzslall = czsl * Double.parseDouble(lisWZXH.get(i).get("WZSL") + "");// ????????????????????????????????????
//			parameterswzjg.put("WZXH", Long.parseLong(lisWZXH.get(i).get("WZXH") + ""));
//			parameterswzjg.put("JGID", jgid);
//			parameterswzjg.put("KFXH", kfxh);
//
//			List<Map<String, Object>> lisWZKC = wlWzkcDao.findSuppliesAmount(parameterswzjg);
//
//			for (int j = 0; j < lisWZKC.size(); j++) {// ????????????????????????
//				double wzsl = Double.parseDouble(lisWZKC.get(j).get("WZSL") + "");
//				double yksl = Double.parseDouble(lisWZKC.get(j).get("YKSL") + "");
//				long kcxh = Long.parseLong(lisWZKC.get(j).get("KCXH") + "");
//				parametersykslupd.put("KCXH", kcxh);
//				parametersykslupd.put("KFXH", kfxh);
//				parametersykslupd.put("JGID", jgid);
//				long wzxhs = Long.parseLong(lisWZKC.get(j).get("WZXH") + "");
//				if (wzslall <= (wzsl - yksl)) {
//					if (jgbz == 1) {
//						wzjg = Double.parseDouble(lisWZKC.get(j).get("WZJG") + "");
//					} else {
//						wzjg = bzjg;
//					}
//					czje += wzslall * wzjg;
//					parametersykslupd.put("YKSL", yksl + wzslall);
//
//					wlWzkcDao.updateyksl(parametersykslupd);
//
//					Map<String, Object> parametersyxhmxsave = new HashMap<String, Object>(16);
//					parametersyxhmxsave.put("BRHM", zyhm);
//					parametersyxhmxsave.put("BRXM", brxm);
//					parametersyxhmxsave.put("WZSL", wzslall);
//					parametersyxhmxsave.put("KSMC", ksmc);
//					parametersyxhmxsave.put("BRID", brid);
//					parametersyxhmxsave.put("BRLY", brly);
//					parametersyxhmxsave.put("XHRQ", new Date());
//					parametersyxhmxsave.put("KSDM", ksdm);
//					parametersyxhmxsave.put("JGID", jgid);
//					parametersyxhmxsave.put("KFXH", kfxh);
//					parametersyxhmxsave.put("WZXH", wzxhs);
//					parametersyxhmxsave.put("ZTBZ", ztbz);
//					parametersyxhmxsave.put("MZXH", sbxh);
//					parametersyxhmxsave.put("KCXH", kcxh);
//
//					WlXhmx wlxhmx = BeanUtil.fillBeanWithMapIgnoreCase(parametersyxhmxsave, new WlXhmx(), true);
//					wlxhmx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.WL_WZKC));
//
//					wlXhmxDao.insert(wlxhmx);
//					break;
//				} else if (wzslall > (wzsl - yksl)) {
//					wzslall = wzslall - (wzsl - yksl);
//					parametersykslupd.put("YKSL", yksl + (wzsl - yksl));
//					wlWzkcDao.updateyksl(parametersykslupd);
//					if ((wzsl - yksl) > 0) {
//						Map<String, Object> parametersyxhmxsave = new HashMap<String, Object>(16);
//						parametersyxhmxsave.put("BRHM", zyhm);
//						parametersyxhmxsave.put("BRXM", brxm);
//						parametersyxhmxsave.put("WZSL", (wzsl - yksl));
//						parametersyxhmxsave.put("KSMC", ksmc);
//						parametersyxhmxsave.put("BRID", brid);
//						parametersyxhmxsave.put("BRLY", brly);
//						parametersyxhmxsave.put("XHRQ", new Date());
//						parametersyxhmxsave.put("KSDM", ksdm);
//						parametersyxhmxsave.put("JGID", jgid);
//						parametersyxhmxsave.put("KFXH", kfxh);
//						parametersyxhmxsave.put("WZXH", wzxhs);
//						parametersyxhmxsave.put("ZTBZ", ztbz);
//						parametersyxhmxsave.put("MZXH", sbxh);
//						parametersyxhmxsave.put("KCXH", kcxh);
//
//						WlXhmx wlxhmx = BeanUtil.fillBeanWithMapIgnoreCase(parametersyxhmxsave, new WlXhmx(), true);
//						wlxhmx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.WL_WZKC));
//
//						wlXhmxDao.insert(wlxhmx);
//					}
//					if (jgbz == 1) {
//						wzjg = Double.parseDouble(lisWZKC.get(j).get("WZJG") + "");
//					} else {
//						wzjg = bzjg;
//					}
//					czje += (wzsl - yksl) * wzjg;
//				}
//			}
//		}
//		double wzdj = czje / czsl;
//		if (wzdj != 0.00 && czje != 0.00) {
//			if ("1".equals(brly)) {
//				parametersupd.put("YLDJ", wzdj);
//				parametersupd.put("HJJE", czje);
//				// update OP_YJCF02 set YLDJ=:YLDJ,HJJE=:HJJE where SBXH=:SBXH
//				opYjcf02Dao.updateYldjAndHjje(parametersupd);
//			} else if ("2".equals(brly)) {
//				parametersupd.put("YPDJ", wzdj);
//				// update CIS_HZYZ set YPDJ=:YPDJ where JLXH=:SBXH
//				opYjcf02Dao.updateYpdj(parametersupd);
//			}
//		}
//	}
//
	/**
	 * ?????????List<Map,String> ???List<T>
	 *
	 * @param <T>
	 * @param mapList
	 * @param bean
	 * @return
	 * @author wy
	 */
	@SuppressWarnings("hiding")
	public static <T> List<T> ListToResultSet(List<Map<String, Object>> mapList, T bean) {
		List<T> resultList = new ArrayList<T>();
		try {
			for (Map<String, Object> map : mapList) {
				bean = (T) bean.getClass().newInstance();
				T t = cn.hutool.core.bean.BeanUtil.fillBeanWithMapIgnoreCase(map, bean, true);
				resultList.add(t);
			}
		} catch (InstantiationException e) {
			logger.error(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage(), e);
		}
		return resultList;
	}
//
//	/**
//	 * @param birthday
//	 * @param nowDate
//	 * @return Map<String, Object> ????????????
//	 * @throws @Title: getPersonAge
//	 * @Description: TODO ??????????????????3*12??????????????????????????? ??????3*12????????????????????????1*12??????????????????????????????
//	 *               ??????12????????????????????????6??????????????????????????? ??????6?????????????????????29??????????????????????????? ??????72????????????29????????????????????????
//	 *               ??????72??????????????????????????????
//	 * @author ?????????
//	 */
//	public static Map<String, Object> getPersonAge(Date birthday, Date nowDate) {
//		if (birthday == null) {
//			throw BaseException.create("ERROR_DCTWORK_OP_0040");
//		}
//		Calendar now = Calendar.getInstance();
//		Calendar birth = Calendar.getInstance();
//		birth.setTime(birthday);
//		if (nowDate != null) {
//			now.setTime(nowDate);
//		}
//
//		int age = AgeUtil.calculateAge(birthday, nowDate);
//		String reAge = age + "???";
//		if (age < 3 && age >= 1) {
//			int month = getMonths(birthday, now.getTime());
//			reAge = age + "???";
//			if ((month - 12 * age) > 0) {
//				reAge = age + "???" + (month - 12 * age) + "???";
//			}
//		} else if (age < 1) {
//			int month = getMonths(birthday, now.getTime());
//			if (month < 12 && month >= 6) {
//				reAge = month + "???";
//			} else {
//				int day = getPeriod(birthday, null);
//				if (day >= 29 && month > 0) {
//					if (now.get(Calendar.DAY_OF_MONTH) >= birth.get(Calendar.DAY_OF_MONTH)) {
//						day = now.get(Calendar.DAY_OF_MONTH) - birth.get(Calendar.DAY_OF_MONTH);
//					} else {
//						now.set(Calendar.MONTH, birth.get(Calendar.MONTH) + 1);
//						day = now.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR);
//					}
//					reAge = month + "???";
//					if (day > 0) {
//						reAge = month + "???" + day + "???";
//					}
//				} else {
//					if (day >= 4) {
//						if ((now.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR)) > 0) {
//							day = now.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR);
//						}
//						reAge = day - 1 + "???";
//					} else {
//						int hour = now.get(Calendar.HOUR_OF_DAY) - birth.get(Calendar.HOUR_OF_DAY);
//						reAge = hour + 24 * (day) + "??????";
//					}
//				}
//			}
//		}
//		HashMap<String, Object> resBody = new HashMap<String, Object>(16);
//		resBody.put("age", age);
//		resBody.put("ages", reAge);
//		return resBody;
//	}
//
//	/**
//	 * @param date1 ?????????????????????
//	 * @param date2 ?????????????????????
//	 * @return int ????????????
//	 * @Title: getMonths
//	 * @Description: TODO ???????????????????????????????????????????????????-1???
//	 * @author ?????????
//	 */
//	public static int getMonths(Date date1, Date date2) {
//		Calendar beginDate = Calendar.getInstance();
//		beginDate.setTime(date1);
//		Calendar now = Calendar.getInstance();
//		now.setTime(date2);
//		if (beginDate.after(now)) {
//			return -1;
//		}
//		int mon = now.get(Calendar.MONTH) - beginDate.get(Calendar.MONTH);
//		if (now.get(Calendar.DAY_OF_MONTH) < beginDate.get(Calendar.DAY_OF_MONTH)) {
//			if (now.getActualMaximum(Calendar.DAY_OF_MONTH) != now.get(Calendar.DAY_OF_MONTH)) {
//				mon -= 1;
//			}
//		}
//		if (now.get(Calendar.YEAR) == beginDate.get(Calendar.YEAR)) {
//			return mon;
//		}
//		return 12 * (now.get(Calendar.YEAR) - beginDate.get(Calendar.YEAR)) + mon;
//	}
//
//	/**
//	 * ??????????????????????????????????????????null?????????????????????
//	 *
//	 * @param date1
//	 * @param date2
//	 * @return
//	 */
//	public static int getPeriod(Date date1, Date date2) {
//		if (date1 == null && date2 == null) {
//			return 0;
//		}
//		if (date1 != null && date2 != null && date1.compareTo(date2) == 0) {
//			return 0;
//		}
//		Calendar begin = Calendar.getInstance();
//		if (date1 != null) {
//			begin.setTime(date1);
//		}
//		Calendar end = Calendar.getInstance();
//		if (date2 != null) {
//			end.setTime(date2);
//		}
//		if (begin.after(end)) {
//			Calendar temp = end;
//			end = begin;
//			begin = temp;
//		}
//		if (end.get(Calendar.YEAR) == begin.get(Calendar.YEAR)) {
//			return end.get(Calendar.DAY_OF_YEAR) - begin.get(Calendar.DAY_OF_YEAR);
//		}
//		int years = end.get(Calendar.YEAR) - begin.get(Calendar.YEAR);
//		int days = begin.getActualMaximum(Calendar.DAY_OF_YEAR) - begin.get(Calendar.DAY_OF_YEAR);
//		for (int i = 0; i < years - 1; i++) {
//			begin.add(Calendar.YEAR, 1);
//			days += begin.getActualMaximum(Calendar.DAY_OF_YEAR);
//		}
//		days += end.get(Calendar.DAY_OF_YEAR);
//		return days;
//	}
//
//	/**
//	 * ?????????List<Map,String> ???List<T>
//	 *
//	 * @param <T>
//	 * @param mapList
//	 * @param bean
//	 * @return
//	 * @author wy
//	 */
//	@SuppressWarnings("hiding")
//	public static <T> List<T> ListToResultSet(List<Map<String, Object>> mapList, T bean) {
//		List<T> resultList = new ArrayList<T>();
//		try {
//			for (Map<String, Object> map : mapList) {
//				bean = (T) bean.getClass().newInstance();
//				T t = BeanUtil.fillBeanWithMapIgnoreCase(map, bean, true);
//				resultList.add(t);
//			}
//		} catch (InstantiationException e) {
//			logger.error(e.getMessage(), e);
//		} catch (IllegalAccessException e) {
//			logger.error(e.getMessage(), e);
//		}
//		return resultList;
//	}

	/**
	 * @param birthday
	 * @param nowDate
	 * @return Map<String, Object> ????????????
	 * @throws @Title: getPersonAge
	 * @Description: TODO ??????????????????3*12??????????????????????????? ??????3*12????????????????????????1*12??????????????????????????????
	 *               ??????12????????????????????????6??????????????????????????? ??????6?????????????????????29??????????????????????????? ??????72????????????29????????????????????????
	 *               ??????72??????????????????????????????
	 * @author ?????????
	 */
	public static Map<String, Object> getPersonAge(Date birthday, Date nowDate) {
		if (birthday == null) {
			throw BaseException.create("ERROR_DCTWORK_OP_0040");
		}
		Calendar now = Calendar.getInstance();
		Calendar birth = Calendar.getInstance();
		birth.setTime(birthday);
		if (nowDate != null) {
			now.setTime(nowDate);
		}

		int age = AgeUtil.calculateAge(birthday, nowDate);
		String reAge = age + "???";
		if (age < 3 && age >= 1) {
			int month = getMonths(birthday, now.getTime());
			reAge = age + "???";
			if ((month - 12 * age) > 0) {
				reAge = age + "???" + (month - 12 * age) + "???";
			}
		} else if (age < 1) {
			int month = getMonths(birthday, now.getTime());
			if (month < 12 && month >= 6) {
				reAge = month + "???";
			} else {
				int day = getPeriod(birthday, null);
				if (day >= 29 && month > 0) {
					if (now.get(Calendar.DAY_OF_MONTH) >= birth.get(Calendar.DAY_OF_MONTH)) {
						day = now.get(Calendar.DAY_OF_MONTH) - birth.get(Calendar.DAY_OF_MONTH);
					} else {
						now.set(Calendar.MONTH, birth.get(Calendar.MONTH) + 1);
						day = now.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR);
					}
					reAge = month + "???";
					if (day > 0) {
						reAge = month + "???" + day + "???";
					}
				} else {
					if (day >= 4) {
						if ((now.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR)) > 0) {
							day = now.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR);
						}
						reAge = day - 1 + "???";
					} else {
						int hour = now.get(Calendar.HOUR_OF_DAY) - birth.get(Calendar.HOUR_OF_DAY);
						reAge = hour + 24 * (day) + "??????";
					}
				}
			}
		}
		HashMap<String, Object> resBody = new HashMap<String, Object>(16);
		resBody.put("age", age);
		resBody.put("ages", reAge);
		return resBody;
	}

	/**
	 * @param date1 ?????????????????????
	 * @param date2 ?????????????????????
	 * @return int ????????????
	 * @Title: getMonths
	 * @Description: TODO ???????????????????????????????????????????????????-1???
	 * @author ?????????
	 */
	public static int getMonths(Date date1, Date date2) {
		Calendar beginDate = Calendar.getInstance();
		beginDate.setTime(date1);
		Calendar now = Calendar.getInstance();
		now.setTime(date2);
		if (beginDate.after(now)) {
			return -1;
		}
		int mon = now.get(Calendar.MONTH) - beginDate.get(Calendar.MONTH);
		if (now.get(Calendar.DAY_OF_MONTH) < beginDate.get(Calendar.DAY_OF_MONTH)) {
			if (now.getActualMaximum(Calendar.DAY_OF_MONTH) != now.get(Calendar.DAY_OF_MONTH)) {
				mon -= 1;
			}
		}
		if (now.get(Calendar.YEAR) == beginDate.get(Calendar.YEAR)) {
			return mon;
		}
		return 12 * (now.get(Calendar.YEAR) - beginDate.get(Calendar.YEAR)) + mon;
	}

	/**
	 * ??????????????????????????????????????????null?????????????????????
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getPeriod(Date date1, Date date2) {
		if (date1 == null && date2 == null) {
			return 0;
		}
		if (date1 != null && date2 != null && date1.compareTo(date2) == 0) {
			return 0;
		}
		Calendar begin = Calendar.getInstance();
		if (date1 != null) {
			begin.setTime(date1);
		}
		Calendar end = Calendar.getInstance();
		if (date2 != null) {
			end.setTime(date2);
		}
		if (begin.after(end)) {
			Calendar temp = end;
			end = begin;
			begin = temp;
		}
		if (end.get(Calendar.YEAR) == begin.get(Calendar.YEAR)) {
			return end.get(Calendar.DAY_OF_YEAR) - begin.get(Calendar.DAY_OF_YEAR);
		}
		int years = end.get(Calendar.YEAR) - begin.get(Calendar.YEAR);
		int days = begin.getActualMaximum(Calendar.DAY_OF_YEAR) - begin.get(Calendar.DAY_OF_YEAR);
		for (int i = 0; i < years - 1; i++) {
			begin.add(Calendar.YEAR, 1);
			days += begin.getActualMaximum(Calendar.DAY_OF_YEAR);
		}
		days += end.get(Calendar.DAY_OF_YEAR);
		return days;
	}

	/**
	 * ????????????????????????
	 *
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date getDateBefore(Date d, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		return now.getTime();
	}

	/**
	 * ?????????????????????????????????pattern???null????????????yyyy-MM-dd?????????????????????
	 *
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String toString(Date date, String pattern) {
		DateFormat sdf = pattern == null ? new SimpleDateFormat("yyyy-MM-dd") : new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
//
//	/**
//	 * tochar????????????
//	 *
//	 * @param prop
//	 * @param format
//	 * @return
//	 */
//	public static String toChar(String prop, String format) {
//		// ??????????????????sql?????????????????????hql??????str???????????????????????????????????????????????????oracle???DB2
//		String tochar = "";
//		tochar += "to_char(" + prop + ",'" + format + "')";
//		return tochar;
//	}

	/**
	 * ?????????List<Object> ??? List<Map<String,String>>
	 *
	 * @param objList
	 * @return
	 */
	@SuppressWarnings("hiding")
	public static <T> List<Map<String, Object>> ListObjToMap(List<T> objList) {
		List<Map<String, Object>> resultList = new ArrayList<>();
		for (T obj : objList) {
			Map map = cn.hutool.core.bean.BeanUtil.beanToMap(obj);
			Map<String, Object> result = new CaseInsensitiveMap<String, Object>(map);
			resultList.add(result);
		}
		return resultList;
	}

//	/**
//	 * ??????????????????Date???????????????????????????yyyy-MM-dd HH:mm:ss????????????????????????-,/,\????????????????????????
//	 * ?????????????????????:,-,/???????????????????????? ?????????????????????????????????????????????null???
//	 *
//	 * @param str
//	 * @return ????????????????????????????????????????????????Date?????????????????????null???
//	 */
//	public static Date toDate(String str) {
//		if (str == null || str.length() < 10) {
//			return null;
//		}
//		String date = str.substring(0, 10);
//		String pattern = "/^((((19|20)\\d{2})-(0?[13-9]|1[012])-(0?[1-9]|[12]\\d|30))|(((19|20)\\d{2})-(0?[13578]|1[02])-31)|(((19|20)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|((((19|20)([13579][26]|[2468][048]|0[48]))|(2000))-0?2-29))$/";
//		// ?????????????????????????????????
//		// String pattern =
//		// "\\d{4}[-,/,\\\\]{1}(0[1-9]{1}|1[0-2]{1})[-,/,\\\\]{1}(([0-2]{1}[1-9]{1})|10|20|30|31)";
//		if (Pattern.matches(pattern, date)) {
//			return null;
//		}
//		int year = Integer.parseInt(date.substring(0, 4));
//		int month = Integer.parseInt(date.substring(5, 7)) - 1;
//		int day = Integer.parseInt(date.substring(8, 10));
//		Calendar c = Calendar.getInstance();
//		c.set(year, month, day, 0, 0, 0);
//		if (str.length() < 19) {
//			return c.getTime();
//		}
//		String time = str.substring(11, 19);
//		/* ???ptn??????[0-1]??????[0-2]????????????20?????????????????????0??? */
//		String ptn = "[0-2]{1}([0-9]{1}|2[03]{1})[:,-,/]{1}[0-5]{1}[0-9]{1}[:,-,/]{1}[0-5]{1}[0-9]{1}";
//		if (Pattern.matches(ptn, time)) {
//			int hour = Integer.parseInt(time.substring(0, 2));
//			int minute = Integer.parseInt(time.substring(3, 5));
//			int second = Integer.parseInt(time.substring(6, 8));
//			c.set(year, month, day, hour, minute, second);
//		}
//		return c.getTime();
//	}
//
//	/**
//	 * ?????????List<Object> ??? List<Map<String,String>>
//	 *
//	 * @param objList
//	 * @return
//	 */
//	@SuppressWarnings("hiding")
//	public static <T> List<Map<String, Object>> ListObjToMap(List<T> objList) {
//		List<Map<String, Object>> resultList = new ArrayList<>();
//		for (T obj : objList) {
//			Map<String, Object> map = BeanUtil.beanToMap(obj);
//			Map<String, Object> result = new CaseInsensitiveMap<String, Object>(map);
//			resultList.add(result);
//		}
//		return resultList;
//	}
//
	/**
	 * ??????????????????Date???????????????????????????yyyy-MM-dd HH:mm:ss????????????????????????-,/,\????????????????????????
	 * ?????????????????????:,-,/???????????????????????? ?????????????????????????????????????????????null???
	 *
	 * @param str
	 * @return ????????????????????????????????????????????????Date?????????????????????null???
	 */
	public static Date toDate(String str) {
		if (str == null || str.length() < 10) {
			return null;
		}
		String date = str.substring(0, 10);
		String pattern = "/^((((19|20)\\d{2})-(0?[13-9]|1[012])-(0?[1-9]|[12]\\d|30))|(((19|20)\\d{2})-(0?[13578]|1[02])-31)|(((19|20)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|((((19|20)([13579][26]|[2468][048]|0[48]))|(2000))-0?2-29))$/";
		// ?????????????????????????????????
		// String pattern =
		// "\\d{4}[-,/,\\\\]{1}(0[1-9]{1}|1[0-2]{1})[-,/,\\\\]{1}(([0-2]{1}[1-9]{1})|10|20|30|31)";
		if (Pattern.matches(pattern, date)) {
			return null;
		}
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(5, 7)) - 1;
		int day = Integer.parseInt(date.substring(8, 10));
		Calendar c = Calendar.getInstance();
		c.set(year, month, day, 0, 0, 0);
		if (str.length() < 19) {
			return c.getTime();
		}
		String time = str.substring(11, 19);
		/* ???ptn??????[0-1]??????[0-2]????????????20?????????????????????0??? */
		String ptn = "[0-2]{1}([0-9]{1}|2[03]{1})[:,-,/]{1}[0-5]{1}[0-9]{1}[:,-,/]{1}[0-5]{1}[0-9]{1}";
		if (Pattern.matches(ptn, time)) {
			int hour = Integer.parseInt(time.substring(0, 2));
			int minute = Integer.parseInt(time.substring(3, 5));
			int second = Integer.parseInt(time.substring(6, 8));
			c.set(year, month, day, hour, minute, second);
		}
		return c.getTime();
	}
//
//	/**
//	 * ?????????????????????????????????null?????????????????????
//	 *
//	 * @param date1
//	 * @param date2
//	 * @return
//	 */
//	public static int getDifferDays(Date date1, Date date2) {
//		if (date1 != null && date2 != null) {
//			return (int) ((date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000));
//		} else {
//			return 0;
//		}
//	}
//
//	public static double loadDischargeDays(String ryrq_s, String cyrq_s) {
//		Calendar c = Calendar.getInstance();
//		Date ryrq_d = toDate(ryrq_s.substring(0, 10));
//		Date cyrq_d = toDate(cyrq_s.substring(0, 10));
//		Date ryrq = toDate(ryrq_s);
//		Date cyrq = toDate(cyrq_s);
//		double d = getDifferDays(cyrq_d, ryrq_d);
//		System.out.println("buhis?????????????????????" + d);
//		c.setTime(ryrq);
//		int ryrq_h = c.get(Calendar.HOUR_OF_DAY);
//		double rysd = ryrq_h < 12 ? 0.5 : 1.0;
//		c.setTime(cyrq);
//		int cyrq_h = c.get(Calendar.HOUR_OF_DAY);
//		double cysd = cyrq_h < 12 ? 0.5 : 1.0;
//		return d + cysd - rysd;
//	}
//
//	/**
//	 * ?????????????????????vip
//	 *
//	 * @param jgid
//	 * @param brxz
//	 * @return
//	 */
//	public boolean isVIP(Integer jgid, String brxz) {
//		SysXtcs sysXtcs = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, SysXtcsCsmcCts.VIPBRXZ);
//		// ?????????VIP??????
//		Boolean isVIP = false;
//		if (sysXtcs != null) {
//			if (sysXtcs.getCsz().split(",")[0].equals(brxz)) {
//				isVIP = true;
//			}
//		}
//
//		return isVIP;
//
//	}
//
//	/**
//	 * ???????????????????????????????????????????????????
//	 *
//	 * @param d1
//	 * @param d2
//	 * @return ??????d1??????d2??????????????????????????????d1??????d2??????0??????????????????????????????
//	 */
//	public static int dateCompare(Date d1, Date d2) {
//		Calendar c = Calendar.getInstance();
//		c.setTime(d1);
//		Calendar c2 = Calendar.getInstance();
//		c2.set(Calendar.YEAR, c.get(Calendar.YEAR));
//		c2.set(Calendar.MONTH, c.get(Calendar.MONTH));
//		c2.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR));
//		Date date0 = c2.getTime();
//
//		c.setTime(d2);
//		c2.set(Calendar.YEAR, c.get(Calendar.YEAR));
//		c2.set(Calendar.MONTH, c.get(Calendar.MONTH));
//		c2.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR));
//		Date date1 = c2.getTime();
//
//		return date0.compareTo(date1);
//	}
//
//	// ????????????????????????????????????????????????????????????????????????(??????)
//	public void setSuppliesZY(Integer manaUnitId, Long jlxh) {
//		Map<String, Object> parameters = new HashMap<String, Object>(16);
//		Map<String, Object> parameterskfxh = new HashMap<String, Object>(16);
//		Map<String, Object> parametersksdm = new HashMap<String, Object>(16);
//		parameters.put("JLXH", jlxh);
//		parameters.put("JGID", manaUnitId);
//		Map<String, Object> lisFYXX = cisHzyzDao.queryWardMaterialsInfo(parameters);
//
//		parametersksdm.put("JGID", manaUnitId);
//		if (lisFYXX != null) {
//			parametersksdm.put("ZYH", Long.parseLong(lisFYXX.get("ZYH") + ""));
//		}
//		Integer wardId = 0;
//		String wardName = null;
//		String zyhm = null;
//		Map<String, Object> ksdmMap = imHzryDao.queryOfficeInfo(parametersksdm);
//		if (ksdmMap != null) {
//			if (ksdmMap.get("BRBQ") != null) {
//				wardId = ObjectToTypes.parseInt(ksdmMap.get("BRBQ"));
//			}
//			if (ksdmMap.get("KSMC") != null) {
//				wardName = ksdmMap.get("KSMC") + "";
//			}
//			if (ksdmMap.get("ZYHM") != null) {
//				zyhm = ksdmMap.get("ZYHM") + "";
//			}
//		}
//		parameterskfxh.put("ejkf", wardId);
//		Map<String, Object> kfxhMap = wlKfdzDao.findKfxh(parameterskfxh);
//		int kfxh = 0;
//		if (kfxhMap != null) {
//			if (kfxhMap.get("KFXH") != null) {
//				kfxh = Integer.parseInt(kfxhMap.get("KFXH") + "");
//			}
//		} else {
//			throw new RuntimeException("???????????????????????????????????????????????????");
//		}
//		if (lisFYXX != null) {
//			double czsl = Double.parseDouble(lisFYXX.get("CZSL") + "");
//			Long sbxh = Long.parseLong(lisFYXX.get("SBXH") + "");
//			Long fyxh = Long.parseLong(lisFYXX.get("FYXH") + "");
//			Long brid = Long.parseLong(lisFYXX.get("BRID") + "");
//			String brxm = lisFYXX.get("BRXM") + "";
//			String jgid = lisFYXX.get("JGID") + "";
//			int jgbz = 0;
//			if (lisFYXX.get("JGBZ") != null) {
//				jgbz = Integer.parseInt(lisFYXX.get("JGBZ") + "");
//			}
//			double bzjg = 0;
//			if (lisFYXX.get("BZJG") != null) {
//				bzjg = Double.parseDouble(lisFYXX.get("BZJG") + "");
//			}
//			setSuppliesJG(sbxh, fyxh, kfxh, czsl, brid, "2", wardId, brxm, wardName, -2, jgid, jgbz, bzjg, zyhm);
//		}
//	}

	/**
	 * ??????????????????
	 *
	 * @param al_yplx
	 * @param al_fyxh
	 * @return
	 */
	public Integer getfygb(Integer al_yplx, Integer al_fyxh) {
		Integer al_fygb;
		if (al_yplx == 1 || al_yplx == 2 || al_yplx == 3) {// ??????????????????,???????????????????????????,???????????????????????????????????????
			DrugsTypkDetailResp drugsTypk = drugsTypkOutSer.getDrugsTypkById(al_fyxh);
			if (drugsTypk != null && drugsTypk.getZblb() != null && drugsTypk.getZblb().intValue() > 0) {
				al_fygb = drugsTypk.getZblb();
			} else {
				throw BaseException.create("ERROR_REG_0011");
			}
		} else {
			FeeYlsfxmOutResp feeYlsfxm = feeYlsfxmOutSer.getById(al_fyxh);
			al_fygb = feeYlsfxm.getFygb();
		}
		return al_fygb;
	}

	/**
	 * @name: getPayProportion
	 * @description: ????????????????????????
	 * @param brxz ????????????
	 * @param fygb ????????????
	 * @param type ?????????????????????1,2,3,?????????0
	 * @param ypxh ????????????
	 * @return: java.util.Map<java.lang.String,java.lang.Object>
	 * @date: 2020/9/20 13:40
	 * @auther: ??????
	 *
	 */
	public Map<String, Object> getPayProportion(Object brxz, Object fygb, Object type, Object ypxh) {
		Map<String, Object> params = new HashMap<>(16);
		params.put("BRXZ", brxz);// ????????????
		params.put("FYGB", fygb);// ????????????
		params.put("TYPE", type);// ???????????? 0=??????
		params.put("FYXH", ypxh);// ????????????
		return getPayProportion(params);
	}

	/**
	 * ????????????????????????
	 *
	 * @param body
	 * @return
	 */
	public Map<String, Object> getPayProportion(Map<String, Object> body) {
		Integer al_yplx = Integer.parseInt(body.get("TYPE") + "");// ?????????????????????1,2,3,?????????0
		Object al_brxz = body.get("BRXZ");// ????????????
		Object al_fyxh = body.get("FYXH");// ????????????
		Object al_fygb = body.get("FYGB");// ????????????
		Map<String, Object> params = new HashMap<String, Object>(16);
		params.put("BRXZ", al_brxz);
		params.put("FYXH", al_fyxh);
		Map<String, Object> map = new HashMap<String, Object>(16);
		if (al_yplx == 0) {
			PubFyxzApiReq pubFyxz = new PubFyxzApiReq();
			pubFyxz.setBrxz(Integer.valueOf(params.get("BRXZ").toString()));
			pubFyxz.setFyxh(Integer.valueOf(params.get("FYXH").toString()));
			// ????????????????????????
			map = pubFyxzService.getFyjyInfo(pubFyxz);
		} else {
			FeeYpxzApiReq feeYpxz = new FeeYpxzApiReq();
			feeYpxz.setBrxz(Integer.valueOf(params.get("BRXZ").toString()));
			feeYpxz.setYpxh(Integer.valueOf(params.get("FYXH").toString()));
			// ????????????????????????
			map = feeYpxzDao.getYpjyInfo(feeYpxz);
		}
		if (map != null) {
			if (map.get("FYXE") == null || map.get("FYXE") == "") {
				map.put("FYXE", 0.0);
			}
			if (map.get("CXBL") == null || map.get("CXBL") == "") {
				map.put("CXBL", 0.0);
			}
			map.put("CXBL", ObjectToTypes.parseBigDecimal(map.get("CXBL")).divide(new BigDecimal(100), 2,
					BigDecimal.ROUND_HALF_UP));
			return map;
		}
		params.clear();
		params.put("BRXZ", al_brxz);
		params.put("FYGB", al_fygb);

		FeeSfdlzfbl feeSfdlzfbl = new FeeSfdlzfbl();
		feeSfdlzfbl.setBrxz(Integer.valueOf(params.get("BRXZ").toString()));
		feeSfdlzfbl.setSfxm(Integer.valueOf(params.get("FYGB").toString()));
		Map<String, Object> zfbl_map = feeSfdlzfblOutSer.getZfblInfo(feeSfdlzfbl);
		if (zfbl_map == null) {
			zfbl_map = new HashMap<String, Object>(16);
			zfbl_map.put("ZFBL", 1);
		}
		return zfbl_map;
	}

//	/**
//	 * ?????????????????????????????? @Title: getzfbl @Description: TODO(?????????????????????????????????????????????) @param @param
//	 * body @param @return ???????????? @return Map<String,Object> ???????????? @author ????????? @throws
//	 */
//	public Map<String, Object> getzfbl(Map<String, Object> body) {
//		Integer al_yplx = ObjectToTypes.parseInt(body.get("TYPE"));// ?????????????????????1,2,3,?????????0
//		Integer al_brxz = ObjectToTypes.parseInt(body.get("BRXZ"));// ????????????
//		Integer al_fyxh = ObjectToTypes.parseInt(body.get("FYXH"));// ????????????
//		Integer al_fygb = ObjectToTypes.parseInt(body.get("FYGB"));// ????????????
//		Map<String, Object> reMap = new HashMap<String, Object>(16);
//		reMap.put("FYGB", al_fygb);
//		reMap.put("ZFBL", 1);
//		Map<String, Object> map = new HashMap<String, Object>(16);
//		if (al_yplx == 0) {
//			PubFyxz pubFyxz = new PubFyxz();
//			pubFyxz.setBrxz(al_brxz);
//			pubFyxz.setFyxh(al_fyxh);
//			map = pubFyxzDao.getFyjyInfo(pubFyxz);
//		} else {
//			FeeYpxz feeYpxz = new FeeYpxz();
//			feeYpxz.setBrxz(al_fyxh);
//			feeYpxz.setYpxh(al_fyxh);
//			// ????????????????????????
//			map = feeYpxzDao.getYpjyInfo(feeYpxz);
//		}
//
//		if (map == null) {
//			if (al_fygb == 0) {
//				al_fygb = getfygb(al_yplx, al_fyxh);
//				reMap.put("FYGB", al_fygb);
//			}
//			FeeSfdlzfbl feeSfdlzfbl = new FeeSfdlzfbl();
//			feeSfdlzfbl.setBrxz(al_brxz);
//			feeSfdlzfbl.setSfxm(al_fygb);
//			Map<String, Object> zfblMap = feeSfdlzfblDao.getZfblInfo(feeSfdlzfbl);
//			if (zfblMap != null) {
//				reMap.put("ZFBL", zfblMap.get("ZFBL"));
//			}
//		} else {
//			reMap.put("ZFBL", map.get("ZFBL"));
//		}
//		return reMap;
//	}
//
	/**
	 * ?????????????????????????????????????????????
	 *
	 * @author wy
	 * @param fygb
	 * @param brxz
	 * @param ypxh
	 * @return
	 */
	public double getCFZFBL(long fygb, long brxz, long ypxh) {
		double zfbl = 1;
		Map<String, Object> parameters = new HashMap<String, Object>(16);
		parameters.put("BRXZ", brxz);
		parameters.put("YPXH", ypxh);
		FeeYpxzApiReq feeYpxz = new FeeYpxzApiReq();
		feeYpxz.setBrxz(parameters.get("BRXZ") != null ? Integer.valueOf(parameters.get("BRXZ").toString()) : 0);
		feeYpxz.setYpxh(parameters.get("YPXH") != null ? Integer.valueOf(parameters.get("YPXH").toString()) : 0);
		Map<String, Object> FEE_YPXZ = feeYpxzDao.getYpjyInfo(feeYpxz);
		if (FEE_YPXZ != null && FEE_YPXZ.get("ZFBL") != null) {
			zfbl = Double.parseDouble(FEE_YPXZ.get("ZFBL") + "");
		} else {
			parameters.remove("YPXH");
			parameters.put("SFXM", fygb);

			List<Map<String, Object>> FEE_SFDLZFBL = feeSfdlzfblOutSer.getZfblMap(parameters);
			zfbl = Double.parseDouble(FEE_SFDLZFBL.get(0).get("ZFBL") + "");
		}
		return zfbl;
	}

	/**
	 * ?????????????????????????????????????????????
	 *
	 * @author wy
	 * @param fygb
	 * @param brxz
	 * @param fyxh
	 * @return
	 */
	public double getYJZFBL(long fygb, long brxz, long fyxh) {
		double zfbl = 1;
		Map<String, Object> parameters = new HashMap<String, Object>(16);
		parameters.put("BRXZ", brxz);
		parameters.put("FYXH", fyxh);

		PubFyxzApiReq pubFyxz = new PubFyxzApiReq();
		pubFyxz.setBrxz(parameters.get("BRXZ") != null ? Integer.valueOf(parameters.get("BRXZ").toString()) : 0);
		pubFyxz.setFyxh(parameters.get("FYXH") != null ? Integer.valueOf(parameters.get("FYXH").toString()) : 0);
		Map<String, Object> FEE_YPXZ = pubFyxzService.getFyjyInfo(pubFyxz);

		if (FEE_YPXZ != null && FEE_YPXZ.get("ZFBL") != null) {
			zfbl = Double.parseDouble(FEE_YPXZ.get("ZFBL") + "");
		} else {
			parameters.remove("FYXH");
			parameters.put("FYGB", fygb);

			FeeSfdlzfbl feesfdlzfbl = new FeeSfdlzfbl();
			feesfdlzfbl
					.setBrxz(parameters.get("BRXZ") != null ? Integer.valueOf(parameters.get("BRXZ").toString()) : 0);
			feesfdlzfbl
					.setSfxm(parameters.get("FYGB") != null ? Integer.valueOf(parameters.get("FYGB").toString()) : 0);
			Map<String, Object> FEE_SFDLZFBL = feeSfdlzfblOutSer.getZfblInfo(feesfdlzfbl);
			if (FEE_SFDLZFBL != null) {
				zfbl = Double.parseDouble(FEE_SFDLZFBL.get("ZFBL") + "");
			}
		}
		return zfbl;
	}

//	/**
//	 * @Title: gf_zy_gxmk_getjkhj @Description: TODO ?????????????????? @param @param
//	 * BRXX @param @return ???????????? @return Map<String,Object> ???????????? @author ????????? @throws
//	 */
//	public Map<String, Object> gf_zy_gxmk_getjkhj(Map<String, Object> BRXX) {
//		BRXX.put("JKHJ", 0);
//		try {
//			Integer zyh = ObjectToTypes.parseInt(BRXX.get("ZYH"));
//			if (Integer.parseInt(BRXX.get("JSLX") + "") == 0 || Integer.parseInt(BRXX.get("JSLX") + "") == 5) {
//				BigDecimal jkhj = imTbkkDao.queryTotalPayment(zyh, null);
//				if (jkhj != null) {
//					BRXX.put("JKHJ", jkhj);
//				}
//			} else if (Integer.parseInt(BRXX.get("JSLX") + "") < 0 || Integer.parseInt(BRXX.get("JSLX") + "") == 10) {
//				BigDecimal zyjkhj = imZyjsDao.queryTotalPaymentHospital(zyh, ObjectToTypes.parseInt(BRXX.get("JSCS")));
//				if (zyjkhj != null) {
//					BRXX.put("JKHJ", zyjkhj);
//				}
//			}
//			return BRXX;
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			throw BaseException.create("ERROR_DCTWORK_ZYBQYZ_00013");
//		}
//	}
//
//	/**
//	 * add by zhangyq ??????????????????
//	 *
//	 * @param BRXX @return @throws
//	 */
//	public Map<String, Object> gf_zy_gxmk_getzfhj(Map<String, Object> BRXX) {
//		BRXX.put("ZFHJ", 0);
//		BRXX.put("YL_ZFHJ", 0);
//		BRXX.put("YP_ZFHJ", 0);
//		try {
//			Integer zyh = ObjectToTypes.parseInt(BRXX.get("ZYH"));
//			if (Integer.parseInt(BRXX.get("JSLX") + "") == 0 || Integer.parseInt(BRXX.get("JSLX") + "") == 5) {
//				BigDecimal zfhj = imFeeFymxDao.queryTotalSelf(zyh, null);
//				if (zfhj != null) {
//					BRXX.put("ZFHJ", zfhj);
//				}
//				BigDecimal zfhjCost = imFeeFymxDao.queryTotalSelfCost(zyh, null);
//				if (zfhjCost != null) {
//					BRXX.put("YL_ZFHJ", zfhjCost);
//				}
//				BigDecimal zfhjNotCost = imFeeFymxDao.queryTotalSelfNotCost(zyh, null);
//				if (zfhjNotCost != null) {
//					BRXX.put("YP_ZFHJ", zfhjNotCost);
//				}
//			} else if (Integer.parseInt(BRXX.get("JSLX") + "") < 0 || Integer.parseInt(BRXX.get("JSLX") + "") == 10) {
//				Integer jscs = ObjectToTypes.parseInt(BRXX.get("JSCS"));
//				BigDecimal zfhj = imZyjsDao.queryTotalSelfHospital(zyh, jscs);
//				if (zfhj != null) {
//					BRXX.put("ZFHJ", zfhj);
//				}
//				BigDecimal zfhjCost = imFeeFymxDao.queryTotalSelfCost(zyh, jscs);
//				if (zfhjCost != null) {
//					BRXX.put("YL_ZFHJ", zfhjCost);
//				}
//				BigDecimal zfhjNotCost = imFeeFymxDao.queryTotalSelfNotCost(zyh, jscs);
//				if (zfhjNotCost != null) {
//					BRXX.put("YP_ZFHJ", zfhjNotCost);
//				}
//			}
//			return BRXX;
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			throw BaseException.create("ERROR_DCTWORK_ZYBQYZ_00014");
//		}
//	}
//
//	/**
//	 * @Title: uf_ywcl @Description: TODO ????????????????????????????????? @param @param
//	 *         parameters @param @param manaUnitId ???????????? @return void ???????????? @author
//	 *         ????????? @throws
//	 */
//	public void uf_ywcl(Map<String, Object> parameters, Integer manaUnitId) {
//		Map<String, Object> parametersrcjl = new HashMap<String, Object>(16);
//		parametersrcjl.put("JGID", manaUnitId);
//		parametersrcjl.put("ZYH", Long.parseLong(parameters.get("ZYH") + ""));
//		parametersrcjl.put("BRKS", Long.parseLong(parameters.get("BRKS") + ""));
//		int czlx = Integer.parseInt(parameters.get("CZLX") + "");
//		int bqpb = Integer.parseInt(parameters.get("BQPB") + "");
//		parametersrcjl.put("BQPB", bqpb);
//		int al_cyfs = Integer.parseInt(parameters.get("CYFS") + "");
//		String as_jyxx = parameters.get("JYXX") + "";
//		try {
//			if (czlx == 1) {
//				parametersrcjl.put("CZLX", czlx);
//				Long l = imRcjlDao.queryZyrcjl(parametersrcjl);
//				if (l > 0) {
//					throw BaseException.create("ERROR_DCTWORK_ZYBRRY_0007");
//				}
//			} else {
//				parametersrcjl.put("CZLX", -1);
//				Long l = imRcjlDao.queryZyrcjl(parametersrcjl);
//				if (l > 0) {
//					throw BaseException.create("ERROR_DCTWORK_ZYBRRY_0008");
//				}
//			}
//			Map<String, Object> parametersSaveRcjl = new HashMap<String, Object>(16);
//			parametersSaveRcjl.put("JGID", parameters.get("JGID"));
//			parametersSaveRcjl.put("CZRQ", new Timestamp(System.currentTimeMillis()));
//			parametersSaveRcjl.put("LCRQ", DateUtil
//					.date(DateUtil.parse(parameters.get("RYRQ") + "")).toTimestamp());
//
//			parametersSaveRcjl.put("CZLX", czlx);
//			parametersSaveRcjl.put("ZYH", Long.parseLong(parameters.get("ZYH") + ""));
//			parametersSaveRcjl.put("BRKS", Long.parseLong(parametersrcjl.get("BRKS") + ""));
//			parametersSaveRcjl.put("YJZYRS", 0);
//			parametersSaveRcjl.put("BQPB", bqpb);
//			parametersSaveRcjl.put("CYFS", al_cyfs);
//			parametersSaveRcjl.put("BZXX", as_jyxx);
//			Integer jlxh = redisFactory.getTableKey(TableName.DB_NAME, TableName.IM_RCJL);
//			ImRcjl imRcjl = BeanUtil.fillBeanWithMapIgnoreCase(parametersSaveRcjl, new ImRcjl(), true);
//			imRcjl.setJlxh(jlxh);
//			imRcjlDao.insert(imRcjl);
//			parameters.put("JLXH", jlxh);
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			throw BaseException.create("ERROR_DCTWORK_ZYBRRY_0009");
//		}
//	}
//
//	/**
//	 * ?????????????????? @Title: uf_cyrq_set @Description: TODO(?????????????????????????????????????????????) @param @param
//	 * parameters @param @param manaUnitId @param @param userId ???????????? @return void
//	 * ???????????? @author ????????? @throws
//	 */
//	public void uf_cyrq_set(Map<String, Object> parameters, Integer manaUnitId, Integer userId) {
//		// ?????????????????????????????????????????????
//		Object xcyrq = parameters.get("xcyrq");// ??????????????????
//		Integer zyh = ObjectToTypes.parseInt(parameters.get("zyh"));// ?????????
//		Object CYFS = parameters.get("cyfs");// ????????????
//		Object BZXX = parameters.get("bzxx");// ????????????
//
//		Integer cyfs = Integer.parseInt(CYFS == null ? "0" : CYFS.toString());
//		if (xcyrq != null) {
//			xcyrq = toDate(xcyrq.toString());
//		}
//
//		ImRcjl imRcjl = new ImRcjl();
//		imRcjl.setZyh(zyh);
//		imRcjl.setJgid(manaUnitId);
//		imRcjl.setCzlx(1);
//
//		Long l = imRcjlDao.findByEntityCount(imRcjl);
//		if (l == 0) {
//			throw BaseException.create("ERROR_DCTWORK_ZYBRRY_00010");
//		}
//		imRcjl.setBqpb(0);
//		ImRcjl rcjl = imRcjlDao.queryClinicalDate(imRcjl);
//
//		if (rcjl != null && xcyrq != null && dateCompare(new Date(rcjl.getLcrq().getTime()), (Date) xcyrq) > 0) {
//			throw BaseException.create("ERROR_DCTWORK_ZYBRRY_00011");
//		}
//
//		ImHzry imHzry = new ImHzry();
//		imHzry.setJgid(manaUnitId);
//		imHzry.setZyh(zyh);
//		ImHzry brry = imHzryDao.queryZyKsInfo(imHzry);
//
//		imRcjl.setCzlx(-1);
//		ImRcjl yrcjl = imRcjlDao.queryClinicalDate(imRcjl);
//		if (brry.getCypb() != 0) {
//			throw BaseException.create("ERROR_DCTWORK_ZYBRRY_00012");
//		}
//		boolean cyrqFlag = xcyrq == null && (yrcjl == null || yrcjl.getLcrq() == null);
//		if (cyrqFlag) {
//			throw BaseException.create("ERROR_DCTWORK_ZYBRRY_00013");
//		}
//		if (xcyrq == null) {
//			imRcjl.setBqpb(1);
//			ImRcjl jlxhMap = imRcjlDao.queryClinicalDate(imRcjl);
//			CisHzyz cisHzyz = new CisHzyz();
//			if (jlxhMap != null) {
//				if (jlxhMap.getJlxh() != null) {
//					cisHzyz.setYwid(jlxhMap.getJlxh());
//					cisHzyz.setJgid(manaUnitId);
//					cisHzyzDao.removeByEntity(cisHzyz);
//				}
//			}
//			ImRcjl imRcjlNew = new ImRcjl();
//			imRcjlNew.setZyh(zyh);
//			imRcjlNew.setJgid(manaUnitId);
//			imRcjlNew.setCzlx(-1);
//			imRcjlDao.removeByEntity(imRcjlNew);
//
//			ImCyjl imCyjl = new ImCyjl();
//			imCyjl.setJgid(manaUnitId);
//			imCyjl.setCzrq(DateUtil.beginOfDay(new Date()).toTimestamp());
//			imCyjl.setCysj(null);
//			imCyjl.setCzlx(2);
//			imCyjl.setZyh(zyh);
//			imCyjl.setCzr(userId);
//			imCyjl.setCyfs(0);
//			imCyjl.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.IM_CYJL));
//			imCyjlDao.insert(imCyjl);
//		} else {
//			if (yrcjl != null && (toString(new Date(rcjl.getLcrq().getTime()), DatePattern.NORM_DATETIME_PATTERN))
//					.equals(toString((Date) xcyrq, DatePattern.NORM_DATETIME_PATTERN))) {
//				imRcjl.setCzlx(-1);
//				imRcjl.setBqpb(1);
//				Map<String, Object> zyinfo = new HashMap<String, Object>(16);
//				zyinfo.put("CYFS", cyfs);
//				zyinfo.put("BZXX", BZXX);
//				zyinfo.put("JGID", manaUnitId);
//				zyinfo.put("ZYH", zyh);
//				ImRcjl jlxhMap = imRcjlDao.queryClinicalDate(imRcjl);
//				CisHzyz cisHzyz = new CisHzyz();
//				if (jlxhMap != null) {
//					if (jlxhMap.getJlxh() != null) {
//						cisHzyz.setYwid(jlxhMap.getJlxh());
//						cisHzyz.setJgid(manaUnitId);
//						cisHzyzDao.removeByEntity(cisHzyz);
//					}
//				}
//				imRcjlDao.updateCyfsStatus(zyinfo);
//				return;
//			}
//
//			if (yrcjl == null || yrcjl.getLcrq() == null) {
//				ImHzry imHzryCy = new ImHzry();
//				imHzryCy.setCyrq(new Timestamp(((Date) xcyrq).getTime()));
//				imHzryCy.setCyfs(cyfs);
//				imHzryCy.setZyh(zyh);
//				imHzryCy.setJgid(manaUnitId);
//				imHzryDao.updateZyCyfsStatus(imHzry);
//
//				Map<String, Object> ywcl = new HashMap<String, Object>(16);
//				ywcl.put("ZYH", zyh);
//				ywcl.put("JGID", manaUnitId);
//				ywcl.put("CZLX", -1);
//				ywcl.put("BQPB", 0);
//				ywcl.put("RYRQ", toString((Date) xcyrq, DatePattern.NORM_DATETIME_PATTERN));
//				ywcl.put("BRKS", brry.getBrks());
//				ywcl.put("JYXX", BZXX);
//				ywcl.put("CYFS", cyfs);
//				uf_ywcl(ywcl, manaUnitId);
//				ywcl.put("BQPB", 1);
//				ywcl.put("BRKS", brry.getBrbq());
//				uf_ywcl(ywcl, manaUnitId);
//				parameters.put("JLXH", ywcl.get("JLXH") + "");
//			} else {
//				ImRcjl imRcjlCy = new ImRcjl();
//				imRcjlCy.setLcrq(new Timestamp(((Date) xcyrq).getTime()));
//				imRcjlCy.setCyfs(cyfs);
//				imRcjlCy.setZyh(zyh);
//				imRcjlCy.setJgid(manaUnitId);
//				imRcjlCy.setCzrq(new Timestamp(System.currentTimeMillis()));
//				imRcjlCy.setBzxx(ObjectToTypes.parseString(BZXX));
//				imRcjlDao.updateImRcjlCyfsStatus(imRcjlCy);
//				imRcjl.setCzlx(-1);
//				imRcjl.setBqpb(1);
//				ImRcjl jlxhMap = imRcjlDao.queryClinicalDate(imRcjl);
//				CisHzyz cisHzyz = new CisHzyz();
//				if (jlxhMap != null) {
//					if (jlxhMap.getJlxh() != null) {
//						cisHzyz.setYwid(jlxhMap.getJlxh());
//						cisHzyz.setJgid(manaUnitId);
//						cisHzyzDao.removeByEntity(cisHzyz);
//					}
//				}
//			}
//		}
//
//	}

	/**
	 * ??????????????????????????????????????????
	 *
	 * @author wy
	 * @param uid        ????????????
	 * @param manageUnit ????????????
	 * @param n          1:???????????? 2??????????????? 3???????????????
	 * @return
	 */
	public String getFPHM(Integer uid, Integer manageUnit, int n) {
		Integer ll_count = opYgpjDao.getJlxhCount(manageUnit, uid, 2);
		if (ll_count > 0) {
			List<OpYgpj> ygpjList = opYgpjDao.getFirstSyhm(manageUnit, uid, 2);
			List<Map<String, Object>> ret = ListObjToMap(ygpjList);
			if (ret.size() < 1) {
				return null;
			}
			Map<String, Object> record = ret.get(0);
			String syhm = (String) record.get("SYHM");
			String zzhm = (String) record.get("ZZHM");
			int k = -1;
			for (int i = syhm.length() - 1; i >= 0; i--) {
				if (syhm.charAt(i) < '0' || syhm.charAt(i) > '9') {
					k = i;
					break;
				}
			}
			String syhmzm = syhm.substring(0, k + 1);
			String syhmsz = syhm.substring(k + 1);
			String zzhmsz = zzhm.substring(k + 1);
			long intnewsyhm = Long.parseLong(syhmsz) + n - 1;
			long intzzhm = Long.parseLong(zzhmsz);
			String newsyhm = "";
			if (intzzhm < intnewsyhm) {
				if (ret.size() > 1) {
					Map<String, Object> record1 = ret.get(1);
					syhm = (String) record1.get("SYHM");
					k = -1;
					for (int i = syhm.length() - 1; i >= 0; i--) {
						if (syhm.charAt(i) < '0' || syhm.charAt(i) > '9') {
							k = i;
							break;
						}
					}
					syhmzm = syhm.substring(0, k + 1);
					syhmsz = syhm.substring(k + 1);
					// int length1 = syhm1.length();
					intnewsyhm = Long.parseLong(syhmsz) + intnewsyhm - intzzhm - 1;
					intzzhm = Long.parseLong(zzhmsz);
					if (intzzhm >= intnewsyhm) {
						newsyhm = syhmzm + String.format("%0" + syhmsz.length() + "d", intnewsyhm);
					} else {
						if (ret.size() > 2) {
							Map<String, Object> record2 = ret.get(2);
							syhm = (String) record2.get("SYHM");
							k = -1;
							for (int i = syhm.length() - 1; i >= 0; i--) {
								if (syhm.charAt(i) < '0' || syhm.charAt(i) > '9') {
									k = i;
									break;
								}
							}
							syhmzm = syhm.substring(0, k + 1);
							syhmsz = syhm.substring(k + 1);
							// int length1 = syhm1.length();
							intnewsyhm = Long.parseLong(syhmsz) + intnewsyhm - intzzhm - 1;
							intzzhm = Long.parseLong(zzhmsz);
							if (intzzhm >= intnewsyhm) {
								newsyhm = syhmzm + String.format("%0" + syhmsz.length() + "d", intnewsyhm);
							} else {
								return null;
							}
						} else {
							return null;
						}
					}
				} else {
					return null;
				}
			} else {
				newsyhm = syhmzm + String.format("%0" + syhmsz.length() + "d", intnewsyhm);
			}
			// record.put("SYHM", newsyhm);
			return newsyhm;
		} else {
			return null;
		}
	}

//	/***
//	 * ?????????Double???????????????scale????????? ????????????
//	 *
//	 * @param doubleVal
//	 * @param scale     scale???????????????0???????????????????????????0
//	 * @return
//	 */
//	public static String formatBy2Scale(Double doubleVal, int scale) {
//		if (null == doubleVal) {
//			doubleVal = new Double(0);
//		}
//		StringBuffer sbStr = new StringBuffer("0.");
//		for (int i = 0; i < scale; i++) {
//			sbStr.append("0");
//		}
//		DecimalFormat myformat = new DecimalFormat(sbStr.toString());
//		return myformat.format(doubleVal);
//	}
//
//	/**
//	 * @Title: u_his_share_yzzxsj @Description: TODO ????????????????????? @param @return
//	 * ???????????? @return List<Map<String,Object>> ???????????? @author ????????? @throws
//	 */
//	public List<Map<String, Object>> u_his_share_yzzxsj() {
//		List<Map<String, Object>> sypcList = null;
//		try {
//			List<DicSypc> dicSypcList = dicSypcDao.findByEntity(null);
//			sypcList = ListObjToMap(dicSypcList);
//		} catch (Exception e) {
//			throw BaseException.create("ERROR_DCTWORK_ZYZKJL_0001");
//		}
//		return sypcList;
//	}
//
//	/**
//	 * ?????????????????????
//	 *
//	 * @param {ZYH} @param @param @return @throws
//	 */
//	public int uf_lsyz(List<Map<String, Object>> listMap, Integer zyh) {
//		try {
//			// ???????????????????????????YZPB<>4
//			List<Map<String, Object>> bryzs = cisHzyzDao.queryHistoricalOrders(zyh);
//			for (Map<String, Object> bryz : bryzs) {
//				int lsbz = uf_cacl_lsbz(listMap, bryz);
//				if (lsbz == 1) {
//					cisHzyzDao.updateToHistoricalOrders(ObjectToTypes.parseInt(bryz.get("JLXH")));
//				}
//			}
//		} catch (Exception e) {
//			throw BaseException.create("ERROR_DCTWORK_ZYZKJL_0002");
//		}
//		return 1;
//	}
//
//	/**
//	 * @Title: uf_cacl_lsbz @Description: TODO ?????????????????? ????????? parameters???????????? datetime
//	 * adt_kssj ???????????????adt_qrsj ???????????????adt_tzsj ???????????????string as_sypc
//	 * ???????????????as_yzzxsj_str????????????????????????long al_lsyz ?????????????????? ?????????int lsbz ???????????? 1:????????????
//	 * 0:???????????? @param @param dicsypcList @param @param parameters @param @return
//	 * ???????????? @return int ???????????? @author ????????? @throws
//	 */
//	public static int uf_cacl_lsbz(List<Map<String, Object>> dicsypcList, Map<String, Object> parameters) {
//		SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			Date adt_kssj = null;
//			if (parameters.get("ldt_kssj") != null) {
//				adt_kssj = sdfdatetime.parse(parameters.get("ldt_kssj") + "");
//			}
//			Date adt_qrsj = null;
//			if (parameters.get("ldt_qrsj") != null) {
//				adt_qrsj = sdfdatetime.parse(parameters.get("ldt_qrsj") + "");
//			}
//			Date adt_tzsj = null;
//			if (parameters.get("ldt_tzsj") != null) {
//				adt_tzsj = sdfdatetime.parse(parameters.get("ldt_tzsj") + "");
//			}
//			String as_sypc = parameters.get("ls_sypc") + "";
//			String as_yzzxsj_str = parameters.get("ls_yzzxsj_str") + "";
//			Long al_lsyz = null;
//			if (parameters.get("ll_lsyz") != null) {
//				al_lsyz = Long.parseLong(parameters.get("ll_lsyz") + "");
//			}
//			if (al_lsyz == 1) {
//				if (adt_qrsj == null) {
//					return 0;
//				} else {
//					return 1;
//				}
//			}
//			if (adt_tzsj == null) {
//				return 0;
//			}
//			if (adt_qrsj == null) {
//				adt_qrsj = adt_kssj;
//			}
//			if (adt_qrsj.getTime() >= adt_tzsj.getTime()) {
//				return 1;
//			}
//			for (int i = 0; i < dicsypcList.size(); i++) {
//				if ((dicsypcList.get(i).get("PCBM") + "").equals(as_sypc)) {
//					if (StrUtil.isBlank(as_yzzxsj_str) || "0".equals(as_yzzxsj_str)) {
//						as_yzzxsj_str = dicsypcList.get(i).get("ZXSJ") + "";
//					}
//					List<String> ls_zxsjlist = new ArrayList<String>();
//					// ???????????????????????????????????????????????????
//					parameters.put("as_yzzxsj_str", as_yzzxsj_str);
//					uf_get_zxsj_list(parameters, ls_zxsjlist);
//					// ??????????????????
//					int ll_mrcs = ObjectToTypes.parseInt(dicsypcList.get(i).get("MRCS"));
//					// ?????????????????????????????????
//					int ll_total_ts = getPeriod(adt_qrsj, adt_tzsj) + 1;
//					// ?????????????????????????????? for????????????
//					for (int ll_ts = 0; ll_ts < ll_total_ts; ll_ts++) {
//						// ????????????
//						Date ldt_current = getDateAfter(adt_qrsj, ll_ts);
//						parameters.put("as_sypc", as_sypc);
//						parameters.put("adt_kssj", adt_kssj);
//						parameters.put("ldt_current", ldt_current);
//						int bol = uf_check_zx(dicsypcList, parameters);
//						if (bol <= 0) {
//							continue;
//						}
//						for (int ll_zxcs = 0; ll_zxcs < ll_mrcs; ll_zxcs++) {
//							Date ldt_zxsj = sdfdatetime
//									.parse(sdfdate.format(ldt_current) + " " + ls_zxsjlist.get(ll_zxcs));
//							if (ldt_zxsj.getTime() > adt_qrsj.getTime() && ldt_zxsj.getTime() < adt_tzsj.getTime()) {
//								return 0;
//							}
//						}
//					}
//				}
//			}
//		} catch (ParseException e) {
//			logger.error(e.getMessage(), e);
//			throw BaseException.create("ERROR_DCTWORK_ZYZKJL_0003");
//		}
//		return 1;
//	}
//
//	/**
//	 * @Title: getDateAfter @Description: TODO ???????????????????????? @param @param
//	 *         d @param @param day @param @return ???????????? @return Date ???????????? @author
//	 *         ????????? @throws
//	 */
//	public static Date getDateAfter(Date d, int day) {
//		Calendar now = Calendar.getInstance();
//		now.setTime(d);
//		now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
//		return now.getTime();
//	}
//
//	/**
//	 *
//	 * @Title: uf_get_zxsj_list @Description: TODO ????????? parameters???????????? string
//	 * as_yzzxsj_str????????????????????????ref string ls_zxsjlist[]??????????????????????????????????????????????????? @param @param
//	 * parameters @param @param ls_zxsjlist ???????????? @return void ???????????? @author
//	 * ????????? @throws
//	 */
//	public static void uf_get_zxsj_list(Map<String, Object> parameters, List<String> ls_zxsjlist) {
//		String as_zxsj_str = parameters.get("as_yzzxsj_str") + "";
//		String ls_zxsj = as_zxsj_str.trim();
//		if (ls_zxsj != "" || ls_zxsj != null) {
//			String[] ll_pos = ls_zxsj.split("-");
//			for (int i = 0; i < ll_pos.length; i++) {
//				if (ll_pos[i].indexOf(":") < 0) {
//					ls_zxsjlist.add(ll_pos[i] + ":00:00");
//				} else {
//					ls_zxsjlist.add(ll_pos[i] + ":00");
//				}
//			}
//		}
//	}
//
//	/**
//	 * @Title: uf_check_zx @Description: TODO ?????????????????????????????? ?????????parameters???????????? string
//	 * as_sypc ????????????datetime adt_kssj ????????????(????????????) datetime adt_dqrq ???????????? ????????? int
//	 * ll_zxbz 1:????????? 0:???????????? -1:??????????????? @param @param dicsypcList @param @param
//	 * parameters @param @return ???????????? @return int ???????????? @author ????????? @throws
//	 */
//	public static int uf_check_zx(List<Map<String, Object>> dicsypcList, Map<String, Object> parameters) {
//		SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		int ll_zxbz = 0;
//		for (int i = 0; i < dicsypcList.size(); i++) {
//			if (dicsypcList.get(i).get("PCBM").toString().equals(parameters.get("as_sypc").toString())) {
//				if (Integer.parseInt(dicsypcList.get(i).get("ZXZQ") + "") == 1) {
//					ll_zxbz = 1;
//					break;
//				} else {
//					// ??????????????????
//					int ll_zxzq = Integer.parseInt(dicsypcList.get(i).get("ZXZQ") + "");
//					String ls_rzxzq = dicsypcList.get(i).get("RZXZQ") + "";
//					if (ll_zxzq != ls_rzxzq.length()) {
//						ll_zxbz = -1;
//						break;
//					} else {
//						try {
//							// ???????????????
//							if (Integer.parseInt(dicsypcList.get(i).get("RLZ") + "") == 1) {
//								int weknum = getWeekOfDate(
//										sdfdatetime.parse(sdfdatetime.format(parameters.get("ldt_current"))));
//								if (ls_rzxzq.length() != weknum) {
//									ll_zxbz = Integer.parseInt(ls_rzxzq.substring(weknum - 1, weknum));
//								} else {
//									ll_zxbz = Integer.parseInt(ls_rzxzq.substring(weknum - 1));
//								}
//							} else {
//								int ll_days = getPeriod(sdfdate.parse(sdfdatetime.format(parameters.get("adt_kssj"))),
//										sdfdate.parse(sdfdatetime.format(parameters.get("ldt_current")))) + 1;
//								ll_days = ll_days % ll_zxzq;
//								if (ll_days == 0) {
//									ll_days = ls_rzxzq.length() - 1;
//								} else {
//									ll_days = ll_days - 1;
//								}
//								if (ls_rzxzq.length() != ll_days) {
//									ll_zxbz = Integer.parseInt(ls_rzxzq.substring(ll_days, ll_days + 1)); // ???????????????????????????
//								} else {
//									ll_zxbz = Integer.parseInt(ls_rzxzq.substring(ll_days)); // ???????????????????????????
//								}
//							}
//						} catch (ParseException e) {
//							throw BaseException.create("ERROR_DCTWORK_ZYZKJL_0004");
//						}
//						break;
//					}
//				}
//			} else {
//				ll_zxbz = -1;
//			}
//		}
//		return ll_zxbz;
//	}
//
//	/**
//	 * @Title: getWeekOfDate @Description: TODO
//	 * ????????????????????????????????????????????????????????????????????????1??????????????????2.. @param @param dt @param @return
//	 * ???????????? @return int ???????????? @author ????????? @throws
//	 */
//	public static int getWeekOfDate(Date dt) {
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(dt);
//		int w = cal.get(Calendar.DAY_OF_WEEK);
//		return w;
//	}
//
	/**
	 * ?????????????????????MAP,?????????????????????????????????Map????????????key????????????
	 *
	 * @author wy
	 * @param bean
	 * @return
	 */
	public static Map<String, Object> caseInsensitiveMap(Object bean) {
		if (bean == null) {
			bean = new Object();
		}
		Map<String, Object> map = BeanUtil.beanToMap(bean);
		Map<String, Object> result = new CaseInsensitiveMap<String, Object>(map);
		return result;
	}

	/**
	 * map ??????key???????????????
	 *
	 * @param orgMap
	 * @return
	 */
	public static Map<String, Object> transformLowerCase(Map<String, Object> orgMap) {
		Map<String, Object> resultMap = new HashMap<>();
		if (orgMap == null || orgMap.isEmpty()) {
			return resultMap;
		}
		Set<String> keySet = orgMap.keySet();
		for (String key : keySet) {
			String newKey = key.toLowerCase();
//			newKey = newKey.replace("_", "");
			resultMap.put(newKey, orgMap.get(key));
		}
		return resultMap;
	}

	/**
	 * ??????:??????????????????????????????????????????????????? ??????????????????????????????
	 *
	 * @param body
	 * @param jgid
	 * @return
	 */
	public Map<String, Object> checkInventory(Map<String, Object> body, Integer jgid) {
		Object pharmId = body.get("pharmId");// ????????????
		Object medId = body.get("medId");// ????????????
		Object medsource = body.get("medsource");// ????????????
		Object quantity = body.get("quantity");// ????????????
		int tag = 0;
		if (body.containsKey("JC")) {
			tag = 1;
		}

		Map<String, Object> params = new HashMap<String, Object>(16);
		params.put("YFSB", Long.parseLong(pharmId.toString()));
		params.put("YPXH", Long.parseLong(medId.toString()));
		params.put("YPCD", Long.parseLong(medsource.toString()));

		List<Map<String, Object>> list = drugService.getKczlAndLsjg(Integer.valueOf(pharmId.toString()),
				Integer.valueOf(medId.toString()), Integer.valueOf(medsource.toString()));

		HashMap<String, Object> map = null;
		if (list == null || list.size() == 0) {
			map = new HashMap<String, Object>(16);
			map.put("sign", -1);
			map.put("KCZL", 0);
			return map;
		}
		map = (HashMap<String, Object>) list.get(0);
		Double kczl = Double.valueOf(map.get("kczl").toString());
		// ????????????????????????
		int SFQYYFYFY = Integer.parseInt(sysXtcsCacheSer.getCsz(jgid, "SFQYYFYFY"));
		double KCDJTS = Double.valueOf(sysXtcsCacheSer.getCsz(jgid, "KCDJTS").toString());
		if (tag == 1) {
			KCDJTS = Double.valueOf(sysXtcsCacheSer.getCsz(jgid, "JCKCDJTS").toString());
		}
		if (SFQYYFYFY == 1) {
			// Session ss = (Session) ctx.get(Context.DB_SESSION);
			// ss.beginTransaction();
			// MedicineCommonModel model = new MedicineCommonModel(
			// new BaseDAO(ctx));
			// model.deleteKCDJ(manaUnitId, ctx);
			// ss.getTransaction().commit();
			long jlxh = 0;
			if (body.containsKey("jlxh")) {
				jlxh = ObjectToTypes.parseLong(body.get("jlxh"));
			}
			params.put("jlxh", jlxh);
			params.put("kcdjts", KCDJTS);
			// params.put("LSJG", map.get("LSJG"));

			QueryDjYpslReq ypsl = BeanUtil.fillBeanWithMapIgnoreCase(params, new QueryDjYpslReq(), true);

			BigDecimal list_djsl = pharKcdjDao.sumYpsl(ypsl);
			// Map<String, Object> map_djsl=dao.doLoad(hql_djsl.toString(),
			// params);
			if (list_djsl != null) {
				kczl -= ObjectToTypes.parseDouble(list_djsl);
			}
		}
		// ????????????????????????
		if (kczl == null || kczl < Double.parseDouble(quantity.toString())) {
			if (kczl == null) {
				map.put("KCZL", 0);
			} else {
				DecimalFormat df = new DecimalFormat("#.00");
				map.put("KCZL", df.format(kczl));
			}
			map.put("sign", -1);
		} else {
			map.put("sign", 1);
		}
		return map;
	}

	/**
	 * ???????????????
	 *
	 * @param n
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static double simpleMultiply(int n, Object num1, Object num2) {
		return formatDouble(n, parseDouble(num1) * parseDouble(num2));
	}

	/**
	 * double???????????????
	 *
	 * @param number
	 * @param data
	 * @return
	 */
	public static double formatDouble(int number, double data) {
		return MzUtil.getDouble(data, number);
	}

	/**
	 * double????????????????????????
	 *
	 * @param d
	 * @param i
	 * @return
	 */
	public static double getDouble(Object d, int i) {
		if (d == null) {
			d = 0d;
		}
		String rStr = String.format("%." + i + "f", Double.parseDouble(d + ""));
		double rd = Double.parseDouble(rStr);
		return rd;
	}

	/**
	 * ???????????????double
	 *
	 * @param o
	 * @return
	 */
	public static double parseDouble(Object o) {
		if (o == null || "".equals(o)) {
			return new Double(0);
		}
		return Double.parseDouble(o + "");
	}

//
//	/*
//	 * ??????????????????
//	 *
//	 * @param sbxh
//	 *
//	 * @param brly
//	 *
//	 * @param jgid
//	 */
//	public void updateXHMXZT(Long sbxh, String brly, Integer jgid) {
//		Map<String, Object> parametersxhmx = new HashMap<String, Object>(16);
//		parametersxhmx.put("JGID", jgid);
//		parametersxhmx.put("MZXH", sbxh);
//		parametersxhmx.put("BRLY", brly);
//		parametersxhmx.put("ZTBZ", 0);
//		wlXhmxDao.updateZtbz(parametersxhmx);
//	}
//
	public static String getDate() {
		Date date = new Date();
		SimpleDateFormat matter = new SimpleDateFormat("yyyy-MM-dd");
		return matter.format(date);
	}

//
//	/**
//	 * @Title: uf_yztj @Description: TODO ???????????? collardrugdetailslist???????????????????????????????????????
//	 * parameters ???????????? ?????????????????????????????????????????????Map????????? @param @param
//	 * collardrugdetailslist @param @param qrsjMap @param @param parameters
//	 * ???????????? @return void ???????????? @author ????????? @throws
//	 */
//	public void uf_yztj(List<Map<String, Object>> collardrugdetailslist, Map<Long, List<Date>> qrsjMap,
//			Map<String, Object> parameters, SysUser user) {
//		SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		int ll_fycs_total = 0;
//		try {
//			Date adt_ylrq = sdfdate.parse(sdfdate.format(parameters.get("ldt_server")));
//			/*********************************************/
//			Date adt_ylrq_by = adt_ylrq;// ??????????????????????????????????????????12????????????????????????????????????????????????????????????
//			if (null != parameters.get("ldt_server_by")) {
//				adt_ylrq_by = sdfdate.parse(sdfdate.format(parameters.get("ldt_server_by")));
//			}
//			/*********************************************/
//			List<Map<String, Object>> dicsypcList = u_his_share_yzzxsj();
//			for (int ll_row = 0; ll_row < collardrugdetailslist.size(); ll_row++) {
//				List<Date> ldt_qrsj_list = new ArrayList<Date>();
//				// ????????????
//				Long ll_yzxh = Long.parseLong(collardrugdetailslist.get(ll_row).get("JLXH") + "");
//				String ldt_kssj = null;
//				// ????????????
//				if (collardrugdetailslist.get(ll_row).get("KSSJ") != null) {
//					ldt_kssj = collardrugdetailslist.get(ll_row).get("KSSJ") + "";
//				}
//				String ldt_tzsj = null;
//				// ????????????
//				if (collardrugdetailslist.get(ll_row).get("TZSJ") != null) {
//					ldt_tzsj = collardrugdetailslist.get(ll_row).get("TZSJ") + "";
//				}
//				String ldt_qrsj = null;
//				// ????????????
//				if (collardrugdetailslist.get(ll_row).get("QRSJ") != null) {
//					ldt_qrsj = collardrugdetailslist.get(ll_row).get("QRSJ") + "";
//				}
//				// ????????????
//				String ls_sypc = collardrugdetailslist.get(ll_row).get("SYPC") + "";
//
//				int ll_lsyz = Integer.parseInt(collardrugdetailslist.get(ll_row).get("LSYZ") + "");// ??????????????????
//				// ???????????????????????????
//				String ls_yzzxsj_str = collardrugdetailslist.get(ll_row).get("YZZXSJ") + "";
//				// ????????????
//				int ll_yfbz = Integer.parseInt(collardrugdetailslist.get(ll_row).get("YFBZ") + "");
//				// ????????????
//				int ll_srcs = Integer.parseInt(collardrugdetailslist.get(ll_row).get("SRCS") + "");
//				// ????????????
//				int ll_xmlx = Integer.parseInt(collardrugdetailslist.get(ll_row).get("XMLX") + "");
//				// ????????????
//				Double ycsl = ObjectToTypes.parseDouble(collardrugdetailslist.get(ll_row).get("YCSL"));
//				Map<String, Object> sjparameters = new HashMap<String, Object>(16);
//				sjparameters.put("ldt_kssj", ldt_kssj);
//				sjparameters.put("ldt_qrsj", ldt_qrsj);
//				sjparameters.put("ldt_tzsj", ldt_tzsj);
//				sjparameters.put("ls_sypc", ls_sypc);
//				sjparameters.put("ls_yzzxsj_str", ls_yzzxsj_str);
//				sjparameters.put("ll_lsyz", ll_lsyz);
//				sjparameters.put("al_ypbz", 1);
//				if (ll_yfbz + "" == "" || ll_yfbz == 0) {
//					ll_yfbz = 1;
//				}
//				int ll_lsbz = uf_cacl_lsbz(dicsypcList, sjparameters);
//				if (ll_lsbz == 1) {
//					parameters.put("ll_yzxh", ll_yzxh);
//					uf_update_lsbz(parameters, user);
//					collardrugdetailslist.get(ll_row).put("FYCS", 0);
//					continue;
//				}
//				parameters.put("ldt_kssj", ldt_kssj);
//				parameters.put("ldt_qrsj", ldt_qrsj);
//				parameters.put("ldt_tzsj", ldt_tzsj);
//				parameters.put("adt_ylrq", adt_ylrq);
//				parameters.put("ll_srcs", ll_srcs);
//				parameters.put("ls_sypc", ls_sypc);
//				parameters.put("ls_yzzxsj_str", ls_yzzxsj_str);
//				parameters.put("al_fybz", 1);
//				// ??????????????????
//				// ????????????
//				if (ll_lsyz == 0) {
//					/*********************************************/
//					String ldt_fyfs = collardrugdetailslist.get(ll_row).get("FYFS") + "";
//					// ???????????????2?????????
//					if ("2".equals(ldt_fyfs)) {
//						// ??????
//						// ????????????????????????
//						parameters.put("adt_ylrq", adt_ylrq_by);
//						ll_fycs_total = uf_cacl_fycs_cq(dicsypcList, parameters, ldt_qrsj_list);
//					} else {
//						parameters.put("adt_ylrq", adt_ylrq);
//						ll_fycs_total = uf_cacl_fycs_cq(dicsypcList, parameters, ldt_qrsj_list);
//					}
//				} else {
//					// ????????????
//					if (ll_xmlx != 3) {
//						ll_fycs_total = uf_cacl_fycs_ls(dicsypcList, parameters, ldt_qrsj_list);
//					}
//				}
//				if (ll_xmlx == 3) {
//					collardrugdetailslist.get(ll_row).put("FYCS", 1);
//					collardrugdetailslist.get(ll_row).put("JE", String.format("%1$.2f",
//							ycsl * 1 * ObjectToTypes.parseDouble(collardrugdetailslist.get(ll_row).get("YPDJ"))));
//				} else {
//					collardrugdetailslist.get(ll_row).put("FYCS", ll_fycs_total);
//					collardrugdetailslist.get(ll_row).put("JE", String.format("%1$.2f", ycsl * ll_fycs_total
//							* ObjectToTypes.parseDouble(collardrugdetailslist.get(ll_row).get("YPDJ"))));
//				}
//				qrsjMap.put(ll_yzxh, ldt_qrsj_list);
//			}
//
//		} catch (ParseException e) {
//			throw BaseException.create("ERROR_DCTWORK_ZYBQYZ_00021");
//		}
//	}
//
//	/**
//	 * @Title: uf_update_lsbz @Description: TODO ????????????????????????????????? @param @param
//	 * parameters @param @param user ???????????? @return void ???????????? @author ????????? @throws
//	 */
//	public void uf_update_lsbz(Map<String, Object> parameters, SysUser user) {
//		Integer manageUnit = user.getHospitalId();
//		try {
//			Map<String, Object> parametersjlxh = new HashMap<String, Object>(16);
//			if (parameters.get("ll_yzxh") != null) {
//				parametersjlxh.put("JLXH", ObjectToTypes.parseInt(parameters.get("ll_yzxh")));
//			} else {
//				parametersjlxh.put("JLXH", 0);
//			}
//			parametersjlxh.put("JGID", manageUnit);
//			cisHzyzDao.modifyToHistoricalAppointOrders(parametersjlxh);
//		} catch (Exception e) {
//			throw BaseException.create("ERROR_DCTWORK_ZYBQYZ_00022");
//		}
//	}
//
//	/**
//	 * @Title: uf_cacl_fycs_cq @Description: TODO ?????????parameters???????????? datetime
//	 * adt_kssj ???????????????adt_qrsj ???????????????adt_tzsj ???????????????adt_ylrq ???????????????long ???????????????string
//	 * as_sypc ???????????????as_yzzxsj_str????????????????????????long ??????????????? ref datetime
//	 * adt_qrsj_list[]??????????????????, long al_fybz (1:?????? 2:??????) ?????????long ll_count
//	 * ???????????????????????? @param @param dicsypcList @param @param parameters @param @param
//	 * adt_qrsj_list @param @return ???????????? @return int ???????????? @author ????????? @throws
//	 */
//	public static int uf_cacl_fycs_cq(List<Map<String, Object>> dicsypcList, Map<String, Object> parameters,
//			List<Date> adt_qrsj_list) {
//		SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
//		int ll_count = 0;
//		try {
//			Date adt_kssj = null;
//			if (parameters.get("ldt_kssj") != null) {
//				adt_kssj = sdfdatetime.parse(parameters.get("ldt_kssj") + "");
//			}
//			Date adt_qrsj = null;
//			if (parameters.get("ldt_qrsj") != null) {
//				adt_qrsj = sdfdatetime.parse(parameters.get("ldt_qrsj") + "");
//			}
//			Date adt_tzsj = null;
//			if (parameters.get("ldt_tzsj") != null) {
//				adt_tzsj = sdfdatetime.parse(parameters.get("ldt_tzsj") + "");
//			}
//			Date adt_ylrq = null;
//			if (parameters.get("adt_ylrq") != null) {
//				adt_ylrq = (Date) parameters.get("adt_ylrq");
//			}
//			int adt_srcs = 0;
//			if (parameters.get("ll_srcs") != null) {
//				adt_srcs = Integer.parseInt(parameters.get("ll_srcs") + "");
//			}
//			String as_sypc = parameters.get("ls_sypc") + "";
//			String as_yzzxsj_str = parameters.get("ls_yzzxsj_str") + "";
//			int al_fybz = 0;
//			if (parameters.get("al_fybz") != null) {
//				al_fybz = Integer.parseInt(parameters.get("al_fybz") + "");
//			}
//			for (int i = 0; i < dicsypcList.size(); i++) {
//				List<String> ls_zxsjlist = new ArrayList<String>();
//				if (dicsypcList.get(i).get("PCBM").toString().equals(as_sypc)) {
//					if (as_yzzxsj_str == null || as_yzzxsj_str == "" || "0".equals(as_yzzxsj_str)) {
//						as_yzzxsj_str = dicsypcList.get(i).get("ZXSJ") + "";
//					}
//					// ???????????????????????????????????????????????????
//					parameters.put("as_yzzxsj_str", as_yzzxsj_str);
//					uf_get_zxsj_list(parameters, ls_zxsjlist);
//					// ??????????????????
//					int ll_mrcs = Integer.parseInt(dicsypcList.get(i).get("MRCS") + "");
//					// ?????????????????????????????????????????? = ????????????????????????????????? = ????????????
//					Date ldt_qssj = new Date();
//					if (adt_qrsj != null) {
//						ldt_qssj = adt_qrsj;
//					} else if (adt_kssj != null) {
//						ldt_qssj = adt_kssj;
//					}
//					// ????????????????????????
//					Date ldt_yljzsj = adt_ylrq; // ???????????????
//					// ?????????????????????????????????????????????????????????????????????????????????
//					Date ldt_zzsj = new Date();
//					if (adt_tzsj == null || ldt_yljzsj.getTime() < adt_tzsj.getTime()) {
//						ldt_zzsj = ldt_yljzsj;
//					} else {
//						ldt_zzsj = adt_tzsj;
//					}
//					// ????????????????????????????????? daysafter?????????????????????????????????
//					int ll_total_ts = getPeriod(sdfdate.parse(sdfdatetime.format(ldt_qssj)),
//							sdfdate.parse(sdfdatetime.format(ldt_zzsj))) + 1;
//					Date ldt_zxsj = new Date();
//					for (int ll_ts = 0; ll_ts < ll_total_ts; ll_ts++) {
//						// ??????????????????
//						Date ldt_current = getDateAfter(ldt_qssj, ll_ts);
//						// ?????????????????????,???????????????,????????????????????????
//						parameters.put("as_sypc", as_sypc);
//						parameters.put("adt_kssj", adt_kssj);
//						parameters.put("ldt_current", ldt_current);
//						int bol = uf_check_zx(dicsypcList, parameters);
//						if (bol <= 0) {
//							continue;
//						}
//						// ???????????????????????????????????????????????????
//						if (ll_ts == 0 && adt_qrsj == null) {
//							// for????????????
//							for (int ll_zxcs = (ll_mrcs - adt_srcs); ll_zxcs < ll_mrcs; ll_zxcs++) {
//								ldt_zxsj = sdfdatetime
//										.parse(sdfdate.format(ldt_current) + " " + ls_zxsjlist.get(ll_zxcs));
//								adt_qrsj_list.add(ldt_zxsj);
//								ll_count++;
//							}
//						} else {
//							// ?????????
//							// for????????????
//							for (int ll_zxcs = 0; ll_zxcs < ll_mrcs; ll_zxcs++) {
//								ldt_zxsj = sdfdatetime
//										.parse(sdfdate.format(ldt_current) + " " + ls_zxsjlist.get(ll_zxcs));
//								// ??????????????????????????????
//								if (al_fybz == 1 && ldt_zxsj.getTime() > ldt_qssj.getTime()
//										&& ldt_zxsj.getTime() < ldt_zzsj.getTime()) {
//									adt_qrsj_list.add(ldt_zxsj);
//									ll_count++;
//								}
//								// ??????????????????????????????
//								if (al_fybz == 2 && ldt_zxsj.getTime() > ldt_qssj.getTime()
//										&& ldt_zxsj.getTime() <= ldt_zzsj.getTime()) {
//									adt_qrsj_list.add(ldt_zxsj);
//									ll_count++;
//								}
//							}
//						}
//					}
//				}
//			}
//		} catch (ParseException e) {
//			throw BaseException.create("ERROR_DCTWORK_ZYBQYZ_00023");
//		}
//		return ll_count;
//	}
//
//	/**
//	 * @Title: uf_cacl_fycs_ls @Description: TODO * ?????????parameters???????????? datetime
//	 * adt_kssj ???????????????string as_sypc ???????????????as_yzzxsj_str????????????????????????ref datetime
//	 * adt_qrsj[]?????????????????? ?????????long ll_mrcs ???????????????????????? @param @param
//	 * dicsypcList @param @param parameters @param @param
//	 * adt_qrsj_list @param @return ???????????? @return int ???????????? @author ????????? @throws
//	 */
//	public static int uf_cacl_fycs_ls(List<Map<String, Object>> dicsypcList, Map<String, Object> parameters,
//			List<Date> adt_qrsj_list) {
//		SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
//		int ll_mrcs = 0;
//		try {
//			Date adt_kssj = null;
//			if (parameters.get("ldt_kssj") != null) {
//				adt_kssj = sdfdatetime.parse(parameters.get("ldt_kssj") + "");
//			}
//			String as_sypc = parameters.get("ls_sypc") + "";
//			String as_yzzxsj_str = parameters.get("ls_yzzxsj_str") + "";
//			for (int i = 0; i < dicsypcList.size(); i++) {
//				List<String> ls_zxsjlist = new ArrayList<String>();
//				if (dicsypcList.get(i).get("PCBM").toString().equals(as_sypc)) {
//					if (as_yzzxsj_str == null || as_yzzxsj_str == "" || "0".equals(as_yzzxsj_str)) {
//						as_yzzxsj_str = dicsypcList.get(i).get("ZXSJ") + "";
//					}
//					// ???????????????????????????????????????????????????
//					parameters.put("as_yzzxsj_str", as_yzzxsj_str);
//					uf_get_zxsj_list(parameters, ls_zxsjlist);
//					// ??????????????????
//					ll_mrcs = Integer.parseInt(dicsypcList.get(i).get("MRCS") + "");
//					// ?????????????????????????????????????????????????????????????????????????????????????????????????????????adt_qrsj???????????????
//					// for????????????
//					Date ldt_zxsj = new Date();
//					for (int ll_zxcs = 0; ll_zxcs < ll_mrcs; ll_zxcs++) {
//						ldt_zxsj = sdfdatetime.parse(sdfdate.format(adt_kssj) + " " + ls_zxsjlist.get(ll_zxcs));
//						adt_qrsj_list.add(ldt_zxsj);
//					}
//				}
//			}
//		} catch (ParseException e) {
//			throw BaseException.create("ERROR_DCTWORK_ZYBQYZ_00024");
//		}
//		return ll_mrcs;
//	}
//
//	/**
//	 * ?????????????????????????????? @Title: ArrearsPatientsQuery @Description:
//	 * TODO(?????????????????????????????????????????????) @param @param collardrugdetailslist @param @param
//	 * user @param @param bqTjMsgResp @param @return ???????????? @return boolean
//	 * ???????????? @author ????????? @throws
//	 */
//	public boolean ArrearsPatientsQuery(List<Map<String, Object>> collardrugdetailslist, SysUser user,
//			NisTjMsgResp nisTjMsgResp) {
//		Integer jgid = user.getHospitalId();
//		// ???????????? ?????????????????????0?????????1??????
//		SysXtcs sysXtcs = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, SysXtcsCsmcCts.ZYQFKZ);
//		String zyqfkz = sysXtcs == null ? "0" : sysXtcs.getCsz();
//		int ll_qfkz = Integer.parseInt(zyqfkz);
//		Map<String, Object> Ls_brxm = new HashMap<String, Object>(16);
//		long ll_zyh = 0;
//		String brxString = " ";
//		String zyhString = " ";
//		boolean flag = false;// ????????????????????????????????????????????????true ????????????false
//		for (int ll_row = 0; ll_row < collardrugdetailslist.size(); ll_row++) {
//			Map<String, Object> rowMap = collardrugdetailslist.get(ll_row);
//			Map<String, Object> body = new HashMap<String, Object>(16);
//			body.put("TYPE", rowMap.get("YPLX"));
//			body.put("BRXZ", rowMap.get("BRXZ"));
//			body.put("FYXH", rowMap.get("YPXH"));
//			if (rowMap.get("FYGB") != null) {
//				body.put("FYGB", rowMap.get("FYGB"));
//			} else {
//				body.put("FYGB", 0);
//			}
//			Map<String, Object> zfblMap = getzfbl(body);
//			double zfbl = Double.parseDouble(zfblMap.get("ZFBL") + "");
//			// ???????????? ??????????????????
//			boolean qfkzFlag = ll_qfkz > 0
//					&& (rowMap.get("BRXZ") != null && !"6089".equals(rowMap.get("BRXZ").toString()));
//			if (qfkzFlag) {
//				long ZYH = Long.parseLong(collardrugdetailslist.get(ll_row).get("ZYH") + "");
//				if ((ll_row == 0) || (ZYH != ll_zyh)) {
//					ll_zyh = ZYH;
//					double ld_hj = 0;
//					for (int ll_row1 = ll_row; ll_row1 < collardrugdetailslist.size(); ll_row1++) {
//						long ZYH1 = Long.parseLong(collardrugdetailslist.get(ll_row1).get("ZYH") + "");
//						double je = parseDouble(collardrugdetailslist.get(ll_row1).get("JE"));
//						if (ZYH1 == ll_zyh) {
//							ld_hj += je;
//						}
//					}
//					if (Wf_qfkz(ll_zyh, ld_hj * zfbl, jgid, Ls_brxm) == 1) {
//						for (int ll_row1 = ll_row; ll_row1 < collardrugdetailslist.size(); ll_row1++) {
//							long ZYH1 = Long.parseLong(collardrugdetailslist.get(ll_row1).get("ZYH") + "");
//							if (collardrugdetailslist.get(ll_row).get("ok") != null) {
//								String ok = collardrugdetailslist.get(ll_row).get("ok") + "";
//								if (ZYH1 == ll_zyh && ok.equals("1")) {
//									collardrugdetailslist.get(ll_row1).put("SFTJ", 1);
//								}
//							} else {
//								if (ZYH1 == ll_zyh) {
//									collardrugdetailslist.get(ll_row1).put("SFTJ", 1);
//								}
//							}
//						}
//					} else {
//						for (int ll_row1 = ll_row; ll_row1 < collardrugdetailslist.size(); ll_row1++) {
//							long ZYH1 = Long.parseLong(collardrugdetailslist.get(ll_row1).get("ZYH") + "");
//							if (collardrugdetailslist.get(ll_row).get("ok") != null) {
//								String ok = collardrugdetailslist.get(ll_row).get("ok") + "";
//								if (ZYH1 == ll_zyh && ok.equals("1")) {
//									collardrugdetailslist.get(ll_row1).put("SFTJ", 0);
//								}
//							} else {
//								if (ZYH1 == ll_zyh) {
//									collardrugdetailslist.get(ll_row1).put("SFTJ", 0);
//								}
//							}
//						}
//					}
//				}
//				if (Ls_brxm.get("Ls_brxm") != null) {
//					// int num = 0;
//					try {
//						for (int ll_row1 = ll_row + 1; ll_row1 < collardrugdetailslist.size(); ll_row1++) {
//							long ZYH1 = Long.parseLong(collardrugdetailslist.get(ll_row1).get("ZYH") + "");
//							if (ZYH1 == Long.parseLong(Ls_brxm.get("Ls_brxm") + "")) {
//								collardrugdetailslist.remove(ll_row1);
//								ll_row1--;
//							}
//
//						}
//						ImHzry imHzry = imHzryDao.getById(ObjectToTypes.parseInt(Ls_brxm.get("Ls_brxm")));
//						brxString += "'" + imHzry.getBrxm() + "'";
//						zyhString += "'" + Ls_brxm.get("Ls_brxm") + "'";
//						nisTjMsgResp.setResBrxmMsg(brxString);
//						nisTjMsgResp.setResZyhMsg(zyhString);
//						collardrugdetailslist.remove(ll_row);
//						ll_row--;
//						Ls_brxm.clear();
//						if (brxString.length() > 0) {
//							ReturnEntity<String> returnEntity = new ReturnEntity<>();
//							returnEntity.setError("ERROR_DCTWORK_ZYBQYZ_00037", new String[] { brxString });
//							nisTjMsgResp.setResErrorMsg(returnEntity.getMessage());
//							flag = true;
//						}
//					} catch (Exception e) {
//						logger.error(e.getMessage(), e);
//						throw BaseException.create("ERROR_DCTWORK_ZYBQYZ_00028");
//					}
//				}
//			}
//		}
//		return flag;
//	}
//
//	/**
//	 * @Title: Wf_qfkz @Description: TODO ?????????????????? @param @param al_zyh @param @param
//	 * ad_fsje @param @param JGID @param @param Ls_brxm @param @return ???????????? @return
//	 * long ???????????? @author ????????? @throws
//	 */
//	public long Wf_qfkz(long zyh, double ad_fsje, Integer jgid, Map<String, Object> Ls_brxm) {
//		try {
//			BigDecimal jkhj = imTbkkDao.queryTotalPayment(ObjectToTypes.parseInt(zyh), jgid);
//
//			Map<String, Object> map = imFeeFymxDao.querySumAndConceit(ObjectToTypes.parseInt(zyh), jgid);
//
//			double ld_jkhj = 0;
//			double ld_fyhj = 0;
//			double ld_zfhj = 0;
//			if (jkhj != null) {
//				ld_jkhj = jkhj.doubleValue();
//			}
//			if (map != null) {
//				if (map.get("ld_fyhj") != null) {
//					ld_fyhj = ObjectToTypes.parseDouble(map.get("ld_fyhj"));
//				}
//				if (map.get("ld_zfhj") != null) {
//					ld_zfhj = ObjectToTypes.parseDouble(map.get("ld_zfhj"));
//				}
//			}
//			double ld_qfje = ld_zfhj - ld_jkhj;
//			String Ls_brxm_s = "";
//			if ((ld_qfje >= 0) || (ld_qfje + ad_fsje > 0)) {
//				long ls_brxm_new = zyh;
//				if (Ls_brxm_s.equals("")) {
//					Ls_brxm_s = ls_brxm_new + "";
//				} else {
//					Ls_brxm_s += "," + ls_brxm_new;
//				}
//				Ls_brxm.put("Ls_brxm", Ls_brxm_s);
//				return 0;
//			}
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			throw BaseException.create("ERROR_DCTWORK_ZYBQYZ_00027");
//		}
//		return 1;
//	}
//
//	/**
//	 * ??????????????????
//	 *
//	 * @param oldBrxz
//	 * @param newBrxz
//	 */
//	public List<Map<String, Object>> changeBrxz(Integer oldBrxz, Integer newBrxz,
//			List<Map<String, Object>> listImFeeFymx) {
//		for (int i = 0; i < listImFeeFymx.size(); i++) {
//			Map<String, Object> imFeeFymx = listImFeeFymx.get(i);
//			Integer yplx = (Integer) imFeeFymx.get("yplx");
//			Integer fyxh = MapAttributeUtils.getInteger("fyxh", imFeeFymx);
//			Integer fygb = MapAttributeUtils.getInteger("fyxm", imFeeFymx);
//			double fydj = MapAttributeUtils.getDouble("fydj", imFeeFymx);
//			double fysl = MapAttributeUtils.getDouble("fysl", imFeeFymx);
//			Map<String, Object> je = imFeeFymxSer.getFyje(yplx, newBrxz, fyxh, fygb, fydj, fysl);
//			imFeeFymx.put("zfbl", je.get("zfbl"));
//			imFeeFymx.put("zfje", je.get("zfje"));
//			imFeeFymx.put("zlje", je.get("zlje"));
//			imFeeFymx.put("zjje", je.get("zjje"));
//			listImFeeFymx.set(i, imFeeFymx);
//		}
//		return listImFeeFymx;
//	}
//
//	/**
//	 * ??????????????????
//	 *
//	 * @param projectList
//	 * @param parameters
//	 * @param dao
//	 * @param ctx
//	 * @return
//	 * @throws ModelDataOperationException
//	 */
//	public Boolean uf_comp_yzzx(List<Map<String, Object>> dicsypcList, List<Map<String, Object>> projectList,
//			SysUser user) {
//		try {
//			SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
//			long ll_yzzh_old = 0;
//			int fysx = 0;
//			int ll_jfbz = 0;
//			Date currentDate = null;
//			/**
//			 * ??????????????????????????????????????????????????????????????????9???????????????????????????????????????????????????????????? 1?????????ll_yjxh?????? 2??????sqlString?????????,
//			 * min(YJXH) as LL_YJXH 3?????????ll_yjxh =
//			 * Long.parseLong(list_fysx.get(0).get("LL_YJXH") + "");?????? 4???????????????if (ll_jfbz ==
//			 * 1) { ?????????if (ll_jfbz == 1 || (ll_yjxh > 0 && ll_jfbz == 9)) {
//			 * 5???????????????LL_JFBZ??????????????????(?????????)
//			 **/
//			long ll_yjxh = 0;
//			for (int i = 0; i < projectList.size(); i++) {
//				Map<String, Object> parameters_lsbz = new HashMap<String, Object>();
//				Map<String, Object> parameters_up_lsbz = new HashMap<String, Object>();
//				Map<String, Object> parameters_cq = new HashMap<String, Object>(); // ??????uf_cacl_zxcs_cq
//																					// ????????????
//
//				String QRSJ = null;
//				if (projectList.get(i).get("QRSJ") != null && projectList.get(i).get("QRSJ") != "") {
//					QRSJ = projectList.get(i).get("QRSJ") + "";// ????????????
//				}
//				String TZSJ = null;
//				if (projectList.get(i).get("TZSJ") != null && projectList.get(i).get("TZSJ") != "") {
//					TZSJ = projectList.get(i).get("TZSJ") + "";// ???????????????
//				}
//				String KSSJ = null;
//				if (projectList.get(i).get("KSSJ") != null && projectList.get(i).get("KSSJ") != "") {
//					KSSJ = projectList.get(i).get("KSSJ") + "";// ????????????
//				}
//				String YZZXSJ = projectList.get(i).get("YZZXSJ") + "";// ??????????????????
//				String SYPC = projectList.get(i).get("SYPC") + "";// ????????????
//				long YZXH = Long.parseLong(projectList.get(i).get("JLXH") + "");// ????????????
//				int LSYZ = Integer.parseInt(projectList.get(i).get("LSYZ") + "");// ????????????//
//				// 1,????????????
//				// 0
//
//				int SRCS = 0;
//				if (projectList.get(i).get("SRCS") != null) {
//					SRCS = Integer.parseInt(projectList.get(i).get("SRCS") + "");// ????????????
//				}
//				// ??????????????????
//				int FJBZ = 0;
//				if (projectList.get(0).get("FJBZ") != null) {
//					// ????????????
//					FJBZ = Integer.parseInt(projectList.get(0).get("FJBZ") + "");
//				}
//				// ????????????
//				int ZXCS_TOTAL = 0;
//
//				parameters_lsbz.put("ldt_kssj", KSSJ);
//				parameters_lsbz.put("ldt_qrsj", QRSJ);
//				parameters_lsbz.put("ldt_tzsj", TZSJ);
//				parameters_lsbz.put("ls_sypc", SYPC);
//				parameters_lsbz.put("ls_yzzxsj_str", YZZXSJ);
//				parameters_lsbz.put("ll_lsyz", LSYZ);
//				parameters_lsbz.put("al_ypbz", 0);
//				parameters_lsbz.put("SRCS", SRCS);
//				// ??????????????????
//				int ll_lsbz = uf_cacl_lsbz(dicsypcList, parameters_lsbz);
//
//				if (ll_lsbz == 1) {// ????????????????????????????????????,????????????????????????
//					parameters_up_lsbz.put("ll_yzxh", YZXH);
//					uf_update_lsbz(parameters_up_lsbz, user); // ??????????????????
//					projectList.get(i).put("FYCS", 0);
//					continue;
//				}
//				// ?????????????????????????????????
//
//				if (FJBZ == 1) {
//					long ll_yzzh = Long.parseLong(projectList.get(i).get("YZZH") + "");
//					if (ll_yzzh_old != ll_yzzh) {
//						ll_yjxh = 0;
//						Map<String, Object> map_FY = new HashMap<String, Object>();
//						map_FY.put("YZZH", Long.parseLong(projectList.get(i).get("YZZH") + ""));
//						// ???????????????????????????????????????????????????????????????
//						List<Map<String, Object>> list_fysx = cisHzyzDao.queryFjBqyzInfo(map_FY);
//						fysx = Integer.parseInt(list_fysx.get(0).get("LL_FYSX") + "");
//						ll_yjxh = Long.parseLong(list_fysx.get(0).get("LL_YJXH") + "");
//						if (list_fysx.get(0).get("LL_JFBZ") != null) {
//							ll_jfbz = Integer.parseInt(list_fysx.get(0).get("LL_JFBZ") + "");
//						}
//						if (list_fysx.get(0).get("LDT_QRSJ") != null) {
//							currentDate = sdfdatetime.parse(list_fysx.get(0).get("LDT_QRSJ") + "");
//						} else {
//							currentDate = null;
//						}
//					}
//					ll_yzzh_old = Long.parseLong(projectList.get(i).get("YZZH") + "");
//					if (fysx == 2) {
//						projectList.get(i).put("FYCS", 0);
//						continue;
//					} else {
//						if (ll_jfbz == 1 || (ll_yjxh > 0 && ll_jfbz == 9)) {
//							if (currentDate != null) {
//								if (TZSJ != null && toDate(TZSJ).getTime() > currentDate.getTime()) {
//									TZSJ = sdfdatetime.format(currentDate);
//								}
//								parameters_lsbz.put("ldt_tzsj", TZSJ);
//							} else {
//								projectList.get(i).put("FYCS", 0);
//								continue;
//							}
//						}
//					}
//				}
//				// ????????????
//				if (LSYZ == 0) {
//					ZXCS_TOTAL = uf_cacl_zxcs_cq(dicsypcList, parameters_lsbz, parameters_cq);
//					double al_zxcs = 0;
//					if (parameters_cq.get("al_zxcs") != null) {
//						al_zxcs = Double.parseDouble(parameters_cq.get("al_zxcs") + "");
//					}
//					projectList.get(i).put("FYCS", al_zxcs);
//					if (ZXCS_TOTAL > 0) {
//						String currentTime = null;
//						if (parameters_cq.get("currentTime") != null) {
//							currentTime = sdfdatetime.format(parameters_cq.get("currentTime"));
//						}
//						// ??????????????????????????????
//						projectList.get(i).put("QRSJ", currentTime);
//						// ?????????????????????QRSJ?????? ???????????? ll_lsbz(????????????)
//						parameters_lsbz.put("ldt_qrsj", currentTime);
//						ll_lsbz = uf_cacl_lsbz(dicsypcList, parameters_lsbz);
//						if (ll_lsbz == 1) {
//							projectList.get(i).put("LSBZ", 1);
//						}
//					}
//				} else { // ????????????
//					// ???????????????????????????
//					int count_MRCS = 0;
//					for (int j = 0; j < dicsypcList.size(); j++) {
//						// ??????????????????,??????????????????,??????MRCS???1
//						if (SYPC == null || "null".equals(SYPC)) {
//							count_MRCS = 1;
//							break;
//						}
//						if (SYPC.equals(dicsypcList.get(j).get("PCBM"))) {
//							count_MRCS = Integer.parseInt(dicsypcList.get(j).get("MRCS") + "");
//						}
//					}
//					if (count_MRCS > 0) {
//						projectList.get(i).put("QRSJ", KSSJ);
//						projectList.get(i).put("LSBZ", 1);
//					}
//					projectList.get(i).put("FYCS", count_MRCS);
//				}
//			}
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			throw BaseException.create("ERROR_DCTWORK_ZYBQYZ_00021");
//		}
//		return true;
//	}
//
//	/**
//	 * ??????????????????????????????
//	 *
//	 * @param parameters
//	 * @param adt_qrsj_list
//	 * @param dao
//	 * @param ctx
//	 * @return
//	 * @throws ModelDataOperationException
//	 */
//
//	public static int uf_cacl_zxcs_cq(List<Map<String, Object>> dicsypcList, Map<String, Object> parameters,
//			Map<String, Object> parameters_cq) {
//		SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
//		int ll_count = 0;
//		try {
//			Date adt_kssj = null;
//			if (parameters.get("ldt_kssj") != null) {
//				adt_kssj = sdfdatetime.parse(parameters.get("ldt_kssj") + "");
//			}
//			Date adt_qrsj = null;
//			if (parameters.get("ldt_qrsj") != null) {
//				adt_qrsj = sdfdatetime.parse(parameters.get("ldt_qrsj") + "");
//			}
//			Date adt_tzsj = null;
//			if (parameters.get("ldt_tzsj") != null) {
//				adt_tzsj = sdfdatetime.parse(parameters.get("ldt_tzsj") + "");
//			}
//			int SRCS = 0; // ????????????
//			if (parameters.get("SRCS") != null) {
//				SRCS = Integer.parseInt(parameters.get("SRCS") + "");
//			}
//
//			String as_sypc = parameters.get("ls_sypc") + "";
//			String as_yzzxsj_str = parameters.get("ls_yzzxsj_str") + "";
//
//			for (int i = 0; i < dicsypcList.size(); i++) {
//				List<String> ls_zxsjlist = new ArrayList<String>();
//				int mrcs = Integer.parseInt(dicsypcList.get(i).get("MRCS") + "");
//
//				if (dicsypcList.get(i).get("PCBM").toString().equals(as_sypc)) {
//					if (as_yzzxsj_str == null || as_yzzxsj_str == "" || "0".equals(as_yzzxsj_str)) {
//						as_yzzxsj_str = dicsypcList.get(i).get("ZXSJ") + "";
//					}
//					// ???????????????????????????????????????????????????
//					parameters.put("as_yzzxsj_str", as_yzzxsj_str);
//					uf_get_zxsj_list(parameters, ls_zxsjlist);
//
//					// ?????????????????????????????????????????? = ????????????????????????????????? = ????????????
//					Date ldt_qssj = new Date();
//					if (adt_qrsj != null) {
//						ldt_qssj = adt_qrsj;
//					} else if (adt_kssj != null) {
//						ldt_qssj = adt_kssj;
//					}
//					// ???????????????????????????
//					Date ldt_yljzsj = sdfdatetime.parse((sdfdate.format(getDateAfter(new Date(), 1)) + " 00:00:00"));
//					// ????????????????????????????????????????????????????????????????????????
//					Date ldt_zzsj = new Date();
//					if (adt_tzsj == null || ldt_yljzsj.getTime() < adt_tzsj.getTime()) {
//						ldt_zzsj = ldt_yljzsj;
//					} else {
//						ldt_zzsj = adt_tzsj;
//					}
//					// ????????????????????????????????? daysafter?????????????????????????????????
//					int ll_total_ts = getPeriod(sdfdate.parse(sdfdatetime.format(ldt_qssj)),
//							sdfdate.parse(sdfdatetime.format(ldt_zzsj))) + 1;
//
//					// ??????????????????????????????
//					int ll_zxcs_day = 0;
//					Date ldt_zxsj = new Date();
//					Date zxsj = new Date();
//
//					// ??????????????????????????????
//					for (int ll_ts = 0; ll_ts < ll_total_ts; ll_ts++) {
//						// ??????????????????
//						Date ldt_current = getDateAfter(ldt_qssj, ll_ts);
//						// ?????????????????????,???????????????,????????????????????????
//						parameters.put("as_sypc", as_sypc);
//						parameters.put("adt_kssj", adt_kssj);
//						parameters.put("ldt_current", ldt_current);
//						int bol = uf_check_zx(dicsypcList, parameters);
//						if (bol <= 0) {
//							continue;
//						}
//						// ???????????????????????????
//						if (ll_ts == 0 && adt_qrsj == null && SRCS != 0) {
//							for (int j = mrcs - SRCS; j < mrcs; j++) {
//								ll_zxcs_day++;
//								ldt_zxsj = sdfdatetime
//										.parse(sdfdate.format(ldt_current) + " " + ls_zxsjlist.get(j) + ":00");
//								Date current = getDateAfter(ldt_zxsj, 1);
//								zxsj = sdfdatetime.parse(sdfdate.format(current) + " " + "00:00:00");
//							}
//						} else {
//							for (int j = 0; j < mrcs; j++) {
//								ls_zxsjlist.get(j);
//								ldt_zxsj = sdfdatetime
//										.parse(sdfdate.format(ldt_current) + " " + ls_zxsjlist.get(j) + ":00");
//								if (ldt_zxsj.getTime() > ldt_qssj.getTime()) {
//									if (ldt_zxsj.getTime() <= ldt_zzsj.getTime()) {
//										ll_zxcs_day++;
//										// zxsj = ldt_zxsj;
//										Date current = getDateAfter(ldt_zxsj, 1);
//										zxsj = sdfdatetime.parse(sdfdate.format(current) + " " + "00:00:00");
//									}
//								}
//							}
//						}
//						if (ll_zxcs_day > 0) {
//							ll_count++;
//							parameters_cq.put("al_zxcs", ll_zxcs_day);
//							parameters_cq.put("currentTime", zxsj);// ?????????????????????????????????????????????
//						}
//					}
//				}
//			}
//		} catch (ParseException e) {
//			logger.error(e.getMessage(), e);
//			throw BaseException.create("ERROR_DCTWORK_ZYBQYZ_00036");
//		}
//		return ll_count;
//	}
//
//	/**
//	 * @throws ParseException ???????????????????????? @Title: uf_insert_fymx @Description:
//	 * TODO(?????????????????????????????????????????????) @param @param list_FYMX @param @param
//	 * listForputFYMX @param @param user @param @return ???????????? @return boolean
//	 * ???????????? @author ????????? @throws
//	 */
//	public Boolean uf_insert_fymx(List<Map<String, Object>> list_FYMX, List<Map<String, Object>> listForputFYMX,
//			SysUser user, Integer brbq) throws ParseException {
//		Integer JGID = user.getHospitalId();
//		Integer bq = 0;
//		if (brbq != null) {
//			// ????????????
//			bq = brbq;
//		} else {
//			if (list_FYMX != null && list_FYMX.size() > 0) {
//				bq = ObjectToTypes.parseInt(list_FYMX.get(0).get("FYBQ"));
//			}
//		}
//		// ?????????????????????
//		Integer yggh = user.getUserId();
//		for (int i = 0; i < list_FYMX.size(); i++) {
//			long ZXKS = 0;
//			double ZFBL = 0;
//			double ZFJE = 0;
//			double ZLJE = 0;
//			double DZBL = 0;
//			double ZJJE = 0;
//			if (list_FYMX.get(i).get("ZFBL") != null) {
//				ZFBL = Double.parseDouble(list_FYMX.get(i).get("ZFBL") + "");
//			}
//			if (list_FYMX.get(i).get("ZFJE") != null) {
//				ZFJE = Double.parseDouble(list_FYMX.get(i).get("ZFJE") + "");
//			}
//			if (list_FYMX.get(i).get("ZLJE") != null) {
//				ZLJE = Double.parseDouble(list_FYMX.get(i).get("ZLJE") + "");
//			}
//			if (list_FYMX.get(i).get("DZBL") != null) {
//				DZBL = Double.parseDouble(list_FYMX.get(i).get("DZBL") + "");
//			}
//			if (list_FYMX.get(i).get("ZJJE") != null) {
//				ZJJE = Double.parseDouble(list_FYMX.get(i).get("ZJJE") + "");
//			}
//			long ZYH = Long.parseLong(list_FYMX.get(i).get("ZYH") + "");
//			long FYKS = Long.parseLong(list_FYMX.get(i).get("FYKS") + "");
//			Integer YPLX = ObjectToTypes.parseInt(list_FYMX.get(i).get("YPLX"));
//			Integer BRXZ = ObjectToTypes.parseInt(list_FYMX.get(i).get("BRXZ"));
//			double FYDJ = Double.parseDouble(list_FYMX.get(i).get("FYDJ") + "");
//			double FYSL = Double.parseDouble(list_FYMX.get(i).get("FYSL") + "");
//			double YCSL = Double.parseDouble(list_FYMX.get(i).get("YCSL") + "");
//			String YSGH = list_FYMX.get(i).get("YSGH") + "";
//			long YPCD = Long.parseLong(list_FYMX.get(i).get("YPCD") + "");
//			// ????????????????????? ?????????????????????
//			if (list_FYMX.get(i).get("ZXKS") == null || list_FYMX.get(i).get("ZXKS") == ""
//					|| "null".equals(list_FYMX.get(i).get("ZXKS"))) {
//				ZXKS = FYKS;
//			} else {
//				ZXKS = Long.parseLong(list_FYMX.get(i).get("ZXKS") + "");
//			}
//			// ??????????????????????????????
//			Map<String, Object> parameters = new HashMap<String, Object>(16);
//			parameters.put("ZYH", ZYH);
//			parameters.put("JGID", JGID);
//			// ???????????????????????????????????????Map
//			Map<String, Object> imfeefymx_map = (Map<String, Object>) list_FYMX.get(i);
//			// ???????????? YPLX_c ?????????????????????
//			Integer YPLX_c = ObjectToTypes.parseInt(list_FYMX.get(i).get("YPLX"));
//			Integer FYXH = ObjectToTypes.parseInt(list_FYMX.get(i).get("FYXH"));
//			Integer FYXM = getfygb(YPLX_c, FYXH);
//			imfeefymx_map.put("FYXM", FYXM);
//			// YPLX ???0????????????
//			if (YPLX == 0) {
//				if (FYSL < 0) {
//					imfeefymx_map.put("ZFBL", ZFBL);
//					imfeefymx_map.put("ZJJE", ZJJE);
//					imfeefymx_map.put("ZFJE", ZFJE);
//					imfeefymx_map.put("ZLJE", ZLJE);
//				} else {
//					if (ZFJE > 0) {
//						imfeefymx_map.put("ZFBL", ZFBL);
//						imfeefymx_map.put("ZJJE", ZJJE);
//						imfeefymx_map.put("ZFJE", ZFJE);
//						imfeefymx_map.put("ZLJE", ZLJE);
//					} else {
//						Map<String, Object> FYXX = getje(YPLX, BRXZ, FYXH, FYXM, FYDJ, FYSL);
//						imfeefymx_map.put("ZFBL", FYXX.get("ZFBL"));
//						imfeefymx_map.put("ZJJE", FYXX.get("ZJJE"));
//						imfeefymx_map.put("ZFJE", FYXX.get("ZFJE"));
//						imfeefymx_map.put("ZLJE", FYXX.get("ZLJE"));
//					}
//				}
//			} else {
//				// ??????????????????
//				if (FYSL < 0) {
//					imfeefymx_map.put("ZFBL", ZFBL);
//					imfeefymx_map.put("ZJJE", ZJJE);
//					imfeefymx_map.put("ZFJE", ZFJE);
//					imfeefymx_map.put("ZLJE", ZLJE);
//				} else {
//					if (ZFJE > 0) {
//						imfeefymx_map.put("ZFBL", ZFBL);
//						imfeefymx_map.put("ZJJE", ZJJE);
//						imfeefymx_map.put("ZFJE", ZFJE);
//						imfeefymx_map.put("ZLJE", ZLJE);
//						imfeefymx_map.put("FYXM", FYXM);
//					} else {
//						Map<String, Object> FYXX = getje(YPLX, BRXZ, FYXH, FYXM, FYDJ, FYSL);
//						imfeefymx_map.put("ZFBL", FYXX.get("ZFBL"));
//						imfeefymx_map.put("ZJJE", FYXX.get("ZJJE"));
//						imfeefymx_map.put("ZFJE", FYXX.get("ZFJE"));
//						imfeefymx_map.put("ZLJE", FYXX.get("ZLJE"));
//						imfeefymx_map.put("FYXM", FYXX.get("FYGB"));
//					}
//				}
//			}
//			// ??????????????????????????????
//			if (list_FYMX.get(i).get("FYRQ") == null || list_FYMX.get(i).get("FYRQ") == "") {
//				imfeefymx_map.put("FYRQ", DateUtil.date().toTimestamp());
//			} else {
//				String FYRQ = list_FYMX.get(i).get("FYRQ") + "";
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//				Date date = list_FYMX.get(i).get("FYRQ") instanceof Date ? (Date) list_FYMX.get(i).get("FYRQ")
//						: sdf.parse(FYRQ);
//				imfeefymx_map.put("FYRQ", DateUtil.date(date).toTimestamp());
//			}
//			// ??????????????????????????????
//			if (list_FYMX.get(i).get("JFRQ") == null || list_FYMX.get(i).get("JFRQ") == "") {
//				imfeefymx_map.put("JFRQ", DateUtil.date().toTimestamp());
//			} else {
//				String JFRQ = list_FYMX.get(i).get("JFRQ") + "";
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//				Date date = list_FYMX.get(i).get("JFRQ") instanceof Date ? (Date) list_FYMX.get(i).get("JFRQ")
//						: sdf.parse(JFRQ);
//				imfeefymx_map.put("JFRQ", DateUtil.date(date).toTimestamp());
//			}
//			// ??????????????????
//			if (YPLX == 0) {
//				imfeefymx_map.put("YPCD", 0);
//			} else {
//				imfeefymx_map.put("YPCD", YPCD);
//			}
//			if (list_FYMX.get(i).get("JLXH") != null) {
//				// ????????????
//				imfeefymx_map.put("YZXH", Long.parseLong(list_FYMX.get(i).get("JLXH") + ""));
//			}
//			imfeefymx_map.put("ZYH", ZYH);// ?????????
//			imfeefymx_map.put("FYXH", FYXH);// ????????????
//			imfeefymx_map.put("FYMC", list_FYMX.get(i).get("FYMC"));// ????????????
//			imfeefymx_map.put("FYSL", FYSL);// ????????????
//			imfeefymx_map.put("FYDJ", FYDJ);// ????????????
//			imfeefymx_map.put("QRGH", yggh);// ?????????????????????
//			imfeefymx_map.put("FYKS", FYKS);// ???????????? long
//			imfeefymx_map.put("ZXKS", ZXKS);// ???????????? long
//			imfeefymx_map.put("XMLX", 1);// ????????????// int
//			imfeefymx_map.put("YPLX", YPLX);// ????????????
//			imfeefymx_map.put("YSGH", YSGH);// ????????????
//			imfeefymx_map.put("FYBQ", bq);// ???????????? long
//			imfeefymx_map.put("DZBL", DZBL);
//			imfeefymx_map.put("JSCS", 0);
//			imfeefymx_map.put("YEPB", 0);
//			imfeefymx_map.put("JGID", JGID);
//			imfeefymx_map.put("XMSL", YCSL);
//			imfeefymx_map.put("JFRQ", DateUtil.date().toTimestamp());
//			listForputFYMX.add(i, imfeefymx_map);
//		}
//		return true;
//	}
//
//	/**
//	 * ???????????? @Title: getje @Description: TODO(?????????????????????????????????????????????) @param @param
//	 * al_yplx @param @param al_brxz @param @param al_fyxh @param @param
//	 * al_fygb @param @param ad_fydj @param @param ad_fysl @param @return
//	 * ???????????? @return Map<String,Object> ???????????? @author ????????? @throws
//	 */
//	public Map<String, Object> getje(Integer al_yplx, Integer al_brxz, Integer al_fyxh, Integer al_fygb, double ad_fydj,
//			double ad_fysl) {
//		double ld_zfbl = 1;
//		boolean adc_zfbl = false;
//		double ld_cxbl = 1;
//		double ld_zfje = 0;
//		double ld_zlje = 0;
//		double ld_fyxe = 0;
//		Map<String, Object> parameters = new HashMap<String, Object>(16);
//		parameters.put("BRXZ", al_brxz);
//		try {
//			if (al_yplx == 0) {
//				PubFyxz pubFyxz = new PubFyxz();
//				pubFyxz.setBrxz(al_brxz);
//				pubFyxz.setFyxh(al_fyxh);
//				// ????????????????????????
//				Map<String, Object> pubfyxzMap = pubFyxzDao.getFyjyInfo(pubFyxz);
//				if (pubfyxzMap != null) {
//					if (pubfyxzMap.get("FYXE") != null) {
//						ld_fyxe = Double.parseDouble(pubfyxzMap.get("FYXE") + "");
//					}
//					if (pubfyxzMap.get("CXBL") != null) {
//						ld_cxbl = Double.parseDouble(pubfyxzMap.get("CXBL") + "");
//					}
//					if (pubfyxzMap.get("ZFBL") != null) {
//						ld_zfbl = Double.parseDouble(pubfyxzMap.get("ZFBL") + "");
//						adc_zfbl = true;
//					}
//				}
//				if (ld_fyxe > 0 && ad_fydj > ld_fyxe) {
//					ld_zfje = ad_fysl * ld_fyxe * ld_zfbl;
//					ld_zlje = ad_fysl * (ad_fydj - ld_fyxe) * ld_cxbl;
//					ld_zfje = ld_zfje + ld_zlje;
//				} else {
//					ld_zfje = ad_fysl * ad_fydj * ld_zfbl;
//					ld_zlje = 0;
//				}
//			} else if (al_yplx == 1 || al_yplx == 2 || al_yplx == 3) {
//				FeeYpxz feeYpxz = new FeeYpxz();
//				feeYpxz.setBrxz(al_brxz);
//				feeYpxz.setYpxh(al_fyxh);
//				// ????????????????????????
//				Map<String, Object> feeypxzMap = feeYpxzDao.getYpjyInfo(feeYpxz);
//				if (feeypxzMap != null) {
//					if (feeypxzMap.get("ZFBL") != null) {
//						ld_zfbl = Double.parseDouble(feeypxzMap.get("ZFBL") + "");
//						adc_zfbl = true;
//					}
//				}
//				ld_zfje = ad_fysl * ad_fydj * ld_zfbl;
//				ld_zlje = 0;
//			}
//			if (!adc_zfbl) {
//				al_fygb = getfygb(al_yplx, al_fyxh);
//				parameters.put("SFXM", al_fygb);
//
//				List<Map<String, Object>> feesfdlzfblList = feeSfdlzfblDao.getZfblMap(parameters);
//				if (CollectionUtils.isNotEmpty(feesfdlzfblList)) {
//					Map<String, Object> feesfdlzfblMap = feesfdlzfblList.get(0);
//					if (feesfdlzfblMap.get("ZFBL") != null) {
//						ld_zfbl = Double.parseDouble(feesfdlzfblMap.get("ZFBL") + "");
//					}
//				}
//				ld_zfje = ad_fysl * ad_fydj * ld_zfbl;
//				ld_zlje = 0;
//			}
//			double ld_zjje = ad_fydj * ad_fysl;
//			Map<String, Object> getjeMap = new HashMap<String, Object>(16);
//			getjeMap.put("ZFBL", ld_zfbl);
//			getjeMap.put("ZFJE", ld_zfje);
//			getjeMap.put("ZLJE", ld_zlje);
//			getjeMap.put("ZJJE", ld_zjje);
//			getjeMap.put("FYGB", al_fygb);
//			return getjeMap;
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			throw BaseException.create("ERROR_NURSEWORK_ZYBRRY_00010");
//		}
//	}
//
//	/**
//	 * ???????????????????????? @Title: isContainChinese @Description:
//	 * TODO(?????????????????????????????????????????????) @param @param str @param @return ???????????? @return boolean
//	 * ???????????? @author ????????? @throws
//	 */
//	public static boolean isContainChinese(String str) {
//		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
//		Matcher m = p.matcher(str);
//		if (m.find()) {
//			return true;
//		}
//		return false;
//	}
//
//	/**
//	 * ??????????????????
//	 *
//	 * @param adt_hzrq
//	 * @param idt_LastDate
//	 * @param user
//	 * @return
//	 */
//	public int wf_IsGather(Date adt_hzrq, Map<String, Object> idt_LastDate, SysUser user) {
//		SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
//		// ???????????????ID
//		Integer gl_jgid = user.getHospitalId();
//		Map<String, Object> parameters = new HashMap<String, Object>();
//		Map<String, Object> parametershzrq = new HashMap<String, Object>();
//		try {
//			Date ldt_Begin = sdfdate.parse(sdfdate.format(adt_hzrq));
//			Date ldt_End = sdfdate.parse(sdfdate.format(getDateAfter(adt_hzrq, 1)));
//			parameters.put("ldt_Begin", ldt_Begin);
//			parameters.put("ldt_End", ldt_End);
//			parameters.put("gl_jgid", gl_jgid);
//			parametershzrq.put("gl_jgid", gl_jgid);
//
//			Integer l = imJzhzDao.queryHzCount(parameters);
//
//			Map<String, Object> hzrqmap = imJzhzDao.queryMaxHzrq(parameters);
//			if (hzrqmap!=null&&hzrqmap.get("HZRQ") != null) {
//				idt_LastDate.put("idt_LastDate", sdfdatetime.parse(hzrqmap.get("HZRQ") + ""));
//			}
//			if (l > 0) {
//				return 1;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}
//
	/**
	 * ??????????????????
	 *
	 * @param amount
	 * @return
	 */
	public static String changeMoneyUpper(Object amount) {
		if (amount == null || amount.toString().length() == 0)
			return null;
		String sNumber = amount.toString();
		String[] oneUnit = { "???", "???", "???", "???", "???", "???", "???", "???", "???", "???", "???", "???", "???", "???", "???", "???" };
		String[] twoUnit = { "???", "???" };
		String[] sChinese = { "???", "???", "???", "???", "???", "???", "???", "???", "???", "???" };
		String sign = ""; // ????????? add by Zhangxw
		if (sNumber.startsWith("-")) {
			sNumber = sNumber.substring(1);
			sign = "???";
		}
		int pointPos = sNumber.indexOf("."); // ??????????????????
		String sInteger;// ??????????????????
		String sDecimal;// ??????????????????
		String value = "";// ??????????????????
		if (pointPos != -1) {
			// ????????????????????????????????????substring()?????????
			sInteger = sNumber.substring(0, pointPos); // ???????????????????????????
			sDecimal = sNumber.substring(pointPos + 1,
					pointPos + 3 < sNumber.length() ? pointPos + 3 : sNumber.length());
		} else { // ???????????????????????????
			sInteger = sNumber;
			sDecimal = "";
		} // ????????????????????????????????????????????????
		for (int i = 0; i < sInteger.length(); i++) {
			int temp = Integer.parseInt(sInteger.substring(i, i + 1));
			value += sChinese[temp] + oneUnit[sInteger.length() - i - 1];
		} // ????????????????????????????????????????????????
		for (int i = 0; i < sDecimal.length(); i++) {
			int temp = Integer.parseInt(sDecimal.substring(i, i + 1));
			// value += sChinese[temp] + twoUnit[sDecimal.length() - i - 1];
			value += sChinese[temp] + twoUnit[2 - i - 1];
		}
		return sign + value;
	}

//
//	/**
//	 * ??????2?????????????????????????????? @Title: getWeeksForTem @Description:
//	 * TODO(?????????????????????????????????????????????) @param @param begin @param @param datum @param @return
//	 * ???????????? @return int ???????????? @author ????????? @throws
//	 */
//	public static int getWeeksForTem(Date begin, Date datum) {
//		Calendar beginDate = Calendar.getInstance();
//		beginDate.setTime(begin);
//		Calendar now = Calendar.getInstance();
//		if (datum != null) {
//			now.setTime(datum);
//		}
//		if (dateCompare(beginDate.getTime(), now.getTime()) > 0) {
//			return -1;
//		}
//		int days = getPeriod(begin, datum) + 1;
//
//		return (int) (Math.ceil(days / 7f));
//	}
//
	/**
	 * ??????32???UUID
	 *
	 * @return
	 */
	public static String UUIDGenerator() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	// ???bigDecimal????????????????????????
	public static double add(Object x, Object y) {
		if (x == null) {
			x = 0;
		}
		if (y == null) {
			y = 0;
		}
		double ret = new BigDecimal(x.toString()).add(new BigDecimal(y.toString())).doubleValue();
		return parseDouble(ret);
	}

	/**
	 * @name: dictionaryConversion
	 * @description: ???????????????
	 * @param code  ????????????:??????LS0000000821
	 * @param value ????????????
	 * @return: java.lang.String ????????????
	 * @date: 2020/8/26 20:09
	 * @auther: ?????????
	 *
	 */
	public String dictionaryConversion(String code, String value) {
		if (StringUtils.isBlank(code) || StringUtils.isBlank(value)) {
			return null;
		}
		List<Map<String, String>> ret = dicGbsj02Dao.getValueByPrimaryDataCode(code);
		for (Map<String, String> m : ret) {
			if (value.equals(m.get("DATA_VALUE"))) {
				return m.get("DATA_VALUE_REMARK");
			}
		}
		return null;
	}

	public static double doubletwo(double dou) {
		double re = new java.math.BigDecimal(Double.toString(dou)).setScale(2, java.math.BigDecimal.ROUND_HALF_UP)
				.doubleValue();
		return re;
	}

//
//	/**
//	 * @name: listToString
//	 * @description: list?????????string
//	 * @return: java.lang.String
//	 * @date: 2020/8/28 9:41
//	 * @auther: ?????????
//	 *
//	 */
//	public static String listToString(List list){
//		if(list == null) return "";
//
//		StringBuilder b = new StringBuilder();
//		int iMax = list.size() - 1;
//		for (int i = 0; i<list.size(); i++) {
//			b.append(list.get(i));
//			if(i == iMax){
//				break;
//			}
//			b.append(", ");
//		}
//		return b.toString();
//	}
//
	public static String getDateTime() {
		Date date = new Date();
		SimpleDateFormat matter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return matter.format(date);
	}
//
//	public static <T> LinkedList<Map<String, Object>> LinkedListObjToMap(LinkedList<T> objList) {
//		LinkedList<Map<String, Object>> resultList = new LinkedList<>();
//		for (T obj : objList) {
//			Map<String, Object> map = BeanUtil.beanToMap(obj);
//		//	Map<String, Object> result = new CaseInsensitiveMap<String, Object>(map);
//			resultList.add(map);
//		}
//		return resultList;
//	}

	public String getSddmByTime(DateTime currenTime) {
		String zblb = null;
		// ??????????????????
		List<OpBcsj> bcsjList = opBcsjService.getBcsjInfo(new OpBcsj());
		for (OpBcsj opBcsj : bcsjList) {
			String sbsjStr = DateUtil.today() + " " + opBcsj.getSbsj() + ":00";
			String xbsjStr = DateUtil.today() + " " + opBcsj.getXbsj() + ":00";
			String nextXbsjStr = DateUtil.format(DateUtil.tomorrow(), "yyyy-MM-dd") + " " + opBcsj.getXbsj() + ":00";
			DateTime sbsjDate = DateUtil.parse(sbsjStr);
			DateTime xbsjDate = DateUtil.parse(xbsjStr);
			if (sbsjDate.after(xbsjDate)) {
				xbsjDate = DateUtil.parse(nextXbsjStr);
			}
			if (currenTime.after(sbsjDate) && currenTime.before(xbsjDate)) {
				zblb = opBcsj.getSddm();
				return zblb;
			}
		}
		return zblb;
	}

	/**
	 * ??????????????????????????????
	 */
	public List<String> getAllSddmByTime(DateTime currenTime) {
		List<String> zblb = new ArrayList<>();
		// ??????????????????
		List<OpBcsj> bcsjList = opBcsjService.getBcsjInfo(new OpBcsj());
		for (OpBcsj opBcsj : bcsjList) {
			String sbsjStr = DateUtil.today() + " " + opBcsj.getSbsj() + ":00";
			String xbsjStr = DateUtil.today() + " " + opBcsj.getXbsj() + ":00";
			String nextXbsjStr = DateUtil.format(DateUtil.tomorrow(), "yyyy-MM-dd") + " " + opBcsj.getXbsj() + ":00";
			DateTime sbsjDate = DateUtil.parse(sbsjStr);
			DateTime xbsjDate = DateUtil.parse(xbsjStr);
			if (sbsjDate.after(xbsjDate)) {
				xbsjDate = DateUtil.parse(nextXbsjStr);
			}
			if (currenTime.after(sbsjDate) && currenTime.before(xbsjDate)) {
				zblb.add(opBcsj.getSddm());
			}
		}
		return zblb;
	}

	/**
	 * ?????????????????????????????????????????????????????????????????????????????????
	 */
	public List<String> getAllSddmByTime(String zblb) {
		List<String> zblbs = new ArrayList<>();
		zblbs.add(zblb);

		OpBcsj bySddm = opBcsjService.getBySddm(zblb);
		DateTime bySddmBegin = DateUtil.parse(DateUtil.today() + " " + bySddm.getSbsj() + ":00");
		DateTime bySddmEnd = DateUtil.parse(DateUtil.today() + " " + bySddm.getSbsj() + ":00");
		DateTime bySddmEndNext = DateUtil.parse(DateUtil.format(DateUtil.tomorrow(), "yyyy-MM-dd") + " " + bySddm.getXbsj() + ":00");
		if (bySddmBegin.after(bySddmEnd)) {
			bySddmEnd = bySddmEndNext;
		}

		// ??????????????????
		List<OpBcsj> bcsjList = opBcsjService.getBcsjInfo(new OpBcsj());
		for (OpBcsj opBcsj : bcsjList) {
			if(zblb.equals(opBcsj.getSddm())){
				continue;
			}

			String sbsjStr = DateUtil.today() + " " + opBcsj.getSbsj() + ":00";
			String xbsjStr = DateUtil.today() + " " + opBcsj.getXbsj() + ":00";
			String nextXbsjStr = DateUtil.format(DateUtil.tomorrow(), "yyyy-MM-dd") + " " + opBcsj.getXbsj() + ":00";

			DateTime sbsjDate = DateUtil.parse(sbsjStr);
			DateTime xbsjDate = DateUtil.parse(xbsjStr);

			if (sbsjDate.after(xbsjDate)) {
				xbsjDate = DateUtil.parse(nextXbsjStr);
			}

			if (bySddmBegin.isAfterOrEquals(sbsjDate) && bySddmEnd.isBeforeOrEquals(xbsjDate)) {
				zblbs.add(opBcsj.getSddm());
			}
		}
		return zblbs;
	}
}
