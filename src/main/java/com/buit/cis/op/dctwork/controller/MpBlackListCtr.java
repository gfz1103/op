
package com.buit.cis.op.dctwork.controller;


import cn.hutool.core.date.DateUtil;
import com.buit.cis.op.dctwork.service.MpBlackListSer;
import com.buit.commons.PageQuery;
import com.buit.commons.model.MpBlackList;
import com.buit.commons.request.MpBlackListReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.buit.commons.BaseSpringController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 黑名单表<br>
 * @author DESKTOP-1OEG1QM
 */
@Api(tags="互联网医院黑名单")
@Controller
@RequestMapping("/mpblacklist")
public class MpBlackListCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(MpBlackListCtr.class);
    
    @Autowired
    private MpBlackListSer mpBlackListSer;
    
    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<MpBlackList>> queryPage(MpBlackListReq mpblacklist, PageQuery page){
        PageInfo<MpBlackList> pageInfo = PageHelper.startPage(
            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                    () -> mpBlackListSer.findByEntity(mpblacklist)
            );
        return ReturnEntityUtil.success(pageInfo);
    }

//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<MpBlackListResp>> getByEntity( MpBlackListReq mpblacklist){//@RequestBody 
//        return ReturnEntityUtil.success(mpBlackListSer.findByEntity(mpblacklist));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<MpBlackListResp> getOneByEntity(MpBlackListReq mpblacklist){
//        List<MpBlackList> list=mpBlackListSer.findByEntity(mpblacklist);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));    
//        }
//        return ReturnEntityUtil.success();
//    }
//    
    /** 新增 */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value="新增" ,httpMethod="POST")
    public ReturnEntity<?> add(MpBlackListReq mpBlackList) {
        mpBlackList.setCjsj(DateUtil.date().toTimestamp());
        mpBlackList.setXgsj(mpBlackList.getCjsj());
        mpBlackListSer.insert(mpBlackList);
        return ReturnEntityUtil.success();
    }
    /** 编辑 */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperation(value="编辑" ,httpMethod="POST")
    public ReturnEntity<?> edit(MpBlackListReq mpBlackList)  {
        mpBlackList.setXgsj(DateUtil.date().toTimestamp());
        mpBlackListSer.update(mpBlackList);
        return ReturnEntityUtil.success();
    }

//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<MpBlackListResp> delete(MpBlackListReq mpBlackList) {
//        mpBlackListSer.removeByEntity(mpBlackList);        
//        return ReturnEntityUtil.success(mpBlackList);            
//    }
    
}

