package com.buit.his.op.infusion.service;

import cn.hutool.core.collection.CollUtil;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.SkinXmDao;
import com.buit.commons.model.SkinXm;
import com.buit.commons.request.OpCf02SaveReq;
import com.buit.commons.request.SkinXmAddReq;
import com.buit.commons.response.SkinXmHzResp;
import com.buit.commons.response.SkinXmResp;
import com.buit.constans.TableName;
import com.buit.drug.response.DrugsTypkDetailResp;
import com.buit.drug.service.DrugsTypkOutSer;
import com.buit.system.service.SysDictConfigSer;
import com.buit.utill.RedisFactory;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <br>
 *
 * @author WY
 */
@Service
public class SkinXmSer extends BaseManagerImp<SkinXm, Integer> {

	static final Logger logger = LoggerFactory.getLogger(SkinXmSer.class);

	@Autowired
	private SkinXmDao skinXmDao;

	@DubboReference
	private SysDictConfigSer sysDictConfigSer;

	@Autowired
	private RedisFactory redisFactory;

	@DubboReference
	private DrugsTypkOutSer drugsTypkOutSer;

	@Override
	public SkinXmDao getEntityMapper() {
		return skinXmDao;
	}

	/**
	 * 皮试列表查询
	 *
	 * @param jgid
	 * @return
	 */
	public List<SkinXmResp> doQuerySkinTestList(Integer jgid) {
		SkinXm skinXm = new SkinXm();
		skinXm.setJgid(jgid);
		List<SkinXmResp> resp = skinXmDao.doQuerySkinTestList(skinXm);
		return resp;
	}

	/**
	 * 皮试项目新增
	 *
	 * @param req
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doSaveSkinTest(SkinXmAddReq req) {
		if ("".equals(req.getPsmc()) || req.getPsmc() == null) {
			throw BaseException.create("ERROR_SKINTEST_0001");
		}
		if (req.getPssc() == null) {
			throw BaseException.create("ERROR_SKINTEST_0002");
		}
		Integer isExistPsmc = skinXmDao.isExistPsmc(req.getJgid(), req.getPsmc(), null);
		if (isExistPsmc != null && isExistPsmc.intValue() > 0) {
			throw BaseException.create("ERROR_SKINTEST_0003");
		}

		SkinXm skinXm = new SkinXm();
		BeanUtils.copyProperties(req, skinXm);
		// 设置拼音、五笔字符
//		ChineseCharacterUtil.setPyAndWb(skinXm, skinXm.getPsmc());
		skinXm.setPsid(redisFactory.getTableKey(TableName.DB_NAME, TableName.SKIN_XM));
		skinXm.setZt("0");
		skinXmDao.insert(skinXm);
		// 更新字典
		sysDictConfigSer.upDateVersion("skin_xm");
	}

	/**
	 * 皮试项目修改
	 *
	 * @param req
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doUpdateSkinTest(@Valid SkinXmAddReq req) {
		if ("".equals(req.getPsmc()) || req.getPsmc() == null) {
			throw BaseException.create("ERROR_SKINTEST_0001");
		}
		if (req.getPssc() == null) {
			throw BaseException.create("ERROR_SKINTEST_0002");
		}
		Integer isExistPsmc = skinXmDao.isExistPsmc(req.getJgid(), req.getPsmc(), req.getPsid());
		if (isExistPsmc != null && isExistPsmc.intValue() > 0) {
			throw BaseException.create("ERROR_SKINTEST_0003");
		}
		SkinXm skinXm = new SkinXm();
		BeanUtils.copyProperties(req, skinXm);
		// 设置拼音、五笔字符
//		ChineseCharacterUtil.setPyAndWb(skinXm, skinXm.getPsmc());
		skinXmDao.updatePsxm(skinXm);
		// 更新字典
		sysDictConfigSer.upDateVersion("skin_xm");
	}

	/**
	 * 皮试项目启用停用
	 * @param skinXm
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doUpdateZt(SkinXm skinXm) {
		skinXmDao.updatePsxm(skinXm);
		// 更新字典
		sysDictConfigSer.upDateVersion("skin_xm");
	}

	/**
	 * 皮试项目删除
	 *
	 * @param skinXm
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doDeleteSkinTest(SkinXm skinXm) {
		List<SkinXm> list = skinXmDao.findByEntity(skinXm);
		if (list.size() > 0) {
			throw BaseException.create("ERROR_SKINTEST_0004");
		}
		skinXmDao.doDeleteSkinTest(skinXm);
		// 更新字典
		sysDictConfigSer.upDateVersion("skin_xm");
	}

	/**
	 * 门诊处方皮试药品带出皮试项目
	 *
	 * @param skinXm
	 * @return
	 */
	public List<SkinXmHzResp> doQueryPsxmHz(SkinXm skinXm) {
		return skinXmDao.doQueryPsxmHz(skinXm);
	}

	/**
	 * 通过药品列表获取皮试项目列表
	 * @param drugs
	 * @return
	 */
	public List<SkinXmHzResp> getPsxmByDrugs(List<OpCf02SaveReq> drugs){
		if (CollUtil.isEmpty(drugs)){
			return null;
		}

		List<Integer> psids = new ArrayList<>();
		List<Integer> removePsids = new ArrayList<>();
		//判断哪些项目不需要做皮试
		drugs.stream().forEach(o ->{
			//查询药品获取药品对应的psid
            if (o.getYpxh() != null){
                DrugsTypkDetailResp drugMessage = drugsTypkOutSer.getDrugsTypkById(o.getYpxh());
                if (drugMessage != null && drugMessage.getPspb() == 1 && drugMessage.getPsid() != null){
                    if (o.getPsjg() != null && o.getPsjg() == 0){
                        if (!removePsids.contains(drugMessage.getPsid()) && !psids.contains(drugMessage.getPsid())){
                            psids.add(drugMessage.getPsid());
                        }
                    }else {
                        psids.remove(drugMessage.getPsid());
                        removePsids.add(drugMessage.getPsid());
                    }
                }
            }
		});

		List<Integer> drugList = drugs.stream().map(o -> o.getYpxh()).collect(Collectors.toList());
		List<SkinXmHzResp> skinXmHzResps = skinXmDao.getpsxmByDrugs(drugList);
		if (CollUtil.isNotEmpty(skinXmHzResps)){
			List<SkinXmHzResp> collect = skinXmHzResps.stream().filter(o -> psids.contains(o.getPsid())).collect(Collectors.toList());
			return  collect;
		}

		return skinXmHzResps;
	}
}
