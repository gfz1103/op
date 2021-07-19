
package com.buit.his.op.reg.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.buit.commons.model.PubJmlx;
import com.buit.commons.request.SaveFydwReq;
import com.buit.his.op.reg.service.PubJmlxSer;
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
 * <br>
 * 
 * @author WY
 */
@Api(tags = "减免政策管理")
@Controller
@RequestMapping("/pubjmlx")
public class PubJmlxCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(PubJmlxCtr.class);

	@Autowired
	private PubJmlxSer pubJmlxSer;
	@DubboReference
    private SysDictConfigSer sysDictConfigSer;

	/**
	 * 减免政策管理分页查询
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("/queryPage")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "减免政策管理分页查询", httpMethod = "POST", notes = "减免政策管理分页查询")
	public ReturnEntity<PageInfo<PubJmlx>> queryPage(PageQuery page) {
		PageInfo<PubJmlx> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> pubJmlxSer.findByEntity(getUser().getHospitalId()));
		return ReturnEntityUtil.success(pageInfo);
	}

	/**
	 * 新增修改减免政策
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doSaveFydw")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "新增修改减免政策", httpMethod = "POST", notes = "新增修改减免政策")
	public ReturnEntity<?> doSaveFydw(@RequestBody @Valid SaveFydwReq req) {
		req.setJgid(getUser().getHospitalId());
		pubJmlxSer.doSaveFydw(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 删除减免政策
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doDeleteFydw")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "删除减免政策", httpMethod = "POST", notes = "删除减免政策")
	public ReturnEntity<?> doDeleteFydw(
			@ApiParam(name = "fydw", value = "妇幼单位主键", required = true) @RequestParam(value = "fydw") Integer fydw) {
		pubJmlxSer.getEntityMapper().deleteById(fydw);
		return ReturnEntityUtil.success();
	}

	/**
	 * 减免政策列表
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doQueryFydwList")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "减免政策列表", httpMethod = "POST", notes = "减免政策列表")
	public ReturnEntity<List<PubJmlx>> doQueryFydwList() {
		PubJmlx pubJmlx = new PubJmlx();
		pubJmlx.setZfpb(0);
		List<PubJmlx> resp = pubJmlxSer.getEntityMapper().findByEntity(pubJmlx);
		sysDictConfigSer.upDateVersion("pub_jmlx");
		return ReturnEntityUtil.success(resp);
	}
}
