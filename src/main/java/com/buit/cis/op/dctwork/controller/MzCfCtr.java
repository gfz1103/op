
package com.buit.cis.op.dctwork.controller;


import com.buit.cis.op.dctwork.request.OpYnzzsqSaveReq;
import com.buit.cis.op.dctwork.request.SaveKjywsqlyReq;
import com.buit.cis.op.dctwork.response.CfPrintResponse;
import com.buit.cis.op.dctwork.response.MzcfGetKssdjByYpxhResp;
import com.buit.cis.op.dctwork.service.MzCfSer;
import com.buit.cis.op.dctwork.service.OpYnzzsqSer;
import com.buit.commons.BaseException;
import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.commons.model.OpCf01;
import com.buit.commons.model.SkinXmldsfxm;
import com.buit.commons.request.*;
import com.buit.commons.response.*;
import com.buit.drug.request.QueryCfypxxReq;
import com.buit.drug.response.DrugsTypkDetailResp;
import com.buit.drug.response.QueryCfypxxResp;
import com.buit.drug.service.DrugService;
import com.buit.drug.service.DrugsTypkOutSer;
import com.buit.his.op.infusion.service.SkinXmldsfxmSer;
import com.buit.his.op.reg.service.OpGhksSer;
import com.buit.his.op.reg.service.OpMzxxSer;
import com.buit.mms.antimi.model.AmqcKjywsycs;
import com.buit.mms.antimi.service.AmqcKjywsycsService;
import com.buit.op.request.ExtractCfReq;
import com.buit.op.response.OpCf01RespModel;
import com.buit.op.service.OpCf01Service;
import com.buit.system.response.SysXtcs;
import com.buit.system.service.HrPersonnelService;
import com.buit.system.service.SysXtcsCacheSer;
import com.buit.utill.BeanUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 门诊_处方<br>
 * @author 老花生
 */
@Api(tags="门诊_处方")
@Controller
@RequestMapping("/mzcf")
public class MzCfCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(MzCfCtr.class);

    @Autowired
    private MzCfSer opCf01Ser;
    @DubboReference
    private SysXtcsCacheSer sysXtcsCacheSer;
    @Autowired
    private OpMzxxSer opMzxxSer;
//    @Autowired
//    private OpYnzzsqSer opYnzzsqSer;
//    @Autowired
//    private YsMzPsjlSer ysMzPsjlSer;
    @Autowired
    private OpGhksSer opGhksSer;
    @DubboReference
    DrugService drugService;
    @Autowired
    private OpYnzzsqSer opYnzzsqSer;
    @DubboReference
    private OpCf01Service opCf01Service;
    @DubboReference
    private DrugsTypkOutSer drugsTypkOutSer;
    @Autowired
    private SkinXmldsfxmSer skinXmldsfxmSer;
    @DubboReference
    private HrPersonnelService hrPersonnelService;
    @DubboReference
    private AmqcKjywsycsService amqcKjywsycsService;

