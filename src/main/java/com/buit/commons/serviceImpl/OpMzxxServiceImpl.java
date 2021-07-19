package com.buit.commons.serviceImpl;

import cn.hutool.core.bean.BeanUtil;
import com.buit.commons.BaseException;
import com.buit.commons.dao.OpGhmxDao;
import com.buit.commons.dao.OpMzxxDao;
import com.buit.commons.dao.WlKfdzDao;
import com.buit.commons.model.OpMzxx;
import com.buit.op.request.ValidWpjfbzReq;
import com.buit.op.response.IOpMzxxResp;
import com.buit.op.service.OpMzxxService;
import com.buit.system.response.SysXtcs;
import com.buit.system.service.DicKszdOutSer;
import com.buit.system.service.SysXtcsCacheSer;
import com.buit.system.utill.ObjectToTypes;
import com.buit.utill.MzUtil;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 病人档案
 * @Author 汪洋
 * @Date 2020/10/10 15:23
 */
@DubboService(timeout = 10000)
public class OpMzxxServiceImpl implements OpMzxxService {
	@DubboReference
	private SysXtcsCacheSer sysXtcsCacheSer;
	@Autowired
	private OpGhmxDao opGhmxDao;
	@Autowired
	private WlKfdzDao wlKfdzDao;
	@DubboReference
	private DicKszdOutSer dicKszdOutSer;

	@Autowired
	OpMzxxDao opMzxxDao;
	/**
	 * 验证病区是否开启物品计费标志 并判断是否存在二级库房
	 *
	 * @param req
	 */
	public void doVerificationWpjfbz(ValidWpjfbzReq req) {
		Map<String, Object> body = MzUtil.caseInsensitiveMap(req);
		// 当前病区
		long bq = 0;
		int wpjfbz = 0;
		// 住院
		if (body.containsKey("bq")) {
			bq = ObjectToTypes.parseLong(body.get("bq"));
			SysXtcs sysXtcs = sysXtcsCacheSer.getByJGIdAndCsmc(req.getJgid(), "WPJFBZ");
			wpjfbz = sysXtcs == null ? 0 : ObjectToTypes.parseInt(sysXtcs.getCsz());
			if (wpjfbz == 0) {
				return;
			}
		} else {// 门诊
			SysXtcs sysXtcs = sysXtcsCacheSer.getByJGIdAndCsmc(req.getJgid(), "MZWPJFBZ");
			wpjfbz = sysXtcs == null ? 0 : ObjectToTypes.parseInt(sysXtcs.getCsz());
			if (wpjfbz == 0) {
				return;
			}
			long ghgl = ObjectToTypes.parseLong(body.get("GHGL"));
			long ghks = ObjectToTypes.parseLong(body.get("GHKS"));
			if (ghgl == 0 && ghks == 0) {
				throw BaseException.create("ERROR_REG_0023");
			}
			Map<String, Object> mapGhks = new HashMap<String, Object>(16);
			Map<String, Object> mapParGhks = new HashMap<String, Object>(16);
			if (ghks == 0) {
				mapParGhks.put("ksdm", ghks);
				mapGhks = opGhmxDao.getKsInfo(mapParGhks);
			} else {
				mapParGhks.put("ksdm", ghks);

				mapGhks = dicKszdOutSer.getKsInfo(mapParGhks);
				//mapGhks = dicKszdDao.getKsInfo(mapParGhks);
			}
			if (mapGhks == null || mapGhks.size() == 0) {
				throw BaseException.create("ERROR_REG_0024");
			}
			bq = ObjectToTypes.parseLong(mapGhks.get("KSDM"));
		}
		Map<String, Object> mapPar = new HashMap<String, Object>(16);
		mapPar.put("bq", bq);
		long l = wlKfdzDao.getCountByKsdm(mapPar);
		if (l == 0) {
			throw BaseException.create("ERROR_REG_0025");
		}
	}

	@Override
	public IOpMzxxResp getById(Integer mzxh) {
		OpMzxx opMzxx = opMzxxDao.getById(mzxh);
		return BeanUtil.toBean(opMzxx,IOpMzxxResp.class);
	}
}
