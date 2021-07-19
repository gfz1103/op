package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.response.InitPatientSetDisposeResp;
import com.buit.op.model.OpYjcf02Zt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 门诊_门诊医技单明细表_组套<br>
 * @author 老花生
 */
@Mapper
public interface OpYjcf02ZtDao extends EntityDao<OpYjcf02Zt,Integer> {

    /**
     * 查询医技组套
     * @param opYj02Zt
     * @return
     */
    InitPatientSetDisposeResp initPatientSetDispose(OpYjcf02Zt opYj02Zt);

    /**
     * 更新医技序号
     * @param ids
     * @param yjxh
     */
    void updateYjxh(@Param("ids") List<Integer> ids, @Param("yjxh") int yjxh);

    /**
     * 根据识别序号查询组套信息
     * @param parm
     * @return
     */
    Map<String, Object> getZtBySbxh(Map<String, Object> parm);

    /**
     * 根据识别序号集合删除
     */
    void deleteBySbxhList(Map<String, Object> parm);

    /**
     * 根据识别序号更新医技序号
     * @param param
     */
    void updateYjxhBySbxh(Map<String, Object> param);

    /**
     * 根据识别序号查询信息
     * @param sbxh
     * @return
     */
    Map<String, Object> getBySbxh(@Param("sbxh") Integer sbxh);

    /**
     * 通过医技序号查询同组
     * @param yjxh
     * @return
     */
    List<OpYjcf02Zt> queryByYjxh(Integer yjxh);

    /**
     * 通过医技序号删除同组
     * @param yjxh
     */
    void deleteByYjxh(Integer yjxh);

    /**
     * 通过就诊流水号和医技组号删除
     * @param jzlsh
     * @param yjzh
     */
    void deleteByJzlshAndYjzh(String jzlsh,Integer yjzh);

    /**
     * 通过就诊流水号和组套编号查询是否存在未作废的项目组套
     * @param jzlsh
     * @param ztbh
     * @return
     */
    int getByJzlshAndZtbh(String jzlsh,Integer ztbh);

    void updateYjxhAndYjzhBySbxh(Integer sbxh, Integer yjzh, Integer yjxh);
}
