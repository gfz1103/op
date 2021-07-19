package com.buit.commons.serviceImpl;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.dao.OpPosmxDao;
import com.buit.op.model.OpPosmx;
import com.buit.op.service.OpPosmxService;

/**
 * @Description pos信息
 * @Author 汪洋
 * @Date 2020/10/10 15:23
 */
@DubboService(timeout = 10000)
public class OpPosmxServiceImpl implements OpPosmxService {
	@Autowired
	private OpPosmxDao opPosmxDao;

	/**
	 * 插入数据
	 * 
	 * @param entity
	 */
	public void insert(OpPosmx opPosmx) {
		opPosmxDao.insert(opPosmx);
	}
}
