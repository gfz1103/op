
package com.buit.cis.op.dctwork.controller;


import com.buit.apply.request.CisJcsq01PageReq;
import com.buit.apply.request.JcSqdReq;
import com.buit.apply.request.QueryAuxiliaryJcReportListReq;
import com.buit.apply.response.*;
import com.buit.apply.service.Cisjcsqd01Service;
import com.buit.cis.op.dctwork.request.ApiPacsReportReq;
import com.buit.cis.op.dctwork.service.ApiPacsReportSer;
import com.buit.commons.BaseSpringController;
import com.buit.commons.model.ApiPacsReport;
import com.buit.file.IReportExportFileSer;
import com.buit.op.response.ApiPacsReportResp;
import com.buit.utill.BeanUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 检查申请单<br>
 * @author 老花生
 */
@Api(tags="检查申请单")
@Controller
@RequestMapping("/cisjcsq01")
public class CisJcsq01Ctr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(CisJcsq01Ctr.class);

    @DubboReference
    private Cisjcsqd01Service cisJcsq01Ser;

    @Autowired
    private ApiPacsReportSer apiPacsReportSer;
    @Autowired
    private IReportExportFileSer iReportExportFileSer;

//    @Autowired
//    private DicZlxmSer dicZlxmSer;

    /** 查询检查申请申请单列表数据(sqdManageService.queryJxSqsList) */
    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperation(value="查询检查申请申请单列表数据" ,httpMethod="POST")
    public ReturnEntity<PageInfo<CisJcsq01PageResp>> queryPage(CisJcsq01PageReq cisjcsq01){
        PageInfo<CisJcsq01PageResp> pageInfo = cisJcsq01Ser.queryPage(cisjcsq01);
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperation(value="查询检查报告单列表数据" ,httpMethod="POST")
    public ReturnEntity<List<ApiPacsReportResp>> getByEntity(ApiPacsReportReq apipacsreport){//@RequestBody
        List<ApiPacsReport> ret = apiPacsReportSer.findByEntity(apipacsreport);
        return ReturnEntityUtil.success(BeanUtil.toBeans(ret, ApiPacsReportResp.class));
    }

    /** 保存门诊申请单(sqdManageService.saveMzSqd) */
    @RequestMapping("/saveMzjcSqd")
    @ResponseBody
    @ApiOperation(value="保存门诊检查申请单" ,httpMethod="POST")
    public ReturnEntity<JcSqdResp> saveMzJcSqd(@Valid @RequestBody JcSqdReq req){//@RequestBody
        JcSqdResp jcSqdResp = cisJcsq01Ser.saveMzSqd(req, getUser());
        return ReturnEntityUtil.success(jcSqdResp);
    }

    /** 病理检查申请打印数据 */
    @RequestMapping("/getBljcsqPrintData")
    @ResponseBody
    @ApiOperation(value="病理检查申请打印数据" ,httpMethod="POST")
    public ReturnEntity<BljcsqPrintResponse> getBljcsqPrintData(@ApiParam(name = "jcxh", value = "检查序号", required = true) @RequestParam(value = "jcxh") Integer jcxh){
        BljcsqPrintResponse printData = cisJcsq01Ser.getBljcsqPrintData(jcxh);
        return ReturnEntityUtil.success(printData);
    }

    /** 检查申请打印数据 */
    @RequestMapping("/getJcsqPrintData")
    @ResponseBody
    @ApiOperation(value="检查申请打印数据" ,httpMethod="POST")
    public ReturnEntity<JcsqdPrintResponse> getJcsqPrintData(@ApiParam(name = "jcxh", value = "检查序号", required = true) @RequestParam(value = "jcxh") Integer jcxh){
        JcsqdPrintResponse jcsqdPrintResponse = cisJcsq01Ser.getjcsqPrintData(jcxh);
        return ReturnEntityUtil.success(jcsqdPrintResponse);
    }

//    @RequestMapping("/queryZyJcSqdList")
//    @ResponseBody
//    @ApiOperation(value="住院检查申请单查询-分页" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<CisJcsq01Resp>> queryZyJcSqdList(CisJcsq01QueryReq cisJcsq01QueryReq, PageQuery page){
//    	cisJcsq01QueryReq.setSqlx(2);
//    	PageInfo<CisJcsq01Resp> pageInfo = PageHelper.startPage(
//				page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//						() -> cisJcsq01Ser.getEntityMapper().queryZyJcSqdList(cisJcsq01QueryReq)
//				);
//        return ReturnEntityUtil.success(pageInfo);
//    }
//
//    /**
//     * 检查申请单打印(SqdFormFile--FsSqdForm.jrxml)
//     *
//     */

    @GetMapping("/jcsqdPrint")
    @ApiOperation(value="检查申请单打印" ,httpMethod="GET")
    public void jcsqdPrint(@ApiParam(name = "jcxh", value = "检查序号", required = true) @RequestParam(value = "jcxh") Integer jcxh,
                                                         @ApiParam(name = "sqlx", value = "申请类型", required = true) @RequestParam(value = "sqlx") Integer sqlx, HttpServletResponse response){
        Map<String, Object> stringObjectMap =  cisJcsq01Ser.jcsqdPrint(jcxh, sqlx, getUser().getHospitalId());
        List<Map<String, Object>> list=new ArrayList<>();
        list.add(stringObjectMap);
        iReportExportFileSer.reportHtmlForStream(list,stringObjectMap,"jrxml/HosCheckForm.jasper",response);
    }

    /**
     * 辅助报告检查列表
     *
     */
    @RequestMapping("/queryAuxiliaryJcReportList")
    @ResponseBody
    @ApiOperation(value="辅助报告检查列表" ,httpMethod="POST")
    public ReturnEntity<List<QueryAuxiliaryJcReportListResp>> queryAuxiliaryJcReportList(@Valid QueryAuxiliaryJcReportListReq req){
        List<QueryAuxiliaryJcReportListResp> resp = cisJcsq01Ser.queryAuxiliaryJcReportList(req);
        return ReturnEntityUtil.success(resp);
    }

    /**
     * 查询检查申请单查询对应的检查项目详情
     * @param jcxh
     */
    @RequestMapping("/getJcxmDetail")
    @ResponseBody
    @ApiOperation(value="查询检查报告对应的检查项目" ,httpMethod="POST")
    public ReturnEntity<List<CisJcsq02ZlxmResp>> getJcxmDetail(@ApiParam(name = "jcxh", value = "检查序号", required = true) @RequestParam(value = "jcxh") Integer jcxh){
        return ReturnEntityUtil.success(cisJcsq01Ser.queryYsJcDicZlxmInfo(jcxh,getUser().getHospitalId()));
    }


    @RequestMapping("/queryApiPacsReportList")
    @ResponseBody
    @ApiOperation(value="查询住院检查申请列表" ,httpMethod="POST")
    public ReturnEntity<List<QueryAuxiliaryJcReportListResp>> queryApiPacsReportList(@ApiParam(name = "zyh", value = "zyh", required = true) @RequestParam(value = "zyh") Integer zyh){
        List<QueryAuxiliaryJcReportListResp> resp = apiPacsReportSer.queryApiPacsReportList(zyh);
        return ReturnEntityUtil.success(resp);
    }
//
//    /**
//     * 辅助报告检查删除
//     *
//     */
//    @RequestMapping("/auxiliaryJcDel")
//    @ResponseBody
//    @ApiOperation(value="辅助报告检查删除" ,httpMethod="POST")
//    public ReturnEntity auxiliaryJcDel(@ApiParam(name = "jcxh", value = "检查序号", required = true) @RequestParam Integer jcxh,
//                                       @ApiParam(name = "yjxh", value = "医技序号", required = true) @RequestParam Integer yjxh){
//        cisJcsq01Ser.auxiliaryJcDel(jcxh, yjxh);
//        return ReturnEntityUtil.success();
//    }
//
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<CisJcsq01Resp> getOneByEntity(CisJcsq01Req cisjcsq01){
//        List<CisJcsq01> list=cisJcsq01Ser.findByEntity(cisjcsq01);
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
//    public ReturnEntity<CisJcsq01Resp> add(CisJcsq01Req cisJcsq01) {
//        cisJcsq01Ser.insert(cisJcsq01);
//        return ReturnEntityUtil.success(cisJcsq01);
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<CisJcsq01Resp> edit(CisJcsq01Req cisJcsq01)  {
//        cisJcsq01Ser.update(cisJcsq01);
//        return ReturnEntityUtil.success(cisJcsq01);
//    }
//
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<CisJcsq01Resp> delete(CisJcsq01Req cisJcsq01) {
//        cisJcsq01Ser.removeByEntity(cisJcsq01);
//        return ReturnEntityUtil.success(cisJcsq01);
//    }

}

