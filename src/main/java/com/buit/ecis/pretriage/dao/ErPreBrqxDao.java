package com.buit.ecis.pretriage.dao;

import com.buit.commons.EntityDao;

import org.apache.ibatis.annotations.Mapper;
import com.buit.ecis.pretriage.model.ErPreBrqx;
/**
 * 病人去向<br>
 * @author 朱智
 */
@Mapper
public interface ErPreBrqxDao extends EntityDao<ErPreBrqx,Integer>{
    
}
