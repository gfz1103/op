package com.buit.his.op.reg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpHzrbDao;
import com.buit.commons.model.OpHzrb;

/**
 * 门诊_门诊收费日报<br>
 * 
 * @author WY
 */
@Service
public class OpHzrbSer extends BaseManagerImp<OpHzrb, String> {

	static final Logger logger = LoggerFactory.getLogger(OpHzrbSer.class);

	@Autowired
	private OpHzrbDao opHzrbDao;

	@Override
	public OpHzrbDao getEntityMapper() {
		return opHzrbDao;
	}

}
