package com.buit.cis.op.dctwork.controller;

import com.buit.cis.op.dctwork.request.OpJbzmQueryReq;
import com.buit.cis.op.dctwork.request.Opjbzmreq;
import com.buit.cis.op.dctwork.response.JbzmPrintResponse;
import com.buit.cis.op.dctwork.response.OpJbzmQueryResponse;
import com.buit.cis.op.dctwork.service.CisJbzmService;
import com.buit.cis.op.dctwork.service.OpBqzmSer;
import com.buit.commons.BaseSpringController;
import com.buit.commons.response.OpBqzmResp;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @Author weijing
 * @Date 2021-03-26 15:33
 * @Description
 **/
@Api(tags="门诊疾病证明")
@Controller
@RequestMapping("/cisjbzm")
public class CisJbzmCtr extends BaseSpringController {
    static final Logger logger = LoggerFactory.getLogger(OpBqzmCtr.class);

    @Autowired
    private CisJbzmService cisJbzmService;

    @Autowired
    private OpBqzmSer opBqzmSer;

    @RequestMapping("/queryJbzm")
    @ResponseBody
    @ApiOperation(value="查询疾病证明" ,httpMethod="POST")
    public ReturnEntity<PageInfo<OpJbzmQueryResponse>> queryJbzm(@RequestBody @Valid OpJbzmQueryReq req) {
        PageInfo<OpJbzmQueryResponse> pageInfo = cisJbzmService.queryJbzm(req, getUser());
        return ReturnEntityUtil.success(pageInfo);
    }

    /**
     * 查询病情证明单打印数据
     * @param bqid
     * @return
     */
    @RequestMapping("/getJbzmPrintData")
    @ResponseBody
    @ApiOperation(value="病情证明单打印数据" ,httpMethod="POST")
    public ReturnEntity<JbzmPrintResponse> getJbzmPrintData(@ApiParam(name = "bqid", value = "病情id(主键)", required = true) @RequestParam(value = "bqid") Integer bqid) {
        return ReturnEntityUtil.success(cisJbzmService.getJbzmPrintData(bqid));
    }

    @RequestMapping("/addOrUpdateOpJbzm")
    @ResponseBody
    @ApiOperation(value="新增/修改病情证明" ,httpMethod="POST")
    public ReturnEntity addOrUpdateOpJbzm(@RequestBody @Valid Opjbzmreq opjbzmreq) {
        cisJbzmService.addOrUpdateOpJbzm(opjbzmreq,getUser());
        return ReturnEntityUtil.success();
    }

    /** 根据ID删除 */
    @RequestMapping("/deleteByBqid")
    @ResponseBody
    @ApiOperation(value="根据ID删除" ,httpMethod="POST")
    public ReturnEntity<OpBqzmResp> delete(@ApiParam(name = "bqid", value = "疾病证明单ID", required = true) @RequestParam(value = "bqid") Integer bqid) {
        opBqzmSer.removeById(bqid);
        return ReturnEntityUtil.success();
    }
}
