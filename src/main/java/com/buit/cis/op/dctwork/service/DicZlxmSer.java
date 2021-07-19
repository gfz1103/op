package com.buit.cis.op.dctwork.service;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.buit.apply.model.OpSbhy;
import com.buit.apply.request.DicZlxmSqdReqYsJx02;
import com.buit.apply.request.JcSqdReq;
import com.buit.apply.request.QueryYjyyDataReq;
import com.buit.apply.request.YjyySaveReq;
import com.buit.apply.response.QueryYysjViewResp;
import com.buit.cis.op.dctwork.request.*;
import com.buit.cis.op.dctwork.response.DicZlxmQueryResp;
import com.buit.cis.op.dctwork.response.DicZlxmRecentTimeResp;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.commons.dao.*;
import com.buit.commons.model.*;
import com.buit.commons.request.JySqdReqJyzt;
import com.buit.commons.request.JySqdReqXmDetail;
import com.buit.constans.TableName;
import com.buit.his.op.reg.service.OpGhksSer;
import com.buit.op.model.OpYjcf02Zt;
import com.buit.op.request.OpYjcf01Req;
import com.buit.op.request.OpYjcf02Req;
import com.buit.system.model.DiccZlsfdz;
import com.buit.system.service.DicYjlxService;
import com.buit.system.service.SysXtcsCacheSer;
import com.buit.system.utill.ObjectToTypes;
import com.buit.utill.Param;
import com.buit.utill.ParamUtil;
import com.buit.utill.RedisFactory;
import jodd.util.StringUtil;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 诊疗项目<br>
 * @author 老花生
 */
@Service
public class DicZlxmSer extends BaseManagerImp<DicZlxm,Integer>{

    static final Logger logger = LoggerFactory.getLogger(DicZlxmSer.class);
    public static final String BRXZ_SYBX = "6024";

    @Autowired
    private DicZlxmDao dicZlxmDao;
    @DubboReference
    private SysXtcsCacheSer sysXtcsCacheSer;
    @Autowired
    private FeeYlsfxmDao feeYlsfxmDao;
    @Autowired
    private OpGhksSer opGhksSer;
    @Autowired
    private OpSbhyDao opSbhyDao;

    @DubboReference
    private DicYjlxService dicYjlxService;
//    @Autowired
//    private DicYjlxDao dicYjlxDao;
    @Autowired
    private PubBrxzDao pubBrxzDao;
    @Autowired
    private CisJcsq01Dao cisJcsq01Dao;
    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    private CisJcsq02Dao cisJcsq02Dao;
    @Autowired
    private OpYjcf02ZtDao opYj02ZtDao;
    @Autowired
    private DiccZlsfdzDao diccZlsfdzDao;
    @Autowired
    private BUHISUtil BUHISUtil;
    @Autowired
    private OpYjcf01Ser opYjcf01Ser;
    @Autowired
    private FeeYlsfxmdjDao feeYlsfxmdjDao;
    @Autowired
    private OpZt02Dao opZt02Dao;
    @Autowired
    private DiccZlsfdzSer diccZlsfdzSer;
    @Autowired
    private OpSbbhDao opSbbhDao;
    @Autowired
    private OpSssdDao opSssdDao;


    @Override
    public DicZlxmDao getEntityMapper(){
        return dicZlxmDao;
    }

    /**
     * 查询诊疗项目列表
     * @param req
     * @param user
     * @return
     */
    public List<DicZlxmQueryResp> queryZlxmList(DicZlxmQueryReq req, SysUser user) {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> resultZfbl = new ArrayList<Map<String, Object>>();
        // 获取传过来的ZLXMID参数
        StringBuffer hql = new StringBuffer();
        String brxz = req.getBrxz();
        Integer jgid = user.getHospitalId();
        //获取VIP
        String vipbrxz = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, "VIPBRXZ").getCsz();
        String[] vipbrxzs =  vipbrxz.split(",");
        boolean isVip = false;//是否是VIP病人
        for (int i=0;i<vipbrxzs.length;i++) {
            if(vipbrxzs[i].toString().equals(req.getBrxz())){
                isVip=true;
            }
        }
        Map<String, Object> parameters = new HashMap<>(16);
        parameters.put("yjlx", req.getYjlx());

        if(brxz != null && "6024".equals(brxz)){
            //如果病人性质是商业保险（6024）,费用单价使用商保价格
            parameters.put("bxlx", "1");
        }
        else{
            parameters.put("bxlx", "2");
        }
        result = dicZlxmDao.getFyzh(parameters);

