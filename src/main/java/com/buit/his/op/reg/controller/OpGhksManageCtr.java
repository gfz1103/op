
package com.buit.his.op.reg.controller;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import com.buit.commons.response.*;
import com.buit.his.shyb.source.entity.SJG1;
import com.buit.his.shyb.source.entity.SM01Res;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseException;
import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.commons.model.MpiBrdaInfo;
import com.buit.commons.model.OpGhks;
import com.buit.commons.model.OpGhmxInfo;
import com.buit.commons.request.MpiBrdaAndCardAddReq;
import com.buit.commons.request.MsCommitTurnDeptReq;
import com.buit.commons.request.MsQryGhdjReq;
import com.buit.commons.request.MsQryPersonReq;
import com.buit.commons.request.MsQryRegisterReq;
import com.buit.commons.request.MsRegisterAddReq;
import com.buit.commons.request.MsRegisterReq;
import com.buit.commons.request.OpGhksListReq;
import com.buit.commons.request.PrintGhxxReq;
import com.buit.commons.request.QueryRegisteredReq;
import com.buit.ecis.pretriage.response.YjfzBrdaResp;
import com.buit.his.op.reg.enums.MpiCardEnum;
import com.buit.his.op.reg.service.OpGhksSer;
import com.buit.his.op.reg.service.PubJmbrSer;
import com.buit.op.response.MpiBrda;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 挂号管理<br>
 * 
 * @author WY
 */
