package com.buit.his.op.reg.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.print.PrintException;

import com.buit.commons.SysUser;
import com.buit.commons.model.*;
import com.buit.commons.response.SfrbhzResp;
import com.buit.constans.TableName;
import cn.hutool.core.date.DatePattern;
import com.buit.system.utill.ObjectToTypes;
import com.buit.utill.RedisFactory;
import com.buit.utill.StrUtil;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.PageQuery;
import com.buit.commons.dao.GhrbReportDao;
import com.buit.commons.dao.OpCf02Dao;
import com.buit.commons.dao.OpCzFkxxDao;
import com.buit.commons.dao.OpFkxxDao;
import com.buit.commons.dao.OpGhFkxxDao;
import com.buit.commons.dao.OpGhmxDao;
import com.buit.commons.dao.OpGhmxZjjsZsfpDao;
import com.buit.commons.dao.OpGhmxZkDao;
import com.buit.commons.dao.OpGhrbDao;
import com.buit.commons.dao.OpGhrbFkmxDao;
import com.buit.commons.dao.OpGrmxDao;
import com.buit.commons.dao.OpHzrbDao;
import com.buit.commons.dao.OpMzxxDao;
import com.buit.commons.dao.OpRbmxDao;
import com.buit.commons.dao.OpSfrbFkmxDao;
import com.buit.commons.dao.OpThmxDao;
import com.buit.commons.dao.OpXzmxDao;
import com.buit.commons.dao.OpYjcf02Dao;
import com.buit.commons.dao.OpZffpDao;
import com.buit.commons.model.GhrbReport;
import com.buit.commons.model.OpGhrb;
import com.buit.commons.model.OpGhrbFkmx;
import com.buit.commons.model.OpGrmx;
import com.buit.commons.model.OpHzrb;
import com.buit.commons.model.OpRbmx;
import com.buit.commons.model.OpSfrbFkmx;
import com.buit.commons.model.OpXzmx;
import com.buit.commons.response.QueryCancelCommitResp;
import com.buit.commons.response.SfrbResp;
import com.buit.system.request.PubFkfsModel;
import com.buit.system.response.HrPersonnelModel;
import com.buit.system.service.DicSfxmlbService;
import com.buit.system.service.HrPersonnelService;
import com.buit.system.service.PubBrxzOutSer;
import com.buit.system.service.PubFkfsService;
import com.buit.system.service.SysXtcsCacheSer;
import com.buit.utill.MzUtil;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.CaseInsensitiveMap;

/**
 * <br>
 * 
 * @author WY
 */
@Service
public class GhrbReportSer extends BaseManagerImp<GhrbReport, Integer> {

	static final Logger logger = LoggerFactory.getLogger(GhrbReportSer.class);

	@Autowired
	private GhrbReportDao ghrbReportDao;

	@DubboReference
	private PubBrxzOutSer pubBrxzOutSer;

	@Autowired
	private OpMzxxDao opMzxxDao;

	@Autowired
	private OpMzlbSer opMzlbSer;

	@DubboReference
	private SysXtcsCacheSer sysXtcsCacheSer;

	@DubboReference
	private PubFkfsService pubFkfsService;

	@Autowired
	private OpZffpDao opZffpDao;

	@Autowired
	private OpThmxDao opThmxDao;

	@Autowired
	private OpGhmxDao opGhmxDao;

//	@Autowired
//	private JcJcjsDao jcJcjsDao;

	@Autowired
	private OpFkxxDao opFkxxDao;

	@Autowired
	private OpHzrbDao opHzrbDao;

	@Autowired
	private OpRbmxDao opRbmxDao;

	@Autowired
	private OpXzmxDao opXzmxDao;

	@Autowired
	private OpSfrbFkmxDao opSfrbFkmxDao;

	@Autowired
	private OpGhrbDao opGhrbDao;

	@Autowired
	private OpGrmxDao opGrmxDao;

	@Autowired
	private OpGhrbFkmxDao opGhrbFkmxDao;

	@Autowired
	private OpGhmxZkDao opGhmxZkDao;

	@Autowired
	private OpGhmxZjjsZsfpDao opGhmxZjjsZsfpDao;

	@Autowired
	private OpCzFkxxDao opCzFkxxDao;

	@Autowired
	private OpYjcf02Dao opYjcf02Dao;

	@Autowired
	private OpCf02Dao opCf02Dao;

	@DubboReference
	private HrPersonnelService hrPersonnelService;

	@DubboReference
	private DicSfxmlbService dicSfxmlbService;

	@Autowired
	private OpGhFkxxDao opGhFkxxDao;

	@Autowired
	private RedisFactory redisFactory;

	@Override
	public GhrbReportDao getEntityMapper() {
		return ghrbReportDao;
	}

	public java.util.Date nowdate = DateUtil.date().toTimestamp();

	/**
	 * 挂号日报获取报表字段值
	 * 
	 * @param userId
	 * @return
	 */
	public Map<String, Object> getParameters(Integer userId, Date ghsj, Integer jgid, String ip) {
		Map<String, Object> resp = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("CZGH", userId);
		parameters.put("beginOfDay", DateUtil.beginOfDay(DateUtil.date(ghsj)).toTimestamp());
		parameters.put("endOfDay", DateUtil.endOfDay(DateUtil.date(ghsj)).toTimestamp());
		List<Map<String, Object>> list = ghrbReportDao.getParameters(parameters);

		Map<String, Object> p = new HashMap<String, Object>();
		if (list.size() > 0 && list != null) {
			p = totalCount(list);
			resp.put("GHRS1", p.get("GHRS1"));
			resp.put("GHJE1", p.get("GHJE1"));
			resp.put("ZLJE1", p.get("ZLJE1"));
			resp.put("ZJJE1", p.get("ZJJE1"));
			resp.put("BLJE1", p.get("BLJE1"));
			resp.put("HJ1", p.get("HJ1"));
		}

		double dxje = resp.get("HJ1") != null ? Double.valueOf(resp.get("HJ1").toString()) : 0;
		String dxjeBig = String.format("%1$.2f", new BigDecimal(ObjectToTypes.null2Str(dxje)));
		if (dxje < 0) {
			resp.put("AMOUNTIN", "负" + MzUtil.changeMoneyUpper(String.format("%1$.2f", -(dxje))) + "(" + dxjeBig + ")");
		} else {
			resp.put("AMOUNTIN", MzUtil.changeMoneyUpper(String.format("%1$.2f", dxje)) + "(" + dxjeBig + ")");
		}
		// 当日现金金额求和
		parameters.put("fkfs", 1);
		BigDecimal xjje = opGhFkxxDao.doSumFkjeByFkfs(parameters);
		resp.put("XJJE", xjje);
		// 支票
		parameters.remove("fkfs");
		parameters.put("fkfs", 2);
		BigDecimal zpje = opGhFkxxDao.doSumFkjeByFkfs(parameters);
		resp.put("ZPJE", zpje);
		// 账户

		// 货币误差
		BigDecimal hbwc = opGhmxDao.doQueryHbwcByDay(parameters);
		resp.put("HBWC", hbwc);
		// 退号号码
		StringBuffer thjzhmxx = new StringBuffer();
		parameters.put("jgid", jgid);
		Integer mzlb = opMzlbSer.getMzlb(jgid, ip);
		parameters.put("mzlb", mzlb);
		List<Map<String, Object>> zfFphmList = opGhmxDao.doQueryZfFphm(parameters);
		if (zfFphmList != null && zfFphmList.size() > 0) {
			thjzhmxx.append("退号:");
			for (int i = 0; i < zfFphmList.size(); i++) {
				Map<String, Object> thfpMap = zfFphmList.get(i);
				thjzhmxx.append(thfpMap.get("PJHM") + "(" + thfpMap.get("BRXM") + "," + thfpMap.get("FKMC") + ":"
						+ thfpMap.get("FKJE") + ") ");
			}
			resp.put("INVALIDGH", thjzhmxx.toString());
		}
		HrPersonnelModel hrPersonnel = hrPersonnelService.getPersonnelById(userId);
		if (hrPersonnel != null) {
			resp.put("SFY", hrPersonnel.getPersonname());
		}
		resp.put("DATETABLING", DateUtil.date().toSqlDate());
		resp.put("SKRQ", ghsj);
		return resp;
	}

	/**
	 * 挂号日报获取报表数据列表
	 * 
	 * @param userId
	 * @return
	 */
	public List<Map<String, Object>> getFields(Integer userId, Date ghsj) {
		List<Map<String, Object>> records = new ArrayList<Map<String, Object>>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("CZGH", userId);
		parameters.put("beginOfDay", DateUtil.beginOfDay(DateUtil.date(ghsj)).toTimestamp());
		parameters.put("endOfDay", DateUtil.endOfDay(DateUtil.date(ghsj)).toTimestamp());
		List<Map<String, Object>> list = ghrbReportDao.getParameters(parameters);
		List<Map<String, Object>> list1 = totalCount1(list, "BRXZ");
		if (list1 != null && list1.size() > 0) {
			records.addAll(list1);
		}
		return records;
	}

	/**
	 * 获取最后一行合计
	 * 
	 * @param tempList
	 * @return
	 */
	public static Map<String, Object> totalCount(List<Map<String, Object>> tempList) {
		if (tempList.size() > 0) {
			Map<String, Object> map1 = tempList.get(0);
			Map<String, Object> map = new HashMap<String, Object>();
			for (String key1 : map1.keySet()) {
				BigDecimal sum = new BigDecimal(0);
				String key = null;
				for (int i = 0; i < tempList.size(); i++) {
					BigDecimal a = new BigDecimal(tempList.get(i).get(key1).toString());
					sum = sum.add(a);
					key = key1 + "1";
				}
				map.put(key, sum);
			}
			return map;
		}
		return null;
	}

	/**
	 * 第一列通过key替换为字典的value
	 * 
	 * @param tempList
	 * @param dic_key
	 * @return
	 */
	public List<Map<String, Object>> totalCount1(List<Map<String, Object>> tempList, String dic_key) {
		if (tempList.size() > 0) {
			for (int i = 0; i < tempList.size(); i++) {
				Integer key = Integer.valueOf(tempList.get(i).get(dic_key).toString());
				String text = pubBrxzOutSer.getBrmcPubBrxz(key).getXzmc();
				if (text.length() > 0) {
					tempList.get(i).remove(dic_key);
					tempList.get(i).put(dic_key, text);
				}
			}
			return tempList;
		}
		return null;
	}

	public Map<String, Object> getCountWorksParameters(String userName, Date beginDay, Date endDay) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("now", DateUtil.date().toSqlDate());
		response.put("czy", userName);
		response.put("begindate", beginDay);
		response.put("enddate", endDay);
		return response;
	}

	/**
	 * 挂号工作量统计
	 * 
	 * @param beginDay
	 * @param endDay
	 */
	public List<Map<String, Object>> getCountWorksFields(Date beginDay, Date endDay) {
		List<Map<String, Object>> records = new ArrayList<Map<String, Object>>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("beginDay", DateUtil.beginOfDay(beginDay).toTimestamp());
		parameters.put("endDay", DateUtil.endOfDay(endDay).toTimestamp());
		parameters.put("brxz", 6021);
		List<Map<String, Object>> list = ghrbReportDao.getCountWorksFields(parameters);
		records.addAll(list);
		return records;
	}

	/**
	 * 收费日报报表产生
	 * 
	 * @param request
	 * @param response
	 * @param ctx
	 * @throws PrintException
	 */
	@Transactional(rollbackFor = Exception.class)
	public Map<String, Object> getLastHzrqParameters(Date beginDay, Date endDay, Integer jgid, Integer uid,
			String userName, String ip) {
		Map<String, Object> response = new HashMap<String, Object>();
		Map<String, Object> jzrqMap = new HashMap<String, Object>();
		jzrqMap.put("jgid", jgid);
		// 获取门诊类别
		Integer mzlb = opMzlbSer.getMzlb(jgid, ip);

		jzrqMap.put("mzlb", mzlb);
		jzrqMap.put("czgh", uid);

		List<Map<String, Object>> jzrqMap1 = opMzxxDao.doQueryJzrq(jzrqMap);
		if (jzrqMap1 != null && jzrqMap1.get(0) != null) {
			Date jzrq = DateUtil.date(DateUtil.parse(jzrqMap1.get(0).get("jzrq").toString())).toSqlDate();
			if (jzrq == null) {
				response.put("body", "");
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
				response.put("body", sdf.format(jzrq));
			}
		}
		// 存收费日报明细OP_RBMX
		List<Map<String, Object>> list_rbmx = new ArrayList<Map<String, Object>>();
		// 存收费日报性质明细OP_XZMX
		List<Map<String, Object>> list_xzmx = new ArrayList<Map<String, Object>>();
		// 存收费日报付款明细OP_SFRB_FKMX
		List<Map<String, Object>> list_sfrb_fkmx = new ArrayList<Map<String, Object>>();
		// 存挂号日报付款明细OP_GHRB_FKMX
		List<Map<String, Object>> list_ghrb_fkmx = new ArrayList<Map<String, Object>>();
		Map<String, Object> map_mzxx_all = new HashMap<String, Object>();
		Map<String, Object> map_ghrb_all = new HashMap<String, Object>();
		List<Map<String, Object>> list_ghrbmx = new ArrayList<Map<String, Object>>();
		String fpxx = "";
		StringBuffer zffpxx = new StringBuffer();
		StringBuffer thjzhmxx = new StringBuffer();

		String SQXTMS = sysXtcsCacheSer.getCsz(jgid, "SQXTMS");
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("jgid", jgid);
		parameters.put("czgh", uid);
		parameters.put("begindate",beginDay+" 00:00:00");
		parameters.put("enddate",endDay+" 23:59:59");
		double sfhj = 0.0;
		String fkxx = "";
		String zfxx = "";
		double qtys = 0.0;
		double jjzfje = 0.0;
		double zfje = 0.0;
		int zfzs = 0;
		int fpzs = 0;
		double thje = 0.0;
		int thsl = 0;
		String thxx = "";
		double ghhj = 0.0;
		double ghje = 0.0;
		double zlje = 0.0;
		double blje = 0.0;
		double zjfy = 0.0;
		parameters.put("mzlb", mzlb);

		StringBuffer hql_mzxx = new StringBuffer();// 统计收费信息OP_MZXX
		StringBuffer hql_mzxx_zf = new StringBuffer();// 统计收费作废信息OP_MZXX
														// OP_ZFFP
		StringBuffer hql_sfmx = new StringBuffer();// 统计收费明细OP_SFMX
		StringBuffer hql_sfmx_zf = new StringBuffer();// 统计收费作废明细OP_SFMX
														// OP_ZFFP
		StringBuffer hql_xzmx = new StringBuffer();// 统计性质明细OP_XZMX
		StringBuffer hql_xzmx_zf = new StringBuffer();// 统计性质作废明细OP_XZMX
														// OP_ZFFP
		StringBuffer hql_fkxx = new StringBuffer();// 统计付款明细OP_FKXX
		StringBuffer hql_fkxx_zf = new StringBuffer();// 统计付款作废明细OP_FKXX
														// OP_ZFFP
		StringBuffer hql_fpxx = new StringBuffer();// 统计发票信息OP_MZXX
		StringBuffer hql_zffpxx = new StringBuffer();// 统计作废发票信息OP_MZXX
														// OP_ZFFP
		StringBuffer hql_ghmx = new StringBuffer();// 统计挂号信息OP_GHMX
		StringBuffer hql_ghthmx = new StringBuffer();// 统计退号信息OP_GHMX
														// OP_THMX
		StringBuffer hql_grmx = new StringBuffer();// 统计挂号信息OP_GHMX
		StringBuffer hql_grthmx = new StringBuffer();// 统计退号信息OP_GHMX
														// OP_THMX
		StringBuffer hql_ghfkxx = new StringBuffer();// 统计挂号付款金额OP_GHMX
														// OP_GH_FKXX
		StringBuffer hql_ghfkxx_zf = new StringBuffer();// 统计退号付款金额OP_GHMX
														// OP_THMX
														// OP_GH_FKXX
//			StringBuffer hql_jzhm = new StringBuffer();// 统计就诊号码信息OP_GHMX
		StringBuffer hql_jzhm_zf = new StringBuffer();// 统计退号就诊号码信息OP_GHMX

		List<Map<String, Object>> mzxxList = opMzxxDao.doQuerySfxx(parameters);
		Map<String, Object> map_mzxx = new HashMap<String, Object>();
		if (mzxxList.size() > 0) {
			map_mzxx = mzxxList.get(0);
		}
//			double syb = 0.00;
//			double sjyb = 0.00;
		if (map_mzxx != null && map_mzxx.size() > 0) {
//				syb = ObjectToTypes.parseDouble(map_mzxx.get("SYB"));
//				sjyb = ObjectToTypes.parseDouble(map_mzxx.get("SJYB"));
//				map_mzxx_all.put("SYB", ObjectToTypes.parseDouble(map_mzxx.get("SYB")));
//				map_mzxx_all.put("SJYB", ObjectToTypes.parseDouble(map_mzxx.get("SJYB")));
			map_mzxx_all.put("CZGH", map_mzxx.get("CZGH"));
			map_mzxx_all.put("MZLB", mzlb);
			map_mzxx_all.put("ZJJE", ObjectToTypes.parseDouble(map_mzxx.get("ZJJE")));
			map_mzxx_all.put("XJJE", ObjectToTypes.parseDouble(map_mzxx.get("XJJE")));
			map_mzxx_all.put("ZPJE", ObjectToTypes.parseDouble(map_mzxx.get("ZPJE")));
			map_mzxx_all.put("QTYS", ObjectToTypes.parseDouble(map_mzxx.get("QTYS")));
			if (map_mzxx.get("JJZFJE") != null) {
				map_mzxx_all.put("JJZFJE", ObjectToTypes.parseDouble(map_mzxx.get("JJZFJE")));
			} else {
				map_mzxx_all.put("JJZFJE", 0.0);
			}
			map_mzxx_all.put("HBWC", ObjectToTypes.parseDouble(map_mzxx.get("HBWC") + ""));
			map_mzxx_all.put("JMJE", ObjectToTypes.parseDouble(map_mzxx.get("JMJE")));

			if (map_mzxx.get("FPZS") != null) {
				map_mzxx_all.put("FPZS", ObjectToTypes.parseInt(map_mzxx.get("FPZS")));
			} else {
				map_mzxx_all.put("FPZS", 0);
			}
			map_mzxx_all.put("ZFZS", 0);
			map_mzxx_all.put("ZFJE", 0.0);
		}
		List<Map<String, Object>> mzxx_zf_list = opMzxxDao.doQuerySfzfxx(parameters);
		Map<String, Object> map_mzxx_zf = new HashMap<String, Object>();
		if (mzxx_zf_list.size() > 0) {
			map_mzxx_zf = mzxx_zf_list.get(0);
		}
		if (map_mzxx_zf != null && map_mzxx_zf.size() > 0) {
			if (map_mzxx_all.size() > 0) {
				if (map_mzxx_zf.get("JJZFJE") != null) {
					map_mzxx_zf.put("JJZFJE", -ObjectToTypes.parseDouble(map_mzxx_zf.get("JJZFJE")));
				} else {
					map_mzxx_zf.put("JJZFJE", 0.00);
				}
				map_mzxx_all.put("ZJJE", ObjectToTypes.parseDouble(map_mzxx_all.get("ZJJE"))
						- ObjectToTypes.parseDouble(map_mzxx_zf.get("ZJJE")));
//					sybzf = ObjectToTypes.parseDouble(map_mzxx_zf.get("SYB"));
//					map_mzxx_all.put("SYB",
//							ObjectToTypes.parseDouble(map_mzxx_all.get("SYB"))
//									- ObjectToTypes.parseDouble(map_mzxx_zf.get("SYB")));
//					sjybzf = ObjectToTypes.parseDouble(map_mzxx_zf.get("SJYB"));
//					map_mzxx_all.put("SZYB",
//							ObjectToTypes.parseDouble(map_mzxx_all.get("SJYB"))
//									- ObjectToTypes.parseDouble(map_mzxx_zf.get("SJYB")));
				map_mzxx_all.put("XJJE", ObjectToTypes.parseDouble(map_mzxx_all.get("XJJE"))
						- ObjectToTypes.parseDouble(map_mzxx_zf.get("XJJE")));
				map_mzxx_all.put("ZPJE", ObjectToTypes.parseDouble(map_mzxx_all.get("ZPJE"))
						- ObjectToTypes.parseDouble(map_mzxx_zf.get("ZPJE")));
				map_mzxx_all.put("QTYS", ObjectToTypes.parseDouble(map_mzxx_all.get("QTYS"))
						- ObjectToTypes.parseDouble(map_mzxx_zf.get("QTYS")));
				map_mzxx_all.put("JJZFJE", ObjectToTypes.parseDouble(map_mzxx_all.get("JJZFJE"))
						+ ObjectToTypes.parseDouble(map_mzxx_zf.get("JJZFJE")));
				map_mzxx_all.put("HBWC", ObjectToTypes.parseDouble(map_mzxx_all.get("HBWC"))
						- ObjectToTypes.parseDouble(map_mzxx_zf.get("HBWC")));
				map_mzxx_all.put("JMJE", ObjectToTypes.parseDouble(map_mzxx_all.get("JMJE"))
						- ObjectToTypes.parseDouble(map_mzxx_zf.get("JMJE")));
				map_mzxx_all.put("ZFZS", ObjectToTypes.parseInt(map_mzxx_all.get("ZFZS"))
						+ ObjectToTypes.parseInt(map_mzxx_zf.get("FPZS")));
				map_mzxx_all.put("ZFJE", ObjectToTypes.parseDouble(map_mzxx_all.get("ZFJE"))
						+ ObjectToTypes.parseDouble(map_mzxx_zf.get("ZJJE")));
			} else {
				map_mzxx_all.put("CZGH", map_mzxx_zf.get("CZGH"));
				map_mzxx_all.put("MZLB", mzlb);
//					sybzf = ObjectToTypes.parseDouble(map_mzxx_zf.get("SYB"));
//					sjybzf = ObjectToTypes.parseDouble(map_mzxx_zf.get("SJYB"));
//					map_mzxx_all.put("SYB",
//							-ObjectToTypes.parseDouble(map_mzxx_zf.get("SYB")));
//					map_mzxx_all.put("SZYB",
//							-ObjectToTypes.parseDouble(map_mzxx_zf.get("SJYB")));
				map_mzxx_all.put("ZJJE", -ObjectToTypes.parseDouble(map_mzxx_zf.get("ZJJE")));
				map_mzxx_all.put("XJJE", -ObjectToTypes.parseDouble(map_mzxx_zf.get("XJJE")));
				map_mzxx_all.put("ZPJE", -ObjectToTypes.parseDouble(map_mzxx_zf.get("ZPJE")));
				map_mzxx_all.put("QTYS", -ObjectToTypes.parseDouble(map_mzxx_zf.get("QTYS")));
				if (map_mzxx_zf.get("JJZFJE") == null) {
					map_mzxx_zf.put("JJZFJE", 0.00);
				}
				map_mzxx_all.put("JJZFJE", -ObjectToTypes.parseDouble(map_mzxx_zf.get("JJZFJE")));
				map_mzxx_all.put("HBWC", -ObjectToTypes.parseDouble(map_mzxx_zf.get("HBWC")));
				map_mzxx_all.put("JMJE", -ObjectToTypes.parseDouble(map_mzxx_zf.get("JMJE")));
				map_mzxx_all.put("FPZS", ObjectToTypes.parseInt(map_mzxx_zf.get("FPZS")));
				map_mzxx_all.put("ZFZS", ObjectToTypes.parseInt(map_mzxx_zf.get("FPZS")));
				map_mzxx_all.put("ZFJE", ObjectToTypes.parseDouble(map_mzxx_zf.get("ZJJE")));
			}
			zfje = ObjectToTypes.parseDouble(map_mzxx_zf.get("ZJJE"));
			zfzs = ObjectToTypes.parseInt(map_mzxx_zf.get("FPZS"));
			zfxx = "张数：" + zfzs + " 作废金额：" + String.format("%1$.2f", zfje);
		}
		if (map_mzxx_all.size() > 0) {
			map_mzxx_all.put("JZRQ", nowdate);
			map_mzxx_all.put("JGID", jgid);
			map_mzxx_all.put("ZFZF", 0.0);
			qtys = qtys + ObjectToTypes.parseDouble(map_mzxx_all.get("QTYS"));
			jjzfje = jjzfje + ObjectToTypes.parseDouble(map_mzxx_all.get("JJZFJE"));
			if (map_mzxx_all.get("FPZS") != null) {
				fpzs = fpzs + Integer.parseInt(map_mzxx_all.get("FPZS").toString());
			}
		}
		// 计算划价金额的时候，划价金额加挂号金额之和总是比其他应收的总计金额少一部分作废发票的减免的金额的钱（原因：划价金额计算的时候）
		List<Map<String, Object>> list_sfmx = opMzxxDao.doQuerySfmx(parameters);
		List<Map<String, Object>> list_sfmx_zf = opMzxxDao.doQuerySfzfmx(parameters);
		if (list_sfmx != null && list_sfmx.size() != 0) {
			for (int i = 0; i < list_sfmx.size(); i++) {
				Map<String, Object> map_sfmx = list_sfmx.get(i);
				Map<String, Object> map_sfmx_all = new HashMap<String, Object>();
				map_sfmx_all.put("SFXM", map_sfmx.get("SFXM"));
				map_sfmx_all.put("CZGH", uid);
				map_sfmx_all.put("SFJE", ObjectToTypes.parseDouble(map_sfmx.get("ZJJE")));
				map_sfmx_all.put("JGID", jgid);
				map_sfmx_all.put("JZRQ", nowdate);
				if (list_sfmx_zf != null && list_sfmx_zf.size() != 0) {
					for (int J = 0; J < list_sfmx_zf.size(); J++) {
						Map<String, Object> map_sfmx_zf = list_sfmx_zf.get(J);
						if (map_sfmx_zf.containsKey("SFXM")) {
							if (Long.parseLong(map_sfmx.get("SFXM") + "") == Long
									.parseLong(map_sfmx_zf.get("SFXM") + "")) {
								map_sfmx_all.put("SFJE", ObjectToTypes.parseDouble(map_sfmx_all.get("SFJE"))
										- ObjectToTypes.parseDouble(map_sfmx_zf.get("ZJJE")));
								list_sfmx_zf.remove(J);
								J--;
							}
						}
					}
				}
				list_rbmx.add(map_sfmx_all);
			}
			if (list_sfmx_zf != null && list_sfmx_zf.size() != 0) {
				for (int i = 0; i < list_sfmx_zf.size(); i++) {
					Map<String, Object> map_sfmx_zf = list_sfmx_zf.get(i);
					if (map_sfmx_zf.containsKey("SFXM")) {
						Map<String, Object> map_sfmx_all = new HashMap<String, Object>();
						map_sfmx_all.put("SFXM", map_sfmx_zf.get("SFXM"));
						map_sfmx_all.put("CZGH", uid);
						map_sfmx_all.put("SFJE", -ObjectToTypes.parseDouble(map_sfmx_zf.get("ZJJE")));
						map_sfmx_all.put("JGID", jgid);
						map_sfmx_all.put("JZRQ", nowdate);
						list_rbmx.add(map_sfmx_all);
						list_sfmx_zf.remove(i);
						i--;
					}
				}
			}

		} else {
			if (list_sfmx_zf != null && list_sfmx_zf.size() != 0) {
				for (int k = 0; k < list_sfmx_zf.size(); k++) {
					Map<String, Object> map_sfmx_zf = list_sfmx_zf.get(k);
					Map<String, Object> map_sfmx_all = new HashMap<String, Object>();
					map_sfmx_all.put("SFXM", map_sfmx_zf.get("SFXM"));
					map_sfmx_all.put("CZGH", uid);
					map_sfmx_all.put("SFJE", -ObjectToTypes.parseDouble(map_sfmx_zf.get("ZJJE")));
					map_sfmx_all.put("JGID", jgid);
					map_sfmx_all.put("JZRQ", nowdate);
					list_rbmx.add(map_sfmx_all);
				}
			}
		}
		if (list_rbmx.size() > 0) {
			for (Map<String, Object> map_rbmx : list_rbmx) {
				sfhj = sfhj + ObjectToTypes.parseDouble(map_rbmx.get("SFJE"));
			}
		}

		List<Map<String, Object>> list_sfxm_xz = opMzxxDao.doQueryXzmx(parameters);
		List<Map<String, Object>> list_sfxm_xz_zf = opMzxxDao.doQueryXzzfmx(parameters);

		if (list_sfxm_xz != null && list_sfxm_xz.size() != 0) {
			for (int i = 0; i < list_sfxm_xz.size(); i++) {
				Map<String, Object> map_sfmx_xz = list_sfxm_xz.get(i);
				Map<String, Object> map_xzmx_all = new HashMap<String, Object>();
				map_xzmx_all.put("BRXZ", map_sfmx_xz.get("BRXZ"));
				map_xzmx_all.put("SFJE", ObjectToTypes.parseDouble(map_sfmx_xz.get("ZJJE")));
				map_xzmx_all.put("FPZS", ObjectToTypes.parseInt(map_sfmx_xz.get("FPZS")));
				map_xzmx_all.put("JGID", jgid);
				map_xzmx_all.put("JZRQ", nowdate);
				map_xzmx_all.put("CZGH", uid);
				if (list_sfxm_xz_zf != null && list_sfxm_xz_zf.size() != 0) {
					for (int J = 0; J < list_sfxm_xz_zf.size(); J++) {
						Map<String, Object> map_sfmx_xz_zf = list_sfxm_xz_zf.get(J);
						if (map_sfmx_xz_zf.containsKey("BRXZ")) {
							if (Long.parseLong(map_sfmx_xz.get("BRXZ") + "") == Long
									.parseLong(map_sfmx_xz_zf.get("BRXZ") + "")) {
								map_xzmx_all.put("SFJE", ObjectToTypes.parseDouble(map_xzmx_all.get("SFJE"))
										- ObjectToTypes.parseDouble(map_sfmx_xz_zf.get("ZJJE")));
								list_sfxm_xz_zf.remove(J);
								J--;
							}
						}
					}
				}
				list_xzmx.add(map_xzmx_all);
			}

			if (list_sfxm_xz_zf != null && list_sfxm_xz_zf.size() != 0) {
				for (int J = 0; J < list_sfxm_xz_zf.size(); J++) {
					Map<String, Object> map_sfmx_xz_zf = list_sfxm_xz_zf.get(J);
					if (map_sfmx_xz_zf.containsKey("BRXZ")) {
						Map<String, Object> map_xzmx_all = new HashMap<String, Object>();
						map_xzmx_all.put("BRXZ", map_sfmx_xz_zf.get("BRXZ"));
						map_xzmx_all.put("SFJE", -ObjectToTypes.parseDouble(map_sfmx_xz_zf.get("ZJJE")));
						map_xzmx_all.put("FPZS", map_sfmx_xz_zf.get("FPZS"));
						map_xzmx_all.put("JGID", jgid);
						map_xzmx_all.put("JZRQ", nowdate);
						map_xzmx_all.put("CZGH", uid);
						list_sfxm_xz_zf.remove(J);
						list_xzmx.add(map_xzmx_all);
						J--;
					}
				}
			}

		} else {
			if (list_sfxm_xz_zf != null && list_sfxm_xz_zf.size() != 0) {
				for (int k = 0; k < list_sfxm_xz_zf.size(); k++) {
					Map<String, Object> map_sfmx_xz_zf = list_sfxm_xz_zf.get(k);
					Map<String, Object> map_xzmx_all = new HashMap<String, Object>();
					map_xzmx_all.put("BRXZ", map_sfmx_xz_zf.get("BRXZ"));
					map_xzmx_all.put("CZGH", uid);
					map_xzmx_all.put("SFJE", -ObjectToTypes.parseDouble(map_sfmx_xz_zf.get("ZJJE")));
					map_xzmx_all.put("JGID", jgid);
					map_xzmx_all.put("JZRQ", nowdate);
					map_xzmx_all.put("FPZS", -ObjectToTypes.parseInt(map_sfmx_xz_zf.get("FPZS")));
					list_xzmx.add(map_xzmx_all);
				}
			}
		}
		List<Map<String, Object>> list_fkmx = opMzxxDao.doQueryFkxx(parameters);
		List<Map<String, Object>> list_fkmx_zf = opMzxxDao.doQueryFkzfxx(parameters);
		double smk = 0.00;
		double smkzf = 0.00;
		if (list_fkmx != null && list_fkmx.size() != 0) {
			for (int i = 0; i < list_fkmx.size(); i++) {
				Map<String, Object> map_fkxx = list_fkmx.get(i);
				Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
				map_fkxx_all.put("FKFS", map_fkxx.get("FKFS"));
				if (ObjectToTypes.parseInt(map_fkxx.get("FKFS")) == 1) {
					smk += ObjectToTypes.parseDouble(map_fkxx.get("FKJE"));
				}
				map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx.get("FKJE")));
				map_fkxx_all.put("CZGH", uid);
				map_fkxx_all.put("JGID", jgid);
				map_fkxx_all.put("JZRQ", nowdate);
				if (list_fkmx_zf != null && list_fkmx_zf.size() != 0) {
					for (int J = 0; J < list_fkmx_zf.size(); J++) {
						Map<String, Object> map_fkxx_zf = list_fkmx_zf.get(J);
						if (map_fkxx_zf.containsKey("FKFS")) {
							if (Long.parseLong(map_fkxx.get("FKFS") + "") == Long
									.parseLong(map_fkxx_zf.get("FKFS") + "")) {
								map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx_all.get("FKJE"))
										- ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE")));
								list_fkmx_zf.remove(J);
								J--;
							}
						}
					}
				}
				list_sfrb_fkmx.add(map_fkxx_all);
			}
			if (list_fkmx_zf != null && list_fkmx_zf.size() != 0) {
				for (int J = 0; J < list_fkmx_zf.size(); J++) {
					Map<String, Object> map_fkxx_zf = list_fkmx_zf.get(J);
					Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
					map_fkxx_all.put("FKFS", map_fkxx_zf.get("FKFS"));
					if (ObjectToTypes.parseInt(map_fkxx_zf.get("FKFS")) == 1) {
						smkzf += ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE"));
					}
					map_fkxx_all.put("FKJE", -ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE")));
					map_fkxx_all.put("CZGH", uid);
					map_fkxx_all.put("JGID", jgid);
					map_fkxx_all.put("JZRQ", nowdate);
					list_fkmx_zf.remove(J);
					list_sfrb_fkmx.add(map_fkxx_all);
					J--;
				}
			}
		} else {
			if (list_fkmx_zf != null && list_fkmx_zf.size() != 0) {
				for (int k = 0; k < list_fkmx_zf.size(); k++) {
					Map<String, Object> map_fkxx_zf = list_fkmx_zf.get(k);
					Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
					map_fkxx_all.put("FKFS", map_fkxx_zf.get("FKFS"));
					map_fkxx_all.put("CZGH", uid);
					map_fkxx_all.put("FKJE", -ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE")));
					map_fkxx_all.put("JGID", jgid);
					map_fkxx_all.put("JZRQ", nowdate);
					list_sfrb_fkmx.add(map_fkxx_all);
				}
			}
		}
		if (smk != 0.00) {
			map_mzxx_all.put("SMK", smk - smkzf);
		}

		int fpzsSum = 0; // 总发票张数

		List<Map<String, Object>> list_fpxx = opMzxxDao.doQueryFpxx(parameters);
		List<Map<String, Object>> addlist_fpxx = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < list_fpxx.size(); i++) {
			Map<String, Object> map_fpxx = list_fpxx.get(i);
			fpzsSum += Long.parseLong(map_fpxx.get("FPZS") + "");
//				Object Lb = map_fpxx.get("Lb"); 原来是Lb为什么是Lb 数据库返回的结果是LB
			Object Lb = map_fpxx.get("LB");

			if (Long.parseLong(map_fpxx.get("FPZS") + "") > 1) {
				for (int j = 1; j < Long.parseLong(map_fpxx.get("FPZS") + ""); j++) {
					String fphm = map_fpxx.get("FPHM") + "";
					int k = -1;
					for (int q = fphm.length() - 1; q >= 0; q--) {
						if (fphm.charAt(q) < '0' || fphm.charAt(q) > '9') {
							k = q;
							break;
						}
					}
					String fphmzm = fphm.substring(0, k + 1);
					String fphmsz = fphm.substring(k + 1);
					if (fphmzm.equals("MS")) { // 过滤虚拟发票
						continue;
					}
					fphm = fphmzm + String.format("%0" + fphmsz.length() + "d", Long.parseLong(fphmsz + "") + j);
					Map<String, Object> fphm_map = new HashMap<String, Object>();
					fphm_map.put("FPHM", fphm);
//						fphm_map.put("Lb", Lb);
					fphm_map.put("LB", Lb);
					addlist_fpxx.add(fphm_map);
				}
			}
		}
		list_fpxx.addAll(addlist_fpxx);
//			List<Map<String, Object>> list_fpxx_num = gethmNUm(list_fpxx);

		List<Map<String, Object>> list_zffpxx = opMzxxDao.doQueryFpzfxx(parameters);
//		List<Map<String, Object>> list_jczffpxx = opMzxxDao.doQueryJczffpxx(parameters);
		// TODO
//		List<Map<String, Object>> list_jjhjfpxx = opMzxxDao.doQueryJjhjfpxx(parameters);
//			List<Map<String, Object>> addlist_zffpxx = new ArrayList<Map<String,Object>>();
//			for(int i = 0 ; i < list_zffpxx.size(); i ++){
//				Map<String, Object> map_zffpxx = list_zffpxx.get(i);
//				if(Long.parseLong(map_zffpxx.get("FPZS")+"")>1){
//					for(int j = 1 ; j < Long.parseLong(map_zffpxx.get("FPZS")+"") ; j ++){
//						String fphm = map_zffpxx.get("FPHM")+"";
//						int k = -1 ;
//						for(int q = fphm.length()-1 ; q >= 0 ; q --){
//							if(fphm.charAt(q)<'0'||fphm.charAt(q)>'9'){
//								k = q;
//								break;
//							}
//						}
//						String fphmzm = fphm.substring(0, k+1);
//						String fphmsz = fphm.substring(k+1);
//						fphm = fphmzm+String.format("%0" + fphmsz.length() + "d", Long.parseLong(fphmsz+"")+j);
//						Map<String, Object> fphm_map = new HashMap<String, Object>();
//						fphm_map.put("FPHM", fphm);
//						addlist_zffpxx.add(fphm_map);
//					}
//				}
//			}
//			list_zffpxx.addAll(addlist_zffpxx);
//			List<Map<String, Object>> list_zffpxx_num = gethmNUm(list_zffpxx);
//			String fphmzfstr = gethmStr(list_zffpxx);
		if ("LB".equals(SQXTMS)) {
			if (list_fpxx != null && list_fpxx.size() > 0) {
				Collections.sort(list_fpxx, new Comparator<Map<String, Object>>() {
					@Override
					public int compare(Map<String, Object> map1, Map<String, Object> map2) {
						int LB1 = ObjectToTypes.toInt(map1.get("LB"));
						int LB2 = ObjectToTypes.toInt(map2.get("LB"));
						int n = LB1 - LB2;
						if (n == 0) {
							String fphm1 = (String) map1.get("FPHM");
							String fphm2 = (String) map2.get("FPHM");
							n = fphm1.compareTo(fphm2);
						}
						return n;
					}
				});

				List list_fpxx0 = new ArrayList(); // 收费
				List list_fpxx1 = new ArrayList(); // 作废
				List list_fpxx2 = new ArrayList(); // 退号
				List list_fpxx3 = new ArrayList(); // 转科
				for (int i = 0; i < list_fpxx.size(); i++) {
					Map map = list_fpxx.get(i);
					int lb = ObjectToTypes.toInt(map.get("LB"));
					if (lb == 0) {
						list_fpxx0.add(map);
					} else if (lb == 1) {
						list_fpxx1.add(map);
					} else if (lb == 2) {
						list_fpxx2.add(map);
					} else if (lb == 3) {
						list_fpxx3.add(map);
					}
				}

				String fphmstr0 = gethmStr(list_fpxx0);
				String fpxx0 = divisionFpxx(list_fpxx0, fphmstr0);

				String fphmstr1 = gethmStr(list_fpxx1);
				String fpxx1 = divisionFpxx(list_fpxx1, fphmstr1);

				String fphmstr2 = gethmStr(list_fpxx2);
				String fpxx2 = divisionFpxx(list_fpxx2, fphmstr2);

				String fphmstr3 = gethmStr(list_fpxx3);
				String fpxx3 = divisionFpxx(list_fpxx3, fphmstr3);

				fpxx += !"".equals(fpxx0) ? "收费:" + fpxx0 : "";
				fpxx += !"".equals(fpxx1) ? " 作废:" + fpxx1 : "";
				fpxx += !"".equals(fpxx2) ? " 退号:" + fpxx2 : "";
				fpxx += !"".equals(fpxx3) ? " 转科:" + fpxx3 : "";

			}
		} else {
			if (list_fpxx != null && list_fpxx.size() > 0) {
				try {
					Collections.sort(list_fpxx, new Comparator<Map<String, Object>>() {

						@Override
						public int compare(Map<String, Object> map1, Map<String, Object> map2) {
							String fphm1 = (String) map1.get("FPHM");
							String fphm2 = (String) map2.get("FPHM");
							return fphm1.compareTo(fphm2);
						}
					});
				} catch (RuntimeException e) {
					e.printStackTrace();
				}

				String fphmstr = gethmStr(list_fpxx);
				fpxx =

						divisionFpxx(list_fpxx, fphmstr);
			}
		}

		if (list_zffpxx != null && list_zffpxx.size() > 0) {
			zffpxx.append("退费:");
			for (

					int i = 0; i < list_zffpxx.size(); i++) {
				Map<String, Object> thfp_map = list_zffpxx.get(i);
				zffpxx.append(thfp_map.get("FPHM") + "(" + thfp_map.get("BRXM") + "," + thfp_map.get("FKMC") + ":"
						+ thfp_map.get("FKJE") + ") ");
			}
		}
//		if (list_jczffpxx != null && list_jczffpxx.size() > 0) {
//			zffpxx.append("家床:");
//			for (int i = 0; i < list_jczffpxx.size(); i++) {
//				Map<String, Object> thfp_map = list_jczffpxx.get(i);
//				zffpxx.append(thfp_map.get("FPHM") + "(" + thfp_map.get("BRXM") + "," + thfp_map.get("FKMC") + ":"
//						+ thfp_map.get("FKJE") + ") ");
//			}
//		}
		// TODO
//		if (list_jjhjfpxx != null && list_jjhjfpxx.size() > 0) {
//			zffpxx.append("居家护理:");
//			for (int i = 0; i < list_jjhjfpxx.size(); i++) {
//				Map<String, Object> thfp_map = list_jjhjfpxx.get(i);
//				zffpxx.append(thfp_map.get("FPHM") + "(" + thfp_map.get("BRXM") + "," + thfp_map.get("FKMC") + ":"
//						+ thfp_map.get("FKJE") + ") ");
//			}
//		}

		if (map_mzxx_all != null && map_mzxx_all.size() > 0) {
//				response.put("total", String.format("%1$.2f", sfhj));
			response.put("amount", fkxx);
//				response.put("otherAmount", String.format("%1$.2f", qtys));
//				response.put("jjzfje", String.format("%1$.2f", jjzfje));
			response.put("numPage", fpzs + "");
			response.put("invalidAmount", zfxx);
			response.put("FPHM", fpxx);
			response.put("invalid", zffpxx.toString());
			map_mzxx_all.put("QZPJ", fpxx);
			map_mzxx_all.put("ZFFP", zffpxx.toString());
			map_mzxx_all.put("ZFJE", zfje);
		}

		List<Map<String, Object>> map_ghmxlist = opMzxxDao.doQueryGhmx(parameters);
		Map<String, Object> map_ghmx = new HashMap<String, Object>();
		if (map_ghmxlist.size() > 0) {
			map_ghmx = map_ghmxlist.get(0);
		}
//			double ghsyb = ObjectToTypes.parseDouble(map_ghmx.get("SYB"));
//			double ghsjyb = ObjectToTypes.parseDouble(map_ghmx.get("SJYB"));
		if (map_ghmx != null && map_ghmx.size() > 0) {
			map_ghrb_all.put("CZGH", map_ghmx.get("CZGH"));
			map_ghrb_all.put("MZLB", mzlb);
			map_ghrb_all.put("ZJJE", ObjectToTypes.parseDouble(map_ghmx.get("ZJJE")));
//				ghsyb = ObjectToTypes.parseDouble(map_ghmx.get("SYB"));
//				map_ghrb_all.put("SYB", ObjectToTypes.parseDouble(map_ghmx.get("SYB")));
//				ghsjyb = ObjectToTypes.parseDouble(map_ghmx.get("SJYB"));
//				map_ghrb_all.put("SJYB", ObjectToTypes.parseDouble(map_ghmx.get("SJYB")));
			map_ghrb_all.put("XJJE", ObjectToTypes.parseDouble(map_ghmx.get("XJJE")));
			map_ghrb_all.put("ZPJE", ObjectToTypes.parseDouble(map_ghmx.get("ZPJE")));
			map_ghrb_all.put("QTYS", ObjectToTypes.parseDouble(map_ghmx.get("QTYS")));
			map_ghrb_all.put("HBWC", ObjectToTypes.parseDouble(map_ghmx.get("HBWC")));
			map_ghrb_all.put("FPZS", ObjectToTypes.parseInt(map_ghmx.get("FPZS")));
			map_ghrb_all.put("THJE", 0.0);
			map_ghrb_all.put("THSL", 0);
			map_ghrb_all.put("JGID", jgid);
		}

		List<Map<String, Object>> map_ghthmxlist = opMzxxDao.doQueryGhthmx(parameters);
		Map<String, Object> map_ghthmx = new HashMap<String, Object>();
		if (map_ghthmxlist.size() > 0) {
			map_ghthmx = map_ghthmxlist.get(0);
		}
//			double ghsybth = ObjectToTypes.parseDouble(map_ghthmx.get("SYB"));
//			double ghsjybth = ObjectToTypes.parseDouble(map_ghthmx.get("SJYB"));
		if (map_ghthmx != null && map_ghthmx.size() > 0) {
			if (map_ghrb_all.size() > 0) {
				map_ghrb_all.put("ZJJE", ObjectToTypes.parseDouble(map_ghrb_all.get("ZJJE"))
						- ObjectToTypes.parseDouble(map_ghthmx.get("ZJJE")));
				map_ghrb_all.put("XJJE", ObjectToTypes.parseDouble(map_ghrb_all.get("XJJE"))
						- ObjectToTypes.parseDouble(map_ghthmx.get("XJJE")));
				map_ghrb_all.put("ZPJE", ObjectToTypes.parseDouble(map_ghrb_all.get("ZPJE"))
						- ObjectToTypes.parseDouble(map_ghthmx.get("ZPJE")));
				map_ghrb_all.put("QTYS", ObjectToTypes.parseDouble(map_ghrb_all.get("QTYS"))
						- ObjectToTypes.parseDouble(map_ghthmx.get("QTYS")));
				map_ghrb_all.put("HBWC", ObjectToTypes.parseDouble(map_ghrb_all.get("HBWC"))
						- ObjectToTypes.parseDouble(map_ghthmx.get("HBWC")));
//					ghsybth = ObjectToTypes.parseDouble(map_ghthmx.get("SYB"));
//					map_ghrb_all.put("SYB",
//							ObjectToTypes.parseDouble(map_ghrb_all.get("SYB"))
//									- ObjectToTypes.parseDouble(map_ghthmx.get("SYB")));
//					ghsjybth = ObjectToTypes.parseDouble(map_ghthmx.get("SJYB"));
//					map_ghrb_all.put("SZYB",
//							ObjectToTypes.parseDouble(map_ghrb_all.get("SJYB"))
//									- ObjectToTypes.parseDouble(map_ghthmx.get("SJYB")));
				map_ghrb_all.put("THJE", ObjectToTypes.parseDouble(map_ghrb_all.get("THJE"))
						+ ObjectToTypes.parseDouble(map_ghthmx.get("ZJJE")));
				map_ghrb_all.put("THSL", ObjectToTypes.parseInt(map_ghrb_all.get("THSL"))
						+ ObjectToTypes.parseInt(map_ghthmx.get("THSL")));
			} else {
				map_ghrb_all.put("CZGH", map_ghthmx.get("CZGH"));
				map_ghrb_all.put("MZLB", mzlb);
//					ghsybth = ObjectToTypes.parseDouble(map_ghthmx.get("SYB"));
//					ghsjybth = ObjectToTypes.parseDouble(map_ghthmx.get("SJYB"));
//					map_ghrb_all
//							.put("SYB", -ObjectToTypes.parseDouble(map_ghthmx.get("SYB")));
//					map_ghrb_all.put("SZYB",
//							-ObjectToTypes.parseDouble(map_ghthmx.get("SJYB")));
				map_ghrb_all.put("ZJJE", -ObjectToTypes.parseDouble(map_ghthmx.get("ZJJE")));
				map_ghrb_all.put("XJJE", -ObjectToTypes.parseDouble(map_ghthmx.get("XJJE")));
				map_ghrb_all.put("ZPJE", -ObjectToTypes.parseDouble(map_ghthmx.get("ZPJE")));
				map_ghrb_all.put("QTYS", -ObjectToTypes.parseDouble(map_ghthmx.get("QTYS")));
				map_ghrb_all.put("HBWC", -ObjectToTypes.parseDouble(map_ghthmx.get("HBWC")));
				map_ghrb_all.put("THJE", ObjectToTypes.parseDouble(map_ghthmx.get("ZJJE")));
				map_ghrb_all.put("THSL", ObjectToTypes.parseInt(map_ghthmx.get("THSL")));
				map_ghrb_all.put("JGID", jgid);
				map_ghrb_all.put("FPZS", 0);
			}
			thje = ObjectToTypes.parseDouble(map_ghthmx.get("ZJJE"));
			thsl = ObjectToTypes.parseInt(map_ghthmx.get("THSL"));
			thxx = "张数：" + thsl + " 退号金额：" + String.format("%1$.2f", thje);
		}
		if (map_ghrb_all.size() > 0) {
			map_ghrb_all.put("JZRQ", nowdate);
//				qtys = qtys + ObjectToTypes.parseDouble(map_ghrb_all.get("QTYS"));
//				response.put("otherAmount", String.format("%1$.2f", qtys));
		}

		List<Map<String, Object>> list_grmx = opMzxxDao.doQueryGrmx(parameters);
		List<Map<String, Object>> list_grthmx = opMzxxDao.doQueryGrthmx(parameters);

		if (list_grmx != null && list_grmx.size() != 0) {
			for (int i = 0; i < list_grmx.size(); i++) {
				Map<String, Object> map_grmx = list_grmx.get(i);
				Map<String, Object> map_grmx_all = new HashMap<String, Object>();
				map_grmx_all.put("BRXZ", map_grmx.get("BRXZ"));
				map_grmx_all.put("CZGH", uid);
				map_grmx_all.put("FPZS", ObjectToTypes.parseInt(map_grmx.get("GHRC")));
				map_grmx_all.put("SFJE", ObjectToTypes.parseDouble(map_grmx.get("ZJJE")));
				map_grmx_all.put("GHJE", ObjectToTypes.parseDouble(map_grmx.get("GHJE")));
				map_grmx_all.put("ZLJE", ObjectToTypes.parseDouble(map_grmx.get("ZLJE")));
				map_grmx_all.put("ZJFY", ObjectToTypes.parseDouble(map_grmx.get("ZJFY")));
				map_grmx_all.put("BLJE", ObjectToTypes.parseDouble(map_grmx.get("BLJE")));
				map_grmx_all.put("JGID", jgid);
				map_grmx_all.put("JZRQ", nowdate);
				map_grmx_all.put("XM", map_grmx.get("XM") + "");
				if (list_grthmx != null && list_grthmx.size() != 0) {
					for (int J = 0; J < list_grthmx.size(); J++) {
						Map<String, Object> map_grthmx = list_grthmx.get(J);
						if (map_grthmx.containsKey("BRXZ")) {
							if (Long.parseLong(map_grmx.get("BRXZ") + "") == Long
									.parseLong(map_grthmx.get("BRXZ") + "")) {
								map_grmx_all.put("SFJE", ObjectToTypes.parseDouble(map_grmx_all.get("SFJE"))
										- ObjectToTypes.parseDouble(map_grthmx.get("ZJJE")));
								map_grmx_all.put("GHJE", ObjectToTypes.parseDouble(map_grmx_all.get("GHJE"))
										- ObjectToTypes.parseDouble(map_grthmx.get("GHJE")));
								map_grmx_all.put("ZLJE", ObjectToTypes.parseDouble(map_grmx_all.get("ZLJE"))
										- ObjectToTypes.parseDouble(map_grthmx.get("ZLJE")));
								map_grmx_all.put("ZJFY", (Double) map_grmx_all.get("ZJFY")
										- ObjectToTypes.parseDouble(map_grthmx.get("ZJFY")));
								map_grmx_all.put("BLJE", ObjectToTypes.parseDouble(map_grmx_all.get("BLJE"))
										- ObjectToTypes.parseDouble(map_grthmx.get("BLJE")));
								list_grthmx.remove(J);
								J--;
							}
						}
					}
				}
				list_ghrbmx.add(map_grmx_all);
			}

			if (list_grthmx != null && list_grthmx.size() != 0) {
				for (int J = 0; J < list_grthmx.size(); J++) {
					Map<String, Object> map_grthmx = list_grthmx.get(J);
					if (map_grthmx.containsKey("BRXZ")) {
						Map<String, Object> map_grmx_all = new HashMap<String, Object>();
						map_grmx_all.put("CZGH", uid);
						map_grmx_all.put("JGID", jgid);
						map_grmx_all.put("JZRQ", nowdate);
						map_grmx_all.put("FPZS", ObjectToTypes.parseInt(map_grthmx.get("GHRC")));
						map_grmx_all.put("SFJE", -ObjectToTypes.parseDouble(map_grthmx.get("ZJJE") + ""));
						map_grmx_all.put("GHJE", -ObjectToTypes.parseDouble(map_grthmx.get("GHJE") + ""));
						map_grmx_all.put("ZLJE", -ObjectToTypes.parseDouble(map_grthmx.get("ZLJE") + ""));
						map_grmx_all.put("ZJFY", -ObjectToTypes.parseDouble(map_grthmx.get("ZJFY") + ""));
						map_grmx_all.put("BLJE", -ObjectToTypes.parseDouble(map_grthmx.get("BLJE") + ""));
						map_grmx_all.put("BRXZ", map_grthmx.get("BRXZ"));
						map_grmx_all.put("XM", map_grthmx.get("XM") + "");
						list_grthmx.remove(J);
						list_ghrbmx.add(map_grmx_all);
						J--;
					}
				}
			}

		} else {
			if (list_grthmx != null && list_grthmx.size() != 0) {
				for (int k = 0; k < list_grthmx.size(); k++) {
					Map<String, Object> map_grthmx = list_grthmx.get(k);
					Map<String, Object> map_grmx_all = new HashMap<String, Object>();
					map_grmx_all.put("BRXZ", map_grthmx.get("BRXZ"));
					map_grmx_all.put("CZGH", uid);
					map_grmx_all.put("FPZS", -ObjectToTypes.parseInt(map_grthmx.get("GHRC")));
					map_grmx_all.put("SFJE", -ObjectToTypes.parseDouble(map_grthmx.get("ZJJE") + ""));
					map_grmx_all.put("GHJE", -ObjectToTypes.parseDouble(map_grthmx.get("GHJE") + ""));
					map_grmx_all.put("ZLJE", -ObjectToTypes.parseDouble(map_grthmx.get("ZLJE") + ""));
					map_grmx_all.put("ZJFY", -ObjectToTypes.parseDouble(map_grthmx.get("ZJFY") + ""));
					map_grmx_all.put("BLJE", -ObjectToTypes.parseDouble(map_grthmx.get("BLJE") + ""));
					map_grmx_all.put("JGID", jgid);
					map_grmx_all.put("JZRQ", nowdate);
					map_grmx_all.put("XM", map_grthmx.get("XM") + "");
					list_ghrbmx.add(map_grmx_all);
				}
			}
		}
		if (list_ghrbmx.size() > 0) {
			for (Map<String, Object> map_rbmx : list_ghrbmx) {
				ghhj = ghhj + ObjectToTypes.parseDouble(map_rbmx.get("SFJE") + "");
				ghje = ghje + ObjectToTypes.parseDouble(map_rbmx.get("GHJE") + "");
				zlje = zlje + ObjectToTypes.parseDouble(map_rbmx.get("ZLJE") + "");
				blje = blje + ObjectToTypes.parseDouble(map_rbmx.get("BLJE") + "");
				zjfy = zjfy + ObjectToTypes.parseDouble(map_rbmx.get("ZJFY") + "");
			}
		}

		List<Map<String, Object>> list_ghfkmx = opMzxxDao.doQueryGhfkxx(parameters);
		List<Map<String, Object>> list_ghfkmx_zf = opMzxxDao.doQueryGhfkzfxx(parameters);

		if (list_ghfkmx != null && list_ghfkmx.size() != 0) {
			for (int i = 0; i < list_ghfkmx.size(); i++) {
				Map<String, Object> map_fkxx = list_ghfkmx.get(i);
				Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
				map_fkxx_all.put("FKFS", map_fkxx.get("FKFS"));
				map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx.get("FKJE")));
				map_fkxx_all.put("CZGH", uid);
				map_fkxx_all.put("JGID", jgid);
				map_fkxx_all.put("JZRQ", nowdate);
				if (list_ghfkmx_zf != null && list_ghfkmx_zf.size() != 0) {
					for (int J = 0; J < list_ghfkmx_zf.size(); J++) {
						Map<String, Object> map_fkxx_zf = list_ghfkmx_zf.get(J);
						if (map_fkxx_zf.containsKey("FKFS")) {
							if (Long.parseLong(map_fkxx.get("FKFS") + "") == Long
									.parseLong(map_fkxx_zf.get("FKFS") + "")) {
								map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx_all.get("FKJE") + "")
										- ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE") + ""));
								list_ghfkmx_zf.remove(J);
								J--;
							}
						}
					}
				}
				list_ghrb_fkmx.add(map_fkxx_all);
			}

			if (list_ghfkmx_zf != null && list_ghfkmx_zf.size() != 0) {
				for (int J = 0; J < list_ghfkmx_zf.size(); J++) {
					Map<String, Object> map_fkxx_zf = list_ghfkmx_zf.get(J);
					if (map_fkxx_zf.containsKey("FKFS")) {
						Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
						map_fkxx_all.put("FKFS", map_fkxx_zf.get("FKFS"));
						map_fkxx_all.put("FKJE", -ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE") + ""));
						map_fkxx_all.put("CZGH", uid);
						map_fkxx_all.put("JGID", jgid);
						map_fkxx_all.put("JZRQ", nowdate);
						list_ghrb_fkmx.add(map_fkxx_all);
						list_ghfkmx_zf.remove(J);
						J--;
					}
				}
			}

		} else {
			if (list_ghfkmx_zf != null && list_ghfkmx_zf.size() != 0) {
				for (int k = 0; k < list_ghfkmx_zf.size(); k++) {
					Map<String, Object> map_fkxx_zf = list_ghfkmx_zf.get(k);
					Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
					map_fkxx_all.put("FKFS", map_fkxx_zf.get("FKFS"));
					map_fkxx_all.put("CZGH", uid);
					map_fkxx_all.put("FKJE", -ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE") + ""));
					map_fkxx_all.put("JGID", jgid);
					map_fkxx_all.put("JZRQ", DateUtil.date().toTimestamp());
					list_ghrb_fkmx.add(map_fkxx_all);
				}
			}
		}

		// if (map_ghrb_all != null && map_ghrb_all.size() > 0) {
//				response.put("GHF", ghje + "");
//				response.put("ZLF", zlje + "");
//				response.put("BLF", blje + "");
//				response.put("ZJF", zjfy + "");

		// response.put("GHHJ", String.format("%1$.2f", ghhj));
		response.put("GHHJ", String.format("%1$.2f", ghhj - ObjectToTypes.parseDouble(map_ghrb_all.get("HBWC"))));// 挂号合计
		// 减去
		// 货币误差
		// }
		Map<String, Object> jcparameters = new HashMap<String, Object>();
		jcparameters.put("CZGH", uid);
		jcparameters.put("JGID", jgid);
		jcparameters.put("MZLB", mzlb);
//		List<Map<String, Object>> jcxm_list = opMzxxDao.doQueryJcxm(jcparameters);

//		double jchj = 0.0;
//		for (int i = 0; i < jcxm_list.size(); i++) {
//			jchj = jchj + ObjectToTypes.parseDouble(jcxm_list.get(i).get("ZJJE"));
//		}
		Map<String, Object> yjkparameters = new HashMap<String, Object>();
		yjkparameters.put("CZGH", uid);
		yjkparameters.put("JGID", jgid);
		yjkparameters.put("MZLB", mzlb);
//		Map<String, Object> yjk_map = opMzxxDao.doQueryYjk(yjkparameters);
//		Map<String, Object> jkzf_map = opMzxxDao.doQueryYjkzf(yjkparameters);
		response.put("HJHJ", String.format("%.2f", sfhj - ObjectToTypes.parseDouble(map_mzxx_all.get("JMJE"))
				- ObjectToTypes.parseDouble(map_mzxx_all.get("HBWC"))));// String.format("%.2f",
		// f)
//			response.put("HJHJ", String.format("%.2f", sfhj+ObjectToTypes.parseDouble(map_mzxx_all.get("HBWC")) - ObjectToTypes.parseDouble(map_mzxx_all.get("JMJE"))-ObjectToTypes.parseDouble(map_mzxx_all.get("HBWC"))));//String.format("%.2f", f)
//		response.put("JCHJ", String.format("%.2f", jchj));
//		response.put("SYJJ", String.format("%1$.2f", yjk_map.get("JKJE")));
//		response.put("TYJJ", String.format("%1$.2f", jkzf_map.get("JKJE")));

		double jjhj = 0.00; // 居家合计 //doGetParameters
//			String jjhjsql = " select sum(a.JKHJ) as JKHJ from  LNHL_JS a where a.JGID=:JGID and a.JSRQ <= :jsrq and JZRQ IS NULL and a.CZGH=:CZGH and a.ZFPB <> 1  ";
		Map<String, Object> params = new HashMap<String, Object>();
//			Date jsrq =BSPHISUtil.toDate(StrUtil.null2Str(request.get("endDate")));
//			if(jsrq!=null){
//				params.put("jsrq",jsrq);
//			}else{
//				params.put("jsrq","");
//			}		
		params.put("CZGH", uid);
		params.put("JGID", jgid);
		params.put("mzlb", mzlb);
//		Map<String, Object> hl_map = opMzxxDao.doQueryJkhj(params);
//		jjhj = ObjectToTypes.parseDouble(hl_map.get("JKHJ"));
//		response.put("JJHJ", String.format("%.2f", jjhj));

		// double dxje = sfhj + ghhj + jchj + jjhj +
		// ObjectToTypes.parseDouble(yjk_map.get("JKJE")) -
		// ObjectToTypes.parseDouble(jkzf_map.get("JKJE")) -
		// ObjectToTypes.parseDouble(map_mzxx_all.get("JMJE"))-
		// ObjectToTypes.parseDouble(map_mzxx_all.get("HBWC"));
		double dxje = sfhj + ghhj - ObjectToTypes.parseDouble(map_mzxx_all.get("JMJE"))
				- ObjectToTypes.parseDouble(map_mzxx_all.get("HBWC"))
				- ObjectToTypes.parseDouble(map_ghrb_all.get("HBWC"));
		String dxjeBig = String.format("%1$.2f", new BigDecimal(ObjectToTypes.null2Str(dxje)));
		if (dxje < 0) {
			response.put("amountIn",
					"负" + MzUtil.changeMoneyUpper(String.format("%1$.2f", -(dxje))) + "(" + (dxjeBig) + ")");
		} else {
			response.put("amountIn", MzUtil.changeMoneyUpper(String.format("%1$.2f", dxje)) + "(" + dxjeBig + ")");
		}

//			hql_jzhm.append("select JZHM as PJHM from OP_GHMX where JGID = :jgid  and MZLB = :mzlb and CZGH = :czgh and JZRQ is null and JZHM not like 'MGH%'");

//			List<Map<String, Object>> list_jzhm = dao.doQuery(
//					hql_jzhm.toString(), parameters);
		List<Map<String, Object>> list_jzhm_zf = opMzxxDao.doQueryJzhmzf(parameters);
//			String beginjzhm = "";
//			String endjzhm = "";
//			long currentjzhm = 0;
//			if (list_jzhm != null && list_jzhm.size() > 0) {
//				try {
//					Collections.sort(list_jzhm,
//							new Comparator<Map<String, Object>>() {
//								@Override
//								public int compare(Map<String, Object> map1,
//										Map<String, Object> map2) {
//									String jzhm1 = (String) map1.get("PJHM");
//									String jzhm2 = (String) map2.get("PJHM");
//									return jzhm1.compareTo(jzhm2);
//								}
//							});
//				} catch (RuntimeException e) {
//					e.printStackTrace();
//				}
//				for (int i = 0; i < list_jzhm.size(); i++) {
//					Map<String, Object> map_jzxx = list_jzhm.get(i);
//					if (i == 0) {
//						beginjzhm = map_jzxx.get("PJHM").toString();
//						currentjzhm = Long.parseLong(map_jzxx.get("PJHM")
//								.toString());
//					}
//					if (Long.parseLong(map_jzxx.get("PJHM").toString()) != currentjzhm) {
//						endjzhm = list_jzhm.get(i - 1).get("PJHM").toString();
//						jzhmxx = InvoiceSequence(jzhmxx, beginjzhm, endjzhm);
//						beginjzhm = map_jzxx.get("PJHM").toString();
//						currentjzhm = Long.parseLong(map_jzxx.get("PJHM")
//								.toString());
//					}
//					currentjzhm++;
//				}
//				endjzhm = list_jzhm.get(list_jzhm.size() - 1).get("PJHM")
//						.toString();
//				jzhmxx = InvoiceSequence(jzhmxx, beginjzhm, endjzhm);
//			}

		if (list_jzhm_zf != null && list_jzhm_zf.size() > 0) {
//				try {
//					Collections.sort(list_jzhm_zf,
//							new Comparator<Map<String, Object>>() {
//								@Override
//								public int compare(Map<String, Object> map1,
//										Map<String, Object> map2) {
//									String jzhm1 = (String) map1.get("PJHM");
//									String jzhm2 = (String) map2.get("PJHM");
//									return jzhm1.compareTo(jzhm2);
//								}
//							});
//				} catch (RuntimeException e) {
//					e.printStackTrace();
//				}
//				for (int i = 0; i < list_jzhm_zf.size(); i++) {
//					Map<String, Object> map_jzxx_zf = list_jzhm_zf.get(i);
//					if (i == 0) {
//						beginjzhm = map_jzxx_zf.get("PJHM").toString();
//						currentjzhm = Long.parseLong(map_jzxx_zf.get("PJHM")
//								.toString());
//					}
//					if (Long.parseLong(map_jzxx_zf.get("PJHM").toString()) != currentjzhm) {
//						endjzhm = list_jzhm_zf.get(i - 1).get("PJHM")
//								.toString();
//						thjzhmxx = InvoiceSequence(thjzhmxx, beginjzhm, endjzhm);
//						beginjzhm = map_jzxx_zf.get("PJHM").toString();
//						currentjzhm = Long.parseLong(map_jzxx_zf.get("PJHM")
//								.toString());
//					}
//					currentjzhm++;
//				}
//				endjzhm = list_jzhm_zf.get(list_jzhm_zf.size() - 1).get("PJHM")
//						.toString();
//				thjzhmxx = InvoiceSequence(thjzhmxx, beginjzhm, endjzhm);
			thjzhmxx.append("退号:");
			for (int i = 0; i < list_jzhm_zf.size(); i++) {
				Map<String, Object> thfp_map = list_jzhm_zf.get(i);
				thjzhmxx.append(thfp_map.get("PJHM") + "(" + thfp_map.get("BRXM") + "," + thfp_map.get("FKMC") + ":"
						+ thfp_map.get("FKJE") + ") ");
			}
		}
		if (map_ghrb_all != null && map_ghrb_all.size() > 0) {
//				response.put("JZHM", jzhmxx);
			response.put("invalidgh", thjzhmxx.toString());
			response.put("invalidghAmount", thxx);
//				map_ghrb_all.put("QZPJ", jzhmxx);
			map_ghrb_all.put("THFP", thjzhmxx.toString());
		}

		if ((map_ghrb_all != null && map_ghrb_all.size() > 0) || (map_mzxx_all != null && map_mzxx_all.size() > 0)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Map<String, Object> jzrq = new HashMap<String, Object>();
			jzrq.put("JGID", jgid);
			jzrq.put("CZGH", uid);
			// 查询上次结账时间
			Map<String, Object> jzrqmapsf = opMzxxDao.doQuerySfrbJzrq(jzrq);
			Map<String, Object> jzrqmapgh = opMzxxDao.doQueryGhrbJzrq(jzrq);
			if ((jzrqmapsf != null && jzrqmapgh != null) && jzrqmapsf.get("JZRQ") != null
					&& jzrqmapgh.get("JZRQ") != null) {
				DateTime jzrqmapsfDate = DateUtil.parse(jzrqmapsf.get("JZRQ") + "", "yyyy-MM-dd HH:mm:ss");
				DateTime jzrqmapghDate = DateUtil.parse(jzrqmapgh.get("JZRQ") + "", "yyyy-MM-dd HH:mm:ss");
				java.util.Date jzrqsf = DateUtil.date(jzrqmapsfDate);
				java.util.Date jzrqgh = DateUtil.date(jzrqmapghDate);
				if (jzrqsf.getTime() > jzrqgh.getTime()) {
					response.put("KSRQ", MzUtil.toString(jzrqsf, "yyyy-MM-dd HH:mm:ss"));
				} else {
					response.put("KSRQ", MzUtil.toString(jzrqgh, "yyyy-MM-dd HH:mm:ss"));
				}
			} else if (jzrqmapsf != null && jzrqmapsf.get("JZRQ") != null) {
				DateTime jzrqmapsfDate = DateUtil.parse(jzrqmapsf.get("JZRQ") + "", "yyyy-MM-dd HH:mm:ss");
				java.util.Date jzrqsf = DateUtil.date(jzrqmapsfDate);
				response.put("KSRQ", MzUtil.toString(jzrqsf, "yyyy-MM-dd HH:mm:ss"));
			} else if (jzrqmapgh != null && jzrqmapgh.get("JZRQ") != null) {
				DateTime jzrqmapghDate = DateUtil.parse(jzrqmapgh.get("JZRQ") + "", "yyyy-MM-dd HH:mm:ss");
				java.util.Date jzrqgh = DateUtil.date(jzrqmapghDate);
				response.put("KSRQ", MzUtil.toString(jzrqgh, "yyyy-MM-dd HH:mm:ss"));
			} else {
				Map<String, Object> sfrqorghrq = new HashMap<String, Object>();
				sfrqorghrq.put("JGID", jgid);
				sfrqorghrq.put("CZGH", uid);
				// 查询上次结账时间
				Map<String, Object> sfrqmap = opMzxxDao.doQueryMinSfrq(sfrqorghrq);
				Map<String, Object> ghrqmap = opMzxxDao.doQueryMinGhsj(sfrqorghrq);
				if ((sfrqmap != null && ghrqmap != null) && sfrqmap.get("SFRQ") != null
						&& ghrqmap.get("GHSJ") != null) {
					DateTime sfrqDate = DateUtil.parse(sfrqmap.get("SFRQ") + "", "yyyy-MM-dd HH:mm:ss");
					DateTime ghsjDate = DateUtil.parse(ghrqmap.get("GHSJ") + "", "yyyy-MM-dd HH:mm:ss");
					java.util.Date sfrq = DateUtil.date(sfrqDate);
					java.util.Date ghsj = DateUtil.date(ghsjDate);
					if (sfrq.getTime() < ghsj.getTime()) {
						response.put("KSRQ", MzUtil.toString(sfrq, "yyyy-MM-dd HH:mm:ss"));
					} else {
						response.put("KSRQ", MzUtil.toString(ghsj, "yyyy-MM-dd HH:mm:ss"));
					}
				} else if (sfrqmap != null && sfrqmap.get("SFRQ") != null) {
					DateTime sfrqDate = DateUtil.parse(sfrqmap.get("SFRQ") + "", "yyyy-MM-dd HH:mm:ss");
					java.util.Date sfrq = DateUtil.date(sfrqDate);
					response.put("KSRQ", MzUtil.toString(sfrq, "yyyy-MM-dd HH:mm:ss"));
				} else if (ghrqmap != null && ghrqmap.get("GHSJ") != null) {
					DateTime ghsjDate = DateUtil.parse(ghrqmap.get("GHSJ") + "", "yyyy-MM-dd HH:mm:ss");
					java.util.Date ghsj = DateUtil.date(ghsjDate);
					response.put("KSRQ", MzUtil.toString(ghsj, "yyyy-MM-dd HH:mm:ss"));
				}

			}
			response.put("toll", userName);
			response.put("SFRQ", MzUtil.toString(new java.util.Date(), "yyyy-MM-dd HH:mm:ss"));
			response.put("Lister", userName);
			response.put("dateTabling", DateUtil.date().toSqlDate());
		}
		List<Map<String, Object>> list_sfrb_fkmx_copy = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list_ghrb_fkmx_copy = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list_fkmx_all = new ArrayList<Map<String, Object>>();

		list_sfrb_fkmx_copy.addAll(list_sfrb_fkmx);
		list_ghrb_fkmx_copy.addAll(list_ghrb_fkmx);
		if (list_sfrb_fkmx_copy != null && list_sfrb_fkmx_copy.size() != 0) {
			for (int i = 0; i < list_sfrb_fkmx_copy.size(); i++) {
				Map<String, Object> map_fkxx = list_sfrb_fkmx_copy.get(i);
				Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
				map_fkxx_all.put("FKFS", map_fkxx.get("FKFS"));
				map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx.get("FKJE")));
				if (list_ghrb_fkmx_copy != null && list_ghrb_fkmx_copy.size() != 0) {
					for (int J = 0; J < list_ghrb_fkmx_copy.size(); J++) {
						Map<String, Object> map_fkxx_zf = list_ghrb_fkmx_copy.get(J);
						if (map_fkxx_zf.containsKey("FKFS")) {
							if (Long.parseLong(map_fkxx.get("FKFS") + "") == Long
									.parseLong(map_fkxx_zf.get("FKFS") + "")) {
								map_fkxx_all.put("FKJE", ObjectToTypes
										.parseDouble((ObjectToTypes.parseDouble(map_fkxx_all.get("FKJE") + "")
												+ ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE") + "")) + ""));
								list_ghrb_fkmx_copy.remove(J);
								J--;
							}
						}
					}
				}
				list_fkmx_all.add(map_fkxx_all);
			}

			if (list_ghrb_fkmx_copy != null && list_ghrb_fkmx_copy.size() != 0) {
				for (int J = 0; J < list_ghrb_fkmx_copy.size(); J++) {
					Map<String, Object> map_fkxx_zf = list_ghrb_fkmx_copy.get(J);
					if (map_fkxx_zf.containsKey("FKFS")) {
						Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
						map_fkxx_all.put("FKFS", map_fkxx_zf.get("FKFS"));
						map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE") + ""));
						list_fkmx_all.add(map_fkxx_all);
						list_ghrb_fkmx_copy.remove(J);
						J--;
					}
				}
			}

		} else {
			if (list_ghrb_fkmx_copy != null && list_ghrb_fkmx_copy.size() != 0) {
				for (int k = 0; k < list_ghrb_fkmx_copy.size(); k++) {
					Map<String, Object> map_fkxx_zf = list_ghrb_fkmx_copy.get(k);
					Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
					map_fkxx_all.put("FKFS", map_fkxx_zf.get("FKFS"));
					map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE") + ""));
					list_fkmx_all.add(map_fkxx_all);
				}
			}
		}

		if (list_fkmx_all.size() > 0) {
			for (Map<String, Object> map_fkxx : list_fkmx_all) {
				Map<String, Object> map_fkxxs = new HashMap<String, Object>();
				PubFkfsModel pubFkfs = pubFkfsService.getById(Integer.valueOf(map_fkxx.get("FKFS").toString()));
				map_fkxxs.put("FKFS", pubFkfs.getFkmc());
				fkxx = fkxx + map_fkxxs.get("FKFS") + ":" + String.format("%1$.2f", map_fkxx.get("FKJE"));
			}
		}
//			response.put("syb", String.format("%1$.2f",
//					((syb - sybzf) + (ghsyb - ghsybth))));
//			response.put("szyb", String.format("%1$.2f",
//					((sjyb - sjybzf) + (ghsjyb - ghsjybth))));
//			if ((map_ghrb_all != null && map_ghrb_all.size() > 0)
//					|| (map_mzxx_all != null && map_mzxx_all.size() > 0)) {
//				response.put("amount", fkxx);
//			}

//	  //性质不为“0”时的按收费性质统计的QTYS
//			//门诊_门诊收费信息
//			List<Map<String, Object>> map_xztj = new ArrayList<Map<String, Object>>();
//			StringBuffer sql_xztj = new StringBuffer();
//			Map<String, Object> parameters2 = new HashMap<String, Object>();
//			parameters2.put("jgid", jgid);
//			parameters2.put("czgh", uid);
//			parameters2.put("mzlb", mzlb);
//			sql_xztj.append(" select g.XZMC as XZMC,f.XZDM as XZDM ,f.QTYS as QTYS from (" +
//			                     " select XZDM,sum(QTYS) as QTYS from ("+
//					                  " select  b.BRXZ as XZDM, sum(a.QTYS) as QTYS  from OP_MZXX a   left join PUB_BRXZ b  on a.brxz = b.brxz" +
//			                          " where a.JGID =:jgid and a.JZRQ IS NULL  and a.MZLB  in (:mzlb) and a.CZGH = :czgh   and b.DBPB != '0' and a.ZFPB=0"+
//					                  "  group by b.BRXZ "+
//			                      " UNION all"+
//				                      " select  b.BRXZ as XZDM, sum(a.QTYS) as QTYS  from OP_GHMX a   left join PUB_BRXZ b  on a.brxz = b.brxz" +
//		                              " where a.JGID =:jgid and a.JZRQ IS NULL  and a.MZLB  in (:mzlb) and a.CZGH =:czgh   and b.DBPB != '0' and a.THBZ=0"+
//				                      "  group by b.BRXZ"+
//			                    "  )group by XZDM"+
//					        " ) f left join PUB_BRXZ g on f.XZDM = g.brxz"); 
//			map_xztj = dao.doSqlQuery(sql_xztj.toString(), parameters2);
//			if (map_xztj != null && map_xztj.size() != 0) {
//				 for(int i=0;i<map_xztj.size();i++){
//					 fkxx = fkxx +map_xztj.get(i).get("XZMC")+ ":"
//								+ String.format("%1$.2f",map_xztj.get(i).get("QTYS"))
//								+ " ";
//				 }
//			}
//	 //性质为“0”时的统计QTYS
//			List<Map<String, Object>> map_qtys = new ArrayList<Map<String, Object>>();
//			StringBuffer sql_qtys = new StringBuffer();
//			sql_qtys.append(" select sum(QTYS) as QTYS from (" +
//				                	"select  sum(a.QTYS) as QTYS " +
//				            	        " from OP_MZXX a left join PUB_BRXZ b on a.brxz=b.brxz " +
//					                    " where a.JGID=:jgid and a.JZRQ IS NULL and a.MZLB  in (:mzlb) and a.CZGH=:czgh and b.DBPB='0' and a.ZFPB=0" +
//					                    " group by b.DBPB , a.CZGH " +
//					          " UNION all " +
//					                " select  sum(a.QTYS) as QTYS " +
//			            	        " from OP_GHMX a left join PUB_BRXZ b on a.brxz=b.brxz " +
//				                    " where a.JGID=:jgid and a.JZRQ IS NULL and a.MZLB  in (:mzlb) and a.CZGH=:czgh and b.DBPB='0' and a.THBZ=0" +
//				                    " group by b.DBPB , a.CZGH) "); 
//			map_qtys = dao.doSqlQuery(sql_qtys.toString(), parameters2);
//			if (map_qtys != null && map_qtys.size() != 0&&map_qtys.get(0).get("QTYS")!=null) {
//				fkxx = fkxx+" " + "记账:"
//								+ String.format("%1$.2f",map_qtys.get(0).get("QTYS"))
//								+ " ";
//			}   
//			 qtysFb=fkxx;
//			 response.put("qtysFb", qtysFb);
		/*
		 * String sql_brxz =
		 * "select sum(c.QTYS) as QTYS,c.BRXZ as BRXZ,d.XZMC as XZMC,nvl(d.DBPB,0) as DBPB from ("
		 * +
		 * "select BRXZ as BRXZ,QTYS as QTYS from OP_MZXX where JGID=:jgid and JZRQ IS NULL and MZLB = :mzlb and CZGH = :czgh"
		 * + " union all "+
		 * "select a.BRXZ as BRXZ,(-1*a.QTYS) as QTYS from OP_MZXX a,OP_ZFFP b where a.MZXH = b.MZXH and b.JGID=:jgid and b.JZRQ IS NULL and b.MZLB = :mzlb and b.CZGH = :czgh"
		 * + " union all "+
		 * "select BRXZ as BRXZ,QTYS as QTYS from OP_GHMX where JGID=:jgid and JZRQ IS NULL and MZLB = :mzlb and CZGH = :czgh and JZHM not like 'MGH%' and nvl(ZKBZ,0)=0 "
		 * + " union all "+
		 * "select BRXZ as BRXZ,QTYS as QTYS from OP_GHMX_ZK where JGID=:jgid and JZRQ IS NULL and MZLB = :mzlb and CZGH = :czgh and JZHM not like 'MGH%' and nvl(ZKBZ,0)=0"
		 * + " union all "+
		 * "select a.BRXZ as BRXZ,(-1*a.QTYS) as QTYS from OP_GHMX a,OP_THMX b where a.SBXH = b.SBXH and b.JGID=:jgid and b.JZRQ IS NULL and b.MZLB = :mzlb and b.CZGH = :czgh and a.JZHM not like 'MGH%'"
		 * + " union all "+
		 * "select BRXZ as BRXZ,FYHJ-ZFHJ as QTYS from JC_JCJS where JGID=:jgid and JZRQ IS NULL and CZGH = :czgh and MZLB = :mzlb"
		 * + " union all "+
		 * "select a.BRXZ as BRXZ,(-1*(a.FYHJ-a.ZFHJ)) as QTYS from JC_JCJS a,JC_JSZF b where a.ZYH = b.ZYH and a.JSCS = b.JSCS and b.JGID=:jgid and b.JZRQ IS NULL and b.ZFGH = :czgh and b.MZLB = :mzlb"
		 * + " union all "+
		 * "select a.BRXZ as BRXZ,a.FYHJ-a.ZFHJ as QTYS from LNHL_JS a where  a.JGID = :jgid and a.JZRQ is null and a.MZLB = :mzlb and a.CZGH = :czgh "
		 * + " union all "+
		 * "select a.BRXZ as BRXZ,(-1*(a.FYHJ-a.ZFHJ)) as QTYS from LNHL_FPZF a where  a.JGID = :jgid and a.JZRQ is null and a.MZLB = :mzlb and a.ZFGH = :czgh "
		 * +
		 * ") c left outer join PUB_BRXZ d on c.BRXZ = d.BRXZ group by c.BRXZ,d.XZMC,d.DBPB"
		 * ;
		 */

		// 增加商业保险
		List<Map<String, Object>> ids_fkfs = pubFkfsService.doQueryFkfs(parameters);
		List<Map<String, Object>> ids_brxz = opMzxxDao.doQueryBrxz(parameters);

		String qtysFb = "";
		String jzjeSt = "0.00";
		String POSZJ = "0.00";// POS总金额
		String YBZJ = "0.00";// 医保总金额
		if (ids_fkfs != null && ids_fkfs.size() != 0) {
			for (int j = 0; j < ids_fkfs.size(); j++) {
				if ("3".equals(ids_fkfs.get(j).get("FKFS") + "") || "12".equals(ids_fkfs.get(j).get("FKFS") + "")
						|| "18".equals(ids_fkfs.get(j).get("FKFS") + "")
						|| "21".equals(ids_fkfs.get(j).get("FKFS") + "")
						|| "23".equals(ids_fkfs.get(j).get("FKFS") + "")
						|| "24".equals(ids_fkfs.get(j).get("FKFS") + "")) {
					POSZJ = String.format("%1$.2f",
							ObjectToTypes.parseDouble(POSZJ) + ObjectToTypes.parseDouble(ids_fkfs.get(j).get("FKJE")));

				}
			}
			for (int j = 0; j < ids_fkfs.size(); j++) {
				Map m = ids_fkfs.get(j);
//					if("1".equals(StrUtil.null2Str(m.get("FKFS"))) ){
//						double FKJE = NumUtil.toDouble(m.get("FKJE"))+jjhj;
//						double FKJE = NumUtil.toDouble(m.get("FKJE"));
//						m.put("FKJE",FKJE);
//					 }
				qtysFb = qtysFb + m.get("FKMC") + ":" + String.format("%1$.2f", m.get("FKJE")) + " ";
			}
		}
		if (ids_brxz != null && ids_brxz.size() != 0) {
			for (int j = 0; j < ids_brxz.size(); j++) {
				if ("4001".equals(ids_brxz.get(j).get("BRXZ") + "") || "4001".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "6023".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "45".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "39".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "36".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "35".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "34".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "33".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "32".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "28".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "19".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "23".equals(ids_brxz.get(j).get("BRXZ") + "")// 离休

						|| "29".equals(ids_brxz.get(j).get("BRXZ") + "")) {

					YBZJ = String.format("%1$.2f", ObjectToTypes.parseDouble(YBZJ)
							+ ObjectToTypes.parseDouble(ids_brxz.get(j).get("QTYS") + ""));
				}
			}
			for (int j = 0; j < ids_brxz.size(); j++) {
				if (Integer.parseInt(ids_brxz.get(j).get("DBPB") + "") == 0) {
					jzjeSt = String.format("%1$.2f", ObjectToTypes.parseDouble(jzjeSt)
							+ ObjectToTypes.parseDouble(ids_brxz.get(j).get("QTYS") + ""));
				} else {
					qtysFb = qtysFb + ids_brxz.get(j).get("XZMC") + ":"
							+ String.format("%1$.2f", ObjectToTypes.parseDouble(ids_brxz.get(j).get("QTYS") + ""))
							+ " ";
				}
			}
			qtysFb = qtysFb + " " + "记账 :" + jzjeSt + " ";
			qtysFb = qtysFb + "POS总金额：" + POSZJ + ",医保总金额:" + YBZJ + " ";
		}
		response.put("qtysFb", qtysFb);
		if (response.get("qtysFb") == null || (response.get("qtysFb") + "").length() == 0) {
			throw BaseException.create("ERROR_REG_0075");
		}

		// 转科转号的发票信息
		{
			int numPage = ObjectToTypes.toInt(response.get("numPage")); // 发票总数
			StringBuilder ZKFP = new StringBuilder();
			List<Map<String, Object>> zkList = opMzxxDao.doQueryJzhmBrid(parameters);
			int zkfps = zkList == null ? 0 : zkList.size(); // 转科发票数
			for (int i = 0; i < zkfps; i++) {
				Map m = zkList.get(i);
				Map<String, Object> result = new CaseInsensitiveMap<String, Object>(m);
				ZKFP.append(result.get("JZHM") + "(" + result.get("BRXM") + ")");
			}

			numPage = numPage == 0 ? fpzsSum - zkfps : numPage;

			response.put("yxfps", numPage); // 有效发票数
			response.put("zkfpxx", "转科:" + ZKFP.toString());
			response.put("numPage", numPage + zkfps);
		}
		return response;
	}

	public String gethmStr(List<Map<String, Object>> hmxx) {
		String strnum = "";
		for (int i = 0; i < hmxx.size(); i++) {
			String hm = null;
			if (hmxx.get(i).containsKey("FPHM")) {
				hm = hmxx.get(i).get("FPHM") + "";
			}
			for (int j = 0; j < hm.length(); j++) {
				if (hm.charAt(j) < '0' || hm.charAt(j) > '9') {
					strnum += " " + hmxx.get(i).get("FPHM");
					break;
				}
			}
		}
		return strnum;
	}

	/**
	 * 分隔发票信息
	 * 
	 * @param o
	 * @return
	 */
	public String divisionFpxx(List<Map<String, Object>> list_fpxx, String fphmstr) {
		String beginfphm = "";
		String endfphm = "";
		String currentfphm = "0";
		String fpxx = "";
		if (list_fpxx != null && list_fpxx.size() > 0) {
			for (int i = 0; i < list_fpxx.size(); i++) {
				Map<String, Object> map_fpxx = list_fpxx.get(i);
				if (i == 0) {
					beginfphm = map_fpxx.get("FPHM").toString();
					currentfphm = map_fpxx.get("FPHM").toString();
				}

				if (!map_fpxx.get("FPHM").toString().equals(currentfphm)) {
					endfphm = list_fpxx.get(i - 1).get("FPHM").toString();
					fpxx = InvoiceSequence(fpxx, beginfphm, endfphm);
					beginfphm = map_fpxx.get("FPHM").toString();
					currentfphm = map_fpxx.get("FPHM").toString();
				}
				int k = -1;
				for (int j = currentfphm.length() - 1; j >= 0; j--) {
					if (currentfphm.charAt(j) < '0' || currentfphm.charAt(j) > '9') {
						k = j;
						break;
					}
				}
				String currentfphmzm = currentfphm.substring(0, k + 1);
				String currentfphmsz = currentfphm.substring(k + 1);
				currentfphm = currentfphmzm
						+ String.format("%0" + currentfphmsz.length() + "d", Long.parseLong(currentfphmsz + "") + 1);
			}
			endfphm = list_fpxx.get(list_fpxx.size() - 1).get("FPHM").toString();

			fpxx = InvoiceSequence(fpxx, beginfphm, endfphm);
//			fpxx = fpxx + fphmstr;
		}
		return fpxx;
	}

	public String InvoiceSequence(String fpxx, String beginfphm, String endfphm) {
		if (beginfphm.equals(endfphm)) {
			fpxx += " " + beginfphm;
		} else {
			fpxx += " " + beginfphm + "-" + endfphm;
		}
		return fpxx;
	}

	/**
	 * 查询收费日报
	 * 
	 * @param beginDay
	 * @param endDay
	 * @param page
	 */
	public List<SfrbResp> doQuerySQL(Date beginDay, Date endDay, PageQuery page, Integer uid, Integer jgid, String ip) {
		List<SfrbResp> resp = new ArrayList<SfrbResp>();
		Map<String, Object> response = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("JGID", uid);
		parameters.put("CZGH", jgid);
		List<Map<String, Object>> listSQL = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jgid", jgid);
		map.put("czgh", uid);
		map.put("beginDay", DateUtil.beginOfDay(DateUtil.date(beginDay)).toTimestamp());
		map.put("endDay", DateUtil.endOfDay(DateUtil.date(endDay)).toTimestamp());
		List<Map<String, Object>> listSQL1 = opMzxxDao.doQuerySfrbJzrqList(map);
		List<Map<String, Object>> listSQL2 = opMzxxDao.doQueryGhrbJzrqList(map);
		if (listSQL1 != null && listSQL1.get(0) != null && listSQL1.size() != 0) {
			for (int i = 0; i < listSQL1.size(); i++) {
				Map<String, Object> map_sql = listSQL1.get(i);
				Map<String, Object> map_sql_all = new HashMap<String, Object>();
				map_sql_all.put("JZRQ", map_sql.get("JZRQ"));
				if (listSQL2 != null && listSQL2.size() != 0) {
					for (int J = 0; J < listSQL2.size(); J++) {
						Map<String, Object> map_sql_zf = listSQL2.get(J);
						if (map_sql_zf.containsKey("JZRQ")) {
							if (map_sql.get("JZRQ").equals(map_sql_zf.get("JZRQ"))) {
								map_sql_all.put("JZRQ", map_sql.get("JZRQ"));
								listSQL2.remove(J);
								J--;
							}
						}
					}
				}
				listSQL.add(map_sql_all);
			}

			if (listSQL2 != null && listSQL2.size() != 0) {
				for (int J = 0; J < listSQL2.size(); J++) {
					Map<String, Object> map_sql_zf = listSQL2.get(J);
					if (map_sql_zf.containsKey("JZRQ")) {
						Map<String, Object> map_sql_all = new HashMap<String, Object>();
						map_sql_all.put("JZRQ", map_sql_zf.get("JZRQ"));
						listSQL.add(map_sql_all);
						listSQL2.remove(J);
						J--;
					}
				}
			}

		} else {
			if (listSQL2 != null && listSQL2.get(0) != null && listSQL2.size() != 0) {
				for (int k = 0; k < listSQL2.size(); k++) {
					Map<String, Object> map_sql_zf = listSQL2.get(k);
					Map<String, Object> map_sql_all = new HashMap<String, Object>();
					map_sql_all.put("JZRQ", map_sql_zf.get("JZRQ"));
					listSQL.add(map_sql_all);
				}
			}
		}

		if (listSQL.size() > 0) {
			Collections.sort(listSQL, new Comparator<Map<String, Object>>() {
				@Override
				public int compare(Map<String, Object> map1, Map<String, Object> map2) {
					Timestamp date1 = DateUtil.date(DateUtil.parse(map1.get("JZRQ") + "", "yyyy-MM-dd HH:mm:ss"))
							.toTimestamp();
					Timestamp date2 = DateUtil.date(DateUtil.parse(map2.get("JZRQ") + "", "yyyy-MM-dd HH:mm:ss"))
							.toTimestamp();
					return date1.compareTo(date2);
				}
			});
			response.put("body", listSQL);
			resp = MzUtil.ListToResultSet(listSQL, new SfrbResp());
		}
		// 获取门诊类别
//		Integer mzlb = opMzlbSer.getMzlb(jgid, ip);
//		Map<String, Object> jsMap = new HashMap<String, Object>();
//		jsMap.put("czgh", uid);
//		jsMap.put("jgid", jgid);
//		jsMap.put("mzlb", mzlb);
//		List<Map<String, Object>> list = opMzxxDao.doQueryJsJzrq(jsMap);
//		if (list.size() > 0 && response.get("body") == null) {
//			resp = BSPHISUtil.ListToResultSet(list, new SfrbResp());
//		}
		return resp;
	}

	/**
	 * 收费日报结账
	 */
	public void doQueryVerification(String jzjsrq,Integer uid, Integer jgid, String ip) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer hql_mzxx = new StringBuffer();// 统计收费信息OP_MZXX
		StringBuffer hql_ghmx = new StringBuffer();// 统计收费信息OP_MZXX
		StringBuffer hql_jcmx = new StringBuffer();// 统计家床信息OP_MZXX
		parameters.put("jgid", jgid);
		parameters.put("czgh", uid);
		parameters.put("mzlb", opMzlbSer.getMzlb(jgid, ip));
		parameters.put("jzjsrq",jzjsrq);
		Map<String, Object> map_mzxx = opMzxxDao.doQuerySumMzxxJe(parameters);
		Map<String, Object> map_ghmx = opMzxxDao.doQuerySumGhmxJe(parameters);

		long zffpcount = opZffpDao.doQueryZffpCount(parameters);
		long thmxcount = 0;
		thmxcount = opThmxDao.doQueryThmxCount(parameters);
//		Map<String, Object> map_jcmx = opMzxxDao.doQueryJcjsJe(parameters);
//		long jczffpcount = opMzxxDao.doQueryJszfCount(parameters);

		if ((map_mzxx == null || map_mzxx.size() == 0) && (map_ghmx == null || map_ghmx.size() == 0) && zffpcount == 0
				&& thmxcount == 0) {
			throw BaseException.create("ERROR_REG_0076");
		}
		long count = 0;
		Map<String, Object> parameters1 = new HashMap<String, Object>();
		parameters1.put("mzlb", opMzlbSer.getMzlb(jgid, ip));
		parameters1.put("czgh", uid);
		parameters1.put("jgid", jgid);
		parameters1.put("jzrq", DateUtil.date().toTimestamp());
		count = opMzxxDao.doQueryCountBySfrq(parameters1);

		if (count > 0) {
			throw BaseException.create("ERROR_REG_0077");
		}
		count = 0;
		count = opZffpDao.doQueryZffpCount(parameters1);
		if (count > 0) {
			throw BaseException.create("ERROR_REG_0077");
		}
		count = 0;
		count = opGhmxDao.doQueryCountByGhsj(parameters1);
		if (count > 0) {
			throw BaseException.create("ERROR_REG_0077");
		}
		count = 0;
		count = opThmxDao.doQueryThmxCount(parameters1);
		if (count > 0) {
			throw BaseException.create("ERROR_REG_0077");
		}
	}

	/**
	 * 生成报表判断逻辑
	 * 
	 * @param map
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public Map<String, Object> doCreateSfrb(Date beginDay, Date endDay, String jzrqStr, String save, Integer jgid,
			Integer userId, String userName, String ip) {
		Map<String, Object> request = new HashMap<String, Object>();
		Map<String, Object> response = new HashMap<String, Object>();
		String saveSign = "";
		java.util.Date jzrq = null;
		if (save != null) {
			saveSign = save;
		}
		Integer mzlb = opMzlbSer.getMzlb(jgid, ip);
		if (saveSign.equals("1")) {
			if (jzrqStr != null) {
				jzrq = MzUtil.toDate(jzrqStr);
			} else {
				jzrq = DateUtil.date().toTimestamp();
			}
			response = doCheckout(jzrq, userId, jgid, ip, mzlb);
			if (response.get("jzrq") != null) {
//					request.put("jzrq",BSPHISUtil.toDate(response.get("jzrq").toString()));
				request.put("save", 2);

				response = doQuery(response, jzrq, jgid, userId, userName, ip);
				response = doChargesFsbDailyParameters(jzrq, response, jgid, userId, userName, ip);
			}
			// 说明没有挂号业务，所以没将FPHM字段放入
			// TODO 注释掉
			/*
			 * if (response.get("FPHM") == null || ((String)
			 * response.get("FPHM")).trim().length() == 0) { addFphm(request, response,
			 * user, dao); }
			 */
			if (response.get("invalid") == null || "".equals(((String) response.get("invalid")).trim())) {
				response = addZffp(response, userId, jgid, mzlb);
			}

		} else if (saveSign.equals("2")) {
			if (jzrqStr != null) {
				jzrq = MzUtil.toDate(jzrqStr);
			} else {
				jzrq = DateUtil.date().toTimestamp();
			}
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> res = doQuery(map, jzrq, jgid, userId, userName, ip);
			request.put("jzrq", jzrq);
			response = doChargesFsbDailyParameters(jzrq, res, jgid, userId, userName, ip);
			if (response.get("FPHM") == null || ((String) response.get("FPHM")).trim().length() == 0) {
				response = addFphmForPrint(jzrq, response, userId, userName, jgid, mzlb);
			}
		} else {
			response = getLastHzrqParameters(beginDay, endDay, jgid, userId, userName, ip);
			if (response.get("FPHM") == null) {
				response = addFphmForIreport(response, beginDay, endDay, userId, userName, jgid, mzlb);
			}
		}
		return response;
	}

	private Map<String, Object> addFphmForIreport(Map<String, Object> response, Date beginDay, Date endDay,
			Integer userId, String userName, Integer jgid, Integer mzlb) {
		boolean flag = true;
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("jgid", jgid);
		parameters.put("czgh", userId);
		parameters.put("mzlb", mzlb);

		List<Map<String, Object>> list_fpxx = null;
		list_fpxx = opMzxxDao.doQueryFphmFpzs(parameters);
		StringBuffer fphms = new StringBuffer("发票号码：");
		int _fpzs = 0;
		for (Map<String, Object> map : list_fpxx) {
			if (flag) {
				fphms.append(map.get("FPHM"));
				flag = false;
			} else {
				fphms.append("-" + map.get("FPHM"));
			}
			_fpzs += map.get("FPZS") != null ? Integer.parseInt(map.get("FPZS").toString()) : 0;
		}
		response.put("FPHM", fphms.toString());
		response.put("toll", userName);
		response.put("KSRQ", beginDay);
		response.put("SFRQ", endDay);
		response.put("numPage", _fpzs);
		// response.put("GHHJ", "0.00");
		response.put("Lister", userName);
		response.put("dateTabling", DateUtil.date().toSqlDate());
		return response;
	}

	@Transactional(rollbackFor = Exception.class)
	public Map<String, Object> doQuery(Map<String, Object> res, java.util.Date jzrq, Integer jgid, Integer uid,
			String userName, String ip) {
		// 获得项目的绝对路径 并将路径值传进SUBREPORT_DIR中,
		// 因子报表SUBREPORT_DIR参数值在不同服务器上路径不同,所以用动态路径传值
//		String realPath = OrderCardsInjectionCard.class.getResource("/").getPath();
//		realPath = realPath.substring(1, realPath.indexOf("WEB-INF"));
//		String[] path = realPath.split("/");
//		String usePath = "";
//		for (int i = 0; i < path.length; i++) {
//			if (i == 0) {
//				usePath = path[i];
//			} else {
//				usePath += "\\" + path[i];
//			}
//		}
//		usePath = usePath.replace("%20", " ");
//		res.put("SUBREPORT_DIR", usePath + "\\phis\\prints\\jrxml\\");
		// 存收费日报明细OP_RBMX
		List<Map<String, Object>> list_rbmx = new ArrayList<Map<String, Object>>();
		// 存收费日报性质明细OP_XZMX
		List<Map<String, Object>> list_xzmx = new ArrayList<Map<String, Object>>();
		// 存收费日报付款明细OP_SFRB_FKMX
		List<Map<String, Object>> list_sfrb_fkmxs = new ArrayList<Map<String, Object>>();
		// 存挂号日报付款明细OP_GHRB_FKMX
		List<Map<String, Object>> list_ghrb_fkmxs = new ArrayList<Map<String, Object>>();
		Map<String, Object> map_mzxx_all = new HashMap<String, Object>();
		Map<String, Object> map_ghrb_all = new HashMap<String, Object>();
		List<Map<String, Object>> list_ghrbmx = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> jcxm_list = new ArrayList<Map<String, Object>>();
//		this.doQueryDateInfo(jzrq, list_rbmx, list_xzmx, list_sfrb_fkmxs, list_ghrb_fkmxs, map_mzxx_all, map_ghrb_all,
//				list_ghrbmx, jcxm_list, uid, jgid, ip);
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("jgid", jgid);
		parameters.put("czgh", uid);
//		String fkxx = "";
		double sfhj = 0.0;
		double ghhj = 0.0;
		double qtys = 0.0;
//		String qtysFb="";
//		double sybsf = 0.0;
//		double sybgh = 0.0;
//		double sjybsf = 0.0;
//		double sjybgh = 0.0;
		Integer mzlb = opMzlbSer.getMzlb(jgid, ip);
		parameters.put("mzlb", mzlb);
		parameters.put("jzrq", MzUtil.toString(jzrq, "yyyy-MM-dd HH:mm:ss"));

		StringBuffer hql_hzrb = new StringBuffer();// 结帐后的信息 OP_HZRB
		StringBuffer hql_rbmx = new StringBuffer();// 结帐后的明细信息
													// OP_RBMX,OP_HZRB
		StringBuffer hql_sfrb_fkmx = new StringBuffer();// 结帐后的付款信息OP_SFRB_FKMX,OP_HZRB
		StringBuffer hql_ghrb = new StringBuffer();// 挂号日报 OP_GHRB
		StringBuffer hql_ghrbmx = new StringBuffer();// 挂号日报明细
														// OP_GHRB,OP_GRMX
		StringBuffer hql_ghrb_fkmx = new StringBuffer();// 挂号日报
		// OP_GHRB,OP_GHRB_FKMX
		Map<String, Object> map_hzrb = opMzxxDao.doQueryHzrb(parameters);
		String fpxx = "";
		String numPage = "";
		if (map_hzrb != null && map_hzrb.size() > 0) {
			res.put("qtysFb", map_hzrb.get("YSQTFB"));
//				YSQTFB
//				qtysFb=" "+map_hzrb.get("YSQTFB");
//				res.put("total", String.format("%1$.2f", map_hzrb.get("ZJJE")));
//				res.put("otherAmount",
//						String.format("%1$.2f", map_hzrb.get("QTYS")));
//				if (map_hzrb.get("JJZFJE") != null) {
//					res.put("jjzfje",
//							String.format("%1$.2f", map_hzrb.get("JJZFJE")));
//				} else {
//					res.put("jjzfje", "0.00");
//				}
//				if (map_hzrb.get("SYB") != null) {
//					sybsf = ObjectToTypes.parseDouble(map_hzrb.get("SYB"));
//				}
//				if (map_hzrb.get("SZYB") != null) {
//					sjybsf = ObjectToTypes.parseDouble(map_hzrb.get("SZYB"));
//				}
			numPage += map_hzrb.get("FPZS") == null ? 0 : map_hzrb.get("FPZS").toString();
			res.put("numPage", numPage);
			res.put("invalid", map_hzrb.get("ZFFP") == null ? " " : map_hzrb.get("ZFFP").toString());
			fpxx += map_hzrb.get("QZPJ") == null ? "" : map_hzrb.get("QZPJ").toString();
			res.put("FPHM", fpxx);
			res.put("invalidAmount",
					"张数：" + map_hzrb.get("ZFZS").toString() + " 作废金额："
							+ String.format("%1$.2f", ObjectToTypes.parseDouble(map_hzrb.get("ZFJE"))
									+ ObjectToTypes.parseDouble(map_hzrb.get("JJZFJE"))));
			qtys = ObjectToTypes.parseDouble(map_hzrb.get("QTYS"));
			int ZKZS = ObjectToTypes.toInt(map_hzrb.get("ZKZS"));
			int yxfps = ObjectToTypes.toInt(numPage) - ZKZS;
			String zkfp = ObjectToTypes.null2Str(map_hzrb.get("ZKFP"));
			res.put("yxfps", yxfps);
			res.put("zkfpxx", "转科:" + zkfp);
		}

//			hql_rbmx.append(
//					"select rb.JGID as JGID,rb.CZGH as CZGH,rb.JZRQ as JZRQ,rb.SFXM as SFXM ,rb.SFJE as SFJE from ")
//					.append("OP_RBMX rb,")
//					.append("OP_HZRB hz ")
//					.append(" where hz.CZGH = rb.CZGH and hz.JZRQ = rb.JZRQ AND hz.JGID=:jgid and hz.JZRQ = :jzrq and hz.MZLB  in (:mzlb) and hz.CZGH=:czgh ");
//			list_rbmx = dao.doQuery(hql_rbmx.toString(), parameters);
//			if (list_rbmx.size() > 0) {
//				for (Map<String, Object> map_rbmx : list_rbmx) {
//					sfhj = sfhj + ObjectToTypes.parseDouble(map_rbmx.get("SFJE") + "");
//				}
//			}
		// 上面求SFHJ 太啰嗦
		list_rbmx = opMzxxDao.doQueryZjje(parameters);
		if (list_rbmx.size() > 0) {
			for (Map<String, Object> map_rbmx : list_rbmx) {
				sfhj = sfhj + ObjectToTypes.parseDouble(map_rbmx.get("ZJJE") + "");
			}
		}
		Map<String, Object> map_ghrb = opMzxxDao.doQueryGhrb(parameters);
		if (map_ghrb != null && map_ghrb.size() > 0) {
//				if (map_ghrb.get("SYB") != null) {
//					sybgh = ObjectToTypes.parseDouble(map_ghrb.get("SYB"));
//				}
//				if (map_ghrb.get("SZYB") != null) {
//					sjybgh = ObjectToTypes.parseDouble(map_ghrb.get("SZYB"));
//				}
			res.put("JZHM", map_ghrb.get("QZPJ") == null ? "" : map_ghrb.get("QZPJ").toString());
			res.put("GHHJ", String.format("%1$.2f", map_ghrb.get("ZJJE")));
			res.put("invalidgh", map_ghrb.get("THFP") == null ? " " : map_ghrb.get("THFP").toString());
			res.put("invalidghAmount",
					"张数：" + map_ghrb.get("THSL").toString() + " 退号金额：" + String.format("%1$.2f", map_ghrb.get("THJE")));
			ghhj = ghhj + ObjectToTypes.parseDouble(map_ghrb.get("ZJJE") + "");
			qtys = ObjectToTypes.parseDouble(map_ghrb.get("QTYS")) + qtys;
//				res.put("otherAmount", String.format("%1$.2f", qtys));
		}
		Map<String, Object> map_ghrbmx = opMzxxDao.doQueryGhrbmx(parameters);
//			if (map_ghrbmx != null && map_ghrbmx.size() > 0) {
//				res.put("GHF", map_ghrbmx.get("GHJE").toString());
//				res.put("ZLF", map_ghrbmx.get("ZLJE").toString());
//				res.put("BLF", map_ghrbmx.get("BLJE").toString());
//				res.put("ZJF", map_ghrbmx.get("ZJFY").toString());
//			}

		if ((map_hzrb != null && map_hzrb.size() > 0) || (map_ghrbmx != null && map_ghrbmx.size() > 0)) {
			SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Map<String, Object> jzrqMap = new HashMap<String, Object>();
			jzrqMap.put("JGID", jgid);
			jzrqMap.put("CZGH", uid);
			jzrqMap.put("jzrq", jzrq);
			// 查询上次结账时间
			Map<String, Object> jzrqmapsf = opMzxxDao.doQueryMaxHzrbJzrq(jzrqMap);
			Map<String, Object> jzrqmapgh = opMzxxDao.doQueryMaxGhrbJzrq(jzrqMap);
			if ((jzrqmapsf != null && jzrqmapgh != null) && jzrqmapsf.get("JZRQ") != null
					&& jzrqmapgh.get("JZRQ") != null) {
				DateTime jzrqmapsfDate = DateUtil.parse(jzrqmapsf.get("JZRQ") + "", "yyyy-MM-dd HH:mm:ss");
				DateTime jzrqmapghDate = DateUtil.parse(jzrqmapgh.get("JZRQ") + "", "yyyy-MM-dd HH:mm:ss");
				java.util.Date jzrqsf = DateUtil.date(jzrqmapsfDate).toTimestamp();
				java.util.Date jzrqgh = DateUtil.date(jzrqmapghDate).toTimestamp();
				if (jzrqsf.getTime() > jzrqgh.getTime()) {
					res.put("KSRQ", MzUtil.toString(jzrqsf, "yyyy-MM-dd HH:mm:ss"));
				} else {
					res.put("KSRQ", MzUtil.toString(jzrqgh, "yyyy-MM-dd HH:mm:ss"));
				}
			} else if (jzrqmapsf != null && jzrqmapsf.get("JZRQ") != null) {
				DateTime jzrqmapsfDate = DateUtil.parse(jzrqmapsf.get("JZRQ") + "", "yyyy-MM-dd HH:mm:ss");
				java.util.Date jzrqsf = DateUtil.date(jzrqmapsfDate).toTimestamp();
				res.put("KSRQ", MzUtil.toString(jzrqsf, "yyyy-MM-dd HH:mm:ss"));
			} else if (jzrqmapgh != null && jzrqmapgh.get("JZRQ") != null) {
				DateTime jzrqmapghDate = DateUtil.parse(jzrqmapgh.get("JZRQ") + "", "yyyy-MM-dd HH:mm:ss");
				java.util.Date jzrqgh = DateUtil.date(jzrqmapghDate).toTimestamp();
				res.put("KSRQ", MzUtil.toString(jzrqgh, "yyyy-MM-dd HH:mm:ss"));
			} else {
				Map<String, Object> sfrqorghrq = new HashMap<String, Object>();
				sfrqorghrq.put("JGID", jgid);
				sfrqorghrq.put("CZGH", uid);
				sfrqorghrq.put("MZLB", mzlb);
				// 查询上次结账时间
				Map<String, Object> sfrqmap = opMzxxDao.doQueryMinSfrq(sfrqorghrq);
				Map<String, Object> ghrqmap = opMzxxDao.doQueryMinGhsj(sfrqorghrq);
				if ((sfrqmap != null && ghrqmap != null) && sfrqmap.get("SFRQ") != null
						&& ghrqmap.get("GHSJ") != null) {
					DateTime sfrqmapDate = DateUtil.parse(sfrqmap.get("SFRQ") + "", "yyyy-MM-dd HH:mm:ss");
					DateTime ghrqmapDate = DateUtil.parse(ghrqmap.get("GHSJ") + "", "yyyy-MM-dd HH:mm:ss");
					java.util.Date sfrq = DateUtil.date(sfrqmapDate).toTimestamp();
					java.util.Date ghsj = DateUtil.date(ghrqmapDate).toTimestamp();
					if (sfrq.getTime() < ghsj.getTime()) {
						res.put("KSRQ", MzUtil.toString(sfrq, "yyyy-MM-dd HH:mm:ss"));
					} else {
						res.put("KSRQ", MzUtil.toString(ghsj, "yyyy-MM-dd HH:mm:ss"));
					}
				} else if (sfrqmap != null && sfrqmap.get("SFRQ") != null) {
					DateTime sfrqmapDate = DateUtil.parse(sfrqmap.get("SFRQ") + "", "yyyy-MM-dd HH:mm:ss");
					java.util.Date sfrq = DateUtil.date(sfrqmapDate).toTimestamp();
					res.put("KSRQ", MzUtil.toString(sfrq, "yyyy-MM-dd HH:mm:ss"));
				} else if (ghrqmap != null && ghrqmap.get("GHSJ") != null) {
					DateTime ghrqmapDate = DateUtil.parse(ghrqmap.get("GHSJ") + "", "yyyy-MM-dd HH:mm:ss");
					java.util.Date ghsj = DateUtil.date(ghrqmapDate).toTimestamp();
					res.put("KSRQ", MzUtil.toString(ghsj, "yyyy-MM-dd HH:mm:ss"));
				}
			}
//				res.put("syb", (sybgh + sybsf) + "");
//				res.put("szyb", (sjybgh + sjybsf) + "");
			res.put("toll", userName);
			res.put("SFRQ", MzUtil.toString(jzrq, "yyyy-MM-dd HH:mm:ss"));
			res.put("Lister", userName);
			res.put("dateTabling", DateUtil.date().toSqlDate());
		}
		List<Map<String, Object>> list_sfrb_fkmx = opMzxxDao.doQuerySfrbFkmx(parameters);
		List<Map<String, Object>> list_ghrb_fkmx = opMzxxDao.doQueryGhrbFkmx(parameters);

		List<Map<String, Object>> list_sfrb_fkmx_copy = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list_ghrb_fkmx_copy = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list_fkmx_all = new ArrayList<Map<String, Object>>();

		list_sfrb_fkmx_copy.addAll(list_sfrb_fkmx);
		list_ghrb_fkmx_copy.addAll(list_ghrb_fkmx);
		if (list_sfrb_fkmx_copy != null && list_sfrb_fkmx_copy.size() != 0) {
			for (int i = 0; i < list_sfrb_fkmx_copy.size(); i++) {
				Map<String, Object> map_fkxx = new CaseInsensitiveMap<String, Object>(list_sfrb_fkmx_copy.get(i));
				Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
				map_fkxx_all.put("FKFS", map_fkxx.get("FKFS"));
				map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx.get("FKJE")));
				if (list_ghrb_fkmx_copy != null && list_ghrb_fkmx_copy.size() != 0) {
					for (int J = 0; J < list_ghrb_fkmx_copy.size(); J++) {
						Map<String, Object> map_fkxx_zf = list_ghrb_fkmx_copy.get(J);
						if (map_fkxx_zf.containsKey("FKFS")) {
							if (Long.parseLong(map_fkxx.get("FKFS") + "") == Long
									.parseLong(map_fkxx_zf.get("FKFS") + "")) {
								map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx_all.get("FKJE") + "")
										+ ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE") + ""));
								list_ghrb_fkmx_copy.remove(J);
								J--;
							}
						}
					}
				}
				list_fkmx_all.add(map_fkxx_all);
			}

			if (list_ghrb_fkmx_copy != null && list_ghrb_fkmx_copy.size() != 0) {
				for (int J = 0; J < list_ghrb_fkmx_copy.size(); J++) {
					Map<String, Object> map_fkxx_zf = new CaseInsensitiveMap<String, Object>(
							list_ghrb_fkmx_copy.get(J));
					if (map_fkxx_zf.containsKey("FKFS")) {
						Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
						map_fkxx_all.put("FKFS", map_fkxx_zf.get("FKFS"));
						map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE") + ""));
						list_fkmx_all.add(map_fkxx_all);
						list_ghrb_fkmx_copy.remove(J);
						J--;
					}
				}
			}

		} else {
			if (list_ghrb_fkmx_copy != null && list_ghrb_fkmx_copy.size() != 0) {
				for (int k = 0; k < list_ghrb_fkmx_copy.size(); k++) {
					Map<String, Object> map_fkxx_zf = new CaseInsensitiveMap<String, Object>(
							list_ghrb_fkmx_copy.get(k));
					Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
					map_fkxx_all.put("FKFS", map_fkxx_zf.get("FKFS"));
					map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE") + ""));
					list_fkmx_all.add(map_fkxx_all);
				}
			}
		}

//			if (list_fkmx_all.size() > 0) {
//				for (Map<String, Object> map_fkxx : list_fkmx_all) {
//					Map<String, Object> map_fkxxs = new HashMap<String, Object>();
//					map_fkxxs.put("FKFS",
//							DictionaryController.instance().get("phis.dictionary.payment")
//									.getText(map_fkxx.get("FKFS").toString()));
//					fkxx = fkxx + map_fkxxs.get("FKFS") + ":"
//							+ String.format("%1$.2f", map_fkxx.get("FKJE"))
//							+ " ";
//				}
//				res.put("amount", fkxx);
////				qtysFb=fkxx+qtysFb;
//			}
//			res.put("qtysFb", qtysFb);
		// TODO 注释掉
		/*
		 * Map<String, Object> jcparameters = new HashMap<String, Object>();
		 * jcparameters.put("CZGH", uid); jcparameters.put("JGID", jgid);
		 * jcparameters.put("jzrq", DateUtil.date(jzrq).toTimestamp()); jcxm_list =
		 * opMzxxDao.doQuerySumZjje(jcparameters); double jchj = 0.0; for (int i = 0; i
		 * < jcxm_list.size(); i++) { jchj = jchj +
		 * ObjectToTypes.parseDouble(jcxm_list.get(i).get("ZJJE")); }
		 */
		Map<String, Object> yjkparameters = new HashMap<String, Object>();
		yjkparameters.put("CZGH", uid);
		yjkparameters.put("JGID", jgid);
		yjkparameters.put("jzrq", DateUtil.date(jzrq).toTimestamp());
//		Map<String, Object> yjk_map = opMzxxDao.doQueryTbkkJkJe(yjkparameters);
//		Map<String, Object> jkzf_map = opMzxxDao.doQueryJkjeZf(yjkparameters);
		res.put("HJHJ", String.format("%.2f", sfhj));
//		res.put("JCHJ", jchj);
//		res.put("SYJJ", String.format("%1$.2f", yjk_map.get("JKJE")));
//		res.put("TYJJ", String.format("%1$.2f", jkzf_map.get("JKJE")));

//			System.out.println( (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cdate.getTime()));
//			System.out.println( (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(req.get("jzrq")));
//			//老年护理结算合计
//			String lnhlsql = " select sum(a.JKHJ) as JKHJ from  LNHL_JS a where a.JGID=:JGID and a.JSRQ = :jzrq  and a.CZGH=:CZGH and a.ZFPB <> 1  ";
//			Map<String,Object> lnhl_map = dao.doSqlLoad(lnhlsql, yjkparameters);
//			res.put("LNHLHJ", String.format("%1$.2f", lnhl_map.get("JKHJ")));

		// TODO 注释掉
		/*
		 * double jjhj = 0.00; // 居家合计 doQuery Map<String, Object> params = new
		 * HashMap<String, Object>(); params.put("CZGH", uid); params.put("JGID", jgid);
		 * params.put("jzrq", DateUtil.date(jzrq).toTimestamp()); params.put("mzlb",
		 * mzlb); Map<String, Object> hl_map = opMzxxDao.doQuerySumJkhj(params); jjhj =
		 * ObjectToTypes.toDouble(hl_map.get("JKHJ")); res.put("JJHJ", jjhj);
		 */

//		double dxje = sfhj + ghhj + jchj + jjhj + ObjectToTypes.parseDouble(yjk_map.get("JKJE"))
		double dxje = sfhj + ghhj;
		String dxjeBig = String.format("%1$.2f", new BigDecimal(ObjectToTypes.null2Str(dxje)));
		if (dxje < 0) {
			res.put("amountIn", "负" + MzUtil.changeMoneyUpper(String.format("%1$.2f", -(dxje))) + "(" + dxjeBig + ")");
		} else {
			res.put("amountIn", MzUtil.changeMoneyUpper(String.format("%1$.2f", dxje)) + "(" + dxjeBig + ")");
		}
		StringBuffer hql_grmx = new StringBuffer();
		StringBuffer hql_grthmx = new StringBuffer();

		List<Map<String, Object>> list_grmx = opMzxxDao.doQueryGrmxJeRb(parameters);
		List<Map<String, Object>> list_grthmx = opMzxxDao.doQueryGrthmxRb(parameters);

		if (list_grmx != null && list_grmx.size() != 0) {
			for (int i = 0; i < list_grmx.size(); i++) {
				Map<String, Object> map_grmx = new CaseInsensitiveMap<String, Object>(list_grmx.get(i));
				Map<String, Object> map_grmx_all = new HashMap<String, Object>();
				map_grmx_all.put("BRXZ", map_grmx.get("BRXZ"));
				map_grmx_all.put("CZGH", uid);
				map_grmx_all.put("FPZS", ObjectToTypes.parseInt(map_grmx.get("GHRC")));
				map_grmx_all.put("SFJE", ObjectToTypes.parseDouble(map_grmx.get("ZJJE")));
				map_grmx_all.put("GHJE", ObjectToTypes.parseDouble(map_grmx.get("GHJE")));
				map_grmx_all.put("ZLJE", ObjectToTypes.parseDouble(map_grmx.get("ZLJE")));
				map_grmx_all.put("ZJFY", ObjectToTypes.parseDouble(map_grmx.get("ZJFY")));
				map_grmx_all.put("BLJE", ObjectToTypes.parseDouble(map_grmx.get("BLJE")));
				map_grmx_all.put("JGID", jgid);
				map_grmx_all.put("JZRQ", DateUtil.date().toTimestamp());
				map_grmx_all.put("XM", map_grmx.get("XM") + "");
				if (list_grthmx != null && list_grthmx.size() != 0) {
					for (int J = 0; J < list_grthmx.size(); J++) {
						Map<String, Object> map_grthmx = new CaseInsensitiveMap<String, Object>(list_grthmx.get(J));
						if (map_grthmx.containsKey("BRXZ")) {
							if (Long.parseLong(map_grmx.get("BRXZ") + "") == Long
									.parseLong(map_grthmx.get("BRXZ") + "")) {
								map_grmx_all.put("SFJE", ObjectToTypes.parseDouble(map_grmx_all.get("SFJE"))
										- ObjectToTypes.parseDouble(map_grthmx.get("ZJJE")));
								map_grmx_all.put("GHJE", ObjectToTypes.parseDouble(map_grmx_all.get("GHJE"))
										- ObjectToTypes.parseDouble(map_grthmx.get("GHJE")));
								map_grmx_all.put("ZLJE", ObjectToTypes.parseDouble(map_grmx_all.get("ZLJE"))
										- ObjectToTypes.parseDouble(map_grthmx.get("ZLJE")));
								map_grmx_all.put("ZJFY", (Double) map_grmx_all.get("ZJFY")
										- ObjectToTypes.parseDouble(map_grthmx.get("ZJFY")));
								map_grmx_all.put("BLJE", ObjectToTypes.parseDouble(map_grmx_all.get("BLJE"))
										- ObjectToTypes.parseDouble(map_grthmx.get("BLJE")));
								list_grthmx.remove(J);
								J--;
							}
						}
					}
				}
				list_ghrbmx.add(map_grmx_all);
			}

			if (list_grthmx != null && list_grthmx.size() != 0) {
				for (int J = 0; J < list_grthmx.size(); J++) {
					Map<String, Object> map_grthmx = new CaseInsensitiveMap<String, Object>(list_grthmx.get(J));
					if (map_grthmx.containsKey("BRXZ")) {
						Map<String, Object> map_grmx_all = new HashMap<String, Object>();
						map_grmx_all.put("CZGH", uid);
						map_grmx_all.put("JGID", jgid);
						map_grmx_all.put("JZRQ", DateUtil.date().toTimestamp());
						map_grmx_all.put("FPZS", ObjectToTypes.parseInt(map_grthmx.get("GHRC")));
						map_grmx_all.put("SFJE", -ObjectToTypes.parseDouble(map_grthmx.get("ZJJE") + ""));
						map_grmx_all.put("GHJE", -ObjectToTypes.parseDouble(map_grthmx.get("GHJE") + ""));
						map_grmx_all.put("ZLJE", -ObjectToTypes.parseDouble(map_grthmx.get("ZLJE") + ""));
						map_grmx_all.put("ZJFY", -ObjectToTypes.parseDouble(map_grthmx.get("ZJFY") + ""));
						map_grmx_all.put("BLJE", -ObjectToTypes.parseDouble(map_grthmx.get("BLJE") + ""));
						map_grmx_all.put("BRXZ", map_grthmx.get("BRXZ"));
						map_grmx_all.put("XM", map_grthmx.get("XM") + "");
						list_grthmx.remove(J);
						list_ghrbmx.add(map_grmx_all);
						J--;
					}
				}
			}

		} else {
			if (list_grthmx != null && list_grthmx.size() != 0) {
				for (int k = 0; k < list_grthmx.size(); k++) {
					Map<String, Object> map_grthmx = new CaseInsensitiveMap<String, Object>(list_grthmx.get(k));
					Map<String, Object> map_grmx_all = new HashMap<String, Object>();
					map_grmx_all.put("BRXZ", map_grthmx.get("BRXZ"));
					map_grmx_all.put("CZGH", uid);
					map_grmx_all.put("FPZS", -ObjectToTypes.parseInt(map_grthmx.get("GHRC")));
					map_grmx_all.put("SFJE", -ObjectToTypes.parseDouble(map_grthmx.get("ZJJE") + ""));
					map_grmx_all.put("GHJE", -ObjectToTypes.parseDouble(map_grthmx.get("GHJE") + ""));
					map_grmx_all.put("ZLJE", -ObjectToTypes.parseDouble(map_grthmx.get("ZLJE") + ""));
					map_grmx_all.put("ZJFY", -ObjectToTypes.parseDouble(map_grthmx.get("ZJFY") + ""));
					map_grmx_all.put("BLJE", -ObjectToTypes.parseDouble(map_grthmx.get("BLJE") + ""));
					map_grmx_all.put("JGID", jgid);
					map_grmx_all.put("JZRQ", DateUtil.date().toTimestamp());
					map_grmx_all.put("XM", map_grthmx.get("XM") + "");
					list_ghrbmx.add(map_grmx_all);
				}
			}
		}

//			
//			String jjhjfpxx = "select sum(a.JKHJ) as JKHJ from  LNHL_JS a where a.JGID=:JGID  and a.JZRQ= :jzrq and a.CZGH=:CZGH and a.ZFPB <> 1  ";
//			List<Map<String, Object>> fplist =dao.doSqlQuery(jjhjfpxx, params);
//			List listtemp = new ArrayList();
//			if(fplist!=null && fplist.size()!=0){
//				for(Map<String, Object> fp :fplist){
//					int fahm = Integer.ObjectToTypes.parseInt(StrUtil.null2Str(fp.get("FPHM")));
//						 listtemp.add(fahm);
//						 fpxx +=" "+ fahm;
//				}
//				res.put("FPHM", fpxx);
//				res.put("numPage", (numPage+listtemp.size()) + "");
//			}
		return res;
	}

	public void doQueryDateInfo(java.util.Date jzrqDate, List<Map<String, Object>> list_rbmx,
			List<Map<String, Object>> list_xzmx, List<Map<String, Object>> list_sfrb_fkmx,
			List<Map<String, Object>> list_ghrb_fkmx, Map<String, Object> map_mzxx_all,
			Map<String, Object> map_ghrb_all, List<Map<String, Object>> list_ghrbmx,
			List<Map<String, Object>> jcxm_list, Integer uid, Integer jgid, String ip) {
		list_rbmx.clear();
		list_xzmx.clear();
		list_sfrb_fkmx.clear();
		list_ghrb_fkmx.clear();
		list_ghrbmx.clear();
		String fpxx = "";
		StringBuffer zffpxx = new StringBuffer();
//		String jzhmxx = "";
		StringBuffer thjzhmxx = new StringBuffer();
		String SQXTMS = sysXtcsCacheSer.getCsz(jgid, "SQXTMS");

		String jzrq = MzUtil.toString(jzrqDate, "yyyy-MM-dd HH:mm:ss");
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("jgid", jgid);
		parameters.put("czgh", uid);
		double sfhj = 0.0;
		String fkxx = "";
		double qtys = 0.0;
		double jjzfje = 0.0;
		double zfje = 0.0;
		int fpzs = 0;
		double ghhj = 0.0;
		double ghje = 0.0;
		double zlje = 0.0;
		double blje = 0.0;
		double zjfy = 0.0;
		Integer mzlb = opMzlbSer.getMzlb(jgid, ip);
		parameters.put("mzlb", mzlb);
		StringBuffer hql_mzxx = new StringBuffer();
		StringBuffer hql_mzxx_zf = new StringBuffer();
		// OP_ZFFP
		StringBuffer hql_sfmx = new StringBuffer();
		StringBuffer hql_sfmx_zf = new StringBuffer();
		// OP_ZFFP
		StringBuffer hql_xzmx = new StringBuffer();
		StringBuffer hql_xzmx_zf = new StringBuffer();
		// OP_ZFFP
		StringBuffer hql_fkxx = new StringBuffer();
		StringBuffer hql_fkxx_zf = new StringBuffer();
		// OP_ZFFP
		StringBuffer hql_fpxx = new StringBuffer();
		StringBuffer hql_zffpxx = new StringBuffer();
		// OP_ZFFP
		StringBuffer hql_ghmx = new StringBuffer();
		StringBuffer hql_ghthmx = new StringBuffer();
		// OP_THMX
		StringBuffer hql_grmx = new StringBuffer();//
		StringBuffer hql_grthmx = new StringBuffer();
		// OP_THMX
		StringBuffer hql_ghfkxx = new StringBuffer();
		// OP_GH_FKXX
		StringBuffer hql_ghfkxx_zf = new StringBuffer();
		// OP_THMX
		// OP_GH_FKXX
//			StringBuffer hql_jzhm = new StringBuffer();
		StringBuffer hql_jzhm_zf = new StringBuffer();
		/*
		 * hql_mzxx.append(
		 * "select a.CZGH as CZGH,sum(nvl(a.FPZS,1))+(select count(JZHM) from OP_GHMX where JGID=:jgid and JZRQ IS NULL and CZGH=:czgh and JZHM not like 'MGH%'  and MZLB = :mzlb and nvl(ZKBZ,0)=0 )+(select count(JZHM) from OP_GHMX_ZK where JGID=:jgid and JZRQ IS NULL and CZGH=:czgh and JZHM not like 'MGH%'  and MZLB = :mzlb and nvl(ZKBZ,0)=0 )  + (select count(FPHM) from  LNHL_JS a where a.JGID=:jgid and JZRQ IS NULL and a.CZGH=:czgh and MZLB  in (:mzlb)) as FPZS,sum(a.ZJJE) as ZJJE,sum(a.XJJE) as XJJE,"
		 * +
		 * " sum(a.ZPJE) as ZPJE,sum(a.ZHJE) as ZHJE,sum(a.QTYS+a.ZHJE) as QTYS,sum(a.JJZFJE) as JJZFJE,"
		 * +
		 * " sum(a.HBWC) as HBWC,nvl((select sum(FYHJ) from JC_JCJS where JGID=:jgid and JZRQ IS NULL and CZGH=:czgh and MZLB = :mzlb),0) as JCJE,nvl((select sum(JKJE) from JC_TBKK where JGID=:jgid and JZRQ IS NULL and CZGH=:czgh and MZLB = :mzlb),0) as JCTJKJE from "
		 * )
		 * .append("(select nvl(aa.czgh, bb.czgh) as czgh,aa.FPZS,nvl( aa.JGID ,bb.jgid) as jgid ,aa.ZJJE ,aa.XJJE  ,aa.ZPJE  ,aa.QTYS ,aa.ZHJE  ,aa.JJZFJE  ,aa.HBWC ,nvl(aa.mzlb,bb.mzlb) as mzlb,nvl(aa.JZRQ, bb.jzrq) as jzrq from OP_MZXX aa full join jc_jcjs bb on aa.czgh = bb.czgh) a"
		 * )
		 * .append(" where a.JGID=:jgid and a.JZRQ IS NULL and a.MZLB  in (:mzlb) and a.CZGH=:czgh group by a.CZGH"
		 * );
		 */

//			hql_mzxx_zf
//					.append("select zf.CZGH as CZGH,sum(nvl(mz.FPZS,1))+(select count(1) from JC_JSZF where JGID=:jgid and JZRQ IS NULL and ZFGH=:czgh) as FPZS,sum(mz.ZJJE) as ZJJE,sum(mz.XJJE) as XJJE,"
//							+ " sum(mz.ZPJE) as ZPJE,sum(mz.ZHJE) as ZHJE,sum(mz.QTYS+mz.ZHJE) as QTYS,"
//							+ " sum(mz.JJZFJE) as JJZFJE,sum(mz.HBWC) as HBWC,nvl((select sum(FYHJ) from JC_JSZF a,JC_JCJS b where a.ZYH=b.ZYH and a.JSCS=b.JSCS and a.JGID=:jgid and a.JZRQ IS NULL and a.ZFGH=:czgh),0) as JCJE,nvl((select sum(a.JKJE) from JC_TBKK a,JC_JKZF b where a.JKXH=b.JKXH and b.JGID=:jgid and b.JZRQ IS NULL and b.ZFGH=:czgh),0) as JCTJKJE from ")
//					.append("OP_MZXX mz,")
//					.append("OP_ZFFP zf where mz.MZXH = zf.MZXH and zf.JGID=:jgid and zf.JZRQ IS NULL and zf.MZLB = :mzlb and zf.CZGH =:czgh group by zf.CZGH");
		List<Map<String, Object>> mzxxList = opMzxxDao.doQueryMzxxJe(parameters);
		logger.info("mzxxList=" + mzxxList);
		Map<String, Object> map_mzxx = new HashMap<String, Object>();
		if (mzxxList.size() > 0) {
//			map_mzxx = mzxxList.get(0);
			map_mzxx = new CaseInsensitiveMap<String, Object>(mzxxList.get(0));
		}
		if (map_mzxx != null && map_mzxx.size() > 0) {
//				map_mzxx_all.put("SYB", ObjectToTypes.parseDouble(map_mzxx.get("SYB")));
//				map_mzxx_all.put("SJYB", ObjectToTypes.parseDouble(map_mzxx.get("SJYB")));
			map_mzxx_all.put("CZGH", map_mzxx.get("CZGH"));
			map_mzxx_all.put("MZLB", mzlb);
			map_mzxx_all.put("ZJJE",
					map_mzxx.get("ZJJE") == null ? 0 : ObjectToTypes.parseDouble(map_mzxx.get("ZJJE")));
			map_mzxx_all.put("XJJE",
					map_mzxx.get("XJJE") == null ? 0 : ObjectToTypes.parseDouble(map_mzxx.get("XJJE")));
			map_mzxx_all.put("ZPJE",
					map_mzxx.get("ZPJE") == null ? 0 : ObjectToTypes.parseDouble(map_mzxx.get("ZPJE")));
			map_mzxx_all.put("QTYS",
					map_mzxx.get("QTYS") == null ? 0 : ObjectToTypes.parseDouble(map_mzxx.get("QTYS")));
			map_mzxx_all.put("JCTJKJE",
					map_mzxx.get("JCTJKJE") == null ? 0 : ObjectToTypes.parseDouble(map_mzxx.get("JCTJKJE")));
			map_mzxx_all.put("JCJE",
					map_mzxx.get("JCJE") == null ? 0 : ObjectToTypes.parseDouble(map_mzxx.get("JCJE")));
			if (map_mzxx.get("JJZFJE") != null) {
				map_mzxx_all.put("JJZFJE", ObjectToTypes.parseDouble(map_mzxx.get("JJZFJE")));
			} else {
				map_mzxx_all.put("JJZFJE", 0.0);
			}
			map_mzxx_all.put("HBWC",
					map_mzxx.get("HBWC") == null ? 0 : ObjectToTypes.parseDouble(map_mzxx.get("HBWC") + ""));
			if (map_mzxx.get("FPZS") != null) {
				map_mzxx_all.put("FPZS", ObjectToTypes.parseInt(map_mzxx.get("FPZS")));
			} else {
				map_mzxx_all.put("FPZS", 0);
			}
			map_mzxx_all.put("ZFZS", 0);
			map_mzxx_all.put("ZFJE", 0.0);
		}
		List<Map<String, Object>> mzxx_zf_list = opMzxxDao.doQueryMzxxJeZf(parameters);
		logger.info("mzxx_zf_list=" + mzxx_zf_list);

		Map<String, Object> map_mzxx_zf = new HashMap<String, Object>();
		if (mzxx_zf_list.size() > 0) {
//			map_mzxx_zf = mzxx_zf_list.get(0);
			map_mzxx_zf = new CaseInsensitiveMap<String, Object>(mzxx_zf_list.get(0));
		}
		if (map_mzxx_zf != null && map_mzxx_zf.size() > 0) {
			if (map_mzxx_all.size() > 0) {
				if (map_mzxx_zf.get("JCJE") != null) {
					map_mzxx_zf.put("JJZFJE", -ObjectToTypes.parseDouble(map_mzxx_zf.get("JCJE")));
				} else {
					map_mzxx_zf.put("JJZFJE", 0.00);
				}
				map_mzxx_all.put("JCTJKJE", ObjectToTypes.parseDouble(map_mzxx_all.get("JCTJKJE"))
						- ObjectToTypes.parseDouble(map_mzxx_zf.get("JCTJKJE")));
				map_mzxx_all.put("JCJE", ObjectToTypes.parseDouble(map_mzxx_all.get("JCJE"))
						- ObjectToTypes.parseDouble(map_mzxx_zf.get("JCJE")));
				map_mzxx_all.put("ZJJE", ObjectToTypes.parseDouble(map_mzxx_all.get("ZJJE"))
						- ObjectToTypes.parseDouble(map_mzxx_zf.get("ZJJE")));
//					map_mzxx_all.put("SYB",
//							ObjectToTypes.parseDouble(map_mzxx_all.get("SYB"))
//									- ObjectToTypes.parseDouble(map_mzxx_zf.get("SYB")));
//					map_mzxx_all.put("SZYB",
//							ObjectToTypes.parseDouble(map_mzxx_all.get("SJYB"))
//									- ObjectToTypes.parseDouble(map_mzxx_zf.get("SJYB")));
				map_mzxx_all.put("XJJE", ObjectToTypes.parseDouble(map_mzxx_all.get("XJJE"))
						- ObjectToTypes.parseDouble(map_mzxx_zf.get("XJJE")));
				map_mzxx_all.put("ZPJE", ObjectToTypes.parseDouble(map_mzxx_all.get("ZPJE"))
						- ObjectToTypes.parseDouble(map_mzxx_zf.get("ZPJE")));
				map_mzxx_all.put("QTYS", ObjectToTypes.parseDouble(map_mzxx_all.get("QTYS"))
						- ObjectToTypes.parseDouble(map_mzxx_zf.get("QTYS")));
				map_mzxx_all.put("JJZFJE", ObjectToTypes.parseDouble(map_mzxx_all.get("JJZFJE"))
						+ ObjectToTypes.parseDouble(map_mzxx_zf.get("JJZFJE")));
				map_mzxx_all.put("HBWC", ObjectToTypes.parseDouble(map_mzxx_all.get("HBWC"))
						- ObjectToTypes.parseDouble(map_mzxx_zf.get("HBWC")));
				map_mzxx_all.put("ZFZS", ObjectToTypes.parseInt(map_mzxx_all.get("ZFZS"))
						+ ObjectToTypes.parseInt(map_mzxx_zf.get("FPZS")));
				map_mzxx_all.put("ZFJE", ObjectToTypes.parseDouble(map_mzxx_all.get("ZFJE"))
						+ ObjectToTypes.parseDouble(map_mzxx_zf.get("ZJJE")));
			} else {
				map_mzxx_all.put("JCTJKJE", -ObjectToTypes.parseDouble(map_mzxx_zf.get("JCTJKJE")));
				map_mzxx_all.put("JCJE", -ObjectToTypes.parseDouble(map_mzxx_zf.get("JCJE")));
				map_mzxx_all.put("CZGH", map_mzxx_zf.get("CZGH"));
				map_mzxx_all.put("MZLB", mzlb);
//					map_mzxx_all.put("SYB",
//							-ObjectToTypes.parseDouble(map_mzxx_zf.get("SYB")));
//					map_mzxx_all.put("SZYB",
//							-ObjectToTypes.parseDouble(map_mzxx_zf.get("SJYB")));
				map_mzxx_all.put("ZJJE", -ObjectToTypes.parseDouble(map_mzxx_zf.get("ZJJE")));
				map_mzxx_all.put("XJJE", -ObjectToTypes.parseDouble(map_mzxx_zf.get("XJJE")));
				map_mzxx_all.put("ZPJE", -ObjectToTypes.parseDouble(map_mzxx_zf.get("ZPJE")));
				map_mzxx_all.put("QTYS", -ObjectToTypes.parseDouble(map_mzxx_zf.get("QTYS")));
				if (map_mzxx_zf.get("JCJE") == null) {
					map_mzxx_zf.put("JJZFJE", 0.00);
				} else {
					map_mzxx_zf.put("JJZFJE", -ObjectToTypes.parseDouble(map_mzxx_zf.get("JCJE")));
				}
				map_mzxx_all.put("JJZFJE", -ObjectToTypes.parseDouble(map_mzxx_zf.get("JJZFJE")));
				map_mzxx_all.put("HBWC", -ObjectToTypes.parseDouble(map_mzxx_zf.get("HBWC")));
				map_mzxx_all.put("FPZS", ObjectToTypes.parseInt(map_mzxx_zf.get("FPZS")));
				map_mzxx_all.put("ZFZS", ObjectToTypes.parseInt(map_mzxx_zf.get("FPZS")));
				map_mzxx_all.put("ZFJE", ObjectToTypes.parseDouble(map_mzxx_zf.get("ZJJE")));
			}
			zfje = ObjectToTypes.parseDouble(map_mzxx_zf.get("ZJJE"));
		}
		if (map_mzxx_all.size() > 0) {
			map_mzxx_all.put("JZRQ", jzrq);
			map_mzxx_all.put("JGID", jgid);
			map_mzxx_all.put("ZFZF", 0.0);
			qtys = qtys + ObjectToTypes.parseDouble(map_mzxx_all.get("QTYS"));
			jjzfje = jjzfje + ObjectToTypes.parseDouble(map_mzxx_all.get("JJZFJE"));
			if (map_mzxx_all.get("FPZS") != null) {
				fpzs = fpzs + Integer.parseInt(map_mzxx_all.get("FPZS").toString());
			}
		}

		List<Map<String, Object>> list_sfmx = opMzxxDao.doQuerySfmx(parameters);
		logger.info("list_sfmx=" + list_sfmx);
		List<Map<String, Object>> list_sfmx_zf = opMzxxDao.doQuerySfmxZf(parameters);

		if (list_sfmx != null && list_sfmx.size() != 0) {
			for (int i = 0; i < list_sfmx.size(); i++) {
				Map<String, Object> map_sfmx = new CaseInsensitiveMap<String, Object>(list_sfmx.get(i));
				Map<String, Object> map_sfmx_all = new HashMap<String, Object>();
				map_sfmx_all.put("SFXM", map_sfmx.get("SFXM"));
				map_sfmx_all.put("CZGH", uid);
				map_sfmx_all.put("SFJE", ObjectToTypes.parseDouble(map_sfmx.get("ZJJE")));
				map_sfmx_all.put("JGID", jgid);
				map_sfmx_all.put("JZRQ", jzrq);
				if (list_sfmx_zf != null && list_sfmx_zf.size() != 0) {
					for (int J = 0; J < list_sfmx_zf.size(); J++) {
						Map<String, Object> map_sfmx_zf = list_sfmx_zf.get(J);
						if (map_sfmx_zf.containsKey("SFXM")) {
							if (Long.parseLong(map_sfmx.get("SFXM") + "") == Long
									.parseLong(map_sfmx_zf.get("SFXM") + "")) {
								map_sfmx_all.put("SFJE", ObjectToTypes.parseDouble(map_sfmx_all.get("SFJE"))
										- ObjectToTypes.parseDouble(map_sfmx_zf.get("ZJJE")));
								list_sfmx_zf.remove(J);
								J--;
							}
						}
					}
				}
				list_rbmx.add(map_sfmx_all);
			}
			if (list_sfmx_zf != null && list_sfmx_zf.size() != 0) {
				for (int i = 0; i < list_sfmx_zf.size(); i++) {
					Map<String, Object> map_sfmx_zf = new CaseInsensitiveMap<String, Object>(list_sfmx_zf.get(i));
					if (map_sfmx_zf.containsKey("SFXM")) {
						Map<String, Object> map_sfmx_all = new HashMap<String, Object>();
						map_sfmx_all.put("SFXM", map_sfmx_zf.get("SFXM"));
						map_sfmx_all.put("CZGH", uid);
						map_sfmx_all.put("SFJE", -ObjectToTypes.parseDouble(map_sfmx_zf.get("ZJJE")));
						map_sfmx_all.put("JGID", jgid);
						map_sfmx_all.put("JZRQ", jzrq);
						list_rbmx.add(map_sfmx_all);
						list_sfmx_zf.remove(i);
						i--;
					}
				}
			}

		} else {
			if (list_sfmx_zf != null && list_sfmx_zf.size() != 0) {
				for (int k = 0; k < list_sfmx_zf.size(); k++) {
					Map<String, Object> map_sfmx_zf = new CaseInsensitiveMap<String, Object>(list_sfmx_zf.get(k));
					Map<String, Object> map_sfmx_all = new HashMap<String, Object>();
					map_sfmx_all.put("SFXM", map_sfmx_zf.get("SFXM"));
					map_sfmx_all.put("CZGH", uid);
					map_sfmx_all.put("SFJE", -ObjectToTypes.parseDouble(map_sfmx_zf.get("ZJJE")));
					map_sfmx_all.put("JGID", jgid);
					map_sfmx_all.put("JZRQ", jzrq);
					list_rbmx.add(map_sfmx_all);
				}
			}
		}
		logger.info("list_rbmx=" + list_rbmx);
		if (list_rbmx.size() > 0) {
			for (Map<String, Object> map_rbmx : list_rbmx) {
				sfhj = sfhj + ObjectToTypes.parseDouble(map_rbmx.get("SFJE"));
			}
		}

		List<Map<String, Object>> list_sfxm_xz = opMzxxDao.doQueryXzmxFphm(parameters);
		List<Map<String, Object>> list_sfxm_xz_zf = opMzxxDao.doQueryXzmxZf(parameters);

		if (list_sfxm_xz != null && list_sfxm_xz.size() != 0) {
			for (int i = 0; i < list_sfxm_xz.size(); i++) {
				Map<String, Object> map_sfmx_xz = new CaseInsensitiveMap<String, Object>(list_sfxm_xz.get(i));
				Map<String, Object> map_xzmx_all = new HashMap<String, Object>();
				map_xzmx_all.put("BRXZ", map_sfmx_xz.get("BRXZ"));
				map_xzmx_all.put("SFJE", ObjectToTypes.parseDouble(map_sfmx_xz.get("ZJJE")));
				map_xzmx_all.put("FPZS", ObjectToTypes.parseInt(map_sfmx_xz.get("FPZS")));
				map_xzmx_all.put("JGID", jgid);
				map_xzmx_all.put("JZRQ", jzrq);
				map_xzmx_all.put("CZGH", uid);
				if (list_sfxm_xz_zf != null && list_sfxm_xz_zf.size() != 0) {
					for (int J = 0; J < list_sfxm_xz_zf.size(); J++) {
						Map<String, Object> map_sfmx_xz_zf = list_sfxm_xz_zf.get(J);
						if (map_sfmx_xz_zf.containsKey("BRXZ")) {
							if (Long.parseLong(map_sfmx_xz.get("BRXZ") + "") == Long
									.parseLong(map_sfmx_xz_zf.get("BRXZ") + "")) {
								map_xzmx_all.put("SFJE", ObjectToTypes.parseDouble(map_xzmx_all.get("SFJE"))
										- ObjectToTypes.parseDouble(map_sfmx_xz_zf.get("ZJJE")));
								list_sfxm_xz_zf.remove(J);
								J--;
							}
						}
					}
				}
				list_xzmx.add(map_xzmx_all);
			}

			if (list_sfxm_xz_zf != null && list_sfxm_xz_zf.size() != 0) {
				for (int J = 0; J < list_sfxm_xz_zf.size(); J++) {
					Map<String, Object> map_sfmx_xz_zf = new CaseInsensitiveMap<String, Object>(list_sfxm_xz_zf.get(J));
					if (map_sfmx_xz_zf.containsKey("BRXZ")) {
						Map<String, Object> map_xzmx_all = new HashMap<String, Object>();
						map_xzmx_all.put("BRXZ", map_sfmx_xz_zf.get("BRXZ"));
						map_xzmx_all.put("SFJE", -ObjectToTypes.parseDouble(map_sfmx_xz_zf.get("ZJJE")));
						map_xzmx_all.put("FPZS", map_sfmx_xz_zf.get("FPZS"));
						map_xzmx_all.put("JGID", jgid);
						map_xzmx_all.put("JZRQ", jzrq);
						map_xzmx_all.put("CZGH", uid);
						list_sfxm_xz_zf.remove(J);
						list_xzmx.add(map_xzmx_all);
						J--;
					}
				}
			}
		} else {
			if (list_sfxm_xz_zf != null && list_sfxm_xz_zf.size() != 0) {
				for (int k = 0; k < list_sfxm_xz_zf.size(); k++) {
					Map<String, Object> map_sfmx_xz_zf = new CaseInsensitiveMap<String, Object>(list_sfxm_xz_zf.get(k));
					Map<String, Object> map_xzmx_all = new HashMap<String, Object>();
					map_xzmx_all.put("BRXZ", map_sfmx_xz_zf.get("BRXZ"));
					map_xzmx_all.put("CZGH", uid);
					map_xzmx_all.put("SFJE", -ObjectToTypes.parseDouble(map_sfmx_xz_zf.get("ZJJE")));
					map_xzmx_all.put("JGID", jgid);
					map_xzmx_all.put("JZRQ", jzrq);
					map_xzmx_all.put("FPZS", -ObjectToTypes.parseInt(map_sfmx_xz_zf.get("FPZS")));
					list_xzmx.add(map_xzmx_all);
				}
			}
		}
		List<Map<String, Object>> list_fkmx = opMzxxDao.doQueryFkxx(parameters);
		List<Map<String, Object>> list_fkmx_zf = opMzxxDao.doQueryFkzfxx(parameters);
		double smk = 0.00;
		double smkzf = 0.00;
		if (list_fkmx != null && list_fkmx.size() != 0) {
			for (int i = 0; i < list_fkmx.size(); i++) {
				Map<String, Object> map_fkxx = new CaseInsensitiveMap<String, Object>(list_fkmx.get(i));
				Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
				map_fkxx_all.put("FKFS", map_fkxx.get("FKFS"));
				if (ObjectToTypes.parseInt(map_fkxx.get("FKFS")) == 1) {
					smk += ObjectToTypes.parseDouble(map_fkxx.get("FKJE"));
				}
				map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx.get("FKJE")));
				map_fkxx_all.put("CZGH", uid);
				map_fkxx_all.put("JGID", jgid);
				map_fkxx_all.put("JZRQ", jzrq);
				if (list_fkmx_zf != null && list_fkmx_zf.size() != 0) {
					for (int J = 0; J < list_fkmx_zf.size(); J++) {
						Map<String, Object> map_fkxx_zf = list_fkmx_zf.get(J);
						if (map_fkxx_zf.containsKey("FKFS")) {
							if (Long.parseLong(map_fkxx.get("FKFS") + "") == Long
									.parseLong(map_fkxx_zf.get("FKFS") + "")) {
								map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx_all.get("FKJE"))
										- ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE")));
								list_fkmx_zf.remove(J);
								J--;
							}
						}
					}
				}
				list_sfrb_fkmx.add(map_fkxx_all);
			}
			if (list_fkmx_zf != null && list_fkmx_zf.size() != 0) {
				for (int J = 0; J < list_fkmx_zf.size(); J++) {
					Map<String, Object> map_fkxx_zf = new CaseInsensitiveMap<String, Object>(list_fkmx_zf.get(J));
					Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
					map_fkxx_all.put("FKFS", map_fkxx_zf.get("FKFS"));
					if (ObjectToTypes.parseInt(map_fkxx_zf.get("FKFS")) == 1) {
						smkzf += ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE"));
					}
					map_fkxx_all.put("FKJE", -ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE")));
					map_fkxx_all.put("CZGH", uid);
					map_fkxx_all.put("JGID", jgid);
					map_fkxx_all.put("JZRQ", jzrq);
					list_fkmx_zf.remove(J);
					list_sfrb_fkmx.add(map_fkxx_all);
					J--;
				}
			}
		} else {
			if (list_fkmx_zf != null && list_fkmx_zf.size() != 0) {
				for (int k = 0; k < list_fkmx_zf.size(); k++) {
					Map<String, Object> map_fkxx_zf = new CaseInsensitiveMap<String, Object>(list_fkmx_zf.get(k));
					Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
					map_fkxx_all.put("FKFS", map_fkxx_zf.get("FKFS"));
					map_fkxx_all.put("CZGH", uid);
					map_fkxx_all.put("FKJE", -ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE")));
					map_fkxx_all.put("JGID", jgid);
					map_fkxx_all.put("JZRQ", jzrq);
					list_sfrb_fkmx.add(map_fkxx_all);
				}
			}
		}
		if (smk != 0.00) {
			map_mzxx_all.put("SMK", smk - smkzf);
		}
//			hql_fpxx.append("select FPHM as FPHM,nvl(FPZS,1) as FPZS from OP_MZXX where JGID = :jgid  and MZLB = :mzlb and CZGH = :czgh and JZRQ is null");
//			hql_zffpxx
//					.append("select a.FPHM as FPHM,nvl(b.FPZS,1) as FPZS from OP_ZFFP a,OP_MZXX b where a.MZXH=b.MZXH and a.JGID = :jgid  and a.MZLB = :mzlb and a.CZGH = :czgh and a.JZRQ is null");
//			hql_zffpxx
//			.append("select a.FPHM as FPHM,nvl(b.FPZS,1) as FPZS from OP_ZFFP a,OP_MZXX b where a.MZXH=b.MZXH and a.JGID = :jgid  and a.MZLB = :mzlb and a.CZGH = :czgh and a.JZRQ is null");
//			hql_zffpxx.append("select a.FPHM as FPHM,nvl(b.FPZS,1) as FPZS,b.ZFJE as ZFJE,b.BRXM as BRXM from OP_ZFFP a,OP_MZXX b where a.MZXH=b.MZXH and a.JGID = :jgid  and a.MZLB = :mzlb and a.CZGH = :czgh and a.JZRQ is null order by a.FPHM");
		List<Map<String, Object>> list_fpxx = opMzxxDao.doQueryFpxxRb(parameters);
		logger.info("list_fpxx=" + list_fpxx);
		List<Map<String, Object>> addlist_fpxx = new ArrayList<Map<String, Object>>();

		int fpzsSum = 0; // 总发票张数
		for (int i = 0; i < list_fpxx.size(); i++) {
			Map<String, Object> map_fpxx = new CaseInsensitiveMap<String, Object>(list_fpxx.get(i));
			fpzsSum += Long.parseLong(map_fpxx.get("FPZS") + "");
			Object Lb = map_fpxx.get("Lb");

			if (Long.parseLong(map_fpxx.get("FPZS") + "") > 1) {
				for (int j = 1; j < Long.parseLong(map_fpxx.get("FPZS") + ""); j++) {
					String fphm = map_fpxx.get("FPHM") + "";
					int k = -1;
					for (int q = fphm.length() - 1; q >= 0; q--) {
						if (fphm.charAt(q) < '0' || fphm.charAt(q) > '9') {
							k = q;
							break;
						}
					}
					String fphmzm = fphm.substring(0, k + 1);
					String fphmsz = fphm.substring(k + 1);
					fphm = fphmzm + String.format("%0" + fphmsz.length() + "d", Long.parseLong(fphmsz + "") + j);
					Map<String, Object> fphm_map = new HashMap<String, Object>();
					fphm_map.put("FPHM", fphm);
					fphm_map.put("Lb", Lb);
					addlist_fpxx.add(fphm_map);
				}
			}
		}
		list_fpxx.addAll(addlist_fpxx);
//			List<Map<String, Object>> list_fpxx_num = gethmNUm(list_fpxx);
//			String fphmstr = gethmStr(list_fpxx);
		List<Map<String, Object>> list_zffpxx = opMzxxDao.doQueryFpxxRbZf(parameters);
//		List<Map<String, Object>> list_jczffpxx = opMzxxDao.doQueryJczffpxx(parameters);
		// TODO
//		List<Map<String, Object>> list_jjhjfpxx = opMzxxDao.doQueryJjhjfpxx(parameters);

//			List<Map<String, Object>> addlist_zffpxx = new ArrayList<Map<String,Object>>();
//			for(int i = 0 ; i < list_zffpxx.size(); i ++){
//				Map<String, Object> map_zffpxx = list_zffpxx.get(i);
//				if(Long.parseLong(map_zffpxx.get("FPZS")+"")>1){
//					for(int j = 1 ; j < Long.parseLong(map_zffpxx.get("FPZS")+"") ; j ++){
//						String fphm = map_zffpxx.get("FPHM")+"";
//						int k = -1 ;
//						for(int q = fphm.length()-1 ; q >= 0 ; q --){
//							if(fphm.charAt(q)<'0'||fphm.charAt(q)>'9'){
//								k = q;
//								break;
//							}
//						}
//						String fphmzm = fphm.substring(0, k+1);
//						String fphmsz = fphm.substring(k+1);
//						fphm = fphmzm+String.format("%0" + fphmsz.length() + "d", Long.parseLong(fphmsz+"")+j);
//						Map<String, Object> fphm_map = new HashMap<String, Object>();
//						fphm_map.put("FPHM", fphm);
//						addlist_zffpxx.add(fphm_map);
//					}
//				}
//			}
//			list_zffpxx.addAll(addlist_zffpxx);
//			List<Map<String, Object>> list_zffpxx_num = gethmNUm(list_zffpxx);
//			String fphmzfstr = gethmStr(list_zffpxx);

		if ("LB".equals(SQXTMS)) {
			if (list_fpxx != null && list_fpxx.size() > 0) {
				try {
					Collections.sort(list_fpxx, new Comparator<Map<String, Object>>() {
						@Override
						public int compare(Map<String, Object> map1, Map<String, Object> map2) {
							int LB1 = ObjectToTypes.toInt(map1.get("LB"));
							int LB2 = ObjectToTypes.toInt(map2.get("LB"));
							int n = LB1 - LB2;
							if (n == 0) {
								String fphm1 = (String) map1.get("FPHM");
								String fphm2 = (String) map2.get("FPHM");
								n = fphm1.compareTo(fphm2);
							}
							return n;
						}
					});
				} catch (RuntimeException e) {
					e.printStackTrace();
				}

				List list_fpxx0 = new ArrayList(); // 收费
				List list_fpxx1 = new ArrayList(); // 作废
				List list_fpxx2 = new ArrayList(); // 退号
				List list_fpxx3 = new ArrayList(); // 转科
				for (int i = 0; i < list_fpxx.size(); i++) {
					Map map = new CaseInsensitiveMap<String, Object>(list_fpxx.get(i));
					int lb = ObjectToTypes.toInt(map.get("LB"));
					if (lb == 0) {
						list_fpxx0.add(map);
					} else if (lb == 1) {
						list_fpxx1.add(map);
					} else if (lb == 2) {
						list_fpxx2.add(map);
					} else if (lb == 3) {
						list_fpxx3.add(map);
					}
				}

				String fphmstr0 = gethmStr(list_fpxx0);
				String fpxx0 = divisionFpxx(list_fpxx0, fphmstr0);

				String fphmstr1 = gethmStr(list_fpxx1);
				String fpxx1 = divisionFpxx(list_fpxx1, fphmstr1);

				String fphmstr2 = gethmStr(list_fpxx2);
				String fpxx2 = divisionFpxx(list_fpxx2, fphmstr2);

				String fphmstr3 = gethmStr(list_fpxx3);
				String fpxx3 = divisionFpxx(list_fpxx3, fphmstr3);

				fpxx += !"".equals(fpxx0) ? "收费:" + fpxx0 : "";
				fpxx += !"".equals(fpxx1) ? " 作废:" + fpxx1 : "";
				fpxx += !"".equals(fpxx2) ? " 退号:" + fpxx2 : "";
				fpxx += !"".equals(fpxx3) ? " 转科:" + fpxx3 : "";

			}
		} else {
			if (list_fpxx != null && list_fpxx.size() > 0) {
				Collections.sort(list_fpxx, new Comparator<Map<String, Object>>() {

					@Override
					public int compare(Map<String, Object> map1, Map<String, Object> map2) {
						String fphm1 = (String) map1.get("FPHM");
						String fphm2 = (String) map2.get("FPHM");
						return fphm1.compareTo(fphm2);
					}
				});

				String fphmstr = gethmStr(list_fpxx);
				fpxx =

						divisionFpxx(list_fpxx, fphmstr);
			}
		}

		if (list_zffpxx != null && list_zffpxx.size() > 0) {
			zffpxx.append("退费:");
			for (int i = 0; i < list_zffpxx.size(); i++) {
				Map<String, Object> thfp_map = new CaseInsensitiveMap<String, Object>(list_zffpxx.get(i));
//					zffpxx.append(thfp_map.get("FPHM")+"("+thfp_map.get("BRXM")+","+thfp_map.get("ZFJE")+") ");
				zffpxx.append(thfp_map.get("FPHM") + "(" + thfp_map.get("BRXM") + "," + thfp_map.get("FKMC") + ":"
						+ thfp_map.get("FKJE") + ") ");
			}
		}
//		if (list_jczffpxx != null && list_jczffpxx.size() > 0) {
//			zffpxx.append("家床:");
//			for (int i = 0; i < list_jczffpxx.size(); i++) {
//				Map<String, Object> thfp_map = new CaseInsensitiveMap<String, Object>(list_jczffpxx.get(i));
//				zffpxx.append(thfp_map.get("FPHM") + "(" + thfp_map.get("BRXM") + "," + thfp_map.get("FKMC") + ":"
//						+ thfp_map.get("FKJE") + ") ");
//			}
//		}

		// TODO
//		if (list_jjhjfpxx != null && list_jjhjfpxx.size() > 0) {
//			zffpxx.append("居家护理:");
//			for (int i = 0; i < list_jjhjfpxx.size(); i++) {
//				Map<String, Object> thfp_map = new CaseInsensitiveMap<String, Object>(list_jjhjfpxx.get(i));
//				zffpxx.append(thfp_map.get("FPHM") + "(" + thfp_map.get("BRXM") + "," + thfp_map.get("FKMC") + ":"
//						+ thfp_map.get("FKJE") + ") ");
//			}
//		}

		if (map_mzxx_all != null && map_mzxx_all.size() > 0) {
			map_mzxx_all.put("QZPJ", fpxx);
			map_mzxx_all.put("ZFFP", zffpxx.toString());
			map_mzxx_all.put("ZFJE", zfje);
		}

		List<Map<String, Object>> map_ghmxlist = opMzxxDao.doQueryGhmxRb(parameters);
		Map<String, Object> map_ghmx = new HashMap<String, Object>();
		if (map_ghmxlist.size() > 0) {
			map_ghmx = new CaseInsensitiveMap<String, Object>(map_ghmxlist.get(0));
		}
		if (map_ghmx != null && map_ghmx.size() > 0) {
			map_ghrb_all.put("CZGH", map_ghmx.get("CZGH"));
			map_ghrb_all.put("MZLB", mzlb);
			map_ghrb_all.put("ZJJE", ObjectToTypes.parseDouble(map_ghmx.get("ZJJE")));
//				map_ghrb_all.put("SYB", ObjectToTypes.parseDouble(map_ghmx.get("SYB")));
//				map_ghrb_all.put("SJYB", ObjectToTypes.parseDouble(map_ghmx.get("SJYB")));
			map_ghrb_all.put("XJJE", ObjectToTypes.parseDouble(map_ghmx.get("XJJE")));
			map_ghrb_all.put("ZPJE", ObjectToTypes.parseDouble(map_ghmx.get("ZPJE")));
			map_ghrb_all.put("QTYS", ObjectToTypes.parseDouble(map_ghmx.get("QTYS")));
			map_ghrb_all.put("HBWC", ObjectToTypes.parseDouble(map_ghmx.get("HBWC")));
			map_ghrb_all.put("FPZS", ObjectToTypes.parseInt(map_ghmx.get("FPZS")));
			map_ghrb_all.put("THJE", 0.0);
			map_ghrb_all.put("THSL", 0);
			map_ghrb_all.put("JGID", jgid);
		}

		List<Map<String, Object>> map_ghthmxlist = opMzxxDao.doQueryGhthmx(parameters);
		Map<String, Object> map_ghthmx = new HashMap<String, Object>();
		if (map_ghthmxlist.size() > 0) {
			map_ghthmx = new CaseInsensitiveMap<String, Object>(map_ghthmxlist.get(0));
		}
		if (map_ghthmx != null && map_ghthmx.size() > 0) {
			if (map_ghrb_all.size() > 0) {
				map_ghrb_all.put("ZJJE", ObjectToTypes.parseDouble(map_ghrb_all.get("ZJJE"))
						- ObjectToTypes.parseDouble(map_ghthmx.get("ZJJE")));
				map_ghrb_all.put("XJJE", ObjectToTypes.parseDouble(map_ghrb_all.get("XJJE"))
						- ObjectToTypes.parseDouble(map_ghthmx.get("XJJE")));
				map_ghrb_all.put("ZPJE", ObjectToTypes.parseDouble(map_ghrb_all.get("ZPJE"))
						- ObjectToTypes.parseDouble(map_ghthmx.get("ZPJE")));
				map_ghrb_all.put("QTYS", ObjectToTypes.parseDouble(map_ghrb_all.get("QTYS"))
						- ObjectToTypes.parseDouble(map_ghthmx.get("QTYS")));
				map_ghrb_all.put("HBWC", ObjectToTypes.parseDouble(map_ghrb_all.get("HBWC"))
						- ObjectToTypes.parseDouble(map_ghthmx.get("HBWC")));
//					map_ghrb_all.put("SYB",
//							ObjectToTypes.parseDouble(map_ghrb_all.get("SYB"))
//									- ObjectToTypes.parseDouble(map_ghthmx.get("SYB")));
//					map_ghrb_all.put("SZYB",
//							ObjectToTypes.parseDouble(map_ghrb_all.get("SJYB"))
//									- ObjectToTypes.parseDouble(map_ghthmx.get("SJYB")));
				map_ghrb_all.put("THJE", ObjectToTypes.parseDouble(map_ghrb_all.get("THJE"))
						+ ObjectToTypes.parseDouble(map_ghthmx.get("ZJJE")));
				map_ghrb_all.put("THSL", ObjectToTypes.parseInt(map_ghrb_all.get("THSL"))
						+ ObjectToTypes.parseInt(map_ghthmx.get("THSL")));
			} else {
				map_ghrb_all.put("CZGH", map_ghthmx.get("CZGH"));
				map_ghrb_all.put("MZLB", mzlb);
//					map_ghrb_all
//							.put("SYB", -ObjectToTypes.parseDouble(map_ghthmx.get("SYB")));
//					map_ghrb_all.put("SZYB",
//							-ObjectToTypes.parseDouble(map_ghthmx.get("SJYB")));
				map_ghrb_all.put("ZJJE", -ObjectToTypes.parseDouble(map_ghthmx.get("ZJJE")));
				map_ghrb_all.put("XJJE", -ObjectToTypes.parseDouble(map_ghthmx.get("XJJE")));
				map_ghrb_all.put("ZPJE", -ObjectToTypes.parseDouble(map_ghthmx.get("ZPJE")));
				map_ghrb_all.put("QTYS", -ObjectToTypes.parseDouble(map_ghthmx.get("QTYS")));
				map_ghrb_all.put("HBWC", -ObjectToTypes.parseDouble(map_ghthmx.get("HBWC")));
				map_ghrb_all.put("THJE", ObjectToTypes.parseDouble(map_ghthmx.get("ZJJE")));
				map_ghrb_all.put("THSL", ObjectToTypes.parseInt(map_ghthmx.get("THSL")));
				map_ghrb_all.put("JGID", jgid);
				map_ghrb_all.put("FPZS", 0);
			}
		}
		if (map_ghrb_all.size() > 0) {
			map_ghrb_all.put("JZRQ", jzrq);
			qtys = qtys + ObjectToTypes.parseDouble(map_ghrb_all.get("QTYS"));
		}
		List<Map<String, Object>> list_grmx = opMzxxDao.doQueryGrmxRb(parameters);
		List<Map<String, Object>> list_grthmx = opMzxxDao.doQueryGrthmx(parameters);
		if (list_grmx != null && list_grmx.size() != 0) {
			for (int i = 0; i < list_grmx.size(); i++) {
				Map<String, Object> map_grmx = new CaseInsensitiveMap<String, Object>(list_grmx.get(i));
				Map<String, Object> map_grmx_all = new HashMap<String, Object>();
				map_grmx_all.put("BRXZ", map_grmx.get("BRXZ"));
				map_grmx_all.put("CZGH", uid);
				map_grmx_all.put("FPZS", ObjectToTypes.parseInt(map_grmx.get("GHRC")));
				map_grmx_all.put("SFJE", ObjectToTypes.parseDouble(map_grmx.get("ZJJE")));
				map_grmx_all.put("GHJE", ObjectToTypes.parseDouble(map_grmx.get("GHJE")));
				map_grmx_all.put("ZLJE", ObjectToTypes.parseDouble(map_grmx.get("ZLJE")));
				map_grmx_all.put("ZJFY", ObjectToTypes.parseDouble(map_grmx.get("ZJFY")));
				map_grmx_all.put("BLJE", ObjectToTypes.parseDouble(map_grmx.get("BLJE")));
				map_grmx_all.put("JGID", jgid);
				map_grmx_all.put("JZRQ", jzrq);
				map_grmx_all.put("XM", map_grmx.get("XM") + "");
				if (list_grthmx != null && list_grthmx.size() != 0) {
					for (int J = 0; J < list_grthmx.size(); J++) {
						Map<String, Object> map_grthmx = new CaseInsensitiveMap<String, Object>(list_grthmx.get(J));
						if (map_grthmx.containsKey("BRXZ")) {
							if (Long.parseLong(map_grmx.get("BRXZ") + "") == Long
									.parseLong(map_grthmx.get("BRXZ") + "")) {
								map_grmx_all.put("SFJE", ObjectToTypes.parseDouble(map_grmx_all.get("SFJE"))
										- ObjectToTypes.parseDouble(map_grthmx.get("ZJJE")));
								map_grmx_all.put("GHJE", ObjectToTypes.parseDouble(map_grmx_all.get("GHJE"))
										- ObjectToTypes.parseDouble(map_grthmx.get("GHJE")));
								map_grmx_all.put("ZLJE", ObjectToTypes.parseDouble(map_grmx_all.get("ZLJE"))
										- ObjectToTypes.parseDouble(map_grthmx.get("ZLJE")));
								map_grmx_all.put("ZJFY", (Double) map_grmx_all.get("ZJFY")
										- ObjectToTypes.parseDouble(map_grthmx.get("ZJFY")));
								map_grmx_all.put("BLJE", ObjectToTypes.parseDouble(map_grmx_all.get("BLJE"))
										- ObjectToTypes.parseDouble(map_grthmx.get("BLJE")));
								list_grthmx.remove(J);
								J--;
							}
						}
					}
				}
				list_ghrbmx.add(map_grmx_all);
			}

			if (list_grthmx != null && list_grthmx.size() != 0)

			{
				for (int J = 0; J < list_grthmx.size(); J++) {
					Map<String, Object> map_grthmx = new CaseInsensitiveMap<String, Object>(list_grthmx.get(J));
					if (map_grthmx.containsKey("BRXZ")) {
						Map<String, Object> map_grmx_all = new HashMap<String, Object>();
						map_grmx_all.put("CZGH", uid);
						map_grmx_all.put("JGID", jgid);
						map_grmx_all.put("JZRQ", jzrq);
						map_grmx_all.put("FPZS", ObjectToTypes.parseInt(map_grthmx.get("GHRC")));
						map_grmx_all.put("SFJE", -ObjectToTypes.parseDouble(map_grthmx.get("ZJJE") + ""));
						map_grmx_all.put("GHJE", -ObjectToTypes.parseDouble(map_grthmx.get("GHJE") + ""));
						map_grmx_all.put("ZLJE", -ObjectToTypes.parseDouble(map_grthmx.get("ZLJE") + ""));
						map_grmx_all.put("ZJFY", -ObjectToTypes.parseDouble(map_grthmx.get("ZJFY") + ""));
						map_grmx_all.put("BLJE", -ObjectToTypes.parseDouble(map_grthmx.get("BLJE") + ""));
						map_grmx_all.put("BRXZ", map_grthmx.get("BRXZ"));
						map_grmx_all.put("XM", map_grthmx.get("XM") + "");
						list_grthmx.remove(J);
						list_ghrbmx.add(map_grmx_all);
						J--;
					}
				}
			}

		} else {
			if (list_grthmx != null && list_grthmx.size() != 0) {
				for (int k = 0; k < list_grthmx.size(); k++) {
					Map<String, Object> map_grthmx = new CaseInsensitiveMap<String, Object>(list_grthmx.get(k));
					Map<String, Object> map_grmx_all = new HashMap<String, Object>();
					map_grmx_all.put("BRXZ", map_grthmx.get("BRXZ"));
					map_grmx_all.put("CZGH", uid);
					map_grmx_all.put("FPZS", -ObjectToTypes.parseInt(map_grthmx.get("GHRC")));
					map_grmx_all.put("SFJE", -ObjectToTypes.parseDouble(map_grthmx.get("ZJJE") + ""));
					map_grmx_all.put("GHJE", -ObjectToTypes.parseDouble(map_grthmx.get("GHJE") + ""));
					map_grmx_all.put("ZLJE", -ObjectToTypes.parseDouble(map_grthmx.get("ZLJE") + ""));
					map_grmx_all.put("ZJFY", -ObjectToTypes.parseDouble(map_grthmx.get("ZJFY") + ""));
					map_grmx_all.put("BLJE", -ObjectToTypes.parseDouble(map_grthmx.get("BLJE") + ""));
					map_grmx_all.put("JGID", jgid);
					map_grmx_all.put("JZRQ", jzrq);
					map_grmx_all.put("XM", map_grthmx.get("XM") + "");
					list_ghrbmx.add(map_grmx_all);
				}
			}
		}
		if (list_ghrbmx.size() > 0) {
			for (Map<String, Object> map_rbmx : list_ghrbmx) {
				ghhj = ghhj + ObjectToTypes.parseDouble(map_rbmx.get("SFJE") + "");
				ghje = ghje + ObjectToTypes.parseDouble(map_rbmx.get("GHJE") + "");
				zlje = zlje + ObjectToTypes.parseDouble(map_rbmx.get("ZLJE") + "");
				blje = blje + ObjectToTypes.parseDouble(map_rbmx.get("BLJE") + "");
				zjfy = zjfy + ObjectToTypes.parseDouble(map_rbmx.get("ZJFY") + "");
			}
		}

		List<Map<String, Object>> list_ghfkmx = opMzxxDao.doQueryGhFkxxRb(parameters);
		List<Map<String, Object>> list_ghfkmx_zf = opMzxxDao.doQueryGhfkzfxx(parameters);
		if (list_ghfkmx != null && list_ghfkmx.size() != 0) {
			for (int i = 0; i < list_ghfkmx.size(); i++) {
				Map<String, Object> map_fkxx = new CaseInsensitiveMap<String, Object>(list_ghfkmx.get(i));
				Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
				map_fkxx_all.put("FKFS", map_fkxx.get("FKFS"));
				map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx.get("FKJE")));
				map_fkxx_all.put("CZGH", uid);
				map_fkxx_all.put("JGID", jgid);
				map_fkxx_all.put("JZRQ", jzrq);
				if (list_ghfkmx_zf != null && list_ghfkmx_zf.size() != 0) {
					for (int J = 0; J < list_ghfkmx_zf.size(); J++) {
						Map<String, Object> map_fkxx_zf = list_ghfkmx_zf.get(J);
						if (map_fkxx_zf.containsKey("FKFS")) {
							if (Long.parseLong(map_fkxx.get("FKFS") + "") == Long
									.parseLong(map_fkxx_zf.get("FKFS") + "")) {
								map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx_all.get("FKJE") + "")
										- ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE") + ""));
								list_ghfkmx_zf.remove(J);
								J--;
							}
						}
					}
				}
				list_ghrb_fkmx.add(map_fkxx_all);
			}

			if (list_ghfkmx_zf != null && list_ghfkmx_zf.size() != 0) {
				for (int J = 0; J < list_ghfkmx_zf.size(); J++) {
					Map<String, Object> map_fkxx_zf = new CaseInsensitiveMap<String, Object>(list_ghfkmx_zf.get(J));
					if (map_fkxx_zf.containsKey("FKFS")) {
						Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
						map_fkxx_all.put("FKFS", map_fkxx_zf.get("FKFS"));
						map_fkxx_all.put("FKJE", -ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE") + ""));
						map_fkxx_all.put("CZGH", uid);
						map_fkxx_all.put("JGID", jgid);
						map_fkxx_all.put("JZRQ", jzrq);
						list_ghrb_fkmx.add(map_fkxx_all);
						list_ghfkmx_zf.remove(J);
						J--;
					}
				}
			}

		} else {
			if (list_ghfkmx_zf != null && list_ghfkmx_zf.size() != 0) {
				for (int k = 0; k < list_ghfkmx_zf.size(); k++) {
					Map<String, Object> map_fkxx_zf = new CaseInsensitiveMap<String, Object>(list_ghfkmx_zf.get(k));
					Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
					map_fkxx_all.put("FKFS", map_fkxx_zf.get("FKFS"));
					map_fkxx_all.put("CZGH", uid);
					map_fkxx_all.put("FKJE", -ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE") + ""));
					map_fkxx_all.put("JGID", jgid);
					map_fkxx_all.put("JZRQ", jzrq);
					list_ghrb_fkmx.add(map_fkxx_all);
				}
			}
		}
//			hql_jzhm.append("select JZHM as PJHM from OP_GHMX where JGID = :jgid  and MZLB = :mzlb and CZGH = :czgh and JZRQ is null and JZHM not like 'MGH%'");

//			hql_jzhm_zf
//			.append("select gh.JZHM as PJHM,gh.XJJE as XJJE,c.BRXM as BRXM from OP_GHMX gh,OP_THMX th,MPI_BRDA c where gh.BRID=c.BRID and gh.JZHM not like 'MGH%' and gh.SBXH = th.SBXH and th.JGID = :jgid  and th.MZLB = :mzlb and th.CZGH = :czgh and th.JZRQ is null order by gh.JZHM");
//			List<Map<String, Object>> list_jzhm = dao.doQuery(
//					hql_jzhm.toString(), parameters);
		List<Map<String, Object>> list_jzhm_zf = opMzxxDao.doQueryJzhmZfRb(parameters);
//			String beginjzhm = "";
//			String endjzhm = "";
//			long currentjzhm = 0;
//			if (list_jzhm != null && list_jzhm.size() > 0) {
//				try {
//					Collections.sort(list_jzhm,
//							new Comparator<Map<String, Object>>() {
//								@Override
//								public int compare(Map<String, Object> map1,
//										Map<String, Object> map2) {
//									String jzhm1 = (String) map1.get("PJHM");
//									String jzhm2 = (String) map2.get("PJHM");
//									return jzhm1.compareTo(jzhm2);
//								}
//							});
//				} catch (RuntimeException e) {
//					e.printStackTrace();
//				}
//				for (int i = 0; i < list_jzhm.size(); i++) {
//					Map<String, Object> map_jzxx = list_jzhm.get(i);
//					if (i == 0) {
//						beginjzhm = map_jzxx.get("PJHM").toString();
//						currentjzhm = Long.parseLong(map_jzxx.get("PJHM")
//								.toString());
//					}
//					if (Long.parseLong(map_jzxx.get("PJHM").toString()) != currentjzhm) {
//						endjzhm = list_jzhm.get(i - 1).get("PJHM").toString();
//						jzhmxx = InvoiceSequence(jzhmxx, beginjzhm, endjzhm);
//						beginjzhm = map_jzxx.get("PJHM").toString();
//						currentjzhm = Long.parseLong(map_jzxx.get("PJHM")
//								.toString());
//					}
//					currentjzhm++;
//				}
//				endjzhm = list_jzhm.get(list_jzhm.size() - 1).get("PJHM")
//						.toString();
//				jzhmxx = InvoiceSequence(jzhmxx, beginjzhm, endjzhm);
//			}

		if (list_jzhm_zf != null && list_jzhm_zf.size() > 0) {
//				try {
//					Collections.sort(list_jzhm_zf,
//							new Comparator<Map<String, Object>>() {
//								@Override
//								public int compare(Map<String, Object> map1,
//										Map<String, Object> map2) {
//									String jzhm1 = (String) map1.get("PJHM");
//									String jzhm2 = (String) map2.get("PJHM");
//									return jzhm1.compareTo(jzhm2);
//								}
//							});
//				} catch (RuntimeException e) {
//					e.printStackTrace();
//				}
//				for (int i = 0; i < list_jzhm_zf.size(); i++) {
//					Map<String, Object> map_jzxx_zf = list_jzhm_zf.get(i);
//					if (i == 0) {
//						beginjzhm = map_jzxx_zf.get("PJHM").toString();
//						currentjzhm = Long.parseLong(map_jzxx_zf.get("PJHM")
//								.toString());
//					}
//					if (Long.parseLong(map_jzxx_zf.get("PJHM").toString()) != currentjzhm) {
//						endjzhm = list_jzhm_zf.get(i - 1).get("PJHM")
//								.toString();
//						thjzhmxx = InvoiceSequence(thjzhmxx, beginjzhm, endjzhm);
//						beginjzhm = map_jzxx_zf.get("PJHM").toString();
//						currentjzhm = Long.parseLong(map_jzxx_zf.get("PJHM")
//								.toString());
//					}
//					currentjzhm++;
//				}
//				endjzhm = list_jzhm_zf.get(list_jzhm_zf.size() - 1).get("PJHM")
//						.toString();
//				thjzhmxx = InvoiceSequence(thjzhmxx, beginjzhm, endjzhm);
		}
		thjzhmxx.append("退号:");
		for (int i = 0; i < list_jzhm_zf.size(); i++) {
			Map<String, Object> thfp_map = new CaseInsensitiveMap<String, Object>(list_jzhm_zf.get(i));
			thjzhmxx.append(thfp_map.get("PJHM") + "(" + thfp_map.get("BRXM") + "," + thfp_map.get("FKMC") + ":"
					+ thfp_map.get("FKJE") + ") ");
		}
		if (map_ghrb_all != null && map_ghrb_all.size() > 0) {
//				map_ghrb_all.put("QZPJ", jzhmxx);
			map_ghrb_all.put("THFP", thjzhmxx);
		}
		List<Map<String, Object>> list_sfrb_fkmx_copy = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list_ghrb_fkmx_copy = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list_fkmx_all = new ArrayList<Map<String, Object>>();

		list_sfrb_fkmx_copy.addAll(list_sfrb_fkmx);
		list_ghrb_fkmx_copy.addAll(list_ghrb_fkmx);
		if (list_sfrb_fkmx_copy != null && list_sfrb_fkmx_copy.size() != 0) {
			for (int i = 0; i < list_sfrb_fkmx_copy.size(); i++) {
				Map<String, Object> map_fkxx = new CaseInsensitiveMap<String, Object>(list_sfrb_fkmx_copy.get(i));
				Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
				map_fkxx_all.put("FKFS", map_fkxx.get("FKFS"));
				map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx.get("FKJE")));
				if (list_ghrb_fkmx_copy != null && list_ghrb_fkmx_copy.size() != 0) {
					for (int J = 0; J < list_ghrb_fkmx_copy.size(); J++) {
						Map<String, Object> map_fkxx_zf = list_ghrb_fkmx_copy.get(J);
						if (map_fkxx_zf.containsKey("FKFS")) {
							if (Long.parseLong(map_fkxx.get("FKFS") + "") == Long
									.parseLong(map_fkxx_zf.get("FKFS") + "")) {
								map_fkxx_all.put("FKJE", ObjectToTypes
										.parseDouble((ObjectToTypes.parseDouble(map_fkxx_all.get("FKJE") + "")
												+ ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE") + "")) + ""));
								list_ghrb_fkmx_copy.remove(J);
								J--;
							}
						}
					}
				}
				list_fkmx_all.add(map_fkxx_all);
			}

			if (list_ghrb_fkmx_copy != null && list_ghrb_fkmx_copy.size() != 0) {
				for (int J = 0; J < list_ghrb_fkmx_copy.size(); J++) {
					Map<String, Object> map_fkxx_zf = new CaseInsensitiveMap<String, Object>(
							list_ghrb_fkmx_copy.get(J));
					if (map_fkxx_zf.containsKey("FKFS")) {
						Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
						map_fkxx_all.put("FKFS", map_fkxx_zf.get("FKFS"));
						map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE") + ""));
						list_fkmx_all.add(map_fkxx_all);
						list_ghrb_fkmx_copy.remove(J);
						J--;
					}
				}
			}

		} else {
			if (list_ghrb_fkmx_copy != null && list_ghrb_fkmx_copy.size() != 0) {
				for (int k = 0; k < list_ghrb_fkmx_copy.size(); k++) {
					Map<String, Object> map_fkxx_zf = new CaseInsensitiveMap<String, Object>(
							list_ghrb_fkmx_copy.get(k));
					Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
					map_fkxx_all.put("FKFS", map_fkxx_zf.get("FKFS"));
					map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE") + ""));
					list_fkmx_all.add(map_fkxx_all);
				}
			}
		}

		if (list_fkmx_all.size() > 0) {
			for (Map<String, Object> map_fkxx : list_fkmx_all) {
				Map<String, Object> map_fkxxs = new HashMap<String, Object>();
				PubFkfsModel pubFkfs = pubFkfsService.getById(Integer.valueOf(map_fkxx.get("FKFS").toString()));
				map_fkxxs.put("FKFS", pubFkfs.getFkmc());
				fkxx = fkxx + map_fkxxs.get("FKFS") + ":" + String.format("%1$.2f", map_fkxx.get("FKJE"));
			}
		}
		// TODO 暂时注释掉
//		jcxm_list.addAll(opMzxxDao.doQuerySfje(parameters));

		// 转科发票信息
		int zkfps = 0; // 转科发票数
		StringBuilder ZKFP = new StringBuilder();
		// 挂号
		if (map_ghrb_all != null && map_ghrb_all.size() > 0) {
			List<Map<String, Object>> zkList = opMzxxDao.doQueryJzhmBrid(parameters);
			zkfps = zkList == null ? 0 : zkList.size();

			for (int i = 0; i < zkfps; i++) {
				Map m = new CaseInsensitiveMap<String, Object>(zkList.get(i));
				ZKFP.append(m.get("JZHM") + "（" + m.get("BRXM") + "） ");
			}

			int GHFPZS = ObjectToTypes.toInt(map_ghrb_all.get("FPZS")); // 发票总数
			GHFPZS = GHFPZS + zkfps;
			map_ghrb_all.put("ZKFP", ZKFP.toString());
			map_ghrb_all.put("ZKSL", zkfps);
			map_ghrb_all.put("FPZS", GHFPZS);
		}

		// 门诊
		if (map_mzxx_all != null && map_mzxx_all.size() > 0) {
			int MZFPZS = ObjectToTypes.toInt(map_mzxx_all.get("FPZS")); // 发票总数
			MZFPZS = MZFPZS == 0 ? fpzsSum : MZFPZS + zkfps;
			map_mzxx_all.put("ZKFP", ZKFP.toString());
			map_mzxx_all.put("ZKZS", zkfps);
			map_mzxx_all.put("FPZS", MZFPZS);
		}
	}

	@Transactional(rollbackFor = Exception.class)
	public Map<String, Object> doChargesFsbDailyParameters(java.util.Date jzrqDate, Map<String, Object> response,
			Integer jgid, Integer uid, String userName, String ip) {
		// 获得项目的绝对路径 并将路径值传进SUBREPORT_DIR中,
		// 因子报表SUBREPORT_DIR参数值在不同服务器上路径不同,所以用动态路径传值
//		String realPath = OrderCardsInjectionCard.class.getResource("/")
//				.getPath();
//		realPath = realPath.substring(1, realPath.indexOf("WEB-INF"));
//		String[] path = realPath.split("/");
//		String usePath = "";
//		for (int i = 0; i < path.length; i++) {
//			if (i == 0) {
//				usePath = path[i];
//			} else {
//				usePath += "\\" + path[i];
//			}
//		}
//		usePath = usePath.replace("%20", " ");
//		response.put("SUBREPORT_DIR", usePath
//				+ "\\WEB-INF\\classes\\phis\\prints\\jrxml\\");

		// 存收费日报明细OP_RBMX
		List<Map<String, Object>> list_rbmx = new ArrayList<Map<String, Object>>();
		// 存收费日报性质明细OP_XZMX
		List<Map<String, Object>> list_xzmx = new ArrayList<Map<String, Object>>();
		// 存收费日报付款明细OP_SFRB_FKMX
		List<Map<String, Object>> list_sfrb_fkmx = new ArrayList<Map<String, Object>>();
		// 存挂号日报付款明细OP_GHRB_FKMX
		List<Map<String, Object>> list_ghrb_fkmx = new ArrayList<Map<String, Object>>();
		Map<String, Object> map_mzxx_all = new HashMap<String, Object>();
		Map<String, Object> map_ghrb_all = new HashMap<String, Object>();
		List<Map<String, Object>> list_ghrbmx = new ArrayList<Map<String, Object>>();
		String fpxx = "";
		StringBuffer zffpxx = new StringBuffer();
//		String jzhmxx = "";
		StringBuffer thjzhmxx = new StringBuffer();
		String SQXTMS = sysXtcsCacheSer.getCsz(jgid, "SQXTMS");
		String jzrq = MzUtil.toString(jzrqDate, "yyyy-MM-dd HH:mm:ss");

		// setNowdate((String)request.get("jzrq"));
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("jgid", jgid);
		parameters.put("czgh", uid);
		parameters.put("JZRQ", jzrq);
		double sfhj = 0.0;
		String fkxx = "";
		String zfxx = "";
		double qtys = 0.0;
		double jjzfje = 0.0;
		double zfje = 0.0;
		int zfzs = 0;
		int fpzs = 0;
		double thje = 0.0;
		int thsl = 0;
		String thxx = "";
		double ghhj = 0.0;
		double ghje = 0.0;
		double zlje = 0.0;
		double blje = 0.0;
		double zjfy = 0.0;
		Integer mzlb = opMzlbSer.getMzlb(jgid, ip);
		parameters.put("mzlb", mzlb);

		StringBuffer hql_mzxx = new StringBuffer();// 统计收费信息OP_MZXX
		StringBuffer hql_mzxx_zf = new StringBuffer();// 统计收费作废信息OP_MZXX
														// OP_ZFFP
		StringBuffer hql_sfmx = new StringBuffer();// 统计收费明细OP_SFMX
		StringBuffer hql_sfmx_zf = new StringBuffer();// 统计收费作废明细OP_SFMX
														// OP_ZFFP
		StringBuffer hql_xzmx = new StringBuffer();// 统计性质明细OP_XZMX
		StringBuffer hql_xzmx_zf = new StringBuffer();// 统计性质作废明细OP_XZMX
														// OP_ZFFP
		StringBuffer hql_fkxx = new StringBuffer();// 统计付款明细OP_FKXX
		StringBuffer hql_fkxx_zf = new StringBuffer();// 统计付款作废明细OP_FKXX
														// OP_ZFFP
		StringBuffer hql_fpxx = new StringBuffer();// 统计发票信息OP_MZXX
		StringBuffer hql_zffpxx = new StringBuffer();// 统计作废发票信息OP_MZXX
														// OP_ZFFP
		StringBuffer hql_ghmx = new StringBuffer();// 统计挂号信息OP_GHMX
		StringBuffer hql_ghthmx = new StringBuffer();// 统计退号信息OP_GHMX
														// OP_THMX
		StringBuffer hql_grmx = new StringBuffer();// 统计挂号信息OP_GHMX
		StringBuffer hql_grthmx = new StringBuffer();// 统计退号信息OP_GHMX
														// OP_THMX
		StringBuffer hql_ghfkxx = new StringBuffer();// 统计挂号付款金额OP_GHMX
														// OP_GH_FKXX
		StringBuffer hql_ghfkxx_zf = new StringBuffer();// 统计退号付款金额OP_GHMX
														// OP_THMX
														// OP_GH_FKXX
//			StringBuffer hql_jzhm = new StringBuffer();// 统计就诊号码信息OP_GHMX
		StringBuffer hql_jzhm_zf = new StringBuffer();// 统计退号就诊号码信息OP_GHMX

		List<Map<String, Object>> mzxxList = opMzxxDao.doQueryJmje(parameters);
		Map<String, Object> map_mzxx = new HashMap<String, Object>();
		if (mzxxList.size() > 0) {
			map_mzxx = mzxxList.get(0);
		}
//			double syb = 0.00;
//			double sjyb = 0.00;
		if (map_mzxx != null && map_mzxx.size() > 0) {
//				syb = ObjectToTypes.parseDouble(map_mzxx.get("SYB"));
//				sjyb = ObjectToTypes.parseDouble(map_mzxx.get("SJYB"));
//				map_mzxx_all.put("SYB", ObjectToTypes.parseDouble(map_mzxx.get("SYB")));
//				map_mzxx_all.put("SJYB", ObjectToTypes.parseDouble(map_mzxx.get("SJYB")));
			map_mzxx_all.put("CZGH", map_mzxx.get("CZGH"));
			map_mzxx_all.put("MZLB", mzlb);
			map_mzxx_all.put("ZJJE", ObjectToTypes.parseDouble(map_mzxx.get("ZJJE")));
			map_mzxx_all.put("XJJE", ObjectToTypes.parseDouble(map_mzxx.get("XJJE")));
			map_mzxx_all.put("ZPJE", ObjectToTypes.parseDouble(map_mzxx.get("ZPJE")));
			map_mzxx_all.put("QTYS", ObjectToTypes.parseDouble(map_mzxx.get("QTYS")));
			if (map_mzxx.get("JJZFJE") != null) {
				map_mzxx_all.put("JJZFJE", ObjectToTypes.parseDouble(map_mzxx.get("JJZFJE")));
			} else {
				map_mzxx_all.put("JJZFJE", 0.0);
			}
			map_mzxx_all.put("HBWC", ObjectToTypes.parseDouble(map_mzxx.get("HBWC") + ""));
			map_mzxx_all.put("JMJE", ObjectToTypes.parseDouble(map_mzxx.get("JMJE") + ""));
			if (map_mzxx.get("FPZS") != null) {
				map_mzxx_all.put("FPZS", ObjectToTypes.parseInt(map_mzxx.get("FPZS")));
			} else {
				map_mzxx_all.put("FPZS", 0);
			}
			map_mzxx_all.put("ZFZS", 0);
			map_mzxx_all.put("ZFJE", 0.0);
		}
		List<Map<String, Object>> mzxx_zf_list = opMzxxDao.doQueryJmjeZf(parameters);

		Map<String, Object> map_mzxx_zf = new HashMap<String, Object>();
		if (mzxx_zf_list.size() > 0) {
			map_mzxx_zf = new CaseInsensitiveMap<String, Object>(mzxx_zf_list.get(0));
		}
//			double sybzf = 0.00;
//			double sjybzf = 0.00;
		if (map_mzxx_zf != null && map_mzxx_zf.size() > 0) {
			if (map_mzxx_all.size() > 0) {
				if (map_mzxx_zf.get("JJZFJE") != null) {
					map_mzxx_zf.put("JJZFJE", -ObjectToTypes.parseDouble(map_mzxx_zf.get("JJZFJE")));
				} else {
					map_mzxx_zf.put("JJZFJE", 0.00);
				}
				map_mzxx_all.put("ZJJE", ObjectToTypes.parseDouble(map_mzxx_all.get("ZJJE"))
						- ObjectToTypes.parseDouble(map_mzxx_zf.get("ZJJE")));
//					sybzf = ObjectToTypes.parseDouble(map_mzxx_zf.get("SYB"));
//					map_mzxx_all.put("SYB",
//							ObjectToTypes.parseDouble(map_mzxx_all.get("SYB"))
//									- ObjectToTypes.parseDouble(map_mzxx_zf.get("SYB")));
//					sjybzf = ObjectToTypes.parseDouble(map_mzxx_zf.get("SJYB"));
//					map_mzxx_all.put("SZYB",
//							ObjectToTypes.parseDouble(map_mzxx_all.get("SJYB"))
//									- ObjectToTypes.parseDouble(map_mzxx_zf.get("SJYB")));
				map_mzxx_all.put("XJJE", ObjectToTypes.parseDouble(map_mzxx_all.get("XJJE"))
						- ObjectToTypes.parseDouble(map_mzxx_zf.get("XJJE")));
				map_mzxx_all.put("ZPJE", ObjectToTypes.parseDouble(map_mzxx_all.get("ZPJE"))
						- ObjectToTypes.parseDouble(map_mzxx_zf.get("ZPJE")));
				map_mzxx_all.put("QTYS", ObjectToTypes.parseDouble(map_mzxx_all.get("QTYS"))
						- ObjectToTypes.parseDouble(map_mzxx_zf.get("QTYS")));
				map_mzxx_all.put("JJZFJE", ObjectToTypes.parseDouble(map_mzxx_all.get("JJZFJE"))
						+ ObjectToTypes.parseDouble(map_mzxx_zf.get("JJZFJE")));
				map_mzxx_all.put("HBWC", ObjectToTypes.parseDouble(map_mzxx_all.get("HBWC"))
						- ObjectToTypes.parseDouble(map_mzxx_zf.get("HBWC")));
				map_mzxx_all.put("JMJE", ObjectToTypes.parseDouble(map_mzxx_all.get("JMJE"))
						- ObjectToTypes.parseDouble(map_mzxx_zf.get("JMJE")));
				map_mzxx_all.put("ZFZS", ObjectToTypes.parseInt(map_mzxx_all.get("ZFZS"))
						+ ObjectToTypes.parseInt(map_mzxx_zf.get("FPZS")));
				map_mzxx_all.put("ZFJE", ObjectToTypes.parseDouble(map_mzxx_all.get("ZFJE"))
						+ ObjectToTypes.parseDouble(map_mzxx_zf.get("ZJJE")));
			} else {
				map_mzxx_all.put("CZGH", map_mzxx_zf.get("CZGH"));
				map_mzxx_all.put("MZLB", mzlb);
//					sybzf = ObjectToTypes.parseDouble(map_mzxx_zf.get("SYB"));
//					sjybzf = ObjectToTypes.parseDouble(map_mzxx_zf.get("SJYB"));
//					map_mzxx_all.put("SYB",
//							-ObjectToTypes.parseDouble(map_mzxx_zf.get("SYB")));
//					map_mzxx_all.put("SZYB",
//							-ObjectToTypes.parseDouble(map_mzxx_zf.get("SJYB")));
				map_mzxx_all.put("ZJJE", -ObjectToTypes.parseDouble(map_mzxx_zf.get("ZJJE")));
				map_mzxx_all.put("XJJE", -ObjectToTypes.parseDouble(map_mzxx_zf.get("XJJE")));
				map_mzxx_all.put("ZPJE", -ObjectToTypes.parseDouble(map_mzxx_zf.get("ZPJE")));
				map_mzxx_all.put("QTYS", -ObjectToTypes.parseDouble(map_mzxx_zf.get("QTYS")));
				if (map_mzxx_zf.get("JJZFJE") == null) {
					map_mzxx_zf.put("JJZFJE", 0.00);
				}
				map_mzxx_all.put("JJZFJE", -ObjectToTypes.parseDouble(map_mzxx_zf.get("JJZFJE")));
				map_mzxx_all.put("HBWC", -ObjectToTypes.parseDouble(map_mzxx_zf.get("HBWC")));
				map_mzxx_all.put("JMJE", -ObjectToTypes.parseDouble(map_mzxx_zf.get("JMJE")));
				map_mzxx_all.put("FPZS", ObjectToTypes.parseInt(map_mzxx_zf.get("FPZS")));
				map_mzxx_all.put("ZFZS", ObjectToTypes.parseInt(map_mzxx_zf.get("FPZS")));
				map_mzxx_all.put("ZFJE", ObjectToTypes.parseDouble(map_mzxx_zf.get("ZJJE")));
			}
			zfje = ObjectToTypes.parseDouble(map_mzxx_zf.get("ZJJE"));
			zfzs = ObjectToTypes.parseInt(map_mzxx_zf.get("FPZS"));
			zfxx = "张数：" + zfzs + " 作废金额：" + String.format("%1$.2f", zfje);
		}
		if (map_mzxx_all.size() > 0) {
			map_mzxx_all.put("JZRQ", jzrq);
			map_mzxx_all.put("JGID", jgid);
			map_mzxx_all.put("ZFZF", 0.0);
			qtys = qtys + ObjectToTypes.parseDouble(map_mzxx_all.get("QTYS"));
			jjzfje = jjzfje + ObjectToTypes.parseDouble(map_mzxx_all.get("JJZFJE"));
			if (map_mzxx_all.get("FPZS") != null) {
				fpzs = fpzs + Integer.parseInt(map_mzxx_all.get("FPZS").toString());
			}
		}
		List<Map<String, Object>> list_sfmx = opMzxxDao.doQuerySfmxRb(parameters);
		List<Map<String, Object>> list_sfmx_zf = opMzxxDao.doQuerySfzfmxRb(parameters);

		if (list_sfmx != null && list_sfmx.size() != 0) {
			for (int i = 0; i < list_sfmx.size(); i++) {
				Map<String, Object> map_sfmx = new CaseInsensitiveMap<String, Object>(list_sfmx.get(i));
				Map<String, Object> map_sfmx_all = new HashMap<String, Object>();
				map_sfmx_all.put("SFXM", map_sfmx.get("SFXM"));
				map_sfmx_all.put("CZGH", uid);
				map_sfmx_all.put("SFJE", ObjectToTypes.parseDouble(map_sfmx.get("ZJJE")));
				map_sfmx_all.put("JGID", jgid);
				map_sfmx_all.put("JZRQ", jzrq);
				if (list_sfmx_zf != null && list_sfmx_zf.size() != 0) {
					for (int J = 0; J < list_sfmx_zf.size(); J++) {
						Map<String, Object> map_sfmx_zf = list_sfmx_zf.get(J);
						if (map_sfmx_zf.containsKey("SFXM")) {
							if (Long.parseLong(map_sfmx.get("SFXM") + "") == Long
									.parseLong(map_sfmx_zf.get("SFXM") + "")) {
								map_sfmx_all.put("SFJE", ObjectToTypes.parseDouble(map_sfmx_all.get("SFJE"))
										- ObjectToTypes.parseDouble(map_sfmx_zf.get("ZJJE")));
								list_sfmx_zf.remove(J);
								J--;
							}
						}
					}
				}
				list_rbmx.add(map_sfmx_all);
			}
			if (list_sfmx_zf != null && list_sfmx_zf.size() != 0) {
				for (int i = 0; i < list_sfmx_zf.size(); i++) {
					Map<String, Object> map_sfmx_zf = new CaseInsensitiveMap<String, Object>(list_sfmx_zf.get(i));
					if (map_sfmx_zf.containsKey("SFXM")) {
						Map<String, Object> map_sfmx_all = new HashMap<String, Object>();
						map_sfmx_all.put("SFXM", map_sfmx_zf.get("SFXM"));
						map_sfmx_all.put("CZGH", uid);
						map_sfmx_all.put("SFJE", -ObjectToTypes.parseDouble(map_sfmx_zf.get("ZJJE")));
						map_sfmx_all.put("JGID", jgid);
						map_sfmx_all.put("JZRQ", jzrq);
						list_rbmx.add(map_sfmx_all);
						list_sfmx_zf.remove(i);
						i--;
					}
				}
			}

		} else {
			if (list_sfmx_zf != null && list_sfmx_zf.size() != 0) {
				for (int k = 0; k < list_sfmx_zf.size(); k++) {
					Map<String, Object> map_sfmx_zf = new CaseInsensitiveMap<String, Object>(list_sfmx_zf.get(k));
					Map<String, Object> map_sfmx_all = new HashMap<String, Object>();
					map_sfmx_all.put("SFXM", map_sfmx_zf.get("SFXM"));
					map_sfmx_all.put("CZGH", uid);
					map_sfmx_all.put("SFJE", -ObjectToTypes.parseDouble(map_sfmx_zf.get("ZJJE")));
					map_sfmx_all.put("JGID", jgid);
					map_sfmx_all.put("JZRQ", jzrq);
					list_rbmx.add(map_sfmx_all);
				}
			}
		}
		if (list_rbmx.size() > 0) {
			for (Map<String, Object> map_rbmx : list_rbmx) {
				sfhj = sfhj + ObjectToTypes.parseDouble(map_rbmx.get("SFJE"));
			}
		}

		List<Map<String, Object>> list_sfxm_xz = opMzxxDao.doQueryXzmxRb(parameters);
		List<Map<String, Object>> list_sfxm_xz_zf = opMzxxDao.doQueryxzmxZfRb(parameters);

		if (list_sfxm_xz != null && list_sfxm_xz.size() != 0) {
			for (int i = 0; i < list_sfxm_xz.size(); i++) {
				Map<String, Object> map_sfmx_xz = new CaseInsensitiveMap<String, Object>(list_sfxm_xz.get(i));
				Map<String, Object> map_xzmx_all = new HashMap<String, Object>();
				map_xzmx_all.put("BRXZ", map_sfmx_xz.get("BRXZ"));
				map_xzmx_all.put("SFJE", ObjectToTypes.parseDouble(map_sfmx_xz.get("ZJJE")));
				map_xzmx_all.put("FPZS", ObjectToTypes.parseInt(map_sfmx_xz.get("FPZS")));
				map_xzmx_all.put("JGID", jgid);
				map_xzmx_all.put("JZRQ", jzrq);
				map_xzmx_all.put("CZGH", uid);
				if (list_sfxm_xz_zf != null && list_sfxm_xz_zf.size() != 0) {
					for (int J = 0; J < list_sfxm_xz_zf.size(); J++) {
						Map<String, Object> map_sfmx_xz_zf = new CaseInsensitiveMap<String, Object>(
								list_sfxm_xz_zf.get(J));
						if (map_sfmx_xz_zf.containsKey("BRXZ")) {
							if (Long.parseLong(map_sfmx_xz.get("BRXZ") + "") == Long
									.parseLong(map_sfmx_xz_zf.get("BRXZ") + "")) {
								map_xzmx_all.put("SFJE", ObjectToTypes.parseDouble(map_xzmx_all.get("SFJE"))
										- ObjectToTypes.parseDouble(map_sfmx_xz_zf.get("ZJJE")));
								list_sfxm_xz_zf.remove(J);
								J--;
							}
						}
					}
				}
				list_xzmx.add(map_xzmx_all);
			}

			if (list_sfxm_xz_zf != null && list_sfxm_xz_zf.size() != 0) {
				for (int J = 0; J < list_sfxm_xz_zf.size(); J++) {
					Map<String, Object> map_sfmx_xz_zf = new CaseInsensitiveMap<String, Object>(list_sfxm_xz_zf.get(J));
					if (map_sfmx_xz_zf.containsKey("BRXZ")) {
						Map<String, Object> map_xzmx_all = new HashMap<String, Object>();
						map_xzmx_all.put("BRXZ", map_sfmx_xz_zf.get("BRXZ"));
						map_xzmx_all.put("SFJE", -ObjectToTypes.parseDouble(map_sfmx_xz_zf.get("ZJJE")));
						map_xzmx_all.put("FPZS", map_sfmx_xz_zf.get("FPZS"));
						map_xzmx_all.put("JGID", jgid);
						map_xzmx_all.put("JZRQ", jzrq);
						map_xzmx_all.put("CZGH", uid);
						list_sfxm_xz_zf.remove(J);
						list_xzmx.add(map_xzmx_all);
						J--;
					}
				}
			}

		} else {
			if (list_sfxm_xz_zf != null && list_sfxm_xz_zf.size() != 0) {
				for (int k = 0; k < list_sfxm_xz_zf.size(); k++) {
					Map<String, Object> map_sfmx_xz_zf = new CaseInsensitiveMap<String, Object>(list_sfxm_xz_zf.get(k));
					Map<String, Object> map_xzmx_all = new HashMap<String, Object>();
					map_xzmx_all.put("BRXZ", map_sfmx_xz_zf.get("BRXZ"));
					map_xzmx_all.put("CZGH", uid);
					map_xzmx_all.put("SFJE", -ObjectToTypes.parseDouble(map_sfmx_xz_zf.get("ZJJE")));
					map_xzmx_all.put("JGID", jgid);
					map_xzmx_all.put("JZRQ", jzrq);
					map_xzmx_all.put("FPZS", -ObjectToTypes.parseInt(map_sfmx_xz_zf.get("FPZS")));
					list_xzmx.add(map_xzmx_all);
				}
			}
		}
		List<Map<String, Object>> list_fkmx = opMzxxDao.doQueryFkxxRb(parameters);
		List<Map<String, Object>> list_fkmx_zf = opMzxxDao.doQueryFkxxZf(parameters);
		double smk = 0.00;
		double smkzf = 0.00;
		if (list_fkmx != null && list_fkmx.size() != 0) {
			for (int i = 0; i < list_fkmx.size(); i++) {
				Map<String, Object> map_fkxx = new CaseInsensitiveMap<String, Object>(list_fkmx.get(i));
				Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
				map_fkxx_all.put("FKFS", map_fkxx.get("FKFS"));
				if (ObjectToTypes.parseInt(map_fkxx.get("FKFS")) == 1) {
					smk += ObjectToTypes.parseDouble(map_fkxx.get("FKJE"));
				}
				map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx.get("FKJE")));
				map_fkxx_all.put("CZGH", uid);
				map_fkxx_all.put("JGID", jgid);
				map_fkxx_all.put("JZRQ", jzrq);
				if (list_fkmx_zf != null && list_fkmx_zf.size() != 0) {
					for (int J = 0; J < list_fkmx_zf.size(); J++) {
						Map<String, Object> map_fkxx_zf = new CaseInsensitiveMap<String, Object>(list_fkmx_zf.get(J));
						if (map_fkxx_zf.containsKey("FKFS")) {
							if (Long.parseLong(map_fkxx.get("FKFS") + "") == Long
									.parseLong(map_fkxx_zf.get("FKFS") + "")) {
								map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx_all.get("FKJE"))
										- ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE")));
								list_fkmx_zf.remove(J);
								J--;
							}
						}
					}
				}
				list_sfrb_fkmx.add(map_fkxx_all);
			}
			if (list_fkmx_zf != null && list_fkmx_zf.size() != 0) {
				for (int J = 0; J < list_fkmx_zf.size(); J++) {
					Map<String, Object> map_fkxx_zf = new CaseInsensitiveMap<String, Object>(list_fkmx_zf.get(J));
					Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
					map_fkxx_all.put("FKFS", map_fkxx_zf.get("FKFS"));
					if (ObjectToTypes.parseInt(map_fkxx_zf.get("FKFS")) == 1) {
						smkzf += ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE"));
					}
					map_fkxx_all.put("FKJE", -ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE")));
					map_fkxx_all.put("CZGH", uid);
					map_fkxx_all.put("JGID", jgid);
					map_fkxx_all.put("JZRQ", jzrq);
					list_fkmx_zf.remove(J);
					list_sfrb_fkmx.add(map_fkxx_all);
					J--;
				}
			}
		} else {
			if (list_fkmx_zf != null && list_fkmx_zf.size() != 0) {
				for (int k = 0; k < list_fkmx_zf.size(); k++) {
					Map<String, Object> map_fkxx_zf = new CaseInsensitiveMap<String, Object>(list_fkmx_zf.get(k));
					Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
					map_fkxx_all.put("FKFS", map_fkxx_zf.get("FKFS"));
					map_fkxx_all.put("CZGH", uid);
					map_fkxx_all.put("FKJE", -ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE")));
					map_fkxx_all.put("JGID", jgid);
					map_fkxx_all.put("JZRQ", jzrq);
					list_sfrb_fkmx.add(map_fkxx_all);
				}
			}
		}
		if (smk != 0.00) {
			map_mzxx_all.put("SMK", smk - smkzf);
		}

//			hql_fpxx.append("select FPHM as FPHM,FPZS as FPZS, LB as LB from (select FPHM as FPHM,nvl(FPZS,1) as FPZS,zfpb as LB  from OP_MZXX where JGID = :jgid  and MZLB = :mzlb and CZGH = :czgh and to_char(JZRQ,'yyyy-mm-dd hh24:mi:ss')=:JZRQ union all select FPHM as FPHM,1 as FPZS, zfpb lb  from JC_JCJS where JGID = :jgid  and CZGH = :czgh  and MZLB = :mzlb  and to_char(JZRQ,'yyyy-mm-dd hh24:mi:ss')=:JZRQ union all select JZHM as FPHM,1 as FPZS,decode(thbz,1,2, decode(zkbz,1,3,0)) lb  from OP_GHMX where JGID = :jgid  and MZLB = :mzlb and CZGH = :czgh and to_char(JZRQ,'yyyy-mm-dd hh24:mi:ss')=:JZRQ and JZHM not like 'MGH%' union all select JZHM as FPHM,1 as FPZS,decode(zkbz,1,3,0) lb from OP_GHMX_ZK where JGID = :jgid  and MZLB = :mzlb and CZGH = :czgh and to_char(JZRQ,'yyyy-mm-dd hh24:mi:ss')=:JZRQ and JZHM not like 'MGH%' union all select FPHM as FPHM,1 as FPZS,zfpb lb from  LNHL_JS a where a.JGID=:jgid and to_char(JZRQ,'yyyy-mm-dd hh24:mi:ss')=:JZRQ and a.CZGH=:czgh and MZLB  in (:mzlb)  ) order by lb,FPHM ");
		// hql_zffpxx
//			.append("select a.FPHM as FPHM,nvl(b.FPZS,1) as FPZS from OP_ZFFP a,OP_MZXX b where a.MZXH=b.MZXH and a.JGID = :jgid  and a.MZLB = :mzlb and a.CZGH = :czgh and a.to_char(JZRQ,'yyyy-mm-dd hh24:mi:ss')=:JZRQ");

		int fpzsSum = 0; // 总发票张数

		List<Map<String, Object>> list_fpxx = opMzxxDao.doQueryFphmFpzsRb(parameters);
		List<Map<String, Object>> addlist_fpxx = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < list_fpxx.size(); i++) {
			Map<String, Object> map_fpxx = new CaseInsensitiveMap<String, Object>(list_fpxx.get(i));
			fpzsSum += Long.parseLong(map_fpxx.get("FPZS") + "");
			Object Lb = map_fpxx.get("LB");

			if (Long.parseLong(map_fpxx.get("FPZS") + "") > 1) {
				for (int j = 1; j < Long.parseLong(map_fpxx.get("FPZS") + ""); j++) {
					String fphm = map_fpxx.get("FPHM") + "";
					int k = -1;
					for (int q = fphm.length() - 1; q >= 0; q--) {
						if (fphm.charAt(q) < '0' || fphm.charAt(q) > '9') {
							k = q;
							break;
						}
					}
					String fphmzm = fphm.substring(0, k + 1);
					String fphmsz = fphm.substring(k + 1);
					if (fphmzm.equals("MS")) { // 过滤虚拟发票
						continue;
					}
					fphm = fphmzm + String.format("%0" + fphmsz.length() + "d", Long.parseLong(fphmsz + "") + j);
					Map<String, Object> fphm_map = new HashMap<String, Object>();
					fphm_map.put("FPHM", fphm);
					fphm_map.put("LB", Lb);
					addlist_fpxx.add(fphm_map);
				}
			}
		}
		list_fpxx.addAll(addlist_fpxx);
//			List<Map<String, Object>> list_fpxx_num = gethmNUm(list_fpxx);

		List<Map<String, Object>> list_zffpxx = opMzxxDao.doQueryFpzfxxRb(parameters);
//		List<Map<String, Object>> list_jczffpxx = opMzxxDao.doQueryJczffpxxRb(parameters);
//		List<Map<String, Object>> list_jjhjfpxx = opMzxxDao.doQueryJjhjfpxxRb(parameters);
//			List<Map<String, Object>> addlist_zffpxx = new ArrayList<Map<String,Object>>();
//			for(int i = 0 ; i < list_zffpxx.size(); i ++){
//				Map<String, Object> map_zffpxx = list_zffpxx.get(i);
//				if(Long.parseLong(map_zffpxx.get("FPZS")+"")>1){
//					for(int j = 1 ; j < Long.parseLong(map_zffpxx.get("FPZS")+"") ; j ++){
//						String fphm = map_zffpxx.get("FPHM")+"";
//						int k = -1 ;
//						for(int q = fphm.length()-1 ; q >= 0 ; q --){
//							if(fphm.charAt(q)<'0'||fphm.charAt(q)>'9'){
//								k = q;
//								break;
//							}
//						}
//						String fphmzm = fphm.substring(0, k+1);
//						String fphmsz = fphm.substring(k+1);
//						fphm = fphmzm+String.format("%0" + fphmsz.length() + "d", Long.parseLong(fphmsz+"")+j);
//						Map<String, Object> fphm_map = new HashMap<String, Object>();
//						fphm_map.put("FPHM", fphm);
//						addlist_zffpxx.add(fphm_map);
//					}
//				}
//			}
//			list_zffpxx.addAll(addlist_zffpxx);
//			List<Map<String, Object>> list_zffpxx_num = gethmNUm(list_zffpxx);
//			String fphmzfstr = gethmStr(list_zffpxx);
		if ("LB".equals(SQXTMS)) {
			if (list_fpxx != null && list_fpxx.size() > 0) {
				try {
					Collections.sort(list_fpxx, new Comparator<Map<String, Object>>() {
						@Override
						public int compare(Map<String, Object> map1, Map<String, Object> map2) {
							int LB1 = ObjectToTypes.toInt(map1.get("LB"));
							int LB2 = ObjectToTypes.toInt(map2.get("LB"));
							int n = LB1 - LB2;
							if (n == 0) {
								String fphm1 = (String) map1.get("FPHM");
								String fphm2 = (String) map2.get("FPHM");
								n = fphm1.compareTo(fphm2);
							}
							return n;
						}
					});
				} catch (RuntimeException e) {
					e.printStackTrace();
				}

				List list_fpxx0 = new ArrayList(); // 收费
				List list_fpxx1 = new ArrayList(); // 作废
				List list_fpxx2 = new ArrayList(); // 退号
				List list_fpxx3 = new ArrayList(); // 转科
				for (int i = 0; i < list_fpxx.size(); i++) {
					Map map = list_fpxx.get(i);
					int lb = ObjectToTypes.toInt(map.get("LB"));
					if (lb == 0) {
						list_fpxx0.add(map);
					} else if (lb == 1) {
						list_fpxx1.add(map);
					} else if (lb == 2) {
						list_fpxx2.add(map);
					} else if (lb == 3) {
						list_fpxx3.add(map);
					}
				}

				String fphmstr0 = gethmStr(list_fpxx0);
				String fpxx0 = divisionFpxx(list_fpxx0, fphmstr0);

				String fphmstr1 = gethmStr(list_fpxx1);
				String fpxx1 = divisionFpxx(list_fpxx1, fphmstr1);

				String fphmstr2 = gethmStr(list_fpxx2);
				String fpxx2 = divisionFpxx(list_fpxx2, fphmstr2);

				String fphmstr3 = gethmStr(list_fpxx3);
				String fpxx3 = divisionFpxx(list_fpxx3, fphmstr3);

				fpxx += !"".equals(fpxx0) ? "收费:" + fpxx0 : "";
				fpxx += !"".equals(fpxx1) ? " 作废:" + fpxx1 : "";
				fpxx += !"".equals(fpxx2) ? " 退号:" + fpxx2 : "";
				fpxx += !"".equals(fpxx3) ? " 转科:" + fpxx3 : "";

			}
		} else {
			if (list_fpxx != null && list_fpxx.size() > 0) {
				try {
					Collections.sort(list_fpxx, new Comparator<Map<String, Object>>() {

						@Override
						public int compare(Map<String, Object> map1, Map<String, Object> map2) {
							String fphm1 = (String) map1.get("FPHM");
							String fphm2 = (String) map2.get("FPHM");
							return fphm1.compareTo(fphm2);
						}
					});
				} catch (RuntimeException e) {
					e.printStackTrace();
				}

				String fphmstr = gethmStr(list_fpxx);
				fpxx =

						divisionFpxx(list_fpxx, fphmstr);
			}
		}

		if (list_zffpxx != null && list_zffpxx.size() > 0) {
			zffpxx.append("退费:");
			for (

					int i = 0; i < list_zffpxx.size(); i++) {
				Map<String, Object> thfp_map = new CaseInsensitiveMap<String, Object>(list_zffpxx.get(i));
				zffpxx.append(thfp_map.get("FPHM") + "(" + thfp_map.get("BRXM") + "," + thfp_map.get("FKMC") + ":"
						+ thfp_map.get("FKJE") + ") ");
			}
		}
//		if (list_jczffpxx != null && list_jczffpxx.size() > 0) {
//			zffpxx.append("家床:");
//			for (int i = 0; i < list_jczffpxx.size(); i++) {
//				Map<String, Object> thfp_map = new CaseInsensitiveMap<String, Object>(list_jczffpxx.get(i));
//				zffpxx.append(thfp_map.get("FPHM") + "(" + thfp_map.get("BRXM") + "," + thfp_map.get("FKMC") + ":"
//						+ thfp_map.get("FKJE") + ") ");
//			}
//		}
//		if (list_jjhjfpxx != null && list_jjhjfpxx.size() > 0) {
//			zffpxx.append("居家护理:");
//			for (int i = 0; i < list_jjhjfpxx.size(); i++) {
//				Map<String, Object> thfp_map = new CaseInsensitiveMap<String, Object>(list_jjhjfpxx.get(i));
//				zffpxx.append(thfp_map.get("FPHM") + "(" + thfp_map.get("BRXM") + "," + thfp_map.get("FKMC") + ":"
//						+ thfp_map.get("FKJE") + ") ");
//			}
//		}

		// 716行至724行的释放出来 针对的是只对挂号费进行结账的话 返回不了发票信息
//				response.put("total", String.format("%1$.2f", sfhj));
		response.put("amount", fkxx);
//				response.put("otherAmount", String.format("%1$.2f", qtys));
//				response.put("jjzfje", String.format("%1$.2f", jjzfje));
//				response.put("numPage", fpzsSum + "");
		response.put("invalidAmount", zfxx);
		response.put("FPHM", fpxx);
		response.put("invalid", zffpxx.toString());
		if (map_mzxx_all != null && map_mzxx_all.size() > 0) {
			map_mzxx_all.put("QZPJ", fpxx);
			map_mzxx_all.put("ZFFP", zffpxx.toString());
			map_mzxx_all.put("ZFJE", zfje);
		}

		List<Map<String, Object>> map_ghmxlist = opMzxxDao.doQueryGhmxRbA(parameters);
		Map<String, Object> map_ghmx = new HashMap<String, Object>();
		if (map_ghmxlist.size() > 0) {
			map_ghmx = new CaseInsensitiveMap<String, Object>(map_ghmxlist.get(0));
		}
//			double ghsyb = ObjectToTypes.parseDouble(map_ghmx.get("SYB"));
//			double ghsjyb = ObjectToTypes.parseDouble(map_ghmx.get("SJYB"));
		if (map_ghmx != null && map_ghmx.size() > 0) {
			map_ghrb_all.put("CZGH", map_ghmx.get("CZGH"));
			map_ghrb_all.put("MZLB", mzlb);
			map_ghrb_all.put("ZJJE", ObjectToTypes.parseDouble(map_ghmx.get("ZJJE")));
//				ghsyb = ObjectToTypes.parseDouble(map_ghmx.get("SYB"));
//				map_ghrb_all.put("SYB", ObjectToTypes.parseDouble(map_ghmx.get("SYB")));
//				ghsjyb = ObjectToTypes.parseDouble(map_ghmx.get("SJYB"));
//				map_ghrb_all.put("SJYB", ObjectToTypes.parseDouble(map_ghmx.get("SJYB")));
			map_ghrb_all.put("XJJE", ObjectToTypes.parseDouble(map_ghmx.get("XJJE")));
			map_ghrb_all.put("ZPJE", ObjectToTypes.parseDouble(map_ghmx.get("ZPJE")));
			map_ghrb_all.put("QTYS", ObjectToTypes.parseDouble(map_ghmx.get("QTYS")));
			map_ghrb_all.put("HBWC", ObjectToTypes.parseDouble(map_ghmx.get("HBWC")));
			map_ghrb_all.put("FPZS", ObjectToTypes.parseInt(map_ghmx.get("FPZS")));
			map_ghrb_all.put("THJE", 0.0);
			map_ghrb_all.put("THSL", 0);
			map_ghrb_all.put("JGID", jgid);
		}

		List<Map<String, Object>> map_ghthmxlist = opMzxxDao.doQueryGhthmxRb(parameters);
		Map<String, Object> map_ghthmx = new HashMap<String, Object>();
		if (map_ghthmxlist.size() > 0) {
			map_ghthmx = new CaseInsensitiveMap<String, Object>(map_ghthmxlist.get(0));
		}
//			double ghsybth = ObjectToTypes.parseDouble(map_ghthmx.get("SYB"));
//			double ghsjybth = ObjectToTypes.parseDouble(map_ghthmx.get("SJYB"));
		if (map_ghthmx != null && map_ghthmx.size() > 0) {
			if (map_ghrb_all.size() > 0) {
				map_ghrb_all.put("ZJJE", ObjectToTypes.parseDouble(map_ghrb_all.get("ZJJE"))
						- ObjectToTypes.parseDouble(map_ghthmx.get("ZJJE")));
				map_ghrb_all.put("XJJE", ObjectToTypes.parseDouble(map_ghrb_all.get("XJJE"))
						- ObjectToTypes.parseDouble(map_ghthmx.get("XJJE")));
				map_ghrb_all.put("ZPJE", ObjectToTypes.parseDouble(map_ghrb_all.get("ZPJE"))
						- ObjectToTypes.parseDouble(map_ghthmx.get("ZPJE")));
				map_ghrb_all.put("QTYS", ObjectToTypes.parseDouble(map_ghrb_all.get("QTYS"))
						- ObjectToTypes.parseDouble(map_ghthmx.get("QTYS")));
				map_ghrb_all.put("HBWC", ObjectToTypes.parseDouble(map_ghrb_all.get("HBWC"))
						- ObjectToTypes.parseDouble(map_ghthmx.get("HBWC")));
//					ghsybth = ObjectToTypes.parseDouble(map_ghthmx.get("SYB"));
//					map_ghrb_all.put("SYB",
//							ObjectToTypes.parseDouble(map_ghrb_all.get("SYB"))
//									- ObjectToTypes.parseDouble(map_ghthmx.get("SYB")));
//					ghsjybth = ObjectToTypes.parseDouble(map_ghthmx.get("SJYB"));
//					map_ghrb_all.put("SZYB",
//							ObjectToTypes.parseDouble(map_ghrb_all.get("SJYB"))
//									- ObjectToTypes.parseDouble(map_ghthmx.get("SJYB")));
				map_ghrb_all.put("THJE", ObjectToTypes.parseDouble(map_ghrb_all.get("THJE"))
						+ ObjectToTypes.parseDouble(map_ghthmx.get("ZJJE")));
				map_ghrb_all.put("THSL", ObjectToTypes.parseInt(map_ghrb_all.get("THSL"))
						+ ObjectToTypes.parseInt(map_ghthmx.get("THSL")));
			} else {
				map_ghrb_all.put("CZGH", map_ghthmx.get("CZGH"));
				map_ghrb_all.put("MZLB", mzlb);
//					ghsybth = ObjectToTypes.parseDouble(map_ghthmx.get("SYB"));
//					ghsjybth = ObjectToTypes.parseDouble(map_ghthmx.get("SJYB"));
//					map_ghrb_all
//							.put("SYB", -ObjectToTypes.parseDouble(map_ghthmx.get("SYB")));
//					map_ghrb_all.put("SZYB",
//							-ObjectToTypes.parseDouble(map_ghthmx.get("SJYB")));
				map_ghrb_all.put("ZJJE", -ObjectToTypes.parseDouble(map_ghthmx.get("ZJJE")));
				map_ghrb_all.put("XJJE", -ObjectToTypes.parseDouble(map_ghthmx.get("XJJE")));
				map_ghrb_all.put("ZPJE", -ObjectToTypes.parseDouble(map_ghthmx.get("ZPJE")));
				map_ghrb_all.put("QTYS", -ObjectToTypes.parseDouble(map_ghthmx.get("QTYS")));
				map_ghrb_all.put("HBWC", -ObjectToTypes.parseDouble(map_ghthmx.get("HBWC")));
				map_ghrb_all.put("THJE", ObjectToTypes.parseDouble(map_ghthmx.get("ZJJE")));
				map_ghrb_all.put("THSL", ObjectToTypes.parseInt(map_ghthmx.get("THSL")));
				map_ghrb_all.put("JGID", jgid);
				map_ghrb_all.put("FPZS", 0);
			}
			thje = ObjectToTypes.parseDouble(map_ghthmx.get("ZJJE"));
			thsl = ObjectToTypes.parseInt(map_ghthmx.get("THSL"));
			thxx = "张数：" + thsl + " 退号金额：" + String.format("%1$.2f", thje);
		}
		if (map_ghrb_all.size() > 0) {
			map_ghrb_all.put("JZRQ", jzrq);
//				qtys = qtys + ObjectToTypes.parseDouble(map_ghrb_all.get("QTYS"));
//				response.put("otherAmount", String.format("%1$.2f", qtys));
		}

		List<Map<String, Object>> list_grmx = opMzxxDao.doQueryGrmxRbA(parameters);
		List<Map<String, Object>> list_grthmx = opMzxxDao.doQueryGrthmxRb(parameters);
		if (list_grmx != null && list_grmx.size() != 0) {
			for (int i = 0; i < list_grmx.size(); i++) {
				Map<String, Object> map_grmx = new CaseInsensitiveMap<String, Object>(list_grmx.get(i));
				Map<String, Object> map_grmx_all = new HashMap<String, Object>();
				map_grmx_all.put("BRXZ", map_grmx.get("BRXZ"));
				map_grmx_all.put("CZGH", uid);
				map_grmx_all.put("FPZS",

						ObjectToTypes.parseInt(map_grmx.get("GHRC")));
				map_grmx_all.put("SFJE", ObjectToTypes.parseDouble(map_grmx.get("ZJJE")));
				map_grmx_all.put("GHJE", ObjectToTypes.parseDouble(map_grmx.get("GHJE")));
				map_grmx_all.put("ZLJE", ObjectToTypes.parseDouble(map_grmx.get("ZLJE")));
				map_grmx_all.put("ZJFY", ObjectToTypes.parseDouble(map_grmx.get("ZJFY")));
				map_grmx_all.put("BLJE", ObjectToTypes.parseDouble(map_grmx.get("BLJE")));
				map_grmx_all.put("JGID", jgid);
				map_grmx_all.put("JZRQ", jzrq);
				map_grmx_all.put("XM", map_grmx.get("XM") + "");
				if (list_grthmx != null && list_grthmx.size() != 0) {
					for (int J = 0; J < list_grthmx.size(); J++) {
						Map<String, Object> map_grthmx = new CaseInsensitiveMap<String, Object>(list_grthmx.get(J));
						if (map_grthmx.containsKey("BRXZ")) {
							if (Long.parseLong(map_grmx.get("BRXZ") + "") == Long
									.parseLong(map_grthmx.get("BRXZ") + "")) {
								map_grmx_all.put("SFJE", ObjectToTypes.parseDouble(map_grmx_all.get("SFJE"))
										- ObjectToTypes.parseDouble(map_grthmx.get("ZJJE")));
								map_grmx_all.put("GHJE", ObjectToTypes.parseDouble(map_grmx_all.get("GHJE"))
										- ObjectToTypes.parseDouble(map_grthmx.get("GHJE")));
								map_grmx_all.put("ZLJE", ObjectToTypes.parseDouble(map_grmx_all.get("ZLJE"))
										- ObjectToTypes.parseDouble(map_grthmx.get("ZLJE")));
								map_grmx_all.put("ZJFY", (Double) map_grmx_all.get("ZJFY")
										- ObjectToTypes.parseDouble(map_grthmx.get("ZJFY")));
								map_grmx_all.put("BLJE", ObjectToTypes.parseDouble(map_grmx_all.get("BLJE"))
										- ObjectToTypes.parseDouble(map_grthmx.get("BLJE")));
								list_grthmx.remove(J);
								J--;
							}
						}
					}
				}
				list_ghrbmx.add(map_grmx_all);
			}

			if (list_grthmx != null && list_grthmx.size() != 0)

			{
				for (int J = 0; J < list_grthmx.size(); J++) {
					Map<String, Object> map_grthmx = new CaseInsensitiveMap<String, Object>(list_grthmx.get(J));
					if (map_grthmx.containsKey("BRXZ")) {
						Map<String, Object> map_grmx_all = new HashMap<String, Object>();
						map_grmx_all.put("CZGH", uid);
						map_grmx_all.put("JGID", jgid);
						map_grmx_all.put("JZRQ", jzrq);
						map_grmx_all.put("FPZS", ObjectToTypes.parseInt(map_grthmx.get("GHRC")));
						map_grmx_all.put("SFJE", -ObjectToTypes.parseDouble(map_grthmx.get("ZJJE") + ""));
						map_grmx_all.put("GHJE", -ObjectToTypes.parseDouble(map_grthmx.get("GHJE") + ""));
						map_grmx_all.put("ZLJE", -ObjectToTypes.parseDouble(map_grthmx.get("ZLJE") + ""));
						map_grmx_all.put("ZJFY", -ObjectToTypes.parseDouble(map_grthmx.get("ZJFY") + ""));
						map_grmx_all.put("BLJE", -ObjectToTypes.parseDouble(map_grthmx.get("BLJE") + ""));
						map_grmx_all.put("BRXZ", map_grthmx.get("BRXZ"));
						map_grmx_all.put("XM", map_grthmx.get("XM") + "");
						list_grthmx.remove(J);
						list_ghrbmx.add(map_grmx_all);
						J--;
					}
				}
			}

		} else {
			if (list_grthmx != null && list_grthmx.size() != 0) {
				for (int k = 0; k < list_grthmx.size(); k++) {
					Map<String, Object> map_grthmx = new CaseInsensitiveMap<String, Object>(list_grthmx.get(k));
					Map<String, Object> map_grmx_all = new HashMap<String, Object>();
					map_grmx_all.put("BRXZ", map_grthmx.get("BRXZ"));
					map_grmx_all.put("CZGH", uid);
					map_grmx_all.put("FPZS", -ObjectToTypes.parseInt(map_grthmx.get("GHRC")));
					map_grmx_all.put("SFJE", -ObjectToTypes.parseDouble(map_grthmx.get("ZJJE") + ""));
					map_grmx_all.put("GHJE", -ObjectToTypes.parseDouble(map_grthmx.get("GHJE") + ""));
					map_grmx_all.put("ZLJE", -ObjectToTypes.parseDouble(map_grthmx.get("ZLJE") + ""));
					map_grmx_all.put("ZJFY", -ObjectToTypes.parseDouble(map_grthmx.get("ZJFY") + ""));
					map_grmx_all.put("BLJE", -ObjectToTypes.parseDouble(map_grthmx.get("BLJE") + ""));
					map_grmx_all.put("JGID", jgid);
					map_grmx_all.put("JZRQ", jzrq);
					map_grmx_all.put("XM", map_grthmx.get("XM") + "");
					list_ghrbmx.add(map_grmx_all);
				}
			}
		}
		if (list_ghrbmx.size() > 0) {
			for (Map<String, Object> map_rbmx : list_ghrbmx) {
				ghhj = ghhj + ObjectToTypes.parseDouble(map_rbmx.get("SFJE") + "");
				ghje = ghje + ObjectToTypes.parseDouble(map_rbmx.get("GHJE") + "");
				zlje = zlje + ObjectToTypes.parseDouble(map_rbmx.get("ZLJE") + "");
				blje = blje + ObjectToTypes.parseDouble(map_rbmx.get("BLJE") + "");
				zjfy = zjfy + ObjectToTypes.parseDouble(map_rbmx.get("ZJFY") + "");
			}
		}

		List<Map<String, Object>> list_ghfkmx = opMzxxDao.doQueryGhFkxxA(parameters);
		List<Map<String, Object>> list_ghfkmx_zf = opMzxxDao.doQueryGhfkxxZf(parameters);
		if (list_ghfkmx != null && list_ghfkmx.size() != 0) {
			for (int i = 0; i < list_ghfkmx.size(); i++) {
				Map<String, Object> map_fkxx = new CaseInsensitiveMap<String, Object>(list_ghfkmx.get(i));
				Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
				map_fkxx_all.put("FKFS", map_fkxx.get("FKFS"));
				map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx.get("FKJE")));
				map_fkxx_all.put("CZGH", uid);
				map_fkxx_all.put("JGID", jgid);
				map_fkxx_all.put("JZRQ", jzrq);
				if (list_ghfkmx_zf != null && list_ghfkmx_zf.size() != 0) {
					for (int J = 0; J < list_ghfkmx_zf.size(); J++) {
						Map<String, Object> map_fkxx_zf = list_ghfkmx_zf.get(J);
						if (map_fkxx_zf.containsKey("FKFS")) {
							if (Long.parseLong(map_fkxx.get("FKFS") + "") == Long
									.parseLong(map_fkxx_zf.get("FKFS") + "")) {
								map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx_all.get("FKJE") + "")
										- ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE") + ""));
								list_ghfkmx_zf.remove(J);
								J--;
							}
						}
					}
				}
				list_ghrb_fkmx.add(map_fkxx_all);
			}

			if (list_ghfkmx_zf != null && list_ghfkmx_zf.size() != 0) {
				for (int J = 0; J < list_ghfkmx_zf.size(); J++) {
					Map<String, Object> map_fkxx_zf = new CaseInsensitiveMap<String, Object>(list_ghfkmx_zf.get(J));
					if (map_fkxx_zf.containsKey("FKFS")) {
						Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
						map_fkxx_all.put("FKFS", map_fkxx_zf.get("FKFS"));
						map_fkxx_all.put("FKJE", -ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE") + ""));
						map_fkxx_all.put("CZGH", uid);
						map_fkxx_all.put("JGID", jgid);
						map_fkxx_all.put("JZRQ", jzrq);
						list_ghrb_fkmx.add(map_fkxx_all);
						list_ghfkmx_zf.remove(J);
						J--;
					}
				}
			}

		} else {
			if (list_ghfkmx_zf != null && list_ghfkmx_zf.size() != 0) {
				for (int k = 0; k < list_ghfkmx_zf.size(); k++) {
					Map<String, Object> map_fkxx_zf = new CaseInsensitiveMap<String, Object>(list_ghfkmx_zf.get(k));
					Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
					map_fkxx_all.put("FKFS", map_fkxx_zf.get("FKFS"));
					map_fkxx_all.put("CZGH", uid);
					map_fkxx_all.put("FKJE", -ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE") + ""));
					map_fkxx_all.put("JGID", jgid);
					map_fkxx_all.put("JZRQ", jzrq);
					list_ghrb_fkmx.add(map_fkxx_all);
				}
			}
		}

		if (map_ghrb_all != null && map_ghrb_all.size() > 0) {
//				response.put("GHF", ghje + "");
//				response.put("ZLF", zlje + "");
//				response.put("BLF", blje + "");
//				response.put("ZJF", zjfy + "");

			// response.put("GHHJ", String.format("%1$.2f", ghhj));
			response.put("GHHJ", String.format("%1$.2f", ghhj - ObjectToTypes.parseDouble(map_ghrb_all.get("HBWC"))));

		}
		// TODO 注释掉
		/*
		 * Map<String, Object> jcparameters = new HashMap<String, Object>();
		 * jcparameters.put("CZGH", uid); jcparameters.put("JGID", jgid);
		 * jcparameters.put("MZLB", mzlb); jcparameters.put("JZRQ", (String)
		 * request.get("jzrq")); List<Map<String, Object>> jcxm_list =
		 * opMzxxDao.doQueryJcxmRb(jcparameters); double jchj = 0.0; for (int i = 0; i <
		 * jcxm_list.size(); i++) { jchj = jchj +
		 * ObjectToTypes.parseDouble(jcxm_list.get(i).get("ZJJE")); }
		 */
		Map<String, Object> yjkparameters = new HashMap<String, Object>();
		yjkparameters.put("CZGH", uid);
		yjkparameters.put("JGID", jgid);
		yjkparameters.put("MZLB", mzlb);
		yjkparameters.put("JZRQ", jzrq);
//		Map<String, Object> yjk_map = opMzxxDao.doQueryYjkRb(parameters);
//		Map<String, Object> jkzf_map = opMzxxDao.doQueryJkZf(parameters);
		response.put("HJHJ", String.format("%.2f", sfhj - ObjectToTypes.parseDouble(map_mzxx_all.get("HBWC"))
				- ObjectToTypes.parseDouble(map_mzxx_all.get("JMJE"))));// String.format("%.2f",
		// f)
//			response.put("HJHJ", String.format("%.2f", sfhj+ObjectToTypes.parseDouble(map_mzxx_all.get("HBWC"))- ObjectToTypes.parseDouble(map_mzxx_all.get("JMJE"))- ObjectToTypes.parseDouble(map_mzxx_all.get("HBWC"))));//String.format("%.2f", f)
		// TODO 注释掉
		// response.put("JCHJ", String.format("%.2f", jchj));
//		response.put("SYJJ", String.format("%1$.2f", yjk_map.get("JKJE")));
//		response.put("TYJJ", String.format("%1$.2f", jkzf_map.get("JKJE")));

		// 居家合计 //doGetParameters
//			String jjhjsql = " select sum(a.JKHJ) as JKHJ from  LNHL_JS a where a.JGID=:JGID and a.JSRQ <= :jsrq and to_char(JZRQ,'yyyy-mm-dd hh24:mi:ss')=:JZRQ and a.CZGH=:CZGH and a.ZFPB <> 1  ";

		// TODO 注释掉
		/*
		 * double jjhj = 0.00; Map<String, Object> params = new HashMap<String,
		 * Object>(); params.put("CZGH", uid); params.put("JGID", jgid);
		 * params.put("mzlb", mzlb); params.put("JZRQ", (String) request.get("jzrq"));
		 * Map<String, Object> hl_map = opMzxxDao.doQueryJjhj(params); jjhj =
		 * ObjectToTypes.toDouble(hl_map.get("JKHJ")); response.put("JJHJ",
		 * String.format("%.2f", jjhj));
		 */

		// double dxje = sfhj + ghhj + jchj + jjhj +
		// ObjectToTypes.parseDouble(yjk_map.get("JKJE")) -
		// ObjectToTypes.parseDouble(jkzf_map.get("JKJE"))-ObjectToTypes.parseDouble(map_mzxx_all.get("JMJE"))-ObjectToTypes.parseDouble(map_mzxx_all.get("HBWC"));
//		double dxje = sfhj + ghhj + jchj + jjhj + ObjectToTypes.parseDouble(yjk_map.get("JKJE"))
		double dxje = sfhj + ghhj - ObjectToTypes.parseDouble(map_mzxx_all.get("JMJE"))
				- ObjectToTypes.parseDouble(map_mzxx_all.get("HBWC"))
				- ObjectToTypes.parseDouble(map_ghrb_all.get("HBWC"));
//			double dxje = sfhj + ghhj + jchj + jjhj + ObjectToTypes.parseDouble(yjk_map.get("JKJE")) - ObjectToTypes.parseDouble(jkzf_map.get("JKJE"))-ObjectToTypes.parseDouble(map_mzxx_all.get("JMJE"))-ObjectToTypes.parseDouble(map_mzxx_all.get("HBWC"));
		String dxjeBig = String.format("%1$.2f", new BigDecimal(ObjectToTypes.null2Str(dxje)));
		if (dxje < 0) {
			response.put("amountIn",
					"负" + MzUtil.changeMoneyUpper(String.format("%1$.2f", -(dxje))) + "(" + (dxjeBig) + ")");
		} else {
			response.put("amountIn", MzUtil.changeMoneyUpper(String.format("%1$.2f", dxje)) + "(" + dxjeBig + ")");
		}

//			hql_jzhm.append("select JZHM as PJHM from OP_GHMX where JGID = :jgid  and MZLB = :mzlb and CZGH = :czgh and to_char(JZRQ,'yyyy-mm-dd hh24:mi:ss')=:JZRQ and JZHM not like 'MGH%'");

//			List<Map<String, Object>> list_jzhm = dao.doQuery(
//					hql_jzhm.toString(), parameters);
		List<Map<String, Object>> list_jzhm_zf = opMzxxDao.doQueryJzhmzfRbA(parameters);
//			String beginjzhm = "";
//			String endjzhm = "";
//			long currentjzhm = 0;
//			if (list_jzhm != null && list_jzhm.size() > 0) {
//				try {
//					Collections.sort(list_jzhm,
//							new Comparator<Map<String, Object>>() {
//								@Override
//								public int compare(Map<String, Object> map1,
//										Map<String, Object> map2) {
//									String jzhm1 = (String) map1.get("PJHM");
//									String jzhm2 = (String) map2.get("PJHM");
//									return jzhm1.compareTo(jzhm2);
//								}
//							});
//				} catch (RuntimeException e) {
//					e.printStackTrace();
//				}
//				for (int i = 0; i < list_jzhm.size(); i++) {
//					Map<String, Object> map_jzxx = list_jzhm.get(i);
//					if (i == 0) {
//						beginjzhm = map_jzxx.get("PJHM").toString();
//						currentjzhm = Long.parseLong(map_jzxx.get("PJHM")
//								.toString());
//					}
//					if (Long.parseLong(map_jzxx.get("PJHM").toString()) != currentjzhm) {
//						endjzhm = list_jzhm.get(i - 1).get("PJHM").toString();
//						jzhmxx = InvoiceSequence(jzhmxx, beginjzhm, endjzhm);
//						beginjzhm = map_jzxx.get("PJHM").toString();
//						currentjzhm = Long.parseLong(map_jzxx.get("PJHM")
//								.toString());
//					}
//					currentjzhm++;
//				}
//				endjzhm = list_jzhm.get(list_jzhm.size() - 1).get("PJHM")
//						.toString();
//				jzhmxx = InvoiceSequence(jzhmxx, beginjzhm, endjzhm);
//			}

		if (list_jzhm_zf != null && list_jzhm_zf.size() > 0) {
//				try {
//					Collections.sort(list_jzhm_zf,
//							new Comparator<Map<String, Object>>() {
//								@Override
//								public int compare(Map<String, Object> map1,
//										Map<String, Object> map2) {
//									String jzhm1 = (String) map1.get("PJHM");
//									String jzhm2 = (String) map2.get("PJHM");
//									return jzhm1.compareTo(jzhm2);
//								}
//							});
//				} catch (RuntimeException e) {
//					e.printStackTrace();
//				}
//				for (int i = 0; i < list_jzhm_zf.size(); i++) {
//					Map<String, Object> map_jzxx_zf = list_jzhm_zf.get(i);
//					if (i == 0) {
//						beginjzhm = map_jzxx_zf.get("PJHM").toString();
//						currentjzhm = Long.parseLong(map_jzxx_zf.get("PJHM")
//								.toString());
//					}
//					if (Long.parseLong(map_jzxx_zf.get("PJHM").toString()) != currentjzhm) {
//						endjzhm = list_jzhm_zf.get(i - 1).get("PJHM")
//								.toString();
//						thjzhmxx = InvoiceSequence(thjzhmxx, beginjzhm, endjzhm);
//						beginjzhm = map_jzxx_zf.get("PJHM").toString();
//						currentjzhm = Long.parseLong(map_jzxx_zf.get("PJHM")
//								.toString());
//					}
//					currentjzhm++;
//				}
//				endjzhm = list_jzhm_zf.get(list_jzhm_zf.size() - 1).get("PJHM")
//						.toString();
//				thjzhmxx = InvoiceSequence(thjzhmxx, beginjzhm, endjzhm);
			thjzhmxx.append("退号:");
			for (int i = 0; i < list_jzhm_zf.size(); i++) {
				Map<String, Object> thfp_map = new CaseInsensitiveMap<String, Object>(list_jzhm_zf.get(i));
				thjzhmxx.append(thfp_map.get("PJHM") + "(" + thfp_map.get("BRXM") + "," + thfp_map.get("FKMC") + ":"
						+ thfp_map.get("FKJE") + ") ");
			}
		}
		if (map_ghrb_all != null && map_ghrb_all.size() > 0) {
//				response.put("JZHM", jzhmxx);
			response.put("invalidgh", thjzhmxx.toString());
			response.put("invalidghAmount", thxx);
//				map_ghrb_all.put("QZPJ", jzhmxx);
			map_ghrb_all.put("THFP", thjzhmxx.toString());
		}

		if ((map_ghrb_all != null && map_ghrb_all.size() > 0) || (map_mzxx_all != null && map_mzxx_all.size() > 0)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Map<String, Object> jzrqMap = new HashMap<String, Object>();
			jzrqMap.put("JGID", jgid);
			jzrqMap.put("CZGH", uid);
			// 查询上次结账时间
//				Map<String, Object> jzrqmapsf = dao
//						.doLoad("select max(JZRQ) as JZRQ from  OP_HZRB where JGID=:JGID and CZGH=:CZGH",
//								jzrq);
//				Map<String, Object> jzrqmapgh = dao
//						.doLoad("select max(JZRQ) as JZRQ from  OP_GHRB where JGID=:JGID and CZGH=:CZGH",
//								jzrq); 

			// 注释原来的逻辑并更改 查询上次结账日期 应该取次大的 最大是当前结账日期
			Map<String, Object> jzrqmapsf = opMzxxDao.doQuerySfrbA(jzrqMap);
			Map<String, Object> jzrqmapgh = opMzxxDao.doQueryGhrbA(jzrqMap);
			if ((jzrqmapsf != null && jzrqmapgh != null) && jzrqmapsf.get("JZRQ") != null
					&& jzrqmapgh.get("JZRQ") != null) {
				DateTime jzrqmapsfDate = DateUtil.parse(jzrqmapsf.get("JZRQ") + "", "yyyy-MM-dd HH:mm:ss");
				DateTime jzrqmapghDate = DateUtil.parse(jzrqmapgh.get("JZRQ") + "", "yyyy-MM-dd HH:mm:ss");
				java.util.Date jzrqsf = DateUtil.date(jzrqmapsfDate);
				java.util.Date jzrqgh = DateUtil.date(jzrqmapghDate);
				if (jzrqsf.getTime() > jzrqgh.getTime()) {
					response.put("KSRQ", MzUtil.toString(jzrqsf, "yyyy-MM-dd HH:mm:ss"));
				} else {
					response.put("KSRQ", MzUtil.toString(jzrqgh, "yyyy-MM-dd HH:mm:ss"));
				}
			} else if (jzrqmapsf != null && jzrqmapsf.get("JZRQ") != null) {
				DateTime jzrqmapsfDate = DateUtil.parse(jzrqmapsf.get("JZRQ") + "", "yyyy-MM-dd HH:mm:ss");
				java.util.Date jzrqsf = DateUtil.date(jzrqmapsfDate);
				response.put("KSRQ", MzUtil.toString(jzrqsf, "yyyy-MM-dd HH:mm:ss"));
			} else if (jzrqmapgh != null && jzrqmapgh.get("JZRQ") != null) {
				DateTime jzrqmapghDate = DateUtil.parse(jzrqmapgh.get("JZRQ") + "", "yyyy-MM-dd HH:mm:ss");
				java.util.Date jzrqgh = DateUtil.date(jzrqmapghDate);
				response.put("KSRQ", MzUtil.toString(jzrqgh, "yyyy-MM-dd HH:mm:ss"));
			} else {
				Map<String, Object> sfrqorghrq = new HashMap<String, Object>();
				sfrqorghrq.put("JGID", jgid);
				sfrqorghrq.put("CZGH", uid);
				// 查询上次结账时间
				Map<String, Object> sfrqmap = opMzxxDao.doQueryMinSfrq(sfrqorghrq);
				Map<String, Object> ghrqmap = opMzxxDao.doQueryMinGhsj(sfrqorghrq);
				if ((sfrqmap != null && ghrqmap != null) && sfrqmap.get("SFRQ") != null
						&& ghrqmap.get("GHSJ") != null) {
					DateTime sfrqmapDate = DateUtil.parse(sfrqmap.get("SFRQ") + "", "yyyy-MM-dd HH:mm:ss");
					DateTime ghrqmapDate = DateUtil.parse(ghrqmap.get("GHSJ") + "", "yyyy-MM-dd HH:mm:ss");
					java.util.Date sfrq = DateUtil.date(sfrqmapDate);
					java.util.Date ghsj = DateUtil.date(ghrqmapDate);
					if (sfrq.getTime() < ghsj.getTime()) {
						response.put("KSRQ", MzUtil.toString(sfrq, "yyyy-MM-dd HH:mm:ss"));
					} else {
						response.put("KSRQ", MzUtil.toString(ghsj, "yyyy-MM-dd HH:mm:ss"));
					}
				} else if (sfrqmap != null && sfrqmap.get("SFRQ") != null) {
					DateTime sfrqmapDate = DateUtil.parse(sfrqmap.get("SFRQ") + "", "yyyy-MM-dd HH:mm:ss");
					java.util.Date sfrq = DateUtil.date(sfrqmapDate);
					response.put("KSRQ", MzUtil.toString(sfrq, "yyyy-MM-dd HH:mm:ss"));
				} else if (ghrqmap != null && ghrqmap.get("GHSJ") != null) {
					DateTime ghrqmapDate = DateUtil.parse(ghrqmap.get("GHSJ") + "", "yyyy-MM-dd HH:mm:ss");
					java.util.Date ghsj = DateUtil.date(ghrqmapDate);
					response.put("KSRQ", MzUtil.toString(ghsj, "yyyy-MM-dd HH:mm:ss"));
				}

			}
			response.put("toll", userName);
			response.put("SFRQ", MzUtil.getDateTime());
			response.put("Lister", userName);
			response.put("dateTabling", DateUtil.date().toSqlDate());

//			if (request.get("jzrq_2") != null && !"undefined".equals(request.get("jzrq_2"))) {
//				response.put("KSRQ", request.get("jzrq_2"));
//			}
//			if (request.get("ksrq_2") != null && !"undefined".equals(request.get("jzrq_2"))) {
//				response.put("SFRQ", request.get("ksrq_2"));
//			}
//				if((request.get("jzrq_2")!=null)&&(request.get("ksrq_2")!=null)){
//					if(request.get("jzrq_2").toString().equals(request.get("ksrq_2").toString())){
//						/*String sql ="  SELECT TO_CHAR(MAX(JZRQ),'yyyy-MM-dd HH24:mi:ss') as  KSRQ  FROM  OP_HZRB WHERE JZRQ < to_date('"+request.get("jzrq_2").toString()+"','yyyy-MM-dd HH24:mi:ss')  ORDER BY  JZRQ  DESC     ";
//						 List<Map<String, Object>> list = dao.doSqlQuery(sql, null);
//						 if(list!=null){
//							 response.put("KSRQ",list.get(0).get("KSRQ").toString());
//							 System.out.println(list.get(0).get("KSRQ").toString()+"=============修改收费日报的打印时间====  saveSign=2     ===================");
//						 }*/
//					}
//				}
			// 如果开始日期和收费日期相同，要从数据库取出一个日期时间
		}
		List<Map<String, Object>> list_sfrb_fkmx_copy = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list_ghrb_fkmx_copy = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list_fkmx_all = new ArrayList<Map<String, Object>>();

		list_sfrb_fkmx_copy.addAll(list_sfrb_fkmx);
		list_ghrb_fkmx_copy.addAll(list_ghrb_fkmx);
		if (list_sfrb_fkmx_copy != null && list_sfrb_fkmx_copy.size() != 0) {
			for (int i = 0; i < list_sfrb_fkmx_copy.size(); i++) {
				Map<String, Object> map_fkxx = new CaseInsensitiveMap<String, Object>(list_sfrb_fkmx_copy.get(i));
				Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
				map_fkxx_all.put("FKFS", map_fkxx.get("FKFS"));
				map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx.get("FKJE")));
				if (list_ghrb_fkmx_copy != null && list_ghrb_fkmx_copy.size() != 0) {
					for (int J = 0; J < list_ghrb_fkmx_copy.size(); J++) {
						Map<String, Object> map_fkxx_zf = new CaseInsensitiveMap<String, Object>(
								list_ghrb_fkmx_copy.get(J));
						if (map_fkxx_zf.containsKey("FKFS")) {
							if (Long.parseLong(map_fkxx.get("FKFS") + "") == Long
									.parseLong(map_fkxx_zf.get("FKFS") + "")) {
								map_fkxx_all.put("FKJE", ObjectToTypes
										.parseDouble((ObjectToTypes.parseDouble(map_fkxx_all.get("FKJE") + "")
												+ ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE") + "")) + ""));
								list_ghrb_fkmx_copy.remove(J);
								J--;
							}
						}
					}
				}
				list_fkmx_all.add(map_fkxx_all);
			}

			if (list_ghrb_fkmx_copy != null && list_ghrb_fkmx_copy.size() != 0) {
				for (int J = 0; J < list_ghrb_fkmx_copy.size(); J++) {
					Map<String, Object> map_fkxx_zf = new CaseInsensitiveMap<String, Object>(
							list_ghrb_fkmx_copy.get(J));
					if (map_fkxx_zf.containsKey("FKFS")) {
						Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
						map_fkxx_all.put("FKFS", map_fkxx_zf.get("FKFS"));
						map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE") + ""));
						list_fkmx_all.add(map_fkxx_all);
						list_ghrb_fkmx_copy.remove(J);
						J--;
					}
				}
			}

		} else {
			if (list_ghrb_fkmx_copy != null && list_ghrb_fkmx_copy.size() != 0) {
				for (int k = 0; k < list_ghrb_fkmx_copy.size(); k++) {
					Map<String, Object> map_fkxx_zf = new CaseInsensitiveMap<String, Object>(
							list_ghrb_fkmx_copy.get(k));
					Map<String, Object> map_fkxx_all = new HashMap<String, Object>();
					map_fkxx_all.put("FKFS", map_fkxx_zf.get("FKFS"));
					map_fkxx_all.put("FKJE", ObjectToTypes.parseDouble(map_fkxx_zf.get("FKJE") + ""));
					list_fkmx_all.add(map_fkxx_all);
				}
			}
		}

		if (list_fkmx_all.size() > 0) {
			for (Map<String, Object> map_fkxx : list_fkmx_all) {
				Map<String, Object> map_fkxxs = new HashMap<String, Object>();
				PubFkfsModel pubFkfs = pubFkfsService.getById(Integer.valueOf(map_fkxx.get("FKFS").toString()));
				map_fkxxs.put("FKFS", pubFkfs.getFkmc());
				fkxx = fkxx + map_fkxxs.get("FKFS") + ":" + String.format("%1$.2f", map_fkxx.get("FKJE"));
			}
		}
//			response.put("syb", String.format("%1$.2f",
//					((syb - sybzf) + (ghsyb - ghsybth))));
//			response.put("szyb", String.format("%1$.2f",
//					((sjyb - sjybzf) + (ghsjyb - ghsjybth))));
//			if ((map_ghrb_all != null && map_ghrb_all.size() > 0)
//					|| (map_mzxx_all != null && map_mzxx_all.size() > 0)) {
//				response.put("amount", fkxx);
//			}

//	  //性质不为“0”时的按收费性质统计的QTYS
//			//门诊_门诊收费信息
//			List<Map<String, Object>> map_xztj = new ArrayList<Map<String, Object>>();
//			StringBuffer sql_xztj = new StringBuffer();
//			Map<String, Object> parameters2 = new HashMap<String, Object>();
//			parameters2.put("jgid", jgid);
//			parameters2.put("czgh", uid);
//			parameters2.put("mzlb", mzlb);
//			sql_xztj.append(" select g.XZMC as XZMC,f.XZDM as XZDM ,f.QTYS as QTYS from (" +
//			                     " select XZDM,sum(QTYS) as QTYS from ("+
//					                  " select  b.BRXZ as XZDM, sum(a.QTYS) as QTYS  from OP_MZXX a   left join PUB_BRXZ b  on a.brxz = b.brxz" +
//			                          " where a.JGID =:jgid and a.to_char(JZRQ,'yyyy-mm-dd hh24:mi:ss')=:JZRQ  and a.MZLB  in (:mzlb) and a.CZGH = :czgh   and b.DBPB != '0' and a.ZFPB=0"+
//					                  "  group by b.BRXZ "+
//			                      " UNION all"+
//				                      " select  b.BRXZ as XZDM, sum(a.QTYS) as QTYS  from OP_GHMX a   left join PUB_BRXZ b  on a.brxz = b.brxz" +
//		                              " where a.JGID =:jgid and a.to_char(JZRQ,'yyyy-mm-dd hh24:mi:ss')=:JZRQ  and a.MZLB  in (:mzlb) and a.CZGH =:czgh   and b.DBPB != '0' and a.THBZ=0"+
//				                      "  group by b.BRXZ"+
//			                    "  )group by XZDM"+
//					        " ) f left join PUB_BRXZ g on f.XZDM = g.brxz"); 
//			map_xztj = dao.doSqlQuery(sql_xztj.toString(), parameters2);
//			if (map_xztj != null && map_xztj.size() != 0) {
//				 for(int i=0;i<map_xztj.size();i++){
//					 fkxx = fkxx +map_xztj.get(i).get("XZMC")+ ":"
//								+ String.format("%1$.2f",map_xztj.get(i).get("QTYS"))
//								+ " ";
//				 }
//			}
//	 //性质为“0”时的统计QTYS
//			List<Map<String, Object>> map_qtys = new ArrayList<Map<String, Object>>();
//			StringBuffer sql_qtys = new StringBuffer();
//			sql_qtys.append(" select sum(QTYS) as QTYS from (" +
//				                	"select  sum(a.QTYS) as QTYS " +
//				            	        " from OP_MZXX a left join PUB_BRXZ b on a.brxz=b.brxz " +
//					                    " where a.JGID=:jgid and a.to_char(JZRQ,'yyyy-mm-dd hh24:mi:ss')=:JZRQ and a.MZLB  in (:mzlb) and a.CZGH=:czgh and b.DBPB='0' and a.ZFPB=0" +
//					                    " group by b.DBPB , a.CZGH " +
//					          " UNION all " +
//					                " select  sum(a.QTYS) as QTYS " +
//			            	        " from OP_GHMX a left join PUB_BRXZ b on a.brxz=b.brxz " +
//				                    " where a.JGID=:jgid and a.to_char(JZRQ,'yyyy-mm-dd hh24:mi:ss')=:JZRQ and a.MZLB  in (:mzlb) and a.CZGH=:czgh and b.DBPB='0' and a.THBZ=0" +
//				                    " group by b.DBPB , a.CZGH) "); 
//			map_qtys = dao.doSqlQuery(sql_qtys.toString(), parameters2);
//			if (map_qtys != null && map_qtys.size() != 0&&map_qtys.get(0).get("QTYS")!=null) {
//				fkxx = fkxx+" " + "记账:"
//								+ String.format("%1$.2f",map_qtys.get(0).get("QTYS"))
//								+ " ";
//			}   
//			 qtysFb=fkxx;
//			 response.put("qtysFb", qtysFb);
		/*
		 * String sql_brxz =
		 * "select sum(c.QTYS) as QTYS,c.BRXZ as BRXZ,d.XZMC as XZMC,nvl(d.DBPB,0) as DBPB from ("
		 * +
		 * "select BRXZ as BRXZ,QTYS as QTYS from OP_MZXX where JGID=:jgid and to_char(JZRQ,'yyyy-mm-dd hh24:mi:ss')=:JZRQ and MZLB = :mzlb and CZGH = :czgh"
		 * + " union all "+
		 * "select a.BRXZ as BRXZ,(-1*a.QTYS) as QTYS from OP_MZXX a,OP_ZFFP b where a.MZXH = b.MZXH and b.JGID=:jgid and to_char(b.JZRQ,'yyyy-mm-dd hh24:mi:ss')=:JZRQ and b.MZLB = :mzlb and b.CZGH = :czgh"
		 * + " union all "+
		 * "select BRXZ as BRXZ,QTYS as QTYS from OP_GHMX where JGID=:jgid and to_char(JZRQ,'yyyy-mm-dd hh24:mi:ss')=:JZRQ and MZLB = :mzlb and CZGH = :czgh and JZHM not like 'MGH%' and nvl(ZKBZ,0)=0  "
		 * + " union all "+
		 * "select BRXZ as BRXZ,QTYS as QTYS from OP_GHMX_ZK where JGID=:jgid and to_char(JZRQ,'yyyy-mm-dd hh24:mi:ss')=:JZRQ and MZLB = :mzlb and CZGH = :czgh and JZHM not like 'MGH%' and nvl(ZKBZ,0)=0"
		 * + " union all "+
		 * "select a.BRXZ as BRXZ,(-1*a.QTYS) as QTYS from OP_GHMX a,OP_THMX b where a.SBXH = b.SBXH and b.JGID=:jgid and to_char(b.JZRQ,'yyyy-mm-dd hh24:mi:ss')=:JZRQ and b.MZLB = :mzlb and b.CZGH = :czgh and a.JZHM not like 'MGH%'"
		 * + " union all "+
		 * "select BRXZ as BRXZ,FYHJ-ZFHJ as QTYS from JC_JCJS where JGID=:jgid and to_char(JZRQ,'yyyy-mm-dd hh24:mi:ss')=:JZRQ and CZGH = :czgh and MZLB = :mzlb"
		 * + " union all "+
		 * "select a.BRXZ as BRXZ,(-1*(a.FYHJ-a.ZFHJ)) as QTYS from JC_JCJS a,JC_JSZF b where a.ZYH = b.ZYH and a.JSCS = b.JSCS and b.JGID=:jgid and to_char(b.JZRQ,'yyyy-mm-dd hh24:mi:ss')=:JZRQ and b.ZFGH = :czgh and b.MZLB = :mzlb"
		 * + " union all "+
		 * "select a.BRXZ as BRXZ,a.FYHJ-a.ZFHJ as QTYS from LNHL_JS a where  a.JGID = :jgid and to_char(a.JZRQ,'yyyy-mm-dd hh24:mi:ss')=:JZRQ and a.MZLB = :mzlb and a.CZGH = :czgh "
		 * + " union all "+
		 * "select a.BRXZ as BRXZ,(-1*(a.FYHJ-a.ZFHJ)) as QTYS from LNHL_FPZF a where  a.JGID = :jgid and to_char(a.JZRQ,'yyyy-mm-dd hh24:mi:ss')=:JZRQ and a.MZLB = :mzlb and a.ZFGH = :czgh "
		 * +
		 * ") c left outer join PUB_BRXZ d on c.BRXZ = d.BRXZ group by c.BRXZ,d.XZMC,d.DBPB"
		 * ;
		 */

		List<Map<String, Object>> ids_fkfs = opMzxxDao.doQueryFkfs(parameters);
		List<Map<String, Object>> ids_brxz = opMzxxDao.doQueryBrxzRb(parameters);
		String qtysFb = "";
		String jzjeSt = "0.00";
		String POSZJ = "0.00";// POS总金额
		String YBZJ = "0.00";// 医保总金额
		if (ids_fkfs != null && ids_fkfs.size() != 0) {
			for (int j = 0; j < ids_fkfs.size(); j++) {
				if ("3".equals(ids_fkfs.get(j).get("FKFS") + "") || "12".equals(ids_fkfs.get(j).get("FKFS") + "")
						|| "18".equals(ids_fkfs.get(j).get("FKFS") + "")
						|| "21".equals(ids_fkfs.get(j).get("FKFS") + "")
						|| "23".equals(ids_fkfs.get(j).get("FKFS") + "")
						|| "24".equals(ids_fkfs.get(j).get("FKFS") + "")) {
					POSZJ = String.format("%1$.2f",
							ObjectToTypes.parseDouble(POSZJ) + ObjectToTypes.parseDouble(ids_fkfs.get(j).get("FKJE")));

				}
			}
			for (int j = 0; j < ids_fkfs.size(); j++) {
				Map m = new CaseInsensitiveMap<String, Object>(ids_fkfs.get(j));
//					if("1".equals(StrUtil.null2Str(m.get("FKFS"))) ){
//						double FKJE = NumUtil.toDouble(m.get("FKJE"))+jjhj;
//						double FKJE = NumUtil.toDouble(m.get("FKJE"));
//						m.put("FKJE",FKJE);
//					 }
				qtysFb = qtysFb + m.get("FKMC") + ":" + String.format("%1$.2f", m.get("FKJE")) + " ";
			}
		}
		if (ids_brxz != null && ids_brxz.size() != 0) {

			for (int j = 0; j < ids_brxz.size(); j++) {
				if ("4001".equals(ids_brxz.get(j).get("BRXZ") + "") || "4001".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "6023".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "45".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "39".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "36".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "35".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "34".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "33".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "32".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "28".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "19".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "23".equals(ids_brxz.get(j).get("BRXZ") + "")// 离休
						|| "29".equals(ids_brxz.get(j).get("BRXZ") + "")) {

					YBZJ = String.format("%1$.2f", ObjectToTypes.parseDouble(YBZJ)
							+ ObjectToTypes.parseDouble(ids_brxz.get(j).get("QTYS") + ""));
				}
			}

			for (int j = 0; j < ids_brxz.size(); j++) {
				if (Integer.parseInt(ids_brxz.get(j).get("DBPB") + "") == 0) {
					jzjeSt = String.format("%1$.2f", ObjectToTypes.parseDouble(jzjeSt)
							+ ObjectToTypes.parseDouble(ids_brxz.get(j).get("QTYS") + ""));
				} else {
					qtysFb = qtysFb + ids_brxz.get(j).get("XZMC") + ":"
							+ String.format("%1$.2f", ObjectToTypes.parseDouble(ids_brxz.get(j).get("QTYS") + ""))
							+ " ";
				}
			}
			qtysFb = qtysFb + " " + "记账 :" + jzjeSt + " ";
			qtysFb = qtysFb + "POS总金额：" + POSZJ + ",医保总金额:" + YBZJ + " ";
		}
		response.put("qtysFb", qtysFb);

		// 转科转号的发票信息
//			if (map_mzxx_all != null && map_mzxx_all.size() > 0) {
		int numPage = ObjectToTypes.toInt(response.get("numPage")); // 发票总数

		StringBuilder ZKFP = new StringBuilder();
		List<Map<String, Object>> zkList = opMzxxDao.doQueryJzhmBridRb(parameters);
		int zkfps = zkList == null ? 0 : zkList.size(); // 转科发票数
		for (int i = 0; i < zkfps; i++) {
			Map m = new CaseInsensitiveMap<String, Object>(zkList.get(i));
			ZKFP.append(m.get("JZHM") + "（" + m.get("BRXM") + "） ");
		}

		numPage = numPage == 0 ? fpzsSum - zkfps : numPage;
		response.put("yxfps", numPage); // 有效发票数
		response.put("zkfpxx", "转科:" + ZKFP.toString());
		response.put("numPage", numPage + zkfps);
		return response;
	}

	private Map<String, Object> addFphmForPrint(java.util.Date jzrq, Map<String, Object> response, Integer userId,
			String userName, Integer jgid, Integer mzlb) {
		boolean flag = true;
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("jgid", jgid);
		parameters.put("czgh", userId);
		parameters.put("mzlb", mzlb);
		String qtysFb = "";
//		List<Map<String, Object>> list = jcJcjsDao.doQueryFyhj(parameters);
//		BigDecimal hj = (BigDecimal) list.get(0).get("HJ");
//		double temp = hj == null ? 0 : hj.doubleValue();
		List<Map<String, Object>> list_fpxx = opMzxxDao.doQueryFphmFpzsRbA(parameters);
		Map<String, Object> parameters2 = new HashMap<String, Object>();
		parameters2.put("czgh", userId);
		parameters2.put("jgid", jgid);
		parameters2.put("mzlb", mzlb);
		List<Map<String, Object>> ids_fkfs = opFkxxDao.doQueryFkje(parameters2);
		if (ids_fkfs != null && ids_fkfs.size() != 0) {
			for (int j = 0; j < ids_fkfs.size(); j++) {
				qtysFb = qtysFb + ids_fkfs.get(j).get("FKMC") + ":"
						+ String.format("%1$.2f", ids_fkfs.get(j).get("FKJE")) + " ";
//				temp -= ((BigDecimal) ids_fkfs.get(j).get("FKJE")).doubleValue();
			}
		}
//		if (!qtysFb.equals("")) {
//			qtysFb += " 普通医保：" + String.format("%1$.2f", temp);
//		}

		StringBuffer fphms = new StringBuffer("发票号码：");
		int _fpzs = 0;
		for (Map<String, Object> map : list_fpxx) {
			if (flag) {
				fphms.append(map.get("FPHM"));
				flag = false;
			} else {
				fphms.append("-" + map.get("FPHM"));
			}
			int fpzs = map.get("FPZS") != null ? Integer.parseInt(map.get("FPZS").toString()) : 0;
			_fpzs += fpzs;
		}
		if (0.00 == ObjectToTypes.parseDouble(ObjectToTypes.null2Str(response.get("JCHJ")))) {
//			response.put("JCHJ", String.format("%1$.2f", hj));
		}
		response.put("FPHM", fphms.toString());
		response.put("toll", userName);

		response.put("KSRQ", MzUtil.toString(DateUtil.beginOfDay(DateUtil.date(jzrq)), "yyyy-MM-dd HH:mm:ss"));
		response.put("SFRQ", MzUtil.toString(jzrq, "yyyy-MM-dd HH:mm:ss"));
		response.put("numPage", _fpzs);
		response.put("GHHJ", "0.00");
		response.put("qtysFb", qtysFb);
		response.put("Lister", userId);
		response.put("dateTabling", DateUtil.date().toSqlDate());
		return response;
	}

	/**
	 * 
	 * @param jzrq
	 * @param uid
	 * @param jgid
	 * @param ip
	 * @param mzlb
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public Map<String, Object> doCheckout(java.util.Date jzrq, Integer uid, Integer jgid, String ip, Integer mzlb) {
		Map<String, Object> res = new HashMap<String, Object>();
		// 存收费日报明细OP_RBMX
		List<Map<String, Object>> list_rbmx = new ArrayList<Map<String, Object>>();
		// 存收费日报性质明细OP_XZMX
		List<Map<String, Object>> list_xzmx = new ArrayList<Map<String, Object>>();
		// 存收费日报付款明细OP_SFRB_FKMX
		List<Map<String, Object>> list_sfrb_fkmx = new ArrayList<Map<String, Object>>();
		// 存挂号日报付款明细OP_GHRB_FKMX
		List<Map<String, Object>> list_ghrb_fkmx = new ArrayList<Map<String, Object>>();
		Map<String, Object> map_mzxx_all = new HashMap<String, Object>();
		Map<String, Object> map_ghrb_all = new HashMap<String, Object>();
		List<Map<String, Object>> list_ghrbmx = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> jcxm_list = new ArrayList<Map<String, Object>>();
		this.doQueryDateInfo(jzrq, list_rbmx, list_xzmx, list_sfrb_fkmx, list_ghrb_fkmx, map_mzxx_all, map_ghrb_all,
				list_ghrbmx, jcxm_list, uid, jgid, ip);
		if ((map_mzxx_all == null || map_mzxx_all.size() == 0) && (map_ghrb_all == null || map_ghrb_all.size() == 0)
				&& (jcxm_list == null || jcxm_list.size() == 0)) {
			return res;
		}
		int count = 0;
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("czgh", uid);
		parameters.put("jgid", jgid);
		parameters.put("jzrq", MzUtil.toString(jzrq, "yyyy-MM-dd HH:mm:ss"));
		parameters.put("mzlb", mzlb);
		count = opMzxxDao.doQueryCountBySfrq(parameters);
		if (count > 0) {
			return res;
		}
		count = 0;
		count = opZffpDao.doQueryZffpCount(parameters);
		if (count > 0) {
			return res;
		}
		count = 0;
		count = opGhmxDao.doQueryCountByGhsj(parameters);
		if (count > 0) {
			return res;
		}
		count = 0;
		count = opThmxDao.doQueryThmxCount(parameters);
		if (count > 0) {
			return res;
		}

		Map<String, Object> parameters2 = new HashMap<String, Object>();
		parameters2.put("czgh", uid);
		parameters2.put("jgid", jgid);
		parameters2.put("mzlb", mzlb);
		List<Map<String, Object>> ids_fkfs = opFkxxDao.doQueryFkjeA(parameters2);
		List<Map<String, Object>> ids_brxz = opMzxxDao.doQueryBrxz(parameters2);
		String qtysFb = "";
		String jzjeSt = "0.00";
		String POSZJ = "0.00";// POS总金额
		String YBZJ = "0.00";// 医保总金额
		if (ids_fkfs != null && ids_fkfs.size() != 0) {
			for (int j = 0; j < ids_fkfs.size(); j++) {
				if ("3".equals(ids_fkfs.get(j).get("FKFS") + "") || "12".equals(ids_fkfs.get(j).get("FKFS") + "")
						|| "18".equals(ids_fkfs.get(j).get("FKFS") + "")
						|| "21".equals(ids_fkfs.get(j).get("FKFS") + "")
						|| "23".equals(ids_fkfs.get(j).get("FKFS") + "")
						|| "24".equals(ids_fkfs.get(j).get("FKFS") + "")) {
					POSZJ = String.format("%1$.2f",
							ObjectToTypes.parseDouble(POSZJ) + ObjectToTypes.parseDouble(ids_fkfs.get(j).get("FKJE")));

				}
			}
			for (int j = 0; j < ids_fkfs.size(); j++) {
				qtysFb = qtysFb + ids_fkfs.get(j).get("FKMC") + ":"
						+ String.format("%1$.2f", ids_fkfs.get(j).get("FKJE")) + " ";
			}
		}
		if (ids_brxz != null && ids_brxz.size() != 0) {
			for (int j = 0; j < ids_brxz.size(); j++) {
				if ("4001".equals(ids_brxz.get(j).get("BRXZ") + "") || "4001".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "6023".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "45".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "39".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "36".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "35".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "34".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "33".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "32".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "28".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "19".equals(ids_brxz.get(j).get("BRXZ") + "")
						|| "23".equals(ids_brxz.get(j).get("BRXZ") + "")// 离休
						|| "29".equals(ids_brxz.get(j).get("BRXZ") + "")) {

					YBZJ = String.format("%1$.2f", ObjectToTypes.parseDouble(YBZJ)
							+ ObjectToTypes.parseDouble(ids_brxz.get(j).get("QTYS") + ""));
				}
			}
			for (int j = 0; j < ids_brxz.size(); j++) {
				if (Integer.parseInt(ids_brxz.get(j).get("DBPB") + "") == 0) {
					jzjeSt = String.format("%1$.2f", ObjectToTypes.parseDouble(jzjeSt)
							+ ObjectToTypes.parseDouble(ids_brxz.get(j).get("QTYS") + ""));
				} else {
					qtysFb = qtysFb + ids_brxz.get(j).get("XZMC") + ":"
							+ String.format("%1$.2f", ObjectToTypes.parseDouble(ids_brxz.get(j).get("QTYS") + ""))
							+ " ";
				}
			}
			qtysFb = qtysFb + " " + "记账 :" + jzjeSt + " ";
			qtysFb = qtysFb + "POS总金额：" + POSZJ + ",医保总金额:" + YBZJ + " ";
		}
		res.put("qtysFb", qtysFb);

		logger.info("map_mzxx_all=" + map_mzxx_all);
		if (map_mzxx_all.size() > 0) {
			if (!"".equals(qtysFb) || "" != qtysFb) {
				// Map<String, Object> map_YSQT_all = new HashMap<String, Object>();
				map_mzxx_all.put("YSQTFB", qtysFb);
			}
			map_mzxx_all.put("MZLB", mzlb);
			OpHzrb opHzrb = BeanUtil.fillBeanWithMapIgnoreCase(map_mzxx_all, new OpHzrb(), true);
			opHzrbDao.insert(opHzrb);
		}
		if (list_rbmx.size() > 0) {
			for (Map<String, Object> map_rbmx : list_rbmx) {
				map_rbmx.put("MZLB", mzlb);
				OpRbmx opRbmx = BeanUtil.fillBeanWithMapIgnoreCase(map_rbmx, new OpRbmx(), true);
				opRbmxDao.insert(opRbmx);
			}
		}

		if (list_xzmx.size() > 0) {
			for (Map<String, Object> map_xzmx : list_xzmx) {
				map_xzmx.put("MZLB", mzlb);
				OpXzmx opXzmx = BeanUtil.fillBeanWithMapIgnoreCase(map_xzmx, new OpXzmx(), true);
				opXzmxDao.insert(opXzmx);
			}
		}

		if (list_sfrb_fkmx.size() > 0) {
			for (Map<String, Object> map_fkxx : list_sfrb_fkmx) {
				map_fkxx.put("MZLB", mzlb);
				OpSfrbFkmx opSfrbFkmx = BeanUtil.fillBeanWithMapIgnoreCase(map_fkxx, new OpSfrbFkmx(), true);
				opSfrbFkmxDao.insert(opSfrbFkmx);
			}
		}

		if (map_ghrb_all.size() > 0) {
			map_ghrb_all.put("MZLB", mzlb);
			OpGhrb opGhrb = BeanUtil.fillBeanWithMapIgnoreCase(map_ghrb_all, new OpGhrb(), true);
			opGhrbDao.insert(opGhrb);
		}

		if (list_ghrbmx.size() > 0) {
			for (Map<String, Object> map_rbmx : list_ghrbmx) {
				map_rbmx.put("MZLB", mzlb);
				OpGrmx opGrmx = BeanUtil.fillBeanWithMapIgnoreCase(map_rbmx, new OpGrmx(), true);
				opGrmxDao.insert(opGrmx);
			}
		}

		if (list_ghrb_fkmx.size() > 0) {
			for (Map<String, Object> map_fkxx : list_ghrb_fkmx) {
				map_fkxx.put("MZLB", mzlb);
				OpGhrbFkmx opGhrbFkmx = BeanUtil.fillBeanWithMapIgnoreCase(map_fkxx, new OpGhrbFkmx(), true);
				opGhrbFkmxDao.insert(opGhrbFkmx);
			}

		}

		Map<String, Object> parameters_update = new HashMap<String, Object>();
		parameters_update.put("jgid", jgid);
		parameters_update.put("czgh", uid);
		parameters_update.put("jzrq", MzUtil.toString(jzrq, "yyyy-MM-dd HH:mm:ss"));
		parameters_update.put("mzlb", mzlb);
		if (map_mzxx_all.size() > 0) {
			opMzxxDao.doUpdateJzrq(parameters_update);
			opZffpDao.doUpdateJzrq(parameters_update);
		}

		if (map_ghrb_all.size() > 0) {
			opGhmxDao.doUpdateJzrq(parameters_update);
			opGhmxDao.doUpdateJzrqByCondition(parameters_update);
			opThmxDao.doUpdateJzrq(parameters_update);
			opGhmxZkDao.doUpdateJzrq(parameters_update);
		}
		res.put("jzrq", MzUtil.toString(jzrq, "yyyy-MM-dd HH:mm:ss"));

		/********************** 家床 *************************/
//			String userid = (String) user.getUserId();
		Map<String, Object> jcparameters = new HashMap<String, Object>();
//			String ls_idt_jzrq = BSPHISUtil.toString(jzrq, "yyyy-MM-dd");
//		Date idt_jzrq = jzrq;
		jcparameters.put("idt_jzrq", MzUtil.toString(jzrq, "yyyy-MM-dd HH:mm:ss"));
		jcparameters.put("userid", uid);
		jcparameters.put("gl_jgid", jgid);
		jcparameters.put("mzlb", mzlb);
		// 日终结帐表单保存
//				Map<String, Object> jzxx = (Map<String, Object>) body.get("jzxx");
//				jzxx.put("SRJE", parseDouble(jzxx.get("SRJE")));
//				jzxx.put("SYB", parseDouble(jzxx.get("SYB")));
////				Date jzrq = BSPHISUtil.toDate((jzxx.get("JZRQ") + ""));
//				jzxx.put("JZRQ", idt_jzrq);
//				jzxx.put("QTYSFB", jzxx.get("qtysFb") + "");
//				dao.doSave("create", BSPHISEntryNames.JC_JZXX, jzxx, false);
		// 将作废发票1、作废收据2及退票号码3写入JC_ZFPJ
//				for (int i = 1; i < 4; i++) {
//					int ll_pjlb = i;
//					Map<String, Object> pjhms = (Map<String, Object>) body
//							.get("iws_pjxx" + i);
//					Map<String, Object> zfpj = new HashMap<String, Object>();
//					zfpj.put("JZRQ", idt_jzrq);
//					zfpj.put("CZGH", userid);
//					zfpj.put("PJLB", ll_pjlb);
//					zfpj.put("JGID", jgid);
//					for (int j = 1; j <= pjhms.size(); j++) {
//						zfpj.put("PJHM", pjhms.get(j + ""));
//						// hql =
//						// "INSERT INTO JC_ZFPJ(JZRQ, CZGH , PJLB ,PJHM,JGID) values( :idt_jzrq, :userid, :ll_pjlb, :pjhm, :gl_jgid)";
//						dao.doSave("create", BSPHISEntryNames.JC_ZFPJ, zfpj, false);
//					}
//				}

		// 将结帐日期写入JC_TBKK
		// TODO 注释掉
		/*
		 * long ll_Count = 0; // String ls_idt_End = body.get("idt_End") + "";
		 * jcparameters.put("ldt_End", idt_jzrq); jcparameters.remove("idt_jzrq");
		 * String hqlWhere =
		 * "CZGH = :userid AND JZRQ IS NULL AND JKRQ < :ldt_End  and JGID = :gl_jgid and MZLB  in (:mzlb) "
		 * ; ll_Count = dao.doCount("JC_TBKK", hqlWhere, jcparameters); String
		 * hql_update = ""; if (ll_Count > 0) { jcparameters.put("idt_jzrq", idt_jzrq);
		 * hql_update =
		 * "UPDATE JC_TBKK SET JZRQ = :idt_jzrq WHERE CZGH =:userid AND JZRQ IS NULL AND JKRQ < :ldt_End  and JGID = :gl_jgid and MZLB  in (:mzlb) "
		 * ; dao.doUpdate(hql_update, jcparameters); }
		 */

		// 将结帐日期写入JC_JKZF
		// TODO 注释掉
		/*
		 * jcparameters.remove("idt_jzrq"); ll_Count = 0; hqlWhere =
		 * "ZFGH = :userid AND JZRQ IS NULL AND ZFRQ < :ldt_End  and JGID = :gl_jgid and MZLB  in (:mzlb) "
		 * ; ll_Count = dao.doCount("JC_JKZF", hqlWhere, jcparameters); if (ll_Count >
		 * 0) { jcparameters.put("idt_jzrq", idt_jzrq); hql_update =
		 * "UPDATE JC_JKZF SET JZRQ = :idt_jzrq WHERE ZFGH = :userid AND JZRQ IS NULL AND ZFRQ < :ldt_End and JGID = :gl_jgid and MZLB  in (:mzlb) "
		 * ; dao.doUpdate(hql_update, jcparameters); }
		 */

		// 将结帐日期写入JC_JCJS
		// TODO 注释掉
		/*
		 * jcparameters.remove("idt_jzrq"); ll_Count = 0; hqlWhere =
		 * "CZGH = :userid AND JZRQ IS NULL AND JSRQ < :ldt_End  and JGID = :gl_jgid and MZLB  in (:mzlb) "
		 * ; ll_Count = dao.doCount("JC_JCJS", hqlWhere, jcparameters); if (ll_Count >
		 * 0) { jcparameters.put("idt_jzrq", idt_jzrq); hql_update =
		 * "UPDATE JC_JCJS SET JZRQ = :idt_jzrq WHERE CZGH = :userid AND JZRQ IS NULL AND JSRQ < :ldt_End and JGID = :gl_jgid and MZLB  in (:mzlb) "
		 * ; dao.doUpdate(hql_update, jcparameters); }
		 */

		// 将结帐日期写入JC_JSZF
		// TODO 注释掉
		/*
		 * jcparameters.remove("idt_jzrq"); ll_Count = 0; hqlWhere =
		 * "ZFGH = :userid AND JZRQ IS NULL AND ZFRQ < :ldt_End  and JGID = :gl_jgid  and MZLB  in (:mzlb) "
		 * ; ll_Count = dao.doCount("JC_JSZF", hqlWhere, jcparameters); if (ll_Count >
		 * 0) { jcparameters.put("idt_jzrq", idt_jzrq); hql_update =
		 * "UPDATE JC_JSZF SET JZRQ = :idt_jzrq WHERE ZFGH = :userid AND JZRQ IS NULL AND ZFRQ < :ldt_End  and JGID = :gl_jgid  and MZLB  in (:mzlb) "
		 * ; dao.doUpdate(hql_update, jcparameters); }
		 */
		// 将结账日期写入居家养老结算
		// TODO 注释掉
		/*
		 * Map<String, Object> jjparameters = new HashMap<String, Object>();
		 * jjparameters.put("CZGH", uid); jjparameters.put("JGID", jgid);
		 * jjparameters.put("JZRQ", jzrq); jjparameters.put("mzlb", mzlb); // 写入居家结算
		 * hql_update =
		 * "UPDATE LNHL_JS a SET a.JZRQ = :JZRQ WHERE a.JGID=:JGID  and a.JZRQ IS NULL and a.JSRQ < :JZRQ and a.CZGH=:CZGH and MZLB  in (:mzlb)"
		 * ; dao.doUpdate(hql_update, jjparameters); // 写入居家作废 hql_update =
		 * "UPDATE LNHL_FPZF a SET a.JZRQ = :JZRQ WHERE a.JGID=:JGID  and a.JZRQ IS NULL and a.ZFRQ < :JZRQ and a.ZFGH=:CZGH and MZLB  in (:mzlb)"
		 * ; dao.doUpdate(hql_update, jjparameters);
		 */
		return res;
	}

	private Map<String, Object> addZffp(Map<String, Object> response, Integer userId, Integer jgid, Integer mzlb) {
//		String hql_jczffpxx = "select b.FPHM as FPHM,1 as FPZS,b.ZFHJ as ZFJE,c.BRXM as BRXM,f.FKMC as FKMC,e.FKJE as FKJE from JC_JSZF a,JC_JCJS b,JC_BRRY d,MPI_BRDA c,JC_FKXX e,PUB_FKFS f where e.FKFS=f.FKFS and e.ZYH=b.ZYH and e.JSCS=b.JSCS and e.FKFS in (1,3,12) and b.ZYH=d.ZYH and d.BRID=c.BRID and a.ZYH=b.ZYH and a.JSCS=b.JSCS and b.JGID = :jgid and a.ZFGH = :czgh and b.MZLB = :mzlb and to_char(a.JZRQ,'yyyy-mm-dd hh24:mi:ss') ='"
//				+ (String) (response.get("jzrq")) + "'  order by b.FPHM";
//		String hql_jjhjfpxx = "select a.FPHM as FPHM,1 as FPZS,a.ZFHJ as ZFJE,d.BRXM as BRXM,f.FKMC as FKMC,e.FKJE as FKJE from LNHL_FPZF a, LNHL_BRRY d,LNHL_FKXX e,PUB_FKFS f where a.djid = d.id and a.jsid = e.jsxh and e.FKFS=f.FKFS  and e.FKFS in (1,3,12) and  a.JGID = :jgid  and  a.MZLB = :mzlb  and  a.ZFGH = :czgh and to_char(a.JZRQ,'yyyy-mm-dd hh24:mi:ss') ='"
//				+ (String) (response.get("jzrq")) + "'  order by a.FPHM";
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer hql_hzrb = new StringBuffer();
		parameters.put("jgid", jgid);
		parameters.put("czgh", userId);
		parameters.put("mzlb", mzlb);
		parameters.put("jzrq", response.get("jzrq"));
		List<Map<String, Object>> list_zffpxx = opZffpDao.doQueryZffp(parameters);
//		List<Map<String, Object>> list_jczffpxx = dao.doSqlQuery(hql_jczffpxx.toString(), parameters);
//		List<Map<String, Object>> list_jjhjfpxx = dao.doSqlQuery(hql_jjhjfpxx.toString(), parameters);
		StringBuffer zffpxx = new StringBuffer();
		if (list_zffpxx != null && list_zffpxx.size() > 0) {
			zffpxx.append("退费:");
			for (int i = 0; i < list_zffpxx.size(); i++) {
				Map<String, Object> thfp_map = new CaseInsensitiveMap<String, Object>(list_zffpxx.get(i));
				zffpxx.append(thfp_map.get("FPHM") + "(" + thfp_map.get("BRXM") + "," + thfp_map.get("FKMC") + ":"
						+ thfp_map.get("FKJE") + ") ");
			}
		}
//		if (list_jczffpxx != null && list_jczffpxx.size() > 0) {
//			zffpxx.append("家床:");
//			for (int i = 0; i < list_jczffpxx.size(); i++) {
//				Map<String, Object> thfp_map = list_jczffpxx.get(i);
//				zffpxx.append(thfp_map.get("FPHM") + "(" + thfp_map.get("BRXM") + "," + thfp_map.get("FKMC") + ":"
//						+ thfp_map.get("FKJE") + ") ");
//			}
//		}
//		if (list_jjhjfpxx != null && list_jjhjfpxx.size() > 0) {
//			zffpxx.append("居家护理:");
//			for (int i = 0; i < list_jjhjfpxx.size(); i++) {
//				Map<String, Object> thfp_map = list_jjhjfpxx.get(i);
//				zffpxx.append(thfp_map.get("FPHM") + "(" + thfp_map.get("BRXM") + "," + thfp_map.get("FKMC") + ":"
//						+ thfp_map.get("FKJE") + ") ");
//			}
//		}
		response.put("invalid", zffpxx.toString());
		return response;
	}

	/**
	 * 取消结账查询
	 * 
	 * @param jgid
	 * @param userId
	 * @param ip
	 * @return
	 */
	public List<QueryCancelCommitResp> doQueryCancelCommit(Integer jgid, Integer userId, String ip) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Integer mzlb = opMzlbSer.getMzlb(jgid, ip);
		parameters.put("jgid", jgid);
		parameters.put("czgh", userId);
		parameters.put("mzlb", mzlb);
		List<Map<String, Object>> list = opHzrbDao.doQueryJzrqAndCzgh(parameters);
		if (list.size() > 0) {
			List<QueryCancelCommitResp> resp = MzUtil.ListToResultSet(list, new QueryCancelCommitResp());
			return resp;
		}
		return null;
	}

	/**
	 * 取消结账
	 * 
	 * @param hospitalId
	 * @param userId
	 * @param ipAddress
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doCancelCommit(String jzrq, Integer jgid, Integer userId, String ip) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		java.util.Date jzdate = null;
//		jzdate = sdfdatetime.parse(jzrq);
		parameters.put("jgid", jgid);
		parameters.put("czgh", userId);
		parameters.put("jzrq", jzrq);
		Integer mzlb = opMzlbSer.getMzlb(jgid, ip);
		parameters.put("mzlb", mzlb);
		List<Map<String, Object>> list = opHzrbDao.doQueryJzrq(parameters);
		if (list.size() == 0) {
			throw BaseException.create("ERROR_REG_0079");
		}
		Map<String, Object> jzmaxparameters = new HashMap<String, Object>();
		jzmaxparameters.put("jgid", jgid);
		jzmaxparameters.put("czgh", userId);
		jzmaxparameters.put("mzlb", mzlb);
		List<Map<String, Object>> list1 = opHzrbDao.doQueryMaxJzrq(jzmaxparameters);
//		List<Map<String, Object>> jcjs = dao.doSqlQuery(
//				"select jzrq as jzrq ,to_char(jzrq,'yyyy-mm-dd hh24:mi:ss') as jzrqchar from jc_jcjs where  JGID='"
//						+ jgid + "' and MZLB in (" + BSPHISUtil.getMZLB(jgid, dao) + ") and CZGH = '" + userId
//						+ "' group by jzrq order by jzrq desc",
//				null);

		if (list1.size() > 0) {
			String maxJzrq = MzUtil.toString(DateUtil.parse(list1.get(0).get("JZRQ") + ""), "yyyy-MM-dd HH:mm:ss");
			if (!jzrq.equals(maxJzrq)) {
				throw BaseException.create("ERROR_REG_0080");
			}
			/*
			 * if(!jzrq.equals(list1.get(0).get("JZRQ")+"")){ throw new
			 * ModelDataOperationException( ServiceCode.CODE_DATABASE_ERROR,
			 * "当前记录不是最后一条结账信息,不能取消!"); }
			 */ }
		opRbmxDao.doDeleteByCondition(parameters);
		opXzmxDao.doDeleteByCondition(parameters);
		opSfrbFkmxDao.doDeleteByCondition(parameters);
		opHzrbDao.doDeleteByCondition(parameters);
		opGrmxDao.doDeleteByCondition(parameters);
		opGhrbFkmxDao.doDeleteByCondition(parameters);
		opGhrbDao.doDeleteByCondition(parameters);

		opMzxxDao.doUpdateJzrqToNull(parameters);
		opZffpDao.doUpdateJzrqToNull(parameters);
		opGhmxDao.doUpdateJzrqToNull(parameters);
		opThmxDao.doUpdateJzrqToNull(parameters);
		opGhmxZkDao.doUpdateJzrqToNull(parameters);
		opGhmxZjjsZsfpDao.doUpdateJzrqToNull(parameters);

//		dao.doUpdate(
//				"update JC_TBKK set JZRQ = null where JGID=:jgid and CZGH = :czgh and JZRQ=:jzrq and MZLB in (:mzlb)",
//				parameters);
//		dao.doUpdate(
//				"update JC_JKZF set JZRQ = null where JGID=:jgid and ZFGH = :czgh and JZRQ=:jzrq and MZLB in (:mzlb)",
//				parameters);
//		dao.doUpdate(
//				"update JC_JCJS set JZRQ = null where JGID=:jgid and CZGH = :czgh and JZRQ=:jzrq and MZLB in (:mzlb)",
//				parameters);
//		dao.doUpdate(
//				"update JC_JSZF set JZRQ = null where JGID=:jgid and ZFGH = :czgh and JZRQ=:jzrq and MZLB in (:mzlb)",
//				parameters);
//		dao.doUpdate(
//				"update LNHL_JS set JZRQ = null where JGID=:jgid and CZGH = :czgh and JZRQ=:jzrq and MZLB in (:mzlb)",
//				parameters);
//		dao.doUpdate(
//				"update LNHL_FPZF set JZRQ = null where JGID=:jgid and ZFGH = :czgh and JZRQ=:jzrq and MZLB in (:mzlb)",
//				parameters);

//		if (jcjs.size() > 0) {
//			Date lastTime = (Date) jcjs.get(0).get("JZRQ");
//			if (jzdate.getTime() < lastTime.getTime()) {
//				throw new ModelDataOperationException("当前记录不是最后一条结账信息,不能取消!");
//			}
//		}
//		dao.doSqlUpdate("update jc_jcjs set jzrq = null where jgid = '" + jgid + "' and mzlb in ("
//				+ BSPHISUtil.getMZLB(jgid, dao) + ") and CZGH = '" + userId
//				+ "' and to_char(JZRQ,'yyyy-mm-dd hh24:mi:ss')='" + jzrq + "'", null);

	}

	public Map<String, Object> getRechargeCardsParameters(Integer userId, String userName, Date beginDay, Date endDay,
			String jgName) {
		Map<String, Object> response = new HashMap<String, Object>();
		Map<String, Object> parameter = new HashMap<String, Object>();
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		parameter.put("userId", userId);
		parameter.put("dateFrom", DateUtil.beginOfDay(DateUtil.date(beginDay)).toTimestamp());
		parameter.put("dateTo", DateUtil.endOfDay(DateUtil.date(endDay)).toTimestamp());
		response.put("TITLE", jgName + "充值日报");
		response.put("TJRQ", beginDay + "至" + endDay);
		response.put("CZY", userName);
		resultList = opCzFkxxDao.doQueryCzFkxx(parameter);
		BigDecimal sum = new BigDecimal("0.00");
		StringBuffer rechargeWaysAmount = new StringBuffer();// 各充值方式金额
		for (Map<String, Object> m : resultList) {
			Map<String, Object> map = new CaseInsensitiveMap<String, Object>(m);
			rechargeWaysAmount.append(map.get("FKMC").toString());
			rechargeWaysAmount.append(":");
			rechargeWaysAmount.append(map.get("ZJE").toString());
			rechargeWaysAmount.append("元");
			rechargeWaysAmount.append("  ");
			sum = sum.add(new BigDecimal(map.get("ZJE").toString()));
		}
		response.put("total", sum + "元");
		response.put("rechargeWaysAmount", rechargeWaysAmount);
		return response;
	}

	public List<Map<String, Object>> getRechargeCardsFields(Integer userId, Date beginDay, Date endDay) {
		List<Map<String, Object>> records = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("userId", userId);
		parameter.put("dateFrom", DateUtil.beginOfDay(DateUtil.date(beginDay)).toTimestamp());
		parameter.put("dateTo", DateUtil.endOfDay(DateUtil.date(endDay)).toTimestamp());
		resultList = opCzFkxxDao.doQueryCzrbFields(parameter);
		records.addAll(resultList);
		return records;
	}

	/**
	 * 发票查询门诊清单
	 * 
	 * @param userId
	 * @param userName
	 * @param beginDay
	 * @param endDay
	 * @param jgName
	 * @return
	 */
	public Map<String, Object> getOutpatientListParameters(String fphm, Integer jgid, String jgName) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("title", jgName + "门诊费用清单");
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("FPHM", fphm);
		parameters.put("JGID", jgid);
		Map<String, Object> OP_MZXX = opMzxxDao.doQueryMzqd(parameters);
		if (OP_MZXX != null) {
			String RMB = numberToRMB(Double.parseDouble(OP_MZXX.get("JEHJXX") + ""));
			OP_MZXX.put("JEHJDX", RMB);
			OP_MZXX.put("SFRQ", DateUtil.parse(OP_MZXX.get("SFRQ").toString(), DatePattern.NORM_DATE_PATTERN).toSqlDate());
			response.putAll(OP_MZXX);
		}
		return response;
	}

	public String numberToRMB(double rmb) {
		String strRMB = "" + rmb;
		DecimalFormat nf = new DecimalFormat("#.#");
		nf.setMaximumFractionDigits(2);
		strRMB = nf.format(rmb).toString();
		strRMB = numberToZH(strRMB);
		if (strRMB.indexOf("点") >= 0) {
			strRMB = strRMB + "零";
			strRMB = strRMB.replaceAll("点", "圆");
			String s1 = strRMB.substring(0, strRMB.indexOf("圆") + 1);
			String s2 = strRMB.substring(strRMB.indexOf("圆") + 1);
			strRMB = s1 + s2.charAt(0) + "角" + s2.charAt(1) + "分整";
		} else {
			strRMB = strRMB + "圆整";
		}
		if (rmb < 1) {
			strRMB = "零" + strRMB;
		}
		return strRMB;
	}

	/**
	 * Description: 数字转化成整数
	 * 
	 * @param str
	 * @param fan
	 * @return
	 */
	public static String numberToZH(String str) {
		String zhnum_0 = "零壹贰叁肆伍陆柒捌玖";
		StringBuilder sb = new StringBuilder();
		int dot = str.indexOf(".");
		if (dot < 0)
			dot = str.length();

		String zhengshu = str.substring(0, dot);
		sb.append(numberToZH(Long.parseLong(zhengshu)));
		if (dot != str.length()) {
			sb.append("点");
			String xiaoshu = str.substring(dot + 1);
			for (int i = 0; i < xiaoshu.length(); i++) {
				sb.append(zhnum_0.charAt(Integer.parseInt(xiaoshu.substring(i, i + 1))));
			}
		}
		String s = new String(sb);
		if (s.startsWith("零"))
			s = s.substring(1);
		if (s.startsWith("一十"))
			s = s.substring(1);
		while (s.endsWith("零")) {
			s = s.substring(0, s.length() - 1);
		}
		if (s.endsWith("点"))
			s = s.substring(0, s.length() - 1);
		return s;
	}

	public static String numberToZH(long n) {
		String[] zhnum2 = { "", "万", "亿", "万亿", "亿亿" };
		StringBuilder sb = new StringBuilder();
		String strN = "000" + n;
		int strN_L = strN.length() / 4;
		strN = strN.substring(strN.length() - strN_L * 4);
		for (int i = 0; i < strN_L; i++) {
			String s1 = strN.substring(i * 4, i * 4 + 4);
			String s2 = numberToZH4(s1);
			sb.append(s2);
			if (s2.length() != 0)
				sb.append(zhnum2[strN_L - i - 1]);
		}
		String s = new String(sb);
		if (s.length() != 0 && s.startsWith("零"))
			s = s.substring(1);
		return s;
	}

	private static String numberToZH4(String s) {
		String zhnum_0 = "零壹贰叁肆伍陆柒捌玖";
		String[] zhnum1_0 = { "", "拾", "佰", "仟" };
		StringBuilder sb = new StringBuilder();
		if (s.length() != 4)
			return null;
		for (int i = 0; i < 4; i++) {
			char c1 = s.charAt(i);
			if (c1 == '0' && i > 1 && s.charAt(i - 1) == '0')
				continue;
			if (c1 != '0' && i > 1 && s.charAt(i - 1) == '0')
				sb.append('零');
			if (c1 != '0') {
				sb.append(zhnum_0.charAt(c1 - 48));
				sb.append(zhnum1_0[4 - i - 1]);
			}
		}
		return new String(sb);
	}

	/**
	 * 发票查询门诊清单
	 * 
	 * @param userId
	 * @param beginDay
	 * @param endDay
	 * @return
	 */
	public List<Map<String, Object>> getOutpatientListFields(String fphm, Integer jgid) {
		List<Map<String, Object>> records = new ArrayList<Map<String, Object>>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("FPHM", fphm);
		parameters.put("JGID", jgid);

		OpMzxx opMzxx = opMzxxDao.getByFphm(fphm);

		if(Objects.isNull(opMzxx)){
			throw BaseException.create("ERROR_REG_0099");
		}
		if(Objects.nonNull(opMzxx.getCdfphm())){
			parameters.replace("FPHM", opMzxxDao.getByFphm(opMzxx.getCdfphm()).getFphm());
		}

		List<Map<String, Object>> yj_List = opYjcf02Dao.doQueryMzqd(parameters);
		List<Map<String, Object>> cf_List = opCf02Dao.doQueryMzqd(parameters);
		records.addAll(yj_List);
		Map<String, Object> OP_MZXX = opMzxxDao.doQueryMzqd(parameters);
		if (OP_MZXX != null) {
			String RMB = numberToRMB(Double.parseDouble(OP_MZXX.get("JEHJXX") + ""));
			OP_MZXX.put("JEHJDX", RMB);
			OP_MZXX.put("SFRQ", DateUtil.parse(OP_MZXX.get("SFRQ").toString(), DatePattern.NORM_DATE_PATTERN).toSqlDate());
			// response.putAll(OP_MZXX);
			OP_MZXX.put("FYDL", "合计金额:");
			OP_MZXX.put("FYMC", RMB);
			OP_MZXX.put("DW", "小写:");
			OP_MZXX.put("JE", OP_MZXX.get("JEHJXX"));
			cf_List.add(OP_MZXX);
			records.addAll(cf_List);
		}
		return records;
	}

	public Map<String, Object> getXmflmxbParameters(Date beginDay, Date endDay, String jgName, String userName) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("title", jgName);
		response.put("now", DateUtil.date().toSqlDate());
		response.put("begindate", beginDay);
		response.put("enddate", endDay);
		response.put("zbr", userName);
		return response;
	}

	public List<Map<String, Object>> getXmflmxbFields(Date beginDay, Date endDay, String ybxl, Integer userId,
			Integer jgid) {
		List<Map<String, Object>> records = new ArrayList<Map<String, Object>>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("begindate", DateUtil.beginOfDay(DateUtil.date(beginDay)).toTimestamp());
		parameters.put("enddate", DateUtil.endOfDay(DateUtil.date(endDay)).toTimestamp());
		parameters.put("jgid", jgid);
		parameters.put("mzlb", ybxl);
		// parameters.put("code", 1);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> czgh_list = opHzrbDao.doQueryHzrbCzgh(parameters);
		List<Map<String, Object>> gh_list = opGhmxDao.doQueryGhfy(parameters);
		List<Map<String, Object>> mzjc_list = opMzxxDao.doQueryMzxxSfmx(parameters);

		for (int i = 0; i < czgh_list.size(); i++) {
			Map<String, Object> reMap = new CaseInsensitiveMap<String, Object>(getMap());
			Map<String, Object> map = new CaseInsensitiveMap<String, Object>(czgh_list.get(i));
			String czgh = map.get("CZGHID").toString();
			for (int j = 0; j < gh_list.size(); j++) {
				Map<String, Object> gh_map = new CaseInsensitiveMap<String, Object>(gh_list.get(j));
				if (czgh.equals(gh_map.get("CZGH").toString())) {
					reMap.putAll(gh_map);
				}
			}
			for (int j = 0; j < mzjc_list.size(); j++) {
				Map<String, Object> mzjc_map = new CaseInsensitiveMap<String, Object>(mzjc_list.get(j));
				if (czgh.equals(mzjc_map.get("CZGH").toString())) {
					if ("西药费".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("XYF", mzjc_map.get("ZJJE"));
						reMap.put("XYLCJ", (Object) MzUtil
								.getDouble(Double.parseDouble(mzjc_map.get("ZJJE").toString()) * 0.15, 2));// 西药零差价
					} else if ("中成药".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("ZYF", mzjc_map.get("ZJJE"));
						reMap.put("CYLCJ", (Object) MzUtil
								.getDouble(Double.parseDouble(mzjc_map.get("ZJJE").toString()) * 0.15, 2));// 西药零差价
					} else if ("中草药".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("CYF", mzjc_map.get("ZJJE"));
					} else if ("检查费".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("JCF", mzjc_map.get("ZJJE"));
					} else if ("治疗费".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("ZLF", mzjc_map.get("ZJJE"));
					} else if ("摄片费".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("ZCF", mzjc_map.get("ZJJE"));
					} else if ("手术(材料费)".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("SSF", mzjc_map.get("ZJJE"));
					} else if ("化验费".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("HYF", mzjc_map.get("ZJJE"));
					} else if ("输血费".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("SXF", mzjc_map.get("ZJJE"));
					} else if ("输氧费".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("SYF", mzjc_map.get("ZJJE"));
					} else if ("透视费".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("TSF", mzjc_map.get("ZJJE"));
					} else if ("体检费".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("TJF", mzjc_map.get("ZJJE"));
					} else if ("疫苗费".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("YMF", mzjc_map.get("ZJJE"));
					} else if ("护工费".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("HGF", mzjc_map.get("ZJJE"));
					} else {
						reMap.put("QTF", Double.parseDouble(reMap.get("QTF").toString())
								+ Double.parseDouble(mzjc_map.get("ZJJE").toString()));
					}
				}
			}
			String czrm = map.get("CZGH").toString();
			reMap.put("CZGH", czrm);
			list.add(reMap);
		}
		records.addAll(list);
		return records;
	}

	public Map<String, Object> getMap() {
		Map<String, Object> reMap = new HashMap<String, Object>();
		reMap.put("JKJE", 0);
		reMap.put("BLF", 0);
		reMap.put("ZJF", 0);
		reMap.put("XYLCJ", 0);
		reMap.put("CYLCJ", 0);
		reMap.put("CTKJE", 0);
		reMap.put("XYF", 0);
		reMap.put("ZYF", 0);
		reMap.put("CYF", 0);
		reMap.put("JCF", 0);
		reMap.put("ZLF", 0);
		reMap.put("ZCF", 0);
		reMap.put("SSF", 0);
		reMap.put("HYF", 0);
		reMap.put("SXF", 0);
		reMap.put("SYF", 0);
		reMap.put("TSF", 0);
		reMap.put("QTF", 0);
		reMap.put("TJF", 0);
		reMap.put("YMF", 0);
		reMap.put("HGF", 0);
		reMap.put("GHF2", 0);
		reMap.put("ZLF2", 0);
		return reMap;
	}

	List<Map<String, Object>> li = new ArrayList<Map<String, Object>>();

	/**
	 * 门诊收费汇总日报-门诊挂号收费汇总
	 * 
	 * @param beginDay
	 * @param endDay
	 * @param jgid
	 * @param jgName
	 * @param userName
	 * @param ybxl
	 * @return
	 */
	public Map<String, Object> getMzghsfjchzParameters(Date beginDay, Date endDay, Integer jgid, String jgName,
			String userName, String ybxl) {
		Map<String, Object> res = new HashMap<String, Object>();
		li.clear();

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("JGID", jgid);
		parameters.put("mzlb", ybxl);
		parameters.put("datefrom", beginDay);
		parameters.put("dateTo", endDay);
		// 收费日报数据
		List<Map<String, Object>> hzghrb_list = opHzrbDao.doQueryHzrbInfo(parameters);
		// 迭代获取操作工号
		System.out.println(hzghrb_list);
		for (int i = 0; i < hzghrb_list.size(); i++) {
			Map<String, Object> xj_hz_map = new HashMap<String, Object>();
			Integer ygdm = hzghrb_list.get(i).get("YGDM") != null
					? Integer.valueOf(hzghrb_list.get(i).get("YGDM").toString())
					: -1;
			HrPersonnelModel hrPersonnel = hrPersonnelService.getPersonnelById(ygdm);
			if (hrPersonnel != null) {
				hzghrb_list.get(i).put("CZGH", hrPersonnel.getPersonname());
			}
			if (xj_hz_map != null && xj_hz_map.size() > 0) {
				hzghrb_list.get(i).putAll(xj_hz_map);// 接着放到List 接着对比
			}
		}
		int ghcount = 0;// 人次合计
		Double ghAmount = 0.0;// 挂号金额合计
		int thcount = 0;// 退号合计
		int sfcount = 0;// 发票张数合计
		Double sfamount = 0.0;// 收费金额合计
		double jcamount = 0.0;// 家床金额合计
		double jkamount = 0.0;// 缴款金额合计
		double jjamount = 0.0;// 居家养老金额合计
		int zfcount = 0;// 发票作废合计
		Double totals = 0.0;// 总的合计
		Double xjAmount = 0.0;// 现金合计
		Double qtysAmount = 0.0;// 其他应收
		Double hbwcAmount = 0.0;// 货币误差
		// 迭代以上列的总数
		for (int j = 0; j < hzghrb_list.size(); j++) {
			Map<String, Object> m = new HashMap<String, Object>();
			Map<String, Object> map = new CaseInsensitiveMap<String, Object>(hzghrb_list.get(j));
			ghcount += ObjectToTypes.parseInt(hzghrb_list.get(j).get("GHRC"));
			thcount += ObjectToTypes.parseInt(hzghrb_list.get(j).get("THSL"));
			ghAmount += ObjectToTypes.parseDouble(hzghrb_list.get(j).get("GHJE"));
			sfcount += ObjectToTypes.parseInt(hzghrb_list.get(j).get("FPZS"));
			zfcount += ObjectToTypes.parseInt(hzghrb_list.get(j).get("ZFZS"));
			sfamount = MzUtil.add(sfamount, ObjectToTypes.parseDouble(hzghrb_list.get(j).get("ZJJE")));// add私有方法，优化四舍五入
			jcamount = MzUtil.add(jcamount, ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JCJE")));
			jkamount = MzUtil.add(jkamount, ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JCTJKJE")));
			jjamount = MzUtil.add(jjamount, ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JJHJ")));
			totals += MzUtil.getDouble(ObjectToTypes.parseDouble(hzghrb_list.get(j).get("ZJJE"))
					+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("GHJE"))
					+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JCJE"))
					+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JCTJKJE"))
					+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JJHJ")), 2);
			// 上面是最后一行的总数合计，下面是每一列的数据
			xjAmount = MzUtil.add(xjAmount, ObjectToTypes.parseDouble(hzghrb_list.get(j).get("XJJE")));
			qtysAmount = MzUtil.add(qtysAmount, ObjectToTypes.parseDouble(hzghrb_list.get(j).get("QTYS")));
			hbwcAmount = MzUtil.add(hbwcAmount, ObjectToTypes.parseDouble(hzghrb_list.get(j).get("HBWC")));
			m.put("GHJE", String.format("%1$.2f", hzghrb_list.get(j).get("GHJE")));
			m.put("GHRC", hzghrb_list.get(j).get("GHRC") + "");
			m.put("THSL", hzghrb_list.get(j).get("THSL") + "");
			m.put("CZGH", hzghrb_list.get(j).get("CZGH") + "");
			m.put("ZJJE", String.format("%1$.2f", hzghrb_list.get(j).get("ZJJE")));
			m.put("JCJE", String.format("%1$.2f", hzghrb_list.get(j).get("JCJE")));
			m.put("JCTJKJE", String.format("%1$.2f", hzghrb_list.get(j).get("JCTJKJE")));
			m.put("FPZS", ObjectToTypes.parseInt(hzghrb_list.get(j).get("FPZS"))
					- ObjectToTypes.parseInt(hzghrb_list.get(j).get("GHRC")) + "");
			m.put("ZFZS", hzghrb_list.get(j).get("ZFZS") + "");
			m.put("QTYS", String.format("%1$.2f", hzghrb_list.get(j).get("QTYS")));
			m.put("HBWC", String.format("%1$.2f", hzghrb_list.get(j).get("HBWC")));
			m.put("XJJE", String.format("%1$.2f", hzghrb_list.get(j).get("XJJE")));
			m.put("JJHJ", String.format("%1$.2f", hzghrb_list.get(j).get("JJHJ")));
			m.put("TOTALAMOUNT",
					String.format("%1$.2f",
							MzUtil.getDouble(ObjectToTypes.parseDouble(hzghrb_list.get(j).get("ZJJE"))
									+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("GHJE"))
									+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JCJE"))
									+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JCTJKJE"))
									+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JJHJ")), 2)));

			Map<String, Object> parameters2 = new HashMap<String, Object>();
			parameters2.put("jgid", jgid);
			parameters2.put("mzlb", ybxl);
			parameters2.put("czgh", hzghrb_list.get(j).get("YGDM") + "");
			parameters2.put("datefrom", beginDay);
			parameters2.put("dateTo", endDay);
			List<Map<String, Object>> ids_fkfs = opFkxxDao.doQueryFkjeByJzrq(parameters2);
			List<Map<String, Object>> ids_brxz = opMzxxDao.doQueryBrxzByJzrq(parameters2);
			Double qt = 0.0;
			if (ids_fkfs != null && ids_fkfs.size() != 0) {
				for (int n = 0; n < ids_fkfs.size(); n++) {

					/*
					 * if (parseInt(ids_fkfs.get(n).get("FKFS"))==12) {
					 * System.out.println(parseDouble(ids_fkfs.get(n).get("FKJE")));
					 * System.out.println(hzghrb_list.get(j).get("YGDM") + ""); }
					 */

					m.put(ids_fkfs.get(n).get("FKFS") + "", ids_fkfs.get(n).get("FKJE"));
					// “钞票”支付方式 归到“其他”
					if (ObjectToTypes.parseInt(ids_fkfs.get(n).get("FKFS")) == 11) {
						qt = MzUtil.add(qt, ObjectToTypes.parseDouble(ids_fkfs.get(n).get("FKJE")));
					}
					// “医院优惠”支付方式 归到“货币误差”
					if (ObjectToTypes.parseInt(ids_fkfs.get(n).get("FKFS")) == 5) {
						m.put("4", MzUtil.add(ObjectToTypes.parseDouble(m.get("4")),
								ObjectToTypes.parseDouble(ids_fkfs.get(n).get("FKJE"))));
					}
				}
			}
			if (ids_brxz != null && ids_brxz.size() != 0) {
				for (int n = 0; n < ids_brxz.size(); n++) {
					qt = MzUtil.add(qt, ObjectToTypes.parseDouble(ids_brxz.get(n).get("QTYS") + ""));

				}
			}
			m.put("QT", qt);
			if (m.get("1") == null)
				m.put("1", "0.0");
			if (m.get("2") == null)
				m.put("2", "0.0");
			if (m.get("3") == null)
				m.put("3", "0.0");
			if (m.get("21") == null)
				m.put("21", "0.0");
			if (m.get("4") == null)
				m.put("4", "0.0");
			if (m.get("12") == null)
				m.put("12", "0.0");
			if (m.get("23") == null)
				m.put("23", "0.0");
			if (m.get("18") == null)
				m.put("18", "0.0");
			if (m.get("24") == null)
				m.put("24", "0.0");
			// j计算总计金额的时候需要把货币误差减去
			m.put("ZJJE", String.format("%1$.2f",
					ObjectToTypes.parseDouble(m.get("ZJJE")) - ObjectToTypes.parseDouble(m.get("4"))));
			// 最后一列ZJJE求和减去货币误差
			sfamount = sfamount - ObjectToTypes.parseDouble(m.get("4"));
			// 合计金额也要减去货币误差
			m.put("TOTALAMOUNT", String.format("%1$.2f",
					ObjectToTypes.parseDouble(m.get("TOTALAMOUNT")) - ObjectToTypes.parseDouble(m.get("4"))));
			// 最后一列TOTALAMOUNT也要减去货币误差
			totals = totals - ObjectToTypes.parseDouble(m.get("4"));

			li.add(m);//
		}
		for (Map<String, Object> m : li) {
			res.put("1_total", String.format("%1$.2f",
					MzUtil.add(ObjectToTypes.parseDouble(m.get("1")), ObjectToTypes.parseDouble(res.get("1_total")))));
			res.put("2_total", String.format("%1$.2f",
					MzUtil.add(ObjectToTypes.parseDouble(m.get("2")), ObjectToTypes.parseDouble(res.get("2_total")))));
			res.put("3_total", String.format("%1$.2f",
					MzUtil.add(ObjectToTypes.parseDouble(m.get("3")), ObjectToTypes.parseDouble(res.get("3_total")))));
			res.put("21_total", String.format("%1$.2f", MzUtil.add(ObjectToTypes.parseDouble(m.get("21")),
					ObjectToTypes.parseDouble(res.get("21_total")))));
			res.put("4_total", String.format("%1$.2f",
					MzUtil.add(ObjectToTypes.parseDouble(m.get("4")), ObjectToTypes.parseDouble(res.get("4_total")))));
			res.put("12_total", String.format("%1$.2f", MzUtil.add(ObjectToTypes.parseDouble(m.get("12")),
					ObjectToTypes.parseDouble(res.get("12_total")))));
			res.put("23_total", String.format("%1$.2f", MzUtil.add(ObjectToTypes.parseDouble(m.get("23")),
					ObjectToTypes.parseDouble(res.get("23_total")))));
			res.put("18_total", String.format("%1$.2f", MzUtil.add(ObjectToTypes.parseDouble(m.get("18")),
					ObjectToTypes.parseDouble(res.get("18_total")))));
			res.put("24_total", String.format("%1$.2f", MzUtil.add(ObjectToTypes.parseDouble(m.get("24")),
					ObjectToTypes.parseDouble(res.get("24_total")))));
			res.put("QT_total", String.format("%1$.2f", MzUtil.add(ObjectToTypes.parseDouble(m.get("QT")),
					ObjectToTypes.parseDouble(res.get("QT_total")))));
		}
		Map<String, Object> hzrq = new HashMap<String, Object>();
		hzrq.put("JGID", jgid);
		res.put("preparedby", jgName);
		res.put("summaryDate", beginDay);
		res.put("startSummaryDate", endDay);
		res.put("Lister", userName);
		res.put("DateTabling", DateUtil.date().toSqlDate());
		res.put("totals", String.format("%1$.2f", totals));
		res.put("ghcount", ghcount + "");
		res.put("thcount", thcount + "");
		res.put("ghAmount", String.format("%1$.2f", ghAmount));
		res.put("sfcount", sfcount - ghcount + "");
		res.put("zfcount", zfcount + "");
		res.put("sfamount", String.format("%1$.2f", sfamount));
		res.put("jcamount", String.format("%1$.2f", jcamount));
		res.put("jkamount", String.format("%1$.2f", jkamount));
		res.put("jjamount", String.format("%1$.2f", jjamount));
		res.put("xjAmount", String.format("%1$.2f", xjAmount));
		res.put("qtysAmount", String.format("%1$.2f", qtysAmount));
		res.put("hbwcAmount", String.format("%1$.2f", hbwcAmount));
		return res;
	}

	public List<Map<String, Object>> getMzghsfjchzFields() {
		List<Map<String, Object>> records = new ArrayList<Map<String, Object>>();
		records.addAll(li);
		return records;
	}

	/**
	 * 门诊收费汇总日报-现金分类明细表(现金)
	 * 
	 * @param beginDay
	 * @param endDay
	 * @param jgName
	 * @param userName
	 * @return
	 */
	public Map<String, Object> getXmflmxxjbParameters(Date beginDay, Date endDay, String jgName, String userName) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("title", jgName);
		response.put("now", DateUtil.date().toSqlDate());
		response.put("begindate", beginDay);
		response.put("enddate", endDay);
		response.put("zbr", userName);
		return response;
	}

	/**
	 * 门诊收费汇总日报-现金分类明细表(现金)
	 * 
	 * @param beginDay
	 * @param endDay
	 * @param ybxl
	 * @param hospitalId
	 * @return
	 */
	public List<Map<String, Object>> getXmflmxxjbFields(Date beginDay, Date endDay, String ybxl, Integer jgid) {
		List<Map<String, Object>> records = new ArrayList<Map<String, Object>>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("begindate", beginDay);
		parameters.put("enddate", endDay);
		parameters.put("jgid", jgid);
		parameters.put("mzlb", ybxl);
		// parameters.put("code", 1);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> czgh_list = opHzrbDao.doQueryHzrbCzghByJzrq(parameters);
		List<Map<String, Object>> gh_list = opGhmxDao.doQueryGhfyByJzrq(parameters);
		List<Map<String, Object>> mzjc_list = opMzxxDao.doQueryMzxxSfxm(parameters);

		for (int i = 0; i < czgh_list.size(); i++) {
			Map<String, Object> reMap = getMap();
			String czgh = czgh_list.get(i).get("czghid").toString();
			for (int j = 0; j < gh_list.size(); j++) {
				Map<String, Object> gh_map = new CaseInsensitiveMap<String, Object>(gh_list.get(j));
				if (czgh.equals(gh_map.get("CZGH").toString())) {
					reMap.putAll(gh_map);
				}
			}
//			for (int j = 0; j < jk_list.size(); j++) {
//				Map<String, Object> jk_map = new CaseInsensitiveMap<String, Object>(jk_list.get(j));
//				if (czgh.equals(jk_map.get("CZGH").toString())) {
//					reMap.putAll(jk_map);
//				}
//			}
			for (int j = 0; j < mzjc_list.size(); j++) {
				Map<String, Object> mzjc_map = new CaseInsensitiveMap<String, Object>(mzjc_list.get(j));
				if (czgh.equals(mzjc_map.get("CZGH").toString())) {
					if ("西药费".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("XYF", mzjc_map.get("ZJJE"));
					} else if ("中成药".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("ZYF", mzjc_map.get("ZJJE"));
					} else if ("中草药".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("CYF", mzjc_map.get("ZJJE"));
					} else if ("检查费".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("JCF", mzjc_map.get("ZJJE"));
					} else if ("治疗费".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("ZLF", mzjc_map.get("ZJJE"));
					} else if ("摄片费".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("ZCF", mzjc_map.get("ZJJE"));
					} else if ("手术(材料费)".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("SSF", mzjc_map.get("ZJJE"));
					} else if ("化验费".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("HYF", mzjc_map.get("ZJJE"));
					} else if ("输血费".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("SXF", mzjc_map.get("ZJJE"));
					} else if ("输氧费".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("SYF", mzjc_map.get("ZJJE"));
					} else if ("透视费".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("TSF", mzjc_map.get("ZJJE"));
					} else if ("体检费".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("TJF", mzjc_map.get("ZJJE"));
					} else if ("疫苗费".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("YMF", mzjc_map.get("ZJJE"));
					} else if ("护工费".equals(mzjc_map.get("SFMC").toString())) {
						reMap.put("HGF", mzjc_map.get("ZJJE"));
					} else {
						reMap.put("QTF", Double.parseDouble(reMap.get("QTF").toString())
								+ Double.parseDouble(mzjc_map.get("ZJJE").toString()));
					}
				}
			}
			String czrm = czgh_list.get(i).get("czgh").toString();
			reMap.put("CZGH", czrm);
			list.add(reMap);
		}

		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = new CaseInsensitiveMap<String, Object>(list.get(i));
			double BLF = MzUtil.doubletwo(Double.parseDouble(map.get("BLF").toString()));
			double ZJF = MzUtil.doubletwo(Double.parseDouble(map.get("ZJF").toString()));
			double CTKJE = MzUtil.doubletwo(Double.parseDouble(map.get("CTKJE").toString()));
			double XYF = MzUtil.doubletwo(Double.parseDouble(map.get("XYF").toString()));
			double ZYF = MzUtil.doubletwo(Double.parseDouble(map.get("ZYF").toString()));
			double CYF = MzUtil.doubletwo(Double.parseDouble(map.get("CYF").toString()));
			double JCF = MzUtil.doubletwo(Double.parseDouble(map.get("JCF").toString()));
			double ZLF = MzUtil.doubletwo(Double.parseDouble(map.get("ZLF").toString()));
			double ZCF = MzUtil.doubletwo(Double.parseDouble(map.get("ZCF").toString()));
			double SSF = MzUtil.doubletwo(Double.parseDouble(map.get("SSF").toString()));
			double HYF = MzUtil.doubletwo(Double.parseDouble(map.get("HYF").toString()));
			double SXF = MzUtil.doubletwo(Double.parseDouble(map.get("SXF").toString()));
			double SYF = MzUtil.doubletwo(Double.parseDouble(map.get("SYF").toString()));
			double TSF = MzUtil.doubletwo(Double.parseDouble(map.get("TSF").toString()));
			double QTF = MzUtil.doubletwo(Double.parseDouble(map.get("QTF").toString()));
			double TJF = MzUtil.doubletwo(Double.parseDouble(map.get("TJF").toString()));
			double YMF = MzUtil.doubletwo(Double.parseDouble(map.get("YMF").toString()));
			double HGF = MzUtil.doubletwo(Double.parseDouble(map.get("HGF").toString()));
			double GHF2 = MzUtil.doubletwo(Double.parseDouble(map.get("GHF2").toString()));
			double ZLF2 = MzUtil.doubletwo(Double.parseDouble(map.get("ZLF2").toString()));
			map.put("BLF", BLF);
			map.put("ZJF", ZJF);
			map.put("CTKJE", CTKJE);
			map.put("XYF", XYF);
			map.put("ZYF", ZYF);
			map.put("CYF", CYF);
			map.put("JCF", JCF);
			map.put("ZLF", ZLF);
			map.put("ZCF", ZCF);
			map.put("SSF", SSF);
			map.put("HYF", HYF);
			map.put("SXF", SXF);
			map.put("SYF", SYF);
			map.put("TSF", TSF);
			map.put("QTF", QTF);
			map.put("TJF", TJF);
			map.put("YMF", YMF);
			map.put("HGF", HGF);
			map.put("GHF2", GHF2);
			map.put("ZLF2", ZLF2);
		}
		records.addAll(list);
		return records;
	}

	/**
	 * 门诊收费汇总日报门诊挂号收费汇总报表(未结账)
	 * 
	 * @param beginDay
	 * @param endDay
	 * @param jgName
	 * @param userName
	 * @return
	 */
	public Map<String, Object> getMzghsfhzbwjzParameters(String jgName, String userName) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("now", DateUtil.date().toSqlDate());
		response.put("zbr", userName);
		response.put("jgid", "制表单位：" + jgName);
		return response;
	}

	/**
	 * 门诊收费汇总日报门诊挂号收费汇总报表(未结账)
	 * 
	 * @param beginDay
	 * @param endDay
	 * @param ybxl
	 * @param hospitalId
	 * @return
	 */
	public List<Map<String, Object>> getMzghsfhzbwjzFields(Date beginDay, Date endDay, String ybxl) {
		List<Map<String, Object>> records = new ArrayList<Map<String, Object>>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("mzlb", ybxl);
		parameters.put("beginDay", beginDay);
		parameters.put("endDay", endDay);
		List<Map<String, Object>> list = opGhmxDao.doQuerySumGhje(parameters);
		for (Map<String, Object> map : list) {
			Integer czgh = map.get("CZGH") != null ? Integer.valueOf(map.get("CZGH").toString()) : -1;
			HrPersonnelModel hrPersonnel = hrPersonnelService.getPersonnelById(czgh);
			if (hrPersonnel != null) {
				map.put("CZGH", hrPersonnel.getPersonname());
			}
		}
		records.addAll(list);
		return records;
	}

	/**
	 * 门诊收费汇总日报-其他应收明细表
	 * 
	 * @param jgName
	 * @param userName
	 * @return
	 */
	public Map<String, Object> getQtysmxParameters(Date beginDay, Date endDay, String ybxl) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Map<String, Object>> list = this.getResult(beginDay, endDay, ybxl);
		Map<String, Object> map = this.getValueForMap(list);
		response.putAll(map);
		return response;
	}

	private List<Map<String, Object>> getResult(Date beginDay, Date endDay, String ybxl) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("datefrom", DateUtil.beginOfDay(DateUtil.date(beginDay)).toTimestamp());
		params.put("dateTo", DateUtil.endOfDay(DateUtil.date(endDay)).toTimestamp());
		params.put("mzlb", ybxl);
		List<Map<String, Object>> results = opGhmxDao.doQuerySumGhmx(params);
		for (Map<String, Object> map : results) {
			Map<String, Object> gh_map = new CaseInsensitiveMap<String, Object>(map);
			map.put("LCJ", new BigDecimal(0));
			Integer czgh = gh_map.get("czgh") != null ? Integer.valueOf(gh_map.get("czgh").toString()) : -1;
			HrPersonnelModel hrPersonnel = hrPersonnelService.getPersonnelById(czgh);
			if (hrPersonnel != null) {
				map.put("czgh", hrPersonnel.getPersonname());
			}
		}
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("_datefrom", beginDay);
		parameters.put("_dateTo", endDay);
		parameters.put("mzlb", ybxl);
		List<Map<String, Object>> zero = opCf02Dao.doQueryYhje(parameters);
		for (Map<String, Object> zeroMap : zero) {
			Map<String, Object> map = new CaseInsensitiveMap<String, Object>(zeroMap);
			String czgh = (String) map.get("CZGH");
			BigDecimal yhje = ((BigDecimal) map.get("YHJE"));
			for (Map<String, Object> hashMap : results) {
				Map<String, Object> map2 = new CaseInsensitiveMap<String, Object>(hashMap);
				if (map2.get("CZGH").equals(czgh)) {
					map2.put("LCJ", yhje);
				}
			}
		}
		return results;
	}

	private Map<String, Object> getValueForMap(List<Map<String, Object>> results) {
		double SUMLDRK = 0;
		double SUMJHSY = 0;
		double SUMPTZF = 0;
		double SUMZQGH = 0;
		double SUMLX = 0;
		double SUMWDZF = 0;
		double SUMPKJSB = 0;
		double SUMMZBK = 0;
		double SUMLDRKPKYF = 0;
		double SUMLNYS = 0;
		double SUMWBLR = 0;
		double SUMZCRY = 0;
		double SUMZXXSHYYE = 0;
		double SUMQTJM = 0;
		double SUMLCJ = 0;
		double SUMBK = 0;
		double SUMYBJHSY = 0;
		double SUMZYBK = 0;
		double SUMHJ = 0;
		double SUMPTYB = 0;
		double SUMJKJM = 0;
		double SUMYLHZBK = 0;
		double SUMFKSZ = 0;

		for (Map<String, Object> map2 : results) {
			Map<String, Object> map = new CaseInsensitiveMap<String, Object>(map2);
			SUMLDRK += ((BigDecimal) map.get("LDRK")).doubleValue();
			SUMJHSY += ((BigDecimal) map.get("JHSY")).doubleValue();
			SUMPTZF += ((BigDecimal) map.get("PTZF")).doubleValue();
			SUMZQGH += ((BigDecimal) map.get("ZQGH")).doubleValue();
			SUMLX += ((BigDecimal) map.get("LX")).doubleValue();
			SUMWDZF += ((BigDecimal) map.get("WDZF")).doubleValue();
			SUMPKJSB += ((BigDecimal) map.get("PKJSB")).doubleValue();
			SUMMZBK += ((BigDecimal) map.get("MZBK")).doubleValue();
			SUMLDRKPKYF += ((BigDecimal) map.get("LDRKPKYF")).doubleValue();
			SUMLNYS += ((BigDecimal) map.get("LNYS")).doubleValue();
			SUMWBLR += ((BigDecimal) map.get("WBLR")).doubleValue();
			SUMZCRY += ((BigDecimal) map.get("ZCRY")).doubleValue();
			SUMZXXSHYYE += ((BigDecimal) map.get("ZXXSHYYE")).doubleValue();
			SUMQTJM += ((BigDecimal) map.get("QTJM")).doubleValue();
			SUMLCJ += ((BigDecimal) map.get("LCJ")).doubleValue();
			SUMBK += ((BigDecimal) map.get("BK")).doubleValue();
			SUMYBJHSY += ((BigDecimal) map.get("YBJHSY")).doubleValue();
			SUMZYBK += ((BigDecimal) map.get("ZYBK")).doubleValue();
			SUMPTYB += ((BigDecimal) map.get("PTYB")).doubleValue();
			SUMJKJM += ((BigDecimal) map.get("JKJM")).doubleValue();
			SUMYLHZBK += ((BigDecimal) map.get("YLHZBK")).doubleValue();
			SUMFKSZ += ((BigDecimal) map.get("FKSZ")).doubleValue();
		}
		SUMHJ = SUMLDRK + SUMJHSY + SUMPTZF + SUMZQGH + SUMLX + SUMWDZF + SUMPKJSB + SUMMZBK + SUMLDRKPKYF + SUMLNYS
				+ SUMWBLR + SUMZCRY + SUMZXXSHYYE + SUMQTJM + SUMHJ + SUMLCJ + SUMYBJHSY + SUMBK + SUMZYBK + SUMPTYB
				+ SUMJKJM + SUMYLHZBK + SUMFKSZ;
		Map<String, Object> lastColumn = new HashMap<String, Object>();
		lastColumn.put("SUMLDRK", SUMLDRK);
		lastColumn.put("SUMJHSY", SUMJHSY);
		lastColumn.put("SUMPTZF", SUMPTZF);
		lastColumn.put("SUMZQGH", SUMZQGH);
		lastColumn.put("SUMLX", SUMLX);
		lastColumn.put("SUMWDZF", SUMWDZF);
		lastColumn.put("SUMPKJSB", SUMPKJSB);
		lastColumn.put("SUMMZBK", SUMMZBK);
		lastColumn.put("SUMLDRKPKYF", SUMLDRKPKYF);
		lastColumn.put("SUMLNYS", SUMLNYS);
		lastColumn.put("SUMWBLR", SUMWBLR);
		lastColumn.put("SUMZCRY", SUMZCRY);
		lastColumn.put("SUMZXXSHYYE", SUMZXXSHYYE);
		lastColumn.put("SUMQTJM", SUMQTJM);
		lastColumn.put("SUMLCJ", SUMLCJ);
		lastColumn.put("SUMYBJHSY", SUMYBJHSY);
		lastColumn.put("SUMBK", SUMBK);
		lastColumn.put("SUMZYBK", SUMZYBK);
		lastColumn.put("SUMPTYB", SUMPTYB);
		lastColumn.put("SUMJKJM", SUMJKJM);
		lastColumn.put("SUMYLHZBK", SUMYLHZBK);
		lastColumn.put("SUMFKSZ", SUMFKSZ);
		lastColumn.put("SUMHJ", SUMHJ);
		return this.doubleCastToStringForMap(lastColumn);
	}

	private Map<String, Object> doubleCastToStringForMap(Map<String, Object> doubleMap) {
		Set<String> keys = doubleMap.keySet();
		Map<String, Object> newMap = new HashMap<String, Object>();
		for (String string : keys) {
			newMap.put(string, String.format("%1$.2f", doubleMap.get(string)));
		}
		return newMap;
	}

	public List<Map<String, Object>> getQtysmxFields(Date beginDay, Date endDay, String ybxl) {
		List<Map<String, Object>> records = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list = this.getResult(beginDay, endDay, ybxl);
		List<Map<String, Object>> _list = this.doubleCastToStringForList(list);
		records.addAll(_list);
		return records;
	}

	// 每条记录的小计
	private List<Map<String, Object>> doubleCastToStringForList(List<Map<String, Object>> results) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> map2 : results) {
			Map<String, Object> map = new CaseInsensitiveMap<String, Object>(map2);
			double subTotal = 0;
			String _subTotal;
			Set<String> keys = map.keySet();
			for (String string : keys) {
				if (string.equalsIgnoreCase("CZGH") || string.equalsIgnoreCase("BRXZ")) {
					continue;
				}
				subTotal += ((BigDecimal) map.get(string)).doubleValue();
				map.put(string, String.format("%1$.2f", map.get(string)));
			}
			_subTotal = String.format("%1$.2f", subTotal);
			map.put("SUBTOTAL", _subTotal);
			subTotal = 0;// 归0，重新计算
			list.add(map);
		}
		return list;
	}

	/**
	 * 收费处人员工作量统计
	 * 
	 * @param beginDay
	 * @param endDay
	 * @return
	 */
	public Map<String, Object> getSfcrygzltjParameters(Date beginDay, Date endDay) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("tjsj", "统计时间：" + beginDay + " 至   " + endDay);
		return response;
	}

	/**
	 * 收费处人员工作量统计
	 * 
	 * @param beginDay
	 * @param endDay
	 * @return
	 */
	public List<Map<String, Object>> getSfcrygzltjFields(Date beginDay, Date endDay) {
		List<Map<String, Object>> records = null;
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("datefrom", DateUtil.beginOfDay(DateUtil.date(beginDay)).toTimestamp());
		parameters.put("dateto", DateUtil.endOfDay(DateUtil.date(endDay)).toTimestamp());
		List<Map<String, Object>> list = opGhmxDao.doQuerySfygzl(parameters);
		if (list != null && !list.isEmpty()) {
			records = new ArrayList<Map<String, Object>>();
			records.addAll(list);
		}
		return records;
	}

	List<Map<String, Object>> sfhzcsMap = new ArrayList<Map<String, Object>>();

	/**
	 * 收费汇总报表产生
	 * 
	 * @param beginDay
	 * @param endDay
	 * @return
	 */
	public Map<String, Object> getChargesFsbSummaryCsParameters(Date start, Date end, Integer jgid, String jgName,
			String userName, String ybxl) {
		Map<String, Object> response = new HashMap<String, Object>();
		sfhzcsMap.clear();
		// 解析前端参数
		SimpleDateFormat sdf1 = new SimpleDateFormat("yy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("JGID", jgid);
		parameters.put("mzlb", ybxl);
		parameters.put("start", MzUtil.toString(DateUtil.beginOfDay(start).toTimestamp(), "yyyy-MM-dd HH:mm:ss"));
		parameters.put("end", MzUtil.toString(DateUtil.endOfDay(end).toTimestamp(), "yyyy-MM-dd HH:mm:ss"));
		Map<String, Object> fkfsparameters = new HashMap<String, Object>();
		fkfsparameters.put("SYLX", "1");
		fkfsparameters.put("ZFBZ", "0");

		// 收费日报数据
		List<Map<String, Object>> hzghrb_list = opHzrbDao.doQueryHzrbJe(parameters);

		// String sfrb_fkmx_sql =
		// "select OP_HZRB.CZGH as YGDM,OP_SFRB_FKMX.FKFS as FKFS,sum(OP_SFRB_FKMX.FKJE)
		// as FKJE from OP_SFRB_FKMX OP_SFRB_FKMX,OP_HZRB OP_HZRB where OP_HZRB.CZGH =
		// OP_SFRB_FKMX.CZGH and OP_HZRB.JZRQ = OP_SFRB_FKMX.JZRQ and OP_HZRB.JGID
		// =:JGID and OP_HZRB.MZLB =:MZLB and OP_HZRB.HZRQ is null group by
		// OP_HZRB.CZGH,OP_SFRB_FKMX.FKFS";
		// String ghrb_fkmx_sql =
		// "select OP_GHRB.CZGH as YGDM,OP_GHRB_FKMX.FKFS as FKFS,sum(OP_GHRB_FKMX.FKJE)
		// as FKJE from OP_GHRB_FKMX OP_GHRB_FKMX,OP_GHRB OP_GHRB where OP_GHRB.CZGH =
		// OP_GHRB_FKMX.CZGH and OP_GHRB.JZRQ = OP_GHRB_FKMX.JZRQ and OP_GHRB.JGID
		// =:JGID and OP_GHRB.MZLB =:MZLB and OP_GHRB.HZRQ is null group by
		// OP_GHRB.CZGH,OP_GHRB_FKMX.FKFS";
		// String fkfs_sql =
		// "SELECT FKFS as FKFS,HBWC as HBWC,FKMC as FKMC,FKLB as FKLB FROM PUB_FKFS
		// WHERE SYLX =:SYLX AND ZFBZ =:ZFBZ";
		// List<Map<String, Object>> hzrb_list = dao.doSqlQuery(hzrb_sql,
		// parameters);// 收费日报数据
		// List<Map<String, Object>> ghrb_list = dao.doSqlQuery(ghrb_sql,
		// parameters);// 挂号日报数据
		// List<Map<String, Object>> sfrb_fkmx_list = dao.doSqlQuery(
		// sfrb_fkmx_sql, parameters);// 已结帐未汇总收费付款数据
		// List<Map<String, Object>> ghrb_fkmx_list = dao.doSqlQuery(
		// ghrb_fkmx_sql, parameters);// 已结帐未汇总挂号付款数据
		// List<Map<String, Object>> fkfs_list = dao.doSqlQuery(fkfs_sql,
		// fkfsparameters);// 付款方式数据
		// 收费现金金额和货币误差赋值

		String fkxx = "";// 收费明细字符串
//			String fkxxAmount="";//收费明细统计字符串
		// Double jjzfjeAmount = 0.0;// 门诊统筹
		// Double tczfhj = 0.0;// 统筹支付
		// Double dbtchj = 0.0;// 大病统筹
		// Double zxjzzfhj = 0.0;// 专项救助支付
		// Double grzhzfhj = 0.0;// 个人账户支付

		// -----性质不为“0”时的按收费性质统计的QTYS
//			List<Map<String, Object>> map_xztj = new ArrayList<Map<String, Object>>();
//			StringBuffer sql_xztj = new StringBuffer(); 
//			sql_xztj.append(" select c.XZDM as XZDM,d.XZMC as XZMC,c.QTYS as QTYS from (select  b.BRXZ as XZDM,sum(a.QTYS) as QTYS ");
//			sql_xztj.append(" from OP_MZXX a left join PUB_BRXZ b  on a.brxz = b.brxz ");
//			sql_xztj.append(" where a.JGID=:JGID and a.HZRQ is null and a.MZLB =:MZLB  and b.DBPB!='0' ");
//			sql_xztj.append("  group by  b.BRXZ) c left join PUB_BRXZ d on c.XZDM=d.brxz "); 
//			map_xztj = dao.doSqlQuery(sql_xztj.toString(), parameters);
//			if (map_xztj != null && map_xztj.size() != 0) {
//				 for(int i=0;i<map_xztj.size();i++){
//					 fkxx = fkxx +map_xztj.get(i).get("XZMC")+ ":"
//								+ String.format("%1$.2f",map_xztj.get(i).get("QTYS"))
//								+ " ";
//					 fkxxAmount = fkxxAmount +map_xztj.get(i).get("XZMC")+ ":"
//								+ String.format("%1$.2f",map_xztj.get(i).get("QTYS"))
//								+ " ";
//				 }
//			} 
//		 //性质为“0”时的统计QTYS
//			List<Map<String, Object>> map_qtys = new ArrayList<Map<String, Object>>();
//			StringBuffer sql_qtys = new StringBuffer();
//			sql_qtys.append(" select a.CZGH,b.DBPB as DBPB,sum(a.QTYS) as QTYS ");
//			sql_qtys.append("from OP_MZXX a left join PUB_BRXZ b on a.brxz=b.brxz ");
//			sql_qtys.append(" where a.JGID=:JGID and a.HZRQ is null and a.MZLB =:MZLB  and b.DBPB='0' ");
//			sql_qtys.append(" group by b.DBPB , a.CZGH "); 
//			map_qtys = dao.doSqlQuery(sql_qtys.toString(), parameters);
//			if (map_qtys != null && map_qtys.size() != 0) {
//				    fkxx = fkxx + "记账 :"
//								+ String.format("%1$.2f",map_qtys.get(0).get("QTYS"))
//								+ " ";
//				    fkxxAmount = fkxxAmount + "记账 :"
//							+ String.format("%1$.2f",map_qtys.get(0).get("QTYS"))
//							+ " ";
//			}
		for (int i = 0; i < hzghrb_list.size(); i++) {
			Map<String, Object> xj_hz_map = new HashMap<String, Object>();
			Integer czgh = hzghrb_list.get(i).get("YGDM") != null
					? Integer.valueOf(hzghrb_list.get(i).get("YGDM").toString())
					: -1;
			HrPersonnelModel hrPersonnel = hrPersonnelService.getPersonnelById(czgh);
			if (hrPersonnel != null) {
				hzghrb_list.get(i).put("CZGH", hrPersonnel.getPersonname());
			}
			hzghrb_list.get(i).putAll(xj_hz_map);// 接着放到List 接着对比
		}
		// 挂号现金金额和货币误差赋值
		// 合并挂号和收费
		int ghcount = 0;// 人次合计
		double ghAmount = 0.0;// 挂号金额合计
		int thcount = 0;// 退号合计
		int sfcount = 0;// 发票张数合计
		double sfamount = 0.0;// 收费金额合计
		double jcamount = 0.0;// 家床金额合计
		double jkamount = 0.0;// 缴款金额合计
		int zfcount = 0;// 发票作废张数
		double totals = 0.0;// 总的合计
		double xjAmount = 0.0;// 现金合计
		double qtysAmount = 0.0;// 其他应收
		double hbwcAmount = 0.0;// 货币误差
		// double jjzfjeAmount = 0.0;// 门诊统筹
		// double sybAmount = 0.0;// 门诊统筹
		// double szybAmount = 0.0;// 门诊统筹
		// double tczfhj = 0.0;// 统筹支付
		// double dbtchj = 0.0;// 大病统筹
		// double zxjzzfhj = 0.0;// 专项救助支付
		// double grzhzfhj = 0.0;// 个人账户支付

		for (int j = 0; j < hzghrb_list.size(); j++) {
			Map<String, Object> m = new HashMap<String, Object>();
			ghcount += ObjectToTypes.parseInt(hzghrb_list.get(j).get("GHRC"));
			thcount += ObjectToTypes.parseInt(hzghrb_list.get(j).get("THSL"));
			ghAmount += ObjectToTypes.parseDouble(hzghrb_list.get(j).get("GHJE"));
			sfcount += ObjectToTypes.parseInt(hzghrb_list.get(j).get("FPZS"));
			zfcount += ObjectToTypes.parseInt(hzghrb_list.get(j).get("ZFZS"));
			sfamount += ObjectToTypes.parseDouble(hzghrb_list.get(j).get("ZJJE"));
			jcamount += ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JCJE"));
			jkamount += ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JCTJKJE"));
			totals += MzUtil.getDouble(ObjectToTypes.parseDouble(hzghrb_list.get(j).get("ZJJE"))
					+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("GHJE"))
					+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JCJE"))
					+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JCTJKJE")), 2);
			xjAmount += ObjectToTypes.parseDouble(hzghrb_list.get(j).get("XJJE"));
			qtysAmount += ObjectToTypes.parseDouble(hzghrb_list.get(j).get("QTYS"));
			hbwcAmount += ObjectToTypes.parseDouble(hzghrb_list.get(j).get("HBWC"));

//			m.put("CZGH", hzghrb_list.get(j).get("CZGH") + "");

			Integer ygdm = hzghrb_list.get(j).get("YGDM") != null
					? Integer.valueOf(hzghrb_list.get(j).get("YGDM").toString())
					: -1;
			HrPersonnelModel hrPersonnel = hrPersonnelService.getPersonnelById(ygdm);
			if (hrPersonnel != null) {
				m.put("CZGH", hrPersonnel.getPersonname());
			}
			m.put("ZJJE", String.format("%1$.2f", hzghrb_list.get(j).get("ZJJE")));
			m.put("JCJE", String.format("%1$.2f", hzghrb_list.get(j).get("JCJE")));
			m.put("JCTJKJE", String.format("%1$.2f", hzghrb_list.get(j).get("JCTJKJE")));
			m.put("FPZS", hzghrb_list.get(j).get("FPZS") + "");
			m.put("ZFZS", hzghrb_list.get(j).get("ZFZS") + "");
			m.put("QTYS", String.format("%1$.2f", hzghrb_list.get(j).get("QTYS")));
			m.put("HBWC", String.format("%1$.2f", hzghrb_list.get(j).get("HBWC")));
			m.put("XJJE", String.format("%1$.2f", hzghrb_list.get(j).get("XJJE")));
			m.put("TOTALAMOUNT",
					String.format("%1$.2f",
							MzUtil.getDouble(ObjectToTypes.parseDouble(hzghrb_list.get(j).get("ZJJE"))
									+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("GHJE"))
									+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JCJE"))
									+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JCTJKJE")), 2)));
			m.put("GHJE", String.format("%1$.2f", hzghrb_list.get(j).get("GHJE")));
			m.put("GHRC", hzghrb_list.get(j).get("GHRC") + "");
			m.put("THSL", hzghrb_list.get(j).get("THSL") + "");
//				m.put("fkxx",fkxx+ "");
//				m.put("fkxxAmount", fkxxAmount+ "");
//				fkxx="货币误差:"+hbwcAmount+" "+fkxx;
//				fkxx="现金:"+xjAmount+" "+fkxx;
//				fkxxAmount="货币误差:"+hbwcAmount+" "+fkxxAmount;
//				fkxxAmount="现金:"+xjAmount+" "+fkxxAmount;
//				m.put("fkxx", fkxx);
//				m.put("fkxxAmount", fkxxAmount);

//				OP_HZRB where JGID =:JGID and MZLB =:MZLB and HZRQ is null group by CZGH";
//				OP_GHRB where JGID =:JGID and MZLB =:MZLB and HZRQ is null group by CZGH";

			Map<String, Object> parameters2 = new HashMap<String, Object>();
			parameters2.put("jgid", jgid);
			parameters2.put("mzlb", ybxl);
			parameters2.put("datefrom", DateUtil.beginOfDay(DateUtil.date(start)).toTimestamp());
			parameters2.put("dateTo", DateUtil.endOfDay(DateUtil.date(end)).toTimestamp());
			parameters2.put("czgh", hzghrb_list.get(j).get("YGDM") + "");
			List<Map<String, Object>> ids_fkfs = opFkxxDao.doQueryFkjeByJzrq(parameters2);
			List<Map<String, Object>> ids_brxz = opMzxxDao.doQueryBrxzByJzrq(parameters2);
			String qtysFb = "";
			String jzjeSt = "0.00";
			if (ids_fkfs != null && ids_fkfs.size() != 0) {
				for (int n = 0; n < ids_fkfs.size(); n++) {
					qtysFb = qtysFb + ids_fkfs.get(n).get("FKMC") + ":"
							+ String.format("%1$.2f", ids_fkfs.get(n).get("FKJE")) + " ";
				}
			}
			if (ids_brxz != null && ids_brxz.size() != 0) {
				for (int n = 0; n < ids_brxz.size(); n++) {
					if (ids_brxz.get(n).get("DBPB") == null) {
						continue;
					}
					if (Integer.parseInt(ids_brxz.get(n).get("DBPB") + "") == 0) {
						jzjeSt = String.format("%1$.2f", ObjectToTypes.parseDouble(jzjeSt)
								+ ObjectToTypes.parseDouble(ids_brxz.get(n).get("QTYS") + ""));
					} else {
						qtysFb = qtysFb + ids_brxz.get(n).get("XZMC") + ":"
								+ String.format("%1$.2f", ObjectToTypes.parseDouble(ids_brxz.get(n).get("QTYS") + ""))
								+ " ";
					}
				}
				qtysFb = qtysFb + " " + "记账 :" + jzjeSt + " ";
			}
			m.put("fkxx", qtysFb);
//				m.put("fkxxAmount", fkxxAmount);
			sfhzcsMap.add(m);
		}

		Map<String, Object> jzrq = new HashMap<String, Object>();
		jzrq.put("JGID", jgid);
		// 查询上次结账时间
		Map<String, Object> hzrqmapsf = opHzrbDao.doQueryMaxHzrq(jzrq);
		Map<String, Object> hzrqmapgh = opGhrbDao.doQueryMaxHzrq(jzrq);
		if ((hzrqmapsf != null && hzrqmapsf.get("HZRQ") != null)
				&& (hzrqmapgh != null && hzrqmapgh.get("HZRQ") != null)) {
			DateTime hzrqsfDate = DateUtil.parse(hzrqmapsf.get("HZRQ") + "", "yyyy-MM-dd HH:mm:ss");
			DateTime hzrqghDate = DateUtil.parse(hzrqmapgh.get("HZRQ") + "", "yyyy-MM-dd HH:mm:ss");
			java.util.Date hzrqsf = DateUtil.date(hzrqsfDate);
			java.util.Date hzrqgh = DateUtil.date(hzrqghDate);
			if (hzrqsf.getTime() > hzrqgh.getTime()) {
				response.put("startSummaryDate", MzUtil.toString(hzrqsf, "yyyy-MM-dd HH:mm:ss"));
			} else {
				response.put("startSummaryDate", MzUtil.toString(hzrqgh, "yyyy-MM-dd HH:mm:ss"));
			}
		} else if (hzrqmapsf != null && hzrqmapsf.get("HZRQ") != null) {
			DateTime hzrqsfDate = DateUtil.parse(hzrqmapsf.get("HZRQ") + "", "yyyy-MM-dd HH:mm:ss");
			java.util.Date hzrqsf = DateUtil.date(hzrqsfDate);
			response.put("startSummaryDate", MzUtil.toString(hzrqsf, "yyyy-MM-dd HH:mm:ss"));
		} else if (hzrqmapgh != null && hzrqmapgh.get("HZRQ") != null) {
			DateTime hzrqghDate = DateUtil.parse(hzrqmapgh.get("HZRQ") + "", "yyyy-MM-dd HH:mm:ss");
			java.util.Date hzrqgh = DateUtil.date(hzrqghDate);
			response.put("startSummaryDate", MzUtil.toString(hzrqgh, "yyyy-MM-dd HH:mm:ss"));
		} else {
			Map<String, Object> sfrqorghrq = new HashMap<String, Object>();
			sfrqorghrq.put("JGID", jgid);
			// 查询上次结账时间
			Map<String, Object> jzrqmapsf = opHzrbDao.doQueryMinJzrq(sfrqorghrq);
			Map<String, Object> jzrqmapgh = opGhrbDao.doQueryMinJzrq(sfrqorghrq);
			if ((jzrqmapsf != null && jzrqmapsf.get("JZRQ") != null)
					&& (jzrqmapgh != null && jzrqmapgh.get("JZRQ") != null)) {
				DateTime jzrqsfDate = DateUtil.parse(jzrqmapsf.get("JZRQ") + "", "yyyy-MM-dd HH:mm:ss");
				java.util.Date jzrqsf = DateUtil.date(jzrqsfDate);
				DateTime jzrqghDate = DateUtil.parse(jzrqmapgh.get("JZRQ") + "", "yyyy-MM-dd HH:mm:ss");
				java.util.Date jzrqgh = DateUtil.date(jzrqghDate);
				if (jzrqsf.getTime() < jzrqgh.getTime()) {
					response.put("startSummaryDate", MzUtil.toString(jzrqsf, "yyyy-MM-dd HH:mm:ss"));
				} else {
					response.put("startSummaryDate", MzUtil.toString(jzrqgh, "yyyy-MM-dd HH:mm:ss"));
				}
			} else if (jzrqmapsf != null && jzrqmapsf.get("JZRQ") != null) {
				DateTime jzrqsfDate = DateUtil.parse(jzrqmapsf.get("JZRQ") + "", "yyyy-MM-dd HH:mm:ss");
				java.util.Date jzrqsf = DateUtil.date(jzrqsfDate);
				response.put("startSummaryDate", MzUtil.toString(jzrqsf, "yyyy-MM-dd HH:mm:ss"));
			} else if (jzrqmapgh != null && jzrqmapgh.get("JZRQ") != null) {
				DateTime jzrqmapghDate = DateUtil.parse(jzrqmapgh.get("JZRQ") + "", "yyyy-MM-dd HH:mm:ss");
				java.util.Date jzrqgh = DateUtil.date(jzrqmapghDate);
				response.put("startSummaryDate", MzUtil.toString(jzrqgh, "yyyy-MM-dd HH:mm:ss"));
			}

		}

		response.put("fkxx", fkxx);
//			response.put("fkxxAmount", fkxxAmount);
		response.put("preparedby", jgName);
		response.put("summaryDate", MzUtil.toString(DateUtil.date(), "yyyy-MM-dd HH:mm:ss"));
		response.put("Lister", userName);
		response.put("DateTabling", MzUtil.getDate());
		response.put("totals", String.format("%1$.2f", totals));
		response.put("ghcount", ghcount + "");
		response.put("thcount", thcount + "");
		response.put("ghAmount", String.format("%1$.2f", ghAmount));
		response.put("sfcount", sfcount + "");
		response.put("zfcount", zfcount + "");
		response.put("sfamount", String.format("%1$.2f", sfamount));
		response.put("jcamount", String.format("%1$.2f", jcamount));
		response.put("jkamount", String.format("%1$.2f", jkamount));
		response.put("xjAmount", String.format("%1$.2f", xjAmount));
		response.put("qtysAmount", String.format("%1$.2f", qtysAmount));
		response.put("hbwcAmount", String.format("%1$.2f", hbwcAmount));

		Map<String, Object> parameters2 = new HashMap<String, Object>();
		parameters2.put("jgid", jgid);
		parameters2.put("mzlb", ybxl);
//			parameters2.put("czgh",hzghrb_list.get(j).get("YGDM") + "");
		List<Map<String, Object>> ids_fkfs = opFkxxDao.doQueryFkxxByHzrq(parameters2);
		List<Map<String, Object>> ids_brxz = opMzxxDao.doQueryBrxzByHzrq(parameters2);
		String qtysFb = "";
		String jzjeSt = "0.00";
		if (ids_fkfs != null && ids_fkfs.size() != 0) {
			for (int n = 0; n < ids_fkfs.size(); n++) {
				qtysFb = qtysFb + ids_fkfs.get(n).get("FKMC") + ":"
						+ String.format("%1$.2f", ids_fkfs.get(n).get("FKJE")) + " ";
			}
		}
		if (ids_brxz != null && ids_brxz.size() != 0) {
			for (int n = 0; n < ids_brxz.size(); n++) {
				if (Integer.parseInt(ids_brxz.get(n).get("DBPB") + "") == 0) {
					jzjeSt = String.format("%1$.2f", ObjectToTypes.parseDouble(jzjeSt)
							+ ObjectToTypes.parseDouble(ids_brxz.get(n).get("QTYS") + ""));
				} else {
					qtysFb = qtysFb + ids_brxz.get(n).get("XZMC") + ":"
							+ String.format("%1$.2f", ObjectToTypes.parseDouble(ids_brxz.get(n).get("QTYS") + ""))
							+ " ";
				}
			}
			qtysFb = qtysFb + " " + "记账 :" + jzjeSt + " ";
		}
		response.put("fkxxAmount", qtysFb);
		response.put("queryDate", "区间日期:" + sdf.format(start) + "至" + sdf.format(end));
		// response.put("SZYBHJ", String.format("%1$.2f", szybAmount));
		// response.put("SYBHJ", String.format("%1$.2f", sybAmount));
		// response.put("jjzfjeAmount", String.format("%1$.2f",
		// jjzfjeAmount));
		// response.put("TCZFHJ", String.format("%1$.2f", tczfhj));
		// response.put("DBTCHJ", String.format("%1$.2f", dbtchj));
		// response.put("ZXJZZFHJ", String.format("%1$.2f", zxjzzfhj));
		// response.put("GRZHZFHJ", String.format("%1$.2f", grzhzfhj));
		return response;
	}

	public List<Map<String, Object>> getChargesFsbSummaryCsFields() {
		List<Map<String, Object>> records = new ArrayList<Map<String, Object>>();
		records.addAll(sfhzcsMap);
		return records;
	}

	List<Map<String, Object>> sfhzhzMap = new ArrayList<Map<String, Object>>();

	/**
	 * 收费汇总-收费汇总报表汇总
	 * 
	 * @param beginDay
	 * @param endDay
	 * @param hospitalId
	 * @param jgName
	 * @param userName
	 * @param ybxl
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public Map<String, Object> getChargesFsbSummaryHzParameters(String hzrq, Integer jgid, String jgName,
			String userName, String ybxl) {
		Map<String, Object> response = new HashMap<String, Object>();
		response = doCheckout(hzrq, ybxl, jgid, response);
		if (response.get("hzrq") != null) {
//				request.put("hzrq",
//						BSHISUtil.toDate(response.get("hzrq").toString()));
			response = doInquiry(userName, jgName, jgid, ybxl, hzrq, response);
		}
		return response;
	}

	@Transactional(rollbackFor = Exception.class)
	public Map<String, Object> doCheckout(String hzrqStr, String ybxl, Integer jgid, Map<String, Object> res) {
		Map<String, Object> hzrbjzrqparameters = new HashMap<String, Object>();
		hzrbjzrqparameters.put("JGID", jgid);
		hzrbjzrqparameters.put("JZRQ", DateUtil.date().toTimestamp());
		hzrbjzrqparameters.put("mzlb", ybxl);
		List<Map<String, Object>> hzrbjzrqlist = opHzrbDao.doQueryCzghByJzrq(hzrbjzrqparameters);
		if (hzrbjzrqlist.size() > 0)// 判断在idt_jzrq后是否有新的结帐发生
			return res;
		// 格式化日期为时间类型
		java.util.Date hzrq = DateUtil.parse(hzrqStr, "yyyy-MM-dd HH:mm:ss");
		Map<String, Object> hzrbhzrqparameters = new HashMap<String, Object>();
		hzrbhzrqparameters.put("JGID", jgid);
		hzrbhzrqparameters.put("ldt_begin", DateUtil.beginOfDay(DateUtil.date(hzrq)).toTimestamp());
		hzrbhzrqparameters.put("ldt_end", DateUtil.endOfDay(DateUtil.date(hzrq)).toTimestamp());
		hzrbhzrqparameters.put("mzlb", ybxl);
		List<Map<String, Object>> hzrbhzrqlist = opHzrbDao.doQueryCzghByHzrq(hzrbhzrqparameters);
		if (hzrbhzrqlist.size() > 0)// 判断在指定的汇总日期是否已有汇总结帐,如果已有则不能再结帐
			return res;

		Map<String, Object> ghrbjzrqparameters = new HashMap<String, Object>();
		ghrbjzrqparameters.put("JGID", jgid);
		ghrbjzrqparameters.put("JZRQ", DateUtil.date().toTimestamp());
		ghrbjzrqparameters.put("mzlb", ybxl);
		List<Map<String, Object>> ghrbjzrqlist = opGhrbDao.doQueryByJzrq(ghrbjzrqparameters);
		if (ghrbjzrqlist.size() > 0)
			return res;

		Map<String, Object> ghrbhzrqparameters = new HashMap<String, Object>();
		ghrbhzrqparameters.put("JGID", jgid);
		ghrbhzrqparameters.put("ldt_begin", DateUtil.beginOfDay(DateUtil.date(hzrq)).toTimestamp());
		ghrbhzrqparameters.put("ldt_end", DateUtil.endOfDay(DateUtil.date(hzrq)).toTimestamp());
		ghrbhzrqparameters.put("mzlb", ybxl);
		List<Map<String, Object>> ghrbhzrqlist = opHzrbDao.doQueryCzghByHzrq(ghrbhzrqparameters);
		if (ghrbhzrqlist.size() > 0)
			return res;

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("gl_jgid", jgid);
		parameters.put("ldt_hzrq", hzrq);
		parameters.put("mzlb", ybxl);

		// 根据指定门诊类别填门诊信息中未汇总记录的汇总日期
		opMzxxDao.doUpdateHzrq(parameters);
		// 根据指定门诊类别填作废发票中未汇总记录的汇总日期
		opZffpDao.doUpdateHzrq(parameters);

		// 更新门诊收费日报中未汇总记录的汇总时间为取得的汇总日期
		opHzrbDao.doUpdateHzrq(parameters);
		// 根据指定门诊类别填挂号信息中未汇总记录的汇总日期
		opGhmxDao.doUpdateHzrq(parameters);
		// 根据指定门诊类别填退号明细中未汇总记录的汇总日期
		opThmxDao.doUpdateHzrq(parameters);
		// 更新门诊收费日报中未汇总记录的汇总时间为取得的汇总日期
		opGhrbDao.doUpdateHzrq(parameters);
		res.put("hzrq", MzUtil.toString(hzrq, "yyyy-MM-dd HH:mm:ss"));
		return res;
	}

	@Transactional(rollbackFor = Exception.class)
	public Map<String, Object> doInquiry(String userName, String jgName, Integer jgid, String ybxl, String hzrqStr,
			Map<String, Object> res) {
		sfhzhzMap.clear();
		SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> fkfsparameters = new HashMap<String, Object>();
//		double sfxjje = 0.0;// 收费现金金额
//		double sfhbwc = 0.0;// 收费货币误差
//		double ghxjje = 0.0;// 挂号现金金额
//		double ghhbwc = 0.0;// 挂号货币误差
//		double sfqtje = 0.0;// 收费其他应收
//		double ghqtje = 0.0;// 挂号其他应收
		parameters.put("JGID", jgid);
		parameters.put("mzlb", ybxl);
		// 格式化日期为时间类型
		java.util.Date hzrq = DateUtil.parse(hzrqStr, "yyyy-MM-dd HH:mm:ss");
		parameters.put("HZRQ", hzrq);
		fkfsparameters.put("SYLX", "1");
		fkfsparameters.put("ZFBZ", "0");
		// 收费日报数据
		List<Map<String, Object>> hzghrb_list = opHzrbDao.doQueryHzje(parameters);
		// String sfrb_fkmx_sql =
		// "select OP_HZRB.CZGH as YGDM,OP_SFRB_FKMX.FKFS as FKFS,sum(OP_SFRB_FKMX.FKJE)
		// as FKJE from OP_SFRB_FKMX OP_SFRB_FKMX,OP_HZRB OP_HZRB where OP_HZRB.CZGH =
		// OP_SFRB_FKMX.CZGH and OP_HZRB.JZRQ = OP_SFRB_FKMX.JZRQ and OP_HZRB.JGID
		// =:JGID and OP_HZRB.MZLB =:MZLB and OP_HZRB.HZRQ=:HZRQ group by
		// OP_HZRB.CZGH,OP_SFRB_FKMX.FKFS";
		// String ghrb_fkmx_sql =
		// "select OP_GHRB.CZGH as YGDM,OP_GHRB_FKMX.FKFS as FKFS,sum(OP_GHRB_FKMX.FKJE)
		// as FKJE from OP_GHRB_FKMX OP_GHRB_FKMX,OP_GHRB OP_GHRB where OP_GHRB.CZGH =
		// OP_GHRB_FKMX.CZGH and OP_GHRB.JZRQ = OP_GHRB_FKMX.JZRQ and OP_GHRB.JGID
		// =:JGID and OP_GHRB.MZLB =:MZLB and OP_GHRB.HZRQ=:HZRQ group by
		// OP_GHRB.CZGH,OP_GHRB_FKMX.FKFS";
		// String fkfs_sql =
		// "SELECT FKFS as FKFS,FKMC as FKMC,FKLB as FKLB,HBWC as HBWC FROM GY_FKFS
		// WHERE SYLX =:SYLX AND ZFBZ =:ZFBZ";

		// List<Map<String, Object>> hzrb_list = dao.doQuery(hzrb_sql,
		// parameters);// 收费日报数据
		// List<Map<String, Object>> ghrb_list = dao.doQuery(ghrb_sql,
		// parameters);// 挂号日报数据
		// List<Map<String, Object>> sfrb_fkmx_list = dao.doQuery(
		// sfrb_fkmx_sql, parameters);// 已结帐未汇总收费付款数据
		// List<Map<String, Object>> ghrb_fkmx_list = dao.doQuery(
		// ghrb_fkmx_sql, parameters);// 已结帐未汇总挂号付款数据
		// List<Map<String, Object>> fkfs_list = dao.doQuery(fkfs_sql,
		// fkfsparameters);// 付款方式数据
		// 收费现金金额和货币误差赋值
		for (int i = 0; i < hzghrb_list.size(); i++) {
			Map<String, Object> xj_hz_map = new HashMap<String, Object>();
			Integer czgh = hzghrb_list.get(i).get("YGDM") != null
					? Integer.valueOf(hzghrb_list.get(i).get("YGDM").toString())
					: -1;
			HrPersonnelModel hrPersonnel = hrPersonnelService.getPersonnelById(czgh);
			if (hrPersonnel != null) {
				hzghrb_list.get(i).put("CZGH", hrPersonnel.getPersonname());
			}
			if (xj_hz_map != null && xj_hz_map.size() > 0) {
				hzghrb_list.get(i).putAll(xj_hz_map);// 接着放到List 接着对比
			}
		}
		int ghcount = 0;// 人次合计
		Double ghAmount = 0.0;// 挂号金额合计
		int thcount = 0;// 退号合计
		int sfcount = 0;// 发票张数合计
		Double sfamount = 0.0;// 收费金额合计
		double jcamount = 0.0;// 家床金额合计
		double jkamount = 0.0;// 缴款金额合计
		int zfcount = 0;// 发票作废合计
		Double totals = 0.0;// 总的合计
		Double xjAmount = 0.0;// 现金合计
		Double qtysAmount = 0.0;// 其他应收
		Double hbwcAmount = 0.0;// 货币误差
//			String fkxx="";//收费明细字符串
//			String fkxxAmount="";//收费明细统计字符串
		// Double jjzfjeAmount = 0.0;// 门诊统筹
		// Double tczfhj = 0.0;// 统筹支付
		// Double dbtchj = 0.0;// 大病统筹
		// Double zxjzzfhj = 0.0;// 专项救助支付
		// Double grzhzfhj = 0.0;// 个人账户支付

//			//-----性质不为“0”时的按收费性质统计的QTYS 
//			List<Map<String, Object>> map_xztj = new ArrayList<Map<String, Object>>();
//			StringBuffer sql_xztj = new StringBuffer(); 
//			sql_xztj.append(" select c.XZDM as XZDM,d.XZMC as XZMC,c.QTYS as QTYS from (select  b.BRXZ as XZDM,sum(a.QTYS) as QTYS ");
//			sql_xztj.append(" from MS_MZXX a left join GY_BRXZ b  on a.brxz = b.brxz ");
//			sql_xztj.append(" where a.JGID=:JGID and a.HZRQ=:HZRQ and a.MZLB =:MZLB  and b.DBPB!='0' ");
//			sql_xztj.append("  group by  b.BRXZ) c left join GY_BRXZ d on c.XZDM=d.brxz "); 
//			map_xztj = dao.doSqlQuery(sql_xztj.toString(), parameters);
//			if (map_xztj != null && map_xztj.size() != 0) {
//				 for(int i=0;i<map_xztj.size();i++){
//					 fkxx = fkxx +map_xztj.get(i).get("XZMC")+ ":"
//								+ String.format("%1$.2f",map_xztj.get(i).get("QTYS"))
//								+ " ";
//					 fkxxAmount = fkxxAmount +map_xztj.get(i).get("XZMC")+ ":"
//								+ String.format("%1$.2f",map_xztj.get(i).get("QTYS"))
//								+ " ";
//				 }
//			} 
//		 //性质为“0”时的统计QTYS
//			List<Map<String, Object>> map_qtys = new ArrayList<Map<String, Object>>();
//			StringBuffer sql_qtys = new StringBuffer();
//			sql_qtys.append(" select a.CZGH,b.DBPB as DBPB,sum(a.QTYS) as QTYS ");
//			sql_qtys.append("from MS_MZXX a left join GY_BRXZ b on a.brxz=b.brxz ");
//			sql_qtys.append(" where a.JGID=:JGID and a.HZRQ=:HZRQ and a.MZLB =:MZLB  and b.DBPB='0' ");
//			sql_qtys.append(" group by b.DBPB , a.CZGH "); 
//			map_qtys = dao.doSqlQuery(sql_qtys.toString(), parameters);
//			if (map_qtys != null && map_qtys.size() != 0) {
//				    fkxx = fkxx + "记账 :"
//								+ String.format("%1$.2f",map_qtys.get(0).get("QTYS"))
//								+ " ";
//				    fkxxAmount = fkxxAmount + "记账 :"
//							+ String.format("%1$.2f",map_qtys.get(0).get("QTYS"))
//							+ " ";
//			}		

		for (int j = 0; j < hzghrb_list.size(); j++) {
			Map<String, Object> m = new HashMap<String, Object>();
			ghcount += ObjectToTypes.parseInt(hzghrb_list.get(j).get("GHRC"));
			thcount += ObjectToTypes.parseInt(hzghrb_list.get(j).get("THSL"));
			ghAmount += ObjectToTypes.parseDouble(hzghrb_list.get(j).get("GHJE"));
			sfcount += ObjectToTypes.parseInt(hzghrb_list.get(j).get("FPZS"));
			zfcount += ObjectToTypes.parseInt(hzghrb_list.get(j).get("ZFZS"));
			sfamount += ObjectToTypes.parseDouble(hzghrb_list.get(j).get("ZJJE"));
			jcamount += ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JCJE"));
			jkamount += ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JCTJKJE"));
			totals += MzUtil.getDouble(ObjectToTypes.parseDouble(hzghrb_list.get(j).get("ZJJE"))
					+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("GHJE"))
					+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JCJE"))
					+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JCTJKJE")), 2);
			xjAmount += ObjectToTypes.parseDouble(hzghrb_list.get(j).get("XJJE"));
			qtysAmount += ObjectToTypes.parseDouble(hzghrb_list.get(j).get("QTYS"));
			hbwcAmount += ObjectToTypes.parseDouble(hzghrb_list.get(j).get("HBWC"));
			// if (hzrb_list.get(j).get("JJZFJE") != null) {
			// hbwcAmount += parseDouble(hzrb_list.get(j).get(
			// "JJZFJE"));
			// }
			m.put("GHJE", String.format("%1$.2f", hzghrb_list.get(j).get("GHJE")));
			m.put("GHRC", hzghrb_list.get(j).get("GHRC") + "");
			m.put("THSL", hzghrb_list.get(j).get("THSL") + "");

			m.put("CZGH", hzghrb_list.get(j).get("CZGH") + "");
			m.put("ZJJE", String.format("%1$.2f", hzghrb_list.get(j).get("ZJJE")));
			m.put("JCJE", String.format("%1$.2f", hzghrb_list.get(j).get("JCJE")));
			m.put("JCTJKJE", String.format("%1$.2f", hzghrb_list.get(j).get("JCTJKJE")));
			m.put("FPZS", hzghrb_list.get(j).get("FPZS") + "");
			m.put("ZFZS", hzghrb_list.get(j).get("ZFZS") + "");
			m.put("QTYS", String.format("%1$.2f", hzghrb_list.get(j).get("QTYS")));
			m.put("HBWC", String.format("%1$.2f", hzghrb_list.get(j).get("HBWC")));

			m.put("XJJE", String.format("%1$.2f", hzghrb_list.get(j).get("XJJE")));

//				fkxx="货币误差:"+hzghrb_list.get(j).get("HBWC")+" "+fkxx;
//				fkxx="现金:"+hzghrb_list.get(j).get("XJJE")+" "+fkxx;

			m.put("TOTALAMOUNT",
					String.format("%1$.2f",
							MzUtil.getDouble(ObjectToTypes.parseDouble(hzghrb_list.get(j).get("ZJJE"))
									+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("GHJE"))
									+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JCJE"))
									+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JCTJKJE")), 2)));

//				 m.put("fkxx", fkxx);

//				from OP_HZRB where JGID =:JGID and MZLB =:MZLB and HZRQ=:HZRQ group by CZGH";
//				from OP_GHRB where JGID =:JGID and MZLB =:MZLB and HZRQ=:HZRQ group by CZGH";
			Map<String, Object> parameters2 = new HashMap<String, Object>();
			parameters2.put("jgid", jgid);
			parameters2.put("mzlb", ybxl);
			parameters2.put("czgh", hzghrb_list.get(j).get("YGDM") + "");
			parameters2.put("hzrq", hzrq);
			List<Map<String, Object>> ids_fkfs = opFkxxDao.doQueryFkxxFkjeByHzrq(parameters2);
			List<Map<String, Object>> ids_brxz = opMzxxDao.doQueryBrxzQtysByHzrq(parameters2);
			String qtysFb = "";
			String jzjeSt = "0.00";
			if (ids_fkfs != null && ids_fkfs.size() != 0) {
				for (int n = 0; n < ids_fkfs.size(); n++) {
					qtysFb = qtysFb + ids_fkfs.get(n).get("FKMC") + ":"
							+ String.format("%1$.2f", ids_fkfs.get(n).get("FKJE")) + " ";
				}
			}
			if (ids_brxz != null && ids_brxz.size() != 0) {
				for (int n = 0; n < ids_brxz.size(); n++) {
					if (Integer.parseInt(ids_brxz.get(n).get("DBPB") + "") == 0) {
						jzjeSt = String.format("%1$.2f", ObjectToTypes.parseDouble(jzjeSt)
								+ ObjectToTypes.parseDouble(ids_brxz.get(n).get("QTYS") + ""));
					} else {
						qtysFb = qtysFb + ids_brxz.get(n).get("XZMC") + ":"
								+ String.format("%1$.2f", ObjectToTypes.parseDouble(ids_brxz.get(n).get("QTYS") + ""))
								+ " ";
					}
				}
				qtysFb = qtysFb + " " + "记账 :" + jzjeSt + " ";
			}
			m.put("fkxx", qtysFb);
			sfhzhzMap.add(m);
		}
		Map<String, Object> hzrqMap = new HashMap<String, Object>();
		hzrqMap.put("JGID", jgid);
		hzrqMap.put("hzrq", hzrq);
		// 查询上次结账时间
		Map<String, Object> hzrqmapsf = opHzrbDao.doQueryByHzrq(hzrqMap);
		Map<String, Object> hzrqmapgh = opGhrbDao.doQueryByHzrq(hzrqMap);
		if ((hzrqmapsf != null && hzrqmapsf.get("HZRQ") != null)
				&& (hzrqmapgh != null && hzrqmapgh.get("HZRQ") != null)) {
			DateTime hzrqmapsfDate = DateUtil.parse(hzrqmapsf.get("HZRQ") + "", "yyyy-MM-dd HH:mm:ss");
			DateTime hzrqmapghDate = DateUtil.parse(hzrqmapgh.get("HZRQ") + "", "yyyy-MM-dd HH:mm:ss");
			java.util.Date hzrqsf = DateUtil.date(hzrqmapsfDate);
			java.util.Date hzrqgh = DateUtil.date(hzrqmapghDate);
			if (hzrqsf.getTime() > hzrqgh.getTime()) {
				res.put("startSummaryDate", MzUtil.toString(hzrqsf, "yyyy-MM-dd HH:mm:ss"));
			} else {
				res.put("startSummaryDate", MzUtil.toString(hzrqgh, "yyyy-MM-dd HH:mm:ss"));
			}
		} else if (hzrqmapsf != null && hzrqmapsf.get("HZRQ") != null) {
			DateTime hzrqmapsfDate = DateUtil.parse(hzrqmapsf.get("HZRQ") + "", "yyyy-MM-dd HH:mm:ss");
			java.util.Date hzrqsf = DateUtil.date(hzrqmapsfDate);
			res.put("startSummaryDate", MzUtil.toString(hzrqsf, "yyyy-MM-dd HH:mm:ss"));
		} else if (hzrqmapgh != null && hzrqmapgh.get("HZRQ") != null) {
			DateTime hzrqmapghDate = DateUtil.parse(hzrqmapgh.get("HZRQ") + "", "yyyy-MM-dd HH:mm:ss");
			java.util.Date hzrqgh = DateUtil.date(hzrqmapghDate);
			res.put("startSummaryDate", MzUtil.toString(hzrqgh, "yyyy-MM-dd HH:mm:ss"));
		} else {
			Map<String, Object> sfrqorghrq = new HashMap<String, Object>();
			sfrqorghrq.put("JGID", jgid);
			// 查询上次结账时间
			Map<String, Object> jzrqmapsf = opHzrbDao.doQueryMinJzrq(sfrqorghrq);
			Map<String, Object> jzrqmapgh = opGhrbDao.doQueryMinJzrq(sfrqorghrq);
			if ((jzrqmapsf != null && jzrqmapsf.get("JZRQ") != null)
					&& (jzrqmapgh != null && jzrqmapgh.get("JZRQ") != null)) {
				DateTime jzrqmapsfDate = DateUtil.parse(jzrqmapsf.get("JZRQ") + "", "yyyy-MM-dd HH:mm:ss");
				DateTime jzrqmapghDate = DateUtil.parse(jzrqmapgh.get("JZRQ") + "", "yyyy-MM-dd HH:mm:ss");
				java.util.Date jzrqsf = DateUtil.date(jzrqmapsfDate);
				java.util.Date jzrqgh = DateUtil.date(jzrqmapghDate);
				if (jzrqsf.getTime() < jzrqgh.getTime()) {
					res.put("startSummaryDate", MzUtil.toString(jzrqsf, "yyyy-MM-dd HH:mm:ss"));
				} else {
					res.put("startSummaryDate", MzUtil.toString(jzrqgh, "yyyy-MM-dd HH:mm:ss"));
				}
			} else if (jzrqmapsf != null && jzrqmapsf.get("JZRQ") != null) {
				DateTime jzrqmapsfDate = DateUtil.parse(jzrqmapsf.get("JZRQ") + "", "yyyy-MM-dd HH:mm:ss");
				java.util.Date jzrqsf = DateUtil.date(jzrqmapsfDate);
				res.put("startSummaryDate", MzUtil.toString(jzrqsf, "yyyy-MM-dd HH:mm:ss"));
			} else if (jzrqmapgh != null && jzrqmapgh.get("JZRQ") != null) {
				DateTime jzrqmapghDate = DateUtil.parse(jzrqmapgh.get("JZRQ") + "", "yyyy-MM-dd HH:mm:ss");
				java.util.Date jzrqgh = DateUtil.date(jzrqmapghDate);
				res.put("startSummaryDate", MzUtil.toString(jzrqgh, "yyyy-MM-dd HH:mm:ss"));
			}

		}
		res.put("preparedby", jgName);
		res.put("summaryDate", hzrq);
		res.put("Lister", userName);
		res.put("DateTabling", DateUtil.date().toSqlDate());
		res.put("totals", String.format("%1$.2f", totals));
		res.put("ghcount", ghcount + "");
		res.put("thcount", thcount + "");
		res.put("ghAmount", String.format("%1$.2f", ghAmount));
		res.put("sfcount", sfcount + "");
		res.put("zfcount", zfcount + "");
		res.put("sfamount", String.format("%1$.2f", sfamount));
		res.put("jcamount", String.format("%1$.2f", jcamount));
		res.put("jkamount", String.format("%1$.2f", jkamount));
		res.put("xjAmount", String.format("%1$.2f", xjAmount));
		res.put("qtysAmount", String.format("%1$.2f", qtysAmount));
		res.put("hbwcAmount", String.format("%1$.2f", hbwcAmount));
		// res.put("jjzfjeAmount", String.format("%1$.2f", jjzfjeAmount));
		// res.put("TCZFHJ", String.format("%1$.2f", tczfhj));
		// res.put("DBTCHJ", String.format("%1$.2f", dbtchj));
		// res.put("ZXJZZFHJ", String.format("%1$.2f", zxjzzfhj));
		// res.put("GRZHZFHJ", String.format("%1$.2f", grzhzfhj));

//			fkxxAmount="货币误差:"+hbwcAmount+" "+fkxxAmount;
//			fkxxAmount="现金:"+xjAmount+" "+fkxxAmount;
		Map<String, Object> parameters2 = new HashMap<String, Object>();
		parameters2.put("jgid", jgid);
		parameters2.put("mzlb", ybxl);
		parameters2.put("hzrq", hzrq);
		List<Map<String, Object>> ids_fkfs = opFkxxDao.doQueryFkxx(parameters2);
		List<Map<String, Object>> ids_brxz = opMzxxDao.doQueryBrxzInfo(parameters2);
		String qtysFb = "";
		String jzjeSt = "0.00";
		if (ids_fkfs != null && ids_fkfs.size() != 0) {
			for (int n = 0; n < ids_fkfs.size(); n++) {
				qtysFb = qtysFb + ids_fkfs.get(n).get("FKMC") + ":"
						+ String.format("%1$.2f", ids_fkfs.get(n).get("FKJE")) + " ";
			}
		}
		if (ids_brxz != null && ids_brxz.size() != 0) {
			for (int n = 0; n < ids_brxz.size(); n++) {
				if (Integer.parseInt(ids_brxz.get(n).get("DBPB") + "") == 0) {
					jzjeSt = String.format("%1$.2f", ObjectToTypes.parseDouble(jzjeSt)
							+ ObjectToTypes.parseDouble(ids_brxz.get(n).get("QTYS") + ""));
				} else {
					qtysFb = qtysFb + ids_brxz.get(n).get("XZMC") + ":"
							+ String.format("%1$.2f", ObjectToTypes.parseDouble(ids_brxz.get(n).get("QTYS") + ""))
							+ " ";
				}
			}
			qtysFb = qtysFb + " " + "记账 :" + jzjeSt + " ";
		}
		res.put("fkxxAmount", qtysFb);
		return res;
	}

	public List<Map<String, Object>> getChargesFsbSummaryHzFields() {
		List<Map<String, Object>> records = new ArrayList<Map<String, Object>>();
		records.addAll(sfhzhzMap);
		return records;
	}

	/**
	 * 查询收费汇总
	 * 
	 * @param beginDay
	 * @param endDay
	 * @param userId
	 * @param jgid
	 * @param ip
	 * @return
	 */
	public List<SfrbResp> querySQLList(Date beginDay, Date endDay, Integer jgid, String ybxl) {
		List<SfrbResp> resp = new ArrayList<SfrbResp>();
		Map<String, Object> res = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer hzhql = new StringBuffer();
		StringBuffer ghhql = new StringBuffer();
		parameters.put("jgid", jgid);
		parameters.put("mzlb", ybxl);
		parameters.put("beginDay", DateUtil.beginOfDay(DateUtil.date(beginDay)).toTimestamp());
		parameters.put("endDay", DateUtil.endOfDay(DateUtil.date(endDay)).toTimestamp());

		List<Map<String, Object>> listSQL = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> hzListSQL = opHzrbDao.doQueryHzrq(parameters);
		List<Map<String, Object>> ghListSQL = opGhrbDao.doQueryHzrq(parameters);

		if (hzListSQL != null && hzListSQL.size() != 0) {
			for (int i = 0; i < hzListSQL.size(); i++) {
				Map<String, Object> map_sql = hzListSQL.get(i);
				Map<String, Object> map_sql_all = new HashMap<String, Object>();
				map_sql_all.put("HZRQ", map_sql.get("HZRQ"));
				if (ghListSQL != null && ghListSQL.size() != 0) {
					for (int J = 0; J < ghListSQL.size(); J++) {
						Map<String, Object> map_sql_zf = ghListSQL.get(J);
						if (map_sql_zf.containsKey("HZRQ")) {
							if (map_sql.get("HZRQ").equals(map_sql_zf.get("HZRQ"))) {
								map_sql_all.put("HZRQ", map_sql.get("HZRQ"));
								ghListSQL.remove(J);
								J--;
							}
						}
					}
				}
				listSQL.add(map_sql_all);
			}

			if (ghListSQL != null && ghListSQL.size() != 0) {
				for (int J = 0; J < ghListSQL.size(); J++) {
					Map<String, Object> map_sql_zf = ghListSQL.get(J);
					if (map_sql_zf.containsKey("HZRQ")) {
						Map<String, Object> map_sql_all = new HashMap<String, Object>();
						map_sql_all.put("HZRQ", map_sql_zf.get("HZRQ"));
						listSQL.add(map_sql_all);
						ghListSQL.remove(J);
						J--;
					}
				}
			}

		} else {
			if (ghListSQL != null && ghListSQL.size() != 0) {
				for (int k = 0; k < ghListSQL.size(); k++) {
					Map<String, Object> map_sql_zf = ghListSQL.get(k);
					Map<String, Object> map_sql_all = new HashMap<String, Object>();
					map_sql_all.put("HZRQ", map_sql_zf.get("HZRQ"));
					listSQL.add(map_sql_all);
				}
			}
		}

		if (listSQL.size() > 0) {
			Collections.sort(listSQL, new Comparator<Map<String, Object>>() {
				@Override
				public int compare(Map<String, Object> map1, Map<String, Object> map2) {
					Date date1 = (Date) map1.get("HZRQ");
					Date date2 = (Date) map2.get("HZRQ");
					return date1.compareTo(date2);
				}
			});
			res.put("body", listSQL);
			resp = MzUtil.ListToResultSet(listSQL, new SfrbResp());
		}
		return resp;
	}

	/**
	 * 收费汇总-收费汇总查询确认
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getChargesFsbSummaryQrFields() {
		List<Map<String, Object>> records = new ArrayList<Map<String, Object>>();
		records.addAll(sfhzhzMap);
		return records;
	}

	/**
	 * 收费汇总-收费汇总查询确认
	 * 
	 * @param hzrq
	 * @param jgid
	 * @param jgName
	 * @param userName
	 * @param ybxl
	 * @return
	 */
	public Map<String, Object> getChargesFsbSummaryQrParameters(String hzrq, Integer jgid, String jgName,
			String userName, String ybxl) {
		Map<String, Object> response = new HashMap<String, Object>();
		response = doInquiry(userName, jgName, jgid, ybxl, hzrq, response);
		return response;
	}

	/**
	 * 取消汇总查询
	 * 
	 * @param jgid
	 * @param ybxl
	 * @return
	 */
	public String doQueryCancelHzCommit(Integer jgid, String ybxl) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("jgid", jgid);
		parameters.put("mzlb", ybxl);
		List<Map<String, Object>> list = opHzrbDao.doQueryAllMaxHzrq(parameters);
		if (list.size() > 0 && list.get(0) != null) {
			DateTime hzrq = DateUtil.parse(list.get(0).get("HZRQ").toString(), "yyyy-MM-dd HH:mm:ss");
			return MzUtil.toString(hzrq, "yyyy-MM-dd HH:mm:ss");
		} else {
			throw BaseException.create("ERROR_REG_0081");
		}
	}

	/**
	 * 收费汇总产生前验证
	 * 
	 * @param jgid
	 * @param ybxl
	 * @return
	 */
	public void doChargesSummaryBefVerification(Integer jgid, String ybxl) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("JGID", jgid);
		parameters.put("mzlb", ybxl);
		// 收费日报数据
		List<Map<String, Object>> hzrb_list = opHzrbDao.doQueryBeforeValid(parameters);
		// 挂号日报数据
		List<Map<String, Object>> ghrb_list = opGhrbDao.doQueryBeforeValid(parameters);
		// 已结帐未汇总收费付款数据
		List<Map<String, Object>> sfrb_fkmx_list = opSfrbFkmxDao.doQueryBeforeValid(parameters);
		// 已结帐未汇总挂号付款数据
		List<Map<String, Object>> ghrb_fkmx_list = opGhrbFkmxDao.doQueryBeforeValid(parameters);
		if (hzrb_list.size() <= 0 && ghrb_list.size() <= 0 && sfrb_fkmx_list.size() <= 0
				&& ghrb_fkmx_list.size() <= 0) {
			throw BaseException.create("ERROR_REG_0082");
		}
	}

	/**
	 * 收费汇总前验证
	 * 
	 * @param csrq
	 * @param jgid
	 * @param ybxl
	 */
	public void doChargesSummaryCheckOutBefVerification(String hzrqStr, Integer jgid, String ybxl) {
		// 格式化日期为时间类型
		java.util.Date hzrq = DateUtil.parse(hzrqStr, "yyyy-MM-dd HH:mm:ss");
		Map<String, Object> hzrbjzrqparameters = new HashMap<String, Object>();
		hzrbjzrqparameters.put("JGID", jgid);
		hzrbjzrqparameters.put("JZRQ", hzrq);
		hzrbjzrqparameters.put("mzlb", ybxl);

		List<Map<String, Object>> hzrbjzrqlist = opHzrbDao.doQueryCzghByJzrq(hzrbjzrqparameters);
		// 判断在idt_jzrq后是否有新的结帐发生
		if (hzrbjzrqlist.size() > 0) {
			throw BaseException.create("ERROR_REG_0083");
		}
		Map<String, Object> hzrbhzrqparameters = new HashMap<String, Object>();
		hzrbhzrqparameters.put("JGID", jgid);
		hzrbhzrqparameters.put("ldt_begin", DateUtil.beginOfDay(DateUtil.date()).toTimestamp());
		hzrbhzrqparameters.put("ldt_end", DateUtil.endOfDay(DateUtil.date()).toTimestamp());
		hzrbhzrqparameters.put("mzlb", ybxl);

		List<Map<String, Object>> hzrbhzrqlist = opHzrbDao.doQueryCzghByHzrq(hzrbhzrqparameters);
		// 判断在指定的汇总日期是否已有汇总结帐,如果已有则不能再结帐
		if (hzrbhzrqlist.size() > 0) {
			throw BaseException.create("ERROR_REG_0084");
		}
	}

	/**
	 * 取消汇总
	 * 
	 * @param hzrqStr
	 * @param jgid
	 * @param ybxl
	 */
	@Transactional(rollbackFor = Exception.class)
	public void cancelCommit(String hzrqStr, Integer jgid, String ybxl) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		java.util.Date hzdate = DateUtil.parse(hzrqStr, "yyyy-MM-dd HH:mm:ss");
		parameters.put("jgid", jgid);
		parameters.put("mzlb", ybxl);
		parameters.put("hzrq", hzdate);
		//opMzxxDao.updateHzrqToNull(parameters);
		opZffpDao.updateHzrqToNull(parameters);
		opHzrbDao.updateHzrqToNull(parameters);
		//opGhmxDao.updateHzrqToNull(parameters);
		opThmxDao.updateHzrqToNull(parameters);
		opGhrbDao.updateHzrqToNull(parameters);

	}

	List<Map<String, Object>> sfhzhzcxMap = new ArrayList<Map<String, Object>>();

	/**
	 * 收费汇总-收费汇总查询
	 * 
	 * @param ksrq
	 * @param jsrq
	 * @param jgid
	 * @param jgName
	 * @param userName
	 * @param ybxl
	 * @param ip
	 * @return
	 */
	public Map<String, Object> getChargesSummarySearchParameters(String ksrq, String jsrq, Integer jgid, String jgName,
			String userName, String ybxl, String ip) {
		Map<String, Object> response = new HashMap<String, Object>();
		sfhzhzcxMap.clear();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> fkfsparameters = new HashMap<String, Object>();

		parameters.put("JGID", jgid);
		parameters.put("mzlb", ybxl);

		// 格式化日期为时间类型
		java.util.Date ksrqstr = DateUtil.parse(ksrq, "yyyy-MM-dd HH:mm:ss");
		// 格式化日期为时间类型
		java.util.Date jsrqstr = DateUtil.parse(jsrq, "yyyy-MM-dd HH:mm:ss");
		parameters.put("KSRQ", ksrqstr);
		parameters.put("JSRQ", jsrqstr);
		fkfsparameters.put("SYLX", "1");
		fkfsparameters.put("ZFBZ", "0");
		// 收费日报数据
		List<Map<String, Object>> hzghrb_list = opHzrbDao.doQueryHzcx(parameters);

		for (int i = 0; i < hzghrb_list.size(); i++) {
			Map<String, Object> xj_hz_map = new HashMap<String, Object>();
			Integer ygdm = hzghrb_list.get(i).get("YGDM") != null
					? Integer.valueOf(hzghrb_list.get(i).get("YGDM").toString())
					: -1;
			HrPersonnelModel hrPersonnel = hrPersonnelService.getPersonnelById(ygdm);
			if (hrPersonnel != null) {
				hzghrb_list.get(i).put("CZGH", hrPersonnel.getPersonname());
			}
			hzghrb_list.get(i).putAll(xj_hz_map);// 接着放到List 接着对比
		}
		int ghcount = 0;// 人次合计
		double ghAmount = 0.0;// 挂号金额合计
		int thcount = 0;// 退号合计
		int sfcount = 0;// 发票张数合计
		double sfamount = 0.0;// 收费金额合计
		double jcamount = 0.0;// 家床金额合计
		double jkamount = 0.0;// 缴款金额合计
		int zfcount = 0;// 发票作废张数
		double totals = 0.0;// 总的合计
		double xjAmount = 0.0;// 现金合计
		double qtysAmount = 0.0;// 其他应收
		// double smkAmount = 0.0;//市民卡
		// double zpAmount = 0.0;//支票
		double hbwcAmount = 0.0;// 货币误差

		for (int j = 0; j < hzghrb_list.size(); j++) {
			Map<String, Object> m = new HashMap<String, Object>();
			ghcount += ObjectToTypes.parseInt(hzghrb_list.get(j).get("GHRC"));
			thcount += ObjectToTypes.parseInt(hzghrb_list.get(j).get("THSL"));
			ghAmount += ObjectToTypes.parseDouble(hzghrb_list.get(j).get("GHJE"));
			sfcount += ObjectToTypes.parseInt(hzghrb_list.get(j).get("FPZS"));
			zfcount += ObjectToTypes.parseInt(hzghrb_list.get(j).get("ZFZS"));
			sfamount += ObjectToTypes.parseDouble(hzghrb_list.get(j).get("ZJJE"));
			jcamount += ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JCJE"));
			jkamount += ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JCTJKJE"));
			totals += MzUtil.getDouble(ObjectToTypes.parseDouble(hzghrb_list.get(j).get("ZJJE"))
					+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("GHJE"))
					+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JCJE"))
					+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JCTJKJE")), 2);
			xjAmount += ObjectToTypes.parseDouble(hzghrb_list.get(j).get("XJJE"));
			qtysAmount += ObjectToTypes.parseDouble(hzghrb_list.get(j).get("QTYS"));
			hbwcAmount += ObjectToTypes.parseDouble(hzghrb_list.get(j).get("HBWC"));
			m.put("CZGH", hzghrb_list.get(j).get("CZGH") + "");
			m.put("GHJE", String.format("%1$.2f", hzghrb_list.get(j).get("GHJE")));
			m.put("GHRC", hzghrb_list.get(j).get("GHRC") + "");
			m.put("THSL", hzghrb_list.get(j).get("THSL") + "");
			m.put("ZJJE", String.format("%1$.2f", hzghrb_list.get(j).get("ZJJE")));
			m.put("JCJE", String.format("%1$.2f", hzghrb_list.get(j).get("JCJE")));
			m.put("JCTJKJE", String.format("%1$.2f", hzghrb_list.get(j).get("JCTJKJE")));
			m.put("FPZS", hzghrb_list.get(j).get("FPZS") + "");
			m.put("ZFZS", hzghrb_list.get(j).get("ZFZS") + "");
			m.put("QTYS", String.format("%1$.2f", hzghrb_list.get(j).get("QTYS")));
			m.put("HBWC", String.format("%1$.2f", hzghrb_list.get(j).get("HBWC")));
			m.put("XJJE", String.format("%1$.2f", hzghrb_list.get(j).get("XJJE")));
			m.put("TOTALAMOUNT",
					String.format("%1$.2f",
							MzUtil.getDouble(ObjectToTypes.parseDouble(hzghrb_list.get(j).get("ZJJE"))
									+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("GHJE"))
									+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JCJE"))
									+ ObjectToTypes.parseDouble(hzghrb_list.get(j).get("JCTJKJE")), 2)));

			Map<String, Object> parameters2 = new HashMap<String, Object>();
			parameters2.put("jgid", jgid);
			// 获取门诊类别
			Integer mzlb = opMzlbSer.getMzlb(jgid, ip);
			parameters2.put("mzlb", mzlb);
			parameters2.put("czgh", hzghrb_list.get(j).get("YGDM") + "");
//				parameters2.put("hzrq", cdate.getTime());
			parameters2.put("ksrq", ksrqstr);
			parameters2.put("jsrq", jsrqstr);
			List<Map<String, Object>> ids_fkfs = opFkxxDao.doQueryHzcxFkxx(parameters2);
			List<Map<String, Object>> ids_brxz = opMzxxDao.doQueryHzcxBrxz(parameters2);
			String qtysFb = "";
			String jzjeSt = "0.00";
			if (ids_fkfs != null && ids_fkfs.size() != 0) {
				for (int n = 0; n < ids_fkfs.size(); n++) {
					qtysFb = qtysFb + ids_fkfs.get(n).get("FKMC") + ":"
							+ String.format("%1$.2f", ids_fkfs.get(n).get("FKJE")) + " ";
				}
			}
			if (ids_brxz != null && ids_brxz.size() != 0) {
				for (int n = 0; n < ids_brxz.size(); n++) {
					if (ids_brxz.get(n).get("DBPB") != null
							&& Integer.parseInt(ids_brxz.get(n).get("DBPB") + "") == 0) {
						jzjeSt = String.format("%1$.2f", ObjectToTypes.parseDouble(jzjeSt)
								+ ObjectToTypes.parseDouble(ids_brxz.get(n).get("QTYS") + ""));
					} else {
						qtysFb = qtysFb + ids_brxz.get(n).get("XZMC") + ":"
								+ String.format("%1$.2f", ObjectToTypes.parseDouble(ids_brxz.get(n).get("QTYS") + ""))
								+ " ";
					}
				}
				qtysFb = qtysFb + " " + "记账 :" + jzjeSt + " ";
			}
			m.put("fkxx", qtysFb);
			sfhzhzcxMap.add(m);
		}
		// }
		// response.put("smkAmount", String.format("%1$.2f", smkAmount));
		// response.put("zpAmount", String.format("%1$.2f", zpAmount));
		response.put("startSummaryDate", ksrqstr);
		response.put("preparedby", jgName);
		response.put("summaryDate", jsrqstr);
		response.put("Lister", userName);
		response.put("DateTabling", DateUtil.date().toSqlDate());
		response.put("totals", String.format("%1$.2f", totals));
		response.put("ghcount", ghcount + "");
		response.put("thcount", thcount + "");
		response.put("ghAmount", String.format("%1$.2f", ghAmount));
		response.put("sfcount", sfcount + "");
		response.put("zfcount", zfcount + "");
		response.put("sfamount", String.format("%1$.2f", sfamount));
		response.put("jcamount", String.format("%1$.2f", jcamount));
		response.put("jkamount", String.format("%1$.2f", jkamount));
		response.put("xjAmount", String.format("%1$.2f", xjAmount));
		response.put("qtysAmount", String.format("%1$.2f", qtysAmount));
		response.put("hbwcAmount", String.format("%1$.2f", hbwcAmount));
		Map<String, Object> parameters2 = new HashMap<String, Object>();
		parameters2.put("jgid", jgid);
		parameters2.put("mzlb", ybxl);
//			parameters2.put("hzrq", cdate.getTime());
		parameters2.put("ksrq", ksrqstr);
		parameters2.put("jsrq", jsrqstr);
		List<Map<String, Object>> ids_fkfs = opFkxxDao.doQueryHzcxFkxxA(parameters2);
		List<Map<String, Object>> ids_brxz = opMzxxDao.doQueryHzcxBrxzA(parameters2);
		String qtysFb = "";
		String jzjeSt = "0.00";
		if (ids_fkfs != null && ids_fkfs.size() != 0) {
			for (int n = 0; n < ids_fkfs.size(); n++) {
				qtysFb = qtysFb + ids_fkfs.get(n).get("FKMC") + ":"
						+ String.format("%1$.2f", ids_fkfs.get(n).get("FKJE")) + " ";
			}
		}
		if (ids_brxz != null && ids_brxz.size() != 0) {
			for (int n = 0; n < ids_brxz.size(); n++) {
				if (ids_brxz.get(n).get("DBPB") != null && Integer.parseInt(ids_brxz.get(n).get("DBPB") + "") == 0) {
					jzjeSt = String.format("%1$.2f", ObjectToTypes.parseDouble(jzjeSt)
							+ ObjectToTypes.parseDouble(ids_brxz.get(n).get("QTYS") + ""));
				} else {
					qtysFb = qtysFb + ids_brxz.get(n).get("XZMC") + ":"
							+ String.format("%1$.2f", ObjectToTypes.parseDouble(ids_brxz.get(n).get("QTYS") + ""))
							+ " ";
				}
			}
			qtysFb = qtysFb + " " + "记账 :" + jzjeSt + " ";
		}
		response.put("fkxxAmount", qtysFb);
		return response;
	}

	/**
	 * 汇总查询
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getChargesSummarySearchFields() {
		List<Map<String, Object>> records = new ArrayList<Map<String, Object>>();
		records.addAll(sfhzhzcxMap);
		return records;
	}

	/**
	 * 项目分类汇总
	 * 
	 * @param beginDay
	 * @param endDay
	 * @param jgid
	 * @param userName
	 * @param ybxl
	 * @return
	 */
	public Map<String, Object> getItemizeSummaryParameters(Date beginDay, Date endDay, Integer jgid, String jgName,
			String userName, String ybxl) {
		Map<String, Object> response = new HashMap<String, Object>();
		SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");

		response.put("ZBRQ", DateUtil.date().toSqlDate());
		response.put("ZBDW", jgName);
		response.put("ZBR", userName);

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("al_jgid", jgid);
		parameters.put("adt_begin", DateUtil.beginOfDay(DateUtil.date(beginDay)).toTimestamp());
		parameters.put("adt_end", DateUtil.endOfDay(DateUtil.date(endDay)).toTimestamp());
		parameters.put("mzlb", ybxl);
		List<Map<String, Object>> mxList = opRbmxDao.doQueryRbmxje(parameters);
		List<Map<String, Object>> ghList = opGhrbDao.doQueryGHrbSumje(parameters);
		Map<String, Object> ghmap = opHzrbDao.doQueryHzSumje(parameters);

		double HJ = 0;
		double GHSF = 0;
		double YPSF = 0;
		double SFXM = 0;
		double XJJE = 0;
		// double ZHJE =0;
		// double JZJE =0;
		Date JSRQ = null;
//			String fkxx="";
		if (mxList.size() > 0 && mxList != null && mxList.get(0) != null) {
			for (int i = 0; i < mxList.size(); i++) {
				Map<String, Object> m = mxList.get(i);
				parameters.clear();
				parameters.put("SFXM", Long.parseLong(m.get("SFXM").toString()));
				Map<String, Object> xmMap = dicSfxmlbService.doQuerySfxm(parameters);
				m.put("FYFL", xmMap.get("FYFL"));
				m.put("SFMC", xmMap.get("SFMC"));
				if ("1".equals(xmMap.get("FYFL").toString())) {
//						SFXM += (Double) m.get("SFJE");
					SFXM += Double.parseDouble(m.get("SFJE").toString());
				} else if ("2".equals(xmMap.get("FYFL").toString())) {
//						YPSF += (Double) m.get("SFJE");
					YPSF += Double.parseDouble(m.get("SFJE").toString());
				} else if ("3".equals(xmMap.get("FYFL").toString())) {
//						SFXM += (Double) m.get("SFJE");
					SFXM += Double.parseDouble(m.get("SFJE").toString());
				}
//					HJ += (Double) m.get("SFJE");
				HJ += Double.parseDouble(m.get("SFJE").toString());
			}
		}

		if (ghList.size() > 0 && ghList != null && ghList.get(0) != null) {
			GHSF += ObjectToTypes.getDoubleValue(ghList.get(0).get("GHJE"));
			HJ += ObjectToTypes.getDoubleValue(ghList.get(0).get("GHJE"));
			GHSF += ObjectToTypes.getDoubleValue(ghList.get(0).get("ZLJE"));
			HJ += ObjectToTypes.getDoubleValue(ghList.get(0).get("ZLJE"));
			GHSF += ObjectToTypes.getDoubleValue(ghList.get(0).get("ZJFY"));
			HJ += ObjectToTypes.getDoubleValue(ghList.get(0).get("ZJFY"));
			GHSF += ObjectToTypes.getDoubleValue(ghList.get(0).get("BLJE"));
			HJ += ObjectToTypes.getDoubleValue(ghList.get(0).get("BLJE"));

		}
		String KSRQ = null;
//			if(ghList != null && ghList.size() > 0&&ghList.get(0).get("KSRQ")!=null){
//				KSRQ=sdfdate.format(ghList.get(0).get("KSRQ"));
//			}
//			if(KSRQ==null){
//				KSRQ=datefrom + " 00:00:00";
//			}
		// 汇总时间显示为查询
		response.put("KSRQ", beginDay);
//			if(JSRQ==null){
//				JSRQ=sdfdate.parse(dateto + " 23:59:59");
//			}
//			response.put("JSRQ", sdfdate.format(JSRQ));
		if (ghmap != null && ghmap.size() > 0 && ghmap.get(0) != null) {
			XJJE = HJ - ObjectToTypes.getDoubleValue(ghmap.get("JZJE"));
			response.put("JZJE", String.format("%1$.2f", ObjectToTypes.getDoubleValue(ghmap.get("JZJE"))));
		}

		response.put("JSRQ", endDay);
		response.put("GHSF", String.format("%1$.2f", GHSF));
		response.put("YPSF", String.format("%1$.2f", YPSF));
		response.put("SFXM", String.format("%1$.2f", SFXM));
		response.put("HJ", String.format("%1$.2f", HJ));
		response.put("HJDX", MzUtil.changeMoneyUpper(String.format("%1$.2f", HJ)));
//			response.put("ZHJE", String.format("%1$.2f", getDoubleValue(ghmap.get("ZHJE"))));
		response.put("XJJE", String.format("%1$.2f", XJJE));
//			response.put("TCZF", String.format("%1$.2f", getDoubleValue(ghmap.get("TCZF"))));

		parameters.clear();
		parameters.put("al_jgid", jgid);
		parameters.put("adt_begin", DateUtil.beginOfDay(DateUtil.date(beginDay)).toTimestamp());
		parameters.put("adt_end", DateUtil.endOfDay(DateUtil.date(endDay)).toTimestamp());
//			}
		Map<String, Object> parameters2 = new HashMap<String, Object>();
		parameters2.put("jgid", jgid);
//			parameters2.put("mzlb",Long.parseLong(BSPHISUtil.getMZLB(JGID, dao) + ""));
//			parameters2.put("hzrq", cdate.getTime());
		parameters2.put("ksrq", DateUtil.beginOfDay(DateUtil.date(beginDay)).toTimestamp());
		parameters2.put("jsrq", DateUtil.endOfDay(DateUtil.date(endDay)).toTimestamp());
		parameters2.put("mzlb", ybxl);
		List<Map<String, Object>> ids_fkfs = opFkxxDao.doQueryXmflhzFkxx(parameters2);
		List<Map<String, Object>> ids_brxz = opMzxxDao.doQueryXmflhz(parameters2);
		String qtysFb = "";
		String jzjeSt = "0.00";
		if (ids_fkfs.size() != 0 && ids_fkfs != null && ids_fkfs.get(0) != null) {
			for (int n = 0; n < ids_fkfs.size(); n++) {
				qtysFb = qtysFb + ids_fkfs.get(n).get("FKMC") + ":"
						+ String.format("%1$.2f", ids_fkfs.get(n).get("FKJE")) + " ";
			}
		}
		if (ids_brxz.size() != 0 && ids_brxz != null && ids_brxz.get(0) != null) {
			for (int n = 0; n < ids_brxz.size(); n++) {
				if (ids_brxz.get(n).get("DBPB") != null && Integer.parseInt(ids_brxz.get(n).get("DBPB") + "") == 0) {
					jzjeSt = String.format("%1$.2f", ObjectToTypes.parseDouble(jzjeSt)
							+ ObjectToTypes.parseDouble(ids_brxz.get(n).get("QTYS") + ""));
				} else {
					qtysFb = qtysFb + ids_brxz.get(n).get("XZMC") + ":"
							+ String.format("%1$.2f", ObjectToTypes.parseDouble(ids_brxz.get(n).get("QTYS") + ""))
							+ " ";
				}
			}
			qtysFb = qtysFb + " " + "记账 :" + jzjeSt + " ";
		}
		response.put("fkxx", qtysFb);
		return response;
	}

	/**
	 * 项目分类汇总
	 * 
	 * @param jgid
	 * @param beginDay
	 * @param endDay
	 * @param ybxl
	 * @return
	 */

	public List<Map<String, Object>> getItemizeSummaryFields(Integer jgid, Date beginDay, Date endDay, String ybxl) {
		List<Map<String, Object>> records = new ArrayList<Map<String, Object>>();
		SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("al_jgid", jgid);
		parameters.put("adt_begin", DateUtil.beginOfDay(DateUtil.date(beginDay)).toTimestamp());
		parameters.put("adt_end", DateUtil.endOfDay(DateUtil.date(endDay)).toTimestamp());
		parameters.put("mzlb", ybxl);
		List<Map<String, Object>> mxList = opRbmxDao.doQuerySfxmJe(parameters);
		List<Map<String, Object>> ghList = opGhrbDao.doQuerySumJe(parameters);
		List<Map<String, Object>> zhList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> ypList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> fyList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> gresult = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < mxList.size(); i++) {
			Map<String, Object> m = mxList.get(i);
			parameters.clear();
			parameters.put("SFXM", Long.parseLong(m.get("SFXM").toString()));
			Map<String, Object> xmMap = dicSfxmlbService.doQuerySfxm(parameters);
			m.put("FYFL", xmMap.get("FYFL"));
			m.put("SFMC", xmMap.get("SFMC"));
			if ("1".equals(xmMap.get("FYFL").toString())) {
				fyList.add(m);
			} else if ("2".equals(xmMap.get("FYFL").toString())) {
				ypList.add(m);
			} else if ("3".equals(xmMap.get("FYFL").toString())) {
				fyList.add(m);
			}
			zhList.add(m);
		}
		int row = Math.max(5, ypList.size());
		row = Math.max(row, fyList.size() / 2 + 1);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> m = ghList.get(0);
		map.put("SFMC1", "挂号金额");
		map.put("SFJE1", m.get("GHJE"));
		gresult.add(map);
		map = new HashMap<String, Object>();
		map.put("SFMC1", "诊疗金额");
		map.put("SFJE1", m.get("ZLJE"));
		gresult.add(map);
		map = new HashMap<String, Object>();
		map.put("SFMC1", "专家费用");
		map.put("SFJE1", m.get("ZJFY"));
		gresult.add(map);
		map = new HashMap<String, Object>();
		map.put("SFMC1", "病历金额");
		map.put("SFJE1", m.get("BLJE"));
		gresult.add(map);
		map = new HashMap<String, Object>();
		map.put("SFMC1", "就诊卡金额");
		map.put("SFJE1", "");
		gresult.add(map);
		for (int i = 0; i < row; i++) {
			if (gresult.size() > i) {
				map = gresult.get(i);
			} else {
				map = new HashMap<String, Object>();
			}
			if (map == null) {
				map = new HashMap<String, Object>();
			}
			m = null;
			if (ypList.size() > i) {
				m = ypList.get(i);
				map.put("SFMC2", m.get("SFMC"));
				map.put("SFJE2", m.get("SFJE"));
			}
			if (fyList.size() > i * 2) {
				m = fyList.get(i * 2);
				map.put("SFMC3", m.get("SFMC"));
				map.put("SFJE3", m.get("SFJE"));
			}
			if (fyList.size() > i * 2 + 1) {
				m = fyList.get(i * 2 + 1);
				map.put("SFMC4", m.get("SFMC"));
				map.put("SFJE4", m.get("SFJE"));
			}
			result.add(map);
		}
		records.addAll(result);
		return records;
	}

	/**
	 * 未结账收费汇总
	 * 
	 * @param ybxl
	 * @param jgid
	 * @param userid
	 * @param userName
	 * @param jgName
	 * @return
	 */
	public Map<String, Object> getOutstandingChargesSummaryParameters(String ybxl, Integer jgid, Integer userid,
			String userName, String jgName) {
		Map<String, Object> response = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("jgid", jgid);
		parameters.put("mzlb", ybxl);

		Map<String, Object> parametersUser = new HashMap<String, Object>();
		parametersUser.put("jgid", jgid);
		parametersUser.put("mzlb", ybxl);

		// 收费日报表单
		List<Map<String, Object>> sfrb_list = opMzxxDao.doQueryWjzsf(parametersUser);
		// 挂号日报表单
		List<Map<String, Object>> ghrb_list = opGhmxDao.doQueryFpzsAndZjje(parametersUser);
		if (sfrb_list == null && ghrb_list == null) {
			return response;
		}
		if (sfrb_list.size() == 0 && ghrb_list.size() == 0) {
			return response;
		}

		// 已结帐未汇总收费表单 和已结帐未汇总挂号表单
		List<Map<String, Object>> yjzghsf_list = opMzxxDao.doQueryFkje(parameters);

		Integer ghcount = 0;
		Double ghAmount = 0D;
		Integer sfcount = 0;
		Double sfAmount = 0D;
		Double jcAmount = 0D;
		Double jcjkAmount = 0D;
		Double totals = 0D;
		Double xjAmount = 0D;
		Double zpAmount = 0D;
		Double yhkAmount = 0D;
		Double yhAmount = 0D;
		Double qtAmount = 0D;
		Double grAmount = 0D;
		Double qtysAmount = 0D;
		Double hbwcAmount = 0D;
		Double khAmount = 0D;
		Double jkAmount = 0D;
		Double tkAmount = 0D;
		Double finalAmount = 0D;
		Double zfbAmount = 0D;
		if (ghrb_list != null && ghrb_list.size() > 0) {
			Map<String, Object> ghrb_map = ghrb_list.get(0);
			if (ghrb_map != null) {
				ghcount = ObjectToTypes.getIntValue(ghrb_map.get("FPZS"));
				ghAmount = ObjectToTypes.getDoubleValue(ghrb_map.get("ZJJE"));
			} else {
				ghcount = 0;
				ghAmount = 0D;
			}
		}
		if (sfrb_list != null && sfrb_list.size() > 0) {
			Map<String, Object> sfrb_map = sfrb_list.get(0);
			if (sfrb_map != null) {
				sfcount = ObjectToTypes.getIntValue(sfrb_map.get("FPZS"));
				sfAmount = ObjectToTypes.getDoubleValue(sfrb_map.get("ZJJE"));
				jcAmount = ObjectToTypes.getDoubleValue(sfrb_map.get("JCJE"));
				jcjkAmount = ObjectToTypes.getDoubleValue(sfrb_map.get("JCTJKJE"));
			} else {
				sfcount = 0;
				sfAmount = 0D;
				jcAmount = 0D;
				jcjkAmount = 0D;
			}
		}
		totals = ghAmount + sfAmount + jcAmount + jcjkAmount;
		for (int i = 0; i < yjzghsf_list.size(); i++) {
			Map<String, Object> yjzghsf_map = yjzghsf_list.get(i);
			// String ll_fkfs = yjzsf_map.get("FKFS") + "";
			Double ld_fkje = ObjectToTypes.getDoubleValue(yjzghsf_map.get("FKJE"));
			Double ld_qtys = ObjectToTypes.getDoubleValue(yjzghsf_map.get("QTYS"));
			if ("1".equals(yjzghsf_map.get("FKLB") + "")) {
				xjAmount = ld_fkje;
			} else if ("2".equals(yjzghsf_map.get("FKLB") + "")) {
				zpAmount = ld_fkje;
			} else if ("4".equals(yjzghsf_map.get("FKLB") + "")) {
				hbwcAmount = ld_fkje;
			} else if ("5".equals(yjzghsf_map.get("FKLB") + "")) {
				yhAmount = ld_fkje;
			} else if ("6".equals(yjzghsf_map.get("FKLB") + "")) {
				yhkAmount = ld_fkje;
				response.put("yhkAmount", ld_fkje);
			} else if ("12".equals(yjzghsf_map.get("FKLB") + "")) {
				zfbAmount = ld_fkje;
				response.put("yhkAmount", ld_fkje);
			} else {
				qtAmount += ld_fkje;
			}
			if (!"4".equals(yjzghsf_map.get("FKLB") + "")) {
				qtysAmount += ld_qtys;
			}
		}

		response.put("ghcount", ghcount.toString());
		response.put("ghAmount", String.format("%1$.2f", ghAmount));
		response.put("sfcount", sfcount.toString());
		response.put("sfAmount", String.format("%1$.2f", sfAmount));
		response.put("jcamount", String.format("%1$.2f", jcAmount));
		response.put("jcjkamount", String.format("%1$.2f", jcjkAmount));
		response.put("totals", String.format("%1$.2f", totals));
		response.put("xjAmount", String.format("%1$.2f", xjAmount));
		response.put("zpAmount", String.format("%1$.2f", zpAmount));
		response.put("yhkAmount", String.format("%1$.2f", yhkAmount));
		response.put("yhAmount", String.format("%1$.2f", yhAmount));
		response.put("qtAmount", String.format("%1$.2f", qtAmount));
		response.put("grAmount", String.format("%1$.2f", grAmount));
		response.put("qtysAmount", String.format("%1$.2f", qtysAmount));
		response.put("hbwcAmount", String.format("%1$.2f", hbwcAmount));
		response.put("khAmount", String.format("%1$.2f", khAmount));
		response.put("jkAmount", String.format("%1$.2f", jkAmount));
		response.put("tkAmount", String.format("%1$.2f", tkAmount));
		response.put("finalAmount", String.format("%1$.2f", finalAmount));
		response.put("zfbAmount", String.format("%1$.2f", zfbAmount));
		response.put("preparedby", jgName);
		response.put("Lister", userName);
		response.put("DateTabling", DateUtil.date().toSqlDate());
		Map<String, Object> m = opGhmxDao.doQueryCountByCondition(parametersUser);
		long ll_ghth = m != null ? ObjectToTypes.toLong(m.get("NUM")) : 0;

		response.put("GHTH", ll_ghth + "");
		List<Map<String, Object>> ll_zffpObj = opMzxxDao.doQueryFphmByCondition(parametersUser);
		int ll_zffp = ll_zffpObj.size();
		response.put("ZFFP", ll_zffp + "");
		String zffpstr = "";
		for (int i = 0; i < ll_zffpObj.size(); i++) {
			Map<String, Object> map = ll_zffpObj.get(i);
			if (i == 0) {
				zffpstr = map.get("FPHM") + "";
			} else {
				zffpstr += "," + map.get("FPHM");
			}
		}
		response.put("ZFFPSTR", zffpstr);
		return response;
	}

	/**
	 * 未结账收费汇总
	 * 
	 * @param ybxl
	 * @param jgid
	 * @param userid
	 * @return
	 */
	public List<Map<String, Object>> getOutstandingChargesSummaryFields(String ybxl, Integer jgid, Integer userid) {
		List<Map<String, Object>> records = new ArrayList<Map<String, Object>>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("jgid", jgid);
		parameters.put("mzlb", ybxl);

		Map<String, Object> parametersUser = new HashMap<String, Object>();
		parametersUser.put("jgid", jgid);
		parametersUser.put("mzlb", ybxl);

		// 第一段sql
		List<Map<String, Object>> sfghrb_list = opMzxxDao.doQueryWjzsfhz(parametersUser);
		// 第二段sql
		List<Map<String, Object>> yjzghsf_list = opMzxxDao.doQueryWjzsfhzJe(parameters);
		List<Map<String, Object>> reList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < sfghrb_list.size(); i++) {
			Map<String, Object> reMap = sfghrb_list.get(i);// 第一段sql的结果集的一条记录
			reMap.put("XJJE", "0.00");
			reMap.put("ZPJE", "0.00");
			reMap.put("HBWC", "0.00");
			reMap.put("YHJE", "0.00");
			reMap.put("YHKJE", "0.00");
			reMap.put("QTZF", "0.00");
			reMap.put("QTYS", "0.00");
			reMap.put("GRZH", "0.00");
			reMap.put("ZFBJE", "0.00");
			for (int j = 0; j < yjzghsf_list.size(); j++) {
				if ((reMap.get("CZGH") + "").equals(yjzghsf_list.get(j).get("CZGH") + "")) {// 第二段sql的结果集的一条记录
					Map<String, Object> yjzghsf_map = yjzghsf_list.get(j);
					Double ld_fkje = ObjectToTypes.getDoubleValue(yjzghsf_map.get("FKJE"));
					Double ld_qtys = ObjectToTypes.getDoubleValue(yjzghsf_map.get("QTYS"));
					if ("1".equals(yjzghsf_map.get("FKLB") + "")) {
						reMap.put("XJJE", String.format("%1$.2f", ld_fkje));
					} else if ("2".equals(yjzghsf_map.get("FKLB") + "")) {
						reMap.put("ZPJE", String.format("%1$.2f", ld_fkje));
					} else if ("4".equals(yjzghsf_map.get("FKLB") + "")) {
						reMap.put("HBWC", String.format("%1$.2f", ld_fkje));
					} else if ("5".equals(yjzghsf_map.get("FKLB") + "")) {
						reMap.put("YHJE", String.format("%1$.2f", ld_fkje));
					} else if ("6".equals(yjzghsf_map.get("FKLB") + "")) {
						reMap.put("YHKJE", String.format("%1$.2f", ld_fkje));
					} else if ("12".equals(yjzghsf_map.get("FKLB") + "")) {
						reMap.put("ZFBJE", String.format("%1$.2f", ld_fkje));
					} else {
						reMap.put("QTZF",
								String.format("%1$.2f", ld_fkje + ObjectToTypes.getDoubleValue(reMap.get("QTZF"))));
					}
					if (!"4".equals(yjzghsf_map.get("FKLB") + "")) {
						reMap.put("QTYS", String.format("%1$.2f",
								MzUtil.getDouble(ld_qtys + ObjectToTypes.getDoubleValue(reMap.get("QTYS")), 2)));
					}

				}
			}

			Integer czgh = reMap.get("CZGH") != null ? Integer.valueOf(reMap.get("CZGH").toString()) : -1;
			HrPersonnelModel hrPersonnel = hrPersonnelService.getPersonnelById(czgh);
			if (hrPersonnel != null) {
				reMap.put("CZGH", hrPersonnel.getPersonname());
			}
			reMap.put("GHJE", String.format("%1$.2f", reMap.get("GHJE")));
			reMap.put("SFJE", String.format("%1$.2f", reMap.get("ZJJE")));
			reMap.put("JCJE", String.format("%1$.2f", reMap.get("JCJE")));
			reMap.put("JCTJKJE", String.format("%1$.2f", reMap.get("JCTJKJE")));
			reMap.put("TOTALAMOUNT",
					String.format("%1$.2f",
							MzUtil.getDouble(ObjectToTypes.getDoubleValue(reMap.get("GHJE"))
									+ ObjectToTypes.getDoubleValue(reMap.get("SFJE"))
									+ ObjectToTypes.getDoubleValue(reMap.get("JCJE"))
									+ ObjectToTypes.getDoubleValue(reMap.get("JCTJKJE")), 2)));
			reList.add(reMap);
		}
		records.addAll(reList);
		return records;
	}

	public List<Map<String, Object>> getOpsfmxListFields(String jzksrq,String jzjsrq,String save, int jgid,
														 int userId, String ip) {
        Integer mzlb = opMzlbSer.getMzlb(jgid,ip);
		List<Map<String, Object>> records = null;
        if("0".equals(save)){
			records = opMzxxDao.doQuerySfxmList(jzksrq,jzjsrq,mzlb, StrUtil.null2Str(userId),StrUtil.null2Str(jgid));
		}else if("2".equals(save)){
			records = opMzxxDao.getOprbmxbyjzrq(jzjsrq,mzlb, userId,jgid);
		}
		if(records.size()>0){
			BigDecimal srje = new BigDecimal(0);
			BigDecimal zk = new BigDecimal(0);
			BigDecimal sjsr = new BigDecimal(0);
			for(int i=0;i<records.size();i++){
				String a = String.valueOf(records.get(i).get("ZJJE"));
				srje = srje.add(new BigDecimal(String.valueOf(records.get(i).get("ZJJE"))));
				zk = zk.add(new BigDecimal(String.valueOf(records.get(i).get("ZKJE"))));
				sjsr = sjsr.add(new BigDecimal(String.valueOf(records.get(i).get("SJJE"))));
			}
			Map<String,Object> map = new HashMap<>();
			map.put("SFMC","合计");
			map.put("ZJJE",srje);
			map.put("ZKJE",zk);
			map.put("SJJE",sjsr);
			records.add(map);
		}

		return records;
		}

	public Map<String, Object> getOpParameters(SysUser user,String jzksrq,String jzjsrq,String save,List<Map<String,Object>> list,String ip) {
        Integer mzlb = opMzlbSer.getMzlb(user.getHospitalId(),ip);
		Map<String, Object> map = new HashMap<>();
        if("0".equals(save) && list.size()>0){
			String YHJE = list.get(list.size()-1).get("ZKJE")+"";
			List<Map<String, Object>> list_fkxx = opMzxxDao.doQueryFkxxMap(jzksrq,jzjsrq,mzlb, user.getUserId(),user.getHospitalId());
			BigDecimal XJ = BigDecimal.ZERO;
			BigDecimal ZP = BigDecimal.ZERO;
			BigDecimal WX = BigDecimal.ZERO;
			BigDecimal ZFB = BigDecimal.ZERO;
			BigDecimal CZK = BigDecimal.ZERO;
			BigDecimal POS = BigDecimal.ZERO;
			BigDecimal HBWC = BigDecimal.ZERO;
			BigDecimal KYCK = BigDecimal.ZERO;
			for (Map<String, Object> fkxx_map : list_fkxx) {
				if("1".equals(StrUtil.null2Str(fkxx_map.get("fkfs")))){
					XJ = new BigDecimal(StrUtil.null2Str(fkxx_map.get("fkje")));
				}
				if("2".equals(StrUtil.null2Str(fkxx_map.get("fkfs")))){
					ZP = new BigDecimal(StrUtil.null2Str(fkxx_map.get("fkje")));
				}
				if("3".equals(StrUtil.null2Str(fkxx_map.get("fkfs")))){
					WX = new BigDecimal(StrUtil.null2Str(fkxx_map.get("fkje")));
				}
				if("4".equals(StrUtil.null2Str(fkxx_map.get("fkfs")))){
					ZFB = new BigDecimal(StrUtil.null2Str(fkxx_map.get("fkje")));
				}
				if("5".equals(StrUtil.null2Str(fkxx_map.get("fkfs")))){
					POS = new BigDecimal(StrUtil.null2Str(fkxx_map.get("fkje")));
				}
				if("9".equals(StrUtil.null2Str(fkxx_map.get("fkfs")))){
					CZK = new BigDecimal(StrUtil.null2Str(fkxx_map.get("fkje")));
				}
				if("10".equals(StrUtil.null2Str(fkxx_map.get("fkfs")))){
					HBWC = new BigDecimal(StrUtil.null2Str(fkxx_map.get("fkje")));
				}
				if("36".equals(StrUtil.null2Str(fkxx_map.get("fkfs")))){
					KYCK = new BigDecimal(StrUtil.null2Str(fkxx_map.get("fkje")));
				}
			}

			map.put("jgid",user.getHospitalName());
			map.put("jzksrq",jzksrq);
			map.put("jzjsrq",jzjsrq);
			map.put("userid",user.getLoginName());
			map.put("username",user.getUserName());
			map.put("djbh","");
			map.put("czrq",DateUtil.date().toSqlDate());

			map.put("XJ",XJ);
			map.put("ZP",ZP);
			map.put("POS",POS);
			map.put("ZFB",ZFB);
			map.put("WX",WX);
			map.put("CZK",CZK);
			map.put("HBWC",HBWC);
			map.put("KYCK",KYCK);
			map.put("YHJE",YHJE);
			map.put("POSA",POS.add(ZFB).add(WX).add(CZK));

			Map<String, Object> map_ghyb = opMzxxDao.doQueryGhybMap(jzksrq,jzjsrq,mzlb, user.getUserId(),user.getHospitalId());
			Map<String, Object> map_sfyb = opMzxxDao.doQuerySfybMap(jzksrq,jzjsrq,mzlb, user.getUserId(),user.getHospitalId());
			BigDecimal QTYS = BigDecimal.ZERO;
			QTYS = StrUtil.null2Str(map_ghyb.get("QTYS"))==""?BigDecimal.ZERO:new BigDecimal(String.valueOf(map_ghyb.get("QTYS"))).add(
					StrUtil.null2Str(map_sfyb.get("QTYS"))==""?BigDecimal.ZERO:new BigDecimal(String.valueOf(map_sfyb.get("QTYS"))) );
			map.put("JZJE",QTYS);
			map.put("QTYS",QTYS);
			map.put("SBJZ","0.00");
			map.put("QTJZ","0.00");
			BigDecimal ZJE = BigDecimal.ZERO;
			ZJE = QTYS.add(XJ).add(ZP).add(POS).add(HBWC).add(ZFB).add(WX).add(CZK);
			map.put("ZJE",ZJE);

			map.put("YJJ_XJ","0.00");
			map.put("YJJ_ZP","0.00");
			map.put("YJJ_POS","0.00");
			map.put("YJJ_HJ","0.00");
			map.put("TJJ_XJ","0.00");
			map.put("TJJ_ZP","0.00");
			map.put("TJJ_POS","0.00");
			map.put("TJJ_HJ","0.00");
			map.put("SS_HJ",XJ.add(ZP).add(POS).add(HBWC).add(ZFB).add(WX).add(CZK));

			List<Map<String, Object>> list_sjh = opMzxxDao.doQuerySjh(jzksrq,jzjsrq,mzlb, user.getUserId(),user.getHospitalId());
			List<Map<String, Object>> list_fph = opMzxxDao.doQueryFph(jzksrq,jzjsrq,mzlb, user.getUserId(),user.getHospitalId());
			map.put("sjh","");
			map.put("fph","");
			map.put("sjzs","0");
			map.put("fpzs","0");
			if(list_sjh.size()>0){
				map.put("sjh",list_sjh.get(0).get("JZHM")+"---"+list_sjh.get(list_sjh.size()-1).get("JZHM"));
				map.put("sjzs",list_sjh.size());
			}
			if(list_fph.size()>0){
				map.put("fph",list_fph.get(0).get("FPHM")+"---"+list_fph.get(list_fph.size()-1).get("FPHM"));
				map.put("fpzs",list_fph.size());
			}
			map.put("sjje","0");
			map.put("fpje","0");
		}else if("2".equals(save)){
        	map = opMzxxDao.doQueryOprbmxsfmxbyjzrq(jzjsrq,mzlb, user.getUserId(),user.getHospitalId());
        	if(map!=null){
				map.put("djbh",map.get("RBID"));
				map.put("jgid",user.getHospitalName());
				map.put("jzksrq",jzksrq);
				map.put("jzjsrq",jzjsrq);
				map.put("userid",user.getLoginName());
				map.put("username",user.getUserName());
				map.put("czrq",DateUtil.date().toSqlDate());
				map.put("sjh",map.get("SJH"));
				map.put("sjzs",map.get("SJZS"));
				map.put("sjje",map.get("SJJE"));
				map.put("fph",map.get("FPH"));
				map.put("fpzs",map.get("FPZS"));
				map.put("fpje",map.get("FPJE"));
				map.put("POSA",new BigDecimal(map.get("POS")+"").add(new BigDecimal(map.get("ZFB")+""))
						.add(new BigDecimal(map.get("WX")+"")).add(new BigDecimal(map.get("CZK")+""))   );
			}

		}

		return map;
	}

    /**
     * 查询收费日报
     *
     * @param user
     * @param ip
     */
    public List<SfrbResp> doQueSfrbList(SysUser user,String ip) {
        List<SfrbResp> resp = new ArrayList<SfrbResp>();
        Integer mzlb = opMzlbSer.getMzlb(user.getHospitalId(), ip);
        List<Map<String, Object>> list = opMzxxDao.doQuerySfrbList(user.getUserId(),user.getHospitalId(),mzlb);
        resp = MzUtil.ListToResultSet(list, new SfrbResp());
        return resp;
    }

    public String getLastJzrq(SysUser user,String ip) throws ParseException {
        Integer mzlb = opMzlbSer.getMzlb(user.getHospitalId(), ip);
        Map<String,Object> map = opMzxxDao.getLastJzrq(user.getUserId(),user.getHospitalId(),mzlb);
		SimpleDateFormat fmFrom = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String JZRQ = "";
		if(map!=null){
			JZRQ = StrUtil.null2Str(map.get("JZRQ"));
		}else{
			List<Map<String, Object>> list = opMzxxDao.getFirstGhsfrq(user.getUserId(),user.getHospitalId(),mzlb);
			if( !list.isEmpty() && list.size()==1){
				JZRQ = list.get(0).get("SFRQ")+"";
			}
		}
        return JZRQ.substring(0,19);
    }

	@Transactional(rollbackFor=Exception.class)
    public void doSaveSfrb(String jzksrq,String jzjsrq,String save,SysUser user,String ip){
		Integer mzlb = opMzlbSer.getMzlb(user.getHospitalId(), ip);
		List<Map<String,Object>> list = opMzxxDao.doQuerySfxmList(jzksrq,jzjsrq,mzlb, StrUtil.null2Str(user.getUserId()),StrUtil.null2Str(user.getHospitalId()));
		Map<String,Object> map = getOpParameters(user,jzksrq,jzjsrq,save,list,ip);
		map.put("jzrq",map.get("jzjsrq"));
		map.put("mzlb",mzlb);
		map.put("jgid",user.getHospitalId());
		map.put("czgh",user.getUserId());
		OpRbmxSfmx oprbmxsfmx = BeanUtil.fillBeanWithMapIgnoreCase(map, new OpRbmxSfmx(), true);
		int rbid = redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_RBMX_SFMX);
		oprbmxsfmx.setRbid(rbid+"");
		opRbmxDao.insertRbmxsfmx(oprbmxsfmx);
		for(int i = 0;i<list.size();i++){
			OpRbmx oprbmx = BeanUtil.fillBeanWithMapIgnoreCase(list.get(i), new OpRbmx(), true);
			oprbmx.setRbid(rbid+"");
			oprbmx.setCzgh(user.getUserId()+"");
			oprbmx.setJzrq(Timestamp.valueOf(jzjsrq));
			oprbmx.setJgid(user.getHospitalId());
			oprbmx.setMzlb(mzlb);
			oprbmx.setSfje(oprbmx.getSjje());
			oprbmx.setJzksrq(Timestamp.valueOf(jzksrq));
			opRbmxDao.insert(oprbmx);
		}
		opGhmxDao.doUpdateJzrqByRb(jzksrq,jzjsrq,mzlb,user.getHospitalId(),user.getUserId());
		opGhmxDao.doUpdateThJzrqByRb(jzksrq,jzjsrq,mzlb,user.getHospitalId(),user.getUserId());
		opMzxxDao.doUpdateJzrqByRb(jzksrq,jzjsrq,mzlb,user.getHospitalId(),user.getUserId());
		opMzxxDao.doUpdateZfJzrqByRb(jzksrq,jzjsrq,mzlb,user.getHospitalId(),user.getUserId());

	}

	/**
	 * 取消结账
	 *
	 * @param hospitalId
	 * @param userId
	 * @param ipAddress
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doCancelSfrb(String jzrq, Integer jgid, Integer userId, String ip) {
/*		Map<String, Object> parameters = new HashMap<String, Object>();
		SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		parameters.put("jgid", jgid);
		parameters.put("czgh", userId);
		parameters.put("jzrq", jzrq);
		Integer mzlb = opMzlbSer.getMzlb(jgid, ip);
		parameters.put("mzlb", mzlb);
		List<Map<String, Object>> list = opHzrbDao.doQueryJzrq(parameters);
		if (list.size() == 0) {
			throw BaseException.create("ERROR_REG_0079");
		}*/
		List<Map<String, Object>> list_hzmx = opMzxxDao.doQueryHzrq(jzrq);
		if (list_hzmx.size()>0) {
			throw BaseException.create("ERROR_REG_0079");
		}
		Integer mzlb = opMzlbSer.getMzlb(jgid, ip);
		Map<String, Object> jzmaxparameters = new HashMap<String, Object>();
		jzmaxparameters.put("jgid", jgid);
		jzmaxparameters.put("czgh", userId);
		jzmaxparameters.put("mzlb", mzlb);
		Map<String,Object> map = opMzxxDao.getLastJzrq(userId,jgid,mzlb);
		if (map!=null) {
			String maxJzrq = MzUtil.toString(DateUtil.parse(map.get("JZRQ") + ""), "yyyy-MM-dd HH:mm:ss");
			if (!jzrq.equals(maxJzrq)) {
				throw BaseException.create("ERROR_REG_0080");
			}
		}
		opRbmxDao.doDeleteRbmxByJzrq(jzrq,mzlb,jgid,userId);
		opRbmxDao.doDeleteByRbmxsfxmxJzrq(jzrq,mzlb,jgid,userId);
		Map<String,Object> parameters = new HashMap<>();
		parameters.put("jgid",jgid);
		parameters.put("mzlb",mzlb);
		parameters.put("czgh",userId);
		parameters.put("jzrq",jzrq);
		opGhmxDao.doUpdateJzrqToNull(parameters);
		opThmxDao.doUpdateJzrqToNull(parameters);
		opMzxxDao.doUpdateJzrqToNull(parameters);
		opZffpDao.doUpdateJzrqToNull(parameters);
	/*	opRbmxDao.doDeleteByCondition(parameters);
		opXzmxDao.doDeleteByCondition(parameters);
		opSfrbFkmxDao.doDeleteByCondition(parameters);
		opHzrbDao.doDeleteByCondition(parameters);
		opGrmxDao.doDeleteByCondition(parameters);
		opGhrbFkmxDao.doDeleteByCondition(parameters);
		opGhrbDao.doDeleteByCondition(parameters);

		opMzxxDao.doUpdateJzrqToNull(parameters);
		opZffpDao.doUpdateJzrqToNull(parameters);
		opGhmxDao.doUpdateJzrqToNull(parameters);
		opThmxDao.doUpdateJzrqToNull(parameters);
		opGhmxZkDao.doUpdateJzrqToNull(parameters);
		opGhmxZjjsZsfpDao.doUpdateJzrqToNull(parameters);*/
	}


	public String getLastHzJzrq(SysUser user,int mzlb) throws ParseException {
		Map<String,Object> map = opMzxxDao.getLastHzJzrq(user.getHospitalId(),mzlb);
		SimpleDateFormat fmFrom = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String HZRQ = "";
		if(map!=null){
			HZRQ = StrUtil.null2Str(map.get("HZRQ"));
		}else{
			List<Map<String, Object>> list = opMzxxDao.getFirstHzrq(user.getHospitalId(),mzlb);
			if( !list.isEmpty() && list.size()==1){
				HZRQ = list.get(0).get("HZRQ")+"";
			}else{
				throw BaseException.create("ERROR_REG_0081");
			}
		}
		return HZRQ.substring(0,19);
	}

	public List<Map<String, Object>> getOpHzListFields(String hzksrq,String hzjsrq,String save, int jgid,
														 int mzlb) {
		List<Map<String, Object>> records = new ArrayList<>();;
		List<Map<String, Object>> records_new = new ArrayList<>();
		List<Map<String, Object>> czgh_llist = null;
		Map<String,Object> map = new HashMap<>();
		BigDecimal srje_all = new BigDecimal(0);
		BigDecimal zk_all = new BigDecimal(0);
		BigDecimal sjsr_all = new BigDecimal(0);
		if("0".equals(save)) {
			czgh_llist = opMzxxDao.doQueryHzRyList(hzksrq, hzjsrq, mzlb, StrUtil.null2Str(jgid));
			if (czgh_llist.size() > 0) {
				for (Map<String, Object> ry_map : czgh_llist) {
					String czgh = ry_map.get("CZGH") + "";
						records = opMzxxDao.doQuerySfxmhzList(czgh, hzksrq, hzjsrq, mzlb, StrUtil.null2Str(jgid));
						records_new.addAll(records);
						if (records.size() > 0) {
							BigDecimal srje = new BigDecimal(0);
							BigDecimal zk = new BigDecimal(0);
							BigDecimal sjsr = new BigDecimal(0);
							for (int i = 0; i < records.size(); i++) {
								srje = srje.add(new BigDecimal(String.valueOf(records.get(i).get("ZJJE"))));
								zk = zk.add(new BigDecimal(String.valueOf(records.get(i).get("ZKJE"))));
								sjsr = sjsr.add(new BigDecimal(String.valueOf(records.get(i).get("SJJE"))));
							}
							srje_all = srje_all.add(srje);
							zk_all = zk_all.add(zk);
							sjsr_all = sjsr_all.add(sjsr);
							map.put("YGXM","");
							map.put("SFMC", "合计");
							map.put("ZJJE", srje);
							map.put("ZKJE", zk);
							map.put("SJJE", sjsr);
							records_new.add(map);
						}

				}
				map.clear();
				map.put("YGXM","");
				map.put("SFMC", "总合计");
				map.put("ZJJE", srje_all);
				map.put("ZKJE", zk_all);
				map.put("SJJE", sjsr_all);
				records.add(map);
			}else{
				throw BaseException.create("ERROR_REG_0081");
			}
		}else if("2".equals(save)) {
			czgh_llist = opMzxxDao.doQueryHzRyedList(hzjsrq, mzlb, StrUtil.null2Str(jgid));
			if (czgh_llist.size() > 0) {
				for (Map<String, Object> ry_map : czgh_llist) {
					String czgh = ry_map.get("CZGH") + "";
					records = opMzxxDao.doQuerySfxmhzedList(czgh, hzjsrq, mzlb, StrUtil.null2Str(jgid));
					records_new.addAll(records);
					if (records.size() > 0) {
						BigDecimal srje = new BigDecimal(0);
						BigDecimal zk = new BigDecimal(0);
						BigDecimal sjsr = new BigDecimal(0);
						for (int i = 0; i < records.size(); i++) {
							srje = srje.add(new BigDecimal(String.valueOf(records.get(i).get("ZJJE"))));
							zk = zk.add(new BigDecimal(String.valueOf(records.get(i).get("ZKJE"))));
							sjsr = sjsr.add(new BigDecimal(String.valueOf(records.get(i).get("SJJE"))));
						}
						srje_all = srje_all.add(srje);
						zk_all = zk_all.add(zk);
						sjsr_all = sjsr_all.add(sjsr);
						map.put("YGXM","");
						map.put("SFMC", "合计");
						map.put("ZJJE", srje);
						map.put("ZKJE", zk);
						map.put("SJJE", sjsr);
						records_new.add(map);
					}
				}
				map.clear();
				map.put("YGXM","");
				map.put("SFMC", "总合计");
				map.put("ZJJE", srje_all);
				map.put("ZKJE", zk_all);
				map.put("SJJE", sjsr_all);
				records.add(map);
			}
		}
		return records;
	}

	public Map<String,Object> getOpHzParameters(SysUser user,String hzksrq,String hzjsrq){
		Map<String,Object> map = new HashMap<>();
		map.put("jgmc",user.getHospitalName());
		map.put("hzksrq",hzksrq);
		map.put("hzjsrq",hzjsrq);
		map.put("czgh",user.getLoginName());
		map.put("zbrq",DateUtil.date().toSqlDate());
		return map;
	}

	/**
	 * 查询收费日报汇总
	 *
	 * @param user
	 * @param ip
	 */
	public List<SfrbhzResp> doQueSfrbhzList(SysUser user, int mzlb) {
		List<SfrbhzResp> resp = new ArrayList<SfrbhzResp>();
		List<Map<String, Object>> list = opMzxxDao.doQuerySfrbhzList(user.getHospitalId(),mzlb);
		resp = MzUtil.ListToResultSet(list, new SfrbhzResp());
		return resp;
	}

	@Transactional(rollbackFor=Exception.class)
	public void doSaveSfrbhz(String hzksrq,String hzjsrq,int mzlb,SysUser user){
		opRbmxDao.updateHzrq(hzksrq,hzjsrq,mzlb,user.getHospitalId());
		opGhmxDao.updateHzrq(hzksrq,hzjsrq,mzlb,user.getHospitalId());
		opGhmxDao.updateThHzrq(hzksrq,hzjsrq,mzlb,user.getHospitalId());
		opMzxxDao.updateHzrq(hzksrq,hzjsrq,mzlb,user.getHospitalId());
		opMzxxDao.updateZfHzrq(hzksrq,hzjsrq,mzlb,user.getHospitalId());

		//opRbmxDao.updateHzrq(hzksrq,hzjsrq,mzlb);
	}

	@Transactional(rollbackFor=Exception.class)
	public void doCancelSfhzrb(String hzrq,int jgid,int mzlb){
		opRbmxDao.updateHzrqToNull(hzrq,mzlb,jgid);
		opGhmxDao.updateHzrqToNull(hzrq,mzlb,jgid);
		opGhmxDao.updateThHzrqToNull(hzrq,mzlb,jgid);

		opMzxxDao.updateHzrqToNull(hzrq,mzlb,jgid);
		opMzxxDao.updateZfHzrqToNull(hzrq,mzlb,jgid);

	}

	public void doQueryHzVerification(String hzksrq,String hzjsrq,Integer jgid, int mzlb) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		List<Map<String, Object>> map_rbmx = opRbmxDao.doQueryHzCount(hzksrq,hzjsrq,jgid,mzlb);
		if (map_rbmx.size()<=0) {
			throw BaseException.create("ERROR_REG_0081");
		}
	}


}
