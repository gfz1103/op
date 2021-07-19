package com.buit.his.op.reg.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.map.CaseInsensitiveMap;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.RandomUtil;
import com.buit.aop.lock.Locked;
import com.buit.apply.response.LoadPatientInfoResp;
import com.buit.apply.service.Cisjcsqd01Service;
import com.buit.cis.op.dctwork.service.BUHISUtil;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.commons.dao.*;
//import com.buit.commons.enums.MessageTypeEnum;
//import com.buit.commons.enums.SM01;
//import com.buit.commons.enums.TradingChannelEnum;
import com.buit.commons.model.*;
import com.buit.commons.request.*;
import com.buit.commons.response.*;
import com.buit.constans.TableName;
import com.buit.ecis.pretriage.dao.ErPreYjfzDao;
import com.buit.ecis.pretriage.response.YjfzBrdaResp;
import com.buit.his.op.queuing.model.OpBcsj;
import com.buit.his.op.queuing.model.OpZspdxx;
import com.buit.his.op.queuing.service.OpBcsjService;
import com.buit.his.op.queuing.service.OpZspdxxService;
import com.buit.his.op.reg.enums.FkfsEnum;
import com.buit.his.op.reg.enums.MpiCardEnum;
import com.buit.his.op.reg.enums.OpPjlxEnum;
import com.buit.his.op.reg.response.YyglResp;
import com.buit.his.shyb.source.entity.*;
import com.buit.his.shyb.source.service.impl.OfflineSettleService;
import com.buit.his.shyb.source.service.impl.ShybSh01Service;
import com.buit.his.shyb.source.service.impl.ShybZhbzService;
import com.buit.op.model.*;
import com.buit.op.response.MpiBrda;
import com.buit.op.service.OpMzlbService;
import com.buit.system.model.FeeYlsfxmdjModel;
import com.buit.system.request.FeeYpxzApiReq;
import com.buit.system.request.PubFkfsModel;
import com.buit.system.request.PubFyxzApiReq;
import com.buit.system.response.*;
import com.buit.system.service.*;
import com.buit.system.utill.MedicineUtils;
import com.buit.system.utill.ObjectToTypes;
import com.buit.utill.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 门诊_挂号科室<br>
 *
 * @author WY
 */
@Service
public class OpGhksSer extends BaseManagerImp<OpGhks, Integer> {

	static final Logger logger = LoggerFactory.getLogger(OpGhksSer.class);

	@Autowired
	private OpGhksDao opGhksDao;

	@Autowired
	private OpYgpjDao opYgpjDao;

	@DubboReference
	private SysXtcsCacheSer sysXtcsCacheSer;
	@DubboReference
	private SysXtcsSer sysXtcsSer;

	@Autowired
	private OpYyghDao opYyghDao;

	@Autowired
	private OpKspbDao opKspbDao;

	@Autowired
	private OpGhmxDao opGhmxDao;

	@Autowired
	private OpMzlbDao opMzlbDao;

	@Autowired
	private OpMzlbSer opMzlbSer;

	@Autowired
	private MpiCardDao mpiCardDao;

	@Autowired
	private MpiBrdaDao mpiBrdaDao;

	@Autowired
	private OpYjcf01Dao opYjcf01Dao;

	@Autowired
	private OpYjcf02Dao opYjcf02Dao;

	@DubboReference
	private FeeYlsfxmdjService feeYlsfxmdjService;

	@Autowired
	private DrugsTypkDao drugsTypkDao;

	@DubboReference
	private FeeYlsfxmOutSer feeYlsfxmOutSer;

	@DubboReference
	private PubFyxzService pubFyxzService;

	@DubboReference
	private FeeYpxzService feeYpxzService;

	@DubboReference
	private FeeSfdlzfblOutSer feeSfdlzfblOutSer;

	@Autowired
	private OpThmxDao opThmxDao;

	@Autowired
	private OpYspbDao opYspbDao;

	@Autowired
	private MpiKpxxDao mpiKpxxDao;

	@Autowired
	private OpCzjlDao opCzjlDao;

	@DubboReference
	private PubFkfsService pubFkfsService;

	@Autowired
	private OpGhFkxxDao opGhFkxxDao;

	@Autowired
	private DiyGhmxZzghDao opGhmxZzghDao;

	@Autowired
	private OpGhyjDao opGhyjDao;

	@Autowired
	private OpGhmxZkDao opGhmxZkDao;

	@Autowired
	private RedisFactory redisFactory;

	@DubboReference
	private Cisjcsqd01Service cisjcsqd01Service;

	@DubboReference
	private DiccZlsfdzService diccZlsfdzDao;

	@Autowired
	private PubJmlxDao pubJmlxDao;

	@DubboReference
	private OpZspdxxService opZspdxxService;

	@DubboReference
	private SysDataCodeSer sysDataCodeSer;

	@DubboReference
	private SysDictConfigSer sysDictConfigSer;

	@DubboReference
	private OfflineSettleService offLineSettle;
	@DubboReference
	private ShybZhbzService shybZhbzService;
	@DubboReference
	private DicKszdOutSer dicKszdOutSer;
	@DubboReference
	private ShybSh01Service shybSh01Service;
	@DubboReference
	public OpMzlbService opMzlbService;

	@DubboReference
	private OpBcsjService opBcsjService;

	@Autowired
	private MzUtil mzUtil;

	@Autowired
	private ErPreYjfzDao erPreYjfzDao;

	@Autowired
	private OpMzxxSer opMzxxSer;

	@DubboReference
	private HrPersonnelService hrPersonnelService;

	@Override
	public OpGhksDao getEntityMapper() {
		return opGhksDao;
	}

	/**
	 * 挂号科室保存
	 *
	 * @param req
	 */
	public void save(OpGhksAddReq req) {

		Integer count = opGhksDao.checkGhksInfo(req.getKsmc(), req.getMzks(), null);
		if(count > 0){
			throw BaseException.create("ERROR_REG_0100");
		}

		OpGhks opGhks = new OpGhks();
		BeanUtils.copyProperties(req, opGhks);
		opGhks.setKsdm(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_GHKS));
		opGhks.setGhlb(1);
		opGhks.setGhxe(0);
		opGhks.setJjrghf(BigDecimal.ZERO);
//		opGhks.setJxdm(req.getJgid().toString());
		opGhks.setJzxh(0);
		opGhks.setTjf(BigDecimal.ZERO);
		opGhks.setTjpb(0);
		opGhks.setYgrs(0);
		opGhks.setYyrs(0);
		opGhksDao.insert(opGhks);
		sysDictConfigSer.upDateVersion("op_ghks");
	}

	/**
	 * 挂号科室删除
	 *
	 * @param ksdm
	 */
	public void delete(Integer ksdm) {
		// 判断当前科室是否被分配业务权限
		Integer count = opGhksDao.isAuth(ksdm);
		if (count != null && count.intValue() > 0) {
			throw BaseException.create("ERROR_REG_0001");
		}
		// 删除挂号科室
		opGhksDao.deleteById(ksdm);
		sysDictConfigSer.upDateVersion("op_ghks");
	}

	/**
	 * 挂号科室维护新增或修改时门诊列表
	 *
	 * @param hospitalId
	 * @return
	 */
	public List<OpGhksOffice> getMzksList(Integer hospitalId) {
		return opGhksDao.getMzksList(hospitalId);
	}

	/**
	 * 初始化挂号管理
	 *
	 * @param jgId
	 * @param ygdm
	 */
	@Transactional(rollbackFor = Exception.class)
	public MsInitGhksResp initGhksInfo(Integer jgId, Integer ygdm) {
		MsInitGhksResp resp = new MsInitGhksResp();
		String jzhm = getNotesNumberNotIncrement(ygdm, jgId, 2);
		if (jzhm == null) {
			throw BaseException.create("ERROR_REG_0056");
		}

		// 获取值班类型：上午、下午
		String now = DateUtil.format(DateUtil.date(), "yyyy-MM-dd");
		Timestamp yyrq = DateUtil.beginOfDay(DateUtil.date()).toTimestamp();
//		Calendar startc = Calendar.getInstance();
//		int zblb = startc.get(Calendar.HOUR_OF_DAY);
//		if (zblb < 12) {
//			zblb = 1;
//		} else {
//			zblb = 2;
//		}
		// 根据时间段获取值班类别
		String zblb = mzUtil.getSddmByTime(DateUtil.date());
		//String zblb = "1000008";
				// 查询系统参数表中当前挂号日期和当前值班类别的参数值
		String dqghrq = sysXtcsCacheSer.getCsz(jgId, "DQGHRQ");
		String dqzblb = sysXtcsCacheSer.getCsz(jgId, "DQZBLB");
		if ((!"".equals(dqghrq) && dqghrq != null) && (!"".equals(dqzblb) && dqzblb != null)) {
			if (!now.equals(dqghrq) || !zblb.equals(dqzblb)) {
				SysXtcs sysXtcs = new SysXtcs();
				sysXtcs.setJgid(jgId);
				sysXtcs.setCsmc("DQGHRQ");
				sysXtcs.setCsz(now);
				// 更新挂号日期
				sysXtcsSer.updateCsz(sysXtcs);
				sysXtcs.setCsmc("DQZBLB");
				sysXtcs.setCsz(zblb);
				// 更新值班类别
				sysXtcsSer.updateCsz(sysXtcs);
				// 首次进入挂号页面初始化已挂人数和预约人数
				opGhksDao.initGhrs(null, 0, 0, jgId, null);
				// 将过期的预约挂号置标志2
				opYyghDao.updateGhbz(jgId, yyrq);
				// 循环遍历更新挂号科室表的已挂人数和预约人数
				OpGhks opGhks = new OpGhks();
				opGhks.setJgid(jgId);
				List<OpGhks> ghksList = opGhksDao.findByEntity(opGhks);
				for (OpGhks ghks : ghksList) {
					OpYygh opYygh = new OpYygh();
					opYygh.setJgid(jgId);
					opYygh.setKsdm(ghks.getKsdm());
					opYygh.setYyrq(DateUtil.date(yyrq).toSqlDate());
					opYygh.setZblb(zblb);
					opYygh.setBeginOfDay(DateUtil.beginOfDay(yyrq).toTimestamp());
					opYygh.setEndOfDay(DateUtil.endOfDay(yyrq).toTimestamp());
					// 获取已挂人数和预约人数
					Integer ygrs = opYyghDao.getYgrs(opYygh) != null ? opYyghDao.getYgrs(opYygh).intValue() : 0;
					Integer yyrs = opYyghDao.getYyrs(opYygh) != null ? opYyghDao.getYyrs(opYygh).intValue() : 0;
					// 更新每个科室的已挂人数和预约人数
					opGhksDao.initGhrs(null, ygrs, yyrs, jgId, ghks.getKsdm());
				}

				OpKspb opKspb = new OpKspb();
				opKspb.setJgid(jgId);
				opKspb.setZblb(zblb);
				opKspb.setGhrq(DateUtil.date().toSqlDate());
				opKspb.setBeginOfDay(DateUtil.beginOfDay(DateUtil.date().toSqlDate()).toTimestamp());
				opKspb.setEndOfDay(DateUtil.endOfDay(DateUtil.date().toSqlDate()).toTimestamp());
				List<OpKspb> kspbList = opKspbDao.getCurrentKspbList(opKspb);
				for (OpKspb kspb : kspbList) {
					opGhksDao.initGhrs(kspb.getJzxh(), 0, 0, jgId, Integer.valueOf(kspb.getGhks()));
				}

				// 清当前班次的科室排班中的就诊序号,已挂人数和预约人数
				opKspb.setJzxh(0);
				opKspb.setYgrs(0);
				opKspb.setYyrs(0);
				opKspbDao.initKspb(opKspb);
				// 当前班次的收费挂号预约到当前班次就不再是预约了,而变成了挂号
				OpGhmx opGhmx = new OpGhmx();
				opGhmx.setJgid(jgId);
				opGhmx.setGhsj(yyrq);
				opGhmx.setBeginOfDay(DateUtil.beginOfDay(yyrq).toTimestamp());
				opGhmx.setEndOfDay(DateUtil.endOfDay(yyrq).toTimestamp());
				opGhmxDao.updateYybz(opGhmx);
			}
		} else {
			SysXtcs sysXtcs = new SysXtcs();
			sysXtcs.setJgid(jgId);
			if ("".equals(dqghrq) || dqghrq == null) {
				sysXtcs.setCsmc("DQGHRQ");
				sysXtcs.setCsz(now);
				sysXtcsSer.insert(sysXtcs);
			}
			if ("".equals(dqzblb) || dqzblb == null) {
				sysXtcs.setCsmc("DQZBLB");
				sysXtcs.setCsz(String.valueOf(zblb));
				sysXtcsSer.insert(sysXtcs);
			}

		}
		String blje = sysXtcsCacheSer.getCsz(jgId, "BLF");
		String ckje = sysXtcsCacheSer.getCsz(jgId, "CKF");
		resp.setJzhm(jzhm);
		resp.setGhrq(yyrq);
		resp.setZblb(zblb);
		resp.setBlje(blje != null ? new BigDecimal(blje) : BigDecimal.ZERO);
		resp.setCkje(ckje != null ? new BigDecimal(ckje) : BigDecimal.ZERO);
		sysDictConfigSer.upDateVersion("op_ghks");
		return resp;
	}

	/**
	 * 排班科室查询
	 *
	 * @param req
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public List<OpGhks> getGhksList(OpGhksListReq req) {
		List<OpGhks> ghksListResult = null;
		String dbtype = StrUtil.null2Str(req.getDbtype());
		if("".equals(dbtype)){
			req.setDbtype("0");
		}else{
			req.setDbtype(dbtype);
		}
		String ghkssfpb = sysXtcsCacheSer.getCsz(Integer.valueOf(req.getJgid()), "GHKSSFPB");
		Timestamp ghrq = DateUtil.date().toTimestamp();
//		Calendar startc = Calendar.getInstance();
//		int zblb = startc.get(Calendar.HOUR_OF_DAY);
		if (req.getGhrq() != null) {
			ghrq = DateUtil.date(req.getGhrq()).toTimestamp();
		}
		Timestamp beginOfDay = DateUtil.beginOfDay(ghrq).toTimestamp();
		Timestamp endOfDay = DateUtil.endOfDay(ghrq).toTimestamp();
//		if (zblb < 12) {
//			zblb = 1;
//		} else {
//			zblb = 2;
//		}

		// 根据时间段获取值班类别
		String zblb = mzUtil.getSddmByTime(DateUtil.date());
		//String zblb = "1000008";
		if (req.getZblb() != null) {
			zblb = req.getZblb();
		}

		if (ghkssfpb != null) {
			if (!"1".equals(ghkssfpb)) {
				// 获取未排班的科室信息
				List<OpGhks> ghksList = opGhksDao.getGhksNoPb(ghrq, zblb, req.getJgid(), beginOfDay, endOfDay, req.getInternet());
				if (ghksList.size() > 0) {
					for (OpGhks ghks : ghksList) {
						OpKspb opKspb = new OpKspb();
						opKspb.setGhks(String.valueOf(ghks.getKsdm()));
						opKspb.setZblb(zblb);
						opKspb.setJgid(req.getJgid());
						opKspb.setGhrq(DateUtil.date(ghrq).toSqlDate());
						opKspb.setBeginOfDay(beginOfDay);
						opKspb.setEndOfDay(endOfDay);
						// 根据GHKS、ZBLB、GHRQ、JGID条件删除
						opKspbDao.delKspbByCondition(opKspb);
						// 循环插入排班信息
						opKspbDao.insert(opKspb);
					}
				}
			}
		}

		// 获取门诊类别
		Integer mzlb = opMzlbSer.getMzlb(req.getJgid(), req.getIp());


		// 根据预约标识返回不同list
		if (req.getYytag() != null) {
			ghksListResult = new ArrayList<>();
			if (req.getYytag() == 1) {
				ghksListResult = opGhksDao.getGhksListByYyTagOne(req.getJgid(), mzlb, ghrq, zblb, beginOfDay, endOfDay,
						req.getGhlx(),dbtype,req.getInternet());
			} else if (req.getYytag() == 2) {
				ghksListResult = opGhksDao.getGhksListByYyTagTwo(req.getJgid(), mzlb, ghrq, zblb, beginOfDay, endOfDay,
						req.getGhlx(),req.getInternet());
			}
		}
		if (ghksListResult == null || ghksListResult.isEmpty()) {
			// 根据时间段获取值班类别
			String currentZblb = mzUtil.getSddmByTime(DateUtil.date());
			//String currentZblb = "1000008";
			OpBcsj opBcsj = opBcsjService.getBySddm(currentZblb);
			if(!"0".equals(req.getDbtype())){
				throw BaseException.create("ERROR_REG_0094", new String[] { opBcsj.getSdmc() });
			}else {
				throw BaseException.create("ERROR_REG_0060", new String[]{opBcsj.getSdmc()});
			}
		}
		return ghksListResult;
	}

	/**
	 * 根据卡号查询病人信息
	 *
	 * @param req
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public MpiBrdaInfo doQueryPerson(MsQryPersonReq req,String ip) {
		MpiCard mpiCard = null;
		MpiBrdaInfo mpiBrdaInfo = null;
		String brxz = sysXtcsCacheSer.getCsz(req.getJgid(), "MRXZ");
		String klx = sysXtcsCacheSer.getCsz(req.getJgid(), "KLX");
		String ghxq = sysXtcsCacheSer.getCsz(req.getJgid(), "GHXQ");
		int isDb = 0;
		// 如果就诊号码不为空
		if (!"".equals(req.getJzkh()) && req.getJzkh() != null) {
			// 上海五版医保SM01begin
		/*	String YBSYPB = sysXtcsCacheSer.getCsz(req.getJgid(), "YBSYPB");
			List<Map<String, Object>> dbdjxxs = null;
			SJ31Res sj31res = new SJ31Res();
			List<SJ31Res> a = null;
			if (req.getJzkh().length() == 28 && "0".equals(YBSYPB)) {
				dbdjxxs = CheckAccountattr(req.getJgid(), ip, req.getJzkh());
				if (dbdjxxs != null && dbdjxxs.size() > 0) {
					isDb = 1;
					for (Map<String, Object> damap : dbdjxxs) {
						sj31res.setDjno(damap.get("djno").toString());
						sj31res.setStartdate(damap.get("startdate").toString());
						sj31res.setEnddate(damap.get("enddate").toString());
						sj31res.setZdno(damap.get("zdno").toString());
						sj31res.setDbtype(damap.get("dbtype").toString());
						sj31res.setDbzl(damap.get("dbzl").toString());
						sj31res.setDjhossame(damap.get("djhossame").toString());
						sj31res.setDjhosname(damap.get("djhosname").toString());
						a.add(sj31res);
					}
					// sj31.setDJXXS(a);
				}
		//		mpiBrdaInfo.setSJ31Res(a);
		//		mpiBrdaInfo.setIsDb(isDb);
			}*/
