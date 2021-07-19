
package com.buit.his.op.reg.controller;

import java.util.List;

import javax.validation.Valid;

import com.buit.commons.BaseException;
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
import com.buit.commons.model.OpGhks;
import com.buit.commons.model.OpGhksOffice;
import com.buit.commons.request.OpGhksAddReq;
import com.buit.commons.request.OpGhksReq;
import com.buit.his.op.reg.service.OpGhksSer;
import com.buit.system.service.SysDictConfigSer;
import com.buit.utill.BeanUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 门诊_挂号科室<br>
 * 
 * @author WY
 */
@Api(tags = "挂号科室维护")
@Controller
@RequestMapping("/opghks")
public class OpGhksCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(OpGhksCtr.class);

	@Autowired
	private OpGhksSer opGhksSer;
	@DubboReference
	private SysDictConfigSer sysDictConfigSer;

	/**
	 * 挂号科室维护分页条件查询
	 * 
	 * @param opghks
	 * @param page
	 * @return
	 */
	@RequestMapping("/queryPage")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "按条件分页查询", httpMethod = "POST", notes = "挂号科室维护分页条件查询")
	public ReturnEntity<PageInfo<OpGhks>> queryPage(OpGhksReq opghks, PageQuery page) {
		opghks.setJgid(getUser().getHospitalId());
		OpGhks ghks = BeanUtil.toBean(opghks, OpGhks.class);
		PageInfo<OpGhks> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> opGhksSer.findByEntity(ghks));
		return ReturnEntityUtil.success(pageInfo);
	}

	/**
	 * 挂号科室新增
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "挂号科室新增", httpMethod = "POST", notes = "挂号科室新增")
	public ReturnEntity<?> add(@RequestBody @Valid OpGhksAddReq req) {
		req.setJgid(getUser().getHospitalId());
		opGhksSer.save(req);
		return ReturnEntityUtil.success();
	}


	/**
	 * 判断上级科室是否为互联网科室
	 *
	 * @param mzks
	 * @return
	 */
	@RequestMapping("/isInternet")
	@ResponseBody
	@ApiOperationSupport(author = "tian")
	@ApiOperation(value = "判断上级科室是否为互联网科室", httpMethod = "POST", notes = "判断上级科室是否为互联网科室")
	public ReturnEntity<?> isInternet(@ApiParam(name = "mzks", value = "门诊科室代码", required = true) @RequestParam(value = "mzks") Integer mzks) {
		return ReturnEntityUtil.success(opGhksSer.getEntityMapper().isInternet(mzks));
	}

	/**
	 * 挂号科室修改时查询
	 * 
	 * @param ksdm
	 * @return
	 */
	@RequestMapping("/getOneByEntity")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "挂号科室修改时查询", httpMethod = "POST", notes = "挂号科室修改时查询")
	public ReturnEntity<OpGhks> getOneByEntity(
			@ApiParam(name = "ksdm", value = "科室代码", required = true) @RequestParam(value = "ksdm") Integer ksdm) {
		OpGhks opGhks = opGhksSer.getEntityMapper().getById(ksdm);
		if (opGhks != null) {
			return ReturnEntityUtil.success(opGhks);
		}
		return ReturnEntityUtil.success();
	}

	/**
	 * 挂号科室修改
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "挂号科室修改", httpMethod = "POST", notes = "挂号科室修改")
	public ReturnEntity<?> edit(@RequestBody @Valid OpGhksAddReq req) {

		Integer count = opGhksSer.getEntityMapper().checkGhksInfo(req.getKsmc(), req.getMzks(), req.getKsdm());
		if(count > 0){
			throw BaseException.create("ERROR_REG_0100");
		}
		OpGhks opGhks = new OpGhks();
		req.setJgid(getUser().getHospitalId());
		BeanUtils.copyProperties(req, opGhks);
		opGhksSer.update(opGhks);
		sysDictConfigSer.upDateVersion("op_ghks");
		return ReturnEntityUtil.success();
	}

	/**
	 * 挂号科室删除
	 */
	@RequestMapping("/delete")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "挂号科室删除", httpMethod = "POST", notes = "挂号科室删除")
	public ReturnEntity<?> delete(
			@ApiParam(name = "ksdm", value = "科室代码", required = true) @RequestParam(value = "ksdm") Integer ksdm) {
		opGhksSer.delete(ksdm);
		sysDictConfigSer.upDateVersion("op_ghks");
		return ReturnEntityUtil.success();
	}

	/**
	 * 挂号科室维护新增或修改时门诊列表
	 * 
	 * @return
	 */
	@RequestMapping("/findMzksList")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "挂号科室维护新增或修改时门诊列表", httpMethod = "POST", notes = "挂号科室维护新增或修改时门诊列表")
	public ReturnEntity<List<OpGhksOffice>> getByEntity() {
		return ReturnEntityUtil.success(opGhksSer.getMzksList(getUser().getHospitalId()));
	}

	/**
	 * 初始化挂号管理
	 * 
	 * @return
	 */
