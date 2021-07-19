package com.buit.his.op.reg.controller;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.buit.file.IReportExportFileSer;
import cn.hutool.json.JSONUtil;
import com.buit.commons.SysUser;
import com.buit.commons.request.JzhzxxReq;
import com.buit.commons.request.JzxxReq;
import com.buit.commons.response.SfrbhzResp;
import com.buit.file.IReportExportFileSer;
import com.buit.system.service.ExportFileSer;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.commons.response.QueryCancelCommitResp;
import com.buit.commons.response.SfrbResp;
import com.buit.his.op.reg.service.GhrbReportSer;
import com.buit.system.service.ExportFileSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.servlet.http.HttpServletResponse;

/**
 * 挂号收费报表<br>
 * 
 * @author WY
 */
@Api(tags = "挂号收费报表")
@Controller
@RequestMapping("/ghrbReport")
public class GhrbReportCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(GhrbReportCtr.class);

	@Autowired
	private GhrbReportSer ghrbReportSer;
	@DubboReference
	private ExportFileSer exportFileSer;
    @Autowired
    private IReportExportFileSer iReportExportFileSer;
	/**
	 * 挂号日报
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/registerDailyTableView")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "挂号日报", httpMethod = "POST", notes = "挂号日报")
	public ReturnEntity<String> registerDailyTableView(
			@ApiParam(name = "ghsj", value = "挂号日期") @RequestParam(value = "ghsj") Date ghsj) {
		String url = exportFileSer.reportHtml(ghrbReportSer.getFields(getUser().getUserId(), ghsj),
				ghrbReportSer.getParameters(getUser().getUserId(), ghsj, getUser().getHospitalId(), getIpAddress()),
				"RegisterDailyTableView.jasper");
		return ReturnEntityUtil.success(url);
	}

	/**
	 * 挂号操作员工作量查询
	 *
	 * @param beginDay
	 * @param endDay
	 * @return
	 */
	@GetMapping("/searchForCountWorks")
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "挂号操作员工作量查询", httpMethod = "GET", notes = "挂号操作员工作量查询")
	public void searchForCountWorks(
			HttpServletResponse response,
			@ApiParam(name = "beginDay", value = "开始日期") @RequestParam(value = "beginDay") Date beginDay,
			@ApiParam(name = "endDay", value = "结束日期") @RequestParam(value = "endDay") Date endDay) {
		iReportExportFileSer.reportHtmlForStream(ghrbReportSer.getCountWorksFields(beginDay, endDay),
				ghrbReportSer.getCountWorksParameters(getUser().getUserName(), beginDay, endDay),
				"jrxml/SearchForCountWorks.jasper", response);
	}

	/**
	 * 收费日报报表产生前查询最后一次汇总时间
	 *
	 * @param beginDay
	 * @param endDay
	 * @return
	 */
	@RequestMapping("/doGetLastHzrq")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "查询最后一次汇总时间", httpMethod = "POST", notes = "查询最后一次汇总时间")
	public ReturnEntity<String> doGetLastHzrq(
			@ApiParam(name = "beginDay", value = "开始日期") @RequestParam(value = "beginDay") Date beginDay,
			@ApiParam(name = "endDay", value = "结束日期") @RequestParam(value = "endDay") Date endDay) {
//		String url = exportFileSer
//				.reportHtml(
//						ghrbReportSer.getLastHzrqParameters(beginDay, endDay, getUser().getHospitalId(),
//								getUser().getUserId(), getUser().getUserName(), getIpAddress()),
//						"chargesFsbDailyLB.jasper");
		Map<String, Object> resp = ghrbReportSer.getLastHzrqParameters(beginDay, endDay, getUser().getHospitalId(),
				getUser().getUserId(), getUser().getUserName(), getIpAddress());
		String body = resp.get("body") != null ? resp.get("body").toString() : "";
		return ReturnEntityUtil.success(body);
	}

    /**
     * 查询收费日报列表
     *
     * @param beginDay
     * @param endDay
     * @return
     */
    @RequestMapping("/doQuerySQL")
    @ResponseBody
    @ApiOperationSupport(author = "汪洋")
    @ApiOperation(value = "查询收费日报", httpMethod = "POST", notes = "查询收费日报")
    public ReturnEntity<List<SfrbResp>> doQuerySQL(
            @ApiParam(name = "beginDay", value = "开始日期") @RequestParam(value = "beginDay") Date beginDay,
            @ApiParam(name = "endDay", value = "结束日期") @RequestParam(value = "endDay") Date endDay, PageQuery page) {
        List<SfrbResp> resp = ghrbReportSer.doQuerySQL(beginDay, endDay, page, getUser().getUserId(),
                getUser().getHospitalId(), getIpAddress());
        return ReturnEntityUtil.success(resp);
    }



	/**
	 * 收费日报产生、结账、查询确认
	 *
	 * @param beginDay
	 * @param endDay
	 * @return
	 */
	@RequestMapping("/doCreateSfrb")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "收费日报产生、结账、查询确认", httpMethod = "POST", notes = "收费日报产生、结账、查询确认")
	public ReturnEntity<String> doCreateSfrb(
			@ApiParam(name = "beginDay", value = "开始日期") @RequestParam(value = "beginDay") Date beginDay,
			@ApiParam(name = "endDay", value = "结束日期") @RequestParam(value = "endDay") Date endDay,
			@ApiParam(name = "save", value = "收费日报标志  产生:传0 ; 结账:传1    ; 查询确认:传2") @RequestParam(value = "save", required = false) String save,
			@ApiParam(name = "jzrq", value = "结账时间 结账时传当前时间，查询确认时传结账日期") @RequestParam(value = "jzrq", required = false) String jzrq) {
		Map<String, Object> sfrbMap = ghrbReportSer.doCreateSfrb(beginDay, endDay, jzrq, save,
				getUser().getHospitalId(), getUser().getUserId(), getUser().getUserName(), getIpAddress());
		// 生成报表url
		String url = exportFileSer.reportHtml(sfrbMap, "chargesFsbDailyLB.jasper");

        /*String url = exportFileSer.reportHtml(ghrbReportSer.getOpsfmxListFields(beginDay, endDay, jzrq, save,
                getUser().getHospitalId(), getUser().getUserId(), getUser().getUserName(), getIpAddress()),
                ghrbReportSer.getOpParameters(),
                "Opsfrb.jasper");*/
		return ReturnEntityUtil.success(url);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 收费日报报查询最后一次结账日期
	 *
	 * @return
	 */
	@RequestMapping("/doGetLastJzrq")
	@ResponseBody
	@ApiOperationSupport(author = "卑军华")
	@ApiOperation(value = "查询最后一次结账时间", httpMethod = "POST", notes = "查询最后一次结账时间")
	public ReturnEntity<String> doGetLastJzrq() throws ParseException {
		String resp = ghrbReportSer.getLastJzrq(getUser(),  getIpAddress());
		return ReturnEntityUtil.success(resp);
	}



    /**
     * 收费日报产生(私立)
     *
     * @return
     */
    @GetMapping("/doCreSfrb")
    @ApiOperationSupport(author = "卑军华")
    @ApiOperation(value = "收费日报产生,查询")
    public void doCreSfrb(
            @RequestParam("reqStr") String reqStr, HttpServletResponse response) {
        JzxxReq rj = JSONUtil.toBean(reqStr, JzxxReq.class);
        String jzrq = rj.getJzrq();
        String jzksrq = rj.getJzksrq();
        String jzjsrq = rj.getJzjsrq();
        String save = rj.getSave();
        List<Map<String,Object>> list = ghrbReportSer.getOpsfmxListFields( jzksrq,jzjsrq,save,
                getUser().getHospitalId(), getUser().getUserId(), getIpAddress());
        Map<String,Object> map =   ghrbReportSer.getOpParameters(getUser(),jzksrq,jzjsrq,save,list,getIpAddress());
        /*tring url = exportFileSer.reportHtml(ghrbReportSer.getOpsfmxListFields( jzrq, save,
                getUser().getHospitalId(), getUser().getUserId(), getUser().getUserName(), getIpAddress()),
                ghrbReportSer.getOpParameters(),
                "Opsfrb.jasper");*/
        if(CollectionUtils.isNotEmpty(list)) {
            iReportExportFileSer.reportHtmlForStream(list, map, "jrxml/Opsfrb.jasper", response);
        }
    }

	/**
	 * 收费日报结账前校验
	 *
	 * @return
	 */
	@RequestMapping("/doQueryVerification")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "收费日报结账前校验", httpMethod = "POST", notes = "收费日报结账前校验")
	public ReturnEntity<?> doQueryVerification(@ApiParam(name = "jzjsrq", value = "结账结束日期") @RequestParam(value = "jzjsrq") String jzjsrq) {
		ghrbReportSer.doQueryVerification(jzjsrq,getUser().getUserId(), getUser().getHospitalId(), getIpAddress());
		return ReturnEntityUtil.success();
	}

	/**
	 * 收费日报结账
	 *
	 * @return
	 */
	@RequestMapping("/doSaveSfrb")
	@ResponseBody
	@ApiOperationSupport(author = "卑军华")
	@ApiOperation(value = "收费日报结账", httpMethod = "POST", notes = "收费日报结账")
	public ReturnEntity<?> doSaveSfrb(
			@ApiParam(name = "jzksrq", value = "结账开始日期") @RequestParam(value = "jzksrq") String jzksrq,
			@ApiParam(name = "jzjsrq", value = "结账结束日期") @RequestParam(value = "jzjsrq") String jzjsrq,
			@ApiParam(name = "save", value = "") @RequestParam(value = "save") String save) {
		ghrbReportSer.doSaveSfrb(jzksrq,jzjsrq,save,getUser(),getIpAddress());
		return ReturnEntityUtil.success();
	}



    /**
     * 查询收费日报列表
     *
     * @return
     */
    @RequestMapping("/doQueSfrbList")
    @ResponseBody
    @ApiOperationSupport(author = "卑军华")
    @ApiOperation(value = "收费日报查询列表", httpMethod = "POST", notes = "收费日报查询列表")
    public ReturnEntity<List<SfrbResp>> doQueSfrbList() {
		List<SfrbResp> resp =  ghrbReportSer.doQueSfrbList(getUser(), getIpAddress());
        return ReturnEntityUtil.success(resp);
    }
	/**
	 * 收费日报查询(私立)
	 *
	 * @return
	 */
