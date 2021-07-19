
package com.buit.his.op.infusion.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.request.SyKsAddReq;
import com.buit.commons.response.SyKsResp;
import com.buit.his.op.infusion.service.SyKsSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 输液/注射科室设置<br>
 * 
 * @author WY
 */
@Api(tags = "输液注射科室设置")
@Controller
@RequestMapping("/syks")
public class SyKsCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(SyKsCtr.class);

	@Autowired
	private SyKsSer syKsSer;

	/**
	 * 查询输液注射科室列表
	 * 
	 * @param syKs
	 * @return
	 */
	@RequestMapping("/doQuerySyksList")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "查询输液注射科室列表", httpMethod = "POST", notes = "查询输液注射科室列表")
	public ReturnEntity<List<SyKsResp>> doQuerySyksList(
			@ApiParam(name = "kslb", value = "科室类别  1：输液室  2：注射室", required = true) @RequestParam(value = "kslb") String kslb,
			@ApiParam(name = "ksdm", value = "输液科室代码", required = true) @RequestParam(value = "ksdm") Integer ksdm) {
		List<SyKsResp> resp = syKsSer.doQuerySyksList(getUser().getHospitalId(), ksdm, kslb, null);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 输液注射科室新增修改
	 * 
	 * @param syKs
	 * @return
	 */
	@RequestMapping("/doSaveSyks")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "输液注射科室新增修改", httpMethod = "POST", notes = "输液注射科室新增修改")
	public ReturnEntity<?> doSaveSyks(@Valid SyKsAddReq req) {
		req.setJgid(getUser().getHospitalId());
		syKsSer.doSaveSyks(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 输液注射科室启用停用
	 * 
	 * @param syKs
	 * @return
	 */
	@RequestMapping("/doUpdateZt")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "输液注射科室启用停用", httpMethod = "POST", notes = "输液注射科室启用停用")
	public ReturnEntity<?> doUpdateZt(@Valid SyKsAddReq req) {
		req.setJgid(getUser().getHospitalId());
		syKsSer.getEntityMapper().doUpdateZt(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 校验条码规则重复
	 * 
	 * @param syKs
	 * @return
	 */
	@RequestMapping("/doValidDjdh")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "校验条码规则重复", httpMethod = "POST", notes = "校验条码规则重复")
	public ReturnEntity<Boolean> doValidDjdh(
			@ApiParam(name = "kslb", value = "科室类别  1：输液室  2：注射室", required = true) @RequestParam(value = "kslb") String kslb,
			@ApiParam(name = "sxhws", value = "顺序号位数", required = true) @RequestParam(value = "sxhws") Integer sxhws,
			@ApiParam(name = "tmscgz", value = "条码生成规则", required = true) @RequestParam(value = "tmscgz") String tmscgz,
			@ApiParam(name = "ksdm", value = "科室代码") @RequestParam(value = "ksdm",required = false) Integer ksdm) {
		Boolean isValid = syKsSer.doValidDjdh(getUser().getHospitalId(), tmscgz, kslb, sxhws, ksdm);
		return ReturnEntityUtil.success(isValid);
	}

//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<SyKsResp>> queryPage(SyKsReq syks,PageQuery page){
//        PageInfo<SyKs> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> syKsSer.findByEntity(syks)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<SyKsResp>> getByEntity( SyKsReq syks){//@RequestBody 
//        return ReturnEntityUtil.success(syKsSer.findByEntity(syks));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<SyKsResp> getOneByEntity(SyKsReq syks){
//        List<SyKs> list=syKsSer.findByEntity(syks);
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
//    public ReturnEntity<SyKsResp> add(SyKsReq syKs) {
//        syKsSer.insert(syKs);        
//        return ReturnEntityUtil.success(syKs);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<SyKsResp> edit(SyKsReq syKs)  {
//        syKsSer.update(syKs);        
//        return ReturnEntityUtil.success(syKs);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<SyKsResp> delete(SyKsReq syKs) {
//        syKsSer.removeByEntity(syKs);        
//        return ReturnEntityUtil.success(syKs);            
//    }

}