//    @DubboReference
//    private MzCfApi mzCfApi;
//    /**
//     *
//     */
//    @RequestMapping("/test")
//    @ResponseBody
//    @ApiOperation(value="测试方法" ,httpMethod="POST")
//    public ReturnEntity<List<OpCf01Resp>> test(){//@RequestBody
//        OpCf01ApiReq req = new OpCf01ApiReq();
//        req.setKfrqBegin(new Date(System.currentTimeMillis()));
//        req.setKfrqEnd(new Date(System.currentTimeMillis()));
//        req.setKsdm(991);
//        req.setShzt("0");
//        ReturnEntity<List<OpCf01Resp>> resp = mzCfApi.getCfList(req);
//        return resp;
//    }

    @RequestMapping("/test2")
    @ResponseBody
    @ApiOperation(value="测试方法2" ,httpMethod="POST")
    public ReturnEntity<List<OpCf01RespModel>> test2(ExtractCfReq req){//@RequestBody
        ReturnEntity<List<OpCf01RespModel>> ret = opCf01Service.extractCf(req);
        return ret;
    }

    /**
     * 查询处方列表(clinicManageService.loadCF01)
     * @param opcf01
     * @return
     */
    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperation(value="查询处方列表" ,httpMethod="POST")
    public ReturnEntity<List<OpCf01Resp>> getByEntity(@Valid OpCf01Req opcf01){//@RequestBody
        List<OpCf01Resp> ret = opCf01Ser.queryCfList(opcf01);
        //List<OpCf01> cfList = opCf01Ser.findByEntity(opcf01);
        //List<OpCf01Resp> ret = BeanUtil.toBeans(cfList, OpCf01Resp.class);
        return ReturnEntityUtil.success(ret);
    }


    /**
     * 查询处方列表没有就诊流水号(clinicManageService.loadCF01)
     * @param opcf01
     * @return
     */
    @RequestMapping("/findListNoJzlsh")
    @ResponseBody
    @ApiOperation(value="查询处方列表" ,httpMethod="POST")
    public ReturnEntity<List<OpCf01Resp>> getByEntityNoJzlsh(@Valid OpCf01Req opcf01){//@RequestBody
        opcf01.setJzlsh(null);
        List<OpCf01> cfList = opCf01Ser.findByEntity(opcf01);
        List<OpCf01Resp> ret = BeanUtil.toBeans(cfList, OpCf01Resp.class);
        return ReturnEntityUtil.success(ret);
    }

