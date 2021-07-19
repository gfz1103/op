package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.DicYljg;
import com.buit.commons.response.DicYljgResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 医疗卫生机构索引表<br>
 *
 * @author yueyu
 */
@Mapper
public interface DicYljgDao extends EntityDao<DicYljg, Integer> {

    /**
     * 根据jgid查询机构信息
     *
     * @param jgidList
     */
    List<DicYljg> queryByJgid(@Param("list") List<String> jgidList);

    /**
     * 查询机构集合
     *
     * @param pyCode
     * @return
     */
    List<DicYljgResp> queryList(@Param("pyCode") String pyCode);

    /**
     * 停用机构
     * @param dicYljg
     */
    void stopYljg(DicYljg dicYljg);
}
