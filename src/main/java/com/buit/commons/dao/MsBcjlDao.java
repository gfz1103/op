package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.MsBcjl;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 门诊_门诊病历 | 病程记录<br>
 * @author 老花生
 */
@Mapper
public interface MsBcjlDao extends EntityDao<MsBcjl,Integer> {

    /**
     * 更新打印标志
     * @param params2
     */
    void updateDybz(Map<String, Object> params2);

    /**
     * 更新状态，病人去向，健康教育等信息
     * @param params2
     */
    void updateJzzt(Map<String, Object> params2);

    /**
     * 更新打印状态
     * @param params2
     */
    void updateBrqxJkjyDybzByJzxh(Map<String, Object> params2);
}
