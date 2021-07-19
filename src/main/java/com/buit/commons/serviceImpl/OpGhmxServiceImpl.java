package com.buit.commons.serviceImpl;

import java.util.List;

import com.buit.utill.BeanUtil;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.dao.OpGhmxDao;
import com.buit.op.model.OpGhmx;
import com.buit.op.service.OpGhmxService;

/**
 * @Description 门诊类别
 * @Author 汪洋
 * @Date 2020/10/10 15:23
 */
@DubboService(timeout = 10000)
public class OpGhmxServiceImpl implements OpGhmxService {
	@Autowired
	private OpGhmxDao opGhmxDao;

	/**
	 * @name: updateYsdmByJzlsh
	 * @description: 根据就诊流水号更新医生代码
	 * @param jzlsh
	 * @param ysdm
	 * @return: void
	 * @date: 2020/9/7 17:44
	 * @auther: 朱智
	 *
	 */
	@Override
	public void updateYsdmByJzlsh(String jzlsh, Integer ysdm) {
		opGhmxDao.updateYsdmByJzlsh(jzlsh, ysdm);
	}

	/**
	 * 按条件查询方法
	 * 
	 * @param opghmx
	 * @return
	 */
	@Override
	public List<OpGhmx> findByEntity(OpGhmx opghmx) {
		return opGhmxDao.findByEntity(opghmx);
	}

	@Override
	public OpGhmx getGhmx(String jzlsh) {
		OpGhmx condition = new OpGhmx();
		condition.setJzlsh(jzlsh);
		List<OpGhmx> dataList = opGhmxDao.findByEntity(condition);
		if (dataList.size() > 0) {
			OpGhmx opGhmx = dataList.get(0);
			return opGhmx ;
		}
		return null;
	}
}
