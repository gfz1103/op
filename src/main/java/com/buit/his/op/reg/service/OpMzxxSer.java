package com.buit.his.op.reg.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import com.buit.aop.lock.Locked;
import com.buit.commons.dao.*;
import com.buit.commons.model.*;
import com.buit.commons.request.*;
import com.buit.constans.CommonConstans;
import com.buit.his.op.reg.enums.FkfsEnum;
import com.buit.his.op.reg.enums.OpPjlxEnum;
import com.buit.his.request.LisRequestCancelReq;
import com.buit.his.request.LisRequestUpdateReq;
import com.buit.his.request.RequestUpdateDetail;
import com.buit.his.request.RequestUpdateInfo;
import com.buit.his.response.LisResp;
import com.buit.his.service.MdiLisService;
import com.buit.his.shyb.source.entity.DiagnosisInfo;
import com.buit.his.treatment.service.TreatmentApplyFormService;
import com.buit.op.model.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buit.apply.model.CisJcsq01Model;
import com.buit.apply.response.OpZt02Resp;
import com.buit.apply.service.Cisjcsqd01Service;
import com.buit.apply.service.OpZt02Service;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.commons.enums.TradingChannelEnum;
//import com.buit.commons.model.YbMzjs;
import com.buit.commons.response.AxktcResp;
import com.buit.commons.response.CfInfoResp;
import com.buit.commons.response.FindKsdmByYsdmResp;
import com.buit.commons.response.FpzfBrdaResp;
import com.buit.commons.response.GetYfkInfoResp;
import com.buit.commons.response.JsCheckInventoryResp;
import com.buit.commons.response.JsxxResp;
import com.buit.commons.response.LoadMedcineSetResp;
import com.buit.commons.response.LoadProjectSetResp;
import com.buit.commons.response.MsCfInfoResp;
import com.buit.commons.response.MsQueryDjResp;
import com.buit.commons.response.MzfpBaseResp;
import com.buit.commons.response.MzfpSfxmResp;
import com.buit.commons.response.MzfpYpResp;
import com.buit.commons.response.OpGhmxInfoResp;
import com.buit.commons.response.PrintMzxxResp;
import com.buit.commons.response.QueryDjDetailResp;
import com.buit.commons.response.QueryFphmResp;
import com.buit.commons.response.QueryGhmxResp;
import com.buit.commons.response.QueryPaymentResp;
import com.buit.commons.response.QueryTf01Resp;
import com.buit.commons.response.QueryTfFkxxResp;
import com.buit.commons.response.QueryTfFphmResp;
import com.buit.commons.response.QueryTfJeResp;
import com.buit.commons.response.QueryTfMzxxResp;
import com.buit.commons.response.QueryTfPaymentResp;
import com.buit.commons.response.QueryVoidInvoiceResp;
import com.buit.commons.response.SaveRefundSettleResp;
import com.buit.commons.response.SelectfujmbrResp;
import com.buit.commons.response.TfJeResp;
import com.buit.commons.response.ZfQueryFphmResp;
import com.buit.commons.response.ZzghksResp;
import com.buit.constans.TableName;
import com.buit.drug.request.PharBaseInfoReq;
import com.buit.drug.request.PharKcdjReq;
import com.buit.drug.request.QueryYfypReq;
import com.buit.drug.request.UpdatePdcfReq;
import com.buit.drug.response.DrugsTypkDetailResp;
import com.buit.drug.response.PharYpxxResp;
import com.buit.drug.service.DrugLogService;
import com.buit.drug.service.DrugService;
import com.buit.drug.service.DrugsTypkOutSer;
import com.buit.drug.service.PharBaseConfigService;
import com.buit.his.shyb.source.entity.SettleResultDTO;
import com.buit.his.shyb.source.service.impl.MedicalInsuranceService;
import com.buit.his.shyb.source.service.impl.OfflineSettleService;
import com.buit.his.shyb.source.service.impl.ShybMzdbDbksService;
import com.buit.his.shyb.source.service.impl.ShybSh01Service;
import com.buit.his.shyb.source.service.impl.UnifiedBusinessService;
import com.buit.op.response.MpiBrda;
import com.buit.op.response.OpCf02;
import com.buit.system.model.DicKszd;
import com.buit.system.response.HrPersonnelModel;
import com.buit.system.response.QueryJsJcResp;
import com.buit.system.response.SysXtcs;
import com.buit.system.service.DicKszdOutSer;
import com.buit.system.service.DicSfxmlbService;
import com.buit.system.service.FeeYlsfxmOutSer;
import com.buit.system.service.FeeYlsfxmdjService;
import com.buit.system.service.HrPersonnelService;
import com.buit.system.service.PubBrxzOutSer;
import com.buit.system.service.PubFkfsService;
import com.buit.system.service.SysXtcsCacheSer;
import com.buit.system.service.SysXtcsSer;
import com.buit.system.utill.MedicineUtils;
import com.buit.system.utill.ObjectToTypes;
import com.buit.utill.HisUtil;
import com.buit.utill.JackJsonUtil;
import com.buit.utill.MzUtil;
import com.buit.utill.RedisFactory;
import com.buit.utill.ServiceCode;
import com.buit.utill.StrUtil;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.CaseInsensitiveMap;

/**
 * 门诊_门诊收费信息<br>
 * 
 * @author WY
 */
@Service
public class OpMzxxSer extends BaseManagerImp<OpMzxx, Integer> {

	static final Logger logger = LoggerFactory.getLogger(OpMzxxSer.class);

	@Autowired
	private OpMzxxDao opMzxxDao;
	@Autowired
	private OpGhmxDao opGhmxDao;

//	@Autowired
//	private ShybMzdbDbksDao ybMzdbDbksDao;

	@Autowired
	private OpCf02Dao opCf02Dao;

	@Autowired
	private OpYjcf02Dao opYjcf02Dao;

	@Autowired
	private OpYjcf02ZtDao opYjcf02ZtDao;

	@Autowired
	private OpCf01Dao opCf01Dao;

	@Autowired
	private OpYjcf01Dao opYjcf01Dao;

	@DubboReference
	private PubBrxzOutSer pubBrxzOutSer;

	@Autowired
	private OpGhksDao opGhksDao;

	@Autowired
	private WlKfdzDao wlKfdzDao;

	@Autowired
	private OpMzlbDao opMzlbDao;

	@Autowired
	private OpMzlbSer opMzlbSer;

	@DubboReference
	private PubFkfsService pubFkfsService;

	@Autowired
	private GmAxektcDao gmAxektcDao;

	@Autowired
	private MpiBrdaDao mpiBrdaDao;

	@Autowired
	private OpGhFkxxDao opGhFkxxDao;

	@Autowired
	private OpYyghDao opYyghDao;

	@Autowired
	private OpYsJzlsDao opYsJzlsDao;

	@Autowired
	private FeeXmzxksDao feeXmzxksDao;

	@Autowired
	private WlWzkcDao wlWzkcDao;

	@Autowired
	private WlXhmxDao wlXhmxDao;

	@DubboReference
	private PharBaseConfigService pharBaseConfigService;

	@DubboReference
	private DrugService drugService;

	@Autowired
	private MpiCardDao mpiCardDao;

	@Autowired
	private OpSeqDao opSeqDao;

	@Autowired
	private OpSfmxDao opSfmxDao;

	@Autowired
	private OpFkxxDao opFkxxDao;

//	@DubboReference
//	private YbMzjsDao ybMzjsDao;

	@Autowired
	private OpPosmxDao opPosmxDao;

	@Autowired
	private OpCzjlDao opCzjlDao;

	@DubboReference
	private Cisjcsqd01Service cisjcsqd01Service;

	@Autowired
	private OpZffpDao opZffpDao;

	@Autowired
	private MpiKpxxDao mpiKpxxDao;

	@DubboReference
	private DrugsTypkOutSer drugsTypkOutSer;

	@DubboReference
	private FeeYlsfxmdjService feeYlsfxmdjDao;

	@Autowired
	private OpYgpjDao opYgpjDao;

	@DubboReference
	private DrugLogService drugLogService;

	@Autowired
	private OpThmxDao opThmxDao;

	@Autowired
	private OpKspbDao opKspbDao;

	@Autowired
	private OpYspbDao opYspbDao;

	@DubboReference
	private OpZt02Service opZt02Service;

	@DubboReference
	private FeeYlsfxmOutSer feeYlsfxmDao;

	@DubboReference
	private DicSfxmlbService dicSfxmlbService;

	@Autowired
	private PubJmlxDao pubJmlxDao;

	@Autowired
	private OpBrzdDao opBrzdDao;

	@Autowired
	private OpGhksSer opGhksSer;

	@Autowired
	private RedisFactory redisFactory;

	@Autowired
	private MzUtil mzUtil;

	@DubboReference
	private SysXtcsCacheSer sysXtcsCacheSer;

	@Autowired
	private OpFpdyjlDao opFpdyjlDao;

	@DubboReference
	private SysXtcsSer sysXtcsSer;

	@DubboReference
	private HrPersonnelService hrPersonnelService;

	@DubboReference
	private MedicalInsuranceService medicalInsuranceService;
	@DubboReference
	private UnifiedBusinessService unifiedBusinessService;
	@DubboReference
	private DicKszdOutSer dicKszdOutSer;
	@DubboReference
	private ShybSh01Service shybSh01Service;
	@DubboReference
	private OfflineSettleService offLineSettle;
	@DubboReference
	private ShybMzdbDbksService shybMzdbDbksService;
	@DubboReference
	private MdiLisService lisService;
	@DubboReference
	private TreatmentApplyFormService treatmentApplyFormService;


	@Override
	public OpMzxxDao getEntityMapper() {
		return opMzxxDao;
	}

	/**
	 * 单据查询
	 *
	 * @param req
	 * @return
	 */
	public MsQueryDjResp doQueryDj(MsQryDjReq req) {
		Map<String, Object> body = MzUtil.caseInsensitiveMap(req);
		Map<String, Object> res = new HashMap<String, Object>(16);
		Map<String, Object> parameters = new HashMap<String, Object>(16);
		Map<String, Object> parameters1 = new HashMap<String, Object>(16);
		long brid = Long.parseLong(body.get("BRID") + "");
		long kdrq = 1;
		// 自动调入处方的有效期0.不限制  以天为单位
		String kdrqstr = sysXtcsCacheSer.getCsz(req.getJgid(), "CFXQ");
		if (kdrqstr != "") {
			kdrq = Long.parseLong(kdrqstr);
		}
		int qymzsf = 0;
		//启用门诊审方标志，0表示不启用，1表示启用，默认是0
		String qymzsftr = sysXtcsCacheSer.getCsz(req.getJgid(), "QYMZSF");
		if (qymzsftr != "") {
			qymzsf = Integer.parseInt(qymzsftr);
		}
		if (req.getCnds() != null) {
			kdrq = Long.parseLong(req.getCnds().toString());
		}
		if (body.get("JZKH") != null) {
			parameters.put("JZKH", body.get("JZKH").toString());
			parameters1.put("JZKH", body.get("JZKH").toString());
		}
		parameters.put("BRID", brid);
		parameters.put("XQ", kdrq);
		parameters.put("JGID", req.getJgid());
		parameters.put("QYMZSF", qymzsf);
		parameters.put("KDRQ", new Date(((Calendar.getInstance().getTimeInMillis()) - (kdrq * 24 * 60 * 60 * 1000))));
		parameters1.put("BRID", brid);
		parameters1.put("XQ", kdrq);
		parameters1.put("JGID", req.getJgid());
		parameters1.put("QYMZSF", qymzsf);
		parameters1.put("KDRQ", new Date(((Calendar.getInstance().getTimeInMillis()) - (kdrq * 24 * 60 * 60 * 1000))));

		List<Map<String, Object>> listCf = opMzxxDao.getCfInfo(parameters);
		List<Map<String, Object>> listYj = opMzxxDao.getAllCfInfo(parameters1);
		List<Map<String, Object>> listDj = new ArrayList<Map<String, Object>>();
		listDj.addAll(listCf);
		listDj.addAll(listYj);
		if (listDj.size() > 0) {
			res.put("count", 1);
			res.put("KDRQ", kdrq);
			res.put("body", listDj);
		} else {
			res.put("count", 0);
			res.put("body", listDj);
		}

		// 以下代码收费处增加诊断查询
		String ghxq = sysXtcsCacheSer.getCsz(req.getJgid(), "GHXQ");
		// 效期计算方式
		String xqjsfs = sysXtcsCacheSer.getCsz(req.getJgid(), "XQJSFS");

		SimpleDateFormat matter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		if ("1".equals(xqjsfs + "")) {
			now = DateUtil.endOfDay(DateUtil.date()).toSqlDate();
		}
		if (ghxq == null || !ghxq.matches("[0-9]+")) {
			throw BaseException.create("ERROR_REG_0022");
		}
		Map<String, Object> opGhmxparameters = new HashMap<String, Object>(16);
		opGhmxparameters.put("GHSJ", DateUtils.addDays(now, -Integer.parseInt(ghxq)));
		opGhmxparameters.put("JGID", req.getJgid());
		opGhmxparameters.put("BRID", brid);
		opGhmxparameters.put("NOW", new Date());
		opGhmxparameters.put("THBZ", 0);

		List<Map<String, Object>> listGhxx = opGhmxDao.getZdxh(opGhmxparameters);

		if (listGhxx != null && listGhxx.size() > 0) {
			res.put("ZDXH", ObjectToTypes.parseLong(listGhxx.get(0).get("ZDXH")));
			res.put("JBMC", ObjectToTypes.parseString(listGhxx.get(0).get("JBMC")));
		} else {
			res.put("ZDXH", 0);
			res.put("JBMC", "");
		}

		// 根据开单日期排序
		Collections.sort(listDj, new Comparator<Map<String, Object>>() {
			public int compare(Map<String, Object> m1, Map<String, Object> m2) {
				int n = ObjectToTypes.toInt(m2.get("JZLSH")) - ObjectToTypes.toInt(m1.get("JZLSH"));
				return n;
			}
		});
		MsQueryDjResp resp = new MsQueryDjResp();
		List<MsCfInfoResp> resultList = MzUtil.ListToResultSet(listDj, new MsCfInfoResp());
		resp.setCount(res.get("count") != null ? Integer.valueOf(res.get("count").toString()) : 0);
		resp.setKdrq(res.get("KDRQ") != null ? Integer.valueOf(res.get("KDRQ").toString()) : 0);
		resp.setZdxh(res.get("ZDXH") != null ? Integer.valueOf(res.get("ZDXH").toString()) : 0);
		resp.setJbmc(res.get("JBMC") != null ? res.get("JBMC").toString() : "");
		resp.setListDj(resultList);
		return resp;
	}

//	/**
//	 * 诊间单据查询
//	 *
//	 * @return
//	 */
//	public List<Integer> doQueryDbybks() {
//		return ybMzdbDbksDao.getKsdm();
//	}

	/**
	 * 根据病人性质改变自负比例
	 *
	 * @param req
	 */
	public void doChangeZfbl(ChangeZfblReq req) {
		List<Map<String, Object>> body = MzUtil.ListObjToMap(req.getZfblList());
		StringBuffer cfsbs = new StringBuffer();
		StringBuffer yjxhs = new StringBuffer();
		for (int i = 0; i < body.size(); i++) {
			Map<String, Object> dj = body.get(i);
			if ("0".equals(String.valueOf(dj.get("CFLX")))) {
				if (yjxhs.length() > 0) {
					yjxhs.append(",");
					yjxhs.append(dj.get("CFSB"));
				} else {
					yjxhs.append(dj.get("CFSB"));
				}
			} else {
				if (cfsbs.length() > 0) {
					cfsbs.append(",");
					cfsbs.append(dj.get("CFSB"));
				} else {
					cfsbs.append(dj.get("CFSB"));
				}
			}
		}
		if (cfsbs.length() != 0) {
			Map<String, Object> map = new HashMap<String, Object>(16);
			map.put("cfsbs", String.valueOf(cfsbs));
			List<Map<String, Object>> listCfmx = opCf02Dao.getSbxhList(map);
			for (int i = 0; i < listCfmx.size(); i++) {
				listCfmx.get(i).put("ZFBL", mzUtil.getCFZFBL(Long.parseLong(listCfmx.get(i).get("FYGB") + ""),
						Long.parseLong(req.getBrxz().toString()), Long.parseLong(listCfmx.get(i).get("YPXH") + "")));
				opCf02Dao.updateYpxh(listCfmx.get(i));
			}
		}
		if (yjxhs.length() != 0) {
			Map<String, Object> map = new HashMap<String, Object>(16);
			map.put("yjxhs", String.valueOf(yjxhs));
			List<Map<String, Object>> listCfmx = opYjcf02Dao.getSbxhInfo(map);
			for (int i = 0; i < listCfmx.size(); i++) {
				listCfmx.get(i).put("ZFBL", mzUtil.getYJZFBL(Long.parseLong(listCfmx.get(i).get("FYGB") + ""),
						Long.parseLong(req.getBrxz().toString()), Long.parseLong(listCfmx.get(i).get("YLXH") + "")));
				opYjcf02Dao.updateYlxh(listCfmx.get(i));
			}
		}

	}

	/**
	 * 单据明细查询
	 *
	 * @param req
	 */
	public List<QueryDjDetailResp> doQueryDjDetails(ChangeZfblReq req) {
		Map<String, Object> res = new HashMap<String, Object>(16);
		List<Map<String, Object>> body = MzUtil.ListObjToMap(req.getZfblList());
		StringBuffer cfsbs = new StringBuffer();
		StringBuffer yjxhs = new StringBuffer();
		String fpcx = req.getFpcx();
		for (int i = 0; i < body.size(); i++) {
			Map<String, Object> dj = body.get(i);
			if ("0".equals(String.valueOf(dj.get("CFLX")))) {
				if (yjxhs.length() > 0) {
					yjxhs.append(",");
					yjxhs.append(dj.get("CFSB"));
				} else {
					yjxhs.append(dj.get("CFSB"));
				}
			} else {
				if (cfsbs.length() > 0) {
					cfsbs.append(",");
					cfsbs.append(dj.get("CFSB"));
				} else {
					cfsbs.append(dj.get("CFSB"));
				}
			}
		}
		int mzsfFlag = 0;
		if (!"1".equals(fpcx)) {
			mzsfFlag = Integer.valueOf(sysXtcsCacheSer.getCsz(req.getJgid(), "QYMZSF"));
		}
		List<Map<String, Object>> listDj = new ArrayList<Map<String, Object>>();
		if (cfsbs.length() != 0) {
			Map<String, Object> map = new HashMap<String, Object>(16);
			map.put("jgid", req.getJgid());
			map.put("mzsfFlag", mzsfFlag);
			map.put("cfsbs", String.valueOf(cfsbs));
			List<Map<String, Object>> listDj1 = opCf01Dao.getCfInfo(map);
			listDj.addAll(listDj1);
		}
		if (yjxhs.length() != 0) {
			Map<String, Object> map = new HashMap<String, Object>(16);
			map.put("jgid", req.getJgid());
			map.put("mzsfFlag", mzsfFlag);
			map.put("yjxhs", String.valueOf(yjxhs));
			List<Map<String, Object>> listDj2 = opYjcf01Dao.getYjInfo(map);
			listDj.addAll(listDj2);
		}
		res.put("body", listDj);
		List<QueryDjDetailResp> respList = MzUtil.ListToResultSet(listDj, new QueryDjDetailResp());

		// 操作药品组套排序
		int sort = 1;
		String sbxhAndYpzh = "";
		for (QueryDjDetailResp resp : respList) {
			if (sbxhAndYpzh.equals(String.valueOf(resp.getCfsb()) + String.valueOf(resp.getYpzh()))) {
				resp.setYpzhSort(sort);
			} else {
				resp.setYpzhSort(++sort);
				sbxhAndYpzh = String.valueOf(resp.getCfsb()) + String.valueOf(resp.getYpzh());
			}
		}
		for (QueryDjDetailResp resp : respList) {
			logger.info(resp.getCfsb() + "-" + resp.getYpzh() + "-" + resp.getYpzhSort());
		}
		return respList;
	}

	/**
	 * 根据病人性质查询上级性质
	 *
	 * @param brxz
	 * @return
	 */
	public Integer querySjBrxz(Integer brxz) {
		Integer sjbrxz = pubBrxzOutSer.getSjxzByBrxz(brxz);
//		if (sjbrxz != null && sjbrxz.intValue() == 6021) {
//			throw BaseException.create("ERROR_REG_0071");
//		}
		return sjbrxz;
	}

	/**
	 * 根据医生工号查找对应的挂号科室
	 *
	 * @param userId
	 * @return
	 */
	public FindKsdmByYsdmResp doFindKsdmByYsdm(Integer userId) {
		List<String> res = new ArrayList<String>();
		Map<String, Object> params = new HashMap<String, Object>(16);
		params.put("YGDM", userId);
		List<Map<String, Object>> list = opGhksDao.getMzksAndKsdm(params);
		for (int i = 0; i < list.size(); i++) {
			res.add(list.get(i).get("MZKS").toString());
		}
		String str = Arrays.toString(res.toArray());
		String subStr = str.substring(1, str.length() - 1);
		String[] subArr = subStr.split(",");
		FindKsdmByYsdmResp resp = new FindKsdmByYsdmResp();
		resp.setKsdm(str);
		resp.setFirstKs(subArr[0]);
		return resp;
	}

	/**
	 * 验证病区是否开启物品计费标志 并判断是否存在二级库房
	 *
	 * @param req
	 */
//	public void doVerificationWpjfbz(ValidWpjfbzReq req) {
//		Map<String, Object> body = MzUtil.caseInsensitiveMap(req);
//		// 当前病区
//		long bq = 0;
//		Map<String, Object> ret = new HashMap<String, Object>(16);
//		int wpjfbz = 0;
//		// 住院
//		if (body.containsKey("bq")) {
//			bq = ObjectToTypes.parseLong(body.get("bq"));
//			SysXtcs sysXtcs = sysXtcsCacheSer.getByJGIdAndCsmc(req.getJgid(), SysXtcsCsmcCts.WPJFBZ);
//			wpjfbz = sysXtcs == null ? 0 : ObjectToTypes.parseInt(sysXtcs.getCsz());
//			if (wpjfbz == 0) {
//				return;
//			}
//		} else {// 门诊
//			SysXtcs sysXtcs = sysXtcsCacheSer.getByJGIdAndCsmc(req.getJgid(), SysXtcsCsmcCts.MZWPJFBZ);
//			wpjfbz = sysXtcs == null ? 0 : ObjectToTypes.parseInt(sysXtcs.getCsz());
//			if (wpjfbz == 0) {
//				return;
//			}
//			long ghgl = ObjectToTypes.parseLong(body.get("GHGL"));
//			long ghks = ObjectToTypes.parseLong(body.get("GHKS"));
//			if (ghgl == 0 && ghks == 0) {
//				throw BaseException.create("ERROR_REG_0023");
//			}
//			StringBuffer hqlGhks = new StringBuffer();
//			Map<String, Object> mapGhks = new HashMap<String, Object>(16);
//			Map<String, Object> mapParGhks = new HashMap<String, Object>(16);
//			if (ghks == 0) {
//				mapParGhks.put("ksdm", ghks);
//				mapGhks = opGhmxDao.getKsInfo(mapParGhks);
//			} else {
//				mapParGhks.put("ksdm", ghks);
//
//				mapGhks = dicKszdDao.getKsInfo(mapParGhks);
//			}
//			if (mapGhks == null || mapGhks.size() == 0) {
//				throw BaseException.create("ERROR_REG_0024");
//			}
//			bq = ObjectToTypes.parseLong(mapGhks.get("KSDM"));
//		}
//		Map<String, Object> mapPar = new HashMap<String, Object>(16);
//		mapPar.put("bq", bq);
//		long l = wlKfdzDao.getCountByKsdm(mapPar);
//		if (l == 0) {
//			throw BaseException.create("ERROR_REG_0025");
//		}
//	}

	/**
	 * 查询获得与这台计算机医保IP绑定的机构ID
	 *
	 * @param jgid
	 * @param ip
	 * @return
	 */
	public String doLoadThisComputerYbArgs(Integer jgid, String ip) {
		Map<String, Object> param = new HashMap<String, Object>(16);
		param.put("jgid", jgid);
		param.put("ip", ip);
		Map<String, Object> map = opMzlbDao.getYbjgid(param);
		String ybjgid = map.get("ybjgid") != null ? map.get("ybjgid").toString() : "";
		return ybjgid;
	}

	/**
	 * 结算信息查询
	 *
	 * @param req
	 */
	public QueryPaymentResp doQueryPayment(QueryPaymentReq req) {
		List<Map<String, Object>> body = MzUtil.ListObjToMap(req.getQueryPayReqList());
		Map<String, Object> parameters = new HashMap<String, Object>(16);
		QueryPaymentResp resp = new QueryPaymentResp();
		parameters.put("MRBZ", "1");
		parameters.put("SYLX", 1);
		List<Map<String, Object>> fkfsList = pubFkfsService.getPubFkfsInfo(parameters);
		Map<String, Object> fkfs = fkfsList.get(0);
		if (fkfs != null) {
			Map<String, Object> jsxx = new HashMap<String, Object>(16);
			BigDecimal zjje = BigDecimal.ZERO;
			BigDecimal zfje = BigDecimal.ZERO;
			BigDecimal jmje = BigDecimal.ZERO;

			BigDecimal sumHjje = BigDecimal.ZERO;
			BigDecimal sumZfbl = BigDecimal.ZERO;
			BigDecimal sum = new BigDecimal("0.0000");
			BigDecimal jmZkje = BigDecimal.ZERO;
			// 减免政策减免的金额
			BigDecimal zcjmje = new BigDecimal("0.00");
			BigDecimal sumZkje = BigDecimal.ZERO;
			// 查询是否存在挂号减免及减免百分比
			PubJmlxJm pubJmlxJm = pubJmlxDao.doQueryJmByFyzh(req.getJzkh());
			List<String> sfmxList = new ArrayList<>();
			// 判断病人是否可以减免
			if (pubJmlxJm != null) {
				if (pubJmlxJm.getZhxq() == null
						|| (pubJmlxJm.getZhxq() != null && DateUtil.date().isBeforeOrEquals(pubJmlxJm.getZhxq()))) {
					if (pubJmlxJm.getSfjm() != null && pubJmlxJm.getJsjmrate() != null) {
						String [] sfmxs = pubJmlxJm.getSfjm().split(",");
						sfmxList = Arrays.asList(sfmxs);
					}
				}
			}
			if (req.getJsxxReq() == null) {
				for (int i = 0; i < body.size(); i++) {
					Map<String, Object> data = body.get(i);
					String hjje = data.get("HJJE") + "";
					String zfbl = data.get("ZFBL") + "";
					String zkje = data.get("ZKJE") + "";
					String fygb = data.get("FYGB") + "";
					Integer sbxh = data.get("SBXH") != null ? Integer.valueOf(data.get("SBXH").toString()) : 0;
					Integer cflx = data.get("CFLX") != null ? Integer.valueOf(data.get("CFLX").toString()) : -1;
					zjje = zjje.add(new BigDecimal(hjje));
					// 患者如果可以减免 分别计算每种费用类别的药品费用
					if (sfmxList != null) {
						if (sfmxList.contains(fygb)) {
							sumHjje = new BigDecimal(hjje).multiply(pubJmlxJm.getJsjmrate());
							jmZkje = new BigDecimal(hjje).subtract(sumHjje);
							jmje = jmje.add(jmZkje);
							zcjmje = new BigDecimal(hjje).multiply(pubJmlxJm.getJsjmrate());
						} else {
							sumHjje = new BigDecimal(hjje);
							zcjmje = BigDecimal.ZERO;
						}
					} else {
						sumHjje = new BigDecimal(hjje);
					}
					sumZfbl = new BigDecimal(zfbl);
					sum = sum.add(sumHjje.multiply(sumZfbl));
					// 页面不允许直接打折扣 注释掉
					if (!"null".equals(zkje) && !"".equals(zkje)) {
						sumZkje = sumZkje.add(new BigDecimal(zkje));
					}

					// 根据sbxh更新医技02或处方02表的减免金额
					if (cflx.intValue() == 0) {
						opYjcf02Dao.updateJmjeBySbxh(zcjmje, sbxh);
					} else {
						opCf02Dao.updateJmjeBySbxh(zcjmje, sbxh);
					}
				}
				jmje = jmje.add(sumZkje);
				zfje = sum.subtract(sumZkje);
			} else {
				Map<String, Object> rjsxx = MzUtil.caseInsensitiveMap(req.getJsxxReq());
				zjje = new BigDecimal(String.valueOf(rjsxx.get("ZJJE")));
				zfje = new BigDecimal(String.valueOf(rjsxx.get("ZFJE")));
				jsxx.put("JJZF", ObjectToTypes.getDouble(Double.parseDouble(rjsxx.get("JJZF") + ""), 2));
				jsxx.put("ZHZF", ObjectToTypes.getDouble(Double.parseDouble(rjsxx.get("ZHZF") + ""), 2));
			}

//			double ysk = ObjectToTypes.getDouble(zfje, Integer.parseInt(fkfs.get("FKJD") + "") - 1);

			jsxx.put("FKFS", fkfs.get("FKFS"));
			jsxx.put("ZJJE", ObjectToTypes.getDouble(zjje, 2));
			jsxx.put("ZFJE", ObjectToTypes.getDouble(zfje, 2));
			jsxx.put("JMJE", ObjectToTypes.getDouble(jmje, 2));
			jsxx.put("YSK", ObjectToTypes.getDouble(zfje, 2));
			jsxx.put("QTYS", ObjectToTypes.getDouble(0, 2));
			// 格式化金额 四舍五入保留到角
//			String yskFormat = mzUtil.formatBy2Scale(ysk, 1);
//			jsxx.put("YSK", Double.valueOf(yskFormat));

			String YBSYPB = sysXtcsCacheSer.getCsz(req.getJgid(), "YBSYPB");
			// 五期医保 明细上传 预结算
			String jzdyh = "";
			String jssqxh = "";
			if (req.getIsYb().intValue() == 1 && "0".equals(YBSYPB)) {
				String mzbkbrxz = sysXtcsCacheSer.getCsz(req.getJgid(), "MZBKBRXZ");
				String dbdm = "";
				String gsrdh = "";
				String persontype = "0";
				Integer brid = req.getBrid();
				/*List<Map<String, Object>> GsbzAndDbbz = mpiBrdaDao.getGsDb(brid);// 获取工伤和大病标识
				if (GsbzAndDbbz.size() > 0&&GsbzAndDbbz.get(0).get("GSRDH")!=null) {
					dbdm = GsbzAndDbbz.get(0).get("DBBZ") + "";
					gsrdh = GsbzAndDbbz.get(0).get("GSRDH") + "";
					persontype = "1";
				}
				String gsbz = "";// 是否为工伤科室
				Map map_gs = opGhksDao.getSfgs(req.getGhks(), req.getJgid());
				if (map_gs != null&&"1".equals(map_gs.get("SFGS"))) {
					gsbz = "1";
				}*/
				Map<String, Object> map_ybksdm = dicKszdOutSer.getYbksdm(Integer.parseInt(req.getGhks()));
				String ybksdm = map_ybksdm.isEmpty() ? "03" : map_ybksdm.get("ybks") + "";
				Map<String, Object> ybfyxx = CollectSfxm(req.getBrxz(),req.getJgid(), body);


				Map resJzdyh = queryMZJzdyhByks(brid, req.getJgid(),req.getGhks());
				if (resJzdyh != null && resJzdyh.containsKey("jzdyh")) {
					jzdyh = resJzdyh.get("jzdyh") + "";
				} else {
					throw BaseException.create("ERROR_SHYB_0021");
				}
				String cfsbxhs = "";
				String yjsbxhs = "";
				String cfsbs = "";
				String yjxhs = "";
				String jzlsh="";
				//
				List<String> cflist = new ArrayList<>();
				List<String> yjlist = new ArrayList<>();
				cflist.add("-999");
				yjlist.add("-999");
				for (Map<String, Object> cfyjsbxhmap : body) {
					String cflx = cfyjsbxhmap.get("cflx").toString();
					String cfsb = cfyjsbxhmap.get("cfsb").toString();
					String sbxh = cfyjsbxhmap.get("sbxh").toString();
					if ("0".equals(cflx)) { // 医技
						yjlist.add(sbxh);
					} else{
						cflist.add(sbxh);
					}
				}

				for (Map<String, Object> mapyb : body) {
					String cflx = mapyb.get("cflx").toString();
					String cfsb = mapyb.get("cfsb").toString();
					String sbxh = mapyb.get("sbxh").toString();
					if ("0".equals(cflx)) { // 医技
						yjxhs = yjxhs + cfsb + "','";
						yjsbxhs = yjsbxhs + sbxh + "','";
					} else { // 处方
						cfsbs = cfsbs + cfsb + "','";
						cfsbxhs = cfsbxhs + sbxh + "','";
					}
					jzlsh = StrUtil.null2Str(mapyb.get("jzlsh"));
				}
				if (!"".equals(cfsbs)) {
					cfsbs = cfsbs.substring(0, cfsbs.length() - 3);
					cfsbxhs = cfsbxhs.substring(0, cfsbxhs.length() - 3);
				}
				if (!"".equals(yjxhs)) {
					yjxhs = yjxhs.substring(0, yjxhs.length() - 3);
					yjsbxhs = yjsbxhs.substring(0, yjsbxhs.length() - 3);
				}
				String orgid = "";
				Map map_orgid = opMzlbDao.getYbjgdm(req.getJgid(), req.getIp());
				if (map_orgid != null && !map_orgid.isEmpty()) {
					orgid = map_orgid.get("ybjgid").toString();
				}
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("cfsbxhs", cfsbxhs);
				param.put("yjsbxhs", yjsbxhs);
				param.put("cfsbs", cfsbs);
				param.put("yjxhs", yjxhs);
				param.put("jgdm", orgid);
				param.put("cardtype", req.getCardtype());
				param.put("carddata", req.getCardid());
				param.put("djh", "");
				param.put("deptid", ybksdm);
				param.put("personspectag", req.getAccountattr().substring(3, 4));
				param.put("yllb", "S11");
				param.put("persontype", persontype);
				param.put("gsrdh", "");
				param.put("dbtype", "");
				param.put("jsksrq", "");
				param.put("jsjsrq", "");
				param.put("xsywlx", "");
				param.put("ghgl", "");
				param.put("zdxh", "");
				param.put("brxz", req.getBrxz());
				param.put("brid", brid);
				param.put("jzdyh", jzdyh);
				param.put("jgid", req.getJgid());
				param.put("ygdm", req.getYgdm());
				param.put("ygxm", req.getYgxm());
				param.put("ip", req.getIp());
				param.put("jslxbz","120");//急诊220
				param.put("jzlsh",jzlsh);

				param.put("bz", 2);
				param.put("yjlist",yjlist);
				param.put("cflist",cflist);
				Map<String, Object> res = new HashMap<>();

				//测试20210505
			/*	Map<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("CFSBXHS", cfsbxhs);
				paramMap.put("YJSBXHS", yjsbxhs);
				paramMap.put("CFSBXH",cflist);
				paramMap.put("YJSBXH",yjlist);
				int bz = 2;
				paramMap.put("BZ", bz);
				List<Map<String, Object>> feeDetailsList = opMzlbDao.getMxzd(paramMap);*/
				//测试20210505

				SettleResultDTO sn01ResultDTO = offLineSettle.batchUploadFeeDetails_MZ(param, res);
				if (sn01ResultDTO.getCode() != ServiceCode.CODE_OK) {
					throw BaseException.create("ERROR_SHYB_0022",
							new String[] { sn01ResultDTO.getCode() + "--" + sn01ResultDTO.getMsg() + "" });
				}
				param.put("resultSn01", sn01ResultDTO.getData());
				SettleResultDTO si11ResultDTO = offLineSettle.ChargePreSettlement_MZ(param, res);
				if (si11ResultDTO.getCode() != ServiceCode.CODE_OK) {
					throw BaseException.create("ERROR_SHYB_0023",
							new String[] { si11ResultDTO.getCode() + "--" + si11ResultDTO.getMsg() + "" });
				} else {
					MessageBody messageBody = JackJsonUtil.parse(si11ResultDTO.getData().toString(), MessageBody.class);
					Map<String, Object> si11res = (HashMap<String, Object>) messageBody.getXxnr();
					jssqxh = StrUtil.null2Str(si11res.get("jssqxh"));
					if ("1".equals(req.getIsDb())) {
						BigDecimal yb_zfje = new BigDecimal(si11res.get("tcdxjzfs") + "")
								.add(new BigDecimal(si11res.get("fjdxjzfs") + ""))
								.add(new BigDecimal(si11res.get("zfdxjzfs") + ""))
								.add(new BigDecimal(si11res.get("ybjsfwfyze") + ""))
								.add(new BigDecimal(si11res.get("fybjsfwfyze") + ""))
								.subtract(new BigDecimal(si11res.get("totalexpense") + ""));
						jsxx.put("ZFJE", yb_zfje);
						jsxx.put("YSK", yb_zfje);
					} else if (!"".equals(gsrdh)) {
						jsxx.put("ZFJE", 0);
					} else if (mzbkbrxz.equals(req.getBrxz())) {
						BigDecimal yb_zfje = new BigDecimal(si11res.get("totalexpense") + "")
								.subtract(new BigDecimal(si11res.get("curaccountpay") + ""))
								.subtract(new BigDecimal(si11res.get("hisaccountpay") + ""))
								.subtract(new BigDecimal(si11res.get("tczfs") + ""))
								.subtract(new BigDecimal(si11res.get("fjzfs") + ""))
								.subtract(new BigDecimal(si11res.get("zfdlnzhzfs") + ""))
								.subtract(new BigDecimal(si11res.get("tcdzhzfs") + ""))
								.subtract(new BigDecimal(si11res.get("fjdzhzfs") + ""));
						jsxx.put("ZFJE", yb_zfje);
						jsxx.put("YSK", yb_zfje);
					} else {
//						BigDecimal yb_zfje = new BigDecimal(si11res.get("zfdxjzfs") + "")
//								.add(new BigDecimal(si11res.get("tcdxjzfs") + ""))
//								.add(new BigDecimal(si11res.get("fjdxjzfs") + ""))
//								.add(new BigDecimal(si11res.get("fybjsfwfyze") + ""))
//								.add(new BigDecimal(si11res.get("ybjsfwfyze") + ""))
//								.subtract(new BigDecimal(si11res.get("totalexpense") + ""));
						BigDecimal yb_jyfyze = new BigDecimal(si11res.get("hisaccountpay") + "")
								.add(new BigDecimal(si11res.get("curaccountpay") + ""))
								//.add(new BigDecimal(si11res.get("zfdxjzfs") + ""))
								.add(new BigDecimal(si11res.get("zfdlnzhzfs") + ""))
								.add(new BigDecimal(si11res.get("tcdzhzfs") + ""))
								//.add(new BigDecimal(si11res.get("tcdxjzfs") + ""))
								.add(new BigDecimal(si11res.get("tczfs") + ""))
								.add(new BigDecimal(si11res.get("fjdzhzfs") + ""))
								//.add(new BigDecimal(si11res.get("fjdxjzfs") + ""))
								.add(new BigDecimal(si11res.get("fjzfs") + ""));
						BigDecimal yb_zfje = new BigDecimal(si11res.get("ybjsfwfyze") + "")
								.subtract(new BigDecimal(si11res.get("totalexpense") + ""))
								.add(new BigDecimal(si11res.get("fjdxjzfs") + ""))
								.add(new BigDecimal(si11res.get("tcdxjzfs") + ""))
								.add(new BigDecimal(si11res.get("zfdxjzfs") + "")).add(new BigDecimal(si11res.get("fybjsfwfyze") + ""))
								;
						jsxx.put("ZFJE", yb_zfje);
						jsxx.put("YSK", yb_zfje);
						//jsxx.put("GSBZ", gsbz);
						jsxx.put("GSRDH", gsrdh);
						jsxx.put("QTYS", yb_jyfyze);


					}
				}
			}
			// 医保end

			String fphm = opGhksSer.getNotesNumberNotIncrement(req.getYgdm(), req.getJgid(), 2);
			jsxx.put("FPHM", fphm);
			int fpzs = doQueryFpzs(body, req.getJgid());
			jsxx.put("FPZS", fpzs);
			String lastFphm = mzUtil.getFPHM(req.getYgdm(), req.getJgid(), fpzs);
			jsxx.put("lastFPHM", lastFphm);
			jsxx.put("jzdyh",jzdyh);
			jsxx.put("jssqxh",jssqxh);
			resp = BeanUtil.fillBeanWithMapIgnoreCase(jsxx, new QueryPaymentResp(), true);
//			res.put("body", jsxx);
		}
		return resp;
	}

	/**
	 * 查询发票张数
	 *
	 * @param datas
	 * @param jgid
	 * @return
	 */
	public int doQueryFpzs(List<Map<String, Object>> datas, Integer jgid) {
		String mzfpfdfs = sysXtcsCacheSer.getCsz(jgid, "MZFPFDFS");
		String mzfpsfld = sysXtcsCacheSer.getCsz(jgid, "MZFPSFLD");
		String mzfpmxsl = sysXtcsCacheSer.getCsz(jgid, "MZFPMXSL");
		if ("0".equals(mzfpfdfs)) {
			if ("1".equals(mzfpsfld) && Integer.parseInt(mzfpmxsl) > 0) {
				// datas中含有的草药记录不管有多少条，只算一条
				Iterator<Map<String, Object>> ite = datas.iterator();
				int herbsCount = 0;
				while (ite.hasNext()) {
					Map<String, Object> m = ite.next();
					if ("3".equals(m.get("CFLX") + "") && "1".equals(m.get("CFTS") + "")) {
						herbsCount++;
						ite.remove();
					}
				}
				if (herbsCount >= 1) {
					herbsCount = 1;
				}
				int n = (datas.size() + herbsCount) / Integer.parseInt(mzfpmxsl);
				if (Integer.parseInt(mzfpmxsl) * n < (datas.size() + herbsCount)) {
					n++;
				}
				return n;
			}
			return 1;
		} else if ("1".equals(mzfpfdfs)) {
			Map<String, String> fygbs = new HashMap<String, String>(16);
			for (Map<String, Object> data : datas) {
				fygbs.put(data.get("FYGB") + "", "");
				;
			}
			if ("1".equals(mzfpsfld) && Integer.parseInt(mzfpmxsl) > 0) {
				int l = 0;
				for (String key : fygbs.keySet()) {
					int k = 0;
					for (Map<String, Object> data : datas) {
						if ((data.get("FYGB") + "").equals(key)) {
							k++;
						}
					}
					int n = k / Integer.parseInt(mzfpmxsl);
					if (Integer.parseInt(mzfpmxsl) * n < k) {
						n++;
					}
					l += n;
				}
				return l;
			}
			return fygbs.size();
		} else if ("2".equals(mzfpfdfs)) {
			Map<String, String> yfsbs = new HashMap<String, String>(16);
			Map<String, String> zxkss = new HashMap<String, String>(16);
			for (Map<String, Object> data : datas) {
				if ("0".equals(data.get("CFLX") + "")) {
					zxkss.put(data.get("ZXKS") + "", "");
				} else {
					yfsbs.put(data.get("YFSB") + "", "");
				}
			}
			if ("1".equals(mzfpsfld) && Integer.parseInt(mzfpmxsl) > 0) {
				int l = 0;
				for (String key : zxkss.keySet()) {
					int k = 0;
					for (Map<String, Object> data : datas) {
						if ((data.get("FYGB") + "").equals(key)) {
							k++;
						}
					}
					int n = k / Integer.parseInt(mzfpmxsl);
					if (Integer.parseInt(mzfpmxsl) * n < k) {
						n++;
					}
					l += n;
				}
				for (String key : yfsbs.keySet()) {
					int k = 0;
					for (Map<String, Object> data : datas) {
						if ((data.get("FYGB") + "").equals(key)) {
							k++;
						}
					}
					int n = k / Integer.parseInt(mzfpmxsl);
					if (Integer.parseInt(mzfpmxsl) * n < k) {
						n++;
					}
					l += n;
				}
				return l;
			}
			return zxkss.size() + yfsbs.size();
		}
		return 0;
	}

	/**
	 * 检查是否是爱心卡
	 *
	 * @param req
	 * @return
	 */
	public AxktcResp doCheckIsAxktc(CheckIsAxktc axkReq) {
		AxktcResp resp = new AxktcResp();
		Map<String, Object> req = MzUtil.caseInsensitiveMap(axkReq);
		String tcbh = String.valueOf(req.get("tcbh"));
		if (StringUtils.isEmpty(tcbh)) {
			String yjxh = String.valueOf(req.get("yjxh"));
			if (yjxh != null && !"null".equals(yjxh)) {
				Map<String, Object> map = new HashMap<String, Object>(16);
				map.put("yjxh", yjxh);
				Map<String, Object> yj01 = opYjcf01Dao.getFwblshByYjxh(map);
				if (yj01 != null) {
					tcbh = String.valueOf(yj01.get("FWBLSH"));
				}
			}
			if (StringUtils.isEmpty(tcbh)) {
				String cfsb = String.valueOf(req.get("cfsb"));
				if (cfsb != null && !"null".equals(cfsb)) {
					Map<String, Object> map = new HashMap<String, Object>(16);
					map.put("cfsb", cfsb);
					Map<String, Object> cf01 = opCf01Dao.getFwblshByCfsb(map);
					if (cf01 != null) {
						tcbh = String.valueOf(cf01.get("FWBLSH"));
					}
				}
			}
		}
		Map<String, Object> map = new HashMap<String, Object>(16);
		map.put("tcbh", tcbh);
		Map<String, Object> groupInfo = gmAxektcDao.getAxklx(map);
		if (groupInfo != null) {
			resp = BeanUtil.fillBeanWithMapIgnoreCase(groupInfo, new AxktcResp(), true);
		}

		return resp;
	}

	/**
	 * 查看妇幼减免病人
	 *
	 * @param req
	 * @return
	 */
	public SelectfujmbrResp doSelectfujmbr(SelectfujmbrReq req) {
		Map<String, Object> res = new HashMap<String, Object>(16);
		Map<String, Object> body = MzUtil.caseInsensitiveMap(req);

		// 病人信息
		OpGhmxInfo opGhmxInfo = new OpGhmxInfo();
		Integer brid = body.get("fubrid") != null ? Integer.valueOf(body.get("fubrid").toString()) : 0;
		opGhmxInfo.setBrid(brid);
		MpiBrda mpiBrda = mpiBrdaDao.getByCondition(opGhmxInfo);
		Map<String, Object> csnymap = MzUtil.caseInsensitiveMap(mpiBrda);
		if (csnymap == null) {
			throw BaseException.create("ERROR_REG_0026");
		}
		Calendar cal = Calendar.getInstance();
		int age = cal.get(Calendar.YEAR) - Integer.valueOf(csnymap.get("CSNY").toString().substring(0, 4));
		body.remove("fuage");
		body.put("fuage", age);
		int xb = Integer.parseInt(body.get("fubrxb").toString());
		int fyetbrxz, newbrxz;
		if (age > 6) {
			if (xb != 2) {
				throw BaseException.create("ERROR_REG_0027");
			}
			// 若是孕妇则挂号科室是妇科类才减免
			String fuksdm = String.valueOf(body.get("JZKS"));// 就诊科室
			// 妇科科室代码
//			String FKKS = ParameterUtil.getParameter(UserRoleToken.getCurrent().getManageUnitId(), "FKKS", ctx);
			String fkks = sysXtcsCacheSer.getCsz(req.getJgid(), "FKKS");

			if (Arrays.asList(fkks.split(",")).contains(fuksdm)) {
				fyetbrxz = 1;
				newbrxz = 1;
			} else {
				throw BaseException.create("ERROR_REG_0029");
			}
		} else {
			fyetbrxz = 2;
			newbrxz = 2;
		}
		// checkgrzh()
		String nhyydm = sysXtcsCacheSer.getCsz(req.getJgid(), "NHYYBH");
		Map<String, Object> pam = new HashMap<String, Object>(16);
		pam.put("OPERATOR", req.getYgdm());
		pam.put("JKKH", body.get("jzkh").toString());
		pam.put("BRXZ", fyetbrxz);//
		// pam.put("BRXZ", "2");
		pam.put("YYBH", nhyydm);

//		Map<String, Object> resMap = mACFeeWaiver.CheckGrzh(pam);
//		System.out.println(resMap);
//		List<Map<String, Object>> list = (List<Map<String, Object>>) resMap.get("data");
//		if (resMap.get("CODE").equals("-1") || list == null || list.size() == 0) {
//			res.put("code", 500);
//			return;
//		}
//		res.put("code", 200);
//		res.put("GRBH", list.get(list.size() - 1).get("Grbh"));
		res.put("FYETBRXZ", fyetbrxz);
		res.put("newbrxz", newbrxz);
		SelectfujmbrResp resp = BeanUtil.fillBeanWithMapIgnoreCase(res, new SelectfujmbrResp(), true);
		return resp;
	}

	/**
	 * 得到自助挂号科室
	 *
	 * @param req
	 * @return
	 */
	public List<ZzghksResp> doGetZzghks(String jzkh, Integer jgid) {
		List<ZzghksResp> ghksList = new ArrayList<ZzghksResp>();
		Map<String, Object> map = new HashMap<String, Object>(16);
		map.put("jgid", jgid);
		map.put("jzkh", jzkh);
		List<Map<String, Object>> resultList = opGhmxDao.getZzghksList(map);
		ghksList = MzUtil.ListToResultSet(resultList, new ZzghksResp());
		return ghksList;
	}

	/**
	 * 保存折扣信息
	 *
	 * @param req
	 */
	public void doSaveDiscountInfo(DiscountInfoReq req) {
		List<Map<String, Object>> datas = MzUtil.ListObjToMap(req.getList());
		for (Map<String, Object> detail : datas) {
			String djly = detail.get("DJLY") + "";// 单据来源
			if ("6".equals(djly) || "null".equals(detail.get("ZKBL") + "") || "".equals(detail.get("ZKBL") + "")) {
				continue;
			}
			Map<String, Object> param = new HashMap<String, Object>(16);
			param.put("ZKBL", detail.get("ZKBL"));
			param.put("ZHJE", detail.get("ZHJE"));
			param.put("ZKJE", detail.get("ZKJE"));
			param.put("SBXH", detail.get("SBXH"));
			String cflx = detail.get("CFLX") + "";// 处方类型，区分处方和医技
			if ("0".equals(cflx)) {
				opYjcf02Dao.updateJeBySbxh(param);
			} else {
				opCf02Dao.updateJeBySbxh(param);
			}
		}

	}

	/**
	 * 门诊结算
	 *
	 * @param req
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doSaveOutpatientSettlement(OutpatientSettlementReq req) {
		Map<String, Object> res = new HashMap<String, Object>(16);
		Map<String, Object> body = MzUtil.caseInsensitiveMap(req);
		String uid = req.getYgdm() + "";
		List<OpFkxxReq> fkxxList = req.getFkxxList();
		Map<Integer, BigDecimal> fkxxMap = fkxxList.stream().collect(Collectors.toMap(OpFkxxReq::getFkfs, OpFkxxReq::getFkje));
		Set<Integer> fkfsList = fkxxMap.keySet();
		MzxxReq mzxxReq = req.getMzxxReq();
		// 获取VIP
		String vipbrxz = sysXtcsCacheSer.getCsz(req.getJgid(), "VIPBRXZ");
		String[] vipbrxzs = vipbrxz.split(",");
		int isVip = 0;// 是否是VIP病人
		String issmk = body.get("ISSMK") == null ? "0" : String.valueOf(body.get("ISSMK"));

		// 捷医发票号码保存（交易单号）
		String fkhm = body.get("FKHM") == null ? "0" : String.valueOf(body.get("FKHM"));
		Map<String, Object> opMzxxMap = MzUtil.caseInsensitiveMap(req.getMzxxReq());
		String brid = opMzxxMap.get("BRID") == null ? "" : String.valueOf(opMzxxMap.get("BRID"));
		if ("1".equals(issmk)) {// ISSMK 0 为窗口结算 1 为医生站结算 2 为自助机结算
			// 医生站结算取虚拟工号
			uid = sysXtcsCacheSer.getCsz(req.getJgid(), "XNCZGH");
			if (uid == null) {
				throw BaseException.create("ERROR_REG_0030");
			}
		}

		// 挂号费结算
//		Map<String, Object> ghMap = MzUtil.caseInsensitiveMap(req.getMzxxReq().getGhDetails());
//		if (!ghMap.isEmpty() && ghMap != null) {
//			// 获取虚拟发票号
//			String ghfp = doGetXnfpxl(req.getJgid());
//			if (fkfsList.contains(FkfsEnum.YFK.getKey())) { // 预付卡扣费
//				opGhksSer.doSaveYykjkInfo(body.get("CARDNO").toString(), ghMap.get("GHFY").toString(), "07", ghfp,
//						req.getYgdm(), req.getIp());
//			}
//			double ghje = Double.parseDouble(ghMap.get("GHJE").toString());// 挂号金额
//			double zlje = Double.parseDouble(ghMap.get("ZLJE").toString());// 诊疗费
//			double blje = Double.parseDouble(ghMap.get("BLJE").toString());// 病历费
//			double zjfy = Double.parseDouble(ghMap.get("ZJFY").toString());// 专家费
//			int sbxh = (Integer) ghMap.get("SBXH");
//
//			Map<String, Object> map = new HashMap<String, Object>(16);
//			map.put("GHJE", ghje);
//			map.put("ZLJE", zlje);
//			map.put("BLJE", blje);
//			map.put("ZJFY", zjfy);
//			map.put("GHFP", ghfp);
//			map.put("uid", uid);
//			map.put("SBXH", sbxh);
//			opGhmxDao.updateGhmxGhje(map);
//
//			// 更新收费表
//			Map<String, Object> map2 = new HashMap<String, Object>(16);
//			map2.put("SBXH", sbxh);
//			map2.put("FKFS", body.get("FFFS").toString());
//			map2.put("FKJE", Double.parseDouble(ghMap.get("GHFY") + ""));
//			OpGhFkxx opGhFkxx = BeanUtil.fillBeanWithMapIgnoreCase(map2, new OpGhFkxx(), true);
//			opGhFkxx.setJzlsh(req.getMzxxReq().getJzlsh() != null ? req.getMzxxReq().getJzlsh() : "0");
//			opGhFkxx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_GH_FKXX));
//			opGhFkxxDao.insert(opGhFkxx);
//
//			// 更新预约状态（收费）
//			Map<String, Object> yyMap = new HashMap<String, Object>(16);
//			yyMap.put("SBXH", sbxh);
//			opYyghDao.updateYyStatus(yyMap);
//
//			// TODO
//			res.put("GHFP", ghfp);
//		}

//		Integer wpjfbz = Integer.valueOf(sysXtcsCacheSer.getCsz(req.getJgid(), "MZWPJFBZ"));
//		Integer wzsfxmjg = Integer.valueOf(sysXtcsCacheSer.getCsz(req.getJgid(), "WZSFXMJG"));

		Date date = new Date();

		List<Map<String, Object>> datas = MzUtil.ListObjToMap(req.getList());
		if (opMzxxMap.containsKey("mxsave") && (Boolean) opMzxxMap.get("mxsave")) {
			body.put("body", datas);
			doSaveSettle(body, res, req);
			datas = (List<Map<String, Object>>) res.get("data");
		}

		// 如果就诊卡号为空，则从MPIcrad里取一个
		if (opMzxxMap.get("JZKH") == null || "".equals(String.valueOf(opMzxxMap.get("JZKH")))) {
			Map<String, Object> map = new HashMap<String, Object>(16);
			map.put("BRID", brid);
			Map<String, Object> m = mpiCardDao.getCardNo(map);
			String cardno = m == null ? "" : String.valueOf(m.get("NO"));
			opMzxxMap.put("JZKH", cardno);
		}

		Map<String, Object> jsData = body.get("jsData") == null ? null : (Map<String, Object>) body.get("jsData");
		BigDecimal idJmje = ObjectToTypes.parseBigDecimal(mzxxReq.getJmje());
		BigDecimal idMpje = ObjectToTypes.parseBigDecimal(mzxxReq.getMpje());
		BigDecimal idLpje = ObjectToTypes.parseBigDecimal(mzxxReq.getLpje());
		BigDecimal idZjje = ObjectToTypes.parseBigDecimal(mzxxReq.getZjje());
		// 病人性质是VIP，id_zjje=id_zfje
		for (int i = 0; i < vipbrxzs.length; i++) {
			if (vipbrxzs[i].toString().equals(opMzxxMap.get("BRXZ").toString())) {
				isVip = 1;
			}
		}
		BigDecimal idZpje = ObjectToTypes.parseBigDecimal(fkxxMap.get(FkfsEnum.ZP.getKey()));
		BigDecimal idFkje = ObjectToTypes.parseBigDecimal(fkxxMap.get(FkfsEnum.XJ.getKey()));
		BigDecimal idZfje = ObjectToTypes.parseBigDecimal(mzxxReq.getZfje());
		BigDecimal idXjje = mzxxReq.getYsk().subtract(idZpje);
		if (isVip == 1) {
			idZjje = idZfje;
		}
//		double idHbwc = MzUtil.getDouble(idZfje - idXjje - idJmje - idLpje - mzxxReq.getZpje().doubleValue(), 2);// 货币误差多减减免金额，理赔金额
		BigDecimal idHbwc = idZfje.subtract(idXjje).subtract(idZpje).negate();// 货币误差多减减免金额，理赔金额
		BigDecimal idJkje = ObjectToTypes.parseBigDecimal(mzxxReq.getJkje());
		BigDecimal idTzje = idJkje.subtract(idFkje);
		opMzxxMap.put("JMJE", MzUtil.getDouble(idJmje, 2));
		opMzxxMap.put("MPJE", MzUtil.getDouble(idMpje, 2));
		opMzxxMap.put("LPJE", MzUtil.getDouble(idLpje, 2));
		opMzxxMap.put("XJJE", MzUtil.getDouble(idXjje, 2));// 现金金额
		opMzxxMap.put("ZPJE", MzUtil.getDouble(idZpje, 2));//支票金额
		opMzxxMap.put("JKJE", MzUtil.getDouble(idJkje, 2));//支票金额
		if (jsData != null) {
			opMzxxMap.put("QTYS", opMzxxMap.get("JJZF"));
			opMzxxMap.put("ZHJE", opMzxxMap.get("ZHZF"));
			// OP_MZXX.put("YBLB", Integer.parseInt(jsData.get("YBLB") +
			// ""));
			// OP_MZXX.put("CYZDBM", jsData.get("CYZDBM") == null ? ""
			// : jsData.get("CYZDBM") + "");
		} else {
			opMzxxMap.put("ZHJE", 0d);
		}
		// if (kkxxObj != null) {// 市民卡信息保存
		// Map<String, Object> smk_kkxx = (Map<String, Object>) kkxxObj;
		// for (String key : smk_kkxx.keySet()) {
		// if ("JYRQ".equals(key)) {// 交易日期
		// // smk_kkxx.put(key,
		// // BSHISUtil.toDate(smk_kkxx.get(smk_kkxx) + ""));
		// smk_kkxx.put(key, new Date());// 交易日期先写定为当前日期
		// } else if ("JYJE".equals(key) || "ZHYE".equals(key)
		// || "XPYEDYXE".equals(key)) {// 交易金额、帐户余额、小票余额打印限额
		// smk_kkxx.put(
		// key,
		// Double.parseDouble(smk_kkxx.get(key) + "") / 100);
		// } else if ("JSLX".equals(key)) {
		// smk_kkxx.put(key,
		// Integer.parseInt(smk_kkxx.get(key) + ""));
		// } else {
		// smk_kkxx.put(key, smk_kkxx.get(key) + "");
		// }
		// }
		// smk_kkxx.put("FPHM", OP_MZXX.get("FPHM"));// 发票号码
		// smk_kkxx.put("CZGH", uid);// 操作工号
		// smk_kkxx.put("JGID", manaUnitId);// 机构ID
		// dao.doSave("create", "SMK_JSXX", smk_kkxx, true);
		// MedicareModel mm = new MedicareModel(dao);
		// mm.doSaveSMK_QDJL(ctx);// 保存市民卡签到记录
		// }
		opMzxxMap.put("ZJJE", MzUtil.getDouble(idZjje, 2));
		opMzxxMap.put("ZFJE", MzUtil.getDouble(idZfje, 2));
		opMzxxMap.put("MZGL", 0);
		opMzxxMap.put("JGID", req.getJgid());// 机构ID
		opMzxxMap.put("HBWC", MzUtil.getDouble(idHbwc, 2));// 货币误差
		opMzxxMap.put("ZFPB", 0);// 作废判别
		opMzxxMap.put("THPB", 0);// 退号判别

		opMzxxMap.put("SFFS", 0);// 收费方式
		// if (kkxxObj != null) {// 市民卡扣款信息不为空时，表明边诊疗边付费模块传来的数据
		if ("1".equals(issmk)) {// ISSMK 0 为窗口结算 1 为医生站结算
			opMzxxMap.put("SFFS", 1);// 收费方式置为1
			// OP_MZXX.put("SJFP", OP_MZXX.get("FPHM") + "");// 虚拟发票置为发票号码
		}
		opMzxxMap.put("HBBZ", 0);// 合并标志
		opMzxxMap.put("SFRQ", date);// 收费日期
		opMzxxMap.put("CZGH", uid);
		opMzxxMap.put("KSDM", req.getMzxxReq().getGhks());
		opMzxxMap.put("YSDM", req.getMzxxReq().getYsdm());

		// 获取门诊类别
		Integer mzlb = opMzlbSer.getMzlb(req.getJgid(), req.getIp());


		opMzxxMap.put("MZLB", mzlb);
		opMzxxMap.put("TZJE", MzUtil.getDouble(idTzje, 2));
		// if (jsData != null) {
		// if (jsData.containsKey("SBK")) {
		// Map<String, Object> brxx = dao.doLoad(
		// BSPHISEntryNames.MPI_BRDA, OP_MZXX.get("BRID") + "");
		// Map<String, Object> card = new HashMap<String, Object>(16);
		// card.put("EMPIID", brxx.get("EMPIID"));
		// card.put("CARDTYPECODE", "03");
		// card.put("CARDNO", jsData.get("SBK"));
		// card.put("CREATEUNIT", manaUnitId);
		// card.put("CREATEUSER", uid);
		// card.put("STATUS", "1");
		// card.put("LASTMODIFYUNIT", manaUnitId);
		// card.put("LASTMODIFYUSER", uid);
		// dao.doSave("create", BSPHISEntryNames.MPI_Card, card, false);
		// }
		// }
		/****************** 自助机 医保QTJE HBWC ZFJE 设置 *************************/

		if (null != body.get("ZZJ_QTYS_FLAG") && "1".equals(body.get("ZZJ_QTYS_FLAG") + "")) {
			if (null != body.get("ZZJ_QTYS")) {
				opMzxxMap.put("QTYS", body.get("ZZJ_QTYS") + "");
			}

			if (null != body.get("ZZJ_ZFJE")) {
				opMzxxMap.put("ZFJE", body.get("ZZJ_ZFJE") + "");

			}
			if (null != body.get("ZZJ_HBWC")) {
				opMzxxMap.put("HBWC", body.get("ZZJ_HBWC") + "");
			}
		}

		/****************** 自助机 医保QTJE HBWC ZFJE 设置 *************************/
		String fphm = "";
		if ("1".equals(issmk) || "2".equals(issmk)) { // 医生站和自助机的发票号取虚拟发票
			fphm = doGetXnfpxl(req.getJgid());
		} else {
			fphm = opGhksSer.getNotesNumber(req.getYgdm(), req.getJgid(), OpPjlxEnum.FPHM.getKey());
		}
		// 获取fphm后开始，处方医技预付卡支付
//		if (body.get("FFFS").toString().equals("19")) {
//			opGhksSer.doSaveYykjkInfo(body.get("CARDNO").toString(), opMzxxMap.get("YSK").toString(), "08", fphm,
//					req.getYgdm(), req.getIp());
//		}
		// add by yangl 获取虚拟药房发药序号
		String xnxh = getPharmacyOrderNum();
		opMzxxMap.put("FPHM", fphm);
		opMzxxMap.put("XNFP", xnxh);
		opMzxxMap.put("ZSFPBZ", "0");
		res.put("FPHM", fphm);
		res.put("JM_OP_MZXX", opMzxxMap);// 返回门诊信息，计免二类疫苗收费使用

		// 查询该卡用户是否存在充值卡
		if (fkfsList.contains(FkfsEnum.CZK.getKey())) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("CARDNO", body.get("cardno").toString());
			Map<String, Object> kpxxMap = mpiKpxxDao.getKpxxBycardNo(map);
			if (kpxxMap != null) {
				MpiKpxx mpiKpxx = BeanUtil.fillBeanWithMapIgnoreCase(kpxxMap, new MpiKpxx(), true);
				BigDecimal ghjr = fkxxMap.get(FkfsEnum.CZK.getKey());
				if (mpiKpxx.getKnye().compareTo(ghjr) < 1) {
					throw BaseException.create("ERROR_REG_0072");
				} else {
					BigDecimal knye = mpiKpxx.getKnye().subtract(ghjr);
					Map<String, Object> knyeMap = new HashMap<String, Object>();
					knyeMap.put("brid", mpiKpxx.getBrid());
					knyeMap.put("ysk", knye);
					knyeMap.put("cardno", body.get("cardno").toString());
					mpiKpxxDao.updateKnyeByBrid(knyeMap);
					// 保存充值卡操作记录数据(写入数据到OP_CZJL表)
					Map<String, Object> czjl = new HashMap<String, Object>(16);
					// 卡号
					czjl.put("CARDNO", body.get("cardno").toString());
					// 操作类型 01发卡 02充值 03退费 04挂失 05解挂 06注销 07挂号付费 08门诊付费 09住院付费 10挂号退费 11挂号退费 12住院退费
					czjl.put("CZTYPE", "08");
					// 操作金额
					czjl.put("AMOUNT", ghjr);
					// 操作工号
					czjl.put("CZGH", req.getYgdm());
					// 操作IP
					czjl.put("CZIP", req.getIp());
					// 操作时间
					czjl.put("CZSJ", DateUtil.date().toTimestamp());
					// 病人ID
					czjl.put("BRID", MedicineUtils.parseLong(opMzxxMap.get("BRID")));
					czjl.put("CZFS", null);
					czjl.put("LASTKNYE", mpiKpxx.getKnye());
					czjl.put("FPHM", fphm);
					czjl.put("JZLSH", req.getMzxxReq().getJzlsh() != null ? req.getMzxxReq().getJzlsh() : "0");
					OpCzjl opCzjl = BeanUtil.fillBeanWithMapIgnoreCase(czjl, new OpCzjl(), true);
					opCzjl.setCzxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CZJL));
					opCzjlDao.insert(opCzjl);
				}
			} else {
				throw BaseException.create("ERROR_REG_0073");
			}
		}

		OpMzxx opMzxx = BeanUtil.fillBeanWithMapIgnoreCase(opMzxxMap, new OpMzxx(), true);
		opMzxx.setMzxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_MZXX));
		opMzxx.setJzlsh(req.getMzxxReq().getJzlsh() != null ? req.getMzxxReq().getJzlsh() : "0");
		opMzxx.setPsje(BigDecimal.ZERO);
		opMzxx.setQtys(ObjectToTypes.parseBigDecimal(mzxxReq.getQtys()));
		opMzxxDao.insert(opMzxx);

		Map<String, Object> mzxh = MzUtil.caseInsensitiveMap(opMzxx);

		int fpzs = Integer.parseInt(opMzxxMap.get("FPZS") + "");
		if (!"1".equals(issmk)) { // 去除诊间结算的逻辑
			for (int i = 0; i < fpzs - 1; i++) {
				opGhksSer.getNotesNumber(req.getYgdm(), req.getJgid(), OpPjlxEnum.FPHM.getKey());
			}
		}
		Set<Long> fygbs = new HashSet<Long>();
		Set<Long> cfsbs = new HashSet<Long>();
		Set<Long> yjxhs = new HashSet<Long>();
		Map<Long, List<Long>> cfsbXy = new HashMap<Long, List<Long>>(16);
		Map<Long, List<Long>> cfsbZy = new HashMap<Long, List<Long>>(16);
		Map<Long, List<Long>> cfsbCy = new HashMap<Long, List<Long>>(16);
		// 药房允许切换时
		Set<Long> fyyfXy = new HashSet<Long>();// 西药
		Set<Long> fyyfZy = new HashSet<Long>();// 中药
		Set<Long> fyyfCy = new HashSet<Long>();// 草药
		for (int i = 0; i < datas.size(); i++) {
			Map<String, Object> data = datas.get(i);
			fygbs.add(Long.parseLong(data.get("FYGB") + ""));
			// fygbs.add(Long.parseLong(data.get("FYGB") + ""));
			if ("0".equals(data.get("CFLX") + "")) {
				if (data.containsKey("YJXH")) {
					yjxhs.add(Long.parseLong(data.get("YJXH") + ""));
				} else {
					yjxhs.add(Long.parseLong(data.get("CFSB") + ""));
				}
			} else {
				int cfs = cfsbs.size();
				cfsbs.add(Long.parseLong(data.get("CFSB") + ""));
				if (cfs != cfsbs.size()) {
					Long yfsb = Long.parseLong(data.get("YFSB") + "");
					if ("1".equals(data.get("CFLX") + "")) {// 以前是对比YS_MZ_FYYF_XY来判断类型，现在改为CFLX
						// ll_xyfzs += 1;
						fyyfXy.add(yfsb);
						if (cfsbXy.containsKey(yfsb)) {
							cfsbXy.get(yfsb).add(Long.parseLong(data.get("CFSB") + ""));
						} else {
							List<Long> list = new ArrayList<Long>();
							list.add(Long.parseLong(data.get("CFSB") + ""));
							cfsbXy.put(yfsb, list);
						}
					} else if ("2".equals(data.get("CFLX") + "")) {
						// ll_zyfzs += 1;
						fyyfZy.add(yfsb);
						if (cfsbZy.containsKey(yfsb)) {
							cfsbZy.get(yfsb).add(Long.parseLong(data.get("CFSB") + ""));
						} else {
							List<Long> list = new ArrayList<Long>();
							list.add(Long.parseLong(data.get("CFSB") + ""));
							cfsbZy.put(yfsb, list);
						}
					} else if ("3".equals(data.get("CFLX") + "")) {
						// ll_cyfzs += 1;
						fyyfCy.add(yfsb);
						if (cfsbCy.containsKey(yfsb)) {
							cfsbCy.get(yfsb).add(Long.parseLong(data.get("CFSB") + ""));
						} else {
							List<Long> list = new ArrayList<Long>();
							list.add(Long.parseLong(data.get("CFSB") + ""));
							cfsbCy.put(yfsb, list);
						}
					}
				}
			}
		}
		Iterator<Long> it = fygbs.iterator();

		//Map<String, Double> zfjes = new HashMap<String, Double>(16);
		Map<String, Object> zfjes = new HashMap<String, Object>();

		while (it.hasNext()) {
			long fygb = it.next();
			Map<String, Object> sfmx = new HashMap<String, Object>(16);
			sfmx.put("MZXH", mzxh.get("MZXH"));
			sfmx.put("JGID", req.getJgid());
			sfmx.put("SFXM", fygb);
			sfmx.put("FPHM", opMzxxMap.get("FPHM"));
			BigDecimal zjje = BigDecimal.ZERO;
			BigDecimal zfje = BigDecimal.ZERO;
			BigDecimal czf = BigDecimal.ZERO;
			BigDecimal flzf = BigDecimal.ZERO;
			BigDecimal jmje = BigDecimal.ZERO;
			BigDecimal jmje_all = BigDecimal.ZERO;
            BigDecimal total_all = BigDecimal.ZERO;
			for (int i = 0; i < datas.size(); i++) {
				Map<String, Object> data = datas.get(i);
				if (fygb == Long.parseLong(data.get("FYGB") + "")) {
					BigDecimal hjje = new BigDecimal(data.get("HJJE") + "");
					BigDecimal zfbl = new BigDecimal(data.get("ZFBL") + "");
					zjje = zjje.add(hjje);
					//自负金额减去减免金额和折扣金额
					BigDecimal zkje = Objects.isNull(data.get("ZKJE")) ? BigDecimal.ZERO : new BigDecimal(String.valueOf(data.get("ZKJE")));
					jmje = Objects.isNull(data.get("JMJE")) ? BigDecimal.ZERO : new BigDecimal(String.valueOf(data.get("JMJE")));
					zfje = zfje.add(hjje.multiply(zfbl)).subtract(jmje).subtract(zkje);
					jmje_all = jmje_all.add(jmje).add(zkje);
					if (BigDecimal.ONE.compareTo(zfbl) == 0) {
						czf = czf.add(hjje.multiply(zfbl));
					} else {
						flzf = flzf.add(hjje.multiply(zfbl));
					}
				}
			}
			sfmx.put("JMJE",jmje_all);
			sfmx.put("ZJJE", MzUtil.getDouble(zjje, 2));
			if (isVip == 1) {
				sfmx.put("ZJJE", MzUtil.getDouble(zfje, 2));
			}
			sfmx.put("ZFJE", MzUtil.getDouble(zfje, 2));
			sfmx.put("CZF", MzUtil.getDouble(czf, 2));
			sfmx.put("FLZF", MzUtil.getDouble(flzf, 2));

			//
			zfjes.put(String.valueOf(fygb), zfje);
            String total = StrUtil.null2Str(zfjes.get("total"));
            System.out.println(total);
			if ("".equals(total)) {
				zfjes.put("total", zfje);
			} else {
                total_all = zfje.add(new BigDecimal(String.valueOf(zfjes.get("total"))));
                zfjes.put("total", total_all);
			}

			OpSfmx opSfmx = BeanUtil.fillBeanWithMapIgnoreCase(sfmx, new OpSfmx(), true);
			opSfmx.setJzlsh(req.getMzxxReq().getJzlsh() != null ? req.getMzxxReq().getJzlsh() : "0");
			opSfmxDao.insert(opSfmx);
		}

		// Long mzSequence=(Long)mzxh.get("MZXH");
		// String
		// updateMzxxSql="update OP_MZXX SET
		// KLBBZ=:KLBBZ,KNSJ=:KNSJ,YBZFJE=:YBZFJE,YBJYLSH=:YBJYLSH WHERE MZXH=:MZXH";
		// Param updateParam=Param.instance();
		// updateParam.put("KLBBZ", body.get("klbbz"));
		// updateParam.put("KNSJ", body.get("knsj"));
		// updateParam.put("YBZFJE", zfjes.get("total"));
		// updateParam.put("YBJYLSH", body.get("ybjylsh"));
		// updateParam.put("MZXH", mzSequence);
		// dao.doUpdate(updateMzxxSql,updateParam);

		res.put("zfjes", zfjes);
		res.put("mzxh", mzxh);

		Map<String, Object> parameters = new HashMap<String, Object>(16);

		parameters.put("FPHM", opMzxxMap.get("FPHM"));
		parameters.put("MZXH", mzxh.get("MZXH"));
		Iterator<Long> cf = cfsbs.iterator();
		StringBuffer cfsb = new StringBuffer();
		List<Long> cfsbList = new ArrayList<Long>();
		while (cf.hasNext()) {
			String cfsbStr = cf.next() + "";
			if (cfsb.length() > 0) {
				cfsb.append(",");
				cfsb.append(cfsbStr);
			} else {
				cfsb.append(cfsbStr);
			}
			cfsbList.add(Long.parseLong(cfsbStr));
		}

		Iterator<Long> yj = yjxhs.iterator();
		StringBuffer yjxh = new StringBuffer();
		while (yj.hasNext()) {
			if (yjxh.length() > 0) {
				yjxh.append(",");
				yjxh.append(yj.next());
			} else {
				yjxh.append(yj.next());
			}
		}
		if (yjxh.length() != 0) {
			// parameters.put("HJGH", user.getId());// add by liyunt
			parameters.put("HJGH", uid);// add by liyunt
			parameters.put("yjxh", String.valueOf(yjxh));
			// 修改单据状态为已收费
			parameters.put("djzt", 20);
			parameters.put("jczt", 20);
			opYjcf01Dao.updateHmByYjxh(parameters);
			// 根据医技序号修改检查状态
			opYjcf01Dao.updateJcztByYjxh(parameters);
//			if (wpjfbz == 1 && wzsfxmjg == 1) {
//				Map<String, Object> parameterssbxh = new HashMap<String, Object>(16);
//				parameterssbxh.put("MZXH", Long.parseLong(mzxh.get("MZXH") + ""));
//
//				List<Map<String, Object>> sbxhList = opYjcf01Dao.getSbxhByMzxh(parameterssbxh);
//				for (int q = 0; q < sbxhList.size(); q++) {
//					Long sbxh = 0L;
//					if (sbxhList.get(q).get("SBXH") != null) {
//						sbxh = Long.parseLong(sbxhList.get(q).get("SBXH") + "");
//						mzUtil.updateXHMXZT(sbxh, "1", req.getJgid());
//					}
//				}
//			}
			parameters.remove("HJGH");
			// if (updateyjsl != yjxhs.size()) {
			// throw new ModelDataOperationException(
			// ServiceCode.CODE_DATABASE_ERROR,
			// "门诊结算失败,有单据已结算，请重新导入后在结算!");
			// }
			// update by caijy at 2015-08-02 for 医保结算 有概率执行这个代码报""转换失败
			// 导致本地报错
			// ConfigLogisticsInventoryControlModel cic = new
			// ConfigLogisticsInventoryControlModel(
			// dao);
			// cic.saveMzWzxx(yjxh.toString(), Long.parseLong(OP_MZXX
			// .get("GHKS") == null ? "0" : OP_MZXX.get("GHKS") + ""),
			// Long.parseLong(OP_MZXX.get("GHGL") == null ? "0"
			// : OP_MZXX.get("GHGL") + ""), Long
			// .parseLong(mzxh.get("MZXH") + ""), ctx);
		}
		int ckbh = -1;
		if (req.getCkbh() != null) {
			ckbh = Integer.parseInt(body.get("CKBH").toString());
		}
		if (cfsb.length() != 0) {
			if (cfsbXy.size() > 0) {// 西药处方
				for (Long yfsb : fyyfXy) {
					List<Long> xycf = cfsbXy.get(yfsb);
					List<Long> jmdCf = opCf01Dao.getJmdCfsb(xycf);
					List<Long> fjmdCf = xycf.stream().filter(o -> !jmdCf.contains(o)).collect(Collectors.toList());
					parameters.put("YFSB", yfsb);
					logger.info("西药处方："+ JSONUtil.toJsonStr(xycf) + "/t" + xycf.size());
					logger.info("精麻毒处方："+ JSONUtil.toJsonStr(jmdCf) + jmdCf.size());
					if(CollUtil.isNotEmpty(fjmdCf)) {
						logger.info("非精麻毒处方："+ JSONUtil.toJsonStr(fjmdCf) + "/t" + fjmdCf.size());
						Integer fyCkbh = opCf01Dao.getCkbhByRule(yfsb);
						if (ckbh > 0) {
							parameters.put("FYCK", ckbh);
						} else {
							parameters.put("FYCK", fyCkbh);
						}
						parameters.put("CFSB", fjmdCf);
						int updatecfsl = opCf01Dao.updateCfInfo(parameters);
						if (updatecfsl != fjmdCf.size()) {
							throw BaseException.create("ERROR_REG_0033");
						}
					}
					if(CollUtil.isNotEmpty(jmdCf)){
						Integer jmdCkbh = Integer.valueOf(sysXtcsCacheSer.getCsz(req.getJgid(), "JMDCKBH"));
						parameters.put("FYCK", jmdCkbh);
						parameters.put("CFSB", jmdCf);
						int updatejmdcfsl = opCf01Dao.updateCfInfo(parameters);
						if (updatejmdcfsl != jmdCf.size()) {
							throw BaseException.create("ERROR_REG_0033");
						}
					}
				}
			}

			if (cfsbZy.size() > 0) {// 中药处方
				for (Long yfsb : fyyfZy) {
					Integer fyCkbh = opCf01Dao.getCkbhByRule(yfsb);
					if (ckbh > 0) {
						parameters.put("FYCK", ckbh);
					} else {
						parameters.put("FYCK", fyCkbh);
					}
					parameters.put("CFSB", cfsbZy.get(yfsb));
					parameters.put("YFSB", yfsb);

					int updatecfsl = opCf01Dao.updateCfInfo(parameters);
					if (updatecfsl != cfsbZy.get(yfsb).size()) {
						throw BaseException.create("ERROR_REG_0033");
					}
				}
			}
			if (cfsbCy.size() > 0) {// 草药处方
				for (Long yfsb : fyyfCy) {
					Integer fyCkbh = opCf01Dao.getCkbhByRule(yfsb);
					if (ckbh > 0) {
						parameters.put("FYCK", ckbh);
					} else {
						parameters.put("FYCK", fyCkbh);
					}
					parameters.put("CFSB", cfsbCy.get(yfsb));
					parameters.put("YFSB", yfsb);

					int updatecfsl = opCf01Dao.updateCfInfo(parameters);
					if (updatecfsl != cfsbCy.get(yfsb).size()) {
						throw BaseException.create("ERROR_REG_0033");
					}
				}

			}
		}
		Map<String, Object> countParameters = new HashMap<String, Object>(16);
		Map<String, Object> countParameters2 = new HashMap<String, Object>(16);
		countParameters.put("MZXH", Long.parseLong(mzxh.get("MZXH") + ""));
		countParameters2.put("MZXH", Long.parseLong(mzxh.get("MZXH") + ""));
		long yj02Count = opYjcf01Dao.getYj01Count(countParameters);
		long cf02Count = opCf01Dao.getCf01Count(countParameters);

//			((Session)ctx.get(Context.DB_SESSION)).flush();
		if ((yj02Count + cf02Count) != datas.size()) {
			throw BaseException.create("ERROR_REG_0034");
		}
		// ========================如果是VIP病人合计金额需要乘以支付比例==================================
		countParameters2.put("VIP", isVip);

		double yj02Hjje = Double.parseDouble(opYjcf01Dao.getAmountByVip(countParameters2).toString());

		double cf02Hjje = Double.parseDouble(opCf01Dao.getAmountByVip(countParameters2).toString());

		// =========截取小数点后，两位数字的方法没有起作用========
		// 需要单独 对YJ02hjje和CF02hjje 取舍后进行运算
		BigDecimal yj02Hjje1 = new BigDecimal(String.valueOf(yj02Hjje));
		BigDecimal cf02Hjje1 = new BigDecimal(String.valueOf(cf02Hjje));
		BigDecimal yjcfhjje1 = yj02Hjje1.add(cf02Hjje1);
		double yjcfhjje = MzUtil.getDouble(yjcfhjje1.doubleValue(), 2);
		logger.info("yjcfhjje=" + yjcfhjje);
		logger.info("MzUtil.getDouble(id_zjje, 2)=" + MzUtil.getDouble(idZjje, 2));
		if (yjcfhjje != MzUtil.getDouble(idZjje, 2)) {
			throw BaseException.create("ERROR_REG_0035");
		}
		/*
		 * if ((MzUtil.getDouble(YJ02hjje + CF02hjje, 2)) != mzUtil
		 * .getDouble(id_zjje, 2)) { throw new ModelDataOperationException(
		 * ServiceCode.CODE_DATABASE_ERROR, "门诊结算失败,结算费用金额已发生变化，请重新导入后再结算!"); }
		 */

		if (BigDecimal.ZERO.compareTo(idHbwc) != 0) {
			Map<String, Object> parameters2 = new HashMap<String, Object>(16);
			parameters2.put("HBWC", "1");
			parameters2.put("SYLX", 1);
			List<Map<String, Object>> map = pubFkfsService.getPubFkfsInfo(parameters2);
			Long fkfs = map.get(0).get("FKFS") != null ? Long.parseLong(map.get(0).get("FKFS").toString()) : 0;

			Map<String, Object> opFkxxMap = new HashMap<String, Object>(16);
			opFkxxMap.put("JGID", req.getJgid());
			opFkxxMap.put("MZXH", mzxh.get("MZXH"));
			opFkxxMap.put("FKFS", fkfs);
			opFkxxMap.put("FKJE", MzUtil.getDouble(idHbwc, 2));
			opFkxxMap.put("FKHM", fkhm);

			OpFkxx opFkxx = BeanUtil.fillBeanWithMapIgnoreCase(opFkxxMap, new OpFkxx(), true);
			opFkxx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_FKXX));
			opFkxx.setJzlsh(req.getMzxxReq().getJzlsh() != null ? req.getMzxxReq().getJzlsh() : "0");
			opFkxxDao.insert(opFkxx);
		}
		fkxxList.forEach(o -> {
			OpFkxx opFkxx = new OpFkxx();
			opFkxx.setJgid(req.getJgid());
			opFkxx.setMzxh(opMzxx.getMzxh());
			opFkxx.setFkhm(fkhm);
			opFkxx.setFkfs(o.getFkfs());
			opFkxx.setFkje(o.getFkje());
			opFkxx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_FKXX));
			opFkxx.setJzlsh(req.getMzxxReq().getJzlsh() != null ? req.getMzxxReq().getJzlsh() : "0");
			opFkxxDao.insert(opFkxx);
		});
//		Map<String, Object> opFkxxMap = new HashMap<String, Object>(16);
//		opFkxxMap.put("JGID", req.getJgid());
//		opFkxxMap.put("MZXH", mzxh.get("MZXH"));
//		opFkxxMap.put("FKHM", fkhm);
//		if (req.getFffs() != null) {
//			opFkxxMap.put("FKFS", Long.valueOf(String.valueOf(body.get("FFFS"))));
//		}
//		opFkxxMap.put("FKJE", MzUtil.getDouble(idXjje, 2));
//
//		OpFkxx opFkxx = BeanUtil.fillBeanWithMapIgnoreCase(opFkxxMap, new OpFkxx(), true);
//		opFkxx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_FKXX));
//		opFkxx.setJzlsh(req.getMzxxReq().getJzlsh() != null ? req.getMzxxReq().getJzlsh() : "0");
//		opFkxxDao.insert(opFkxx);

//		PharmacyDispensingModel mpmm = new PharmacyDispensingModel(dao);
//		String sfzjfy = sysXtcsCacheSer.getCsz(req.getJgid(), "SFZJFY");
//		String ydczsf = opMzxxMap.get("YDCZSF") + "";// 移动收费判别字段，0为移动收费
//		if ("0".equals(ydczsf)) {// 如果为0，则为移动收费，设置收费直接发药参数
//			sfzjfy = "1";
//		}
		// TODO
//		if ("1".equals(SFZJFY)) {
//			for (int i = 0; i < cfsb_list.size(); i++) {
//				Map<String, Object> map = new HashMap<String, Object>(16);
//				map.put("cfsb", cfsb_list.get(i));
//				map.put("fygh", uid);
//				Map<String, Object> m = mpmm.saveDispensing(map, ctx);
//				if (m.containsKey("x-response-code")) {
//					if (Integer.parseInt(m.get("x-response-code") + "") > 300) {
//						throw new ModelDataOperationException(ServiceCode.CODE_DATABASE_ERROR,
//								m.get("x-response-msg") + "");
//					}
//				}
//			}
//		}
		if (req.getDetails() != null) {
			List<Map<String, Object>> dta = MzUtil.ListObjToMap(req.getDetails());
			Map<String, Object> bllxpar = new HashMap<String, Object>(16);
			for (int i = 0; i < dta.size(); i++) {
				Map<String, Object> detail = dta.get(i);
				if ("0".equals(String.valueOf(detail.get("CFLX")))) {
					bllxpar.put("SBXH", ObjectToTypes.parseLong(detail.get("SBXH")));
					bllxpar.put("ZFBL", ObjectToTypes.parseDouble(detail.get("ZFBL")));
					opYjcf02Dao.updateZfblBySbxh(bllxpar);
				} else {
					bllxpar.put("SBXH", ObjectToTypes.parseLong(detail.get("SBXH")));
					bllxpar.put("ZFBL", ObjectToTypes.parseDouble(detail.get("ZFBL")));
					opCf02Dao.updateZfblBySbxh(bllxpar);
				}
			}
		}
		// 库存冻结代码
		int sfqyyfyfy = Integer.parseInt(sysXtcsCacheSer.getCsz(req.getJgid(), "SFQYYFYFY"));
		int mzkcdjsj = Integer.parseInt(sysXtcsCacheSer.getCsz(req.getJgid(), "MZKCDJSJ"));

		if (sfqyyfyfy == 1 && mzkcdjsj == 2) {// 如果启用库存冻结,并且在收费时冻结
			// 先删除过期的冻结库存
			// MedicineCommonModel model = new MedicineCommonModel(dao);
			// model.deleteKCDJ(manaUnitId, ctx);
			for (Map<String, Object> mapCf02 : datas) {
				PharYpxxResp pharYpxx = drugService.findByYfsbAndYpxh(ObjectToTypes.parseInt(mapCf02.get("YFSB")),
						ObjectToTypes.parseInt(mapCf02.get("YPXH")));
				int yfbz = pharYpxx != null ? pharYpxx.getYfbz() : 0;
				Map<String, Object> mapKcdj = new HashMap<String, Object>(16);
				mapKcdj.put("JGID", req.getJgid());
				mapKcdj.put("YFSB", ObjectToTypes.parseLong(mapCf02.get("YFSB")));
				mapKcdj.put("CFSB", ObjectToTypes.parseLong(mapCf02.get("CFSB")));
				mapKcdj.put("YPXH", ObjectToTypes.parseLong(mapCf02.get("YPXH")));
				mapKcdj.put("YPCD", ObjectToTypes.parseLong(mapCf02.get("YPCD")));
				mapKcdj.put("YPSL", MzUtil.simpleMultiply(2, mapCf02.get("YPSL"), mapCf02.get("CFTS")));
				mapKcdj.put("YFBZ", yfbz);
				mapKcdj.put("DJSJ", DateUtil.date().toTimestamp());
				mapKcdj.put("JLXH", ObjectToTypes.parseLong(mapCf02.get("SBXH")));
				mapKcdj.put("DJLB", 1);
				mapKcdj.put("LSJG", ObjectToTypes.parseDouble(mapCf02.get("YPDJ")));
				PharKcdjReq pharKcdj = BeanUtil.fillBeanWithMapIgnoreCase(mapKcdj, new PharKcdjReq(), true);
				pharKcdj.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.PHAR_KCDJ));
				drugService.insertKcdj(pharKcdj);
			}
		}
		// 库存冻结代码结束
//		if (jsData != null) {// 如果是医保结算
//			Map<String, Object> mapBody = new HashMap<String, Object>(16);// 将需要保存到YB_MZJS的数据放到该变量中
//			mapBody.put("MZXH", mzxh.get("MZXH"));// 门诊序号 OP_MZXX主键
//			mapBody.put("FPHM", opMzxxMap.get("FPHM") + "");// 发票号码
//			mapBody.put("JGID", req.getJgid());// 机构ID
//			mapBody.put("ZFPB", 0);// 作废判别,1为作废
//			// ....
//			YbMzjs ybMzjs = BeanUtil.fillBeanWithMapIgnoreCase(mapBody, new YbMzjs(), true);
//			ybMzjs.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.YB_MZJS));
//			ybMzjsDao.insert(ybMzjs);
//		}
		if (opMzxxMap.get("ZDXH") != null && ObjectToTypes.parseLong(opMzxxMap.get("ZDXH")) != 0
				&& opMzxxMap.get("GHGL") != null && ObjectToTypes.parseLong(opMzxxMap.get("GHGL")) != 0) {
			Map<String, Object> mapPar = new HashMap<String, Object>(16);
			mapPar.put("zdxh", ObjectToTypes.parseLong(opMzxxMap.get("ZDXH")));
			mapPar.put("ghgl", ObjectToTypes.parseLong(opMzxxMap.get("GHGL")));
			opGhmxDao.updateZdxhBySbxh(mapPar);
		}

//		// POS机交易
//		String fffs = body.get("FFFS").toString();// 付费方式
//		Map<String, Object> pos = (Map<String, Object>) body.get("pos");
//		if (("3".equals(fffs) || "12".equals(fffs) || "18".equals(fffs)) && "1".equals(pos.get("success"))) {// 付费方式：POS机(新添微信支付宝)，写入pos机交易信息
//			Map<String, Object> posInfo = new HashMap<String, Object>(16);
//			// posInfo.put("ID", id);
//			posInfo.put("JYSJ", DateUtil.date().toTimestamp());
//			posInfo.put("JYLB", pos.get("TransType"));
//			posInfo.put("FPHM", fphm);
//			OpPosmx msOpPosmx = BeanUtil.fillBeanWithMapIgnoreCase(posInfo, new OpPosmx(), true);
//			msOpPosmx.setId(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_POSMX));
//			opPosmxDao.insert(msOpPosmx);
//		}

		// 医保begin
		if (req.getIsYb().intValue() == 1) {
			BigDecimal yb_zfje = new BigDecimal(req.getMzxxReq().getZfje() + "");
			String yb_mzxh = opMzxx.getMzxh() + "";
			Map<String, Object> map_ybksdm = dicKszdOutSer.getYbksdm((Integer) req.getMzxxReq().getGhks());
			String ybksdm = map_ybksdm.isEmpty() ? "03" : map_ybksdm.get("ksdm") + "";
			String gsrdh = "";
			String persontype = "0";
			if ("1".equals(req.getGsbz()) && !"".equals(req.getGsrdh())) {
				gsrdh = req.getGsrdh();
				persontype = "1";
			}
			String orgid = "";
			Map map_orgid = opMzlbDao.getYbjgdm(req.getJgid(), req.getIp());
			if (map_orgid != null && !map_orgid.isEmpty()) {
				orgid = map_orgid.get("ybjgid").toString();
			} else {
				throw BaseException.create("ERROR_SHYB_0015");
			}
           // String jzlsh = StrUtil.null2Str(body.get("jzlsh"));
            List<Map<String, Object>> zdnoList = opBrzdDao.getZdForSf(StrUtil.null2Str(opMzxxMap.get("jzlsh")));
            List<DiagnosisInfo> zdnos = new ArrayList<DiagnosisInfo>();
            for(int i = 0 ;i<zdnoList.size();i++){
                DiagnosisInfo zdno = new DiagnosisInfo();
                zdno.setZdno( zdnoList.get(i).get("zdno")+"");
                zdno.setZdmc(zdnoList.get(i).get("zdmc")+"");
                zdnos.add(zdno);
            }

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("ip", req.getIp());
			params.put("jgdm", orgid);
			params.put("jgid",req.getJgid());
			params.put("ygdm",req.getYgdm());
			params.put("ygxm",req.getYgxm());
			params.put("cardtype", opMzxxMap.get("cardtype"));
			params.put("carddata", opMzxxMap.get("cardid"));
			params.put("deptid", ybksdm);
			params.put("persontype", persontype);
			params.put("yllb", "S11");
			params.put("personspectag", StrUtil.null2Str(opMzxxMap.get("accountattr")).substring(3, 4));
			params.put("gsrdh", gsrdh);
			params.put("dbtype", req.getDbtype());
			params.put("jsksrq", "");
			params.put("jsjsrq", "");
			params.put("jzdyh", opMzxxMap.get("jzdyh"));
			params.put("xsywlx", "");
			params.put("jssqxh", opMzxxMap.get("jssqxh"));
			params.put("mzxh", yb_mzxh);
			params.put("zdnos", zdnos);
			params.put("jzlsh", opMzxxMap.get("jzlsh"));
			params.put("mxzdhs", req.getDetailsBills());
			SettleResultDTO si12ResultDTO = offLineSettle.confirmCharge_MZ(params, res);
			if (si12ResultDTO.getCode().intValue() == ServiceCode.CODE_OK
					&& !"".equals(si12ResultDTO.getData().toString())) {
				MessageBody messageBody = JackJsonUtil.parse(si12ResultDTO.getData().toString(), MessageBody.class);
				// 返回字段待定
			} else {
				throw BaseException.create("ERROR_SHYB_0020",
						new String[] { si12ResultDTO.getCode() + "--" + si12ResultDTO.getMsg() + "" });
				// jycx si91 待定
			}
		}

		if (StringUtils.isNotEmpty(String.valueOf(yjxh))) {
			try {
				List<OpYjcf01> zlSqdIdList = opYjcf01Dao.getListByYjxhs(String.valueOf(yjxh), null, 7, 1);
				for (OpYjcf01 zlsqd : zlSqdIdList) {
					treatmentApplyFormService.payBill(zlsqd.getZlsqdid(), fphm);
				}
			} catch (Exception e) {
				logger.info(CommonConstans.ZLSQD_RPC_INFO);
			}
			try {
				List<RequestUpdateInfo> requestUpdateInfoList = opYjcf01Dao.getLisRequestUpdate(String.valueOf(yjxh));
				requestUpdateInfoList.forEach(o -> {
					if (o.getBirthday() != null) {
						Map<String, Object> agMap = MzUtil.getPersonAge(DateUtil.parse(o.getBirthday()), null);
						if (!agMap.isEmpty()) {
							String ages = String.valueOf(agMap.get("ages"));
							if (ages.contains("岁")) {
								o.setAge_unit("岁");
								o.setAge(Integer.parseInt(String.valueOf(agMap.get("age"))));
							} else if (ages.contains("月")) {
								o.setAge_unit("月");
								o.setAge(Integer.parseInt((ages.split("月"))[0]));
							} else if (ages.contains("天")) {
								o.setAge_unit("天");
								o.setAge(Integer.parseInt((ages.split("天"))[0]));
							} else {
								o.setAge_unit("天");
								o.setAge(1);
							}

						}
					}
				});

				requestUpdateInfoList.forEach(o -> {
					List<RequestUpdateDetail> requestUpdateDetailList = opYjcf02Dao.getLisRequestUpdate(o.getRequest_no());
					LisRequestUpdateReq lisRequestUpdateReq = new LisRequestUpdateReq();
					lisRequestUpdateReq.setRequest_info(o);
					lisRequestUpdateReq.setRequest_detail(requestUpdateDetailList);
					logger.info("调用LIS入参：{}", JSONUtil.toJsonStr(lisRequestUpdateReq));
					LisResp lisResp = lisService.lisRequestUpdate(lisRequestUpdateReq);
					logger.info("调用LIS返回结果：{}", JSONUtil.toJsonStr(lisResp));
				});
			} catch (Exception e) {
				logger.info(CommonConstans.LIS_RPC_INFO);
			}
		}


		// 医保更新本地结算记录mzxh
//		if (body.containsKey("isYb") && "true".equals(body.get("isYb").toString())) {
//			String ybSql = "update " + body.get("tableName").toString() + " SET MZXH = '" + mzxh.get("MZXH").toString()
//					+ "' where zxlsh = '" + body.get("zxlsh").toString() + "'";
//			dao.doSqlUpdate(ybSql, null);
//		}

		// TODO 暂时不做
		// 农合收费结算
//		if (body.containsKey("isNh") && "1".equals(body.get("isNh") + "")) {
//			String nhyydm = sysXtcsCacheSer.getCsz(req.getJgid(), "NHYYBH");
//			String djid = body.get("djid") + "";
//			String bxje = body.get("bxje") + "";
//			NHCommonService nhs = new NHCommonService();
//			Result result = nhs.doMzjs(body, ctx, fphm);
//			if (!"1".equals(result.getCode())) {
//				throw BaseException.create("ERROR_REG_0036");
//			} else {
//				String bxid = result.getBxid();
//				String bxrq = result.getBxrq();
//				dao.doSqlUpdate("UPDATE OP_MZXX T SET T.bxje = '" + bxje + "', t.djid = '" + djid + "' ,t.nhbh = '"
//						+ nhyydm + "',t.nhbxid = " + bxid + ",t.nhbxrq = '" + bxrq + "' WHERE  t.mzxh = '"
//						+ mzxh.get("MZXH").toString() + "'", null);
//			}
//		}

		// TODO 暂时不做
		// 记录爱心卡减免数据
//		Map<String, Object> axkData = (Map<String, Object>) body.get("axk");
//		if (axkData != null) {
//			axkData.put("mzxh", mzxh.get("MZXH"));
//			dao.doSqlUpdate("update OP_MZXX set axktcbh=:axktcbh,axkjmje=:axkjmje where mzxh=:mzxh", axkData);
//		}

		// 如果前台没有选择发药窗口，调自动发药机过程获得窗口

		// 调用全自动发药机存储过程
		// this.callDispensingProc(fphm);
		// TODO 暂时不做
//		String qyzdfyj = sysXtcsCacheSer.getCsz(req.getJgid(), "QYZDFYJ");
//		if ("1".equals(qyzdfyj)) {
////				res.put("needAutoSendDrug", true);
//			Session ss = (Session) ctx.get(Context.DB_SESSION);
//			ss.flush();
//			res.put("qyzdfyj", true);
//			if (CKBH <= 0) {
//				res.put("chargeType", 0);
//				this.callDispensingProc(fphm, "0");
//			} else {
//				res.put("chargeType", 2);
//				this.callDispensingProc(fphm, "2");
//			}
//		}

		// TODO 暂时不做
//		if ("2".equals(ISSMK)) { // 等于2的时候代表自助结费,自助机获取不到ctx.get(Context.DB_SESSION) 为空报错
//
//		} else {
//			// 调用处方衍生接口
//			Session ss = (Session) ctx.get(Context.DB_SESSION);
//			ss.flush();
//			this.payConfirmAll(ctx, mzxh);
//
//			// 处理药房发药排队叫号
//			String SFQYYFFYJH = ParameterUtil.getParameter(user.getManageUnitId(), BSPHISSystemArgument.SFQYYFFYJH, "0",
//			if ("1".equals(SFQYYFFYJH)) {
//				for (Long sb : cfsbs) {
//					this.doYfPdxh(String.valueOf(sb), manaUnitId, ctx);
//				}
//			}
//			ss.flush();
//			String SFQYZYYPJK = ParameterUtil.getParameter(manaUnitId, BSPHISSystemArgument.SFQYZYYPJK, "0",
//					"是否启用中药饮片接口", ctx);
//			// 代煎处方上传接口
//			if ("1".equals(SFQYZYYPJK)) {
//				if (cfsb_cy != null && cfsb_cy.size() != 0) {
//					this.djcfscjk(ctx, OP_MZXX, datas, cfsb_cy);
//				}
//			}
//			ss.flush();
//			// 支付宝交易写在最后保证本地流程正常
//			Map<String, Object> alipay = (Map<String, Object>) body.get("alipay");
//			if ("12".equals(fffs) && "1".equals(alipay.get("success"))) {
//				this.doAlipayTradePay(Param.instance().put("totalAmount", StrUtil.null2Str(alipay.get("totalAmount")))
//						.put("zfbnum", StrUtil.null2Str(alipay.get("zfbnum"))).put("fphm", fphm), res, ctx);
//			}
//			ss.flush();
//		}
//		Map<String, Object> map_brxz = dao.doLoad(BSPHISEntryNames.PUB_BRXZ, OP_MZXX.get("BRXZ") + "");
//		// 如果非商保病人
//		if (!(Constants.BRXZ_SYBX + "").equals(OP_MZXX.get("BRXZ") + "")) {
//			// 将处方和医技的明细保存到Tbl_Cust_DocMaster
//			String Payee = DictionaryController.instance().get("phis.dictionary.doctor")
//					.getText(OP_MZXX.get("CZGH") + "");
//			/********************* 增值税 *******************************/
//			// 取税号和发票机号
//			String machinetaxnr = "";
//			String machinenr = "";
//			PublicService publicService = new PublicService();
//			Map<String, Object> Pamargs = publicService
//					.doLoadThisComputerArgs(Param.instance().put("names", "MACHINETAXNR,MACHINENR"), res, dao, ctx);
//			machinetaxnr = StrUtil.null2Str(Pamargs.get("MACHINETAXNR"));
//			machinenr = StrUtil.null2Str(Pamargs.get("MACHINENR"));
//
//			String ZZS_FKFS = "1";
//			if (null != OP_MZXX.get("FKFS")) {
//				ZZS_FKFS = OP_MZXX.get("FKFS") + "";
//			} else if (!"".equals(fffs) && !"null".equals(fffs) && !"0".equals(fffs) && !"1".equals(fffs)) {
//				ZZS_FKFS = fffs;
//			}
//
//			String ZZS_fkfs = "select FKFS as FKFS,FKMC as FKMC  from PUB_FKFS where  SYLX=1 AND  FKFS =  '" + ZZS_FKFS
//					+ "'";
//			List<Map<String, Object>> fkfslist = dao.doSqlQuery(ZZS_fkfs, null);
//			String ZZS_brxzsql = "SELECT t.sjxz as SJXZ FROM PUB_BRXZ t where brxz = '" + OP_MZXX.get("BRXZ") + "'";
//			List<Map<String, Object>> sjxzList = dao.doSqlQuery(ZZS_brxzsql, null);
//			String SJXZ = sjxzList.get(0).get("SJXZ") + "";
//			if ("1000".equals(SJXZ)) {
//
//			}
//			String ZZS_KSMC = "";
//			String ZZS_JHHM = "";
//			String ZZS_JLCH = "";
//			String ZZS_MZHM = "";
//			String ZZS_JZHM = "";
//			String ZZS_BZ2 = "";
//			DecimalFormat df = new DecimalFormat("#.00");
//			ZZS_JZHM = "单据号:" + OP_MZXX.get("FPHM") + "";
//
//			// if(!"0.00".equals(OP_MZXX.get("XJJE")+"")){
//			if ("1000".equals(SJXZ)) {
//				ZZS_BZ2 += "" + fkfslist.get(0).get("FKMC") + ":" + df.format(OP_MZXX.get("XJJE")) + "元";
//			}
//			if (!"0.0".equals(OP_MZXX.get("JMJE") + "")) {
//				ZZS_BZ2 += ",减免:" + df.format(OP_MZXX.get("JMJE")) + "元";
//			}
//
//			/************************************************/
//			for (Map<String, Object> detail : datas) {
//				Map<String, Object> invoiceInfo = new HashMap<String, Object>(16);
//				invoiceInfo.put("InvKind", 2);// 发票类型 0：增值税专用发票，2：增值税普通发票
//				invoiceInfo.put("DocumentNr", OP_MZXX.get("FPHM"));// 单据号
//				invoiceInfo.put("DocumentDate", new Date());// 单据日期
//				invoiceInfo.put("CustomerName", StrUtil.null2Str(OP_MZXX.get("BRXM")) + "     "
//						+ StrUtil.null2Str(map_brxz.get("XZMC")) + "     卡号: " + StrUtil.null2Str(OP_MZXX.get("JZKH")));// 客户名称
//				invoiceInfo.put("CustomerTaxNr", "");// 客户税号
//				invoiceInfo.put("CustomerAddressTel", "  ");// 客户地址电话
//				// invoiceInfo.put("CustomerBankAccountNr", "");//客户银行帐号
//				invoiceInfo.put("CustomerBankAccountNr", ZZS_JZHM);// 客户银行帐号
//				invoiceInfo.put("Invoicer", "");// 开票人
//				invoiceInfo.put("Checker", "");// 复核人
//				invoiceInfo.put("Payee", Payee);// 收款人
//
//				String msg = detail.get("YPMC") + "";
//				int msg_len = msg.length();
//				if (msg.length() > 15) {
//					msg_len = 15;
//				}
//				invoiceInfo.put("ProductName", msg.substring(0, msg_len));// 商品名称
//
//				// invoiceInfo.put("ProductName", detail.get("YPMC"));//商品名称
//				invoiceInfo.put("ProductUnit", detail.get("YFDW"));// 商品计量单位
//				invoiceInfo.put("ProductSpec", detail.get("YFGG"));// 商品规格
//				invoiceInfo.put("ProductQuantity", detail.get("YPSL"));// 商品数量
//				if (Double.parseDouble(detail.get("ZFBL").toString()) > 1) {
//					invoiceInfo.put("ProductValue", Double.parseDouble(detail.get("YPDJ").toString())
//							* Double.parseDouble(detail.get("ZFBL").toString()));// 商品价格
//					// invoiceInfo.put("ProductAmount",
//					// Double.parseDouble(detail.get("YPDJ").toString())*Double.parseDouble(detail.get("ZFBL").toString())*Double.parseDouble(detail.get("YPSL").toString()));//商品金额
//					invoiceInfo.put("ProductAmount",
//							Double.parseDouble(detail.get("YPDJ").toString())
//									* Double.parseDouble(detail.get("ZFBL").toString())
//									* Double.parseDouble(detail.get("YPSL").toString())
//									* Double.parseDouble(detail.get("CFTS").toString()));// 商品金额
//
//				} else {
//					invoiceInfo.put("ProductValue", detail.get("YPDJ"));// 商品价格
//					invoiceInfo.put("ProductAmount", detail.get("HJJE"));// 商品金额
//				}
//
//				invoiceInfo.put("TaxRate", 0);// 税率
//				invoiceInfo.put("ProductTax", 0);// 商品税额
//				invoiceInfo.put("DiscountValue", 0);// 折扣金额
//				invoiceInfo.put("DiscountTax", 0);// 折扣税额
//				invoiceInfo.put("MachineNr", "");// 开票机号
//				invoiceInfo.put("TaxItem", "");// 明细税目
//				invoiceInfo.put("GoodsNoVer", "30.0");// 编码版本号
//				invoiceInfo.put("GoodsTaxNo", "3070202");// 税收分类编码
//				invoiceInfo.put("TaxPre", "1");// 是否享受优惠政策
//				invoiceInfo.put("TaxPreCon", "免税");// 享受税收优惠政策内容
//				invoiceInfo.put("ZeroTax", "1");// 零税率标识
//				invoiceInfo.put("TaxDeduction", 0);// 扣除额
//				invoiceInfo.put("AlternateKey", "");// 备用关键字
//
//				if (null != body.get("ALTERNATEKEY_ZZJ")) {// 自助机传入备注信息
//					invoiceInfo.put("AlternateKey", body.get("ALTERNATEKEY_ZZJ") + "");// 备用关键字
//
//				}
//
//				invoiceInfo.put("ZZSBZXX", ZZS_BZ2);// 备用关键字2
//				StringBuffer invoiceSql = new StringBuffer();
//				invoiceSql.append(
//						"insert into Tbl_Cust_DocMaster (InvKind,DocumentNr,DocumentDate,CustomerName,CustomerTaxNr,CustomerAddressTel,CustomerBankAccountNr,Invoicer,Checker,Payee,ProductName,ProductSpec,ProductUnit,");
//				invoiceSql.append(
//						"ProductQuantity,ProductValue,ProductAmount,TaxRate,ProductTax,DiscountValue,DiscountTax,MachineNr,TaxItem,GoodsNoVer,GoodsTaxNo,TaxPre,TaxPreCon,ZeroTax,TaxDeduction,AlternateKey");
//				invoiceSql.append(",ZZSBZXX");// ---------------
//				invoiceSql.append(")");
//				invoiceSql.append(" values (");
//				invoiceSql.append(
//						":InvKind,:DocumentNr,:DocumentDate,:CustomerName,:CustomerTaxNr,:CustomerAddressTel,:CustomerBankAccountNr,:Invoicer,:Checker,:Payee,:ProductName,:ProductSpec,:ProductUnit,");
//				invoiceSql.append(
//						":ProductQuantity,:ProductValue,:ProductAmount,:TaxRate,:ProductTax,:DiscountValue,:DiscountTax,:MachineNr,:TaxItem,:GoodsNoVer,:GoodsTaxNo,:TaxPre,:TaxPreCon,:ZeroTax,:TaxDeduction,:AlternateKey");
//				invoiceSql.append(",:ZZSBZXX");// ---------------
//				invoiceSql.append(")");
//				// dao.doSqlUpdate(invoiceSql.toString(), invoiceInfo);
//
//				if (0.0 != Double.parseDouble(invoiceInfo.get("ProductValue") + "")) {
//					dao.doSqlUpdate(invoiceSql.toString(), invoiceInfo);
//
//				}
//
//			}
//		}

	}

	private static final Object XNFPXLOBJ = new Object();

	/**
	 * 获取虚拟发票号
	 *
	 * @param jgid
	 * @return
	 */
	public String doGetXnfpxl(Integer jgid) {
		synchronized (XNFPXLOBJ) {// 同步
			long xnfpxl = 1;
			String csz = sysXtcsCacheSer.getCsz(jgid, "XNFPXL");
			if (csz != null) {
				xnfpxl = Long.parseLong(csz);
				Map<String, Object> map = new HashMap<String, Object>(16);
				map.put("CSZ", String.valueOf(xnfpxl + 1));
				map.put("JGID", jgid);
				SysXtcs xtcs = BeanUtil.fillBeanWithMapIgnoreCase(map, new SysXtcs(), true);
				sysXtcsSer.updateCsz(xtcs);
			} else {
				Map<String, Object> parameter = new HashMap<String, Object>(16);
				parameter.put("CSZ", String.valueOf(xnfpxl + 1));
				parameter.put("JGID", jgid);
				parameter.put("CSMC", "XNFPXL");
				parameter.put("BZ", "虚拟发票序列");
				SysXtcs xtcs = BeanUtil.fillBeanWithMapIgnoreCase(parameter, new SysXtcs(), true);
				sysXtcsSer.insert(xtcs);
			}
			return "MS" + xnfpxl;
		}
	}

	/**
	 * 收费预保存
	 *
	 * @param req
	 * @param res
	 * @param jgid
	 * @param ygdm
	 * @param request
	 */
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public void doSaveSettle(Map<String, Object> req, Map<String, Object> res, OutpatientSettlementReq request) {
		List<Map<String, Object>> datas = (List<Map<String, Object>>) req.get("body");
		List<Map<String, Object>> reData = new ArrayList<Map<String, Object>>();
		List<Object> cfsbList = new ArrayList<Object>();
		Map<String, Object> mzxx = MzUtil.caseInsensitiveMap(request.getMzxxReq());
		List<RemoveSettleReq> removeCfsbList = request.getMzxxReq().getRemoveCfsb();

		if (request.getMzxxReq().getRemoveData().size() > 0) {
			Map<String, Object> removeData = new HashMap<String, Object>(16);
			removeData.put("body", request.getMzxxReq().getRemoveData());
			doRemoveSettle(removeData, res, request.getJgid());
			cfsbList.addAll(removeCfsbList);
		}
		long cfsb = 0;
		List<Map<String, Object>> djs = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < datas.size(); i++) {
			Map<String, Object> result = datas.get(i);
			Map<String, Object> data = new CaseInsensitiveMap<String, Object>(result);
			int fygb = Integer.parseInt(data.get("FYGB") + "");
			if (!"6".equals(data.get("DJLY") + "")) {
				Map<String, Object> dj = new HashMap<String, Object>(16);
				dj.put("CFLX", data.get("CFLX"));
				dj.put("CFSB", Long.parseLong(data.get("CFSB") + ""));
				djs.add(dj);
				reData.add(data);
				continue;
			}
			String op = "create";
			if (data.get("CFSB") != null) {
				op = "update";
				cfsb = Long.parseLong(data.get("CFSB") + "");
				data.put("SBXH", data.get("SBXH"));
				data.put("YJXH", data.get("CFSB"));
			}
			if ("0".equals(data.get("CFLX") + "")) {
				data.put("YJZX", 0);
				if (data.get("CFNEW") != null && (data.get("CFNEW") + "").length() > 0) {
					data.put("KDRQ", DateUtil.date().toTimestamp());
					data.put("ZFPB", 0);
					data.put("ZXPB", 0);
					data.put("CFBZ", 0);
					data.put("DJZT", 0);
					data.put("JGID", request.getJgid());
					data.put("JZXH", 0);
					data.put("DJLY", 6);
					data.put("YJZX", 1);
					data.put("HJGH", request.getYgdm());
					data.put("BRID", mzxx.get("BRID"));
					data.put("BRXM", mzxx.get("BRXM"));
					data.put("JZKH", mzxx.get("JZKH"));
					data.put("JZLSH", mzxx.get("JZLSH") != null ? mzxx.get("JZLSH").toString() : "0");

					OpYjcf01 opYjcf01 = BeanUtil.fillBeanWithMapIgnoreCase(data, new OpYjcf01(), true);
					if ("create".equals(op)) {
						opYjcf01.setYjxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJCF01));
						opYjcf01Dao.insert(opYjcf01);
					} else if ("update".equals(op)) {
						opYjcf01Dao.updateBySaveSettle(opYjcf01);
					}

					Map<String, Object> yj01 = MzUtil.caseInsensitiveMap(opYjcf01);
					String sfbxgh = sysXtcsCacheSer.getCsz(request.getJgid(), "SFBJZJL");
					if ("1".equals(sfbxgh)) {
						this.doSaveMsJzls(op, data, mzxx, request.getJgid());
					}
					Map<String, Object> dj = new HashMap<String, Object>(16);
					if ("update".equals(op)) {
						cfsb = Long.parseLong(data.get("YJXH") + "");
					} else {
						cfsb = Long.parseLong(yj01.get("YJXH") + "");
						data.put("CFSB", cfsb);
					}
					dj.put("CFLX", data.get("CFLX"));
					dj.put("CFSB", cfsb);
					djs.add(dj);
				}
				data.put("YJZH", data.get("ypzhShow"));
				data.put("JGID", request.getJgid());
				data.put("YJXH", cfsb);
				data.put("YLXH", data.get("YPXH"));
				data.put("YLDJ", data.get("YPDJ"));
				data.put("YLSL", data.get("YPSL"));
				data.put("DZBL", 1);
				data.put("XMLX", data.get("CFLX"));
				data.put("FYGB", mzUtil.getfygb(Integer.valueOf(data.get("CFLX") + ""), Integer.valueOf(data.get("YPXH") + "")));
				data.put("JZLSH", mzxx.get("JZLSH") != null ? mzxx.get("JZLSH").toString() : "0");

				OpYjcf02 opYjcf02 = BeanUtil.fillBeanWithMapIgnoreCase(data, new OpYjcf02(), true);

				if ("create".equals(op)) {
					opYjcf02.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJCF02));
					opYjcf02Dao.insert(opYjcf02);
				} else if ("update".equals(op)) {
					opYjcf02Dao.updateBySaveSettle(opYjcf02);
				}
				Map<String, Object> yj02 = MzUtil.caseInsensitiveMap(opYjcf02);

				if (!"update".equals(op)) {
					data.put("SBXH", yj02.get("SBXH"));
					int wpjfbz = Integer.parseInt(sysXtcsCacheSer.getCsz(request.getJgid(), "MZWPJFBZ"));
					int wzsfxmjg = Integer.parseInt(sysXtcsCacheSer.getCsz(request.getJgid(), "WZSFXMJG"));

//					if (wzsfxmjg == 1 && wpjfbz == 1) {
//						doSaveSupplies(Integer.valueOf(yj02.get("SBXH") + ""), Integer.valueOf(data.get("KSDM") + ""),
//								request.getJgid());
//					}
				}
				data.put("CFSB", cfsb);
			} else {
				if (data.get("CFNEW") != null && (data.get("CFNEW") + "").length() > 0) {
					String sjjg = null;
					long sjyf = 0;

					PharBaseInfoReq yflb = pharBaseConfigService.getById(Integer.valueOf(data.get("YFSB") + ""));

					Map<String, Object> mapYfxx = MzUtil.caseInsensitiveMap(yflb);

					if (mapYfxx.get("SJJG") != null && !"".equals(mapYfxx.get("SJJG"))) {
						sjjg = mapYfxx.get("SJJG") + "";
					}
					if (mapYfxx.get("SJYF") != null && !"".equals(mapYfxx.get("SJYF"))
							&& Long.parseLong(mapYfxx.get("SJYF") + "") != 0) {
						sjyf = Long.parseLong(mapYfxx.get("SJYF") + "");
					}
					if (sjyf != 0 && sjjg != null) {
						data.put("SJJG", sjjg);
						data.put("SJYF", sjyf);
						data.put("SJFYBZ", 1);
					}
					data.put("JGID", request.getJgid());
					data.put("PYBZ", 0);
					data.put("TYBZ", 0);
					data.put("KFRQ", DateUtil.date().toTimestamp());
					data.put("FYBZ", 0);
					data.put("ZFPB", 0);
					data.put("YXPB", 0);
					data.put("DJYBZ", 0);
					data.put("BRID", mzxx.get("BRID"));
					data.put("BRXM", mzxx.get("BRXM"));
					data.put("JZKH", mzxx.get("JZKH"));
					data.put("JZLSH", mzxx.get("JZLSH") != null ? mzxx.get("JZLSH").toString() : "0");
					// 获取主键值
					if (data.get("CFSB") != null) {
						data.put("CFHM", data.get("CFSB"));
					} else {
//						Schema sc = SchemaController.instance().get(BSPHISEntryNames.OP_CF01);
//						List<SchemaItem> items = sc.getItems();
//						SchemaItem item = null;
//						for (SchemaItem sit : items) {
//							if ("CFSB".equals(sit.getId())) {
//								item = sit;
//								break;
//							}
//						}
//						Long pkey = Long
//								.parseLong(KeyManager.getKeyByName("OP_CF01", item.getKeyRules(), item.getId(), ctx));
						Integer pkey = redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CF01);
						data.put("CFSB", pkey);
						data.put("CFHM", pkey);
					}

					OpCf01 opCf01 = BeanUtil.fillBeanWithMapIgnoreCase(data, new OpCf01(), true);
					if ("create".equals(op)) {
//						opCf01.setCfsb(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CF01));
						opCf01Dao.insert(opCf01);
					} else if ("update".equals(op)) {
						opCf01Dao.updateBySaveSettle(opCf01);
					}

					String sfbxgh = sysXtcsCacheSer.getCsz(request.getJgid(), "SFBJZJL");

					if ("1".equals(sfbxgh)) {
						this.doSaveMsJzls(op, data, mzxx, request.getJgid());
					}

					Map<String, Object> dj = new HashMap<String, Object>(16);
					cfsb = Long.parseLong(data.get("CFSB") + "");
					data.put("CFSB", cfsb);
					dj.put("CFLX", data.get("CFLX"));
					dj.put("CFSB", cfsb);
					cfsbList.add(cfsb);
					djs.add(dj);
				}
				data.put("YPZH", data.get("ypzhShow"));

				// 判断库存是否足够
				Map<String, Object> dataMsg = new HashMap<String, Object>(16);
				dataMsg.put("pharmId", data.get("YFSB"));
				dataMsg.put("medId", data.get("YPXH"));
				dataMsg.put("medsource", data.get("YPCD"));
				if (data.get("CFLX").toString().equals("3")) {
					data.put("YYTS", 1);
					dataMsg.put("quantity",
							Double.parseDouble(data.get("YPSL").toString()) * (Integer) data.get("CFTS"));
				} else {
					dataMsg.put("quantity", data.get("YPSL"));
				}
				if (Integer.parseInt(data.get("YPXH") + "") != 0) {
					dataMsg.put("lsjg", data.get("YPDJ"));
					dataMsg.put("jlxh", data.get("SBXH"));
					Map<String, Object> inventory = mzUtil.checkInventory(dataMsg, request.getJgid());
					if ((Integer) inventory.get("sign") == -1) {
						throw BaseException.create("ERROR_REG_0032", new String[] { data.get("YPMC").toString(),
								inventory.get("KCZL").toString(), dataMsg.get("quantity").toString() });
					}
				}

				data.put("JGID", request.getJgid());
				data.put("CFSB", cfsb);
				data.put("XMLX", data.get("CFLX"));
				data.put("YCSL", "0");
				data.put("FYGB", mzUtil.getfygb(Integer.valueOf(data.get("CFLX") + ""),
						Integer.valueOf(data.get("YPXH") + "")));
				data.put("JZLSH", mzxx.get("JZLSH") != null ? mzxx.get("JZLSH").toString() : "0");
				Object ypzs = (data.get("YPZS"));
				if (ypzs == null || ypzs.toString().equals("0")) {
					data.put("YPZS", null);
				}
				if (!data.containsKey("ZFYP")) {
					data.put("ZFYP", 0);
				}

				OpCf02 opCf02 = BeanUtil.fillBeanWithMapIgnoreCase(data, new OpCf02(), true);

				if ("create".equals(op)) {
					opCf02.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CF02));
					opCf02Dao.insert(opCf02);
				} else if ("update".equals(op)) {
					opCf02Dao.updateBySaveSettle(opCf02);
				}

				Map<String, Object> cf02 = MzUtil.caseInsensitiveMap(opCf02);

				if (!"update".equals(op)) {
					data.put("SBXH", cf02.get("SBXH"));
				}
				data.put("CFSB", cfsb);

			}
			data.put("FYGB", fygb);
			reData.add(data);
		}

		// 库存冻结代码
		int sfqyyfyfy = Integer.parseInt(sysXtcsCacheSer.getCsz(request.getJgid(), "SFQYYFYFY"));
		int mzkcdjsj = Integer.parseInt(sysXtcsCacheSer.getCsz(request.getJgid(), "MZKCDJSJ"));

		if (sfqyyfyfy == 1 && mzkcdjsj == 1) {// 如果启用库存冻结,并且在开单时冻结
			// 先删除过期的冻结库存
			// MedicineCommonModel model = new MedicineCommonModel(dao);
			// model.deleteKCDJ(manaUnitId, ctx);
			// 先删除对应CFSB的冻结记录
			for (int i = 0; i < cfsbList.size(); i++) {
				long djcfsb = Long.parseLong(cfsbList.get(i) + "");
				drugService.deleteKcdjByCfsbAndDjlb(Integer.valueOf(String.valueOf(djcfsb)), 1);
				for (Map<String, Object> mapCf02 : reData) {
					if (djcfsb == Long.parseLong(mapCf02.get("CFSB") + "")) {
						Map<String, Object> mapKcdj = new HashMap<String, Object>(16);
						mapKcdj.put("JGID", request.getJgid());
						mapKcdj.put("YFSB", ObjectToTypes.parseLong(mapCf02.get("YFSB")));
						mapKcdj.put("CFSB", ObjectToTypes.parseLong(mapCf02.get("CFSB")));
						mapKcdj.put("YPXH", ObjectToTypes.parseLong(mapCf02.get("YPXH")));
						mapKcdj.put("YPCD", ObjectToTypes.parseLong(mapCf02.get("YPCD")));
						mapKcdj.put("YPSL", MzUtil.simpleMultiply(2, mapCf02.get("YPSL"), mapCf02.get("CFTS")));
						mapKcdj.put("YFBZ", ObjectToTypes.parseInt(mapCf02.get("YFBZ")));
						mapKcdj.put("DJSJ", DateUtil.date().toTimestamp());
						mapKcdj.put("JLXH", ObjectToTypes.parseLong(mapCf02.get("SBXH")));
						mapKcdj.put("DJLB", 1);
						mapKcdj.put("LSJG", ObjectToTypes.parseDouble(mapCf02.get("YPDJ")));

						PharKcdjReq pharKcdj = BeanUtil.fillBeanWithMapIgnoreCase(mapKcdj, new PharKcdjReq(), true);
						pharKcdj.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.PHAR_KCDJ));
						drugService.insertKcdj(pharKcdj);
					}
				}
			}
//			Session ss = (Session) ctx.get(Context.DB_SESSION);
//			ss.flush();
		}
		res.put("djs", djs);
		res.put("data", reData);
		// add by caijy for 更新挂号表的诊断序号
		if (mzxx.containsKey("ZDXH") && ObjectToTypes.parseLong(mzxx.get("ZDXH")) != 0 && mzxx.containsKey("GHGL")
				&& ObjectToTypes.parseLong(mzxx.get("GHGL")) != 0) {
			Map<String, Object> mapPar = new HashMap<String, Object>(16);
			mapPar.put("zdxh", ObjectToTypes.parseLong(mzxx.get("ZDXH")));
			mapPar.put("ghgl", ObjectToTypes.parseLong(mzxx.get("GHGL")));
			opGhmxDao.updateZdxhBySbxh(mapPar);
		}
	}

	/**
	 * 收费删除
	 *
	 * @param req
	 * @param res
	 * @param ctx
	 */
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public void doRemoveSettle(Map<String, Object> req, Map<String, Object> res, Integer jgid) {
		List<RemoveSettleReq> data = (List<RemoveSettleReq>) req.get("body");
		List<Map<String, Object>> bodys = MzUtil.ListObjToMap(data);
		Map<String, Object> parameters = new HashMap<String, Object>(16);
		for (int i = 0; i < bodys.size(); i++) {
			Map<String, Object> body = bodys.get(i);
			if ("0".equals(body.get("CFLX") + "")) {
				parameters.clear();
				parameters.put("YJXH", Long.parseLong(body.get("CFSB") + ""));
				long count = opYjcf02Dao.getCountByYjxh(parameters);
				if (count > 1) {
					parameters.clear();
					parameters.put("SBXH", Integer.valueOf(body.get("SBXH").toString()));
					opYjcf02Dao.deleteBySbxh(parameters);
					mzUtil.deleteSupplies(jgid, Integer.valueOf(body.get("SBXH").toString()));
				} else {
					parameters.clear();
					parameters.put("SBXH", Integer.valueOf(body.get("SBXH").toString()));
					opYjcf02Dao.deleteBySbxh(parameters);
					mzUtil.deleteSupplies(jgid, Integer.valueOf(body.get("SBXH").toString()));
					parameters.put("YJXH", Integer.valueOf(body.get("CFSB").toString()));
					opYjcf01Dao.deleteByYjxh(parameters);
				}
			} else {
				parameters.clear();
				parameters.put("CFSB", Long.parseLong(body.get("CFSB") + ""));
				long count = opCf02Dao.getCountByCfsb(parameters);
				if (count > 1) {
					parameters.clear();
					parameters.put("SBXH", Integer.valueOf(body.get("SBXH").toString()));
					opCf02Dao.deleteBySbxh(parameters);
				} else {
					parameters.clear();
					parameters.put("SBXH", Integer.valueOf(body.get("SBXH").toString()));
					opCf02Dao.deleteBySbxh(parameters);
					parameters.put("CFSB", Integer.valueOf(body.get("CFSB").toString()));
					opCf01Dao.deleteByCfsb(parameters);
				}
			}
		}
	}

	/**
	 * 更新就诊历史
	 *
	 * @param op
	 * @param cfxx
	 * @param mzxx
	 * @param jgid
	 */
	@Transactional(rollbackFor = Exception.class)
	private void doSaveMsJzls(String op, Map<String, Object> cfxx, Map<String, Object> mzxx, Integer jgid) {
		Map<String, Object> jzls = new HashMap<String, Object>(16);
		jzls.clear();
		jzls.put("GHXH", mzxx.get("GHGL"));
		jzls.put("BRBH", mzxx.get("BRID"));
		jzls.put("KSDM", cfxx.get("KSDM"));
		jzls.put("YSDM", cfxx.get("YSDM"));
		jzls.put("KSSJ", DateUtil.date().toTimestamp());
		jzls.put("JSSJ", DateUtil.date().toTimestamp());
		jzls.put("JZZT", 9);
		jzls.put("YYXH", null);
		jzls.put("FZRQ", null);
		jzls.put("GHFZ", null);
		jzls.put("JGID", cfxx.get("JGID"));
		jzls.put("SFDY", 1);
		jzls.put("JZLSH", mzxx.get("JZLSH") != null ? mzxx.get("JZLSH").toString() : "0");

		Map<String, Object> pmap = new HashMap<String, Object>(16);
		pmap.put("GHXH", Long.parseLong(jzls.get("GHXH").toString()));
		pmap.put("BRBH", Long.parseLong(jzls.get("BRBH").toString()));

		Map<String, Object> jzls2 = opYsJzlsDao.getJzxhInfo(pmap);
		if (jzls2 != null && jzls2.get("JZXH") != null) {
			jzls.put("GHXH", Long.parseLong(jzls.get("GHXH").toString()));
			jzls.put("BRBH", mzxx.get("BRID"));
			jzls.put("KSDM", cfxx.get("KSDM"));
			jzls.put("YSDM", cfxx.get("YSDM"));
			jzls.put("KSSJ", DateUtil.date().toTimestamp());
			jzls.put("JSSJ", DateUtil.date().toTimestamp());
			jzls.put("JZZT", 9);
			jzls.put("YYXH", null);
			jzls.put("FZRQ", null);
			jzls.put("GHFZ", null);
			jzls.put("JGID", cfxx.get("JGID"));
			jzls.put("SFDY", 1);
			jzls.put("JZXH", Long.parseLong(jzls.get("JZXH").toString()));

			OpYsJzls opYsJzls = BeanUtil.fillBeanWithMapIgnoreCase(jzls, new OpYsJzls(), true);
			opYsJzls.setJzxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YS_JZLS));
			opYsJzlsDao.insert(opYsJzls);

		} else {
			OpYsJzls opYsJzls = BeanUtil.fillBeanWithMapIgnoreCase(jzls, new OpYsJzls(), true);
			opYsJzls.setJzxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YS_JZLS));
			opYsJzlsDao.insert(opYsJzls);
		}
		opGhmxDao.updateJzztByCondition(pmap);
	}

	/**
	 * 根据处置开的项目去取对应的价格并插入到物资库存表
	 *
	 * @param sbxhs
	 * @param ksdm
	 * @param jgid
	 */
	public void doSaveSupplies(Integer sbxhs, Integer ksdm, Integer jgid) {
		Map<String, Object> parameters = new HashMap<String, Object>(16);
		Map<String, Object> parameterskfxh = new HashMap<String, Object>(16);
		// 根据sbxh取到该条项目的所有信息
		parameters.put("SBXH", sbxhs);
		parameters.put("JGID", jgid);
		Map<String, Object> lisFyxx = opYjcf02Dao.getYj02Info(parameters);

		DicKszd dicKszd = dicKszdOutSer.getById(ksdm);
		String ksmc = dicKszd.getOfficename();

		parameterskfxh.put("ejkf", ksdm);
		Map<String, Object> kfxhMap = wlKfdzDao.findKfxh(parameterskfxh);

		int kfxh = 0;
		if (kfxhMap != null) {
			if (kfxhMap.get("KFXH") != null) {
				kfxh = Integer.parseInt(kfxhMap.get("KFXH") + "");
			}
		} else {
			throw BaseException.create("ERROR_REG_0031");
		}
		if (lisFyxx != null) {
			double czsl = Double.parseDouble(lisFyxx.get("CZSL") + "");
			Long sbxh = Long.parseLong(lisFyxx.get("SBXH") + "");
			Long fyxh = Long.parseLong(lisFyxx.get("FYXH") + "");
			Long brid = Long.parseLong(lisFyxx.get("BRID") + "");
			int jgbz = 0;
			if (lisFyxx.get("JGBZ") != null) {
				jgbz = Integer.parseInt(lisFyxx.get("JGBZ") + "");
			}
			double bzjg = 0;
			if (lisFyxx.get("BZJG") != null) {
				bzjg = Double.parseDouble(lisFyxx.get("BZJG") + "");
			}
			String brxm = lisFyxx.get("BRXM") + "";
			String jgid2 = lisFyxx.get("JGID") + "";
			setSuppliesJg(sbxh, fyxh, kfxh, czsl, brid, "1", ksdm, brxm, ksmc, -2, jgid2, jgbz, bzjg, null);
		}
	}

	/**
	 * 根据处置开的项目去取对应的价格本计算金额
	 *
	 * @param sbxh
	 * @param fyxh
	 * @param kfxh
	 * @param czsl
	 * @param brid
	 * @param brly
	 * @param ksdm
	 * @param brxm
	 * @param ksmc
	 * @param ztbz
	 * @param jgid
	 * @param jgbz
	 * @param bzjg
	 * @param zyhm
	 */
	@Transactional(rollbackFor = Exception.class)
	public void setSuppliesJg(Long sbxh, Long fyxh, int kfxh, double czsl, Long brid, String brly, Integer ksdm,
			String brxm, String ksmc, int ztbz, String jgid, int jgbz, double bzjg, String zyhm) {
		Map<String, Object> parameterswzxh = new HashMap<String, Object>(16);
		Map<String, Object> parameterswzjg = new HashMap<String, Object>(16);
		Map<String, Object> parametersupd = new HashMap<String, Object>(16);
		Map<String, Object> parametersykslupd = new HashMap<String, Object>(16);
		parameterswzxh.put("FYXH", fyxh);
		parameterswzxh.put("JGID", jgid);
		parametersupd.put("SBXH", sbxh);

		// 根据fyxh取对应的wzxh
		List<Map<String, Object>> lisWzxh = feeXmzxksDao.findSuppliesInfo(parameterswzxh);

//		double wzjg = 0.00;
//		double czje = 0.00;
		for (int i = 0; i < lisWzxh.size(); i++) {
			double wzslall = czsl * Double.parseDouble(lisWzxh.get(i).get("WZSL") + "");// 取到第一个物资的实际数量
			parameterswzjg.put("WZXH", Long.parseLong(lisWzxh.get(i).get("WZXH") + ""));
			parameterswzjg.put("JGID", jgid);
			parameterswzjg.put("KFXH", kfxh);

			List<Map<String, Object>> lisWzkc = wlWzkcDao.findSuppliesAmount(parameterswzjg);

			for (int j = 0; j < lisWzkc.size(); j++) {// 第一个去做的金额
				double wzsl = Double.parseDouble(lisWzkc.get(j).get("WZSL") + "");
				double yksl = Double.parseDouble(lisWzkc.get(j).get("YKSL") + "");
				long kcxh = Long.parseLong(lisWzkc.get(j).get("KCXH") + "");
				parametersykslupd.put("KCXH", kcxh);
				parametersykslupd.put("KFXH", kfxh);
				parametersykslupd.put("JGID", jgid);
				long wzxhs = Long.parseLong(lisWzkc.get(j).get("WZXH") + "");
				if (wzslall <= (wzsl - yksl)) {
//					if (jgbz == 1) {
//						wzjg = Double.parseDouble(lisWZKC.get(j).get("WZJG") + "");
//					} else {
//						wzjg = bzjg;
//					}
//					czje += wzslall * wzjg;
					parametersykslupd.put("YKSL", yksl + wzslall);

					wlWzkcDao.updateyksl(parametersykslupd);

					Map<String, Object> parametersyxhmxsave = new HashMap<String, Object>(16);
					parametersyxhmxsave.put("BRHM", zyhm);
					parametersyxhmxsave.put("BRXM", brxm);
					parametersyxhmxsave.put("WZSL", wzslall);
					parametersyxhmxsave.put("KSMC", ksmc);
					parametersyxhmxsave.put("BRID", brid);
					parametersyxhmxsave.put("BRLY", brly);
					parametersyxhmxsave.put("XHRQ", DateUtil.date().toTimestamp());
					parametersyxhmxsave.put("KSDM", ksdm);
					parametersyxhmxsave.put("JGID", jgid);
					parametersyxhmxsave.put("KFXH", kfxh);
					parametersyxhmxsave.put("WZXH", wzxhs);
					parametersyxhmxsave.put("ZTBZ", ztbz);
					parametersyxhmxsave.put("MZXH", sbxh);
					parametersyxhmxsave.put("KCXH", kcxh);

					WlXhmx wlxhmx = BeanUtil.fillBeanWithMapIgnoreCase(parametersyxhmxsave, new WlXhmx(), true);
					wlxhmx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.WL_WZKC));

					wlXhmxDao.insert(wlxhmx);
					break;
				} else if (wzslall > (wzsl - yksl)) {
					wzslall = wzslall - (wzsl - yksl);
					parametersykslupd.put("YKSL", yksl + (wzsl - yksl));
					wlWzkcDao.updateyksl(parametersykslupd);
					if ((wzsl - yksl) > 0) {
						Map<String, Object> parametersyxhmxsave = new HashMap<String, Object>(16);
						parametersyxhmxsave.put("BRHM", zyhm);
						parametersyxhmxsave.put("BRXM", brxm);
						parametersyxhmxsave.put("WZSL", (wzsl - yksl));
						parametersyxhmxsave.put("KSMC", ksmc);
						parametersyxhmxsave.put("BRID", brid);
						parametersyxhmxsave.put("BRLY", brly);
						parametersyxhmxsave.put("XHRQ", DateUtil.date().toTimestamp());
						parametersyxhmxsave.put("KSDM", ksdm);
						parametersyxhmxsave.put("JGID", jgid);
						parametersyxhmxsave.put("KFXH", kfxh);
						parametersyxhmxsave.put("WZXH", wzxhs);
						parametersyxhmxsave.put("ZTBZ", ztbz);
						parametersyxhmxsave.put("MZXH", sbxh);
						parametersyxhmxsave.put("KCXH", kcxh);

						WlXhmx wlxhmx = BeanUtil.fillBeanWithMapIgnoreCase(parametersyxhmxsave, new WlXhmx(), true);
						wlxhmx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.WL_WZKC));

						wlXhmxDao.insert(wlxhmx);
					}
				}
			}
		}
	}

	/**
	 * 防止并发问题,此处读写采用synchronized,并且事务分离
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public synchronized String getPharmacyOrderNum() {
//		SessionFactory sf = AppContextHolder.getBean(AppContextHolder.DEFAULT_SESSION_FACTORY, SessionFactory.class);
//		Session ss = null;
//		ss = sf.openSession();

		Map<String, Object> map = new HashMap<String, Object>(16);
		map.put("DQRQ", DateUtil.date().toSqlDate());
		List<Map<String, Object>> l = opSeqDao.getDqxh(map);

		if (l.size() > 0) {
			String dqhm = l.get(0).get("DQXH").toString();
			opSeqDao.updateDqxh(map);
			return dqhm;
		} else {
			OpSeq opSeq = new OpSeq();
			opSeq.setDqrq(map.get("DQRQ").toString());
			opSeq.setDqxh(2);
			opSeqDao.insert(opSeq);
			return "1";
		}
	}

	/**
	 * 获取发票号码
	 *
	 * @param userId
	 * @param hospitalId
	 * @param i
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public String doGetNotesNumber(Integer userId, Integer hospitalId, Integer type) {
		String fphm = opGhksSer.getNotesNumberNotIncrement(userId, hospitalId, type);
		return fphm;
	}

	/**
	 * 收费病人查询
	 *
	 * @return
	 * @throws ParseException
	 */
	public QueryGhmxResp doQueryGhmx(Integer jgid) throws ParseException {
		int adtBegin = 1;
		String klx = sysXtcsCacheSer.getCsz(jgid, "KLX");
		String adtBeginStr = sysXtcsCacheSer.getCsz(jgid, "GHXQ");

		if (adtBeginStr != "") {
			adtBegin = Integer.parseInt(adtBeginStr);
		}
		SimpleDateFormat matter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String xqjsfs = sysXtcsCacheSer.getCsz(jgid, "XQJSFS");
		Date adtBeginData = DateUtils.addDays(new Date(), -adtBegin);
		if ("1".equals(xqjsfs)) {
			adtBeginData = DateUtils.addDays(matter.parse(MzUtil.getDate() + " 23:59:59"), -1);
		}
		Map<String, Object> parameters = new HashMap<String, Object>(16);
		parameters.put("al_jgid", jgid);
		parameters.put("adt_begin", adtBeginData);
		parameters.put("KLX", klx);
		List<Map<String, Object>> listRet = opGhmxDao.getGhmxDetail(parameters);
		Integer count = listRet.size();

		QueryGhmxResp resp = new QueryGhmxResp();
		List<OpGhmxInfoResp> list = MzUtil.ListToResultSet(listRet, new OpGhmxInfoResp());
		resp.setCount(count);
		resp.setResultList(list);
		return resp;
	}

	/**
	 * 预付卡支付信息返回
	 *
	 * @param fphm
	 * @return
	 */
	public GetYfkInfoResp doGetYfkInfoByFphm(String fphm) {
		Map<String, Object> map = new HashMap<String, Object>(16);
		List<GetYfkInfoResp> resultList = new ArrayList<GetYfkInfoResp>();
		GetYfkInfoResp resp = new GetYfkInfoResp();
		map.put("fphm", fphm);
		List<Map<String, Object>> list = opCzjlDao.getAmount(map);
		if (list.size() > 0) {
			resultList = MzUtil.ListToResultSet(list, new GetYfkInfoResp());
			resp = resultList.get(0);
		}
		return resp;
	}

	/**
	 * 发票作废 发票查询
	 *
	 * @param fphm
	 * @return
	 */
	public ZfQueryFphmResp doQueryFphm(String fphm, Integer jgid) {
		ZfQueryFphmResp resp = new ZfQueryFphmResp();
		Map<String, Object> parameters = new HashMap<String, Object>(16);
		parameters.put("FPHM", fphm);
		parameters.put("JGID", jgid);

		OpMzxx opMzxx = opMzxxDao.getByFphm(fphm);

		if(Objects.isNull(opMzxx)){
			throw BaseException.create("ERROR_REG_0099");
		}
		if(Objects.nonNull(opMzxx.getCdfphm())){
			parameters.replace("FPHM", opMzxxDao.getByFphm(opMzxx.getCdfphm()).getFphm());
			resp.setCdpb(1);
		}else {
			resp.setCdpb(0);
		}
		String klx = sysXtcsCacheSer.getCsz(jgid, "KLX");

		List<Map<String, Object>> djs = new ArrayList<Map<String, Object>>();

		List<Map<String, Object>> persons = opMzxxDao.getFpzfInfo(parameters);

		Map<String, Object> person = null;
		if (persons.size() > 0) {
			person = persons.get(0);
		}

		resp.setIsYb(0);
		if (person != null && person.get("CSNY") != null) {
			person.put("AGE", MzUtil.getPersonAge((Date) person.get("CSNY"), null).get("ages"));
//				Map<String, Object> MPI_Cardparameters = new HashMap<String, Object>(16);
//				MPI_Cardparameters.put("EMPIID", person.get("EMPIID"));
//				Map<String, Object> MPI_Card = null;
//				try {
//					MPI_Card = dao.doLoad(
//							"select a.cardNo as cardNo from MPI_Card a where a.cardTypeCode="
//									+ KLX + " and a.empiId=:EMPIID",
//							MPI_Cardparameters);
//				} catch (Exception e) {
//					// add by yangl 增加异常处理,防止因为档案问题导致退费失败
//					logger.error("查询病人档案错误,无法正确关联到卡号", e);
//				}
//				if (MPI_Card != null) {
//					person.put("JZKH", MPI_Card.get("cardNo"));
//				}

			Integer sjxz = querySjBrxz(Integer.parseInt(String.valueOf(person.get("BRXZ"))));
			if(6021 == sjxz){
				resp.setIsYb(1);
			}
		}
		parameters.remove("JGID");
		List<Map<String, Object>> cfsbs = opCf01Dao.getByFphm(parameters);
		List<Map<String, Object>> yjxhs = opYjcf01Dao.getByFphm(parameters);

		djs.addAll(cfsbs);
		djs.addAll(yjxhs);


		FpzfBrdaResp fpzfBrdaResp = BeanUtil.fillBeanWithMapIgnoreCase(person, new FpzfBrdaResp(), true);
		List<CfInfoResp> list = MzUtil.ListToResultSet(djs, new CfInfoResp());
		resp.setFpzfBrdaResp(fpzfBrdaResp);
		resp.setResultList(list);
		return resp;
	}

	/**
	 * 发票作废
	 *
	 * @param req
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doUpdateVoidInvoice(UpdateVoidInvoiceReq req) {
		Map<String, Object> body = MzUtil.caseInsensitiveMap(req);
		String fphm = body.get("FPHM") + "";
//		String nocommit = body.get("nocommit") + "";

//		int wpjfbz = Integer.parseInt(sysXtcsCacheSer.getCsz(req.getJgid(), "MZWPJFBZ"));
//		int wzsfxmjg = Integer.parseInt(sysXtcsCacheSer.getCsz(req.getJgid(), "WZSFXMJG"));

		Map<String, Object> parameters = new HashMap<String, Object>(16);
		parameters.put("FPHM", fphm);
		parameters.put("JGID", req.getJgid());

		Map<String, Object> mzxxMap = opMzxxDao.getMzxxByCondition(parameters);
		if (1 == Integer.parseInt(mzxxMap.get("ZFPB") + "")) {
			throw BaseException.create("ERROR_REG_0037");
		}
		parameters.remove("FPHM");
		parameters.put("MZXH", mzxxMap.get("MZXH"));
		parameters.put("ZXPB", 1);

		long llFound = opYjcf01Dao.getCountByCondition(parameters);
		if (llFound > 0) {
			throw BaseException.create("ERROR_REG_0038");
		}
		parameters.put("FYBZ", 1);
		llFound = 0;
		llFound = opCf01Dao.getCountByCondition(parameters);
		if (llFound > 0) {
			throw BaseException.create("ERROR_REG_0039");
		}
//		parameters.remove("FYBZ");
//		parameters.put("FYBZ", 3);
//		llFound = opCf01Dao.getCountByCondition(parameters);
//		if (llFound > 0) {
//			throw BaseException.create("ERROR_REG_0040");
//		}

		// 未日结的POS机退费只能到收费时的pos退费
//		try {
//			PosService ps = new PosService();
//			ps.beforeRetire(res, ctx, dao, fphm);
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			res.put("msg", e.getMessage());
//			return;
//		}
		// 未日结的POS机退费只能到收费时的pos退费

//		if ("true".equals(nocommit)) // 仅用作校验
//			return;

		// 医保作废
		if (req.getIsYb().intValue() == 1) {
			// 获取医保总金额
			Map<String, Object> Yb_Totex = new HashMap<String, Object>();
			Yb_Totex.put("ywlx", "2");
			Yb_Totex.put("sbxh", mzxxMap.get("MZXH"));
			Map<String, Object> feeMap = medicalInsuranceService.queryMedicalInsuranceTranInfo(Yb_Totex);
			Map<String, Object> map = new HashMap<String, Object>();
			String orgid = "";
			Map map_orgid = opMzlbDao.getYbjgdm(req.getJgid(), req.getIp());
			if (map_orgid != null && !map_orgid.isEmpty()) {
				orgid = map_orgid.get("ybjgid").toString();
			} else {
				throw BaseException.create("ERROR_SHYB_0015");
			}
			String carddata = req.getCarddata();
			String cardtype = req.getCardtype();
			map.put("carddata", carddata);
			map.put("cardtype", cardtype);
			map.put("orgid", orgid);
			map.put("xsywlx", "");
			map.put("jyqd", "10");
			map.put("ip", req.getIp());
			map.put("jgid", req.getJgid());
			map.put("ygdm", req.getYgdm());
			map.put("ygxm", req.getYgxm());
			map.put("sbxh",mzxxMap.get("MZXH"));
			SettleResultDTO result = new SettleResultDTO();
			result = unifiedBusinessService.sk01(map, feeMap);
			if (result.getCode() == 200 && StringUtils.isNotBlank(StrUtil.null2Str(result.getData()))) {
				String reStr = result.getData().toString();
				Map<String, Object> resMap = JackJsonUtil.parse(reStr, HashMap.class);
				medicalInsuranceService.saveSk01RequireNew(resMap, map, feeMap);
			} else {
				throw BaseException.create("ERROR_SHYB_0024",
						new String[] { result.getCode() + "--" + result.getMsg() + "" });
			}
		}
		// 医保作废end
		parameters.put("ZFPB", 1);
		opMzxxDao.updateZfpb(parameters);
		parameters.remove("FYBZ");
		long llCount = opCf01Dao.getCountByCondition(parameters);
		if (llCount > 0) {
			opCf01Dao.updateZfpb(parameters);
//			String qyzdfyj = ParameterUtil.getParameter(manaUnitId, BSPHISSystemArgument.QYZDFYJ, ctx);
//			if ("1".equals(qyzdfyj)) {
//				// add by yangl 作废时调用接口作废自动发药中的处方
//				Map<String, Object> parameters1 = new HashMap<String, Object>(16);
//				String zdfyYfsb = ParameterUtil.getParameter(user.getManageUnitId(), "ZDFYYFSB", "3", "自动发药药房识别", "03",
//						ContextUtils.getContext());
//				parameters1.put("MZXH", MZXX.get("MZXH"));
//				parameters1.put("JGID", manaUnitId);
//				parameters1.put("YFSB", zdfyYfsb);
//				List<Map<String, Object>> l = dao.doSqlQuery(
//						"select CFSB as CFSB,KFRQ,FPHM,YFSB from OP_CF01 where  MZXH=:MZXH and JGID=:JGID and YFSB=:YFSB",
//						parameters1);
//				if (l.size() > 0) {
//					try {
//						StringBuffer pt = new StringBuffer();
//						pt.append("<ROOT>");
//						pt.append("<OPSYSTEM>HIS</OPSYSTEM>");
//						pt.append("<OPWINID></OPWINID>");
//						pt.append("<OPTYPE>205</OPTYPE>");
//						pt.append("<OPIP></OPIP>");
//						pt.append("<OPMANNO>").append(user.getUserId()).append("</OPMANNO>"); // 收费工号
//						pt.append("<OPMANNAME>").append(user.getUserName()).append("</OPMANNAME>"); // 收费姓名
//						for (Map<String, Object> row : l) {
//							getUnPrescTpl(pt, row);
//							// add by yangl 自动发药采用新接口方式
//						}
//						pt.append("</ROOT>");
//
//						// System.out.println(pt);
//						ServiceHisLocator sh = new ServiceHisLocator();
//						String retVal = sh.getBasicHttpBinding_IHisService().hisTransData(pt.toString());
//						Document doc = XMLHelper.StrToXMLDocment(retVal);
//						String code = doc.getRootElement().elementText("RETCODE");
//						String msg = doc.getRootElement().elementText("RETMSG");
//						if (code == null || !code.equals("1")) {
//							logger.error("调用发药机接口错误:" + msg);
//						}
//					} catch (RemoteException e) {
//						// throw new
//						// ModelDataOperationException("调用发药机接口错误!请联系管理员(不影响收费业务)!",
//						// e);
//						logger.error("发票作废调用发药机接口错误!请联系管理员", e);
//					} catch (javax.xml.rpc.ServiceException e) {
//						// throw new
//						// ModelDataOperationException("调用发药机接口错误!请联系管理员(不影响收费业务)!",
//						// e);
//						logger.error("发票作废调用发药机接口错误!请联系管理员", e);
//					} catch (Exception e) {
//						logger.error("发票作废调用发药机接口错误!请联系管理员", e);
//					}
//				}
//			}
		}
		parameters.remove("ZXPB");
		llCount = opYjcf01Dao.getCountByCondition(parameters);
		if (llCount > 0) {
			opYjcf01Dao.updateZfpb(parameters);
			// 如果是医技检查的, 需要把预约的信息也置为作废, 不同发票收费的MZXH是不一样的
			opYjcf01Dao.updateJczt(parameters);
//
//			if (wpjfbz == 1 && wzsfxmjg == 1) {
//				List<Map<String, Object>> sbxhlist = opYjcf01Dao.getYjSbxhs(parameters);
//				for (int i = 0; i < sbxhlist.size(); i++) {
//					mzUtil.setSuppliesYKSL(dao, ctx, Long.parseLong(sbxhlist.get(i).get("SBXH") + ""), 1);
//				}
//				Map<String, Object> parametersxhmxupd = new HashMap<String, Object>(16);
//				List<Map<String, Object>> sbxhlistupd = dao.doQuery(
//						"select b.SBXH as SBXH from OP_YJCF01 a,OP_YJCF02 b,WL_XHMX c Where a.YJXH=b.YJXH and b.SBXH=c.MZXH and c.BRLY='1' and a.JGID=:JGID and a.MZXH=:MZXH",
//						parameters);
//				for (int i = 0; i < sbxhlistupd.size(); i++) {
//					parametersxhmxupd.put("MZXH", Long.parseLong(sbxhlistupd.get(i).get("SBXH") + ""));
//					parametersxhmxupd.put("BRLY", "1");
//					dao.doUpdate("update WL_XHMX set ZTBZ=-1 where MZXH=:MZXH and BRLY=:BRLY", parametersxhmxupd);
//				}
//			}
		}
		parameters.put("FPHM", fphm);
		parameters.put("CZGH", String.valueOf(req.getYgdm()));
		// 获取门诊类别
		Integer mzlb = opMzlbSer.getMzlb(req.getJgid(), req.getIp());


		parameters.put("MZLB", mzlb);
		parameters.put("ZFRQ", DateUtil.date().toTimestamp());

		OpZffp opZffp = BeanUtil.fillBeanWithMapIgnoreCase(parameters, new OpZffp(), true);
//		opZffp.setMzxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_ZFFP));
		opZffp.setJzlsh(req.getJzlsh());
		opZffpDao.insert(opZffp);
//		if (body.containsKey("YBXX")) {
//			MedicareInterface model = new HZSMedicareModel(dao);
//			model.saveYbFpzf((Map<String, Object>) body.get("YBXX"));
//		}
		// 库存冻结代码
		int sfqyyfyfy = Integer.parseInt(sysXtcsCacheSer.getCsz(req.getJgid(), "SFQYYFYFY"));
		if (sfqyyfyfy == 1) {
			// 先删除过期的冻结库存
			// MedicineCommonModel model = new MedicineCommonModel(dao);
			// model.deleteKCDJ(manaUnitId, ctx);
			Map<String, Object> mapParCfsb = new HashMap<String, Object>(16);
			mapParCfsb.put("JGID", req.getJgid());
			mapParCfsb.put("MZXH", ObjectToTypes.parseLong(mzxxMap.get("MZXH")));
			List<Map<String, Object>> listCfsb = opCf01Dao.getByFphm(mapParCfsb);
			if (listCfsb != null && listCfsb.size() > 0) {
				for (Map<String, Object> mapCfsb : listCfsb) {
					Integer djcfsb = Integer.valueOf(mapCfsb.get("CFSB") + "");
					drugService.deleteKcdjByCfsbAndDjlb(djcfsb, 1);
				}
			}
		}

		// POS机退费，保存OP_POSMX表
//		Map<String, Object> pos = (Map<String, Object>) body.get("pos");
//		if (pos != null && pos.get("PosTraceNumber") != null) {
//			Map<String, Object> posInfo = phis.source.utils.MapUtils.upcaseKeys(pos);
//			posInfo.put("JYSJ", new Date());
//			posInfo.put("JYLB", pos.get("TransType"));
//			posInfo.put("FPHM", fphm);
//			dao.doSave("create", "phis.application.pos.schemas.OP_POSMX", posInfo, false);
//		}

		// 预付卡退费(发票作废) 前台没有传付款方式 后台fkxx查询获取

		Map<String, Object> map = new HashMap<String, Object>(16);
		map.put("MZXH", mzxxMap.get("MZXH"));
		List<Map<String, Object>> list = opFkxxDao.getFkxxByCondition(map);
		if (list.size() > 0) {
			doYfkTfByFphm(fphm, "11", req.getYgdm(), req.getIp());
		}
//		// 如果非商保病人
//		if (!(Constants.BRXZ_SYBX + "").equals(MZXX.get("BRXZ") + "")) {
//			// 检查发票号码是否已经开了发票，没开发票就删除Tbl_Cust_DocMaster中对应的记录
//			Map<String, Object> countParam = new HashMap<String, Object>(16);
//			countParam.put("DocumentNr", fphm);
//
//			String ZZSFPDY = "";
//			PublicService publicService = new PublicService();
//			Map<String, Object> Pamargs = publicService.doLoadThisComputerArgs(Param.instance().put("names", "ZZSFPDY"),
//					res, dao, ctx);
//			ZZSFPDY = StrUtil.null2Str(Pamargs.get("ZZSFPDY"));
//			if (ZZSFPDY.equals("1")) { // 启用增值税发票
//				dao.doSqlUpdate("delete from Tbl_Cust_DocMaster where DocumentNr=:DocumentNr", countParam);
//				// 去作废增值税发票
//				Map<String, Object> request = new HashMap<String, Object>(16);
//				request.put("FPHM", fphm);
//				request.put("FPLX", "MZ");
//				PHISCommonModel phis = new PHISCommonModel(dao);
//				// phis.doCancelinv(request);
//				phis.doCancelinv_jk(request, res, ctx);
//			} else {
//				List<Map<String, Object>> countList = dao.doSqlQuery(
//						"select count(*) as TOTAL from Tbl_Result where DocumentNr=:DocumentNr", countParam);
//				if (countList != null && 0 == Long.parseLong(countList.get(0).get("TOTAL") + "")) {
//					dao.doSqlUpdate("delete from Tbl_Cust_DocMaster where DocumentNr=:DocumentNr", countParam);
//				}
//			}
//		}
//		Session ss = (Session) ctx.get(Context.DB_SESSION);
//		ss.flush();
		// 库存冻结代码结束
		// 此处新加延伸处方退费接口
		/*
		 * String
		 * sql="select cfsb as cfsb,yscfhm as yscfhm from OP_CF01 where mzxh='"+MZXX.get
		 * ("MZXH")+"' and (DJLY=9 or TSCF=3) and ZFPB !=1 "; List<Map<String,Object>>
		 * cfList=dao.doSqlQuery(sql,null); logger.info("查询处方语句: "+sql);
		 * logger.info("延伸处方退费接口，处方数 "+cfList.size()); for(Map<String,Object>
		 * item:cfList){ logger.info("开始调用处方退费接口:.................."); String msg2 =
		 * this.doYscftf(ctx,String.valueOf(item.get("YSCFHM")));
		 * logger.info("调用处方退费接口完毕:.................."+msg2); }
		 */
	}

	/**
	 * 预付卡退费 根据发票号码
	 *
	 * @param fphm
	 * @param cztype
	 * @param ygdm
	 * @param ip
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doYfkTfByFphm(String fphm, String cztype, Integer ygdm, String ip) {
		Map<String, Object> map = new HashMap<String, Object>(16);
		map.put("fphm", fphm);
		List<Map<String, Object>> list = mpiKpxxDao.getKpInfo(map);
		if (list.size() == 0) {
			throw BaseException.create("ERROR_REG_0041");
		}

		Map<String, Object> yeMap = new HashMap<String, Object>(16);
		yeMap.put("KNYE", list.get(0).get("AMOUNT"));
		yeMap.put("BRID", list.get(0).get("BRID"));
		mpiKpxxDao.updateKnyeByCondition(yeMap);

		Map<String, Object> data = new HashMap<String, Object>(16);
		data.put("CARDNO", list.get(0).get("CARDNO"));// carno
		data.put("CZTYPE", cztype);
		data.put("AMOUNT", list.get(0).get("AMOUNT"));// amount
		data.put("CZGH", ygdm);// czgh
		data.put("CZIP", ip);// czip
		data.put("CZSJ", DateUtil.date().toTimestamp());// czsj
		data.put("BRID", list.get(0).get("BRID"));// BRID
		data.put("FPHM", fphm);// fphm
		data.put("LASTKNYE", Double.parseDouble(list.get(0).get("KNYE") + ""));// lastknye

		OpCzjl opCzjl = BeanUtil.fillBeanWithMapIgnoreCase(data, new OpCzjl(), true);
		opCzjl.setCzxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CZJL));
		opCzjlDao.insert(opCzjl);
	}

	/**
	 * 复制发票号码
	 *
	 * @param req
	 */
	@Transactional(rollbackFor = Exception.class)
	public List<CfInfoResp> saveCopyFphm(SaveCopyFphmReq req) {
		Map<String, Object> body = MzUtil.caseInsensitiveMap(req);
		Map<String, Object> parameters = new HashMap<String, Object>(16);
		List<CfInfoResp> resp = new ArrayList<CfInfoResp>();
		String fphm = (String) body.get("FPHM");
		Map<String, Object> mzxx = MzUtil.caseInsensitiveMap(req.getMzxx());
		String ghks = mzxx.get("GHKS").toString();
		parameters.put("JGID", req.getJgid());
		parameters.put("FPHM", fphm);

		long n = opMzxxDao.getCountByConditiion(parameters);
		if (n > 0) {
			// 处方
			List<Map<String, Object>> djs = new ArrayList<Map<String, Object>>();
//				List<Map<String, Object>> cfList = dao
//						.doQuery(
//								"select CSMC as CSMC,CSZ as CSZ from SYS_XTCS where JGID=:JGID and CSMC like 'YS_MZ_FYYF_"
//										+ GHKS + "_%'", parameters);

			List<Map<String, Object>> cfList = opCf01Dao.getByFphm(parameters);
			if (cfList.size() > 0) {
				Map<String, Object> yfsbsparameters = new HashMap<String, Object>(16);
				yfsbsparameters.put("JGID", req.getJgid());
				yfsbsparameters.put("CSMC", "YS_MZ_FYYF_");
				List<Map<String, Object>> yfsbs = sysXtcsSer.getXtcsByCsmc(yfsbsparameters);
				String ysMzFyyfXy = "0";
				String ysMzFyyfZy = "0";
				String ysMzFyyfCy = "0";
				for (int i = 0; i < yfsbs.size(); i++) {
					if (("YS_MZ_FYYF_" + ghks + "_XY").equals(yfsbs.get(i).get("CSMC") + "")) {
						ysMzFyyfXy = (String) yfsbs.get(i).get("CSZ");
					} else if (("YS_MZ_FYYF_" + ghks + "_ZY").equals(yfsbs.get(i).get("CSMC") + "")) {
						ysMzFyyfZy = (String) yfsbs.get(i).get("CSZ");
					} else if (("YS_MZ_FYYF_" + ghks + "_CY").equals(yfsbs.get(i).get("CSMC") + "")) {
						ysMzFyyfCy = (String) yfsbs.get(i).get("CSZ");
					}
				}
				if (ysMzFyyfXy.trim().length() == 0 || ysMzFyyfZy.trim().length() == 0
						|| ysMzFyyfCy.trim().length() == 0 || "null".equals(ysMzFyyfXy) || "null".equals(ysMzFyyfZy)
						|| "null".equals(ysMzFyyfCy)) {
					throw BaseException.create("ERROR_REG_0042");
				}
				for (int i = 0; i < cfList.size(); i++) {
					Map<String, Object> cfparameters = new HashMap<String, Object>(16);
					cfparameters.put("CFSB", cfList.get(i).get("CFSB"));
					cfparameters.put("CFLX", cfList.get(i).get("CFLX"));
					cfparameters.put("YS_MZ_FYYF_XY", ysMzFyyfXy);
					cfparameters.put("YS_MZ_FYYF_ZY", ysMzFyyfZy);
					cfparameters.put("YS_MZ_FYYF_CY", ysMzFyyfCy);

					List<Map<String, Object>> cf02s = opCf02Dao.getYpInfo(cfparameters);
					for (int j = 0; j < cf02s.size(); j++) {
						cf02s.get(j).put("lsjg", cf02s.get(j).get("YPDJ"));
						Map<String, Object> ci = mzUtil.checkInventory(cf02s.get(j), req.getJgid());
						if (Integer.parseInt(ci.get("sign") + "") < 0) {
//							Map<String, Object> ypxhParameters = new HashMap<String, Object>(16);
//							ypxhParameters.put("YPXH", cf02s.get(j).get("medId"));
							Integer ypxh = Integer.valueOf(cf02s.get(j).get("medId").toString());
							DrugsTypkDetailResp rebody = drugsTypkOutSer.getDrugsTypkById(ypxh);
							throw BaseException.create("ERROR_REG_0043", new String[] { rebody.getYpmc() });
						}
					}
				}
				for (int i = 0; i < cfList.size(); i++) {
					Map<String, Object> cf01Pkey = cfList.get(i);
					String cflx = cf01Pkey.get("CFLX") + "";
					cf01Pkey.remove("cflx");

					Map<String, Object> map = new HashMap<String, Object>(16);
					map.put("CFLX", cflx);
					map.put("YS_MZ_FYYF_XY", ysMzFyyfXy);
					map.put("YS_MZ_FYYF_ZY", ysMzFyyfZy);
					map.put("YS_MZ_FYYF_CY", ysMzFyyfCy);
					map.put("CFSB", cf01Pkey.get("CFSB"));
					List<Map<String, Object>> cf02List = opCf02Dao.getSbxh(map);

					if (cf02List.size() == 0) {
						throw BaseException.create("ERROR_REG_0044");
					}
					OpCf01 opCf01 = opCf01Dao.getById(Integer.valueOf(cf01Pkey.get("CFSB").toString()));
					Map<String, Object> cf01 = MzUtil.caseInsensitiveMap(opCf01);
					cf01.putAll(mzxx);
					cf01.put("DJLY", 6);
					cf01.remove("cfsb");
					cf01.remove("fyrq");
					cf01.remove("pygh");
					cf01.remove("fygh");
					cf01.remove("fphm");
					cf01.remove("mzxh");
//						cf01.remove("JZXH");
					cf01.put("KFRQ", DateUtil.date().toTimestamp());
					cf01.put("PYBZ", 0);
					cf01.put("FYBZ", 0);
					cf01.put("TYBZ", 0);
					cf01.put("ZFPB", 0);
					cf01.put("YXPB", 0);
					cf01.put("DJYBZ", 0);

					OpCf01 mc01 = BeanUtil.fillBeanWithMapIgnoreCase(cf01, new OpCf01(), true);
					mc01.setCfsb(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CF01));
					opCf01Dao.insert(mc01);

					Map<String, Object> newCfsb = MzUtil.caseInsensitiveMap(mc01);
					for (int j = 0; j < cf02List.size(); j++) {
						Map<String, Object> cfsb = new HashMap<String, Object>(16);
						cfsb.put("CFSB", newCfsb.get("CFSB"));
						cfsb.put("CFLX", cf01.get("CFLX"));
						// cfsb.put("DJLX", "1");
						djs.add(cfsb);
						Map<String, Object> cf02Pkey = cf02List.get(j);

						OpCf02 opCf02 = opCf02Dao.getById(Integer.valueOf(cf02Pkey.get("SBXH").toString()));
						Map<String, Object> cf02 = MzUtil.caseInsensitiveMap(opCf02);
						cf02.put("CFSB", newCfsb.get("CFSB"));
						cf02.remove("sbxh");
						Map<String, Object> payProportionMap = new HashMap<String, Object>(16);
						payProportionMap.put("TYPE", cf02.get("XMLX"));
						payProportionMap.put("BRXZ", mzxx.get("BRXZ"));
						payProportionMap.put("FYXH", cf02.get("YPXH"));
						payProportionMap.put("FYGB", cf02.get("FYGB"));
						Map<String, Object> zfblMap = mzUtil.getPayProportion(payProportionMap);
						if (zfblMap != null) {
							cf02.put("ZFBL", zfblMap.get("ZFBL"));
						} else {
							cf02.put("ZFBL", 1);
						}
						Map<String, Object> ypdjProportion = new HashMap<String, Object>(16);
						ypdjProportion.put("JGID", req.getJgid());
						ypdjProportion.put("YPXH", Long.parseLong(cf02.get("YPXH") + ""));
						ypdjProportion.put("YFSB", Long.parseLong(cf02List.get(j).get("YFSB") + ""));
						ypdjProportion.put("YPCD", cf02.get("YPCD"));
						QueryYfypReq queryYfypReq = BeanUtil.fillBeanWithMapIgnoreCase(ypdjProportion,
								new QueryYfypReq(), true);
						BigDecimal lsjg = drugService.getLsjg(queryYfypReq);

						if (lsjg != null) {
							if (Double.parseDouble(lsjg + "") > 0) {
								cf02.put("YPDJ", lsjg);
							}
							cf02.put("HJJE",
									Double.parseDouble(cf02.get("YPDJ") + "")
											* Double.parseDouble(cf02.get("YPSL") + "")
											* Integer.parseInt(cf02.get("CFTS") + ""));
						}

						OpCf02 ms02 = BeanUtil.fillBeanWithMapIgnoreCase(cf02, new OpCf02(), true);
						ms02.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CF02));
						opCf02Dao.insert(ms02);
					}
				}
			}
			// 医技
			List<Map<String, Object>> yjList = opYjcf01Dao.getYjxh(parameters);
			if (yjList.size() > 0) {
				for (int i = 0; i < yjList.size(); i++) {
					Map<String, Object> yj01Pkey = yjList.get(i);
					List<Map<String, Object>> yj02List = opYjcf02Dao.getSbxh(yj01Pkey);
					if (yj02List.size() == 0) {
						throw BaseException.create("ERROR_REG_0044");
					}
					OpYjcf01 opYjcf01 = opYjcf01Dao.getById(Integer.valueOf(yj01Pkey.get("YJXH").toString()));
					Map<String, Object> yj01 = MzUtil.caseInsensitiveMap(opYjcf01);
					yj01.remove("yjxh");
					yj01.remove("zxrq");
					yj01.remove("fphm");
					yj01.remove("mzxh");
					yj01.put("KDRQ", DateUtil.date().toTimestamp());
					yj01.put("YJGL", 0);
					yj01.put("ZFPB", 0);
					yj01.put("JZXH", 0);
					yj01.put("ZXPB", 0);
					yj01.put("DJLY", 6);
					yj01.putAll(mzxx);

					OpYjcf01 ms01 = BeanUtil.fillBeanWithMapIgnoreCase(yj01, new OpYjcf01(), true);
					ms01.setYjxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJCF01));
					opYjcf01Dao.insert(ms01);
					Map<String, Object> newYjsb = MzUtil.caseInsensitiveMap(ms01);
					// ---发票复制修:发票作废后，重新复制发票号码。还原JC01的状态，10改成2
					Map<String, Object> sqidobj = MzUtil.caseInsensitiveMap(opYjcf01);

					if (null != sqidobj && null != sqidobj.get("SQID") && "null" != sqidobj.get("SQID") + ""
							&& "" != sqidobj.get("SQID") + "") {
						Map<String, Object> sqidparam = new HashMap<String, Object>(16);
						sqidparam.put("JCXH", sqidobj.get("SQID"));

						CisJcsq01Model cisJcsq01 = cisjcsqd01Service
								.jc01getById(Integer.valueOf(sqidobj.get("SQID").toString()));
						Map<String, Object> jc01obj = MzUtil.caseInsensitiveMap(cisJcsq01);
						if (null != jc01obj && "10".equals(jc01obj.get("JCZT") + "")) {// 检查项目存在并且是作废状态的。还原成作废前的
							cisjcsqd01Service.updateJcztByJcxh(sqidparam);
						}
					}

					for (int j = 0; j < yj02List.size(); j++) {
						Map<String, Object> yjxh = new HashMap<String, Object>(16);
						yjxh.put("CFSB", newYjsb.get("YJXH"));
						// yjxh.put("DJLX", "2");
						yjxh.put("CFLX", "0");
						djs.add(yjxh);
						Map<String, Object> yj02Pkey = yj02List.get(j);

						OpYjcf02 opYjcf02 = opYjcf02Dao.getById(Integer.valueOf(yj02Pkey.get("SBXH").toString()));
						Map<String, Object> yj02 = MzUtil.caseInsensitiveMap(opYjcf02);
						yj02.put("YJXH", newYjsb.get("YJXH"));
						yj02.remove("sbxh");
						Map<String, Object> payProportionMap = new HashMap<String, Object>(16);
						payProportionMap.put("TYPE", yj02.get("XMLX"));
						payProportionMap.put("BRXZ", mzxx.get("BRXZ"));
						payProportionMap.put("FYXH", yj02.get("YLXH"));
						payProportionMap.put("FYGB", yj02.get("FYGB"));
						Map<String, Object> zfblMap = mzUtil.getPayProportion(payProportionMap);
						if (zfblMap != null && Double.parseDouble(zfblMap.get("ZFBL") + "") > 0) {
							yj02.put("ZFBL", zfblMap.get("ZFBL"));
						} else {
							yj02.put("ZFBL", 1);
						}
						Map<String, Object> fydjProportion = new HashMap<String, Object>(16);
						fydjProportion.put("JGID", req.getJgid());
						fydjProportion.put("FYXH", Long.parseLong(yj02.get("YLXH") + ""));
						List<Map<String, Object>> fydjList = feeYlsfxmdjDao.getFydj(fydjProportion);
						if (fydjList.size() > 0) {
							if (Double.parseDouble(fydjList.get(0).get("FYDJ") + "") > 0) {
								yj02.put("YLDJ", fydjList.get(0).get("FYDJ"));
							}
							yj02.put("HJJE", Double.parseDouble(yj02.get("YLDJ") + "")
									* Double.parseDouble(yj02.get("YLSL") + ""));
						}

						OpYjcf02 ms02 = BeanUtil.fillBeanWithMapIgnoreCase(yj02, new OpYjcf02(), true);
						ms02.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJCF02));
						opYjcf02Dao.insert(ms02);
					}
				}
			}
			resp = MzUtil.ListToResultSet(djs, new CfInfoResp());
			return resp;
		} else {
			return resp;
		}
		// dao.doLoad("select MZXH as MZXH from "+BSPHISEntryNames.OP_MZXX+" where
		// JGID=:JGID and FPHM=:FPHM",
		// parameters);
	}

	/**
	 * 获取退费发票列表
	 *
	 * @param jgid
	 * @param ygdm
	 * @return
	 */
	public List<QueryVoidInvoiceResp> doQueryVoidInvoice(Integer jgid, Integer ygdm) {
		return opZffpDao.doQueryVoidInvoice(jgid, ygdm);
	}

	/**
	 * 分页条件查询可以作废的发票列表
	 *
	 * @param req
	 * @return
	 */
	public List<OpMzxx> getFpzfList(FpzfListReq req) {
		OpMzxx opMzxx = new OpMzxx();
		opMzxx.setSfrq(DateUtil.date().toTimestamp());
		opMzxx.setBeginOfDay(DateUtil.beginOfDay(req.getBeginDay()).toTimestamp());
		opMzxx.setEndOfDay(DateUtil.endOfDay(req.getEndDay()).toTimestamp());
		if (req.getZfpb() != null) {
			if (req.getZfpb().intValue() == 0) {
				opMzxx.setJzkh(req.getFphm());
			} else if (req.getZfpb() == 1) {
				opMzxx.setFphm(req.getFphm());
			}
		}
		List<OpMzxx> resultList = opMzxxDao.getFpzfList(opMzxx);
		return resultList;
	}

	/**
	 * 取消发票作废
	 *
	 * @param fphm
	 * @param jgid
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doUpdateCanceledVoidInvoice(String fphm, Integer jgid) {
		int wpjfbz = Integer.parseInt(sysXtcsCacheSer.getCsz(jgid, "MZWPJFBZ"));
		int wzsfxmjg = Integer.parseInt(sysXtcsCacheSer.getCsz(jgid, "WZSFXMJG"));
		Map<String, Object> parameters = new HashMap<String, Object>(16);
		parameters.put("FPHM", fphm);
		parameters.put("JGID", jgid);
		Map<String, Object> mzxxMap = opMzxxDao.getMzxxByCondition(parameters);

		if ("1".equals(mzxxMap.get("THPB") + "")) {
			// throw new ModelDataOperationException(
			// ServiceCode.CODE_DATABASE_ERROR, "退号发票不可以取消作废!");
			throw BaseException.create("ERROR_REG_0045");
		}
		if (0 == Integer.parseInt(mzxxMap.get("ZFPB") + "")) {
			throw BaseException.create("ERROR_REG_0046");
		}

		parameters.put("thpb", 1);
		long llFound = opMzxxDao.getCountByConditiion(parameters);
		if (llFound > 0) {
			throw BaseException.create("ERROR_REG_0047");
		}
		parameters.remove("FPHM");
		parameters.put("MZXH", mzxxMap.get("MZXH"));
		opMzxxDao.updateZfpbByCondition(parameters);

		long ll_Count = opCf01Dao.getCountByCondition(parameters);
		if (ll_Count > 0) {
			opCf01Dao.updateCancelZfpb(parameters);
			// 库存冻结代码
			int sfqyyfyfy = Integer.parseInt(sysXtcsCacheSer.getCsz(jgid, "SFQYYFYFY"));
			if (sfqyyfyfy == 1) {
				// 先删除过期的冻结库存
				// MedicineCommonModel model = new MedicineCommonModel(dao);
				// model.deleteKCDJ(manaUnitId, ctx);

				List<Map<String, Object>> listCfsb = opCf01Dao.getByFphm(parameters);
				if (listCfsb != null && listCfsb.size() > 0) {
					for (Map<String, Object> mapCfsb : listCfsb) {
						List<OpCf02> opCf02List = opCf02Dao.queryByCfsb(ObjectToTypes.parseInt(mapCfsb.get("CFSB")));
						List<Map<String, Object>> listCf02 = MzUtil.ListObjToMap(opCf02List);

						if (listCf02 != null && listCf02.size() > 0) {
							for (Map<String, Object> mapCf02 : listCf02) {
								Map<String, Object> mapKcdj = new HashMap<String, Object>(16);
								mapKcdj.put("JGID", jgid);
								mapKcdj.put("YFSB", ObjectToTypes.parseLong(mapCfsb.get("YFSB")));
								mapKcdj.put("CFSB", ObjectToTypes.parseLong(mapCfsb.get("CFSB")));
								mapKcdj.put("YPXH", ObjectToTypes.parseLong(mapCf02.get("YPXH")));
								mapKcdj.put("YPCD", ObjectToTypes.parseLong(mapCf02.get("YPCD")));
								mapKcdj.put("YPSL", MzUtil.simpleMultiply(2, mapCf02.get("YPSL"), mapCf02.get("CFTS")));
								mapKcdj.put("YFBZ", ObjectToTypes.parseInt(mapCf02.get("YFBZ")));
								mapKcdj.put("DJSJ", DateUtil.date().toTimestamp());
								mapKcdj.put("JLXH", ObjectToTypes.parseLong(mapCf02.get("SBXH")));
								mapKcdj.put("DJLB", 1);
								mapKcdj.put("LSJG", ObjectToTypes.parseDouble(mapCf02.get("YPDJ")));
								PharKcdjReq pharKcdj = BeanUtil.fillBeanWithMapIgnoreCase(mapKcdj, new PharKcdjReq(),
										true);
								pharKcdj.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.PHAR_KCDJ));
								drugService.insertKcdj(pharKcdj);
							}
						}

					}
				}
			}
			// 库存冻结代码结束
		}
		// TODO
		ll_Count = opYjcf01Dao.getCountByCondition(parameters);
		if (ll_Count > 0) {
			opYjcf01Dao.updateCalcelZfpb(parameters);
//			if (wpjfbz == 1 && wzsfxmjg == 1) {
//				List<Map<String, Object>> sbxhlist = opYjcf01Dao.getYjSbxhs(parameters);
//
//				for (int i = 0; i < sbxhlist.size(); i++) {
//					mzUtil.setSuppliesYKSL(dao, ctx, Long.parseLong(sbxhlist.get(i).get("SBXH") + ""), 0);
//				}
//				Map<String, Object> parametersxhmxupd = new HashMap<String, Object>(16);
//				List<Map<String, Object>> sbxhlistupd = dao.doQuery(
//						"select b.SBXH as SBXH from OP_YJCF01 a,OP_YJCF02 b,WL_XHMX c Where a.YJXH=b.YJXH and b.SBXH=c.MZXH and c.BRLY='1' and a.JGID=:JGID and a.MZXH=:MZXH",
//						parameters);
//				for (int i = 0; i < sbxhlistupd.size(); i++) {
//					parametersxhmxupd.put("MZXH", Long.parseLong(sbxhlistupd.get(i).get("SBXH") + ""));
//					parametersxhmxupd.put("BRLY", "1");
//					dao.doUpdate("update WL_XHMX set ZTBZ=0 where MZXH=:MZXH and BRLY=:BRLY", parametersxhmxupd);
//
//				}
//			}
		}
		// 根据主键删除作废发票数据
		opZffpDao.deleteById(Integer.valueOf(mzxxMap.get("MZXH").toString()));
	}

	/**
	 * 修改发票号
	 *
	 * @param fphm
	 * @param jgid
	 * @param ygdm
	 * @param type
	 * @return
	 */
	public String doUpdateNotesNumber(String fphm, Integer jgid, Integer ygdm, Integer type) {
		List<OpYgpj> list = opYgpjDao.getFirstSyhm(jgid, ygdm, type);
		List<Map<String, Object>> ret = MzUtil.ListObjToMap(list);
		if (ret.size() < 1) {
			throw BaseException.create("ERROR_REG_0044");
		}
		Map<String, Object> record = ret.get(0);
		String syhm = (String) record.get("SYHM");
		String zzhm = (String) record.get("ZZHM");
		String qshm = (String) record.get("QSHM");

		if (fphm != null && zzhm != null) {
			if (Integer.parseInt(fphm) > Integer.parseInt(zzhm)) {
				throw BaseException.create("ERROR_REG_0066");
			}
		}

		Integer jlxh = record.get("JLXH") != null ? Integer.valueOf(record.get("JLXH").toString()) : 0;
		if (fphm.length() == syhm.length() && Integer.parseInt(fphm) < Integer.parseInt(zzhm)
				&& Integer.parseInt(fphm) > Integer.parseInt(qshm)) {
			opYgpjDao.updateHm(fphm.toString(), null, jlxh, null, null);
		} else {
			return null;
		}
		return fphm;

	}

	/**
	 * 退费处理 发票查询
	 *
	 * @param fphm
	 * @param jgid
	 * @param ygdm
	 * @return
	 */
	public QueryTfFphmResp doQueryTfFphm(String fphm, Integer jgid, Integer ygdm) {
		Map<String, Object> parameters = new HashMap<String, Object>(16);
		parameters.put("FPHM", fphm);
		parameters.put("JGID", jgid);
		// List<Map<String, Object>> djs = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> persons = mpiBrdaDao.getTfPersonInfo(parameters);

		Map<String, Object> person = null;
		if (persons.size() > 0) {
			person = persons.get(0);
			person.put("FPHM", opGhksSer.getNotesNumberNotIncrement(ygdm, jgid, 2));
			List<Map<String, Object>> listDetails = new ArrayList<Map<String, Object>>();
			List<Map<String, Object>> listDetails1 = opCf01Dao.getTfDetail(parameters);
			listDetails.addAll(listDetails1);
			List<Map<String, Object>> listDetails2 = opYjcf01Dao.getTfDetail(parameters);
			listDetails.addAll(listDetails2);
			queryTfFphmComment();
			Map<String, Object> mzxhParameters = new HashMap<String, Object>(16);
			mzxhParameters.put("JGID", jgid);
			mzxhParameters.put("MZXH", Long.parseLong(persons.get(0).get("MZXH") + ""));

			List<Map<String, Object>> fkxxList = opFkxxDao.getFkxxInfo(mzxhParameters);

			Integer mzxh = persons.get(0).get("MZXH") != null ? Integer.valueOf(persons.get(0).get("MZXH").toString()) : 0;
			OpMzxx opMzxx = opMzxxDao.getById(mzxh);
			Map<String, Object> mzxxMap = MzUtil.caseInsensitiveMap(opMzxx);
			mzxxMap.put("FKFS", Long.parseLong(fkxxList.size() > 1 ? "1" : fkxxList.get(0).get("FKFS") + ""));
			// MZXX.put(key, value)
			QueryTfFphmResp resp = new QueryTfFphmResp();
			List<QueryDjDetailResp> details = MzUtil.ListToResultSet(listDetails, new QueryDjDetailResp());
			List<QueryTfFkxxResp> fkxxs = MzUtil.ListToResultSet(fkxxList, new QueryTfFkxxResp());
			QueryTfMzxxResp mzxx = BeanUtil.fillBeanWithMapIgnoreCase(mzxxMap, new QueryTfMzxxResp(), true);
			QueryTfJeResp body = BeanUtil.fillBeanWithMapIgnoreCase(person, new QueryTfJeResp(), true);
			resp.setDetails(details);
			resp.setFkxxs(fkxxs);
			resp.setMzxx(mzxx);
			resp.setBody(body);
			return resp;
		}
		return null;
	}

	private void queryTfFphmComment() {
		//			Map<String, Object> ZTYZSBXH = new HashMap<String, Object>();
//	        for (Map<String, Object> record : listDetails) {
//	            if (record.get("ZTBZ") != null && record.get("ZTBZ").toString().equals("1")) {
//	                if (ZTYZSBXH.containsKey(MedicineUtils.parseString(record.get("ZTYZSBXH")))) {
//	                    continue;
//	                }
//	                Map<String,Object> parm = Param.instance().put("sbxh", MedicineUtils.parseLong(record.get("ZTYZSBXH")));
//	                record = opYj02ZtDao.getZtBySbxh(parm);
//	                ZTYZSBXH.put(MedicineUtils.parseString(record.get("SBXH")), record);
//	            }
//	            result.add(record);
//	        }

		// List<Map<String, Object>> fkxxList = new ArrayList<Map<String, Object>>();
	}

	/**
	 * 退费处理 主表查询
	 *
	 * @param fphm
	 * @param jgid
	 * @return
	 */
	public List<QueryTf01Resp> doQueryTf01(String fphm, Integer jgid) {
		Map<String, Object> parameters = new HashMap<String, Object>(16);
		parameters.put("jgid", jgid);
		parameters.put("fphm", fphm);

		List<Map<String, Object>> list01 = opCf01Dao.getCf01(parameters);
		for (int i = 0; i < list01.size(); i++) {
			Map<String, Object> map = list01.get(i);
			Map<String, Object> parametersYs = new HashMap<String, Object>(16);
			if (!"".equals(map.get("YSDM")) && map.get("YSDM") != null) {
				parametersYs.put("PERSONID", map.get("YSDM"));
				Integer personId = parametersYs.get("PERSONID") != null
						? Integer.valueOf(parametersYs.get("PERSONID").toString())
						: 0;
				HrPersonnelModel hrPersonnel = hrPersonnelService.getPersonnelById(personId);
				map.put("YSMC", hrPersonnel.getPersonname());
			}
			Map<String, Object> parametersKs = new HashMap<String, Object>(16);
			if (map.get("KSDM") != null) {
				parametersKs.put("ID", Long.parseLong(map.get("KSDM") + ""));

				Integer id = map.get("KSDM") != null ? Integer.valueOf(map.get("KSDM").toString()) : 0;
				DicKszd dicKszd = dicKszdOutSer.getById(id);
				map.put("KSMC", dicKszd.getOfficename());
			}
			if ("0".equals(map.get("CFLX") + "")) {
				if ("1".equals(map.get("ZFPB") + "")) {
					map.put("BZXX", "已作废");
				} else if ("1".equals(map.get("FYBZ") + "")) {
					map.put("BZXX", "已执行");
				}
			} else {
				if ("1".equals(map.get("ZFPB") + "")) {
					map.put("BZXX", "已退药");
				} else if ("3".equals(map.get("DJLY") + "") && map.get("FPHM") == null) {
					map.put("BZXX", "新处方");
				} else if ("1".equals(map.get("FYBZ") + "")) {
					map.put("BZXX", "已发药");
				}
			}
		}
		List<QueryTf01Resp> resp = MzUtil.ListToResultSet(list01, new QueryTf01Resp());
		return resp;
	}

	/**
	 * 退费结算计算
	 *
	 * @param req
	 * @return
	 */
	public QueryTfPaymentResp doQueryTfPayment(QueryTfPaymentReq req) {
		QueryTfPaymentResp resp = new QueryTfPaymentResp();
		List<Map<String, Object>> body = MzUtil.ListObjToMap(req.getBody());
		Map<String, Object> mzxxMap = MzUtil.caseInsensitiveMap(req.getMzxx());

		List<QueryPayReq> dataList = req.getBody();
		// 判断药品是否发药
//		Map<String, Object> params = new HashMap<String, Object>(16);
//		params.put("FPHM", req.getMzxx().getFphm());
//		params.put("JGID", req.getJgid());
//		Map<String, Object> fybzMap = opMzxxDao.getMzxxByCondition(params);
//		params.put("MZXH", fybzMap.get("MZXH"));
//		params.put("ZXPB", 1);
//		params.put("FYBZ", 1);
//		int llFound = opCf01Dao.getCountByCondition(params);
//		if (llFound > 0) {
//			throw BaseException.create("ERROR_REG_0086");
//		}
		Map<String, Object> parameters = new HashMap<String, Object>(16);
		parameters.put("FKFS", Long.parseLong(mzxxMap.get("FKFS") + ""));
		parameters.put("SYLX", 1);
		List<Map<String, Object>> list = pubFkfsService.getPubFkfsInfo(parameters);
		Map<String, Object> fkfs = list.get(0);

		Map<String, Object> jsxx = new HashMap<String, Object>(16);
		// jsxx.put("JJZF", "0.00");
		// jsxx.put("ZHZF", "0.00");
		BigDecimal zjje = BigDecimal.ZERO;
		BigDecimal zfje = BigDecimal.ZERO;
		BigDecimal jmje = BigDecimal.ZERO;
		if (req.getJsxxReq() == null) {
			for (QueryPayReq payReq : dataList) {
				BigDecimal hjje = ObjectToTypes.parseBigDecimal(payReq.getHjje());
				BigDecimal zfbl = ObjectToTypes.parseBigDecimal(payReq.getZfbl());
				BigDecimal zkje = ObjectToTypes.parseBigDecimal(payReq.getZkje());
				jmje = ObjectToTypes.parseBigDecimal(payReq.getJmje());
				zjje = zjje.add(hjje);
				zfje = zfje.add(hjje.multiply(zfbl)).subtract(jmje).subtract(zkje);
			}
		} else {
			Map<String, Object> rjsxx = MzUtil.caseInsensitiveMap(req.getJsxxReq());
			zjje = ObjectToTypes.parseBigDecimal(rjsxx.get("ZJJE"));
			zfje = ObjectToTypes.parseBigDecimal(rjsxx.get("ZFJE"));
			jsxx.put("JJZF", MzUtil.getDouble(Double.parseDouble(rjsxx.get("JJZF") + ""), 2));
			jsxx.put("ZHZF", MzUtil.getDouble(Double.parseDouble(rjsxx.get("ZHZF") + ""), 2));
		}
		double ysk = MzUtil.getDouble(zfje, Integer.parseInt(fkfs.get("FKJD") + "") - 1);
//		double ysk = MzUtil.getDouble(mzxxMap.get("ZJJE"), Integer.parseInt(fkfs.get("FKJD") + "") - 1);
		jsxx.put("FKFS", fkfs.get("FKFS"));
		jsxx.put("FKMC", fkfs.get("FKMC"));
		jsxx.put("ZJJE", MzUtil.getDouble(zjje, 2));
		jsxx.put("ZFJE", MzUtil.getDouble(zfje, 2));
//		jsxx.put("ZJJE", MzUtil.getDouble(ysk - zfje, 2));
//		jsxx.put("ZFJE", MzUtil.getDouble(ysk - zfje, 2));
		jsxx.put("YSK", ysk);
		String fphm = opGhksSer.getNotesNumberNotIncrement(req.getYgdm(), req.getJgid(), 2);
		jsxx.put("FPHM", fphm);
		int fpzs = doQueryFpzs(body, req.getJgid());
		jsxx.put("FPZS", fpzs);
		String lastFphm = mzUtil.getFPHM(req.getYgdm(), req.getJgid(), fpzs);
		jsxx.put("lastFPHM", lastFphm);
		// 前台显示数据
		BigDecimal tfje = ObjectToTypes.parseBigDecimal(mzxxMap.get("ZFJE")).subtract(zfje);
//		double tfje = MzUtil.getDouble(MzUtil.getDouble(mzxxMap.get("ZJJE"), 2) - hbwc - zfje, 2);
		Map<String, Object> showjs = new HashMap<String, Object>(16);
		showjs.put("TFJE", MzUtil.getDouble(tfje, 2));

		// 查询卡类别标志、卡内数据、医保支付金额
		// Map<String,Object>
		// medPayInfo=this.loadYbtfxx(dao,String.valueOf(MZXX.get("MZXH")),"2");
		// if(MapUtils.isNotEmpty(medPayInfo)){
		// showjs.putAll(medPayInfo);
		// }

		double qtysk = -MzUtil.getDouble(tfje.add(ObjectToTypes.parseBigDecimal(showjs.get("JE"))),
				Integer.parseInt(fkfs.get("FKJD") + "") - 1);
		showjs.put("YSK", qtysk);

		// pos机退费
		Map<String, Object> map = new HashMap<String, Object>(16);
		map.put("p1", mzxxMap.get("FPHM"));
		Map<String, Object> posTraceNumber = opPosmxDao.getPm(map);
		if (posTraceNumber != null) {
			showjs.put("posTraceNumber", posTraceNumber.get("PM"));
		}

		JsxxResp tfJsxx = BeanUtil.fillBeanWithMapIgnoreCase(jsxx, new JsxxResp(), true);
		TfJeResp tfShowjs = BeanUtil.fillBeanWithMapIgnoreCase(showjs, new TfJeResp(), true);
		resp.setBody(tfJsxx);
		resp.setShowjs(tfShowjs);
		return resp;
	}

	/**
	 * 退费结算处理
	 *
	 * @param req
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public SaveRefundSettleResp doSaveRefundSettle(SaveRefundSettleReq req) {
		/*req.setAccountattr("1000000000000000");
		req.setCardno("");
		req.setCardtype("1");*/

		SaveRefundSettleResp resp = new SaveRefundSettleResp();
		Map<String, Object> body = MzUtil.caseInsensitiveMap(req);
		List<Map<String, Object>> datas = MzUtil.ListObjToMap(req.getData());

		List<QueryPayReq> dataList = req.getData();
		Map<String, Object> mzxxMap = MzUtil.caseInsensitiveMap(req.getMzxx());
		String yfphm = mzxxMap.get("FPHM") + "";

		String vipbrxz = sysXtcsCacheSer.getCsz(req.getJgid(), "VIPBRXZ");
		String[] vipbrxzs = vipbrxz.split(",");
		int isVip = 0;// 是否是VIP病人

		Integer wpjfbz = Integer.valueOf(sysXtcsCacheSer.getCsz(req.getJgid(), "MZWPJFBZ"));
		Integer wzsfxmjg = Integer.valueOf(sysXtcsCacheSer.getCsz(req.getJgid(), "WZSFXMJG"));

		//上海医保开始
		String jssqxh = "";
		Integer sjbrxz = pubBrxzOutSer.getSjxzByBrxz(Integer.parseInt(mzxxMap.get("brxz")+""));
		String YBSYPB = sysXtcsCacheSer.getCsz(req.getJgid(), "YBSYPB");
		if (sjbrxz == 6021  && "0".equals(YBSYPB)) {
			//作废
			Map<String, Object> Yb_Totex = new HashMap<String, Object>();
			Yb_Totex.put("ywlx", "2");
			Yb_Totex.put("sbxh", mzxxMap.get("mzxh"));
			Map<String, Object> feeMap = medicalInsuranceService.queryMedicalInsuranceTranInfo(Yb_Totex);
			Map<String, Object> map = new HashMap<String, Object>();
			String orgid = "";
			Map map_orgid = opMzlbDao.getYbjgdm(req.getJgid(), req.getIp());
			if (map_orgid != null && !map_orgid.isEmpty()) {
				orgid = map_orgid.get("ybjgid").toString();
			} else {
				throw BaseException.create("ERROR_SHYB_0015");
			}
			String carddata = req.getCardno();
			String cardtype = req.getCardtype();
			map.put("carddata", carddata);
			map.put("cardtype", cardtype);
			map.put("orgid", orgid);
			map.put("xsywlx", "");
			map.put("jyqd", "10");
			map.put("ip", req.getIp());
			map.put("jgid", req.getJgid());
			map.put("ygdm", req.getYgdm());
			map.put("ygxm", req.getYgxm());
			map.put("sbxh",mzxxMap.get("mzxh"));
			SettleResultDTO result = new SettleResultDTO();
			result = unifiedBusinessService.sk01(map, feeMap);
			if (result.getCode() == 200 && StringUtils.isNotBlank(StrUtil.null2Str(result.getData()))) {
				String reStr = result.getData().toString();
				Map<String, Object> resMap = JackJsonUtil.parse(reStr, HashMap.class);
				medicalInsuranceService.saveSk01RequireNew(resMap, map, feeMap);

			} else {
				throw BaseException.create("ERROR_SHYB_0024",
						new String[] { result.getCode() + "--" + result.getMsg() + "" });
			}
			//费用明细上传
			String jzdyh = "";

			String jzlsh = req.getMzxx().getJzlsh();
			String mzbkbrxz = sysXtcsCacheSer.getCsz(req.getJgid(), "MZBKBRXZ");
			String dbdm = "";
			String gsrdh = "";
			String persontype = "0";
			Integer brid = req.getMzxx().getBrid();
			List<Map<String,Object>> ghks_list = opMzxxDao.getGhks(req.getMzxx().getJzlsh());
			String ghks = "";
			if(ghks_list.size()>0){
					ghks = ghks_list.get(0).get("ksdm")+"";
				}
			Map<String, Object> map_ybksdm = dicKszdOutSer.getYbksdm(Integer.parseInt(ghks));
			String ybksdm = map_ybksdm.isEmpty() ? "03" : map_ybksdm.get("ybks") + "";
				//Map<String, Object> ybfyxx = CollectSfxm(req.getBrxz(),req.getJgid(), body);
			Map resJzdyh = queryMZJzdyhByks(brid, req.getJgid(),ghks);
			if (resJzdyh != null && resJzdyh.containsKey("jzdyh")) {
				jzdyh = resJzdyh.get("jzdyh") + "";
			} else {
				throw BaseException.create("ERROR_SHYB_0021");
			}
			String cfsbs = "";
			String yjxhs = "";
			List<String> yjsbxhs = new ArrayList<>();
			List<String> cfsbxhs = new ArrayList<>();
			if (datas.size() > 0) {
				for (Map<String, Object> mapyb : datas) {
					String cflx = mapyb.get("cflx").toString();
					String cfsb = mapyb.get("cfsb").toString();
					String sbxh = mapyb.get("sbxh").toString();

					if ("0".equals(cflx)) { // 医技
						yjsbxhs.add(sbxh);
					} else { // 处方
						cfsbxhs.add(sbxh);
					}
					jzlsh = StrUtil.null2Str(mapyb.get("jzlsh"));
				}
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("cfsbxhs", cfsbxhs);
				param.put("yjsbxhs", yjsbxhs);
				param.put("cfsbs", cfsbs);
				param.put("yjxhs", yjxhs);
				param.put("jgdm", orgid);
				param.put("cardtype", req.getCardtype());
				param.put("carddata", req.getCardno());
				param.put("djh", "");
				param.put("deptid", ybksdm);
				param.put("personspectag", req.getAccountattr().substring(3, 4));
				param.put("yllb", "S11");
				param.put("persontype", persontype);
				param.put("gsrdh", "");
				param.put("dbtype", "");
				param.put("jsksrq", "");
				param.put("jsjsrq", "");
				param.put("xsywlx", "");
				param.put("ghgl", "");
				param.put("zdxh", "");
				param.put("brxz", req.getMzxx().getBrxz());
				param.put("brid", brid);
				param.put("jzdyh", jzdyh);
				param.put("jgid", req.getJgid());
				param.put("ygdm", req.getYgdm());
				param.put("ygxm", req.getYgxm());
				param.put("ip", req.getIp());
				param.put("jslxbz", "120");//急诊220
				param.put("jzlsh", jzlsh);
				param.put("bz", 2);
				Map<String, Object> res = new HashMap<>();
				SettleResultDTO sn01ResultDTO = offLineSettle.batchUploadFeeDetails_MZ(param, res);
				if (sn01ResultDTO.getCode() != ServiceCode.CODE_OK) {
					throw BaseException.create("ERROR_SHYB_0022",
							new String[]{sn01ResultDTO.getCode() + "--" + sn01ResultDTO.getMsg() + ""});
				}
				param.put("resultSn01", sn01ResultDTO.getData());
				SettleResultDTO si11ResultDTO = offLineSettle.ChargePreSettlement_MZ(param, res);
				if (si11ResultDTO.getCode() != ServiceCode.CODE_OK) {
					throw BaseException.create("ERROR_SHYB_0023",
							new String[]{si11ResultDTO.getCode() + "--" + si11ResultDTO.getMsg() + ""});
				} else {
					MessageBody messageBody = JackJsonUtil.parse(si11ResultDTO.getData().toString(), MessageBody.class);
					Map<String, Object> si11res = (HashMap<String, Object>) messageBody.getXxnr();
					jssqxh = StrUtil.null2Str(si11res.get("jssqxh"));
			/*		if ("1".equals(req.getIsDb())) {
						BigDecimal yb_zfje = new BigDecimal(si11res.get("tcdxjzfs") + "")
								.add(new BigDecimal(si11res.get("fjdxjzfs") + ""))
								.add(new BigDecimal(si11res.get("ybjsfwfyze") + ""))
								.add(new BigDecimal(si11res.get("fybjsfwfyze") + ""))
								.subtract(new BigDecimal(si11res.get("totalexpense") + ""));
						jsxx.put("ZFJE", yb_zfje);
						jsxx.put("YSK", yb_zfje);
					} else if (!"".equals(gsrdh)) {
						jsxx.put("ZFJE", 0);
					} else if (mzbkbrxz.equals(req.getBrxz())) {
						BigDecimal yb_zfje = new BigDecimal(si11res.get("totalexpense") + "")
								.subtract(new BigDecimal(si11res.get("curaccountpay") + ""))
								.subtract(new BigDecimal(si11res.get("hisaccountpay") + ""))
								.subtract(new BigDecimal(si11res.get("tczfs") + ""))
								.subtract(new BigDecimal(si11res.get("fjzfs") + ""))
								.subtract(new BigDecimal(si11res.get("zfdlnzhzfs") + ""))
								.subtract(new BigDecimal(si11res.get("tcdzhzfs") + ""))
								.subtract(new BigDecimal(si11res.get("fjdzhzfs") + ""));
						jsxx.put("ZFJE", yb_zfje);
						jsxx.put("YSK", yb_zfje);
					} else {
						BigDecimal yb_jyfyze = new BigDecimal(si11res.get("hisaccountpay") + "")
								.add(new BigDecimal(si11res.get("curaccountpay") + ""))
								.add(new BigDecimal(si11res.get("zfdxjzfs") + ""))
								.add(new BigDecimal(si11res.get("zfdlnzhzfs") + ""))
								.add(new BigDecimal(si11res.get("tcdzhzfs") + ""))
								.add(new BigDecimal(si11res.get("tcdxjzfs") + ""))
								.add(new BigDecimal(si11res.get("tczfs") + ""))
								.add(new BigDecimal(si11res.get("fjdzhzfs") + ""))
								.add(new BigDecimal(si11res.get("fjdxjzfs") + ""))
								.add(new BigDecimal(si11res.get("fjzfs") + ""));
						BigDecimal yb_zfje = new BigDecimal(si11res.get("ybjsfwfyze") + "")
								.subtract(yb_jyfyze);
						jsxx.put("ZFJE", yb_zfje);
						jsxx.put("YSK", yb_zfje);
						jsxx.put("GSRDH", gsrdh);
						jsxx.put("QTYS", yb_jyfyze);


					}*/


				}
				//实结算
				List<Map<String, Object>> zdnoList = opBrzdDao.getZdForSf(jzlsh);
				List<DiagnosisInfo> zdnos = new ArrayList<DiagnosisInfo>();
				for(int i = 0 ;i<zdnoList.size();i++){
					DiagnosisInfo zdno = new DiagnosisInfo();
					zdno.setZdno( zdnoList.get(i).get("zdno")+"");
					zdno.setZdmc(zdnoList.get(i).get("zdmc")+"");
					zdnos.add(zdno);
				}
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("ip", req.getIp());
				params.put("jgdm", orgid);
				params.put("jgid",req.getJgid());
				params.put("ygdm",req.getYgdm());
				params.put("ygxm",req.getYgxm());
				params.put("cardtype", req.getCardtype());
				params.put("carddata", req.getCardno());
				params.put("deptid", ybksdm);
				params.put("persontype", persontype);
				params.put("yllb", "S11");
				params.put("personspectag", StrUtil.null2Str(req.getAccountattr().substring(3, 4)));
				params.put("gsrdh", gsrdh);
				params.put("dbtype", "");
				params.put("jsksrq", "");
				params.put("jsjsrq", "");
				params.put("jzdyh", jzdyh);
				params.put("xsywlx", "");
				params.put("jssqxh", jssqxh);
				params.put("mzxh", "9825");
				params.put("zdnos", zdnos);
				params.put("jzlsh", jzlsh);
				params.put("mxzdhs", "");
				SettleResultDTO si12ResultDTO = offLineSettle.confirmCharge_MZ(params, res);
				if (si12ResultDTO.getCode().intValue() == ServiceCode.CODE_OK
						&& !"".equals(si12ResultDTO.getData().toString())) {
					MessageBody messageBody = JackJsonUtil.parse(si12ResultDTO.getData().toString(), MessageBody.class);
					// 返回字段待定
				} else {
					throw BaseException.create("ERROR_SHYB_0020",
							new String[] { si12ResultDTO.getCode() + "--" + si12ResultDTO.getMsg() + "" });
					// jycx si91 待定
				}


			}


		}

		//医保结束

		List<Map<String, Object>> tfxxList = MzUtil.ListObjToMap(req.getMzxx().getTfxx()); //
		List<Integer> tfYjxhList = new ArrayList<>();
		for (int i = 0; i < tfxxList.size(); i++) {
			Map<String, Object> tfxxMap = tfxxList.get(i);
			Map<String, Object> parametersMap = new HashMap<String, Object>(16);
			parametersMap.put("CFSB", Long.parseLong(tfxxMap.get("CFSB") + ""));
			if ("0".equals(tfxxMap.get("CFLX") + "")) {
				Map<String, Object> mapPar = new HashMap<String, Object>(16);
				mapPar.put("yjxh", tfxxMap.get("CFSB"));
				mapPar.put("jczt", 21);
				OpYjcf01 opYjcf01 = new OpYjcf01();
				opYjcf01.setYjxh(mapPar.get("yjxh") != null ? Integer.valueOf(mapPar.get("yjxh").toString()) : 0);
				opYjcf01.setDjzt(21);
				opYjcf01Dao.updateBySaveSettle(opYjcf01);
				// 根据医技序号修改检查状态
				cisjcsqd01Service.updateJcztByOneYjxh(mapPar);
				tfYjxhList.add(opYjcf01.getYjxh());
			}
		}
		// 库存冻结代码
		int sfqyyfyfy = Integer.parseInt(sysXtcsCacheSer.getCsz(req.getJgid(), "SFQYYFYFY"));
		if (sfqyyfyfy == 1) {
			// 先删除过期的冻结库存
			// MedicineCommonModel model = new MedicineCommonModel(dao);
			// model.deleteKCDJ(manaUnitId, ctx);
			Map<String, Object> map_par_cfsb = new HashMap<String, Object>(16);
			map_par_cfsb.put("JGID", req.getJgid());
			map_par_cfsb.put("MZXH", ObjectToTypes.parseLong(mzxxMap.get("MZXH")));
			List<Map<String, Object>> list_cfsb = opCf01Dao.getByFphm(map_par_cfsb);
			if (list_cfsb != null && list_cfsb.size() > 0) {
				for (Map<String, Object> map_cfsb : list_cfsb) {
					drugService.deleteKcdjByCfsbAndDjlb(Integer.valueOf(map_cfsb.get("CFSB") + ""), 1);
				}
			}
		}
//		if (wpjfbz == 1) {
//			if (wzsfxmjg == 1) {
//				List<Map<String, Object>> tfxxList = MzUtil.ListObjToMap(req.getMzxx().getTfxx()); //
//				List<Object> ckdj_list = new ArrayList<Object>(); //
//				List<Map<String, Object>> cf02_list = new ArrayList<Map<String, Object>>();
//				for (int i = 0; i < tfxxList.size(); i++) {
//					Map<String, Object> tfxxMap = tfxxList.get(i);
//					Map<String, Object> parametersMap = new HashMap<String, Object>(16);
//					parametersMap.put("CFSB", Long.parseLong(tfxxMap.get("CFSB") + ""));
//					if ("0".equals(tfxxMap.get("CFLX") + "")) {
//						Map<String, Object> mapPar = new HashMap<String, Object>(16);
//						mapPar.put("yjxh", tfxxMap.get("CFSB"));
//						List<Map<String, Object>> listCount = wlCk02Dao.getCkInfoOne(mapPar);
//
//						if (listCount != null && listCount.size() > 0) {
//							long l = ObjectToTypes.parseLong(listCount.get(0).get("NUM"));
//							if (l > 0) {
//								long ll = ObjectToTypes.parseLong(wlCk02Dao.getCkInfoTwo(mapPar).get(0).get("NUM"));
//								if (l != ll) {
//									throw BaseException.create("ERROR_REG_0048");
//								}
//							}
//						}
//					}
//				}
//			}
//		}

		// 预付卡退费
	/*	if (req.getFffs() != null && req.getFffs().toString().equals("19")) {
			doYfkTfByFphm(yfphm, "11", req.getYgdm(), req.getIp());
		}*/
		if (datas.size() > 0) {
			List<Map<String, Object>> fzxxList = MzUtil.ListObjToMap(req.getMzxx().getFzxx());
			List<Object> ckdjList = new ArrayList<Object>();
			List<Map<String, Object>> cf02Lists = new ArrayList<Map<String, Object>>();
			List<Integer> sbxhList = dataList.stream().filter(o -> o.getCflx() == 0).map(QueryPayReq::getSbxh).collect(Collectors.toList());
			Map<Integer, Integer> alreadyInsertMap = new HashMap<>();
			List<OpYjcf02> allOpYjcf02List;
			Integer maxYjzh = 0;
			if(CollUtil.isNotEmpty(sbxhList)) {
				allOpYjcf02List = opYjcf02Dao.getBySbxhList(sbxhList);
				maxYjzh = opYjcf02Dao.getMaxYjzh(req.getMzxx().getJzlsh(), req.getJgid());
				if (maxYjzh == null) {
					maxYjzh = 1;//组号从1开始
				} else {
					maxYjzh++;
				}
				for (OpYjcf02 opYjcf02 : allOpYjcf02List) {
					if(!alreadyInsertMap.containsKey(opYjcf02.getZtyzsbxh())) {
						OpYjcf02Zt opYjcf02Zt = opYjcf02ZtDao.getById(opYjcf02.getZtyzsbxh());
						opYjcf02Zt.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJ02_ZT));
						opYjcf02ZtDao.insert(opYjcf02Zt);
						alreadyInsertMap.put(opYjcf02.getZtyzsbxh(), opYjcf02Zt.getSbxh());
					}
				}
			}


			for (int i = 0; i < fzxxList.size(); i++) {
				Map<String, Object> fzxxMap = fzxxList.get(i);
				Map<String, Object> parametersMap = new HashMap<String, Object>(16);
				parametersMap.put("CFSB", Long.parseLong(fzxxMap.get("CFSB") + ""));
				if ("0".equals(fzxxMap.get("CFLX") + "")) {
					Integer yjxh = fzxxMap.get("CFSB") != null ? Integer.valueOf(fzxxMap.get("CFSB").toString()) : 0;
					Map<String, Object> yj01Map = new HashMap<String, Object>(16);
					yj01Map.put("yjxh", yjxh);
					Map<String, Object> opYjcf01Map = opYjcf01Dao.getOpYjcf01Cic(yj01Map);

					OpYjcf01 opYjcf01 = BeanUtil.fillBeanWithMapIgnoreCase(opYjcf01Map, new OpYjcf01(), true);
					opYjcf01.setYjxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJCF01));
					opYjcf01.setJzlsh(req.getMzxx().getJzlsh());
					opYjcf01Dao.insert(opYjcf01);
					Map<String, Object> yjxhMap = MzUtil.caseInsensitiveMap(opYjcf01);

					Map<String, Object> yj02Map = new HashMap<String, Object>(16);
					Integer yjxh02 = fzxxMap.get("CFSB") != null ? Integer.valueOf(fzxxMap.get("CFSB").toString()) : 0;
					yj02Map.put("YJXH", yjxh02);
					List<Map<String, Object>> opYjcf02List = opYjcf02Dao.getYj02Cic(yj02Map);
					Set<Integer> ztyzSbxh = new HashSet<>();
					for (int j = 0; j < opYjcf02List.size(); j++) {
						Map<String, Object> opYjcf02Map = opYjcf02List.get(j);
						opYjcf02Map.put("YJXH", Long.parseLong(yjxhMap.get("YJXH") + ""));

						OpYjcf02 opYjcf02 = BeanUtil.fillBeanWithMapIgnoreCase(opYjcf02Map, new OpYjcf02(), true);
						opYjcf02.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJCF02));
						opYjcf02.setJzlsh(req.getMzxx().getJzlsh());
						opYjcf02.setZtyzsbxh(alreadyInsertMap.get(opYjcf02.getZtyzsbxh()));
						opYjcf02.setYjzh(maxYjzh);
						opYjcf02Dao.insert(opYjcf02);
						if(!ztyzSbxh.contains(opYjcf02.getZtyzsbxh())){
							opYjcf02ZtDao.updateYjxhAndYjzhBySbxh(opYjcf02.getZtyzsbxh(), maxYjzh, opYjcf02.getYjxh());
							ztyzSbxh.add(opYjcf02.getZtyzsbxh());
						}
					}
					opYjcf01Dao.updateFphmMzxh(parametersMap);
					maxYjzh++;
				} else {
					Integer cfsb = fzxxMap.get("CFSB") != null ? Integer.valueOf(fzxxMap.get("CFSB").toString()) : 0;
					OpCf01 opCf01 = opCf01Dao.getById(cfsb);
					Map<String, Object> opCf01Map = MzUtil.caseInsensitiveMap(opCf01);
					opCf01Map.remove("CFSB");
					opCf01.setCfsb(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CF01));
					opCf01.setJzlsh(req.getMzxx().getJzlsh());
					opCf01Dao.insert(opCf01);
					Map<String, Object> cfsbMap = MzUtil.caseInsensitiveMap(opCf01);

					Integer cfsb02 = fzxxMap.get("CFSB") != null ? Integer.valueOf(fzxxMap.get("CFSB").toString()) : 0;
					List<OpCf02> cf02List = opCf02Dao.queryByCfsb(cfsb02);
					List<Map<String, Object>> opCf02List = MzUtil.ListObjToMap(cf02List);

					//部分退药
					List<QueryPayReq> cfList = dataList.stream().filter(o -> o.getCfsb().equals(cfsb)).collect(Collectors.toList());
					List<Integer> bcSbxhList = cfList.stream().map(QueryPayReq::getSbxh).collect(Collectors.toList());
					Map<Integer, Integer> yfbzMap = new HashMap<>();
					cfList.forEach( o -> {
						cf02List.forEach( p -> {
							yfbzMap.put(p.getSbxh(), p.getYfbz());
							if(o.getSbxh().equals(p.getSbxh()) && !o.getYpsl().equals(p.getYpsl())){
								if(Objects.nonNull(o.getZkbl())){
									o.setZhje(o.getHjje().multiply(o.getZfbl()).multiply(o.getZkbl()));
								}
								opCf02Dao.updateYlslAndJe(o);
							}
							if(!bcSbxhList.contains(p.getSbxh())){
								Map<String, Object> sbxhMap = new HashMap<>();
								sbxhMap.put("SBXH", p.getSbxh());
								opCf02Dao.deleteBySbxh(sbxhMap);
							}
						});
					});


					if (sfqyyfyfy == 1) {
						cfList.forEach( o -> {
							PharKcdjReq pharKcdj = new PharKcdjReq();
							pharKcdj.setJgid(req.getJgid());
							pharKcdj.setYfsb(o.getYfsb());
							pharKcdj.setCfsb(o.getCfsb());
							pharKcdj.setYpxh(o.getYpxh());
							pharKcdj.setYpcd(o.getYpcd());
							pharKcdj.setYpsl(BigDecimal.valueOf((MzUtil.simpleMultiply(2, o.getYpsl(), o.getCfts()))));
							pharKcdj.setYfbz(yfbzMap.get(o.getSbxh()));
							pharKcdj.setDjsj(DateUtil.date().toTimestamp());
							pharKcdj.setJlxh(o.getSbxh());
							pharKcdj.setDjlb(1);
							pharKcdj.setLsjg(o.getYpdj());
							pharKcdj.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.PHAR_KCDJ));
							drugService.insertKcdj(pharKcdj);
						});
					}

					for (int j = 0; j < opCf02List.size(); j++) {
						Map<String, Object> opCf02Map = opCf02List.get(j);
						opCf02Map.put("CFSB", Long.parseLong(cfsbMap.get("CFSB") + ""));
						ckdjList.add(Long.parseLong(cfsbMap.get("CFSB") + ""));
						cf02Lists.add(opCf02Map);

						OpCf02 opCf02 = BeanUtil.fillBeanWithMapIgnoreCase(opCf02Map, new OpCf02(), true);
						opCf02.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CF02));
						opCf02.setJzlsh(req.getMzxx().getJzlsh());
						opCf02Dao.insert(opCf02);
					}
					opCf01Dao.updateFphmMzxh(parametersMap);
				}
			}

//			// 库存冻结代码
//			int mzkcdjsj = Integer.parseInt(sysXtcsCacheSer.getCsz(req.getJgid(), "MZKCDJSJ"));
//			if (sfqyyfyfy == 1 && mzkcdjsj == 1) {// 如果启用库存冻结,并且在开单时冻结
//				// 先删除过期的冻结库存
//				// MedicineCommonModel model = new MedicineCommonModel(dao);
//				// model.deleteKCDJ(manaUnitId, ctx);
//				// 先删除对应CFSB的冻结记录
//				for (int i = 0; i < ckdjList.size(); i++) {
//					long djcfsb = Long.parseLong(ckdjList.get(i) + "");
//					drugService.deleteKcdjByCfsbAndDjlb(Integer.valueOf(String.valueOf(djcfsb)), 1);
//					for (Map<String, Object> map_cf02 : cf02Lists) {
//						if (djcfsb == Long.parseLong(map_cf02.get("CFSB") + "")) {
//							Map<String, Object> mapKcdj = new HashMap<String, Object>(16);
//							mapKcdj.put("JGID", req.getJgid());
//							mapKcdj.put("YFSB", ObjectToTypes.parseLong(map_cf02.get("YFSB")));
//							mapKcdj.put("CFSB", ObjectToTypes.parseLong(map_cf02.get("CFSB")));
//							mapKcdj.put("YPXH", ObjectToTypes.parseLong(map_cf02.get("YPXH")));
//							mapKcdj.put("YPCD", ObjectToTypes.parseLong(map_cf02.get("YPCD")));
//							mapKcdj.put("YPSL", MzUtil.simpleMultiply(2, map_cf02.get("YPSL"), map_cf02.get("CFTS")));
//							mapKcdj.put("YFBZ", ObjectToTypes.parseInt(map_cf02.get("YFBZ")));
//							mapKcdj.put("DJSJ", DateUtil.date().toTimestamp());
//							mapKcdj.put("JLXH", ObjectToTypes.parseLong(map_cf02.get("SBXH")));
//							mapKcdj.put("DJLB", 1);
//							mapKcdj.put("LSJG", ObjectToTypes.parseDouble(map_cf02.get("YPDJ")));
//							PharKcdjReq pharKcdj = BeanUtil.fillBeanWithMapIgnoreCase(mapKcdj, new PharKcdjReq(), true);
//							pharKcdj.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.PHAR_KCDJ));
//							drugService.insertKcdj(pharKcdj);
//						}
//					}
//				}
//			}
			// 结算

			Date date = new Date();
			Map<String, Object> opMzxxMap = MzUtil.caseInsensitiveMap(req.getMzxx());

			SaveRefundSettleMzxxReq mzxxReq = req.getMzxx();

			for (int i = 0; i < vipbrxzs.length; i++) {
				if (vipbrxzs[i].toString().equals(opMzxxMap.get("BRXZ").toString())) {
					isVip = 1;
				}
			}
			//总计金额
			BigDecimal idZjje = ObjectToTypes.parseBigDecimal(mzxxReq.getZjje());
			//自负金额
			BigDecimal idZfje = ObjectToTypes.parseBigDecimal(mzxxReq.getZfje());
			if (isVip == 1) {
				idZjje = idZfje;
			}
			//支票金额
			BigDecimal idZpje = ObjectToTypes.parseBigDecimal(mzxxReq.getZpje());
			//减免金额
			BigDecimal idJmje = ObjectToTypes.parseBigDecimal(mzxxReq.getJmje());
			//现金金额
			BigDecimal idXjje = ObjectToTypes.parseBigDecimal(mzxxReq.getYsk()).subtract(idZpje);
			//货币误差
			BigDecimal idHbwc = idZfje.subtract(idXjje).subtract(idZpje).negate();
			//交款金额
			BigDecimal idJkje = ObjectToTypes.parseBigDecimal(mzxxReq.getJkje());
			//退找金额
			BigDecimal idTzje = idJkje.subtract(idXjje);

			opMzxxMap.put("XJJE", MzUtil.getDouble(idXjje, 2));// 现金金额
			opMzxxMap.put("ZPJE", MzUtil.getDouble(idZpje, 2));

			opMzxxMap.put("QTYS", BigDecimal.ZERO);
			opMzxxMap.put("ZHJE", BigDecimal.ZERO);
			opMzxxMap.put("ZJJE", MzUtil.getDouble(idZjje, 2));
			opMzxxMap.put("ZFJE", MzUtil.getDouble(idZfje, 2));
			opMzxxMap.put("MZGL", 0);
			opMzxxMap.put("JGID", req.getJgid());// 机构ID
			opMzxxMap.put("HBWC", MzUtil.getDouble(idHbwc, 2));// 货币误差
			opMzxxMap.put("ZFPB", 0);// 作废判别
			opMzxxMap.put("THPB", 0);// 退号判别

			opMzxxMap.put("SFFS", 0);// 收费方式
			opMzxxMap.put("JMJE", MzUtil.getDouble(idJmje, 2));// 减免金额
			opMzxxMap.put("MPJE", BigDecimal.ZERO);// 免赔金额
			opMzxxMap.put("LPJE", BigDecimal.ZERO);// 理赔金额
			opMzxxMap.put("HBBZ", 0);// 合并标志
			opMzxxMap.put("SFRQ", date);// 收费日期
			opMzxxMap.put("CZGH", req.getYgdm());

			// 获取门诊类别
			Integer mzlb = opMzlbSer.getMzlb(req.getJgid(), req.getIp());

			opMzxxMap.put("MZLB", mzlb);
			opMzxxMap.put("TZJE", MzUtil.getDouble(idTzje, 2));
			String fphm = opGhksSer.getNotesNumber(req.getYgdm(), req.getJgid(), OpPjlxEnum.FPHM.getKey());
			opMzxxMap.put("FPHM", fphm);
			opMzxxMap.remove("JZRQ");
			opMzxxMap.remove("HZRQ");
			opMzxxMap.put("ZSFPBZ", "0");

			OpMzxx opMzxx = BeanUtil.fillBeanWithMapIgnoreCase(opMzxxMap, new OpMzxx(), true);
			int new_mzxh = redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_MZXX);
			opMzxx.setMzxh(new_mzxh);
			opMzxx.setJzlsh(req.getMzxx().getJzlsh());
			opMzxxDao.insert(opMzxx);
			for (int i = 0; i < opMzxx.getFpzs() - 1; i++) {
				opGhksSer.getNotesNumber(req.getYgdm(), req.getJgid(), OpPjlxEnum.FPHM.getKey());
			}

			if (sjbrxz == 6021  && "0".equals(YBSYPB)) {
				shybSh01Service.updateSi12bftf(jssqxh, StrUtil.null2Str(new_mzxh));
			}

			Map<String, Object> mzxh = MzUtil.caseInsensitiveMap(opMzxx);
			// 获取fphm后开始，处方医技预付卡支付
			if (req.getFffs() != null && req.getFffs().toString().equals("19")) {
				List<Map<String, Object>> list = mpiKpxxDao.getMpiKpxxInfo(yfphm);

				if (list.size() == 0) {
					throw BaseException.create("ERROR_REG_0049");
				} else {
					int brid = Integer.parseInt(ObjectToTypes.null2Str(list.get(0).get("BRID")));
					opGhksSer.doSaveYykjkInfo(req.getCardno(), opMzxxMap.get("ZJJE").toString(), "08", fphm,
							req.getYgdm(), req.getIp());
				}
			}

			int fpzs = Integer.parseInt(opMzxxMap.get("FPZS") + "");
			for (int i = 0; i < fpzs - 1; i++) {
				opGhksSer.getNotesNumberNotIncrement(req.getYgdm(), req.getJgid(), 2);
			}
			opMzxxMap.put("MZXH", mzxh.get("MZXH"));

			SaveRefundSettleMzxxReq mzxx = BeanUtil.fillBeanWithMapIgnoreCase(opMzxxMap, new SaveRefundSettleMzxxReq(),
					true);
			resp.setFphm(fphm);
			resp.setMzxx(mzxx);

			Set<Long> fygbs = new HashSet<Long>();
			Set<Long> cfsbs = new HashSet<Long>();
			Set<Long> yjxhs = new HashSet<Long>();
			Map<Long, List<Long>> cfsbXy = new HashMap<Long, List<Long>>(16);
			Map<Long, List<Long>> cfsbZy = new HashMap<Long, List<Long>>(16);
			Map<Long, List<Long>> cfsbCy = new HashMap<Long, List<Long>>(16);
			// 药房允许切换时
			Set<Long> fyyfXy = new HashSet<Long>();// 西药
			Set<Long> fyyfZy = new HashSet<Long>();// 中药
			Set<Long> fyyfCy = new HashSet<Long>();// 草药
			for (int i = 0; i < datas.size(); i++) {
				Map<String, Object> data = datas.get(i);
				fygbs.add(Long.parseLong(data.get("FYGB") + ""));
				if ("0".equals(data.get("CFLX") + "")) {
					if (data.containsKey("YJXH")) {
						yjxhs.add(Long.parseLong(data.get("YJXH") + ""));
					} else {
						yjxhs.add(Long.parseLong(data.get("CFSB") + ""));
					}
				} else {
					int cfs = cfsbs.size();
					cfsbs.add(Long.parseLong(data.get("CFSB") + ""));
					if (cfs != cfsbs.size()) {
						Long yfsb = Long.parseLong(data.get("YFSB") + "");
						if ("1".equals(data.get("CFLX") + "")) {// 以前是对比YS_MZ_FYYF_XY来判断类型，现在改为CFLX
							// ll_xyfzs += 1;
							fyyfXy.add(yfsb);
							if (cfsbXy.containsKey(yfsb)) {
								cfsbXy.get(yfsb).add(Long.parseLong(data.get("CFSB") + ""));
							} else {
								List<Long> list = new ArrayList<Long>();
								list.add(Long.parseLong(data.get("CFSB") + ""));
								cfsbXy.put(yfsb, list);
							}
						} else if ("2".equals(data.get("CFLX") + "")) {
							fyyfZy.add(yfsb);
							if (cfsbZy.containsKey(yfsb)) {
								cfsbZy.get(yfsb).add(Long.parseLong(data.get("CFSB") + ""));
							} else {
								List<Long> list = new ArrayList<Long>();
								list.add(Long.parseLong(data.get("CFSB") + ""));
								cfsbZy.put(yfsb, list);
							}
						} else if ("3".equals(data.get("CFLX") + "")) {
							fyyfCy.add(yfsb);
							if (cfsbCy.containsKey(yfsb)) {
								cfsbCy.get(yfsb).add(Long.parseLong(data.get("CFSB") + ""));
							} else {
								List<Long> list = new ArrayList<Long>();
								list.add(Long.parseLong(data.get("CFSB") + ""));
								cfsbCy.put(yfsb, list);
							}
						}
					}
				}
			}
			Iterator<Long> it = fygbs.iterator();
			while (it.hasNext()) {
				long fygb = it.next();
				Map<String, Object> sfmx = new HashMap<String, Object>(16);
				sfmx.put("MZXH", mzxh.get("MZXH"));
				sfmx.put("JGID", req.getJgid());
				sfmx.put("SFXM", fygb);
				sfmx.put("FPHM", opMzxxMap.get("FPHM"));
				BigDecimal zjje = BigDecimal.ZERO;
				BigDecimal zfje = BigDecimal.ZERO;
				BigDecimal czf = BigDecimal.ZERO;
				BigDecimal flzf = BigDecimal.ZERO;
				BigDecimal totalJmje = BigDecimal.ZERO;
				for (QueryPayReq payReq : dataList) {
					if(fygb == payReq.getFygb()){
						BigDecimal hjje = payReq.getHjje();
						BigDecimal zfbl = payReq.getZfbl();
						zjje = zjje.add(hjje);
						BigDecimal zkje = ObjectToTypes.parseBigDecimal(payReq.getZkje());
						BigDecimal jmje = ObjectToTypes.parseBigDecimal(payReq.getJmje());
						zfje = zfje.add(hjje.multiply(zfbl)).subtract(jmje).subtract(zkje);
						totalJmje = totalJmje.add(jmje).add(zkje);
						if (BigDecimal.ONE.compareTo(zfbl) == 0) {
							czf = czf.add(hjje);
						} else {
							flzf = flzf.add(hjje.multiply(zfbl));
						}
					}
				}
				sfmx.put("ZJJE", MzUtil.getDouble(zjje, 2));
				if (isVip == 1) {
					sfmx.put("ZJJE", MzUtil.getDouble(zfje, 2));
				}
				sfmx.put("ZFJE", MzUtil.getDouble(zfje, 2));
				sfmx.put("CZF", MzUtil.getDouble(czf, 2));
				sfmx.put("FLZF", MzUtil.getDouble(flzf, 2));
				sfmx.put("JMJE", MzUtil.getDouble(totalJmje, 2));

				OpSfmx opSfmx = BeanUtil.fillBeanWithMapIgnoreCase(sfmx, new OpSfmx(), true);
				opSfmx.setJzlsh(req.getMzxx().getJzlsh());
				opSfmxDao.insert(opSfmx);
			}
			Map<String, Object> parameters = new HashMap<String, Object>(16);
			parameters.put("FPHM", opMzxxMap.get("FPHM"));
			parameters.put("MZXH", mzxh.get("MZXH"));
			Iterator<Long> cf = cfsbs.iterator();
			StringBuffer cfsb = new StringBuffer();
			List<Long> cfsbList = new ArrayList<Long>();
			while (cf.hasNext()) {
				String cfsbStr = cf.next() + "";
				if (cfsb.length() > 0) {
					cfsb.append(",");
					cfsb.append(cfsbStr);
				} else {
					cfsb.append(cfsbStr);
				}
				cfsbList.add(Long.parseLong(cfsbStr));
			}
			Iterator<Long> yj = yjxhs.iterator();
			StringBuffer yjxh = new StringBuffer();
			while (yj.hasNext()) {
				if (yjxh.length() > 0) {
					yjxh.append(",");
					yjxh.append(yj.next());
				} else {
					yjxh.append(yj.next());
				}
			}
			if (yjxh.length() != 0) {
				parameters.put("HJGH", req.getYgdm());
				parameters.put("yjxh", String.valueOf(yjxh));
				parameters.put("jczt", 20);
				parameters.put("djzt", 20);
				opYjcf01Dao.updateHmByYjxh(parameters);
//				if (wpjfbz == 1 && wzsfxmjg == 1) {
//					Map<String, Object> parameterssbxh = new HashMap<String, Object>(16);
//					parameterssbxh.put("MZXH", Long.parseLong(mzxh.get("MZXH") + ""));
//					List<Map<String, Object>> sbxhList = opYjcf01Dao.getSbxhByMzxh(parameterssbxh);
//					for (int q = 0; q < sbxhList.size(); q++) {
//						Long sbxh = 0L;
//						if (sbxhList.get(q).get("SBXH") != null) {
//							sbxh = Long.parseLong(sbxhList.get(q).get("SBXH") + "");
//							mzUtil.updateXHMXZT(sbxh, "1", req.getJgid());
//						}
//					}
//				}
				parameters.remove("HJGH");
//				ConfigLogisticsInventoryControlModel cic = new ConfigLogisticsInventoryControlModel(dao);
//				cic.saveMzWzxx(yjxh.toString(),
//						Long.parseLong(OP_MZXX.get("GHKS") == null ? "0" : OP_MZXX.get("GHKS") + ""),
//						Long.parseLong(OP_MZXX.get("GHGL") == null ? "0" : OP_MZXX.get("GHGL") + ""),
//						Long.parseLong(mzxh.get("MZXH") + ""), ctx);
			}
			if (cfsb.length() != 0) {
				if (cfsbXy.size() > 0) {// 西药处方
					for (Long yfsb : fyyfXy) {
						List<Long> xycf = cfsbXy.get(yfsb);
						List<Long> jmdCf = opCf01Dao.getJmdCfsb(xycf);
						List<Long> fjmdCf = xycf.stream().filter(o -> !jmdCf.contains(o)).collect(Collectors.toList());
						parameters.put("YFSB", yfsb);
						if(CollUtil.isNotEmpty(fjmdCf)) {
							Integer fyCkbh = opCf01Dao.getCkbhByRule(yfsb);
							parameters.put("FYCK", fyCkbh);
							parameters.put("CFSB", fjmdCf);
							int updatecfsl = opCf01Dao.updateCfInfo(parameters);
							if (updatecfsl != fjmdCf.size()) {
								throw BaseException.create("ERROR_REG_0033");
							}
						}
						if(CollUtil.isNotEmpty(jmdCf)){
							Integer jmdCkbh = Integer.valueOf(sysXtcsCacheSer.getCsz(req.getJgid(), "JMDCKBH"));
							parameters.put("FYCK", jmdCkbh);
							parameters.put("CFSB", jmdCf);
							int updatejmdcfsl = opCf01Dao.updateCfInfo(parameters);
							if (updatejmdcfsl != jmdCf.size()) {
								throw BaseException.create("ERROR_REG_0033");
							}
						}
					}
				}

				if (cfsbZy.size() > 0) {// 中药处方
					for (Long yfsb : fyyfZy) {
						Integer fyCkbh = opCf01Dao.getCkbhByRule(yfsb);
						parameters.put("FYCK", fyCkbh);

						parameters.put("CFSB", cfsbZy.get(yfsb));
						parameters.put("YFSB", yfsb);

						int updatecfsl = opCf01Dao.updateCfInfo(parameters);
						if (updatecfsl != cfsbZy.get(yfsb).size()) {
							throw BaseException.create("ERROR_REG_0033");
						}
					}
				}
				if (cfsbCy.size() > 0) {// 草药处方
					for (Long yfsb : fyyfCy) {
						Integer fyCkbh = opCf01Dao.getCkbhByRule(yfsb);
						parameters.put("FYCK", fyCkbh);

						parameters.put("CFSB", cfsbCy.get(yfsb));
						parameters.put("YFSB", yfsb);

						int updatecfsl = opCf01Dao.updateCfInfo(parameters);
						if (updatecfsl != cfsbCy.get(yfsb).size()) {
							throw BaseException.create("ERROR_REG_0033");
						}
					}

				}
			}
			Map<String, Object> countParameters = new HashMap<String, Object>(16);
			countParameters.put("MZXH", Long.parseLong(mzxh.get("MZXH") + ""));
			long yj02Count = opYjcf01Dao.getYj01Count(countParameters);
			long cf02Count = opCf01Dao.getCf01Count(countParameters);
			if ((yj02Count + cf02Count) != datas.size()) {
				throw BaseException.create("ERROR_REG_0034");
			}
			countParameters.put("VIP", isVip);

			double yj02Hjje = Double.parseDouble(opYjcf01Dao.getAmountByVip(countParameters).toString());

			double cf02Hjje = Double.parseDouble(opCf01Dao.getAmountByVip(countParameters).toString());

			BigDecimal yj02Hjje1 = new BigDecimal(String.valueOf(yj02Hjje));
			BigDecimal cf02Hjje1 = new BigDecimal(String.valueOf(cf02Hjje));
			BigDecimal yjcfhjje1 = yj02Hjje1.add(cf02Hjje1);
			double yjcfhjje = MzUtil.getDouble(yjcfhjje1.doubleValue(), 2);
			logger.info("yjcfhjje=" + yjcfhjje);
			logger.info("MzUtil.getDouble(id_zjje, 2)=" + MzUtil.getDouble(idZjje, 2));
			if (yjcfhjje != MzUtil.getDouble(idZjje, 2)) {
				throw BaseException.create("ERROR_REG_0035");
			}
//				if ((MzUtil.getDouble(YJ02hjje + CF02hjje, 2)) != mzUtil
//						.getDouble(id_zjje, 2)) {
//					throw new ModelDataOperationException(
//							ServiceCode.CODE_DATABASE_ERROR,
//							"门诊结算失败,结算费用金额已发生变化，请重新导入后在结算!");
//				}
			if (BigDecimal.ZERO.compareTo(idHbwc) != 0) {
				Map<String, Object> parameters2 = new HashMap<String, Object>(16);
				parameters2.put("HBWC", "1");
				parameters2.put("SYLX", 1);
				List<Map<String, Object>> map = pubFkfsService.getPubFkfsInfo(parameters2);
				Long fkfs = map.get(0).get("FKFS") != null ? Long.parseLong(map.get(0).get("FKFS").toString()) : 0;
				Map<String, Object> opFkxxMap = new HashMap<String, Object>(16);
				opFkxxMap.put("JGID", req.getJgid());
				opFkxxMap.put("MZXH", mzxh.get("MZXH"));
				opFkxxMap.put("FKFS", fkfs);
				opFkxxMap.put("FKJE", MzUtil.getDouble(idHbwc, 2));
				OpFkxx opFkxx = BeanUtil.fillBeanWithMapIgnoreCase(opFkxxMap, new OpFkxx(), true);
				opFkxx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_FKXX));
				opFkxx.setJzlsh(req.getMzxx().getJzlsh());
				opFkxxDao.insert(opFkxx);
			}
			Map<String, Object> opFkxxMap = new HashMap<String, Object>(16);
			opFkxxMap.put("JGID", req.getJgid());
			opFkxxMap.put("MZXH", mzxh.get("MZXH"));
			if (body.containsKey("FFFS")) {
				opFkxxMap.put("FKFS", Long.valueOf(String.valueOf(body.get("FFFS"))));
			}
			opFkxxMap.put("FKJE", MzUtil.getDouble(idXjje, 2));
			OpFkxx opFkxx = BeanUtil.fillBeanWithMapIgnoreCase(opFkxxMap, new OpFkxx(), true);
			opFkxx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_FKXX));
			opFkxx.setJzlsh(req.getMzxx().getJzlsh());
			opFkxxDao.insert(opFkxx);

//			PharmacyDispensingModel mpmm = new PharmacyDispensingModel(dao);
//			String sfzjfy = sysXtcsCacheSer.getCsz(req.getJgid(), "SFZJFY");
//			String ydczsf = opMzxxMap.get("YDCZSF") + "";// 移动收费判别字段，0为移动收费
//			if ("0".equals(ydczsf)) {// 如果为0，则为移动收费，设置收费直接发药参数
//				sfzjfy = "1";
//			}

			// update by caijy for 张伟2要求 PHAR_MZFYMX只能要药房模块新增记录.
			Map<String, Object> mapPar = new HashMap<String, Object>(16);
			mapPar.put("fphm", opMzxxMap.get("FPHM"));
			for (int i = 0; i < cfsbList.size(); i++) {
				mapPar.put("cfsb", cfsbList.get(i));
				drugLogService.updateFphmByCfsb(Integer.valueOf(cfsbList.get(i).toString()),
						opMzxxMap.get("FPHM").toString());
			}
			// PharmacyDispensingModel mpmm = new
			// PharmacyDispensingModel(dao);
			// String SFZJFY = ParameterUtil.getParameter(manaUnitId,
			// BSPHISSystemArgument.SFZJFY, ctx);
			// String YDCZSF = OP_MZXX.get("YDCZSF") + "";// 移动收费判别字段，0为移动收费
			// if ("0".equals(YDCZSF)) {// 如果为0，则为移动收费，设置收费直接发药参数
			// SFZJFY = "1";
			// }
			// if ("1".equals(SFZJFY)) {
			// for (int i = 0; i < cfsb_list.size(); i++) {
			// Map<String, Object> map = new HashMap<String, Object>(16);
			// map.put("cfsb", cfsb_list.get(i));
			// map.put("fygh", uid);
			// Map<String, Object> m = mpmm.saveDispensing(map, ctx);
			// if (m.containsKey("x-response-code")) {
			// if (Integer.parseInt(m.get("x-response-code") + "") > 300) {
			// throw new ModelDataOperationException(
			// ServiceCode.CODE_DATABASE_ERROR,
			// m.get("x-response-msg") + "");
			// }
			// }
			// }
			// }
			// TODO 待修改
			if (body.containsKey("details")) {
				List<Map<String, Object>> dta = (List<Map<String, Object>>) body.get("details");
				Map<String, Object> bllxpar = new HashMap<String, Object>(16);
				for (int i = 0; i < dta.size(); i++) {
					Map<String, Object> detail = dta.get(i);
					if ("0".equals(String.valueOf(detail.get("CFLX")))) {
						bllxpar.put("SBXH", ObjectToTypes.parseLong(detail.get("SBXH")));
						bllxpar.put("ZFBL", ObjectToTypes.parseDouble(detail.get("ZFBL")));
						opYjcf02Dao.updateZfblBySbxh(bllxpar);
					} else {
						bllxpar.put("SBXH", ObjectToTypes.parseLong(detail.get("SBXH")));
						bllxpar.put("ZFBL", ObjectToTypes.parseDouble(detail.get("ZFBL")));
						opCf02Dao.updateZfblBySbxh(bllxpar);
					}
				}
			}

		}
		// 作废
		Map<String, Object> parametersZf = new HashMap<String, Object>(16);
		parametersZf.put("FPHM", yfphm);
		parametersZf.put("JGID", req.getJgid());
		Map<String, Object> mzxxZf = opMzxxDao.getMzxxByCondition(parametersZf);

		parametersZf.remove("FPHM");
		parametersZf.put("MZXH", mzxxZf.get("MZXH"));
		parametersZf.put("ZFPB", 1);
		parametersZf.put("THPB", 1);
		opMzxxDao.updateZfpb(parametersZf);

		long llCount = opCf01Dao.getCountByCondition(parametersZf);

		if (llCount > 0) {
			opCf01Dao.updateZfpb(parametersZf);
		}
		llCount = opYjcf01Dao.getCountByCondition(parametersZf);
		if (llCount > 0) {
			opYjcf01Dao.updateZfpb(parametersZf);
			if (wpjfbz == 1 && wzsfxmjg == 1) {
//				List<Map<String, Object>> sbxhList = opYjcf01Dao.getYjSbxhs(parametersZf);

//				for (int i = 0; i < sbxhlist.size(); i++) {
//					mzUtil.setSuppliesYKSL(dao, ctx, Long.parseLong(sbxhlist.get(i).get("SBXH") + ""), 1);
//				}
//				Map<String, Object> parametersxhmxupd = new HashMap<String, Object>(16);
//				List<Map<String, Object>> sbxhlistupd = opYjcf01Dao.getSbxh(parametersZf);
//				for (int i = 0; i < sbxhlistupd.size(); i++) {
//					parametersxhmxupd.put("MZXH", Long.parseLong(sbxhlistupd.get(i).get("SBXH") + ""));
//					parametersxhmxupd.put("BRLY", "1");
//					wlXhmxDao.updateZtbz(parametersxhmxupd);
//				}
			}
		}
		parametersZf.put("FPHM", yfphm);
		parametersZf.put("CZGH", req.getYgdm());
		// 获取门诊类别
		Integer mzlb = opMzlbSer.getMzlb(req.getJgid(), req.getIp());

		parametersZf.put("MZLB", mzlb);
		parametersZf.put("ZFRQ", DateUtil.date().toTimestamp());

		OpZffp opZffp = BeanUtil.fillBeanWithMapIgnoreCase(parametersZf, new OpZffp(), true);
//		opZffp.setMzxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_ZFFP));
		opZffp.setJzlsh(req.getMzxx().getJzlsh());
		opZffpDao.insert(opZffp);
		if (CollUtil.isNotEmpty(tfYjxhList)) {
			 try{
				List<OpYjcf01> zlYjcf01List = opYjcf01Dao.getListByYjxhs(null, tfYjxhList, 7, 2);
				zlYjcf01List.forEach(o -> {
					treatmentApplyFormService.cancel(o.getZlsqdid(), req.getYgdm());
				});
			} catch (Exception e) {
				logger.info(CommonConstans.ZLSQD_RPC_INFO);
			}
			try {
				List<OpYjcf01> jcYjcf01List = opYjcf01Dao.getListByYjxhs(null, tfYjxhList, 4, 2);
				jcYjcf01List.forEach(o -> {
					LisRequestCancelReq lisRequestCancelReq = new LisRequestCancelReq();
					lisRequestCancelReq.setRequest_no(o.getYjxh().toString());
					lisRequestCancelReq.setHospital_id(req.getJgid().toString());
					LisResp lisResp = lisService.lisRequestCancel(lisRequestCancelReq);
					logger.info("调用LIS返回结果：{}", JSONUtil.toJsonStr(lisResp));
				});
			} catch (Exception e) {
				logger.info(CommonConstans.LIS_RPC_INFO);
			}
		}


		// POS机退费，保存OP_POSMX表
		Map<String, Object> pos = MzUtil.caseInsensitiveMap(req.getPos());
		if (pos != null && pos.get("PosTraceNumber") != null) {
			Map<String, Object> posInfo = new HashMap<String, Object>(16);
			posInfo.put("JYSJ", DateUtil.date().toTimestamp());
			posInfo.put("JYLB", pos.get("TransType"));
			posInfo.put("FPHM", yfphm);
			OpPosmx msOpPosmx = BeanUtil.fillBeanWithMapIgnoreCase(posInfo, new OpPosmx(), true);
			msOpPosmx.setId(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_POSMX));
			opPosmxDao.insert(msOpPosmx);
		}
//			//预付卡退费
//			if(body.get("FFFS").toString().equals("19")){
//				doYfkTfByFphm(yfphm,"11",ctx);
//			}
		// 如果非商保病人
//		Map<String, Object> map_brxz = dao.doLoad(BSPHISEntryNames.PUB_BRXZ, MZXX.get("BRXZ") + "");
//
//		if (!(Constants.BRXZ_SYBX + "").equals(MZXX.get("BRXZ") + "")) {
//			// 将重新收费的处方和医技的明细保存到Tbl_Cust_DocMaster
//			String Payee = DictionaryController.instance().get("phis.dictionary.doctor").getText(MZXX.get("CZGH") + "");
//			for (Map<String, Object> detail : datas) {
//				Map<String, Object> invoiceInfo = new HashMap<String, Object>(16);
//				invoiceInfo.put("InvKind", 2);// 发票类型 0：增值税专用发票，2：增值税普通发票
//				invoiceInfo.put("DocumentNr", res.get("FPHM"));// 单据号
//				invoiceInfo.put("DocumentDate", new Date());// 单据日期
//				// invoiceInfo.put("CustomerName", MZXX.get("BRXM"));//客户名称
//				invoiceInfo.put("CustomerName", StrUtil.null2Str(MZXX.get("BRXM")) + "     "
//						+ StrUtil.null2Str(map_brxz.get("XZMC")) + "     卡号: " + StrUtil.null2Str(MZXX.get("JZKH")));
//				invoiceInfo.put("CustomerTaxNr", "");// 客户税号
//				invoiceInfo.put("CustomerAddressTel", "");// 客户地址电话
//				invoiceInfo.put("CustomerBankAccountNr", "");// 客户银行帐号
//				invoiceInfo.put("Invoicer", "");// 开票人
//				invoiceInfo.put("Checker", "");// 复核人
//				invoiceInfo.put("Payee", Payee);// 收款人
//
//				String msg = detail.get("YPMC") + "";
//				int msg_len = msg.length();
//				if (msg.length() > 15) {
//					msg_len = 15;
//				}
//				invoiceInfo.put("ProductName", msg.substring(0, msg_len));// 商品名称
//
//				// invoiceInfo.put("ProductName",detail.get("YPMC"));//商品名称
//				invoiceInfo.put("ProductUnit", StrUtil.null2Str(detail.get("YFDW")));// 商品计量单位
//				invoiceInfo.put("ProductSpec", StrUtil.null2Str(detail.get("YFGG")));// 商品规格
//				invoiceInfo.put("ProductQuantity", detail.get("YPSL"));// 商品数量
//				if (Double.parseDouble(detail.get("ZFBL").toString()) > 1) {
//					invoiceInfo.put("ProductValue", Double.parseDouble(detail.get("YPDJ").toString())
//							* Double.parseDouble(detail.get("ZFBL").toString()));// 商品价格
//					// invoiceInfo.put("ProductAmount",
//					// Double.parseDouble(detail.get("YPDJ").toString())*Double.parseDouble(detail.get("ZFBL").toString())*Double.parseDouble(detail.get("YPSL").toString()));//商品金额
//
//					invoiceInfo.put("ProductAmount",
//							Double.parseDouble(detail.get("YPDJ").toString())
//									* Double.parseDouble(detail.get("ZFBL").toString())
//									* Double.parseDouble(detail.get("YPSL").toString())
//									* Double.parseDouble(detail.get("CFTS").toString()));// 商品金额
//
//				} else {
//					invoiceInfo.put("ProductValue", detail.get("YPDJ"));// 商品价格
//					invoiceInfo.put("ProductAmount", detail.get("HJJE"));// 商品金额
//				}
//				invoiceInfo.put("TaxRate", 0);// 税率
//				invoiceInfo.put("ProductTax", 0);// 商品税额
//				invoiceInfo.put("DiscountValue", 0);// 折扣金额
//				invoiceInfo.put("DiscountTax", 0);// 折扣税额
//				invoiceInfo.put("MachineNr", "");// 开票机号
//				invoiceInfo.put("TaxItem", "");// 明细税目
//				invoiceInfo.put("GoodsNoVer", "30.0");// 编码版本号
//				invoiceInfo.put("GoodsTaxNo", "3070202");// 税收分类编码
//				invoiceInfo.put("TaxPre", "1");// 是否享受优惠政策
//				invoiceInfo.put("TaxPreCon", "免税");// 享受税收优惠政策内容
//				invoiceInfo.put("ZeroTax", "1");// 零税率标识
//				invoiceInfo.put("TaxDeduction", 0);// 扣除额
//				invoiceInfo.put("AlternateKey", "");// 备用关键字
//
//				if (null != body.get("ALTERNATEKEY_ZZJ")) {// 自助机传入备注信息
//					invoiceInfo.put("AlternateKey", body.get("ALTERNATEKEY_ZZJ") + "");// 备用关键字
//
//				}
//
//				StringBuffer invoiceSql = new StringBuffer();
//				invoiceSql.append(
//						"insert into Tbl_Cust_DocMaster (InvKind,DocumentNr,DocumentDate,CustomerName,CustomerTaxNr,CustomerAddressTel,CustomerBankAccountNr,Invoicer,Checker,Payee,ProductName,ProductSpec,ProductUnit,");
//				invoiceSql.append(
//						"ProductQuantity,ProductValue,ProductAmount,TaxRate,ProductTax,DiscountValue,DiscountTax,MachineNr,TaxItem,GoodsNoVer,GoodsTaxNo,TaxPre,TaxPreCon,ZeroTax,TaxDeduction,AlternateKey");
//				invoiceSql.append(")");
//				invoiceSql.append(" values (");
//				invoiceSql.append(
//						":InvKind,:DocumentNr,:DocumentDate,:CustomerName,:CustomerTaxNr,:CustomerAddressTel,:CustomerBankAccountNr,:Invoicer,:Checker,:Payee,:ProductName,:ProductSpec,:ProductUnit,");
//				invoiceSql.append(
//						":ProductQuantity,:ProductValue,:ProductAmount,:TaxRate,:ProductTax,:DiscountValue,:DiscountTax,:MachineNr,:TaxItem,:GoodsNoVer,:GoodsTaxNo,:TaxPre,:TaxPreCon,:ZeroTax,:TaxDeduction,:AlternateKey");
//				invoiceSql.append(")");
//				dao.doSqlUpdate(invoiceSql.toString(), invoiceInfo);
//			}
//			// 检查旧发票号码是否已经开了发票，没开发票就删除Tbl_Cust_DocMaster中对应的记录
//			Map<String, Object> countParam = new HashMap<String, Object>(16);
//			countParam.put("DocumentNr", yfphm);
//
//			String ZZSFPDY = "";
//			PublicService publicService = new PublicService();
//			Map<String, Object> Pamargs = publicService.doLoadThisComputerArgs(Param.instance().put("names", "ZZSFPDY"),
//					res, dao, ctx);
//			ZZSFPDY = StrUtil.null2Str(Pamargs.get("ZZSFPDY"));
//			if (ZZSFPDY.equals("1")) { // 启用增值税发票
//				dao.doSqlUpdate("delete from Tbl_Cust_DocMaster where DocumentNr=:DocumentNr", countParam);
//				// 去作废增值税发票
//				Map<String, Object> request = new HashMap<String, Object>(16);
//				request.put("FPHM", yfphm);
//				request.put("FPLX", "MZ");
//				PHISCommonModel phis = new PHISCommonModel(dao);
//				// phis.doCancelinv(request);
//				phis.doCancelinv_jk(request, res, ctx);
//			} else {
//				List<Map<String, Object>> countList = dao.doSqlQuery(
//						"select count(*) as TOTAL from Tbl_Result where DocumentNr=:DocumentNr", countParam);
//				if (countList != null && 0 == Long.parseLong(countList.get(0).get("TOTAL") + "")) {
//					dao.doSqlUpdate("delete from Tbl_Cust_DocMaster where DocumentNr=:DocumentNr", countParam);
//				}
//			}
////				List<Map<String, Object>> countList=dao.doSqlQuery("select count(*) as TOTAL from Tbl_Result where DocumentNr=:DocumentNr", countParam);
////				if(countList!=null&&0==Long.parseLong(countList.get(0).get("TOTAL")+"")){
////					dao.doSqlUpdate("delete from Tbl_Cust_DocMaster where DocumentNr=:DocumentNr", countParam);
////				}
//		}
//		Session ss = (Session) ctx.get(Context.DB_SESSION);
//		ss.flush();
		return resp;
	}

	/**
	 * 退号
	 *
	 * @param req
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doSaveRetireRegistered(SaveRetireRegistReq req) {
		Map<String, Object> body = MzUtil.caseInsensitiveMap(req);
		String sbxh = body.get("SBXH") + "";
		String fphm = body.get("FPHM") + "";
		String YBSYPB = sysXtcsCacheSer.getCsz(req.getJgid(), "YBSYPB");
		if (req.getIsYb().intValue() == 1 && "0".equals(YBSYPB)) {
			SettleResultDTO result = new SettleResultDTO();
			body.put("ywlx", "1");
			Map<String, Object> feeMap = medicalInsuranceService.queryMedicalInsuranceTranInfo(body);
			if(feeMap==null||"".equals(feeMap.get("LSH"))){
				throw BaseException.create("ERROR_SHYB_0043");
			}if("1".equals(feeMap.get("ZFPB"))){
				throw BaseException.create("ERROR_SHYB_0050");
			}
			Map<String, Object> map = new HashMap<String, Object>();
			String orgid = "";
			Map map_orgid = opMzlbDao.getYbjgdm(req.getJgid(), req.getIp());
			if (map_orgid != null && !map_orgid.isEmpty()) {
				orgid = map_orgid.get("ybjgid").toString();
			} else {
				throw BaseException.create("ERROR_SHYB_0015");
			}
			String carddata = req.getJzkh();
			String cardtype = req.getCardtype();
			map.put("carddata", carddata);
			map.put("cardtype", cardtype);
			map.put("orgid", orgid);
			map.put("jgid", req.getJgid());
			map.put("ygdm", req.getYgdm());
			map.put("ygxm", req.getYgxm());
			map.put("xsywlx", "");
			map.put("jyqd", "10");
			map.put("ip", req.getIp());
			map.put("sbxh", sbxh);
			result = unifiedBusinessService.sk01(map, feeMap);
			if (result.getCode() == 200
					&& org.apache.commons.lang3.StringUtils.isNotBlank(StrUtil.null2Str(result.getData()))) {
				String reStr = result.getData().toString();
				Map<String, Object> resMap = JackJsonUtil.parse(reStr, HashMap.class);
				medicalInsuranceService.saveSk01RequireNew(resMap, map, feeMap);
			} else {
				throw BaseException.create("ERROR_SHYB_0024",
						new String[] { result.getCode() + "--" + result.getMsg() + "" });
			}
		}

		Map<String, Object> opYspbParameters = new HashMap<String, Object>(16);
		Map<String, Object> opGhmxParameters = new HashMap<String, Object>(16);
		Map<String, Object> opGhksParameters = new HashMap<String, Object>(16);

		// 判断是否开诊断
		Integer zdCount = opBrzdDao.doQueryCountByJzlsh(req.getJzlsh());
		if (zdCount != null && zdCount.intValue() > 0) {
			throw BaseException.create("ERROR_REG_0089");
		}
		// 判断是否开医技
		Integer yjCount = opYjcf01Dao.doQueryCountByJzlsh(req.getJzlsh());
		if (yjCount != null && yjCount.intValue() > 0) {
			throw BaseException.create("ERROR_REG_0088");
		}
		// 判断是否开过处方
		Integer cfCount = opCf01Dao.doQueryCountByJzlsh(req.getJzlsh());
		if (cfCount != null && cfCount.intValue() > 0) {
			throw BaseException.create("ERROR_REG_0087");
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar startc = Calendar.getInstance();
		opGhmxParameters.put("SBXH", Long.parseLong(sbxh));
		opGhmxParameters.put("thbz", 1);
		opGhmxDao.updateThbz(opGhmxParameters);

		Integer sbxhIn = Integer.valueOf(sbxh);
		OpGhmx opGhmx = opGhmxDao.getById(sbxhIn);
		Map<String, Object> opGhmxMap = MzUtil.caseInsensitiveMap(opGhmx);
//			startc.setTime(new Date());
		int hour = startc.get(Calendar.HOUR_OF_DAY);
//		int zblb = 0;
//		if (hour < 12) {
//			zblb = 1;
//		} else {
//			zblb = 2;
//		}
		Map<String, Object> opThmxMap = new HashMap<String, Object>(16);
		opThmxMap.put("SBXH", Long.parseLong(sbxh));
		opThmxMap.put("JGID", req.getJgid());
		opThmxMap.put("CZGH", req.getYgdm());
		opThmxMap.put("MZLB", opGhmxMap.get("MZLB"));
		opThmxMap.put("THRQ", DateUtil.date().toTimestamp());

		OpThmx opThmx = BeanUtil.fillBeanWithMapIgnoreCase(opThmxMap, new OpThmx(), true);
//		opThmx.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_THMX));
		opThmx.setJzlsh(req.getJzlsh());
		opThmxDao.insert(opThmx);
//		if (sdf.format(new Date()).equals(sdf.format((Date) opGhmxMap.get("GHSJ")))
//				&& Integer.parseInt(opGhmxMap.get("GHLB") + "") == zblb) {
		// 更新挂号科室表已挂人数
		opGhksParameters.put("JGID", req.getJgid());
		opGhksParameters.put("KSDM", Long.parseLong(opGhmxMap.get("KSDM") + ""));
		opGhksDao.updateYgrs(opGhksParameters);
//		} else if (sdf.format(new Date()).equals(sdf.format((Date) opGhmxMap.get("GHSJ")))
//				&& Integer.parseInt(opGhmxMap.get("GHLB") + "") == 2) {
//				int GHRQ = startc.get(Calendar.DAY_OF_WEEK);
//			opGhksParameters.put("JGID", req.getJgid());
//			opGhksParameters.put("KSDM", Long.parseLong(opGhmxMap.get("KSDM") + ""));
////				OP_GHKS_parameters.put("GHRQ", GHRQ);
//			opGhksParameters.put("GHRQ", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//			opGhksParameters.put("ZBLB", 2);
//			opKspbDao.updateByTh(opGhksParameters);
//		} else if (((Date) opGhmxMap.get("GHSJ")).getTime() > System.currentTimeMillis()) {
		startc.setTime((Date) opGhmxMap.get("GHSJ"));
//				int GHRQ = startc.get(Calendar.DAY_OF_WEEK);
		// 更新科室排班已挂人数
		opGhksParameters.put("JGID", req.getJgid());
		opGhksParameters.put("KSDM", Long.parseLong(opGhmxMap.get("KSDM") + ""));
		opGhksParameters.put("GHRQ", DateUtil.date(opGhmx.getGhsj()));
		opGhksParameters.put("ZBLB", Integer.parseInt(opGhmxMap.get("GHLB") + ""));
		opKspbDao.updateByTh(opGhksParameters);
//		}
		if (opGhmxMap.containsKey("YSDM")) {
			Date ldtBegin = DateUtil.beginOfDay(DateUtil.parse(opGhmxMap.get("GHSJ") + "", "yyyy-MM-dd"));
			Date ldtEnd = DateUtil.endOfDay(DateUtil.parse(opGhmxMap.get("GHSJ") + "", "yyyy-MM-dd"));
			opYspbParameters.put("JGID", req.getJgid());
			opYspbParameters.put("ldt_begin", ldtBegin);
			opYspbParameters.put("ldt_end", ldtEnd);
			opYspbParameters.put("YSDM", opGhmxMap.get("YSDM"));
			opYspbParameters.put("ZBLB", Integer.parseInt(opGhmxMap.get("GHLB") + ""));
			opYspbParameters.put("KSDM", Long.parseLong(opGhmxMap.get("KSDM") + ""));
			opYspbParameters.put("GZRQ", DateUtil.date());
			opYspbDao.updateYgrsSub(opYspbParameters);
		}

		// POS机退费，保存OP_POSMX表
		@SuppressWarnings("unchecked")
		Map<String, Object> pos = (Map<String, Object>) body.get("pos");
		if (pos != null && pos.get("PosTraceNumber") != null) {
			Map<String, Object> posInfo = new HashMap<String, Object>(16);
//				@SuppressWarnings("unchecked")
//				Map<String,Object> mapid=dao.doSqlLoad("select SEQ_OP_POSMX.nextval as id from dual");
//				posInfo.put("ID", mapid.get("id"));
			SimpleDateFormat mmoo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			posInfo.put("JYSJ", mmoo.format(new Date()));
			posInfo.put("JYLB", pos.get("TransType"));
			posInfo.put("FPHM", fphm);
			OpPosmx msOpPosmx = BeanUtil.fillBeanWithMapIgnoreCase(posInfo, new OpPosmx(), true);
			msOpPosmx.setId(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_POSMX));
			opPosmxDao.insert(msOpPosmx);
		}
		// 预付卡退费
		List<Map<String, Object>> list = mpiKpxxDao.getMpiKpxxInfo(fphm);
		if (list.size() == 0) {

		} else {
			int brid = Integer.parseInt(ObjectToTypes.null2Str(list.get(0).get("BRID")));
			Map<String, Object> data = new HashMap<String, Object>(16);
			data.put("CARDNO", list.get(0).get("CARDNO"));// carno
			data.put("CZTYPE", "10");
			data.put("AMOUNT", list.get(0).get("TFJE"));// amount
			data.put("CZGH", req.getYgdm());// czgh
			data.put("CZIP", req.getIp());// czip
			data.put("CZSJ", DateUtil.date().toTimestamp());// czsj
			data.put("BRID", brid);// BRID
			data.put("FPHM", fphm);// fphm
			data.put("LASTKNYE", Double.parseDouble(list.get(0).get("KNYE").toString()));// lastknye

			Map<String, Object> map = new HashMap<String, Object>(16);
			map.put("KNYE", Double.parseDouble(ObjectToTypes.null2Str(list.get(0).get("TFJE"))));
			map.put("BRID", list.get(0).get("BRID"));
			map.put("status", 0);
			mpiKpxxDao.updateKnyeByCondition(map);

			OpCzjl opCzjl = BeanUtil.fillBeanWithMapIgnoreCase(data, new OpCzjl(), true);
			opCzjl.setCzxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CZJL));
			opCzjl.setJzlsh(req.getJzlsh());
			opCzjlDao.insert(opCzjl);
		}
//		Session session = (Session) ctx.get(Context.DB_SESSION);
//		session.flush();
		// 排队系统 退号处理
		// doMzth(Long.parseLong(SBXH), ctx);
//		if (body.containsKey("YBXX")) {
//			MedicareInterface model = new HZSMedicareModel(dao);
//			model.saveYbGhth((Map<String, Object>) body.get("YBXX"));
//		}
		// else if(body.containsKey("jyqr")){
		// Map<String,Object> jyqr = (Map<String,Object>)body.get("jyqr");
		// MedicareSYBModel msm = new MedicareSYBModel(dao);
		// msm.doSaveSzYbjyqr("update", jyqr, res, ctx);
		// }

		// 如果非商保病人
//		if (!(Constants.BRXZ_SYBX + "").equals(body.get("XZDM") + "")) {
//			Map<String, Object> countParam = new HashMap<String, Object>(16);
//			countParam.put("DocumentNr", FPHM);
//			String ZZSFPDY = "";
//			PublicService publicService = new PublicService();
//			Map<String, Object> Pamargs = publicService.doLoadThisComputerArgs(Param.instance().put("names", "ZZSFPDY"),
//					res, dao, ctx);
//			ZZSFPDY = StrUtil.null2Str(Pamargs.get("ZZSFPDY"));
//			if (ZZSFPDY.equals("1")) { // 启用增值税发票
//				dao.doSqlUpdate("delete from Tbl_Cust_DocMaster where DocumentNr=:DocumentNr", countParam);
//				// 去作废增值税发票
//				Map<String, Object> request = new HashMap<String, Object>(16);
//				request.put("FPHM", FPHM);
//				request.put("FPLX", "GH");
//				PHISCommonModel phis = new PHISCommonModel(dao);
//				// phis.doCancelinv(request);
//				phis.doCancelinv_jk(request, res, ctx);
//			} else {// 未启用增值税
//				// 根据发票号码检查是否已经开了发票，没开发票就删除Tbl_Cust_DocMaster中对应的记录
//				List<Map<String, Object>> countList = dao.doSqlQuery(
//						"select count(*) as TOTAL from Tbl_Result where DocumentNr=:DocumentNr", countParam);
//				if (countList != null && 0 == Long.parseLong(countList.get(0).get("TOTAL") + "")) {
//					dao.doSqlUpdate("delete from Tbl_Cust_DocMaster where DocumentNr=:DocumentNr", countParam);
//				}
//			}
//		}
	}

	/**
	 * 校验库存信息
	 *
	 * @param req
	 * @param jgid
	 * @return
	 */
	public JsCheckInventoryResp doCheckInventory(JsCheckInventoryReq req, Integer jgid) {
		Map<String, Object> body = MzUtil.caseInsensitiveMap(req);
		Map<String, Object> respMap = mzUtil.checkInventory(body, jgid);
		JsCheckInventoryResp resp = BeanUtil.fillBeanWithMapIgnoreCase(respMap, new JsCheckInventoryResp(), true);
		return resp;
	}

	/**
	 * 获取药品组套明细
	 *
	 * @param req
	 * @return
	 */
	public List<LoadMedcineSetResp> doLoadMedcineSet(LoadMedcineSetReq req) {
		Map<String, Object> body = MzUtil.caseInsensitiveMap(req);
		long ztbh = Long.parseLong(body.get("YPXH") + "");
		List<Map<String, Object>> rebody = new ArrayList<Map<String, Object>>();
		// 发药药房 和 药品类别
		Object pharmacyId = body.get("pharmacyId");
		List<OpZt02Resp> zt02List = opZt02Service.findByZtbh(req.getZtbh());
		List<Map<String, Object>> list = MzUtil.ListObjToMap(zt02List);
		for (Map<String, Object> med : list) {
			Object ypxh = med.get("YPXH");
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("YFSB", Long.parseLong(pharmacyId.toString()));
			params.put("YPXH", ypxh);
			List<Map<String, Object>> meds = opMzxxDao.getYktypkInfo(params);
			if (meds.size() > 0) {
				Map<String, Object> zt_med = meds.get(0);// 默认取第一条记录
				for (Map<String, Object> i_med : meds) {// 如果有库存数量大于所需数量的，就取那个。
					i_med.put("pharmId", i_med.get("YFSB"));
					i_med.put("medId", i_med.get("YPXH"));
					i_med.put("medsource", i_med.get("YPCD"));
					i_med.put("quantity", med.get("XMSL"));
					i_med.put("lsjg", i_med.get("LSJG"));
					Map<String, Object> yfck = mzUtil.checkInventory(i_med, req.getJgid());
					if (Integer.parseInt(yfck.get("sign") + "") > 0) {
						zt_med = i_med;
						break;
					}
				}
				Integer ybfl = Integer.parseInt(zt_med.get("YBFL") + "");
				String yBFL_text = "";
				if (ybfl == 1) {
					yBFL_text = "甲";
				} else if (ybfl == 2) {
					yBFL_text = "乙";
				} else if (ybfl == 2) {
					yBFL_text = "丙";
				}
				zt_med.put("YPMC", "(" + yBFL_text + ")" + zt_med.get("YPMC"));
				zt_med.put("YPZH", med.get("YPZH"));
				zt_med.put("YCJL", med.get("YCJL"));
				zt_med.put("YYTS", med.get("YYTS"));
				zt_med.put("YPSL", med.get("XMSL"));
				zt_med.put("HJJE",
						Double.parseDouble(zt_med.get("YPDJ") + "") * Double.parseDouble(med.get("XMSL") + ""));
				zt_med.put("YPYF", med.get("SYPC"));
				zt_med.put("YPYF_text", med.get("SYPC_text"));
				zt_med.put("GYTJ", med.get("GYTJ"));
				zt_med.put("GYTJ_text", med.get("GYTJ_text"));
				zt_med.put("BZMC", med.get("BZMC"));
				zt_med.put("MRCS", med.get("MRCS"));
				zt_med.put("SYPC", med.get("SYPC"));
				zt_med.put("SYPC_text", med.get("SYPC_text"));
				// 获取组套中药品自负比例和库存数量
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("TYPE", zt_med.get("TYPE"));
				data.put("CFLX", zt_med.get("TYPE"));
				data.put("FYXH", zt_med.get("YPXH"));
				data.put("BRXZ", body.get("BRXZ"));
				data.put("FYGB", zt_med.get("FYGB"));
				Map<String, Object> zfbl = mzUtil.getPayProportion(data);
				zt_med.put("ZFBL", zfbl.get("ZFBL"));
				// zt_med.put("YPYF", zt_med.get("SYPC"));
				zt_med.put("ZTBH", ztbh);
				rebody.add(zt_med);
			} else {
				throw BaseException.create("ERROR_REG_0062", new String[] { med.get("YPMC").toString() });
			}
		}
		List<LoadMedcineSetResp> resp = MzUtil.ListToResultSet(rebody, new LoadMedcineSetResp());
		return resp;
	}

	/**
	 * 预保存
	 *
	 * @param req
	 */
	@Transactional(rollbackFor = Exception.class)
	public void saveSettle(OutpatientSettlementReq req) {
		List<Map<String, Object>> datas = MzUtil.ListObjToMap(req.getList());
		Map<String, Object> body = new HashMap<String, Object>();
		Map<String, Object> res = new HashMap<String, Object>();
		body.put("body", datas);
		doSaveSettle(body, res, req);
	}

	/**
	 * 处置组套-获取项目组套明细
	 *
	 * @param req
	 * @return
	 */
	public List<LoadProjectSetResp> doLoadProjectSet(LoadMedcineSetReq req) {
		Map<String, Object> body = MzUtil.caseInsensitiveMap(req);
		String brxz = body.get("BRXZ") + "";
		long ztbh = Long.parseLong(body.get("YPXH") + "");
		List<Map<String, Object>> rebody = new ArrayList<Map<String, Object>>();
		// 发药药房 和 药品类别
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ztbh", ztbh);
		List<Map<String, Object>> list = opZt02Service.getZtInfoByZtbh(param);
		for (Map<String, Object> med : list) {
			Object ypxh = Long.parseLong(med.get("XMBH") + "");
			Map<String, Object> params = new HashMap<String, Object>();
			// params.put("YFSB", Long.parseLong(pharmacyId.toString()));
			params.put("YPXH", ypxh);
			params.put("JGID", req.getJgid());

			List<Map<String, Object>> meds = new ArrayList<Map<String, Object>>();
			if (brxz.equals("6024")) {
				meds = feeYlsfxmDao.getYlsfInfoBybrxzOne(params);
			} else {
				meds = feeYlsfxmDao.getYlsfInfoBybrxzTwo(params);
			}
			if (meds.size() > 0) {// 取第一条记录
				Map<String, Object> zt_med = meds.get(0);
				// zt_med.putAll(med);
				zt_med.put("YPZH", med.get("YPZH"));
				zt_med.put("YPSL", med.get("XMSL"));
				zt_med.put("HJJE",
						Double.parseDouble(zt_med.get("LSJG") + "") * Double.parseDouble(med.get("XMSL") + ""));
				zt_med.put("YPYF", med.get("SYPC"));
				zt_med.put("YPYF_text", med.get("SYPC_text"));
				zt_med.put("GYTJ", med.get("GYTJ"));
				zt_med.put("GYTJ_text", med.get("GYTJ_text"));
				zt_med.put("BZMC", med.get("BZMC"));
				zt_med.put("MRCS", med.get("MRCS"));
				zt_med.put("SYPC", med.get("SYPC"));
				zt_med.put("SYPC_text", med.get("SYPC_text"));
				// 获取组套中药品自负比例和库存数量
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("TYPE", zt_med.get("TYPE"));
				data.put("FYXH", zt_med.get("YPXH"));
				data.put("BRXZ", body.get("BRXZ"));
				data.put("FYGB", zt_med.get("FYGB"));
				Map<String, Object> zfbl = mzUtil.getPayProportion(data);
				zt_med.put("ZFBL", zfbl.get("ZFBL"));
				zt_med.put("ZTBH", ztbh);
				rebody.add(zt_med);
			} else {
				throw BaseException.create("ERROR_REG_0063", new String[] { med.get("XMMC").toString() });
			}
		}
		List<LoadProjectSetResp> resp = MzUtil.ListToResultSet(rebody, new LoadProjectSetResp());
		return resp;
	}

	/**
	 * 划价收费获取物资价格
	 *
	 * @param req
	 * @return
	 */
	public BigDecimal doQueryMaterialsPrice(QueryMaterialsPriceReq req) {
		Map<String, Object> parameterswzxh = new HashMap<String, Object>();
		Map<String, Object> parameterswzjg = new HashMap<String, Object>();
		Map<String, Object> parameterjgbz = new HashMap<String, Object>();
		Map<String, Object> parameterskfxh = new HashMap<String, Object>();
		String jgid = String.valueOf(req.getJgid());
		int wpjfbz = Integer.parseInt(sysXtcsCacheSer.getCsz(req.getJgid(), "MZWPJFBZ"));
		int wzsfxmjg = Integer.parseInt(sysXtcsCacheSer.getCsz(req.getJgid(), "WZSFXMJG"));

		if (wzsfxmjg != 1 || wpjfbz != 1) {
			return BigDecimal.ZERO;
		}
		Map<String, Object> body = MzUtil.caseInsensitiveMap(req);
		long fyxh = Long.parseLong(body.get("YPXH") + "");
		double bzjg = Double.parseDouble(body.get("LSJG") + "");
		long KSDM = Long.parseLong(body.get("KSDM") + "");
		double czsl = Double.parseDouble(body.get("YPSL") + "");
		// 查询jgbz
		parameterjgbz.put("fyxh", fyxh);
		parameterjgbz.put("jgid", jgid);
		Map<String, Object> jgbzMap = feeYlsfxmdjDao.getJgbz(parameterjgbz);
		int jgbz = 0;
		if (jgbzMap != null) {
			if (jgbzMap.get("JGBZ") != null) {
				jgbz = Integer.parseInt(jgbzMap.get("JGBZ") + "");
			}
		}
		// 查询kfxh
		parameterskfxh.put("ksdm", KSDM);
		Map<String, Object> kfxhMap = wlKfdzDao.findKfxh(parameterskfxh);
		int kfxh = 0;
		if (kfxhMap != null) {
			if (kfxhMap.get("KFXH") != null) {
				kfxh = Integer.parseInt(kfxhMap.get("KFXH") + "");
			}
		} else {
			throw BaseException.create("ERROR_REG_0064");
		}
		// 查询wzsl
		parameterswzxh.put("FYXH", fyxh);
		parameterswzxh.put("JGID", jgid);
		// 根据fyxh取对应的wzxh
		List<Map<String, Object>> lisWZXH = feeXmzxksDao.queryObj(parameterswzxh);
		double wzjg = 0.00;
		double czje = 0.00;
		for (int i = 0; i < lisWZXH.size(); i++) {
			// 查询物资信息
			double wzslall = czsl * Double.parseDouble(lisWZXH.get(i).get("WZSL") + "");// 取到第一个物资的实际数量
			parameterswzjg.put("WZXH", Long.parseLong(lisWZXH.get(i).get("WZXH") + ""));
			parameterswzjg.put("JGID", jgid);
			parameterswzjg.put("KFXH", kfxh);
			List<Map<String, Object>> lisWZKC = wlWzkcDao.findSuppliesAmount(parameterswzjg);

			if (lisWZKC.size() == 0) {
				// msg = "项目为：" + FYMC + "所对应的的物资名称：" + WZMC_TS
				// + "库存不足不能保存!";
				throw BaseException.create("ERROR_REG_0065", new String[] { lisWZXH.get(i).get("WZMC").toString() });
			}
			for (int j = 0; j < lisWZKC.size(); j++) {// 第一个去做的金额
				double wzsl = Double.parseDouble(lisWZKC.get(j).get("WZSL") + "");
				double yksl = Double.parseDouble(lisWZKC.get(j).get("YKSL") + "");
				if ((j == (lisWZKC.size() - 1)) && wzslall > (wzsl - yksl)) {
					throw BaseException.create("ERROR_REG_0065",
							new String[] { lisWZXH.get(i).get("WZMC").toString() });
				}
				if (wzslall <= (wzsl - yksl)) {
					if (jgbz == 1) {
						wzjg = Double.parseDouble(lisWZKC.get(j).get("WZJG") + "");
					} else {
						wzjg = bzjg;
					}
					czje += wzslall * wzjg;
					break;
				} else if (wzslall > (wzsl - yksl)) {
					wzslall = wzslall - (wzsl - yksl);
					if (jgbz == 1) {
						wzjg = Double.parseDouble(lisWZKC.get(j).get("WZJG") + "");
					} else {
						wzjg = bzjg;
					}
					czje += (wzsl - yksl) * wzjg;
				}
			}
		}
		double wzdj = czje / czsl;
		BigDecimal resp = BigDecimal.valueOf(wzdj);
		return resp;
	}

	/**
	 * 门诊结算发票打印
	 *
	 * @param req
	 */
	@Transactional(rollbackFor = Exception.class)
	public PrintMzxxResp doPrintMoth(PrintMzxxReq req) {
		Map<String, Object> request = MzUtil.caseInsensitiveMap(req);
		Map<String, Object> response = new HashMap<String, Object>();
		String fphm = request.get("fphm") + "";
		String ZSFPHM = request.get("ZSFPHM") + "";
		boolean isYb = request.containsKey("isYb") ? (Boolean) request.get("isYb") : false;
		String JGID = String.valueOf(req.getJgid());
		String jgname = req.getJgName();

		String MZFPFDFS = sysXtcsCacheSer.getCsz(req.getJgid(), "MZFPFDFS"); // 门诊发票分单方式
		String MZFPSFLD = sysXtcsCacheSer.getCsz(req.getJgid(), "MZFPSFLD"); // 门诊发票是否连打
		String MZFPMXSL = sysXtcsCacheSer.getCsz(req.getJgid(), "MZFPMXSL");// 门诊发票连打明细数量
		String VIPBRXZ = sysXtcsCacheSer.getCsz(req.getJgid(), "VIPBRXZ");// 获取VIP
		String GHDYFS = sysXtcsCacheSer.getCsz(req.getJgid(), "GHDYFS");// 挂号发票打印方式1-公立医院发票2-私立医院发票3-宏德医院样式
		String NSRSBH = sysXtcsCacheSer.getCsz(req.getJgid(), "NSRSBH");// 挂号发票打印方式1-公立医院发票2-私立医院发票3-宏德医院样式
		String[] VIPBRXZS = VIPBRXZ.split(",");
		List<Map<String, Object>> mzfps = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> mzfpInfolist = new ArrayList<Map<String, Object>>();
		int page = 1;
		Map<String, Object> jhhmMap = new HashMap<String, Object>();
		Map<String, Object> mzfpInfo = null;
		jhhmMap.put("fphm", fphm);
		//取发药叫号号码
		Map<String, Object> pdhm = opCf01Dao.doQueryMinJhhm(jhhmMap);
		if ("0".equals(MZFPFDFS)) {
			if ("1".equals(MZFPSFLD) && Integer.parseInt(MZFPMXSL) > 0) {
				// =============================================================
				Map<String, Object> parameters = new HashMap<String, Object>();
				Map<String, Object> MZXX = new HashMap<String, Object>();
				List<Map<String, Object>> SFXMS = new ArrayList<Map<String, Object>>();
				parameters.put("FPHM", fphm);
				parameters.put("JGID", JGID);
				//获取门诊信息总计金额以及病人信息
				Map<String, Object> parameters2 = new HashMap<String, Object>(16);
				parameters2.put("HBWC", "1");
				parameters2.put("SYLX", 1);
				List<Map<String, Object>> map = pubFkfsService.getPubFkfsInfo(parameters2);
				Long fkfs = map.get(0).get("FKFS") != null ? Long.parseLong(map.get(0).get("FKFS").toString()) : 0;

				parameters.put("HBWC", fkfs);
				MZXX = opMzxxDao.doQueryMzxxJeInfo(parameters).get(0);
				Map<String, Object> parameters1 = new HashMap<String, Object>();
				parameters1.put("MZXH", MZXX.get("MZXH"));
				Boolean isVIP = false;// 是否是VIP病人
				for (int i = 0; i < VIPBRXZS.length; i++) {
					if (VIPBRXZS[i].toString().equals(MZXX.get("BRXZ").toString())) {
						isVIP = true;
					}
				}
//					String JGID = user.getManageUnit().getId();
				List<Map<String, Object>> details = opCf01Dao.doQueryCfDetail(parameters1);
				// for自备药
				for (Map<String, Object> d : details) {
					if (Integer.parseInt(d.get("ZFYP") + "") == 1) {
						d.put("YPMC", "(自备)" + d.get("YPMC"));
					}
				}
				int n = details.size() / Integer.parseInt(MZFPMXSL);
				if (Integer.parseInt(MZFPMXSL) * n < details.size()) {
					n++;
				}
				for (int jk = 0; jk < n; jk++) {
					Map<String, Object> mzfp = new HashMap<String, Object>();
					mzfpInfo = new HashMap<String, Object>();
					int maxdetal = (jk + 1) * Integer.parseInt(MZFPMXSL);
					if (maxdetal > details.size()) {
						maxdetal = details.size();
					}
					int k = 0;
					for (int i = (jk) * Integer.parseInt(MZFPMXSL); i < maxdetal; i++) {
						Map<String, Object> detail = details.get(i);
						mzfp.put("HMBM" + (++k), detail.get("HMBM"));
						mzfp.put("MXMC" + (k), detail.get("YPMC"));
						mzfp.put("MXBM" + (k), detail.get("YPBM"));
						mzfp.put("MXGG" + (k), detail.get("YPGG"));
						mzfp.put("MXSL" + (k), detail.get("YPSL"));
						mzfp.put("MXDJ" + (k), detail.get("YPDJ"));// ----------药品单价--------------------
						mzfp.put("MXJE" + (k), detail.get("HJJE"));// ------------合计金额--------------------
						// =======获取支付比例======
//							Map<String, Object> body = new HashMap<String, Object>();
//							body.put("TYPE", detail.get("TYPE"));
//							body.put("FYXH", detail.get("FYXH"));
//							body.put("FYGB", detail.get("FYGB"));
//							body.put("BRXZ", MZXX.get("BRXZ"));
//							Map<String, Object> zfbl_map =mzUtil.getPayProportion(body, ctx, dao);
						// 设置系统参数，如果是VIP病人,重新计算获得药品单价和合计金额
						if (isVIP) {
							mzfp.put("MXDJ" + (k), ObjectToTypes.parseDouble(detail.get("YPDJ"))
									* ObjectToTypes.parseDouble(detail.get("ZFBL")));// ----------药品单价--------------------
							mzfp.put("MXJE" + (k),
									ObjectToTypes.parseDouble(detail.get("YPDJ"))
											* ObjectToTypes.parseDouble(detail.get("ZFBL"))
											* ObjectToTypes.parseDouble(detail.get("YPSL")));// ------------合计金额--------------------
						}

						mzfp.put("YSDM" + (k), detail.get("YSDM"));
						mzfp.put("YSXM" + (k), detail.get("YSXM"));
						mzfp.put("YFDW" + (k), detail.get("YFDW"));
						if (detail.get("KSMC") != null && (detail.get("KSMC").toString().indexOf("队") > 0
								|| detail.get("KSMC").toString().indexOf("点") > 0
								|| detail.get("KSMC").toString().indexOf("所") > 0
								|| detail.get("KSMC").toString().indexOf("医") > 0)) {
							if (!mzfp.containsKey("KSMC")) {
								mzfp.put("KSMC", detail.get("KSMC").toString().substring(0, 2));
							}
						}
					}
					if (jk == 0) {
						String[] upint = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
						// =======如果是VIP病人获取ZFJE=========
//						if (isVIP) {
//							hql1.delete(0, hql1.length());
//							hql1 = hql1.append(
//									" select b.MZGB as MZGB,nvl(b.MCSX,b.SFMC) as MCSX,sum(a.ZFJE) as ZJJE,b.MZPL as MZPL from  DIC_SFXMLB b left outer join OP_SFMX a on a.SFXM = b.SFXM and a.MZXH = :MZXH group by b.MZGB,b.MZPL,b.MCSX,b.SFMC");
//						}
						SFXMS = dicSfxmlbService.doQueryGbje(parameters1);
						for (int i = 0; i < SFXMS.size(); i++) {
							Map<String, Object> SFXM = SFXMS.get(i);
							if (SFXM.get("MZPL") != null && (SFXM.get("MZPL") + "").length() > 0) {
								if ("其 它".equals(SFXM.get("MCSX") + "") || "其它".equals(SFXM.get("MCSX") + "")) {
									mzfp.put("QTPL", SFXM.get("MZPL"));
									mzfp.put("SFXM" + SFXM.get("MZPL"), SFXM.get("MCSX") + "");
									if (SFXM.get("ZJJE") != null && (SFXM.get("ZJJE") + "").length() > 0) {
										mzfp.put("XMJE" + SFXM.get("MZPL"), SFXM.get("ZJJE") + "");
									} else {
										mzfp.put("XMJE" + SFXM.get("MZPL"), "0.00");
									}
									continue;
								} else {
									if (SFXM.get("ZJJE") != null && (SFXM.get("ZJJE") + "").length() > 0) {
										if (Double.parseDouble(SFXM.get("ZJJE") + "") > 0) {
											mzfp.put("SFXM" + SFXM.get("MZPL"), SFXM.get("MCSX") + "");
											mzfp.put("XMJE" + SFXM.get("MZPL"), SFXM.get("ZJJE") + "");
										}
										// } else {
										// response.put("XMJE" +
										// SFXM.get("MZPL"), "0.00");
									}
								}
							} else if (SFXM.get("ZJJE") != null && (SFXM.get("ZJJE") + "").length() > 0) {
								if (Double.parseDouble(SFXM.get("ZJJE") + "") > 0) {
									if (mzfp.containsKey("QTJE")) {
										mzfp.put("QTJE", (Double.parseDouble(mzfp.get("QTJE") + "")
												+ Double.parseDouble(SFXM.get("ZJJE") + "")) + "");
									} else {
										mzfp.put("QTJE", SFXM.get("ZJJE") + "");
									}
								}
							}
						}
						if (mzfp.containsKey("QTJE")) {
							if (mzfp.containsKey("XMJE" + mzfp.get("QTPL"))
									&& (mzfp.get("XMJE" + mzfp.get("QTPL")) + "").length() > 0) {
								mzfp.put("XMJE" + mzfp.get("QTPL"),
										Double.parseDouble(mzfp.get("XMJE" + mzfp.get("QTPL")) + "")
												+ Double.parseDouble(mzfp.get("QTJE") + ""));
							} else {
								mzfp.put("XMJE" + mzfp.get("QTPL"), Double.parseDouble(mzfp.get("QTJE") + ""));
							}
						} else {
							if (mzfp.containsKey("SFXM" + mzfp.get("QTPL"))) {
								mzfp.remove("SFXM" + mzfp.get("QTPL"));
								mzfp.remove("XMJE" + mzfp.get("QTPL"));
							}
						}
						mzfpInfo.put("XLH", MZXX.get("XLH") + "");
						mzfpInfo.put("HJJE", MZXX.get("HJJE") + "");
						// =======如果是VIP病人,合计金额需要乘以支付比例======
						if (isVIP) {
							mzfpInfo.put("HJJE", MZXX.get("JKJE") + "");
						}

						mzfpInfo.put("GRJF", (new BigDecimal(MZXX.get("XJJE").toString())).add(new BigDecimal(MZXX.get("ZPJE").toString())).toString());
						mzfpInfo.put("JZ", MZXX.get("JZ") + "");

						// TODO 注释掉
						/*
						 * double hjje = Double.parseDouble(MZXX.get("HJJE") + ""); int sw = (int) (hjje
						 * / 100000) % 10; int w = (int) (hjje / 10000) % 10; int q = (int) (hjje /
						 * 1000) % 10; int b = (int) (hjje / 100) % 10; int s = (int) (hjje / 10) % 10;
						 * int y = (int) (hjje) % 10; int j = (int) (hjje * 10) % 10; String fStr =
						 * String.format("%.0f", hjje * 100); int f = Integer.parseInt(fStr) % 10; if (f
						 * == 0) { String jStr = String.format("%.0f", hjje * 10); j =
						 * Integer.parseInt(jStr) % 10; } mzfpInfo.put("SW", upint[sw]);
						 * mzfpInfo.put("W", upint[w]); mzfpInfo.put("Q", upint[q]); mzfpInfo.put("B",
						 * upint[b]); mzfpInfo.put("S", upint[s]); mzfpInfo.put("Y", upint[y]);
						 * mzfpInfo.put("J", upint[j]); mzfpInfo.put("F", upint[f]);
						 */
						if ("6103".equals(MZXX.get("BRXZ") + "")) {
							mzfpInfo.put("BZ", "'小病'免费:3.00");
							mzfpInfo.put("GRZF", "个人缴费:"
									+ String.format("%1$.2f", (Double.parseDouble(MZXX.get("HJJE") + "") - 3.00)));
						}
						if ("6104".equals(MZXX.get("BRXZ") + "")) {
							mzfpInfo.put("GRZF", "个人缴费:3.00");
							mzfpInfo.put("BZ", "股民减免:"
									+ String.format("%1$.2f", (Double.parseDouble(MZXX.get("HJJE") + "") - 3.00)));
						}
						if ("6089".equals(MZXX.get("BRXZ") + "")) {
							mzfpInfo.put("BZ", "民政救助金额:" + MZXX.get("MZJZJE") + "");
						}
					}
					mzfpInfo.put("FPHM", fphm);
					// ==========天佑捷医
					if (!"null".equals(ZSFPHM) && !"".equals(ZSFPHM)) {
						mzfpInfo.put("FPHM", ZSFPHM);
					}
					// ==========天佑捷医
					mzfpInfo.put("POSJE", MZXX.get("POSJE"));
					mzfpInfo.put("ZFBJE", MZXX.get("ZFBJE"));
					mzfpInfo.put("FPFKFS", MZXX.get("FPFKFS"));
					mzfpInfo.put("FPFKMC", MZXX.get("FPFKMC"));
					mzfpInfo.put("FPFKJE", MZXX.get("FPFKJE"));
//						mzfp.put("FPFKJE", MZXX.get("FPFKJE"));

					mzfpInfo.put("XNFP", MZXX.get("XNFP") + "");
					mzfpInfo.put("YYYY", MZXX.get("YYYY") + "");
//						mzfp.put("MM", MZXX.get("MM") + "");
//						mzfp.put("DD", MZXX.get("DD") + "");
					mzfpInfo.put("XM", MZXX.get("XM") + "");
					mzfpInfo.put("BRXB", MZXX.get("BRXB") + "");
					mzfpInfo.put("JGMC", jgname);
					mzfpInfo.put("SFY", MZXX.get("SFY") + "");
					mzfpInfo.put("SFYGH", MZXX.get("SFYGH") + "");
					mzfpInfo.put("JSFS", MZXX.get("JSFS") + "");

					String fpyl = sysXtcsCacheSer.getCsz(req.getJgid(), "FPYL");
					String mzhjsfdyjmc = sysXtcsCacheSer.getCsz(req.getJgid(), "MZHJSFDYJMC");
					response.put("fpyl", fpyl);
					response.put("mzhjsfdyjmc", mzhjsfdyjmc);

					mzfpInfo.put("PAGE", "(" + page + "/" + MZXX.get("FPZS") + ")");
					mzfpInfo.putAll(getMzJsFyck(fphm));// 设置发药窗口
					//获取医保数据
					List<Map<String,Object>> ybxx =  opMzxxDao.doQueryybxxInfo(MZXX.get("MZXH") + "");
					if(!ybxx.isEmpty() && ybxx.size()>0){
						mzfpInfo.putAll(ybxx.get(0));
					}else{
						mzfpInfo.put("grzhzf", "0.00");
						mzfpInfo.put("ybtczf", "0.00");
						mzfpInfo.put("fjzf", "0.00");
						mzfpInfo.put("dnzhye", "0.00");
						mzfpInfo.put("lnzhye", "0.00");
						mzfpInfo.put("xjzfFlzf", "0.00");
						mzfpInfo.put("xjzfZifei", "0.00");
                        mzfpInfo.put("xjzf","0");
//						mzfp.putAll(getYbMzJsxx(MZXX.get("MZXH") + ""))
					};
					mzfpInfo.putAll(getBrkhByMzxh(MZXX.get("MZXH") + ""));

					mzfpInfo.put("JKJE", MZXX.get("JKJE") + "");
					mzfpInfo.put("JMJE", MZXX.get("JMJE") + "");
					mzfpInfo.put("TZJE", MZXX.get("TZJE") + "");

					mzfps.add(mzfp);
					mzfpInfolist.add(mzfpInfo);
					page++;
				}
				response.put("jhhm", pdhm.get("JHHM"));
				response.put("mzfps", mzfps);
				response.put("mzxh", MZXX.get("MZXH"));
			} else { //不连打
				Map<String, Object> mzfp = new HashMap<String, Object>();
				Map<String, Object> parameters = new HashMap<String, Object>();
				Map<String, Object> MZXX = new HashMap<String, Object>();
				List<Map<String, Object>> SFXMS = new ArrayList<Map<String, Object>>();
				parameters.put("FPHM", fphm);
				parameters.put("JGID", JGID);
				MZXX = opMzxxDao.doQueryMzxxPosAndZfbJe(parameters);
				Map<String, Object> parameters1 = new HashMap<String, Object>();
				parameters1.put("MZXH", MZXX.get("MZXH"));
				List<Map<String, Object>> details = opCf01Dao.doQueryCfDetail(parameters1);
				// add by caijy at 2014.10.8 for自备药
				for (Map<String, Object> d : details) {
					if (Integer.parseInt(d.get("ZFYP") + "") == 1) {
						d.put("YPMC", "(自备)" + d.get("YPMC"));
					}
				}
				int detsize = details.size();
				if (Integer.parseInt(MZFPMXSL) != 0 && Integer.parseInt(MZFPMXSL) < detsize) {
					detsize = Integer.parseInt(MZFPMXSL);
				}
				for (int i = 0; i < detsize; i++) {
					Map<String, Object> detail = details.get(i);
					mzfp.put("HMBM" + (i + 1), detail.get("HMBM"));
					mzfp.put("MXBM" + (i + 1), detail.get("YPBM"));
					mzfp.put("MXMC" + (i + 1), detail.get("YPMC"));
					mzfp.put("MXGG" + (i + 1), detail.get("YPGG"));
					mzfp.put("MXDJ" + (i + 1), detail.get("YPDJ"));
					mzfp.put("MXSL" + (i + 1), detail.get("YPSL"));
					mzfp.put("MXJE" + (i + 1), detail.get("HJJE"));
					mzfp.put("YSDM" + (i + 1), detail.get("YSDM"));
					mzfp.put("YSXM" + (i + 1), detail.get("YSXM"));
					if (detail.get("KSMC").toString().indexOf("队") > 0 || detail.get("KSMC").toString().indexOf("点") > 0
							|| detail.get("KSMC").toString().indexOf("所") > 0
							|| detail.get("KSMC").toString().indexOf("医") > 0) {
						if (!mzfp.containsKey("KSMC")) {
							mzfp.put("KSMC", detail.get("KSMC").toString().substring(0, 2));
						}
					}
				}
				if (detsize < details.size()) {
					mzfp.put("MXMC" + (detsize + 1), "*以上明细信息不全");
				}
				String[] upint = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
				SFXMS = dicSfxmlbService.doQueryGbje(parameters1);
				for (int i = 0; i < SFXMS.size(); i++) {
					Map<String, Object> SFXM = SFXMS.get(i);
					if (SFXM.get("MZPL") != null && (SFXM.get("MZPL") + "").length() > 0) {
						if ("其 它".equals(SFXM.get("MCSX") + "") || "其它".equals(SFXM.get("MCSX") + "")) {
							mzfp.put("QTPL", SFXM.get("MZPL"));
							mzfp.put("SFXM" + SFXM.get("MZPL"), SFXM.get("MCSX") + "");
							if (SFXM.get("ZJJE") != null && (SFXM.get("ZJJE") + "").length() > 0) {
								mzfp.put("XMJE" + SFXM.get("MZPL"), SFXM.get("ZJJE") + "");
							} else {
								mzfp.put("XMJE" + SFXM.get("MZPL"), "0.00");
							}
							continue;
						} else {

							if (SFXM.get("ZJJE") != null && (SFXM.get("ZJJE") + "").length() > 0) {
								if (Double.parseDouble(SFXM.get("ZJJE") + "") > 0) {
									mzfp.put("SFXM" + SFXM.get("MZPL"), SFXM.get("MCSX") + "");
									mzfp.put("XMJE" + SFXM.get("MZPL"), SFXM.get("ZJJE") + "");
								}
								// } else {
								// response.put("XMJE" + SFXM.get("MZPL"),
								// "0.00");
							}
						}
					} else if (SFXM.get("ZJJE") != null && (SFXM.get("ZJJE") + "").length() > 0) {
						if (Double.parseDouble(SFXM.get("ZJJE") + "") > 0) {
							if (mzfp.containsKey("QTJE")) {
								mzfp.put("QTJE", (Double.parseDouble(mzfp.get("QTJE") + "")
										+ Double.parseDouble(SFXM.get("ZJJE") + "")) + "");
							} else {
								mzfp.put("QTJE", SFXM.get("ZJJE") + "");
							}
						}
					}
				}
				if (mzfp.containsKey("QTJE")) {
					if (mzfp.containsKey("XMJE" + mzfp.get("QTPL"))
							&& (mzfp.get("XMJE" + mzfp.get("QTPL")) + "").length() > 0) {
						mzfp.put("XMJE" + mzfp.get("QTPL"), Double.parseDouble(mzfp.get("XMJE" + mzfp.get("QTPL")) + "")
								+ Double.parseDouble(mzfp.get("QTJE") + ""));
					} else {
						mzfp.put("XMJE" + mzfp.get("QTPL"), Double.parseDouble(mzfp.get("QTJE") + ""));
					}
				} else {
					if (mzfp.containsKey("SFXM" + mzfp.get("QTPL"))) {
						mzfp.remove("SFXM" + mzfp.get("QTPL"));
						mzfp.remove("XMJE" + mzfp.get("QTPL"));
					}
				}
				mzfpInfo.put("FPHM", fphm);
				mzfpInfo.put("POSJE", MZXX.get("POSJE"));
				mzfpInfo.put("ZFBJE", MZXX.get("ZFBJE"));
				mzfpInfo.put("FPFKFS", MZXX.get("FPFKFS"));
				mzfpInfo.put("FPFKJE", MZXX.get("FPFKJE"));
				mzfpInfo.put("XNFP", MZXX.get("XNFP") + "");
				mzfpInfo.put("XLH", MZXX.get("XLH") + "");
				mzfpInfo.put("YYYY", MZXX.get("YYYY") + "");
//					mzfp.put("MM", MZXX.get("MM") + "");
//					mzfp.put("DD", MZXX.get("DD") + "");
				mzfpInfo.put("XM", MZXX.get("XM") + "");
				mzfpInfo.put("BRXB", MZXX.get("BRXB") + "");
				mzfpInfo.put("HJJE", MZXX.get("HJJE") + "");
				mzfpInfo.put("GRJF", (new BigDecimal(MZXX.get("XJJE").toString())).add(new BigDecimal(MZXX.get("ZPJE").toString())).toString());
				mzfpInfo.put("XJZF","0");
				mzfpInfo.put("JZ", MZXX.get("JZ") + "");
				mzfpInfo.put("JGMC", jgname);
				mzfpInfo.put("SFY", MZXX.get("SFY") + "");
				mzfpInfo.put("JSFS", MZXX.get("JSFS") + "");
				// TODO 注释掉
				if ("6103".equals(MZXX.get("BRXZ") + "")) {
					mzfpInfo.put("BZ", "'小病'免费:3.00");
					mzfpInfo.put("GRZF",
							"个人缴费:" + String.format("%1$.2f", (Double.parseDouble(MZXX.get("HJJE") + "") - 3.00)));
				}
				if ("6104".equals(MZXX.get("BRXZ") + "")) {
					mzfpInfo.put("GRZF", "个人缴费:3.00");
					mzfpInfo.put("BZ",
							"股民减免:" + String.format("%1$.2f", (Double.parseDouble(MZXX.get("HJJE") + "") - 3.00)));
				}
				if ("6089".equals(MZXX.get("BRXZ") + "")) {
					mzfpInfo.put("BZ", "民政救助金额:" + MZXX.get("MZJZJE") + "");
				}

				String fpyl = sysXtcsCacheSer.getCsz(req.getJgid(), "FPYL");
				String mzhjsfdyjmc = sysXtcsCacheSer.getCsz(req.getJgid(), "MZHJSFDYJMC");
				response.put("fpyl", fpyl);
				response.put("mzhjsfdyjmc", mzhjsfdyjmc);

				mzfpInfo.put("PAGE", "(" + page + "/" + MZXX.get("FPZS") + ")");
				mzfpInfo.putAll(getMzJsFyck(fphm));// 设置发药窗口
				if (isYb) {
//					mzfp.putAll(getYbMzJsxx(MZXX.get("MZXH") + ""));
				} else {
					mzfpInfo.putAll(getBrkhByMzxh(MZXX.get("MZXH") + ""));
				}
				mzfpInfo.put("JKJE", MZXX.get("JKJE") + "");
				mzfpInfo.put("JMJE", MZXX.get("JMJE") + "");
				mzfpInfo.put("TZJE", MZXX.get("TZJE") + "");
				mzfpInfo.put("grzhzf", "0.00");
				mzfpInfo.put("ybtczf", "0.00");
				mzfpInfo.put("fjzf", "0.00");
				mzfpInfo.put("dnzhye", "0.00");
				mzfpInfo.put("lnzhye", "0.00");
				mzfpInfo.put("xjzfFlzf", "0.00");
				mzfpInfo.put("xjzfZifei", "0.00");
				mzfpInfo.put("zxlsh", "");
				mzfps.add(mzfp);
				mzfpInfolist.add(mzfpInfo);
				page++;
				response.put("jhhm", pdhm.get("JHHM"));
				response.put("mzfps", mzfps);
			}
		} else if ("1".equals(MZFPFDFS)) {// 按收费项目分单
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("FPHM", fphm);
			parameters.put("JGID", JGID);
			List<Map<String, Object>> fygbs = opSfmxDao.doQuerySfxmByCondition(parameters);
			for (Map<String, Object> fygb : fygbs) {
				parameters.put("SFXM", Long.parseLong(fygb.get("SFXM") + ""));
				if ("1".equals(MZFPSFLD) && Integer.parseInt(MZFPMXSL) > 0) {
					Map<String, Object> MZXX = new HashMap<String, Object>();
					List<Map<String, Object>> SFXMS = new ArrayList<Map<String, Object>>();
					MZXX = opMzxxDao.doQueryMzxxJeA(parameters);
					Map<String, Object> parameters1 = new HashMap<String, Object>();
					parameters1.put("MZXH", MZXX.get("MZXH"));
					parameters1.put("SFXM", Long.parseLong(fygb.get("SFXM") + ""));
					List<Map<String, Object>> details = opCf01Dao.doQueryCfYp(parameters1);
					// add by caijy at 2014.10.8 for自备药
					for (Map<String, Object> d : details) {
						if (Integer.parseInt(d.get("ZFYP") + "") == 1) {
							d.put("YPMC", "(自备)" + d.get("YPMC"));
						}
					}
					int n = details.size() / Integer.parseInt(MZFPMXSL);
					if (Integer.parseInt(MZFPMXSL) * n < details.size()) {
						n++;
					}
					for (int jk = 0; jk < n; jk++) {
						Map<String, Object> mzfp = new HashMap<String, Object>();
						int maxdetal = (jk + 1) * Integer.parseInt(MZFPMXSL);
						if (maxdetal > details.size()) {
							maxdetal = details.size();
						}
						int k = 0;
						for (int i = (jk) * Integer.parseInt(MZFPMXSL); i < maxdetal; i++) {
							Map<String, Object> detail = details.get(i);
							mzfp.put("HMBM" + (++k), detail.get("HMBM"));
							mzfp.put("MXMC" + (k), detail.get("YPMC"));
							mzfp.put("MXBM" + (k), detail.get("YPBM"));
							mzfp.put("MXGG" + (k), detail.get("YPGG"));
							mzfp.put("MXDJ" + (k), detail.get("YPDJ"));
							mzfp.put("MXSL" + (k), detail.get("YPSL"));
							mzfp.put("MXJE" + (k), detail.get("HJJE"));
						}
						if (jk == 0) {
							String[] upint = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
							opMzxxDao.doQueryMzxxJeA(parameters);
							SFXMS = dicSfxmlbService.doQueryGbjeByCondition(parameters1);
							for (int i = 0; i < SFXMS.size(); i++) {
								Map<String, Object> SFXM = SFXMS.get(i);
								if (SFXM.get("MZPL") != null && (SFXM.get("MZPL") + "").length() > 0) {
									if ("其 它".equals(SFXM.get("MCSX") + "") || "其它".equals(SFXM.get("MCSX") + "")) {
										mzfp.put("QTPL", SFXM.get("MZPL"));
										mzfp.put("SFXM" + SFXM.get("MZPL"), SFXM.get("MCSX") + "");
										if (SFXM.get("ZJJE") != null && (SFXM.get("ZJJE") + "").length() > 0) {
											mzfp.put("XMJE" + SFXM.get("MZPL"), SFXM.get("ZJJE") + "");
										} else {
											mzfp.put("XMJE" + SFXM.get("MZPL"), "0.00");
										}
										continue;
									} else {

										if (SFXM.get("ZJJE") != null && (SFXM.get("ZJJE") + "").length() > 0) {
											if (Double.parseDouble(SFXM.get("ZJJE") + "") > 0) {
												mzfp.put("SFXM" + SFXM.get("MZPL"), SFXM.get("MCSX") + "");
												mzfp.put("XMJE" + SFXM.get("MZPL"), SFXM.get("ZJJE") + "");
											}
											// } else {
											// response.put("XMJE" +
											// SFXM.get("MZPL"), "0.00");
										}
									}
								} else if (SFXM.get("ZJJE") != null && (SFXM.get("ZJJE") + "").length() > 0) {
									if (Double.parseDouble(SFXM.get("ZJJE") + "") > 0) {
										if (mzfp.containsKey("QTJE")) {
											mzfp.put("QTJE", (Double.parseDouble(mzfp.get("QTJE") + "")
													+ Double.parseDouble(SFXM.get("ZJJE") + "")) + "");
										} else {
											mzfp.put("QTJE", SFXM.get("ZJJE") + "");
										}
									}
								}
							}
							if (mzfp.containsKey("QTJE")) {
								if (mzfp.containsKey("XMJE" + mzfp.get("QTPL"))
										&& (mzfp.get("XMJE" + mzfp.get("QTPL")) + "").length() > 0) {
									mzfp.put("XMJE" + mzfp.get("QTPL"),
											Double.parseDouble(mzfp.get("XMJE" + mzfp.get("QTPL")) + "")
													+ Double.parseDouble(mzfp.get("QTJE") + ""));
								} else {
									mzfp.put("XMJE" + mzfp.get("QTPL"), Double.parseDouble(mzfp.get("QTJE") + ""));
								}
							} else {
								if (mzfp.containsKey("SFXM" + mzfp.get("QTPL"))) {
									mzfp.remove("SFXM" + mzfp.get("QTPL"));
									mzfp.remove("XMJE" + mzfp.get("QTPL"));
								}
							}
							mzfpInfo.put("XLH", MZXX.get("XLH") + "");
							mzfpInfo.put("HJJE", MZXX.get("HJJE") + "");
							mzfpInfo.put("GRJF",(new BigDecimal(MZXX.get("XJJE").toString())).add(new BigDecimal(MZXX.get("ZPJE").toString())).toString());
							mzfpInfo.put("XJZF","0");
							mzfpInfo.put("JZ", MZXX.get("JZ") + "");
							// TODO 注释掉
							/*
							 * double hjje = Double.parseDouble(MZXX.get("HJJE") + ""); int sw = (int) (hjje
							 * / 100000) % 10; int w = (int) (hjje / 10000) % 10; int q = (int) (hjje /
							 * 1000) % 10; int b = (int) (hjje / 100) % 10; int s = (int) (hjje / 10) % 10;
							 * int y = (int) (hjje) % 10; int j = (int) (hjje * 10) % 10; String fStr =
							 * String.format("%.0f", hjje * 100); int f = Integer.parseInt(fStr) % 10; if (f
							 * == 0) { String jStr = String.format("%.0f", hjje * 10); j =
							 * Integer.parseInt(jStr) % 10; } mzfpInfo.put("SW", upint[sw]);
							 * mzfpInfo.put("W", upint[w]); mzfpInfo.put("Q", upint[q]); mzfpInfo.put("B",
							 * upint[b]); mzfpInfo.put("S", upint[s]); mzfpInfo.put("Y", upint[y]);
							 * mzfpInfo.put("J", upint[j]); mzfpInfo.put("F", upint[f]);
							 */
							if ("6103".equals(MZXX.get("BRXZ") + "")) {
								mzfpInfo.put("BZ", "'小病'免费:3.00");
								mzfpInfo.put("GRZF", "个人缴费:"
										+ String.format("%1$.2f", (Double.parseDouble(MZXX.get("HJJE") + "") - 3.00)));
							}
							if ("6104".equals(MZXX.get("BRXZ") + "")) {
								mzfpInfo.put("GRZF", "个人缴费:3.00");
								mzfpInfo.put("BZ", "股民减免:"
										+ String.format("%1$.2f", (Double.parseDouble(MZXX.get("HJJE") + "") - 3.00)));
							}
							if ("6089".equals(MZXX.get("BRXZ") + "")) {
								mzfpInfo.put("BZ", "民政救助金额:" + MZXX.get("MZJZJE") + "");
							}
						}
						mzfpInfo.put("FPHM", fphm);
						mzfpInfo.put("POSJE", MZXX.get("POSJE"));
						mzfpInfo.put("ZFBJE", MZXX.get("ZFBJE"));
						mzfpInfo.put("FPFKFS", MZXX.get("FPFKFS"));
						mzfpInfo.put("FPFKJE", MZXX.get("FPFKJE"));
						mzfpInfo.put("YYYY", MZXX.get("YYYY") + "");
//							mzfp.put("MM", MZXX.get("MM") + "");
//							mzfp.put("DD", MZXX.get("DD") + "");
						mzfpInfo.put("XM", MZXX.get("XM") + "");

						mzfpInfo.put("JGMC", jgname);
						mzfpInfo.put("SFY", MZXX.get("SFY") + "");
						mzfpInfo.put("JSFS", MZXX.get("JSFS") + "");

						String fpyl = sysXtcsCacheSer.getCsz(req.getJgid(), "FPYL");
						String mzhjsfdyjmc = sysXtcsCacheSer.getCsz(req.getJgid(), "MZHJSFDYJMC");
						response.put("fpyl", fpyl);
						response.put("mzhjsfdyjmc", mzhjsfdyjmc);

						mzfpInfo.put("PAGE", "(" + page + "/" + MZXX.get("FPZS") + ")");
						mzfpInfo.putAll(getMzJsFyck(fphm));
						if (isYb) {
//							mzfp.putAll(getYbMzJsxx(MZXX.get("MZXH") + ""));
						} else {
							mzfpInfo.putAll(getBrkhByMzxh(MZXX.get("MZXH") + ""));
						}
						mzfpInfo.put("grzhzf", "0.00");
						mzfpInfo.put("ybtczf", "0.00");
						mzfpInfo.put("fjzf", "0.00");
						mzfpInfo.put("dnzhye", "0.00");
						mzfpInfo.put("lnzhye", "0.00");
						mzfpInfo.put("xjzfFlzf", "0.00");
						mzfpInfo.put("xjzfZifei", "0.00");
						mzfps.add(mzfp);
						mzfpInfolist.add(mzfpInfo);
						page++;
					}
				} else {
					Map<String, Object> mzfp = new HashMap<String, Object>();
					Map<String, Object> MZXX = new HashMap<String, Object>();
					List<Map<String, Object>> SFXMS = new ArrayList<Map<String, Object>>();
					String[] upint = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
					Map<String, Object> parameters1 = new HashMap<String, Object>();
					MZXX = opMzxxDao.doQueryMzxxJeA(parameters);
					parameters1.put("MZXH", MZXX.get("MZXH"));
					parameters1.put("SFXM", Long.parseLong(fygb.get("SFXM") + ""));
					SFXMS = dicSfxmlbService.doQueryGbjeByCondition(parameters1);
					for (int i = 0; i < SFXMS.size(); i++) {
						Map<String, Object> SFXM = SFXMS.get(i);
						if (SFXM.get("MZPL") != null && (SFXM.get("MZPL") + "").length() > 0) {
							if ("其 它".equals(SFXM.get("MCSX") + "") || "其它".equals(SFXM.get("MCSX") + "")) {
								mzfp.put("QTPL", SFXM.get("MZPL"));
								mzfp.put("SFXM" + SFXM.get("MZPL"), SFXM.get("MCSX") + "");
								if (SFXM.get("ZJJE") != null && (SFXM.get("ZJJE") + "").length() > 0) {
									mzfp.put("XMJE" + SFXM.get("MZPL"), SFXM.get("ZJJE") + "");
								} else {
									mzfp.put("XMJE" + SFXM.get("MZPL"), "0.00");
								}
								continue;
							} else {

								if (SFXM.get("ZJJE") != null && (SFXM.get("ZJJE") + "").length() > 0) {
									if (Double.parseDouble(SFXM.get("ZJJE") + "") > 0) {
										mzfp.put("SFXM" + SFXM.get("MZPL"), SFXM.get("MCSX") + "");
										mzfp.put("XMJE" + SFXM.get("MZPL"), SFXM.get("ZJJE") + "");
									}
									// } else {
									// response.put("XMJE" +
									// SFXM.get("MZPL"), "0.00");
								}
							}
						} else if (SFXM.get("ZJJE") != null && (SFXM.get("ZJJE") + "").length() > 0) {
							if (Double.parseDouble(SFXM.get("ZJJE") + "") > 0) {
								if (mzfp.containsKey("QTJE")) {
									mzfp.put("QTJE", (Double.parseDouble(mzfp.get("QTJE") + "")
											+ Double.parseDouble(SFXM.get("ZJJE") + "")) + "");
								} else {
									mzfp.put("QTJE", SFXM.get("ZJJE") + "");
								}
							}
						}
					}
					if (mzfp.containsKey("QTJE")) {
						if (mzfp.containsKey("XMJE" + mzfp.get("QTPL"))
								&& (mzfp.get("XMJE" + mzfp.get("QTPL")) + "").length() > 0) {
							mzfp.put("XMJE" + mzfp.get("QTPL"),
									Double.parseDouble(mzfp.get("XMJE" + mzfp.get("QTPL")) + "")
											+ Double.parseDouble(mzfp.get("QTJE") + ""));
						} else {
							mzfp.put("XMJE" + mzfp.get("QTPL"), Double.parseDouble(mzfp.get("QTJE") + ""));
						}
					} else {
						if (mzfp.containsKey("SFXM" + mzfp.get("QTPL"))) {
							mzfp.remove("SFXM" + mzfp.get("QTPL"));
							mzfp.remove("XMJE" + mzfp.get("QTPL"));
						}
					}
					mzfpInfo.put("FPHM", fphm);
					mzfpInfo.put("POSJE", MZXX.get("POSJE"));
					mzfpInfo.put("ZFBJE", MZXX.get("ZFBJE"));
					mzfpInfo.put("FPFKFS", MZXX.get("FPFKFS"));
					mzfpInfo.put("FPFKJE", MZXX.get("FPFKJE"));
					mzfpInfo.put("XLH", MZXX.get("XLH") + "");
					mzfpInfo.put("YYYY", MZXX.get("YYYY") + "");
//						mzfp.put("MM", MZXX.get("MM") + "");
//						mzfp.put("DD", MZXX.get("DD") + "");
					mzfpInfo.put("XM", MZXX.get("XM") + "");
					mzfpInfo.put("HJJE", MZXX.get("HJJE") + "");
					mzfpInfo.put("GRJF", (new BigDecimal(MZXX.get("XJJE").toString())).add(new BigDecimal(MZXX.get("ZPJE").toString())).toString());
					mzfpInfo.put("XJZF","0");
					mzfpInfo.put("JZ", MZXX.get("JZ") + "");
					mzfpInfo.put("JGMC", jgname);
					mzfpInfo.put("SFY", MZXX.get("SFY") + "");
					mzfpInfo.put("JSFS", MZXX.get("JSFS") + "");
					// TODO 注释掉
					/*
					 * double hjje = Double.parseDouble(MZXX.get("HJJE") + ""); int sw = (int) (hjje
					 * / 100000) % 10; int w = (int) (hjje / 10000) % 10; int q = (int) (hjje /
					 * 1000) % 10; int b = (int) (hjje / 100) % 10; int s = (int) (hjje / 10) % 10;
					 * int y = (int) (hjje) % 10; int j = (int) (hjje * 10) % 10; String fStr =
					 * String.format("%.0f", hjje * 100); int f = Integer.parseInt(fStr) % 10; if (f
					 * == 0) { String jStr = String.format("%.0f", hjje * 10); j =
					 * Integer.parseInt(jStr) % 10; } mzfpInfo.put("SW", upint[sw]);
					 * mzfpInfo.put("W", upint[w]); mzfpInfo.put("Q", upint[q]); mzfpInfo.put("B",
					 * upint[b]); mzfpInfo.put("S", upint[s]); mzfpInfo.put("Y", upint[y]);
					 * mzfpInfo.put("J", upint[j]); mzfpInfo.put("F", upint[f]);
					 */
					if ("6103".equals(MZXX.get("BRXZ") + "")) {
						mzfpInfo.put("BZ", "'小病'免费:3.00");
						mzfpInfo.put("GRZF",
								"个人缴费:" + String.format("%1$.2f", (Double.parseDouble(MZXX.get("HJJE") + "") - 3.00)));
					}
					if ("6104".equals(MZXX.get("BRXZ") + "")) {
						mzfpInfo.put("GRZF", "个人缴费:3.00");
						mzfpInfo.put("BZ",
								"股民减免:" + String.format("%1$.2f", (Double.parseDouble(MZXX.get("HJJE") + "") - 3.00)));
					}
					if ("6089".equals(MZXX.get("BRXZ") + "")) {
						mzfpInfo.put("BZ", "民政救助金额:" + MZXX.get("MZJZJE") + "");
					}
					List<Map<String, Object>> details = opCf01Dao.doQueryCfYp(parameters1);
					// add by caijy at 2014.10.8 for自备药
					for (Map<String, Object> d : details) {
						if (Integer.parseInt(d.get("ZFYP") + "") == 1) {
							d.put("YPMC", "(自备)" + d.get("YPMC"));
						}
					}
					int detsize = details.size();
					if (Integer.parseInt(MZFPMXSL) != 0 && Integer.parseInt(MZFPMXSL) < detsize) {
						detsize = Integer.parseInt(MZFPMXSL);
					}
					for (int i = 0; i < detsize; i++) {
						Map<String, Object> detail = details.get(i);
						mzfp.put("HMBM" + (i + 1), detail.get("HMBM"));
						mzfp.put("MXMC" + (i + 1), detail.get("YPMC"));
						mzfp.put("MXBM" + (i + 1), detail.get("YPBM"));
						mzfp.put("MXGG" + (i + 1), detail.get("YPGG"));
						mzfp.put("MXDJ" + (i + 1), detail.get("YPDJ"));
						mzfp.put("MXSL" + (i + 1), detail.get("YPSL"));
						mzfp.put("MXJE" + (i + 1), detail.get("HJJE"));
					}
					if (detsize < details.size()) {
						mzfp.put("MXMC" + (detsize + 1), "*以上明细信息不全");
					}
					// for(int i = 0 ; i < details.size() ; i ++ ){
					// Map<String,Object> detail = details.get(i);
					// mzfp.put("MXMC"+(i+1),detail.get("YPMC"));
					// mzfp.put("MXDJ"+(i+1),detail.get("YPDJ"));
					// mzfp.put("MXSL"+(i+1),detail.get("YPSL"));
					// mzfp.put("MXJE"+(i+1),detail.get("HJJE"));
					// }
					String fpyl = sysXtcsCacheSer.getCsz(req.getJgid(), "FPYL");
					String mzhjsfdyjmc = sysXtcsCacheSer.getCsz(req.getJgid(), "MZHJSFDYJMC");
					response.put("fpyl", fpyl);
					response.put("mzhjsfdyjmc", mzhjsfdyjmc);

					mzfpInfo.put("PAGE", "(" + page + "/" + MZXX.get("FPZS") + ")");
					mzfpInfo.putAll(getMzJsFyck(fphm));
					if (isYb) {
//						mzfp.putAll(getYbMzJsxx(MZXX.get("MZXH") + ""));
					} else {
						mzfpInfo.putAll(getBrkhByMzxh(MZXX.get("MZXH") + ""));
					}
					mzfpInfo.put("grzhzf", "0.00");
					mzfpInfo.put("ybtczf", "0.00");
					mzfpInfo.put("fjzf", "0.00");
					mzfpInfo.put("dnzhye", "0.00");
					mzfpInfo.put("lnzhye", "0.00");
					mzfpInfo.put("xjzfFlzf", "0.00");
					mzfpInfo.put("xjzfZifei", "0.00");
					mzfps.add(mzfp);
					mzfpInfolist.add(mzfpInfo);
					page++;
				}

			}
			response.put("jhhm", pdhm.get("JHHM"));
			response.put("mzfps", mzfps);
		} else if ("2".equals(MZFPFDFS)) {// 检查按执行科室分单，药品按药房分单
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("FPHM", fphm);
			parameters.put("JGID", JGID);
			List<Map<String, Object>> yfsbs = opCf01Dao.doQueryYfsb(parameters);
			List<Map<String, Object>> zxkss = opYjcf01Dao.doQueryZxks(parameters);
			for (Map<String, Object> yfsb : yfsbs) {
				parameters.put("YFSB", Long.parseLong(yfsb.get("YFSB") + ""));
				if ("1".equals(MZFPSFLD) && Integer.parseInt(MZFPMXSL) > 0) {
					Map<String, Object> MZXX = new HashMap<String, Object>();
					List<Map<String, Object>> SFXMS = new ArrayList<Map<String, Object>>();
					MZXX = opMzxxDao.doQueryMzxxJeB(parameters);
					Map<String, Object> parameters1 = new HashMap<String, Object>();
					parameters1.put("MZXH", MZXX.get("MZXH"));
					parameters1.put("YFSB", Long.parseLong(yfsb.get("YFSB") + ""));
					List<Map<String, Object>> details = opCf01Dao.doQUeryYpA(parameters1);
					// add by caijy at 2014.10.8 for自备药
					for (Map<String, Object> d : details) {
						if (Integer.parseInt(d.get("ZFYP") + "") == 1) {
							d.put("YPMC", "(自备)" + d.get("YPMC"));
						}
					}
					int n = details.size() / Integer.parseInt(MZFPMXSL);
					if (Integer.parseInt(MZFPMXSL) * n < details.size()) {
						n++;
					}
					for (int jk = 0; jk < n; jk++) {
						Map<String, Object> mzfp = new HashMap<String, Object>();
						int maxdetal = (jk + 1) * Integer.parseInt(MZFPMXSL);
						if (maxdetal > details.size()) {
							maxdetal = details.size();
						}
						int k = 0;
						for (int i = (jk) * Integer.parseInt(MZFPMXSL); i < maxdetal; i++) {
							Map<String, Object> detail = details.get(i);
							mzfp.put("HMBM" + (++k), detail.get("HMBM"));
							mzfp.put("MXMC" + (k), detail.get("YPMC"));
							mzfp.put("MXBM" + (k), detail.get("YPBM"));
							mzfp.put("MXGG" + (k), detail.get("YPGG"));
							mzfp.put("MXDJ" + (k), detail.get("YPDJ"));
							mzfp.put("MXSL" + (k), detail.get("YPSL"));
							mzfp.put("MXJE" + (k), detail.get("HJJE"));
						}
						if (jk == 0) {
							String[] upint = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
							SFXMS = dicSfxmlbService.doQueryGbjeA(parameters);
							for (int i = 0; i < SFXMS.size(); i++) {
								Map<String, Object> SFXM = SFXMS.get(i);
								if (SFXM.get("MZPL") != null && (SFXM.get("MZPL") + "").length() > 0) {
									if ("其 它".equals(SFXM.get("MCSX") + "") || "其它".equals(SFXM.get("MCSX") + "")) {
										mzfp.put("QTPL", SFXM.get("MZPL"));
										mzfp.put("SFXM" + SFXM.get("MZPL"), SFXM.get("MCSX") + "");
										if (SFXM.get("ZJJE") != null && (SFXM.get("ZJJE") + "").length() > 0) {
											mzfp.put("XMJE" + SFXM.get("MZPL"), SFXM.get("ZJJE") + "");
										} else {
											mzfp.put("XMJE" + SFXM.get("MZPL"), "0.00");
										}
										continue;
									} else {

										if (SFXM.get("ZJJE") != null && (SFXM.get("ZJJE") + "").length() > 0) {
											if (Double.parseDouble(SFXM.get("ZJJE") + "") > 0) {
												mzfp.put("SFXM" + SFXM.get("MZPL"), SFXM.get("MCSX") + "");
												mzfp.put("XMJE" + SFXM.get("MZPL"), SFXM.get("ZJJE") + "");
											}
											// } else {
											// response.put("XMJE" +
											// SFXM.get("MZPL"), "0.00");
										}
									}
								} else if (SFXM.get("ZJJE") != null && (SFXM.get("ZJJE") + "").length() > 0) {
									if (Double.parseDouble(SFXM.get("ZJJE") + "") > 0) {
										if (mzfp.containsKey("QTJE")) {
											mzfp.put("QTJE", (Double.parseDouble(mzfp.get("QTJE") + "")
													+ Double.parseDouble(SFXM.get("ZJJE") + "")) + "");
										} else {
											mzfp.put("QTJE", SFXM.get("ZJJE") + "");
										}
									}
								}
							}
							if (mzfp.containsKey("QTJE")) {
								if (mzfp.containsKey("XMJE" + mzfp.get("QTPL"))
										&& (mzfp.get("XMJE" + mzfp.get("QTPL")) + "").length() > 0) {
									mzfp.put("XMJE" + mzfp.get("QTPL"),
											Double.parseDouble(mzfp.get("XMJE" + mzfp.get("QTPL")) + "")
													+ Double.parseDouble(mzfp.get("QTJE") + ""));
								} else {
									mzfp.put("XMJE" + mzfp.get("QTPL"), Double.parseDouble(mzfp.get("QTJE") + ""));
								}
							} else {
								if (mzfp.containsKey("SFXM" + mzfp.get("QTPL"))) {
									mzfp.remove("SFXM" + mzfp.get("QTPL"));
									mzfp.remove("XMJE" + mzfp.get("QTPL"));
								}
							}
							mzfpInfo.put("XLH", MZXX.get("XLH") + "");
							mzfpInfo.put("HJJE", MZXX.get("HJJE") + "");
							mzfpInfo.put("GRJF", (new BigDecimal(MZXX.get("XJJE").toString())).add(new BigDecimal(MZXX.get("ZPJE").toString())).toString());
							mzfpInfo.put("XJZF","0");
							mzfpInfo.put("JZ", MZXX.get("JZ") + "");
							// TODO 注释掉
							/*
							 * double hjje = Double.parseDouble(MZXX.get("HJJE") + ""); int sw = (int) (hjje
							 * / 100000) % 10; int w = (int) (hjje / 10000) % 10; int q = (int) (hjje /
							 * 1000) % 10; int b = (int) (hjje / 100) % 10; int s = (int) (hjje / 10) % 10;
							 * int y = (int) (hjje) % 10; int j = (int) (hjje * 10) % 10; String fStr =
							 * String.format("%.0f", hjje * 100); int f = Integer.parseInt(fStr) % 10; if (f
							 * == 0) { String jStr = String.format("%.0f", hjje * 10); j =
							 * Integer.parseInt(jStr) % 10; } mzfpInfo.put("SW", upint[sw]);
							 * mzfpInfo.put("W", upint[w]); mzfpInfo.put("Q", upint[q]); mzfpInfo.put("B",
							 * upint[b]); mzfpInfo.put("S", upint[s]); mzfpInfo.put("Y", upint[y]);
							 * mzfpInfo.put("J", upint[j]); mzfpInfo.put("F", upint[f]);
							 */
							if ("6103".equals(MZXX.get("BRXZ") + "")) {
								mzfpInfo.put("BZ", "'小病'免费:3.00");
								mzfpInfo.put("GRZF", "个人缴费:"
										+ String.format("%1$.2f", (Double.parseDouble(MZXX.get("HJJE") + "") - 3.00)));
							}
							if ("6104".equals(MZXX.get("BRXZ") + "")) {
								mzfpInfo.put("GRZF", "个人缴费:3.00");
								mzfpInfo.put("BZ", "股民减免:"
										+ String.format("%1$.2f", (Double.parseDouble(MZXX.get("HJJE") + "") - 3.00)));
							}
							if ("6089".equals(MZXX.get("BRXZ") + "")) {
								mzfpInfo.put("BZ", "民政救助金额:" + MZXX.get("MZJZJE") + "");
							}
						}
						mzfpInfo.put("FPHM", fphm);
						mzfpInfo.put("POSJE", MZXX.get("POSJE"));
						mzfpInfo.put("ZFBJE", MZXX.get("ZFBJE"));
						mzfpInfo.put("FPFKFS", MZXX.get("FPFKFS"));
						mzfpInfo.put("FPFKJE", MZXX.get("FPFKJE"));
						mzfpInfo.put("YYYY", MZXX.get("YYYY") + "");
//							mzfp.put("MM", MZXX.get("MM") + "");
//							mzfp.put("DD", MZXX.get("DD") + "");
						mzfpInfo.put("XM", MZXX.get("XM") + "");
						mzfpInfo.put("JGMC", jgname);
						mzfpInfo.put("SFY", MZXX.get("SFY") + "");
						mzfpInfo.put("JSFS", MZXX.get("JSFS") + "");

						String fpyl = sysXtcsCacheSer.getCsz(req.getJgid(), "FPYL");
						String mzhjsfdyjmc = sysXtcsCacheSer.getCsz(req.getJgid(), "MZHJSFDYJMC");
						response.put("fpyl", fpyl);
						response.put("mzhjsfdyjmc", mzhjsfdyjmc);
						mzfpInfo.put("PAGE", "(" + page + "/" + MZXX.get("FPZS") + ")");
						mzfpInfo.putAll(getMzJsFyck(fphm));
						if (isYb) {
//							mzfp.putAll(getYbMzJsxx(MZXX.get("MZXH") + ""));
						} else {
							mzfpInfo.putAll(getBrkhByMzxh(MZXX.get("MZXH") + ""));
						}
						mzfpInfo.put("grzhzf", "0.00");
						mzfpInfo.put("ybtczf", "0.00");
						mzfpInfo.put("fjzf", "0.00");
						mzfpInfo.put("dnzhye", "0.00");
						mzfpInfo.put("lnzhye", "0.00");
						mzfpInfo.put("xjzfFlzf", "0.00");
						mzfpInfo.put("xjzfZifei", "0.00");
						mzfps.add(mzfp);
						mzfpInfolist.add(mzfpInfo);
						page++;
					}
				} else {
					Map<String, Object> mzfp = new HashMap<String, Object>();
					Map<String, Object> MZXX = new HashMap<String, Object>();
					List<Map<String, Object>> SFXMS = new ArrayList<Map<String, Object>>();
					String[] upint = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
					Map<String, Object> parameters1 = new HashMap<String, Object>();
					MZXX = opMzxxDao.doQueryMzxxJeB(parameters);
					parameters1.put("MZXH", MZXX.get("MZXH"));
					parameters1.put("YFSB", Long.parseLong(yfsb.get("YFSB") + ""));
					SFXMS = dicSfxmlbService.doQueryGbjeA(parameters);
					for (int i = 0; i < SFXMS.size(); i++) {
						Map<String, Object> SFXM = SFXMS.get(i);
						if (SFXM.get("MZPL") != null && (SFXM.get("MZPL") + "").length() > 0) {
							if ("其 它".equals(SFXM.get("MCSX") + "") || "其它".equals(SFXM.get("MCSX") + "")) {
								mzfp.put("QTPL", SFXM.get("MZPL"));
								mzfp.put("SFXM" + SFXM.get("MZPL"), SFXM.get("MCSX") + "");
								if (SFXM.get("ZJJE") != null && (SFXM.get("ZJJE") + "").length() > 0) {
									mzfp.put("XMJE" + SFXM.get("MZPL"), SFXM.get("ZJJE") + "");
								} else {
									mzfp.put("XMJE" + SFXM.get("MZPL"), "0.00");
								}
								continue;
							} else {

								if (SFXM.get("ZJJE") != null && (SFXM.get("ZJJE") + "").length() > 0) {
									if (Double.parseDouble(SFXM.get("ZJJE") + "") > 0) {
										mzfp.put("SFXM" + SFXM.get("MZPL"), SFXM.get("MCSX") + "");
										mzfp.put("XMJE" + SFXM.get("MZPL"), SFXM.get("ZJJE") + "");
									}
									// } else {
									// response.put("XMJE" +
									// SFXM.get("MZPL"), "0.00");
								}
							}
						} else if (SFXM.get("ZJJE") != null && (SFXM.get("ZJJE") + "").length() > 0) {
							if (Double.parseDouble(SFXM.get("ZJJE") + "") > 0) {
								if (mzfp.containsKey("QTJE")) {
									mzfp.put("QTJE", (Double.parseDouble(mzfp.get("QTJE") + "")
											+ Double.parseDouble(SFXM.get("ZJJE") + "")) + "");
								} else {
									mzfp.put("QTJE", SFXM.get("ZJJE") + "");
								}
							}
						}
					}
					if (mzfp.containsKey("QTJE")) {
						if (mzfp.containsKey("XMJE" + mzfp.get("QTPL"))
								&& (mzfp.get("XMJE" + mzfp.get("QTPL")) + "").length() > 0) {
							mzfp.put("XMJE" + mzfp.get("QTPL"),
									Double.parseDouble(mzfp.get("XMJE" + mzfp.get("QTPL")) + "")
											+ Double.parseDouble(mzfp.get("QTJE") + ""));
						} else {
							mzfp.put("XMJE" + mzfp.get("QTPL"), Double.parseDouble(mzfp.get("QTJE") + ""));
						}
					} else {
						if (mzfp.containsKey("SFXM" + mzfp.get("QTPL"))) {
							mzfp.remove("SFXM" + mzfp.get("QTPL"));
							mzfp.remove("XMJE" + mzfp.get("QTPL"));
						}
					}
					mzfpInfo.put("FPHM", fphm);
					mzfpInfo.put("POSJE", MZXX.get("POSJE"));
					mzfpInfo.put("ZFBJE", MZXX.get("ZFBJE"));
					mzfpInfo.put("FPFKFS", MZXX.get("FPFKFS"));
					mzfpInfo.put("FPFKJE", MZXX.get("FPFKJE"));
					mzfpInfo.put("XLH", MZXX.get("XLH") + "");
					mzfpInfo.put("YYYY", MZXX.get("YYYY") + "");
//						mzfp.put("MM", MZXX.get("MM") + "");
//						mzfp.put("DD", MZXX.get("DD") + "");
					mzfpInfo.put("XM", MZXX.get("XM") + "");
					mzfpInfo.put("HJJE", MZXX.get("HJJE") + "");
					mzfpInfo.put("GRJF", (new BigDecimal(MZXX.get("XJJE").toString())).add(new BigDecimal(MZXX.get("ZPJE").toString())).toString());
					mzfpInfo.put("XJZF","0");
					mzfpInfo.put("JZ", MZXX.get("JZ") + "");
					mzfpInfo.put("JGMC", jgname);
					mzfpInfo.put("SFY", MZXX.get("SFY") + "");
					mzfpInfo.put("JSFS", MZXX.get("JSFS") + "");
					// TODO 注释掉
					/*
					 * double hjje = Double.parseDouble(MZXX.get("HJJE") + ""); int sw = (int) (hjje
					 * / 100000) % 10; int w = (int) (hjje / 10000) % 10; int q = (int) (hjje /
					 * 1000) % 10; int b = (int) (hjje / 100) % 10; int s = (int) (hjje / 10) % 10;
					 * int y = (int) (hjje) % 10; int j = (int) (hjje * 10) % 10; String fStr =
					 * String.format("%.0f", hjje * 100); int f = Integer.parseInt(fStr) % 10; if (f
					 * == 0) { String jStr = String.format("%.0f", hjje * 10); j =
					 * Integer.parseInt(jStr) % 10; } mzfpInfo.put("SW", upint[sw]);
					 * mzfpInfo.put("W", upint[w]); mzfpInfo.put("Q", upint[q]); mzfpInfo.put("B",
					 * upint[b]); mzfpInfo.put("S", upint[s]); mzfpInfo.put("Y", upint[y]);
					 * mzfpInfo.put("J", upint[j]); mzfpInfo.put("F", upint[f]);
					 */
					if ("6103".equals(MZXX.get("BRXZ") + "")) {
						mzfpInfo.put("BZ", "'小病'免费:3.00");
						mzfpInfo.put("GRZF",
								"个人缴费:" + String.format("%1$.2f", (Double.parseDouble(MZXX.get("HJJE") + "") - 3.00)));
					}
					if ("6104".equals(MZXX.get("BRXZ") + "")) {
						mzfpInfo.put("GRZF", "个人缴费:3.00");
						mzfpInfo.put("BZ",
								"股民减免:" + String.format("%1$.2f", (Double.parseDouble(MZXX.get("HJJE") + "") - 3.00)));
					}
					if ("6089".equals(MZXX.get("BRXZ") + "")) {
						mzfpInfo.put("BZ", "民政救助金额:" + MZXX.get("MZJZJE") + "");
					}
					List<Map<String, Object>> details = opCf01Dao.doQUeryYpA(parameters1);
					// add by caijy at 2014.10.8 for自备药
					for (Map<String, Object> d : details) {
						if (Integer.parseInt(d.get("ZFYP") + "") == 1) {
							d.put("YPMC", "(自备)" + d.get("YPMC"));
						}
					}
					// for(int i = 0 ; i < details.size() ; i ++ ){
					// Map<String,Object> detail = details.get(i);
					// mzfp.put("MXMC"+(i+1),detail.get("YPMC"));
					// mzfp.put("MXDJ"+(i+1),detail.get("YPDJ"));
					// mzfp.put("MXSL"+(i+1),detail.get("YPSL"));
					// mzfp.put("MXJE"+(i+1),detail.get("HJJE"));
					// }
					int detsize = details.size();
					if (Integer.parseInt(MZFPMXSL) != 0 && Integer.parseInt(MZFPMXSL) < detsize) {
						detsize = Integer.parseInt(MZFPMXSL);
					}
					for (int i = 0; i < detsize; i++) {
						Map<String, Object> detail = details.get(i);
						mzfp.put("HMBM" + (i + 1), detail.get("HMBM"));
						mzfp.put("MXMC" + (i + 1), detail.get("YPMC"));
						mzfp.put("MXBM" + (i + 1), detail.get("YPBM"));
						mzfp.put("MXGG" + (i + 1), detail.get("YPGG"));
						mzfp.put("MXDJ" + (i + 1), detail.get("YPDJ"));
						mzfp.put("MXSL" + (i + 1), detail.get("YPSL"));
						mzfp.put("MXJE" + (i + 1), detail.get("HJJE"));
					}
					if (detsize < details.size()) {
						mzfp.put("MXMC" + (detsize + 1), "*以上明细信息不全");
					}

					String fpyl = sysXtcsCacheSer.getCsz(req.getJgid(), "FPYL");
					String mzhjsfdyjmc = sysXtcsCacheSer.getCsz(req.getJgid(), "MZHJSFDYJMC");
					response.put("fpyl", fpyl);
					response.put("mzhjsfdyjmc", mzhjsfdyjmc);

					mzfpInfo.put("PAGE", "(" + page + "/" + MZXX.get("FPZS") + ")");
					mzfpInfo.putAll(getMzJsFyck(fphm));
					if (isYb) {
//						mzfp.putAll(getYbMzJsxx(MZXX.get("MZXH") + ""));
					} else {
						mzfpInfo.putAll(getBrkhByMzxh(MZXX.get("MZXH") + ""));
					}
					mzfpInfo.put("grzhzf", "0.00");
					mzfpInfo.put("ybtczf", "0.00");
					mzfpInfo.put("fjzf", "0.00");
					mzfpInfo.put("dnzhye", "0.00");
					mzfpInfo.put("lnzhye", "0.00");
					mzfpInfo.put("xjzfFlzf", "0.00");
					mzfpInfo.put("xjzfZifei", "0.00");
					mzfps.add(mzfp);
					mzfpInfolist.add(mzfpInfo);
					page++;
				}
			}
			for (Map<String, Object> zxks : zxkss) {
				parameters.put("ZXKS", Long.parseLong(zxks.get("ZXKS") + ""));
				if ("1".equals(MZFPSFLD) && Integer.parseInt(MZFPMXSL) > 0) {
					Map<String, Object> MZXX = new HashMap<String, Object>();
					List<Map<String, Object>> SFXMS = new ArrayList<Map<String, Object>>();
					parameters.remove("YFSB");
					MZXX = opMzxxDao.doQueryMzxxYjJe(parameters);
					Map<String, Object> parameters1 = new HashMap<String, Object>();
					parameters1.put("MZXH", MZXX.get("MZXH"));
					parameters1.put("ZXKS", Long.parseLong(zxks.get("ZXKS") + ""));
					List<Map<String, Object>> details = opYjcf01Dao.doQueryYjFy(parameters1);
					int n = details.size() / Integer.parseInt(MZFPMXSL);
					if (Integer.parseInt(MZFPMXSL) * n < details.size()) {
						n++;
					}
					for (int jk = 0; jk < n; jk++) {
						Map<String, Object> mzfp = new HashMap<String, Object>();
						int maxdetal = (jk + 1) * Integer.parseInt(MZFPMXSL);
						if (maxdetal > details.size()) {
							maxdetal = details.size();
						}
						int k = 0;
						for (int i = (jk) * Integer.parseInt(MZFPMXSL); i < maxdetal; i++) {
							Map<String, Object> detail = details.get(i);
							mzfp.put("HMBM" + (++k), detail.get("HMBM"));
							mzfp.put("MXMC" + (k), detail.get("YPMC"));
							mzfp.put("MXBM" + (k), detail.get("YPBM"));
							mzfp.put("MXGG" + (k), detail.get("YPGG"));
							mzfp.put("MXDJ" + (k), detail.get("YPDJ"));
							mzfp.put("MXSL" + (k), detail.get("YPSL"));
							mzfp.put("MXJE" + (k), detail.get("HJJE"));
						}
						if (jk == 0) {
							String[] upint = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
							SFXMS = dicSfxmlbService.doQueryYjGbJe(parameters);
							for (int i = 0; i < SFXMS.size(); i++) {
								Map<String, Object> SFXM = SFXMS.get(i);
								if (SFXM.get("MZPL") != null && (SFXM.get("MZPL") + "").length() > 0) {
									if ("其 它".equals(SFXM.get("MCSX") + "") || "其它".equals(SFXM.get("MCSX") + "")) {
										mzfp.put("QTPL", SFXM.get("MZPL"));
										mzfp.put("SFXM" + SFXM.get("MZPL"), SFXM.get("MCSX") + "");
										if (SFXM.get("ZJJE") != null && (SFXM.get("ZJJE") + "").length() > 0) {
											mzfp.put("XMJE" + SFXM.get("MZPL"), SFXM.get("ZJJE") + "");
										} else {
											mzfp.put("XMJE" + SFXM.get("MZPL"), "0.00");
										}
										continue;
									} else {

										if (SFXM.get("ZJJE") != null && (SFXM.get("ZJJE") + "").length() > 0) {
											if (Double.parseDouble(SFXM.get("ZJJE") + "") > 0) {
												mzfp.put("SFXM" + SFXM.get("MZPL"), SFXM.get("MCSX") + "");
												mzfp.put("XMJE" + SFXM.get("MZPL"), SFXM.get("ZJJE") + "");
											}
											// } else {
											// response.put("XMJE" +
											// SFXM.get("MZPL"), "0.00");
										}
									}
								} else if (SFXM.get("ZJJE") != null && (SFXM.get("ZJJE") + "").length() > 0) {
									if (Double.parseDouble(SFXM.get("ZJJE") + "") > 0) {
										if (mzfp.containsKey("QTJE")) {
											mzfp.put("QTJE", (Double.parseDouble(mzfp.get("QTJE") + "")
													+ Double.parseDouble(SFXM.get("ZJJE") + "")) + "");
										} else {
											mzfp.put("QTJE", SFXM.get("ZJJE") + "");
										}
									}
								}
							}
							if (mzfp.containsKey("QTJE")) {
								if (mzfp.containsKey("XMJE" + mzfp.get("QTPL"))
										&& (mzfp.get("XMJE" + mzfp.get("QTPL")) + "").length() > 0) {
									mzfp.put("XMJE" + mzfp.get("QTPL"),
											Double.parseDouble(mzfp.get("XMJE" + mzfp.get("QTPL")) + "")
													+ Double.parseDouble(mzfp.get("QTJE") + ""));
								} else {
									mzfp.put("XMJE" + mzfp.get("QTPL"), Double.parseDouble(mzfp.get("QTJE") + ""));
								}
							} else {
								if (mzfp.containsKey("SFXM" + mzfp.get("QTPL"))) {
									mzfp.remove("SFXM" + mzfp.get("QTPL"));
									mzfp.remove("XMJE" + mzfp.get("QTPL"));
								}
							}
							mzfpInfo.put("XLH", MZXX.get("XLH") + "");
							mzfpInfo.put("HJJE", MZXX.get("HJJE") + "");
							mzfpInfo.put("GRJF", (new BigDecimal(MZXX.get("XJJE").toString())).add(new BigDecimal(MZXX.get("ZPJE").toString())).toString());
							mzfpInfo.put("XJZF","0");
							mzfpInfo.put("JZ", MZXX.get("JZ") + "");
							// TODO 注释掉
							/*
							 * double hjje = Double.parseDouble(MZXX.get("HJJE") + ""); int sw = (int) (hjje
							 * / 100000) % 10; int w = (int) (hjje / 10000) % 10; int q = (int) (hjje /
							 * 1000) % 10; int b = (int) (hjje / 100) % 10; int s = (int) (hjje / 10) % 10;
							 * int y = (int) (hjje) % 10; int j = (int) (hjje * 10) % 10; String fStr =
							 * String.format("%.0f", hjje * 100); int f = Integer.parseInt(fStr) % 10; if (f
							 * == 0) { String jStr = String.format("%.0f", hjje * 10); j =
							 * Integer.parseInt(jStr) % 10; } mzfpInfo.put("SW", upint[sw]);
							 * mzfpInfo.put("W", upint[w]); mzfpInfo.put("Q", upint[q]); mzfpInfo.put("B",
							 * upint[b]); mzfpInfo.put("S", upint[s]); mzfpInfo.put("Y", upint[y]);
							 * mzfpInfo.put("J", upint[j]); mzfpInfo.put("F", upint[f]);
							 */
							if ("6103".equals(MZXX.get("BRXZ") + "")) {
								mzfpInfo.put("BZ", "'小病'免费:3.00");
								mzfpInfo.put("GRZF", "个人缴费:"
										+ String.format("%1$.2f", (Double.parseDouble(MZXX.get("HJJE") + "") - 3.00)));
							}
							if ("6104".equals(MZXX.get("BRXZ") + "")) {
								mzfpInfo.put("GRZF", "个人缴费:3.00");
								mzfpInfo.put("BZ", "股民减免:"
										+ String.format("%1$.2f", (Double.parseDouble(MZXX.get("HJJE") + "") - 3.00)));
							}
							if ("6089".equals(MZXX.get("BRXZ") + "")) {
								mzfpInfo.put("BZ", "民政救助金额:" + MZXX.get("MZJZJE") + "");
							}
						}
						mzfpInfo.put("FPHM", fphm);
						mzfpInfo.put("POSJE", MZXX.get("POSJE"));
						mzfpInfo.put("ZFBJE", MZXX.get("ZFBJE"));
						mzfpInfo.put("FPFKFS", MZXX.get("FPFKFS"));
						mzfpInfo.put("FPFKJE", MZXX.get("FPFKJE"));
						mzfpInfo.put("YYYY", MZXX.get("YYYY") + "");
//							mzfp.put("MM", MZXX.get("MM") + "");
//							mzfp.put("DD", MZXX.get("DD") + "");
						mzfpInfo.put("XM", MZXX.get("XM") + "");
						mzfpInfo.put("JGMC", jgname);
						mzfpInfo.put("SFY", MZXX.get("SFY") + "");
						mzfpInfo.put("JSFS", MZXX.get("JSFS") + "");

						String fpyl = sysXtcsCacheSer.getCsz(req.getJgid(), "FPYL");
						String mzhjsfdyjmc = sysXtcsCacheSer.getCsz(req.getJgid(), "MZHJSFDYJMC");
						response.put("fpyl", fpyl);
						response.put("mzhjsfdyjmc", mzhjsfdyjmc);
						mzfpInfo.put("PAGE", "(" + page + "/" + MZXX.get("FPZS") + ")");
						mzfpInfo.putAll(getMzJsFyck(fphm));
						if (isYb) {
//							mzfp.putAll(getYbMzJsxx(MZXX.get("MZXH") + ""));
						} else {
							mzfpInfo.putAll(getBrkhByMzxh(MZXX.get("MZXH") + ""));
						}
						mzfpInfo.put("grzhzf", "0.00");
						mzfpInfo.put("ybtczf", "0.00");
						mzfpInfo.put("fjzf", "0.00");
						mzfpInfo.put("dnzhye", "0.00");
						mzfpInfo.put("lnzhye", "0.00");
						mzfpInfo.put("xjzfFlzf", "0.00");
						mzfpInfo.put("xjzfZifei", "0.00");
						mzfps.add(mzfp);
						mzfpInfolist.add(mzfpInfo);
						page++;
					}
				} else {
					Map<String, Object> mzfp = new HashMap<String, Object>();
					Map<String, Object> MZXX = new HashMap<String, Object>();
					List<Map<String, Object>> SFXMS = new ArrayList<Map<String, Object>>();
					String[] upint = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
					Map<String, Object> parameters1 = new HashMap<String, Object>();
					parameters.remove("YFSB");
					MZXX = opMzxxDao.doQueryMzxxYjJe(parameters);
					parameters1.put("MZXH", MZXX.get("MZXH"));
					parameters1.put("ZXKS", Long.parseLong(zxks.get("ZXKS") + ""));
					SFXMS = dicSfxmlbService.doQueryYjGbJe(parameters);
					for (int i = 0; i < SFXMS.size(); i++) {
						Map<String, Object> SFXM = SFXMS.get(i);
						if (SFXM.get("MZPL") != null && (SFXM.get("MZPL") + "").length() > 0) {
							if ("其 它".equals(SFXM.get("MCSX") + "") || "其它".equals(SFXM.get("MCSX") + "")) {
								mzfp.put("QTPL", SFXM.get("MZPL"));
								mzfp.put("SFXM" + SFXM.get("MZPL"), SFXM.get("MCSX") + "");
								if (SFXM.get("ZJJE") != null && (SFXM.get("ZJJE") + "").length() > 0) {
									mzfp.put("XMJE" + SFXM.get("MZPL"), SFXM.get("ZJJE") + "");
								} else {
									mzfp.put("XMJE" + SFXM.get("MZPL"), "0.00");
								}
								continue;
							} else {

								if (SFXM.get("ZJJE") != null && (SFXM.get("ZJJE") + "").length() > 0) {
									if (Double.parseDouble(SFXM.get("ZJJE") + "") > 0) {
										mzfp.put("SFXM" + SFXM.get("MZPL"), SFXM.get("MCSX") + "");
										mzfp.put("XMJE" + SFXM.get("MZPL"), SFXM.get("ZJJE") + "");
									}
									// } else {
									// response.put("XMJE" +
									// SFXM.get("MZPL"), "0.00");
								}
							}
						} else if (SFXM.get("ZJJE") != null && (SFXM.get("ZJJE") + "").length() > 0) {
							if (Double.parseDouble(SFXM.get("ZJJE") + "") > 0) {
								if (mzfp.containsKey("QTJE")) {
									mzfp.put("QTJE", (Double.parseDouble(mzfp.get("QTJE") + "")
											+ Double.parseDouble(SFXM.get("ZJJE") + "")) + "");
								} else {
									mzfp.put("QTJE", SFXM.get("ZJJE") + "");
								}
							}
						}
					}
					if (mzfp.containsKey("QTJE")) {
						if (mzfp.containsKey("XMJE" + mzfp.get("QTPL"))
								&& (mzfp.get("XMJE" + mzfp.get("QTPL")) + "").length() > 0) {
							mzfp.put("XMJE" + mzfp.get("QTPL"),
									Double.parseDouble(mzfp.get("XMJE" + mzfp.get("QTPL")) + "")
											+ Double.parseDouble(mzfp.get("QTJE") + ""));
						} else {
							mzfp.put("XMJE" + mzfp.get("QTPL"), Double.parseDouble(mzfp.get("QTJE") + ""));
						}
					} else {
						if (mzfp.containsKey("SFXM" + mzfp.get("QTPL"))) {
							mzfp.remove("SFXM" + mzfp.get("QTPL"));
							mzfp.remove("XMJE" + mzfp.get("QTPL"));
						}
					}
					mzfpInfo.put("FPHM", fphm);
					mzfpInfo.put("POSJE", MZXX.get("POSJE"));
					mzfpInfo.put("ZFBJE", MZXX.get("ZFBJE"));
					mzfpInfo.put("FPFKFS", MZXX.get("FPFKFS"));
					mzfpInfo.put("FPFKJE", MZXX.get("FPFKJE"));
					mzfpInfo.put("XLH", MZXX.get("XLH") + "");
					mzfpInfo.put("YYYY", MZXX.get("YYYY") + "");
//						mzfp.put("MM", MZXX.get("MM") + "");
//						mzfp.put("DD", MZXX.get("DD") + "");
					mzfpInfo.put("XM", MZXX.get("XM") + "");
					mzfpInfo.put("HJJE", MZXX.get("HJJE") + "");
					mzfpInfo.put("GRJF", (new BigDecimal(MZXX.get("XJJE").toString())).add(new BigDecimal(MZXX.get("ZPJE").toString())).toString());
					mzfpInfo.put("XJZF","0");
					mzfpInfo.put("JZ", MZXX.get("JZ") + "");
					mzfpInfo.put("JGMC", jgname);
					mzfpInfo.put("SFY", MZXX.get("SFY") + "");
					mzfpInfo.put("JSFS", MZXX.get("JSFS") + "");
					// TODO 注释掉
					/*
					 * double hjje = Double.parseDouble(MZXX.get("HJJE") + ""); int sw = (int) (hjje
					 * / 100000) % 10; int w = (int) (hjje / 10000) % 10; int q = (int) (hjje /
					 * 1000) % 10; int b = (int) (hjje / 100) % 10; int s = (int) (hjje / 10) % 10;
					 * int y = (int) (hjje) % 10; int j = (int) (hjje * 10) % 10; String fStr =
					 * String.format("%.0f", hjje * 100); int f = Integer.parseInt(fStr) % 10; if (f
					 * == 0) { String jStr = String.format("%.0f", hjje * 10); j =
					 * Integer.parseInt(jStr) % 10; } mzfpInfo.put("SW", upint[sw]);
					 * mzfpInfo.put("W", upint[w]); mzfpInfo.put("Q", upint[q]); mzfpInfo.put("B",
					 * upint[b]); mzfpInfo.put("S", upint[s]); mzfpInfo.put("Y", upint[y]);
					 * mzfpInfo.put("J", upint[j]); mzfpInfo.put("F", upint[f]);
					 */
					if ("6103".equals(MZXX.get("BRXZ") + "")) {
						mzfpInfo.put("BZ", "'小病'免费:3.00");
						mzfpInfo.put("GRZF",
								"个人缴费:" + String.format("%1$.2f", (Double.parseDouble(MZXX.get("HJJE") + "") - 3.00)));
					}
					if ("6104".equals(MZXX.get("BRXZ") + "")) {
						mzfpInfo.put("GRZF", "个人缴费:3.00");
						mzfpInfo.put("BZ",
								"股民减免:" + String.format("%1$.2f", (Double.parseDouble(MZXX.get("HJJE") + "") - 3.00)));
					}
					if ("6089".equals(MZXX.get("BRXZ") + "")) {
						mzfpInfo.put("BZ", "民政救助金额:" + MZXX.get("MZJZJE") + "");
					}
					List<Map<String, Object>> details = opYjcf01Dao.doQueryYjYp(parameters1);
					// for(int i = 0 ; i < details.size() ; i ++ ){
					// Map<String,Object> detail = details.get(i);
					// mzfp.put("MXMC"+(i+1),detail.get("YPMC"));
					// mzfp.put("MXDJ"+(i+1),detail.get("YPDJ"));
					// mzfp.put("MXSL"+(i+1),detail.get("YPSL"));
					// mzfp.put("MXJE"+(i+1),detail.get("HJJE"));
					// }
					int detsize = details.size();
					if (Integer.parseInt(MZFPMXSL) != 0 && Integer.parseInt(MZFPMXSL) < detsize) {
						detsize = Integer.parseInt(MZFPMXSL);
					}
					for (int i = 0; i < detsize; i++) {
						Map<String, Object> detail = details.get(i);
						mzfp.put("HMBM" + (i + 1), detail.get("HMBM"));
						mzfp.put("MXMC" + (i + 1), detail.get("YPMC"));
						mzfp.put("MXBM" + (i + 1), detail.get("YPBM"));
						mzfp.put("MXGG" + (i + 1), detail.get("YPGG"));
						mzfp.put("MXDJ" + (i + 1), detail.get("YPDJ"));
						mzfp.put("MXSL" + (i + 1), detail.get("YPSL"));
						mzfp.put("MXJE" + (i + 1), detail.get("HJJE"));
					}
					if (detsize < details.size()) {
						mzfp.put("MXMC" + (detsize + 1), "*以上明细信息不全");
					}

					String fpyl = sysXtcsCacheSer.getCsz(req.getJgid(), "FPYL");
					String mzhjsfdyjmc = sysXtcsCacheSer.getCsz(req.getJgid(), "MZHJSFDYJMC");
					response.put("fpyl", fpyl);
					response.put("mzhjsfdyjmc", mzhjsfdyjmc);

					mzfpInfo.put("PAGE", "(" + page + "/" + MZXX.get("FPZS") + ")");
					mzfpInfo.putAll(getMzJsFyck(fphm));
					if (isYb) {
//						mzfp.putAll(getYbMzJsxx(MZXX.get("MZXH") + ""));
					} else {
						mzfpInfo.putAll(getBrkhByMzxh(MZXX.get("MZXH") + ""));
					}
					mzfpInfo.put("grzhzf", "0.00");
					mzfpInfo.put("ybtczf", "0.00");
					mzfpInfo.put("fjzf", "0.00");
					mzfpInfo.put("dnzhye", "0.00");
					mzfpInfo.put("lnzhye", "0.00");
					mzfpInfo.put("xjzfFlzf", "0.00");
					mzfpInfo.put("xjzfZifei", "0.00");
					mzfps.add(mzfp);
					mzfpInfolist.add(mzfpInfo);
					page++;
				}
			}
			response.put("mzfps", mzfps);
			response.put("jhhm", pdhm.get("JHHM"));
		}

		if (mzfpInfolist != null && !mzfpInfolist.isEmpty() && mzfpInfolist.get(0) != null) {
			OpFpdyjl opFpdyjl = new OpFpdyjl();
			opFpdyjl.setDysj(DateUtil.date().toSqlDate());
			opFpdyjl.setFphm(mzfpInfolist.get(0).get("FPHM").toString());
			opFpdyjl.setFpzs(mzfpInfolist.size());
			opFpdyjl.setDynr("");
			opFpdyjlDao.insert(opFpdyjl);
		}

//		if (mzfps != null) {
//			for (Map<String, Object> mzfp : mzfps) {
//				if ("1".equals(mzfp.get("GSBZ"))) {
//					mzfp.put("JSFS", "工伤");
//				}
//			}
//		}
		PrintMzxxResp resp = new PrintMzxxResp();
		resp.setFpyl(response.get("fpyl") != null ? response.get("fpyl").toString() : "0");
		resp.setMzhjsfdyjmc(response.get("mzhjsfdyjmc") != null ? response.get("mzhjsfdyjmc").toString() : "");
		resp.setJhhm(response.get("jhhm") != null ? response.get("jhhm").toString() : "");
		resp.setMzfpmxsl(Integer.valueOf(MZFPMXSL));
		resp.setDyfs(GHDYFS);
		resp.setNsrsbh(NSRSBH);
		List<MzfpBaseResp> mzfpBaseResp = MzUtil.ListToResultSet(mzfpInfolist, new MzfpBaseResp());
		resp.setMzfpBaseResp(mzfpBaseResp);
		resp.setFpzs(mzfpBaseResp.size());
		List<MzfpSfxmResp> sfxmList = opSfmxDao.queryDyInfo(Integer.valueOf(String.valueOf(response.get("mzxh"))));
		List<MzfpYpResp> ypList = new ArrayList<MzfpYpResp>();
		// 循环放入收费项目
		if (mzfps != null) {
			for (Map<String, Object> mzfpMap : mzfps) {
//				for (int i = 1; i <= mzfpMap.size(); i++) {
//					MzfpSfxmResp sfxmresp = new MzfpSfxmResp();
//					String sfxm = "SFXM" + i;
//					String xmje = "XMJE" + i;
//					if (mzfpMap.containsKey(sfxm)) {
//						sfxmresp.setSfxm(mzfpMap.get(sfxm).toString());
//						sfxmresp.setXmje(new BigDecimal(mzfpMap.get(xmje).toString()));
//						sfxmList.add(sfxmresp);
//					}
//				}
				// 循环放入药品信息
				for (int i = 1; i <= mzfpMap.size(); i++) {
					MzfpYpResp ypResp = new MzfpYpResp();
					String mxbm = "MXBM" + i;
					String mxmc = "MXMC" + i;
					String mxgg = "MXGG" + i;
					String mxsl = "MXSL" + i;
					String mxdj = "MXDJ" + i;
					String mxje = "MXJE" + i;
					String yfdw = "YFDW" + i;
					if (mzfpMap.containsKey(mxmc)) {
						ypResp.setMxbm(mzfpMap.get(mxbm) != null ? mzfpMap.get(mxbm).toString() : null);
						ypResp.setMxmc(mzfpMap.get(mxmc) != null ? mzfpMap.get(mxmc).toString() : null);
						ypResp.setMxgg(mzfpMap.get(mxgg) != null ? mzfpMap.get(mxgg).toString() : null);
						ypResp.setYfdw(mzfpMap.get(yfdw) != null ? mzfpMap.get(yfdw).toString() : null);
						ypResp.setMxsl(mzfpMap.get(mxsl) != null ? new BigDecimal(mzfpMap.get(mxsl).toString())
								: BigDecimal.ZERO);
						ypResp.setMxdj(mzfpMap.get(mxdj) != null ? new BigDecimal(mzfpMap.get(mxdj).toString())
								: BigDecimal.ZERO);
						ypResp.setMxje(mzfpMap.get(mxje) != null ? new BigDecimal(mzfpMap.get(mxje).toString())
								: BigDecimal.ZERO);
						ypList.add(ypResp);
					}
				}
			}
		}

		resp.setSfxmList(sfxmList);
		resp.setYpList(ypList);
		return resp;
	}

	private Map<String, Object> getMzJsFyck(String fphm) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> res = new HashMap<String, Object>();
		parameters.put("FPHM", fphm);
		List<Map<String, Object>> fycks = opCf01Dao.doQueryFyck(parameters);
		if (null != fycks && !fycks.isEmpty() && fycks.get(0) != null) {
			StringBuilder fyckStr = new StringBuilder();
			for (Map<String, Object> map : fycks) {
				fyckStr.append(map.get("FYCK") == null ? "" : map.get("FYCK"));
				fyckStr.append(",");
			}
			res.put("FYCK", fyckStr.substring(0, fyckStr.length() - 1));
		}
		return res;
	}

	/**
	 * 根据mzxh查找就诊当次就诊卡号
	 *
	 * @param mzxh
	 * @return
	 */
	private Map<String, Object> getBrkhByMzxh(String mzxh) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("MZXH", mzxh);
		return opMzxxDao.doQueryJzkh(parameters);
	}

	/**
	 * 发票查询
	 *
	 * @param req
	 * @return
	 */
	public List<QueryFphmResp> doQueryReceivablesInvoice(QueryFphmReq req) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("beginFphm", req.getBeginFphm());
		params.put("endFphm", req.getEndFphm());
		if (req.getBeginSfrq() != null) {
			params.put("beginSfrq", DateUtil.beginOfDay(DateUtil.date(req.getBeginSfrq())).toTimestamp());
		}
		if (req.getEndSfrq() != null) {
			params.put("endSfrq", DateUtil.endOfDay(DateUtil.date(req.getEndSfrq())).toTimestamp());
		}
		params.put("brxz", req.getBrxz());
		params.put("brxm", req.getBrxm());
		params.put("jzkh", req.getJzkh());
		params.put("czgh", req.getCzgh());
		params.put("jgid", req.getJgid());
		params.put("cardTypeCode", req.getCardTypeCode());
		List<QueryFphmResp> resp = opMzxxDao.doQueryFphmInfo(params);
		return resp;
	}

	// 医保相关方法
	/**
	 * 收费项目合并
	 * 
	 * @param brxz
	 * @param data
	 * @return
	 */
	public Map CollectSfxm(String brxz, Integer jgid,List<Map<String, Object>> data) {
		Map<String, Object> res = new HashMap<String, Object>();
		Double fyze = 0.0;// 费用总额
		Double czf = 0.0;// 纯自费
		Double ybflzf = 0.0;// 医保分类自付
		Map<String, Object> sfxm = new HashMap<String, Object>();
		List<Map<String, Object>> datas = new ArrayList<>();
		String MZBKBRXZ = sysXtcsCacheSer.getCsz(jgid, "MZBKBRXZ");
		for (Map<String, Object> map : data) {
			String fygb = map.get("fygb").toString();
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("fygb", fygb);
			Map<String, Object> record = dicSfxmlbService.getYbmzxm(parameters);
			map.put("YBMZXM", record.get("YBMZXM").toString());
			datas.add(map);
		}
		if (brxz.equals(MZBKBRXZ)) {
			for (int i = 0; i < datas.size(); i++) {
				Integer ybmzxm = Integer.parseInt(datas.get(i).get("YBMZXM").toString());
				Double je = Double.parseDouble(datas.get(i).get("hjje").toString());//
				fyze += je;
				if (sfxm.get(ybmzxm.toString()) != null) {
					sfxm.put(ybmzxm.toString(), Double.parseDouble(sfxm.get(ybmzxm.toString()).toString()) + je);
				} else {
					sfxm.put(ybmzxm.toString(), je);
				}
			}
			sfxm.put("zjje", fyze);// 总费用
			sfxm.put("flzf", "0");// 分类自负
			sfxm.put("ybjsfwfyze", fyze);// 医保结算范围费用总额,即总费用-纯自费
			sfxm.put("fybjsfwgrzf", "0");// 非医保结算范围个人自费
			Double jyfyze = Double.parseDouble(sfxm.get("ybjsfwfyze").toString())
					- Double.parseDouble(sfxm.get("flzf").toString());
			sfxm.put("jyfyze", jyfyze);// 交易费用总额,即医保结算范围费用总额-分类自负
			res.put("sfxm", sfxm);
		} else {
			for (int i = 0; i < datas.size(); i++) {
				String cflx = datas.get(i).get("cflx") + "";
				Integer ybmzxm = Integer.parseInt(datas.get(i).get("YBMZXM").toString());// 费用归并
				Double je = Double.parseDouble(datas.get(i).get("hjje").toString());//// 单个明细费用
				Double fygbje = je;// 单项费用归并金额
				fyze += je;// 总金额累加
				Integer YPXH = Integer.parseInt(datas.get(i).get("ypxh").toString());// 药品序号，医技序号
				if (datas.get(i).get("zfbl").toString().equals("1")) {// 如果明细的自付比例=1
					czf += je * 1;// 纯自费=金额
					fygbje = 0.0;// 费用归并金额赋值0
				} else if (this.isSpecialCzf(brxz, cflx, YPXH, jgid)) {// 特殊性质纯自费
					czf += je * Double.parseDouble(datas.get(i).get("zfbl").toString());
					fygbje = je - (je * Double.parseDouble(datas.get(i).get("zfbl").toString()));
				} else {
					ybflzf += Double.parseDouble(datas.get(i).get("hjje").toString())
							* Double.parseDouble(datas.get(i).get("zfbl").toString());// 医保分类自付
				}
				if (sfxm.get(ybmzxm.toString()) != null) {
					sfxm.put(ybmzxm.toString(), Double.parseDouble(sfxm.get(ybmzxm.toString()).toString()) + fygbje);
					sfxm.put(ybmzxm + "zz",
							Double.parseDouble(sfxm.get(ybmzxm + "zz").toString())
									+ Double.parseDouble(datas.get(i).get("hjje").toString())
											* Double.parseDouble(datas.get(i).get("ZFBL").toString()));
				} else {
					sfxm.put(ybmzxm.toString(), fygbje);
					sfxm.put(ybmzxm + "zz", Double.parseDouble(datas.get(i).get("HJJE").toString())
							* Double.parseDouble(datas.get(i).get("zfbl").toString()));
				}
			}
			sfxm.put("zjje", fyze);// 总费用
			sfxm.put("flzf", ybflzf);// 分类自负
			sfxm.put("ybjsfwfyze", fyze - czf);// 医保结算范围费用总额,即总费用-纯自费
			sfxm.put("fybjsfwgrzf", czf);// 非医保结算范围个人自费
			sfxm.put("jyfyze", fyze - czf - ybflzf);// 交易费用总额,即医保结算范围费用总额-分类自负
			res.put("sfxm", sfxm);
		}
		return res;
	}

	private boolean isSpecialCzf(String brxz, String cflx, Integer yPXH, Integer jgid) {
		String SPBRXZANDFYXH = sysXtcsCacheSer.getCsz(jgid, "SPBRXZANDFYXH");// '32'-''1'-1234','
		if (SPBRXZANDFYXH == null || SPBRXZANDFYXH.trim().length() == 0 || SPBRXZANDFYXH.equals("0")
				|| SPBRXZANDFYXH.indexOf("-") == -1) {
			return false;
		}
		String[] array = SPBRXZANDFYXH.split("\\|\\|");
		Map<String, String> map = findArray(array);
		String key = (brxz + "-" + cflx + "-" + yPXH).toString();
		boolean contatins = map.containsValue(key);
		if (contatins) {
			return true;
		} else {
			return false;
		}
	}

	public static Map<String, String> findArray(String[] str) {
		Map<String, String> map = new HashMap<String, String>();
		if (str == null) {
			return null;
		}
		for (int i = 0; i < str.length; i++) {
			map.put("key" + i, str[i]);
		}
		return map;
	}

	/**
	 * 查询是门诊就诊单元号
	 * 
	 * @param brid ghks
	 */
	public Map<String, Object> queryMZJzdyhByks(Integer brid, Integer jgid,String ghks) {
		Map<String, Object> map = new HashMap<String, Object>();
		String GHXQ = sysXtcsCacheSer.getCsz(jgid, "GHXQ");
		String XQJSFS = sysXtcsCacheSer.getCsz(jgid, "XQJSFS");
		String CFXQ = sysXtcsCacheSer.getCsz(jgid, "CFXQ");
		if (Integer.parseInt(GHXQ) < Integer.parseInt(CFXQ)) {
			GHXQ = CFXQ;
		}
		try {
			Date now = new Date();
			if ("1".equals(XQJSFS + "")) {
				SimpleDateFormat matter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				now = matter.parse(HisUtil.getDate() + " 23:59:59");
			}
			Date regBegin = DateUtils.addDays(now, -Integer.parseInt(GHXQ));
			String currDate = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(regBegin);
			String jzdyh = "";
			List<Map<String, Object>> jzdyhlist = shybSh01Service.getJzdyh(currDate, brid, jgid, ghks);
			if (jzdyhlist != null && jzdyhlist.size() > 0) {
				jzdyh = StrUtil.null2Str(jzdyhlist.get(0).get("jzdyh"));
				map.put("jzdyh", jzdyh);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 大病科室查询
	 *
	 * @return
	 */
	public List<Integer> doQueryDbybks() {
		return shybMzdbDbksService.getKsdm();
	}

	/**
	 * 检验 输入法查询 -挂号收费专用
	 * 
	 * @param par
	 * @return
	 */
	public List<QueryJsJcResp> doQueryJsjc(Map<String, Object> par) {
		return opMzxxDao.doQueryJsjc(par);
	}

	@Transactional
	@Locked("doPrintMothNext_#[req.fphm]")
	public PrintMzxxResp doPrintMothNext(PrintMzxxReq req, Integer ygdm) {
		OpMzxx opMzxx = opMzxxDao.getByFphm(req.getFphm());
		if(Objects.isNull(opMzxx)){
			throw BaseException.create("ERROR_REG_0044");
		}
		if(Objects.nonNull(opMzxx.getCdfphm())){
			throw BaseException.create("ERROR_REG_0111");
		}
		String ysFphm = opMzxx.getFphm();
		Integer ysMzxh = opMzxx.getMzxh();
		String cdFphm = opGhksSer.getNotesNumber(ygdm, req.getJgid(), OpPjlxEnum.FPHM.getKey());

		opMzxx.setFphm(cdFphm);
		opMzxxDao.updateFphmByMzxh(cdFphm, opMzxx.getMzxh());

		opMzxx.setFphm(ysFphm);
		opMzxx.setCdfphm(cdFphm);
		opMzxx.setZfpb(1);
		opMzxx.setThpb(1);
		opMzxx.setMzxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_MZXX));
		opMzxxDao.insert(opMzxx);

		for (int i = 0; i < opMzxx.getFpzs() - 1; i++) {
			opGhksSer.getNotesNumber(ygdm, req.getJgid(), OpPjlxEnum.FPHM.getKey());
		}

		opCf01Dao.updateFphmByMzxh(cdFphm, ysMzxh);
		opYjcf01Dao.updateFphmByMzxh(cdFphm, ysMzxh);
		opSfmxDao.updateFphmByMzxh(cdFphm, ysMzxh);

		OpZffp opZffp = new OpZffp();
		opZffp.setJgid(req.getJgid());
		opZffp.setCzgh(String.valueOf(ygdm));
		opZffp.setFphm(ysFphm);
		opZffp.setMzxh(opMzxx.getMzxh());
		opZffp.setMzlb(opMzxx.getMzlb());
		opZffp.setJzlsh(opMzxx.getJzlsh());
		opZffp.setZfrq(DateUtil.date().toTimestamp());
		opZffpDao.insert(opZffp);

		req.setFphm(cdFphm);
		return doPrintMoth(req);
	}
}
