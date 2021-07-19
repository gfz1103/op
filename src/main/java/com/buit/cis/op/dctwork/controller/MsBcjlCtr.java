
package com.buit.cis.op.dctwork.controller;


import cn.hutool.core.bean.BeanUtil;
import com.buit.cis.op.dctwork.request.*;
import com.buit.cis.op.dctwork.service.GyBlmbSer;
import com.buit.cis.op.dctwork.service.GyZlfaSer;
import com.buit.cis.op.dctwork.service.MsBcjlSer;
import com.buit.commons.BaseSpringController;
import com.buit.commons.dao.OpGhmxDao;
import com.buit.commons.dao.OpMzxxDao;
import com.buit.commons.dao.OpYsJzlsDao;
import com.buit.commons.model.MsBcjl;
import com.buit.commons.response.*;
import com.buit.emr.model.OpBcjlModel;
import com.buit.emr.service.OpBcjlService;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 门诊_门诊病历 | 病程记录<br>
 * @author 老花生
 */
@Api(tags="门诊_门诊病历 | 病程记录")
@Controller
@RequestMapping("/msbcjl")
public class MsBcjlCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(MsBcjlCtr.class);


    @Autowired
    private OpYsJzlsDao opYsJzlsDao;

    @Autowired
    private OpMzxxDao opMzxxDao;

    @Autowired
    private OpGhmxDao opGhmxDao;

    @Autowired
    private MsBcjlSer msBcjlSer;
    @Autowired
    private GyBlmbSer gyBlmbSer;
    @Autowired
    private GyZlfaSer gyZlfaSer;
    @DubboReference
    private OpBcjlService opBcjlService;