//			long l = mpiCardDao.countIsYb(req.getJzkh());
//			if (l != 0 && req.getIsRead()==0) {
//				throw BaseException.create("ERROR_SHYB_0019");
//			}
			// 五版医保SM0end

			// 查询卡号 如果不是正常卡则返给前端
			MpiCard mcStatus = new MpiCard();
			mcStatus.setCardno(req.getJzkh());
			MpiCard cardStatus = mpiCardDao.getMpiCardInfo(mcStatus);

			MpiCard mpiCardCon = new MpiCard();
			mpiCardCon.setCardno(req.getJzkh());
			mpiCardCon.setStatus(MpiCardEnum.NORMAL.getCode());
			// 根据卡号查询正常状态的卡信息
			List<MpiCard> mpiCardList = mpiCardDao.doQueryPerson(mpiCardCon);

			if (!mpiCardList.isEmpty() && mpiCardList != null && mpiCardList.size() == 1) {
				mpiCard = mpiCardList.get(0);
			}
			if (mpiCard != null) {
				if (req.getYbxz() != null && (req.getYbxz().intValue() != mpiCard.getBrxz().intValue())) {
					// mpiCardDao.updateBrxz(req.getYbxz(), mpiCard.getBrid(), req.getJzkh());
				}
				// 根据卡号和唯一标识查询卡信息
				MpiCard mCard = new MpiCard();
				mCard.setCardno(req.getJzkh());
				mCard.setBrid(mpiCard.getBrid());
				List<MpiCard> mpiCards = mpiCardDao.doQueryPerson(mCard);
				if (mpiCards.size() > 0) {
					MpiCard mc = mpiCards.get(0);
					if (mc.getBrxz() != null) {
						mpiBrdaDao.updateBrxz(mc.getBrxz(), mpiCard.getBrid());
					}
				}

				if (MpiCardEnum.LOST.getCode().equals(mpiCard.getStatus())) {
					throw BaseException.create("ERROR_REG_0006");
				}
				if (MpiCardEnum.CANCEL.getCode().equals(mpiCard.getStatus())) {
					throw BaseException.create("ERROR_REG_0007");
				}
				if (MpiCardEnum.INVALID.getCode().equals(mpiCard.getStatus())) {
					throw BaseException.create("ERROR_REG_0008");
				}

				// 病人性质大类的查询用于收费信息保存时如果大类是医保的未录入诊断 不允许保存
				mpiBrdaInfo = mpiBrdaDao.getBrxzInfo(mpiCard.getBrid(), null);
				if (mpiBrdaInfo == null) {
					// 病人存在基本档案,但没有MPI_BRDA时进入此逻辑,自动生成病人档案
					doSaveBrda(mpiCard, req);
				}
				mpiBrdaInfo.setJzkh(req.getJzkh());
				if (mpiBrdaInfo.getCsny() != null) {
					Map<String, Object> agMap = MzUtil.getPersonAge(mpiBrdaInfo.getCsny(), null);
					if (agMap != null && !agMap.isEmpty()) {
						mpiBrdaInfo.setAge(Integer.valueOf(agMap.get("age").toString()));
						mpiBrdaInfo.setAges(agMap.get("ages").toString());
					}
				}
				if (mpiBrdaInfo.getBrxz() == null) {
					mpiBrdaInfo.setBrxz(Integer.valueOf(brxz));
				}
			} else {
				mpiBrdaInfo = new MpiBrdaInfo();
				if (cardStatus != null) {
					mpiBrdaInfo.setStatus(cardStatus.getStatus());
					return mpiBrdaInfo;
				} else {
					return null;
				}
			}
		} else {
			if (!"".equals(req.getMzhm()) && req.getMzhm() != null) {
				mpiBrdaInfo = mpiBrdaDao.getBrxzInfo(null, req.getMzhm());
				if (mpiBrdaInfo != null) {
					if (mpiBrdaInfo.getCsny() != null) {
						Map<String, Object> agMap = MzUtil.getPersonAge(mpiBrdaInfo.getCsny(), null);
						if (agMap != null && !agMap.isEmpty()) {
							mpiBrdaInfo.setAge(Integer.valueOf(agMap.get("age").toString()));
							mpiBrdaInfo.setAges(agMap.get("ages").toString());
						}
					}
					if (mpiBrdaInfo.getBrxz() == null) {
						mpiBrdaInfo.setBrxz(Integer.valueOf(brxz));
					}

					if (!"".equals(req.getCardNo()) && req.getCardNo() != null) {
						mpiCard = new MpiCard();
						mpiCard.setCardno(req.getCardNo());
						mpiCard.setStatus(MpiCardEnum.NORMAL.getCode());
						mpiCard.setBrid(mpiBrdaInfo.getBrid());
						List<MpiCard> mpiCardList = mpiCardDao.doQueryPerson(mpiCard);
						if (mpiCardList != null && mpiCardList.size() == 1) {
							mpiBrdaInfo.setBrxz(mpiCardList.get(0).getBrxz());
						}
					}

					mpiCard.setBrid(mpiBrdaInfo.getBrid());
					mpiCard.setCardtypecode(klx);
					List<MpiCard> mpiCardList = mpiCardDao.doQueryPerson(mpiCard);
					if (mpiCardList != null && mpiCardList.size() > 0) {
						MpiCard mCard = mpiCardList.get(0);
						if (mCard != null) {
							mpiBrdaInfo.setJzkh(mCard.getCardno());
						}
					}

				}

			}
		}
		if (mpiBrdaInfo != null) {
//			String xqjsfs = sysXtcsCacheSer.getCsz(req.getJgid(), "XQJSFS");
			String mtsqycghf = sysXtcsCacheSer.getCsz(req.getJgid(), "MTSQYCGHF");
			String wghms = sysXtcsCacheSer.getCsz(req.getJgid(), "YXWGHBRJZ");
			if (ghxq == null || !ghxq.matches("[0-9]+")) {
				throw BaseException.create("ERROR_REG_0009");
			}

			OpGhmxInfo opGhmxInfo = new OpGhmxInfo();
			opGhmxInfo.setJgid(req.getJgid());
			opGhmxInfo.setBeginOfDay(DateUtil.offsetDay(DateUtil.date(), -Integer.parseInt(ghxq)).toTimestamp());
			opGhmxInfo.setEndOfDay(DateUtil.date().toTimestamp());
			opGhmxInfo.setBrid(mpiBrdaInfo.getBrid());
			opGhmxInfo.setGhsj(DateUtil.date().toTimestamp());
			opGhmxInfo.setThbz(0);
			List<OpGhmxInfo> opGhmxList = opGhmxDao.getGhmxByCondition(opGhmxInfo);

			Integer ghgl = 0;
			if (req.getSelectedGhgl() != null) {
				OpGhmxInfo opGhmx = new OpGhmxInfo();
				opGhmx.setSbxh(req.getSelectedGhgl());
				opGhmx.setJgid(req.getJgid());
				opGhmx.setBrid(mpiBrdaInfo.getBrid());
				opGhmx.setThbz(0);
				opGhmxList = opGhmxDao.getGhmxByCondition(opGhmx);
			}

			if (opGhmxList.size() > 0) {
				OpGhmxInfo ghmx = opGhmxList.get(0);
				ghgl = ghmx.getSbxh();
				mpiBrdaInfo.setGhks(ghmx.getKsdm());
				mpiBrdaInfo.setKsmc(ghmx.getKsmc());

				// 增加自动插入诊疗费(收费处)
				if (req.getUseBy() != null && req.getUseBy().toString().equals("charges")) {
					mpiBrdaInfo.setTempGhgl(ghgl);
					mpiBrdaInfo.setGhgl(ghgl);
					doSaveZlf(mpiBrdaInfo, req.getJgid());
				}
			}

			opGhmxInfo.setThbz(0);
			opGhmxInfo.setBeginOfDay(
					DateUtil.beginOfDay(DateUtil.offsetDay(DateUtil.date(), -Integer.parseInt("1"))).toTimestamp());
			opGhmxList = opGhmxDao.getGhmxInfo(opGhmxInfo);
			if ("1".equals(mtsqycghf)) {
				// 挂号模式使用，
				if (opGhmxList.size() > 0) {
					// 今天已挂号
					mpiBrdaInfo.setJtygh(1);
				}
			}
			mpiBrdaInfo.setGhgl(ghgl);
			if (opGhmxList.size() > 0) {
				mpiBrdaInfo.setMzlb(opGhmxList.get(0).getMzlb());
			}

			// 新病人就诊费在收费处正常调入时产生
			if ("1".equals(wghms) && opGhmxList.size() > 0 && req.getNewPerson() == null) {
				mpiBrdaInfo.setTempGhgl(opGhmxList.get(0).getSbxh());
				doSaveZlf(mpiBrdaInfo, req.getJgid());
			}

		}
		// 获取病人今日已挂号的科室、科室医生和门诊就诊流水号
		OpGhmxInfo opGhmxInfo = new OpGhmxInfo();
		opGhmxInfo.setJgid(req.getJgid());
		opGhmxInfo.setBeginOfDay(DateUtil.offsetDay(DateUtil.date(), -Integer.parseInt(ghxq)).toTimestamp());
		opGhmxInfo.setEndOfDay(DateUtil.date().toTimestamp());
		opGhmxInfo.setBrid(mpiBrdaInfo.getBrid());
		opGhmxInfo.setGhsj(DateUtil.date().toTimestamp());
		opGhmxInfo.setThbz(0);
		List<MsGhInfo> msGhInfos = opGhmxDao.getGhInfoList(opGhmxInfo);
		mpiBrdaInfo.setMsGhInfo(msGhInfos);
		OpGhmxInfo countGhmxinfo = new OpGhmxInfo();
		countGhmxinfo.setJgid(req.getJgid());
		countGhmxinfo.setBrid(mpiBrdaInfo.getBrid());
		countGhmxinfo.setJzkh(req.getJzkh());

		Integer sjBrxz = opMzxxSer.querySjBrxz(mpiBrdaInfo.getBrxz());
		if(sjBrxz == 6021 || opGhmxDao.getGhmxCount(countGhmxinfo) > 0){
			mpiBrdaInfo.setCzfz(1);
		}else {
			mpiBrdaInfo.setCzfz(0);
		}
		return mpiBrdaInfo;
	}

	/**
	 * 病人档案建档
	 *
	 * @param mpiCard
	 * @param req
	 */
	public void doSaveBrda(MpiCard mpiCard, MsQryPersonReq req) {
		OpGhmxInfo ghmx = new OpGhmxInfo();
		ghmx.setBrid(mpiCard.getBrid());
		MpiBrda mpiBrda = mpiBrdaDao.getByCondition(ghmx);
		if (mpiBrda == null) {
			return;
		}
		MpiBrda brda = new MpiBrda();
		// 避免无用的值 所以挨个塞值
		brda.setBrxz(mpiCard.getBrxz());
		brda.setZxbz(0);
		brda.setBrxm(mpiBrda.getBrxm());
		brda.setBrxb(mpiBrda.getBrxb());
		brda.setCsny(mpiBrda.getCsny());
		brda.setSfzh(mpiBrda.getSfzh());
		brda.setGjdm(mpiBrda.getGjdm());
		brda.setMzdm(mpiBrda.getMzdm());
		brda.setHyzk(mpiBrda.getHyzk());
		brda.setZydm(mpiBrda.getZydm());
		brda.setDwmc(mpiBrda.getDwmc());
		brda.setJtdh(mpiBrda.getJtdh());
		brda.setLxrm(mpiBrda.getLxrm());
		brda.setLxdh(mpiBrda.getLxdh());
		brda.setHkyb(mpiBrda.getHkyb());
		brda.setLxdz(mpiBrda.getLxdz());
		brda.setXxdm(mpiBrda.getXxdm());
		brda.setJdjg(mpiBrda.getJdjg());
		brda.setJdr(req.getYgdm().toString());
		brda.setJdsj(DateUtil.date().toTimestamp());
		brda.setXgsj(DateUtil.date().toTimestamp());
		brda.setMzhm(getNotesNumber(req.getYgdm(), req.getJgid(), OpPjlxEnum.DAHM.getKey()));
		brda.setBrid(redisFactory.getTableKey(TableName.DB_NAME, TableName.MPI_BRDA));
		mpiBrdaDao.insert(brda);

	}

	/**
	 * 建档获取票据号
	 *
	 * @param ygdm
	 * @param jgid
	 * @param type
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public String getNotesNumberNotIncrement(Integer ygdm, Integer jgid, Integer type) {
		String autoCreate = null;
		Integer jlxhCount = opYgpjDao.getJlxhCount(jgid, ygdm, type);
		if (jlxhCount != null && jlxhCount.intValue() > 0) {
			return getNotesNumberNotIncrement1(jgid, ygdm, type);
		}

		if (type == 3) {
			autoCreate = sysXtcsCacheSer.getCsz(jgid, "ZDCSMZH");
		} else if (type == 1) {
			autoCreate = sysXtcsCacheSer.getCsz(jgid, "ZDCSJZH");
		}
		if ("1".equals(autoCreate)) {
			int zdgh = 0;
			// 自动生成门诊号码的前10位
			String today = DateUtil.today();
			String rq = today.substring(2, 4) + today.substring(5, 7) + today.substring(8, 10);
			String zdmzh = "0";
			if (3 == type) {
				String zdmzhxngh = sysXtcsCacheSer.getCsz(jgid, "ZDMZHXNGH");
				zdgh = Integer.parseInt(zdmzhxngh);
				if (zdgh == 9999) {
					zdgh = 1;
				} else {
					zdgh = Integer.parseInt(zdmzhxngh) + 1;
				}
				zdmzh = rq + String.format("%0" + 4 + "d", zdgh);
			} else if (1 == type) {
				String zdmzhxngh = sysXtcsCacheSer.getCsz(jgid, "ZDJZHXNGH");
				zdgh = Integer.parseInt(zdmzhxngh);
				if (zdgh == 99) {
					zdgh = 1;
				} else {
					zdgh = Integer.parseInt(zdmzhxngh) + 1;
				}
				zdmzh = rq + String.format("%0" + 2 + "d", zdgh);
			}
			// 获取起始和终止号码
			String qshm = zdmzh + "001";
//			String syhm = zdmzh + "002";
			String zzhm = zdmzh + "999";
			// 将生成的自动门诊号码写入员工票据中
			OpYgpj opYgpj = new OpYgpj();
			opYgpj.setJgid(jgid);
			opYgpj.setYgdm(ygdm);
			opYgpj.setLyrq(DateUtil.date().toTimestamp());
			opYgpj.setPjlx(type);
			opYgpj.setQshm(qshm);
			opYgpj.setZzhm(zzhm);
			opYgpj.setSyhm(qshm);
			opYgpj.setSypb(0);
			opYgpj.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YGPJ));
			opYgpjDao.insert(opYgpj);

			SysXtcs sysXtcs = new SysXtcs();
			sysXtcs.setCsz(zdgh + "");
			if (3 == type) {
				sysXtcs.setCsmc("ZDMZHXNGH");
				// sysXtcsDao.updateCsz(sysXtcs);
			} else if (1 == type) {
				sysXtcs.setCsmc("ZDJZHXNGH");
				// sysXtcsDao.updateCsz(sysXtcs);
			}
			return qshm;
		} else {
			return null;
		}
	}

	/**
	 * 获取使用号码
	 *
	 * @param jgid
	 * @param ygdm
	 * @param type
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public String getNotesNumberNotIncrement1(Integer jgid, Integer ygdm, Integer type) {
		List<OpYgpj> syhmList = opYgpjDao.getFirstSyhm(jgid, ygdm, type);
		if (syhmList.size() == 0) {
			return null;
		}
		OpYgpj opYgpj = syhmList.get(0);
		String syhm = opYgpj.getSyhm().toString();
		return syhm;
//		List<OpYgpj> syhmList = opYgpjDao.getFirstSyhm(jgid, ygdm, 3);
//		if (syhmList.size() == 0) {
//			return null;
//		}
//		OpYgpj opYgpj = syhmList.get(0);
//		String syhm = opYgpj.getSyhm().toString();
//		StringBuffer sb = new StringBuffer(syhm);
//		sb = sb.reverse();
//		String syhmnew = sb.toString();
//		if (syhm.equals(opYgpj.getZzhm().toString())) {
//			opYgpj.setSypb(1);
//			opYgpjDao.updateHm(Integer.valueOf(syhm), opYgpj.getZzhm(), opYgpj.getJlxh(), 1);
//		} else {
//			if (type == 2) {
//				int length = syhm.length();
//				int slen = length;
//				for (int i = 0; i < length; i++) {
//					char n = syhmnew.charAt(i);
//					if (n < 48 || n > 57) {
//						slen = i;
//						break;
//					}
//				}
//				String sz = syhm.substring(syhm.length() - slen);
//				String zm = syhm.substring(0, syhm.length() - slen);
//				long intnewsz = Long.parseLong(sz) + 1;
//				String newssz = String.format("%0" + (slen) + "d", intnewsz);
//				opYgpjDao.updateHm(Integer.valueOf(zm + newssz), opYgpj.getZzhm(), opYgpj.getJlxh(), null);
//			} else {
//				int length = syhm.length();
//				long intnewsyhm = Long.parseLong(syhm) + 1;
//				String newsyhm = String.format("%0" + length + "d", intnewsyhm);
//				opYgpjDao.updateHm(Integer.valueOf(newsyhm), opYgpj.getZzhm(), opYgpj.getJlxh(), null);
//			}
//		}
//		return syhm;
	}

	/**
	 * 保存诊疗费
	 *
	 * @param mpiBrdaInfo
	 * @param jgid
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doSaveZlf(MpiBrdaInfo mpiBrdaInfo, Integer jgid) {
		String mtsqycghf = sysXtcsCacheSer.getCsz(jgid, "MTSQYCGHF");
		String brxzSybx = sysXtcsCacheSer.getCsz(jgid, "BRXZ_SYBX");
		long l = 0;
		// 拱墅模式：增加挂号明细费用查询，判断挂号是否已经收费了（OP_GHMX的ghje+zlje>0表示已经收费了）
		if (!"1".equals(mtsqycghf)) {
			// 是否每天收取一次挂号费，1一天只收一次，0每次挂号都收
			OpGhmxInfo opGhmxInfo = new OpGhmxInfo();
			opGhmxInfo.setSbxh(mpiBrdaInfo.getTempGhgl());
			BigDecimal gjf = opGhmxDao.getGhf(opGhmxInfo);

			if (gjf != null && gjf.compareTo(BigDecimal.ZERO) == 1
					|| (brxzSybx.equals(String.valueOf(mpiBrdaInfo.getBrxz())))) {
				// 已经存在收过费的挂号费用,或者是商保病人
				return;
			}
			OpYjcf01 opYjcf01 = new OpYjcf01();
			opYjcf01.setFjlb(3);
			opYjcf01.setFjgl(opGhmxInfo.getSbxh());
			l = opYjcf01Dao.getYjCount(opYjcf01);
		} else {
			OpGhmxInfo opGhmxInfo = new OpGhmxInfo();
			opGhmxInfo.setJgid(jgid);
			opGhmxInfo.setBrid(mpiBrdaInfo.getBrid());
			opGhmxInfo.setThbz(0);
			opGhmxInfo.setGhsj(DateUtil.date().toTimestamp());
			opGhmxInfo.setBeginOfDay(DateUtil.offsetDay(DateUtil.date(), -1).toTimestamp());
			opGhmxInfo.setEndOfDay(DateUtil.date().toTimestamp());
			BigDecimal gjf = opGhmxDao.getGhf(opGhmxInfo);
			if (gjf != null && gjf.compareTo(BigDecimal.ZERO) == 1
					|| (brxzSybx.equals(String.valueOf(mpiBrdaInfo.getBrxz())))) {
				// 已经存在收过费的挂号费用,或者是商保病人
				return;
			}
			l = opYjcf01Dao.getYjCountOne(opGhmxInfo);
		}

		if (l <= 0) {
			OpGhmxInfo opGhmxInfo = new OpGhmxInfo();
			opGhmxInfo.setSbxh(mpiBrdaInfo.getGhgl());
			List<OpGhmxInfo> ghmxList = opGhmxDao.getGhmxByCondition(opGhmxInfo);
			if (ghmxList.size() > 0) {
				opGhmxInfo = ghmxList.get(0);
			} else {
				throw BaseException.create("ERROR_REG_0010");
			}
			// 查询医疗项目中自动插入为1的
			FeeYlsfxmdjModel feeYlsfxmdj = new FeeYlsfxmdjModel();
			feeYlsfxmdj.setZdcr(1);
			feeYlsfxmdj.setZfpb(0);
			feeYlsfxmdj.setJgid(jgid);
			List<FeeYlsfxmdjModel> ylmxList = feeYlsfxmdjService.getYlmxInfo(feeYlsfxmdj);
			if (ylmxList.size() > 0) {
				OpYjcf01 opYjcf01 = new OpYjcf01();
				opYjcf01.setJgid(jgid);
				opYjcf01.setBrid(mpiBrdaInfo.getBrid());
				opYjcf01.setBrxm(mpiBrdaInfo.getBrxm());
				opYjcf01.setKdrq(DateUtil.date().toTimestamp());
				opYjcf01.setKsdm(opGhmxInfo.getMzks());
				opYjcf01.setYsdm(opGhmxInfo.getYsdm());
				opYjcf01.setZxks(opGhmxInfo.getMzks());
				opYjcf01.setZxpb(0);
				opYjcf01.setZfpb(0);
				opYjcf01.setCfbz(0);
				opYjcf01.setJzxh(mpiBrdaInfo.getJzxh());
				opYjcf01.setFjgl(mpiBrdaInfo.getGhgl());
				opYjcf01.setFjlb(3);
				opYjcf01.setDjzt(0);
				opYjcf01.setDjly(6);
				opYjcf01.setYjxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJCF01));
				opYjcf01Dao.insert(opYjcf01);

				Integer yjxh = opYjcf01.getYjxh();
				for (FeeYlsfxmdjModel feeYlsfxmdj2 : ylmxList) {
					OpYjcf02 opYjcf02 = new OpYjcf02();
					opYjcf02.setJgid(jgid);
					opYjcf02.setYjxh(yjxh);
					opYjcf02.setYlxh(feeYlsfxmdj2.getFyxh());
					opYjcf02.setXmlx(0);
					opYjcf02.setYjzx(1);
					opYjcf02.setYldj(feeYlsfxmdj2.getFydj());
					opYjcf02.setYlsl(new BigDecimal("1"));
					opYjcf02.setHjje(feeYlsfxmdj2.getFydj());
					opYjcf02.setFygb(getfygb(01, feeYlsfxmdj2.getFyxh()));
					Map<String, Object> payArgs = new HashMap<String, Object>(16);
					payArgs.put("TYPE", 0);
					payArgs.put("FYXH", feeYlsfxmdj2.getFyxh());
					payArgs.put("FYGB", opYjcf02.getFygb());
					payArgs.put("BRXZ", mpiBrdaInfo.getBrxz());
					opYjcf02.setZfbl(new BigDecimal(getPayProportion(payArgs).get("ZFBL").toString()));
					opYjcf02.setDzbl(new BigDecimal("0.00"));
					opYjcf02.setYjzh(1);
					opYjcf02.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJCF02));
					opYjcf02Dao.insert(opYjcf02);
				}

			}

		}

	}

	/**
	 * 获取费用归并
	 *
	 * @param alYplx
	 * @param alFyxh
	 * @return
	 */
	public Integer getfygb(Integer alYplx, Integer alFyxh) {
		Integer alFygb;
		// 如果不是费用,先查询有吴账簿类别,没有账簿类别则按药品类型分
		if (alYplx.intValue() == 1 || alYplx.intValue() == 2 || alYplx.intValue() == 3) {
			DrugsTypk drugsTypk = drugsTypkDao.getById(alFyxh);
			if (drugsTypk != null && drugsTypk.getZblb() != null && drugsTypk.getZblb().intValue() > 0) {
				alFygb = drugsTypk.getZblb();
			} else {
				throw BaseException.create("ERROR_REG_0011");
			}
		} else {
			FeeYlsfxmOutResp feeYlsfxm = feeYlsfxmOutSer.getById(alFyxh);
			alFygb = feeYlsfxm.getFygb();
		}
		return alFygb;
	}

	/**
	 * 获取费用自负比例
	 *
	 * @param body
	 * @return
	 */
	public Map<String, Object> getPayProportion(Map<String, Object> body) {
		Integer alYplx = Integer.parseInt(body.get("TYPE") + "");// 药品传药品类型1,2,3,费用传0
		Object alBrxz = body.get("BRXZ");// 病人性质
		Object alFyxh = body.get("FYXH");// 费用序号
		Object alFygb = body.get("FYGB");// 费用归并
		Map<String, Object> params = new HashMap<String, Object>(16);
		params.put("BRXZ", alBrxz);
		params.put("FYXH", alFyxh);
		Map<String, Object> map = new HashMap<String, Object>(16);
		if (alYplx == 0) {
			PubFyxzApiReq pubFyxz = new PubFyxzApiReq();
			pubFyxz.setBrxz(Integer.valueOf(params.get("BRXZ").toString()));
			pubFyxz.setFyxh(Integer.valueOf(params.get("FYXH").toString()));
			// 查询费用禁用信息
			map = pubFyxzService.getFyjyInfo(pubFyxz);
		} else {
			FeeYpxzApiReq feeYpxz = new FeeYpxzApiReq();
			feeYpxz.setBrxz(Integer.valueOf(params.get("BRXZ").toString()));
			feeYpxz.setYpxh(Integer.valueOf(params.get("FYXH").toString()));
			// 查询药品禁用信息
			map = feeYpxzService.getYpjyInfo(feeYpxz);
		}
		if (map != null) {
			if (map.get("FYXE") == null || map.get("FYXE") == "") {
				map.put("FYXE", 0.0);
			}
			if (map.get("CXBL") == null || map.get("CXBL") == "") {
				map.put("CXBL", 0.0);
			}
			map.put("CXBL", (ObjectToTypes.parseBigDecimal(map.get("CXBL")).divide(new BigDecimal(100))));
			return map;
		} else {
			ParamUtil.instance().put("ZFBL", 1);
		}
		params.clear();
		params.put("BRXZ", alBrxz);
		params.put("FYGB", alFygb);

		FeeSfdlzfbl feeSfdlzfbl = new FeeSfdlzfbl();
		feeSfdlzfbl.setBrxz(Integer.valueOf(params.get("BRXZ").toString()));
		feeSfdlzfbl.setSfxm(Integer.valueOf(params.get("FYGB").toString()));
		Map<String, Object> zfblMap = feeSfdlzfblOutSer.getZfblInfo(feeSfdlzfbl);
		if (zfblMap == null) {
			zfblMap = new HashMap<String, Object>(16);
			zfblMap.put("ZFBL", 1);
		}
		return zfblMap;
	}

	/**
	 * 退号查询单据号
	 *
	 * @param req
	 * @return
	 */
	public List<OpGhmxInfo> doQueryGhdj(MsQryGhdjReq req) {
		if (!"".equals(req.getGrbh()) && req.getGrbh() != null) {
			String mzhm = mpiBrdaDao.getMzhmByGrbh(req.getGrbh());
			if ("".equals(mzhm) || mzhm == null) {
				throw BaseException.create("ERROR_REG_0012");
			}
			req.setJzkh(mzhm);
		}

//		Date dateBegin = formatter.parse(formatter.format(new Date()));
//		if (req.containsKey("YBXX")) {
//			Map<String, Object> map_ybxx = (Map<String, Object>) req.get("YBXX");
//			StringBuffer hql_ybbrxx = new StringBuffer();
//			hql_ybbrxx.append("select a.MZHM as MZHM from MPI_BRDA a,")
//					.append("YB_CBRYJBXX b where a.BRID=b.BRID and b.GRBH=:grbh");
//			Map<String, Object> map_par = new HashMap<String, Object>();
//			map_par.put("grbh", map_ybxx.get("GRBH") + "");
//			Map<String, Object> map_ybbrxx = dao.doLoad(hql_ybbrxx.toString(), map_par);
//			if (map_ybbrxx == null || map_ybbrxx.size() == 0) {
//				res.put("x-response-code", 9000);
//				res.put("x-response-msg", "未找到该卡对应的挂号信息");
//				return;
//			}
//			req.put("JZKH", map_ybbrxx.get("MZHM") + "");
//		}

		if (!"".equals(req.getJzkh()) && req.getJzkh() != null) {
			MpiCard mc = new MpiCard();
			mc.setCardno(req.getJzkh());
			MpiCard mpiCard = mpiCardDao.getMpiCardInfo(mc);
			if (mpiCard != null) {
				OpGhmxInfo ghmx = new OpGhmxInfo();
				ghmx.setBrid(mpiCard.getBrid());
				MpiBrda mpiBrda = mpiBrdaDao.getByCondition(ghmx);
				if (mpiBrda == null) {
					throw BaseException.create("ERROR_REG_0014");
				}
				OpGhmxInfo opGhmxInfo = new OpGhmxInfo();
				opGhmxInfo.setBrid(mpiBrda.getBrid());
				opGhmxInfo.setJgid(req.getJgid());
				opGhmxInfo.setGhsj(DateUtil.date().toTimestamp());
				opGhmxInfo.setBeginOfDay(DateUtil.beginOfDay(DateUtil.date()).toTimestamp());
				opGhmxInfo.setEndOfDay(DateUtil.endOfDay(DateUtil.offsetDay(DateUtil.date(), 1)).toTimestamp());
				opGhmxInfo.setJzjs(0);
				opGhmxInfo.setThbz(0);
				// 查询挂号信息数量
				Integer count = opGhmxDao.getGhmxCount(opGhmxInfo);

				if (count != null && count.intValue() == 1) {
					// 暂挂状态要单独判断
					// 1.判断暂挂状态是否有处方
					// 2.判断暂挂状态是否有处置
					// 3.只要存在处方和处置，不能退号count赋值为-2 return
					Integer cfsbCount = opGhmxDao.getCfsbCount(opGhmxInfo);
					Integer yjxhCount = opGhmxDao.getYjxhCount(opGhmxInfo);
					if (cfsbCount != null && yjxhCount != null) {
						if (cfsbCount.intValue() + yjxhCount.intValue() > 0) {
							throw BaseException.create("ERROR_REG_0015");
						}
					}

					if (!"".equals(req.getFphm()) && req.getFphm() != null) {
						opGhmxInfo.setJzhm(req.getFphm());
					}

					if (!"".equals(req.getJzkh()) && req.getJzkh() != null) {
						opGhmxInfo.setJzkh(req.getJzkh());
					}
					// 查询挂号信息
					List<OpGhmxInfo> ghmxInfo = opGhmxDao.getGhmx(opGhmxInfo);

					return ghmxInfo;
				} else if (count != null && count.intValue() > 1) {
					List<OpGhmxInfo> ghmxList = new ArrayList<OpGhmxInfo>();
					if (!"".equals(req.getFphm()) && req.getFphm() != null) {
						opGhmxInfo.setJzhm(req.getFphm());
					}

					if (!"".equals(req.getJzkh()) && req.getJzkh() != null) {
						opGhmxInfo.setJzkh(req.getJzkh());
					}
					// 查询挂号信息
					List<OpGhmxInfo> ghmxInfo = opGhmxDao.getGhmx(opGhmxInfo);
					for (OpGhmxInfo opGhmx : ghmxInfo) {
						Integer jzxhCount = opGhmxDao.getJzxhCount(opGhmx.getSbxh());
						// 没有处方和处置
						if (jzxhCount != null && jzxhCount.intValue() == 0) {
							ghmxList.add(opGhmx);
						}
					}
					return ghmxList;
				}
			}
		} else if (!"".equals(req.getFphm()) && req.getFphm() != null) {
			OpGhmxInfo opGhmxInfo = new OpGhmxInfo();
			opGhmxInfo.setJzhm(req.getFphm());
			opGhmxInfo.setJgid(req.getJgid());
			opGhmxInfo.setGhsj(DateUtil.date().toTimestamp());
			opGhmxInfo.setBeginOfDay(DateUtil.beginOfDay(DateUtil.date()).toTimestamp());
			opGhmxInfo.setEndOfDay(DateUtil.endOfDay(DateUtil.offsetDay(DateUtil.date(), 1)).toTimestamp());
			opGhmxInfo.setThbz(0);
			if (!"".equals(req.getFphm()) && req.getFphm() != null) {
				opGhmxInfo.setJzhm(req.getFphm());
			}

			if (!"".equals(req.getJzkh()) && req.getJzkh() != null) {
				opGhmxInfo.setJzkh(req.getJzkh());
			}
			List<OpGhmxInfo> ghmxInfo = opGhmxDao.getGhmx(opGhmxInfo);
			if (ghmxInfo.isEmpty()) {
				return null;
			}
			return ghmxInfo;
		} else {
			OpGhmxInfo opGhmxInfo = new OpGhmxInfo();
			opGhmxInfo.setMzhm(req.getMzhm());
			MpiBrda mpiBrda = mpiBrdaDao.getByCondition(opGhmxInfo);
			if (mpiBrda == null) {
				throw BaseException.create("ERROR_REG_0014");
			}
			OpGhmxInfo opghmx = new OpGhmxInfo();
			opghmx.setBrid(mpiBrda.getBrid());
			opghmx.setJgid(req.getJgid());
			opghmx.setGhsj(DateUtil.date().toTimestamp());
			opghmx.setBeginOfDay(DateUtil.date().toTimestamp());
			opghmx.setEndOfDay(DateUtil.offsetDay(DateUtil.date(), 1).toTimestamp());
			opghmx.setJzjs(0);
			opghmx.setThbz(0);
			// 查询挂号信息数量
			Integer count = opGhmxDao.getGhmxCount(opghmx);
			if (count != null && count.intValue() == 1) {
				if (req.getYbxx() == null) {
					Integer ybghCount = opGhmxDao.getYbghCount(opghmx);
					if (ybghCount != null && ybghCount.intValue() > 0) {
						throw BaseException.create("ERROR_REG_0013");
					}
				}

				// 暂挂状态要单独判断
				// 1.判断暂挂状态是否有处方
				// 2.判断暂挂状态是否有处置
				// 3.只要存在处方和处置，不能退号count赋值为-2 return
				Integer cfsbCount = opGhmxDao.getCfsbCount(opghmx);
				Integer yjxhCount = opGhmxDao.getYjxhCount(opghmx);
				if (cfsbCount != null && yjxhCount != null) {
					if (cfsbCount.intValue() + yjxhCount.intValue() > 0) {
						throw BaseException.create("ERROR_REG_0015");
					}
				}
				if (!"".equals(req.getFphm()) && req.getFphm() != null) {
					opGhmxInfo.setJzhm(req.getFphm());
				}

				if (!"".equals(req.getJzkh()) && req.getJzkh() != null) {
					opGhmxInfo.setJzkh(req.getJzkh());
				}
				// 查询挂号信息
				List<OpGhmxInfo> ghmxInfo = opGhmxDao.getGhmx(opghmx);
				if (ghmxInfo.isEmpty()) {
					return null;
				}
				return ghmxInfo;
			}
		}
		return null;
	}

	/**
	 * 退号处理
	 *
	 * @param req
	 * @throws ParseException
	 */
