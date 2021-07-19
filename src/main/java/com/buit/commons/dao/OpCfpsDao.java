package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpCfps;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 处方皮试<br>
 * @author 朱智
 */
@Mapper
public interface OpCfpsDao extends EntityDao<OpCfps,Integer> {

    /**
     * @name: deleteByCfsb
     * @description: 根据处方识别删除
     * @param cfsb
     * @return: void
     * @date: 2020/11/2 13:59
     * @auther: 老花生
     *
     */
    void deleteByCfsb(@Param("cfsb") Integer cfsb);
}
