package com.buit.commons.dao;


import com.buit.commons.EntityDao;
import com.buit.commons.model.GyZlfa;
import org.apache.ibatis.annotations.Mapper;

/**
 * 公用_诊疗方案<br>
 * @author 老花生
 */
@Mapper
public interface GyZlfaDao extends EntityDao<GyZlfa,Integer> {
    /**
     * 更新启用状态
      * @param zlfa
     */
    void updateFlag(GyZlfa zlfa);
}
