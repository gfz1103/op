
package com.buit.cis.op.dctwork.controller;


import com.buit.cis.op.dctwork.request.OpBqzmPageReq;
import com.buit.cis.op.dctwork.response.BqzmPrintResponse;
import com.buit.cis.op.dctwork.response.OpBqzmPageResp;
import com.buit.cis.op.dctwork.service.OpBqzmSer;
import com.buit.commons.BaseSpringController;
import com.buit.commons.request.OpBqzmSaveReq;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 病情证明<br>
 * @author 老花生
 */
@Api(tags="病情证明")
@Controller
@RequestMapping("/opbqzm")
public class OpBqzmCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(OpBqzmCtr.class);

    @Autowired
    private OpBqzmSer opBqzmSer;

    /** 查询病情证明单列表(DiseaseProofModel.getDiseaseProofList) */
    @RequestMapping("/getDiseaseProofList")
    @ResponseBody
    @ApiOperation(value="查询病情证明单列表" ,httpMethod="POST")
    public ReturnEntity<PageInfo<OpBqzmPageResp>> getDiseaseProofList(@Valid OpBqzmPageReq req){
        PageInfo<OpBqzmPageResp> pageInfo = opBqzmSer.getDiseaseProofList(req, getUser());
        return ReturnEntityUtil.success(pageInfo);
    }


    /** 新增病情证明单(diseaseProofService.saveDiseaseProof) */
    @RequestMapping("/saveDiseaseProof")
    @ResponseBody
    @ApiOperation(value="新增病情证明单(更新病情证明单)" ,httpMethod="POST")
    public ReturnEntity<Integer> saveDiseaseProof(@Valid OpBqzmSaveReq req) {
        return ReturnEntityUtil.success(opBqzmSer.save(req, getUser()));
    }


    /** 根据ID删除 */
    @RequestMapping("/deleteByBqid")
    @ResponseBody
    @ApiOperation(value="根据ID删除" ,httpMethod="POST")
    public ReturnEntity<OpBqzmResp> delete(@ApiParam(name = "bqid", value = "病情证明单ID", required = true) @RequestParam(value = "bqid") Integer bqid) {
        opBqzmSer.removeById(bqid);
        return ReturnEntityUtil.success();
    }


    /** 打印（DiseaseProofForm_MZ--DiseaseProofFormFile） */
    @RequestMapping("/bqzmdPrint")
    @ResponseBody
    @ApiOperation(value="病情证明单打印" ,httpMethod="POST")
    public ReturnEntity<String> bqzmdPrint(@ApiParam(name = "pkey", value = "id", required = true) @RequestParam(value = "pkey") Integer pkey,
                                               @ApiParam(name = "lx", value = "类型", required = true) @RequestParam(value = "lx") Integer lx) {
        return ReturnEntityUtil.success(opBqzmSer.bqzmdPrint(pkey,lx,getUser().getHospitalId()));
    }

    /**
     * 查询病情证明单打印数据
     * @param bqid
     * @return
     */
    @RequestMapping("/getBqzmPrintData")
    @ResponseBody
    @ApiOperation(value="病情证明单打印数据" ,httpMethod="POST")
    public ReturnEntity<BqzmPrintResponse> getBqzmPrintData(@ApiParam(name = "bqid", value = "病情id(主键)", required = true) @RequestParam(value = "bqid") Integer bqid) {
        return ReturnEntityUtil.success(opBqzmSer.getBqzmPrintData(bqid));
    }

//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<OpBqzmResp>> getByEntity( OpBqzmReq opbqzm){//@RequestBody
//        return ReturnEntityUtil.success(opBqzmSer.findByEntity(opbqzm));
//    }
//
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<OpBqzmResp> getOneByEntity(OpBqzmReq opbqzm){
//        List<OpBqzm> list=opBqzmSer.findByEntity(opbqzm);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));
//        }
//        return ReturnEntityUtil.success();
//    }

//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<OpBqzmResp> edit(OpBqzmReq opBqzm)  {
//        opBqzmSer.update(opBqzm);
//        return ReturnEntityUtil.success(opBqzm);
//    }


}

