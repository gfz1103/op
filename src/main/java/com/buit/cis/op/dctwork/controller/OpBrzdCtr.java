
package com.buit.cis.op.dctwork.controller;

import com.buit.cis.op.dctwork.service.OpBrzdSer;
import com.buit.commons.BaseSpringController;
import com.buit.commons.request.OpBrzdQueryReq;
import com.buit.commons.request.OpBrzdReq;
import com.buit.commons.request.OpBrzdSaveReq;
import com.buit.commons.response.OpBrzdQueryResp;
import com.buit.commons.response.OpBrzdResp;
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

import java.util.List;

/**
 * 病人诊断<br>
 * @author 老花生
 */
@Api(tags="患者--诊断")
@Controller
@RequestMapping("/opbrzd")
public class OpBrzdCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(OpBrzdCtr.class);

    @Autowired
    private OpBrzdSer opBrzdSer;

    /** 查询集合 */
    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperation(value="查询诊断信息列表" ,httpMethod="POST")
    public ReturnEntity<List<OpBrzdResp>> getByEntity(OpBrzdReq req){//@RequestBody
        return ReturnEntityUtil.success(opBrzdSer.customQuery(req, getUser()));
    }


    /** 删除 */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value="删除" ,httpMethod="POST")
    public ReturnEntity delete(@ApiParam(name = "jlbh", value = "记录编号", required = true) @RequestParam Integer jlbh) {
        opBrzdSer.removeById(jlbh);
        return ReturnEntityUtil.success();
    }

    /** 保存 */
    @RequestMapping("/save")
    @ResponseBody
    @ApiOperation(value="保存" ,httpMethod="POST")
    public ReturnEntity add(@RequestBody OpBrzdSaveReq req) {
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
        opBrzdSer.save(req, getUser());
        return ReturnEntityUtil.success();
    }

    /** 查询病人诊断信息(sqdManageService.queryMSBRZD) */
    @RequestMapping("/queryMsbrzd")
    @ResponseBody
    @ApiOperation(value="查询诊断信息列表" ,httpMethod="POST")
    public ReturnEntity<OpBrzdQueryResp> queryMsbrzd(OpBrzdQueryReq req){//@RequestBody
        return ReturnEntityUtil.success(opBrzdSer.queryMsbrzd(req));
    }

}

