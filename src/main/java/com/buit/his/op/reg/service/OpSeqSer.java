package com.buit.his.op.reg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpSeqDao;
import com.buit.commons.model.OpSeq;

/**
 * 暂时用来解决发票虚拟自增序号<br>
 * 
 * @author WY
 */
@Service
public class OpSeqSer extends BaseManagerImp<OpSeq, String> {

	static final Logger logger = LoggerFactory.getLogger(OpSeqSer.class);

	@Autowired
	private OpSeqDao opSeqDao;

	@Override
	public OpSeqDao getEntityMapper() {
		return opSeqDao;
	}

}
