package com.buit.cis.op.dctwork.service;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import com.buit.apply.response.OpZt02Resp;
import com.buit.cis.op.dctwork.request.*;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.commons.dao.*;
import com.buit.commons.enums.StatusEnum;
import com.buit.commons.model.*;
import com.buit.commons.response.*;
import com.buit.constans.TableName;
import com.buit.enums.MqMatching;
import com.buit.his.op.reg.enums.OpPjlxEnum;
import com.buit.his.op.reg.service.OpGhksSer;
import com.buit.his.op.reg.service.OpMzlbSer;
import com.buit.mq.RabbitMqProducer;
import com.buit.op.model.OpYsJzls;
import com.buit.op.response.MpiBrda;
import com.buit.op.response.SaveInitClinicInfoResp;
import com.buit.op.service.mphis.MphisOpService;
import com.buit.system.response.SysXtcs;
import com.buit.system.service.HrPersonnelService;
import com.buit.system.service.SysXtcsCacheSer;
import com.buit.system.utill.ObjectToTypes;
import com.buit.utill.ParamUtil;
import com.buit.utill.RedisFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 门诊_门诊病历 | 病程记录<br>
 * @author 老花生
 */
@Service
public class MsBcjlSer extends BaseManagerImp<MsBcjl,Integer> {

    static final Logger logger = LoggerFactory.getLogger(MsBcjlSer.class);

    @Autowired
    private MsBcjlDao msBcjlDao;
    @Autowired
    private OpCf01Dao opCf01Dao;
    @Autowired
    private OpYjcf01Dao opYjcf01Dao;
    @Autowired
    private OpBrzdDao opBrzdDao;
    @Autowired
    private HerHealthreciperecordMzDao herHealthreciperecordMzDao;
    @Autowired
    private OpGhmxDao opGhmxDao;
    @Autowired
    private OpYsJzlsDao opYsJzlsDao;
    @Autowired
    private RedisFactory redisFactory;
    //@Autowired
    //private HrPersonnelDao hrPersonnelDao;
    @DubboReference
    private HrPersonnelService hrPersonnelService;
    @DubboReference
	private SysXtcsCacheSer sysXtcsCacheSer;
    @Autowired
    private OpPdjhDao opPdjhDao;
    @Autowired
    private MpiBrdaDao mpiBrdaDao;
    @Autowired
    private HerHealthreciperecordDao herHealthreciperecordDao;
    @Autowired
    private OpKspbDao opKspbDao;
    @Autowired
    private OpMzlbSer opMzlbSer;
    @Autowired
    private OpYyghDao opYyghDao;
    @Autowired
    private OpGhksSer opGhksSer;
    @Autowired
    private OpYspbDao opYspbDao;
    @Autowired
    private OpCf02Dao opCf02Dao;
    @Autowired
    private OpZt02Dao opZt02Dao;
    @Autowired
    private DrugsTypkDao drugsTypkDao;
    @Autowired
    private BUHISUtil buhisutil;
    @Autowired
    private OpZspdxxDao opZspdxxDao;
    @Autowired
    private OpMzzsDao opMzzsDao;
    @Autowired
    RabbitMqProducer rabbitMqProducer;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @DubboReference
    private MphisOpService mphisOpService;
    @Autowired
    private OpGhksDao opGhksDao;

    @Override
    public MsBcjlDao getEntityMapper(){
        return msBcjlDao;
    }

//    /**
//     * 暂存 或 保存
//     * @param req
//     */
//    public void saveMsBcjl(PatientIndexToSaveReq req, SysUser user, String ip) {
//        Map<String, Object> body = BeanUtil.beanToMap(req);
//
//        String manageUnit = user.getHospitalIdStr();
//
//        body.put("JZXH", Long.parseLong(body.get("JZXH").toString()));
//        // 判断是否有处方处置,若都为0，则不更新就诊状态
//        Map<String, Object> params = new HashMap<>(16);
//        params.put("JZXH", body.get("JZXH"));
//
//        long cfCount = opCf01Dao.findByEntityCount(params);
//        long czCount = opYjcf01Dao.findByEntityCount(params);
//        long zdCount = opBrzdDao.findByEntityCount(params);
//        /** 2014-9-4 modify by yaosq 加健康处方判断 **/
//        params.put("JZXH", body.get("JZXH") + "");
//        long jkjyCount = herHealthreciperecordMzDao.findByEntityCount(params);
//        params.put("JZXH", body.get("JZXH"));
//        /** 2013-10-11 modify by gejj 去除门诊病历判断 **/
//        long hlCount = msBcjlDao.findByEntityCount(params);
//        long omrCount = omrBl01Dao.findByEntityCount(params);
//        if (cfCount == 0 && czCount == 0 && zdCount == 0
//                && hlCount == 0 && jkjyCount == 0 && omrCount == 0) {
//            /** 2013-10-11 end **/
//            params.put("JZZT", 0);
//            //update OP_GHMX set JZZT=:JZZT where SBXH=(select GHXH from OP_YS_JZLS  where JZXH=:JZXH)
//            opGhmxDao.updateJzzt(params);
//            params.remove("JZZT");
//            opYsJzlsDao.deleteByjzxh(params);
//            return;
//        }
//        /** 增加将病人去向和健康教育存到表MS_BCJL里 add by liuxy */
//        Map<String, Object> params3 = new HashMap<>(16);
//        params3.put("JZXH", Long.parseLong(body.get("JZXH").toString()));
//        long l = msBcjlDao.findByEntityCount(params3);
//        if (l <= 0) {
//            String op = "create";
//            body.put("JZYS", user.getUserId());// 获取员工代码暂时用该方法替代
//            body.put("JZKS", req.getJzks());
//            body.put("JGID", manageUnit);
//            body.put("BLLX", 1);
//
//            MsBcjl bcjl = BeanUtil.fillBeanWithMapIgnoreCase(body, new MsBcjl(), true);
//            bcjl.setJzxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.MS_BCJL));
//
//            msBcjlDao.insert(bcjl);
//        }
//        Map<String, Object> params2 = new HashMap<>(16);
//        int brqx = ObjectToTypes.parseInt(body.get("BRQX"));
//        String jkjy = body.get("JKJY") + "";
//        if (brqx > 0) {
//            params2.put("BRQX", brqx);
//            params2.put("JKJY", jkjy);
//            params2.put("JZXH", body.get("JZXH"));
//            // 新增DYBZ打印标志字段 保存再次打开病例反复提示打印病例 2015.5.18 by cqd
//            //update MS_BCJL set BRQX=:BRQX,JKJY=:JKJY,DYBZ='1' where JZXH=:JZXH
//            msBcjlDao.updateDybz(params2);
//        }
//        params.put("JZZT", body.get("JZZT"));
//        params.put("YSDM", user.getUserId() + "");// 获取员工代码暂时用该方法替代
//
//        if("0".equals(String.valueOf(body.get("updatingDoctor")))){
//            params.remove("YSDM");
//            //update OP_GHMX set JZZT=:JZZT where (JZZT=1 or JZZT=2) and SBXH=(select GHXH from OP_YS_JZLS  where JZXH=:JZXH)
//            opGhmxDao.updateJzztNotOver(params);
//            params.put("YSDM", user.getUserId() + "");// 获取员工代码暂时用该方法替代
//        }else{
//            //update OP_GHMX set JZZT=:JZZT, JZYS=:YSDM where (JZZT=1 or JZZT=2) and SBXH=(select GHXH from OP_YS_JZLS  where JZXH=:JZXH)
//            opGhmxDao.updateJzztJzys(params);
//        }
//
//        params.put("JSSJ", new Date());
//
//        //是否更新就诊医生
//        if("0".equals(String.valueOf(body.get("updatingDoctor")))){
//            params.remove("YSDM");
//            //update OP_YS_JZLS set JZZT=:JZZT,JSSJ=:JSSJ where JZXH=:JZXH and JZZT=1
//            opYsJzlsDao.updateJzztJssj(params);
//        }else{
//            //update OP_YS_JZLS set JZZT=:JZZT,JSSJ=:JSSJ,YSDM=:YSDM where JZXH=:JZXH and JZZT=1
//            opYsJzlsDao.updateJzztJssjYsdm(params);
//        }
//
//        //就诊结束时更新叫号信息
//        int jzzt = ObjectToTypes.parseInt(body.get("JZZT"));
//        if(jzzt == 9){
//            this.doClearCallXx(req.getGhks(), req.getSbxh(), user, ip);
//        }
//
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String today = sdf.format(date) + " 06:01:00";
//        String ksdm = "";
//        //select BSRUNKSDM from OP_GHKS where ksdm=:ksdm
//        Map<String, Object> ksdmMap = opGhksDao.getOldKsdm(ParamUtil.instance().put("ksdm", body.get("GHKS")));
//
//        if (ksdmMap != null) {
//            ksdm = String.valueOf(ksdmMap.get("BSRUNKSDM"));
//        }
//        String ysdm = body.get("ysdm").toString();
//        // 获得老系统员工代码
//        //select YGDM from HR_PERSONNEL where personid=:pid
//        Map<String, Object> ygdmMap = hrPersonnelDao.getYgdm(ParamUtil.instance().put("pid", body.get("YSDM")));
//
//        if (ksdmMap != null) {
//            ysdm = String.valueOf(ygdmMap.get("ysdm"));
//        }
//    }

