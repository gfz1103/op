
package com.buit.his.op.reg.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hutool.core.collection.CollUtil;
import com.buit.commons.BaseException;
import com.buit.constans.MqRoutingKeyCst;
import com.buit.mq.RabbitMqProducer;
import org.apache.curator.shaded.com.google.common.collect.ImmutableMap;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.commons.model.OpMzxx;
import com.buit.commons.request.ChangeZfblReq;
import com.buit.commons.request.CheckIsAxktc;
import com.buit.commons.request.DiscountInfoReq;
import com.buit.commons.request.DrugsTypkReq;
import com.buit.commons.request.FpzfListReq;
import com.buit.commons.request.JsCheckInventoryReq;
import com.buit.commons.request.LoadMedcineSetReq;
import com.buit.commons.request.MsQryDjReq;
import com.buit.commons.request.OutpatientSettlementReq;
import com.buit.commons.request.PrintMzxxReq;
import com.buit.commons.request.QueryFphmReq;
import com.buit.commons.request.QueryMaterialsPriceReq;
import com.buit.commons.request.QueryPaymentReq;
import com.buit.commons.request.QueryTfPaymentReq;
import com.buit.commons.request.SaveCopyFphmReq;
import com.buit.commons.request.SaveRefundSettleReq;
import com.buit.commons.request.SaveRetireRegistReq;
import com.buit.commons.request.SelectfujmbrReq;
import com.buit.commons.request.UpdateVoidInvoiceReq;
import com.buit.commons.response.AxktcResp;
import com.buit.commons.response.CfInfoResp;
import com.buit.commons.response.FindKsdmByYsdmResp;
import com.buit.commons.response.GetYfkInfoResp;
import com.buit.commons.response.JsCheckInventoryResp;
import com.buit.commons.response.LoadMedcineSetResp;
import com.buit.commons.response.LoadProjectSetResp;
import com.buit.commons.response.MsQueryDjResp;
import com.buit.commons.response.OpZt01Resp;
import com.buit.commons.response.PrintMzxxResp;
import com.buit.commons.response.QueryDjDetailResp;
import com.buit.commons.response.QueryFphmResp;
import com.buit.commons.response.QueryGhmxResp;
import com.buit.commons.response.QueryPaymentResp;
import com.buit.commons.response.QueryTf01Resp;
import com.buit.commons.response.QueryTfFphmResp;
import com.buit.commons.response.QueryTfPaymentResp;
import com.buit.commons.response.QueryVoidInvoiceResp;
import com.buit.commons.response.SaveRefundSettleResp;
import com.buit.commons.response.SelectfujmbrResp;
import com.buit.commons.response.ZfQueryFphmResp;
import com.buit.commons.response.ZzghksResp;
import com.buit.his.op.reg.service.OpMzxxSer;
import com.buit.system.response.QueryJsJcResp;
import com.buit.system.service.FeeYlsfxmdjService;
import com.buit.system.service.SysXtcsCacheSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 门诊收费结算<br>
 * 
 * @author WY
 */
@Api(tags = "门诊收费结算")
@Controller
@RequestMapping("/opmzxx")
public class OpMzxxCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(OpMzxxCtr.class);

	@Autowired
	private OpMzxxSer opMzxxSer;

	@DubboReference
	private SysXtcsCacheSer sysXtcsCacheSer;
	
	@DubboReference
	private FeeYlsfxmdjService feeYlsfxmdjService;
	@Autowired
	RabbitMqProducer rabbitMqProducer;

	/**
	 * 单据查询
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doQueryDj")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "单据查询", httpMethod = "POST", notes = "单据查询")
	public ReturnEntity<MsQueryDjResp> doQueryDj(@RequestBody MsQryDjReq req) {
		req.setJgid(getUser().getHospitalId());
		MsQueryDjResp resp = opMzxxSer.doQueryDj(req);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 根据病人性质查询上级性质
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/querySjBrxz")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "根据病人性质查询上级性质", httpMethod = "POST", notes = "根据病人性质查询上级性质")
	public ReturnEntity<Integer> querySjBrxz(
			@ApiParam(name = "brxz", value = "病人性质", required = true) @RequestParam(value = "brxz") Integer brxz) {
		return ReturnEntityUtil.success(opMzxxSer.querySjBrxz(brxz));
	}

	/**
	 * 大病科室查询单据查询
	 *
	 * @param req
	 * @return
	 */
