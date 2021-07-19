
package com.buit.cis.op.dctwork.controller;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.commons.response.PubCyzdResp;
import com.buit.system.request.DicZyjbCopyReq;
import com.buit.system.request.IPubCyzdReq;
import com.buit.system.request.IPubCyzdSaveReq;
import com.buit.system.response.DicJbbmModel;
import com.buit.system.response.DicZyjbCopyResp;
import com.buit.system.response.IPubCyzdResp;
import com.buit.system.service.DicJbbmService;
import com.buit.system.service.PubCyzdService;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 公用_个人常用诊断表<br>
 * @author 老花生
 */
@Api(tags="常用诊断维护")
@Controller
@RequestMapping("/pubcyzd")
public class PubCyzdCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(PubCyzdCtr.class);

    @DubboReference
    private DicJbbmService dicJbbmService;
    @DubboReference
    private PubCyzdService pubCyzdService;

    @RequestMapping("/xyPage")
    @ResponseBody
    @ApiOperation(value="西医疾病分页查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<DicJbbmModel>> xyPage(DicJbbmModel dicjbbm, PageQuery page){
        PageInfo<DicJbbmModel> pageInfo = dicJbbmService.findByEntity(dicjbbm);
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/zyPage")
    @ResponseBody
    @ApiOperation(value="中医疾病分页查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<DicZyjbCopyResp>> zyPage(DicZyjbCopyReq req){
        PageInfo<DicZyjbCopyResp> pageInfo = dicJbbmService.findZyjb(req);
        return ReturnEntityUtil.success(pageInfo);
    }


    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperation(value="查询个人收藏诊断" ,httpMethod="POST")
    public ReturnEntity<List<IPubCyzdResp>> getByEntity(@Valid IPubCyzdReq pubcyzd){//@RequestBody
        pubcyzd.setJgid(getUser().getHospitalId());
        pubcyzd.setYgdm(getUser().getUserId());
        return ReturnEntityUtil.success(pubCyzdService.query(pubcyzd));
    }



    @RequestMapping("/findPage")
    @ResponseBody
    @ApiOperation(value="查询个人收藏诊断-分页" ,httpMethod="POST")
    public ReturnEntity<PageInfo<IPubCyzdResp>> findPage(@Valid IPubCyzdReq pubcyzd){//@RequestBody
        pubcyzd.setJgid(getUser().getHospitalId());
        pubcyzd.setYgdm(getUser().getUserId());
        return ReturnEntityUtil.success(pubCyzdService.queryPage(pubcyzd));
    }

    /** 保存 */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value="新增个人收藏" ,httpMethod="POST")
    public ReturnEntity<PubCyzdResp> add(@Valid IPubCyzdSaveReq req) {
        req.setJgid(getUser().getHospitalId());
        req.setYgdm(getUser().getUserId());
        pubCyzdService.add(req);
        return ReturnEntityUtil.success();
    }

    /** 删除 */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value="删除个人收藏" ,httpMethod="POST")
    public ReturnEntity<PubCyzdResp> delete(@ApiParam(name = "jlbh", value = "序号", required = true) @RequestParam Integer jlbh) {
        pubCyzdService.removeById(jlbh);
        return ReturnEntityUtil.success();
    }
//
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<PubCyzdResp> getOneByEntity(PubCyzdReq pubcyzd){
//        List<PubCyzd> list=pubCyzdSer.findByEntity(pubcyzd);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));
//        }
//        return ReturnEntityUtil.success();
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<PubCyzdResp> edit(PubCyzdReq pubCyzd)  {
//        pubCyzdSer.update(pubCyzd);
//        return ReturnEntityUtil.success(pubCyzd);
//    }
//
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<PubCyzdResp> delete(PubCyzdReq pubCyzd) {
//        pubCyzdSer.removeByEntity(pubCyzd);
//        return ReturnEntityUtil.success(pubCyzd);
//    }

}