//	@Transactional(rollbackFor = Exception.class)
//	public void doCancelRegister(MsCancelRegisterReq req) {
////		Integer number = null;
////		if ("".equals(req.getFphm())) {
////			number = opPosmxDao.getPosTraceNumber(req.getJzhm());
////		} else {
////			number = opPosmxDao.getPosTraceNumber(req.getFphm());
////		}
//		// TODO pos退号暂时不加
//		// 未日结的POS机退费只能到收费时的pos退费
////		beforeRetire(req);
//
//		String sbxh = req.getSbxh() != null ? req.getSbxh().toString() : "";
//		String fphm = req.getJzhm();
//		String xzdm = req.getBrxz() != null ? req.getBrxz().toString() : "";
//		Map<String, Object> opYspbParameters = new HashMap<String, Object>(16);
//		Map<String, Object> opGhmxParameters = new HashMap<String, Object>(16);
//		Map<String, Object> opGhksParameters = new HashMap<String, Object>(16);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		opGhmxParameters.put("SBXH", Long.parseLong(sbxh));
//		opGhmxParameters.put("thbz", 1);
//		opGhmxDao.updateThbz(opGhmxParameters);
//		OpGhmx opGhmx = opGhmxDao.getById(req.getSbxh());
//		Map<String, Object> opGhmxMap = MzUtil.caseInsensitiveMap(opGhmx);
//		Calendar startc = Calendar.getInstance();
////		int hour = startc.get(Calendar.HOUR_OF_DAY);
////		int zblb = 0;
////		if (hour < 12) {
////			zblb = 1;
////		} else {
////			zblb = 2;
////		}
//
//		String zblb = null;
//		// 查询班级集合
//		List<OpBcsj> bcsjList = opBcsjService.getBcsjInfo(new OpBcsj());
//		for (OpBcsj opBcsj : bcsjList) {
//			DateTime currenTime = DateUtil.date();
//			String sbsjStr = DateUtil.today() + opBcsj.getSbsj();
//			String xbsjStr = DateUtil.today() + opBcsj.getXbsj();
//			DateTime sbsjDate = DateUtil.parse(sbsjStr);
//			DateTime xbsjDate = DateUtil.parse(xbsjStr);
//			if (currenTime.after(sbsjDate) && currenTime.before(xbsjDate)) {
//				zblb = opBcsj.getSddm();
//			}
//		}
//
//		Map<String, Object> opThmxMap = new HashMap<String, Object>(16);
//		opThmxMap.put("SBXH", Long.parseLong(sbxh));
//		opThmxMap.put("JGID", req.getJgid());
//		opThmxMap.put("CZGH", req.getYgdm());
//		opThmxMap.put("MZLB", opGhmxMap.get("MZLB"));
//		opThmxMap.put("THRQ", DateUtil.date());
//		OpThmx opThmx = BeanUtil.fillBeanWithMapIgnoreCase(opThmxMap, new OpThmx(), true);
//		opThmx.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_THMX));
//		opThmxDao.insert(opThmx);
//
//		if (sdf.format(new Date()).equals(sdf.format((Date) opGhmxMap.get("GHSJ")))
//				&& Integer.parseInt(opGhmxMap.get("GHLB") + "") == zblb) {
//			opGhksParameters.put("JGID", req.getJgid());
//			opGhksParameters.put("KSDM", Long.parseLong(opGhmxMap.get("KSDM") + ""));
//			opGhksDao.updateYgrs(opGhksParameters);
//		} else if (sdf.format(new Date()).equals(sdf.format((Date) opGhmxMap.get("GHSJ")))
//				&& Integer.parseInt(opGhmxMap.get("GHLB") + "") == 2) {
//			opGhksParameters.put("JGID", req.getJgid());
//			opGhksParameters.put("KSDM", Long.parseLong(opGhmxMap.get("KSDM") + ""));
//			opGhksParameters.put("GHRQ", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//			opGhksParameters.put("ZBLB", 2);
//			opKspbDao.updateByTh(opGhksParameters);
//		} else if (((Date) opGhmxMap.get("GHSJ")).getTime() > System.currentTimeMillis()) {
//			startc.setTime((Date) opGhmxMap.get("GHSJ"));
//			opGhksParameters.put("JGID", req.getJgid());
//			opGhksParameters.put("KSDM", Long.parseLong(opGhmxMap.get("KSDM") + ""));
//			opGhksParameters.put("GHRQ", DateUtil.parse(opGhmxMap.get("GHSJ") + "", "yyyy-MM-dd"));
//			opGhksParameters.put("ZBLB", Integer.parseInt(opGhmxMap.get("GHLB") + ""));
//			opKspbDao.updateByTh(opGhksParameters);
//		}
//		if (opGhmxMap.containsKey("YSDM")) {
//			Date ldtBegin = DateUtil.beginOfDay(DateUtil.parse(opGhmxMap.get("GHSJ") + "", "yyyy-MM-dd"));
//			Date ldtEnd = DateUtil.endOfDay(DateUtil.parse(opGhmxMap.get("GHSJ") + "", "yyyy-MM-dd"));
//			opYspbParameters.put("JGID", req.getJgid());
//			opYspbParameters.put("ldt_begin", ldtBegin);
//			opYspbParameters.put("ldt_end", ldtEnd);
//			opYspbParameters.put("YSDM", opGhmxMap.get("YSDM"));
//			opYspbParameters.put("ZBLB", Integer.parseInt(opGhmxMap.get("GHLB") + ""));
//			opYspbParameters.put("KSDM", Long.parseLong(opGhmxMap.get("KSDM") + ""));
//			opYspbDao.updateByTh(opYspbParameters);
//		}
//
//		// POS机退费，保存OP_POSMX表
////		@SuppressWarnings("unchecked")
////		Map<String, Object> pos = (Map<String, Object>) body.get("pos");
////		if (pos != null && pos.get("PosTraceNumber") != null) {
////			Map<String, Object> posInfo = phis.source.utils.MapUtils.upcaseKeys(pos);
//////			@SuppressWarnings("unchecked")
//////			Map<String,Object> mapid=dao.doSqlLoad("select SEQ_OP_POSMX.nextval as id from dual");
//////			posInfo.put("ID", mapid.get("id"));
////			SimpleDateFormat mmoo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////			posInfo.put("JYSJ", mmoo.format(new Date()));
////			posInfo.put("JYLB", pos.get("TransType"));
////			posInfo.put("FPHM", FPHM);
////			dao.doSave("create", "phis.application.pos.schemas.OP_POSMX", posInfo, false);
////		}
//		// 预付卡退费
//		List<Map<String, Object>> list = mpiKpxxDao.getMpiKpxxInfo(fphm);
//		if (list.size() == 0) {
//
//		} else {
//			String tfjeStr = list.get(0).get("TFJE") != null ? list.get(0).get("TFJE").toString() : "";
//			BigDecimal tfje = new BigDecimal(tfjeStr);
//			String brid = list.get(0).get("BRID") != null ? list.get(0).get("BRID").toString() : "";
//			MpiKpxx mpiKpxx = mpiKpxxDao.getById(Integer.valueOf(brid));
//			BigDecimal amount = mpiKpxx.getKnye().add(tfje);
//			mpiKpxxDao.updateMsPkxx(amount, brid);
//
//			String czgh = req.getYgdm().toString();
//			String czip = req.getIp();
//			Map<String, Object> data = new HashMap<String, Object>(16);
//			data.put("CARDNO", list.get(0).get("CARDNO"));
//			data.put("CZTYPE", "10");
//			data.put("AMOUNT", list.get(0).get("TFJE"));
//			data.put("CZGH", czgh);
//			data.put("CZIP", czip);
//			data.put("CZSJ", DateUtil.date().toTimestamp());
//			data.put("BRID", Integer.valueOf(brid));
//			data.put("FPHM", fphm);
//			data.put("LASTKNYE", Double.parseDouble(list.get(0).get("KNYE").toString()));
//
//			OpCzjl opCzjl = BeanUtil.fillBeanWithMapIgnoreCase(opThmxMap, new OpCzjl(), true);
//			opCzjl.setCzxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CZJL));
//			opCzjlDao.insert(opCzjl);
//		}
//		// 排队系统 退号处理
////		if (body.containsKey("YBXX")) {
////			MedicareInterface model = new HZSMedicareModel(dao);
////			model.saveYbGhth((Map<String, Object>) body.get("YBXX"));
////		}
//		// else if(body.containsKey("jyqr")){
//		// Map<String,Object> jyqr = (Map<String,Object>)body.get("jyqr");
//		// MedicareSYBModel msm = new MedicareSYBModel(dao);
//		// msm.doSaveSzYbjyqr("update", jyqr, res, ctx);
//		// }
//
//		// 如果非商保病人 TODO
////		String brxz_sybx = sysXtcsCacheSer.getCsz(req.getJgid(), "BRXZ_SYBX");
////
////		if (!brxz_sybx.equals(xzdm)) {
////			Map<String, Object> countParam = new HashMap<String, Object>(16);
////			countParam.put("DocumentNr", fphm);
////			SystemPublicSer publicService = new SystemPublicSer();
////			Map<String, Object> map = new HashMap<String, Object>(16);
////			map.put("names", "ZZSFPDY");
////			Map<String, Object> Pamargs = publicService.doLoadThisComputerArgs(map, req.getIp(), req.getJgid());
////			String ZZSFPDY = Pamargs.get("ZZSFPDY") != null ? Pamargs.get("ZZSFPDY").toString() : "";
////			if (ZZSFPDY.equals("1")) { // 启用增值税发票
////				// 去作废增值税发票
////				tblCustDocmasterDao.delByDocumentNr(fphm);
////				Map<String, Object> request = new HashMap<String, Object>(16);
////				request.put("FPHM", fphm);
////				request.put("FPLX", "GH");
////				PHISCommonModel phis = new PHISCommonModel(dao);
////				// phis.doCancelinv(request);
////				phis.doCancelinv_jk(request, res, ctx);
////			} else {// 未启用增值税
////				// 根据发票号码检查是否已经开了发票，没开发票就删除Tbl_Cust_DocMaster中对应的记录
////				List<Map<String, Object>> countList = dao.doSqlQuery(
////						"select count(*) as TOTAL from Tbl_Result where DocumentNr=:DocumentNr", countParam);
////				if (countList != null && 0 == Long.parseLong(countList.get(0).get("TOTAL") + "")) {
////					dao.doSqlUpdate("delete from Tbl_Cust_DocMaster where DocumentNr=:DocumentNr", countParam);
////				}
////			}
////		}
//	}

	/**
	 * 查询当日是否在选择的科室挂号
	 *
	 * @param req
	 */
	public void doCheckGhks(MsRegisterReq req) {
		Map<String, Object> parameters = new HashMap<String, Object>(16);
		if (req.getGhsj() != null) {
//			if(opGhksDao.checkZyhz(req.getJzkh())){
//				throw BaseException.create("ERROR_REG_0098");
//			}
			Timestamp ghsjB = DateUtil.beginOfDay(req.getGhsj()).toTimestamp();
			Timestamp ghsjE = DateUtil.endOfDay(req.getGhsj()).toTimestamp();
//			parameters.put("BRID", body.get("BRID"));
			parameters.put("KSDM", req.getKsdm());
			parameters.put("GHSJ_B", ghsjB);
			parameters.put("GHSJ_E", ghsjE);
			parameters.put("JZKH", req.getJzkh());
			parameters.put("thbz", 0);
			parameters.put("GHSJ", DateUtil.date(req.getGhsj()).toTimestamp());
			parameters.put("ZBLB", req.getZblb());

			// 当日某科室挂号次数 查询时增加退号标志判断
			Map<String, Object> map = opGhmxDao.getSbxhCount(parameters);
			int ghksTimes = Integer.valueOf(map.get("GHJG").toString()).intValue();

			// 当日挂号次数
			parameters.remove("KSDM");
			Map<String, Object> map1 = opGhmxDao.getSbxhCount(parameters);
			int ghTimes = Integer.valueOf(map1.get("GHJG").toString()).intValue();

			// 判断今天是否挂过该科室
			if (ghksTimes > 0) {
				throw BaseException.create("ERROR_REG_0019");
			}

			// 判断今天挂号总次数 留着以后用
//			if (ghTimes > 1) {
//				throw BaseException.create("ERROR_REG_0020");
//			}

			// 判断当日上下午挂号限额
			Map<String, Object> params = new HashMap<String, Object>(16);
			params.put("KSDM", req.getKsdm());
			params.put("GHSJ_B", ghsjB);
			params.put("GHSJ_E", ghsjE);
			params.put("ZBLB", req.getZblb());
			Map<String, Object> ghxeMap = opGhksDao.doQueryGhxeByDay(params);
			if (ghxeMap != null && !ghxeMap.isEmpty()) {
				int ghxe = ghxeMap.get("GHXE") != null ? Integer.parseInt(ghxeMap.get("GHXE").toString()) : 0;
				int ygrs = ghxeMap.get("YGRS") != null ? Integer.parseInt(ghxeMap.get("YGRS").toString()) : 0;
				if (ghxe == ygrs) {
					throw BaseException.create("ERROR_REG_0085");
				}
			}
		}

	}

	/**
	 * 查询排班医生
	 *
	 * @param ksdm
	 */
	public List<MsGhYspbResp> doQuerySchedulingDoctor(Integer ksdm, Integer jgid) {
		Map<String, Object> parameters = new HashMap<String, Object>(16);
		Calendar startc = Calendar.getInstance();
		Timestamp adtBegin = DateUtil.beginOfDay(DateUtil.date()).toTimestamp();
		Timestamp adtEnd = DateUtil.endOfDay(DateUtil.date()).toTimestamp();
//		int zblb = startc.get(Calendar.HOUR_OF_DAY);
//		if (zblb < 12) {
//			zblb = 1;
//		} else {
//			zblb = 2;
//		}
		// 根据时间段获取值班类别
		List<String> zblb = mzUtil.getAllSddmByTime(DateUtil.date());

		parameters.put("JGID", jgid);
		parameters.put("ZBLB", String.join(",",zblb));
		//parameters.put("ZBLB", "1000008");
		parameters.put("adt_begin", adtBegin);
		parameters.put("adt_end", adtEnd);
		parameters.put("GZRQ", DateUtil.date());
		parameters.put("KSDM", ksdm);
		parameters.put("fwlx", 1);
		List<Map<String, Object>> inofList = opYspbDao.getGhYspbList(parameters);

		if (inofList != null && inofList.size() > 0) {
//			String where1 = ""; // 科室代码条件
//			Pattern p = Pattern.compile("(?i)a.KSDM\\s*=\\s*'*\\w+'*");
//			Matcher matcher = p.matcher(where);
//			while (matcher.find()) {
//				where1 = matcher.group(0);
//				break;
//			}
			String currDate = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());

			// 医生候诊人数、暂挂人数
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("jgid", jgid);
			resultMap.put("ksdm", ksdm);
			resultMap.put("currDate", currDate);
			List<Map<String, Object>> list1 = opYspbDao.getHzrsAndZgrs(resultMap);

			Map<String, Object> m1 = new HashMap<String, Object>();
			for (Map<String, Object> m : list1) {
				m1.put(m.get("YSDM") + "_1_" + m.get("ZSID"), m.get("HZRS"));
				m1.put(m.get("YSDM") + "_2_" + m.get("ZSID"), m.get("ZGRS"));
				m1.put(m.get("YSDM") + "_3_" + m.get("ZSID"), m.get("YGRS"));
			}

			// 合计医生候诊人数
			for (Map<String, Object> map : inofList) {
				String ysdm = ObjectToTypes.null2Str(map.get("YSDM"));
				String zsid = map.get("ZSID") != null ? map.get("ZSID").toString() : "0";

				int hzrs = ObjectToTypes.toInt(m1.get(ysdm + "_1_" + zsid));
				int zgrs = ObjectToTypes.toInt(m1.get(ysdm + "_2_" + zsid));
				int ygrs = ObjectToTypes.toInt(m1.get(ysdm + "_3_" + zsid));
				map.put("HZRS", hzrs);
				map.put("ZGRS", zgrs);
				map.put("YGRS", ygrs);
			}
			// 根据候诊人数排序
			Collections.sort(inofList, new Comparator<Map<String, Object>>() {
				public int compare(Map<String, Object> m1, Map<String, Object> m2) {
					int n = ObjectToTypes.toInt(m1.get("SFTZ")) - ObjectToTypes.toInt(m2.get("SFTZ"));
					if (n == 0) {
						n = ObjectToTypes.toInt(m1.get("HZRS")) - ObjectToTypes.toInt(m2.get("HZRS"));
					}
					if (n == 0) {
						n = ObjectToTypes.toInt(m1.get("ZGRS")) - ObjectToTypes.toInt(m2.get("ZGRS"));
					}
					if (n == 0) {
						n = ObjectToTypes.toInt(m1.get("ZSID")) - ObjectToTypes.toInt(m2.get("ZSID"));
					}
					return n;
				}
			});
		}
		List<MsGhYspbResp> resultList = MzUtil.ListToResultSet(inofList, new MsGhYspbResp());
		return resultList;
	}

	/**
	 * 挂号结算查询
	 *
	 * @param req
	 * @return
	 */
	public MsQryRegisterResp doQueryRegistSettle(MsQryRegisterReq req,String ip) {
		MsQryRegisterResp resp = new MsQryRegisterResp();
		Map<String, Object> parameters = new HashMap<String, Object>(16);
		parameters.put("MRBZ", "1");
		parameters.put("SYLX", 1);

		List<Map<String, Object>> fkfsList = pubFkfsService.getPubFkfsInfo(parameters);

		if (fkfsList.size() > 0) {
			Map<String, Object> fkfs = fkfsList.get(0);
			String ghfSfxm = sysXtcsCacheSer.getCsz(req.getJgid(), "GHF");

			Map<String, Object> ghfParameters = new HashMap<String, Object>(16);
			ghfParameters.put("SFXM", Long.parseLong(ghfSfxm));
			ghfParameters.put("BRXZ", Long.parseLong(req.getBrxz().toString()));

			List<Map<String, Object>> ghfZfbl = feeSfdlzfblOutSer.getZfblMap(ghfParameters);
			BigDecimal ldZfghf;// 挂号费
			BigDecimal ldZfbl;
			if (ghfZfbl.size() == 0) {
				ldZfbl = BigDecimal.ONE;
			} else {
				ldZfbl = new BigDecimal(String.valueOf(ghfZfbl.get(0).get("ZFBL")));
			}

			if (req.getGhje() == null) {
				req.setGhje(new BigDecimal("0.00"));
			}
			ldZfghf = req.getGhje().multiply(ldZfbl);  //挂号费end

			String zlfSfxm = sysXtcsCacheSer.getCsz(req.getJgid(), "ZLF");
			Map<String, Object> zlfParameters = new HashMap<String, Object>(16);
			zlfParameters.put("SFXM", Long.parseLong(zlfSfxm));
			zlfParameters.put("BRXZ", Long.parseLong(req.getBrxz().toString()));
			List<Map<String, Object>> zlfZfbl = feeSfdlzfblOutSer.getZfblMap(zlfParameters);
			BigDecimal idZfzlf;// 诊疗费
			if (zlfZfbl.size() == 0) {
				ldZfbl = BigDecimal.ONE;
			} else {
				ldZfbl = new BigDecimal(String.valueOf(zlfZfbl.get(0).get("ZFBL")));
			}
			idZfzlf = req.getZlje().multiply(ldZfbl); //诊疗费end

			String zjfSfxm = sysXtcsCacheSer.getCsz(req.getJgid(), "ZJF");
			Map<String, Object> zjfParameters = new HashMap<String, Object>(16);
			zjfParameters.put("SFXM", Long.parseLong(zjfSfxm));
			zjfParameters.put("BRXZ", Long.parseLong(req.getBrxz().toString()));
			List<Map<String, Object>> zjfZfbl = feeSfdlzfblOutSer.getZfblMap(zjfParameters);
			if (CollUtil.isEmpty(zjfZfbl)) {
				ldZfbl = BigDecimal.ONE;
			} else {
				ldZfbl = new BigDecimal(String.valueOf(zjfZfbl.get(0).get("ZFBL")));
			}
			BigDecimal idZfzjf;// 专家费
			idZfzjf = req.getZjje().multiply(ldZfbl); //专家费end

			BigDecimal idZfckf = req.getCkje();// 磁卡金额

			//上海五期医保开始
			String YBSYPB = sysXtcsCacheSer.getCsz(req.getJgid(), "YBSYPB");
			if(req.getIsYb() == 1 && "0".equals(YBSYPB)){
				Map<String, Object> result  = preRegisteredSettlement(req,ip,ldZfghf,req.getZlje(),idZfzjf,idZfckf);
				if("0".equals(result.get("code"))){
					Map<String,Object> jsxx = new HashMap<String,Object>();
					BigDecimal zjje = new BigDecimal(req.getGhje().toString()).add
							(new BigDecimal(req.getZlje().toString())).add
							(new BigDecimal(req.getBlje().toString())).add
							(new BigDecimal(req.getZjje().toString()));
					BigDecimal zfje = zjje.subtract(new BigDecimal(result.get("ybje").toString()));
					jsxx.put("FKFS", fkfs.get("FKFS"));
					jsxx.put("ZJJE",zjje);
					jsxx.put("ZFJE",zfje);
					jsxx.put("XJJE",result.get("xjje"));
					jsxx.put("ZHJE",result.get("zhje"));
					jsxx.put("YSK",result.get("ysk"));
					jsxx.put("QTYS",result.get("ybje"));
					jsxx.put("DBTYPE",req.getDbtype());
					jsxx.put("ISDB",req.getIsDb());
					jsxx.putAll(result);

					resp = BeanUtil.fillBeanWithMapIgnoreCase(jsxx, new MsQryRegisterResp(), true);
				}
				//五期医保结束
			} else {
				BigDecimal zjje = req.getZjje().add(req.getGhje()).add(req.getZlje()).add(req.getBlje()).add(req.getCkje());
				double zjjeStr = zjje.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				double zfjeStr = zjje.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				if (req.getGrxjzf() != null) {
					zfjeStr = req.getGrxjzf().setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
				}
				if ("2".equals(fkfs.get("FKJD"))) {
					zfjeStr = zjje.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
				}
				if ("1".equals(fkfs.get("FKJD"))) {
					zfjeStr = zjje.setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
				}
				Map<String, Object> jsxx = new HashMap<String, Object>(16);
				jsxx.put("YSK", zfjeStr);
				// 查询是否存在挂号减免及减免百分比
				PubJmlxJm pubJmlxJm = pubJmlxDao.doQueryJmByFyzh(req.getJzkh());
				if (pubJmlxJm != null) {
					if (pubJmlxJm.getZhxq() == null
							|| (pubJmlxJm.getZhxq() != null && DateUtil.date().isBeforeOrEquals(pubJmlxJm.getZhxq()))) {
						if (pubJmlxJm.getGhjm() != null && "1".equals(pubJmlxJm.getGhjm())
								&& pubJmlxJm.getGhjmrate() != null) {
							BigDecimal beforeYsk = BigDecimal.valueOf(zfjeStr);
							BigDecimal afterYsk = beforeYsk.multiply(pubJmlxJm.getGhjmrate());
							BigDecimal jmje = beforeYsk.subtract(afterYsk);
							jsxx.put("YSK", afterYsk);
							jsxx.put("JMJE", jmje);
							zfjeStr = afterYsk.doubleValue();
						}
					}
				}
				jsxx.put("FKFS", fkfs.get("FKFS"));
				jsxx.put("ZJJE", zjjeStr);
				jsxx.put("QTYS", BigDecimal.ZERO);
				jsxx.put("ZFJE", zfjeStr);
				jsxx.put("CKJE", req.getCkje());
				jsxx.put("ZLF", idZfzlf);
				jsxx.put("GHF", ldZfghf);
				jsxx.put("ZJFY", idZfzjf);
				resp = BeanUtil.fillBeanWithMapIgnoreCase(jsxx, new MsQryRegisterResp(), true);
			}
		} else {
			throw BaseException.create("ERROR_REG_0057");
		}
		//处理义诊和免费
		if(req.getSfmf() == 1 || req.getSfmf() == 2){
			resp.setZfje(BigDecimal.ZERO);
			resp.setYsk(BigDecimal.ZERO);
			resp.setJmje(resp.getZjje());
		}
		return resp;

	}

	/**
	 * 挂号
	 *
	 * @param req
	 * @throws ParseException
	 */
	@Transactional(rollbackFor = Exception.class)
	public MsRegisterResp doSaveRegisteredManagement(MsRegisterAddReq req, Boolean isInternet) throws ParseException {
		Map<String, Object> map_body = MzUtil.caseInsensitiveMap(req);
		Map<String, Object> body = MzUtil.caseInsensitiveMap(req.getGhxx());
		Map<String, Object> ybxx = MzUtil.caseInsensitiveMap(req.getYbxx());
		MsGhxxReq msGhxxReq = req.getGhxx();
		List<OpFkxxReq> fkxxList = msGhxxReq.getFkxxList();
		Map<Integer, BigDecimal> fkxxMap = fkxxList.stream().collect(Collectors.toMap(OpFkxxReq::getFkfs, OpFkxxReq::getFkje));
		Set<Integer> fkfsList = fkxxMap.keySet();
		int yytag = 1;
		long jzxhqj = 1;
		long sbxhqj = 0;
		if (map_body.get("YYTAG") != null) {
			yytag = Integer.parseInt(map_body.get("YYTAG") + "");
		}
		String ghyj = map_body.get("GHYJ") + "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 原挂号时间格式为yy-MM-dd无时分秒 导致挂号时间为 00:00:00 改为有时分秒格式 by
																	// wwh 2015-02-06
		sdf.set2DigitYearStart(sdf.parse(body.get("GHSJ") + ""));
		DecimalFormat df = new DecimalFormat("#.00");

		body.put("JGID", req.getJgid());

		String ghsj = body.get("GHSJ") + "";
		if (yytag == 1 && !isInternet) {
			body.put("GHSJ", new Date());
		}
		else if(!isInternet){
			body.put("GHSJ", sdf.parse(ghsj));
		}
		Map<String, Object> parameters = new HashMap<String, Object>(16);
		parameters.put("JGID", req.getJgid());

		Map<String, Object> opGhmx = new HashMap<String, Object>(16);
		BigDecimal jmje = ObjectToTypes.parseBigDecimal(msGhxxReq.getJmje());
		BigDecimal zfje = ObjectToTypes.parseBigDecimal(msGhxxReq.getZfje());
		BigDecimal zpje = ObjectToTypes.parseBigDecimal(fkxxMap.get(FkfsEnum.ZP.getKey()));
		BigDecimal xjje = ObjectToTypes.parseBigDecimal(msGhxxReq.getYsk()).subtract(zpje);

		BigDecimal hbwc = zfje.subtract(xjje).subtract(zpje).negate();
		// 诊室ID
		int zsid = body.get("ZSID") == null ? 0 : Integer.valueOf(body.get("ZSID").toString());

		// OP_GHMX.putAll(body);
		parameters.put("BRID", Long.parseLong(body.get("BRID") + ""));
		Integer czpbl = opGhmxDao.getGhmxCzpbl(parameters);
		parameters.remove("BRID");
		parameters.put("KSDM", Long.parseLong(body.get("KSDM") + ""));
		opGhmx.put("GHCS", 1);
		opGhmx.put("ZPJE", BUHISUtil.getDouble(zpje, 2));
		opGhmx.put("ZHJE", BigDecimal.ZERO);
		// OP_GHMX.put("ZFJE", 0);
		opGhmx.put("HBWC", BUHISUtil.getDouble(hbwc, 2));
		opGhmx.put("QTYS", req.getIsYb() == 1 ? ObjectToTypes.parseBigDecimal(req.getYbxx().getQtys()) : BigDecimal.ZERO);
		opGhmx.put("THBZ", 0);
		if (czpbl > 0) {
			opGhmx.put("CZPB", 0);
		} else {
			opGhmx.put("CZPB", 1);
		}

		// 获取门诊类别
		Integer mzlb = opMzlbSer.getMzlb(req.getJgid(), req.getIp());

		opGhmx.put("MZLB", mzlb);
		opGhmx.put("YSPB", 0);
		opGhmx.put("SFFS", 0);
		opGhmx.put("JZZT", 0);
		opGhmx.put("JZJS", 0);
		opGhmx.put("CZGH", req.getYgdm());
		opGhmx.put("BRXZ", body.get("BRXZ"));
		// modify by yangl 闵行特殊需求,挂号就诊号码取发票号码
		String jzhm = getNotesNumberNotIncrement(req.getYgdm(), req.getJgid(), 2);
		if(msGhxxReq.getSfmf() != 0){
			jzhm = "FREE".concat(RandomUtil.randomNumbers(10));
		}
		opGhmx.put("JZHM", jzhm);
		opGhmx.put("XJJE", BUHISUtil.getDouble(xjje, 2));
		opGhmx.put("JMJE", BUHISUtil.getDouble(jmje, 2));
//		opGhmx.put("QTYS", qtys);自费病人qtys为0
		opGhmx.put("BRID", body.get("BRID"));
		opGhmx.put("JGID", req.getJgid());
		opGhmx.put("ZSID", String.valueOf(zsid));
		opGhmx.put("YWLX", 1);
		opGhmx.put("ZKBZ", 0);
		opGhmx.put("GHLX", body.get("GHLX"));
		opGhmx.put("SFMF", msGhxxReq.getSfmf());
		opGhmx.put("ZSFPHM", jzhm);
		opGhmx.put("LSH", body.get("lsh"));

		if (yytag == 1 && !isInternet) {
			opGhmx.put("GHSJ", DateUtil.date().toTimestamp());
		} else if(isInternet){
			opGhmx.put("GHSJ", sdf.parse(ghsj));
		}
		else {
			opGhmx.put("YYBZ", 1);
			opGhmx.put("GHSJ", sdf.parse(ghsj));
		}

//		String nowdate = sdf.format(new Date());
//		if (nowdate.equals(sdf.format(sdf.parse(ghsj)))) {
//			if ("1".equals(body.get("GHLB"))) {
//				String ampm = sfampm.format(new Date());
//				if ("上午".equals(ampm)) {
//					opGhmx.put("GHLB", 1);
//				} else if ("下午".equals(ampm)) {
//					opGhmx.put("GHLB", 2);
//				}
//			} else {
//				opGhmx.put("GHLB", body.get("GHLB"));
//			}
//		} else {
//			opGhmx.put("GHLB", body.get("GHLB"));
//		}

		// 根据时间段获取值班类别
		String zblb = mzUtil.getSddmByTime(DateUtil.date());
		//String zblb = "1000008";
		opGhmx.put("GHLB", zblb);
		if(isInternet){
			opGhmx.put("GHLB", body.get("GHLB"));
		}
		opGhmx.put("KSDM", Long.parseLong(body.get("KSDM") + ""));
		opGhmx.put("GHJE", BUHISUtil.getDouble(msGhxxReq.getGhje(), 2));
		opGhmx.put("ZLJE", BUHISUtil.getDouble(msGhxxReq.getZlje(), 2));
		opGhmx.put("BLJE", BUHISUtil.getDouble(msGhxxReq.getBlje(), 2));
		opGhmx.put("CKJE", BUHISUtil.getDouble(msGhxxReq.getCkje(), 2));
		opGhmx.put("WZJE", BUHISUtil.getDouble(msGhxxReq.getWzje(), 2));
		String zjfy = body.get("ZJFY") + "";
		if ("null".equals(zjfy)) {
			zjfy = "0";
		}
		opGhmx.put("ZJFY", BUHISUtil.getDouble(msGhxxReq.getZjfy(), 2));
		if (body.containsKey("YSDM") && (body.get("YSDM") + "").length() > 0) {
			opGhmx.put("YSDM", body.get("YSDM"));
			if (!"1".equals(body.get("YYBZ") + "")) {
				Calendar startc = sdf.getCalendar();
				startc.set(Calendar.HOUR_OF_DAY, 0);
				startc.set(Calendar.MINUTE, 0);
				startc.set(Calendar.SECOND, 0);
				startc.set(Calendar.MILLISECOND, 0);
				Date ldtBegin = startc.getTime();
				startc.set(Calendar.HOUR_OF_DAY, 23);
				startc.set(Calendar.MINUTE, 59);
				startc.set(Calendar.SECOND, 59);
				startc.set(Calendar.MILLISECOND, 999);
				Date ldtEnd = startc.getTime();
				if (yytag == 2 || isInternet) {
					ldtBegin = sdf.parse(ghsj);
					ldtEnd = sdf.parse(ghsj);
				}
				parameters.put("YSDM", body.get("YSDM") + "");
				parameters.put("ldt_begin", ldtBegin);
				parameters.put("ldt_end", ldtEnd);
				parameters.put("ZBLB", opGhmx.get("GHLB").toString());
				parameters.put("GZRQ", DateUtil.date());

				Map<String, Object> mjzxh = opYspbDao.getJzxhIncrease(parameters);
				if (mjzxh != null) {
					int jzxh = Integer.valueOf(mjzxh.get("JZXH").toString()).intValue();
					jzxhqj = jzxh;
					opGhmx.put("JZXH", jzxh);
				} else {
					opGhmx.put("JZXH", 1);
					jzxhqj = 1;
				}
			} else {
				opGhmx.put("JZXH", 0);
				opGhmx.put("YYBZ", body.get("YYBZ"));
				opGhmx.put("YYXH", body.get("YYXH"));
			}
		} else {
			if (!"1".equals(body.get("YYBZ") + "")) {
				parameters.put("KSDM", Long.parseLong(body.get("KSDM") + ""));
				parameters.put("GHRQ", (new SimpleDateFormat("yyyy-MM-dd")).format(new SimpleDateFormat("yyyy-MM-dd").parse(body.get("GHRQ") + "")));
				parameters.put("ZBLB", opGhmx.get("GHLB").toString());

				Map<String, Object> mjzxh = opKspbDao.getJzxhIncrease(parameters);

				if (mjzxh != null) {
					int jzxh = Integer.valueOf(mjzxh.get("JZXH").toString()).intValue();
					jzxhqj = jzxh;
					opGhmx.put("JZXH", jzxh);
				} else {
					jzxhqj = 1;
					opGhmx.put("JZXH", 1);
				}
				parameters.remove("KSDM");
				parameters.remove("GHRQ");
				parameters.remove("ZBLB");
			} else {
				opGhmx.put("JZXH", 0);
				opGhmx.put("YYBZ", body.get("YYBZ"));
				opGhmx.put("YYXH", body.get("YYXH"));
			}
		}
		opGhmx.put("CZSJ", DateUtil.date().toTimestamp());
		opGhmx.put("JZKH", body.get("JZKH"));
		opGhmx.put("DQXH", 1L); // 1 未叫号 2 重叫号 0 已叫号
		Date d = new Date();
		opGhmx.put("PDHM", d.getTime());

		// -----
		// isDb=1, =999, =3

		if (map_body.get("isDb") != null) {
			opGhmx.put("DBBZ", map_body.get("isDb") + "");
		}

		if (map_body.get("dbybDbbm") != null) {
			opGhmx.put("DBBM", map_body.get("dbybDbbm") + "");
		}
		if (map_body.get("dbybDbxm") != null) {
			opGhmx.put("DBXM", map_body.get("dbybDbxm") + "");
		}

		if (null != body.get("GZDWMC")) {// 挂账单位名称
			opGhmx.put("GZDWMC", body.get("GZDWMC") + "");
		}
		// ------
		logger.info("oracle 挂号信息：" + opGhmx);
		// 判断是不是预约的病人调入，如果是预约的病人，关于排队的字段就用预约表的字段
		if ("1".equals(body.get("YYBZ") + "")) {
			Map<String, Object> paramsYycx = new HashMap<String, Object>(16);
			paramsYycx.put("YYXH", Long.valueOf(body.get("YYXH") + ""));
			Integer yyxh = Integer.valueOf(body.get("YYXH") + "");
			OpYygh opYygh = opYyghDao.getById(yyxh);
			Map<String, Object> temp = MzUtil.caseInsensitiveMap(opYygh);
			opGhmx.put("PDHM", Long.valueOf(temp.get("PDHM").toString()));
			opGhmx.put("JHHM", temp.get("JHHM").toString());
			opGhmx.put("PDXH", Long.valueOf(temp.get("PDXH").toString()));
			opGhmx.put("DDCS", Long.valueOf(temp.get("DDCS").toString()));
			opGhmx.put("ZSID", 0L);
		}

		// 门诊就诊流水号
		String jzlsh = sysDataCodeSer.getSysDataCode(1);
		opGhmx.put("jzlsh", jzlsh);

		// 查询该卡用户是否存在充值卡
		if (fkfsList.contains(FkfsEnum.CZK.getKey())) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("CARDNO", body.get("JZKH").toString());
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
					knyeMap.put("cardno", body.get("JZKH").toString());
					mpiKpxxDao.updateKnyeByBrid(knyeMap);
					// 保存充值卡操作记录数据(写入数据到OP_CZJL表)
					Map<String, Object> czjl = new HashMap<String, Object>(16);
					// 卡号
					czjl.put("CARDNO", body.get("JZKH").toString());
					// 操作类型 01发卡 02充值 03退费 04挂失 05解挂 06注销 07挂号付费 08门诊付费 09住院付费 10挂号退费 11挂号退费 12住院退费
					czjl.put("CZTYPE", "07");
					// 操作金额
					czjl.put("AMOUNT", ghjr);
					// 操作工号
					czjl.put("CZGH", req.getYgdm());
					// 操作IP
					czjl.put("CZIP", req.getIp());
					// 操作时间
					czjl.put("CZSJ", DateUtil.date().toTimestamp());
					// 病人ID
					czjl.put("BRID", MedicineUtils.parseLong(body.get("BRID")));
					czjl.put("CZFS", null);
					czjl.put("LASTKNYE", mpiKpxx.getKnye());
					czjl.put("FPHM", jzhm);
					czjl.put("JZLSH", jzlsh);
					OpCzjl opCzjl = BeanUtil.fillBeanWithMapIgnoreCase(czjl, new OpCzjl(), true);
					opCzjl.setCzxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CZJL));
					opCzjlDao.insert(opCzjl);
				}
			} else {
				throw BaseException.create("ERROR_REG_0073");
			}
		}

		// 插入挂号明细信息
		OpGhmx opghmx = BeanUtil.fillBeanWithMapIgnoreCase(opGhmx, new OpGhmx(), true);
		opghmx.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_GHMX));
		opGhmxDao.insert(opghmx);

		// 插入排队信息表
		OpZspdxx opZspdxx = new OpZspdxx();
		opZspdxx.setOid(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_ZSPDXX));
		opZspdxx.setCjsj(DateUtil.date().toTimestamp());
		opZspdxx.setJgid(req.getJgid());
		opZspdxx.setGhsj(opghmx.getGhsj());
		opZspdxx.setGhks(opghmx.getKsdm());
		opZspdxx.setGhys(opghmx.getYsdm() != null ? Integer.valueOf(opghmx.getYsdm().toString()) : 0);
		opZspdxx.setJzxh(opghmx.getSbxh());
		// op_ghmx中CZPB 初诊判别 | 1.初诊 0.非初诊
		// op_zspdxx中就诊标志 0-第一次,1-二次就诊,2-转诊 暂时非出诊置为1
		opZspdxx.setJzbz(opghmx.getCzpb().intValue() == 1 ? "0" : "1");
		if (opghmx.getJzzt().intValue() == 0) {
			opZspdxx.setJzzt("0");
		} else if (opghmx.getJzzt().intValue() == 1 || opghmx.getJzzt().intValue() == 2) {
			opZspdxx.setJzzt("1");
		} else if (opghmx.getJzzt().intValue() == 9) {
			opZspdxx.setJzzt("2");
		}
		opZspdxx.setBrid(opghmx.getBrid());
		opZspdxx.setJzlsh(opghmx.getJzlsh());
		MpiBrda pdxxBrda = mpiBrdaDao.getById(opghmx.getBrid());
		opZspdxx.setBrxm(pdxxBrda.getBrxm());
		opZspdxx.setBrkh(opghmx.getJzkh());
		opZspdxx.setCsrq(DateUtil.date(pdxxBrda.getCsny()).toSqlDate());
		opZspdxx.setXb(pdxxBrda.getBrxb() != null ? pdxxBrda.getBrxb().toString() : "0");
		opZspdxx.setSfxz(pdxxBrda.getBrxz() != null ? pdxxBrda.getBrxz().toString() : "");
		OpGhks ghks = opGhksDao.getById(opghmx.getKsdm());
		opZspdxx.setJhtdm(ghks.getFwtid() == null ? null : ghks.getFwtid().toString());
		opZspdxx.setSddm(req.getGhxx().getZblb());
		if ("1".equals(body.get("YYBZ") + "")) {
			// 预约时直接插入
			opZspdxx.setPdxh(opghmx.getPdxh());
		}

		//bjh 测试暂时注释
		opZspdxxService.insert(opZspdxx);

		Map<String, Object> sbxh = MzUtil.caseInsensitiveMap(opghmx);
