package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.MkeyRecordCert;
import org.apache.ibatis.annotations.Mapper;
/**
 * 签名记录证书<br>
 * @author 韦靖
 */
@Mapper
public interface MkeyRecordCertDao extends EntityDao<MkeyRecordCert,Integer>{

    MkeyRecordCert selectByRecordId(Integer recordId);
}
