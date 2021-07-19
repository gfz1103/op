package com.buit.cis.op.dctwork.service;


import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpYjcf02Dao;
import com.buit.op.model.OpYjcf02;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 门诊_门诊医技单明细表<br>
 * @author 老花生
 */
@Service
public class OpYjcf02Ser extends BaseManagerImp<OpYjcf02,Integer> {

    static final Logger logger = LoggerFactory.getLogger(OpYjcf02Ser.class);

    @Autowired
    private OpYjcf02Dao opYjcf02Dao;

    @Override
    public OpYjcf02Dao getEntityMapper(){
        return opYjcf02Dao;
    }

    /**
     * 获取最大医技组号
     * @param jzlsh
     * @param jgid
     * @return
     */
    public Integer getMaxYjzh(String jzlsh,Integer jgid){
        //获取最大医技组号
        Integer maxYjzh = opYjcf02Dao.getMaxYjzh(jzlsh, jgid);
        if (maxYjzh == null){
            maxYjzh = 1;
        }else {
            maxYjzh ++;
        }
        return maxYjzh;
    }

    /**
     * 查询代煎费
     * @param cfsb
     * @param jgid
     * @return
     */
    public OpYjcf02 getDjf(Integer cfsb,Integer jgid){
        return opYjcf02Dao.getDjf(cfsb, jgid);
    }
}
