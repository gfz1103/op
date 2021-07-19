package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.MkeyUser;
import org.apache.ibatis.annotations.Mapper;
/**
 * CA用户表<br>
 * @author 韦靖
 */
@Mapper
public interface MkeyUserDao extends EntityDao<MkeyUser,Integer>{

    /**
     * 通过mkey用户标识查询
     * @param mkeyUserId
     * @return
     */
    MkeyUser selectByMkeyUserId(String mkeyUserId);

    /**
     * 通过用户ID查询
     * @param sysUserId
     * @return
     */
    MkeyUser selectBySysUserId(String sysUserId);

    /**
     * 新增医护人员的证书序列号
     * @param mkeyUser
     */
    void updateMkeyUser(MkeyUser mkeyUser);

    /**
     * 修改ca账号和证书序列号
     * @param mkeyUser
     */
    void updateCaZsxlh(MkeyUser mkeyUser);
}
