package com.buit.commons.dao;

import com.buit.cis.op.dctwork.response.FeeYpxzYpxzResp;
import com.buit.commons.EntityDao;
import com.buit.commons.model.FeeYpxz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 公用_药品禁用<br>
 * @author "MLeo"
 */
@Mapper
public interface FeeYpxzDao extends EntityDao<FeeYpxz,Integer>{
    /**
     * 批量插入
     * @param ypjies
     */
    void batchInsert(List<FeeYpxz> ypjies);

    /**
     * 删除
     * @param ypxh
     */
    void deleteByYpxh(Integer ypxh);

    /** 更新状态 */
//        void updateStatus(FeeYpxz feeYpxz);

    /**
     * 获取药品禁用信息
     * @param feeYpxz
     * @return
     */
	Map<String, Object> getYpjyInfo(FeeYpxz feeYpxz);

    /**
     * 根据brxz、ypxh查询
     * @param brxz
     * @param ypxh
     * @return
     */
    FeeYpxz getByBrxzAndYpxh(@Param("brxz") Integer brxz, @Param("ypxh") Integer ypxh);

    /**
     * 中心维护-病人性质维护-药品限制-列表
     * @param brxz  病人性质代码
     * @param pydm  拼音代码
     * @return
     */
    List<FeeYpxzYpxzResp> queryYpxzList(@Param("brxz") Integer brxz, @Param("pydm") String pydm);

    /**
     * 中心维护-病人性质维护-药品限制-删除
     * @param brxz
     * @param ypxh
     */
    void deleteById(@Param("brxz") Integer brxz, @Param("ypxh") Integer ypxh);
}
