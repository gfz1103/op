package com.buit.his.op.reg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpRbmxDao;
import com.buit.commons.model.OpRbmx;

/**
 * 门诊_收费日报明细<br>
 * 
 * @author WY
 */
@Service
public class OpRbmxSer extends BaseManagerImp<OpRbmx, String> {

	static final Logger logger = LoggerFactory.getLogger(OpRbmxSer.class);

	@Autowired
	private OpRbmxDao opRbmxDao;

	@Override
	public OpRbmxDao getEntityMapper() {
		return opRbmxDao;
	}

}
