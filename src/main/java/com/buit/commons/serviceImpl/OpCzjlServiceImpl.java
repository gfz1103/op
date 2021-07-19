package com.buit.commons.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.dao.OpCzjlDao;
import com.buit.op.model.OpCzjl;
import com.buit.op.service.OpCzjlService;

/**
 * @Description 操作记录
 * @Author 汪洋
 * @Date 2020/10/10 15:23
 */
@DubboService(timeout = 10000)
public class OpCzjlServiceImpl implements OpCzjlService {
	@Autowired
	private OpCzjlDao opCzjlDao;

	/**
	 * 插入数据
	 * 
	 * @param entity
	 */
	public void insert(OpCzjl opCzjl) {
		opCzjlDao.insert(opCzjl);
	}

	/**
	 * 操作记录打印发票
	 * 
	 * @param fphm
	 * @return
	 */
	public List<Map<String, Object>> queryCzjlDyfp(String fphm) {
		return opCzjlDao.queryCzjlDyfp(fphm);
	}
}
