
package com.buit.his.op.infusion.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.commons.request.PsDjReq;
import com.buit.commons.request.PsProcessReq;
import com.buit.commons.request.QueryAllPsDjCountReq;
import com.buit.commons.request.QueryDjmxReq;
import com.buit.commons.request.QueryPsAllergyReq;
import com.buit.commons.request.QueryPsDjCfListReq;
import com.buit.commons.request.QueryUnSkinTestReq;
import com.buit.commons.request.SavePsRegistReq;
import com.buit.commons.response.PsDjResp;
import com.buit.commons.response.QueryAllPsDjCountResp;
import com.buit.commons.response.QueryPsAllergyResp;
import com.buit.commons.response.QueryPsDjListResp;
import com.buit.commons.response.QueryUnRegistResp;
import com.buit.commons.response.QueryUnSkinTestResp;
import com.buit.his.op.infusion.service.SkinDjzbSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <br>
 * 
 * @author WY
 */
@Api(tags = "皮试登记")
@Controller
@RequestMapping("/skindjzb")
public class SkinDjzbCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(SkinDjzbCtr.class);

	@Autowired
	private SkinDjzbSer skinDjzbSer;

	/**
	 * 皮试列表分页查询
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doQueryPsDjList")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "皮试列表分页查询", httpMethod = "POST", notes = "皮试列表分页查询")
	public ReturnEntity<PageInfo<PsDjResp>> doQueryPsDjList(PsDjReq req, PageQuery page) {
		req.setJgid(getUser().getHospitalId());
		PageInfo<PsDjResp> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> skinDjzbSer.doQueryPsDjList(req));
		return ReturnEntityUtil.success(pageInfo);
	}

	/**
	 * 查询病人已收费、未执行的皮试项目
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doQueryUnSkinTest")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "查询病人已收费、未执行的皮试项目", httpMethod = "POST", notes = "查询病人已收费、未执行的皮试项目")
	public ReturnEntity<QueryUnSkinTestResp> doQueryUnSkinTest(QueryUnSkinTestReq req) {
		req.setJgid(getUser().getHospitalId());
		QueryUnSkinTestResp resp = skinDjzbSer.doQueryUnSkinTest(req);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 皮试登记
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doPsSaveRegist")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "皮试登记", httpMethod = "POST", notes = "皮试登记")
	public ReturnEntity<?> doPsSaveRegist(@RequestBody SavePsRegistReq req) {
		req.setJgid(getUser().getHospitalId());
		skinDjzbSer.doPsSaveRegist(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 开始皮试
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doPsProcess")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "开始皮试", httpMethod = "POST", notes = "开始皮试")
	public ReturnEntity<?> doPsProcess(PsProcessReq req) {
		req.setJgid(getUser().getHospitalId());
		skinDjzbSer.doPsProcess(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 取消登记
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doPsCancel")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "取消登记", httpMethod = "POST", notes = "取消登记")
	public ReturnEntity<?> doPsCancel(PsProcessReq req) {
		req.setJgid(getUser().getHospitalId());
		skinDjzbSer.doPsCancel(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 结束皮试
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doPsFinish")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "结束皮试", httpMethod = "POST", notes = "结束皮试")
	public ReturnEntity<?> doPsFinish(PsProcessReq req) {
		req.setJgid(getUser().getHospitalId());
		skinDjzbSer.doPsFinish(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 根据登记单号查询登记明细
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doQueryDjmx")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "根据登记单号查询登记明细", httpMethod = "POST", notes = "根据登记单号查询登记明细")
	public ReturnEntity<List<QueryUnRegistResp>> doQueryDjmx(QueryDjmxReq req) {
		req.setJgid(getUser().getHospitalId());
		List<QueryUnRegistResp> resp = skinDjzbSer.doQueryDjmx(req);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 皮试工作量统计人次
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doQueryAllDjCount")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "皮试工作量统计人次", httpMethod = "POST", notes = "皮试工作量统计人次")
	public ReturnEntity<List<QueryAllPsDjCountResp>> doQueryAllDjCount(QueryAllPsDjCountReq req, PageQuery page) {
		req.setJgid(getUser().getHospitalId());
		List<QueryAllPsDjCountResp> pageInfo = skinDjzbSer.doQueryAllDjCount(req);
		return ReturnEntityUtil.success(pageInfo);
	}

	/**
	 * 皮试工作量统计每日输液数据
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doQueryDjList")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "皮试工作量统计每日输液数据", httpMethod = "POST", notes = "皮试工作量统计每日输液数据")
	public ReturnEntity<PageInfo<QueryPsDjListResp>> doQueryDjList(QueryPsDjCfListReq req, PageQuery page) {
		req.setJgid(getUser().getHospitalId());
		PageInfo<QueryPsDjListResp> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> skinDjzbSer.doQueryDjList(req));
		return ReturnEntityUtil.success(pageInfo);
	}

	/**
	 * 皮试阳性率统计
	 * 
	 * @param req
	 * @param page
	 * @return
	 */
	@RequestMapping("/doQueryPsAllergy")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "皮试阳性率统计", httpMethod = "POST", notes = "皮试阳性率统计")
	public ReturnEntity<PageInfo<QueryPsAllergyResp>> doQueryPsAllergy(QueryPsAllergyReq req, PageQuery page) {
		req.setJgid(getUser().getHospitalId());
		PageInfo<QueryPsAllergyResp> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> skinDjzbSer.doQueryPsAllergy(req));
		return ReturnEntityUtil.success(pageInfo);
	}

//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<SkinDjzbResp>> queryPage(SkinDjzbReq skindjzb,PageQuery page){
//        PageInfo<SkinDjzb> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> skinDjzbSer.findByEntity(skindjzb)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<SkinDjzbResp>> getByEntity( SkinDjzbReq skindjzb){//@RequestBody 
//        return ReturnEntityUtil.success(skinDjzbSer.findByEntity(skindjzb));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<SkinDjzbResp> getOneByEntity(SkinDjzbReq skindjzb){
//        List<SkinDjzb> list=skinDjzbSer.findByEntity(skindjzb);
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
//    public ReturnEntity<SkinDjzbResp> add(SkinDjzbReq skinDjzb) {
//        skinDjzbSer.insert(skinDjzb);        
//        return ReturnEntityUtil.success(skinDjzb);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<SkinDjzbResp> edit(SkinDjzbReq skinDjzb)  {
//        skinDjzbSer.update(skinDjzb);        
//        return ReturnEntityUtil.success(skinDjzb);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<SkinDjzbResp> delete(SkinDjzbReq skinDjzb) {
//        skinDjzbSer.removeByEntity(skinDjzb);        
//        return ReturnEntityUtil.success(skinDjzb);            
//    }

}
