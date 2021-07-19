package com.buit.his.op.reg.service;

import cn.hutool.core.collection.CollUtil;
import com.buit.cis.op.dctwork.response.OpMzzsResp;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpGhksDao;
import com.buit.commons.dao.OpMzzsDao;
import com.buit.commons.model.OpGhks;
import com.buit.commons.model.OpMzzs;
import com.buit.commons.request.OpMzzsAddReq;
import com.buit.constans.TableName;
import com.buit.utill.BeanUtil;
import com.buit.utill.RedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 门诊诊室信息<br>
 *
 * @author WY
 */
@Service
public class OpMzzsSer extends BaseManagerImp<OpMzzs, Integer> {

	static final Logger logger = LoggerFactory.getLogger(OpMzzsSer.class);

	@Autowired
	private OpMzzsDao opMzzsDao;

	@Autowired
	private RedisFactory redisFactory;
	@Autowired
	private OpGhksDao opGhksDao;

	@Override
	public OpMzzsDao getEntityMapper() {
		return opMzzsDao;
	}

	/**
	 * 门诊信息维护新增
	 *
	 * @param req
	 */
	public void add(OpMzzsAddReq req) {
		OpMzzs opMzzs = new OpMzzs();
		BeanUtils.copyProperties(req, opMzzs);
		opMzzs.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_MZZS));
		opMzzsDao.insert(opMzzs);
	}

	/**
	 * 校验同一科室诊室ID是否存在
	 *
	 * @param ghks
	 * @param zsId
	 */
	public void validZsIdExist(Integer ghks, Integer zsId, String zsmc, Integer oldZsId) {
		Integer count = opMzzsDao.validZsIdExist(ghks, zsId, zsmc, oldZsId);
		if (count != null && count> 0) {
			if(Objects.nonNull(zsId)) {
				throw BaseException.create("ERROR_REG_0052");
			}else {
				throw BaseException.create("ERROR_REG_0101");
			}
		}
	}

	/**
	 * @name: queryMsByFwtId
	 * @description: 根据服务台ID查询科室
	 * @param fwtid
	 * @return: void
	 * @date: 2020/9/4 9:58
	 * @auther: 朱智
	 *
	 */
    public List<OpGhks> queryKsByFwtId(Integer fwtid, String ksmc) {
		OpGhks opGhks = new OpGhks();
		opGhks.setFwtid(fwtid);
		opGhks.setKsmc(ksmc);
		return opGhksDao.findByEntity(opGhks);
    }

    /**
     * @name: queryWaitMs
     * @description: 根据服务台ID查询科室信息
     * @return: java.lang.Object
     * @date: 2020/9/4 10:54
     * @auther: 朱智
     *
     */
	public List<OpGhks> queryWaitMs(String ksmc) {
		OpGhks opGhks = new OpGhks();
		opGhks.setKsmc(ksmc);
		return opGhksDao.queryWaitMs(opGhks);
	}

	/**
	 * @name: fwtZsChange
	 * @description: 服务台诊室维护
	 * @param fwtid
	 * @param ksdmList
	 * @param type
	 * @return: java.lang.Object
	 * @date: 2020/9/4 14:19
	 * @auther: 朱智
	 *
	 */
	public void fwtKsChange(Integer fwtid, List<Integer> ksdmList, Integer type) {
		if(type.intValue() == 1){//加
			opGhksDao.changeFwtId(fwtid, ksdmList);
		}else{//减
			opGhksDao.changeFwtId(null, ksdmList);
		}
	}

	/**
	 * 通过门诊科室查询诊室信息
	 * @param mzks
	 * @param jgid
	 * @return
	 */
	public List<OpMzzsResp> getOpMzzsByMzks(Integer mzks, Integer jgid){
		List<OpMzzs> opMzzsByMzks = opMzzsDao.getOpMzzsByMzks(jgid, mzks);

		List<OpMzzsResp> resps = new ArrayList<>();
		if (CollUtil.isNotEmpty(opMzzsByMzks)){
			resps = opMzzsByMzks.stream().map(o -> {
				OpMzzsResp opMzzsResp = BeanUtil.toBean(o, OpMzzsResp.class);
				return opMzzsResp;
			}).collect(Collectors.toList());
		}
		return resps;
	}
}
