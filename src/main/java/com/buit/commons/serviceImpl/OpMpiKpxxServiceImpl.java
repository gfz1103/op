package com.buit.commons.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.dao.MpiKpxxDao;
import com.buit.op.model.MpiKpxx;
import com.buit.op.service.OpMpiKpxxService;

/**
 * @Description 卡片信息
 * @Author 汪洋
 * @Date 2020/10/10 15:23
 */
@DubboService(timeout = 10000)
public class OpMpiKpxxServiceImpl implements OpMpiKpxxService {
	@Autowired
	private MpiKpxxDao mpiKpxxDao;

	/**
	 * 更新卡内余额
	 * 
	 * @param map
	 */
	public void updateKnye(Map<String, Object> map) {
		mpiKpxxDao.updateKnye(map);
	}

	/**
	 * 插入数据
	 */
	public void insert(MpiKpxx mpiKpxx) {
		mpiKpxxDao.insert(mpiKpxx);
	}

	/**
	 * 通过病人id查询卡信息
	 * 
	 * @param brid
	 * @return
	 */
	public List<Map<String, Object>> queryCardInfoByBrid(String brid) {
		return mpiKpxxDao.queryCardInfoByBrid(brid);
	}

	/**
	 * 通过病人id更新卡内余额
	 * 
	 * @param map
	 */
	public void updateKnyeByBrid(Map<String, Object> map) {
		mpiKpxxDao.updateKnyeByBrid(map);
	}

	@Override
	public List<Map<String, Object>> queryCardInfoByFphm(String fphm) {
		return mpiKpxxDao.queryCardInfoByFphm(fphm);
	}
}