//    /**
//     * 查询处方详情(OP_CF01_YFQH)
//     * @param cfsb
//     * @return
//     */
//    @RequestMapping("/findCf")
//    @ResponseBody
//    @ApiOperation(value="查询处方详情" ,httpMethod="POST")
//    public ReturnEntity<OpCf01Resp> findCf(@ApiParam(name = "cfsb", value = "处方识别", required = true) @RequestParam Integer cfsb)
//            throws InvocationTargetException, IllegalAccessException {//@RequestBody
//        OpCf01 cf01 = opCf01Ser.getEntityMapper().getById(cfsb);
//        OpCf01Resp resp = new OpCf01Resp();
//        copyProperties(cf01, resp);
//        return ReturnEntityUtil.success(resp);
//    }

    /**
     * 查询处方明细
     * @param cfsb  处方识别
     * @return
     */
    @RequestMapping("/findDetails")
    @ResponseBody
    @ApiOperation(value="查询明细" ,httpMethod="POST")
    public ReturnEntity<List<PatientPrescriptionDetailsResp>> getDetails(@ApiParam(name = "cfsb", value = "处方识别", required = true) @RequestParam Integer cfsb){//@RequestBody
        return ReturnEntityUtil.success(opCf01Ser.queryPrescriptionDetails(cfsb));
    }

    /** 保存 (ClinicManageService.saveClinicInfo)*/
    @RequestMapping("/save")
    @ResponseBody
    @ApiOperation(value="保存" ,httpMethod="POST")
    public ReturnEntity<Integer> save(@Valid @RequestBody MsCfSaveReq req) {
        req.setIp(getIpAddress());
//        try {
//            req.setIp(getIpAddress());
//        }catch (Exception e){
//            logger.error("获取本机ip地址失败");
//        }
//        try {
//            req.setMac(getMac());
//        }catch (Exception e){
//            logger.error("获取本机mac地址失败");
//        }
        return ReturnEntityUtil.success(opCf01Ser.save(req, getUser()));
    }

    //根据选择的药品判断当前药品当前医生能否使用
    @RequestMapping("/isUse")
    @ResponseBody
    @ApiOperation(value="当前医生能否使用当前抗菌药物" ,httpMethod="POST")
    public ReturnEntity isUse(@RequestBody MsCfSaveReq req) {
        opCf01Ser.checkKjyw(req, getUser());
        return ReturnEntityUtil.success();
    }


    /** 根据系统参数QYCFCZQZTJ 未录入诊断，不允许录入处方处置(clinicManageService.queryIsAllowed) */
    @RequestMapping("/queryIsAllowed")
    @ResponseBody
    @ApiOperation(value="根据系统参数QYCFCZQZTJ 未录入诊断，不允许录入处方处置" ,httpMethod="POST")
    public ReturnEntity<String> queryIsAllowed() {
        SysXtcs xtcs = sysXtcsCacheSer.getByJGIdAndCsmc(getUser().getHospitalId(), "QYCFCZQZTJ");
        String csz = null;
        if(xtcs != null){
            csz = xtcs.getCsz();
        }
        return ReturnEntityUtil.success(csz);
    }

    /** 获取处方录入模块公共信息参数 1、门诊发药药房 2、医生处方权限 ...(clinicManageService.loadOutClinicInitParams) */
    @RequestMapping("/loadOutClinicInitParams")
    @ResponseBody
    @ApiOperation(value="获取处方录入模块公共信息参数" ,httpMethod="POST")
    public ReturnEntity<LoadOutClinicInitParamsResp> loadOutClinicInitParams() {
        return ReturnEntityUtil.success(opCf01Ser.loadOutClinicInitParams(getUser().getUserId()));
    }

    /** 载入附加项目(clinicManageService.loadAddition) */
    @RequestMapping("/loadAddition")
    @ResponseBody
    @ApiOperation(value="载入附加项目" ,httpMethod="POST")
    public ReturnEntity<PageInfo<LoadAdditionResp>> loadAddition(@ApiParam(name = "jzxh", value = "就诊序号", required = true) @RequestParam Integer jzxh, PageQuery page) {
        return ReturnEntityUtil.success(opCf01Ser.loadAddition(jzxh, page));
    }

    /** 检验处方拷贝信息(clinicPerscriptionService.perscriptionCopyCheck) */
    @RequestMapping("/perscriptionCopyCheck")
    @ResponseBody
    @ApiOperation(value="检验处方拷贝信息" ,httpMethod="POST")
    public ReturnEntity<PageInfo<LoadAdditionResp>> perscriptionCopyCheck(@RequestBody PerscriptionCopyCheckReq req) {
        opCf01Ser.perscriptionCopyCheck(req);
        return ReturnEntityUtil.success();
    }

    /** 校验库存信息(clinicManageService.checkInventory) */
    @RequestMapping("/checkInventory")
    @ResponseBody
    @ApiOperation(value="校验库存信息" ,httpMethod="POST")
    public ReturnEntity<CheckInventoryResp> checkInventory(CheckInventoryReq req) {
        return ReturnEntityUtil.success(opCf01Ser.checkInventory(req, getUser().getHospitalId()));
    }

    /** 获取医保药品信息(clinicManageService.queryYbypxx) */
    @RequestMapping("/queryYbypxx")
    @ResponseBody
    @ApiOperation(value="获取医保药品信息" ,httpMethod="POST")
    public ReturnEntity<List<QueryYbypxxResp>> queryYbypxx(@ApiParam(name = "ypcd", value = "药品产地", required = true) @RequestParam Integer ypcd,
                                                           @ApiParam(name = "ypxh", value = "药品序号", required = true) @RequestParam Integer ypxh) {
        List<QueryYbypxxResp> ret = opCf01Ser.queryYbypxx(ypcd, ypxh);
        return ReturnEntityUtil.success(ret);
    }

    /** 根据病人性质查询上级性质(ybCommonService.querySjBrxz) */
    @RequestMapping("/querySjBrxz")
    @ResponseBody
    @ApiOperation(value = "根据病人性质查询上级性质", httpMethod = "POST")
    public ReturnEntity<Integer> querySjBrxz(
            @ApiParam(name = "brxz", value = "病人性质", required = true) @RequestParam(value = "brxz") Integer brxz) {
        return ReturnEntityUtil.success(opMzxxSer.querySjBrxz(brxz));
    }

    /** 院内转诊(clinicManageService.saveYNZZSQ) */
    @RequestMapping("/saveYnzzsq")
    @ResponseBody
    @ApiOperation(value="院内转诊" ,httpMethod="POST")
    public ReturnEntity saveYnzzsq(@Valid OpYnzzsqSaveReq req) {
        opYnzzsqSer.saveYnzzsq(req);
        return ReturnEntityUtil.success();
    }

    /** 判断是否已经开始皮试 clinicManageService.querySkinTestStatus */
