package com.buit.his.op.reg.controller;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.commons.model.OpKspb;
import com.buit.commons.model.OpYspb;
import com.buit.commons.request.*;
import com.buit.his.op.reg.service.OpKspbSer;
import com.buit.his.op.reg.service.OpYspbSer;
import com.buit.system.response.OpKspbPerson;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

/**
 * 门诊_门诊医生排班<br>
 *
 * @author LAPTOP-VAONTPUB
 */
@Api(tags = "医生排班维护")
@Controller
@RequestMapping("/opyspb")
public class OpYspbCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(OpYspbCtr.class);

	@Autowired
	private OpYspbSer opYspbSer;

	@Autowired
	private OpKspbSer opKspbSer;

	/**
	 * 医生排班维护分页条件查询
	 *
	 * @param opyspb
	 * @param page
	 * @return
	 */
	@RequestMapping("/queryPage")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "医生排班维护分页条件查询", httpMethod = "POST", notes = "医生排班维护左侧信息")
	public ReturnEntity<List<OpYspb>> queryPage(@Valid OpYspbReq opyspb, PageQuery page) {
		opyspb.setJgid(getUser().getHospitalId());
		List<OpYspb> respList = opYspbSer.getYspbList(opyspb);
		return ReturnEntityUtil.success(respList);
	}

	/**
	 * 医生排班-当日科室排班信息
	 *
	 * @param opkspb
	 * @return
	 */
	@RequestMapping("/findList")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "当日科室医生列表", httpMethod = "POST", notes = "医生排班维护右侧信息")
	public ReturnEntity<List<OpKspbPerson>> getByEntity(@Valid OpYspbReq opkspb) {
		opkspb.setJgid(getUser().getHospitalId());
		return ReturnEntityUtil.success(opYspbSer.getKspbList(opkspb));
	}

	/**
	 * 医生排班-当日科室列表
	 *
	 * @param opkspb
	 * @return
	 */
	@RequestMapping("/findDeptList")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "医生排班-当日科室列表", httpMethod = "POST", notes = "医生排班-当日科室列表")
	public ReturnEntity<List<OpKspb>> findDeptList(@Valid OpKspbReq req) {
		req.setJgid(getUser().getHospitalId());
		return ReturnEntityUtil.success(opKspbSer.getDeptList(req));
	}

	/**
	 * 医生排班维护-复制一条 doCopyOneRecordPlan
	 *
	 * @param opkspb
	 * @return
	 */
	@RequestMapping("/addCopy")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "医生排班维护-复制一条", httpMethod = "POST", notes = "医生排班维护-复制一条")
	public ReturnEntity<?> addCopy(@Valid OpYspbCopyReq req) {
		req.setJgid(getUser().getHospitalId());
		opYspbSer.addCopy(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 医生排班维护-复制一周 doSave_copyYSPB_JK
	 *
	 * @param opkspb
	 * @return
	 */
	@RequestMapping("/addCopyWeeks")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "医生排班维护-复制一周", httpMethod = "POST", notes = "医生排班维护-复制一周")
	public ReturnEntity<?> addCopyWeeks(@Valid OpYspbCopyReq req) {
		req.setJgid(getUser().getHospitalId());
		opYspbSer.addCopyWeeks(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 保存
	 *
	 * @param opKspb
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "保存", httpMethod = "POST", notes = "保存")
	public ReturnEntity<?> add(@RequestBody List<OpYspbAddReq> req) {
		Integer jgid = getUser().getHospitalId();
		opYspbSer.add(req, jgid);
		return ReturnEntityUtil.success();
	}

	/**
	 * 删除doRemoveRegistrationDoctorPlan
	 *
	 * @param opKspb
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "删除", httpMethod = "POST", notes = "删除")
	public ReturnEntity<?> delete(OpYspbDelReq req) {
		req.setJgid(getUser().getHospitalId());
		opYspbSer.delete(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 医生排班时校验医生的值班类别
	 *
	 * @param opkspb
	 * @return
	 */
	@RequestMapping("/doVaildYspbByZblb")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "医生排班时校验医生的值班类别", httpMethod = "POST", notes = "医生排班时校验医生的值班类别")
	public ReturnEntity<?> doVaildYspbByZblb(
			@ApiParam(name = "gzrq", value = "工作日期") @RequestParam(value = "gzrq") Date gzrq,
			@ApiParam(name = "zblb", value = "值班类别") @RequestParam(value = "zblb") String zblb,
			@ApiParam(name = "ysdm", value = "医生代码") @RequestParam(value = "ysdm") Integer ysdm,
			@ApiParam(name = "ksdm", value = "科室代码") @RequestParam(value = "ksdm") Integer ksdm) {
		opYspbSer.doVaildYspbByZblb(gzrq, zblb, ysdm, ksdm, getUser().getHospitalId());
		return ReturnEntityUtil.success();
	}

//
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<OpYspbResp> getOneByEntity(OpYspbReq opyspb){
//        List<OpYspb> list=opYspbSer.findByEntity(opyspb);
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
//    public ReturnEntity<OpYspbResp> add(OpYspbReq opYspb) {
//        opYspbSer.insert(opYspb);
//        return ReturnEntityUtil.success(opYspb);
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<OpYspbResp> edit(OpYspbReq opYspb)  {
//        opYspbSer.update(opYspb);
//        return ReturnEntityUtil.success(opYspb);
//    }
//
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<OpYspbResp> delete(OpYspbReq opYspb) {
//        opYspbSer.removeByEntity(opYspb);
//        return ReturnEntityUtil.success(opYspb);
//    }

}