        if(isVip  && brxz != null && !"6024".equals(brxz)){//商保病人费用取商保价格
            resultZfbl = feeYlsfxmDao.getFygbFyxhFydj(parameters);
            List<Map<String, Object>> fyxhZlxmid = dicZlxmDao.getFyxhZlxmidFysl(parameters);

            for (Map<String, Object> map : resultZfbl) {
                //=======获取支付比例======
                Map<String, Object> zfbl = new HashMap<>(16);
                zfbl.put("TYPE", 0);//检查项目
                zfbl.put("FYXH", map.get("FYXH"));
                zfbl.put("FYGB",map.get("FYGB"));
                zfbl.put("BRXZ", req.getBrxz());
                //组套对应的价格可以获取到，获取之后
                Map<String, Object> zfblMap = opGhksSer.getPayProportion(zfbl);
                //计算费用单价
                double fydj = Double.parseDouble(zfblMap.get("ZFBL")+"")*Double.parseDouble(map.get("FYDJ")+"");
                for (Map<String, Object> map2 : fyxhZlxmid) {
                    if(map.get("FYXH").toString().equals(map2.get("FYXH").toString())){
                        map2.put("FYDJ", fydj *Double.parseDouble(map2.get("FYSL")+""));
                    }
                }
            }
            for (Map<String, Object> map : result) {
                double sum = 0.00;
                for(int i =0;i<fyxhZlxmid.size();i++){
                    if(map.get("ZLXMID").toString().equals(fyxhZlxmid.get(i).get("ZLXMID").toString())){
                        sum+=Double.parseDouble(fyxhZlxmid.get(i).get("FYDJ")+"");
                    }
                }
                map.put("FYDJ", sum);
            }
        }

