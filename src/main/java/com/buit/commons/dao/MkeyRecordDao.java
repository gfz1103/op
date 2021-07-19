package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.op.model.mphis.response.MkeyRecord;
import org.apache.ibatis.annotations.Mapper;
/**
 * CA签名记录表<br>
 * @author 韦靖
 */
@Mapper
public interface MkeyRecordDao extends EntityDao<MkeyRecord,Integer>{

    MkeyRecord selectByBizsn(String bizSn);

    void updateSelectiveById(MkeyRecord record);
}