//			if ("1".equals(StrUtil.null2Str(body.get("YYBZ")))) {
//				BsrunDaoUtils.execute("update OP_YYGH set GHBZ=1 where YYXH=?",body.get("YYXH"));
//			}
		sbxhqj = Long.parseLong(sbxh.get("SBXH") + "");
		if (BigDecimal.ZERO.compareTo(hbwc) != 0) {
			Map<String, Object> parameters2 = new HashMap<String, Object>(16);
			parameters2.put("HBWC", "1");
			parameters2.put("SYLX", 1);
			List<Map<String, Object>> fkfss = pubFkfsService.getPubFkfsInfo(parameters2);
			Long fkfs = Long.parseLong(fkfss.get(0).get("FKFS") + "");
			Map<String, Object> opGhFkxxMap = new HashMap<String, Object>(16);
			// OP_GH_FKXX.put("JGID", manaUnitId);
			opGhFkxxMap.put("SBXH", sbxh.get("SBXH"));
			opGhFkxxMap.put("FKFS", fkfs);
			opGhFkxxMap.put("FKJE", BUHISUtil.getDouble(hbwc, 2));
			OpGhFkxx opGhFkxx = BeanUtil.fillBeanWithMapIgnoreCase(opGhFkxxMap, new OpGhFkxx(), true);
			opGhFkxx.setJzlsh(opghmx.getJzlsh());
			opGhFkxx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_GH_FKXX));
			opGhFkxxDao.insert(opGhFkxx);
		}
		fkxxList.forEach(o -> {
			OpGhFkxx opGhFkxx = new OpGhFkxx();
			opGhFkxx.setSbxh(opghmx.getSbxh());
			opGhFkxx.setFkfs(o.getFkfs());
			opGhFkxx.setFkje(o.getFkje());
			opGhFkxx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_GH_FKXX));
			opGhFkxx.setJzlsh(opghmx.getJzlsh());
			opGhFkxxDao.insert(opGhFkxx);
		});
		if (opGhmx.containsKey("YSDM") && body.get("YSDM") != null && !"0".equals(body.get("YSDM") + "")) {
			if ("1".equals(body.get("YYBZ") + "")) {
				Calendar startc = sdf.getCalendar();
				startc.set(Calendar.HOUR_OF_DAY, 0);
				startc.set(Calendar.MINUTE, 0);
				startc.set(Calendar.SECOND, 0);
				startc.set(Calendar.MILLISECOND, 0);
				Date ldtBegin = startc.getTime();
				startc.set(Calendar.HOUR_OF_DAY, 23);
				startc.set(Calendar.MINUTE, 59);
				startc.set(Calendar.SECOND, 59);
				startc.set(Calendar.MILLISECOND, 999);
				Date ldtEnd = startc.getTime();
				parameters.put("ZBLB", Integer.parseInt(body.get("ZBLB") + ""));
				if (yytag == 2 || isInternet) {
					ldtBegin = sdf.parse(ghsj);
					ldtEnd = sdf.parse(ghsj);
					parameters.put("ZBLB", Integer.parseInt(body.get("GHLB") + ""));
				}
				parameters.put("YSDM", body.get("YSDM") + "");
				parameters.put("ldt_begin", ldtBegin);
				parameters.put("ldt_end", ldtEnd);
				parameters.put("KSDM", Long.parseLong(body.get("KSDM") + ""));
				opYspbDao.updateYgrs(parameters);
			} else {
				opYspbDao.updateYgrsAndJzxh(parameters);
			}
			// dao.doUpdate("update OP_YSPB set YYRS=1,JZXH=1", null);
			parameters.clear();
		}
		parameters.put("JGID", req.getJgid());
		parameters.put("KSDM", Long.parseLong(body.get("KSDM") + ""));
		if ("1".equals(body.get("YYBZ") + "")) {
			opGhksDao.updateYgrsAndYyrs(parameters);
			/**
			 * modified by gaof 2014-1-3 修正挂号后OP_KSPB记录增加错误，增加约束条件日期和上下午判别
			 */
			parameters.put("GHRQ", (new SimpleDateFormat("yyyy-MM-dd"))
					.format(new SimpleDateFormat("yyyy-MM-dd").parse(body.get("GHRQ") + "")));
			parameters.put("ZBLB", Integer.parseInt(body.get("ZBLB") + ""));
			opKspbDao.updateYgrsAndJzxh(parameters);
			/**
			 * modified by gaof 2014-1-3 end
			 */
			Map<String, Object> opYyghParameters = new HashMap<String, Object>(16);
			opYyghParameters.put("YYXH", Long.parseLong(body.get("YYXH") + ""));
			opYyghParameters.put("GHBZ", 0);
			opYyghDao.updateGhbzAndSfqh(opYyghParameters);
		} else {
			if (yytag == 2) {
				Map<String, Object> yyghMap = new HashMap<String, Object>(16);
				yyghMap.put("JGID", req.getJgid());
				yyghMap.put("YYMM", "0");
				yyghMap.put("BRID", Long.parseLong(body.get("BRID") + ""));
				yyghMap.put("GHRQ", sdf.parse(sdf.format(new Date())));
				yyghMap.put("KSDM", Long.parseLong(body.get("KSDM") + ""));
				yyghMap.put("ZBLB", Integer.parseInt(body.get("GHLB") + ""));
				if (opGhmx.containsKey("YSDM") && (body.get("YSDM") + "").length() > 0
						&& !"0".equals(body.get("YSDM") + "")) {
					yyghMap.put("YSDM", body.get("YSDM") + "");
				}
				yyghMap.put("YYLB", 1);
				yyghMap.put("GHBZ", 1);
				yyghMap.put("YYRQ", sdf.parse(ghsj));
				yyghMap.put("JZXH", jzxhqj);
				yyghMap.put("SBXH", sbxhqj);
				yyghMap.put("ZCID", 0L);

				OpYygh opYygh = BeanUtil.fillBeanWithMapIgnoreCase(yyghMap, new OpYygh(), true);
				opYygh.setYyxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YYGH));
				opYyghDao.insert(opYygh);
			} else {
				opGhksDao.updateYgrsAndJzxh(parameters);
			}

			/**
			 * modified by gaof 2014-1-3 修正挂号后OP_KSPB记录增加错误，增加约束条件日期和上下午判别
			 */
//				parameters.put("GHRQ", Integer.parseInt(body.get("GHRQ") + ""));
			parameters.put("GHRQ", (new SimpleDateFormat("yyyy-MM-dd"))
					.format(new SimpleDateFormat("yyyy-MM-dd").parse(body.get("GHRQ") + "")));
			if (yytag == 2) {
				parameters.put("ZBLB", Integer.parseInt(body.get("GHLB") + ""));
			} else {
				parameters.put("ZBLB", Integer.parseInt(body.get("ZBLB") + ""));
			}
			opKspbDao.updateYgrsAndJzxh(parameters);
			/**
			 * modified by gaof 2014-1-3 end
			 */
		}
		// 更新就诊号码
		// modify by yangl 闵行特殊需求,挂号就诊号码取发票号码
		if(msGhxxReq.getSfmf() == 0) {
			getNotesNumber(req.getYgdm(), req.getJgid(), OpPjlxEnum.FPHM.getKey());
		}

		// ******************排队叫号 start********************//
		if ("1".equals(body.get("YYBZ") + "")) {
			// 预约的病人直接在上面就取预约里面的字段了
		} else {
			Map<String, Object> m = new HashMap<String, Object>(16);
			m.put("SBXH", sbxh.get("SBXH"));
			m.put("KSDM", body.get("KSDM"));
			m.put("ZSID", body.get("ZSID"));
			m.put("JGID", req.getJgid());
			m.put("OID", opZspdxx.getOid());
			if(isInternet){
				m.put("YWLX", 12);
				m.put("GHRQ", body.get("GHSJ"));
				m.put("GHSJ", req.getGhsj());
			}
			//bjh 测试暂时注释
			this.doSetQueue(m);
		}
		// ******************排队叫号 end********************//

//		if (req.getYbxx() != null) {
//			YbGhjs ybGhjs = new YbGhjs();
//			BeanUtils.copyProperties(req.getYbxx(), ybGhjs);
//			ybGhjs.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.YB_GHJS));
//			ybGhjsDao.insert(ybGhjs);
//		}
		if ((!"false".equals(ghyj)) && (!"null".equals(ghyj))) {
			Map<String, Object> ghyjParameters = new HashMap<String, Object>(16);
			ghyjParameters.put("YJXH", Long.parseLong(ghyj));
			ghyjParameters.put("ghbz", 1);
			opGhyjDao.updateMsGhbz(ghyjParameters);
		}
//		// 预付卡支付保存
//		if (fkfsList.contains(FkfsEnum.YFK.getKey())) {
//			doSaveYykjkInfo(body.get("JZKH").toString(), String.valueOf(xjje), "07", jzhm, req.getYgdm(), req.getIp());
//		}

		// 上海五期医保挂号结算
		Map<String, Object> map_ybksdm = dicKszdOutSer.getYbksdm((Integer) body.get("KSDM"));
		String ybksdm =(Objects.isNull(map_ybksdm) || map_ybksdm.isEmpty()) ? "03" : map_ybksdm.get("ybks") + "";
		String YBSYPB = sysXtcsCacheSer.getCsz(req.getJgid(), "YBSYPB");
		if (req.getIsYb().intValue() == 1  && "0".equals(YBSYPB)) {
			String yllb = ybxx.get("yllb").toString();
//			if ("1".equals(yllb)) {
//				yllb = "S12";
//			} else if ("1".equals(req.getIsDb())) {
//				yllb = "S13";
//			} else {
//				yllb = "S11";
//			}
			String orgid = "";
			Map map_orgid = opMzlbDao.getYbjgdm(req.getJgid(), req.getIp());
			if (map_orgid != null && !map_orgid.isEmpty()) {
				orgid = map_orgid.get("ybjgid").toString();
			} else {
				throw BaseException.create("ERROR_SHYB_0015");
			}
			Map<String, Object> args = new HashMap<String, Object>();
			args.put("xxlxm", "SH02");
			args.put("cardtype", body.get("cardtype"));
			if("3".equals(body.get("cardtype"))){
				args.put("carddata", body.get("cardid"));
			}else{
				args.put("carddata", body.get("cardid"));
			}
			args.put("deptid", ybksdm);
			args.put("zlxmdm", "");
			args.put("personspectag", ybxx.get("accountattr").toString().substring(3, 4));
			args.put("yllb", yllb);
			args.put("persontype", "0");
			if("1".equals(body.get("isDb"))){
				args.put("dbtype", body.get("dbtype"));
			}else{
				args.put("dbtype", "");
			}
			if("1".equals(body.get("isGs"))){
				args.put("persontype", "1");
				args.put("gsrdh", body.get("gsrdh"));
			}else{
				args.put("gsrdh", "");
			}
			args.put("totalexpense", ybxx.get("totalexpense"));
			args.put("ybjsfwfyze", ybxx.get("ybjsfwfyze"));
			args.put("fybjsfwfyze", ybxx.get("fybjsfwfyze"));
			args.put("zhenlf", ybxx.get("zlf"));
			args.put("ghf", ybxx.get("ghf"));
			args.put("jmbz", ybxx.get("jmjsbz"));
			args.put("xsywlx", "");
			args.put("jgid", req.getJgid());
			args.put("orgid",orgid);
			args.put("jssqxh", ybxx.get("jssqxh"));
			args.put("ip", req.getIp());
			args.put("ygdm",req.getYgdm());
			args.put("ygxm",req.getYgxm());
			SettleResultDTO sh02res  = offLineSettle.registerOp(args);
//			Map regisMap = (Map) res.get("data");
//			int code = Integer.parseInt(regisMap.get("code") + "");
//			String msg = regisMap.get("msg") + "";
//			String ret = "";
			if (sh02res.getCode()== 200) {// 医保成功
				String jsonData = sh02res.getData().toString();
				Map<String, Object> tmpMap = JackJsonUtil.parse(jsonData, Map.class);
				Map<String, Object> xxtMap = (Map<String, Object>)tmpMap.get("xxnr");
				if (!"".equals(xxtMap.get("lsh")) && !"".equals(xxtMap.get("jzdyh"))) {
					SimpleDateFormat fmFrom = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					SimpleDateFormat fmTo = new SimpleDateFormat("yyyyMMdd/HHmmss/");
					xxtMap.put("jysj", fmTo.format(fmFrom.parse(tmpMap.get("jysj").toString())));
					xxtMap.put("jgdm", tmpMap.get("jgdm"));
					xxtMap.put("ksdm", args.get("deptid"));
					xxtMap.put("zt", "1");
					xxtMap.put("zfpb", "0");
					xxtMap.put("persontype", args.get("persontype"));
					xxtMap.put("gsrdh", args.get("gsrdh"));
					xxtMap.put("dbbz", args.get("dbtype"));
					xxtMap.put("ghxh", sbxh.get("SBXH"));
					if (xxtMap.containsKey("qfdzhzfs")) {
						xxtMap.put("jmjsbz", "0");
						xxtMap.put("jlc", "0");
					}
					shybSh01Service.insertShybsh02(xxtMap);
				}
			} else {
				// Ext.Msg.alert("医保错误,本地撤销挂号！", ret.msg);
//				String ssbxh = sbxh.get("SBXH")+"";
//				long l = opGhmxDao.getGhjl(ssbxh);
//				if(l>0){
//					opGhmxDao.insertShybbf(opghmx);
//					opGhFkxxDao.deleteBySbxh(ssbxh);
//					opGhmxDao.deleteBySbxh(ssbxh);
//					if(!"".equals(parameters.get("JGID"))&&!"".equals(parameters.get("KSDM"))
//							&&!"".equals(parameters.get("KSDM"))&&!"".equals(parameters.get("ZBLB"))){
//						opGhksDao.lessYgrsAndJzxh(parameters);
//						opKspbDao.lessYgrsAndJzxh(parameters);
//						CancelNotesNumber(req.getJgid(),req.getYgdm(),2);
//					}
//				}
				throw BaseException.create("ERROR_SHYB_0020",
						new String[] { sh02res.getCode() + "", sh02res.getMsg() + "" });
			}
		}
		// 上海五期医保结束

		// 保存pos机交易记录
//		Map<String, Object> pos = (Map<String, Object>) map_body.get("pos");
//
//		if (("3".equals(body.get("FKFS")) || "12".equals(body.get("FKFS")) || "18".equals(body.get("FKFS")))
//				&& pos != null) {// 新填微信支付宝
//			Map<String, Object> posInfo = phis.source.utils.MapUtils.upcaseKeys(pos);
//			posInfo.put("JYSJ", new Date());
//			posInfo.put("JYLB", pos.get("TransType"));
//			posInfo.put("FPHM", jzhm);
//			dao.doSave("create", "phis.application.pos.schemas.OP_POSMX", posInfo, false);
//		}
		// 医保结算
//		if (req.getIsYb() != null && "1".equals(req.getIsYb().toString())) {
//			String zxlsh = req.getZxlsh().toString();
//			Map<String, Object> map = new HashMap<String, Object>(16);
//			map.put("sbxhqj", sbxhqj);
//			map.put("zxlsh", zxlsh);
//			ybSh04Dao.updateGhxh(map);
//		}
		// 农合挂号结算
//		if (map_body.containsKey("isNh") && "1".equals(map_body.get("isNh") + "")) {
//			NHCommonService nhs = new NHCommonService();
//			Result result = nhs.doNhGhjs(req, ctx, jzhm);
//			if (!"1".equals(result.getCode())) {
//				throw new ModelDataOperationException(ServiceCode.CODE_DATABASE_ERROR, "农合结算失败！" + result.getMsg());
//			} else {
//				String nhyydm = ParameterUtil.getParameter(user.getManageUnitId(), "NHYYBH", "12111301", "农合医院编号", ctx);
//				String bxje = map_body.get("bxje") + "";
//				String djid = map_body.get("djid") + "";
//				String bxid = result.getBxid();
//				String bxrq = result.getBxrq();
//				dao.doSqlUpdate(
//						"UPDATE OP_GHMX T SET T.bxje = '" + bxje + "', t.ghid = " + djid + ",t.nhbh = " + nhyydm
//								+ ",t.nhbxid = " + bxid + ",t.nhbxrq = '" + bxrq + "' WHERE t.sbxh = '" + sbxhqj + "'",
//						null);
//			}
//		}
		// 支付宝交易
//		Map<String, Object> alipay = (Map<String, Object>) map_body.get("alipay");
//		if ("12".equals(body.get("FKFS")) && "1".equals(alipay.get("success"))) {
//			this.doAlipayTradePay(Param.instance().put("totalAmount", StrUtil.null2Str(alipay.get("totalAmount")))
//					.put("zfbnum", StrUtil.null2Str(alipay.get("zfbnum"))).put("fphm", jzhm), res, ctx);
//		}
		// 如果非商保病人
