package com.buit.his.op.reg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpSfrbFkmxDao;
import com.buit.commons.model.OpSfrbFkmx;

/**
 * 门诊_门诊收费日报付款明细<br>
 * 
 * @author WY
 */
@Service
public class OpSfrbFkmxSer extends BaseManagerImp<OpSfrbFkmx, String> {

	static final Logger logger = LoggerFactory.getLogger(OpSfrbFkmxSer.class);

	@Autowired
	private OpSfrbFkmxDao opSfrbFkmxDao;

	@Override
	public OpSfrbFkmxDao getEntityMapper() {
		return opSfrbFkmxDao;
	}

}
