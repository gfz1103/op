
package com.buit.cis.op.dctwork.controller;

import cn.hutool.core.bean.BeanUtil;
import com.buit.cis.op.dctwork.service.PatientListSer;
import com.buit.commons.BaseSpringController;
import com.buit.commons.request.OpGhmxReq;
import com.buit.commons.request.PatientInfoReq;
import com.buit.commons.request.SaveInitClinicInfoReq;
import com.buit.commons.response.OpGhmxResp;
import com.buit.commons.response.PatientInfoResp;
import com.buit.emr.model.OpBcjlModel;
import com.buit.emr.service.OpBcjlService;
import com.buit.op.response.SaveInitClinicInfoResp;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Map;

/**
 * 门诊_挂号明细表<br>
 * @author 老花生
 */
@Api(tags="患者列表")
@Controller
@RequestMapping("/opghmx")
public class PatientListCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(PatientListCtr.class);

    @Autowired
    private PatientListSer patientListSer;
    @DubboReference
    private OpBcjlService opBcjlService;

    @RequestMapping("/queryPatientList")
    @ResponseBody
    @ApiOperation(value="查询患者列表" ,httpMethod="POST")
    public ReturnEntity<PageInfo<OpGhmxResp>> queryPatientList(@Valid OpGhmxReq req){
        return ReturnEntityUtil.success(patientListSer.queryPatientList(req, getUser()));
    }

    @RequestMapping("/nextPatient")
    @ResponseBody
    @ApiOperation(value="下一位" ,httpMethod="POST")
    public ReturnEntity<OpGhmxResp> nextPatient(@Valid OpGhmxReq req){
        return ReturnEntityUtil.success(patientListSer.nextPatient(req, getUser()));
    }

    /** 选择病人后，初始化病人就诊信息 (clinicManageService.saveInitClinicInfo)*/
    @RequestMapping("/saveInitClinicInfo")
    @ResponseBody
    @ApiOperation(value="选择病人后，初始化病人就诊信息" ,httpMethod="POST")
    public ReturnEntity<SaveInitClinicInfoResp> saveInitClinicInfo(SaveInitClinicInfoReq req) {
        Map<String, Object> body = BeanUtil.beanToMap(req);
//        String ipAddress = "";
//        try {
//            ipAddress = getIpAddress();
//        }catch (Exception e){
//            logger.error("获取本机ip地址失败");
//        }
//        try {
//            body.put("mac",getMac());
//        }catch (Exception e){
//            logger.error("获取本机mac地址失败");
//        }
        SaveInitClinicInfoResp resp = patientListSer.saveInitClinicInfo(body, getUser().getUserId(), getUser().getHospitalId(),getIpAddress());

        return ReturnEntityUtil.success(resp);
    }

    /** 载入病历首页信息 clinicManageService.loadClinicInfo */
    @RequestMapping("/loadClinicInfo")
    @ResponseBody
    @ApiOperation(value="载入病历首页信息" ,httpMethod="POST")
    public ReturnEntity<PatientInfoResp> loadClinicInfo(@Valid PatientInfoReq req){
        return ReturnEntityUtil.success(patientListSer.intoPatientInfo(req, getUser()));
    }

    /** 调用emr病程记录信息 */
    @RequestMapping("/queryBcjlByEmr")
    @ResponseBody
    @ApiOperation(value="调用emr病程记录信息" ,httpMethod="POST")
    public ReturnEntity<OpBcjlModel> queryBcjlByEmr(@ApiParam(name = "jzlsh", value = "就诊流水号", required = true) @RequestParam String jzlsh){
        return ReturnEntityUtil.success(opBcjlService.queryBcjl(jzlsh));
    }

//
////    @RequestMapping("/findList")
////    @ResponseBody
////    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
////    public ReturnEntity<List<OpGhmxResp>> getByEntity( OpGhmxReq opghmx){//@RequestBody
////        return ReturnEntityUtil.success(opGhmxSer.findByEntity(opghmx));
////    }
////
////    @RequestMapping("/getOneByEntity")
////    @ResponseBody
////    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
////    public ReturnEntity<OpGhmxResp> getOneByEntity(OpGhmxReq opghmx){
////        List<OpGhmx> list=opGhmxSer.findByEntity(opghmx);
////        if(list.size()>0){
////           return ReturnEntityUtil.success(list.get(0));
////        }
////        return ReturnEntityUtil.success();
////    }
////
////    /** 新增 */
////    @RequestMapping("/add")
////    @ResponseBody
////    @ApiOperation(value="新增" ,httpMethod="POST")
////    public ReturnEntity<OpGhmxResp> add(OpGhmxReq opGhmx) {
////        opGhmxSer.insert(opGhmx);
////        return ReturnEntityUtil.success(opGhmx);
////    }
////    /** 编辑 */
////    @RequestMapping("/edit")
////    @ResponseBody
////    @ApiOperation(value="编辑" ,httpMethod="POST")
////    public ReturnEntity<OpGhmxResp> edit(OpGhmxReq opGhmx)  {
////        opGhmxSer.update(opGhmx);
////        return ReturnEntityUtil.success(opGhmx);
////    }
////
////    /** 删除 */
////    @RequestMapping("/delete")
////    @ResponseBody
////    @ApiOperation(value="按条件查询" ,httpMethod="POST")
////    public ReturnEntity<OpGhmxResp> delete(OpGhmxReq opGhmx) {
////        opGhmxSer.removeByEntity(opGhmx);
////        return ReturnEntityUtil.success(opGhmx);
////    }
//
}

