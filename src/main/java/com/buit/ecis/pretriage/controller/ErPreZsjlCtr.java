
package com.buit.ecis.pretriage.controller;


import com.buit.commons.BaseSpringController;
import com.buit.ecis.pretriage.model.ErPreZsjl;
import com.buit.ecis.pretriage.request.ErPreZsjlAddReq;
import com.buit.ecis.pretriage.request.ErPreZsjlCheckReq;
import com.buit.ecis.pretriage.request.ErPreZsjlEditReq;
import com.buit.ecis.pretriage.response.ErPreZsjlResp;
import com.buit.ecis.pretriage.service.ErPreZsjlSer;
import com.buit.utill.*;
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
import java.util.List;

/**
 * 主诉记录<br>
 * @author 朱智
 */
@Api(tags="主诉记录")
@Controller
@RequestMapping("/erprezsjl")
public class ErPreZsjlCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(ErPreZsjlCtr.class);
    
    @Autowired
    private ErPreZsjlSer erPreZsjlSer;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<ErPreZsjlResp>> queryPage(ErPreZsjlReq erprezsjl,PageQuery page){
//        PageInfo<ErPreZsjl> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> erPreZsjlSer.findByEntity(erprezsjl)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }

    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperation(value="查询列表" ,httpMethod="POST")
    public ReturnEntity<List<ErPreZsjlResp>> getByEntity(
            @ApiParam(name = "zslbid", value = "主诉类别ID", required = true) @RequestParam Integer zslbid){
        ErPreZsjl zsjl = new ErPreZsjl();
        zsjl.setZslbid(zslbid);
        List<ErPreZsjl> ret = erPreZsjlSer.findByEntity(zsjl);
        return ReturnEntityUtil.success(BeanUtil.toBeans(ret, ErPreZsjlResp.class));
    }

    @RequestMapping("/findListByZsms")
    @ResponseBody
    @ApiOperation(value="根据主诉查询列表" ,httpMethod="POST")
    public ReturnEntity<List<ErPreZsjlResp>> getByEntityByZsms(
            @ApiParam(name = "zsms", value = "主诉描述") @RequestParam(value = "zsms", required = false) String zsms){
        ErPreZsjl zsjl = new ErPreZsjl();
        zsjl.setZsms(zsms);
        List<ErPreZsjl> ret = erPreZsjlSer.findByEntity(zsjl);
        return ReturnEntityUtil.success(BeanUtil.toBeans(ret, ErPreZsjlResp.class));
    }

    /** 保存校验 */
    @RequestMapping("/saveCheck")
    @ResponseBody
    @ApiOperation(value="保存校验" ,httpMethod="POST")
    public ReturnEntity<Boolean> saveCheck(@Valid ErPreZsjlCheckReq req) {
        List<ErPreZsjl> list = erPreZsjlSer.findByEntity(req);
        if(list == null && list.size() > 1){
            return ReturnEntityUtil.success(false);
        }
        return ReturnEntityUtil.success(true);
    }

    /** 新增 */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value="新增" ,httpMethod="POST")
    public ReturnEntity<ErPreZsjlResp> add(@Valid ErPreZsjlAddReq req) {
        req.setJgid(getUser().getHospitalId());
        erPreZsjlSer.add(req);
        return ReturnEntityUtil.success();
    }

    /** 编辑 */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperation(value="编辑" ,httpMethod="POST")
    public ReturnEntity<ErPreZsjlResp> edit(@Autowired ErPreZsjlEditReq req)  {
        req.setPym(PinyinUtils.getSimplePinYin(req.getZsms()));
        req.setWbm(WubiUtils.getSimpleWuBi(req.getZsms()));
        erPreZsjlSer.update(req);
        return ReturnEntityUtil.success();
    }


    /** 删除 */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value="删除" ,httpMethod="POST")
    public ReturnEntity<ErPreZsjlResp> delete(
            @ApiParam(name = "zsmsid", value = "主诉描述ID", required = true) @RequestParam Integer zsmsid) {
        erPreZsjlSer.removeById(zsmsid);
        return ReturnEntityUtil.success();
    }
    //    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<ErPreZsjlResp> getOneByEntity(ErPreZsjlReq erprezsjl){
//        List<ErPreZsjl> list=erPreZsjlSer.findByEntity(erprezsjl);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));    
//        }
//        return ReturnEntityUtil.success();
//    }

    
}

