package com.buit.ecis.pretriage.service;


import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.ecis.pretriage.dao.ErPreZsjlDao;
import com.buit.ecis.pretriage.dao.ErPreZslbDao;
import com.buit.ecis.pretriage.model.ErPreZslb;
import com.buit.ecis.pretriage.request.ErPreZslbAddReq;
import com.buit.ecis.pretriage.response.ErPreZslbResp;
import com.buit.utill.BeanUtil;
import com.buit.utill.ParamUtil;
import com.buit.utill.RedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 主诉类别<br>
 * @author 朱智
 */
@Service
public class ErPreZslbSer extends BaseManagerImp<ErPreZslb,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(ErPreZslbSer.class);
    
    @Autowired
    private ErPreZslbDao erPreZslbDao;
    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    private ErPreZsjlDao erPreZsjlDao;

    @Override
    public ErPreZslbDao getEntityMapper(){        
        return erPreZslbDao;
    }

    /**
     * @name: add
     * @description: 新增
     * @param erPreZslb
     * @return: void
     * @date: 2020/9/10 19:17
     * @auther: 朱智
     *
     */
    public void add(ErPreZslbAddReq erPreZslb) {
        Integer id = redisFactory.getTableKey(TableName.DB_NAME, TableName.ER_PRE_ZSLB);
        erPreZslb.setZslbid(id);
        erPreZslbDao.insert(erPreZslb);
    }

    /**
     * @name: getList
     * @description: 查询列表
     * @return: java.lang.Object
     * @date: 2020/9/11 10:59
     * @auther: 朱智
     *
     */
    public List<ErPreZslbResp> getList() {
        ErPreZslbResp ret = new ErPreZslbResp();
        ret.setZslbid(0);
        ret.setZslb("主诉类别");
        List<ErPreZslb> list = erPreZslbDao.findByEntity(new ErPreZslb());
        ErPreZslbResp resp = setChild(list, 0, ret);
        if(resp != null){
            return resp.getChildren();
        }else{
            return null;
        }

    }

    private ErPreZslbResp setChild(List<ErPreZslb> list, Integer fid, ErPreZslbResp ret){
        for(ErPreZslb zslb : list){
            if(fid == zslb.getFid()){
                ErPreZslbResp resp = BeanUtil.toBean(zslb, ErPreZslbResp.class);
                if(ret.getChildren() == null){
                    ret.setChildren(new ArrayList<>());
                }
                ret.getChildren().add(resp);
                setChild(list, resp.getZslbid(), resp);
            }
        }
        return ret;
    }

    /**
     * @name: delete
     * @description: 删除
     * @param zslbid
     * @return: void
     * @date: 2020/9/13 9:30
     * @auther: 朱智
     *
     */
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer zslbid) {
        erPreZslbDao.deleteById(zslbid);
        erPreZsjlDao.removeByEntity(ParamUtil.instance().put("zslbid", zslbid));
    }
}
