package com.buit.commons.dao;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.commons.model.ApiEcgReport;

/**
 * 接口心电图<br>
 * @author 老花生
 */
@Mapper
public interface ApiEcgReportDao extends EntityDao<ApiEcgReport,Integer> {
    
}
