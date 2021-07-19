
package com.buit.cis.op.dctwork.controller;


import com.buit.cis.op.dctwork.service.MpGlksSer;
import com.buit.commons.dao.OpGhksDao;
import com.buit.commons.model.MpGlks;
import com.buit.commons.model.OpGhks;
import com.buit.commons.request.MpGlksReq;
import com.buit.commons.response.MpGlksResp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.buit.commons.BaseSpringController;

import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 互联网科室HIS挂号科室关联表<br>
 * @author DESKTOP-1OEG1QM
 */
@Api(tags="互联网科室HIS挂号科室关联表")
@Controller
@RequestMapping("/mpglks")
public class MpGlksCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(MpGlksCtr.class);
    
    @Autowired
    private MpGlksSer mpGlksSer;
    @Autowired
    private OpGhksDao opGhksDao;
    
    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<MpGlksResp>> queryPage(MpGlksReq mpglks){
        mpglks.setJgid(getUser().getHospitalId());
        PageInfo<MpGlksResp> pageInfo = PageHelper.startPage(
                mpglks.getPageNum(), mpglks.getPageSize()).doSelectPageInfo(
                    () -> mpGlksSer.getEntityMapper().getList(mpglks)
            );
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    @ApiOperation(value="保存或者更新" ,httpMethod="POST")
    public ReturnEntity<?> saveOrUpdate(MpGlks mpGlks)  {
        mpGlksSer.saveOrUpdate(mpGlks);
        return ReturnEntityUtil.success();
    }

//    @RequestMapping("/getNotInternetGhks")
//    @ResponseBody
//    @ApiOperation(value="获取非互联网线下科室列表" ,httpMethod="POST")
//    public ReturnEntity<List<OpGhks>> getNotInternetGhks(@ApiParam(name = "keyword", value = "关键字模糊搜索(拼音码或者名称)", required = false)
//                                                             @RequestParam(required = false) String keyword){
//        return ReturnEntityUtil.success(opGhksDao.getInternetGhks(getUser().getHospitalId(), keyword, 0));
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<MpGlksResp> getOneByEntity(MpGlksReq mpglks){
//        List<MpGlks> list=mpGlksSer.findByEntity(mpglks);
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
//    public ReturnEntity<MpGlksResp> add(MpGlksReq mpGlks) {
//        mpGlksSer.insert(mpGlks);        
//        return ReturnEntityUtil.success(mpGlks);            
//    }

//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<MpGlksResp> delete(MpGlksReq mpGlks) {
//        mpGlksSer.removeByEntity(mpGlks);        
//        return ReturnEntityUtil.success(mpGlks);            
//    }
    
}

