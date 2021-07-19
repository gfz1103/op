package com.buit.his.op.infusion.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.SyKsDao;
import com.buit.commons.model.SyKs;
import com.buit.commons.request.SyKsAddReq;
import com.buit.commons.response.SyKsResp;

/**
 * 输液/注射科室设置<br>
 * 
 * @author WY
 */
@Service
public class SyKsSer extends BaseManagerImp<SyKs, String> {

	static final Logger logger = LoggerFactory.getLogger(SyKsSer.class);

	@Autowired
	private SyKsDao syKsDao;

	@Override
	public SyKsDao getEntityMapper() {
		return syKsDao;
	}

	/**
	 * 输液科室新增
	 * 
	 * @param req
	 */
	public void doSaveSyks(SyKsAddReq req) {
		if (req.getTmscgz() != null && "4".equals(req.getTmscgz())) {
			if ("".equals(req.getQz()) || req.getQz() == null) {
				throw BaseException.create("ERROR_INFUSION_0001");
			}
		}
		SyKs syKs = new SyKs();
		BeanUtils.copyProperties(req, syKs);
		List<SyKsResp> isExist = doQuerySyksList(req.getJgid(), req.getKsdm(), req.getKslb(), null);
		if (isExist != null && !isExist.isEmpty()) {
			syKsDao.doUpdateSyKs(syKs);
		} else {
			syKsDao.insert(syKs);
		}

	}

	/**
	 * 查询输液科室列表
	 * 
	 * @param jgid
	 * @param ksdm
	 * @param kslb
	 * @return
	 */
	public List<SyKsResp> doQuerySyksList(Integer jgid, Integer ksdm, String kslb, String zt) {
		return syKsDao.doQuerySyksList(jgid, ksdm, kslb, zt);
	}

	/**
	 * 校验条码规则重复
	 * 
	 * @param jgid
	 * @param kslb
	 * @param sxhws
	 * @return
	 */
	public Boolean doValidDjdh(Integer jgid, String tmscgz, String kslb, Integer sxhws, Integer ksdm) {
		boolean isValid = Boolean.TRUE;
		Integer count = syKsDao.doValidDjdh(jgid, tmscgz, kslb, sxhws, ksdm);
		if (count != null && count.intValue() > 0) {
			isValid = Boolean.FALSE;
		}
		return isValid;
	}

}
