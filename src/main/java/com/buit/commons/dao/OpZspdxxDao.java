package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpJzdlResult;
import com.buit.his.op.queuing.model.OpZspdxx;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * 门诊就诊队列<br>
 * @author 老花生
 */
@Mapper
public interface OpZspdxxDao extends EntityDao<OpZspdxx,Integer>{

    /**
     * @name: updateZdysByOid
     * @description: 更新指定医生
     * @param oid
     * @param ysdm
     * @return: void
     * @date: 2020/9/7 17:20
     * @auther: 朱智
     *
     */
    void updateZdysByOid(@Param("oid") Integer oid, @Param("zdys") Integer ysdm);

    /**
     * @name: updateZdysJzztByOid
     * @description: 更新指定医生、就诊状态
     * @param jzlsh
     * @param ysdm
     * @return: void
     * @date: 2020/9/7 17:58
     * @auther: 朱智
     *
     */
    void updateZdysJzztByOid(@Param("jzlsh") String jzlsh, @Param("zdys") Integer ysdm, @Param("zsid") Integer zsid);

    List<OpJzdlResult> getWaitQueueByDeptId(@Param("ksid") Integer ksid, @Param("jhksdm") Integer zsid,
                                            @Param("jhsj") Date jhsj, @Param("beginOfDay") Timestamp beginOfDay,
                                            @Param("endOfDay") Timestamp endOfDay, @Param("jgid") Integer hospitalId);

    List<OpJzdlResult> getWaitQueueByConsultCode(@Param("ksid") Integer ksid, @Param("jhksdm") Integer zsid,
                                                 @Param("jhsj") Date jhsj, @Param("beginOfDay") Timestamp beginOfDay,
                                                 @Param("endOfDay") Timestamp endOfDay, @Param("jgid") Integer hospitalId);

	/**
	 * 根据主键修改排队序号
	 *
	 * @param map
	 */
	void updatePdxhByOid(Map<String, Object> map);

    /**
     * 通过就诊流水号修改就诊状态
     * @param jzlsh
     * @param jzzt
     */
	int updateJzztByJzlsh(@Param("jzlsh") String jzlsh,@Param("jzzt") String jzzt);
}
