package com.buit.cis.op.dctwork.job;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.buit.commons.dao.OpGhmxDao;
import com.buit.commons.dao.OpMzxxDao;
import com.buit.commons.dao.OpYsJzlsDao;
import com.buit.commons.model.OpMzxx;
import com.buit.op.model.OpGhmx;
import com.buit.op.model.OpYsJzls;
import com.buit.system.response.DicYljgOut;
import com.buit.system.service.DicYljgOutSer;
import com.buit.system.service.SysXtcsCacheSer;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author weijing
 * @Date 2021-03-03 15:43
 * @Description
 **/
@Component
public class EndJzJob {
    static final Logger log = LoggerFactory.getLogger(EndJzJob.class);

    @Autowired
    private OpYsJzlsDao opYsJzlsDao;

    @Autowired
    private OpMzxxDao opMzxxDao;

    @Autowired
    private OpGhmxDao opGhmxDao;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @DubboReference
    private DicYljgOutSer dicYljgOutSer;

    @DubboReference
    private SysXtcsCacheSer sysXtcsCacheSer;

//    @Autowired
//    private ParamConfig paramConfig;

    private String END_JZ = "lock:job:cf:EndJz";

    private String END_GH = "lock:job:gh:EndGh";
    /**
     * 将没有手动结束就诊的就诊结束(每天1点执行定时任务)
     * cron:秒 分 时 天 月 周 年
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void EndJz(){
        log.info("开始 => 将未手动结束的就诊自动结束");

        try {
            //加锁(防止重复执行)
            if (stringRedisTemplate.opsForValue().setIfAbsent(END_JZ, DateUtil.now(), 3600, TimeUnit.SECONDS)){
                //查询未结束的就诊记录
                List<OpYsJzls> opYsJzls = opYsJzlsDao.queryYsZljl(new Timestamp(System.currentTimeMillis()));
                if (CollUtil.isEmpty(opYsJzls)){
                    log.info("没有需要自动结束的就诊数据");
                    return;
                }

                //自动确认执行参数
                int totalData = 0;
                int successData = 0;
                int failData = 0;

                for (OpYsJzls jzls:opYsJzls){
                    totalData ++;
                    //定义结束时间为就诊开始日期增加30分钟
                    Date endDate = new Date(jzls.getKssj().getTime() + 30*60*1000);

                    //查询未结束的就诊记录的收费时间(通过就诊流水号)
                    List<OpMzxx> opMzxx = opMzxxDao.getOpMzxxByJzlsh(jzls.getJzlsh());
                    if (CollUtil.isNotEmpty(opMzxx)){
                        //取最近的收费日期
                        endDate = opMzxx.get(0).getSfrq();
                    }

                    try {
                        //更新结束就诊时间和结束状态
                        //更新op_ys_jzls表
                        OpYsJzls ysJzls = new OpYsJzls();
                        ysJzls.setJzxh(jzls.getJzxh());
                        ysJzls.setJssj(new Timestamp(endDate.getTime()));
                        ysJzls.setJzzt(9);
                        opYsJzlsDao.updatejssjAndZt(ysJzls);
                        //更新op_ghmx表状态
                        opGhmxDao.updateJzztBySbxh(jzls.getGhxh(),9);

                        successData++;
                    }catch (Exception e){
                        failData++;
                        log.error("更新状态失败：jzlsh:{} === 错误:{}",jzls.getJzlsh(),e.getMessage());
                    }
                }
                log.info("完成 => 将未手动结束的就诊自动结束,本次需要确认收货数据{}条,成功{}条，失败{}条",totalData,successData,failData);
            }
        }catch (Exception e){
            log.error("就诊自动结束失败",e);
        }finally {
            stringRedisTemplate.delete(END_JZ);//删除redis
        }
    }

    /**
     * 将大于等于N天未就诊的数据结束就诊
     */
    @Scheduled(cron = "0 20 1 * * ?")
    public void EndGh(){
        log.info("开始 => 将挂号未就诊的数据结束");

        try {
            //加锁(防止重复执行)
            if (stringRedisTemplate.opsForValue().setIfAbsent(END_GH, DateUtil.now(), 3600, TimeUnit.SECONDS)){

                //查询机构列表
                List<DicYljgOut> allYljg = dicYljgOutSer.getAllYljg();
                if (CollUtil.isEmpty(allYljg)){
                    log.info("将挂号未就诊的数据结束失败：未查询系统中有效的机构");
                    return;
                }

                for (DicYljgOut yljg:allYljg){
                    //查询机构的挂号有效期
                    String ghxq = sysXtcsCacheSer.getByJGIdAndCsmc(yljg.getHospitalId(), "GHXQ").getCsz();
                    if (StrUtil.isBlank(ghxq)){
                        log.info("系统参数未配置:挂号有效期,机构名称:{},机构ID:{}",yljg.getHospitalName(),yljg.getHospitalId());
                        break;
                    }

                    //查询未来就诊的挂号数据
                    List<OpGhmx> opGhmxes = opGhmxDao.getwjz(new Timestamp(System.currentTimeMillis()),ghxq);
                    if (CollUtil.isEmpty(opGhmxes)){
                        log.info("没有需要自动结束的挂号数据");
                        break;
                    }

                    //自动确认执行参数
                    int totalData = 0;
                    int successData = 0;
                    int failData = 0;

                    //处理数据
                    for (OpGhmx ghmx:opGhmxes){
                        totalData ++;
                        try {
                            //更新op_ghmx表状态
                            opGhmxDao.updateJzztBySbxh(ghmx.getSbxh(),9);
                            successData++;
                        }catch (Exception e){
                            failData++;
                            log.error("更新挂号表状态失败：sbxh:{} === 错误:{}",ghmx.getSbxh(),e.getMessage());
                        }
                    }

                    log.info("完成 => 将挂号未就诊的数据结束,机构号:{},本次需要确认收货数据{}条,成功{}条，失败{}条",yljg.getHospitalId(),totalData,successData,failData);
                }
            }
        }catch (Exception e){
            log.error("挂号未就诊的数据结束失败",e);
        }finally {
            stringRedisTemplate.delete(END_GH);//删除redis
        }
    }
}
