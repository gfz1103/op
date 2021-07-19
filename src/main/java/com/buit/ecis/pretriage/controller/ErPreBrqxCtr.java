
package com.buit.ecis.pretriage.controller;


import com.buit.commons.BaseSpringController;
import com.buit.ecis.pretriage.model.ErPreBrqx;
import com.buit.ecis.pretriage.request.ErPreBrqxAddReq;
import com.buit.ecis.pretriage.request.ErPreBrqxEditReq;
import com.buit.ecis.pretriage.response.ErPreBrqxResp;
import com.buit.ecis.pretriage.service.ErPreBrqxSer;
import com.buit.utill.BeanUtil;
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

import javax.validation.Valid;
import java.util.List;

/**
 * 病人去向<br>
 * @author 朱智
 */
@Api(tags="病人去向")
@Controller
@RequestMapping("/erprebrqx")
public class ErPreBrqxCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(ErPreBrqxCtr.class);
    
    @Autowired
    private ErPreBrqxSer erPreBrqxSer;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<ErPreBrqxResp>> queryPage(ErPreBrqxReq erprebrqx,PageQuery page){
//        PageInfo<ErPreBrqx> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> erPreBrqxSer.findByEntity(erprebrqx)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }

    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperation(value="查询列表" ,httpMethod="POST")
    public ReturnEntity<List<ErPreBrqxResp>> getByEntity( ){//@RequestBody
        List<ErPreBrqx> ret = erPreBrqxSer.findByEntity(new ErPreBrqx());
        return ReturnEntityUtil.success(BeanUtil.toBeans(ret, ErPreBrqxResp.class));
    }

//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<ErPreBrqxResp> getOneByEntity(ErPreBrqxReq erprebrqx){
//        List<ErPreBrqx> list=erPreBrqxSer.findByEntity(erprebrqx);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));    
//        }
//        return ReturnEntityUtil.success();
//    }

    /** 新增 */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value="新增" ,httpMethod="POST")
    public ReturnEntity<ErPreBrqxResp> add(@Valid ErPreBrqxAddReq erPreBrqx) {
        erPreBrqx.setJgid(getUser().getHospitalId());
        erPreBrqxSer.add(erPreBrqx);
        return ReturnEntityUtil.success();
    }

    /** 编辑 */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperation(value="编辑" ,httpMethod="POST")
    public ReturnEntity<ErPreBrqxResp> edit(@Valid ErPreBrqxEditReq erPreBrqx)  {
        erPreBrqxSer.update(erPreBrqx);
        return ReturnEntityUtil.success();
    }

    /** 删除 */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value="删除" ,httpMethod="POST")
    public ReturnEntity<ErPreBrqxResp> delete(
            @ApiParam(name = "qxid", value = "去向ID", required = true) @RequestParam Integer qxid) {
        erPreBrqxSer.removeById(qxid);
        return ReturnEntityUtil.success();
    }
    
}

