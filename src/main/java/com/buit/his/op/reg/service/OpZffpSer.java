package com.buit.his.op.reg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpZffpDao;
import com.buit.commons.model.OpZffp;

/**
 * 门诊_作废发票<br>
 * 
 * @author WY
 */
@Service
public class OpZffpSer extends BaseManagerImp<OpZffp, Integer> {

	static final Logger logger = LoggerFactory.getLogger(OpZffpSer.class);

	@Autowired
	private OpZffpDao opZffpDao;

	@Override
	public OpZffpDao getEntityMapper() {
		return opZffpDao;
	}

}