    /**
     * 清除叫号信息(最后一个病人的叫号信息)
     * @param ksdm  就诊科室
     * @param sbxh  识别序号
     * @param user  用户信息
     * @param ip    ip
     */
    private void doClearCallXx(Integer ksdm, Integer sbxh, SysUser user, String ip) {

        String uid= user.getUserIdStr();
        //社区叫号模式启用时间(HH:mm:ss)
        String sqjhsj = sysXtcsCacheSer.getByJGIdAndCsmc(user.getHospitalId(), "SQJHSJ").getCsz();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String today = df.format(new Date()) +" " + sqjhsj;

        String zsid = "";

        Map<String, Object> pamargs  = sysXtcsCacheSer.doLoadThisComputerArgs(ParamUtil.instance().put("names", "ZSID"), ip, user.getHospitalId());
        zsid = ObjectToTypes.parseString(pamargs.get("zsid"));
        if("".equals(zsid)){
            return;
        }

        Map<String, Object> par = new HashMap<>(16);
        par.put("KSDM", ksdm);
        par.put("YSDM", uid);
        par.put("ZSID", zsid);
        par.put("GHSB", sbxh);
        par.put("JHTX", 2);
        par.put("TODAY", today);
        par.put("JHHM", "停诊");

        //delete OP_PDJH  where KSDM='"+ksdm+"' and YSDM='"+uid+"' and ZSID='"+ZSID+"' and GHSB='"+sbxh+"' and JHTX='2' and to_char(JHSJ,'yyyy-mm-dd hh24:mi:ss') >= '"+today+"'
        opPdjhDao.deleteByObj(par);

        //select count(1) as COUNT from OP_PDJH where KSDM='"+ksdm+"' and YSDM='"+uid+"' and ZSID='"+ZSID+"' and JHTX='2' and GHSB !='"+sbxh+"' and JHHM !='停诊' and to_char(JHSJ,'yyyy-mm-dd hh24:mi:ss') >= '"+today+"'
        Long count = opPdjhDao.findByMapCount(par);
        if(count == null || count==0){
            //update OP_PDJH set JHZT= 1 where KSDM='"+ksdm+"' and YSDM='"+uid+"' and ZSID='"+ZSID+"' and GHSB='"+sbxh+"' and JHZT='0' and toChar(JHSJ,'yyyy-mm-dd hh24:mi:ss') >= '"+today+"'
            opPdjhDao.updateJhzt(par);
        }
    }

    /**
     * 保存病历信息
     * @param body
     * @param user
     */
    public void saveMsBcjl(Map<String, Object> body, SysUser user) {
        Map<String, Object> params = new HashMap<>(16);
        String manageUnit = user.getHospitalIdStr();
        List<Map<String, Object>> jkcfs = new ArrayList<>();
        if(body.get("jkcf") != null){
            jkcfs = BUHISUtil.ListObjToMap((List<MsBcjljKcfReq>)body.get("jkcf")) ;
        }
        String jzxh = body.get("jzxh") + "";
        body.remove(jkcfs);
        List<Map<String, Object>> updateList = new ArrayList<>();
        List<Map<String, Object>> createList = new ArrayList<>();
        List<Map<String, Object>> removeList = new ArrayList<>();

        params.put("jzxh", Long.parseLong(body.get("jzxh").toString()));
        long l = msBcjlDao.findByEntityCount(params);
        body.put("JZYS", user.getUserId() + "");// 获取员工代码暂时用该方法替代
        body.put("JZKS", body.get("jzks"));
        body.put("JGID", manageUnit);
        body.put("BLLX", 1);
        body.put("DYBZ", 0);

        if(l == 0){
            //body.put("jzxh", redisFactory.getTableKey(TableName.DB_NAME, TableName.MS_BCJL));
            msBcjlDao.insert(body);
        }else{
            msBcjlDao.update(body);
        }


        Integer brid = ObjectToTypes.parseInt(body.get("brid"));
        MpiBrda brda = mpiBrdaDao.getById(brid);
        Map<String, Object> empiIdMap = BeanUtil.beanToMap(brda);
        String empiId = empiIdMap.get("empiid") + "";

        HerHealthreciperecordMz hhm = new HerHealthreciperecordMz();
        hhm.setWayid(jzxh);
        hhm.setSortColumns(" recordId ");
        List<HerHealthreciperecordMz> retlist = herHealthreciperecordMzDao.findByEntity(hhm);
        List<Map<String, Object>> list = BUHISUtil.ListObjToMap(retlist);


        for(Map<String, Object> m : jkcfs) {
            boolean isUpdate = false;
            for (Map<String, Object> map : list) {
                if (m.get("diagnoseId").equals(map.get("diagnoseId"))) {
                    m.put("id", map.get("id"));
                    isUpdate = true;
                    break;
                }
            }
            Map<String, Object> mBody = new HashMap<>(16);
            mBody.put("empiId", empiId);
            mBody.put("recordId", m.get("recordId"));
            mBody.put("wayId", jzxh);
            mBody.put("recipeName", m.get("recipeName"));
            mBody.put("diagnoseName", m.get("diagnoseName"));
            mBody.put("diagnoseId", m.get("diagnoseId"));
            mBody.put("ICD10", m.get("ICD10"));
            mBody.put("healthTeach", m.get("healthTeach"));
            mBody.put("examineUnit", body.get("jzks"));
            mBody.put("guideDate", new Date());
            mBody.put("guideUser", user.getUserId() + "");
            mBody.put("guideWay", "01");
            mBody.put("lastModifyUnit", manageUnit);
            mBody.put("lastModifyDate", new Date());
            mBody.put("lastModifyUser", user.getUserId() + "");
            if (isUpdate == true) {
                mBody.put("id", m.get("id"));
                updateList.add(mBody);
            } else {
                mBody.put("inputUnit", manageUnit);
                mBody.put("inputDate", new Date());
                mBody.put("inputUser", user.getUserId() + "");
                createList.add(mBody);
            }
        }
        for (Map<String, Object> map : list) {
            boolean isRemove = true;
            for(Map<String, Object> m : jkcfs) {
                if (m.get("diagnoseId").equals(map.get("diagnoseId"))) {
                    isRemove = false;
                    break;
                }
            }
            if (isRemove == true) {
                removeList.add(map);
            }
        }
        list.clear();
        for (Map<String, Object> map : createList) {

            map.put("id", redisFactory.getTableKey(TableName.DB_NAME, TableName.HER_HealthRecipeRecord_MZ));
            herHealthreciperecordMzDao.insert(map);

            map.put("childId", redisFactory.getTableKey(TableName.DB_NAME, TableName.HER_HealthRecipeRecord_MZ));
            map.put("id", redisFactory.getTableKey(TableName.DB_NAME, TableName.HER_HEALTHRECIPERECORD));
            herHealthreciperecordDao.insert(map);

            list.add(map);
        }
        for (Map<String, Object> map : updateList) {
            herHealthreciperecordMzDao.update(map);

            Map<String, Object> parameters = new HashMap<>(16);
            parameters.put("childId", map.get("id"));
            parameters.put("guideWay", "01");
            List<HerHealthreciperecord> retList = herHealthreciperecordDao.findByEntity(parameters);
            Map<String, Object> result2 = null;
            if(!retList.isEmpty()){
                HerHealthreciperecord hh = retList.get(0);
                result2 = BeanUtil.beanToMap(hh);
            }

            String zjId = result2.get("id") + "";
            result2.putAll(map);
            result2.put("id", zjId);

            herHealthreciperecordDao.update(result2);
            list.add(map);
        }
        for (Map<String, Object> map : removeList) {
            herHealthreciperecordMzDao.deleteById(map.get("id").toString());

            Map<String, Object> parameters = new HashMap<>(16);
            parameters.put("childId", map.get("id"));
            parameters.put("guideWay", "01");
            List<HerHealthreciperecord> retList = herHealthreciperecordDao.findByEntity(parameters);
            Map<String, Object> result2 = null;
            if(!retList.isEmpty()){
                HerHealthreciperecord hh = retList.get(0);
                result2 = BeanUtil.beanToMap(hh);
            }

            herHealthreciperecordDao.deleteById(result2.get("id").toString());
        }
    }

