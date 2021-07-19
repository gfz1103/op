
package com.buit.cis.op.dctwork.controller;

import com.buit.cis.op.dctwork.response.OpZydjPageResp;
import com.buit.cis.op.dctwork.service.OpZydjSer;
import com.buit.commons.BaseSpringController;
import com.buit.commons.request.OpZydjPageReq;
import com.buit.commons.request.OpZydjSaveReq;
import com.buit.commons.request.OpZydjUpdateReq;
import com.buit.commons.response.RydjPrintDataResponse;
import com.buit.op.request.OpZydjUpdateStatusReq;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * <br>
 * 门诊住院登记
 *
 * @author 老花生
 */
@Api(tags = "门诊住院登记")
@Controller
@RequestMapping("/mzzydj")
public class MzZydjCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(MzZydjCtr.class);

    @Autowired
    private OpZydjSer opZydjSer;


    /**
     * 查询住院登记单列表(hospitalizedRegisterService.getHospitalizedRegisterList)
     */
    @RequestMapping("/getHospitalizedRegisterList")
    @ResponseBody
    @ApiOperation(value = "查询住院登记单列表", httpMethod = "POST")
    public ReturnEntity<PageInfo<OpZydjPageResp>> getHospitalizedRegisterList(@Valid OpZydjPageReq req) {
        return ReturnEntityUtil.success(opZydjSer.getHospitalizedRegisterList(req, getUser()));
    }


    /**
     * 新增住院登记单(hospitalizedRegisterService.saveHosReg)
     */
    @RequestMapping("/saveHosReg")
    @ResponseBody
    @ApiOperation(value = "新增住院登记单", httpMethod = "POST")
    public ReturnEntity<Integer> saveHosReg(@Valid OpZydjSaveReq req) {
        req.setMzys(getUser().getUserId().toString());
        req.setJgid(getUser().getHospitalId().toString());
        return ReturnEntityUtil.success(opZydjSer.saveHosReg(req));
    }


    /**
     * 修改住院登记单状态(hospitalizedRegisterService.updateHosReg)
     */
    @RequestMapping("/updateHosRegStatus")
    @ResponseBody
    @ApiOperation(value = "修改住院登记单状态", httpMethod = "POST")
    public ReturnEntity updateHosRegStatus(OpZydjUpdateStatusReq req) {
        opZydjSer.updateHosRegStatus(req);
        return ReturnEntityUtil.success();
    }


    /**
     * 修改住院登记单(hospitalizedRegisterService.updateHosReg)
     */
    @RequestMapping("/updateHosReg")
    @ResponseBody
    @ApiOperation(value = "修改住院登记单", httpMethod = "POST")
    public ReturnEntity updateHosReg(@Valid OpZydjUpdateReq req) {
        opZydjSer.updateHosReg(req);
        return ReturnEntityUtil.success();
    }


    /**
     * 住院登记单删除
     */
    @RequestMapping("/deleteById")
    @ResponseBody
    @ApiOperation(value = "住院登记单删除", httpMethod = "POST")
    public ReturnEntity deleteById(Integer djid) {
        opZydjSer.getEntityMapper().deleteById(djid);
        return ReturnEntityUtil.success();
    }

    /**
     * 住院登记单打印(HospitalizedRegisterFile--HospitalizedRegisterForm.jrxml)
     */
    @GetMapping("/zydjPrint")
    @ApiOperation(value = "住院登记单打印", httpMethod = "GET")
    public void zydjPrint(@ApiParam(name = "pkey", value = "id", required = true) @RequestParam(value = "pkey") Integer pkey, HttpServletResponse response) {
        opZydjSer.zydjPrint(pkey, getUser().getHospitalId(), response);
    }

    /**
     * 入院证打印数据
     * @param djid
     */
    @RequestMapping("/getRydjPrintData")
    @ResponseBody
    @ApiOperation(value = "入院证打印数据", httpMethod = "POST")
    public ReturnEntity<RydjPrintDataResponse> getRydjPrintData(@ApiParam(name = "djid", value = "登记单ID", required = true) @RequestParam(value = "djid") Integer djid) {
        RydjPrintDataResponse rydjPrintData = opZydjSer.getRydjPrintData(djid);
        return ReturnEntityUtil.success(rydjPrintData);
    }

}

