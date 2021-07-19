package com.buit.his.op.infusion.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.model.SkinXmldsfxm;
import com.buit.commons.request.SkinXmldsfxmAddReq;
import com.buit.commons.request.SkinXmldsfxmReq;
import com.buit.commons.response.SkinXmldsfxmResp;
import com.buit.his.op.infusion.service.SkinXmldsfxmSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <br>
 * 
 * @author WY
 */
@Api(tags = "皮试联动收费项目")
@Controller
@RequestMapping("/skinxmldsfxm")
public class SkinXmldsfxmCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(SkinXmldsfxmCtr.class);

	@Autowired
	private SkinXmldsfxmSer skinXmldsfxmSer;

	/**
	 * 根据皮试ID获取联动收费项目
	 * 
	 * @param psid
	 * @return
	 */
	@RequestMapping("/doQueryLdsfxmList")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "根据皮试ID获取联动收费项目", httpMethod = "POST", notes = "根据皮试ID获取联动收费项目")
	public ReturnEntity<List<SkinXmldsfxmResp>> doQueryLdsfxmList(
			@ApiParam(name = "psid", value = "皮试项目主键", required = true) @RequestParam(value = "psid") Integer psid) {
		SkinXmldsfxm skinXmldsfxm = new SkinXmldsfxm();
		skinXmldsfxm.setJgid(getUser().getHospitalId());
		skinXmldsfxm.setPsid(psid);
		List<SkinXmldsfxmResp> resp = skinXmldsfxmSer.doQueryLdsfxmList(skinXmldsfxm);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 联动收费项目新增修改
	 * 
	 * @param list
	 * @return
	 */
	@RequestMapping("/doSaveLdsfxm")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "联动收费项目新增修改", httpMethod = "POST", notes = "联动收费项目新增修改")
	public ReturnEntity<?> doSaveLdsfxm(@RequestBody List<SkinXmldsfxmAddReq> list) {
		skinXmldsfxmSer.doSaveLdsfxm(list, getUser().getHospitalId());
		return ReturnEntityUtil.success();
	}

	/**
	 * 联动收费项目删除
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doDeleteLdsfxm")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "联动收费项目删除", httpMethod = "POST", notes = "联动收费项目删除")
	public ReturnEntity<?> doDeleteLdsfxm(@Valid SkinXmldsfxmReq req) {
		req.setJgid(getUser().getHospitalId());
		skinXmldsfxmSer.doDeleteLdsfxm(req);
		return ReturnEntityUtil.success();
	}

//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<SkinXmldsfxmResp>> queryPage(SkinXmldsfxmReq skinxmldsfxm,PageQuery page){
//        PageInfo<SkinXmldsfxm> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> skinXmldsfxmSer.findByEntity(skinxmldsfxm)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<SkinXmldsfxmResp>> getByEntity( SkinXmldsfxmReq skinxmldsfxm){//@RequestBody 
//        return ReturnEntityUtil.success(skinXmldsfxmSer.findByEntity(skinxmldsfxm));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<SkinXmldsfxmResp> getOneByEntity(SkinXmldsfxmReq skinxmldsfxm){
//        List<SkinXmldsfxm> list=skinXmldsfxmSer.findByEntity(skinxmldsfxm);
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
//    public ReturnEntity<SkinXmldsfxmResp> add(SkinXmldsfxmReq skinXmldsfxm) {
//        skinXmldsfxmSer.insert(skinXmldsfxm);        
//        return ReturnEntityUtil.success(skinXmldsfxm);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<SkinXmldsfxmResp> edit(SkinXmldsfxmReq skinXmldsfxm)  {
//        skinXmldsfxmSer.update(skinXmldsfxm);        
//        return ReturnEntityUtil.success(skinXmldsfxm);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<SkinXmldsfxmResp> delete(SkinXmldsfxmReq skinXmldsfxm) {
//        skinXmldsfxmSer.removeByEntity(skinXmldsfxm);        
//        return ReturnEntityUtil.success(skinXmldsfxm);            
//    }

}