//    @RequestMapping("/querySkinTestStatus")
//    @ResponseBody
//    @ApiOperation(value="判断是否已经开始皮试" ,httpMethod="POST")
//    public ReturnEntity<Boolean> querySkinTestStatus(@ApiParam(name = "ypxh", value = "药品序号", required = true) @RequestParam(value = "ypxh") Integer ypxh,
//                                                     @ApiParam(name = "cfsb", value = "处方识别", required = true) @RequestParam(value = "cfsb") Integer cfsb){
//        return ReturnEntityUtil.success(ysMzPsjlSer.querySkinTestStatus(ypxh, cfsb));
//    }

    /** 获取费用自负比例 clinicManageService.getPayProportion */
    @RequestMapping("/getPayProportion")
    @ResponseBody
    @ApiOperation(value="获取费用自负比例" ,httpMethod="POST")
    public ReturnEntity<Object> getPayProportion(MzCfGetPayProportionReq req){
        Map<String, Object> zfbl = new HashMap<>(16);
        zfbl.put("TYPE", req.getType());
        zfbl.put("FYXH", req.getFyxh());
        zfbl.put("FYGB", req.getFygb());
        zfbl.put("BRXZ", req.getBrxz());
        Map<String, Object> ret = opGhksSer.getPayProportion(zfbl);
        return ReturnEntityUtil.success(ret.get("ZFBL"));
    }

    /** 获取私有药品属性 clinicManageService.loadPrivateYpxx  */
    @RequestMapping("/loadPrivateYpxx")
    @ResponseBody
    @ApiOperation(value="获取私有药品属性" ,httpMethod="POST")
    public ReturnEntity<Integer> loadPrivateYpxx(@ApiParam(name = "ypxh", value = "药品序号", required = true) @RequestParam(value = "ypxh") Integer ypxh){
        return ReturnEntityUtil.success(drugService.loadPrivateYpxx(ypxh, getUser().getHospitalId()));
    }

    /** 根据系统参数限制每张处方明细条数 clinicManageService.querySystemArgumentCFMXSL  */
    @RequestMapping("/querySystemArgumentCFMXSL")
    @ResponseBody
    @ApiOperation(value="根据系统参数限制每张处方明细条数" ,httpMethod="POST")
    public ReturnEntity<SystemArgumentCfmxslResp> querySystemArgumentCfmxsl(){
        return ReturnEntityUtil.success(opCf01Ser.querySystemArgumentCfmxsl(getUser()));
    }

    /** 查询全部药品 (PHAR_YPXX_MS)*/
    @RequestMapping("/queryCfAllYpxx")
    @ResponseBody
    @ApiOperation(value="查询全部药品" ,httpMethod="POST")
    public ReturnEntity<PageInfo<QueryCfypxxResp>> queryCfAllYpxx(QueryCfypxxReq req){
        return ReturnEntityUtil.success(opCf01Ser.queryCfAllYpxx(req, getUser()));
    }

    /** 根据组套载入组套明细信息 (clinicManageService.loadPersonalSet)*/
    @RequestMapping("/loadPersonalSet")
    @ResponseBody
    @ApiOperation(value="根据组套载入组套明细信息" ,httpMethod="POST")
    public ReturnEntity<List<LoadPersonalSetResp>> loadPersonalSet(@RequestBody LoadPersonalSetReq req){
        return ReturnEntityUtil.success(opCf01Ser.loadPersonalSet(req));
    }

    /** 根据药品序号获取药品信息（助手方式） (clinicManageService.loadMedcineInfo)*/
    @RequestMapping("/loadMedcineInfo")
    @ResponseBody
    @ApiOperation(value="根据药品序号获取药品信息（助手方式）" ,httpMethod="POST")
    public ReturnEntity<LoadMedcineInfoResp> loadMedcineInfo(LoadMedcineInfoReq req){
        return ReturnEntityUtil.success(opCf01Ser.loadMedcineInfo(req));
    }

    /** 删除处方 (clinicManageService.removeClinicInfo)*/
    @RequestMapping("/removeClinicInfo")
    @ResponseBody
    @ApiOperation(value="删除处方" ,httpMethod="POST")
    public ReturnEntity<LoadMedcineInfoResp> removeClinicInfo(@ApiParam(name = "cfsb", value = "处方识别", required = true) @RequestParam(value = "cfsb") Integer cfsb){
        opCf01Ser.removeClinicInfo(cfsb, getUser().getHospitalId());
        return ReturnEntityUtil.success();
    }

    /** 查询附加项目信息 (wardPatientManageService.loadAppendAdvice)*/
    @RequestMapping("/loadAppendAdvice")
    @ResponseBody
    @ApiOperation(value="查询附加项目信息" ,httpMethod="POST")
    public ReturnEntity<LoadMedcineInfoResp> loadAppendAdvice(@ApiParam(name = "cfsb", value = "处方识别", required = true) @RequestParam(value = "cfsb") Integer cfsb){
        //opCf01Ser.loadAppendAdvice();
        return ReturnEntityUtil.success();
    }

    /** 根据药品序号获取联动收费项目 (clinicManageService.getSkinTest)*/
    @RequestMapping("/getSkinTest")
    @ResponseBody
    @ApiOperation(value="根据药品序号获取联动收费项目" ,httpMethod="POST")
    public ReturnEntity<List<SkinXmldsfxmResp>> getSkinTest(@ApiParam(name = "ypxh", value = "药品序号", required = true) @RequestParam(value = "ypxh") Integer ypxh){
        DrugsTypkDetailResp ret = drugsTypkOutSer.getDrugsTypkById(ypxh);
        if(ret != null){
            Integer psid = ret.getPsid();
            SkinXmldsfxm skinXmldsfxm = new SkinXmldsfxm();
            skinXmldsfxm.setJgid(getUser().getHospitalId());
            skinXmldsfxm.setPsid(psid);
            List<SkinXmldsfxmResp> resp = skinXmldsfxmSer.doQueryLdsfxmList(skinXmldsfxm);
            return ReturnEntityUtil.success(resp);
        }
        return ReturnEntityUtil.success(null);
    }

    /** 载入皮试收费项目 (clinicManageService.loadPssfxm)*/
    @RequestMapping("/loadPssfxm")
    @ResponseBody
    @ApiOperation(value="载入皮试收费项目" ,httpMethod="POST")
    public ReturnEntity<GetSkinTestResp> loadPssfxm(){
        return ReturnEntityUtil.success();
    }

    /** 特殊药品 (clinicManageService.getTsypPb)*/
    @RequestMapping("/getTsypPb")
    @ResponseBody
    @ApiOperation(value="特殊药品" ,httpMethod="POST")
    public ReturnEntity<GetSkinTestResp> getTsypPb(){
        return ReturnEntityUtil.success();
    }

    /** 处方打印 (ReportForPrescriptionDetail)*/
    @GetMapping("/cfPrint")
    @ApiOperation(value="处方打印" ,httpMethod="GET")
    public void cfPrint(@Valid CfPrintReq req, HttpServletResponse response){
       opCf01Ser.cfPrint(req, getUser(),response);
    }

    /** 根据药品序号查询抗生素等级 */
    @RequestMapping("/getKssdjByYpxh")
    @ResponseBody
    @ApiOperation(value="根据药品序号查询抗生素等级" ,httpMethod="POST")
    public ReturnEntity<MzcfGetKssdjByYpxhResp> getKssdjByYpxh(@ApiParam(name = "ypxh", value = "药品序号", required = true) @RequestParam(value = "ypxh") Integer ypxh){
        DrugsTypkDetailResp typk = drugsTypkOutSer.getDrugsTypkById(ypxh);
        if(typk == null){
            throw BaseException.create("ERROR_DCTWORK_OP_0047");
        }

        Integer kssdj = typk.getKssdj();
        String yskssdj = hrPersonnelService.getPersonnelById(getUser().getUserId()).getAntibioticlevel();
        MzcfGetKssdjByYpxhResp resp = new MzcfGetKssdjByYpxhResp();
        resp.setKssdj(kssdj);
        resp.setYskssdj(yskssdj);
        return ReturnEntityUtil.success(resp);
    }

    /** 获取门诊抗生素参数 */
    @RequestMapping("/getMzKsscs")
    @ResponseBody
    @ApiOperation(value="获取门诊抗生素参数" ,httpMethod="POST")
    public ReturnEntity<AmqcKjywsycs> getMzKsscs(){
        AmqcKjywsycs ksscs = amqcKjywsycsService.getSycsById(getUser().getHospitalId());
        return ReturnEntityUtil.success(ksscs);
    }

    /** 保存抗菌药物申请理由 */
    @RequestMapping("/saveKjywsqly")
    @ResponseBody
    @ApiOperation(value="保存抗菌药物申请理由" ,httpMethod="POST")
    public ReturnEntity saveKjywsqly(@RequestBody List<SaveKjywsqlyReq> saveKjywsqlyReqList){
        opCf01Ser.saveKjywsqly(saveKjywsqlyReqList);
        return ReturnEntityUtil.success();
    }

    /** 【互联网医院】发起会议存储会议ID到Redis */
    @RequestMapping("/saveMeetingIdToRedis")
    @ResponseBody
    @ApiOperation(value="互联网医院】发起会议存储会议ID到Redis" ,httpMethod="POST")
    public ReturnEntity saveMeetingIdToRedis(@ApiParam(name = "jzlsh", value = "就诊流水号", required = true) @RequestParam(value = "jzlsh") String jzlsh,
                                             @ApiParam(name = "meetingId", value = "会议Id", required = true) @RequestParam(value = "meetingId") String meetingId){
        opCf01Ser.saveMeetingIdToRedis(jzlsh, meetingId);
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/selectMeetingIdToRedis")
    @ResponseBody
    @ApiOperation(value="互联网医院】发起会议存储会议ID到Redis" ,httpMethod="POST")
    public ReturnEntity<String> selectMeetingIdToRedis(@ApiParam(name = "jzlsh", value = "就诊流水号", required = true) @RequestParam(value = "jzlsh") String jzlsh){
        return ReturnEntityUtil.success(opCf01Ser.selectMeetingIdToRedis(jzlsh));
    }

    /**【互联网医院】从Redis销毁会议Id */
    @RequestMapping("/destoryMeetingIdInRedis")
    @ResponseBody
    @ApiOperation(value="【互联网医院】从Redis销毁会议Id" ,httpMethod="POST")
    public ReturnEntity destoryMeetingIdInRedis(@ApiParam(name = "jzlsh", value = "就诊流水号", required = true) @RequestParam(value = "jzlsh") String jzlsh){
        opCf01Ser.destoryMeetingIdInRedis(jzlsh);
        return ReturnEntityUtil.success();
    }

    /**
     * 获取处方打印数据
     * @param cfsb
     * @return
     */
    @RequestMapping("/getCfPrintData")
    @ResponseBody
    @ApiOperation(value="查询处方打印数据" ,httpMethod="POST")
    public ReturnEntity<CfPrintResponse> getCfPrintData(@ApiParam(name = "cfsb", value = "处方识别", required = true) @RequestParam(value = "cfsb") Integer cfsb){
        return ReturnEntityUtil.success(opCf01Ser.getCfPrintData(cfsb,getUser()));
    }
}

