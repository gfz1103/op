
package com.buit.his.op.infusion.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.model.SyDyj;
import com.buit.commons.request.SaveSyDyjReq;
import com.buit.commons.response.SyDyjResp;
import com.buit.his.op.infusion.service.SyDyjSer;
import com.buit.utill.BeanUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 打印机<br>
 * 
 * @author WY
 */
@Api(tags = "打印机")
@Controller
@RequestMapping("/sydyj")
public class SyDyjCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(SyDyjCtr.class);

	@Autowired
	private SyDyjSer syDyjSer;

	/**
	 * 输液瓶贴打印机列表
	 * 
	 * @param ksdm
	 * @return
	 */
	@RequestMapping("/doQuerySyptdyj")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "输液瓶贴打印机列表", httpMethod = "POST", notes = "输液瓶贴打印机列表")
	public ReturnEntity<List<SyDyjResp>> doQuerySyptdyj(
			@ApiParam(name = "ksdm", value = "输液科室代码") @RequestParam(value = "ksdm") Integer ksdm) {
		List<SyDyjResp> resp = syDyjSer.doQuerySyptdyj(ksdm, getUser().getHospitalId());
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 输液巡回单打印机列表
	 * 
	 * @param ksdm
	 * @return
	 */
	@RequestMapping("/doQuerySyxhddyj")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "输液巡回单打印机列表", httpMethod = "POST", notes = "输液巡回单打印机列表")
	public ReturnEntity<List<SyDyjResp>> doQuerySyxhddyj(
			@ApiParam(name = "ksdm", value = "输液科室代码") @RequestParam(value = "ksdm") Integer ksdm) {
		List<SyDyjResp> resp = syDyjSer.doQuerySyxhddyj(ksdm, getUser().getHospitalId());
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 输液瓶贴或巡回单打印机保存
	 * 
	 * @param ksdm
	 * @return
	 */
	@RequestMapping("/doSaveSydyj")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "输液瓶贴或巡回单打印机保存", httpMethod = "POST", notes = "输液瓶贴或巡回单打印机保存")
	public ReturnEntity<?> doSaveOrUpdateSydyj(@RequestBody SaveSyDyjReq req) {
		req.setJgid(getUser().getHospitalId());
		SyDyj syDyj = BeanUtil.toBean(req, SyDyj.class);
		syDyjSer.doSaveOrUpdateSydyj(syDyj);
		return ReturnEntityUtil.success();
	}

//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<SyDyjResp>> queryPage(SyDyjReq sydyj,PageQuery page){
//        PageInfo<SyDyj> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> syDyjSer.findByEntity(sydyj)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<SyDyjResp>> getByEntity( SyDyjReq sydyj){//@RequestBody 
//        return ReturnEntityUtil.success(syDyjSer.findByEntity(sydyj));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<SyDyjResp> getOneByEntity(SyDyjReq sydyj){
//        List<SyDyj> list=syDyjSer.findByEntity(sydyj);
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
//    public ReturnEntity<SyDyjResp> add(SyDyjReq syDyj) {
//        syDyjSer.insert(syDyj);        
//        return ReturnEntityUtil.success(syDyj);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<SyDyjResp> edit(SyDyjReq syDyj)  {
//        syDyjSer.update(syDyj);        
//        return ReturnEntityUtil.success(syDyj);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<SyDyjResp> delete(SyDyjReq syDyj) {
//        syDyjSer.removeByEntity(syDyj);        
//        return ReturnEntityUtil.success(syDyj);            
//    }

}
