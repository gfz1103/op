package com.buit.cis.op.dctwork.service;


import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.commons.dao.PubCyzdDao;
import com.buit.commons.model.PubCyzd;
import com.buit.commons.request.PubCyzdReq;
import com.buit.commons.request.PubCyzdSaveReq;
import com.buit.commons.response.PubCyzdResp;
import com.buit.constans.TableName;
import com.buit.utill.BeanUtil;
import com.buit.utill.PinyinUtils;
import com.buit.utill.RedisFactory;
import com.buit.utill.WubiUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公用_个人常用诊断表<br>
 * @author 老花生
 */
@Service
public class PubCyzdSer extends BaseManagerImp<PubCyzd,Integer> {

    static final Logger logger = LoggerFactory.getLogger(PubCyzdSer.class);

    @Autowired
    private PubCyzdDao pubCyzdDao;
    @Autowired
    private RedisFactory redisFactory;

    @Override
    public PubCyzdDao getEntityMapper(){
        return pubCyzdDao;
    }

    /**
     * 查询个人常用诊断
     * @param pubcyzd    请求对象
     * @return
     */
    public List<PubCyzdResp> query(PubCyzdReq pubcyzd, SysUser user) {
        pubcyzd.setJgid(user.getHospitalId());
        pubcyzd.setYgdm(user.getUserId());
        return pubCyzdDao.query(pubcyzd);
    }

    /**
     * 查询个人常用诊断-分页
     * @param pubcyzd    请求对象
     * @return
     */
    public PageInfo<PubCyzdResp> queryPage(PubCyzdReq pubcyzd, SysUser user) {
        pubcyzd.setJgid(user.getHospitalId());
        pubcyzd.setYgdm(user.getUserId());
        PageInfo<PubCyzdResp> pageInfo = PageHelper.startPage(
                pubcyzd.getPageNum(), pubcyzd.getPageSize()).doSelectPageInfo(
                () -> pubCyzdDao.query(pubcyzd)
        );
        return pageInfo;
    }

    /**
     * 新增个人常用诊断
     * @param req   请求信息
     * @param user  用户信息
     */
    public void add(PubCyzdSaveReq req, SysUser user) {

        PubCyzd query = new PubCyzd();
        query.setZdxh(req.getZdxh());
        query.setYgdm(user.getUserId());
        query.setJgid(user.getHospitalId());
        List<PubCyzd> ret = pubCyzdDao.findByEntity(query);
        if(!ret.isEmpty()){
            throw BaseException.create("ERROR_DCTWORK_OP_0001");
        }

        PubCyzd pubcyzd = BeanUtil.toBean(req, PubCyzd.class);
        pubcyzd.setYgdm(user.getUserId());
        pubcyzd.setJgid(user.getHospitalId());
        pubcyzd.setJlbh(redisFactory.getTableKey(TableName.DB_NAME, TableName.PUB_CYZD));
        pubcyzd.setPydm(PinyinUtils.getSimplePinYin(req.getZdmc()));
        pubcyzd.setWbdm(WubiUtils.getSimpleWuBi(req.getZdmc()));
        pubCyzdDao.insert(pubcyzd);
    }
}
