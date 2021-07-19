
package com.buit.his.op.reg.controller;

import com.buit.cis.op.dctwork.response.OpMzzsResp;
import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.commons.model.OpGhks;
import com.buit.commons.model.OpMzzs;
import com.buit.commons.request.OpMzzsAddReq;
import com.buit.commons.request.OpMzzsReq;
import com.buit.his.op.reg.service.OpMzzsSer;
import com.buit.utill.ParamUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 门诊诊室信息<br>
 *
 * @author WY
 */
@Api(tags = "门诊信息维护")
@Controller
@RequestMapping("/opmzzs")
public class OpMzzsCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(OpMzzsCtr.class);

	@Autowired
	private OpMzzsSer opMzzsSer;

	/**
	 * 门诊信息维护分页查询
	 *
	 * @param req
	 * @param page
	 * @return
	 */
	@RequestMapping("/queryPage")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "门诊信息维护分页查询", httpMethod = "POST", notes = "门诊信息维护分页查询")
	public ReturnEntity<PageInfo<OpMzzs>> queryPage(OpMzzsReq req, PageQuery page) {
		OpMzzs opMzzs = new OpMzzs();
		req.setSortColumns("GHKS,ZSID");
		BeanUtils.copyProperties(req, opMzzs);
		PageInfo<OpMzzs> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> opMzzsSer.findByEntity(opMzzs));
		return ReturnEntityUtil.success(pageInfo);
	}

	/**
	 * 门诊信息维护新增
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "门诊信息维护新增", httpMethod = "POST", notes = "门诊信息维护新增")
	public ReturnEntity<?> add(@Valid @RequestBody OpMzzsAddReq req) {
		opMzzsSer.add(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 诊室信息维护修改时查询
	 *
	 * @param sbxh
	 * @return
	 */
	@RequestMapping("/getOneByEntity")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "诊室信息维护修改时查询", httpMethod = "POST", notes = "诊室信息维护修改时查询")
	public ReturnEntity<OpMzzs> getOneByEntity(
			@ApiParam(name = "sbxh", value = "识别序号", required = true) @RequestParam(value = "sbxh") Integer sbxh) {
		OpMzzs opMzzs = opMzzsSer.getById(sbxh);
		if (opMzzs != null) {
			return ReturnEntityUtil.success(opMzzs);
		}
		return ReturnEntityUtil.success();
	}

	/**
	 * 诊室信息维护修改
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "诊室信息维护修改", httpMethod = "POST", notes = "诊室信息维护修改")
	public ReturnEntity<?> edit(@Valid @RequestBody OpMzzsAddReq req) {
		OpMzzs opMzzs = new OpMzzs();
		BeanUtils.copyProperties(req, opMzzs);
		opMzzsSer.update(opMzzs);
		return ReturnEntityUtil.success();
	}

	/**
	 * 诊室信息维护删除
	 *
	 * @param sbxh
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "诊室信息维护删除", httpMethod = "POST", notes = "诊室信息维护删除")
	public ReturnEntity<?> delete(
			@ApiParam(name = "sbxh", value = "门诊类别", required = true) @RequestParam(value = "sbxh") Integer sbxh) {
		opMzzsSer.getEntityMapper().deleteById(sbxh);
		return ReturnEntityUtil.success();
	}

	/**
	 * 校验同一科室诊室ID是否存在
	 *
	 * @param ghks
	 * @param zsId
	 * @param oldZsId
	 * @return
	 */
	@RequestMapping("/validZsIdExist")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "校验同一科室诊室ID是否存在", httpMethod = "POST", notes = "校验同一科室诊室ID是否存在")
	public ReturnEntity<?> validZsIdExist(
			@ApiParam(name = "ghks", value = "挂号科室", required = true) @RequestParam(value = "ghks") Integer ghks,
			@ApiParam(name = "zsId", value = "门诊ID") @RequestParam(value = "zsId", required = false) Integer zsId,
			@ApiParam(name = "zsmc", value = "诊室名称") @RequestParam(value = "zsmc", required = false) String zsmc,
			@ApiParam(name = "oldZsId", value = "修改时原门诊ID") @RequestParam(value = "oldZsId", required = false) Integer oldZsId) {
		opMzzsSer.validZsIdExist(ghks, zsId, zsmc, oldZsId);
		return ReturnEntityUtil.success();
	}

	@RequestMapping("/queryZsByFwtId")
	@ResponseBody
	@ApiOperationSupport(author = "朱智")
	@ApiOperation(value = "根据服务台ID查询科室", httpMethod = "POST")
	public ReturnEntity<List<OpGhks>> queryKsByFwtId(
			@ApiParam(name = "fwtid", value = "服务台ID", required = true) @RequestParam(value = "fwtid") Integer fwtid,
			@ApiParam(name = "ksmc", value = "科室名称") @RequestParam(value = "ksmc", required = false) String ksmc) {
		return ReturnEntityUtil.success(opMzzsSer.queryKsByFwtId(fwtid, ksmc));
	}


	/**
	 * @name: queryWaitMs
	 * @description: 查询待选择科室信息
	 * @date: 2020/9/4 9:58
	 * @auther: 朱智
	 *
	 */
	@RequestMapping("/queryWaitMs")
	@ResponseBody
	@ApiOperationSupport(author = "朱智")
	@ApiOperation(value = "查询待选择诊室信息", httpMethod = "POST")
	public ReturnEntity<List<OpGhks>> queryWaitMs(@ApiParam(name = "ksmc", value = "科室名称") @RequestParam(value = "ksmc", required = false) String ksmc) {
		return ReturnEntityUtil.success(opMzzsSer.queryWaitMs(ksmc));
	}


	/**
	 * @name: fwtZsChange
	 * @description: 服务台诊室维护
	 * @date: 2020/9/4 9:58
	 * @auther: 朱智
	 *
	 */
	@RequestMapping("/fwtKsChange")
	@ResponseBody
	@ApiOperationSupport(author = "朱智")
	@ApiOperation(value = "服务台科室维护", httpMethod = "POST")
	public ReturnEntity fwtZsChange(@ApiParam(name = "fwtid", value = "服务台ID", required = true) @RequestParam(value = "fwtid") Integer fwtid,
									@ApiParam(name = "ksdmList", value = "诊室识别序号集合", required = true) @RequestParam(value = "ksdmList") List<Integer> ksdmList,
									@ApiParam(name = "type", value = "类型1：加、2：减", required = true) @RequestParam(value = "type") Integer type) {
		opMzzsSer.fwtKsChange(fwtid, ksdmList, type);
		return ReturnEntityUtil.success();
	}

	/**
	 * 通过门诊科室查询诊室信息
	 * @param mzks
	 * @return
	 */
	@RequestMapping("/getOpMzzsByMzks")
	@ResponseBody
	@ApiOperationSupport(author = "韦靖")
	@ApiOperation(value = "通过门诊科室查询诊室信息", httpMethod = "POST")
	public ReturnEntity<List<OpMzzsResp>> getOpMzzsByMzks(@ApiParam(name = "mzks", value = "门诊科室", required = true) @RequestParam(value = "mzks") Integer mzks) {
		return ReturnEntityUtil.success(opMzzsSer.getOpMzzsByMzks(mzks,getUser().getHospitalId()));
	}

	@RequestMapping("/getFwtIdByZsmc")
	@ResponseBody
	@ApiOperationSupport(author = "朱智")
	@ApiOperation(value = "通过诊室名称查询服务台ID[废弃]", httpMethod = "POST")
	public ReturnEntity<OpMzzs> fwtZsChange(@ApiParam(name = "zsmc", value = "诊室名称", required = true) @RequestParam(value = "zsmc") String zsmc) {
		List<OpMzzs> list = opMzzsSer.getEntityMapper().findByEntity(ParamUtil.instance().put("zsmc", zsmc));
		if(!list.isEmpty()){
			return ReturnEntityUtil.success(list.get(0));
		}
		return ReturnEntityUtil.success();
	}
}
