
package com.buit.ecis.pretriage.controller;


import com.buit.commons.BaseSpringController;
import com.buit.ecis.pretriage.request.ErPreZslbAddReq;
import com.buit.ecis.pretriage.response.ErPreZslbResp;
import com.buit.ecis.pretriage.service.ErPreZslbSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
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

import java.util.List;

/**
 * 主诉类别<br>
 * @author 朱智
 */
@Api(tags="主诉类别")
@Controller
@RequestMapping("/erprezslb")
public class ErPreZslbCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(ErPreZslbCtr.class);
    
    @Autowired
    private ErPreZslbSer erPreZslbSer;

    /** 新增 */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value="新增" ,httpMethod="POST")
    public ReturnEntity<ErPreZslbResp> add(ErPreZslbAddReq erPreZslb) {
        erPreZslb.setJgid(getUser().getHospitalId());
        erPreZslbSer.add(erPreZslb);
        return ReturnEntityUtil.success();
    }

    /** 删除 */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value="按条件查询" ,httpMethod="POST")
    public ReturnEntity<ErPreZslbResp> delete(
            @ApiParam(name = "zslbid", value = "主诉类别ID", required = true) @RequestParam Integer zslbid) {
        erPreZslbSer.delete(zslbid);
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperation(value="查询列表" ,httpMethod="POST")
    public ReturnEntity<List<ErPreZslbResp>> getByEntity(){//@RequestBody
        return ReturnEntityUtil.success(erPreZslbSer.getList());
    }

//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<ErPreZslbResp>> queryPage(ErPreZslbReq erprezslb,PageQuery page){
//        PageInfo<ErPreZslb> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> erPreZslbSer.findByEntity(erprezslb)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }

//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<ErPreZslbResp> getOneByEntity(ErPreZslbReq erprezslb){
//        List<ErPreZslb> list=erPreZslbSer.findByEntity(erprezslb);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));    
//        }
//        return ReturnEntityUtil.success();
//    }

//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<ErPreZslbResp> edit(ErPreZslbReq erPreZslb)  {
//        erPreZslbSer.update(erPreZslb);        
//        return ReturnEntityUtil.success(erPreZslb);            
//    }

    
}

