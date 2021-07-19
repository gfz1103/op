
package com.buit.cis.op.dctwork.controller;

import cn.hutool.json.JSONUtil;
import com.buit.cis.op.dctwork.request.MpEasemobUserAddReq;
import com.buit.cis.op.dctwork.request.MpEasemobUserReq;
import com.buit.cis.op.dctwork.response.MpEasemobUserResp;
import com.buit.cis.op.dctwork.service.MpEasemobUserSer;
import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
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
 * 环信用户表（客服使用）<br>
 * @author 韦靖
 */
@Api(tags="环信用户表（客服使用）")
@Controller
@RequestMapping("/mpeasemobuser")
public class MpEasemobUserCtr extends BaseSpringController{

    static final Logger logger = LoggerFactory.getLogger(MpEasemobUserCtr.class);

    @Autowired
    private MpEasemobUserSer mpEasemobUserSer;

    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<MpEasemobUserResp>> queryPage(MpEasemobUserReq req, PageQuery page){
        logger.info("req:{},page:{}", JSONUtil.toJsonStr(req),JSONUtil.toJsonStr(page));
        PageInfo<MpEasemobUserResp> pageInfo = PageHelper.startPage(
            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                    () -> mpEasemobUserSer.queryEasemobUser(req)
            );
        return ReturnEntityUtil.success(pageInfo);
    }
//
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<IhEasemobUserResp>> getByEntity( IhEasemobUserReq iheasemobuser){//@RequestBody
//        return ReturnEntityUtil.success(ihEasemobUserSer.findByEntity(iheasemobuser));
//    }
//
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<IhEasemobUserResp> getOneByEntity(IhEasemobUserReq iheasemobuser){
//        List<IhEasemobUser> list=ihEasemobUserSer.findByEntity(iheasemobuser);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));
//        }
//        return ReturnEntityUtil.success();
//    }
//
    /** 新增 */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value="新增环信账户信息" ,httpMethod="POST")
    public ReturnEntity add(@Valid MpEasemobUserAddReq addReq) {
        mpEasemobUserSer.insertEasemobUser(addReq,getUser());
        return ReturnEntityUtil.success();
    }

    /** 禁用与解禁 */
    @RequestMapping("/disableOrLift")
    @ResponseBody
    @ApiOperation(value="禁用与解禁" ,httpMethod="POST")
    public ReturnEntity disableOrLift(@ApiParam(name = "id", value = "账号ID", required = true) @RequestParam(value = "id") Long id,
                                      @ApiParam(name = "activated", value = "禁用与解禁(1禁用 2解禁)", required = true) @RequestParam(value = "activated") String activated) {
        mpEasemobUserSer.disableOrLift(id,activated,getUser());
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/getEasemobUser")
    @ResponseBody
    @ApiOperation(value="返回登录环信账号信息" ,httpMethod="POST")
    public ReturnEntity<MpEasemobUserResp> getEasemobUser() {
        return ReturnEntityUtil.success(mpEasemobUserSer.getEasemobUser(getUser()));
    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<IhEasemobUserResp> edit(IhEasemobUserReq ihEasemobUser)  {
//        ihEasemobUserSer.update(ihEasemobUser);
//        return ReturnEntityUtil.success(ihEasemobUser);
//    }
//
    /** 删除 */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value="删除环信账号" ,httpMethod="POST")
    public ReturnEntity delete(@ApiParam(name = "id", value = "账号ID", required = true) @RequestParam(value = "id") Long id) {
        mpEasemobUserSer.deleteEasemob(id,getUser());
        return ReturnEntityUtil.success();
    }
}

