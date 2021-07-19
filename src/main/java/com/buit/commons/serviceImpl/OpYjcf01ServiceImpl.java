package com.buit.commons.serviceImpl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.buit.cis.op.dctwork.response.FeeYlsfxm;
import com.buit.cis.op.dctwork.service.FeeYlsfxmSer;
import com.buit.cis.op.dctwork.service.OpYjcf01Ser;
import com.buit.commons.BaseException;
import com.buit.commons.SysUser;
import com.buit.commons.dao.OpYjcf01Dao;
import com.buit.commons.dao.OpYjcf02Dao;
import com.buit.commons.enums.StatusEnum;
import com.buit.constans.TableName;
import com.buit.op.model.OpYjcf01;
import com.buit.op.model.OpYjcf02;
import com.buit.op.request.IOptSssqSaveYjReq;
import com.buit.op.request.OpYjcf01Req;
import com.buit.op.response.OpYjcfEmrResp;
import com.buit.op.service.OpYjcf01Service;
import com.buit.utill.*;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Description 医技接口实现
 * @Author 老花生
 * @Date 2020/10/13 10:28
 */
@DubboService(timeout = 10000)
public class OpYjcf01ServiceImpl implements OpYjcf01Service {
	@Autowired
	private OpYjcf01Dao opYjcf01Dao;
	@Autowired
	private OpYjcf02Dao opYjcf02Dao;
	@Autowired
	private OpYjcf01Ser opYjcf01Ser;
	@Autowired
	private FeeYlsfxmSer feeYlsfxmSer;
	@Autowired
	private RedisFactory redisFactory;

	@Override
	public void insert(OpYjcf01 yjcf01) {
		opYjcf01Dao.insert(yjcf01);
	}

	@Override
	public void delById(Integer yjxh) {
		OpYjcf01 yj = opYjcf01Dao.getById(yjxh);
		if (yj == null || yj.getYjxh() == null) {
			throw BaseException.create("ERROR_DCTWORK_OP_0043");
		}
		opYjcf02Dao.removeByEntity(ParamUtil.instance().put("yjxh", yjxh));
		opYjcf01Dao.deleteById(yjxh);
	}

	@Override
	public List<Map<String, Object>> getJzxh(String yjxhs) {
		return opYjcf01Dao.getJzxh(yjxhs);
	}

	@Override
	public Integer save(OpYjcf01Req yjReq, Integer userId, Integer hospitalId) {
		SysUser user = new SysUser();
		user.setUserId(userId);
		user.setHospitalId(hospitalId);

		OpYjcf01Req req = BeanUtil.toBean(yjReq, OpYjcf01Req.class);
		return opYjcf01Ser.save(req, user);
	}

	@Override
	public void updateSqid(Map<String, Object> par) {
		opYjcf01Dao.updateSqid(par);
	}

	/**
	 * sssqSaveYj 手术申请保存医技信息
	 * @param req
	 */
//	@Override
//	public void sssqSaveYj(IOptSssqSaveYjReq req) {
//		Map<String, Object> body = cn.hutool.core.bean.BeanUtil.beanToMap(req);
//		body.put("sssqid", req.getSqdh());
//		OpYjcf01Req yj01 = cn.hutool.core.bean.BeanUtil.fillBeanWithMapIgnoreCase(body, new OpYjcf01Req(), true);
//		List<OpYjcf02Req> yj02List = new ArrayList<>();
//		OpYjcf02Req yj02 = cn.hutool.core.bean.BeanUtil.fillBeanWithMapIgnoreCase(body, new OpYjcf02Req(), true);
//		yj02List.add(yj02);
//		yj01.setBodys(yj02List);
//		yj01.setJzlsh(req.getJzlsh());
//		yj01.setLy(6);
//		SysUser user = new SysUser();
//		user.setUserId(req.getUserId());
//		user.setHospitalId(req.getHospitalId());
//		opYjcf01Ser.save(yj01, user);
//	}

