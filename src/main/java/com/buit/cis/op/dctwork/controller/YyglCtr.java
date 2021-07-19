
package com.buit.cis.op.dctwork.controller;

import com.buit.apply.response.LoadPatientInfoResp;
import com.buit.apply.response.QueryRecentTimeByHyrqResp;
import com.buit.cis.op.dctwork.service.OpSbhySer;
import com.buit.commons.BaseSpringController;
import com.buit.commons.request.*;
import com.buit.commons.response.LoadAppointedInfoResp;
import com.buit.commons.response.QueryJcSqdListResp;
import com.buit.commons.response.QueryYyksYsInfoResp;
import com.buit.his.op.reg.response.YyglResp;
import com.buit.his.op.reg.service.OpGhksSer;
import com.buit.his.op.reg.service.OpYyghSer;
import com.buit.system.response.LoadSqdDetailInfoResp;
import com.buit.system.service.DicZlxmService;
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
import java.sql.Date;
import java.util.List;

/**
 * 预约管理<br>
 * @author 老花生
 */
@Api(tags="预约管理")
@Controller
@RequestMapping("/yygl")
public class YyglCtr extends BaseSpringController {


    static final Logger logger = LoggerFactory.getLogger(YyglCtr.class);

    @Autowired
    private OpGhksSer opGhksSer;
    @Autowired
    private OpSbhySer opSbhySer;
    @Autowired
    private OpYyghSer opyyghSer;
    @DubboReference
    private DicZlxmService dicZlxmService;

    /**预约排班科室查询(appointmentManageService.querySchedulingDepartment)*/
    @RequestMapping("/yyglQuery")
    @ResponseBody
    @ApiOperation(value="预约管理" ,httpMethod="POST")
    public ReturnEntity<PageInfo<YyglResp>> yyglQuery(@Valid YyglReq req){
        return ReturnEntityUtil.success(opGhksSer.yyglQuery(req, getUser()));
    }

    /**预约挂号校验(appointmentManageService.checkCanAppointedToday)*/
    @RequestMapping("/checkCanAppointedToday")
    @ResponseBody
    @ApiOperation(value="预约挂号校验" ,httpMethod="POST")
    public ReturnEntity<Boolean> checkCanAppointedToday(@Valid CheckCanAppointedTodayReq req){
        return ReturnEntityUtil.success(opGhksSer.checkCanAppointedToday(req));
    }

    /**查询诊间医技预病人信息(sqdManageService.loadPatientInfo)*/
    @RequestMapping("/loadPatientInfo")
    @ResponseBody
    @ApiOperation(value="查询诊间医技预病人信息" ,httpMethod="POST")
    public ReturnEntity<List<LoadPatientInfoResp>> loadPatientInfo(@ApiParam(name = "searchType", value = "类型：1 门诊号码 2 住院号码", required = true) @RequestParam Integer searchType,
                                                                   @ApiParam(name = "searchValue", value = "查询值", required = true) @RequestParam String searchValue){
        return ReturnEntityUtil.success(opGhksSer.loadPatientInfo(searchType, searchValue));
    }

    /**查询医技预病人申请单详细信息(sqdManageService.loadSqdDetailInfo)*/
    @RequestMapping("/loadSqdDetailInfo")
    @ResponseBody
    @ApiOperation(value="查询医技预病人申请单详细信息" ,httpMethod="POST")
    public ReturnEntity<List<LoadSqdDetailInfoResp>> loadSqdDetailInfo(@ApiParam(name = "type", value = "申请类型", required = true) @RequestParam Integer type,
                                                                       @ApiParam(name = "jcxh", value = "检查序号", required = true) @RequestParam Integer jcxh){
        return ReturnEntityUtil.success(opGhksSer.loadSqdDetailInfo(type, jcxh));
    }

    /** 判断号源是否已经被占用(sqdManageService.checkHYID) */
    @RequestMapping("/checkHyid")
    @ResponseBody
    @ApiOperation(value="判断号源是否已经被占用" ,httpMethod="POST")
    public ReturnEntity<Boolean> checkHyid(@ApiParam(name = "hyid", value = "号源ID", required = true) @RequestParam Integer hyid){//@RequestBody
        return ReturnEntityUtil.success(opSbhySer.checkHyid(hyid));
    }

    /** 冻结设备号源(sqdManageService.freezeSBHH) */
    @RequestMapping("/freezeSBHH")
    @ResponseBody
    @ApiOperation(value="冻结设备号源" ,httpMethod="POST")
    public ReturnEntity freezeSBHH(@ApiParam(name = "hyid", value = "号源ID", required = true) @RequestParam Integer hyid){//@RequestBody
        opSbhySer.freezeSbhh(hyid, getUser().getUserId());
        return ReturnEntityUtil.success();
    }