@Api(tags = "挂号管理")
@Controller
@RequestMapping("/opghksManage")
public class OpGhksManageCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(OpGhksManageCtr.class);

	@Autowired
	private OpGhksSer opGhksSer;

	@Autowired
	private PubJmbrSer pubJmbrSer;

	/**
	 * 初始化挂号管理
	 * 
	 * @return
	 */
	@RequestMapping("/doUpdateDoctorNumbers")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "初始化挂号管理", httpMethod = "POST", notes = "初始化挂号管理,判断票据号是否设置，判断是否排班，初始化挂号科室信息")
	public ReturnEntity<MsInitGhksResp> initGhksInfo() {
		MsInitGhksResp resp = opGhksSer.initGhksInfo(getUser().getHospitalId(), getUser().getUserId());
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 排班科室查询
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doQuerySchedulingDepartment")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "排班科室查询", httpMethod = "POST", notes = "排班科室查询")
	public ReturnEntity<List<OpGhks>> getGhksList(OpGhksListReq req) {
		req.setJgid(getUser().getHospitalId());
		req.setIp(getIpAddress());
		req.setInternet("0");
		return ReturnEntityUtil.success(opGhksSer.getGhksList(req));
	}

	/**
	 * 挂号根据卡号查询病人信息
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doQueryPerson")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "挂号管理根据卡号查询病人信息", httpMethod = "POST", notes = "挂号管理根据卡号查询病人信息")
	public ReturnEntity<MpiBrdaInfo> doQueryPerson(MsQryPersonReq req) {
		req.setJgid(getUser().getHospitalId());
		req.setYgdm(getUser().getUserId());
		return ReturnEntityUtil.success(opGhksSer.doQueryPerson(req,getIpAddress()));
	}

	/**
	 * 挂号单据查询
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doQueryGhdj")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "挂号单据查询", httpMethod = "POST", notes = "挂号单据查询")
	public ReturnEntity<List<OpGhmxInfo>> doQueryGhdj(MsQryGhdjReq req) {
		req.setJgid(getUser().getHospitalId());
		return ReturnEntityUtil.success(opGhksSer.doQueryGhdj(req));
	}

//	/**
//	 * 退号
//	 * 
//	 * @param req
//	 * @return
//	 */
//	@RequestMapping("/doSaveRetireRegistered")
//	@ResponseBody
//	@ApiOperationSupport(author = "汪洋")
//	@ApiOperation(value = "退号", httpMethod = "POST", notes = "退号")
//	public ReturnEntity<?> doCancelRegister(MsCancelRegisterReq req) {
//		req.setJgid(getUser().getHospitalId());
//		req.setYgdm(getUser().getUserId());
//		req.setIp(getIpAddress());
//		opGhksSer.doCancelRegister(req);
//		return ReturnEntityUtil.success();
//	}

	/**
	 * 查询当日是否在选择的科室挂号
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doCheckGhks")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "查询当日是否在选择的科室挂号", httpMethod = "POST", notes = "查询当日是否在选择的科室挂号")
	public ReturnEntity<?> doCheckGhks(MsRegisterReq req) {
		req.setJgid(getUser().getHospitalId());
		opGhksSer.doCheckGhks(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 查询当日专家门诊是否排班
	 * 
	 * @param ksdm
	 * @return
	 */
	@RequestMapping("/doCheckZjmzpb")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "查询当日专家门诊是否排班", httpMethod = "POST", notes = "查询当日专家门诊是否排班")
	public ReturnEntity<?> doCheckZjmzpb(
			@ApiParam(name = "ksdm", value = "科室代码", required = true) @RequestParam(value = "ksdm") Integer ksdm) {
		opGhksSer.doCheckZjmzpb(ksdm);
		return ReturnEntityUtil.success();
	}

	/**
	 * 查询排班医生
	 * 
	 * @param ksdm
	 * @return
	 */
	@RequestMapping("/doQuerySchedulingDoctor")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "查询排班医生", httpMethod = "POST", notes = "查询排班医生")
	public ReturnEntity<List<MsGhYspbResp>> doQuerySchedulingDoctor(
			@ApiParam(name = "ksdm", value = "科室代码") @RequestParam(value = "ksdm", required = false) Integer ksdm) {
		List<MsGhYspbResp> resp = opGhksSer.doQuerySchedulingDoctor(ksdm, getUser().getHospitalId());
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 挂号结算查询
	 * 
	 * @param ksdm
	 * @return
	 */
	@RequestMapping("/doQueryRegisteredSettlement")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "挂号结算查询", httpMethod = "POST", notes = "挂号结算查询")
	public ReturnEntity<MsQryRegisterResp> doQueryRegistSettle(MsQryRegisterReq req) {
		req.setJgid(getUser().getHospitalId());
		req.setYgdm(getUser().getUserId());
		req.setYgxm(getUser().getUserName());
		return ReturnEntityUtil.success(opGhksSer.doQueryRegistSettle(req,getIpAddress()));
	}

	/**
	 * 挂号
	 * 
	 * @param req
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/doSaveRegisteredManagement")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "挂号", httpMethod = "POST", notes = "挂号")
	public ReturnEntity<MsRegisterResp> doSaveRegisteredManagement(@RequestBody MsRegisterAddReq req)
			throws ParseException {
		req.setJgid(getUser().getHospitalId());
		req.setIp(getIpAddress());
		req.setYgdm(getUser().getUserId());
		req.setYgxm(getUser().getUserName());
		MsRegisterResp resp = opGhksSer.doSaveRegisteredManagement(req, false);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 转科卡号查询可以转科的挂号单
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doQueryTurnDept")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "根据卡号查询可以转科的挂号单", httpMethod = "POST", notes = "根据卡号查询可以转科的挂号单")
	public ReturnEntity<List<MsQryTurnDeptResp>> doQueryTurnDept(
			@ApiParam(name = "jzkh", value = "就诊卡号") @RequestParam(value = "jzkh") String jzkh) {
		return ReturnEntityUtil.success(opGhksSer.doQueryTurnDept(jzkh, getUser().getHospitalId()));
	}

	/**
	 * 查询科室费用
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doCheckKSFY")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "查询科室费用", httpMethod = "POST", notes = "查询科室费用")
	public ReturnEntity<CheckKsfyResp> doCheckKSFY(
			@ApiParam(name = "ksdm", value = "科室代码") @RequestParam(value = "ksdm") Integer ksdm) {
		CheckKsfyResp resp = opGhksSer.doCheckKSFY(ksdm, getUser().getHospitalId());
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 转科确认
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doCommitTurnDept")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "转科确认", httpMethod = "POST", notes = "转科确认")
	public ReturnEntity<?> doCommitTurnDept(MsCommitTurnDeptReq req) {
		req.setJgid(getUser().getHospitalId());
		req.setYgdm(getUser().getUserId());
		opGhksSer.doCommitTurnDept(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 建档：获取门诊号码
	 * 
	 * @return
	 */
	@RequestMapping("/doQueryMzhm")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "建档获取门诊号码", httpMethod = "POST", notes = "建档：获取门诊号码")
	public ReturnEntity<String> doQueryMzhm() {
		return ReturnEntityUtil.success(opGhksSer.doQueryMzhm(getUser().getHospitalId(), getUser().getUserId()));
	}

	/**
	 * 建档根据卡号查询档案信息
	 * 
	 * @param jzkh
	 * @return
	 */
	@RequestMapping("/doQueryPersonByCardno")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "建档根据卡号查询档案信息", httpMethod = "POST", notes = "建档根据卡号查询档案信息")
	public ReturnEntity<MpiBrdaAndCardResp> doQueryPersonByCardno(
			@ApiParam(name = "jzkh", value = "就诊卡号") @RequestParam(value = "jzkh") String jzkh) {
		MpiBrdaAndCardResp resp = opGhksSer.doQueryPersonByCardno(jzkh);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 根据身份证号码查询档案信息
	 * 
	 * @param zjlx
	 * @param idCard
	 * @return
	 */
	@RequestMapping("/doQueryPersonByIdcard")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "根据身份证号码查询档案信息", httpMethod = "POST", notes = "根据身份证号码查询档案信息")
	public ReturnEntity<MpiBrdaAndCardResp> doQueryPersonByIdcard(
			@ApiParam(name = "zjlx", value = "证件类型") @RequestParam(value = "zjlx", required = false) String zjlx,
			@ApiParam(name = "idCard", value = "身份证号码") @RequestParam(value = "idCard") String idCard) {
		MpiBrdaAndCardResp resp = opGhksSer.doQueryPersonByIdcard(zjlx, idCard);
		return ReturnEntityUtil.success(resp);
	}


	/**
	 * 根据姓名查询档案信息
	 *
	 * @param name 姓名
	 * @param csny 出生日期
	 * @param brxb 病人性别
	 * @return
	 */
	@RequestMapping("/doQueryPersonByName")
	@ResponseBody
	@ApiOperationSupport(author = "tian")
	@ApiOperation(value = "根据姓名查询档案信息", httpMethod = "POST", notes = "根据姓名查询档案信息")
	public ReturnEntity<List<MpiBrdaAndCardResp>> doQueryPersonByName(
			@ApiParam(name = "name", value = "姓名", required = true) @RequestParam(value = "name") String name,
			@ApiParam(name = "csny", value = "出生日期", required = true) @RequestParam(value = "csny") Date csny,
			@ApiParam(name = "brxb", value = "病人性别", required = true) @RequestParam(value = "brxb") Integer brxb) {
		List<MpiBrdaAndCardResp> mpiBrdaAndCardRespList = opGhksSer.doQueryPersonByName(name, csny, brxb);
		return ReturnEntityUtil.success(mpiBrdaAndCardRespList);
	}

	/**
	 * 建档新增个人基本信息和卡信息
	 * 
	 * @param zjlx
	 * @param idCard
	 * @return
	 */
	@RequestMapping("/doAddPerson")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "建档新增个人基本信息和卡信息", httpMethod = "POST", notes = "建档新增个人基本信息和卡信息")
	public ReturnEntity<MpiBrda> doAddPerson(@RequestBody MpiBrdaAndCardAddReq req) {
		req.setJgid(getUser().getHospitalId());
		req.setYgdm(getUser().getUserId());
		MpiBrda mpiBrda = opGhksSer.doAddPerson(req);
		return ReturnEntityUtil.success(mpiBrda);
	}

	/**
	 * 校验卡号是否重复
	 * 
	 * @param zjlx
	 * @param idCard
	 * @return
	 */
	@RequestMapping("/doCheckJzkh")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "校验卡号是否重复", httpMethod = "POST", notes = "校验卡号是否重复")
	public ReturnEntity<?> doCheckJzkh(
			@ApiParam(name = "jzkh", value = "就诊卡号") @RequestParam(value = "jzkh") String jzkh) {
		opGhksSer.doCheckJzkh(jzkh);
		return ReturnEntityUtil.success();
	}

	/**
	 * 卡注销
	 * 
	 * @param jzkh
	 * @return
	 */
	@RequestMapping("/doCancelCard")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "卡注销", httpMethod = "POST", notes = "卡注销")
	public ReturnEntity<?> doCancelCard(
			@ApiParam(name = "cardno", value = "卡号") @RequestParam(value = "cardno") String cardno,
			@ApiParam(name = "brid", value = "病人ID") @RequestParam(value = "brid") Integer brid) {
		opGhksSer.updateCardStatus(cardno, brid, getUser().getUserId(), getIpAddress(), MpiCardEnum.CANCEL.getCode());
		return ReturnEntityUtil.success();
	}

	/**
	 * 卡挂失
	 * 
	 * @param jzkh
	 * @return
	 */
	@RequestMapping("/doLostCard")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "卡挂失", httpMethod = "POST", notes = "卡挂失")
	public ReturnEntity<?> doLostCard(
			@ApiParam(name = "cardno", value = "卡号") @RequestParam(value = "cardno") String cardno,
			@ApiParam(name = "brid", value = "病人ID") @RequestParam(value = "brid") Integer brid) {
		opGhksSer.updateCardStatus(cardno, brid, getUser().getUserId(), getIpAddress(), MpiCardEnum.LOST.getCode());
		return ReturnEntityUtil.success();
	}

	/**
	 * 卡解挂
	 * 
	 * @param jzkh
	 * @return
	 */
	@RequestMapping("/doUnlatchCard")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "卡解挂", httpMethod = "POST", notes = "卡解挂")
	public ReturnEntity<?> doUnlatchCard(
			@ApiParam(name = "cardno", value = "卡号") @RequestParam(value = "cardno") String cardno,
			@ApiParam(name = "brid", value = "病人ID") @RequestParam(value = "brid") Integer brid) {
		opGhksSer.updateCardStatus(cardno, brid, getUser().getUserId(), getIpAddress(), MpiCardEnum.NORMAL.getCode());
		return ReturnEntityUtil.success();
	}

	/**
	 * 建档时查询病人性质
	 * 
	 * @return
	 */
