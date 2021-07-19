package com.buit.cis.op.dctwork.service;


import com.buit.cis.op.dctwork.request.GyBlmbAddReq;
import com.buit.cis.op.dctwork.request.GyBlmbReq;
import com.buit.cis.op.dctwork.request.GyBlmbSaveReq;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.commons.dao.GyBlmbDao;
import com.buit.commons.dao.PubPelplehealthteachMbDao;
import com.buit.commons.enums.SslbEnum;
import com.buit.commons.model.GyBlmb;
import com.buit.commons.model.PubPelplehealthteachMb;
import com.buit.commons.request.PubPelplehealthteachMbSaveReq;
import com.buit.commons.response.GyBlmbDetailsResp;
import com.buit.commons.response.GyBlmbResp;
import com.buit.constans.TableName;
import com.buit.utill.BeanUtil;
import com.buit.utill.PinyinUtils;
import com.buit.utill.RedisFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 公用_门诊病历模板<br>
 * @author 老花生
 */
@Service
public class GyBlmbSer extends BaseManagerImp<GyBlmb,Integer> {

    static final Logger logger = LoggerFactory.getLogger(GyBlmbSer.class);

    @Autowired
    private GyBlmbDao gyBlmbDao;
    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    private PubPelplehealthteachMbDao pubPelplehealthteachMbDao;

    @Override
    public GyBlmbDao getEntityMapper(){
        return gyBlmbDao;
    }

    /**
     * 查询模板
     * @param gyblmb    请求参数
     * @param user      用户对象
     * @return
     */
    public PageInfo<GyBlmbResp> query(GyBlmbReq gyblmb, SysUser user) {
        gyblmb.setJgid(user.getHospitalId());
        //个人
        if(SslbEnum.code_1.getCode().intValue() == gyblmb.getSslb().intValue()){
            gyblmb.setYgdm(user.getUserId());
        //科室
        }else if(SslbEnum.code_2.getCode().intValue() == gyblmb.getSslb().intValue()){
            gyblmb.setKsdm(gyblmb.getKsdm());
        }

        PageInfo<GyBlmb> pageInfo = PageHelper.startPage(
                gyblmb.getPageNum(), gyblmb.getPageSize()).doSelectPageInfo(
                () -> gyBlmbDao.findByEntity(gyblmb)
        );

        return BeanUtil.toPage(pageInfo, GyBlmbResp.class);
    }

    /**
     * 新增模板
     * @param req
     * @param user
     */
    public void add(GyBlmbAddReq req, SysUser user) {
        GyBlmb data = BeanUtil.toBean(req, GyBlmb.class);
        data.setJgid(user.getHospitalId());
        data.setPydm(PinyinUtils.getSimplePinYin(data.getMbmc()));

        //个人
        if(SslbEnum.code_1.getCode().intValue() == data.getSslb().intValue()){
            data.setYgdm(user.getUserId());
        //科室
        }else if(SslbEnum.code_2.getCode().intValue() == data.getSslb().intValue()){
            data.setKsdm(req.getKsdm());
        }

        List<GyBlmb> ret = gyBlmbDao.findByEntity(data);
        if(ret.isEmpty()){
            data.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.GY_BLMB));
            gyBlmbDao.insert(data);
        }else{
            throw BaseException.create("ERROR_DCTWORK_OP_0002");
        }
    }

    /**
     * 保存模板
     * @param req
     * @param user
     */
    @Transactional(rollbackFor=Exception.class)
    public void save(GyBlmbSaveReq req, SysUser user) {
        //更新模板表
        GyBlmb obj = gyBlmbDao.getById(req.getJlxh());
        BeanUtils.copyProperties(req, obj);
        gyBlmbDao.update(obj);

        //删除模板下健康教育数据
        PubPelplehealthteachMb del = new PubPelplehealthteachMb();
        del.setJlxh(String.valueOf(req.getJlxh()));
        pubPelplehealthteachMbDao.removeByEntity(del);

        //新增模板下健康教育数据
        List<PubPelplehealthteachMbSaveReq> list = req.getMbList();
        if(!list.isEmpty()){
            for(PubPelplehealthteachMbSaveReq mb : list){
                PubPelplehealthteachMb mbObj = BeanUtil.toBean(mb, PubPelplehealthteachMb.class);
                mbObj.setId(String.valueOf(redisFactory.getTableKey(TableName.DB_NAME, TableName.PUB_PELPLEHEALTHTEACH_MB)));
                pubPelplehealthteachMbDao.insert(mbObj);
            }
        }
    }

    /**
     * 根据记录号查询模板
     * @param jlxh
     * @return
     */
    public GyBlmbDetailsResp getObjbyId(Integer jlxh) {
        GyBlmb obj = gyBlmbDao.getById(jlxh);
        if(obj == null){
            return new GyBlmbDetailsResp();
        }
        GyBlmbDetailsResp ret = BeanUtil.toBean(obj, GyBlmbDetailsResp.class);

        PubPelplehealthteachMb query = new PubPelplehealthteachMb();
        query.setJlxh(String.valueOf(jlxh));
        List<PubPelplehealthteachMb> list = pubPelplehealthteachMbDao.findByEntity(query);

        ret.setJkcfRecords(list);
        return ret;
    }

    /**
     * 更新启用标志
     * @param jlxh
     * @param qybz
     */
    public void updateQybz(Integer jlxh, String qybz) {
        GyBlmb obj = new GyBlmb();
        obj.setJlxh(jlxh);
        obj.setQybz(Integer.parseInt(qybz));
        gyBlmbDao.updateQybz(obj);
    }
}
