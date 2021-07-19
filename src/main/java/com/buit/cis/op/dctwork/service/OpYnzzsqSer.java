package com.buit.cis.op.dctwork.service;


import com.buit.cis.op.dctwork.request.OpYnzzsqSaveReq;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.OpYnzzsqDao;
import com.buit.commons.model.OpYnzzsq;
import com.buit.constans.TableName;
import com.buit.utill.BeanUtil;
import com.buit.utill.RedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 院内转诊申请<br>
 * @author 老花生
 */
@Service
public class OpYnzzsqSer extends BaseManagerImp<OpYnzzsq,Integer> {

    static final Logger logger = LoggerFactory.getLogger(OpYnzzsqSer.class);

    @Autowired
    private OpYnzzsqDao opYnzzsqDao;
    @Autowired
    private RedisFactory redisFactory;

    @Override
    public OpYnzzsqDao getEntityMapper(){
        return opYnzzsqDao;
    }

    /**
     * 院内转诊
     * @param req
     */
    public void saveYnzzsq(OpYnzzsqSaveReq req) {
        Map<String, Object> parameters = new HashMap<>(16);
        parameters.put("jzks", req.getJzks());
        parameters.put("jzys", req.getJzys());
        parameters.put("sqrq", new Date());
        parameters.put("brid", req.getBrid());
        parameters.put("jzkh", req.getJzkh());
        List<OpYnzzsq> list = opYnzzsqDao.findByEntity(parameters);

        if(list.isEmpty()){
            OpYnzzsq sq = BeanUtil.toBean(req, OpYnzzsq.class);
            if(sq.getBrnl().indexOf("岁") >0 ){
                sq.setBrnl(sq.getBrnl().replace("岁", ""));
            }
            sq.setSqrq(new Timestamp(System.currentTimeMillis()));
            sq.setZfbz(0);
            sq.setSqdh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YNZZSQ));
            sq.setJzlsh(req.getJzlsh());
            opYnzzsqDao.insert(sq);
        }else {
            parameters.put("zzks", req.getZzks());
            parameters.put("sqzd", req.getSqzd());
            parameters.put("zzmd", req.getZzmd());
            //更新转诊科室、目前诊断、转诊目的
            opYnzzsqDao.updateZzksSqzdZzmd(parameters);
        }
    }
}
