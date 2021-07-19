package com.buit.his.op.infusion.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.SkinXmldsfxmDao;
import com.buit.commons.model.SkinXmldsfxm;
import com.buit.commons.request.SkinXmldsfxmAddReq;
import com.buit.commons.request.SkinXmldsfxmReq;
import com.buit.commons.response.SkinXmldsfxmResp;

/**
 * <br>
 * 
 * @author WY
 */
@Service
public class SkinXmldsfxmSer extends BaseManagerImp<SkinXmldsfxm, Integer> {

	static final Logger logger = LoggerFactory.getLogger(SkinXmldsfxmSer.class);

	@Autowired
	private SkinXmldsfxmDao skinXmldsfxmDao;

	@Override
	public SkinXmldsfxmDao getEntityMapper() {
		return skinXmldsfxmDao;
	}

	/**
	 * 根据皮试ID获取联动收费项目
	 * 
	 * @param hospitalId
	 * @param psid
	 * @return
	 */
	public List<SkinXmldsfxmResp> doQueryLdsfxmList(SkinXmldsfxm skinXmldsfxm) {
		List<SkinXmldsfxmResp> resp = skinXmldsfxmDao.doQueryLdsfxmList(skinXmldsfxm);
		return resp;
	}

	/**
	 * 联动收费项目新增修改
	 * 
	 * @param req
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doSaveLdsfxm(List<SkinXmldsfxmAddReq> list, Integer jgid) {
		// 修改时清空原有数据，重新添加
		if (list != null && !list.isEmpty()) {
			SkinXmldsfxmAddReq sfxm = list.get(0);
			SkinXmldsfxm skinXmldsfxm = new SkinXmldsfxm();
			skinXmldsfxm.setJgid(jgid);
			skinXmldsfxm.setPsid(sfxm.getPsid());
			skinXmldsfxm.setXmlx(sfxm.getXmlx());
			skinXmldsfxmDao.removeByEntity(skinXmldsfxm);
		}

		for (SkinXmldsfxmAddReq req : list) {
			req.setJgid(jgid);
			if (req.getSfxmdm() == null) {
				throw BaseException.create("ERROR_SKINTEST_0005");
			}
			if (req.getSl() == null) {
				throw BaseException.create("ERROR_SKINTEST_0006");
			}
		}
		skinXmldsfxmDao.doSaveLdsfxm(list);
	}

	/**
	 * 联动收费项目删除
	 * 
	 * @param req
	 */
	public void doDeleteLdsfxm(SkinXmldsfxmReq req) {
		SkinXmldsfxm skinXmldsfxm = new SkinXmldsfxm();
		BeanUtils.copyProperties(req, skinXmldsfxm);
		skinXmldsfxmDao.removeByEntity(skinXmldsfxm);
	}

	/**
	 * 校验药品序号是否重复
	 * 
	 * @param orderList
	 * @return
	 */
//	private Boolean knowledgeIsRepeat(List<Knowledge> orderList) {
//		Set<Knowledge> set = new TreeSet<Knowledge>(new Comparator<Knowledge>() {
//			public int compare(Knowledge a, Knowledge b) {
//				// 字符串则按照asicc码升序排列
//				return a.getCode().compareTo(b.getCode());
//			}
//		});
//		set.addAll(orderList);
//		if (set.size() < orderList.size()) {
//			return true;
//		}
//		return false;
//	}

}
