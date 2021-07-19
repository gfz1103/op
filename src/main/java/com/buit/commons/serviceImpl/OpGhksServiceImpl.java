package com.buit.commons.serviceImpl;

import java.util.Map;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.dao.OpGhksDao;
import com.buit.op.service.OpGhksService;

/**
 * @Description 挂号科室
 * @Author 汪洋
 * @Date 2020/10/10 15:23
 */
@DubboService(timeout = 10000)
public class OpGhksServiceImpl implements OpGhksService {
	@Autowired
	private OpGhksDao opGhksDao;

	/**
	 * 查询是否工伤
	 *
	 * @param ksdm
	 * @return
	 */
	public Map<String, Object> getSfgs(String ksdm, Integer jgid) {
		return opGhksDao.getSfgs(ksdm, jgid);
	}
}
