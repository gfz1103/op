package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.DicZlxm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 诊疗项目<br>
 * @author 老花生
 */
@Mapper
public interface DicZlxmDao extends EntityDao<DicZlxm,Integer> {

    /**
     * 查询费用总和
     * @param parameters
     * @return
     */
    List<Map<String, Object>> getFyzh(Map<String, Object> parameters);

    /**
     * 查询费用项目、诊疗项目ID、费用数量
     * @param parameters
     * @return
     */
    List<Map<String, Object>> getFyxhZlxmidFysl(Map<String, Object> parameters);
}