//		Map<String, Object> map_brxz = dao.doLoad(BSPHISEntryNames.PUB_BRXZ, body.get("BRXZ") + "");
//		if (!(Constants.BRXZ_SYBX + "").equals(body.get("BRXZ") + "")) {
//
//			/***************************************************/
//
//			String ZZS_fkfs = "select FKFS as FKFS,FKMC as FKMC  from PUB_FKFS where  SYLX=1 AND  FKFS =  '"
//					+ body.get("FKFS") + "'";
//
//			List<Map<String, Object>> fkfslist = dao.doSqlQuery(ZZS_fkfs, null);
//			String ZZS_brxzsql = "SELECT t.sjxz as SJXZ FROM PUB_BRXZ t where brxz = '" + body.get("BRXZ") + "'";
//
//			List<Map<String, Object>> sjxzList = dao.doSqlQuery(ZZS_brxzsql, null);
//			String SJXZ = sjxzList.get(0).get("SJXZ") + "";
//			if ("1000".equals(SJXZ)) {
//
//			}
//
//			// 取税号和发票机号
//			String machinetaxnr = "";
//			String machinenr = "";
//			PublicService publicService = new PublicService();
//			Map<String, Object> Pamargs = publicService
//					.doLoadThisComputerArgs(Param.instance().put("names", "MACHINETAXNR,MACHINENR"), res, dao, ctx);
//			machinetaxnr = StrUtil.null2Str(Pamargs.get("MACHINETAXNR"));
//			machinenr = StrUtil.null2Str(Pamargs.get("MACHINENR"));
//
//			String ZZS_BRXB = "男";
//			if ("1".equals(StrUtil.null2Str(map_brxz.get("XZMC")))) {
//				ZZS_BRXB = "男";
//			} else if ("2".equals(StrUtil.null2Str(map_brxz.get("XZMC")))) {
//				ZZS_BRXB = "女";
//			}
//			String ZZS_KSMC = "";
//			String ZZS_JHHM = "";
//			String ZZS_JLCH = "";
//			String ZZS_MZHM = "";
//			String ZZS_JZHM = "";
//			String ZZS_BZ2 = "";
//			String ZZS_GHSQL = "select b.KSMC as KSMC,a.JHHM as JHHM ,a.JLCH as JLCH ,c.MZHM as MZHM ,a.JZHM as JZHM ,"
//					+ "decode(a.XJJE,0,'0.00',(to_char(round(a.XJJE,2),'fm99999999999999.00'))) as XJJE," +
//
//					"decode(a.JMJE,0,'0.00',(to_char(round(a.JMJE,2),'fm99999999999999.00'))) as JMJE "
//					+ "from OP_GHMX a,OP_GHKS b ,MPI_BRDA c where a.ksdm = b.ksdm  and a.brid = c.brid  AND a.sbxh = "
//					+ sbxhqj;
//			List<Map<String, Object>> ZZS_GH_LIST = dao.doSqlQuery(ZZS_GHSQL, null);
//			if (ZZS_GH_LIST.size() > 0) {
//				Map<String, Object> ZZS_GH = ZZS_GH_LIST.get(0);
//				ZZS_KSMC = "门诊:" + ZZS_GH.get("KSMC") + "";
//				ZZS_JHHM = "序号:" + ZZS_GH.get("JHHM") + "";
//				if (!"".equals(ZZS_GH.get("JLCH") + "") && !"null".equals(ZZS_GH.get("JLCH") + "")) {
//					ZZS_JLCH = "记录册号:" + ZZS_GH.get("JLCH") + "";
//				}
//
//				if (!"".equals(ZZS_GH.get("MZHM") + "") && !"null".equals(ZZS_GH.get("MZHM") + "")) {
//					ZZS_MZHM = "门诊号:" + ZZS_GH.get("MZHM") + "";
//				}
//
//				ZZS_JZHM = "单据号:" + ZZS_GH.get("JZHM") + "";
//
//				if ("1000".equals(SJXZ)) {
//					ZZS_BZ2 += "" + fkfslist.get(0).get("FKMC") + ":" + ZZS_GH.get("XJJE") + "元";
//				}
//				if (!"0.00".equals(ZZS_GH.get("JMJE") + "")) {
//					ZZS_BZ2 += "减免:" + ZZS_GH.get("JMJE") + "元";
//				}
//
//			}
//
//			/************************************************/
//
//			// 保存一条记录到表Tbl_Cust_DocMaster
//			Map<String, Object> invoiceInfo = new HashMap<String, Object>(16);
//			invoiceInfo.put("InvKind", 2);// 发票类型 0：增值税专用发票，2：增值税普通发票
//			invoiceInfo.put("DocumentNr", jzhm);// 单据号
//			invoiceInfo.put("DocumentDate", new Date());// 单据日期
//			invoiceInfo.put("CustomerName", StrUtil.null2Str(body.get("BRXM")) + "     "
//					+ StrUtil.null2Str(map_brxz.get("XZMC")) + "     卡号: " + StrUtil.null2Str(body.get("JZKH")));// 客户名称
//			// invoiceInfo.put("CustomerName", StrUtil.null2Str(body.get("BRXM"))+" "
//			// +StrUtil.null2Str( map_brxz.get("XZMC")) +" "+ ZZS_MZHM );//客户名称
//
//			invoiceInfo.put("CustomerTaxNr", "");// 客户税号
//			// invoiceInfo.put("CustomerAddressTel", "");//客户地址电话
//			invoiceInfo.put("CustomerAddressTel", ZZS_KSMC + "  " + ZZS_JHHM + " " + ZZS_JLCH);// 客户地址电话
//
//			// invoiceInfo.put("CustomerBankAccountNr", "");//客户银行帐号
//			invoiceInfo.put("CustomerBankAccountNr", ZZS_JZHM);// 客户银行帐号
//			invoiceInfo.put("Invoicer", "");// 开票人
//			invoiceInfo.put("Checker", "");// 复核人
//			invoiceInfo.put("Payee",
//					DictionaryController.instance().get("phis.dictionary.doctor").getText(userId + ""));// 收款人
//			invoiceInfo.put("ProductName", "诊查费(自费)");// 商品名称
//			invoiceInfo.put("ProductUnit", "");// 商品计量单位
//			invoiceInfo.put("ProductQuantity", 1.0);// 商品数量
//			invoiceInfo.put("ProductValue", Double.parseDouble(body.get("GHJE").toString()));// 商品价格
//			invoiceInfo.put("TaxRate", 0);// 税率
//			invoiceInfo.put("ProductTax", 0);// 商品税额
//			invoiceInfo.put("DiscountValue", 0);// 折扣金额
//			invoiceInfo.put("DiscountTax", 0);// 折扣税额
//			invoiceInfo.put("MachineNr", "");// 开票机号
//			invoiceInfo.put("TaxItem", "");// 明细税目
//			invoiceInfo.put("GoodsNoVer", "30.0");// 编码版本号
//			invoiceInfo.put("GoodsTaxNo", "3070202");// 税收分类编码
//			invoiceInfo.put("TaxPre", "1");// 是否享受优惠政策
//			invoiceInfo.put("TaxPreCon", "免税");// 享受税收优惠政策内容
//			invoiceInfo.put("ZeroTax", "1");// 零税率标识
//			invoiceInfo.put("TaxDeduction", 0);// 扣除额
//			invoiceInfo.put("AlternateKey", "");// 备用关键字
//
//			invoiceInfo.put("ZZSBZXX", ZZS_BZ2);// 备用关键字2
//
//			Map<String, Object> invoiceInfoZLF = new HashMap<String, Object>(16);
//			invoiceInfoZLF.put("InvKind", 2);// 发票类型 0：增值税专用发票，2：增值税普通发票
//			invoiceInfoZLF.put("DocumentNr", jzhm);// 单据号
//			invoiceInfoZLF.put("DocumentDate", new Date());// 单据日期
//			invoiceInfoZLF.put("CustomerName", StrUtil.null2Str(body.get("BRXM")) + "     "
//					+ StrUtil.null2Str(map_brxz.get("XZMC")) + "     卡号: " + StrUtil.null2Str(body.get("JZKH")));// 客户名称
//			// invoiceInfoZLF.put("CustomerName", StrUtil.null2Str(body.get("BRXM"))+" "
//			// +StrUtil.null2Str( map_brxz.get("XZMC")) +" "+ ZZS_MZHM );//客户名称
//			invoiceInfoZLF.put("CustomerTaxNr", "");// 客户税号
//			// invoiceInfoZLF.put("CustomerAddressTel", "");//客户地址电话
//			invoiceInfoZLF.put("CustomerAddressTel", ZZS_KSMC + "  " + ZZS_JHHM + " " + ZZS_JLCH);// 客户地址电话
//			// invoiceInfoZLF.put("CustomerBankAccountNr", "");//客户银行帐号
//			invoiceInfoZLF.put("CustomerBankAccountNr", ZZS_JZHM);// 客户银行帐号
//			invoiceInfoZLF.put("Invoicer", "");// 开票人
//			invoiceInfoZLF.put("Checker", "");// 复核人
//			invoiceInfoZLF.put("Payee",
//					DictionaryController.instance().get("phis.dictionary.doctor").getText(userId + ""));// 收款人
//			invoiceInfoZLF.put("ProductName", "诊查费");// 商品名称
//			invoiceInfoZLF.put("ProductUnit", "");// 商品计量单位
//			invoiceInfoZLF.put("ProductQuantity", 1.0);// 商品数量
//			invoiceInfoZLF.put("ProductValue", Double.parseDouble(body.get("ZLJE").toString()));// 商品价格
//			invoiceInfoZLF.put("TaxRate", 0);// 税率
//			invoiceInfoZLF.put("ProductTax", 0);// 商品税额
//			invoiceInfoZLF.put("DiscountValue", 0);// 折扣金额
//			invoiceInfoZLF.put("DiscountTax", 0);// 折扣税额
//			invoiceInfoZLF.put("MachineNr", "");// 开票机号
//			invoiceInfoZLF.put("TaxItem", "");// 明细税目
//			invoiceInfoZLF.put("GoodsNoVer", "30.0");// 编码版本号
//			invoiceInfoZLF.put("GoodsTaxNo", "3070202");// 税收分类编码
//			invoiceInfoZLF.put("TaxPre", "1");// 是否享受优惠政策
//			invoiceInfoZLF.put("TaxPreCon", "免税");// 享受税收优惠政策内容
//			invoiceInfoZLF.put("ZeroTax", "1");// 零税率标识
//			invoiceInfoZLF.put("TaxDeduction", 0);// 扣除额
//			invoiceInfoZLF.put("AlternateKey", "");// 备用关键字
//
//			invoiceInfoZLF.put("ZZSBZXX", ZZS_BZ2);// 备用关键字2
//
//			// 如果是医保病人，需要把医保的信息 存放到备注信息中
//			/*
//			 * StringBuffer AlternateKeySql=new StringBuffer(); Map<String, Object> map_par
//			 * = new HashMap<String, Object>(16); map_par.put("GHXH", sbxhqj); //
//			 * AlternateKeySql.
//			 * append("select  '中心流水号:'||sh04.ZXLSH||',现金支付:'||sh04.FYBJSFWGRZF||'账户支付:'||sh04.DNZHZFS||',统筹支付:'||sh04.TCZFS||'(现金支付中,'||sh04.FJDXJZFS||'不属于医保保险范围)'||'当年账户余额:'||sh04.DNZHYE||'元'||'历年账户余额:'||sh04.LNZHYE||'元'   AS  AlternateKey ,brxz.SJXZ  as SJXZ  FROM  yb_sh04  sh04,OP_GHMX ghmx,PUB_BRXZ brxz   WHERE   sh04.GHXH= ghmx.SBXH    and sh04.ZFPB = 0 and  brxz.BRXZ = ghmx.BRXZ  and sh04.GHXH  = "
//			 * +sbxhqj); AlternateKeySql.
//			 * append("select sh04.ZXLSH as ZXLSH,sh04.FYBJSFWGRZF as FYBJSFWGRZF,sh04.DNZHZFS as DNZHZFS,sh04.TCZFS as TCZFS,sh04.FJDXJZFS as FJDXJZFS,sh04.DNZHYE as DNZHYE, sh04.LNZHYE as LNZHYE,brxz.SJXZ  as SJXZ  FROM  yb_sh04  sh04,OP_GHMX ghmx,PUB_BRXZ brxz   WHERE   sh04.GHXH= ghmx.SBXH    and sh04.ZFPB = 0 and  brxz.BRXZ = ghmx.BRXZ  and sh04.GHXH  = :GHXH"
//			 * ); List<Map<String, Object>> list =
//			 * dao.doSqlQuery(AlternateKeySql.toString(),map_par); if(list.size()!=0){
//			 * if((list.get(0).get("XJXZ")!=null)&&(list.get(0).get("XJXZ").toString().
//			 * equals("6021"))){
//			 * invoiceInfo.put("AlternateKey",list.get(0).get("AlternateKey") ); } }
//			 */
//
//			/*	*//*************************************************/
//			/*
//			 * StringBuffer AlternateKeySql=new StringBuffer(); Map<String, Object> map_par
//			 * = new HashMap<String, Object>(16); map_par.put("GHXH", sbxhqj);
//			 * AlternateKeySql.
//			 * append("select sh04.ZXLSH as ZXLSH,sh04.FYBJSFWGRZF as FYBJSFWGRZF,sh04.DNZHZFS as DNZHZFS,sh04.TCZFS as TCZFS,sh04.FJDXJZFS as FJDXJZFS,sh04.DNZHYE as DNZHYE, sh04.LNZHYE as LNZHYE,brxz.SJXZ  as SJXZ  FROM  yb_sh04  sh04,OP_GHMX ghmx,PUB_BRXZ brxz   WHERE   sh04.GHXH= ghmx.SBXH    and sh04.ZFPB = 0 and  brxz.BRXZ = ghmx.BRXZ  and sh04.GHXH  = :GHXH"
//			 * ); List<Map<String, Object>> list =
//			 * dao.doSqlQuery(AlternateKeySql.toString(),map_par); if(list.size()!=0){
//			 * if((list.get(0).get("XJXZ")!=null)&&(list.get(0).get("XJXZ").toString().
//			 * equals("6021"))){
//			 * invoiceInfo.put("AlternateKey",list.get(0).get("AlternateKey") ); } }
//			 *
//			 *
//			 *//*************************************************/
//
//			StringBuffer invoiceSql = new StringBuffer();
//			invoiceSql.append(
//					"insert into Tbl_Cust_DocMaster (InvKind,DocumentNr,DocumentDate,CustomerName,CustomerTaxNr,CustomerAddressTel,CustomerBankAccountNr,Invoicer,Checker,Payee,ProductName,ProductUnit,");
//			invoiceSql.append(
//					"ProductQuantity,ProductValue,ProductAmount,TaxRate,ProductTax,DiscountValue,DiscountTax,MachineNr,TaxItem,GoodsNoVer,GoodsTaxNo,TaxPre,TaxPreCon,ZeroTax,TaxDeduction,AlternateKey");
//
//			invoiceSql.append(",ZZSBZXX");// ---------------
//			invoiceSql.append(")");
//			invoiceSql.append(" values (");
//			invoiceSql.append(
//					":InvKind,:DocumentNr,:DocumentDate,:CustomerName,:CustomerTaxNr,:CustomerAddressTel,:CustomerBankAccountNr,:Invoicer,:Checker,:Payee,:ProductName,:ProductUnit,");
//			invoiceSql.append(
//					":ProductQuantity,:ProductValue,:ProductValue,:TaxRate,:ProductTax,:DiscountValue,:DiscountTax,:MachineNr,:TaxItem,:GoodsNoVer,:GoodsTaxNo,:TaxPre,:TaxPreCon,:ZeroTax,:TaxDeduction,:AlternateKey");
//
//			invoiceSql.append(",:ZZSBZXX");// ---------------
//			invoiceSql.append(")");
//			// dao.doSqlUpdate(invoiceSql.toString(), invoiceInfo);
//			// dao.doSqlUpdate(invoiceSql.toString(), invoiceInfoZLF);
//
//			if (0.0 != Double.parseDouble(invoiceInfo.get("ProductValue") + "")) {
//				dao.doSqlUpdate(invoiceSql.toString(), invoiceInfo);
//			}
//			if (0.0 != Double.parseDouble(invoiceInfoZLF.get("ProductValue") + "")) {
//				dao.doSqlUpdate(invoiceSql.toString(), invoiceInfoZLF);
//			}
//		}

		// 如果是特需门诊 指定通知医生 TODO
