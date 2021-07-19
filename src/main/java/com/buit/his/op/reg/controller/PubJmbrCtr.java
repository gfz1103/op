
package com.buit.his.op.reg.controller;

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
import com.buit.commons.PageQuery;
import com.buit.commons.model.PubJmbr;
import com.buit.commons.request.SaveFybrReq;
import com.buit.commons.response.PubJmbrResp;
import com.buit.his.op.reg.service.PubJmbrSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 妇幼病人<br>
 * 
 * @author WY
 */
@Api(tags = "减免患者")
@Controller
@RequestMapping("/pubjmbr")
public class PubJmbrCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(PubJmbrCtr.class);

	@Autowired
	private PubJmbrSer pubJmbrSer;

	/**
	 * 减免患者分页查询
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("/queryPage")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "减免患者分页查询", httpMethod = "POST", notes = "减免患者分页查询")
	public ReturnEntity<PageInfo<PubJmbrResp>> queryPage(
			@ApiParam(name = "fydw", value = "妇幼单位主键", required = true) @RequestParam(value = "fydw") Integer fydw,
			PageQuery page) {
		PubJmbr pubJmbr = new PubJmbr();
		pubJmbr.setFydw(fydw);
		PageInfo<PubJmbrResp> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> pubJmbrSer.findByEntity(pubJmbr));
		return ReturnEntityUtil.success(pageInfo);
	}

	/**
	 * 新增修改减免患者
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doSaveFybr")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "新增修改减免患者", httpMethod = "POST", notes = "新增修改减免患者")
	public ReturnEntity<?> doSaveFybr(@RequestBody @Valid SaveFybrReq req) {
		pubJmbrSer.doSaveFybr(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 删除减免患者
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doDeleteFybr")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "删除减免患者", httpMethod = "POST", notes = "删除减免患者")
	public ReturnEntity<?> doDeleteFybr(
			@ApiParam(name = "fyzh", value = "证号", required = true) @RequestParam(value = "fyzh") String fyzh) {
		pubJmbrSer.getEntityMapper().deleteById(fyzh);
		return ReturnEntityUtil.success();
	}

//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<PubJmbrResp>> queryPage(PubJmbrReq pubjmbr,PageQuery page){
//        PageInfo<PubJmbr> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> pubJmbrSer.findByEntity(pubjmbr)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<PubJmbrResp>> getByEntity( PubJmbrReq pubjmbr){//@RequestBody 
//        return ReturnEntityUtil.success(pubJmbrSer.findByEntity(pubjmbr));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<PubJmbrResp> getOneByEntity(PubJmbrReq pubjmbr){
//        List<PubJmbr> list=pubJmbrSer.findByEntity(pubjmbr);
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
//    public ReturnEntity<PubJmbrResp> add(PubJmbrReq pubJmbr) {
//        pubJmbrSer.insert(pubJmbr);        
//        return ReturnEntityUtil.success(pubJmbr);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<PubJmbrResp> edit(PubJmbrReq pubJmbr)  {
//        pubJmbrSer.update(pubJmbr);        
//        return ReturnEntityUtil.success(pubJmbr);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<PubJmbrResp> delete(PubJmbrReq pubJmbr) {
//        pubJmbrSer.removeByEntity(pubJmbr);        
//        return ReturnEntityUtil.success(pubJmbr);            
//    }

}
