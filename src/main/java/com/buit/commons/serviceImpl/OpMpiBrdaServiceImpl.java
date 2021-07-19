package com.buit.commons.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.buit.commons.dao.MpiBrdaDao;
import com.buit.op.response.MpiBrda;
import com.buit.op.service.OpMpiBrdaService;

/**
 * @Description 病人档案
 * @Author 汪洋
 * @Date 2020/10/10 15:23
 */
@DubboService(timeout = 10000)
public class OpMpiBrdaServiceImpl implements OpMpiBrdaService {
	@Autowired
	private MpiBrdaDao mpiBrdaDao;

	@Override
	public MpiBrda getByBrid(Integer brid, Integer jgid) {
		return mpiBrdaDao.getByBrid(brid, jgid);
	}

	/**
	 * 根据ID查询病人信息
	 * 
	 * @param brid
	 * @return
	 */
	public MpiBrda getById(Integer brid) {
		return mpiBrdaDao.getById(brid);
	}

	/**
	 * 更新 联系人地址 联系人电话 联系人姓名
	 * 
	 * @param brda
	 */
	public void updateLxdzLxdhLxRm(MpiBrda brda) {
		mpiBrdaDao.updateLxdzLxdhLxRm(brda);
	}

	/**
	 * 根据cfsb查询病人信息
	 * 
	 * @param cfsb
	 * @return
	 */
	public MpiBrda getbyCfsb(Integer cfsb) {
		return mpiBrdaDao.getbyCfsb(cfsb);
	}

	/**
	 * 查询工伤大病标识
	 * 
	 * @author beijunhua
	 * @param brid
	 * @return
	 */
	public List<Map<String, Object>> getGsDb(Integer brid) {
		return mpiBrdaDao.getGsDb(brid);
	}

	/**
	 * 修改病人信息
	 *
	 * @author
	 * @param brda
	 * @return
	 */
	public void update(MpiBrda brda) {
		mpiBrdaDao.update(brda);
	}

	/**
	 * 保存病人信息
	 *
	 * @author
	 * @param brda
	 * @return
	 */
	public void insert(MpiBrda brda) {
		mpiBrdaDao.insert(brda);
	}
}