//	@RequestMapping("/getPubBrxzList")
//	@ResponseBody
//	@ApiOperationSupport(author = "汪洋")
//	@ApiOperation(value = "建档时查询病人性质", httpMethod = "POST", notes = "建档时查询病人性质")
//	public ReturnEntity<List<PubBrxz>> getPubBrxzList() {
//		List<PubBrxz> resp = opGhksSer.getPubBrxzList();
//		return ReturnEntityUtil.success(resp);
//	}

	/**
	 * 调入-预约病人查询
	 * 
	 * @param zblb
	 * @param jzkh
	 * @return
	 */
	@RequestMapping("/doGetAnAppointment")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "调入预约病人查询", httpMethod = "POST", notes = "调入预约病人查询,调入确认走挂号收费")
	public ReturnEntity<List<GetAnAppointResp>> doGetAnAppointment(
			@ApiParam(name = "zblb", value = "排班类别") @RequestParam(value = "zblb") String zblb,
			@ApiParam(name = "jzkh", value = "就诊卡号") @RequestParam(value = "jzkh") String jzkh) {
		List<GetAnAppointResp> resp = opGhksSer.doGetAnAppointment(zblb, jzkh, getUser().getHospitalId(),
				getIpAddress());
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 挂号查询
	 * 
	 * @param opghks
	 * @param page
	 * @return
	 */
	@RequestMapping("/doRegisteredQuery")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "挂号查询", httpMethod = "POST", notes = "挂号查询")
	public ReturnEntity<PageInfo<QueryRegisteredResp>> doRegisteredQuery(QueryRegisteredReq req, PageQuery page) {
		req.setJgid(getUser().getHospitalId());
		PageInfo<QueryRegisteredResp> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> opGhksSer.doRegisteredQuery(req));
		return ReturnEntityUtil.success(pageInfo);
	}

	/**
	 * 获取挂号科室对应的门诊科室
	 * 
	 * @param opghks
	 * @param page
	 * @return
	 */
	@RequestMapping("/doQueryOfficeCode")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "获取挂号科室对应的门诊科室", httpMethod = "POST", notes = "获取挂号科室对应的门诊科室")
	public ReturnEntity<List<QueryOfficeCodeResp>> doQueryOfficeCode() {
		List<QueryOfficeCodeResp> resp = opGhksSer.doQueryOfficeCode(getUser().getHospitalId());
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 卡登记管理
	 * 
	 * @param opghks
	 * @param page
	 * @return
	 */
	@RequestMapping("/doQueryList")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "卡登记管理", httpMethod = "POST", notes = "卡登记管理")
	public ReturnEntity<PageInfo<QueryBrdaListResp>> doQueryList(
			@ApiParam(name = "jzkh", value = "就诊卡号或者姓名或者身份证", required = false) @RequestParam(value = "jzkh", required = false) String jzkh,
			PageQuery page) {
		PageInfo<QueryBrdaListResp> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> opGhksSer.doQueryList(jzkh, getUser().getHospitalId()));
		return ReturnEntityUtil.success(pageInfo);
	}


	/**
	 * 就诊卡信息校验
	 *
	 * @param jzkh 就诊卡号
	 * @param sfzh 身份证号
	 * @return
	 */
	@RequestMapping("/checkCardInfo")
	@ResponseBody
	@ApiOperationSupport(author = "tian")
	@ApiOperation(value = "就诊卡信息校验", httpMethod = "POST", notes = "就诊卡信息校验")
	public ReturnEntity<?> checkCardInfo(
			@ApiParam(name = "jzkh", value = "就诊卡号", required = true) @RequestParam(value = "jzkh") String jzkh,
			@ApiParam(name = "sfzh", value = "身份证号", required = true) @RequestParam(value = "sfzh") String sfzh) {
		opGhksSer.checkCardInfo(jzkh, sfzh, getUser().getHospitalId());
		return ReturnEntityUtil.success();
	}

	/**
	 * 判断是否为减免病人
	 * 
	 * @param cardno
	 * @param brxz
	 * @return
	 */
	@RequestMapping("/doQueryJmbr")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "判断是否为减免病人", httpMethod = "POST", notes = "判断是否为减免病人")
	public ReturnEntity<Boolean> doQueryJmbr(
			@ApiParam(name = "cardno", value = "卡号") @RequestParam(value = "cardno") String cardno,
			@ApiParam(name = "brxz", value = "病人性质") @RequestParam(value = "brxz") Integer brxz) {
		boolean isJm = Boolean.FALSE;
		Integer count = pubJmbrSer.getEntityMapper().doQueryIsJmbr(cardno, brxz);
		if (count != null && count > 0) {
			isJm = Boolean.TRUE;
		} else {
			throw BaseException.create("ERROR_REG_0074");
		}
		return ReturnEntityUtil.success(isJm);
	}


	/**
	 * 挂号发票打印
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doPrintghxx")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "挂号发票打印", httpMethod = "POST", notes = "挂号发票打印")
	public ReturnEntity<PrintGhxxResp> doPrintghxx(PrintGhxxReq req) {
		req.setJgid(getUser().getHospitalId());
		req.setUserName(getUser().getUserName());
		PrintGhxxResp resp = opGhksSer.doPrintghxx(req);
		return ReturnEntityUtil.success(resp);
	}


	/**
	 * 病人医保读卡
	 * @return
	 */
	@RequestMapping("/readPatientMedicareAccountInfo")
	@ResponseBody
	@ApiOperationSupport(author = "beijunhua")
	@ApiOperation(value="病人医保读卡" ,httpMethod="POST")
	public ReturnEntity<SM01Res> readPatientMedicareAccountInfo(
			@ApiParam(name = "carddata", value = "卡号") @RequestParam(value = "carddata") String carddata,
			@ApiParam(name = "cardtype", value = "卡类型") @RequestParam(value = "cardtype") String cardtype){
		return opGhksSer.readPatientMedicareAccountInfo(carddata,cardtype,getIpAddress(),getUser(),"1");
	}
	/**
	 * 病人医保读卡+sfz txdz
	 * @return
	 */
	@RequestMapping("/readPatientAccountInfo")
	@ResponseBody
	@ApiOperationSupport(author = "beijunhua")
	@ApiOperation(value="病人医保读卡" ,httpMethod="POST")
	public ReturnEntity<SM01Res> readPatientAccountInfo(
			@ApiParam(name = "carddata", value = "卡号") @RequestParam(value = "carddata") String carddata,
			@ApiParam(name = "cardtype", value = "卡类型") @RequestParam(value = "cardtype") String cardtype){
		return opGhksSer.readPatientMedicareAccountInfo(carddata,cardtype,getIpAddress(),getUser(),"2");
	}

	/**
	 * 工伤认定号校验
	 * @return
	 */
	@RequestMapping("/checkGs")
	@ResponseBody
	@ApiOperationSupport(author = "beijunhua")
	@ApiOperation(value="工伤认定号验证" ,httpMethod="POST")
	public ReturnEntity<?> checkGs(
			@ApiParam(name = "carddata", value = "卡号") @RequestParam(value = "carddata") String carddata,
			@ApiParam(name = "cardtype", value = "卡类型") @RequestParam(value = "cardtype") String cardtype,
			@ApiParam(name = "gsrdh", value = "工伤认定号", required = true) @RequestParam(value = "gsrdh") String gsrdh,
			@ApiParam(name = "brid", value = "病人id", required = true) @RequestParam(value = "brid") String brid){
		opGhksSer.checkGs(carddata,cardtype,gsrdh,brid,getIpAddress(),getUser());
		return ReturnEntityUtil.success();
	}

	/**
	 * 挂号管理查询分诊病人信息
	 *
	 *
	 * @param jzkh
	 * @param brxm
	 * @param fzrq
	 * @param page
	 * @return
	 */
	@RequestMapping("/doQueryYjfzbrInfo")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "挂号管理查询分诊病人信息", httpMethod = "POST", notes = "挂号管理查询分诊病人信息")
	public ReturnEntity<PageInfo<QueryYjfzbrResp>> doQueryYjfzbrInfo(
			@ApiParam(name = "jzkh", value = "就诊卡号") @RequestParam(value = "jzkh", required = false) String jzkh,
			@ApiParam(name = "brxm", value = "病人姓名") @RequestParam(value = "brxm", required = false) String brxm,
			@ApiParam(name = "fzrq", value = "分诊日期") @RequestParam(value = "fzrq", required = false) Date fzrq,
			PageQuery page) {
		PageInfo<QueryYjfzbrResp> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> opGhksSer.doQueryYjfzbrInfo(jzkh, brxm, getUser().getHospitalId(), fzrq));
		return ReturnEntityUtil.success(pageInfo);
	}

	/**
	 * 挂号管理分诊病人信息调入
	 *
	 * @param page
	 * @return
	 */
	@RequestMapping("/doGetYjfzLsh")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "挂号管理分诊病人信息调入", httpMethod = "POST", notes = "挂号管理查询分诊病人信息")
	public ReturnEntity<YjfzBrdaResp> doGetYjfzLsh(
			@ApiParam(name = "lsh", value = "就诊卡号") @RequestParam(value = "lsh") Integer lsh) {
		YjfzBrdaResp resp = opGhksSer.doGetYjfzLsh(lsh);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 获取病人及上级病人性质
	 * @return
	 */
	@RequestMapping("/queryBrxz")
	@ResponseBody
	@ApiOperationSupport(author = "beijunhua")
	@ApiOperation(value="查询病人性质及上级病人性质" ,httpMethod="POST")
	public ReturnEntity<List<PubBrxzsResp>> queryBrxz(){
		return ReturnEntityUtil.success(opGhksSer.queryBrxz());
	}


}


	/**
	 * 病人医保刷卡
	 * @param carddata
	 * @return
	 */
/*	@RequestMapping("/queryPatientMedicareAccountInfo")
	@ResponseBody
	@ApiOperationSupport(author = "beijunhua")
	@ApiOperation(value="病人医保刷卡" ,httpMethod="POST")
	public ReturnEntity<SM01Res> queryPatientMedicareAccountInfo(String carddata){

		return imHzrySer.readPatientMedicareAccountInfo(carddata,getIpAddress());
	}*/



