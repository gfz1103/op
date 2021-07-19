package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpMzzs;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 门诊诊室信息<br>
 *
 * @author WY
 */
@Mapper
public interface OpMzzsDao extends EntityDao<OpMzzs, Integer> {

	/**
	 * 校验同一科室诊室ID是否存在
	 *
	 * @param ghks
	 * @param zsid
	 * @param oldZsId
	 * @return
	 */
	Integer validZsIdExist(Integer ghks, Integer zsid, String zsmc, Integer oldZsId);

	/**
	 * @name: queryWaitMs
	 * @description: 查询待选择诊室信息
	 * @param opMzzs
	 * @return: java.util.List<com.buit.his.op.reg.model.OpMzzs>
	 * @date: 2020/9/4 11:08
	 * @auther: 朱智
	 *
	 */
    List<OpMzzs> queryWaitMs(OpMzzs opMzzs);

    /**
     * @name: changeFwtId
     * @description: 根据zsid集合更新服务台id
     * @param fwtid
     * @param sbxhList
     * @return: void
     * @date: 2020/9/4 14:25
     * @auther: 朱智
     *
     */
	void changeFwtId(@Param("fwtid") Integer fwtid, @Param("sbxhList") List<Integer> sbxhList);

	/**
	 * @name: getSbxhByIp
	 * @description: 根据ip查询识别序号
	 * @param lastLoginIp
	 * @return: java.lang.Integer
	 * @date: 2020/9/8 17:10
	 * @auther: 朱智
	 *
	 */
    Integer getSbxhByIp(String lastLoginIp);

    //通过门诊科室查询其对应的诊室列表
	List<OpMzzs> getOpMzzsByMzks(@Param("jgid") Integer jgid,@Param("mzks") Integer mzks);
}
