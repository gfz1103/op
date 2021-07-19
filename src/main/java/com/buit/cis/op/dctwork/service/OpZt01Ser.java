package com.buit.cis.op.dctwork.service;


import cn.hutool.core.collection.CollUtil;
import com.buit.cis.op.dctwork.controller.OpZtAddReq;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.commons.dao.OpZt01Dao;
import com.buit.commons.enums.StopFlagEnum;
import com.buit.commons.model.OpZt01;
import com.buit.commons.request.OpZt01AddReq;
import com.buit.commons.request.OpZt01EditReq;
import com.buit.commons.request.OpZt01Req;
import com.buit.commons.response.OpZt01Resp;
import com.buit.utill.BeanUtil;
import com.buit.utill.PinyinUtils;
import com.buit.utill.RedisFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 门诊_门诊医生组套 | 个人:YGDM值
科室:KSDM值
公用:NULL值<br>
 * @author 老花生
 */
@Service
public class OpZt01Ser extends BaseManagerImp<OpZt01,Integer> {

    static final Logger logger = LoggerFactory.getLogger(OpZt01Ser.class);

    @Autowired
    private OpZt01Dao opZt01Dao;

    @Autowired
    private OpZt02Ser opZt02Ser;

    @Autowired
    private RedisFactory redisFactory;

    @Override
    public OpZt01Dao getEntityMapper(){
        return opZt01Dao;
    }

    /**
     * 停用
     * @param ztbh  组套编号
     */
    public void stop(Integer ztbh) {
        OpZt01 opZt01 = new OpZt01();
        opZt01.setZtbh(ztbh);
        opZt01.setSfqy(Integer.parseInt(StopFlagEnum.code_0.getCode()));
        opZt01Dao.updateFlag(opZt01);
    }

    /**
     * 启用
     * @param ztbh  组套编号
     */
    public void enable(Integer ztbh) {
        OpZt01 opZt01 = new OpZt01();
        opZt01.setZtbh(ztbh);
        opZt01.setSfqy(Integer.parseInt(StopFlagEnum.code_1.getCode()));
        opZt01Dao.updateFlag(opZt01);
    }

    /**
     * 新增
     * @param req   请求对象
     */
    public Integer add(OpZt01AddReq req, SysUser user) {
        //校验组套名称不能重复
        checkZtNotSame(req);

        OpZt01 obj = BeanUtil.toBean(req, OpZt01.class);
//        obj.setZtbh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_ZT01));
        obj.setPydm(PinyinUtils.getSimplePinYin(obj.getZtmc()));
        obj.setJgid(user.getHospitalId());
        if(StringUtils.isBlank(req.getKsdm())){
            obj.setYgdm(user.getUserId());
        }
        obj.setJzlsh(req.getJzlsh());
        opZt01Dao.insert(obj);
        return obj.getZtbh();
    }

    /**
     * 医生工作站新增组套（同时新增op_zt01和op_zt02）
     * @param req
     * @param user
     */
    @Transactional(rollbackFor = Exception.class)
    public void addzt(OpZtAddReq req, SysUser user){
        OpZt01AddReq zt01AddReq = BeanUtil.toBean(req, OpZt01AddReq.class);
        zt01AddReq.setSfqy(Integer.parseInt(StopFlagEnum.code_1.getCode()));

        //新增zt01
        Integer zt01Id = add(zt01AddReq, user);

        if (CollUtil.isNotEmpty(req.getOpZt02AddReq())){
            req.getOpZt02AddReq().stream().forEach(o ->{
                o.setZtbh(zt01Id);
                o.setJzlsh(req.getJzlsh());
            });
        }else {
            throw BaseException.create("ERROR_DCTWORK_OP_0086");
        }
        //新增zt02
        opZt02Ser.add(req.getOpZt02AddReq());
    }

    /**
     * 校验组套名称是否重复
     * @param zt01AddReq
     */
    private void checkZtNotSame(OpZt01AddReq zt01AddReq){
        int isExit = opZt01Dao.checkZtmcIsExit(zt01AddReq.getSslb(), zt01AddReq.getZtlb(), zt01AddReq.getZtmc());
        if (isExit > 0){
            throw BaseException.create("ERROR_DCTWORK_OP_0078");
        }
    }

    /**
     * 编辑
     * @param req   请求对象
     */
    public void edit(OpZt01EditReq req) {
        OpZt01 obj = opZt01Dao.getById(req.getZtbh());
        obj.setZtmc(req.getZtmc());
        obj.setPydm(PinyinUtils.getSimplePinYin(req.getZtmc()));
        opZt01Dao.update(obj);
    }

    /**
     * 查询组套信息
     * @param req
     * @param user
     * @return
     */
    public PageInfo<OpZt01Resp> query(OpZt01Req req, SysUser user) {
        OpZt01 zt01 = new OpZt01();
        zt01.setSslb(req.getSslb());
        zt01.setZtlb(req.getZtlb());
        if(req.getSfqy() != null && req.getSfqy().intValue() == 1){
            zt01.setSfqy(1);
        }
        zt01.setJgid(user.getHospitalId());
        if(req.getSslb().intValue() == 1 || req.getSslb().intValue() ==4){
            zt01.setYgdm(user.getUserId());
        }else if(req.getSslb().intValue() == 2 || req.getSslb().intValue() ==5){
            zt01.setKsdm(req.getKsdm());
        }else if(req.getSslb().intValue() == 3 || req.getSslb().intValue() ==6){
            zt01.setKsdm("0");
        }
        if(req.getZtlx() != null){
            zt01.setZtlx(req.getZtlx());
        }
        zt01.setPydm(req.getPydm());
        zt01.setSortColumns("PLSX is null,PLSX");

        PageInfo<OpZt01> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> opZt01Dao.findByEntity(zt01)
        );
        PageInfo<OpZt01Resp> ret = BeanUtil.toPage(pageInfo, OpZt01Resp.class);
        for(OpZt01Resp resp :ret.getList()){
            resp.setZtlxMc(req.getZtlxMc());
        }
        return ret;
    }
}
