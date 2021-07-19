package com.buit.cis.op.dctwork.service;


import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.commons.dao.OpBrzdDao;
import com.buit.commons.dao.OpYsJzlsDao;
import com.buit.commons.request.OpYsJzlsListReq;
import com.buit.commons.response.OpYsJzlsListResp;
import com.buit.op.model.OpYsJzls;
import com.buit.system.utill.ObjectToTypes;
import com.buit.utill.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 门诊_就诊历史<br>
 * @author 老花生
 */
@Service
public class OpYsJzlsSer extends BaseManagerImp<OpYsJzls,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(OpYsJzlsSer.class);
    
    @Autowired
    private OpYsJzlsDao opYsJzlsDao;
    @Autowired
    private OpBrzdDao opBrzdDao;

    @Override
    public OpYsJzlsDao getEntityMapper(){        
        return opYsJzlsDao;
    }


    /**
     * 查询就诊记录
     * @param req
     * @param user
     * @return
     */
    public PageInfo<OpYsJzlsListResp> getList(OpYsJzlsListReq req, SysUser user) {
        OpYsJzls query = BeanUtil.toBean(req, OpYsJzls.class);
        query.setJgid(user.getHospitalIdStr());
        PageInfo<OpYsJzlsListResp> pageInfo = PageHelper.startPage(req.getPageNum(),req.getPageSize())
                .doSelectPageInfo(()->opYsJzlsDao.queryJzls(query));

        List<OpYsJzlsListResp> jzlsList = pageInfo.getList();
        //根据就诊序号集合查询诊断集合
        List<Map<String, Object>> zdList = new ArrayList<>();
        if(jzlsList.isEmpty()){
            return pageInfo;
        }else{
            zdList = opBrzdDao.queryBrzdListByJzxhList(jzlsList);
        }
        //查询的诊断集合插入到返回page中
        for(OpYsJzlsListResp jzls : jzlsList){
            for(Map<String, Object> zd : zdList){
                if(jzls.getJzxh().intValue() == ObjectToTypes.parseInt(zd.get("jzxh"))){
                    jzls.setZyzd(zd.get("zdmc").toString());
                }
            }
        }

        return pageInfo;
    }
}
