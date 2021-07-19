package com.buit.commons.dao;

import com.buit.commons.EntityDao;

import org.apache.ibatis.annotations.Mapper;
import com.buit.commons.model.OpCfdbr;
/**
 * 处方代办信息表<br>
 * @author 韦靖
 */
@Mapper
public interface OpCfdbrDao extends EntityDao<OpCfdbr,Integer>{
    /**
     * 通过处方识别删除处方代办人信息
     * @param cfsb
     * @return
     */
    void deleteByCfsb(Integer cfsb);

    /**
     * 通过处方识别查询代办人信息
     * @param cfsb
     * @return
     */
    OpCfdbr queryByCfsb(Integer cfsb);

}
