package com.buit.his.op.reg.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.PubJmlxDao;
import com.buit.commons.model.PubJmlx;
import com.buit.commons.request.SaveFydwReq;
import com.buit.constans.TableName;
import com.buit.system.service.SysDictConfigSer;
import com.buit.utill.RedisFactory;

/**
 * <br>
 * 
 * @author WY
 */
@Service
public class PubJmlxSer extends BaseManagerImp<PubJmlx, Integer> {

	static final Logger logger = LoggerFactory.getLogger(PubJmlxSer.class);

	@Autowired
	private PubJmlxDao pubJmlxDao;

	@Autowired
	private RedisFactory redisFactory;
	@DubboReference
	private SysDictConfigSer sysDictConfigSer;

	@Override
	public PubJmlxDao getEntityMapper() {
		return pubJmlxDao;
	}

	/**
	 * 新增修改妇幼单位
	 * 
	 * @param req
	 */
	public void doSaveFydw(SaveFydwReq req) {
		PubJmlx pubJmlx = new PubJmlx();
		BeanUtils.copyProperties(req, pubJmlx);
		if (req.getFydw() != null) {
			pubJmlxDao.updateFydwInfo(pubJmlx);
		} else {
			pubJmlx.setFydw(redisFactory.getTableKey(TableName.DB_NAME, TableName.PUB_JMLX));
			pubJmlxDao.insert(pubJmlx);
		}
		sysDictConfigSer.upDateVersion("pub_jmlx");
	}

}
