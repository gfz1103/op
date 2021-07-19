package com.buit.ecis.pretriage.service;


import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.ecis.pretriage.dao.ErPreYjfzDao;
import com.buit.ecis.pretriage.model.ErPreYjfz;
import com.buit.ecis.pretriage.request.ErPreYjfzAddReq;
import com.buit.ecis.pretriage.request.ErPreYjfzQueryReq;
import com.buit.ecis.pretriage.response.ErPreYjfzResp;
import com.buit.utill.BeanUtil;
import com.buit.utill.DateUtil;
import com.buit.utill.RedisFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 急诊预检分诊<br>
 * @author 朱智
 */
@Service
public class ErPreYjfzSer extends BaseManagerImp<ErPreYjfz,Integer> {

    static final Logger logger = LoggerFactory.getLogger(ErPreYjfzSer.class);

    @Autowired
    private ErPreYjfzDao erPreYjfzDao;
    @Autowired
    private RedisFactory redisFactory;

    @Override
    public ErPreYjfzDao getEntityMapper(){
        return erPreYjfzDao;
    }

    /**
     * @name: add
     * @description: 新增
     * @param erPreYjfz
     * @return: void
     * @date: 2020/9/15 16:07
     * @auther: 朱智
     *
     */
    public void add(ErPreYjfzAddReq erPreYjfz) {
        Integer id = redisFactory.getTableKey(TableName.DB_NAME, TableName.ER_PRE_YJFZ);
        erPreYjfz.setLsh(id);
        erPreYjfz.setLzsj(DateUtil.getCurrentTimestamp());
        if(erPreYjfz.getLksj() == null){
            erPreYjfz.setZt("1");
        }else {
            erPreYjfz.setZt("2");
        }
        erPreYjfz.setDrzt("0");//调入状态 0未调入 1 已调入
        //erPreYjfz.setZs(erPreYjfz.getZsList().toString());
        erPreYjfzDao.insert(erPreYjfz);
    }

    /**
     * @name: queryPage
     * @description: 分页查询
     * @param req
     * @return: com.github.pagehelper.PageInfo<com.buit.ecis.pretriage.response.ErPreYjfzResp>
     * @date: 2020/9/15 16:55
     * @auther: 朱智
     *
     */
    public PageInfo<ErPreYjfzResp> queryPage(ErPreYjfzQueryReq req) {
        if(req.getLzsjStart() != null){
            req.setLzsjStartTime(cn.hutool.core.date.DateUtil.beginOfDay(req.getLzsjStart()).toTimestamp());
        }
        if(req.getLzsjEnd() != null){
            req.setLzsjEndTime(cn.hutool.core.date.DateUtil.endOfDay(req.getLzsjEnd()).toTimestamp());
        }
        PageInfo<ErPreYjfz> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> erPreYjfzDao.findByEntity(req)
        );

        return BeanUtil.toPage(pageInfo, ErPreYjfzResp.class);
    }
}
