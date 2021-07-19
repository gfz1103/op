package com.buit.cis.op.dctwork.ybtspost.controller;

import cn.hutool.core.thread.ThreadUtil;
import com.buit.cis.op.dctwork.ybtspost.request.CfRequest;
import com.buit.cis.op.dctwork.ybtspost.service.YbtspostService;
import com.buit.commons.BaseSpringController;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @Author weijing
 * @Date 2021-04-10 16:04
 * @Description
 **/
@Api(tags="医保智能提醒")
@Controller
@RequestMapping("/ybtspost")
public class YbtspostController extends BaseSpringController {
    static final Logger logger = LoggerFactory.getLogger(YbtspostController.class);

    @Autowired
    private YbtspostService ybtspostService;

    @RequestMapping("/mzjz")
    @ResponseBody
    @ApiOperation(value="4.1门诊就诊" ,httpMethod="POST")
    public ReturnEntity mzjz(@ApiParam(name = "jzlsh", value = "就诊流水号", required = true) @RequestParam String jzlsh) {
        ybtspostService.mzjz(jzlsh,getUser().getHospitalId(), getIpAddress());
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/mzzd")
    @ResponseBody
    @ApiOperation(value="4.2门诊诊断" ,httpMethod="POST")
    public ReturnEntity mzzd(@ApiParam(name = "jzlsh", value = "就诊流水号", required = true) @RequestParam String jzlsh) {
        ybtspostService.mzzd(jzlsh, getUser().getHospitalId(), getIpAddress());
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/lrcf")
    @ResponseBody
    @ApiOperation(value="4.3录入处方" ,httpMethod="POST")
    public ReturnEntity lrcf(@RequestBody @Valid CfRequest request) {
        //医保智能提醒
        ThreadUtil.execAsync(()->{
            logger.info("【录入处方】调用医保智能提醒开始");
            try {
                ybtspostService.lrcf(request,getUser().getHospitalId(),getIpAddress());
            }catch (Exception e){
                logger.error("【录入处方】智能提醒接口异常",e);
            }
            logger.info("【录入处方】调用医保智能提醒结束");
        });

        return ReturnEntityUtil.success();
    }

    @RequestMapping("/bccf")
    @ResponseBody
    @ApiOperation(value="4.4保存处方" ,httpMethod="POST")
    public ReturnEntity bccf(@ApiParam(name = "jzlsh", value = "就诊流水号", required = true) @RequestParam String jzlsh,
                             @ApiParam(name = "cfsb", value = "处方编号", required = true) @RequestParam Integer cfsb) {
        ybtspostService.bccf(jzlsh,cfsb, getUser().getHospitalId(),getIpAddress());
        return ReturnEntityUtil.success();
    }
}
