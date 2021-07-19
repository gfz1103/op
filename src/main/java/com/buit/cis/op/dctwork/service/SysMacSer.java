package com.buit.cis.op.dctwork.service;


import cn.hutool.core.util.StrUtil;
import com.buit.cis.op.dctwork.request.SysMacReq;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.SysMacDao;
import com.buit.commons.model.SysMac;
import com.buit.constans.TableName;
import com.buit.utill.RedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * MAC信息表(用于mac地址维护)<br>
 * @author 韦靖
 */
@Service
public class SysMacSer extends BaseManagerImp<SysMac,Integer> {

    static final Logger logger = LoggerFactory.getLogger(SysMacSer.class);

    @Autowired
    private SysMacDao sysMacDao;

    @Autowired
    private RedisFactory redisFactory;

    @Override
    public SysMacDao getEntityMapper(){
        return sysMacDao;
    }

    /**
     * 新增mac地址
     * @param req
     */
    public void addMac(SysMacReq req){
        req.setMac(req.getMac().trim());
        req.setId(redisFactory.getTableKey(TableName.DB_NAME, TableName.SYS_MAC));
        sysMacDao.insert(req);
    }

    /**
     * 查询ip是否对应mac
     * @param ip
     * @param jgid
     */
    public Integer getMac(String ip,Integer jgid){
        String mac = sysMacDao.getMacByIp(ip, jgid);
        if (StrUtil.isNotBlank(mac)){
            return 1;
        }
        return 0;
    }

    /**
     * 查询mac
     * @param ip
     * @param jgid
     * @return
     */
    public String getMacMessage(String ip,Integer jgid){
        return sysMacDao.getMacByIp(ip, jgid);
    }
}
