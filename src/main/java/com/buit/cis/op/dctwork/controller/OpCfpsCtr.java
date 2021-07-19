
package com.buit.cis.op.dctwork.controller;


import com.buit.cis.op.dctwork.request.OpCfpsReq;
import com.buit.cis.op.dctwork.response.OpCfpsResp;
import com.buit.cis.op.dctwork.service.OpYjcf01Ser;
import com.buit.cis.op.dctwork.service.OpYjcf02Ser;
import com.buit.commons.PageQuery;
import com.buit.commons.model.OpCfps;
import com.buit.commons.serviceImpl.OpGhmxServiceImpl;
import com.buit.op.model.OpYjcf01;
import com.buit.op.model.OpYjcf02;
import com.buit.utill.BeanUtil;
import com.buit.utill.ParamUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.buit.commons.BaseSpringController;
import com.buit.cis.op.dctwork.service.OpCfpsSer;

import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 处方皮试<br>
 * @author 朱智
 */
@Api(tags="处方皮试")
@Controller
@RequestMapping("/opcfps")
public class OpCfpsCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(OpCfpsCtr.class);
    
    @Autowired
    private OpCfpsSer opCfpsSer;
    @Autowired
    private OpYjcf01Ser opYjcf01Ser;
    @Autowired
    private OpYjcf02Ser opYjcf02Ser;
//
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<OpCfpsResp>> queryPage(OpCfpsReq opcfps, PageQuery page){
//        PageInfo<OpCfps> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> opCfpsSer.findByEntity(opcfps)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }

    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperation(value="根据处方识别查询处方皮试" ,httpMethod="POST")
    public ReturnEntity<List<OpCfpsResp>> getByEntity(@ApiParam(name = "cfsb", value = "处方识别", required = true) @RequestParam Integer cfsb){//@RequestBody
        List<OpYjcf01> yj01List = opYjcf01Ser.findByEntity(ParamUtil.instance().put("cfsb", cfsb));
        if(yj01List != null && yj01List.size() >0){
            List<OpYjcf02> list = opYjcf02Ser.findByEntity(ParamUtil.instance().put("yjxh", yj01List.get(0).getYjxh()));
            return ReturnEntityUtil.success(BeanUtil.toBeans(list, OpCfpsResp.class));
        }

        return ReturnEntityUtil.success();
    }

//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<OpCfpsResp> getOneByEntity(OpCfpsReq opcfps){
//        List<OpCfps> list=opCfpsSer.findByEntity(opcfps);
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
//    public ReturnEntity<OpCfpsResp> add(OpCfpsReq opCfps) {
//        opCfpsSer.insert(opCfps);        
//        return ReturnEntityUtil.success(opCfps);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<OpCfpsResp> edit(OpCfpsReq opCfps)  {
//        opCfpsSer.update(opCfps);        
//        return ReturnEntityUtil.success(opCfps);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<OpCfpsResp> delete(OpCfpsReq opCfps) {
//        opCfpsSer.removeByEntity(opCfps);        
//        return ReturnEntityUtil.success(opCfps);            
//    }
    
}

