package com.buit.commons.serviceImpl;

import java.util.Map;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.dao.OpMzlbDao;
import com.buit.op.service.OpMzlbService;

/**
 * @Description 门诊类别
 * @Author 汪洋
 * @Date 2020/10/10 15:23
 */
@DubboService(timeout = 10000)
public class OpMzlbServiceImpl implements OpMzlbService {
	@Autowired
	private OpMzlbDao opMzlbDao;

	/**
	 * 获取门诊类别
	 * 
	 * @param jgid
	 * @param ip
	 * @return
	 */
	public Integer getMzlb(Integer jgid, String ip) {
		return opMzlbDao.getMzlb(jgid, ip);
	}

	/**
	 * 根据ip查询医保机构代码
	 * 
	 * @param jgid
	 * @param ip
	 * @return
	 */
	public Map<String, Object> getYbjgdm(Integer jgid, String ip) {
		return opMzlbDao.getYbjgdm(jgid, ip);
	}
	
	/**
	 * 根据门诊类别查询医保名称
	 * @param mzlb
	 * @return
	 */
	public long findYbmcCount(String mzlb) {
		return opMzlbDao.findYbmcCount(mzlb);
	}
	
	public Map<String,Object> getYbmc(String mzlb){
		return opMzlbDao.getYbmc(mzlb);
	}
}
