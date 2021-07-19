package com.buit.his.op.reg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.WlCk02Dao;
import com.buit.commons.model.WlCk02;

/**
 * <br>
 * 
 * @author WY
 */
@Service
public class WlCk02Ser extends BaseManagerImp<WlCk02, Integer> {

	static final Logger logger = LoggerFactory.getLogger(WlCk02Ser.class);

	@Autowired
	private WlCk02Dao wlCk02Dao;

	@Override
	public WlCk02Dao getEntityMapper() {
		return wlCk02Dao;
	}

}