//	@RequestMapping("/initGhksInfo")
//	@ResponseBody
//	@ApiOperationSupport(author = "汪洋")
//	@ApiOperation(value = "初始化挂号管理", httpMethod = "POST", notes = "初始化挂号管理,判断票据号是否设置，判断是否排班，初始化挂号科室信息")
//	public ReturnEntity<MsInitGhksResp> initGhksInfo() {
//		MsInitGhksResp resp = opGhksSer.initGhksInfo(getUser().getHospitalId(), getUser().getUserId());
//		return ReturnEntityUtil.success(resp);
//	}

	/**
	 * 挂号科室列表
	 * 
	 * @param req
	 * @return
	 */
//	@RequestMapping("/getGhksList")
//	@ResponseBody
//	@ApiOperationSupport(author = "汪洋")
//	@ApiOperation(value = "挂号科室列表", httpMethod = "POST", notes = "挂号科室列表")
//	public ReturnEntity<List<OpGhks>> getGhksList(OpGhksListReq req) {
//		req.setJgid(getUser().getHospitalId());
//		req.setIp(getIpAddress());
//		return ReturnEntityUtil.success(opGhksSer.getGhksList(req));
//	}

	/**
	 * 根据卡号查询病人信息
	 * 
	 * @param req
	 * @return
	 */
//	@RequestMapping("/doQueryPerson")
//	@ResponseBody
//	@ApiOperationSupport(author = "汪洋")
//	@ApiOperation(value = "根据卡号查询病人信息", httpMethod = "POST", notes = "根据卡号查询病人信息")
//	public ReturnEntity<List<OpGhks>> doQueryPerson(MsQryPersonReq req) {
//		req.setJgid(getUser().getHospitalId());
//		req.setYgdm(getUser().getUserId());
//		return ReturnEntityUtil.success(opGhksSer.doQueryPerson(req));
//	}

//    
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<OpGhksResp>> getByEntity( OpGhksReq opghks){//@RequestBody 
//        return ReturnEntityUtil.success(opGhksSer.findByEntity(opghks));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<OpGhksResp> getOneByEntity(OpGhksReq opghks){
//        List<OpGhks> list=opGhksSer.findByEntity(opghks);
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
//    public ReturnEntity<OpGhksResp> add(OpGhksReq opGhks) {
//        opGhksSer.insert(opGhks);        
//        return ReturnEntityUtil.success(opGhks);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<OpGhksResp> edit(OpGhksReq opGhks)  {
//        opGhksSer.update(opGhks);        
//        return ReturnEntityUtil.success(opGhks);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<OpGhksResp> delete(OpGhksReq opGhks) {
//        opGhksSer.removeByEntity(opGhks);        
//        return ReturnEntityUtil.success(opGhks);            
//    }

}