//    /** 病历复制 */
//    @RequestMapping("/copy")
//    @ResponseBody
//    @ApiOperation(value="病历复制" ,httpMethod="POST")
//    public ReturnEntity<MsBcjlCopyResp> copy(MsBcjlCopyReq req) {
//        return ReturnEntityUtil.success(msBcjlSer.copy(req, getUser()));
//    }

    /** 查询排版科室 */
    @RequestMapping("/queryShiftDept")
    @ApiOperation(value="查询排版科室" ,httpMethod="POST")
    public ReturnEntity<List<QueryShiftDeptResp>> queryShiftDept(QueryShiftDeptReq req) {
        return ReturnEntityUtil.success(msBcjlSer.queryShiftDept(req, getUser(), getIpAddress()));
    }

    /** 清空 */
    @RequestMapping("/removeBcjl")
    @ResponseBody
    @ApiOperation(value="清空" ,httpMethod="POST")
    public ReturnEntity removeBcjl(MsBcjlRemoveReq req) {
        msBcjlSer.remove(req);
        return ReturnEntityUtil.success();
    }

    /** 保存病历信息 (clinicManageService.saveMsBcjl)*/
    @RequestMapping("/saveMsBcjl")
    @ResponseBody
    @ApiOperation(value="保存病历信息" ,httpMethod="POST")
    public ReturnEntity saveMsBcjl(@RequestBody MsBcjlSaveReq req) {
        Map<String, Object> body = BeanUtil.beanToMap(req);
        msBcjlSer.saveMsBcjl(body, getUser());
        return ReturnEntityUtil.success();
    }

    /** 查询医生排班(clinicManageService.queryYspb)*/
    @RequestMapping("/queryYspb")
    @ResponseBody
    @ApiOperation(value="查询医生排班" ,httpMethod="POST")
    public ReturnEntity<List<QueryYspbResp>> queryYspb(@ApiParam(name = "ghks", value = "挂号科室", required = true) @RequestParam Integer ghks,
                                                       @ApiParam(name = "ysdm", value = "医生代码", required = true) @RequestParam Integer ysdm) {
        List<QueryYspbResp> resp = msBcjlSer.queryYspb(ghks, ysdm, getUser().getHospitalId());
        return ReturnEntityUtil.success(resp);
    }

    /** 临床完成-暂挂和结束调用(clinicManageService.saveClinicFinish)*/
    @RequestMapping("/saveClinicFinish")
    @ResponseBody
    @ApiOperation(value="临床完成" ,httpMethod="POST")
    public ReturnEntity saveClinicFinish(SaveClinicFinishReq req) {
        msBcjlSer.saveClinicFinish(req, getUser(), getIpAddress());
        return ReturnEntityUtil.success();
    }

    /** 载入结算明细(clinicManageService.loadSettlementInfo)*/
    @RequestMapping("/loadSettlementInfo")
    @ResponseBody
    @ApiOperation(value="载入结算明细" ,httpMethod="POST")
    public ReturnEntity<LoadSettlementInfoResp> loadSettlementInfo(@ApiParam(name = "brid", value = "病人id", required = true) @RequestParam Integer brid,
                                                                   @ApiParam(name = "jzxh", value = "就诊序号", required = true) @RequestParam Integer jzxh) {
        return ReturnEntityUtil.success(msBcjlSer.loadSettlementInfo(brid, jzxh));
    }

    /** 保存诊间预约信息(clinicManageService.saveYyxx)*/
    @RequestMapping("/saveYyxx")
    @ResponseBody
    @ApiOperation(value="保存诊间预约信息" ,httpMethod="POST")
    public ReturnEntity saveYyxx(@Valid SaveYyxxReq req) {

        Map<String, Object> body = BeanUtil.beanToMap(req);

        msBcjlSer.saveYyxx(getUser(), body);
        return ReturnEntityUtil.success();
    }

    /** 病历复制(clinicManageService.blfzQuery)*/
    @RequestMapping("/blfzQuery")
    @ResponseBody
    @ApiOperation(value="病历复制" ,httpMethod="POST")
    public ReturnEntity<MsBcjl> blfzQuery(@ApiParam(name = "brid", value = "病人id", required = true) @RequestParam Integer brid,
                                          @ApiParam(name = "jzxh", value = "就诊序号", required = true) @RequestParam Integer jzxh) {

        return ReturnEntityUtil.success(msBcjlSer.blfzQuery(brid, jzxh));
    }

    /** 病历模板调入 */
    @RequestMapping("/templateImport")
    @ResponseBody
    @ApiOperation(value="病历模板调入" ,httpMethod="POST")
    public ReturnEntity<GyBlmbDetailsResp> templateImport(@ApiParam(name = "jlxh", value = "记录序号", required = true) @RequestParam Integer jlxh){
        GyBlmbDetailsResp ret = gyBlmbSer.getObjbyId(jlxh);
        return ReturnEntityUtil.success(ret);
    }

    /** 查询诊疗方案列表 */
    @RequestMapping("/queryZlfa")
    @ResponseBody
    @ApiOperation(value="查询诊疗方案列表" ,httpMethod="POST")
    public ReturnEntity<PageInfo<GyZlfaResp>> queryZlfa(GyZlfaReq req){
        req.setJgid(getUser().getHospitalId());
        req.setYgdm(getUser().getUserId());
        PageInfo<GyZlfaResp> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> gyZlfaSer.findByEntity(req)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

//    /** 诊疗方案调入(clinicManageService.saveClinicTherapeutic) */
//    @RequestMapping("/saveClinicTherapeutic")
//    @ResponseBody
//    @ApiOperation(value="诊疗方案调入" ,httpMethod="POST")
//    public ReturnEntity saveClinicTherapeutic(@Valid SaveClinicTherapeuticReq req){
//        return ReturnEntityUtil.success(msBcjlSer.saveClinicTherapeutic(req, getUser()));
//    }

    /** 调用emr病程记录信息 */
    @RequestMapping("/queryBcjlByEmr")
    @ResponseBody
    @ApiOperation(value="调用emr病程记录信息" ,httpMethod="POST")
    public ReturnEntity<OpBcjlModel> queryBcjlByEmr(@ApiParam(name = "jzlsh", value = "就诊流水号", required = true) @RequestParam String jzlsh){
        return ReturnEntityUtil.success(opBcjlService.queryBcjl(jzlsh));
    }

    /** 查询患者的在线状态 **/
    @RequestMapping("/getOnLineStatus")
    @ResponseBody
    @ApiOperation(value = "查询用户在线状态",httpMethod="POST")
    public ReturnEntity<Map<String,Object>> getOnLineStatus(@RequestBody List<String> jzlshList){
        return ReturnEntityUtil.success(msBcjlSer.getOnLineStatus(jzlshList));
    }

//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<MsBcjlResp> edit(MsBcjlReq msBcjl)  {
//        msBcjlSer.update(msBcjl);
//        return ReturnEntityUtil.success(msBcjl);
//    }
//
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<MsBcjlResp> delete(MsBcjlReq msBcjl) {
//        msBcjlSer.removeByEntity(msBcjl);
//        return ReturnEntityUtil.success(msBcjl);
//    }

//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<MsBcjlResp>> queryPage(MsBcjlReq msbcjl,PageQuery page){
//        PageInfo<MsBcjl> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> msBcjlSer.findByEntity(msbcjl)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<MsBcjlResp>> getByEntity( MsBcjlReq msbcjl){//@RequestBody
//        return ReturnEntityUtil.success(msBcjlSer.findByEntity(msbcjl));
//    }
//
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<MsBcjlResp> getOneByEntity(MsBcjlReq msbcjl){
//        List<MsBcjl> list=msBcjlSer.findByEntity(msbcjl);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));
//        }
//        return ReturnEntityUtil.success();
//    }
//
//    /** 保存病历信息 (clinicManageService.saveMsBcjl)*/
//    @RequestMapping("/saveMsBcjl")
//    @ResponseBody
//    @ApiOperation(value="保存病历信息" ,httpMethod="POST")
//    public ReturnEntity saveMsBcjl(MsBcjlSaveReq req) {
//        Map<String, Object> body = BeanUtil.beanToMap(req);
//        msBcjlSer.saveMsBcjl(body, getUser());
//        return ReturnEntityUtil.success();
//    }
//    /** 暂存 或 就诊结束(clinicManageService.saveMsBcjl) */
//    @RequestMapping("/saveMsBcjlEnd")
//    @ResponseBody
//    @ApiOperation(value="暂存 或 就诊结束" ,httpMethod="POST")
//    public ReturnEntity saveMsBcjlEnd(PatientIndexToSaveReq req) {
//
//        msBcjlSer.saveMsBcjl(req, getUser(), this.getIpAddress());
//        return ReturnEntityUtil.success();
//    }
}

