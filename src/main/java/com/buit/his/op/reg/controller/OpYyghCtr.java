
package com.buit.his.op.reg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.request.OpYyghQueryReq;
import com.buit.commons.response.OpYyghQueryResp;
import com.buit.his.op.reg.service.OpYyghSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 门诊_预约挂号<br>
 * @author WY
 */
@Api(tags="预约挂号")
@Controller
@RequestMapping("/opyygh")
public class OpYyghCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(OpYyghCtr.class);
    
    @Autowired
    private OpYyghSer opYyghSer;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<OpYyghResp>> queryPage(OpYyghReq opyygh,PageQuery page){
//        PageInfo<OpYygh> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> opYyghSer.findByEntity(opyygh)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }

    /** 预约查询(appointmentManageService.loadAppointedInfo)
     * @return*/
    @RequestMapping("/loadAppointedInfo")
    @ResponseBody
    @ApiOperation(value="预约查询" ,httpMethod="POST")
    public ReturnEntity<List<OpYyghQueryResp>> loadAppointedInfo(OpYyghQueryReq opyygh){//@RequestBody
        return ReturnEntityUtil.success(opYyghSer.loadAppointedInfo(opyygh));
    }

//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<OpYyghResp> getOneByEntity(OpYyghReq opyygh){
//        List<OpYygh> list=opYyghSer.findByEntity(opyygh);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));    
//        }
//        return ReturnEntityUtil.success();
//    }
//    
//    /** 新增 */
//    @RequestMapping("/add")
//    @ResponseBody
//    @ApiOperation(value="新增" ,httpMethod="POST")
//    public ReturnEntity<OpYyghResp> add(OpYyghReq opYygh) {
//        opYyghSer.insert(opYygh);        
//        return ReturnEntityUtil.success(opYygh);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<OpYyghResp> edit(OpYyghReq opYygh)  {
//        opYyghSer.update(opYygh);        
//        return ReturnEntityUtil.success(opYygh);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<OpYyghResp> delete(OpYyghReq opYygh) {
//        opYyghSer.removeByEntity(opYygh);        
//        return ReturnEntityUtil.success(opYygh);            
//    }
    
}

