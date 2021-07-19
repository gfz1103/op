package com.buit.commons.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.buit.commons.response.MpiKpxxPrintFpResp;
import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.op.model.MpiKpxx;

import org.apache.ibatis.annotations.Param;

/**
 * 充值卡管理<br>
 * 
 * @author WY
 */
@Mapper
public interface MpiKpxxDao extends EntityDao<MpiKpxx, Integer> {

	/**
	 * 充值卡信息查询
	 * 
	 * @param fphm
	 * @return
	 */
	List<Map<String, Object>> getMpiKpxxInfo(String fphm);

	/**
	 * 更新充值卡信息
	 * 
	 * @param tfje
	 * @param brid
	 */
	void updateMsPkxx(@Param("tfje") BigDecimal tfje, @Param("brid") String brid);

	/**
	 * 根据卡号查询充值卡信息
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getMpiKpxxByCardNo(Map<String, Object> map);

	/**
	 * 更新卡内余额
	 * 
	 * @param map
	 */
	void updateKnye(Map<String, Object> map);

	/**
	 * 查询卡片信息
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getKpInfo(Map<String, Object> map);

	/**
	 * 更新卡内余额
	 * 
	 * @param map
	 */
	void updateKnyeByCondition(Map<String, Object> map);

	/**
	 * 通过病人id查询卡信息
	 * 
	 * @param brid
	 * @return
	 */
	List<Map<String, Object>> queryCardInfoByBrid(String brid);

	/**
	 * 通过病人id更新卡内余额
	 * 
	 * @param brid
	 */
	void updateKnyeByBrid(Map<String, Object> map);

	/**
	 * 充值卡分页查询
	 * 
	 * @param mpiKpxx
	 * @return
	 */
	List<MpiKpxx> doQueryCzkList(MpiKpxx mpiKpxx);

	/**
	 * 根据卡号查询卡信息
	 * 
	 * @param map
	 * @return
	 */
	Map<String, Object> getKpxxBycardNo(Map<String, Object> map);

	/**
	 * 根据cardId更新卡内余额
	 * 
	 * @param map
	 */
	void updateKnyeByCardId(Map<String, Object> map);

	/**
	 * 根据cardId查询余额
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getknyeByCardId(Map<String, Object> map);

	/**
	 * 卡内余额扣款
	 * 
	 * @param map
	 */
	void updateKnyeSubtr(Map<String, Object> map);

	/**
	 * 根据发票号码查询卡信息
	 * 
	 * @param fphm
	 * @return
	 */
	List<Map<String, Object>> queryCardInfoByFphm(String fphm);

	/**
	 * 更改状态
	 * 
	 * @param map
	 */
	void updateStatus(Map<String, Object> map);

}
