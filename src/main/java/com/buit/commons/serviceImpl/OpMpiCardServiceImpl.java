package com.buit.commons.serviceImpl;

import java.util.Map;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.dao.MpiCardDao;
import com.buit.op.service.OpMpiCardService;

/**
 * @Description 病人卡片
 * @Author 汪洋
 * @Date 2020/10/10 15:23
 */
@DubboService(timeout = 10000)
public class OpMpiCardServiceImpl implements OpMpiCardService {
	@Autowired
	private MpiCardDao mpiCardDao;

	@Override
	public Map<String, Object> getMpiCardInfoByCardNo(Map<String, Object> map) {
		Map<String, Object> result = mpiCardDao.getMpiCardInfoByCardNo(map);
		return result;
	}

	/**
	 * 判断是否为医保卡号
	 * 
	 * @param brkh
	 * @return
	 */
	public long countIsYb(String brkh) {
		return mpiCardDao.countIsYb(brkh);
	}
}