//		String txmz = req.getGHXX().getTxmz()!= null?req.getGHXX().getTxmz().toString():"";
//		if (txmz.equals("1")) {
//			sendAdviceChangeMessage(OP_GHMX.get("BRXM"), OP_GHMX.get("YSDM"));
//		}

		// 返回值
		MsRegisterResp resp = new MsRegisterResp();
		resp.setSbxh(opghmx.getSbxh());
		resp.setJzhm(jzhm);
		// 获取生日
		OpGhmxInfo opGhmxInfo = new OpGhmxInfo();
		opGhmxInfo.setBrid(opghmx.getBrid());
		MpiBrda mpiBrda = mpiBrdaDao.getByCondition(opGhmxInfo);
		resp.setCsny(DateUtil.date(mpiBrda.getCsny()).toSqlDate());

		// 更新分诊调入状态
		if (req.getGhxx().getLsh() != null) {
			erPreYjfzDao.doProcessDrzt(req.getGhxx().getLsh());
		}
		return resp;
	}

	/**
	 * 生排队序号
	 *
	 * @param body
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doSetQueue(Map<String, Object> body) {
		// 业务类型(1：窗口挂号, 2：自助机挂号, 3 : 服务台预约, 4:自助机预约, 5: 网上预约, 12: 互联网挂号)
		int ywlx = body.get("YWLX") == null ? 1 : Integer.valueOf(body.get("YWLX").toString());
		String ghmxTab = "";
		long yyxh = 0;
		String yyrq = "";
		if (ywlx == 3 || ywlx == 4 || ywlx == 5 || ywlx == 6 || ywlx == 7) {
			ghmxTab = "DIY_GHMX_ZZGH";
		} else if (ywlx == 11) {
			ghmxTab = "OP_YYGH";
			yyxh = body.get("YYXH") == null ? 0 : Integer.valueOf(body.get("YYXH").toString());
		} else {
			ghmxTab = "OP_GHMX";
		}
		String sbxh = String.valueOf(body.get("SBXH")); // 识别序号
		String ksdm = String.valueOf(body.get("KSDM")); // 科室代码

//		int ZSID = NumUtil.toInt(body.get("ZSID"),0);  //诊室ID
		int zsid = 0; // 诊室ID
		String sqjhsj = sysXtcsCacheSer.getCsz(Integer.valueOf(body.get("JGID").toString()), "SQJHSJ");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String today = "";
		Date d = new Date();
		String now = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(d);
		if (ywlx == 11) {
			today = body.get("YYRQ").toString();
		} else if(ywlx == 12){
			today = body.get("GHRQ").toString();
			yyrq = today;
			now = body.get("GHSJ").toString();
		} else {
//			today = df.format(new Date()) + " " + sqjhsj;
			today = df.format(new Date());
			yyrq = df.format(new Date());
		}

		Map<String, Object> params = new HashMap<String, Object>(16);
		if (ywlx == 11) { // 只有预约的时候会执行
			params.put("today", today);
			params.put("KSDM", ksdm);
			params.put("ZSID", zsid);
			params.put("YYXH", yyxh);
			// 获取排队序号
			Integer pdxh = opGhmxDao.getMaxPdxh(params);
			// 获取等待次数
			Integer ddcs = opYyghDao.getDdcs(params);
			Map<String, Object> map = new HashMap<String, Object>(16);
			map.put("pdxh", pdxh);
			map.put("ddcs", ddcs);
			map.put("zsid", zsid);
			map.put("jhhm", pdxh);
			map.put("now", now);
			map.put("YYXH", yyxh);
			opYyghDao.updateYyghInfo(map);
		} else {
			params.put("today", today);
			params.put("KSDM", ksdm);
			params.put("ZSID", zsid);
			params.put("SBXH", sbxh);
			params.put("YYRQ", yyrq);

			// 获取排队序号
			Integer pdxh = opGhmxDao.getMaxPdxh(params);
			// 获取等待次数和
			Integer ddcs = opGhmxDao.getSumDdcs(params);
			Map<String, Object> map = new HashMap<String, Object>(16);
			map.put("pdxh", pdxh);
			map.put("ddcs", ddcs);
			map.put("zsid", zsid);
			map.put("jhhm", pdxh);
			map.put("now", now);
			map.put("sbxh", sbxh);

			if (ywlx == 3 || ywlx == 4 || ywlx == 5 || ywlx == 6 || ywlx == 7) {
				opGhmxZzghDao.updateGhmxZzghInfo(map);
			} else {
				opGhmxDao.updateGhmxInfo(map);
				if (body.get("OID") != null) {
					Integer oid = Integer.valueOf(body.get("OID").toString()); // 排队信息主键
					map.put("oid", oid);
					opZspdxxService.updatePdxhByOid(map);
				}
			}
		}
	}

	/**
	 * 预付卡记录存储
	 *
	 * @param jzkh
	 * @param ysk
	 * @param cztype
	 * @param fphm
	 * @param userId
	 * @param ip
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doSaveYykjkInfo(String jzkh, String ysk, String cztype, String fphm, Integer userId, String ip) {
		Map<String, Object> map = new HashMap<String, Object>(16);
		map.put("cardno", jzkh);
		map.put("status", 0);
		List<Map<String, Object>> list = mpiKpxxDao.getMpiKpxxByCardNo(map);
		if (list.size() == 0) {
			throw BaseException.create("ERROR_REG_0021");
		}
		BigDecimal knye = list.get(0).get("KNYE") != null ? new BigDecimal(list.get(0).get("KNYE").toString())
				: new BigDecimal("0.00");

		Map<String, Object> knyeMap = new HashMap<String, Object>(16);
		knyeMap.put("KNYE", knye.subtract(new BigDecimal(ysk)));
		knyeMap.put("cardno", jzkh);
		knyeMap.put("status", 0);
		mpiKpxxDao.updateKnye(knyeMap);

		Double yskDouble = Double.parseDouble(ysk);
		Map<String, Object> data = new HashMap<String, Object>(16);
		data.put("CARDNO", list.get(0).get("CARDNO"));// carno
		data.put("CZTYPE", cztype);// cztype
		data.put("AMOUNT", yskDouble);// amount
		data.put("CZGH", userId);// czgh
		data.put("CZIP", ip);// czip
		data.put("CZSJ", DateUtil.date().toTimestamp());// czsj
		data.put("BRID", list.get(0).get("BRID"));// BRID
		data.put("FPHM", fphm);// fphm
		data.put("LASTKNYE", list.get(0).get("KNYE"));// lastknye

		OpCzjl opCzjl = BeanUtil.fillBeanWithMapIgnoreCase(data, new OpCzjl(), true);
		opCzjl.setCzxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CZJL));
		opCzjlDao.insert(opCzjl);
	}

	/**
	 * 根据卡号查询可以转科的挂号单
	 *
	 * @param jzkh
	 * @param jgid
	 * @return
	 */
	public List<MsQryTurnDeptResp> doQueryTurnDept(String jzkh, Integer jgid) {
		Map<String, Object> parameterMap = new HashMap<String, Object>(16);
		parameterMap.put("CARDNO", jzkh);
		int ghxq = Integer.valueOf(sysXtcsCacheSer.getCsz(jgid, "GHXQ"));
		String xqjsfs = sysXtcsCacheSer.getCsz(jgid, "XQJSFS");
		List<Map<String, Object>> brList = mpiBrdaDao.getBrdaInfo(parameterMap);
		parameterMap.clear();
		/*
		 * Adt_begin、Adt_end：通过参数ghxq计算得到对应的日期，XQJSFS计算得到集体的时间， 例如：ghxq是n时，
		 * 当XQJSFS为0（精确到时分），Adt_begin=（当前日期-n）的日期 + 当前时间，Adt_end = 当前日期时间,
		 * 当XQJSFS为1（23:59:59），Adt_begin=（当前日期-n+1）的日期 + 0时0分0秒，Adt_end = 当前日期时间
		 */
		String adtBegin = "", adtEnd = "", format = "", dbformat = "";
		if ("0".equals(xqjsfs)) {
			format = "yyyy-MM-dd HH:mm";
			dbformat = "yyyy-MM-dd HH24:mi";
			adtBegin = MzUtil.toString(DateUtil.beginOfDay(MzUtil.getDateBefore(new Date(), ghxq)), format);
			adtEnd = MzUtil.toString(new Date(), format);
			parameterMap.put("adt_begin", adtBegin);
			parameterMap.put("adt_end", adtEnd);
		} else if ("1".equals(xqjsfs)) {
			format = "yyyy-MM-dd HH:mm:ss";
			dbformat = "yyyy-MM-dd HH24:mi:ss";
			adtBegin = MzUtil.toString(DateUtil.beginOfDay(MzUtil.getDateBefore(new Date(), (ghxq - 1))), "yyyy-MM-dd");
			adtEnd = MzUtil.toString(DateUtil.endOfDay(DateUtil.date()), format);
			parameterMap.put("adt_begin", adtBegin);
			parameterMap.put("adt_end", adtEnd);
		}
		parameterMap.put("al_JZHM", jzkh);
		parameterMap.put("al_jgid", jgid);
		parameterMap.put("thbz", 0);
		parameterMap.put("GHSJ", DateUtil.date());

		List<Map<String, Object>> list = opGhmxDao.getTurnDeptInfo(parameterMap);
		String jzzt = "";
		for (Map<String, Object> map : list) {
			jzzt = String.valueOf(map.get("JZZT"));
			map.put("BRXM", String.valueOf(map.get("BRXM")));
			map.put("BRID", String.valueOf(map.get("BRID")));
			map.put("JZZTTEXT", jzzt.equals("0") ? "挂号" : "1".equals(jzzt) ? "就诊中" : "2".equals(jzzt) ? "暂挂" : "就诊结束");
			map.put("AGE", DateUtil.ageOfNow(map.get("CSNY") != null ? map.get("CSNY").toString() : ""));
		}

		List<MsQryTurnDeptResp> msQryTurnDeptResp = MzUtil.ListToResultSet(list, new MsQryTurnDeptResp());
		return msQryTurnDeptResp;
	}

	/**
	 * 转科确认
	 *
	 * @param req
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doCommitTurnDept(MsCommitTurnDeptReq req) {
		Map<String, Object> body = MzUtil.caseInsensitiveMap(req);
		String sbxh = req.getSbxh() != null ? req.getSbxh().toString() : "";
		// 转入的科室
		String zrks = req.getKsdm() != null ? req.getKsdm().toString() : "";
		// 转入的医生
		String zrys = req.getZrys() != null ? req.getZrys().toString() : "";
		int zrzs = req.getZrzs() != null ? req.getZrzs() : 0;

		Calendar c = Calendar.getInstance();
//		int zblb = c.get(Calendar.HOUR_OF_DAY) < 12 ? 1 : 2;// 值班类别（1上午，2下午）
		// 根据时间段获取值班类别
		String zblb = mzUtil.getSddmByTime(DateUtil.date());

		OpGhmx opGhmx = opGhmxDao.getById(Integer.valueOf(sbxh));
		Map<String, Object> map = MzUtil.caseInsensitiveMap(opGhmx);

		String ksdm = map.get("KSDM") != null ? map.get("KSDM").toString() : "";
		String ysdm = map.get("YSDM") != null ? map.get("YSDM").toString() : "";
		// 发票号码
		String fphm = map.get("JZHM") != null ? map.get("JZHM").toString() : "";
		String jzhm = getNotesNumber(req.getYgdm(), req.getJgid(), OpPjlxEnum.FPHM.getKey());

		Map<String, Object> zkMap = new HashMap<String, Object>(16);
		zkMap.put("sfxzk", 0);
		zkMap.put("SBXH", sbxh);
		opGhmxZkDao.updateSfxzk(zkMap);

		opGhmx.setZrsj(DateUtil.date().toTimestamp());
		opGhmx.setXjzhm(jzhm);
		opGhmx.setSfxzk(1);
		opGhmx.setZkbz(opGhmx.getZkbz() != null ? opGhmx.getZkbz() : 0);

		OpGhmxZk opGhmxZk = new OpGhmxZk();
		BeanUtils.copyProperties(opGhmx, opGhmxZk);
		opGhmxZk.setGhsb(opGhmx.getSbxh());
		opGhmxZk.setJzlsh(req.getJzlsh());
		opGhmxZkDao.insert(opGhmxZk);

		Map<String, Object> params1 = new HashMap<String, Object>(16);
		params1.put("SBXH", sbxh);
		params1.put("KSDM", zrks);
		params1.put("YSDM", zrys);
		params1.put("GHSJ", new Date());
		params1.put("JZHM", jzhm);
		params1.put("ZSID", zrzs);
		params1.put("CZGH", req.getYgdm());
		params1.put("CZSJ", new Date());
		params1.put("ZKBZ", 1);

		// 更新挂号明细
		opGhmxDao.updateGhmx(params1);

		// 更新pos发票号码
		Map<String, Object> posMap = new HashMap<String, Object>(16);
		posMap.put("jzhm", jzhm);
		posMap.put("FPHM", fphm);
		posMap.put("JGID", req.getJgid());
		posMap.put("KSDM", ksdm);
		posMap.put("ZRKS", zrks);
//		opPosmxDao.updateFphm(posMap);

		if (!zrks.equals(ksdm)) {
			opGhksDao.updateYgrs(posMap);
			opGhksDao.updateYgrsAdd(posMap);
		}

		if (!zrys.equals(ysdm)) {
			Map<String, Object> yspbMap = new HashMap<String, Object>(16);
			yspbMap.put("JGID", req.getJgid());
			yspbMap.put("KSDM", ksdm);
			yspbMap.put("YSDM", ysdm);
			yspbMap.put("ZBLB", zblb);
			yspbMap.put("ldt_begin", DateUtil.beginOfDay(DateUtil.date()).toTimestamp());
			yspbMap.put("ldt_end", DateUtil.endOfDay(DateUtil.date()).toTimestamp());
			yspbMap.put("GZRQ", DateUtil.date());
			yspbMap.put("ZRKS", zrks);
			if (!"".equals(ysdm)) {
				opYspbDao.updateYgrsSub(yspbMap);
			}

			if (!"".equals(zrys)) {
				opYspbDao.updateYgrsAdd(yspbMap);
			}
		}
	}

	/**
	 * 建档获取门诊号码
	 *
	 * @param jgid
	 * @param ygdm
	 */
	public String doQueryMzhm(Integer jgid, Integer ygdm) {
		// 查询当前用户的使用号码
		List<OpYgpj> opYgpjList = opYgpjDao.getFirstSyhm(jgid, ygdm, 3);
		if (opYgpjList != null && !opYgpjList.isEmpty()) {
			String syhm = opYgpjList.get(0).getSyhm();
			if (syhm == null) {
				throw BaseException.create("ERROR_REG_0028");
			}
			return syhm;
		} else {
			throw BaseException.create("ERROR_REG_0028");
		}
	}

	/**
	 * 建档根据卡号查询档案信息
	 *
	 * @param jzkh
	 * @return
	 */
	public MpiBrdaAndCardResp doQueryPersonByCardno(String jzkh) {
		MpiBrdaAndCardResp resp = new MpiBrdaAndCardResp();
		MpiCard card = new MpiCard();
		card.setCardno(jzkh);
		// 根据卡号查询卡信息
		MpiCard mpiCard = mpiCardDao.getMpiCardInfo(card);
		if (mpiCard != null && mpiCard.getBrid() != null) {
			OpGhmxInfo opGhmxInfo = new OpGhmxInfo();
			opGhmxInfo.setBrid(mpiCard.getBrid());
			MpiBrda mpiBrda = mpiBrdaDao.getByCondition(opGhmxInfo);
			if ("01".equals(mpiBrda.getZjlx())) {
				// 根据身份证号查询出生年月、年龄、性别
				DateTime date = IdcardUtil.getBirthDate(mpiBrda.getSfzh());
				Timestamp csny = DateUtil.date(date).toTimestamp();
//				Integer age = IdcardUtil.getAgeByIdCard(mpiBrda.getSfzh());
				Integer sex = IdcardUtil.getGenderByIdCard(mpiBrda.getSfzh());
				mpiBrda.setCsny(csny);
//				mpiBrda.setAge(age);
				mpiBrda.setBrxb(sex != null && sex.intValue() == 0 ? 2 : 1);
			}

			if (mpiBrda.getCsny() != null) {
				Map<String, Object> agMap = MzUtil.getPersonAge(mpiBrda.getCsny(), null);
				if (agMap != null && !agMap.isEmpty()) {
					mpiBrda.setAge(Integer.valueOf(agMap.get("age").toString()));
					mpiBrda.setAges(agMap.get("ages").toString());
				}
			}

			mpiBrda.setBrxz(mpiCard.getBrxz());
			// 放入病人信息
			BeanUtils.copyProperties(mpiBrda, resp);
			resp.setCsny(new java.sql.Date(mpiBrda.getCsny().getTime()));
			// 卡信息列表
			MpiCard mc = new MpiCard();
			mc.setBrid(mpiCard.getBrid());
			// 根据病人ID查询卡信息
			List<MpiCard> mpiCardList = mpiCardDao.findByEntity(mc);
			resp.setMpiCardList(mpiCardList);
			return resp;
		}
		return null;
	}

	/**
	 * 根据身份证号码查询档案信息
	 *
	 * @param zjlx
	 * @param idCard
	 * @return
	 */
	public MpiBrdaAndCardResp doQueryPersonByIdcard(String zjlx, String idCard) {
		MpiBrdaAndCardResp resp = new MpiBrdaAndCardResp();
		MpiBrda brda = new MpiBrda();
		brda.setZjlx(zjlx);
		brda.setSfzh(idCard);
		// 根据病人性质和身份证号查询病人档案
		List<MpiBrda> mpiBrdaList = mpiBrdaDao.findByEntity(brda);
		if (mpiBrdaList.size() > 0) {
			Integer brid = mpiBrdaList.get(0).getBrid();
			if (brid != null) {
				MpiCard card = new MpiCard();
				card.setBrid(brid);
				// 根据病人ID查询卡信息
				List<MpiCard> mpiCardList = mpiCardDao.findByEntity(card);
				// 病人信息
				OpGhmxInfo opGhmxInfo = new OpGhmxInfo();
				opGhmxInfo.setBrid(brid);
				MpiBrda mpiBrda = mpiBrdaDao.getByCondition(opGhmxInfo);
				DateTime date = IdcardUtil.getBirthDate(mpiBrda.getSfzh());
				Timestamp csny = DateUtil.date(date).toTimestamp();
				if (csny != null) {
					Map<String, Object> agMap = MzUtil.getPersonAge(csny, null);
					if (agMap != null && !agMap.isEmpty()) {
						mpiBrda.setAge(Integer.valueOf(agMap.get("age").toString()));
						mpiBrda.setAges(agMap.get("ages").toString());
					}
				}

//				Integer age = IdcardUtil.getAgeByIdCard(mpiBrda.getSfzh());
				Integer sex = IdcardUtil.getGenderByIdCard(mpiBrda.getSfzh());
				mpiBrda.setCsny(csny);
//				mpiBrda.setAge(age);
				mpiBrda.setBrxb(sex != null && sex.intValue() == 0 ? 2 : 1);
				mpiBrda.setBrxz(null);
				// 放入病人信息
				BeanUtils.copyProperties(mpiBrda, resp);
				resp.setCsny(date.toSqlDate());
				// 放入卡信息
				resp.setMpiCardList(mpiCardList);
				resp.setJzkh(null);
				return resp;
			}
		} else {
			DateTime date = IdcardUtil.getBirthDate(idCard);
			Timestamp csny = DateUtil.date(date).toTimestamp();

			if (csny != null) {
				Map<String, Object> agMap = MzUtil.getPersonAge(csny, null);
				if (agMap != null && !agMap.isEmpty()) {
					resp.setAge(Integer.valueOf(agMap.get("age").toString()));
					resp.setAges(agMap.get("ages").toString());
				}
			}

//			Integer age = IdcardUtil.getAgeByIdCard(idCard);
			Integer sex = IdcardUtil.getGenderByIdCard(idCard);
			resp.setCsny(date.toSqlDate());
//			resp.setAge(age);
			resp.setBrxb(sex != null && sex.intValue() == 0 ? 2 : 1);
			return resp;

		}
		return null;
	}

	/**
	 * 建档新增个人基本信息和卡信息
	 *
	 * @param req
	 */
	@Transactional(rollbackFor = Exception.class)
	@Locked("doAddPerson_#[req.ygdm]")
	public MpiBrda doAddPerson(MpiBrdaAndCardAddReq req) {
		MpiBrda mpiBrda = new MpiBrda();
		BeanUtils.copyProperties(req, mpiBrda);
		if ("01".equals(req.getZjlx())) {
			DateTime date = IdcardUtil.getBirthDate(mpiBrda.getSfzh());
			Timestamp csny = DateUtil.date(date).toTimestamp();
			Integer age = IdcardUtil.getAgeByIdCard(mpiBrda.getSfzh());
			Integer sex = IdcardUtil.getGenderByIdCard(mpiBrda.getSfzh());
			mpiBrda.setAge(age);
			mpiBrda.setBrxb(sex != null && sex.intValue() == 0 ? 2 : 1);
			mpiBrda.setCsny(DateUtil.offsetHour(date, 2).toTimestamp());
		} else {
			mpiBrda.setCsny(DateUtil.date(req.getCsny()).toTimestamp());
		}
		if (req.getBrid() != null) {
			// 修改档案
			OpGhmxInfo opGhmxInfo = new OpGhmxInfo();
			opGhmxInfo.setBrid(req.getBrid());
			if (mpiBrdaDao.getByCondition(opGhmxInfo) != null) {
				mpiBrda.setXgr(String.valueOf(req.getYgdm()));
				mpiBrda.setXgsj(DateUtil.date().toTimestamp());
				mpiBrdaDao.updateBrdaInfo(mpiBrda);
			} else {
				throw BaseException.create("ERROR_REG_0023");
			}
		} else {
			// 建档
			mpiBrda.setBrid(redisFactory.getTableKey(TableName.DB_NAME, TableName.MPI_BRDA));
			mpiBrda.setJdr(String.valueOf(req.getYgdm()));
			mpiBrda.setJdsj(DateUtil.date().toTimestamp());
			mpiBrda.setJdjg(req.getJgid());
			mpiBrda.setEmpiid(MzUtil.UUIDGenerator());
			mpiBrda.setMzhm(getNotesNumber(req.getYgdm(), req.getJgid(), OpPjlxEnum.DAHM.getKey()));
			// 插入病人档案信息
			mpiBrdaDao.insert(mpiBrda);

			// 使用号码加1
//			Map<String, Object> map = new HashMap<String, Object>(16);
//			map.put("jgid", req.getJgid());
//			map.put("ygdm", req.getYgdm());
//			map.put("pjlx", 3);
//			opYgpjDao.updateSyhm(map);

			// 更新预检分诊记录的卡号
			if (req.getLsh() != null) {
				erPreYjfzDao.doUpdateJzkhByLsh(req.getJzkh(), req.getLsh());
			}
		}

		if (req.getMpiCardList() != null) {
			// 删除已存在的卡信息
			if (req.getBrid() != null) {
				MpiCard delCard = new MpiCard();
				delCard.setBrid(req.getBrid());
				if (delCard.getBrid() != null) {
					mpiCardDao.removeByEntity(delCard);
				}
			}
			// 循环插入新的卡信息
			for (MpiCard mc : req.getMpiCardList()) {
				MpiCard mpiCard = new MpiCard();
				BeanUtils.copyProperties(mc, mpiCard);
				mpiCard.setCreateunit(String.valueOf(req.getJgid()));
				mpiCard.setCreateuser(String.valueOf(req.getYgdm()));
				mpiCard.setCreatetime(DateUtil.date().toTimestamp());
				mpiCard.setCardno(mc.getCardno());
				mpiCard.setBrid(mpiBrda.getBrid());
				mpiCard.setBrxz(mc.getBrxz());
				mpiCard.setCardid(String.valueOf(redisFactory.getTableKey(TableName.DB_NAME, TableName.MPI_CARD)));
				mpiCard.setEmpiid(mpiBrda.getEmpiid());
				// 插入个人卡信息
				mpiCardDao.insert(mpiCard);

			}
		}

		return mpiBrda;
	}

	/**
	 * 校验卡号是否重复
	 *
	 * @param jzkh
	 */
	public void doCheckJzkh(String jzkh) {
		MpiCard card = new MpiCard();
		card.setCardno(jzkh);
		// 根据卡号查询卡信息
		MpiCard mpiCard = mpiCardDao.getMpiCardInfo(card);
		if (mpiCard != null) {
			throw BaseException.create("ERROR_REG_0022");
		}
	}

	/**
	 * 卡注销
	 *
	 * @param cardno
	 */
	public void doCancelCard(String cardno) {
		MpiCard mpiCard = new MpiCard();
		mpiCard.setCardno(cardno);
		mpiCard.setStatus(MpiCardEnum.CANCEL.getCode());
		mpiCardDao.updateCardStatus(mpiCard);
	}

	/**
	 * 卡挂失、注销、解挂
	 *
	 * @param cardno
	 * @param brid
	 * @param userId
	 * @param ip
	 * @param status
	 */
	@Transactional(rollbackFor = Exception.class)
	public void updateCardStatus(String cardno, Integer brid, Integer userId, String ip, String status) {
		// 挂失卡
		MpiCard mpiCard = new MpiCard();
		mpiCard.setCardno(cardno);
		mpiCard.setStatus(status);
		mpiCardDao.updateCardStatus(mpiCard);
		// 充值卡挂失
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("STATUS", status);
		map.put("CARDNO", cardno);
		map.put("BRID", String.valueOf(brid));
		mpiKpxxDao.updateStatus(map);

		Map<String, Object> czjl = new HashMap<String, Object>();
		// 卡号
		czjl.put("CARDNO", cardno);
		// 操作类型 01发卡 02充值 03退费 04挂失 05解挂 06注销
		if ("1".equals(status)) {
			czjl.put("CZTYPE", "04");
		} else if ("0".equals(status)) {
			czjl.put("CZTYPE", "05");
		} else if ("2".equals(status)) {
			czjl.put("CZTYPE", "06");
		}

		// 金额
		czjl.put("AMOUNT", 0.00);
		// 操作工号
		czjl.put("CZGH", userId);
		// 操作IP
		czjl.put("CZIP", ip);
		// 操作时间
		czjl.put("CZSJ", DateUtil.date().toTimestamp());
		// 病人ID
		czjl.put("BRID", brid);
		// 操作记录
		OpCzjl opCzjl = BeanUtil.fillBeanWithMapIgnoreCase(czjl, new OpCzjl(), true);
		opCzjl.setCzxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CZJL));
		opCzjlDao.insert(opCzjl);
	}

	/**
	 * 卡解挂
	 *
	 * @param cardno
	 */
	public void doUnlatchCard(String cardno) {
		MpiCard mpiCard = new MpiCard();
		mpiCard.setCardno(cardno);
		mpiCard.setStatus(MpiCardEnum.NORMAL.getCode());
		mpiCardDao.updateCardStatus(mpiCard);
	}

	/**
	 * 调入根据卡号查询信息
	 *
	 * @param req
	 * @return
	 */
	public Object getAnAppointment(MpiBrdaAndCardAddReq req) {

		return null;
	}

	/**
	 * 建档时查询病人性质
	 *
	 * @return
	 */
