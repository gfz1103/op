package com.buit.cis.op.dctwork.service;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.StrUtil;
import com.buit.cis.op.dctwork.ybtspost.service.YbtspostService;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.commons.dao.*;
import com.buit.commons.enums.OperateEnum;
import com.buit.commons.enums.PatientTypeEnum;
import com.buit.commons.model.OpBrzd;
import com.buit.commons.model.OpCf01;
import com.buit.commons.model.OpGhks;
import com.buit.commons.request.OpGhmxReq;
import com.buit.commons.request.PatientInfoReq;
import com.buit.commons.response.*;
import com.buit.enums.MqMatching;
import com.buit.his.op.reg.service.OpGhksSer;
import com.buit.mq.RabbitMqProducer;
import com.buit.op.model.OpGhmx;
import com.buit.op.model.OpYjcf01;
import com.buit.op.model.OpYjcf02Zt;
import com.buit.op.model.OpYsJzls;
import com.buit.op.response.MpiBrda;
import com.buit.op.response.SaveInitClinicInfoResp;
import com.buit.system.response.HrPersonnelModel;
import com.buit.system.service.HrPersonnelService;
import com.buit.system.service.SysXtcsCacheSer;
import com.buit.system.utill.ObjectToTypes;
import com.buit.utill.BeanUtil;
import com.buit.utill.MzUtil;
import com.buit.utill.RedisFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.time.DateUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 门诊_挂号明细表<br>
 * @author 老花生
 */
@Service
public class PatientListSer extends BaseManagerImp<OpGhmx,Integer> {

    static final Logger logger = LoggerFactory.getLogger(PatientListSer.class);

    @Autowired
    private OpGhmxDao opGhmxDao;
    @Autowired
    MpiBrdaDao mpiBrdaDao;
    @Autowired
    private OpMzzsDao opMzzsDao;
    @DubboReference
    private SysXtcsCacheSer sysXtcsCacheSer;
    @Autowired
    private OpYsJzlsDao opYsJzlsDao;
    @DubboReference
    private HrPersonnelService hrPersonnelService;
    @Autowired
    private OpBrzdDao opBrzdDao;
    @Autowired
    private OpCf01Dao opCf01Dao;
    @Autowired
    private OpYjcf01Dao opYjcf01Dao;
    @Autowired
    private OpYjcf02ZtDao opYj02ZtDao;
    @Autowired
    private OpZt01Dao opZt01Dao;
    @Autowired
    private OpZspdxxDao opZspdxxDao;
    @Autowired
    private OpGhksSer opGhksSer;
    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    RabbitMqProducer rabbitMqProducer;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private YbtspostService ybtspostService;


    @Override
    public OpGhmxDao getEntityMapper(){
        return opGhmxDao;
    }

    /**
     * 查询患者列表
     * @param req
     * @param user
     */
    public PageInfo<OpGhmxResp> queryPatientList(OpGhmxReq req, SysUser user) {

        req.setJgid(user.getHospitalId());
        //req.setGhks(req.getKsdm());//解决查询条件按门诊科室查询的问题（sql取的是ghks，实际应该是门诊科室）[暂时不用]
        req.setYsdm(user.getUserId());
        //如果日期没传  默认查询当天
        if (StrUtil.isBlank(req.getNowDate())){
            req.setNowDate(DateUtil.format(new Date(), "yyyy-MM-dd"));
        }
        if (StrUtil.isBlank(req.getNowDateEnd())){
            req.setNowDateEnd(DateUtil.format(new Date(), "yyyy-MM-dd"));
        }
        PageInfo<OpGhmxResp> pageInfo = null;
        if(PatientTypeEnum.code_1.getCode().intValue() == req.getPatientType().intValue()){
            pageInfo = PageHelper.startPage(
                    req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                    () -> opGhmxDao.queryDz(req)
            );
        }else if(PatientTypeEnum.code_2.getCode().intValue() == req.getPatientType().intValue()){
            pageInfo = PageHelper.startPage(
                    req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                    () -> opGhmxDao.queryZg(req)
            );
        }else if(PatientTypeEnum.code_3.getCode().intValue() == req.getPatientType().intValue()){
            pageInfo = PageHelper.startPage(
                    req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                    () -> opGhmxDao.queryYz(req)
            );
        }else{
            throw BaseException.create("ERROR_DCTWORK_OP_0003");
        }
        pageInfo.getList().stream().forEach(o ->{
            o.setNl(MzUtil.getPersonAge(o.getCsny(), null).get("ages").toString());
        });
        return pageInfo;
    }

