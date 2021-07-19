package com.buit.commons.dao;

import java.sql.Date;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.OpFpdyjl;

/**
 * 发票打印记录<br>
 * 
 * @author WY
 */
@Mapper
public interface OpFpdyjlDao extends EntityDao<OpFpdyjl, Date> {

}
