package com.buit.commons.dao;

import com.buit.cis.op.dctwork.request.WorkloadAccountForKFReq;
import com.buit.cis.op.dctwork.request.WorkloadAccountForYSReq;
import com.buit.cis.op.dctwork.response.WorkloadAccountForYSResp;
import com.buit.commons.EntityDao;
import com.buit.commons.model.MpUserConsult;
import com.buit.commons.model.OnlineConsultCount;
import com.buit.commons.model.WorkloadAccountForKF;
import com.buit.op.response.ConsultCountResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户咨询表（客服使用）<br>
 * @author 韦靖
 */
@Mapper
public interface MpUserConsultDao extends EntityDao<MpUserConsult,Integer>{

    /**
     * 查询在线客服的正在咨询的人数
     * @param userNames
     * @return
     */
    List<OnlineConsultCount> onlineConsultCount(@Param("userNames") List<String> userNames);

    /**
     * 修改咨询状态（结束咨询）
     * @param id
     * @param zxzt
     */
    void updateConsultZt(@Param("id") Integer id,@Param("zxzt") Integer zxzt);

    /**
     * 客服工作量统计
     * @param param
     * @return
     */
    List<WorkloadAccountForKF> workloadAccountForKF(WorkloadAccountForKFReq param);


    /**
     * 医生工作量统计
     * @param req
     * @return
     */
    List<WorkloadAccountForYSResp> workloadAccountForYS(WorkloadAccountForYSReq req);


    /**
     * 查询咨询人当天咨询的客服（最近一条）
     * @param zxrid
     * @return
     */
    MpUserConsult selectzxjl(Long zxrid);

    /**
     * 查询客服当日的咨询量
     * @param userid
     * @return
     */
    ConsultCountResp consultCount(@Param("userid") Integer userid);

}
