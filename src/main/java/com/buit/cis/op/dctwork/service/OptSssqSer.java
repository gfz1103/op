package com.buit.cis.op.dctwork.service;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.commons.dao.OptSssqDao;
import com.buit.commons.model.OptSssq;
import com.buit.commons.request.OptSssqPageReq;
import com.buit.commons.request.OptSssqSaveReq;
import com.buit.commons.response.OptSssqPageResp;
import com.buit.constans.TableName;
import com.buit.op.request.OpYjcf01Req;
import com.buit.op.request.OpYjcf02Req;
import com.buit.utill.RedisFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 手术申请<br>
 *
 * @author 老花生
 */
@Service
public class OptSssqSer extends BaseManagerImp<OptSssq, Integer> {

    static final Logger logger = LoggerFactory.getLogger(OptSssqSer.class);

    @Autowired
    private OptSssqDao optSssqDao;
    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    private MzYjSer mzYjSer;
    @Autowired
    private OpYjcf01Ser opYjcf01Ser;
//    @Autowired
//    private ImHzryByDctworkSer imHzryByDctworkSer;
//    @Autowired
//    private CisHzyzDao cisHzyzDao;

    @Override
    public OptSssqDao getEntityMapper() {
        return optSssqDao;
    }

    /**
     * 保存手术申请记录
     *
     * @param req
     * @param user
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Object saveSssq(OptSssqSaveReq req, SysUser user) {
        Map<String, Object> res = new HashMap<>(16);

        Map<String, Object> body = BeanUtil.beanToMap(req.getBody());
        Map<String, Object> formInfo = BeanUtil.beanToMap(req.getFormInfo());
        Map<String, Object> formData = BeanUtil.beanToMap(formInfo.get("formData"));

        // 机构ID
        formData.put("jgid", user.getHospitalId());
        // 操作工号
        formData.put("czgh", user.getUserId());

        formData.put("sqdh", redisFactory.getTableKey(TableName.DB_NAME, TableName.OPT_SSSQ));
        formData.put("jzlsh", req.getJzlsh());
        if (!StrUtil.isEmptyIfStr(req.getZyh())) {
            formData.put("zyh", req.getZyh());
        }
        optSssqDao.insert(formData);
        res.put("sqdh", formData.get("sqdh"));

        // 门诊申请
        if ("1".equals(formInfo.get("sqlx").toString())) {

            body.put("brid", req.getBrid());
            body.put("brxm", req.getBrxm());
            body.put("djly", req.getDjly());
            body.put("ghgl", req.getGhgl());
            body.put("sssqid", formData.get("sqdh"));
            body.put("clinicId", req.getClinicId());

            OpYjcf01Req yj01 = BeanUtil.fillBeanWithMapIgnoreCase(body, new OpYjcf01Req(), true);
            List<OpYjcf02Req> yj02List = new ArrayList<>();
            OpYjcf02Req yj02 = BeanUtil.fillBeanWithMapIgnoreCase(body, new OpYjcf02Req(), true);
            yj02List.add(yj02);
            yj01.setBodys(yj02List);
            yj01.setJzlsh(req.getJzlsh());
            yj01.setLy(6);
            opYjcf01Ser.save(yj01, user);
        } else {
            throw BaseException.create("ERROR_DCTWORK_OP_0046");
        }

        return null;
    }

    /**
     * 查询手术申请单列表数据
     *
     * @param req
     * @return
     */
    public PageInfo<OptSssqPageResp> querySurSssqList(OptSssqPageReq req, SysUser user) {
        // 申请类型(1=门诊 2=住院3=查询住院全部4=查询门诊全部)
        String sqlx = req.getSqlx();
        req.setSqys(user.getUserId());
        PageInfo<OptSssqPageResp> pageInfo = new PageInfo<>();
        if ("1".equals(sqlx)) {
            pageInfo = PageHelper.startPage(
                    req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                    () -> optSssqDao.findByEntityMz(req)
            );
        } else if ("2".equals(sqlx)) {
            pageInfo = PageHelper.startPage(
                    req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                    () -> optSssqDao.findByEntityZy(req)
            );
        } else if ("3".equals(sqlx)) {
            pageInfo = PageHelper.startPage(
                    req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                    () -> optSssqDao.findByEntityAllZy(req)
            );
        } else if ("4".equals(sqlx)) {
            pageInfo = PageHelper.startPage(
                    req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                    () -> optSssqDao.findByEntityAllMz(req)
            );
        }

        return pageInfo;
    }
}
