package com.buit.ecis.pretriage.dao;

import com.buit.commons.EntityDao;

import com.buit.ecis.pretriage.request.ErPreYjfzQxReq;
import com.buit.ecis.pretriage.response.YjfzBrdaResp;

import org.apache.ibatis.annotations.Mapper;
import com.buit.ecis.pretriage.model.ErPreYjfz;
import org.apache.ibatis.annotations.Param;

/**
 * 急诊预检分诊<br>
 * @author 朱智
 */
@Mapper
public interface ErPreYjfzDao extends EntityDao<ErPreYjfz,Integer>{

    /**
     * @name: cancel
     * @description: 取消
     * @param lsh
     * @return: void
     * @date: 2020/9/15 17:23
     * @auther: 朱智
     *
     */
    void cancel(@Param("lsh") Integer lsh);

    /**
     * @name: patientWhereabouts
     * @description: patientWhereabouts
     * @param req
     * @return: void
     * @date: 2020/9/15 17:32
     * @auther: 朱智
     *
     */
    void patientWhereabouts(ErPreYjfzQxReq req);

	/**
	 * 挂号管理分诊病人信息调入
	 * 
	 * @param lsh
	 * @return
	 */
	YjfzBrdaResp getByLsh(@Param("lsh") Integer lsh, @Param("drzt") String drzt);

	/**
	 * 更新分诊调入状态
	 * 
	 * @param lsh
	 */
	void doProcessDrzt(String lsh);

	/**
	 * //更新预检分诊记录的卡号
	 * 
	 * @param jzkh
	 * @param lsh
	 */
	void doUpdateJzkhByLsh(@Param("jzkh") String jzkh, @Param("lsh") Integer lsh);
}
