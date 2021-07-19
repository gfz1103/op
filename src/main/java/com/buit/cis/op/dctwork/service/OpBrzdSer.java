package com.buit.cis.op.dctwork.service;


import cn.hutool.core.thread.ThreadUtil;
import com.buit.cis.op.dctwork.ybtspost.service.YbtspostService;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.commons.dao.MsBcjlDao;
import com.buit.commons.dao.OpBrzdDao;
import com.buit.commons.dao.OpGhmxDao;
import com.buit.commons.model.MsBcjl;
import com.buit.commons.model.OpBrzd;
import com.buit.commons.request.OpBrzdAddReq;
import com.buit.commons.request.OpBrzdQueryReq;
import com.buit.commons.request.OpBrzdReq;
import com.buit.commons.request.OpBrzdSaveReq;
import com.buit.commons.response.OpBrzdQueryResp;
import com.buit.commons.response.OpBrzdResp;
import com.buit.constans.TableName;
import com.buit.utill.BeanUtil;
import com.buit.utill.DateUtil;
import com.buit.utill.ParamUtil;
import com.buit.utill.RedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 门诊_病人诊断<br>
 * @author 老花生
 */
@Service
public class OpBrzdSer extends BaseManagerImp<OpBrzd,Integer> {

    static final Logger logger = LoggerFactory.getLogger(OpBrzdSer.class);


    @Autowired
    private OpBrzdDao opBrzdDao;
    @Autowired
    private OpGhmxDao opGhmxDao;
    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    private MsBcjlDao msBcjlDao;
    @Autowired
    private YbtspostService ybtspostService;

    @Override
    public OpBrzdDao getEntityMapper(){
        return opBrzdDao;
    }

    public List<OpBrzdResp> customQuery(OpBrzdReq req, SysUser user) {
        OpBrzd brzd = BeanUtil.toBean(req, OpBrzd.class);
        brzd.setJgid(user.getHospitalId());
        return opBrzdDao.customQuery(brzd);
    }

    /**
     * 保存
     * @param req
     */
    @Transactional(rollbackFor = Exception.class)
    public void save(OpBrzdSaveReq req, SysUser user) {

        List<OpBrzdAddReq> dignosisList = req.getBrzdList();
        int jzxh =  req.getJzxh();
        int brid = req.getBrid();
        int plxh = 0;
        Map<String,Integer> SJZD_MAP = new HashMap<>();
        //删除老的诊断
        opBrzdDao.deleteByBridJzxh(req);
        for (OpBrzdAddReq brzdReq : dignosisList) {
            OpBrzd brzd = BeanUtil.toBean(brzdReq, OpBrzd.class);

            Integer deep = brzd.getDeep();
            if(deep.intValue() != 0) {
                brzd.setSjzd(SJZD_MAP.get("SJZD_" + (deep - 1)));
            }
            brzd.setJzxh(jzxh);
            brzd.setBrid(brid);
            brzd.setJgid(user.getHospitalId());
            brzd.setPlxh(plxh++);
            brzd.setZdsj(DateUtil.getCurrentTimestamp());
            brzd.setYgzd(0);
            brzd.setJzlsh(req.getJzlsh());

            //更新挂号表的诊断序号(主诊断更新)
            if(brzd.getZzbz() == 1){
                Map<String, Object> udtGhmx = ParamUtil.instance().put("zdxh",brzdReq.getZdxh()).put("jzxh",req.getJzxh());
                opGhmxDao.updateBySbxh(udtGhmx);
            }

            Integer jlbh = redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_BRZD);
            brzd.setJlbh(jlbh);
            opBrzdDao.insert(brzd);

            SJZD_MAP.put("SJZD_"+deep, jlbh);

        }

        //医保智能提醒
        ThreadUtil.execAsync(()->{
            logger.info("【门诊诊断】调用医保智能提醒开始");
            try {
                ybtspostService.mzzd(req.getJzlsh(),user.getHospitalId(),req.getIp());
            }catch (Exception e){
                logger.error("【门诊诊断】调用医保智能提醒失败:",e);
            }
            logger.info("【门诊诊断】调用医保智能提醒结束");
        });
    }

    /**
     * 查询诊断信息列表
     * @param req
     * @return
     */
    public OpBrzdQueryResp queryMsbrzd(OpBrzdQueryReq req) {
        OpBrzdQueryResp resp = new OpBrzdQueryResp();
        String zdmc = "";
        String zsxx = "";

        // 申请类型 1=门诊，2=住院
        int sqlx = req.getSqlx();
        int jzxh = req.getJzxh();
        Map<String, Object> map = ParamUtil.instance().put("jzxh", jzxh);
        List<OpBrzd> reslut = opBrzdDao.findByEntity(map);

        //主诉 与体格检查 加上 提示头信息，与换行符
        List<MsBcjl> zsxxList = msBcjlDao.findByEntity(map);

        for (OpBrzd m : reslut) {
            zdmc += m.getZdmc() + ",";
            // 取主诊断名称及其ICD10
            if ("0".equals(m.getPlxh())) {
                resp.setMainIcd10(m.getIcd10());
                resp.setMainZdmc(m.getZdmc());
            }
        }
        if (zdmc.length() > 0) {
            zdmc = zdmc.substring(0, zdmc.lastIndexOf(","));
        }
        if(!zsxxList.isEmpty()){
            zsxx = zsxxList.get(0).getZsxx();
        }else{
            //主诉未填写或未保存病历！
            throw BaseException.create("ERROR_DCTWORK_OP_0010");
        }

        resp.setZdmc(zdmc);
        resp.setTztz(zsxx);
        return resp;
    }
}
