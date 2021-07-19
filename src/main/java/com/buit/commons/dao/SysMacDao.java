package com.buit.commons.dao;

import com.buit.commons.EntityDao;

import org.apache.ibatis.annotations.Mapper;
import com.buit.commons.model.SysMac;
/**
 * MAC信息表(用于mac地址维护)<br>
 * @author 韦靖
 */
@Mapper
public interface SysMacDao extends EntityDao<SysMac,Integer>{

    /**
     * 通过ip获取mac
     * @param ip
     * @param jgid
     * @return
     */
    String getMacByIp(String ip,Integer jgid);
}