//	@RequestMapping("/doQueryDbybks")
//	@ResponseBody
//	@ApiOperationSupport(author = "汪洋")
//	@ApiOperation(value = "诊间单据查询", httpMethod = "POST", notes = "诊间单据查询")
//	public ReturnEntity<List<Integer>> doQueryDbybks() {
//		List<Integer> list = opMzxxSer.doQueryDbybks();
//		return ReturnEntityUtil.success(list);
//	}

	/**
	 * 根据医生工号查找对应的挂号科室
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doFindKsdmByYsdm")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "根据医生工号查找对应的挂号科室", httpMethod = "POST", notes = "根据医生工号查找对应的挂号科室")
	public ReturnEntity<FindKsdmByYsdmResp> doFindKsdmByYsdm() {
		FindKsdmByYsdmResp resp = opMzxxSer.doFindKsdmByYsdm(getUser().getUserId());
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 根据病人性质改变自负比例
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doChangeZfbl")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "根据病人性质改变自负比例", httpMethod = "POST", notes = "根据病人性质改变自负比例")
	public ReturnEntity<?> doChangeZfbl(@RequestBody ChangeZfblReq req) {
		opMzxxSer.doChangeZfbl(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 单据明细查询
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doQueryDjDetails")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "单据明细查询", httpMethod = "POST", notes = "单据明细查询")
	public ReturnEntity<List<QueryDjDetailResp>> doQueryDjDetails(@RequestBody ChangeZfblReq req) {
		req.setJgid(getUser().getHospitalId());
		List<QueryDjDetailResp> resp = opMzxxSer.doQueryDjDetails(req);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 验证病区是否开启物品计费标志 并判断是否存在二级库房
	 *
	 * @param req
	 * @return
	 */