/*	@GetMapping("/doQueSfrb")
	@ApiOperationSupport(author = "卑军华")
	@ApiOperation(value = "收费日报查询")
	public void doQueSfrb(
			@RequestParam("reqStr") String reqStr, HttpServletResponse response) {
		JzxxReq rj = JSONUtil.toBean(reqStr, JzxxReq.class);
		String jzrq = rj.getJzrq();
		String jzksrq = rj.getJzksrq();
		String jzjsrq = rj.getJzjsrq();
		String save = rj.getSave();
		List<Map<String,Object>> list = ghrbReportSer.getOpsfmxListFields( jzksrq,jzjsrq,
				getUser().getHospitalId(), getUser().getUserId(), getIpAddress());
		Map<String,Object> map =   ghrbReportSer.getOpParameters(getUser(),jzksrq,jzjsrq,list,getIpAddress());
		if(CollectionUtils.isNotEmpty(list)) {
			iReportExportFileSer.reportHtmlForStream(list, map, "jrxml/Opsfrb.jasper", response);
		}
	}*/

	/**
	 * 取消结账
	 *
	 * @return
	 */
	@RequestMapping("/doCancelSfrb")
	@ResponseBody
	@ApiOperationSupport(author = "卑军华")
	@ApiOperation(value = "收费日报取消结账", httpMethod = "POST", notes = "收费日报取消结账")
	public ReturnEntity<?> doCancelSfrb(
			@ApiParam(name = "jzrq", value = "结账时间") @RequestParam(value = "jzrq", required = false) String jzrq) {
		ghrbReportSer.doCancelSfrb(jzrq, getUser().getHospitalId(), getUser().getUserId(), getIpAddress());
		return ReturnEntityUtil.success();
	}



	//////////////////////////////////////////////////////////////////////////
	/**
	 * 收费汇总日报报查询最后一次结账日期
	 *
	 * @return
	 */
	@RequestMapping("/doGetLastHzJzrq")
	@ResponseBody
	@ApiOperationSupport(author = "卑军华")
	@ApiOperation(value = "查询最后一次汇总结账时间", httpMethod = "POST", notes = "查询最后一次汇总结账时间")
	public ReturnEntity<String> doGetLastHzJzrq(
			@ApiParam(name = "mzlb", value = "门诊类别") @RequestParam(value = "mzlb", required = false) int mzlb) throws ParseException {
		String resp = ghrbReportSer.getLastHzJzrq(getUser(),  mzlb);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 收费汇总日报结账前校验
	 *
	 * @return
	 */
	@RequestMapping("/doQueryHzVerification")
	@ResponseBody
	@ApiOperationSupport(author = "卑军华")
	@ApiOperation(value = "收费汇总日报结账前校验", httpMethod = "POST", notes = "收费汇总日报结账前校验")
	public ReturnEntity<?> doQueryHzVerification(
			@ApiParam(name = "hzksrq", value = "结账结束日期") @RequestParam(value = "hzksrq") String hzksrq,
			@ApiParam(name = "hzjsrq", value = "结账结束日期") @RequestParam(value = "hzjsrq") String hzjsrq,
			@ApiParam(name = "mzlb", value = "门诊类别") @RequestParam(value = "mzlb") int mzlb) {
		ghrbReportSer.doQueryHzVerification(hzksrq,hzjsrq,getUser().getHospitalId(),mzlb);
		return ReturnEntityUtil.success();
	}

	/**
	 * 收费汇总日报产生
	 *
	 * @return
	 */
	@GetMapping("/doCreSfhzrb")
	@ApiOperationSupport(author = "卑军华")
	@ApiOperation(value = "收费汇总日报产生,查询")
	public void doCreSfhzrb(
			@RequestParam("reqStr") String reqStr, HttpServletResponse response) {
		JzhzxxReq rj = JSONUtil.toBean(reqStr, JzhzxxReq.class);
		String hzksrq = rj.getHzksrq();
		String hzjsrq = rj.getHzjsrq();
		String save = rj.getSave();
		int mzlb = rj.getMzlb();
		List<Map<String,Object>> list = ghrbReportSer.getOpHzListFields(hzksrq,hzjsrq,save,
				getUser().getHospitalId(), mzlb);
		Map<String,Object> map =   ghrbReportSer.getOpHzParameters(getUser(),hzksrq,hzjsrq);
		if(CollectionUtils.isNotEmpty(list)) {
			iReportExportFileSer.reportHtmlForStream(list, map, "jrxml/Opsfrbhz.jasper", response);
		}
	}

	/**
	 * 查询收费汇总日报列表
	 *
	 * @return
	 */
	@RequestMapping("/doQueSfhzrbList")
	@ResponseBody
	@ApiOperationSupport(author = "卑军华")
	@ApiOperation(value = "收费日报汇总查询列表", httpMethod = "POST", notes = "收费日报汇总查询列表")
	public ReturnEntity<List<SfrbhzResp>> doQueSfhzrbList(
			@ApiParam(name = "mzlb", value = "门诊类别") @RequestParam(value = "mzlb", required = false) int mzlb
	) {
		List<SfrbhzResp> resp =  ghrbReportSer.doQueSfrbhzList(getUser(),mzlb);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 收费日报结账汇总
	 *
	 * @return
	 */
	@RequestMapping("/doSaveSfrbhz")
	@ResponseBody
	@ApiOperationSupport(author = "卑军华")
	@ApiOperation(value = "收费日报汇总结账", httpMethod = "POST", notes = "收费日报汇总结账")
	public ReturnEntity<?> doSaveSfrbhz(
			@ApiParam(name = "hzksrq", value = "汇总开始日期") @RequestParam(value = "hzksrq") String hzksrq,
			@ApiParam(name = "hzjsrq", value = "汇总结束日期") @RequestParam(value = "hzjsrq") String hzjsrq,
			@ApiParam(name = "mzlb", value = "门诊类别") @RequestParam(value = "mzlb") int mzlb) {
		ghrbReportSer.doSaveSfrbhz(hzksrq,hzjsrq,mzlb,getUser());
		return ReturnEntityUtil.success();
	}

	/**
	 * 取消结账
	 *
	 * @return
	 */
	@RequestMapping("/doCancelSfhzrb")
	@ResponseBody
	@ApiOperationSupport(author = "卑军华")
	@ApiOperation(value = "收费汇总日报取消结账", httpMethod = "POST", notes = "收费汇总日报取消结账")
	public ReturnEntity<?> doCancelSfhzrb(
			@ApiParam(name = "hzrq", value = "汇总时间") @RequestParam(value = "hzrq", required = false) String hzrq,
			@ApiParam(name = "mzlb", value = "门诊类别") @RequestParam(value = "mzlb", required = false) int mzlb) {
		ghrbReportSer.doCancelSfhzrb(hzrq, getUser().getHospitalId(),mzlb);
		return ReturnEntityUtil.success();
	}



	/////////////////////////////////////////////////////////////////////////
	/**
	 * 取消结账查询
	 *
	 * @return
	 */
	@RequestMapping("/doQueryCancelCommit")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "取消结账查询", httpMethod = "POST", notes = "取消结账查询")
	public ReturnEntity<List<QueryCancelCommitResp>> doQueryCancelCommit() {
		List<QueryCancelCommitResp> resp = ghrbReportSer.doQueryCancelCommit(getUser().getHospitalId(),
				getUser().getUserId(), getIpAddress());
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 取消结账
	 *
	 * @param beginDay
	 * @param endDay
	 * @return
	 */
	@RequestMapping("/doCancelCommit")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "取消结账", httpMethod = "POST", notes = "取消结账")
	public ReturnEntity<?> doCancelCommit(
			@ApiParam(name = "jzrq", value = "结账时间") @RequestParam(value = "jzrq", required = false) String jzrq) {
		ghrbReportSer.doCancelCommit(jzrq, getUser().getHospitalId(), getUser().getUserId(), getIpAddress());
		return ReturnEntityUtil.success();
	}

	/**
	 * 充值日报统计
	 *
	 * @param beginDay
	 * @param endDay
	 * @param jgName
	 * @return
	 */
	@GetMapping("/rechargeCardsDailyReport")
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "充值日报统计", httpMethod = "GET", notes = "充值日报统计")
	public void rechargeCardsDailyReport(
			HttpServletResponse response,
			@ApiParam(name = "beginDay", value = "开始日期") @RequestParam(value = "beginDay") Date beginDay,
			@ApiParam(name = "endDay", value = "结束日期") @RequestParam(value = "endDay") Date endDay,
			@ApiParam(name = "jgName", value = "机构名称") @RequestParam(value = "jgName") String jgName) {
		iReportExportFileSer.reportHtmlForStream(
				ghrbReportSer.getRechargeCardsFields(getUser().getUserId(), beginDay, endDay),
				ghrbReportSer.getRechargeCardsParameters(getUser().getUserId(), getUser().getUserName(), beginDay,
						endDay, jgName),
				"jrxml/RechargeCardsDailyReport.jasper", response);
	}

	/**
	 * 发票查询门诊清单
	 *
	 * @param jgName
	 * @return
	 */

	@GetMapping("/outpatientList")
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "发票查询门诊清单", httpMethod = "GET", notes = "发票查询门诊清单")
	public void outpatientList(
			HttpServletResponse response,
			@ApiParam(name = "jgName", value = "机构名称") @RequestParam(value = "jgName") String jgName,
			@ApiParam(name = "fphm", value = "发票号码") @RequestParam(value = "fphm") String fphm) {
		iReportExportFileSer.reportHtmlForStream(ghrbReportSer.getOutpatientListFields(fphm, getUser().getHospitalId()),
				ghrbReportSer.getOutpatientListParameters(fphm, getUser().getHospitalId(), jgName),
				"jrxml/OutpatientList.jasper", response);
	}

	/**
	 * 门诊收费汇总日报-项目分类明细表
	 *
	 * @param beginDay
	 * @param endDay
	 * @param jgName
	 * @return
	 */
	@RequestMapping("/xmflmxb")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "门诊收费汇总日报项目分类明细表", httpMethod = "POST", notes = "门诊收费汇总日报项目分类明细表")
	public ReturnEntity<String> xmflmxb(
			@ApiParam(name = "beginDay", value = "开始日期") @RequestParam(value = "beginDay") Date beginDay,
			@ApiParam(name = "endDay", value = "结束日期") @RequestParam(value = "endDay") Date endDay,
			@ApiParam(name = "ybxl", value = "医保线路 以逗号分割") @RequestParam(value = "ybxl") String ybxl,
			@ApiParam(name = "jgName", value = "机构名称") @RequestParam(value = "jgName") String jgName) {
		String url = exportFileSer.reportHtml(
				ghrbReportSer.getXmflmxbFields(beginDay, endDay, ybxl, getUser().getUserId(),
						getUser().getHospitalId()),
				ghrbReportSer.getXmflmxbParameters(beginDay, endDay, jgName, getUser().getUserName()),
				"xmflmxb.jasper");
		return ReturnEntityUtil.success(url);
	}

	/**
	 * 门诊收费汇总日报-门诊挂号收费汇总
	 *
	 * @param beginDay
	 * @param endDay
	 * @param jgName
	 * @return
	 */
	@RequestMapping("/mzghsfjchz")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "门诊收费汇总日报门诊挂号收费汇总", httpMethod = "POST", notes = "门诊收费汇总日报门诊挂号收费汇总")
	public ReturnEntity<String> mzghsfjchz(
			@ApiParam(name = "beginDay", value = "开始日期") @RequestParam(value = "beginDay") Date beginDay,
			@ApiParam(name = "endDay", value = "结束日期") @RequestParam(value = "endDay") Date endDay,
			@ApiParam(name = "ybxl", value = "医保线路 以逗号分割") @RequestParam(value = "ybxl") String ybxl,
			@ApiParam(name = "jgName", value = "机构名称") @RequestParam(value = "jgName") String jgName) {
		Map<String, Object> reportMap = ghrbReportSer.getMzghsfjchzParameters(beginDay, endDay,
				getUser().getHospitalId(), jgName, getUser().getUserName(), ybxl);
		List<Map<String, Object>> reportList = ghrbReportSer.getMzghsfjchzFields();
		String url = exportFileSer.reportHtml(reportList, reportMap, "mzghsfjchz.jasper");
		return ReturnEntityUtil.success(url);
	}

	/**
	 * 门诊收费汇总日报-现金分类明细表(现金)
	 *
	 * @param beginDay
	 * @param endDay
	 * @param ybxl
	 * @param jgName
	 * @return
	 */
	@RequestMapping("/xmflmxxjb")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "门诊收费汇总日报现金分类明细表(现金)", httpMethod = "POST", notes = "门诊收费汇总日报现金分类明细表(现金)")
	public ReturnEntity<String> xmflmxxjb(
			@ApiParam(name = "beginDay", value = "开始日期") @RequestParam(value = "beginDay") Date beginDay,
			@ApiParam(name = "endDay", value = "结束日期") @RequestParam(value = "endDay") Date endDay,
			@ApiParam(name = "ybxl", value = "医保线路 以逗号分割") @RequestParam(value = "ybxl") String ybxl,
			@ApiParam(name = "jgName", value = "机构名称") @RequestParam(value = "jgName") String jgName) {
		String url = exportFileSer.reportHtml(
				ghrbReportSer.getXmflmxxjbFields(beginDay, endDay, ybxl, getUser().getHospitalId()),
				ghrbReportSer.getXmflmxxjbParameters(beginDay, endDay, jgName, getUser().getUserName()),
				"xmflmxxjb.jasper");
		return ReturnEntityUtil.success(url);
	}

	/**
	 * 门诊收费汇总日报-门诊挂号收费汇总报表(未结账)
	 *
	 * @param ybxl
	 * @param jgName
	 * @return
	 */
	@RequestMapping("/mzghsfhzbwjz")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "门诊收费汇总日报门诊挂号收费汇总报表(未结账)", httpMethod = "POST", notes = "门诊收费汇总日报门诊挂号收费汇总报表(未结账)")
	public ReturnEntity<String> mzghsfhzbwjz(
			@ApiParam(name = "beginDay", value = "开始日期") @RequestParam(value = "beginDay") Date beginDay,
			@ApiParam(name = "endDay", value = "结束日期") @RequestParam(value = "endDay") Date endDay,
			@ApiParam(name = "ybxl", value = "医保线路 以逗号分割") @RequestParam(value = "ybxl") String ybxl,
			@ApiParam(name = "jgName", value = "机构名称") @RequestParam(value = "jgName") String jgName) {
		String url = exportFileSer.reportHtml(ghrbReportSer.getMzghsfhzbwjzFields(beginDay, endDay, ybxl),
				ghrbReportSer.getMzghsfhzbwjzParameters(jgName, getUser().getUserName()), "mzghsfhzbwjz.jasper");
		return ReturnEntityUtil.success(url);
	}

	/**
	 * 门诊收费汇总日报-其他应收明细表
	 *
	 * @param beginDay
	 * @param endDay
	 * @param ybxl
	 * @return
	 */
	@RequestMapping("/qtysmx")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "门诊收费汇总日报其他应收明细表", httpMethod = "POST", notes = "门诊收费汇总日报其他应收明细表")
	public ReturnEntity<String> qtysmx(
			@ApiParam(name = "beginDay", value = "开始日期") @RequestParam(value = "beginDay") Date beginDay,
			@ApiParam(name = "endDay", value = "结束日期") @RequestParam(value = "endDay") Date endDay,
			@ApiParam(name = "ybxl", value = "医保线路 以逗号分割") @RequestParam(value = "ybxl") String ybxl) {
		String url = exportFileSer.reportHtml(ghrbReportSer.getQtysmxFields(beginDay, endDay, ybxl),
				ghrbReportSer.getQtysmxParameters(beginDay, endDay, ybxl), "qtysmx.jasper");
		return ReturnEntityUtil.success(url);
	}

	/**
	 * 划价收费收费处人员工作量统计
	 *
	 * @param beginDay
	 * @param endDay
	 * @return
	 */
	@GetMapping("/sfcrygzltj")
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "划价收费收费处人员工作量统计", httpMethod = "GET", notes = "划价收费收费处人员工作量统计")
	public void sfcrygzltj(
			HttpServletResponse response,
			@ApiParam(name = "beginDay", value = "开始日期") @RequestParam(value = "beginDay") Date beginDay,
			@ApiParam(name = "endDay", value = "结束日期") @RequestParam(value = "endDay") Date endDay) {
		iReportExportFileSer.reportHtmlForStream(ghrbReportSer.getSfcrygzltjFields(beginDay, endDay),
				ghrbReportSer.getSfcrygzltjParameters(beginDay, endDay), "jrxml/sfcrygzltj.jasper", response);
	}

	/**
	 * 收费汇总-收费汇总报表产生
	 *
	 * @param beginDay
	 * @param endDay
	 * @param ybxl
	 * @param jgName
	 * @return
	 */
	@RequestMapping("/chargesFsbSummaryCs")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "收费汇总报表产生", httpMethod = "POST", notes = "收费汇总报表产生")
	public ReturnEntity<String> chargesFsbSummaryCs(
			@ApiParam(name = "beginDay", value = "开始日期") @RequestParam(value = "beginDay") Date beginDay,
			@ApiParam(name = "endDay", value = "结束日期") @RequestParam(value = "endDay") Date endDay,
			@ApiParam(name = "ybxl", value = "医保线路  以逗号分割") @RequestParam(value = "ybxl") String ybxl,
			@ApiParam(name = "jgName", value = "机构名称 ") @RequestParam(value = "jgName") String jgName) {
		Map<String, Object> reportMap = ghrbReportSer.getChargesFsbSummaryCsParameters(beginDay, endDay,
				getUser().getHospitalId(), jgName, getUser().getUserName(), ybxl);
		List<Map<String, Object>> reportList = ghrbReportSer.getChargesFsbSummaryCsFields();
		String url = exportFileSer.reportHtml(reportList, reportMap, "ChargesFsbSummary.jasper");
		return ReturnEntityUtil.success(url);
	}

	/**
	 * 收费汇总-收费汇总报表汇总
	 *
	 * @param hzrq
	 * @param ybxl
	 * @param jgName
	 * @return
	 */
	@RequestMapping("/chargesFsbSummaryHz")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "收费汇总报表汇总", httpMethod = "POST", notes = "收费汇总报表汇总")
	public ReturnEntity<String> chargesFsbSummaryHz(
			@ApiParam(name = "hzrq", value = "汇总日期") @RequestParam(value = "hzrq") String hzrq,
			@ApiParam(name = "ybxl", value = "医保线路  以逗号分割") @RequestParam(value = "ybxl") String ybxl,
			@ApiParam(name = "jgName", value = "机构名称 ") @RequestParam(value = "jgName") String jgName) {
		Map<String, Object> reportMap = ghrbReportSer.getChargesFsbSummaryHzParameters(hzrq, getUser().getHospitalId(),
				jgName, getUser().getUserName(), ybxl);
		List<Map<String, Object>> reportList = ghrbReportSer.getChargesFsbSummaryHzFields();
		String url = exportFileSer.reportHtml(reportList, reportMap, "ChargesFsbSummary.jasper");
		return ReturnEntityUtil.success(url);
	}

	/**
	 * 查询收费汇总
	 *
	 * @param beginDay
	 * @param endDay
	 * @param ybxl
	 * @return
	 */
	@RequestMapping("/doQuerySQLList")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "查询收费汇总", httpMethod = "POST", notes = "查询收费汇总")
	public ReturnEntity<List<SfrbResp>> doQuerySQLList(
			@ApiParam(name = "beginDay", value = "开始日期") @RequestParam(value = "beginDay") Date beginDay,
			@ApiParam(name = "endDay", value = "结束日期") @RequestParam(value = "endDay") Date endDay,
			@ApiParam(name = "ybxl", value = "医保线路  以逗号分割") @RequestParam(value = "ybxl") String ybxl) {
		List<SfrbResp> resp = ghrbReportSer.querySQLList(beginDay, endDay, getUser().getHospitalId(), ybxl);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 收费汇总-收费汇总查询确认
	 *
	 * @param hzrq
	 * @param ybxl
	 * @param jgName
	 * @return
	 */
	@RequestMapping("/chargesFsbSummaryQr")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "收费汇总查询确认", httpMethod = "POST", notes = "收费汇总查询确认")
	public ReturnEntity<String> chargesFsbSummaryQr(
			@ApiParam(name = "hzrq", value = "汇总日期") @RequestParam(value = "hzrq") String hzrq,
			@ApiParam(name = "ybxl", value = "医保线路  以逗号分割") @RequestParam(value = "ybxl") String ybxl,
			@ApiParam(name = "jgName", value = "机构名称 ") @RequestParam(value = "jgName") String jgName) {
		Map<String, Object> reportMap = ghrbReportSer.getChargesFsbSummaryQrParameters(hzrq, getUser().getHospitalId(),
				jgName, getUser().getUserName(), ybxl);
		List<Map<String, Object>> reportList = ghrbReportSer.getChargesFsbSummaryQrFields();
		String url = exportFileSer.reportHtml(reportList, reportMap, "ChargesFsbSummary.jasper");
		return ReturnEntityUtil.success(url);
	}

	/**
	 * 取消汇总查询
	 *
	 * @param ybxl
	 * @return
	 */
	@RequestMapping("/doQueryCancelHzCommit")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "取消汇总查询", httpMethod = "POST", notes = "取消汇总查询")
	public ReturnEntity<String> doQueryCancelHzCommit(
			@ApiParam(name = "ybxl", value = "医保线路  以逗号分割") @RequestParam(value = "ybxl") String ybxl) {
		String resp = ghrbReportSer.doQueryCancelHzCommit(getUser().getHospitalId(), ybxl);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 收费汇总产生前验证
	 *
	 * @param ybxl
	 * @return
	 */
	@RequestMapping("/doChargesSummaryBefVerification")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "收费汇总产生前验证", httpMethod = "POST", notes = "收费汇总产生前验证")
	public ReturnEntity<?> doChargesSummaryBefVerification(
			@ApiParam(name = "ybxl", value = "医保线路  以逗号分割") @RequestParam(value = "ybxl") String ybxl) {
		ghrbReportSer.doChargesSummaryBefVerification(getUser().getHospitalId(), ybxl);
		return ReturnEntityUtil.success();
	}

	/**
	 * 收费汇总前验证
	 *
	 * @param ybxl
	 * @param hzrq
	 * @return
	 */
	@RequestMapping("/doChargesSummaryCheckOutBefVerification")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "收费汇总前验证", httpMethod = "POST", notes = "收费汇总前验证")
	public ReturnEntity<?> doChargesSummaryCheckOutBefVerification(
			@ApiParam(name = "ybxl", value = "医保线路  以逗号分割") @RequestParam(value = "ybxl") String ybxl,
			@ApiParam(name = "hzrq", value = "汇总日期") @RequestParam(value = "hzrq") String hzrq) {
		ghrbReportSer.doChargesSummaryCheckOutBefVerification(hzrq, getUser().getHospitalId(), ybxl);
		return ReturnEntityUtil.success();
	}

	/**
	 * 取消汇总
	 *
	 * @param hzrq
	 * @param ybxl
	 * @return
	 */
	@RequestMapping("/cancelCommit")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "取消汇总", httpMethod = "POST", notes = "取消汇总")
	public ReturnEntity<?> cancelCommit(
			@ApiParam(name = "hzrq", value = "汇总日期") @RequestParam(value = "hzrq") String hzrq,
			@ApiParam(name = "ybxl", value = "医保线路  以逗号分割") @RequestParam(value = "ybxl") String ybxl) {
		ghrbReportSer.cancelCommit(hzrq, getUser().getHospitalId(), ybxl);
		return ReturnEntityUtil.success();
	}

	/**
	 * 收费汇总-收费汇总查询
	 *
	 * @param ksrqstr
	 * @param jsrqstr
	 * @param ybxl
	 * @param jgName
	 * @return
	 */
	@RequestMapping("/chargesSummarySearch")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "收费汇总查询", httpMethod = "POST", notes = "收费汇总查询")
	public ReturnEntity<String> chargesSummarySearch(
			@ApiParam(name = "ksrqstr", value = "开始日期") @RequestParam(value = "ksrqstr") String ksrqstr,
			@ApiParam(name = "jsrqstr", value = "结束日期") @RequestParam(value = "jsrqstr") String jsrqstr,
			@ApiParam(name = "ybxl", value = "医保线路  以逗号分割") @RequestParam(value = "ybxl") String ybxl,
			@ApiParam(name = "jgName", value = "机构名称 ") @RequestParam(value = "jgName") String jgName) {
		Map<String, Object> reportMap = ghrbReportSer.getChargesSummarySearchParameters(ksrqstr, jsrqstr,
				getUser().getHospitalId(), jgName, getUser().getUserName(), ybxl, getIpAddress());
		List<Map<String, Object>> reportList = ghrbReportSer.getChargesSummarySearchFields();
		String url = exportFileSer.reportHtml(reportList, reportMap, "ChargesSummarySearch.jasper");
		return ReturnEntityUtil.success(url);
	}

	/**
	 * 收费汇总-项目分类汇总
	 *
	 * @param beginDay
	 * @param endDay
	 * @param ybxl
	 * @param jgName
	 * @return
	 */
	@RequestMapping("/itemizeSummary")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "项目分类汇总", httpMethod = "POST", notes = "项目分类汇总")
	public ReturnEntity<String> itemizeSummary(
			@ApiParam(name = "beginDay", value = "开始日期") @RequestParam(value = "beginDay") Date beginDay,
			@ApiParam(name = "endDay", value = "结束日期") @RequestParam(value = "endDay") Date endDay,
			@ApiParam(name = "ybxl", value = "医保线路  以逗号分割") @RequestParam(value = "ybxl") String ybxl,
			@ApiParam(name = "jgName", value = "机构名称") @RequestParam(value = "jgName") String jgName) {
		Map<String, Object> reportMap = ghrbReportSer.getItemizeSummaryParameters(beginDay, endDay,
				getUser().getHospitalId(), jgName, getUser().getUserName(), ybxl);
		List<Map<String, Object>> reportList = ghrbReportSer.getItemizeSummaryFields(getUser().getHospitalId(),
				beginDay, endDay, ybxl);
		String url = exportFileSer.reportHtml(reportList, reportMap, "ItemizeSummary.jasper");
		return ReturnEntityUtil.success(url);
	}

	/**
	 * 收费汇总-未结账收费汇总
	 *
	 * @param ybxl
	 * @param jgName
	 * @return
	 */
	@RequestMapping("/outstandingChargesSummary")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "收费汇总未结账收费汇总", httpMethod = "POST", notes = "收费汇总未结账收费汇总")
	public ReturnEntity<String> outstandingChargesSummary(
			@ApiParam(name = "ybxl", value = "医保线路  以逗号分割") @RequestParam(value = "ybxl") String ybxl,
			@ApiParam(name = "jgName", value = "机构名称") @RequestParam(value = "jgName") String jgName) {
		Map<String, Object> reportMap = ghrbReportSer.getOutstandingChargesSummaryParameters(ybxl,
				getUser().getHospitalId(), getUser().getUserId(), getUser().getUserName(), jgName);
		List<Map<String, Object>> reportList = ghrbReportSer.getOutstandingChargesSummaryFields(ybxl,
				getUser().getHospitalId(), getUser().getUserId());
		String url = exportFileSer.reportHtml(reportList, reportMap, "OutstandingChargesSummary.jasper");
		return ReturnEntityUtil.success(url);
	}

}
