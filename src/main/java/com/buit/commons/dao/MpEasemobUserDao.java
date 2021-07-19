package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.MpEasemobUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 环信用户表（客服使用）<br>
 * @author 韦靖
 */
@Mapper
public interface MpEasemobUserDao extends EntityDao<MpEasemobUser,Long>{
    /**
     * 查询用户-通过医生（客服）的唯一id
     * @param userid
     * @return
     */
    MpEasemobUser easemobIsExit(@Param("userid") String userid);

    /**
     * 查询有效的客服环信数据
     * @return
     */
    List<MpEasemobUser> getEffectiveData();

    /**
     * 修改环信账号状态（禁用与解禁）
     * @param mpEasemobUser
     */
    void updateZt(MpEasemobUser mpEasemobUser);

    /**
     * 通过用户id查询环信账号信息
     * @param userid
     * @return
     */
    MpEasemobUser getEaseMobUserByUserId(@Param("userid") Long userid);

    /**
     * 逻辑删除更改state
     * @param mpEasemobUser
     */
    void updateState(MpEasemobUser mpEasemobUser);

    /**
     * 查询环信账号列表（返回医生（客服）的姓名）
     * @param mpEasemobUser
     * @return
     */
    List<MpEasemobUser> queryEasemobUser(MpEasemobUser mpEasemobUser);
}
