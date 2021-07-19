package com.buit.his.op.reg.service;


import java.util.List;

import com.buit.commons.request.QueryYyksYsInfoReq;
import com.buit.commons.response.QueryYyksYsInfoResp;
import com.buit.utill.MzUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpYyghDao;
import com.buit.commons.model.OpYygh;
import com.buit.commons.request.OpYyghQueryReq;
import com.buit.commons.response.OpYyghQueryResp;

/**
 * 门诊_预约挂号<br>
 * @author WY
 */
@Service
public class OpYyghSer extends BaseManagerImp<OpYygh,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(OpYyghSer.class);

    @Autowired
    private OpYyghDao opYyghDao;

    @Autowired
    private MzUtil mzUtil;
    
    @Override
    public OpYyghDao getEntityMapper(){        
        return opYyghDao;
    }

    /**
     * 预约查询(appointmentManageService.loadAppointedInfo)
     * @param opyygh
     * @return
     */
    public List<OpYyghQueryResp> loadAppointedInfo(OpYyghQueryReq opyygh) {
        List<OpYyghQueryResp> resp = opYyghDao.queryYyxx(opyygh);
        return resp;
    }

    public List<QueryYyksYsInfoResp> queryYyksYsInfo(QueryYyksYsInfoReq req) {
        List<String> zblb = mzUtil.getAllSddmByTime(req.getZblb());
        req.setZblb(String.join(",", zblb));
        return getEntityMapper().queryYyksYsInfo(req);
    }
}
