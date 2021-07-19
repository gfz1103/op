package com.buit.commons.dao;

import com.buit.commons.EntityDao;

import com.buit.commons.model.MpBlackList;
import org.apache.ibatis.annotations.Mapper;
/**
 * 黑名单表<br>
 * @author DESKTOP-1OEG1QM
 */
@Mapper
public interface MpBlackListDao extends EntityDao<MpBlackList,Long>{

    Boolean checkBlackList(String sfzh);
}
