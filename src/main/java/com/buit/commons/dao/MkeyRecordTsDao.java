package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.MkeyRecordTs;
import org.apache.ibatis.annotations.Mapper;
/**
 * 签名记录时间戳<br>
 * @author 韦靖
 */
@Mapper
public interface MkeyRecordTsDao extends EntityDao<MkeyRecordTs,Integer>{

}
