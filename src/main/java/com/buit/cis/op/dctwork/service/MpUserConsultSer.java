package com.buit.cis.op.dctwork.service;


import com.buit.cis.op.dctwork.request.WorkloadAccountForKFReq;
import com.buit.cis.op.dctwork.request.WorkloadAccountForYSReq;
import com.buit.cis.op.dctwork.response.WorkloadAccountForKFResp;
import com.buit.cis.op.dctwork.response.WorkloadAccountForYSResp;
import com.buit.cis.op.dctwork.service.easemob.code.EasemobConsts;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.MpUserConsultDao;
import com.buit.commons.model.MpUserConsult;
import com.buit.commons.model.OnlineConsultCount;
import com.buit.commons.model.WorkloadAccountForKF;
import com.buit.constans.TableName;
import com.buit.utill.BeanUtil;
import com.buit.utill.RedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * 用户咨询表（客服使用）<br>
 * @author 韦靖
 */
@Service
public class MpUserConsultSer extends BaseManagerImp<MpUserConsult,Integer> {

    static final Logger logger = LoggerFactory.getLogger(MpUserConsultSer.class);

    @Autowired
    private MpUserConsultDao mpUserConsultDao;

    @Autowired
    public RedisFactory redisFactory;

    @Override
    public MpUserConsultDao getEntityMapper(){
        return mpUserConsultDao;
    }

    /**
     * 查询在线客服的工作量
     * @param userNames
     * @return
     */
    public List<OnlineConsultCount> onlineConsultCount(List<String> userNames){
        List<OnlineConsultCount> consultCounts = mpUserConsultDao.onlineConsultCount(userNames);
        return consultCounts;
    }

    /**
     * 新增咨询记录
     * @param userid
     * @param zxrid
     */
    public MpUserConsult addConsultCount(Integer userid, Long zxrid, String zxrxm, String zxrsjhm){
        MpUserConsult consult = new MpUserConsult();
        consult.setId(redisFactory.getTableKey(TableName.DB_NAME, TableName.MP_USER_CONSULT));
        consult.setUserid(userid);
        consult.setZxrid(zxrid);
        consult.setZxkssj(new Timestamp(System.currentTimeMillis()));
        consult.setZxzt(EasemobConsts.ZXZT.START.getKey());
        consult.setCreateTime(new Timestamp(System.currentTimeMillis()));
        consult.setZxrxm(zxrxm);
        consult.setZxrsjhm(zxrsjhm);
        mpUserConsultDao.insert(consult);
        return consult;
    }

    /**
     * 修改咨询状态(结束咨询)
     * @param id
     * @param zxzt
     */
    public void updateConsultZt(Integer id,Integer zxzt){
        mpUserConsultDao.updateConsultZt(id,zxzt);
    }

    /**
     * 客服工作量统计
     * @param req
     * @return
     */
    public List<WorkloadAccountForKFResp> workloadAccountForKF(WorkloadAccountForKFReq req){
        List<WorkloadAccountForKF> accountForKFS = mpUserConsultDao.workloadAccountForKF(req);
        return BeanUtil.toBeans(accountForKFS, WorkloadAccountForKFResp.class);
    }

    public List<WorkloadAccountForYSResp> workloadAccountForYS(WorkloadAccountForYSReq req) {
        return mpUserConsultDao.workloadAccountForYS(req);
    }
}
