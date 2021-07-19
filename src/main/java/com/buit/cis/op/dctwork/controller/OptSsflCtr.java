
package com.buit.cis.op.dctwork.controller;

import cn.hutool.core.util.StrUtil;
import com.buit.cis.op.dctwork.response.FeeYlsfxmResp;
import com.buit.cis.op.dctwork.service.OptSsflSer;
import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.commons.request.OptSsflAddReq;
import com.buit.commons.request.OptSsflReq;
import com.buit.commons.response.OptSsflResp;
import com.buit.system.model.FeeYlsfxmModel;
import com.buit.system.request.IFeeYlsfxmReq;
import com.buit.system.response.IFeeYlsfxm;
import com.buit.system.service.FeeYlsfxmOutSer;
import com.buit.system.utill.ObjectToTypes;
import com.buit.utill.BeanUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <br>
 * @author 老花生
 */
@Api(tags="手术信息维护")
@Controller
@RequestMapping("/optssfl")
public class OptSsflCtr extends BaseSpringController {
    
    static final Logger logger = LoggerFactory.getLogger(OptSsflCtr.class);
    
    @Autowired
    private OptSsflSer optSsflSer;
    @DubboReference
    private FeeYlsfxmOutSer feeYlsfxmOutSer;

    @RequestMapping("/allInfo")
    @ResponseBody
    @ApiOperation(value="查询全部手术信息" ,httpMethod="POST")
    public ReturnEntity<PageInfo<FeeYlsfxmResp>> allInfo(IFeeYlsfxmReq req){
        req.setZfpb(0);
        PageInfo<FeeYlsfxmModel> pageInfo = feeYlsfxmOutSer.findPageByEntity(req);
        PageInfo<FeeYlsfxmResp> ret = BeanUtil.toPage(pageInfo, FeeYlsfxmResp.class);
        for(FeeYlsfxmResp feeYlsfxmResp : ret.getList()) {
        	feeYlsfxmResp.setSsnm(feeYlsfxmResp.getFyxh());
        }
        return ReturnEntityUtil.success(ret);
    }

    @RequestMapping("/allInfoNoUser")
    @ResponseBody
    @ApiOperation(value="查询全部手术信息刨除用户选择" ,httpMethod="POST")
    public ReturnEntity<PageInfo<FeeYlsfxmResp>> allInfoNoUser(IFeeYlsfxmReq req){
        PageInfo<IFeeYlsfxm> pageInfo = feeYlsfxmOutSer.allInfoNoUser(req);
        PageInfo<FeeYlsfxmResp> ret = BeanUtil.toPage(pageInfo, FeeYlsfxmResp.class);
        return ReturnEntityUtil.success(ret);
    }
    
    @RequestMapping("/userInfo")
    @ResponseBody
    @ApiOperation(value="医生(科室)手术信息" ,httpMethod="POST")
    public ReturnEntity<PageInfo<OptSsflResp>> userInfo(OptSsflReq req){
    	if(StrUtil.isBlank(ObjectToTypes.parseString(req.getKsdm()))) {
    		req.setYsdm(String.valueOf(getUser().getUserId()));
    	}

        PageInfo<OptSsflResp> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                    () -> optSsflSer.getEntityMapper().queryByReq(req)
            );
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/hospitalInfo")
    @ResponseBody
    @ApiOperation(value="全院手术信息" ,httpMethod="POST")
    public ReturnEntity<PageInfo<OptSsflResp>> hospitalInfo(PageQuery page){
        OptSsflReq req = new OptSsflReq();
        req.setIsHospital(1);
        PageInfo<OptSsflResp> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> optSsflSer.getEntityMapper().queryByReq(req)
        );
        return ReturnEntityUtil.success(pageInfo);
    }


    /** 新增 */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value="新增医生手术" ,httpMethod="POST")
    public ReturnEntity add(OptSsflAddReq req) {
    	if(StrUtil.isBlank(ObjectToTypes.parseString(req.getKsdm()))) {
    		req.setYsdm(String.valueOf(getUser().getUserId()));
    	}
        optSsflSer.add(req);
        return ReturnEntityUtil.success();
    }

    /** 删除 */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value="删除医生手术" ,httpMethod="POST")
    public ReturnEntity delete(@ApiParam(name = "id", value = "主键", required = true) @RequestParam Integer id) {
        optSsflSer.removeById(id);
        return ReturnEntityUtil.success();
    }

//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<OptSsflResp>> getByEntity( OptSsflReq optssfl){//@RequestBody 
//        return ReturnEntityUtil.success(optSsflSer.findByEntity(optssfl));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<OptSsflResp> getOneByEntity(OptSsflReq optssfl){
//        List<OptSsfl> list=optSsflSer.findByEntity(optssfl);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));    
//        }
//        return ReturnEntityUtil.success();
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<OptSsflResp> edit(OptSsflReq optSsfl)  {
//        optSsflSer.update(optSsfl);        
//        return ReturnEntityUtil.success(optSsfl);            
//    }
//    

    
}

