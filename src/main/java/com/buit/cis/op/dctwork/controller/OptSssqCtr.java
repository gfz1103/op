
package com.buit.cis.op.dctwork.controller;


import com.buit.cis.op.dctwork.service.OptSssqSer;
import com.buit.commons.BaseSpringController;
import com.buit.commons.request.OptSssqPageReq;
import com.buit.commons.request.OptSssqSaveReq;
import com.buit.commons.response.OptSssqPageResp;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 手术申请<br>
 * @author 老花生
 */
@Api(tags="手术申请")
@Controller
@RequestMapping("/optsssq")
public class OptSssqCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(OptSssqCtr.class);

    @Autowired
    private OptSssqSer optSssqSer;


    /** 保存手术申请记录(surService.saveSssq) */
    @RequestMapping("/saveSssq")
    @ResponseBody
    @ApiOperation(value="保存手术申请记录" ,httpMethod="POST")
    public ReturnEntity saveSssq(@Valid @RequestBody OptSssqSaveReq optSssq) {
        return ReturnEntityUtil.success(optSssqSer.saveSssq(optSssq, getUser()));
    }

    /** 查询手术申请单列表数据(surService.querySurSssqList) */
    @RequestMapping("/querySurSssqList")
    @ResponseBody
    @ApiOperation(value="查询手术申请单列表数据" ,httpMethod="POST")
    public ReturnEntity<PageInfo<OptSssqPageResp>> querySurSssqList(OptSssqPageReq req){
        PageInfo<OptSssqPageResp> pageInfo = optSssqSer.querySurSssqList(req, getUser());
        return ReturnEntityUtil.success(pageInfo);
    }
//
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<OptSssqResp>> getByEntity( OptSssqReq optsssq){//@RequestBody
//        return ReturnEntityUtil.success(optSssqSer.findByEntity(optsssq));
//    }
//
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<OptSssqResp> getOneByEntity(OptSssqReq optsssq){
//        List<OptSssq> list=optSssqSer.findByEntity(optsssq);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));
//        }
//        return ReturnEntityUtil.success();
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<OptSssqResp> edit(OptSssqReq optSssq)  {
//        optSssqSer.update(optSssq);
//        return ReturnEntityUtil.success(optSssq);
//    }
//
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<OptSssqResp> delete(OptSssqReq optSssq) {
//        optSssqSer.removeByEntity(optSssq);
//        return ReturnEntityUtil.success(optSssq);
//    }

}