    /**
     * 病历复制
     * @param req
     * @param user
     */
    public MsBcjlCopyResp copy(MsBcjlCopyReq req, SysUser user) {
        MsBcjl bcjl = new MsBcjl();
        bcjl.setBrid(req.getBrid());
        bcjl.setJzxh(req.getJzxh());
        bcjl.setSortColumns(" JZXH desc ");
        List<MsBcjl> retList = msBcjlDao.findByEntity(bcjl);

        if(retList.isEmpty()){
            throw BaseException.create("ERROR_DCTWORK_OP_0009");
        }else{
            MsBcjl retBcjl = retList.get(0);
            HerHealthreciperecordMz hhm = new HerHealthreciperecordMz();
            hhm.setWayid(retBcjl.getJzxh().toString());
            hhm.setGuideway("01");
            List<HerHealthreciperecordMz> hhmList = herHealthreciperecordMzDao.findByEntity(hhm);

            MsBcjlCopyResp bcjlResp = com.buit.utill.BeanUtil.toBean(retBcjl, MsBcjlCopyResp.class);
            List<HerHealthreciperecordMzCopyResp> jkcfRecords = com.buit.utill.BeanUtil.toBeans(hhmList, HerHealthreciperecordMzCopyResp.class);

            bcjlResp.setJkcfRecords(jkcfRecords);

            return bcjlResp;
        }

    }

    /**
     * 查询排版科室
     * @param req
     * @param user
     * @return
     */
    public List<QueryShiftDeptResp> queryShiftDept(QueryShiftDeptReq req, SysUser user, String ip) {
        // 获取门诊类别
        Integer mzlb = opMzlbSer.getMzlb(user.getHospitalId(), ip);

        Map<String, Object> parameters = new HashMap<>(16);
        parameters.put("JGID", user.getHospitalId());
        parameters.put("MZLB", mzlb);
        parameters.put("GHRQ", DateUtil.format(new Date(), "yyyy-MM-dd"));
        parameters.put("ZBLB", req.getZblb());
        parameters.put("YYRQ", req.getGhrq());
        parameters.put("KSDM", req.getKslb());

        List<Map<String, Object>> list = opKspbDao.getYyKspbList(parameters);
        List<QueryShiftDeptResp> resp = BUHISUtil.ListToResultSet(list, new QueryShiftDeptResp());

        return resp;
    }

//    /**
//     * 存预约挂号
//     * @param req
//     * @param user
//     */
//    public void saveAppointedInfomation(SaveAppointmentRegistrationReq req, SysUser user) {
//        Map<String, Object> saveInformation = BeanUtil.beanToMap(req);
//        String uid = user.getUserIdStr() ;
//        saveInformation.put("DJGH", uid);
//        saveInformation.put("SFQH", 0);
//        saveInformation.put("PDHM", DateUtil.now());
//        //科室更新预约人数
//        opGhksDao.updateYyrs(saveInformation);
//
//        //保存预约挂号信息
//        saveInformation.put("YYXH", redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YYGH));
//        OpYygh yygh = BeanUtil.fillBeanWithMapIgnoreCase(saveInformation, new OpYygh(), true);
//        opYyghDao.insert(yygh);
//
//        Map<String,Object> m = new HashMap<String,Object>(16);
//        m.put("yyxh", saveInformation.get("YYXH"));
//        m.put("yyrq", saveInformation.get("YYRQ"));
//        m.put("ksdm", saveInformation.get("KSDM"));
//        m.put("ywlx", 11);
//        m.put("zsid", 0);
//        //生排队序号
//        opGhksSer.doSetQueue(m);
//
//        if(saveInformation.get("YSDM")!=null){
//            //医生排班预约人数+1
//            opYspbDao.updateYyrs(saveInformation);
//        }
//    }

    /**
     * 清空
     * @param req
     */
    public void remove(MsBcjlRemoveReq req) {
        msBcjlDao.deleteById(req.getClinicId());
    }

