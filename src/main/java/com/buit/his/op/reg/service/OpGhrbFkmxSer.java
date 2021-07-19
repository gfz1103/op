package com.buit.his.op.reg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpGhrbFkmxDao;
import com.buit.commons.model.OpGhrbFkmx;

/**
 * 门诊_挂号日报付款明细<br>
 * 
 * @author WY
 */
@Service
public class OpGhrbFkmxSer extends BaseManagerImp<OpGhrbFkmx, String> {

	static final Logger logger = LoggerFactory.getLogger(OpGhrbFkmxSer.class);

	@Autowired
	private OpGhrbFkmxDao opGhrbFkmxDao;

	@Override
	public OpGhrbFkmxDao getEntityMapper() {
		return opGhrbFkmxDao;
	}

}