    /**
     * 门诊患者列表-下一位
     * @param req
     * @param user
     * @return
     */
    public OpGhmxResp nextPatient(OpGhmxReq req, SysUser user){
        PageInfo<OpGhmxResp> pageInfo = queryPatientList(req, user);
        if (CollUtil.isEmpty(pageInfo.getList())){
            throw BaseException.create("ERROR_DCTWORK_OP_0049");
        }
        return  pageInfo.getList().get(0);
    }

    /**
     * 查询病人档案
     * @param brid
     * @return
     */
    public PatientListBrdaResp getPatientInfo(Integer brid){
        MpiBrda brda = mpiBrdaDao.getById(brid);
        if(brda != null){
            return BeanUtil.toBean(brda, PatientListBrdaResp.class);
        }else{
            throw BaseException.create("ERROR_DCTWORK_OP_0004");
        }
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
        if (userId == null || userId == 0){
            throw BaseException.create("ERROR_DCTWORK_OP_0087");
        }

        //更新指定医生、就诊状态
        HrPersonnelModel hrPersonnelModel = hrPersonnelService.getPersonnelById(userId);
        String lastLoginIp = hrPersonnelModel.getLastLoginIp();
        Integer zsid = opMzzsDao.getSbxhByIp(lastLoginIp);

        //通过就诊流水号更新门诊叫号表数据(op_zspdxx),更新诊室和医生信息
        opZspdxxDao.updateZdysJzztByOid(ObjectToTypes.parseString(body.get("jzlsh")), userId, zsid);

        //更新挂号医生
        opGhmxDao.updateYsdmByJzlsh(ObjectToTypes.parseString(body.get("jzlsh")), userId);

        SaveInitClinicInfoResp resp = new SaveInitClinicInfoResp();
        // 判断挂号信息是否存在
        Map<String, Object> parameters = new HashMap<>(16);
        String manageUnit = jgid.toString();
        Integer reg_ksdm = ObjectToTypes.parseInt(body.get("ghks"));//挂号科室

        //通过挂号科室查询门诊科室(2020-12-02 18:19:00)
        OpGhks opGhks = opGhksSer.getEntityMapper().getById(reg_ksdm);
        if (opGhks == null){
            throw BaseException.create("ERROR_DCTWORK_OP_0050");
        }
        Integer mz_ksdm = opGhks.getMzks();//门诊科室

        //Integer mz_ksdm = ObjectToTypes.parseInt(body.get("mzks"));//门诊科室
        // 是否自动挂号
        //String yxwggbrjz = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, "YXWGHBRJZ").getCsz();
        // 挂号有效期
        String ghxq = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, "GHXQ").getCsz();
        // 效期计算方式
        String xqjsfs = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, "XQJSFS").getCsz();

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
            if(brda == null){
                throw BaseException.create("ERROR_DCTWORK_OP_0017");
            }
            Timestamp csny = brda.getCsny();
            age = ObjectToTypes.parseInt(MzUtil.getPersonAge(csny, null).get("age"));
        }

        Integer regId = Integer.parseInt(body.get("sbxh").toString());// 挂号明细表的sbxh

        if (regId > 0) {
            // 存在挂号信息，判断效期内是否有就诊记录
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
            parameters.put("ksdm", mz_ksdm);
            parameters.put("querykssj", regBegin);
            parameters.put("sortColumns", " KSSJ desc ");
            List<OpYsJzls> ret = opYsJzlsDao.findByEntity(parameters);
            List<Map<String, Object>> jzlsList = MzUtil.ListObjToMap(ret);
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
                    record.put("ksdm", mz_ksdm);
                    opYsJzlsDao.updateJzztKsdm(record);
                }else{
                    record.clear();
                    record.put("jzxh", jzxh);
                    record.put("jzzt", 1);
                    record.put("ksdm", mz_ksdm);
                    record.put("ysdm", userId);
                    opYsJzlsDao.updateJzztKsdmYsdm(record);
                }
                resp.setJzxh(jzxh);
            } else {
                // 插入就诊记录
                record.clear();
                record.put("ghxh", regId);
                record.put("brbh", brid);
                record.put("ksdm", mz_ksdm);
                record.put("kssj", new Date());
                record.put("ysdm", userId);// 获取员工代码暂时用该方法替代
                record.put("jzzt", 1);
                record.put("jgid", manageUnit);
                //int jzxh = redisFactory.getTableKey(TableName.DB_NAME,TableName.OP_YS_JZLS);
                //OP_GHMX 表 sbxh 当jzxh
                int jzxh = ObjectToTypes.parseInt(body.get("sbxh"));
                record.put("jzxh", jzxh);//此表主键对应op_ghmx表主键
                record.put("jzlsh", body.get("jzlsh"));
                record.put("bizsn",body.get("bizsn"));
                opYsJzlsDao.insert(record);
                resp.setJzxh(jzxh);
            }
        } else {
            throw BaseException.create("ERROR_DCTWORK_OP_0020");
        }

        resp.setBrid(brid);
        resp.setAge(age);

        //互联网医院使用（当科室为互联网医院科室时，需要保存当前医生的待诊患者列表到Redis，并发送消息给公众号）
        if ("1".equals(opGhks.getInternet())){
            try {
                sendMessage(ObjectToTypes.parseString(body.get("jzlsh")),jgid,userId,reg_ksdm);
            }catch (Exception e){
                logger.error("发送消息失败",e);
            }
        }

        //医保智能提醒
        ThreadUtil.execAsync(()->{
            logger.info("【门诊就诊】调用医保智能提醒开始");
            try {
                ybtspostService.mzjz(ObjectToTypes.parseString(body.get("jzlsh")),jgid,ip);
            }catch (Exception e){
                logger.error("【门诊就诊】调用医保智能提醒失败:",e);
            }
            logger.info("【门诊就诊】调用医保智能提醒结束");
        });

        return resp;
    }

    /**
     * 互联网医院使用（当科室为互联网医院科室时，需要保存当前医生的待诊患者列表到Redis，并发送消息给公众号）
     */
    private void sendMessage(String jzlsh,Integer jgid,Integer userid,Integer ghks){
        //查询当前医生的候诊列表
        OpGhmxReq req = new OpGhmxReq();
        req.setGhks(ghks);
        req.setJgid(jgid);
        req.setYsdm(userid);
        req.setNowDate(DateUtil.format(new Date(), "yyyy-MM-dd"));
        req.setNowDateEnd(DateUtil.format(new Date(), "yyyy-MM-dd"));
        List<OpGhmxResp> resps = opGhmxDao.queryDz(req);

        //将当前就诊的放在第一位
        List<String> jzlshList = resps.stream().map(o -> o.getJzlsh()).collect(Collectors.toList());
        jzlshList.add(0,jzlsh);

        String collect = jzlshList.stream().collect(Collectors.joining(","));

        //存放到redis中去【waitingList文件夹存放医生候诊信息】
        //redisFactory.setKey("waitingList:"+userid,jzlshList);

        Map<String, String> map = new HashMap<>();
        map.put("jzlsh",collect);
        //发送消息到公众号
        rabbitMqProducer.send(MqMatching.OP_YSJH.getKey(),MapUtil.builder(map).build());
    }

    /**
     * 选择病人后，初始化病人就诊信息(查询病人档案)
     * @param req
     * @param user
     * @return
     */
    public PatientInfoResp intoPatientInfo(PatientInfoReq req, SysUser user) {
        PatientInfoResp ret = new PatientInfoResp();

        //查询病人档案
        PatientListBrdaResp brda = getPatientInfo(req.getBrid());
        ret.setBrda(brda);

        //加载病历信息
        PatientInfoResp resp = loadClinicInfo(req.getTypes(), req.getClinicId(), user.getHospitalId());
        BeanUtils.copyProperties(resp, ret);

        //保存参数
        IdsResp ids = BeanUtil.toBean(req, IdsResp.class);
        ret.setIds(ids);

        return ret;
    }

    /**
     * 载入病历信息
     * @param type  type 1:病历 2：诊断 3：处方 4:处置 5：所有
     * @param jzxh  就诊序号
     * @param jgId  机构ID
     */
    private PatientInfoResp loadClinicInfo(String type, Integer jzxh, Integer jgId){
        PatientInfoResp ret = new PatientInfoResp();

        String[] types = type.split(",");
        for (int i = 0; i < types.length; i++) {
            if (types[i].equals(OperateEnum.code_1.getCode()) || types[i].equals(OperateEnum.code_5.getCode())) {
                //门诊病历
                //MsBcjl bcjl = getBcjl(jzxh);
                //ret.setBcjl(bcjl);

                //健康处方
                //List<HerHealthreciperecordMzResp> jkcfList = getJkcfList(jzxh);
                //ret.setJkcfList(jkcfList);
            }
            if (types[i].equals(OperateEnum.code_2.getCode()) || types[i].equals(OperateEnum.code_5.getCode())) {
                //诊断
                List<OpBrzdPatientResp> brzdList = getBrzdList(jzxh, jgId);
                ret.setBrzdList(brzdList);
            }
            if (types[i].equals(OperateEnum.code_3.getCode()) || types[i].equals(OperateEnum.code_5.getCode())) {
                //处方
                List<PatientPrescriptionDetailsResp> pdList = getZdDetailsList(jzxh);
                ret.setZdDetailsList(pdList);
            }if (types[i].equals(OperateEnum.code_4.getCode()) || types[i].equals(OperateEnum.code_5.getCode())) {
                //医技
                List<InitPatientDisposeResp> yjlist = getYjList(jzxh);
                ret.setYjList(yjlist);
                //组套
                List<OpZt01Resp> ztlist = getZtList(jzxh);
                ret.setZtList(ztlist);
            }
        }

        return ret;
    }