    /**
     * @name: saveInitClinicInfo
     * @description: 选择病人后，初始化病人就诊信息  (分诊叫号)
     * @param body
     * @param userId
     * @param jgid
     * @param ip
     * @return: com.buit.cis.op.dctwork.response.SaveInitClinicInfoResp
     * @date: 2020/9/8 16:29
     * @auther: 朱智
     *
     */
    @Transactional(rollbackFor = Exception.class)
    public SaveInitClinicInfoResp saveInitClinicInfo(Map<String, Object> body, Integer userId, Integer jgid, String ip) {
        //更新指定医生、就诊状态
        String lastLoginIp = hrPersonnelService.getPersonnelById(userId).getLastLoginIp();
        //String lastLoginIp = hrPersonnelDao.getById(userId).getLastLoginIp();
        Integer zsid = opMzzsDao.getSbxhByIp(lastLoginIp);
        opZspdxxDao.updateZdysJzztByOid(ObjectToTypes.parseString(body.get("jzlsh")), userId, zsid);
        //更新挂号医生
        opGhmxDao.updateYsdmByJzlsh(ObjectToTypes.parseString(body.get("jzlsh")), userId);

        SaveInitClinicInfoResp resp = new SaveInitClinicInfoResp();
        // 判断挂号信息是否存在
        Map<String, Object> parameters = new HashMap<>(16);
        String manageUnit = jgid.toString();
        Integer reg_ksdm = ObjectToTypes.parseInt(body.get("ghks"));//挂号科室
        // 是否自动挂号
        String yxwggbrjz = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, "YXWGHBRJZ").getCsz();
        // 挂号有效期
        String ghxq = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, "GHXQ").getCsz();
        // 效期计算方式
        String xqjsfs = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, "XQJSFS").getCsz();

        Integer regId = null;
        // 挂号有效期
        Date now = new Date();
        if ("1".equals(xqjsfs)) {
            now = DateUtil.endOfDay(now);
        }
        Date regBegin = DateUtils.addDays(now, -Integer.parseInt(ghxq));

        // 取出年龄放入mpi
        Integer brid = ObjectToTypes.parseInt(body.get("brid"));

        int age = 0;
        if (brid != null) {
            MpiBrda brda = mpiBrdaDao.getById(brid);
            Timestamp csny = brda.getCsny();
            age = ObjectToTypes.parseInt(BUHISUtil.getPersonAge(csny, null).get("age"));
            if(brda == null){
                throw BaseException.create("ERROR_DCTWORK_OP_0017");
            }
        }

        Object sbxh = body.get("sbxh");// 挂号明细表的
        // 1、如果sbxh为空且YXWGGBRJZ为1时，自动插入挂号信息
        if (sbxh == null) {
            if (!yxwggbrjz.equals("1")) {
                throw BaseException.create("ERROR_DCTWORK_OP_0018");
            }
            // 判断有效期内是否有挂号信息
            Map<String, Object> params = new HashMap<>(16);
            params.put("ghsj", regBegin);
            params.put("brid", brid);
            params.put("ksdm", reg_ksdm);
            regId = opGhmxDao.getMaxSbxh(params);
            if (regId == null) {
                // 根据当前医生获取就诊号码
                String clinicId = opGhksSer.getNotesNumber(userId, jgid, OpPjlxEnum.JZHM.getKey());
                // 就诊序号和就诊号码生成策略
                Map<String, Object> OP_GHMX = new HashMap<>(16);
                OP_GHMX.put("jzhm", "MGH" + clinicId);
                OP_GHMX.put("jzxh", 1);
                OP_GHMX.put("jgid", manageUnit);
                OP_GHMX.put("brid", brid);
                OP_GHMX.put("brxz", body.get("brxz"));
                OP_GHMX.put("ghsj", new Date());
                OP_GHMX.put("ghlb", body.get("ghlb"));
                OP_GHMX.put("ksdm", reg_ksdm);
                OP_GHMX.put("jzys", userId);// 获取员工代码暂时用该方法替代
                OP_GHMX.put("czgh", userId);// 获取员工代码暂时用该方法替代
                // 设置默认值
                params.clear();
                params.put("brid", brid);
                params.put("jgid", manageUnit);
                Long l = opGhmxDao.findByEntityCount(params);
                OP_GHMX.put("czpb", l > 0 ? 0 : 1);
                OP_GHMX.put("ghlb", 1);
                OP_GHMX.put("ghje", 0.00);
                OP_GHMX.put("ghcs", 1);
                OP_GHMX.put("thbz", 0);
                OP_GHMX.put("zlje", 0.00);
                OP_GHMX.put("zjfy", 0.00);
                OP_GHMX.put("blje", 0.00);
                OP_GHMX.put("xjje", 0.00);
                OP_GHMX.put("zpje", 0.00);
                OP_GHMX.put("zhje", 0.00);
                OP_GHMX.put("hbwc", 0.00);
                OP_GHMX.put("qtys", 0.00);
                OP_GHMX.put("mzlb", opMzlbSer.getMzlb(jgid, ip));
                OP_GHMX.put("yspb", 0);
                OP_GHMX.put("sffs", 0);
                OP_GHMX.put("jzzt", 0);
                //查询就诊卡信息,优先查找医保
                parameters.clear();
                parameters.put("brid", brid);
                List<Map<String, Object>> jzkList = mpiBrdaDao.getCardInfo(parameters);
                for (Map<String, Object> jzk : jzkList) {
                    OP_GHMX.put("jzkh", jzk.get("cardno"));
                    if ("6021".equals(jzk.get("sjxz") + "")
                            && "98".equals(jzk.get("cardtypecode") + "")) {// 医保性质且能找到医保类型的卡
                        OP_GHMX.put("jzkh", jzk.get("cardno"));
                        break;
                    }
                    if ("1000".equals(jzk.get("sjxz") + "")
                            && ("01".equals(jzk.get("cardtypecode") + "") || "04"
                            .equals(jzk.get("CARDTYPECODE") + ""))) {
                        OP_GHMX.put("JZKH", jzk.get("CARDNO"));// 自费性质且能找到健康卡或者就诊卡
                        break;
                    }
                }

                regId = redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_GHMX);
                OP_GHMX.put("sbxh", regId);
                //创建挂号明细表，则把识别序号更换为最新的识别序号
                body.put("sbxh", regId);
                opGhmxDao.insert(OP_GHMX);
            }
        } else {
            regId = sbxh==null?null:Integer.parseInt(sbxh.toString());
        }

        if (regId > 0) {// 存在挂号信息，判断效期内是否有就诊记录
            // 更新OP_GHMX表的JZZT
            parameters.clear();
            parameters.put("sbxh", regId);
            parameters.put("jzys",  userId);
            if("0".equals(String.valueOf(body.get("updatingDoctor")))){
                //更新为就诊中根据sbxh
                opGhmxDao.updateInConsultationBySbxh(parameters);
            }else{
                //更新为就诊中根据sbxh、jzys
                opGhmxDao.updateInConsultationBySbxhAndJzys(parameters);
            }
            // OP_YS_JZLS表信息插入
            Map<String, Object> record = new HashMap<>();
            parameters.clear();
            parameters.put("ghxh", Long.parseLong(regId.toString()));
            parameters.put("brbh", brid);
            parameters.put("ksdm", reg_ksdm);
            parameters.put("querykssj", regBegin);
            parameters.put("sortColumns", " KSSJ desc ");
            List<OpYsJzls> ret = opYsJzlsDao.findByEntity(parameters);
            List<Map<String, Object>> jzlsList = BUHISUtil.ListObjToMap(ret);
            if (jzlsList.size() > 0) {
                // 判断就诊状态
                Integer jzzt = (Integer) jzlsList.get(0).get("jzzt");
                String ysdm = (String) jzlsList.get(0).get("ysdm");
                Integer jzxh = (Integer) jzlsList.get(0).get("jzxh");
                if (jzzt == 1) {
                    if (!userId.toString().equals(ysdm)) {// 获取员工代码暂时用该方法替代
                        throw BaseException.create("ERROR_DCTWORK_OP_0019");
                    }
                }
                // 修改状态为就诊中
                if("0".equals(String.valueOf(body.get("updatingDoctor")))){
                    record.clear();
                    record.put("jzxh", jzxh);
                    record.put("jzzt", 1);
                    record.put("ksdm", reg_ksdm);
                    opYsJzlsDao.updateJzztKsdm(record);
                }else{
                    record.clear();
                    record.put("jzxh", jzxh);
                    record.put("jzzt", 1);
                    record.put("ksdm", reg_ksdm);
                    record.put("ysdm", userId);
                    opYsJzlsDao.updateJzztKsdmYsdm(record);
                }

                resp.setJzxh(jzxh);
            } else {
                // 插入就诊记录
                record.clear();
                record.put("ghxh", regId);
                record.put("brbh", brid);
                record.put("ksdm", reg_ksdm);
                record.put("kssj", new Date());
                record.put("ysdm", userId);// 获取员工代码暂时用该方法替代
                record.put("jzzt", 1);
                record.put("jgid", manageUnit);
                //int jzxh = redisFactory.getTableKey(TableName.DB_NAME,TableName.OP_YS_JZLS);
                //OP_GHMX 表 sbxh 当jzxh
                int jzxh = ObjectToTypes.parseInt(body.get("sbxh"));
                record.put("jzxh", jzxh);
                record.put("jzlsh", body.get("jzlsh"));
                opYsJzlsDao.insert(record);
                resp.setJzxh(jzxh);
            }
        } else {
            throw BaseException.create("ERROR_DCTWORK_OP_0020");
        }

        resp.setBrid(brid);
        resp.setAge(age);
        return resp;
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveClinicFinish(SaveClinicFinishReq req, SysUser user, String ip) {
        Map<String, Object> body = BeanUtil.beanToMap(req);
        String manageUnit = user.getHospitalIdStr();
        // 判断是否有处方处置,若都为0，则不更新就诊状态
        Map<String, Object> params = new HashMap<>();
        params.put("jzxh", req.getJzxh());

        long cf_count = opCf01Dao.findByEntityCount(params);
        long cz_count = opYjcf01Dao.findByEntityCount(params);
        long zd_count = opBrzdDao.findByEntityCount(params);

        /** 2014-9-4 modify by yaosq 加健康处方判断 **/
        //params.clear();
        //params.put("wayid", req.getJzxh());
        //long jkjy_count = herHealthreciperecordMzDao.findByEntityCount(params);

        /** 2013-10-11 modify by gejj 去除门诊病历判断 **/
        params.clear();
        params.put("jzxh", req.getJzxh());
        long hl_count = msBcjlDao.findByEntityCount(params);
        //long omr_count = omrBl01Dao.findByEntityCount(params);

        if (cf_count == 0 && cz_count == 0 && zd_count == 0 && hl_count == 0 ) {
            /** 2013-10-11 end **/
            params.put("jzzt", 0);
            opGhmxDao.updateJzztByJzxh(params);
            params.remove("jzzt");
            params.put("JZXH", req.getJzxh());
            opYsJzlsDao.deleteByjzxh(params);

            //互联网医院科室发送消息
            sendMessage(req.getGhks(),req.getJzlsh(),StatusEnum.DealType.CSHJZ.getCode());
            return;
        }
        /** 增加将病人去向和健康教育存到表MS_BCJL里 add by liuxy */
        Map<String, Object> params3 = new HashMap<>();
        params3.put("jzxh", req.getJzxh());
        long l = msBcjlDao.findByEntityCount(params3);

        if (l <= 0) {
            req.setJzys(user.getUserId());
            req.setJzks(req.getGhks());
            req.setJgid(user.getHospitalId());
            req.setBllx(1);
            MsBcjl bcjl = com.buit.utill.BeanUtil.toBean(req, MsBcjl.class);
            msBcjlDao.insert(bcjl);
        }else {
            Map<String, Object> params2 = new HashMap<>();
            params2.put("BRQX", req.getBrqx());
            params2.put("JKJY", req.getJkjy());
            params2.put("JZXH", req.getJzxh());
            msBcjlDao.updateDybz(params2);
        }

//        int brqx = req.getBrqx();
//        String jkjy = req.getJkjy();
//        if (brqx > 0) {
//            Map<String, Object> params2 = new HashMap<>();
//            params2.put("BRQX", brqx);
//            params2.put("JKJY", jkjy);
//            params2.put("JZXH", req.getJzxh());
//            // 新增DYBZ打印标志字段 保存再次打开病例反复提示打印病例 2015.5.18 by cqd
//            msBcjlDao.updateDybz(params2);
//        }
        params.put("jzzt", req.getJzzt());
        params.put("ysdm", user.getUserId());// 获取员工代码暂时用该方法替代

        //是否更新【门诊挂号表-op_ghmx】就诊医生
        if(req.getUpdatingDoctor() != null && req.getUpdatingDoctor().intValue() == 0){
            opGhmxDao.updateJzztByJzztSbxh(params);
        }else{
            opGhmxDao.updateJzztJzysByJzztSbxh(params);
        }

        params.put("jssj", new Date());

        //是否更新【门诊_就诊历史- op_ys_jzls】就诊医生
        if(req.getUpdatingDoctor() != null && req.getUpdatingDoctor().intValue() == 0){
            opYsJzlsDao.updateJzztJssj(params);
        }else{
            opYsJzlsDao.updateJzztJssjYsdm(params);
        }

        //就诊结束时更新叫号信息
        int jzzt = req.getJzzt();
        if(jzzt == 9){
            this.doClearCallXx(req.getGhks(), req.getSbxh(), user, ip);

            //修改门诊就诊队列的就诊状态为 2-诊毕（jzzt）
            int status = opZspdxxDao.updateJzztByJzlsh(req.getJzlsh(), "2");
            if (status == 0){
                logger.error("修改门诊就诊队列数据失败,就诊流水号：{}",req.getJzlsh());
            }

            //互联网医院科室（发送消息）
            sendMessage(req.getGhks(),req.getJzlsh(),StatusEnum.DealType.JSJZ.getCode());
        }


        /* =====无效代码
         * 拱墅版本中的功能暂时隐藏 params.clear(); params.put("JZZT", 1);
         * params.put("JZXH", Long.parseLong(body.get("JZXH").toString()));
         * params.put("BRID", body.get("BIRD")); doSavePdJzzt(params, ctx);
         *//*
        // dao.doSave("update", BSPHISEntryNames.OP_YS_JZLS, body, false);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(date) + " 06:01:00";
        String KSDM = "";
        Map<String, Object> ksdmMap = dao.doSqlLoad(
                "select BSRUNKSDM from OP_GHKS where ksdm=:ksdm", Param
                        .instance().put("ksdm", body.get("GHKS")));
        if (ksdmMap != null) {
            KSDM = String.valueOf(ksdmMap.get("BSRUNKSDM"));
        }
        String YSDM = body.get("YSDM").toString();
        // 获得老系统员工代码
        Map<String, Object> ygdmMap = dao.doSqlLoad(
                "select YGDM from HR_PERSONNEL where personid=:pid", Param
                        .instance().put("pid", body.get("YSDM")));
        if (ksdmMap != null) {
            YSDM = String.valueOf(ygdmMap.get("YGDM"));
        }
        if (body.get("GHLX") != null && body.get("GHLX").equals(0)) {
//				BsrunDaoUtils.execute(
//						"update OP_GHMX set DQXH = 0 where SBXH = ? ",
//						body.get("SBXH"));
//				// 等待次数减1
//				BsrunDaoUtils
//						.execute(
//								"update OP_GHMX set DDCS = DDCS - 1 where KSDM = ? "
//										+ " and (YSDM = ? or YSDM = '' or YSDM is null) "
//										+ " and DQXH > 0 and GHSJ >= CONVERT(varchar, ?, 120 ) and THBZ = 0 and JZJS = 0 and DDCS > 0",
//								KSDM, YSDM, today);
        } else {
//				BsrunDaoUtils.execute(
//						"update DIY_GHMX_ZZGH set DQXH = 0 where SBXH = ? ",
//						body.get("SBXH"));
//				// 等待次数减1
//				BsrunDaoUtils
//						.execute(
//								"update DIY_GHMX_ZZGH set DDCS = DDCS - 1 where KSDM = ? "
//										+ " and (YSDM = ? or YSDM = '' or YSDM is null) "
//										+ " and DQXH > 0 and GHSJ >= CONVERT(varchar, ?, 120 ) and THBZ = 0 and JZJS = 0 and DDCS > 0",
//								KSDM, YSDM, today);
        }*/
    }

    /**
     * 发送消息
     * @param ghks
     * @param jzlsh
     * @param dealType
     */
    private void sendMessage(Integer ghks,String jzlsh,String dealType){
        logger.info("挂号发送消息:挂号科室：{}",ghks);
        OpGhks opGhks = opGhksSer.getById(ghks);
        if (opGhks != null && "1".equals(opGhks.getInternet())){
            logger.info("挂号发送消息:查询挂号科室数据:internet{}",opGhks.getInternet());
            try {
                logger.info("互联网医院结束就诊发送消息，jzlsh:{}",jzlsh);
                Map map = new HashMap();
                map.put("jzlsh",jzlsh);
                map.put("dealType", dealType);
                rabbitMqProducer.send(MqMatching.OP_JSJZ.getKey(),MapUtil.builder(map).build());
            }catch (Exception e){
                logger.error("互联网医院医生束诊发送消息失败:",e);
            }
        }else {
            logger.error("挂号科室信息为空或者不是互联网科室无需发送消息");
        }
    }

    /**
     * 查询医生排班
     * @param ghks
     * @param ysdm
     * @param hospitalId
     * @return
     */
    public List<QueryYspbResp> queryYspb(Integer ghks, Integer ysdm, Integer hospitalId) {
        Map<String, Object> par = new HashMap<>();
        par.put("ksdm", ghks);
        par.put("ysdm", ysdm);
        par.put("jgid", hospitalId);
        return opYspbDao.queryYspb(par);
    }

    /**
     * 载入结算明细
     * @param brid
     * @param jzxh
     */
    public LoadSettlementInfoResp loadSettlementInfo(Integer brid, Integer jzxh) {
        LoadSettlementInfoResp resp = new LoadSettlementInfoResp();

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("jzxh", jzxh);
        List<Map<String, Object>> cfsbList = opCf01Dao.queryCfsbByJzxhFphmIsNull(params);

        String cfsbs = "";
        for (Map<String, Object> cfsb : cfsbList) {
            if (cfsbs.length() > 0) {
                cfsbs += ",";
            }
            cfsbs += cfsb.get("cfsb");
        }

        params.put("zfpb", 0);
        resp.setCfsl(opCf01Dao.findByEntityCount(params));
        resp.setJcsl(opYjcf01Dao.findByEntityCount(params));


        Map<String, Object> map = opCf02Dao.queryCfje(params);

        if (map == null || map.get("cfje") == null) {
            resp.setCfje(BigDecimal.ZERO);
        } else {
            resp.setCfje(new BigDecimal(map.get("cfje").toString()));
        }

        map = opYjcf01Dao.queryJcje(params);

        if (map == null || map.get("jcje") == null) {
            resp.setJcje(BigDecimal.ZERO);
        } else {
            resp.setJcje(new BigDecimal(map.get("jcje").toString()));
        }

        //未付款处方集合
        List<BigDecimal> measures = new ArrayList<>();
        if(StringUtils.isNotBlank(cfsbs)){
            measures = opCf02Dao.queryHjjeByCfsb(cfsbs);
        }
        //未付款医技集合
        List<BigDecimal> disposal = new ArrayList<>();
        if(jzxh != null){
            disposal = opYjcf01Dao.queryHjjeByJzxh(jzxh);
        }


        //合计
        BigDecimal hj = resp.getJcje().add(resp.getCfje());
        //未付款
        BigDecimal wfk = BigDecimal.ZERO;
        //已付款
        BigDecimal yfk = BigDecimal.ZERO;

        for(BigDecimal b : measures){
            wfk = wfk.add(b);
        }
        for(BigDecimal b : disposal){
            wfk = wfk.add(b);
        }

        yfk = hj.subtract(wfk);

        resp.setHj(hj);
        resp.setYfk(yfk);
        resp.setWfk(wfk);
        resp.setDisposal(disposal);
        resp.setMeasures(measures);

        return resp;
    }

    /**
     * 保存诊间预约信息
     */
    public void saveYyxx(SysUser user, Map<String, Object> body) {
        Integer jgid = user.getHospitalId();
        String ksdm = ObjectToTypes.null2Str(body.get("ksdm"));
        String ysdm = user.getUserIdStr();
        String yyrq = ObjectToTypes.null2Str(body.get("yyrq"));
        String brid = ObjectToTypes.null2Str(body.get("brid"));
        String zblb = ObjectToTypes.null2Str(body.get("zblb"));
        String ywxh = ObjectToTypes.null2Str(body.get("sbxh"));
        String yykssj = yyrq+" "+body.get("yysj").toString()+":00";
        String yyjssj = String.valueOf(DateUtil.offsetMinute(DateUtil.parse(yykssj, DatePattern.NORM_DATETIME_FORMAT), 10));

        String yysj = yykssj;

        Map<String, Object> queryPar = new HashMap<>();
        queryPar.put("jgid", jgid);
        queryPar.put("ksdm", ksdm);
        queryPar.put("ysdm", ysdm);
        queryPar.put("zblb", zblb);
        queryPar.put("yyrq", yyrq);
        Long count = opYspbDao.findByEntityCount(queryPar);

        if(count <= 0){
            throw BaseException.create("ERROR_DCTWORK_OP_0028");
        }

        Map<String, Object> deletePar = new HashMap<>();
        deletePar.put("ywxh", ywxh);
        deletePar.put("ysdm", ysdm);
        deletePar.put("ghbz", 0);
        deletePar.put("yylb", 10);
        if(Objects.nonNull(ywxh)) {
            opYyghDao.removeByEntity(deletePar);
        }

        //同一个医生的同一个时间段预约人数 YYSJDRS = 10;
        Integer yysjdrs = ObjectToTypes.parseInt(sysXtcsCacheSer.getByJGIdAndCsmc(jgid, "YYSJDRS").getCsz());


        Map<String, Object> countPar = new HashMap<>();
        countPar.put("yyrq", yyrq);
        countPar.put("ysdm", ysdm);
        countPar.put("ywxh", ywxh);
        countPar.put("yylb", 10);
        countPar.put("yykssj", yykssj);
        countPar.put("yyjssj", yyjssj);

        Long yyCount = opYyghDao.findByEntityCount(countPar);

        if(yysjdrs <= yyCount){
            throw BaseException.create("ERROR_DCTWORK_OP_0029");
        }

        Map data= new HashMap();
        data.put("brid", brid);
        data.put("jgid", jgid);
        data.put("yymm", "0");
        data.put("ksdm", ksdm);
        data.put("ysdm", ysdm);
        data.put("zcid", 0);
        data.put("zblb", zblb);
        data.put("yylb", 10);
        data.put("yyrq", yysj);
        data.put("ghsj", new Date());
        data.put("ghbz", 0);	//0预约
        data.put("yykssj", yykssj);//预约开始时间
        data.put("yyjssj", yyjssj);//预约结束时间
        data.put("ywxh", ywxh);		//业务序号
        data.put("djgh", user.getUserId());	//登记工号
        data.put("cardno", body.get("jzkh"));
        data.put("yyxh", redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YYGH));
        data.put("jzlsh", body.get("jzlsh"));
        opYyghDao.insert(data);
    }

    /**
     * 病历复制
     * @param brid
     * @param jzxh
     */
    public MsBcjl blfzQuery(Integer brid, Integer jzxh) {
        HashMap<Object, Object> map_par = MapUtil.of(new Object[][]{
                {"brid", brid},
                {"nojzxh", jzxh},
                {"sortColumns", "JZXH desc"}
        });
        List<MsBcjl> bcjlList = msBcjlDao.findByEntity(map_par);

        if (bcjlList != null && !bcjlList.isEmpty()) {
            MsBcjl bcjl = bcjlList.get(0);

            map_par = MapUtil.of(new Object[][]{
                {"wayid", bcjl.getJzxh()},
                {"guideway", "01"}
            });

            List<HerHealthreciperecordMz> jkcfList = herHealthreciperecordMzDao.findByEntity(map_par);
            bcjl.setJkcfRecords(jkcfList);
            return bcjl;
        }
        return null;
    }

