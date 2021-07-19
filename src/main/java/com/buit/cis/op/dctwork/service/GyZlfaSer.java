package com.buit.cis.op.dctwork.service;


import com.buit.cis.op.dctwork.request.GyBlmbReq;
import com.buit.cis.op.dctwork.request.GyZlfaAddReq;
import com.buit.cis.op.dctwork.request.GyZlfaSaveReq;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.commons.dao.GyZlfaDao;
import com.buit.commons.enums.SslbEnum;
import com.buit.commons.enums.StopFlagEnum;
import com.buit.commons.model.GyBlmb;
import com.buit.commons.model.GyZlfa;
import com.buit.commons.model.OpZt01;
import com.buit.commons.request.PubCyzdReq;
import com.buit.commons.response.GyBlmbResp;
import com.buit.commons.response.GyZlfaMapResp;
import com.buit.commons.response.OpZt01Resp;
import com.buit.commons.response.PubCyzdResp;
import com.buit.constans.TableName;
import com.buit.utill.BeanUtil;
import com.buit.utill.PinyinUtils;
import com.buit.utill.RedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 公用_诊疗方案<br>
 * @author 老花生
 */
@Service
public class GyZlfaSer extends BaseManagerImp<GyZlfa,Integer> {

    static final Logger logger = LoggerFactory.getLogger(GyZlfaSer.class);

    @Autowired
    private GyZlfaDao gyZlfaDao;
    @Autowired
    private PubCyzdSer pubCyzdSer;
    @Autowired
    private OpZt01Ser opZt01Ser;
    @Autowired
    private GyBlmbSer gyBlmbSer;
    @Autowired
    private RedisFactory redisFactory;

    @Override
    public GyZlfaDao getEntityMapper(){
        return gyZlfaDao;
    }

    public GyZlfaMapResp queryList(SysUser user) {
        GyZlfaMapResp ret = new GyZlfaMapResp();
        //查询常用诊断
        List<PubCyzdResp> cyzt = pubCyzdSer.query(new PubCyzdReq(), user);
        ret.setCyzt(cyzt);


        //处方组套
        OpZt01 zt = new OpZt01();
        zt.setJgid(user.getHospitalId());
        zt.setYgdm(user.getUserId());
        zt.setSslb(SslbEnum.code_1.getCode());
        zt.setSfqy(1);
        List<OpZt01> ztret = opZt01Ser.findByEntity(zt);

        List<OpZt01Resp> cfList = new ArrayList<>();
        List<OpZt01Resp> xmList = new ArrayList<>();
        for(OpZt01 obj : ztret){
            if(SslbEnum.code_4.getCode().intValue() == obj.getZtlb().intValue()){
                xmList.add(BeanUtil.toBean(obj, OpZt01Resp.class));
            }else{
                cfList.add(BeanUtil.toBean(obj, OpZt01Resp.class));
            }
        }
        ret.setCfzt(cfList);

        //项目组套
        ret.setXmzt(xmList);

        //病历模板
        GyBlmbReq gyblmb = new GyBlmbReq();
        gyblmb.setSslb(SslbEnum.code_1.getCode());
        gyblmb.setYgdm(user.getUserId());
        List<GyBlmb> blmb = gyBlmbSer.findByEntity(gyblmb);
        List<GyBlmbResp> gyBlmbResps = BeanUtil.toBeans(blmb, GyBlmbResp.class);
        ret.setBlmb(gyBlmbResps);

        return ret;
    }

    /**
     * 新增诊疗方案
     * @param req
     * @param user
     */
    public Integer add(GyZlfaAddReq req, SysUser user) {
        GyZlfa query = new GyZlfa();
        query.setZlmc(req.getZlmc());
        //query.setQybz(Integer.parseInt(StopFlagEnum.code_1.getCode()));
        List<GyZlfa> list = gyZlfaDao.findByEntity(query);
        if(!list.isEmpty()){
            throw BaseException.create("ERROR_DCTWORK_OP_0026");
        }

        req.setZlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.GY_ZLFA));
        req.setJgid(user.getHospitalId());
        req.setYgdm(user.getUserId());
        req.setQybz(Integer.parseInt(StopFlagEnum.code_1.getCode()));
        req.setSslb(SslbEnum.code_4.getCode());
        req.setPydm(PinyinUtils.getSimplePinYin(req.getZlmc()));
        gyZlfaDao.insert(req);

        return req.getZlxh();
    }

    /**
     * 保存明细
     * @param req
     */
    public void save(GyZlfaSaveReq req) {
        GyZlfa zlfa = gyZlfaDao.getById(req.getZlxh());
        zlfa.setJbxh(req.getJbxh());
        zlfa.setCfztbh(req.getCfztbh());
        zlfa.setXmztbh(req.getXmztbh());
        zlfa.setBlmbbh(req.getBlmbbh());

        gyZlfaDao.update(zlfa);
    }

    /**
     * 停用
     * @param zlxh  诊疗序号
     */
    public void stop(Integer zlxh) {
        GyZlfa zlfa = new GyZlfa();
        zlfa.setZlxh(zlxh);
        zlfa.setQybz(Integer.parseInt(StopFlagEnum.code_0.getCode()));
        gyZlfaDao.updateFlag(zlfa);
    }

    /**
     * 启用
     * @param zlxh  诊疗序号
     */
    public void enable(Integer zlxh) {
        GyZlfa zlfa = new GyZlfa();
        zlfa.setZlxh(zlxh);
        zlfa.setQybz(Integer.parseInt(StopFlagEnum.code_1.getCode()));
        gyZlfaDao.updateFlag(zlfa);
    }
}
