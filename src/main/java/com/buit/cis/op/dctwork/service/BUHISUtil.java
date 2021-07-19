package com.buit.cis.op.dctwork.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.CaseInsensitiveMap;
import com.buit.cis.op.dctwork.response.FeeYlsfxm;
import com.buit.commons.BaseException;
import com.buit.commons.dao.*;
import com.buit.commons.model.DrugsTypk;
import com.buit.commons.model.FeeYpxz;
import com.buit.commons.model.PubFyxz;
import com.buit.constans.SysXtcsCsmcCts;
import com.buit.system.response.FeeSfdlzfbl;
import com.buit.system.response.SysXtcs;
import com.buit.system.service.SysXtcsCacheSer;
import com.buit.system.utill.AgeUtil;
import com.buit.system.utill.ObjectToTypes;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

@Service
public class BUHISUtil {

	static final Logger logger = LoggerFactory.getLogger(BUHISUtil.class);

	@Autowired
	private DrugsTypkDao drugsTypkDao;
	@Autowired
	private FeeYlsfxmDao feeYlsfxmDao;
	@Autowired
	private FeeYpxzDao feeYpxzDao;
	@Autowired
	private FeeSfdlzfblDao feeSfdlzfblDao;
	@Autowired
	private PubFyxzDao pubFyxzDao;
    @DubboReference
    private SysXtcsCacheSer sysXtcsCacheSer;



	/**
	 * 结果集List<Map,String> 转List<T>
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
				T t = BeanUtil.fillBeanWithMapIgnoreCase(map, bean, true);
				resultList.add(t);
			}
		} catch (InstantiationException e) {
			logger.error(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage(), e);
		}
		return resultList;
	}

	/**
	 * @param birthday
	 * @param nowDate
	 * @return Map<String, Object> 返回类型
	 * @throws @Title: getPersonAge
	 * @Description: TODO 年龄大于等于3*12个月的，用岁表示； 小于3*12个月而又大于等于1*12个月的，用岁月表示；
	 *               小于12个月而又大于等于6个月的，用月表示； 小于6个月而大于等于29天的，用月天表示； 大于72小时小于29天的，用天表示；
	 *               小于72小时的，用小时表示。
	 * @author 龚方舟
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
		String reAge = age + "岁";
		if (age < 3 && age >= 1) {
			int month = getMonths(birthday, now.getTime());
			reAge = age + "岁";
			if ((month - 12 * age) > 0) {
				reAge = age + "岁" + (month - 12 * age) + "月";
			}
		} else if (age < 1) {
			int month = getMonths(birthday, now.getTime());
			if (month < 12 && month >= 6) {
				reAge = month + "月";
			} else {
				int day = getPeriod(birthday, null);
				if (day >= 29 && month > 0) {
					if (now.get(Calendar.DAY_OF_MONTH) >= birth.get(Calendar.DAY_OF_MONTH)) {
						day = now.get(Calendar.DAY_OF_MONTH) - birth.get(Calendar.DAY_OF_MONTH);
					} else {
						now.set(Calendar.MONTH, birth.get(Calendar.MONTH) + 1);
						day = now.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR);
					}
					reAge = month + "月";
					if (day > 0) {
						reAge = month + "月" + day + "天";
					}
				} else {
					if (day >= 4) {
						if ((now.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR)) > 0) {
							day = now.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR);
						}
						reAge = day - 1 + "天";
					} else {
						int hour = now.get(Calendar.HOUR_OF_DAY) - birth.get(Calendar.HOUR_OF_DAY);
						reAge = hour + 24 * (day) + "小时";
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
	 * @param date1 较早的一个日期
	 * @param date2 较晚的一个日期
	 * @return int 返回类型
	 * @Title: getMonths
	 * @Description: TODO 如果前面的日期小于后面的日期将返回-1。
	 * @author 龚方舟
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
	 * 计算两个日期之间的天数，参数null表示当前日期。
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
	 * 日期转换为字符串，如果pattern为null，使用“yyyy-MM-dd”的格式转换。
	 *
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String toString(Date date, String pattern) {
		DateFormat sdf = pattern == null ? new SimpleDateFormat("yyyy-MM-dd") : new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * 结果集List<Object> 转 List<Map<String,String>>
	 *
	 * @param objList
	 * @return
	 */
	@SuppressWarnings("hiding")
	public static <T> List<Map<String, Object>> ListObjToMap(List<T> objList) {
		List<Map<String, Object>> resultList = new ArrayList<>();
		for (T obj : objList) {
			Map<String, Object> map = BeanUtil.beanToMap(obj);
			Map<String, Object> result = new CaseInsensitiveMap<String, Object>(map);
			resultList.add(result);
		}
		return resultList;
	}