        List<DicZlxmQueryResp> ret = BUHISUtil.ListToResultSet(result, new DicZlxmQueryResp());
        return ret;
    }

    /**
     * 查询设备指定日期最近的号源
     * @param req
     * @return
     */
    public DicZlxmRecentTimeResp queryRecentTime(DicZlxmRecentTimeReq req) {

        Map<String, Object> result = new HashMap<>(16);

        //当前实际加30分钟
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(System.currentTimeMillis()+1800000));
        // 接口类型
        String jklx = req.getJklx();
        Map<String, Object> param = Param.instance().put("JKLX", jklx).put("HYRQ", nowTime);
        //查询号源信息
        List<Map<String, Object>> list = opSbhyDao.getHyInfo(param);

        if (list != null && list.size() > 0) {
            result = list.get(0);
        }

        DicZlxmRecentTimeResp resp = BeanUtil.mapToBean(result, DicZlxmRecentTimeResp.class, false);

        return resp;
    }

    //调用医技保存
    private Integer saveYj(JcSqdReq req, CisJcsq01 zb, List<OpYjcf02Req> jc02List, SysUser user) {
        OpYjcf01Req yjReq = new OpYjcf01Req();
        yjReq.setClinicId(req.getClinicId());
        yjReq.setBrid(req.getBrid());
        yjReq.setBrxm(req.getBrxm());
        yjReq.setDjly(req.getDjly());
        yjReq.setGhgl(req.getGhgl());
        yjReq.setJzkh(req.getJzkh());
        yjReq.setSqid(zb.getJcxh());
        yjReq.setBodys(jc02List);
        yjReq.setJzlsh(req.getJzlsh());
        yjReq.setLy(5);
        Integer yjxh = opYjcf01Ser.save(yjReq, user);
        return yjxh;
    }

    //门诊医保病人，CT检查一天每人只能限一次一个部位
    private void checkCt(int brxz, int brid, int pid) {
        if(pid == 26){	//CT检查
            Map<String, Object> par = Param.instance().put("sjxz", 6021);
            List<PubBrxz> brxzList = pubBrxzDao.findByEntity(par);

            for(PubBrxz pubBrxz : brxzList){
                if(brxz == pubBrxz.getBrxz().intValue()){	//医保病人
                    Map<String, Object> jc01Params = new HashMap<>(16);
                    jc01Params.put("brid", brid);
                    jc01Params.put("sqsj", DateUtil.parse(DateUtil.now(), DatePattern.NORM_DATE_PATTERN));
                    Long jc01Count = cisJcsq01Dao.getJcSqdCount(jc01Params);
                    if(jc01Count >= 1){
                        throw BaseException.create("ERROR_DCTWORK_OP_0011");
                    }
                }
            }
        }
    }

    //判断项目是否作废，若作废不能保存并给出提示和医保病人不能开自费项目
    private void checkInvalid(int brxz, int jgid, List<DicZlxmSqdReqYsJx02> details) {
        String zfxmMc = "";
        String ybzfMc ="";//医保自费项目
        for (DicZlxmSqdReqYsJx02 zlxm : details) {
            Map<String, Object> parameters = new HashMap<>(16);
            parameters.put("jgid", jgid);
            parameters.put("zlxmid", zlxm.getZlxmid());

            List<Map<String, Object>> xmList = feeYlsfxmDao.getFyxhFymcZfpbYbbm(parameters);
            for (Map<String, Object> xm : xmList) {
                if ("1".equals(ObjectToTypes.parseString(xm.get("ZFPB")))) {
                    zfxmMc += "【" + ObjectToTypes.parseString(xm.get("FYMC")) + "】" + ", ";
                }
                if (xm.get("YBBM") == null || StringUtil.isBlank(ObjectToTypes.parseString(xm.get("YBBM")))) {
                    ybzfMc += "【" + ObjectToTypes.parseString(xm.get("FYMC")) + "】" + ", ";
                }
            }
            boolean b = (4001==brxz || 4001==brxz || 6023==brxz || 45==brxz || 39==brxz || 36==brxz
                    || 35==brxz || 34==brxz || 33==brxz || 32==brxz || 28==brxz || 19==brxz || 29==brxz
            );

            if( b && ybzfMc.length() > 0 ){
                throw BaseException.create("ERROR_DCTWORK_OP_0012");
            }

            if (zfxmMc.length() > 0) {
                throw BaseException.create("ERROR_DCTWORK_OP_0013");
            }
        }
    }

    //保存申请单主表
    private void saveJcsq(JcSqdReq req, CisJcsq01 zb, DicYjlx yjlx, List<DicZlxmSqdReqYsJx02> details) {
        //如果选择日期和时间则变为已预约状态，并且更新号源状态
        int yyzt = 0;
        if(req.getYsJx01().getYyrq() != null && req.getYsJx01().getYysj() != null){
            yyzt = 1;
            // 更新设备号源使用状态
            opSbhyDao.updateSfyy(String.valueOf(zb.getHyid()));
        }

        zb.setJcxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.CIS_JCSQ01));
        zb.setJclx(yjlx.getJclx());
        zb.setSqsj(com.buit.utill.DateUtil.getCurrentTimestamp());// 申请时间
        zb.setYyzt(yyzt);
        zb.setJczt(2);
        zb.setZxks(ObjectToTypes.parseInt(details.get(0).getZxks()));// 执行科室
        zb.setJczt(1);
        zb.setSqlx("1");
        cisJcsq01Dao.insert(zb);

        for (DicZlxmSqdReqYsJx02 detail : details) {
            detail.setJcxh(zb.getJcxh());
            detail.setFyxh(detail.getZlxmid());
            cisJcsq02Dao.insert(detail);
        }
    }

    //保存检查组套信息
    private Map<String, Object> saveJcZt(int brxz, List<DicZlxmSqdReqYsJx02> details, int jgid, String jzlsh, int brks) {
        Map<String, Object> ret = new HashMap();
        List<OpYjcf02Req> jc02List = new ArrayList<>();
        List<Integer> yzztIds = new ArrayList<>();// 记录保存的组套id
        for(DicZlxmSqdReqYsJx02 zlxm : details){
            // 保存门诊医嘱组套
            OpYjcf02Zt zt = new OpYjcf02Zt();

            // 赋值医嘱组套信息
            zt.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJ02_ZT));
            zt.setZtbz(1); // 组套标志(该条医嘱存是组套信息) 0非组套标志，1组套标志
            zt.setJgid(jgid); // 机构ID
            zt.setYjxh(1); // 医技序号
            zt.setYlxh(zlxm.getZlxmid()); // 医疗序号
            zt.setXmlx(5); // 项目类型=检查
            zt.setYjzx(0); // 项目类型=检查
            zt.setYldj(zlxm.getFydj()); // 医疗单价
            zt.setYlsl(BigDecimal.ONE); // 医疗数量
            zt.setHjje(zlxm.getFydj()); // 划价金额
            zt.setFygb(5); // 费用归并
            zt.setZfbl(BigDecimal.ONE); // 自负比例 组套不显示自负比例
            zt.setDzbl(BigDecimal.ONE); // 打折比例
            zt.setYjzh(1); // 医技组号
            zt.setFymc(zlxm.getFymc()); // 打折比例
            zt.setJzlsh(jzlsh); // 就诊流水号
            opYj02ZtDao.insert(zt);

            yzztIds.add(zt.getSbxh());

            // 保存门诊医嘱组套
            // 查询该诊疗项目对应的收费项目明细
            Map<String, Object> parameters = new HashMap<>(16);
            parameters.put("zlxmid", zlxm.getZlxmid());
            parameters.put("types", brxz == 6024? 1:2);//1商保、2非商保
            List<Map<String, Object>> fymxList = feeYlsfxmDao.getBxfy(parameters);

            Map<String, Object> map = Param.instance().put("zlxmid", zlxm.getZlxmid());
            List<DiccZlsfdz> xmfyList = diccZlsfdzDao.findByEntity(map);

            for (Map<String, Object> fymx : fymxList) {
                OpYjcf02Req yj02 = new OpYjcf02Req(); // 处置明细
                yj02.setZxks(zlxm.getZxks());// 赋值执行科室
                yj02.setZtbz(1);// 组套标志(该条医嘱存是组套信息) 0非组套标志，1组套标志
                yj02.setZtyzsbxh(zt.getSbxh());// 组套医嘱识别序号(OP_YJ02_ZT表SBXH)
                yj02.setYjzh(1);// 医技组号
                yj02.setJgid(jgid); // 机构ID
                yj02.setYlxh(ObjectToTypes.parseInt(fymx.get("FYXH")));// 医疗序号=费用序号
                yj02.setXmlx(5);// 项目类型：4检验,5检查,6手术,7治疗,8护理,9饮食,10卫材,99其他
                yj02.setYldj(ObjectToTypes.parseBigDecimal(fymx.get("FYDJ")));// 医疗单价=费用单价
                yj02.setYjzx(0);// 医技主项
                yj02.setDzbl(BigDecimal.ONE);// 打折比例============================================
                yj02.setKsdm(brks);// 科室代码
                yj02.setFydw(ObjectToTypes.parseString(fymx.get("FYDW")));// 费用单位
                yj02.setYlsl(setylsl(fymx, xmfyList));//设置数量
                yj02.setHjje(ObjectToTypes.parseBigDecimal(fymx.get("FYDJ")).
                        divide(ObjectToTypes.parseBigDecimal(yj02.getYlsl())));// 合计金额=============================
                yj02.setFymc(ObjectToTypes.parseString(fymx.get("FYMC")));// 费用名称
                yj02.setFygb(BUHISUtil.getfygb(0, yj02.getYlxh()));// 费用归并
                yj02.setZfbl(ObjectToTypes.parseBigDecimal(
                        BUHISUtil.getPayProportion(brxz, yj02.getFygb(), 0, yj02.getYlxh()).get("ZFBL")));// 自负比例
                jc02List.add(yj02);
            }
        }
        ret.put("yzztIds", yzztIds);
        ret.put("jc02List", jc02List);

        return ret;
    }

    //设置数量
    private BigDecimal setylsl(Map<String, Object> fyxh, List<DiccZlsfdz> xmfyList) {
        List<DiccZlsfdz> list = xmfyList.stream().filter(
                item -> item.getFyxh().intValue() == ObjectToTypes.parseInt(fyxh.get("FYXH"))).collect(Collectors.toList());
        if(list == null || list.isEmpty()){
            return BigDecimal.ONE;
        }
        return new BigDecimal(list.get(0).getFysl()==null?1:list.get(0).getFysl());
    }

    /**
     * 保存门诊检验申请单
     * @param req
     * @param user
     * @return
     */
    public void saveMzJySqd(JySqdReq req, SysUser user) {

        List<JySqdReqJyzt> jyzt = req.getJyzts();
        List<JySqdReqXmDetail> details = req.getXmDetails();


        // 判断项目是否作废，若作废不能保存并给出提示
        checkYz(details);

        // 保存医嘱信息
        Map<String, Object> zt01 = new HashMap<>(16);
        // 组号 同一组套的项目全选时，医嘱存为同一组
        int yzzhShow = 1;

        for (JySqdReqJyzt zt : jyzt) {
            List<Integer> yzztIds = new ArrayList<>();// 记录保存的组套id
            Integer brxz = req.getBrxz(); //获得病人性质
            List<Map<String, Object>> xmDetails;// 查询该组套下面的项目明细

            //判断病人性质是否是医保病人
            if(brxz != null&& brxz.intValue() == 6024){
                //如果是商保病人，获取商保价格
                Map<String, Object> param = Param.instance().put("ztbh", zt.getZtbh());
                xmDetails = opZt02Dao.getJlbhXmbhXmslFydjSb(param);
            }else{
                //非商保病人
                Map<String, Object> param = Param.instance().put("ztbh", zt.getZtbh());
                xmDetails = opZt02Dao.getJlbhXmbhXmslFydjFSb(param);
            }

            //判断组套信息是否全选
            boolean hasZt = ztSelectAll(details, xmDetails);

            // 该组套的项目全部选中，新增组套信息表信息
            if (hasZt) {
                // 保存yjcf02Zt表
                OpYjcf02Zt yzxxZt = saveYjcf02Zt(user.getHospitalId(), zt.getZtbh(), yzzhShow, zt.getZtmc(), req.getJzlsh(), xmDetails);

                yzztIds.add(yzxxZt.getSbxh());
                for (Map<String, Object> xm : xmDetails) {
                    zt01.put(xm.get("jlbh").toString(), ObjectToTypes.parseLong(yzxxZt.getSbxh()));
                }
            }

            // 处方组套明细保
            List<OpYjcf02Req> jc02List = new ArrayList<>();
            for(JySqdReqXmDetail detail : details){
                //判断明细是否属于这个组套
                boolean flag=true;
                for(Map<String, Object> xm : xmDetails){
                    if(xm.get("jlbh").toString().equals(detail.getJlbh().toString())){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    continue;
                }

                // 保存yjcf02
                OpYjcf02Req yj02 = saveYjcf02(detail, yzzhShow, zt01, brxz, user.getHospitalId(), req.getBrks());

                //医学检验科
                jc02List.add(yj02);
            }

            //调用保存医技
            OpYjcf01Req yjReq = com.buit.utill.BeanUtil.toBean(req, OpYjcf01Req.class);
            yjReq.setBodys(jc02List);
            yjReq.setLy(4);
            Integer yjxh = opYjcf01Ser.save(yjReq, user);

            // 更新OP_YJ02_ZT的YJXH值
            String inSql = "";
            for (Integer id : yzztIds) {
                inSql += "'" + id + "',";
            }
            int a = inSql.lastIndexOf(",");
            //判断如果是组套全选的取跟新OP_YJ02_ZT，如果只开了组套中的某一项，则不用更新OP_YJ02_ZT
            if(a!=-1){
                opYj02ZtDao.updateYjxh(yzztIds, yjxh);
            }
        }

    }

    // 保存yjcf02
    private OpYjcf02Req saveYjcf02(JySqdReqXmDetail detail, int yzzhShow, Map<String, Object> zt01, Integer brxz, Integer jgid, Integer brks) {
        OpYjcf02Req yj02 = new OpYjcf02Req();

        if (!zt01.containsKey(detail.getJlbh().toString())) {
            yj02.setZtbz(0); // 组套标志 非组套医嘱
            yzzhShow += 1;
        } else {
            yj02.setZtbz(1);// 组套标志 组套医嘱
            yj02.setZtyzsbxh(ObjectToTypes.parseInt(zt01.get(detail.getJlbh().toString())));
        }

        //判断是否是商保病人====================================================
        Map<String, Object> param = Param.instance().put("fyxh", detail.getXmbh());
        // 查询该组套下面的项目明细
        //判断病人性质是否是医保病人
        if(brxz != null && BRXZ_SYBX.equals(brxz.toString())){
            param.put("type", "1");//商保病人
        }else{
            param.put("type", "2");//非商保病人
        }
        Map<String, Object> fymx = feeYlsfxmDao.getBxInfo(param);

        yj02.setYjzh(1);// 医技组号
        yj02.setJgid(jgid); // 机构ID
        yj02.setYlxh(ObjectToTypes.parseInt(fymx.get("fyxh")));// 医疗序号=费用序号
        yj02.setXmlx(4);// 项目类型 4检验,5检查,6手术,7治疗,8护理,9饮食,10卫材,99其他
        yj02.setYldj(ObjectToTypes.parseBigDecimal(fymx.get("bzjg")));// 医疗单价=费用单价
        yj02.setYlsl(new BigDecimal(detail.getFysl()));// 医疗数量
        yj02.setYjzx(0);// 医技主项
        yj02.setDzbl(BigDecimal.ONE);// 打折比例============================================
        yj02.setKsdm(brks);// 科室代码
        yj02.setFydw(ObjectToTypes.parseString(fymx.get("fydw")));// 费用单位
        yj02.setHjje(ObjectToTypes.parseBigDecimal(fymx.get("bzjg")).multiply(ObjectToTypes.parseBigDecimal(detail.getFysl())));// 合计金额=============================
        yj02.setFymc(ObjectToTypes.parseString(fymx.get("fymc")));// 费用名称
        yj02.setZtbh(detail.getZtbh());

        // 获取病人自负比例
        Integer ypxh = ObjectToTypes.parseInt(fymx.get("fyxh"));// 费用序号
        Integer fygb = BUHISUtil.getfygb(0, ypxh);// 获取费用归并
        Map<String, Object> zfblMap = BUHISUtil.getPayProportion(brxz, fygb, 0, ypxh);
        yj02.setZfbl(ObjectToTypes.parseBigDecimal(zfblMap.get("ZFBL")));// 自负比例
        yj02.setFygb(fygb);// 费用归并

        return yj02;
    }

    private OpYjcf02Zt saveYjcf02Zt(Integer jgid, Integer ztbh, int yzzhShow, String ztmc, String jzlsh, List<Map<String, Object>> xmDetails) {
        BigDecimal ypdj = BigDecimal.ZERO;
        for (Map<String, Object> xm : xmDetails) {
            ypdj.add(ObjectToTypes.parseBigDecimal(xm.get("fydj")).multiply(ObjectToTypes.parseBigDecimal(xm.get("fysl"))));
        }
        OpYjcf02Zt yzxxZt = new OpYjcf02Zt(); // 组套信息
        yzxxZt.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJCF02)); // 主键
        yzxxZt.setZtbz(1); // 组套标志(该条医嘱存是组套信息) 0非组套标志，1组套标志
        yzxxZt.setJgid(jgid); // 机构ID
        yzxxZt.setYjxh(1); // 医技序号
        yzxxZt.setYlxh(ztbh); // 医疗序号=组套编号
        yzxxZt.setXmlx(4); // 项目类型=检验
        yzxxZt.setYjzx(0); // 项目主项
        yzxxZt.setYldj(ypdj); // 医疗单价
        yzxxZt.setYlsl(BigDecimal.ONE); // 医疗数量
        yzxxZt.setHjje(ypdj); // 划价金额
        yzxxZt.setFygb(9); // 费用归并,取DIC_SFXMLB收费名称为化验费的值=9
        yzxxZt.setZfbl(BigDecimal.ONE); // 自负比例 组套不显示自负比例
        yzxxZt.setDzbl(BigDecimal.ONE); // 打折比例
        yzxxZt.setYjzh(yzzhShow); // 医技组号
        yzxxZt.setFymc(ztmc); // 费用名称
        yzxxZt.setJzlsh(jzlsh);
        opYj02ZtDao.insert(yzxxZt);

        return yzxxZt;
    }

    //判断组套信息是否全选
    private boolean ztSelectAll(List<JySqdReqXmDetail> details, List<Map<String, Object>> xmDetails) {
        boolean hasZt = true;// 该组套项目明细全选
        for (Map<String, Object> xm : xmDetails) {
            boolean hasXm = false;// 该明细项目被选中
            for (JySqdReqXmDetail yz : details) {
                if (ObjectToTypes.parseInt(xm.get("jlbh")) == yz.getJlbh()) {
                    hasXm = true;
                    break;
                }
            }
            if (!hasXm) {
                hasZt = false;
                break;
            }
        }
        return hasZt;
    }

    //判断项目是否作废，若作废不能保存并给出提示
    private void checkYz(List<JySqdReqXmDetail> details) {
        String zfxmMc = "";
        for (JySqdReqXmDetail xm : details) {
            Map<String, Object> parameters = new HashMap<>(16);
            parameters.put("fyxh", xm.getXmbh());
            parameters.put("zfpb", 0);
            List<FeeYlsfxmdj> ylmxList = feeYlsfxmdjDao.findByEntity(parameters);
            if (ylmxList.isEmpty()) {
                zfxmMc += ObjectToTypes.parseString(xm.getYzmc()) + ", ";
            }
        }
        if (zfxmMc.length() > 0) {
            throw BaseException.create("ERROR_DCTWORK_OP_0014", new String[]{zfxmMc});
        }
    }

    /**
     * 门诊或住院医技预约保存
     * @param req
     */
    public void saveSqdFromMzorZy(YjyySaveReq req) {
        cisJcsq01Dao.updateAppointment(req);
    }

    /**
     * 医技取消
     * @param jcxh
     */
    public void cancelYjyy(Integer jcxh) {
        CisJcsq01 jc = cisJcsq01Dao.getById(jcxh);
        if(jc == null){
            throw BaseException.create("ERROR_DCTWORK_OP_0015");
        }
        //取消状态
        if("3".equals(jc.getSqlx())){
            cisJcsq01Dao.cancelYjTj(jcxh);
        }else{
            cisJcsq01Dao.cancelYjMzOrZy(jcxh);
        }

        //解冻号源
        opSbhyDao.unfreeze(jc.getHyid());
    }

    /**
     * 判断号源是否已经被占用
     * @param hyid
     * @return
     */
    public Boolean checkHyid(Integer hyid) {
        OpSbhy sbhy = opSbhyDao.getById(hyid);
        if(sbhy == null){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 查询诊间医技预约时间View数据
     * @param hyrq
     * @param jclx
     * @return
     */
    public List<QueryYysjViewResp> queryYysjView(String hyrq, Integer jclx) throws Exception{
        Date nowDate = new Date();
        String hysj = new SimpleDateFormat("HH:mm").format(new Date());
        if(nowDate.getTime() < DateUtil.parse(hyrq).getTime()){
            hysj = null;
        }
        List<QueryYysjViewResp> resp = opSbhyDao.queryYysjView(hyrq, jclx, hysj);
        return resp;
    }

    /**
     * 中心维护-诊疗项目维护-查询医技类型列表
     * @param yjlx
     * @return
     */
    public List<DicZlxm> queryList(int yjlx) {
        DicZlxm condition = new DicZlxm();
        condition.setYjlx(yjlx);
        condition.setZfbz("0");
        return dicZlxmDao.findByEntity(condition);
    }

    /**
     * 中心维护-诊疗项目维护-新增
     *
     * @param req
     */
    @Transactional(rollbackFor = Exception.class)
    public void add(DicZlxmAddReq req, SysUser user) {
        DicZlxm zlxm = BeanUtil.toBean(req, DicZlxm.class);
        int id = redisFactory.getTableKey(TableName.DB_NAME, TableName.DIC_ZLXM);
        zlxm.setZlxmid(id);
        zlxm.setJgid(user.getHospitalId());
        dicZlxmDao.insert(zlxm);
        if (req.getDiccZlsfdzAddReqList().size() > 0) {
            for (DiccZlsfdzAddReq zlsfdzAddReq : req.getDiccZlsfdzAddReqList()) {
                zlsfdzAddReq.setZlxmid(id);
                diccZlsfdzSer.add(zlsfdzAddReq);
            }
        }
    }

    /**
     * 中心维护-诊疗项目维护-作废
     * @param zlxmId
     */
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer zlxmId) {
        dicZlxmDao.deleteById(zlxmId);
        diccZlsfdzSer.deleteByZlxmId(zlxmId);
    }

    /**
     * 查询诊间医技预病html组装
     */
    public Map<String, Object> queryYjyy4Html() {
        //QueryYjyy4HtmlResp resp = null;
        Map<String, Object> res = new HashMap<>();
        List<OpSbbh> sbObjList =
                opSbbhDao.findByEntity(ParamUtil.instance().put("sortColumns", " JKLX,sbmc"));
        List<Map<String, Object>> sbList = BUHISUtil.ListObjToMap(sbObjList);
        List<Map<String, Object>> sblxList = opSbbhDao.getJklx();


        List<Map<String, Object>>	headerList = new ArrayList();
        List<Map<String, Object>>	headerChildList =  new ArrayList();
        Map<String, Object> headerBlank = new LinkedHashMap<String, Object>();
        headerBlank.put("value", "");
        headerBlank.put("rowspan", 2);
        headerBlank.put("width", 100);
        headerList.add(headerBlank);
        for(Map<String, Object> sblxmap:sblxList){
            Map<String, Object> headerMap = new LinkedHashMap<String, Object>();
            String jklx_text= ObjectToTypes.parseString(sblxmap.get("jklx_text"));
            String jklx= ObjectToTypes.parseString(sblxmap.get("jklx"));
            headerMap.put("id", jklx);
            headerMap.put("value", jklx_text);
            headerMap.put("colspan", sblxmap.get("count"));
            headerMap.put("jklx",jklx);//隐藏列私用
            headerList.add(headerMap);
        }
        for(Map<String, Object> sbmap:sbList){
            Map<String, Object> headerChildMap = new LinkedHashMap<String, Object>();
            String jklx= ObjectToTypes.parseString(sbmap.get("jklx"));
            String sbmc= ObjectToTypes.parseString(sbmap.get("sbmc"));
            String bhid= ObjectToTypes.parseString(sbmap.get("bhid"));
            headerChildMap.put("id", jklx+"_"+bhid);
            headerChildMap.put("value", sbmc);
            headerChildMap.put("jklx",jklx);//隐藏列私用
            headerChildList.add(headerChildMap);
        }
        Map<String, Object> headeritem = new LinkedHashMap<String, Object>();
        headeritem.put("type", "header");
        headeritem.put("items", headerList);

        Map<String, Object> headerChilditem = new LinkedHashMap<String, Object>();
        headerChilditem.put("type", "header");
        headerChilditem.put("items", headerChildList);


        res.put("Header", headeritem);
        res.put("HeaderChild", headerChilditem);


        //具体项目和时间画出表格
        List<OpSssd> sssdObjList = opSssdDao.findByEntity(ParamUtil.instance().put("sfxs", 1).put("sortColumns", " " +
                "SSSDID "));
        List<Map<String, Object>> sssdList = BUHISUtil.ListObjToMap(sssdObjList);

        List<Map<String, Object>>	dataList=  new ArrayList<Map<String, Object>>();
        for(int i=0;i<sssdList.size()+2;i++){
            Map<String, Object>	dataMap = new LinkedHashMap<String, Object>();

            List<Map<String, Object>>	dataItemList = new ArrayList();
            Map<String, Object> dataTimeMap = new LinkedHashMap<String, Object>();
            if(i==0){
                dataTimeMap.put("type", "header");
                dataTimeMap.put("id", "t_kyyrc_"+i);
                dataTimeMap.put("value", "可预约人次");
                dataItemList.add(dataTimeMap);
            }
            if(i==1){
                dataTimeMap.put("type", "header");
                dataTimeMap.put("id", "t_yyyrc_"+i);
                dataTimeMap.put("value", "已预约人次");
                dataItemList.add(dataTimeMap);
            }
            if(i>1){
                Map<String, Object> sssdMap =  sssdList.get(i-2);
                String SSSDID= ObjectToTypes.parseString(sssdMap.get("sssdid"));
                String VALUE= ObjectToTypes.parseString(sssdMap.get("value"));
                dataTimeMap.put("type", "header");
                dataTimeMap.put("id", "t_"+SSSDID);
                dataTimeMap.put("value", VALUE);
                dataItemList.add(dataTimeMap);
            }
            for(int j=0;j<sbList.size();j++){
                Map<String, Object> sbMap =  sbList.get(j);
                String JKLX= ObjectToTypes.parseString(sbMap.get("jklx"));
                String BHID= ObjectToTypes.parseString(sbMap.get("bhid"));

                Map<String, Object> dataSbMap = new LinkedHashMap<String, Object>();

                if (i==0){
                    dataSbMap.put("id", "t_kyyrc_"+JKLX+"_"+BHID);
                }
                if(i==1){
                    dataSbMap.put("id", "t_yyyrc_"+JKLX+"_"+BHID);
                }

                if(i>1){
                    Map<String, Object> sssdMap =  sssdList.get(i-2);
                    String SSSDID= ObjectToTypes.parseString(sssdMap.get("sssdid"));
                    dataSbMap.put("id", "t_"+SSSDID+"_"+JKLX+"_"+BHID);
                    dataSbMap.put("click", true);
                    dataSbMap.put("info", ObjectToTypes.parseString(sbMap.get("sbmc")));
                }
                dataSbMap.put("value", 0);
                dataSbMap.put("type", "data");
                dataSbMap.put("jklx",JKLX);//隐藏列私用
                dataItemList.add(dataSbMap);
            }
            dataMap.put("items", dataItemList);
            dataList.add(dataMap);
        }
        res.put("dataList", dataList);

        return res;
    }

    /**
     * 医技预约数据加载
     * @param req
     * @return
     */
    public Map<String, Object> queryYjyyData(QueryYjyyDataReq req) {
        Map<String, Object> param = new HashMap<>();
        param.put("data",req.getDate());
        param.put("data1", req.getDate1());
        param.put("brxm", req.getBrxm());

        //查询已预约
        List<Map<String, Object>> list = opSbhyDao.queryYyqk(param);

        //查询已检查
        param.put("jczt", "1");//条件jczt>2
        List<Map<String, Object>> yjclist = opSbhyDao.queryYyqk(param);

        Map<String, Object> retmap=new HashMap<String, Object>();
        String value="0";
        for(Map<String, Object> map:list){
            value=ObjectToTypes.parseString(map.get("value")+"(0)");
            for(Map<String, Object> yjclistmap:yjclist){
                if(ObjectToTypes.parseString(map.get("id")).equals(ObjectToTypes.parseString(yjclistmap.get("id")))){
                    value=ObjectToTypes.parseString(map.get("value"))+"("+ObjectToTypes.parseString(yjclistmap.get("value"))+")";
                }
            }
            retmap.put(ObjectToTypes.parseString(map.get("id")), value);
        }

        //可预约
        List<Map<String, Object>>	kyyslist = opSbhyDao.queryKyy(param);
        for(Map<String, Object> map:kyyslist){
            retmap.put(ObjectToTypes.parseString(map.get("id")), map.get("value"));
        }

        //已预约
        List<Map<String, Object>> yyyslist = opSbhyDao.queryYyy(param);
        for(Map<String, Object> map:yyyslist){
            retmap.put(ObjectToTypes.parseString(map.get("id")), map.get("value"));
        }

        return retmap;
    }
}
