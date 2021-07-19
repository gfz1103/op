package com.buit.his.op.reg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpGhmxZkDao;
import com.buit.commons.model.OpGhmxZk;

/**
 * 挂号明细_转科信息<br>
 * 
 * @author WY
 */
@Service
public class OpGhmxZkSer extends BaseManagerImp<OpGhmxZk, String> {

	static final Logger logger = LoggerFactory.getLogger(OpGhmxZkSer.class);

	@Autowired
	private OpGhmxZkDao opGhmxZkDao;

	@Override
	public OpGhmxZkDao getEntityMapper() {
		return opGhmxZkDao;
	}

}
