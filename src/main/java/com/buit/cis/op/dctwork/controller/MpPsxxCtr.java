
package com.buit.cis.op.dctwork.controller;


import com.buit.cis.op.dctwork.service.MpPsxxSer;
import com.buit.commons.model.MpPsxx;
import com.buit.commons.request.MpPsxxReq;
import com.buit.commons.response.MpPsxxResp;
import com.buit.utill.DateUtil;
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


/**
 * 互联网医院配送信息表<br>
 * @author DESKTOP-1OEG1QM
 */
@Api(tags="互联网医院配送信息表")
@Controller
@RequestMapping("/mpipsxx")
public class MpPsxxCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(MpPsxxCtr.class);
    
    @Autowired
    private MpPsxxSer mpPsxxSer;
    
    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<MpPsxxResp>> queryPage(MpPsxxReq mpPsxxReq){
        mpPsxxReq.setJgid(getUser().getHospitalId().toString());
        PageInfo<MpPsxxResp> pageInfo = PageHelper.startPage(
                mpPsxxReq.getPageNum(), mpPsxxReq.getPageSize()).doSelectPageInfo(
                    () -> mpPsxxSer.getEntityMapper().getList(mpPsxxReq)
            );
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/getById")
    @ResponseBody
    @ApiOperation(value="查看详情" ,httpMethod="POST")
    public ReturnEntity<MpPsxx> getOneByEntity(@ApiParam(name = "id", value = "主键ID", required = true) @RequestParam Integer id){
        MpPsxx mpPsxx= mpPsxxSer.getById(id);
        return ReturnEntityUtil.success(mpPsxx);
    }

    /** 编辑 */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperation(value="编辑" ,httpMethod="POST")
    public ReturnEntity<?> edit(MpPsxxReq mpPsxxReq)  {
        mpPsxxReq.setXgsj(DateUtil.getCurrentTimestamp());
        mpPsxxSer.update(mpPsxxReq);
        return ReturnEntityUtil.success();
    }


//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<MpiPsxxResp>> getByEntity( MpiPsxxReq mpipsxx){//@RequestBody
//        return ReturnEntityUtil.success(mpiPsxxSer.findByEntity(mpipsxx));
//    }
//
//    
//    /** 新增 */
//    @RequestMapping("/add")
//    @ResponseBody
//    @ApiOperation(value="新增" ,httpMethod="POST")
//    public ReturnEntity<MpiPsxxResp> add(MpiPsxxReq mpiPsxx) {
//        mpiPsxxSer.insert(mpiPsxx);        
//        return ReturnEntityUtil.success(mpiPsxx);            
//    }

//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<MpiPsxxResp> delete(MpiPsxxReq mpiPsxx) {
//        mpiPsxxSer.removeByEntity(mpiPsxx);        
//        return ReturnEntityUtil.success(mpiPsxx);            
//    }
    
}

