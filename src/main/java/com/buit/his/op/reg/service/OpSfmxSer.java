package com.buit.his.op.reg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpSfmxDao;
import com.buit.commons.model.OpSfmx;

/**
 * 门诊_收费明细表<br>
 * 
 * @author WY
 */
@Service
public class OpSfmxSer extends BaseManagerImp<OpSfmx, Integer> {

	static final Logger logger = LoggerFactory.getLogger(OpSfmxSer.class);

	@Autowired
	private OpSfmxDao opSfmxDao;

	@Override
	public OpSfmxDao getEntityMapper() {
		return opSfmxDao;
	}

}
