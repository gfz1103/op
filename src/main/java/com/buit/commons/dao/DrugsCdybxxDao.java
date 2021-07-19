package com.buit.commons.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.DrugsCdybxx;
import com.buit.commons.response.QueryYbypxxResp;

/**
 * 药品产地医保信息<br>
 * @author 老花生
 */
@Mapper
public interface DrugsCdybxxDao extends EntityDao<DrugsCdybxx,Integer>{

    /**
     * 根据药品序号、药品产地查询集合
     * @param parameters
     * @return
     */
    List<QueryYbypxxResp> findByYpxhYpcd(Map<String, Object> parameters);

    void deleteByxhcd(Integer ypxh,Integer ypcd);
  //  void save(Map<String,Object> med);
}
