package com.buit.commons.dao;


import com.buit.cis.op.dctwork.response.FeeYlsfxm;
import com.buit.cis.op.dctwork.response.FeeYlsfxmDetailResponse;
import com.buit.cis.op.dctwork.response.QueryMzYsFjResp;
import com.buit.commons.EntityDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 公用_医疗收费<br>
 *
 * @author 老花生
 */
@Mapper
public interface FeeYlsfxmDao extends EntityDao<FeeYlsfxm, Integer> {
    /**
     * 查询费用归并、费用序号、费用单价
     *
     * @param parameters
     * @return
     */
    List<Map<String, Object>> getFygbFyxhFydj(Map<String, Object> parameters);

    /**
     * 查询费用序号、费用名称、作废判别、医保编码
     *
     * @param parameters
     * @return
     */
    List<Map<String, Object>> getFyxhFymcZfpbYbbm(Map<String, Object> parameters);

    /**
     * 查询辅检-医保
     *
     * @param queryfjxx
     * @return
     */
    List<QueryMzYsFjResp> getfjxxyb(Map<String, Object> queryfjxx);

    /**
     * 查询辅检-医保
     *
     * @param queryfjxx
     * @return
     */
    List<QueryMzYsFjResp> getfjxx(Map<String, Object> queryfjxx);

    /**
     * 查询保险费用
     *
     * @param parameters
     * @return
     */
    List<Map<String, Object>> getBxfy(Map<String, Object> parameters);

    /**
     * 查询保险信息
     *
     * @param param
     * @return
     */
    Map<String, Object> getBxInfo(Map<String, Object> param);

    /**
     * 通过fyxh查询具体的收费项目
     * @param jgid
     * @param fyxh
     * @return
     */
    FeeYlsfxmDetailResponse getYlsfxmByFyxh(Integer jgid,Integer fyxh);
}