	/**
	 * 将日期转换成Date对象，支持的格式为yyyy-MM-dd HH:mm:ss，日期分隔符为（-,/,\）中的任意一个，
	 * 时间分隔符为（:,-,/）中的任意一个。 如果传入的日期格式不正确将返回null。
	 *
	 * @param str
	 * @return 如果传入的日期格式正确将返回一个Date对象，否则返回null。
	 */
	public static Date toDate(String str) {
		if (str == null || str.length() < 10) {
			return null;
		}
		String date = str.substring(0, 10);
		String pattern = "/^((((19|20)\\d{2})-(0?[13-9]|1[012])-(0?[1-9]|[12]\\d|30))|(((19|20)\\d{2})-(0?[13578]|1[02])-31)|(((19|20)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|((((19|20)([13579][26]|[2468][048]|0[48]))|(2000))-0?2-29))$/";
		// 年月日正则表达式有错误
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
		/* 将ptn中的[0-1]改称[0-2]，原因：20点之后会转化成0点 */
		String ptn = "[0-2]{1}([0-9]{1}|2[03]{1})[:,-,/]{1}[0-5]{1}[0-9]{1}[:,-,/]{1}[0-5]{1}[0-9]{1}";
		if (Pattern.matches(ptn, time)) {
			int hour = Integer.parseInt(time.substring(0, 2));
			int minute = Integer.parseInt(time.substring(3, 5));
			int second = Integer.parseInt(time.substring(6, 8));
			c.set(year, month, day, hour, minute, second);
		}
		return c.getTime();
	}

	/**
	 * 判断病人是否是vip
	 *
	 * @param jgid
	 * @param brxz
	 * @return
	 */
	public boolean isVIP(Integer jgid, String brxz) {
		SysXtcs sysXtcs = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, SysXtcsCsmcCts.VIPBRXZ);
		// 是否是VIP病人
		Boolean isVIP = false;
		if (sysXtcs != null) {
			if (sysXtcs.getCsz().split(",")[0].equals(brxz)) {
				isVIP = true;
			}
		}

