package com.buit.his.op.reg.service;

import java.util.List;

import com.buit.commons.SysUser;
import com.buit.his.op.reg.enums.OpPjlxEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpYgpjDao;
import com.buit.commons.model.OpYgpj;
import com.buit.commons.request.OpYgpjAddReq;
import com.buit.constans.TableName;
import com.buit.utill.RedisFactory;

import cn.hutool.core.date.DateUtil;

/**
 * 门诊_门诊员工票据<br>
 * 
 * @author WY
 */
@Service
public class OpYgpjSer extends BaseManagerImp<OpYgpj, Integer> {

	static final Logger logger = LoggerFactory.getLogger(OpYgpjSer.class);

	@Autowired
	private OpYgpjDao opYgpjDao;

	@Autowired
	private RedisFactory redisFactory;

	@Override
	public OpYgpjDao getEntityMapper() {
		return opYgpjDao;
	}

	/**
	 * 发票号码维护、就诊号码维护、门诊号码维护 新增
	 * 
	 * @param req
	 */
	public void add(OpYgpjAddReq req) {
		if (req.getQshm().length() != req.getZzhm().length()) {
			throw BaseException.create("ERROR_REG_0054");
		}
		if (Integer.valueOf(req.getSyhm()).intValue() < Integer.valueOf(req.getQshm()).intValue()) {
			throw BaseException.create("ERROR_REG_0059");
		}
		if (Integer.valueOf(req.getSyhm()).intValue() > Integer.valueOf(req.getZzhm()).intValue()) {
			throw BaseException.create("ERROR_REG_0058");
		}

		// 判断所有号码是否重复
		invoiceNumberVerification(req);
		// 判断号码段是否冲突
		invoiceNumberRangeVerification(req);
		OpYgpj opYgpj = new OpYgpj();
		BeanUtils.copyProperties(req, opYgpj);
		opYgpj.setJqpb(0);
		opYgpj.setSypb(1);
		opYgpj.setLyrq(DateUtil.date(req.getLyrq()).toTimestamp());
		opYgpj.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YGPJ));
		opYgpjDao.insert(opYgpj);
	}

	/**
	 * 判断所有号码是否重复
	 * 
	 * @return
	 */
	public void invoiceNumberVerification(OpYgpjAddReq req) {
		for (int i = 1; i < 4; i++) {
			OpYgpj opYgpj = new OpYgpj();
			opYgpj.setPjlx(req.getPjlx());
			opYgpj.setJgid(req.getJgid());
			// 分别判断数量 起始号码、终止号码、使用号码是否存在，并反错误信息
			if (i == 1) {
				opYgpj.setQshm(req.getQshm());
			}
			if (i == 2) {
				opYgpj.setZzhm(req.getZzhm());
			}
			if (i == 3) {
				opYgpj.setSyhm(req.getSyhm());
			}
			Integer count = opYgpjDao.doInvoiceNumberValid(opYgpj);
			if (count != null && count.intValue() > 0) {
				if (i == 1) {
					throw BaseException.create("ERROR_REG_0002");
				}
				if (i == 2) {
					throw BaseException.create("ERROR_REG_0003");
				}
				if (i == 3) {
					throw BaseException.create("ERROR_REG_0004");
				}
			}
		}
	}

	/**
	 * 判断号码段是否冲突
	 * 
	 * @return
	 */
	public void invoiceNumberRangeVerification(OpYgpjAddReq req) {
		OpYgpj opYgpj = new OpYgpj();
		BeanUtils.copyProperties(req, opYgpj);
		opYgpj.setLength(String.valueOf(req.getQshm()).length());
		// 新增的起始号码在库里起止号码范围内
		Integer oneCount = opYgpjDao.doNumberRangeValidOne(opYgpj);
		// 库里的起始号码在新增起止号码范围内或者库里的终止号码在新增起止号码范围内
		Integer twoCount = opYgpjDao.doNumberRangeValidTwo(opYgpj);
		if ((oneCount != null && oneCount.intValue() > 0) || (twoCount != null && twoCount.intValue() > 0)) {
			throw BaseException.create("ERROR_REG_0005");
		}
	}

	/**
	 * 查询票据信息
	 * 
	 * @param opYgpj
	 * @return
	 */
	public List<OpYgpj> getYgpjInfo(OpYgpj opYgpj) {
		return opYgpjDao.getYgpjInfo(opYgpj);
	}

	/**
	 * 发票号码维护、就诊号码维护、门诊号码维护 修改
	 * 
	 * @param req
	 */
	public void updateSyhm(OpYgpjAddReq req) {
		if (req.getQshm().length() != req.getSyhm().length() || (req.getZzhm().length() != req.getSyhm().length())) {
			throw BaseException.create("ERROR_REG_0069");
		}
		if (Integer.valueOf(req.getSyhm()).intValue() < Integer.valueOf(req.getQshm()).intValue()) {
			throw BaseException.create("ERROR_REG_0068");
		}
		if (Integer.valueOf(req.getSyhm()).intValue() > Integer.valueOf(req.getZzhm()).intValue()) {
			throw BaseException.create("ERROR_REG_0067");
		}

		// 判断所有号码是否重复
//		invoiceNumberVerification(req);
		// 判断号码段是否冲突
//		invoiceNumberRangeVerification(req);
		OpYgpj opYgpj = new OpYgpj();
		opYgpj.setPjlx(req.getPjlx());
		opYgpj.setJgid(req.getJgid());
		opYgpj.setSyhm(req.getSyhm());
		opYgpj.setYgdm(req.getYgdm());
		Integer count = opYgpjDao.doInvoiceNumberValid(opYgpj);
		if (count != null && count.intValue() > 0) {
			throw BaseException.create("ERROR_REG_0004");
		}
		BeanUtils.copyProperties(req, opYgpj);
		opYgpjDao.update(opYgpj);
	}



	/**
	 * 获取票据号码
	 *
	 * @param jgid
	 * @param ygdm
	 */
	public String getPjhm(Integer jgid, Integer ygdm, Integer pjlx) {
		// 查询当前用户的使用号码
		List<OpYgpj> opYgpjList = opYgpjDao.getFirstSyhm(jgid, ygdm, pjlx);
		if (opYgpjList != null && !opYgpjList.isEmpty()) {
			String syhm =opYgpjList.get(0).getSyhm();
			if (syhm == null) {
				throw BaseException.create("ERROR_REG_0097");
			}
			return syhm;
		} else {
			throw BaseException.create("ERROR_REG_0097");
		}
	}

    public void updateStatus(SysUser user, Integer pjlx, Integer jlxh, Integer sypb) {
		if(sypb == 0){
			Integer count = opYgpjDao.checkSypb(user.getUserId(), jlxh, pjlx,user.getHospitalId());
			if(count > 0){
				throw BaseException.create("ERROR_REG_0110");
			}

		}
		opYgpjDao.updateHm(null, null, jlxh, sypb, null);
    }

	public void jqhm(Integer jlxh) {
		OpYgpj opYgpj = opYgpjDao.getById(jlxh);
		String syhm = opYgpj.getSyhm();
		StringBuilder sb = new StringBuilder(syhm);
		sb.reverse();
		String syhmnew = sb.toString();
		if (syhm.equals(opYgpj.getQshm())) {
			opYgpjDao.deleteById(opYgpj.getJlxh());
		} else {
			if (OpPjlxEnum.FPHM.getKey().equals(opYgpj.getPjlx())) {
				int length = syhm.length();
				int slen = length;
				for (int i = 0; i < length; i++) {
					char n = syhmnew.charAt(i);
					if (n < 48 || n > 57) {
						slen = i;
						break;
					}
				}
				String sz = syhm.substring(syhm.length() - slen);
				String zm = syhm.substring(0, syhm.length() - slen);
				long intnewsz = Long.parseLong(sz) - 1;
				String newssz = String.format("%0" + (slen) + "d", intnewsz);
				opYgpjDao.updateHm(zm + newssz, zm + newssz, opYgpj.getJlxh(), 1, 1);
			} else {
				int length = syhm.length();
				long intnewsyhm = Long.parseLong(syhm) - 1;
				String newsyhm = String.format("%0" + length + "d", intnewsyhm);
				opYgpjDao.updateHm(newsyhm, newsyhm, opYgpj.getJlxh(), 1, 1);
			}
		}
	}
}
