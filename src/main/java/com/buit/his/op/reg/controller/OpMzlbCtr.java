
package com.buit.his.op.reg.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.commons.model.OpMzlb;
import com.buit.commons.request.OpMzlbReq;
import com.buit.commons.request.SaveOrUpdateYbipReq;
import com.buit.commons.response.QueryYbipDetatilResp;
import com.buit.his.op.reg.service.OpMzlbSer;
import com.buit.his.op.reg.service.OpYbipSer;
import com.buit.system.service.SysDictConfigSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 门诊_门诊类别<br>
 * 
 * @author WY
 */
@Api(tags = "医保线路维护")
@Controller
@RequestMapping("/opmzlb")
public class OpMzlbCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(OpMzlbCtr.class);

	@Autowired
	private OpMzlbSer opMzlbSer;
	
	@Autowired
	private OpYbipSer opYbipSer;

	@DubboReference
	private SysDictConfigSer sysDictConfigSer;

	@RequestMapping("/queryPage")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "医保线路维护分页查询", httpMethod = "POST", notes = "医保线路维护分页查询")
	public ReturnEntity<PageInfo<OpMzlb>> queryPage(PageQuery page) {
		OpMzlb opMzlb = new OpMzlb();
		opMzlb.setJgid(getUser().getHospitalId());
		PageInfo<OpMzlb> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> opMzlbSer.findByEntity(opMzlb));
		return ReturnEntityUtil.success(pageInfo);
	}

	/**
	 * 医保线路维护新增
	 * 
	 * @param opMzlb
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "医保线路维护新增", httpMethod = "POST", notes = "医保线路维护新增")
	public ReturnEntity<?> add(@Valid @RequestBody OpMzlbReq req) {
		req.setJgid(getUser().getHospitalId());
		opMzlbSer.add(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 医保线路维护修改时查询
	 * 
	 * @param mzlb
	 * @return
	 */
	@RequestMapping("/getOneByEntity")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "医保线路维护修改时查询", httpMethod = "POST", notes = "医保线路维护修改时查询")
	public ReturnEntity<OpMzlb> getOneByEntity(
			@ApiParam(name = "mzlb", value = "门诊类别", required = true) @RequestParam(value = "mzlb") Integer mzlb) {
		OpMzlb opMzlb = opMzlbSer.getById(mzlb);
		if (opMzlb != null) {
			return ReturnEntityUtil.success(opMzlb);
		}
		return ReturnEntityUtil.success();
	}

	/**
	 * 医保线路维护修改
	 * 
	 * @param opMzlb
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "医保线路维护修改", httpMethod = "POST", notes = "医保线路维护修改")
	public ReturnEntity<?> edit(@Valid @RequestBody OpMzlbReq req) {
		OpMzlb opMzlb = new OpMzlb();
		req.setJgid(getUser().getHospitalId());
		BeanUtils.copyProperties(req, opMzlb);
		opMzlbSer.update(opMzlb);
		sysDictConfigSer.upDateVersion("op_mzlb");
		return ReturnEntityUtil.success();
	}

	/**
	 * 医保线路维护删除
	 * 
	 * @param opMzlb
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "医保线路维护删除", httpMethod = "POST", notes = "医保线路维护删除")
	public ReturnEntity<?> delete(
			@ApiParam(name = "mzlb", value = "门诊类别", required = true) @RequestParam(value = "mzlb") Integer mzlb) {
		opMzlbSer.getEntityMapper().deleteById(mzlb);
		sysDictConfigSer.upDateVersion("op_mzlb");
		return ReturnEntityUtil.success();
	}

	/**
	 * 根据门诊类别查询医保IP
	 * 
	 * @param opMzlb
	 * @return
	 */
	@RequestMapping("/doQueryYbipDetatil")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "根据门诊类别查询医保IP", httpMethod = "POST", notes = "根据门诊类别查询医保IP")
	public ReturnEntity<List<QueryYbipDetatilResp>> doQueryYbipDetatil(
			@ApiParam(name = "mzlb", value = "门诊类别", required = true) @RequestParam(value = "mzlb") Integer mzlb) {
		List<QueryYbipDetatilResp> resp = opMzlbSer.doQueryYbipDetatil(mzlb, getUser().getHospitalId());
		return ReturnEntityUtil.success(resp);
	}
	
	/**
	 * 医保IP删除
	 * 
	 * @param opMzlb
	 * @return
	 */
	@RequestMapping("/delIpBySbxh")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "医保IP删除", httpMethod = "POST", notes = "医保IP删除")
	public ReturnEntity<?> delIpBySbxh(
			@ApiParam(name = "sbxh", value = "识别序号", required = true) @RequestParam(value = "sbxh") Integer sbxh) {
		opYbipSer.getEntityMapper().deleteById(sbxh);
		return ReturnEntityUtil.success();
	}

	/**
	 * 更新或修改医保ip
	 * 
	 * @param opMzlb
	 * @return
	 */
	@RequestMapping("/doSaveOrUpdateYbip")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "更新或修改医保ip", httpMethod = "POST", notes = "更新或修改医保ip")
	public ReturnEntity<?> doSaveOrUpdateYbip(@RequestBody SaveOrUpdateYbipReq req) {
		opYbipSer.doSaveOrUpdateYbip(req);
		return ReturnEntityUtil.success();
	}


}
