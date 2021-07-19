
package com.buit.ecis.pretriage.controller;


import com.buit.commons.BaseSpringController;
import com.buit.ecis.pretriage.request.ErPreYjfzAddReq;
import com.buit.ecis.pretriage.request.ErPreYjfzQueryReq;
import com.buit.ecis.pretriage.request.ErPreYjfzQxReq;
import com.buit.ecis.pretriage.response.ErPreYjfzResp;
import com.buit.ecis.pretriage.service.ErPreYjfzSer;
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
 * 急诊预检分诊<br>
 * @author 朱智
 */
@Api(tags="急诊预检分诊")
@Controller
@RequestMapping("/erpreyjfz")
public class ErPreYjfzCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(ErPreYjfzCtr.class);
    
    @Autowired
    private ErPreYjfzSer erPreYjfzSer;
    
    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<ErPreYjfzResp>> queryPage(ErPreYjfzQueryReq erpreyjfz){

        PageInfo<ErPreYjfzResp> ret = erPreYjfzSer.queryPage(erpreyjfz);

        return ReturnEntityUtil.success(ret);
    }

    /** 新增 */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value="新增" ,httpMethod="POST")
    public ReturnEntity<ErPreYjfzResp> add(@Valid @RequestBody ErPreYjfzAddReq erPreYjfz) {
        erPreYjfz.setJgid(getUser().getHospitalId());
        erPreYjfzSer.add(erPreYjfz);
        return ReturnEntityUtil.success();
    }

    /** 取消 */
    @RequestMapping("/cancel")
    @ResponseBody
    @ApiOperation(value="取消" ,httpMethod="POST")
    public ReturnEntity<ErPreYjfzResp> cancel(@ApiParam(name = "lsh", value = "急诊流水号", required = true) @RequestParam Integer lsh) {
        erPreYjfzSer.getEntityMapper().cancel(lsh);
        return ReturnEntityUtil.success();
    }

    /** 病人去向 */
    @RequestMapping("/patientWhereabouts")
    @ResponseBody
    @ApiOperation(value="病人去向" ,httpMethod="POST")
    public ReturnEntity<ErPreYjfzResp> patientWhereabouts(@Valid ErPreYjfzQxReq req) {
        erPreYjfzSer.getEntityMapper().patientWhereabouts(req);
        return ReturnEntityUtil.success();
    }

//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<ErPreYjfzResp>> getByEntity( ErPreYjfzReq erpreyjfz){//@RequestBody 
//        return ReturnEntityUtil.success(erPreYjfzSer.findByEntity(erpreyjfz));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<ErPreYjfzResp> getOneByEntity(ErPreYjfzReq erpreyjfz){
//        List<ErPreYjfz> list=erPreYjfzSer.findByEntity(erpreyjfz);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));    
//        }
//        return ReturnEntityUtil.success();
//    }

//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<ErPreYjfzResp> edit(ErPreYjfzReq erPreYjfz)  {
//        erPreYjfzSer.update(erPreYjfz);        
//        return ReturnEntityUtil.success(erPreYjfz);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<ErPreYjfzResp> delete(ErPreYjfzReq erPreYjfz) {
//        erPreYjfzSer.removeByEntity(erPreYjfz);        
//        return ReturnEntityUtil.success(erPreYjfz);            
//    }
    
}

