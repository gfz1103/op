package com.buit.his.op.infusion.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.SyGytjDao;
import com.buit.commons.model.SyGytj;
import com.buit.commons.request.SyGytjAddReq;
import com.buit.commons.request.SyGytjReq;
import com.buit.commons.response.SyGytjResp;

/**
 * 输液/注射给药途径设置<br>
 * 
 * @author WY
 */
@Service
public class SyGytjSer extends BaseManagerImp<SyGytj, Integer> {

	static final Logger logger = LoggerFactory.getLogger(SyGytjSer.class);

	@Autowired
	private SyGytjDao syGytjDao;

	@Override
	public SyGytjDao getEntityMapper() {
		return syGytjDao;
	}

	/**
	 * 查询已选给药途径列表
	 * 
	 * @param req
	 * @return
	 */
	public List<SyGytjResp> doQueryGytjList(SyGytjReq req) {
		return syGytjDao.doQueryGytjList(req);
	}

	/**
	 * 给药途径新增
	 * 
	 * @param req
	 */
	public void doSaveGytj(SyGytjAddReq req) {
		String gytjdmArray[] = req.getGytjdm().split(",");
		for (String gytjdm : gytjdmArray) {
			SyGytj syGytj = new SyGytj();
			BeanUtils.copyProperties(req, syGytj);
			syGytj.setGytjdm(gytjdm);
			syGytjDao.insert(syGytj);
		}
	}

	/**
	 * 给药途径删除
	 * 
	 * @param req
	 */
	public void doDeleteGytj(SyGytjAddReq req) {
		String gytjdmArray[] = req.getGytjdm().split(",");
		for (String gytjdm : gytjdmArray) {
			SyGytj syGytj = new SyGytj();
			BeanUtils.copyProperties(req, syGytj);
			syGytj.setGytjdm(gytjdm);
			syGytjDao.doDeleteGytj(syGytj);
		}
	}

}