//    /**
//     * 诊疗方案调入
//     * @param req
//     * @param user
//     */
//    public SaveClinicTherapeuticResp saveClinicTherapeutic(SaveClinicTherapeuticReq req, SysUser user) {
//        SaveClinicTherapeuticResp resp = new SaveClinicTherapeuticResp();
//        Integer ksdm = req.getMzks();//门诊科室
//        Map<String, Object> parameters = new HashMap<>();
//        Integer zlxh = req.getZlxh();
//        Integer jzxh = req.getJzxh();
//        Integer brid = req.getBrid();
//        String brxz = req.getBrxz();
//        String brxm = req.getBrxm();
//        Integer ghks = req.getGhks();
//
//        parameters.put("jzxh", jzxh);
//
//        // 载入诊疗方案
//
//
//        // 判断是否能载入诊疗方案
//        long l = opCf01Dao.queryCountByJzxhFpxhNotNull(parameters);
//        if (l > 0) {
//            throw BaseException.create("ERROR_DCTWORK_OP_0032");
//        }
//
//        long m = opYjcf01Dao.queryCountByJzxhFpxhNotNull(parameters);
//
//        if (m > 0) {
//            throw BaseException.create("ERROR_DCTWORK_OP_0033");
//        }
//
//        GyZlfa zlfa = gyZlfaDao.getById(zlxh);
//
//        Integer blmbbh = zlfa.getBlmbbh();// 病例模版序号
//        Integer cfztbh = zlfa.getCfztbh();// 处方组套序号
//        Integer xmztbh = zlfa.getXmztbh();// 项目组套序号
//        Integer jbxh = zlfa.getJbxh();// 疾病序号 modify by yangl
//
//        // 修改为常用诊断表主键
//        if (blmbbh != null && blmbbh > 0) {
//            GyBlmb blxx = gyBlmbDao.getById(blmbbh);
//            GyBlmbResp gyBlmbResp = new GyBlmbResp();
//            BeanUtil.copyProperties(blxx, gyBlmbResp);
//            if (blxx != null && blxx.getJlxh() != null) {
//                Map<String,Object> param = ParamUtil.instance().put("jlxh",blxx.getJlxh());
//                List<PubPelplehealthteachMb> list = pubPelplehealthteachMbDao.findByEntity(param);
//                gyBlmbResp.setJkcfRecords(list);
//            }
//            resp.setGyBlmb(gyBlmbResp);
//        }
//        // 删除处方信息
//        List<OpCf01> cfsbList = opCf01Dao.findByEntity(parameters);
//        for (OpCf01 cf01 : cfsbList) {
//            //opCf02Dao.removeByEntity(ParamUtil.instance().put("cfsb", cf01.getCfsb()));
//            opCf02Dao.deleteByCfsb(cf01.getCfsb());
//            opCf01Dao.deleteById(cf01.getCfsb());
//        }
//        if (cfztbh != null && cfztbh > 0) {
//            Map<String, Object> cfxxMap = new HashMap<String, Object>();
//            // 根据组套类型获取药房识别，费用归并
//            OpZt01 zt01 = opZt01Dao.getById(cfztbh);
//            cfxxMap.put("ztbh", cfztbh);
//            cfxxMap.put("pharmacyId", getYFSB(zt01.getZtlb(), ghks, user.getHospitalId()));
//            cfxxMap.put("brxz", brxz);
//            List<Map<String, Object>> meds = doLoadPersonalSet(cfxxMap);
//            String errorMsg = "";
//            for (int i = 0; i < meds.size(); i++) {
//                Map<String, Object> med = meds.get(i);
//                med.put("zfyp", 0);
//                if (med.get("errorMsg") != null) {
//                    errorMsg += "药品【" + med.get("ypmc") + "】" + med.get("errorMsg") + "\n";
//                    meds.remove(med);
//                    i--;
//                }
//            }
//            if (!"".equals(errorMsg)) {
//                resp.setErrorMsg(errorMsg);
//            }
//            cfxxMap.clear();
//            Map<String, Object> formData = new HashMap<String, Object>();
//            formData.put("JZXH", jzxh);
//            formData.put("BRXZ", brxz);
//            formData.put("BRXM", brxm);
//            formData.put("KSDM", ksdm);
//            formData.put("YSDM", user.getUserId());// 获取员工代码暂时用该方法替代
//            formData.put("KFRQ", DateUtil.now());
//            formData.put("CFLX", zt01.getZtlb());
//            formData.put("BRID", brid);
//            formData.put("DJLY", 1);
//            formData.put("CFTS", 1);
//            formData.put("YFSB", getYFSB(zt01.getZtlb(), ghks, user.getHospitalId()));
//            formData.put("JZLSH", req.getJzlsh());
//
//            MsCfSaveReq cfSaveReq = BeanUtil.fillBeanWithMapIgnoreCase(formData, new MsCfSaveReq(), true);
//            cfSaveReq.setCf02List(BSPHISUtil.ListToResultSet(meds, new OpCf02SaveReq()));
//            opCf01Ser.save(cfSaveReq, user);
//        }
//
//        // 删除处置信息
//        List<OpYjcf01> yjxhList = opYjcf01Dao.findByEntity(parameters);
//
//        for (OpYjcf01 yjxhMap : yjxhList) {
//            if (yjxhMap != null) {
//                opYjcf02Dao.removeByEntity(ParamUtil.instance().put("yjxh", yjxhMap.getYjxh()));
//                opYjcf01Dao.deleteById(yjxhMap.getYjxh());
//            }
//        }
//        if (xmztbh != null && xmztbh > 0) {
//            Map<String, Object> cz_body = new HashMap<>();
//            cz_body.put("ztbh", xmztbh);
//            List<Map<String, Object>> yjList = doLoadPersonalSet(cz_body);
//
//            for (Map<String, Object> yjMap : yjList) {
//                yjMap.put("jgid", user.getHospitalId());
//                yjMap.put("ylxh", yjMap.get("fyxh"));
//                yjMap.put("yjzh", yjMap.get("ypzh"));
//                yjMap.put("yldj", yjMap.get("fydj"));
//                yjMap.put("ylsl", yjMap.get("xmsl"));
//                yjMap.put("hjje", (Double) yjMap.get("fydj") * (Double) yjMap.get("xmsl"));
//                yjMap.put("DZBL", 1);
//                yjMap.put("YJXH", 0);
//                if (yjMap.get("XMLX") != null && yjMap.get("XMLX") != "") {
//                    yjMap.put("XMLX", Integer.parseInt(yjMap.get("XMLX") + ""));
//                } else {
//                    yjMap.put("XMLX", 0);
//                }
//                yjMap.put("YJZX", 0);
//                Map<String, Object> params = new HashMap<String, Object>();
//                params.put("TYPE", 0);
//                params.put("BRXZ", brxz);
//                params.put("FYXH", yjMap.get("fyxh"));
//                params.put("FYGB", yjMap.get("fygb"));
//                yjMap.put("zfbl", buhisutil.getPayProportion(params).get("ZFBL"));
//            }
//
//            OpYjcf01Req yjreq = new OpYjcf01Req();
//            yjreq.setClinicId(jzxh);
//            yjreq.setBrid(brid);
//            yjreq.setBrxm(brxm);
//            yjreq.setDjly(1);
//            yjreq.setGhgl(0);
//            yjreq.setBodys(BSPHISUtil.ListToResultSet(yjList, new OpYjcf02Req()));
//            yjreq.setJzlsh(req.getJzlsh());
//            opYjcf01Ser.save(yjreq, user);
//        }
//        // 删除诊断表数据
//        opBrzdDao.removeByEntity(ParamUtil.instance().put("jzxh", jzxh));
//
//        if (jbxh != null && jbxh > 0) {
//            // 增加西医中医诊断区别
//            Map<String, Object> cyzd = BeanUtil.beanToMap(pubCyzdDao.getById(jbxh));
//
////            List<PubCyzd> cyzdList = pubCyzdDao.findByEntity(ParamUtil.instance().put("zdxh", jbxh));
////            if(!cyzdList.isEmpty()){
////                cyzd = BeanUtil.beanToMap(cyzdList.get(0));
////            }
//
//            if (cyzd != null) {
//                Map<String, Object> jbMap = null;
//
//                if("2".equals(cyzd.get("cflx").toString())){
//                    List<DicZyjb> list = dicZyjbDao.findByEntity(ParamUtil.instance().put("jbbs",
//                            cyzd.get("zdxh")));
//                    if(!list.isEmpty()){
//                        jbMap = BeanUtil.beanToMap(list.get(0));
//                    }
//                }else{
//                    List<DicJbbm> list = dicJbbmDao.findByEntity(ParamUtil.instance().put("jbxh", cyzd.get("zdxh")));
//                    if(!list.isEmpty()){
//                        jbMap = BeanUtil.beanToMap(list.get(0));
//                    }
//                }
//
//
//                Map<String, Object> dignosis = new HashMap<String, Object>();
//                dignosis.put("zdxh", cyzd.get("zdxh").toString());
//                if (jbMap != null) {
//                    dignosis.put("icd10", jbMap.get("icd10"));
//                    dignosis.put("zdmc", jbMap.get("jbmc"));
//                }
//                dignosis.put("cflx", cyzd.get("cflx"));
//                dignosis.put("zdlb", 1);
//                dignosis.put("zdbw", 0);
//                dignosis.put("deep", 0);
//                dignosis.put("sjzd", 0);
//                dignosis.put("zzbz", 1);
//                dignosis.put("jzxh", jzxh);
//                dignosis.put("brid", brid);
//                dignosis.put("jgid", user.getHospitalId());
//                dignosis.put("zdys", user.getUserId());// 获取员工代码暂时用该方法替代
//                dignosis.put("zdsj", new Date());
//                dignosis.put("plxh", 0);
//                dignosis.put("fzbz", 1);
//                dignosis.put("jlbh", redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_BRZD));
//                dignosis.put("ffbz", 0);
//                dignosis.put("blzd", 0);
//                dignosis.put("ygzd", 0);
//                dignosis.put("jzlsh", req.getJzlsh());
//                dignosis.put("fbrq", DateUtil.now());
//                opBrzdDao.insert(dignosis);
//            }
//        }
//
//        return resp;
//    }

    private Integer getYFSB(Integer type, Integer ghks, Integer hospitalId){
        String p = "";
        if (type == 1) {
            p = "YS_MZ_FYYF_" + ghks + "_XY";
        } else if (type == 2) {
            p = "YS_MZ_FYYF_" + ghks + "_ZY";
        } else if (type == 3) {
            p = "YS_MZ_FYYF_" + ghks + "_CY";
        }
        SysXtcs xtcs = sysXtcsCacheSer.getByJGIdAndCsmc(hospitalId, p);
        if(xtcs == null){
            throw BaseException.create("ERROR_DCTWORK_OP_0034");
        }else{
            return Integer.parseInt(xtcs.getCsz());
        }
    }

    public List<Map<String, Object>> doLoadPersonalSet(Map<String, Object> body){
        List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();
        Integer ztbh = Integer.parseInt(body.get("ztbh").toString());
        // 发药药房 和 药品类别
        Object pharmacyId = body.get("pharmacyId");
        List<OpZt02Resp> list = opZt02Dao.findByZtbh(ztbh);

        for (OpZt02Resp med : list) {
            if (body.containsKey("ZT02_JLBH")) { // 部分明细调入
                Set<Object> set = new HashSet<>();
                set.addAll((List<Object>) body.get("ZT02_JLBH"));
                if (!set.contains(med.getJlbh())){continue;}
            }
            Map<String, Object> params = new HashMap<>();
            params.put("yfsb", pharmacyId);
            params.put("ypxh", med.getYpxh());
            List<Map<String, Object>> meds = drugsTypkDao.findByYfsbYpxh(params);

            if (meds.size() > 0) {// 取第一条记录
                Map<String, Object> zt_med = meds.get(0);
                // zt_med.putAll(med);
                zt_med.put("ybfl", med.getYbfl());
                zt_med.put("ypzh", med.getYpzh());
                zt_med.put("ycjl", med.getYcjl());
                zt_med.put("yyts", med.getYyts());
                zt_med.put("ypsl", med.getYpsl());
                //zt_med.put("YPYF", med.get("YPYF"));
                //zt_med.put("YPYF_text",  med.get("YPYF_text"));
                zt_med.put("gytj", med.getGytj());
                //zt_med.put("GYTJ_text", med.get("GYTJ_text"));
                //zt_med.put("BZMC", med.get("BZMC"));
                zt_med.put("mrcs", med.getMrcs());
                zt_med.put("sypc", med.getSypc());
                //zt_med.put("SYPC_text", med.get("SYPC_text"));
                // 获取组套中药品自负比例和库存数量
                Map<String, Object> data = new HashMap<String, Object>();
                data.put("TYPE", zt_med.get("type"));
                data.put("FYXH", zt_med.get("ypxh"));
                data.put("BRXZ", body.get("brxz"));
                data.put("FYGB", zt_med.get("fygb"));
                Map<String, Object> zfbl = buhisutil.getPayProportion(data);
                zt_med.put("zfbl", zfbl.get("ZFBL"));
                zt_med.put("ypyf", zt_med.get("sypc"));
                res.add(zt_med);
            } else {
                med.setErrorMsg("暂无库存!");
                res.add(BeanUtil.beanToMap(med));
            }
        }
        return res;
    }


    /**
     *通过就诊流水号查询用户的在线状态
     * @param jzlshList
     * @return
     */
    public Map<String,Object> getOnLineStatus(List<String> jzlshList){
        return mphisOpService.getOnLineStatus(jzlshList);
    }
}