//	@RequestMapping("/doVerificationWpjfbz")
//	@ResponseBody
//	@ApiOperationSupport(author = "汪洋")
//	@ApiOperation(value = "验证病区是否开启物品计费标志 并判断是否存在二级库房", httpMethod = "POST", notes = "单验证病区是否开启物品计费标志 并判断是否存在二级库房")
//	public ReturnEntity<?> doVerificationWpjfbz(ValidWpjfbzReq req) {
//		req.setJgid(getUser().getUserId());
//		opMzxxSer.doVerificationWpjfbz(req);
//		return ReturnEntityUtil.success();
//	}

	/**
	 * 查询获得与这台计算机医保IP绑定的机构ID
	 *
	 * @return
	 */
	@RequestMapping("/doLoadThisComputerYBArgs")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "查询获得与这台计算机医保IP绑定的机构ID", httpMethod = "POST", notes = "查询获得与这台计算机医保IP绑定的机构ID")
	public ReturnEntity<String> doLoadThisComputerYbArgs() {
		String ybjgid = opMzxxSer.doLoadThisComputerYbArgs(getUser().getHospitalId(), getIpAddress());
		return ReturnEntityUtil.success(ybjgid);
	}

	/**
	 * 结算信息查询
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doQueryPayment")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "结算信息查询", httpMethod = "POST", notes = "结算信息查询")
	public ReturnEntity<QueryPaymentResp> doQueryPayment(@RequestBody QueryPaymentReq req) {
		req.setJgid(getUser().getHospitalId());
		req.setYgdm(getUser().getUserId());
		req.setYgxm(getUser().getUserName());
		req.setIp(getIpAddress());
		QueryPaymentResp resp = opMzxxSer.doQueryPayment(req);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 检查是否是爱心卡
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doCheckIsAxktc")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "检查是否是爱心卡", httpMethod = "POST", notes = "检查是否是爱心卡")
	public ReturnEntity<AxktcResp> doCheckIsAxktc(CheckIsAxktc req) {
		AxktcResp resp = opMzxxSer.doCheckIsAxktc(req);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 查看妇幼减免病人
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doSelectfujmbr")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "查看妇幼减免病人", httpMethod = "POST", notes = "查看妇幼减免病人")
	public ReturnEntity<SelectfujmbrResp> doSelectfujmbr(SelectfujmbrReq req) {
		req.setJgid(getUser().getHospitalId());
		req.setYgdm(getUser().getUserId());
		SelectfujmbrResp resp = opMzxxSer.doSelectfujmbr(req);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 得到自助挂号科室
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doGetZzghks")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "得到自助挂号科室", httpMethod = "POST", notes = "得到自助挂号科室")
	public ReturnEntity<List<ZzghksResp>> doGetZzghks(
			@ApiParam(name = "jzkh", value = "就诊卡号", required = true) @RequestParam(value = "jzkh") String jzkh) {
		List<ZzghksResp> resp = opMzxxSer.doGetZzghks(jzkh, getUser().getHospitalId());
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 保存折扣信息到OP_CF02和OP_YJCF02
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doSaveDiscountInfo")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "保存折扣信息到OP_CF02和OP_YJCF02", httpMethod = "POST", notes = "保存折扣信息到OP_CF02和OP_YJCF02")
	public ReturnEntity<?> doSaveDiscountInfo(@RequestBody DiscountInfoReq req) {
		opMzxxSer.doSaveDiscountInfo(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 门诊结算
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doSaveOutpatientSettlement")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "门诊结算", httpMethod = "POST", notes = "门诊结算")
	public ReturnEntity<?> doSaveOutpatientSettlement(@RequestBody OutpatientSettlementReq req) {
		req.setJgid(getUser().getHospitalId());
		req.setYgdm(getUser().getUserId());
		req.setYgxm(getUser().getUserName());
		req.setIp(getIpAddress());
		opMzxxSer.doSaveOutpatientSettlement(req);
		req.getList().stream()
				.filter(r->r.getCflx()==1||r.getCflx()==2||r.getCflx()==3)
				.forEach(r->
						rabbitMqProducer.send(MqRoutingKeyCst.drugsAutoPrintList, ImmutableMap.of("consumerType", "autoPrintListConsumer", "payload", Collections.singletonMap("cfsb", r.getCfsb())))
				);
		return ReturnEntityUtil.success();
	}

	/**
	 * 获取发票号
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doGetNotesNumber")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "获取发票号", httpMethod = "POST", notes = "获取发票号")
	public ReturnEntity<String> doGetNotesNumber() {
		String fphm = opMzxxSer.doGetNotesNumber(getUser().getUserId(), getUser().getHospitalId(), 2);
		return ReturnEntityUtil.success(fphm);
	}

	/**
	 * 收费病人查询
	 *
	 * @param req
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/doQueryGhmx")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "收费病人查询", httpMethod = "POST", notes = "收费病人查询")
	public ReturnEntity<QueryGhmxResp> doQueryGhmx() throws ParseException {
		QueryGhmxResp resp = opMzxxSer.doQueryGhmx(getUser().getHospitalId());
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 预付卡支付信息返回
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doGetYfkInfoByFphm")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "预付卡支付信息返回", httpMethod = "POST", notes = "预付卡支付信息返回")
	public ReturnEntity<GetYfkInfoResp> doGetYfkInfoByFphm(
			@ApiParam(name = "fphm", value = "发票号码", required = true) @RequestParam(value = "fphm") String fphm) {
		GetYfkInfoResp resp = opMzxxSer.doGetYfkInfoByFphm(fphm);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 分页条件查询可以作废/可退款的列表
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/getFpzfList")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "分页条件查询可以作废或退款的列表", httpMethod = "POST", notes = "分页条件查询可以作废或退款的列表")
	public ReturnEntity<PageInfo<OpMzxx>> getFpzfList(FpzfListReq req, PageQuery page) {
		PageInfo<OpMzxx> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> opMzxxSer.getFpzfList(req));
		return ReturnEntityUtil.success(pageInfo);
	}

	/**
	 * 获取已作废发票列表分页
	 *
	 * @param page
	 * @return
	 */
	@RequestMapping("/doQueryVoidInvoice")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "获取已作废发票列表分页", httpMethod = "POST", notes = "获取已作废发票列表分页")
	public ReturnEntity<PageInfo<QueryVoidInvoiceResp>> doQueryVoidInvoice(PageQuery page) {
		PageInfo<QueryVoidInvoiceResp> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> opMzxxSer.doQueryVoidInvoice(getUser().getHospitalId(), getUser().getUserId()));
		return ReturnEntityUtil.success(pageInfo);
	}

	/**
	 * 发票作废 发票查询
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doQueryFphm")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "发票作废 发票查询", httpMethod = "POST", notes = "发票作废 发票查询")
	public ReturnEntity<ZfQueryFphmResp> doQueryFphm(
			@ApiParam(name = "fphm", value = "发票号码", required = true) @RequestParam(value = "fphm") String fphm) {
		ZfQueryFphmResp resp = opMzxxSer.doQueryFphm(fphm, getUser().getHospitalId());
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 发票作废
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doUpdateVoidInvoice")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "发票作废", httpMethod = "POST", notes = "发票作废")
	public ReturnEntity<?> doUpdateVoidInvoice(UpdateVoidInvoiceReq req) {
		req.setJgid(getUser().getHospitalId());
		req.setYgdm(getUser().getUserId());
		req.setYgxm(getUser().getUserName());
		req.setIp(getIpAddress());
		opMzxxSer.doUpdateVoidInvoice(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 取消发票作废
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doUpdateCanceledVoidInvoice")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "取消发票作废", httpMethod = "POST", notes = "取消发票作废")
	public ReturnEntity<?> doUpdateCanceledVoidInvoice(
			@ApiParam(name = "fphm", value = "发票号码", required = true) @RequestParam(value = "fphm") String fphm) {
		opMzxxSer.doUpdateCanceledVoidInvoice(fphm, getUser().getHospitalId());
		return ReturnEntityUtil.success();
	}

	/**
	 * 复制发票号
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/saveCopyFphm")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "复制发票号", httpMethod = "POST", notes = "复制发票号")
	public ReturnEntity<List<CfInfoResp>> saveCopyFphm(@RequestBody SaveCopyFphmReq req) {
		req.setJgid(getUser().getHospitalId());
		List<CfInfoResp> resp = opMzxxSer.saveCopyFphm(req);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 修改发票号
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doUpdateNotesNumber")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "修改发票号", httpMethod = "POST", notes = "修改发票号")
	public ReturnEntity<String> doUpdateNotesNumber(
			@ApiParam(name = "fphm", value = "发票号码", required = true) @RequestParam(value = "fphm") String fphm) {
		String syhm = opMzxxSer.doUpdateNotesNumber(fphm, getUser().getHospitalId(), getUser().getUserId(), 2);
		return ReturnEntityUtil.success(syhm);
	}

	/**
	 * 退费处理 根据卡号或者发票号码查询退费信息
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doQueryTFFphm")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "退费处理 根据发票号码查询退费信息", httpMethod = "POST", notes = "退费处理 根据卡号或者发票号码查询退费信息 ")
	public ReturnEntity<QueryTfFphmResp> doQueryTfFphm(
			@ApiParam(name = "fphm", value = "发票号码", required = true) @RequestParam(value = "fphm") String fphm) {
		QueryTfFphmResp resp = opMzxxSer.doQueryTfFphm(fphm, getUser().getHospitalId(), getUser().getUserId());
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 退费处理 主表查询 右上信息
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doQueryTF01")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "退费处理 主表查询 右上信息", httpMethod = "POST", notes = "退费处理 主表查询  右上信息")
	public ReturnEntity<List<QueryTf01Resp>> doQueryTf01(
			@ApiParam(name = "fphm", value = "发票号码", required = true) @RequestParam(value = "fphm") String fphm) {
		List<QueryTf01Resp> resp = opMzxxSer.doQueryTf01(fphm, getUser().getHospitalId());
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 退费结算计算
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doQueryTFPayment")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "退费结算计算", httpMethod = "POST", notes = "退费结算计算")
	public ReturnEntity<QueryTfPaymentResp> doQueryTfPayment(@RequestBody QueryTfPaymentReq req) {
		req.setJgid(getUser().getHospitalId());
		req.setYgdm(getUser().getUserId());
		QueryTfPaymentResp resp = opMzxxSer.doQueryTfPayment(req);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 退费结算处理
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doSaveRefundSettle")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "退费结算处理", httpMethod = "POST", notes = "退费结算处理")
	public ReturnEntity<SaveRefundSettleResp> doSaveRefundSettle(@RequestBody SaveRefundSettleReq req) {
		req.setJgid(getUser().getHospitalId());
		req.setYgdm(getUser().getUserId());
		req.setYgxm(getUser().getUserName());
		req.setIp(getIpAddress());
		SaveRefundSettleResp resp = opMzxxSer.doSaveRefundSettle(req);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 退号
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doSaveRetireRegistered")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "退号", httpMethod = "POST", notes = "退号")
	public ReturnEntity<?> doSaveRetireRegistered(SaveRetireRegistReq req) {
		req.setJgid(getUser().getHospitalId());
		req.setYgdm(getUser().getUserId());
		req.setYgxm(getUser().getUserName());
		req.setIp(getIpAddress());
		opMzxxSer.doSaveRetireRegistered(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 校验库存信息
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doCheckInventory")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "校验库存信息", httpMethod = "POST", notes = "校验库存信息")
	public ReturnEntity<JsCheckInventoryResp> doCheckInventory(JsCheckInventoryReq req) {
		JsCheckInventoryResp resp = opMzxxSer.doCheckInventory(req, getUser().getHospitalId());
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 处方组套-获取药品组套明细
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doLoadMedcineSet")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "处方组套获取药品组套明细", httpMethod = "POST", notes = "获取药品组套明细")
	public ReturnEntity<List<LoadMedcineSetResp>> doLoadMedcineSet(LoadMedcineSetReq req) {
		req.setJgid(getUser().getHospitalId());
		List<LoadMedcineSetResp> resp = opMzxxSer.doLoadMedcineSet(req);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 预保存
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doSaveSettle")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "预保存", httpMethod = "POST", notes = "预保存")
	public ReturnEntity<?> doSaveSettle(@RequestBody OutpatientSettlementReq req) {
		req.setJgid(getUser().getHospitalId());
		req.setYgdm(getUser().getUserId());
		opMzxxSer.saveSettle(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 处置组套-获取项目组套明细
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doLoadProjectSet")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "处置组套获取项目组套明细", httpMethod = "POST", notes = "处置组套获取项目组套明细")
	public ReturnEntity<List<LoadProjectSetResp>> doLoadProjectSet(LoadMedcineSetReq req) {
		req.setJgid(getUser().getHospitalId());
		List<LoadProjectSetResp> resp = opMzxxSer.doLoadProjectSet(req);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 划价收费获取物资价格
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doQueryMaterialsPrice")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "划价收费获取物资价格", httpMethod = "POST", notes = "划价收费获取物资价格")
	public ReturnEntity<BigDecimal> doQueryMaterialsPrice(QueryMaterialsPriceReq req) {
		req.setJgid(getUser().getHospitalId());
		BigDecimal resp = opMzxxSer.doQueryMaterialsPrice(req);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 收费结算组套查询
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doQueryJcZtInfo")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "收费结算组套查询", notes = "收费结算组套查询", httpMethod = "POST")
	public ReturnEntity<PageInfo<OpZt01Resp>> doQueryJcZtInfo(DrugsTypkReq req, PageQuery page) {
		req.setJgid(getUser().getHospitalId());
		PageInfo<OpZt01Resp> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> opMzxxSer.getEntityMapper().doQueryJcZtInfo(req));
		return ReturnEntityUtil.success(pageInfo);
	}

	/**
	 * 退费和发票作废病人信息分页查询
	 *
	 * @param fphm
	 * @param page
	 * @return
	 */
	@RequestMapping("/doQueryMzxxFpxx")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "退费和发票作废病人信息分页查询", notes = "退费和发票作废病人信息分页查询", httpMethod = "POST")
	public ReturnEntity<PageInfo<OpMzxx>> doQueryMzxxFpxx(
			@ApiParam(name = "fphm", value = "发票号码", required = true) @RequestParam(value = "fphm") String fphm,
			PageQuery page) {
		PageInfo<OpMzxx> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> opMzxxSer.getEntityMapper().doQueryMzxxFpxx(fphm, getUser().getHospitalId()));
		return ReturnEntityUtil.success(pageInfo);
	}

	/**
	 * 门诊结算发票打印
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doPrintMoth")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "门诊结算发票打印", httpMethod = "POST", notes = "门诊结算发票打印")
	public ReturnEntity<PrintMzxxResp> doPrintMoth(PrintMzxxReq req) {
		req.setJgid(getUser().getHospitalId());
		PrintMzxxResp resp = opMzxxSer.doPrintMoth(req);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 门诊结算发票重打
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doPrintMothNext")
	@ResponseBody
	@ApiOperationSupport(author = "tian")
	@ApiOperation(value = "门诊结算发票重打", httpMethod = "POST", notes = "门诊结算发票重打")
	public ReturnEntity<PrintMzxxResp> doPrintMothNext(PrintMzxxReq req) {
		req.setJgid(getUser().getHospitalId());
		PrintMzxxResp resp = opMzxxSer.doPrintMothNext(req, getUser().getUserId());
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 发票查询
	 *
	 * @param req
	 * @param page
	 * @return
	 */
	@RequestMapping("/doQueryReceivablesInvoice")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "发票查询", httpMethod = "POST", notes = "发票查询")
	public ReturnEntity<PageInfo<QueryFphmResp>> doQueryReceivablesInvoice(QueryFphmReq req, PageQuery page) {
		req.setJgid(getUser().getHospitalId());
		String klx = sysXtcsCacheSer.getCsz(req.getJgid(), "KLX");
		req.setCardTypeCode(klx);
		PageInfo<QueryFphmResp> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> opMzxxSer.doQueryReceivablesInvoice(req));
		return ReturnEntityUtil.success(pageInfo);
	}
	
	/**
	 * 检验 输入法查询 -挂号收费专用
	 * 
	 * @param pydm
	 * @param page
	 * @return
	 */
	@RequestMapping("/doQueryJsjc")
	@ResponseBody
	@ApiOperation(value = "检验 输入法查询 挂号收费专用", httpMethod = "POST")
	public ReturnEntity<PageInfo<QueryJsJcResp>> doQueryJsjc(
			@ApiParam(name = "pydm", value = "拼音代码", required = true) @RequestParam String pydm, PageQuery page) {
		Map<String, Object> par = new HashMap<>(16);
		par.put("pydm", pydm);
		par.put("jgid", getUser().getHospitalId());
		PageInfo<QueryJsJcResp> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> opMzxxSer.doQueryJsjc(par));
		return ReturnEntityUtil.success(pageInfo);
	}


	//TODO 打印真实发票


	// TODO 单表查询
