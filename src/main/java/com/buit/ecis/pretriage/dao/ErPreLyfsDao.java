package com.buit.ecis.pretriage.dao;

import com.buit.commons.EntityDao;

import com.buit.ecis.pretriage.request.ErPreLyfsUpdateInfoReq;
import com.buit.ecis.pretriage.request.ErPreLyfsUpdateZtReq;
import org.apache.ibatis.annotations.Mapper;
import com.buit.ecis.pretriage.model.ErPreLyfs;
/**
 * 来院方式<br>
 * @author 朱智
 */
@Mapper
public interface ErPreLyfsDao extends EntityDao<ErPreLyfs,Integer>{

    /**
     * @name: updateZt
     * @description: 更新状态
     * @param erPreLyfs
     * @return: void
     * @date: 2020/9/10 15:05
     * @auther: 朱智
     *
     */
    void updateZt(ErPreLyfsUpdateZtReq erPreLyfs);

    /**
     * @name: updateInfo
     * @description: 编辑信息
     * @param erPreLyfs
     * @return: void
     * @date: 2020/9/10 15:09
     * @auther: 朱智
     *
     */
    void updateInfo(ErPreLyfsUpdateInfoReq erPreLyfs);
}
