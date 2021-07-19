
package com.buit.his.op.reg.controller;

import com.buit.commons.request.*;
import com.buit.commons.response.MpiKpxxPrintFpResp;
import com.buit.commons.response.OpCzFkxxResp;
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
import com.buit.commons.response.OpCzjlResp;
import com.buit.commons.response.QueryMpiCardResp;
import com.buit.his.op.reg.service.MpiKpxxSer;
import com.buit.op.model.MpiKpxx;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 充值卡管理<br>
 * 
 * @author WY
 */
@Api(tags = "充值卡管理")
@Controller
@RequestMapping("/mpikpxx")
public class MpiKpxxCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(MpiKpxxCtr.class);

	@Autowired
	private MpiKpxxSer mpiKpxxSer;

	/**
	 * 充值卡分页查询
	 * 
	 * @param cardno
	 * @param page
	 * @return
	 */
	@RequestMapping("/doQueryCzkList")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "充值卡分页查询", httpMethod = "POST", notes = "充值卡分页查询")
	public ReturnEntity<PageInfo<MpiKpxx>> doQueryCzkList(
			@ApiParam(name = "kphm", value = "卡号或姓名或身份证") @RequestParam(value = "cardno", required = false) String cardno,
			PageQuery page) {
		PageInfo<MpiKpxx> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> mpiKpxxSer.doQueryCzkList(cardno));
		return ReturnEntityUtil.success(pageInfo);
	}

	/**
	 * 充值卡登记卡号查询
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doQueryMPICard")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "充值卡登记卡号查询", httpMethod = "POST", notes = "充值卡登记卡号查询")
	public ReturnEntity<QueryMpiCardResp> doQueryMpiCard(
			@ApiParam(name = "cardno", value = "卡号") @RequestParam(value = "cardno", required = true) String cardno) {
		QueryMpiCardResp resp = mpiKpxxSer.doQueryMpiCard(cardno);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 充值卡登记
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doSaveIssuingCards")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "充值卡登记", httpMethod = "POST", notes = "充值卡登记")
	public ReturnEntity<?> doSaveIssuingCards(SaveIssuingCardsReq req) {
		req.setYgdm(getUser().getUserId());
		req.setIp(getIpAddress());
		mpiKpxxSer.doSaveIssuingCards(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 卡号查询充值卡信息
	 * 
	 * @param cardno
	 * @return
	 */
	@RequestMapping("/doQueryKpxx")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "卡号查询充值卡信息", httpMethod = "POST", notes = "卡号查询充值卡信息")
	public ReturnEntity<MpiKpxx> doQueryKpxx(
			@ApiParam(name = "cardno", value = "卡号") @RequestParam(value = "cardno") String cardno) {
		MpiKpxx resp = mpiKpxxSer.doQueryKpxx(cardno);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 充值
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doSaveRecharge")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "充值", httpMethod = "POST", notes = "充值")
	public ReturnEntity<Integer> doSaveRecharge(@RequestBody SaveRechargeReq req) {
		req.setJgid(getUser().getHospitalId());
		req.setYgdm(getUser().getUserId());
		req.setIp(getIpAddress());
		Integer czxh = mpiKpxxSer.doSaveRecharge(req);
		return ReturnEntityUtil.success(czxh);
	}


	/**
	 * 充值卡发票打印
	 *
	 * @param jlxh
	 * @return
	 */
	@RequestMapping("/doPrintFpxx")
	@ResponseBody
	@ApiOperationSupport(author = "tian")
	@ApiOperation(value = "充值卡发票打印", httpMethod = "POST", notes = "充值卡发票打印")
	public ReturnEntity<MpiKpxxPrintFpResp> doPrintFpxx(
			@ApiParam(name = "jlxh", value = "记录序号", required = true) @RequestParam(value = "jlxh") Integer jlxh) {
		return ReturnEntityUtil.success(mpiKpxxSer.doPrintFpxx(jlxh));
	}


	/**
	 * 余额转出
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doSaveTransfer")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "余额转出", httpMethod = "POST", notes = "余额转出")
	public ReturnEntity<?> doSaveTransfer(SaveTransferReq req) {
		req.setYgdm(getUser().getUserId());
		req.setIp(getIpAddress());
		mpiKpxxSer.doSaveTransfer(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 退费
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doSaveRefund")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "退费", httpMethod = "POST", notes = "退费")
	public ReturnEntity<?> doSaveRefund(SaveRefundReq req) {
		req.setYgdm(getUser().getUserId());
		req.setIp(getIpAddress());
		req.setJgid(getUser().getHospitalId());
		mpiKpxxSer.doSaveRefund(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 挂失
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doSaveRegloss")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "挂失", httpMethod = "POST", notes = "挂失")
	public ReturnEntity<?> doSaveRegloss(SaveReglossReq req) {
		req.setYgdm(getUser().getUserId());
		req.setIp(getIpAddress());
		mpiKpxxSer.doSaveRegloss(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 解挂
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doSaveUnregloss")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "解挂", httpMethod = "POST", notes = "解挂")
	public ReturnEntity<?> doSaveUnregloss(SaveReglossReq req) {
		req.setYgdm(getUser().getUserId());
		req.setIp(getIpAddress());
		mpiKpxxSer.doSaveUnregloss(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 注销
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doSaveLogout")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "注销", httpMethod = "POST", notes = "注销")
	public ReturnEntity<?> doSaveLogout(SaveReglossReq req) {
		req.setYgdm(getUser().getUserId());
		req.setIp(getIpAddress());
		mpiKpxxSer.doSaveLogout(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 操作记录
	 * 
	 * @param cardNo
	 * @param page
	 * @return
	 */
	@RequestMapping("/doQueryCzjlList")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "操作记录分页查询", httpMethod = "POST", notes = "操作记录分页查询")
	public ReturnEntity<PageInfo<OpCzjlResp>> doQueryCzjlList(
			@ApiParam(name = "cardNo", value = "卡号") @RequestParam(value = "cardNo", required = true) String cardNo,
			PageQuery page) {
		PageInfo<OpCzjlResp> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> mpiKpxxSer.doQueryCzjlList(cardNo));
		return ReturnEntityUtil.success(pageInfo);
	}



	/**
	 * 充值记录
	 *
	 * @param opCzFkxxReq
	 * @return
	 */
	@RequestMapping("/doQueryCzFkxxList")
	@ResponseBody
	@ApiOperationSupport(author = "tian")
	@ApiOperation(value = "充值记录", httpMethod = "POST", notes = "充值记录")
	public ReturnEntity<PageInfo<OpCzFkxxResp>> doQueryCzFkxxList(OpCzFkxxReq opCzFkxxReq)
	{
		opCzFkxxReq.setJgid(getUser().getHospitalId());
		PageInfo<OpCzFkxxResp> pageInfo = PageHelper.startPage(opCzFkxxReq.getPageNum(), opCzFkxxReq.getPageSize())
				.doSelectPageInfo(() -> mpiKpxxSer.doQueryCzFkxxList(opCzFkxxReq));
		return ReturnEntityUtil.success(pageInfo);
	}

