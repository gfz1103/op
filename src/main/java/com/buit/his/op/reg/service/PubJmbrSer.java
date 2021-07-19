package com.buit.his.op.reg.service;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.PubJmbrDao;
import com.buit.commons.model.PubJmbr;
import com.buit.commons.request.SaveFybrReq;

/**
 * 妇幼病人<br>
 * 
 * @author WY
 */
@Service
public class PubJmbrSer extends BaseManagerImp<PubJmbr, String> {

	static final Logger logger = LoggerFactory.getLogger(PubJmbrSer.class);

	@Autowired
	private PubJmbrDao pubJmbrDao;

	@Override
	public PubJmbrDao getEntityMapper() {
		return pubJmbrDao;
	}

	/**
	 * 新增修改减免患者
	 * 
	 * @param req
	 */
	public void doSaveFybr(@Valid SaveFybrReq req) {
		PubJmbr pubJmbr = new PubJmbr();
		BeanUtils.copyProperties(req, pubJmbr);
		// 查询证号是否存在
		PubJmbr fybr = pubJmbrDao.getById(req.getFyzh());
		if (fybr != null) {
			pubJmbrDao.updateFybrInfo(pubJmbr);
		} else {
			pubJmbrDao.insert(pubJmbr);
		}
	}
}