//	public List<PubBrxz> getPubBrxzList() {
//		List<PubBrxz> result = pubBrxzOutSer.getPubBrxzList();
//		return result;
//	}

	/**
	 * 调入-预约病人查询
	 *
	 * @param zblb
	 * @param jzkh
	 * @param jgid
	 * @param ip
	 * @return
	 */
	public List<GetAnAppointResp> doGetAnAppointment(String zblb, String jzkh, Integer jgid, String ip) {
		Map<String, Object> parameters = new HashMap<String, Object>(16);
		parameters.put("GHRQ", DateUtil.date().toSqlDate());
		parameters.put("ZBLB", zblb);
		parameters.put("cardId", jzkh);
		List<Map<String, Object>> list = opYyghDao.getYyghInfo(parameters);
		List<GetAnAppointResp> resp = MzUtil.ListToResultSet(list, new GetAnAppointResp());

		boolean isKspb = Boolean.FALSE;
		boolean isYspb = Boolean.FALSE;
		for (GetAnAppointResp appointResp : resp) {
			// 判断预约科室是否排班
			OpGhksListReq req = new OpGhksListReq();
			req.setJgid(jgid);
			req.setIp(ip);
			req.setYytag(1);
			List<OpGhks> kspbList = getGhksList(req);
			if (kspbList != null && !kspbList.isEmpty()) {
				for (OpGhks opghks : kspbList) {
					if (appointResp.getKsdm().equals(opghks.getKsdm())) {
						isKspb = Boolean.TRUE;
						appointResp.setExistKspb(isKspb);
						break;
					}
				}
			}

			// 判断预约科室医生是否排班
			if (!"".equals(appointResp.getYsdm()) && appointResp.getYsdm() != null) {
				Map<String, Object> param = new HashMap<String, Object>(16);
				Calendar startc = Calendar.getInstance();
				Timestamp adtBegin = DateUtil.beginOfDay(DateUtil.date()).toTimestamp();
				Timestamp adtEnd = DateUtil.endOfDay(DateUtil.date()).toTimestamp();
//				int zblbCurrent = startc.get(Calendar.HOUR_OF_DAY);
//				if (zblbCurrent < 12) {
//					zblbCurrent = 1;
//				} else {
//					zblbCurrent = 2;
//				}
				// 根据时间段获取值班类别
				String zblbCurrent = mzUtil.getSddmByTime(DateUtil.date());
				param.put("JGID", jgid);
				param.put("ZBLB", zblbCurrent);
				param.put("adt_begin", adtBegin);
				param.put("adt_end", adtEnd);
				param.put("GZRQ", DateUtil.date());
				param.put("KSDM", appointResp.getKsdm());
				param.put("fwlx", 1);
				List<Map<String, Object>> inofList = opYspbDao.getGhYspbList(param);
				List<MsGhYspbResp> resultList = MzUtil.ListToResultSet(inofList, new MsGhYspbResp());
				if (resultList != null && !resultList.isEmpty()) {
					for (MsGhYspbResp yspbResp : resultList) {
						if (yspbResp.getYsdm().equals(appointResp.getYsdm())) {
							isYspb = Boolean.TRUE;
							appointResp.setExistYspb(isYspb);
							break;
						}
					}
				}
			} else {
				isYspb = Boolean.TRUE;
				appointResp.setExistYspb(isYspb);
			}
		}
		return resp;
	}

	/**
	 * 建档获门诊据号
	 *
	 * @param ygdm
	 * @param jgid
	 * @param type
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public String getNotesNumber(Integer ygdm, Integer jgid, Integer type) {
		String autoCreate = null;
		Integer jlxhCount = opYgpjDao.getJlxhCount(jgid, ygdm, type);
		if (jlxhCount != null && jlxhCount.intValue() > 0) {
			return getNotesNumber1(jgid, ygdm, type);
		}

		if (type == 3) {
			autoCreate = sysXtcsCacheSer.getCsz(jgid, "ZDCSMZH");
		} else if (type == 1) {
			autoCreate = sysXtcsCacheSer.getCsz(jgid, "ZDCSJZH");
		}
		if ("1".equals(autoCreate)) {
			int zdgh = 0;
			// 自动生成门诊号码的前10位
			String today = DateUtil.today();
			String rq = today.substring(2, 4) + today.substring(5, 7) + today.substring(8, 10);
			String zdmzh = "0";
			if (3 == type) {
				String zdmzhxngh = sysXtcsCacheSer.getCsz(jgid, "ZDMZHXNGH");
				zdgh = Integer.parseInt(zdmzhxngh);
				if (zdgh == 9999) {
					zdgh = 1;
				} else {
					zdgh = Integer.parseInt(zdmzhxngh) + 1;
				}
				zdmzh = rq + String.format("%0" + 4 + "d", zdgh);
			} else if (1 == type) {
				String zdmzhxngh = sysXtcsCacheSer.getCsz(jgid, "ZDJZHXNGH");
				zdgh = Integer.parseInt(zdmzhxngh);
				if (zdgh == 99) {
					zdgh = 1;
				} else {
					zdgh = Integer.parseInt(zdmzhxngh) + 1;
				}
				zdmzh = rq + String.format("%0" + 2 + "d", zdgh);
			}
			// 获取起始和终止号码
			String qshm = zdmzh + "001";
//			String syhm = zdmzh + "002";
			String zzhm = zdmzh + "999";
			// 将生成的自动门诊号码写入员工票据中
			OpYgpj opYgpj = new OpYgpj();
			opYgpj.setJgid(jgid);
			opYgpj.setYgdm(ygdm);
			opYgpj.setLyrq(DateUtil.date().toTimestamp());
			opYgpj.setPjlx(type);
			opYgpj.setQshm(qshm);
			opYgpj.setZzhm(zzhm);
			opYgpj.setSyhm(qshm);
			opYgpj.setSypb(0);
			opYgpj.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YGPJ));
			opYgpjDao.insert(opYgpj);

			SysXtcs sysXtcs = new SysXtcs();
			sysXtcs.setCsz(zdgh + "");
			if (3 == type) {
				sysXtcs.setCsmc("ZDMZHXNGH");
				sysXtcsSer.updateCsz(sysXtcs);
			} else if (1 == type) {
				sysXtcs.setCsmc("ZDJZHXNGH");
				sysXtcsSer.updateCsz(sysXtcs);
			}
			return qshm;
		} else {
			return null;
		}
	}

	/**
	 * 获取使用号码
	 *
	 * @param jgid
	 * @param ygdm
	 * @param type
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public String getNotesNumber1(Integer jgid, Integer ygdm, Integer type) {
		List<OpYgpj> syhmList = opYgpjDao.getFirstSyhm(jgid, ygdm, type);
		if (syhmList.size() == 0) {
			return null;
		}
		OpYgpj opYgpj = syhmList.get(0);
		String syhm = opYgpj.getSyhm().toString();
		StringBuffer sb = new StringBuffer(syhm);
		sb = sb.reverse();
		String syhmnew = sb.toString();
		if (syhm.equals(opYgpj.getZzhm().toString())) {
			opYgpjDao.updateHm(syhm, opYgpj.getZzhm(), opYgpj.getJlxh(), 1, null);
		} else {
			if (type == 2) {
				int length = syhm.length();
				int slen = length;
				for (int i = 0; i < length; i++) {
					char n = syhmnew.charAt(i);
					if (n < 48 || n > 57) {
						slen = i;
						break;
					}
				}
				String sz = syhm.substring(syhm.length() - slen);
				String zm = syhm.substring(0, syhm.length() - slen);
				long intnewsz = Long.parseLong(sz) + 1;
				String newssz = String.format("%0" + (slen) + "d", intnewsz);
				opYgpjDao.updateHm(zm + newssz, opYgpj.getZzhm(), opYgpj.getJlxh(), null, null);
			} else {
				int length = syhm.length();
				long intnewsyhm = Long.parseLong(syhm) + 1;
				String newsyhm = String.format("%0" + length + "d", intnewsyhm);
				opYgpjDao.updateHm(newsyhm, opYgpj.getZzhm(), opYgpj.getJlxh(), null, null);
			}
		}
		return syhm;
	}

	/**
	 * 查询当日专家门诊是否排班
	 *
	 * @param ksdm
	 */
	public void doCheckZjmzpb(Integer ksdm) {
		String ksdmStr = ObjectToTypes.null2Str(ksdm);
		Calendar startc = Calendar.getInstance();

//		int zblb = startc.get(Calendar.HOUR_OF_DAY);
//		if (zblb < 12) {
//			zblb = 1;
//		} else {
//			zblb = 2;
//		}
		// 根据时间段获取值班类别
		String zblb = mzUtil.getSddmByTime(DateUtil.date());

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("KSDM", ksdmStr);
		parameters.put("ZBLB", zblb);
		parameters.put("GZRQ", DateUtil.beginOfDay(DateUtil.date()));
		Integer count = opYspbDao.getZjPb(parameters);
		if (count == null || count != null && count.intValue() == 0) {
			throw BaseException.create("ERROR_REG_0053");
		}
	}

	/**
	 * 预约管理-查询
	 *
	 * @param req
	 * @param user
	 */
	public PageInfo<YyglResp> yyglQuery(YyglReq req, SysUser user) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("jgid", user.getHospitalId());
		parameters.put("mzlb", 1);
		parameters.put("ghrq", req.getGhrq());

		List<String> zblb = mzUtil.getAllSddmByTime(req.getZblb());
		//需要包含天
		parameters.put("zblb", String.join(",", zblb));
		parameters.put("ksdm", req.getKslb());
		parameters.put("pydm", req.getPydm());

		PageInfo<YyglResp> pageInfo = PageHelper.startPage(req.getPageNum(), req.getPageSize())
				.doSelectPageInfo(() -> opGhksDao.yyglQuery(parameters));

		return pageInfo;
	}

	/**
	 * 预约挂号校验
	 *
	 * @param req
	 * @return
	 */
	public boolean checkCanAppointedToday(CheckCanAppointedTodayReq req) {
		boolean flg = true;

		// 判断是否已经预约过
		Map<String, Object> appointedCheck = new HashMap<>(16);
		appointedCheck.put("brid", req.getBrid());
		appointedCheck.put("ksdm", req.getKsdm());
		appointedCheck.put("yyrq", req.getYyrq());
		appointedCheck.put("ghbz", 0);
		long appointedCheckCount = opYyghDao.findByEntityCount(appointedCheck);

		// 判断是否挂号过
		Map<String, Object> registerCheck = new HashMap<>(16);
		registerCheck.put("brid", req.getBrid());
		registerCheck.put("ksdm", req.getBrid());
		registerCheck.put("ghsj", DateUtil.format(req.getGhsj(), "yyyy-mm-dd"));
		long registerCheckCount = opYyghDao.findByEntityCount(registerCheck);

		if ((appointedCheckCount + registerCheckCount) > 0) {
			throw BaseException.create("ERROR_DCTWORK_OP_0025");
		}

		return flg;
	}

	/**
	 * 查询诊间医技预病人信息
	 *
	 * @param searchType
	 * @param searchValue
	 */
	public List<LoadPatientInfoResp> loadPatientInfo(Integer searchType, String searchValue) {
		if (searchType != null && searchType.intValue() == 1) {// 门诊
			return cisjcsqd01Service.loadPatientInfoMz(searchType, searchValue);
		} else if (searchType != null && searchType.intValue() == 2) {// 住院
			return cisjcsqd01Service.loadPatientInfoZy(searchValue);
		} else {// 体检
			return cisjcsqd01Service.loadPatientInfoTj(searchValue);
		}
	}

	/**
	 * 查询医技预病人申请单详细信息
	 *
	 * @param type
	 * @param jcxh
	 * @return
	 */
	public List<LoadSqdDetailInfoResp> loadSqdDetailInfo(Integer type, Integer jcxh) {
		if (!"3".equals(type)) {
			return diccZlsfdzDao.loadSqdDetailInfo(jcxh);
		}
		return new ArrayList<>();
	}

	/**
	 * 加载预约信息
	 *
	 * @param req
	 * @return
	 */
	public List<LoadAppointedInfoResp> loadAppointedInfo(LoadAppointedInfoReq req) {
		List<LoadAppointedInfoResp> resp = opYyghDao.findByOtherEntity(req);
		for (LoadAppointedInfoResp r : resp) {
			r.setNl(DateUtil.ageOfNow(r.getCsny()));
		}
		return resp;
	}

	/**
	 * 保存预约挂号
	 *
	 * @param req
	 * @return
	 */
	public Object saveAppointedInfomation(SaveAppointedInfomationReq req, SysUser user) {
		Map<String, Object> saveInformation = BeanUtil.beanToMap(req);
		saveInformation.put("djgh", user.getUserId());
		saveInformation.put("sfqh", 0);
		saveInformation.put("pdhm", System.currentTimeMillis());
		saveInformation.put("jgid", user.getHospitalId());
		saveInformation.put("ghsj", req.getGhsj());
		saveInformation.put("ghbz", 0);

		// 保存预约挂号信息
		saveInformation.put("yyxh", redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YYGH));
		opYyghDao.insert(saveInformation);

		Map<String, Object> m = new HashMap<String, Object>(16);
		m.put("YYXH", saveInformation.get("yyxh"));
		m.put("YYRQ", saveInformation.get("yyrq"));
		m.put("KSDM", saveInformation.get("ksdm"));
		m.put("YWLX", 11);
		m.put("ZSID", 0);
		m.put("JGID", user.getHospitalId());
		// 生排队序号
		doSetQueue(m);

		// 科室排班预约人数+1
		opGhksDao.updateYyrs(saveInformation);

		if (saveInformation.get("ysdm") != null) {
			// 医生排班预约人数+1
			opYspbDao.updateYyrs(saveInformation);
		}

		return saveInformation.get("yyxh");
	}

	/**
	 * 查询科室费用
	 *
	 * @param ksdm
	 */
	public CheckKsfyResp doCheckKSFY(Integer ksdm, Integer jgid) {
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Map<String, Object> respMap = new HashMap<String, Object>();
		parameterMap.put("JGID", jgid);
		parameterMap.put("KSDM", ksdm);
		List<Map<String, Object>> list = opGhksDao.checkKsfy(parameterMap);
		if (list != null && list.size() > 0) {
			respMap.put("ghf", list.get(0).get("GHF"));
			respMap.put("zlf", list.get(0).get("ZLF"));
		}
		CheckKsfyResp resp = BeanUtil.fillBeanWithMapIgnoreCase(respMap, new CheckKsfyResp(), true);
		return resp;
	}

	/**
	 * 判断是否能更改预约信息
	 *
	 * @param brid
	 * @param yyxh
	 * @return
	 */
	public Boolean checkCanModifyAppointment(Integer brid, Integer yyxh, Integer jgid) {

		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("brid", brid);
		parameter.put("yyxh", yyxh);

		Map<String, Object> yyInfo = opYyghDao.getYyCount(parameter);

		String sycsStr = sysXtcsCacheSer.getCsz(jgid, "YYSYCS"); // 获取参数 预约爽约次数
		String ggcsStr = sysXtcsCacheSer.getCsz(jgid, "YYGGCS"); // 获取参数 预约更改次数

		if (ObjectToTypes.parseInt(yyInfo.get("YYSYCS")) > Integer.parseInt(ggcsStr)) {
			return false;
		}

		if (ObjectToTypes.parseInt(yyInfo.get("YYGGCS")) > Integer.parseInt(sycsStr)) {
			return false;
		}

		return true;
	}

	/**
	 * 改预约信息
	 *
	 * @param req
	 * @return
	 */
	public void modifyAppointedInfo(ModifyAppointedInfoReq req) {
		// 更改门诊预约信息
		opYyghDao.updateMzYy(req);
	}

	/**
	 * 查询医技检查申请单列表
	 *
	 * @param req
	 */
	public List<QueryJcSqdListResp> queryJcSqdList(QueryJcSqdListReq req) {
		List<QueryJcSqdListResp> resps = new ArrayList<>();
		Map<String, Object> param = BeanUtil.beanToMap(req);
		List<Map<String, Object>> result = cisjcsqd01Service.queryJcsqdList(param);

		if (result != null) {
			for (Map<String, Object> m : result) {
				// 门诊
				if (MedicineUtils.parseString(m.get("SQLX")).equals("1")) {
					m.put("SQLX", "门诊");

					Map<String, Object> brxx = cisjcsqd01Service.queryMzBrxx(MapAttributeUtils.getInteger("JZXH", m));

					if (brxx != null) {
						m.putAll(brxx);
					}
				}
				// 住院
				else if (MedicineUtils.parseString(m.get("SQLX")).equals("2")) {
					m.put("SQLX", "住院");
					Map<String, Object> brxx = cisjcsqd01Service.queryZyBrxx(MapAttributeUtils.getString("HM", m));

					if (brxx != null) {
						m.putAll(brxx);
					}
				} else if (MedicineUtils.parseString(m.get("SQLX")).equals("3")) {
					m.put("SQLX", "体检");
					Map<String, Object> brxx = cisjcsqd01Service.queryTjBrxx(MapAttributeUtils.getString("HM", m));

					if (brxx != null) {
						m.putAll(brxx);
					}
				}

			}
		}

		for (Map map : result) {
			map = MzUtil.transformLowerCase(map);
			QueryJcSqdListResp queryJcSqdListResp = new QueryJcSqdListResp();
			try {
				queryJcSqdListResp = MapAttributeUtils.mapToBean(map, QueryJcSqdListResp.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
			resps.add(queryJcSqdListResp);
		}

		return resps;
	}

	/**
	 * 挂号查询
	 * @param req
	 * @return
	 */
	public List<QueryRegisteredResp> doRegisteredQuery(QueryRegisteredReq req) {
//		List<Map<String, Object>> inofList = opGhksDao.doRegisteredQuery(map);
//		List<QueryRegisteredResp> resp = mzUtil.ListToResultSet(inofList, new QueryRegisteredResp());
		return opGhksDao.doRegisteredQuery(req);
	}

	/**
	 * 获取挂号科室对应的门诊科室
	 *
	 * @param jgid
	 * @return
	 */
	public List<QueryOfficeCodeResp> doQueryOfficeCode(Integer jgid) {
		return opGhksDao.doQueryOfficeCode(jgid);
	}

	/**
	 * 患者档案登记
	 *
	 * @param jzkh
	 * @param jgid
	 * @return
	 */
	public List<QueryBrdaListResp> doQueryList(String jzkh, Integer jgid) {
		List<QueryBrdaListResp> resp = opGhksDao.doQueryList(jzkh, jgid);
		return resp;
	}

	/**
	 * 挂号发票打印
	 *
	 * @param req
	 * @return
	 */
	public PrintGhxxResp doPrintghxx(PrintGhxxReq req) {
		OpGhmx opGhmx = opGhmxDao.getById(req.getSbxh());
		MpiBrda mpiBrda = mpiBrdaDao.getById(opGhmx.getBrid());
		Map<String, Object> res = new HashMap<String, Object>();
		Map<String, Object> body = MzUtil.caseInsensitiveMap(req);
		long sbxh = Long.parseLong(body.get("sbxh").toString());
		String BRXZ = body.get("BRXZ") + "";
		String ybsjbrxz = body.get("ybsjbrxz") + "";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("KSDM", body.get("KSDM").toString());
		List<Map<String, Object>> KSlist = opGhksDao.doQueryKsmcAndKswz(parameters);
		res.put("KSMC", KSlist.get(0).get("KSMC"));
		res.put("KSWZ", KSlist.get(0).get("KSWZ"));
		List<Map<String, Object>> JZXHlist = opGhmxDao.doQueryMaxPdxh();
		res.put("JZXH", JZXHlist.get(0).get("JZXH"));
		if (BRXZ.equals(ybsjbrxz)) {// 医保
			List<Map<String,Object>> ybxx = opGhmxDao.queryGhybxx(sbxh);
			if(ybxx.size()>0){
				res = ybxx.get(0);
				res.put("KSMC", KSlist.get(0).get("KSMC"));
				res.put("KSWZ", KSlist.get(0).get("KSWZ"));
			}else{
				throw BaseException.create("ERROR_REG_0112");
			};
//			parameters.put("jzhm", body.get("JZHM").toString());
//			List<Map<String, Object>> list = dao
//					.doSqlQuery("SELECT ( SELECT xz.xzmc FROM PUB_BRXZ xz where xz.brxz = ghmx.brxz )"
//							+ " as YBLX, sh04.brkh as SHBZK, sh03.jlch as JZJLXH, to_char(ghmx.ghje,'fm9990.0099') as JCF,"
//							// 现金支付=自费(sh04.FYBJSFWGRZF)+自负(sh04.TCDXJZFS+sh04.FJDXJZFS+sh04.ZFDXJZFS)+分类自负()
//							// to_char(ghmx.zlje,'fm9990.0099')
//							+ " to_char(ghmx.zlje,'fm999990.0099') as ZLF, to_char((sh04.FYBJSFWGRZF+sh04.TCDXJZFS+sh04.FJDXJZFS+sh04.ZFDXJZFS),'fm999990.0099') as XJZF, to_char((sh04.DNZHZFS+sh04.LNZHZFS),'fm999990.0099') as GRZHZF,to_char((sh04.TCDXJZFS+sh04.FJDXJZFS+sh04.ZFDXJZFS),'fm999990.0099') as ZF,"
//							+ " to_char(sh04.TCZFS,'fm999990.0099') as YBTCZF, to_char(sh04.FJZFS,'fm999990.0099') as FJZF, to_char(sh04.DNZHYE,'fm999990.0099') as DNZHYE, "
//							+ "to_char(sh04.LNZHYE,'fm999990.0099') as LNZHYE, to_char(ghmx.JMJE,'fm999990.0099') as JMJE, sh04.ZXLSH as ZXLSH ,"
////										+ "sh04.LNZHYE as LNZHYE, sh04.YBJSFWFYZE as JMJE, sh04.ZXLSH as ZXLSH ,"
//							+ "buser.name as YSMC  ,sh04.DBBZ AS DBBZ "// 大病医保
//							+ " FROM yb_sh04 sh04, OP_GHMX ghmx left join base_user buser on ghmx.ysdm = buser.id, yb_sh03 sh03 where sh03.jssqxh = "
//							+ "sh04.jssqxh and sh04.ghxh = ghmx.sbxh and sh04.zfpb = 0 and ghmx.jzhm = :jzhm",
//							parameters);
//			// 如果门诊查询的数据为空，则尝试读取工伤挂号门诊表
//			if (CollectionUtils.isEmpty(list)) {
//				list = dao.doSqlQuery("SELECT ( SELECT xz.xzmc FROM PUB_BRXZ xz where xz.brxz = ghmx.brxz )"
//						+ " as YBLX, sh04.brkh as SHBZK, sh03.jlch as JZJLXH, ghmx.ghje as JCF,"
//						+ " ghmx.zlje as ZLF,ghmx.zjfy as ZJFY,ghmx.jmje as JMJE , sh04.FGSJSFWGRZF as XJZF,(sh04.TCDXJZFS+sh04.FJDXJZFS+sh04.ZFDXJZFS) as ZF, "
//						+ " sh04.GSJJZFS as YBTCZF,  sh04.DNZHYE as DNZHYE, "
//						+ "sh04.LNZHYE as LNZHYE, sh04.GSJSFWFYZE as JMJE, sh04.ZXLSH as ZXLSH " + ",buser.name as YSMC"
//						+ " FROM yb_sh06 sh04, OP_GHMX ghmx left join base_user buser on ghmx.ysdm = buser.id, "
//						+ "yb_sh05 sh03 where sh03.jssqxh = "
//						+ "sh04.jssqxh and sh04.ghxh = ghmx.sbxh  and ghmx.jzhm = :jzhm", parameters);
//			}
//			res.put("jzhm", body.get("JZHM").toString());
//			if (list != null && list.size() > 0) {
//				res.put("YBLX", list.get(0).get("YBLX"));
//				res.put("ZF", list.get(0).get("ZF"));
//				res.put("SHBZK", list.get(0).get("SHBZK"));
//				res.put("JZJLXH", list.get(0).get("JZJLXH"));
//				res.put("JCF", list.get(0).get("JCF"));
//				res.put("ZJFY", list.get(0).get("ZJFY"));
//				res.put("JMJE", list.get(0).get("JMJE"));
//				res.put("ZLF", list.get(0).get("ZLF"));
//				res.put("XJZF", list.get(0).get("XJZF"));
//				res.put("GRZHZF", list.get(0).get("GRZHZF"));
//				res.put("YBTCZF", list.get(0).get("YBTCZF"));
//				res.put("FJZF", list.get(0).get("FJZF"));
//				res.put("DNZHYE", list.get(0).get("DNZHYE"));
//				res.put("LNZHYE", list.get(0).get("LNZHYE"));
//				res.put("JMJE", list.get(0).get("JMJE"));
//				res.put("ZXLSH", list.get(0).get("ZXLSH"));
//				res.put("YSMC", list.get(0).get("YSMC") != null ? list.get(0).get("YSMC") : "");
//				res.put("DBBZ", list.get(0).get("DBBZ"));// 大病标志
//			}
		} else {// 非医保
			parameters.clear();
			parameters.put("jzhm", body.get("JZHM").toString());
			List<Map<String, Object>> list = opGhmxDao.doQueryGhmxInfo(parameters);
			Map<String, Object> map = opGhmxDao.doQueryJzkh(parameters);

			BigDecimal jcf = list.get(0).get("JCF") != null ? new BigDecimal(list.get(0).get("JCF").toString())
					: BigDecimal.ZERO;
			BigDecimal blje = list.get(0).get("BLJE") != null ? new BigDecimal(list.get(0).get("BLJE").toString())
					: BigDecimal.ZERO;
			BigDecimal ckje = list.get(0).get("CKJE") != null ? new BigDecimal(list.get(0).get("CKJE").toString())
					: BigDecimal.ZERO;
			BigDecimal zjfy = list.get(0).get("ZJFY") != null ? new BigDecimal(list.get(0).get("ZJFY").toString())
					: BigDecimal.ZERO;
			BigDecimal wzje = list.get(0).get("WZJE") != null ? new BigDecimal(list.get(0).get("WZJE").toString())
					: BigDecimal.ZERO;
			res.put("SHBZK", map.get("SHBZK"));
			res.put("jzhm", body.get("JZHM").toString());
			res.put("YBLX", list.get(0).get("YBLX"));
			res.put("JZJLXH", "");
//			res.put("JCF", list.get(0).get("JCF"));
			res.put("JCF", jcf);
			res.put("ZJFY", list.get(0).get("ZJFY"));
			res.put("JMJE", list.get(0).get("JMJE"));
			res.put("ZLF", list.get(0).get("ZLF"));
			res.put("BLJE", list.get(0).get("BLJE"));
			res.put("CKJE", list.get(0).get("CKJE"));
			res.put("YSMC", list.get(0).get("YSMC") != null ? list.get(0).get("YSMC") : "");
			res.put("XJZF",  BigDecimal.ZERO);
			res.put("GRZHZF", BigDecimal.ZERO);
			res.put("YBTCZF",  BigDecimal.ZERO);
			res.put("FJZF",  BigDecimal.ZERO);
			res.put("DNZHYE",  BigDecimal.ZERO);
			res.put("LNZHYE",  BigDecimal.ZERO);
			res.put("FLZF",  BigDecimal.ZERO);
			res.put("ZF",  BigDecimal.ZERO);
			res.put("ZFEI",  BigDecimal.ZERO);
			res.put("ZXLSH", "");
			res.put("ZFBJE", list.get(0).get("ZFBJE"));
			res.put("HJJE", list.get(0).get("ZJJE"));
			res.put("QTF", blje.add(zjfy).add(ckje).add(wzje));
		}
		// 增加返回付款方式 如果是预付卡 一并返回预付卡支付信息
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("sbxh", sbxh);
		List<Map<String, Object>> fkxxList = opGhFkxxDao.doQueryBySbxh(param);
		Map<String, Object> fkxxMap = new HashMap<String, Object>();
		for (Map<String, Object> m : fkxxList) {
			Map<String, Object> map = new CaseInsensitiveMap<String, Object>(m);
			if (!"4".equals(map.get("FKFS").toString())) {
				fkxxMap = map;
				res.put("FKFS", map.get("FKFS"));
				Map<String, Object> fkfsMap = new HashMap<String, Object>();
				fkfsMap.put("FKFS", map.get("FKFS") + "");
				PubFkfsModel pubFkfs = pubFkfsService.getById(Integer.valueOf(map.get("FKFS").toString()));
				res.put("FKMC", pubFkfs.getFkmc());
				break;
			}
		}
//		String czkzf = sysXtcsCacheSer.getCsz(req.getJgid(), "CZKZF");
		if (ObjectToTypes.null2Str(fkxxMap.get("FKFS")).equals(FkfsEnum.CZK.getKey())) {
			String fphm = body.get("JZHM") != null ? body.get("JZHM").toString() : null;
			List<Map<String, Object>> czkxx = opCzjlDao.queryCzjlDyfp(fphm);
			if (null != czkxx) {
				res.put("CZKZF", czkxx.get(0).get("AMOUNT"));
				res.put("CZKYE", czkxx.get(0).get("YE"));
			}
		}
		// by cqd 打印需要查找老系统的DDCD
		// String bird= body.get("BRID") + "";
		Map<String, Object> dayinmap = new HashMap<String, Object>();
		dayinmap.put("SBXH", sbxh);
		List<Map<String, Object>> list = opGhmxDao.doQueryDdcsAndPdxh(dayinmap);
		if (list == null || list.isEmpty()) {
			throw BaseException.create("ERROR_REG_0078");
		}

		res.put("JZXH", list.get(0).get("JHHM"));
		res.put("DDCS", list.get(0).get("DDCS"));
		res.put("now", DateUtil.format(opGhmx.getGhsj(), DatePattern.CHINESE_DATE_PATTERN));
		res.put("name", req.getUserName());

		// ===============
		// 打印机参数
		String ghdyjmc = sysXtcsCacheSer.getCsz(req.getJgid(), "GHDYJMC");
		String ghdyfs = sysXtcsCacheSer.getCsz(req.getJgid(), "GHDYFS");
		String nsrsbh = sysXtcsCacheSer.getCsz(req.getJgid(), "NSRSBH");

		PrintGhxxResp response = BeanUtil.fillBeanWithMapIgnoreCase(res, new PrintGhxxResp(), true);
		HrPersonnelModel hrPersonnel = hrPersonnelService.getPersonnelById(Integer.valueOf(opGhmx.getCzgh()));
		response.setGhdyjmc(ghdyjmc);
		response.setDyfs(Integer.valueOf(ghdyfs));
		response.setNsrsbh(nsrsbh);
		response.setJzlsh(opGhmx.getJzlsh());
		response.setSkygh(hrPersonnel.getRybh());
		response.setBrxm(mpiBrda.getBrxm());
        String fpyl = sysXtcsCacheSer.getCsz(req.getJgid(), "FPYL");
        response.setFpyl(fpyl);
        return response;
	}

	public static void main(String[] args) {
		System.out.println(DateUtil.format(DateUtil.date(), DatePattern.CHINESE_DATE_PATTERN));
	}
	/**
	 * 医保SM01
	 *
	 * @param jgid
	 * @param ip
	 * @param jzkh
	 */
	public List<Map<String, Object>> CheckAccountattr(Integer jgid, String ip, String jzkh) {
		String isDb = "0";
		List<Map<String, Object>> dbdjxxs = new ArrayList<>();
		String orgid = "";
		Map map_orgid = opMzlbDao.getYbjgdm(jgid, ip);
		if (map_orgid != null && !map_orgid.isEmpty()) {
			orgid = map_orgid.get("ybjgid").toString();
		} else {
			throw BaseException.create("ERROR_SHYB_0015");
		}
		Map<String, Object> res = new HashMap<>();
		Map<String, Object> res_db = new HashMap<>();
		Map<String, Object> sm01 = new HashMap<String, Object>();
		sm01.put("xxlxm", "SM01");
		sm01.put("cardtype", "0");
		sm01.put("carddata", jzkh);
		sm01.put("orgId", orgid);
		sm01.put("ip", ip);
		SettleResultDTO sm01_res  = offLineSettle.send(res, sm01);
		if (sm01_res.getCode() == 200) {
			String json = sm01_res.getData().toString();
			Map<String,Object> tempMap = JackJsonUtil.parse(json,Map.class);
			Map<String,Object> ybkxxMap = (Map<String, Object>) tempMap.get("xxnr");
			//Map ybkxxMap = (Map) res.get("xxt");
			String accountattr = ybkxxMap.get("accountattr").toString();
			String zhfc = accountattr.substring(4, 5);
			String zhbz = accountattr.substring(11, 12);
			String brkh = ybkxxMap.get("cardid").toString();
			if ("1".equals(zhfc)) {
				throw BaseException.create("ERROR_SHYB_0016");
			}
			if ("A".equals(zhbz)) { // 民政医疗帮困
				Map<String, Object> res_sj51 = new HashMap<>();
				sm01.put("xxlxm", "SJ51");
				offLineSettle.send(res_sj51, sm01);
				Map ylhzbkMap = (Map) res.get("xxt");
				if ((Integer) res_sj51.get("isError") != -1) {
					if ("0".equals(ylhzbkMap.get("ddhossame"))) {
						throw BaseException.create("ERROR_SHYB_0017");
					}
				}
				if (res_sj51.get("errorText") != null) {
					throw BaseException.create("ERROR_SHYB_0018", new String[] { res_sj51.get("errorText") + "" });
				}
			}
			String date = DateUtil.format(DateUtil.date(), "yyyy-MM-dd");
			//大病暂时注销
			//List<YbDbdj> dbdjobj = shybZhbzService.getShybDbxmdm(brkh, date);
			//List<Map<String, Object>> dbdj_list = MzUtil.ListObjToMap(dbdjobj);
//			List<Map<String, Object>> dbdj_list = new ArrayList<>();
//			if (dbdj_list.size() > 0) {
//				Map<String, Object> sj31 = new HashMap<String, Object>();
//				sj31.put("xxlxm", "SJ31");
//				sj31.put("orgid", orgid);
//				sj31.put("ip", ip);
//				sj31.put("cardtype", "0");
//				sj31.put("carddata", jzkh);
//				sj31.put("djlb", "4");
//				offLineSettle.send(res_db, sj31);
//				if ((Integer) res_db.get("code") == 200) {
//					Map ybdbxxMap = (Map) res_db.get("xxt");
//					dbdjxxs = (List<Map<String, Object>>) ybdbxxMap.get("djxxs");
//				}
//			}
			updateBrxzByMediclInsurance(brkh, accountattr);
		} else {
			Integer code = (Integer) res.get("code");
			String msg = (String) res.get("msg");
			throw BaseException.create("ERROR_SHYB_0020", new String[] { res.get("code") + "", res.get("msg") + "" });
		}
		return dbdjxxs;
	}

	/**
	 * 医保返回更新mpi_card中brxz
	 *
	 * @param brkh
	 * @param accountattr
	 */
	public void updateBrxzByMediclInsurance(String brkh, String accountattr) {
		String tsdybs = ""; // 特殊待遇标识
		String zhbz = "";// 医保办法标识
		if (accountattr == null || accountattr.trim().equals("")) {
			logger.info("未取到有效的账户标识");
			return;
		} else {
			tsdybs = accountattr.substring(3, 4); // 特殊待遇标识
			zhbz = accountattr.substring(11, 12);// 账户标志
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("zhbz", zhbz);
		Map<String, Object> ybBrxz = shybZhbzService.getZhbzBrxz(zhbz);
		if (ybBrxz == null || ybBrxz.isEmpty()) {
			ybBrxz = new HashMap<String, Object>();
			ybBrxz.put("BRXZ", "4001");// 医保调用已经成功，如果在本地没找到，就是普通医保性质
		}
		if ("2".equals(tsdybs) && "0".equals(zhbz)) {
			ybBrxz.put("BRXZ", "304");
		}
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("cardNo", brkh);
		List<MpiCard> listMpi = mpiCardDao.getCardInfoByCardNo(parameters);
		List<Map<String, Object>> list = MzUtil.ListObjToMap(listMpi);
		if (list.size() != 1) {
			logger.info("卡号查询多条记录" + brkh);
			return;
		}
		String brxz = "";
		if (list.get(0).get("BRXZ") != null) {
			brxz = list.get(0).get("BRXZ").toString();
		}
		if (!ybBrxz.get("BRXZ").equals(brxz)) {
			parameters.clear();
			parameters.put("brxz", ybBrxz.get("BRXZ"));
			parameters.put("cardId", list.get(0).get("CARDID"));
			mpiCardDao.updateBrxzByYb(parameters);
		}
	}

	/**
	 * 医保挂号预结算
	 * @param req
	 * @param ip
	 * @param id_ghf
	 * @param id_zlf
	 * @param id_zjf
	 * @param id_ckf
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public Map<String, Object> preRegisteredSettlement(MsQryRegisterReq req, String ip,BigDecimal id_ghf, BigDecimal id_zlf, BigDecimal id_zjf,BigDecimal id_ckf) {
		// 医保
		Map<String, Object> map = new HashMap<String, Object>();
		String pzlx = "";
		String pzhm = "";
		String jmbz = "";
		String kxsybsqjmbz = req.getYbsqjmbz();
		int ghlx = req.getGhlx();
		String yllb = "S11";
		if (ghlx==1) {
			yllb = "S12";
		} else if (req.getIsDb()==1) {
			yllb = "S13";
		} else {
			yllb = "S11";
		}
		Integer jgid = req.getJgid();
		String orgid = "";
		// 医保挂号预结算
		// 挂号费 ldZfghf 诊疗费 idZfzlf 病历费 专家费 ldZfzjf
		if (req.getIsDb() == 1 && req.getBrid() != null) {
			doUpdateDbdm(req.getBrid(), req.getDbtype());
		}
		if ("1".equals(req.getCardtype())) {
			pzlx = "1";
			pzhm = req.getCardid();
			jmbz = "1";
			if ("Y".equals(req.getAccountattr().substring(11, 12))) {
				kxsybsqjmbz = "0";
			} else {
				kxsybsqjmbz = "1";
			}
		} else {
			if ("1".equals(req.getYbsqjmbz())) {
				pzlx = "2";
				pzhm = req.getCardid();
				jmbz = "1";
			} else {
				// 此病人不享受医保减免，如若要享受财政减免，请出示上海市居民户口簿及身份证，并输入户口簿编号
			}
		}
		Integer ksdm = req.getKsdm();
		BigDecimal id_blf = req.getBlje(); //病历费
		Map<String, Object> map_ybksdm = dicKszdOutSer.getYbksdm(req.getKsdm());
		String ybksdm = map_ybksdm.isEmpty() ? "03" : map_ybksdm.get("ybks") + "";
		if("".equals(req.getAccountattr())||req.getAccountattr()==null){
			throw BaseException.create("ERROR_SHYB_0047");
		}
		String zhbz = req.getAccountattr().substring(11, 12);
		String tsdybs = req.getAccountattr().substring(3, 4);
		BigDecimal ld_zfje = id_ghf.add(id_blf).add(id_zjf).add(id_ckf);  //自负金额

		int ll_bz;
		BigDecimal szje_fyze = new BigDecimal(0);
		BigDecimal szje_ybfyze = new BigDecimal(0);
		BigDecimal ghf = new BigDecimal(0);
		BigDecimal zlf = new BigDecimal(0);
		BigDecimal zjf = new BigDecimal(0);
		BigDecimal ckf = new BigDecimal(0);
		BigDecimal blf = new BigDecimal(0);
		BigDecimal szje_ghf = new BigDecimal(0);

		BigDecimal id_xjje = new BigDecimal(0);
		BigDecimal id_ybzf = new BigDecimal(0);

		if ("2".equals(tsdybs) ) { // 伤残
			ll_bz = 1;
			szje_ghf = id_ghf.add(id_zjf).add(id_ckf).add(id_blf);// 诊疗费自费
			szje_fyze = id_zlf.add(szje_ghf);// 新医保病人只有诊疗费可向医保传送
			szje_ybfyze = szje_fyze; // 医保结算范围总额=诊疗费
			ghf = id_ghf;// 诊疗费
			zlf = id_zlf;// 诊疗费
			zjf = id_zjf; //专家费
			ckf = id_ckf; //次咖啡
			blf = id_blf;  //病历费
		} else {
			ll_bz = 0;
			if (!"A".equals(zhbz)) {
				if (req.getIsGs() == 1) { // 工伤
					//szje_fyze = id_ghf.add(id_zlf);
					//szje_ybfyze = id_ghf.add(id_zlf);
					szje_fyze = id_zlf;
					szje_ybfyze = id_zlf;
					ghf = id_ghf;// 诊疗费
					zlf = id_zlf;// 挂号费
					zjf = id_zjf; //专家费
					ckf = id_ckf; //次咖啡
					blf = id_blf;  //病历费
				} else {
					szje_fyze = id_zlf;
					szje_ybfyze = id_zlf;

					ghf = id_ghf;// 挂号费
					zlf = id_zlf;// 诊疗费
					zjf = id_zjf; //专家费
					ckf = id_ckf; //次咖啡
					blf = id_blf;  //病历费
				}
			} else {
				szje_fyze = ld_zfje;
				szje_ybfyze = ld_zfje;
				zlf = id_zlf;
				ghf = id_ghf;
			}
			szje_ghf = ghf.add(zjf).add(ckf).add(blf);
		}

		Map map_orgid = opMzlbDao.getYbjgdm(jgid, ip);
		if (map_orgid != null && !map_orgid.isEmpty()) {
			orgid = map_orgid.get("ybjgid").toString();
		} else {
			throw BaseException.create("ERROR_SHYB_0015");
		}
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("xxlxm", "SH01");
		args.put("cardtype", req.getCardtype());
		if("3".equals(req.getCardtype())){
			args.put("carddata", req.getCardid());
		}else{
			args.put("carddata", req.getCardid());
		}
		args.put("deptid", ybksdm);
		args.put("zlxmdm", "");
		args.put("personspectag", tsdybs);
		args.put("yllb", yllb);
		args.put("dbtype", req.getDbtype());
		if(req.getIsGs() == 1){
			args.put("gsrdh", req.getGsrdh());
		}else{
			args.put("gsrdh", "");
		}
		args.put("zhenlf", zlf);
		args.put("ghf", szje_ghf);
		args.put("jmbz", kxsybsqjmbz);
		args.put("xsywlx", "");
		args.put("jgid", jgid);
		args.put("orgid", orgid);
		args.put("ip",ip);
		args.put("ygdm",req.getYgdm());
		args.put("ygxm",req.getYgxm());
		if (req.getIsGs() == 1) {
			args.put("persontype", "1");
		//	args.put("totalexpense", szje_ybfyze);
		//	args.put("ybjsfwfyze", szje_ybfyze);
		//	args.put("fybjsfwfyze", 0);
			args.put("totalexpense", szje_fyze);
			args.put("ybjsfwfyze", szje_ybfyze);
			args.put("fybjsfwfyze",  ghf.add(zjf).add(blf).add(ckf));
		}  else if("2".equals(tsdybs)  ) {
			args.put("persontype", "0");
			args.put("totalexpense", szje_fyze);
			args.put("ybjsfwfyze", szje_ybfyze);
			args.put("fybjsfwfyze", 0);
		} else if (req.getIsDb() == 1) {
			args.put("persontype", "0");
			args.put("totalexpense", szje_fyze);
			args.put("ybjsfwfyze", szje_ybfyze);
			args.put("fybjsfwfyze", ghf.add(zjf).add(blf).add(ckf));
		}else {
				args.put("persontype", "0");
				args.put("totalexpense", szje_fyze);
				args.put("ybjsfwfyze", szje_ybfyze);
				args.put("fybjsfwfyze", ghf.add(zjf).add(blf).add(ckf));
			}

		Map<String, Object> res = new HashMap<>();
		SettleResultDTO sh01res  = offLineSettle.prepareRegisterOp(res, args);
		if (sh01res.getCode() == 200) {
			String jsonData = sh01res.getData().toString();
			Map<String, Object> tmpMap = JackJsonUtil.parse(jsonData, Map.class);
			Map<String, Object> xxtMap = (Map<String, Object>)tmpMap.get("xxnr");
			xxtMap.put("jysj", tmpMap.get("jysj"));
			xxtMap.put("persontype", args.get("persontype"));
			xxtMap.put("jgdm", tmpMap.get("jgdm"));
			xxtMap.put("ksdm", args.get("deptid"));
			Map preRegisMap = xxtMap;
			String yb_zhbz = StrUtil.null2Str(preRegisMap.get("accountattr")).substring(11, 12);
			if ("2".equals(preRegisMap.get("personspectag")) ) {
				id_xjje = BigDecimal.valueOf(0);
				id_ybzf = new BigDecimal(preRegisMap.get("ybjsfwfyze")+"");
			} else {
				if (!"A".equals(yb_zhbz)) {
					if (req.getIsGs() == 1) {
						//id_xjje = new BigDecimal(preRegisMap.get("fybjsfwfyze") + "").add(zjf).add(id_blf);
						id_xjje = zjf.add(ghf)
								.add(blf).add(ckf);
						id_ybzf = new BigDecimal(preRegisMap.get("curaccountpay") + "")
								.add(new BigDecimal(preRegisMap.get("hisaccountpay") + ""))
								.add(new BigDecimal(preRegisMap.get("tczfs") + ""))
								.add(new BigDecimal(preRegisMap.get("fjzfs") + ""));
					} else if ("Y".equals(yb_zhbz)) {
						// 异地医保门诊预结算与结算数据有可能不同,支付方式请选择现金并以发票打印的收款金额为准
						id_ybzf = new BigDecimal(preRegisMap.get("curaccountpay") + "")
								.add(new BigDecimal(preRegisMap.get("hisaccountpay") + ""))
								.add(new BigDecimal(preRegisMap.get("tczfs") + ""))
								.add(new BigDecimal(preRegisMap.get("fjzfs") + ""));
						id_xjje = id_ghf.add(id_zlf).add(id_ybzf);
					} else {
						id_xjje =/* new BigDecimal(preRegisMap.get("zfdxjzfs") + "")
								.add(new BigDecimal(preRegisMap.get("tczfs") + ""))
								.add(new BigDecimal(preRegisMap.get("fjdxjzfs") + "")).add(zjf).add(ghf)
								.add(blf).add(ckf);*/
								zjf.add(ghf).add(blf).add(ckf)
										.add(new BigDecimal(preRegisMap.get("zfdxjzfs") + ""))
										.add(new BigDecimal(preRegisMap.get("tcdxjzfs") + ""))
										.add(new BigDecimal(preRegisMap.get("fjdxjzfs") + ""));
						id_ybzf = new BigDecimal(preRegisMap.get("curaccountpay") + "")
								.add(new BigDecimal(preRegisMap.get("hisaccountpay") + ""))
								//.add(new BigDecimal(preRegisMap.get("zfdxjzfs")+""))
								.add(new BigDecimal(preRegisMap.get("zfdlnzhzfs")+""))
								.add(new BigDecimal(preRegisMap.get("tcdzhzfs")+""))
								//.add(new BigDecimal(preRegisMap.get("tcdxjzfs")+""))
								.add(new BigDecimal(preRegisMap.get("tczfs") + ""))
								.add(new BigDecimal(preRegisMap.get("fjdzhzfs") + ""))
								//.add(new BigDecimal(preRegisMap.get("fjdxjzfs") + ""))
								.add(new BigDecimal(preRegisMap.get("fjzfs") + ""));
					}
				} else {
					id_ybzf = new BigDecimal(preRegisMap.get("curaccountpay") + "")
							.add(new BigDecimal(preRegisMap.get("hisaccountpay") + ""))
							.add(new BigDecimal(preRegisMap.get("zfdxjzfs")+""))
							.add(new BigDecimal(preRegisMap.get("zfdlnzhzfs")+""))
							.add(new BigDecimal(preRegisMap.get("tcdzhzfs")+""))
							.add(new BigDecimal(preRegisMap.get("tcdxjzfs")+""))
							.add(new BigDecimal(preRegisMap.get("tczfs") + ""))
							.add(new BigDecimal(preRegisMap.get("fjdzhzfs") + ""))
							.add(new BigDecimal(preRegisMap.get("fjdxjzfs") + ""))
							.add(new BigDecimal(preRegisMap.get("fjzfs") + ""));
					id_xjje = ld_zfje.subtract(id_ybzf);
				}
			}
			if (!"Y".equals(yb_zhbz)) {// 减免现金
				BigDecimal ld_czjm = new BigDecimal(preRegisMap.get("fybjsfwfyze") + "");
				if ("0".equals(preRegisMap.get("jmjsbz"))) {
					id_xjje = id_xjje;
				} else if ("1".equals(preRegisMap.get("jmjsbz"))) {
					id_xjje = id_xjje.subtract(id_ghf).subtract(id_zlf);
				} else if ("2".equals(preRegisMap.get("jmjsbz"))) {
					id_xjje = id_xjje.subtract(ld_czjm);
				}
			}
			ld_zfje = id_xjje;
			BigDecimal ld_xjje = ld_zfje;
			BigDecimal ld_zhje = new BigDecimal(0);
			BigDecimal fyze = new BigDecimal(0);
			if ("Y".equals(preRegisMap.get("accountattr"))) {
				fyze = id_ybzf;
			} else {
				fyze = new BigDecimal(preRegisMap.get("totalexpense") + "")
						.subtract(new BigDecimal(preRegisMap.get("zfdxjzfs") + ""))
						.subtract(new BigDecimal(preRegisMap.get("tcdxjzfs") + ""))
						.subtract(new BigDecimal(preRegisMap.get("fjdxjzfs") + ""));
			}
			// 预结算结果
			BigDecimal ybje = fyze;
			BigDecimal ysk = ld_zfje; // ld_zfje_d1
			BigDecimal xjje = ld_xjje; // ld_xjje_d2
			BigDecimal zhje = ld_zhje; // ld_zhje_d3
			preRegisMap.put("jgdm", ybksdm);
			preRegisMap.put("carddata", req.getCardid());
			//preRegisMap.put("mzbs", map_orgid.get("mzlb"));
			preRegisMap.put("mzbs", "1");
			preRegisMap.put("ksdm", ybksdm);
			shybSh01Service.insertShybsh01(preRegisMap);
			map.put("ybje", ybje);
			map.put("ysk", ysk);
			map.put("xjje", xjje);
			map.put("zhje", zhje);
			map.put("code", "0");
			map.put("ghf", szje_ghf);
			map.put("zlf", zlf);
			map.put("yllb", yllb);
			map.putAll(preRegisMap);
		} else {
			Integer code = sh01res.getCode();
			String msg = sh01res.getMsg();
			throw BaseException.create("ERROR_SHYB_0020", new String[] { code+"", msg + "" });
		}
		return map;
	}

	/**
	 * 更新病人档案大病标志
	 *
	 * @param brid
	 * @param dbtype
	 */
	public void doUpdateDbdm(Integer brid, String dbtype) {
		mpiBrdaDao.updateDbbz(brid, dbtype);
	}


	/**
	 * 结算管理-病人医保读卡
	 * @param carddata
	 * @param ip
	 * @param
	 * @return
	 */
	public ReturnEntity<SM01Res> readPatientMedicareAccountInfo(String carddata, String cardtype,String ip,SysUser user,String type) {
		if("".equals(StrUtil.null2Str(cardtype))){
			throw BaseException.create("ERROR_SHYB_0044");
		}
		String ecToken = carddata;
		if("1".equals(cardtype)){
			ecToken = "";
		}
		Map<String,Object> map = new HashMap<>();
		Map<String,Object> res = new HashMap<>();
		Map<String,Object> res_s = new HashMap<>();
		if("0".equals(cardtype) && carddata.length()!=28){
			throw BaseException.create("ERROR_SHYB_0045",new String[]{carddata});
		}else if("3".equals(cardtype) && "".equals(StrUtil.null2Str(carddata))){
			throw BaseException.create("ERROR_SHYB_0045",new String[]{carddata});
		}
		String orgid = "";
		Map map_orgid = opMzlbService.getYbjgdm(user.getHospitalId(),ip);
		if(map_orgid!=null && !map_orgid.isEmpty()){
			orgid = map_orgid.get("ybjgid").toString();
		}else{
			throw BaseException.create("ERROR_SHYB_0015");
		}
		if("3".equals(cardtype)){
			SE01Res se01res = new SE01Res();
			Map<String,Object> se01_map = new HashMap<>();
			se01_map.put("orgId",orgid);
			se01_map.put("ecQrCode",carddata);
			se01_map.put("ecQrChannel","");
			se01_map.put("ywlx","1");
			se01_map.put("operatorId",user.getUserId());
			se01_map.put("operatorName",user.getUserName());
			se01_map.put("ip",ip);
			se01_map.put("jgid",user.getHospitalId());
			se01_map.put("ygdm",user.getUserId());
			se01_map.put("ygxm",user.getUserName());
			SettleResultDTO se01_res = offLineSettle.se01(se01_map);
			if(se01_res.getCode()== 200) {
				System.out.println(se01_res);
				String json = se01_res.getData().toString();
				Map<String, Object> tempMap = JackJsonUtil.parse(json, Map.class);
				Map<String, Object> a = (Map<String, Object>) tempMap.get("xxnr");
				ecToken = StrUtil.null2Str(a.get("ecToken"));
			}else{
				throw BaseException.create("ERROR_SHYB_0046",
						new String[] { se01_res.getCode() + "--" + se01_res.getMsg() + "" });
			}
		}

		SM01Res sm01res = new SM01Res();
		map.put("cardtype",cardtype);
		map.put("carddata",ecToken);
		map.put("ip",ip);
		map.put("xxlxm","SM01");
		map.put("orgId",orgid);
		map.put("jgid",user.getHospitalId());
		map.put("ygdm",user.getUserId());
		map.put("ygxm",user.getUserName());
		//s000
    //    map.put("xxlxm","S000");
  //      SettleResultDTO s000_res = offLineSettle.send(res,map);
        //s000end
        map.put("xxlxm","SM01");
		System.out.println("aaaaaaa");
		SettleResultDTO sm01_res = offLineSettle.send(res,map);
		if(sm01_res.getCode()== 200){
			System.out.println(sm01_res);
			String json = sm01_res.getData().toString();
			Map<String,Object> tempMap = JackJsonUtil.parse(json,Map.class);
			Map<String,Object> a = (Map<String, Object>) tempMap.get("xxnr");
			sm01res= cn.hutool.core.bean.BeanUtil.fillBeanWithMapIgnoreCase(a, new SM01Res(), true);
			if("1".equals(cardtype)){
				sm01res.setEcToken(StrUtil.null2Str(a.get("cardid")));
			}else {
				sm01res.setEcToken(ecToken);
			}
			String zhbz = sm01res.getAccountattr();
			String ztqk = zhbz.substring(0,1);
			String bjdx = zhbz.substring(1,2);
			String gwy = zhbz.substring(2,3);
			String tsrybz = zhbz.substring(3,4);
			String fcbz = zhbz.substring(4,5);
			String ybxz = zhbz.substring(11,12);
			int brxz = 4001;
            Map<String,Object> map_zhbz = shybZhbzService.getZhbzBrxz(ybxz);
            if(map_zhbz==null){
                throw BaseException.create("ERROR_SHYB_0015");
            }else{
                brxz = Integer.parseInt(map_zhbz.get("BRXZ")+"");
            }
            sm01res.setBrxz(brxz);
			if("1".equals(ztqk)){
				sm01res.setZtqk("在职");
			}else if("2".equals(ztqk)){
				sm01res.setZtqk("退休");
			}else if("3".equals(ztqk)){
				sm01res.setZtqk("离休");
			}else{
				sm01res.setZtqk(ztqk);
			}
			if("1".equals(bjdx)){
				sm01res.setBjdx("保健对象");
			}else{
				sm01res.setBjdx("非保健对象");
			}
			if("1".equals(gwy)){
				sm01res.setGwy("公务员");
			}else if("2".equals(gwy)){
				sm01res.setGwy("参照公务员");
			}else{
				sm01res.setGwy("非公务员");
			}
			if("1".equals(tsrybz)){
				sm01res.setTsrybz("离休");
			}else if("2".equals(tsrybz)){
				sm01res.setTsrybz("伤残");
			}else{
				sm01res.setTsrybz("普通");
			}
			if("1".equals(fcbz)){
				sm01res.setFcbz("封存");
			}else{
				sm01res.setFcbz("正常");
			}
			sm01res.setJzkh(sm01res.getCardid());
			sm01res.setBrxb(sm01res.getXb());
			sm01res.setBrxm(sm01res.getPersonname());
			sm01res.setZjlx("01");
			//sm01res.setSfzh("320681199404210052");
		}else {
			throw BaseException.create("ERROR_SHYB_0018",
					new String[] { sm01_res.getCode() + "--" + sm01_res.getMsg() + "" });
		}
		if("2".equals(type)){
			map.put("xxlxm","S000");
			map.put("jgid",user.getHospitalId());
			SettleResultDTO s000_res = offLineSettle.send(res_s,map);
			if(s000_res.getCode()== 200){
				String s000_json = s000_res.getData().toString();
				Map<String,Object> s000_tempMap = JackJsonUtil.parse(s000_json,Map.class);
				Map<String,Object> b = (Map<String, Object>) s000_tempMap.get("xxnr");
				sm01res.setSfzh(StrUtil.null2Str(b.get("sfzh")));
				sm01res.setLxdh(StrUtil.null2Str(b.get("lxdh")));
				sm01res.setTxdz(StrUtil.null2Str(b.get("txdz")));
				sm01res.setYzbm(StrUtil.null2Str(b.get("yzbm")));
				sm01res.setXzqh(StrUtil.null2Str(b.get("xzqh")));
			}
		}
		return ReturnEntityUtil.success(sm01res);
	}

	/**
	 * 挂号管理查询分诊病人信息
	 *
	 * @param jzkh
	 * @param brxm
	 * @param jgid
	 * @param fzrq
	 * @return
	 */
	public List<QueryYjfzbrResp> doQueryYjfzbrInfo(String jzkh, String brxm, Integer jgid, java.sql.Date fzrq) {
		Timestamp beginOfDay = null;
		Timestamp endOfDay = null;
		if (fzrq != null) {
			beginOfDay = DateUtil.beginOfDay(fzrq).toTimestamp();
			endOfDay = DateUtil.endOfDay(fzrq).toTimestamp();
		}
		return opGhksDao.doQueryYjfzbrInfo(jzkh, brxm, jgid, fzrq, beginOfDay, endOfDay);
	}

	/**
	 * 挂号管理分诊病人信息调入
	 *
	 * @param lsh
	 * @return
	 */
	public YjfzBrdaResp doGetYjfzLsh(Integer lsh) {
		YjfzBrdaResp erPreYjfz = erPreYjfzDao.getByLsh(lsh, "0");
		if (erPreYjfz != null) {
			if (!"".equals(erPreYjfz.getJzkh()) && erPreYjfz.getJzkh() != null) {
				mpiBrdaDao.updateLshByJzkh(lsh, erPreYjfz.getJzkh());
			}
		}
		return erPreYjfz;
	}

	public List<PubBrxzsResp> queryBrxz() {
		return opGhksDao.doQueryBrxzInfo();
	}

	/**
	 * 工伤认定号查询
	 * @param carddata
	 * @param ip
	 * @param
	 * @return
	 */
	public void checkGs(String carddata, String cardtype, String gsrdh, String brid, String ip, SysUser user) {
		String isgs="0";
		if("".equals(StrUtil.null2Str(cardtype))){
			throw BaseException.create("ERROR_SHYB_0044");
		}
		if("".equals(StrUtil.null2Str(gsrdh))){
			throw BaseException.create("ERROR_SHYB_0049");
		}
		String ecToken = carddata;
		if("1".equals(cardtype)){
			ecToken = "";
		}
		Map<String,Object> map = new HashMap<>();
		Map<String,Object> res = new HashMap<>();
		Map<String,Object> res_s = new HashMap<>();
		if("0".equals(cardtype) && carddata.length()!=28){
			throw BaseException.create("ERROR_SHYB_0045",new String[]{carddata});
		}else if("3".equals(cardtype) && "".equals(StrUtil.null2Str(carddata))){
			throw BaseException.create("ERROR_SHYB_0045",new String[]{carddata});
		}
		String orgid = "";
		Map map_orgid = opMzlbService.getYbjgdm(user.getHospitalId(),ip);
		if(map_orgid!=null && !map_orgid.isEmpty()){
			orgid = map_orgid.get("ybjgid").toString();
		}else{
			throw BaseException.create("ERROR_SHYB_0015");
		}
		if("3".equals(cardtype)){
			SE01Res se01res = new SE01Res();
			Map<String,Object> se01_map = new HashMap<>();
			se01_map.put("orgId",orgid);
			se01_map.put("ecQrCode",carddata);
			se01_map.put("ecQrChannel","");
			se01_map.put("ywlx","1");
			se01_map.put("operatorId",user.getUserId());
			se01_map.put("operatorName",user.getUserName());
			se01_map.put("ip",ip);
			se01_map.put("jgid",user.getHospitalId());
			se01_map.put("ygdm",user.getUserId());
			se01_map.put("ygxm",user.getUserName());
			SettleResultDTO se01_res = offLineSettle.se01(se01_map);
			if(se01_res.getCode()== 200) {
				System.out.println(se01_res);
				String json = se01_res.getData().toString();
				Map<String, Object> tempMap = JackJsonUtil.parse(json, Map.class);
				Map<String, Object> a = (Map<String, Object>) tempMap.get("xxnr");
				ecToken = StrUtil.null2Str(a.get("ecToken"));
			}else{
				throw BaseException.create("ERROR_SHYB_0046",
						new String[] { se01_res.getCode() + "--" + se01_res.getMsg() + "" });
			}
		}
		SJG1 sjg1res = new SJG1();
		map.put("cardtype",cardtype);
		map.put("carddata",ecToken);
		map.put("ip",ip);
		map.put("xxlxm","SJG1");
		map.put("orgId",orgid);
		map.put("jgid",user.getHospitalId());
		map.put("ygdm",user.getUserId());
		map.put("ygxm",user.getUserName());
		System.out.println("aaaaaaa");
		SettleResultDTO sjg1_res = offLineSettle.send(res,map);
		if(sjg1_res.getCode()== 200){
			String json = sjg1_res.getData().toString();
			Map<String, Object> tempMap = JackJsonUtil.parse(json, Map.class);
			Map<String, Object> b = (Map<String, Object>) tempMap.get("xxnr");
			sjg1res = cn.hutool.core.bean.BeanUtil.fillBeanWithMapIgnoreCase(b, new SJG1(), true);
			List<SJG1Res> gsrdhList = sjg1res.getGSXXS();
			if(gsrdhList.size()>0 && !gsrdhList.isEmpty()){
				for(int i =0;i<gsrdhList.size();i++){
					String gsrdh_yb = gsrdhList.get(i).getGsrdh();
					if(gsrdh_yb.equals(gsrdh)){
						isgs="1";
						mpiBrdaDao.updateGsrdh(brid, gsrdh);
					}
				}
				if("0".equals(isgs)){
					throw BaseException.create("ERROR_SHYB_0048");
				}
			}
		}else {
			throw BaseException.create("ERROR_SHYB_0018",
					new String[] { sjg1_res.getCode() + "--" + sjg1_res.getMsg() + "" });
		}
	}


	public void checkCardInfo(String jzkh, String sfzh, Integer hospitalId) {
		MpiCard request = new MpiCard();
		request.setCardno(jzkh);
		request.setCreateunit(hospitalId.toString());
		MpiCard mpiCard = mpiCardDao.getMpiCardInfo(request);
		if(Objects.nonNull(mpiCard)){
			MpiBrda mpiBrda = mpiBrdaDao.getByBrid(mpiCard.getBrid(), hospitalId);
			if(Objects.nonNull(mpiBrda)){
				if(mpiBrda.getSfzh().equals(sfzh)) {
					throw BaseException.create("ERROR_REG_0050");
				} else {
					throw BaseException.create("ERROR_REG_0095");
				}
			}else {
				throw BaseException.create("ERROR_REG_0096");
			}
		}
	}

	public List<MpiBrdaAndCardResp> doQueryPersonByName(String name, java.sql.Date csrq, Integer brxb) {
		List<MpiBrdaAndCardResp> mpiBrdaAndCardRespList = new ArrayList<>();
		List<MpiBrda> mpiBrdaList = mpiBrdaDao.getBrdaByName(name, csrq, brxb);
		if(CollUtil.isNotEmpty(mpiBrdaList)){
			mpiBrdaList.forEach( o -> {
				MpiCard card = new MpiCard();
				card.setBrid(o.getBrid());
				// 根据病人ID查询卡信息
				List<MpiCard> mpiCardList = mpiCardDao.findByEntity(card);
				// 病人信息
				OpGhmxInfo opGhmxInfo = new OpGhmxInfo();
				opGhmxInfo.setBrid(o.getBrid());
				MpiBrda mpiBrda = mpiBrdaDao.getByCondition(opGhmxInfo);
				DateTime date = IdcardUtil.getBirthDate(mpiBrda.getSfzh());
				Timestamp csny = DateUtil.date(date).toTimestamp();
				if (csny != null) {
					Map<String, Object> agMap = MzUtil.getPersonAge(csny, null);
					if (agMap != null && !agMap.isEmpty()) {
						mpiBrda.setAge(Integer.valueOf(agMap.get("age").toString()));
						mpiBrda.setAges(agMap.get("ages").toString());
					}
				}

				Integer sex = IdcardUtil.getGenderByIdCard(mpiBrda.getSfzh());
				mpiBrda.setCsny(csny);
				mpiBrda.setBrxb(sex != null && sex.intValue() == 0 ? 2 : 1);
				mpiBrda.setBrxz(null);
				// 放入病人信息
				MpiBrdaAndCardResp resp = new MpiBrdaAndCardResp();
				BeanUtils.copyProperties(mpiBrda, resp);
				resp.setCsny(date.toSqlDate());
				// 放入卡信息
				resp.setMpiCardList(mpiCardList);
				resp.setJzkh(null);
				mpiBrdaAndCardRespList.add(resp);
			});
		}
		return mpiBrdaAndCardRespList;
	}



