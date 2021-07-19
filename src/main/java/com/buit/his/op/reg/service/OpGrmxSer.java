package com.buit.his.op.reg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpGrmxDao;
import com.buit.commons.model.OpGrmx;

/**
 * 门诊_挂号日报明细<br>
 * 
 * @author WY
 */
@Service
public class OpGrmxSer extends BaseManagerImp<OpGrmx, String> {

	static final Logger logger = LoggerFactory.getLogger(OpGrmxSer.class);

	@Autowired
	private OpGrmxDao opGrmxDao;

	@Override
	public OpGrmxDao getEntityMapper() {
		return opGrmxDao;
	}

}
