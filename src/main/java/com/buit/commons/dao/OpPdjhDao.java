package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpPdjh;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpPdjh;

/**
 * <br>
 * @author 老花生
 */
@Mapper
public interface OpPdjhDao extends EntityDao<OpPdjh,Integer> {

    /**
     * 根据参数删除
     * @param par
     */
    void deleteByObj(Map<String, Object> par);

    /**
     * 根据map查询数量
     * @param par
     * @return
     */
    Long findByMapCount(Map<String, Object> par);

    /**
     * 更新就诊状态
     * @param par
     */
    void updateJhzt(Map<String, Object> par);
}