		return isVIP;

	}

	/**
	 * 获取费用归并
	 *
	 * @param al_yplx
	 * @param al_fyxh
	 * @return
	 */
	public Integer getfygb(Integer al_yplx, Integer al_fyxh) {
		Integer al_fygb;
		if (al_yplx == 1 || al_yplx == 2 || al_yplx == 3) {// 如果不是费用,先查询有吴账簿类别,没有账簿类别则按药品类型分
			DrugsTypk drugsTypk = drugsTypkDao.getById(al_fyxh);
			if (drugsTypk != null && drugsTypk.getZblb() != null && drugsTypk.getZblb().intValue() > 0) {
				al_fygb = drugsTypk.getZblb();
			} else {
				throw BaseException.create("ERROR_REG_0011");
			}
		} else {
			FeeYlsfxm feeYlsfxm = feeYlsfxmDao.getById(al_fyxh);
			al_fygb = feeYlsfxm.getFygb();
		}
		return al_fygb;
	}

	/**
	 * @name: getPayProportion
	 * @description: 获取费用自付比例
	 * @param brxz	病人性质
	 * @param fygb	费用归并
	 * @param type	药品传药品类型1,2,3,费用传0
	 * @param ypxh  费用序号
	 * @return: java.util.Map<java.lang.String,java.lang.Object>
	 * @date: 2020/9/20 13:40
	 * @auther: 朱智
	 *
	 */
	public Map<String, Object> getPayProportion(Object brxz, Object fygb, Object type, Object ypxh){
		Map<String, Object> params = new HashMap<>(16);
		params.put("BRXZ", brxz);// 病人性质
		params.put("FYGB", fygb);// 费用归并
		params.put("TYPE", type);// 药品类型 0=项目
		params.put("FYXH", ypxh);// 费用序号
		return getPayProportion(params);
	}

	/**
	 * 获取费用自负比例
	 *
	 * @param body
	 * @return
	 */
	public Map<String, Object> getPayProportion(Map<String, Object> body) {
		Integer al_yplx = Integer.parseInt(body.get("TYPE") + "");// 药品传药品类型1,2,3,费用传0
		Object al_brxz = body.get("BRXZ");// 病人性质
		Object al_fyxh = body.get("FYXH");// 费用序号
		Object al_fygb = body.get("FYGB");// 费用归并
		Map<String, Object> params = new HashMap<String, Object>(16);
		params.put("BRXZ", al_brxz);
		params.put("FYXH", al_fyxh);
		Map<String, Object> map = new HashMap<String, Object>(16);
		if (al_yplx == 0) {
			PubFyxz pubFyxz = new PubFyxz();
			pubFyxz.setBrxz(Integer.valueOf(params.get("BRXZ").toString()));
			pubFyxz.setFyxh(Integer.valueOf(params.get("FYXH").toString()));
			// 查询费用禁用信息
			map = pubFyxzDao.getFyjyInfo(pubFyxz);
		} else {
			FeeYpxz feeYpxz = new FeeYpxz();
			feeYpxz.setBrxz(Integer.valueOf(params.get("BRXZ").toString()));
			feeYpxz.setYpxh(Integer.valueOf(params.get("FYXH").toString()));
			// 查询药品禁用信息
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
		Map<String, Object> zfbl_map = feeSfdlzfblDao.getZfblInfo(feeSfdlzfbl);
		if (zfbl_map == null) {
			zfbl_map = new HashMap<String, Object>(16);
			zfbl_map.put("ZFBL", 1);
		}
		return zfbl_map;
	}

	/**
	 * 项目执行获取自付比例 @Title: getzfbl @Description: TODO(这里用一句话描述这个方法的作用) @param @param
	 * body @param @return 设定文件 @return Map<String,Object> 返回类型 @author 龚方舟 @throws
	 */
	public Map<String, Object> getzfbl(Map<String, Object> body) {
		Integer al_yplx = ObjectToTypes.parseInt(body.get("TYPE"));// 药品传药品类型1,2,3,费用传0
		Integer al_brxz = ObjectToTypes.parseInt(body.get("BRXZ"));// 病人性质
		Integer al_fyxh = ObjectToTypes.parseInt(body.get("FYXH"));// 费用序号
		Integer al_fygb = ObjectToTypes.parseInt(body.get("FYGB"));// 费用归并
		Map<String, Object> reMap = new HashMap<String, Object>(16);
		reMap.put("FYGB", al_fygb);
		reMap.put("ZFBL", 1);
		Map<String, Object> map = new HashMap<String, Object>(16);
		if (al_yplx == 0) {
			PubFyxz pubFyxz = new PubFyxz();
			pubFyxz.setBrxz(al_brxz);
			pubFyxz.setFyxh(al_fyxh);
			map = pubFyxzDao.getFyjyInfo(pubFyxz);
		} else {
			FeeYpxz feeYpxz = new FeeYpxz();
			feeYpxz.setBrxz(al_fyxh);
			feeYpxz.setYpxh(al_fyxh);
			// 查询药品禁用信息
			map = feeYpxzDao.getYpjyInfo(feeYpxz);
		}

		if (map == null) {
			if (al_fygb == 0) {
				al_fygb = getfygb(al_yplx, al_fyxh);
				reMap.put("FYGB", al_fygb);
			}
			FeeSfdlzfbl feeSfdlzfbl = new FeeSfdlzfbl();
			feeSfdlzfbl.setBrxz(al_brxz);
			feeSfdlzfbl.setSfxm(al_fygb);
			Map<String, Object> zfblMap = feeSfdlzfblDao.getZfblInfo(feeSfdlzfbl);
			if (zfblMap != null) {
				reMap.put("ZFBL", zfblMap.get("ZFBL"));
			}
		} else {
			reMap.put("ZFBL", map.get("ZFBL"));
		}
		return reMap;
	}


	/**
	 * 对象接收参数转MAP,对象为空则新创建一个，Map取值忽略key值大小写
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
	 * double四舍五入保留小数
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
	 * 数据转换成double
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

	public static String getDate() {
		Date date = new Date();
		SimpleDateFormat matter = new SimpleDateFormat("yyyy-MM-dd");
		return matter.format(date);
	}

	// 用bigDecimal做浮点数加法计算
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

}
