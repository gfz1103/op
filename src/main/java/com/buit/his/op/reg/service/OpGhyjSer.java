package com.buit.his.op.reg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpGhyjDao;
import com.buit.commons.model.OpGhyj;

/**
 * 门诊_挂号预检<br>
 * 
 * @author WY
 */
@Service
public class OpGhyjSer extends BaseManagerImp<OpGhyj, Integer> {

	static final Logger logger = LoggerFactory.getLogger(OpGhyjSer.class);

	@Autowired
	private OpGhyjDao opGhyjDao;

	@Override
	public OpGhyjDao getEntityMapper() {
		return opGhyjDao;
	}

}
