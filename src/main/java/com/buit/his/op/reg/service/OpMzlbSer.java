package com.buit.his.op.reg.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.buit.commons.BaseException;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpMzlbDao;
import com.buit.commons.model.OpMzlb;
import com.buit.commons.request.OpMzlbReq;
import com.buit.commons.response.QueryYbipDetatilResp;
import com.buit.constans.TableName;
import com.buit.system.service.SysDictConfigSer;
import com.buit.utill.MzUtil;
import com.buit.utill.RedisFactory;

/**
 * 门诊_门诊类别<br>
 * 
 * @author WY
 */
@Service
public class OpMzlbSer extends BaseManagerImp<OpMzlb, Integer> {

	static final Logger logger = LoggerFactory.getLogger(OpMzlbSer.class);

	@Autowired
	private OpMzlbDao opMzlbDao;

	@Autowired
	private RedisFactory redisFactory;
	@DubboReference
	private SysDictConfigSer sysDictConfigSer;

	@Override
	public OpMzlbDao getEntityMapper() {
		return opMzlbDao;
	}

	/**
	 * 医保线路维护新增
	 * 
	 * @param req
	 */
	public void add(OpMzlbReq req) {
		OpMzlb opMzlb = new OpMzlb();
		BeanUtils.copyProperties(req, opMzlb);
		opMzlb.setMzlb(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_MZLB));
		opMzlbDao.insert(opMzlb);
		sysDictConfigSer.upDateVersion("op_mzlb");
	}

	/**
	 * 根据门诊类别查询医保IP
	 * 
	 * @param mzlb
	 * @param jgid
	 * @return
	 */
	public List<QueryYbipDetatilResp> doQueryYbipDetatil(Integer mzlb, Integer jgid) {
		Map<String, Object> parameters = new HashMap<String, Object>(16);
		parameters.put("MZLB", mzlb);
		parameters.put("JGID", jgid);
		List<Map<String, Object>> resultList = opMzlbDao.getYbIp(parameters);
		List<QueryYbipDetatilResp> resp = MzUtil.ListToResultSet(resultList, new QueryYbipDetatilResp());
		return resp;
	}

	public Integer getMzlb(Integer jgid,  String ip){
		Integer mzlb = opMzlbDao.getMzlb(jgid, ip);
		if(Objects.isNull(mzlb)){
			throw BaseException.create("ERROR_REG_0070", new String[] {ip});
		}
		return mzlb;
	}
}