	/**
	 * 手术申请保存医技信息
	 * @param req
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void sssqSaveYj(IOptSssqSaveYjReq req){
		//通过手术id查询手术信息
		FeeYlsfxm feeYlsfxm = feeYlsfxmSer.getById(Integer.valueOf(req.getYlxh()));
		if (feeYlsfxm == null){
			throw BaseException.create("ERROR_DCTWORK_OP_0047");
		}
		//1.通过手术申请单id查询医技数据
		OpYjcf01 opYjcf01 = opYjcf01Ser.queryBysssqId(Integer.valueOf(req.getSssqid()));
		if (opYjcf01 == null){
			//新增门诊_门诊医技单主表
			Integer yjxh = insertOpYjcf01(req);
			//新增门诊_门诊医技单子表
			insertOpYjcf02(req,yjxh,feeYlsfxm);
		}else {
			//先删除主表和子表
			opYjcf01Dao.deleteById(opYjcf01.getYjxh());
			opYjcf02Dao.deleteByYjxhForSssq(opYjcf01.getYjxh());
			//新增门诊_门诊医技单主表
			Integer yjxh = insertOpYjcf01(req);
			//新增门诊_门诊医技单子表
			insertOpYjcf02(req,yjxh,feeYlsfxm);
		}
	}

	@Override
	public List<OpYjcfEmrResp> queryYjcfToEmr(String jzlsh) {
		return opYjcf01Dao.queryYjcfToEmr(jzlsh);
	}

	/**
	 * 通过康复申请id删除处置数据
	 * @param kfsqid 康复申请单id
	 */
	@Override
	public void deleteOpyj(Integer kfsqid) throws BaseException{
		if (kfsqid == null || kfsqid == 0){
			return;
		}
		//通过申请单ID查询opyjcf01
		List<OpYjcf01> opYjcf01s = opYjcf01Dao.getcf01Byzlsqdid(kfsqid);
		if (CollUtil.isEmpty(opYjcf01s)){
			return;
		}
		opYjcf01s.stream().forEach(o ->{
			if (StrUtil.isNotBlank(o.getFphm())){
				throw BaseException.create("ERROR_DCTWORK_OP_0082");
			}
			opYjcf02Dao.deleteByYjxhForSssq(o.getYjxh());//删除opyjcf02
			opYjcf02Dao.deleteByYjxhForSssq(o.getYjxh());//删除opyj01zt
			opYjcf01Dao.deleteById(o.getYjxh());//删除opyjcf01
		});
	}

	/**
	 * 新增医技主表
	 * @param req
	 */
	private Integer insertOpYjcf01(IOptSssqSaveYjReq req){
		OpYjcf01 opYjcf01 = BeanUtil.toBean(req, OpYjcf01.class);
		opYjcf01.setYjxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.OP_YJCF01));//主键
		opYjcf01.setKdrq(DateUtil.getCurrentTimestamp());//开单日期
		opYjcf01.setDjzt(StatusEnum.Djzt.TJ.getCode());//单据状态 默认为1
		opYjcf01.setDjly(1);//单据来源 todo 不知道啥意思

		opYjcf01.setZfpb(0);
		opYjcf01.setZxpb(0);
		opYjcf01.setCfbz(0);
		opYjcf01.setDjzt(0);
		opYjcf01.setSqwh(0);

		opYjcf01.setSqid(opYjcf01.getYjxh());//申请id
		opYjcf01Dao.insert(opYjcf01);
		return opYjcf01.getYjxh();
	}

	/**
	 * 新增医技子表
	 * @param req
	 */
	private void insertOpYjcf02(IOptSssqSaveYjReq req,Integer jyxh,FeeYlsfxm feeYlsfxm){
		OpYjcf02 opYjcf02 = new OpYjcf02();
		opYjcf02.setSbxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.OP_YJCF02));
		opYjcf02.setJgid(req.getJgid());
		opYjcf02.setYjxh(jyxh);
		opYjcf02.setYlxh(req.getYlxh());
		//opYjcf02.setXmlx(feeYlsfxm.getXmlx());
		opYjcf02.setXmlx(req.getXmlx());
		opYjcf02.setYjzx(feeYlsfxm.getYjlx());//医技主项 todo  不知道什么意思
		opYjcf02.setYldj(feeYlsfxm.getFydj());
		opYjcf02.setYlsl(new BigDecimal(1));
		opYjcf02.setHjje(feeYlsfxm.getFydj());//合计金额？？
		opYjcf02.setFygb(feeYlsfxm.getFygb());
		opYjcf02.setZfbl(new BigDecimal(1));//自负比例 todo
		//opYjcf02.setBzxx();//备注信息
		opYjcf02.setDzbl(new BigDecimal(1));//打折比例 todo
		//opYjcf02.setYjzh(feeYlsfxm.g);//医技组号
		opYjcf02.setZfpb(feeYlsfxm.getFygb());//自负判别
		//opYjcf02.setSpbh();//审批编号
		//opYjcf02.setZtbh(feeYlsfxm.);//组套编号
		//opYjcf02.setZxpb();//执行判别
		opYjcf02.setSqdh(opYjcf02.getSbxh());//申请单号
		//opYjcf02.setZtbz();//组套标志(该条医嘱存是组套信息) 0非组套标志，1组套标志
		opYjcf02.setJzlsh(req.getJzlsh());//就诊流水号
		opYjcf02Dao.insert(opYjcf02);
	}
}
