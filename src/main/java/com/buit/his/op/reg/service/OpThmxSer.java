package com.buit.his.op.reg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpThmxDao;
import com.buit.commons.model.OpThmx;

/**
 * 门诊_退号明细<br>
 * 
 * @author WY
 */
@Service
public class OpThmxSer extends BaseManagerImp<OpThmx, Integer> {

	static final Logger logger = LoggerFactory.getLogger(OpThmxSer.class);

	@Autowired
	private OpThmxDao opThmxDao;

	@Override
	public OpThmxDao getEntityMapper() {
		return opThmxDao;
	}

}
