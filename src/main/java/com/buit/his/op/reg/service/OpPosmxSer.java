package com.buit.his.op.reg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpPosmxDao;
import com.buit.op.model.OpPosmx;

/**
 * <br>
 * 
 * @author WY
 */
@Service
public class OpPosmxSer extends BaseManagerImp<OpPosmx, Integer> {

	static final Logger logger = LoggerFactory.getLogger(OpPosmxSer.class);

	@Autowired
	private OpPosmxDao opPosmxDao;

	@Override
	public OpPosmxDao getEntityMapper() {
		return opPosmxDao;
	}

}