/*
	public ReturnEntity<MessageBody> readPatientMedicareAccountInfos(String carddata, String cardtype,String ip,SysUser user) {
		if("".equals(StrUtil.null2Str(cardtype))){
			throw BaseException.create("ERROR_SHYB_0044");
		}
		String ecToken = carddata;
		if("1".equals(cardtype)){
			ecToken = "";
		}
		Map<String,Object> accountOptions = new HashMap<>();
		Map<String,Object> res = new HashMap<>();
		Map<String,Object> res_s = new HashMap<>();
		if("0".equals(cardtype) && carddata.length()!=28){
			throw BaseException.create("ERROR_SHYB_0045",new String[]{carddata});
		}else if("3".equals(cardtype) && "".equals(StrUtil.null2Str(carddata))){
			throw BaseException.create("ERROR_SHYB_0045",new String[]{carddata});
		}
		String orgid = "";
		Map map_orgid = opMzlbService.getYbjgdm(user.getHospitalId(),ip);
		if(map_orgid!=null && !map_orgid.isEmpty()){
			orgid = map_orgid.get("ybjgid").toString();
		}else{
			throw BaseException.create("ERROR_SHYB_0015");
		}
		if("3".equals(cardtype)){
			SE01Res se01res = new SE01Res();
			Map<String,Object> se01_map = new HashMap<>();
			se01_map.put("orgId",orgid);
			se01_map.put("ecQrCode",carddata);
			se01_map.put("ecQrChannel","");
			se01_map.put("ywlx","1");
			se01_map.put("operatorId",user.getUserId());
			se01_map.put("operatorName",user.getUserName());
			se01_map.put("ip",ip);
			se01_map.put("jgid",user.getHospitalId());
			se01_map.put("ygdm",user.getUserId());
			se01_map.put("ygxm",user.getUserName());
			SettleResultDTO se01_res = offLineSettle.se01(se01_map);
			if(se01_res.getCode()== 200) {
				System.out.println(se01_res);
				String json = se01_res.getData().toString();
				Map<String, Object> tempMap = JackJsonUtil.parse(json, Map.class);
				Map<String, Object> a = (Map<String, Object>) tempMap.get("xxnr");
				ecToken = StrUtil.null2Str(a.get("ecToken"));
			}else{
				throw BaseException.create("ERROR_SHYB_0046",
						new String[] { se01_res.getCode() + "--" + se01_res.getMsg() + "" });
			}
		}
		String orgId = orgid;
		int ygdm = user.getUserId();
		String ygxm = user.getUserName();
		TradingChannelEnum jyqd =TradingChannelEnum.OFFLINE;
		String cardType = cardtype;
		String cardData = ecToken;
		MessageBody messageBody = buildCommonMessageBody(orgId, ygdm,ygxm, MessageTypeEnum.SM01, jyqd);

		SM01 sm01 = new SM01();
		sm01.setCardtype(cardType);
		if (cardData != null && !"".equals(cardData)) {
			sm01.setCarddata(cardData);
		}else {
			sm01.setCarddata("");
		}
		messageBody.setXxnr(sm01);

		return ReturnEntityUtil.success(messageBody);
	}*/

	/*public MessageBody buildCommonMessageBody(String orgId, int operatorId,String operatorName,MessageTypeEnum messageType,
											  TradingChannelEnum tradingChannelEnum) {
		String msgId = getMsgId(orgId,9);
		MessageBody messageBody = new MessageBody();
		messageBody.setJysj(new Date());
		messageBody.setMsgid(msgId);
		messageBody.setJgdm(orgId);
		messageBody.setCzybm(operatorId);
		messageBody.setCzyxm(operatorName);
		messageBody.setXxlxm(messageType);
		messageBody.setJyqd(tradingChannelEnum);
		return messageBody;
	}*/

	/*public String getMsgId(String id,int size){
		String seqNumber  ="";
		StringBuilder msgId = new StringBuilder(30);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String currentDateString = simpleDateFormat.format(new Date());
		if(size==6){
			simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			currentDateString = simpleDateFormat.format(new Date());
		}
		if(seqNumber.length() >= size){
			seqNumber = seqNumber.substring(0,size);
		}else{
			seqNumber = StringUtils.leftPad(seqNumber, size, "0");
		}
		msgId.append(id).append(currentDateString).append(seqNumber);
		return msgId.toString();
	}*/



}
