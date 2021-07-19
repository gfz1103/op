
package com.buit.cis.op.dctwork.controller;


import com.buit.cis.op.dctwork.request.CzPrintRequest;
import com.buit.cis.op.dctwork.request.JySqdReq;
import com.buit.cis.op.dctwork.response.CzPrintResponse;
import com.buit.cis.op.dctwork.response.YjztDetailResp;
import com.buit.cis.op.dctwork.service.MzYjSer;
import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.commons.dao.ApiLisReportDao;
import com.buit.commons.model.ApiLisReport;
import com.buit.commons.request.*;
import com.buit.commons.response.*;
import com.buit.commons.serviceImpl.OpYjcf01ServiceImpl;
import com.buit.file.IReportExportFileSer;
import com.buit.op.request.IOptSssqSaveYjReq;
import com.buit.op.request.OpYjcf01Req;
import com.buit.op.response.ApiLisReportResp;
import com.buit.system.response.YjQueryPageHelperResp;
import com.buit.utill.BeanUtil;
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 患者_技单<br>
 * @author 老花生
 */
@Api(tags="门诊--医技(处置)")
@Controller
@RequestMapping("/opyjcf01")
public class MzYjCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(MzYjCtr.class);

    @Autowired
    private MzYjSer mzYjSer;

    @Autowired
    private OpYjcf01ServiceImpl opYjcf01Service;

    @Autowired
    private ApiLisReportDao apiLisReportDao;

    /** 保存(clinicDisposalEntryService.saveDisposalEntry) */
    @RequestMapping("/save")
    @ResponseBody
    @ApiOperation(value="保存" ,httpMethod="POST")
    public ReturnEntity add(@Valid @RequestBody OpYjcf01Req req) throws Exception{
        req.setLy(11);
        return ReturnEntityUtil.success(mzYjSer.save(req, getUser()));
    }

    /** 保存校验(clinicDisposalEntryService.checkProjectMaterials) */
    @RequestMapping("/saveCheck")
    @ResponseBody
    @ApiOperation(value="保存校验" ,httpMethod="POST")
    public ReturnEntity checkProjectMaterials(@RequestBody CheckProjectMaterialsReq req) {
        //mzYjSer.saveCheck(req,getUser());
        return ReturnEntityUtil.success();
    }

    /** 查询处置列表(clinicDisposalEntryService.queryDisposalEntryList) */
    @RequestMapping("/queryDisposalEntryList")
    @ResponseBody
    @ApiOperation(value="查询处置列表" ,httpMethod="POST")
    public ReturnEntity<List<QueryDisposalEntryListResp>> queryDisposalEntryList(QueryDisposalEntryListReq req) {
        return ReturnEntityUtil.success(mzYjSer.queryDisposalEntryList(req));
    }

    /**
     * 查询医技组套详情信息
     * @param sbxh
     * @return
     */
    @RequestMapping("/queryZtDetail")
    @ResponseBody
    @ApiOperation(value="查询处置详情" ,httpMethod="POST")
    public ReturnEntity<List<YjztDetailResp>> queryZtDetail(@ApiParam(name = "sbxh", value = "识别序号", required = true) @RequestParam Integer sbxh) {
        return ReturnEntityUtil.success(mzYjSer.queryZtDetail(sbxh));
    }

    /** 医技全部查询（助手方式） */
    @RequestMapping("/queryPageHelper")
    @ResponseBody
    @ApiOperation(value="医技全部查询（助手方式）" ,httpMethod="POST")
    public ReturnEntity<PageInfo<YjQueryPageHelperResp>> queryPageHelper(YjQueryPageHelperReq req) {
        return ReturnEntityUtil.success(mzYjSer.queryPageHelper(req, getUser().getHospitalId()));
    }

    /** 处置明细删除(clinicDisposalEntryService.removeDisposalEntry) */
    @RequestMapping("/removeDisposalEntry")
    @ResponseBody
    @ApiOperation(value="处置明细删除" ,httpMethod="POST")
    public ReturnEntity removeDisposalEntry(@ApiParam(name = "sbxh", value = "识别序号") @RequestParam(required = false) Integer sbxh,
                                            @ApiParam(name = "ztsbxh", value = "组套识别序号") @RequestParam(required = false) Integer ztsbxh,
                                            @ApiParam(name = "ztbz", value = "组套标志 1是 0 否") @RequestParam(required = false) Integer ztbz,
                                            @ApiParam(name = "yjzh", value = "组号", required = true) @RequestParam Integer yjzh,
                                            @ApiParam(name = "type", value = "1删除同组、2删除一条", required = true) @RequestParam String type) {
        mzYjSer.removeDisposalEntry(sbxh,ztsbxh,ztbz,yjzh,type);
        return ReturnEntityUtil.success();
    }

    /** 根据组套载入组套明细信息(clinicDisposalEntryService.loadPersonalSet) */
    @RequestMapping("/loadPersonalSet")
    @ResponseBody
    @ApiOperation(value="根据组套载入组套明细信息" ,httpMethod="POST")
    public ReturnEntity<List<YjLoadPersonalSetResp>> loadPersonalSet(@Valid YjLoadPersonalSetReq req) {
        return ReturnEntityUtil.success(mzYjSer.loadPersonalSet(req, getUser()));
    }

    /** 根据组套载入组套明细信息（全院-科室）(clinicDisposalEntryService.saveDisposalSet) */
    @RequestMapping("/saveDisposalSet")
    @ResponseBody
    @ApiOperation(value="根据组套载入组套明细信息（全院-科室）" ,httpMethod="POST")
    public ReturnEntity<Integer> saveDisposalSet(@Valid SaveDisposalSetReq req) {
        req.setYgdm(getUser().getUserId());
        return ReturnEntityUtil.success(mzYjSer.saveDisposalSet(req, getUser()));
    }

    /** 根据组装组套插入数据(clinicDisposalEntryService.insertDisposalSet) */
    @RequestMapping("/insertDisposalSet")
    @ResponseBody
    @ApiOperation(value="根据组装组套插入数据" ,httpMethod="POST")
    public ReturnEntity<InsertDisposalSetResp> insertDisposalSet(@ApiParam(name = "sbxh", value = "识别序号", required = true) @RequestParam Integer sbxh) {
        return ReturnEntityUtil.success(mzYjSer.insertDisposalSet(sbxh));
    }

    /** 判断是否需要审核(clinicDisposalEntryService.queryIsNeedVerify) */
    @RequestMapping("/queryIsNeedVerify")
    @ResponseBody
    @ApiOperation(value="判断是否需要审核" ,httpMethod="POST")
    public ReturnEntity<Long> queryIsNeedVerify(@ApiParam(name = "fyxh", value = "费用序号", required = true) @RequestParam Integer fyxh,
                                                                 @ApiParam(name = "brid", value = "识别序号", required = true) @RequestParam Integer brid,
                                                                 @ApiParam(name = "xzts", value = "识别序号", required = true) @RequestParam Integer xzts) {
        return ReturnEntityUtil.success(mzYjSer.queryIsNeedVerify(fyxh, brid, xzts, getUser().getHospitalId()));
    }

    /** 医技打印(TreatmentPrintFile) */
    @GetMapping("/yjPrint")
    @ApiOperation(value="医技打印" ,httpMethod="GET")
    public void yjPrint(@Valid YjPrintReq req, HttpServletResponse response) {
        req.setJgid(getUser().getHospitalId());
        mzYjSer.yjPrint(req, getUser(),response);
    }

    /** 查询辅助报告检验申请列表*/
    @RequestMapping("/queryAuxiliaryJyReportList")
    @ResponseBody
    @ApiOperation(value="查询辅助报告检验申请列表" ,httpMethod="POST")
    public ReturnEntity<List<QueryAuxiliaryReportListResp>> queryAuxiliaryJyReportList(@Valid QueryDisposalEntryListReq req) {
        List<QueryAuxiliaryReportListResp> resp = mzYjSer.queryAuxiliaryJyReportList(req);
        return ReturnEntityUtil.success(resp);
    }

    /** 查询辅助报告检验明细信息*/
    @RequestMapping("/queryAuxiliaryJyDetail")
    @ResponseBody
    @ApiOperation(value="查询辅助报告检验明细信息" ,httpMethod="POST")
    public ReturnEntity<List<QueryAuxiliaryJyDetailResp>> queryAuxiliaryJyDetail(@Valid QueryAuxiliaryJyDetailReq req) {
        List<QueryAuxiliaryJyDetailResp> resp = mzYjSer.queryAuxiliaryJyDetail(req);
        return ReturnEntityUtil.success(resp);
    }

    /** 查询患者的检验报告单*/
    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperation(value="查询患者的检验报告单" ,httpMethod="POST")
    public ReturnEntity<List<ApiLisReportResp>> queryAuxiliaryJyDetail(ApiLisReportReq apilisreport) {
        List<ApiLisReport> resp = apiLisReportDao.findByEntity(apilisreport);
        return ReturnEntityUtil.success(BeanUtil.toBeans(resp, ApiLisReportResp.class));
    }

    /** 辅助报告检验删除*/
    @RequestMapping("/auxiliaryJyDel")
    @ResponseBody
    @ApiOperation(value="辅助报告检验删除" ,httpMethod="POST")
    public ReturnEntity auxiliaryJyDel(@Valid QueryAuxiliaryJyDetailReq req) {
        mzYjSer.delById(req.getYjxh());
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/queryApiLisReport")
    @ResponseBody
    @ApiOperation(value="查询检验报告" ,httpMethod="POST")
    public ReturnEntity<List<ApiLisReportResp>> queryApiLisReport(@ApiParam(name = "brid", value = "brid", required = true) @RequestParam String brid,
                                                    @ApiParam(name = "patType", value = "patType", required = true) @RequestParam String patType) {
        return ReturnEntityUtil.success(apiLisReportDao.queryLisReport(brid, patType));
    }

    @RequestMapping("/queryApiLisReportDetail")
    @ResponseBody
    @ApiOperation(value="查询检验报告明细" ,httpMethod="POST")
    public ReturnEntity<List<ApiLisReportResp>> queryLisReportDetail(@ApiParam(name = "reportItemId", value = "reportItemId", required = true) @RequestParam String reportItemId) {
        return ReturnEntityUtil.success(apiLisReportDao.queryLisReportDetail(reportItemId));
    }

    /** 医技添加校验*/
    @RequestMapping("/checkAddYj")
    @ResponseBody
    @ApiOperation(value="添加医技校验(处置保存、检查申请单、检验申请单)" ,httpMethod="POST")
    public ReturnEntity<Boolean> checkAddYj(
            @ApiParam(name = "type", value = "类型：1处置、2检查、3检验、7治疗", required = true) @RequestParam Integer type,
            @ApiParam(name = "jzlsh", value = "就诊流水号", required = true) @RequestParam String jzlsh,
            @ApiParam(name = "ylxhs", value = "医疗序号集合") @RequestParam(value="ylxhs", required = false) String ylxhs,
            @ApiParam(name = "zlxmids", value = "诊疗项目ID集合") @RequestParam(value="zlxmids", required = false) String zlxmids,
            @ApiParam(name = "xmbhs", value = "项目编号集合") @RequestParam(value="xmbhs", required = false) String xmbhs) {
        return ReturnEntityUtil.success(mzYjSer.checkAddYj(type, jzlsh, ylxhs, zlxmids, xmbhs));
    }

    /**
     * 保存门诊检验申请单(sqdManageService.saveMzJySqd)
     */
    @RequestMapping("/saveMzjySqd")
    @ResponseBody
    @ApiOperation(value = "保存门诊检验申请单", httpMethod = "POST")
    public ReturnEntity saveMzJySqd(@Valid @RequestBody JySqdReq req) {//@RequestBody
        mzYjSer.saveMzJySqd(req, getUser());
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/sssqSaveYj")
    @ResponseBody
    @ApiOperation(value = "手术申请保存医技", httpMethod = "POST")
    public ReturnEntity sssqSaveYj(@Valid @RequestBody IOptSssqSaveYjReq req) {//@RequestBody
        opYjcf01Service.sssqSaveYj(req);
        return ReturnEntityUtil.success();
    }


    @RequestMapping("/queryJysqdMessage")
    @ResponseBody
    @ApiOperation(value = "查询检验申请单", httpMethod = "POST")
    public ReturnEntity<PageInfo<QueryJysqdResp>> queryJysqdMessage(@Valid @RequestBody QueryJysqdReq req, PageQuery page) {//@RequestBody
        PageInfo<QueryJysqdResp> pageInfo = PageHelper.startPage(
            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                    () -> mzYjSer.queryJysqdMessage(req,getUser())
            );
        return ReturnEntityUtil.success(pageInfo);
    }

    /**
     * 查询处置打印数据
     * @param request
     * @return
     */
    @RequestMapping("/getCzPrintData")
    @ResponseBody
    @ApiOperation(value = "查询处置打印数据", httpMethod = "POST")
    public ReturnEntity<CzPrintResponse> getCzPrintData(@Valid @RequestBody CzPrintRequest request) {//@RequestBody
        return ReturnEntityUtil.success(mzYjSer.getCzPrintData(request));
    }


//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<OpYjcf01Resp>> queryPage(OpYjcf01Req opyjcf01,PageQuery page){
//        PageInfo<OpYjcf01> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> mzYjSer.findByEntity(opyjcf01)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<OpYjcf01Resp>> getByEntity( OpYjcf01Req opyjcf01){//@RequestBody
//        return ReturnEntityUtil.success(mzYjSer.findByEntity(opyjcf01));
//    }
//
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<OpYjcf01Resp> getOneByEntity(OpYjcf01Req opyjcf01){
//        List<OpYjcf01> list=mzYjSer.findByEntity(opyjcf01);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));
//        }
//        return ReturnEntityUtil.success();
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<OpYjcf01Resp> edit(OpYjcf01Req opYjcf01)  {
//        mzYjSer.update(opYjcf01);
//        return ReturnEntityUtil.success(opYjcf01);
//    }
//

    @Autowired
   private IReportExportFileSer iReportExportFileSer;
    @RequestMapping("/testReport")
    @ResponseBody
    @ApiOperation(value="按条件查询" ,httpMethod="POST")
    public ReturnEntity<String> delete() {
        String jasperName = "report1.jasper";
        Map<String, Object> params = new HashMap<>();
        String url = "http://192.168.102.252:7990/ftpuser//image/system/eaded5a2-bd60-4294-9a6b-c501d7473870.png";
        params.put("LOGO",url);
        String s = iReportExportFileSer.reportHtml(params, jasperName);
        System.out.println(s);
        return ReturnEntityUtil.success(s) ;
    }

}