    /** 解冻设备号源(sqdManageService.unfreezeSBHH) */
    @RequestMapping("/unfreezeSBHH")
    @ResponseBody
    @ApiOperation(value="解冻设备号源" ,httpMethod="POST")
    public ReturnEntity unfreezeSBHH(@ApiParam(name = "hyid", value = "号源ID", required = true) @RequestParam Integer hyid){//@RequestBody
        opSbhySer.unfreezeSbhh(hyid);
        return ReturnEntityUtil.success();
    }

    /** 查询设备指定日期最近的号源(sqdManageService.queryRecentTimeByHYRQ) */
    @RequestMapping("/queryRecentTimeByHyrq")
    @ResponseBody
    @ApiOperation(value="查询设备指定日期最近的号源" ,httpMethod="POST")
    public ReturnEntity<List<QueryRecentTimeByHyrqResp>> queryRecentTimeByHyrq(@ApiParam(name = "jklx", value = "接口类型", required = true) @RequestParam Integer jklx,
                                                                               @ApiParam(name = "hyrq", value = "号源日期", required = true) @RequestParam Date hyrq){//@RequestBody
        return ReturnEntityUtil.success(opSbhySer.queryRecentTimeByHyrq(jklx, hyrq));
    }

    /**加载预约信息(appointmentManageService.loadAppointedInfo)*/
    @RequestMapping("/loadAppointedInfo")
    @ResponseBody
    @ApiOperation(value="加载预约信息" ,httpMethod="POST")
    public ReturnEntity<List<LoadAppointedInfoResp>> loadAppointedInfo(LoadAppointedInfoReq req){
        List<LoadAppointedInfoResp> resp = opGhksSer.loadAppointedInfo(req);
        return ReturnEntityUtil.success(resp);
    }

    /**保存预约挂号(appointmentManageService.saveAppointedInfomation)*/
    @RequestMapping("/saveAppointedInfomation")
    @ResponseBody
    @ApiOperation(value="保存预约挂号" ,httpMethod="POST")
    public ReturnEntity<Object> saveAppointedInfomation(SaveAppointedInfomationReq req) {
        return ReturnEntityUtil.success(opGhksSer.saveAppointedInfomation(req, getUser()));
    }

    /**判断是否能更改预约信息(appointmentManageService.checkCanModifyAppointment)*/
    @RequestMapping("/checkCanModifyAppointment")
    @ResponseBody
    @ApiOperation(value="判断是否能更改预约信息" ,httpMethod="POST")
    public ReturnEntity<Boolean> checkCanModifyAppointment(@ApiParam(name = "brid", value = "病人id", required = true) @RequestParam Integer brid,
                                                          @ApiParam(name = "yyxh", value = "预约序号", required = true) @RequestParam Integer yyxh) {
        return ReturnEntityUtil.success(opGhksSer.checkCanModifyAppointment(brid, yyxh, getUser().getHospitalId()));
    }

    /**改预约信息(appointmentManageService.modifyAppointedInfo)*/
    @RequestMapping("/modifyAppointedInfo")
    @ResponseBody
    @ApiOperation(value="改预约信息" ,httpMethod="POST")
    public ReturnEntity modifyAppointedInfo(ModifyAppointedInfoReq req) {
        req.setUserId(getUser().getUserId());
        opGhksSer.modifyAppointedInfo(req);
        return ReturnEntityUtil.success();
    }

    /**查询医技检查申请单列表(appointmentManageService.queryJcSqdList)*/
    @RequestMapping("/queryJcSqdList")
    @ResponseBody
    @ApiOperation(value="查询医技检查申请单列表" ,httpMethod="POST")
    public ReturnEntity<List<QueryJcSqdListResp>> queryJcSqdList(QueryJcSqdListReq req) {
        return ReturnEntityUtil.success(opGhksSer.queryJcSqdList(req));
    }

    @RequestMapping("/deleteYygl")
    @ResponseBody
    @ApiOperation(value="删除预约" ,httpMethod="POST")
    public ReturnEntity<List<QueryJcSqdListResp>> deleteYygl(@ApiParam(name = "yyxh", value = "预约序号", required = true) @RequestParam Integer yyxh) {
        opyyghSer.removeById(yyxh);
        return ReturnEntityUtil.success();
    }

    /** 查询预约科室医生(simpleQuery.MS_YSPB_MANAGE)
     * @return*/
    @RequestMapping("/queryYyksYsInfo")
    @ResponseBody
    @ApiOperation(value="查询预约科室医生" ,httpMethod="POST")
    public ReturnEntity<List<QueryYyksYsInfoResp>> queryYyksYsInfo(@Valid QueryYyksYsInfoReq req){
        return ReturnEntityUtil.success(opyyghSer.queryYyksYsInfo(req));
    }
}
