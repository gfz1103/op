
package com.buit.his.op.reg.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseException;
import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.commons.model.OpYgpj;
import com.buit.commons.request.OpYgpjAddReq;
import com.buit.commons.request.OpYgpjReq;
import com.buit.his.op.reg.service.OpYgpjSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 门诊_门诊员工票据<br>
 * 
 * @author WY
 */
@Api(tags = "票据号码维护")
@Controller
@RequestMapping("/opygpj")
public class OpYgpjCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(OpYgpjCtr.class);

	@Autowired
	private OpYgpjSer opYgpjSer;

	/**
	 * 发票号码维护、就诊号码维护、门诊号码维护分页查询
	 * 
	 * @param req
	 * @param page
	 * @return
	 */
	@RequestMapping("/queryPage")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "发票号码维护、就诊号码维护、门诊号码维护分页查询", httpMethod = "POST", notes = "发票号码维护、就诊号码维护、门诊号码维护分页查询")
	public ReturnEntity<PageInfo<OpYgpj>> queryPage(@Valid OpYgpjReq req, PageQuery page) {
		OpYgpj opYgpj = new OpYgpj();
		req.setJgid(getUser().getHospitalId());
		req.setYgdm(getUser().getUserId());
		BeanUtils.copyProperties(req, opYgpj);
		PageInfo<OpYgpj> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> opYgpjSer.getYgpjInfo(opYgpj));
		return ReturnEntityUtil.success(pageInfo);
	}

	/**
	 * 发票号码维护、就诊号码维护、门诊号码维护 新增
	 * 
	 * @param opYgpj
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "发票号码维护、就诊号码维护、门诊号码维护 新增", httpMethod = "POST", notes = "发票号码维护、就诊号码维护、门诊号码维护 新增")
	public ReturnEntity<?> add(@Valid @RequestBody OpYgpjAddReq req) {
		req.setJgid(getUser().getHospitalId());
//		req.setYgdm(getUser().getUserId());
		opYgpjSer.add(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 发票号码维护、就诊号码维护、门诊号码维护修改
	 * 
	 * @param opYgpj
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "发票号码维护、就诊号码维护、门诊号码维护修改", httpMethod = "POST", notes = "发票号码维护、就诊号码维护、门诊号码维护修改")
	public ReturnEntity<?> edit(@Valid @RequestBody OpYgpjAddReq req) {
		req.setJgid(getUser().getHospitalId());
		opYgpjSer.updateSyhm(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 发票号码维护、就诊号码维护、门诊号码维护删除
	 * 
	 * @param jlxh
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "发票号码维护、就诊号码维护、门诊号码维护删除", httpMethod = "POST", notes = "发票号码维护、就诊号码维护、门诊号码维护删除")
	public ReturnEntity<?> delete(
			@ApiParam(name = "jlxh", value = "记录序号", required = true) @RequestParam(value = "jlxh") Integer jlxh) {
		OpYgpj opYgpj = opYgpjSer.getById(jlxh);
		if (opYgpj != null) {
			if (!opYgpj.getQshm().equals(opYgpj.getSyhm())) {
				throw BaseException.create("ERROR_REG_0055");
			}
		}
		opYgpjSer.getEntityMapper().deleteById(jlxh);
		return ReturnEntityUtil.success();
	}


	/**
	 * 发票号码维护、就诊号码维护、门诊号码维护删除
	 *
	 * @param pjlx
	 * @return
	 */
	@RequestMapping("/getPjhm")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "根据票据类型查询票据号码", httpMethod = "POST", notes = "根据票据类型查询票据号码")
	public ReturnEntity<?> getPjhm(
			@ApiParam(name = "pjlx", value = "1-就诊号码 2-发票号码 3-档案号码 4-充值号码", required = true) @RequestParam(value = "pjlx") Integer pjlx) {
		return ReturnEntityUtil.success(opYgpjSer.getPjhm(getUser().getHospitalId(), getUser().getUserId(), pjlx));
	}


    @RequestMapping("/updateStatus")
    @ResponseBody
    @ApiOperation(value="更新票据的使用判别" ,httpMethod="POST")
    public ReturnEntity<?> updateStatus(
			@ApiParam(name = "pjlx", value = "1-就诊号码 2-发票号码 3-档案号码 4-充值号码", required = true) @RequestParam(value = "pjlx") Integer pjlx,
			@ApiParam(name = "sypb", value = "使用判别 0-启用 1-不启用", required = true) @RequestParam(value = "sypb") Integer sypb,
			@ApiParam(name = "jlxh", value = "记录序号", required = true) @RequestParam(value = "jlxh") Integer jlxh){//@RequestBody
		opYgpjSer.updateStatus(getUser(), pjlx, jlxh, sypb);
        return ReturnEntityUtil.success();
    }


	@RequestMapping("/jqhm")
	@ResponseBody
	@ApiOperation(value="截取就诊号码" ,httpMethod="POST")
	public ReturnEntity<?> jqhm(
			@ApiParam(name = "jlxh", value = "记录序号", required = true) @RequestParam(value = "jlxh") Integer jlxh){//@RequestBody
		opYgpjSer.jqhm(jlxh);
		return ReturnEntityUtil.success();
	}

//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<OpYgpjResp> getOneByEntity(OpYgpjReq opygpj){
//        List<OpYgpj> list=opYgpjSer.findByEntity(opygpj);
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
//    public ReturnEntity<OpYgpjResp> add(OpYgpjReq opYgpj) {
//        opYgpjSer.insert(opYgpj);        
//        return ReturnEntityUtil.success(opYgpj);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<OpYgpjResp> edit(OpYgpjReq opYgpj)  {
//        opYgpjSer.update(opYgpj);
//        return ReturnEntityUtil.success(opYgpj);
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<OpYgpjResp> delete(OpYgpjReq opYgpj) {
//        opYgpjSer.removeByEntity(opYgpj);        
//        return ReturnEntityUtil.success(opYgpj);            
//    }

}
