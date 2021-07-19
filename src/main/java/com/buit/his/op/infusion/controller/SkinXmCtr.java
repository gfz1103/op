package com.buit.his.op.infusion.controller;

import com.buit.commons.BaseSpringController;
import com.buit.commons.model.SkinXm;
import com.buit.commons.request.OpCf02SaveReq;
import com.buit.commons.request.SkinXmAddReq;
import com.buit.commons.response.SkinXmHzResp;
import com.buit.commons.response.SkinXmResp;
import com.buit.his.op.infusion.service.SkinXmSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * <br>
 *
 * @author WY
 */
@Api(tags = "皮试项目")
@Controller
@RequestMapping("/skinxm")
public class SkinXmCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(SkinXmCtr.class);

	@Autowired
	private SkinXmSer skinXmSer;

	/**
	 * 皮试列表查询
	 * @return
	 */
	@RequestMapping("/doQuerySkinTestList")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "皮试列表查询", httpMethod = "POST", notes = "皮试列表查询")
	public ReturnEntity<List<SkinXmResp>> doQuerySkinTestList() {
		List<SkinXmResp> resp = skinXmSer.doQuerySkinTestList(getUser().getHospitalId());
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 皮试项目新增
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doSaveSkinTest")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "皮试项目新增", httpMethod = "POST", notes = "皮试项目新增")
	public ReturnEntity<?> doSaveSkinTest(@Valid SkinXmAddReq req) {
		req.setJgid(getUser().getHospitalId());
		skinXmSer.doSaveSkinTest(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 皮试项目修改
	 *
	 * @param req
	 * @return
	 */
	@RequestMapping("/doUpdateSkinTest")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "皮试项目修改", httpMethod = "POST", notes = "皮试项目修改")
	public ReturnEntity<?> doUpdateSkinTest(@Valid SkinXmAddReq req) {
		req.setJgid(getUser().getHospitalId());
		skinXmSer.doUpdateSkinTest(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 皮试项目启用停用
	 *
	 * @param psid
	 * @param zt
	 * @return
	 */
	@RequestMapping("/doUpdateZt")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "皮试项目启用停用", httpMethod = "POST", notes = "皮试项目启用停用")
	public ReturnEntity<?> doUpdateZt(
			@ApiParam(name = "psid", value = "皮试项目主键", required = true) @RequestParam(value = "psid") Integer psid,
			@ApiParam(name = "zt", value = "状态 0：启用  1：停用", required = true) @RequestParam(value = "zt") String zt) {
		SkinXm skinXm = new SkinXm();
		skinXm.setJgid(getUser().getHospitalId());
		skinXm.setPsid(psid);
		skinXm.setZt(zt);
		skinXmSer.doUpdateZt(skinXm);
		return ReturnEntityUtil.success();
	}

	/**
	 * 皮试项目删除
	 *
	 * @param psid
	 * @return
	 */
	@RequestMapping("/doDeleteSkinTest")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "皮试项目删除", httpMethod = "POST", notes = "皮试项目删除")
	public ReturnEntity<?> doDeleteSkinTest(
			@ApiParam(name = "psid", value = "皮试项目主键", required = true) @RequestParam(value = "psid") Integer psid) {
		SkinXm skinXm = new SkinXm();
		skinXm.setJgid(getUser().getHospitalId());
		skinXm.setPsid(psid);
		skinXm.setZt("0");
		skinXmSer.doDeleteSkinTest(skinXm);
		return ReturnEntityUtil.success();
	}

	/**
	 * 门诊处方皮试药品带出皮试项目
	 *
	 * @param psid
	 * @return
	 */
	@RequestMapping("/doQueryPsxmHz")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "门诊处方皮试药品带出皮试项目", httpMethod = "POST", notes = "皮试项目删除")
	public ReturnEntity<List<SkinXmHzResp>> doQueryPsxmHz(
			@ApiParam(name = "psid", value = "皮试项目主键") @RequestParam(required = false,value = "psid") Integer psid) {
		if (psid == null){
			List<SkinXmHzResp> skinXmHzResps = new ArrayList<>();
			return ReturnEntityUtil.success(skinXmHzResps);
		}
		SkinXm skinXm = new SkinXm();
		skinXm.setJgid(getUser().getHospitalId());
		skinXm.setPsid(psid);
		skinXm.setZt("0");
		List<SkinXmHzResp> result = skinXmSer.doQueryPsxmHz(skinXm);
		return ReturnEntityUtil.success(result);
	}

	@RequestMapping("/getPsxmByDrugs")
	@ResponseBody
	@ApiOperationSupport(author = "韦靖")
	@ApiOperation(value = "通过处方药品查询皮试项目列表", httpMethod = "POST")
	public ReturnEntity<List<SkinXmHzResp>> doQueryPsxmHz(@RequestBody List<OpCf02SaveReq> drugs) {
		return ReturnEntityUtil.success(skinXmSer.getPsxmByDrugs(drugs));
	}





//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<SkinXmResp>> queryPage(SkinXmReq skinxm,PageQuery page){
//        PageInfo<SkinXm> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> skinXmSer.findByEntity(skinxm)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<SkinXmResp>> getByEntity( SkinXmReq skinxm){//@RequestBody
//        return ReturnEntityUtil.success(skinXmSer.findByEntity(skinxm));
//    }
//
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<SkinXmResp> getOneByEntity(SkinXmReq skinxm){
//        List<SkinXm> list=skinXmSer.findByEntity(skinxm);
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
//    public ReturnEntity<SkinXmResp> add(SkinXmReq skinXm) {
//        skinXmSer.insert(skinXm);
//        return ReturnEntityUtil.success(skinXm);
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<SkinXmResp> edit(SkinXmReq skinXm)  {
//        skinXmSer.update(skinXm);
//        return ReturnEntityUtil.success(skinXm);
//    }
//
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<SkinXmResp> delete(SkinXmReq skinXm) {
//        skinXmSer.removeByEntity(skinXm);
//        return ReturnEntityUtil.success(skinXm);
//    }

}
