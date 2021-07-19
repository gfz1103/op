package com.buit.commons.dao;


import com.buit.commons.EntityDao;
import com.buit.commons.model.OpZt01;
import com.buit.commons.request.OpZt01QueReq;
import com.buit.commons.response.OpZt01AccountingSrfResp;
import com.buit.commons.response.OpZt01Resp;
import com.buit.commons.response.QueryMzYsFjZtResp;
import com.buit.op.request.IOpZt01AccountingSrfReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 门诊医生组套
 * @author 老花生
 */
@Mapper
public interface OpZt01Dao extends EntityDao<OpZt01,Integer> {
    /**
     * 更新数据状态
     * @param opZt01  请求参数
     */
    void updateFlag(OpZt01 opZt01);

    /**
     * 初始化用户查询组套信息
     * @param ztbhs
     * @return
     */
    List<OpZt01Resp> initPatientSet(List<Integer> ztbhs);

    /**
     * 开处方 时的组套输入法
     * @param ztbhs
     * @return
     */
    List<OpZt01Resp> ztsrf(OpZt01QueReq Req);

    /**
     * 住院药品医嘱组套查询
     * @Title: queryMedicalStack
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param ygdm
     * @param @param ksdm
     * @param @param jgid
     * @param @param pydm
     * @param @return    设定文件
     * @return List<OpZt01>    返回类型
     * @author 龚方舟
     * @throws
     */
    List<OpZt01> queryMedicalStack(@Param("ygdm") Integer ygdm, @Param("ksdm") Integer ksdm,
    		@Param("jgid") Integer jgid, @Param("pydm") String pydm);

    /**
     * 费用记账查询项目组套
     * @Title: queryProjectStackAccounting
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param parameters
     * @param @return    设定文件
     * @return List<OpZt01AccountingSrfResp>    返回类型
     * @author 龚方舟
     * @throws
     */
    List<OpZt01AccountingSrfResp> queryProjectStackAccounting(IOpZt01AccountingSrfReq req);


    /**
     * 查询组套编号、组套名称、项目类型、所属类别
     * @param queryZt
     * @return
     */
    List<QueryMzYsFjZtResp> queryZtbhZtmcXmlxSslb(Map<String, Object> queryZt);

    /**
     * 判断组套名称是否已经存在
     * @param sslb
     * @param ztlb
     * @param ztmc
     * @return
     */
    int checkZtmcIsExit(Integer sslb,Integer ztlb,String ztmc);
}