//    /**
//     * 获取病程记录
//     * @param jzxh  就诊序号
//     * @return
//     */
//    public MsBcjl getBcjl(Integer jzxh){
//        return msBcjlSer.getById(jzxh);
//    }

//    /**
//     * 获取健康出发
//     * @param jzxh  就诊序号
//     * @return
//     */
//    public List<HerHealthreciperecordMzResp> getJkcfList(Integer jzxh){
//        HerHealthreciperecordMz hhm = new HerHealthreciperecordMz();
//        hhm.setWayid(String.valueOf(jzxh));
//        hhm.setGuideway(GuidewayEnum.code_01.getCode());
//        return BeanUtil.toBeans(herHealthreciperecordMzDao.findByEntity(hhm), HerHealthreciperecordMzResp.class);
//    }

    /**
     * 获取诊断
     * @param jzxh  就诊序号
     * @param jgId  机构ID
     * @return
     */
    public List<OpBrzdPatientResp> getBrzdList(Integer jzxh, Integer jgId){
        OpBrzd brzd = new OpBrzd();
        brzd.setJzxh(jzxh);
        brzd.setJgid(jgId);
        return opBrzdDao.patientDiagnosis(brzd);
    }

    /**
     * 获取处方
     * @param jzxh    就诊序号
     * @return
     */
    public List<PatientPrescriptionDetailsResp> getZdDetailsList(Integer jzxh){
        OpCf01 cf = new OpCf01();
        cf.setJzxh(jzxh);
        cf.setZfpb(0);
        cf.setSortColumns(" CFLX,CFHM ");
        List<OpCf01> mscfList = opCf01Dao.findByEntity(cf);

        List<Integer> cfsbs = new ArrayList<>();
        for (OpCf01 mscf : mscfList) {
            cfsbs.add(mscf.getCfsb());
        }

        if (!cfsbs.isEmpty()) {
            List<PatientPrescriptionDetailsResp> pdList = opCf01Dao.queryPrescriptionDetails(cfsbs);
            for (PatientPrescriptionDetailsResp resp : pdList) {
                if (resp.getZfyp() != null && resp.getZfyp().intValue() == 1) {
                    resp.setYpmc("(自备)" + resp.getYpmc());
                }
            }
            return pdList;
        }
        return null;
    }

    /**
     * 获取组套
     * @param jzxh   就诊序号
     * @return
     */
    public List<OpZt01Resp> getZtList(Integer jzxh){

        OpYjcf01 opYjcf01 = new OpYjcf01();
        opYjcf01.setJzxh(jzxh);
        opYjcf01.setZfpb(0);
        List<InitPatientDisposeResp> yjList = opYjcf01Dao.initPatientDispose(opYjcf01);

        // add by yangl 处置界面预览显示时,组套项目明细显示组套名称
        List<Integer> ztbhs = new ArrayList<>();
        for (InitPatientDisposeResp pd : yjList) {
            if (pd.getZtbh() != null) {
                ztbhs.add(pd.getZtbh());
            }
        }
        if (!ztbhs.isEmpty()) {
            List<OpZt01Resp> ztList = opZt01Dao.initPatientSet(ztbhs);
            return ztList;
        }
        return null;
    }

    /**
     * 获取医技
     * @param jzxh  就诊序号
     * @return
     */
    public List<InitPatientDisposeResp> getYjList(Integer jzxh){
        OpYjcf01 opYjcf01 = new OpYjcf01();
        opYjcf01.setJzxh(jzxh);
        opYjcf01.setZfpb(0);
        List<InitPatientDisposeResp> yjList = opYjcf01Dao.initPatientDispose(opYjcf01);

        // 过滤掉是组套的明细数据，显示组套
        Map<Integer, Object> ztyzsbxh = new HashMap<Integer, Object>(16);
        List<InitPatientDisposeResp> result = new ArrayList<>();
        for (InitPatientDisposeResp pd : yjList) {
            if (pd.getZtbz() != null && pd.getZtbz().intValue() == 1) {
                if (ztyzsbxh.containsKey(pd.getZtyzsbxh())) {
                    continue;
                }
                OpYjcf02Zt opYj02Zt = new OpYjcf02Zt();
                opYj02Zt.setSbxh(pd.getZtyzsbxh());
                InitPatientSetDisposeResp yjzt = opYj02ZtDao.initPatientSetDispose(opYj02Zt);
                if (yjzt != null) {
                    ztyzsbxh.put(yjzt.getSbxh(), yjzt);
                    pd = BeanUtil.toBean(yjzt, InitPatientDisposeResp.class);
                    pd.setSldw("套");
                }
            }
            result.add(pd);
        }
        return result;
    }
}
