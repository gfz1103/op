package com.buit.his.op.reg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpGhrbDao;
import com.buit.commons.model.OpGhrb;

/**
 * 门诊_挂号日报<br>
 * 
 * @author WY
 */
@Service
public class OpGhrbSer extends BaseManagerImp<OpGhrb, String> {

	static final Logger logger = LoggerFactory.getLogger(OpGhrbSer.class);

	@Autowired
	private OpGhrbDao opGhrbDao;

	@Override
	public OpGhrbDao getEntityMapper() {
		return opGhrbDao;
	}

}
