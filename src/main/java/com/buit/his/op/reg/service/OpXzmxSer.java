package com.buit.his.op.reg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpXzmxDao;
import com.buit.commons.model.OpXzmx;

/**
 * 门诊_日报性质明细<br>
 * 
 * @author WY
 */
@Service
public class OpXzmxSer extends BaseManagerImp<OpXzmx, String> {

	static final Logger logger = LoggerFactory.getLogger(OpXzmxSer.class);

	@Autowired
	private OpXzmxDao opXzmxDao;

	@Override
	public OpXzmxDao getEntityMapper() {
		return opXzmxDao;
	}

}
