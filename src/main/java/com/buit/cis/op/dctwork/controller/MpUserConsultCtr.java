
package com.buit.cis.op.dctwork.controller;

import com.buit.cis.op.dctwork.request.WorkloadAccountForKFReq;
import com.buit.cis.op.dctwork.request.WorkloadAccountForYSReq;
import com.buit.cis.op.dctwork.response.WorkloadAccountForKFResp;
import com.buit.cis.op.dctwork.response.WorkloadAccountForYSResp;
import com.buit.cis.op.dctwork.service.MpUserConsultSer;
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

/**
 * 用户咨询表（客服使用）<br>
 * @author 韦靖
 */
@Api(tags="用户咨询表（客服使用）")
@Controller
@RequestMapping("/mpuserconsult")
public class MpUserConsultCtr extends BaseSpringController{

    static final Logger logger = LoggerFactory.getLogger(MpUserConsultCtr.class);

    @Autowired
    private MpUserConsultSer mpUserConsultSer;


    /** /修改咨询状态(结束咨询) */
    @RequestMapping("/updateConsultZt")
    @ResponseBody
    @ApiOperation(value="修改咨询状态(结束咨询)" ,httpMethod="POST")
    public ReturnEntity updateConsultZt(@ApiParam(name = "id", value = "咨询的ID", required = true) @RequestParam(value = "id") Integer id,
                                        @ApiParam(name = "zxzt", value = "咨询状态（2结束咨询）", required = true) @RequestParam(value = "zxzt") Integer zxzt)  {
        mpUserConsultSer.updateConsultZt(id, zxzt);
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/workloadAccountForKF")
    @ResponseBody
    @ApiOperation(value="客服工作量统计" ,httpMethod="POST")
    public ReturnEntity<PageInfo<WorkloadAccountForKFResp>> workloadAccountForKF(WorkloadAccountForKFReq req, PageQuery page){
        PageInfo<WorkloadAccountForKFResp> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> mpUserConsultSer.workloadAccountForKF(req)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/workloadAccountForYS")
    @ResponseBody
    @ApiOperation(value="医生工作量统计" ,httpMethod="POST")
    public ReturnEntity<PageInfo<WorkloadAccountForYSResp>> workloadAccountForYS(WorkloadAccountForYSReq req){
        req.setJgid(getUser().getHospitalId());
        PageInfo<WorkloadAccountForYSResp> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> mpUserConsultSer.workloadAccountForYS(req)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<IhUserConsultResp>> queryPage(IhUserConsultReq ihuserconsult,PageQuery page){
//        PageInfo<IhUserConsult> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> ihUserConsultSer.findByEntity(ihuserconsult)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<IhUserConsultResp>> getByEntity( IhUserConsultReq ihuserconsult){//@RequestBody
//        return ReturnEntityUtil.success(ihUserConsultSer.findByEntity(ihuserconsult));
//    }
//
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<IhUserConsultResp> getOneByEntity(IhUserConsultReq ihuserconsult){
//        List<IhUserConsult> list=ihUserConsultSer.findByEntity(ihuserconsult);
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
//    public ReturnEntity<IhUserConsultResp> add(IhUserConsultReq ihUserConsult) {
//        ihUserConsultSer.insert(ihUserConsult);
//        return ReturnEntityUtil.success(ihUserConsult);
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<IhUserConsultResp> edit(IhUserConsultReq ihUserConsult)  {
//        ihUserConsultSer.update(ihUserConsult);
//        return ReturnEntityUtil.success(ihUserConsult);
//    }
//
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<IhUserConsultResp> delete(IhUserConsultReq ihUserConsult) {
//        ihUserConsultSer.removeByEntity(ihUserConsult);
//        return ReturnEntityUtil.success(ihUserConsult);
//    }

}