//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<MpiKpxxResp>> queryPage(MpiKpxxReq mpikpxx,PageQuery page){
//        PageInfo<MpiKpxx> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> mpiKpxxSer.findByEntity(mpikpxx)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<MpiKpxxResp>> getByEntity( MpiKpxxReq mpikpxx){//@RequestBody 
//        return ReturnEntityUtil.success(mpiKpxxSer.findByEntity(mpikpxx));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<MpiKpxxResp> getOneByEntity(MpiKpxxReq mpikpxx){
//        List<MpiKpxx> list=mpiKpxxSer.findByEntity(mpikpxx);
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
//    public ReturnEntity<MpiKpxxResp> add(MpiKpxxReq mpiKpxx) {
//        mpiKpxxSer.insert(mpiKpxx);        
//        return ReturnEntityUtil.success(mpiKpxx);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<MpiKpxxResp> edit(MpiKpxxReq mpiKpxx)  {
//        mpiKpxxSer.update(mpiKpxx);        
//        return ReturnEntityUtil.success(mpiKpxx);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<MpiKpxxResp> delete(MpiKpxxReq mpiKpxx) {
//        mpiKpxxSer.removeByEntity(mpiKpxx);        
//        return ReturnEntityUtil.success(mpiKpxx);            
//    }

}
