
package com.buit.his.op.reg.controller;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import com.buit.commons.model.OpYgpj;
import com.buit.his.op.reg.enums.PbCzEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import com.buit.commons.model.OpKspb;
import com.buit.commons.request.OpKspbReq;
import com.buit.his.op.reg.service.OpKspbSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 门诊_科室排班<br>
 * 
 * @author wangyang
 */
@Api(tags = "科室排班维护")
@Controller
@RequestMapping("/opkspb")
public class OpKspbCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(OpKspbCtr.class);

	@Autowired
	private OpKspbSer opKspbSer;

	/**
	 * 科室排班分页查询
	 * 
	 * @param opkspb
	 * @param page
	 * @return
	 */
	@RequestMapping("/doGetModelDataOperation")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "科室排班分页查询", httpMethod = "POST", notes = "科室排班分页查询")
	public ReturnEntity<List<OpKspb>> queryPage(@Valid OpKspbReq opkspb, PageQuery page) {
		opkspb.setJgid(getUser().getHospitalId());
		List<OpKspb> pageInfo = opKspbSer.getKspbList(opkspb);
		return ReturnEntityUtil.success(pageInfo);
	}

	/**
	 * 保存
	 * 
	 * @param opKspb
	 * @return
	 */
	@RequestMapping("/doSaveDepartmentScheduling")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "保存、赋值到下一天", httpMethod = "POST", notes = "保存和赋值到下一天接口")
	public ReturnEntity<?> add(@RequestBody List<OpKspb> opKspb) {
		opKspbSer.add(opKspb, getUser().getHospitalId());
		return ReturnEntityUtil.success();
	}

	/**
	 * 复制到下一天
	 * 
	 * @param opKspb
	 * @return
	 */
	@RequestMapping("/doSaveCopy")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "复制到下一天", httpMethod = "POST", notes = "复制到下一天")
	public ReturnEntity<?> doSaveCopy(
			@ApiParam(name = "currDate", value = "当前日期", required = true) @RequestParam(value = "currDate") Date currDate,
			@ApiParam(name = "nextDate", value = "下一天日期", required = true) @RequestParam(value = "nextDate") Date nextDate,
			@ApiParam(name = "zblb", value = "值班类别", required = true) @RequestParam(value = "zblb") String zblb) {
		opKspbSer.doSaveCopy(currDate, nextDate, zblb, getUser().getHospitalId());
		return ReturnEntityUtil.success();
	}


	/**
	 * 挂号科室排班修改校验
	 *
	 * @param opKspb
	 * @return
	 */
	@RequestMapping("/doModifyCheck")
	@ResponseBody
	@ApiOperationSupport(author = "tian")
	@ApiOperation(value = "挂号科室排班修改校验", httpMethod = "POST", notes = "挂号科室排班修改校验")
	public ReturnEntity<?> doModifyCheck(@RequestBody List<OpKspb> opKspb) {
		opKspbSer.doModifyCheck(opKspb);
		return ReturnEntityUtil.success();
	}


	/**
	 * 复制到下一天校验
	 *
	 * @param currDate
	 * @param nextDate
	 * @param zblb
	 * @return
	 */
	@RequestMapping("/doCopyCheck")
	@ResponseBody
	@ApiOperationSupport(author = "tian")
	@ApiOperation(value = "复制到下一天校验", httpMethod = "POST", notes = "复制到下一天校验")
	public ReturnEntity<?> doCopyCheck(
			@ApiParam(name = "currDate", value = "当前日期", required = true) @RequestParam(value = "currDate") Date currDate,
			@ApiParam(name = "nextDate", value = "下一天日期", required = true) @RequestParam(value = "nextDate") Date nextDate,
			@ApiParam(name = "zblb", value = "值班类别", required = true) @RequestParam(value = "zblb") String zblb) {
		opKspbSer.doVaildCheck(currDate, nextDate, zblb, getUser().getHospitalId(), 2);
		return ReturnEntityUtil.success();
	}

}
