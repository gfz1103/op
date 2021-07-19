
package com.buit.his.op.infusion.controller;

import java.util.Collections;
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
import com.buit.commons.PageQuery;
import com.buit.commons.request.QueryAllDjCountReq;
import com.buit.commons.request.QueryDjCfListReq;
import com.buit.commons.request.QuerySyJydjzbReq;
import com.buit.commons.request.QueryUnregistReq;
import com.buit.commons.request.SaveRegistReq;
import com.buit.commons.response.QueryAllDjCountResp;
import com.buit.commons.response.QueryDjCfListResp;
import com.buit.commons.response.QuerySyJydjzbResp;
import com.buit.commons.response.QuerySyptdyResp;
import com.buit.commons.response.QueryUnRegistResp;
import com.buit.commons.response.UnRegistResp;
import com.buit.his.op.infusion.service.SyJydjzbSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 输液/注射接药登记主表<br>
 * 
 * @author WY
 */
@Api(tags = "输液注射接药登记")
@Controller
@RequestMapping("/syjydjzb")
public class SyJydjzbCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(SyJydjzbCtr.class);

	@Autowired
	private SyJydjzbSer syJydjzbSer;

	@RequestMapping("/doQuerySyJydjList")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "输液注射接药分页查询", httpMethod = "POST", notes = "输液注射接药分页查询")
	public ReturnEntity<PageInfo<QuerySyJydjzbResp>> doQuerySyJydjList(@Valid QuerySyJydjzbReq req, PageQuery page) {
		req.setJgid(getUser().getHospitalId());
		PageInfo<QuerySyJydjzbResp> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> syJydjzbSer.doQuerySyJydjList(req));
		return ReturnEntityUtil.success(pageInfo);
	}

	@RequestMapping("/doQueryUnregistList")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "查询病人已收费、已发药、未输液注射的处方", httpMethod = "POST", notes = "查询病人已收费、已发药、未输液注射的处方")
	public ReturnEntity<UnRegistResp> doQueryUnregistList(QueryUnregistReq req) {
		req.setJgid(getUser().getHospitalId());
		UnRegistResp resp = syJydjzbSer.doQueryUnregistList(req);
		return ReturnEntityUtil.success(resp);
	}

	@RequestMapping("/doSySaveRegist")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "输液注射登记", httpMethod = "POST", notes = "输液注射登记")
	public ReturnEntity<?> doSySaveRegist(@RequestBody @Valid SaveRegistReq req) {
		req.setJgid(getUser().getHospitalId());
		return ReturnEntityUtil.success(Collections.singletonMap("djdh", syJydjzbSer.doSySaveRegist(req)));
	}

	@RequestMapping("/doQueryRegistList")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "查询病人的输液注射处方", httpMethod = "POST", notes = "查询病人的输液注射处方")
	public ReturnEntity<List<QueryUnRegistResp>> doQueryRegistList(
			@ApiParam(name = "djdh", value = "登记单号", required = true) @RequestParam(value = "djdh") String djdh,
			@ApiParam(name = "ksdm", value = "输液科室代码", required = true) @RequestParam(value = "ksdm") Integer ksdm) {
		List<QueryUnRegistResp> resp = syJydjzbSer.doQueryRegistList(djdh, ksdm, getUser().getHospitalId());
		return ReturnEntityUtil.success(resp);
	}

	@RequestMapping("/startShuYe")
	@ResponseBody
	@ApiOperation(value = "输液开始", httpMethod = "POST")
	public ReturnEntity<?> startShuYe(
			@ApiParam(name = "djdhs", value = "输液登记单号,多个单号用逗号分割", required = true) @RequestParam(value = "djdhs") String djdhs) {
		syJydjzbSer.startShuYe(djdhs, getUser().getHospitalId(), getUser().getUserId());
		return ReturnEntityUtil.success();
	}

	@RequestMapping("/doUpdateSyZt")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "输液注射完成", httpMethod = "POST", notes = "输液注射完成")
	public ReturnEntity<?> doUpdateSyZt(
			@ApiParam(name = "djdhs", value = "输液完成登记单号,多个单号用逗号分割", required = true) @RequestParam(value = "djdhs") String djdhs) {
		syJydjzbSer.doUpdateSyZt(djdhs, getUser().getHospitalId(), getUser().getUserId());
		return ReturnEntityUtil.success();
	}

	@RequestMapping("/doQueryAllDjCount")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "输液注射工作量统计人次", httpMethod = "POST", notes = "输液注射工作量统计人次")
	public ReturnEntity<List<QueryAllDjCountResp>> doQueryAllDjCount(@Valid QueryAllDjCountReq req, PageQuery page) {
		req.setJgid(getUser().getHospitalId());
//		PageInfo<QueryAllDjCountResp> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
//				.doSelectPageInfo(() -> syJydjzbSer.doQueryAllDjCount(req));
		List<QueryAllDjCountResp> resp = syJydjzbSer.doQueryAllDjCount(req);
		return ReturnEntityUtil.success(resp);
	}

	@RequestMapping("/doQueryDjCfList")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "输液注射工作量统计每日输液数据", httpMethod = "POST", notes = "输液注射工作量统计每日输液数据")
	public ReturnEntity<PageInfo<QueryDjCfListResp>> doQueryDjCfList(@Valid QueryDjCfListReq req, PageQuery page) {
		req.setJgid(getUser().getHospitalId());
		PageInfo<QueryDjCfListResp> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> syJydjzbSer.doQueryDjCfList(req));
		return ReturnEntityUtil.success(pageInfo);
	}

	@RequestMapping("/doPrintSyptdy")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "输液瓶贴打印", httpMethod = "POST", notes = "输液瓶贴打印")
	public ReturnEntity<QuerySyptdyResp> doPrintSyptdy(
			@ApiParam(name = "djdh", value = "登记单号", required = true) @RequestParam(value = "djdh") String djdh,
			@ApiParam(name = "kslb", value = "科室类别", required = true) @RequestParam(value = "kslb") String kslb,
			@ApiParam(name = "ksdm", value = "输液科室代码", required = true) @RequestParam(value = "ksdm") Integer ksdm) {
		QuerySyptdyResp resp = syJydjzbSer.doPrintSyptdy(djdh, kslb, ksdm, getUser().getHospitalId());
		return ReturnEntityUtil.success(resp);
	}

//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<SyJydjzbResp>> queryPage(SyJydjzbReq syjydjzb,PageQuery page){
//        PageInfo<SyJydjzb> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> syJydjzbSer.findByEntity(syjydjzb)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<SyJydjzbResp>> getByEntity( SyJydjzbReq syjydjzb){//@RequestBody 
//        return ReturnEntityUtil.success(syJydjzbSer.findByEntity(syjydjzb));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<SyJydjzbResp> getOneByEntity(SyJydjzbReq syjydjzb){
//        List<SyJydjzb> list=syJydjzbSer.findByEntity(syjydjzb);
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
//    public ReturnEntity<SyJydjzbResp> add(SyJydjzbReq syJydjzb) {
//        syJydjzbSer.insert(syJydjzb);        
//        return ReturnEntityUtil.success(syJydjzb);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<SyJydjzbResp> edit(SyJydjzbReq syJydjzb)  {
//        syJydjzbSer.update(syJydjzb);        
//        return ReturnEntityUtil.success(syJydjzb);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<SyJydjzbResp> delete(SyJydjzbReq syJydjzb) {
//        syJydjzbSer.removeByEntity(syJydjzb);        
//        return ReturnEntityUtil.success(syJydjzb);            
//    }

}
