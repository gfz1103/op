package com.buit.commons.dao;

import com.buit.cis.op.dctwork.response.DiccZlsfdzResp;
import com.buit.commons.EntityDao;
import com.buit.system.model.DiccZlsfdz;
import com.buit.system.response.GyYlxmDicResp;
import com.buit.system.response.LoadSqdDetailInfoResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 诊疗收费对照<br>
 * @author 老花生
 */
@Mapper
public interface DiccZlsfdzDao extends EntityDao<DiccZlsfdz,Integer>{
    /**
     * 查询医技预病人申请单详细信息
     * @param jcxh
     * @return
     */
    List<LoadSqdDetailInfoResp> loadSqdDetailInfo(@Param("jcxh") Integer jcxh);

    /**
     * 根据诊疗项目ID删除
     * @param zlxmId
     */
    void deleteByZlxmId(@Param("zlxmId") int zlxmId);

    /**
     * 诊疗收费对照字典
     * @param jgid
     * @param pydm
     * @return
     */
    List<GyYlxmDicResp> queryZlsfdzDicList(@Param("jgid") int jgid, @Param("pydm") String pydm);

    /**
     * 诊疗收费对照列表
     * @param zlxmid
     * @return
     */
    List<DiccZlsfdzResp> queryZlsfdzList(@Param("zlxmid") int zlxmid);

    /**
     * @name: getListByZlxmidList
     * @description: 根据诊疗项目ID集合查询
     * @return: void
     * @date: 2020/9/14 13:24
     * @auther: 朱智
     *
     */
    List<Integer> getListByZlxmidList(String[] zlxmids);
}