//	/**
//	 * 隔夜退费列表查询
//	 *
//	 * @param req
//	 * @return
//	 */
//	@RequestMapping("/saveCopyFphm")
//	@ResponseBody
//	@ApiOperationSupport(author = "汪洋")
//	@ApiOperation(value = "隔夜退费列表查询", httpMethod = "POST", notes = "隔夜退费列表查询")
//	public ReturnEntity<List<CfInfoResp>> saveCopyFphm(SaveCopyFphmReq req) {
//		req.setJgid(getUser().getHospitalId());
//		List<CfInfoResp> resp = opMzxxSer.saveCopyFphm(req);
//		return ReturnEntityUtil.success(resp);
//	}

//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<OpMzxxResp>> queryPage(OpMzxxReq opmzxx,PageQuery page){
//        PageInfo<OpMzxx> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> opMzxxSer.findByEntity(opmzxx)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<OpMzxxResp>> getByEntity( OpMzxxReq opmzxx){//@RequestBody
//        return ReturnEntityUtil.success(opMzxxSer.findByEntity(opmzxx));
//    }
//
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<OpMzxxResp> getOneByEntity(OpMzxxReq opmzxx){
//        List<OpMzxx> list=opMzxxSer.findByEntity(opmzxx);
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
//    public ReturnEntity<OpMzxxResp> add(OpMzxxReq opMzxx) {
//        opMzxxSer.insert(opMzxx);
//        return ReturnEntityUtil.success(opMzxx);
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<OpMzxxResp> edit(OpMzxxReq opMzxx)  {
//        opMzxxSer.update(opMzxx);
//        return ReturnEntityUtil.success(opMzxx);
//    }
//
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<OpMzxxResp> delete(OpMzxxReq opMzxx) {
//        opMzxxSer.removeByEntity(opMzxx);
//        return ReturnEntityUtil.success(opMzxx);
//    }

}
