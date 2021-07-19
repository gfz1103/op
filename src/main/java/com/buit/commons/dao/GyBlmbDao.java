package com.buit.commons.dao;


import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.GyBlmb;

/**
 * 公用_门诊病历模板<br>
 * @author 老花生
 */
@Mapper
public interface GyBlmbDao extends EntityDao<GyBlmb,Integer> {
    /**
     * 更细启用标志
     * @param obj   更新对象
     */
    void updateQybz(GyBlmb obj);
}
