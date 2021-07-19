package com.buit.his.op.reg.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpYbipDao;
import com.buit.commons.model.OpYbip;
import com.buit.commons.request.SaveOrUpdateYbipReq;
import com.buit.constans.TableName;
import com.buit.utill.MzUtil;
import com.buit.utill.RedisFactory;

import cn.hutool.core.bean.BeanUtil;

/**
 * <br>
 *
 * @author WY
 */
@Service
public class OpYbipSer extends BaseManagerImp<OpYbip, Integer> {

	static final Logger logger = LoggerFactory.getLogger(OpYbipSer.class);

	@Autowired
	private OpYbipDao opYbipDao;

	@Autowired
	private RedisFactory redisFactory;

	@Override
	public OpYbipDao getEntityMapper() {
		return opYbipDao;
	}

	/**
	 * 更新或修改医保ip
	 *
	 * @param req
	 */
	public void doSaveOrUpdateYbip(SaveOrUpdateYbipReq req) {
		List<Map<String, Object>> mats = MzUtil.ListObjToMap(req.getYbIpList());
		Map<String, Object> parameters = new HashMap<String, Object>(16);
		for (int i = 0; i < mats.size(); i++) {
			Map<String, Object> mat = mats.get(i);
			Map<String, Object> ipMap = new HashMap<String, Object>(16);
			if ("create".equals(mat.get("opStatus"))) {
				String ip = mat.get("IP") + "";
				if (!"".equals(ip)) {
					parameters.clear();
					parameters.put("IP", ip);
					ipMap = opYbipDao.getIp(parameters);
				}
				if (ipMap != null && ipMap.size() > 0) {
					throw BaseException.create("ERROR_REG_0061");
				} else {
					OpYbip opYbip = BeanUtil.fillBeanWithMapIgnoreCase(mat, new OpYbip(), true);
					opYbip.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YBIP));
					opYbipDao.insert(opYbip);
				}
			} else {
				parameters.clear();
				parameters.put("IP", mat.get("IP") + "");
				parameters.put("SBXH", Long.parseLong(mat.get("SBXH") + ""));
				opYbipDao.updateIpBySbxh(parameters);
			}
		}
	}

}
