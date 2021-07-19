package com.buit.cis.op.dctwork.service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.buit.apply.model.OpSbhy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.apply.model.OpSbhy;
import com.buit.apply.response.QueryRecentTimeByHyrqResp;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpSbhyDao;

import cn.hutool.core.date.DateUtil;

/**
 * 设备号源表<br>
 * @author 老花生
 */
@Service
public class OpSbhySer extends BaseManagerImp<OpSbhy,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(OpSbhySer.class);
    
    @Autowired
    private OpSbhyDao opSbhyDao;
    
    @Override
    public OpSbhyDao getEntityMapper(){        
        return opSbhyDao;
    }


    /**
     * 冻结设备号源
     * @param hyid
     * @param djys
     */
    public void freezeSbhh(Integer hyid, Integer djys) {
        opSbhyDao.freezeSbhh(hyid, djys);
    }

    /**
     * 解冻设备号源
     * @param hyid
     */
    public void unfreezeSbhh(Integer hyid) {
        opSbhyDao.unfreezeSbhh(hyid);
    }

    /**
     * 查询设备指定日期最近的号源
     * @param jklx
     * @param hyrq
     */
    public List<QueryRecentTimeByHyrqResp> queryRecentTimeByHyrq(Integer jklx, Date hyrq) {
        // 今天之前的数据不显示
        String nowTime = null;
        if ((DateUtil.date().getTime() - hyrq.getTime()) > 0) {
            return null;
        } else if ((DateUtil.date().getTime() - hyrq.getTime()) == 0) {
            nowTime = new SimpleDateFormat("HH:mm").format(new Date());
        }
        return opSbhyDao.queryRecentTimeByHyrq(jklx, hyrq, nowTime);
    }

    /**
     * 判断号源是否已经被占用
     * @param hyid
     * @return
     */
    public Boolean checkHyid(Integer hyid) {
        OpSbhy sbhy = opSbhyDao.getById(hyid);
        if(sbhy == null){
            return false;
        }else{
            return true;
        }
    }
}
