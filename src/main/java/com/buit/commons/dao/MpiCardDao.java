package com.buit.commons.dao;

import java.util.List;
import java.util.Map;

import com.buit.op.model.mphis.request.MphisJzxxjyRequest;
import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.MpiCard;

import org.apache.ibatis.annotations.Param;

/**
 * EMPI个人基本信息(卡)<br>
 * 
 * @author wangyang
 */
@Mapper
public interface MpiCardDao extends EntityDao<MpiCard, String> {
	/**
	 * 根据就诊号码查询人员卡信息
	 * 
	 * @author wy
	 * @param jzhm
	 * @return
	 */
	List<MpiCard> doQueryPerson(MpiCard mpiCard);

	/**
	 * 根据条件更改病人性质
	 * 
	 * @author wy
	 * @param brxz
	 * @param empiId
	 * @param jzkh
	 */
	void updateBrxz(@Param("ybxz") Integer ybxz, @Param("brid") Integer brid, @Param("jzkh") String jzkh);

	/**
	 * 根据就诊号码查询人员卡信息
	 * 
	 * @param mpiCard
	 * @return
	 */
	MpiCard getMpiCardInfo(MpiCard mpiCard);

	/**
	 * 更改卡状态
	 * 
	 * @author wy
	 * @param mpiCard
	 */
	void updateCardStatus(MpiCard mpiCard);

	/**
	 * 获得卡号
	 * 
	 * @param map
	 * @return
	 */
	Map<String, Object> getCardNo(Map<String, Object> map);

	/**
	 * 根据卡号查询卡信息
	 * 
	 * @param map
	 * @return
	 */
	Map<String, Object> getMpiCardInfoByCardNo(Map<String, Object> map);

	/**
	 * 根据卡号查询卡信息
	 * @param parameters
	 * @return
	 */
	List<MpiCard> getCardInfoByCardNo(Map<String,Object> parameters);

	/**
	 * 提报更新病人性质
	 * @param parameters
	 */
	void updateBrxzByYb(Map<String,Object> parameters);

	long countIsYb(String brkh);

	Boolean checkCardInfo(MphisJzxxjyRequest request);

	MpiCard getWnCardInfo(MphisJzxxjyRequest request);
}
