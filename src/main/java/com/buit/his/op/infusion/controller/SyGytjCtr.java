
package com.buit.his.op.infusion.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.request.SyGytjAddReq;
import com.buit.commons.request.SyGytjReq;
import com.buit.commons.response.SyGytjResp;
import com.buit.his.op.infusion.service.SyGytjSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 输液/注射给药途径设置<br>
 * 
 * @author WY
 */
@Api(tags = "输液注射给药途径设置")
@Controller
@RequestMapping("/sygytj")
public class SyGytjCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(SyGytjCtr.class);

	@Autowired
	private SyGytjSer syGytjSer;

	/**
	 * 查询已选输液注射给药途径列表
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doQueryGytjList")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "查询已选输液注射给药途径列表", httpMethod = "POST", notes = "查询已选输液注射给药途径列表")
	public ReturnEntity<List<SyGytjResp>> doQueryGytjList(@Valid SyGytjReq req) {
		req.setJgid(getUser().getHospitalId());
		List<SyGytjResp> resp = syGytjSer.doQueryGytjList(req);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 输液注射给药途径新增
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doSaveGytj")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "输液注射给药途径新增", httpMethod = "POST", notes = "输液注射给药途径新增")
	public ReturnEntity<?> doSaveGytj(@Valid SyGytjAddReq req) {
		req.setJgid(getUser().getHospitalId());
		syGytjSer.doSaveGytj(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 输液注射给药途径删除
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doDeleteGytj")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "输液注射给药途径删除", httpMethod = "POST", notes = "输液注射给药途径删除")
	public ReturnEntity<?> doDeleteGytj(@Valid SyGytjAddReq req) {
		req.setJgid(getUser().getHospitalId());
		syGytjSer.doDeleteGytj(req);
		return ReturnEntityUtil.success();
	}

//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<SyGytjResp>> queryPage(SyGytjReq sygytj,PageQuery page){
//        PageInfo<SyGytj> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> syGytjSer.findByEntity(sygytj)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<SyGytjResp>> getByEntity( SyGytjReq sygytj){//@RequestBody 
//        return ReturnEntityUtil.success(syGytjSer.findByEntity(sygytj));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<SyGytjResp> getOneByEntity(SyGytjReq sygytj){
//        List<SyGytj> list=syGytjSer.findByEntity(sygytj);
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
//    public ReturnEntity<SyGytjResp> add(SyGytjReq syGytj) {
//        syGytjSer.insert(syGytj);        
//        return ReturnEntityUtil.success(syGytj);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<SyGytjResp> edit(SyGytjReq syGytj)  {
//        syGytjSer.update(syGytj);        
//        return ReturnEntityUtil.success(syGytj);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<SyGytjResp> delete(SyGytjReq syGytj) {
//        syGytjSer.removeByEntity(syGytj);        
//        return ReturnEntityUtil.success(syGytj);            
//    }

}
