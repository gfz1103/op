package com.buit.cis.op.dctwork.service;


import com.buit.apply.model.OpZt02;
import com.buit.apply.response.OpZt02CdResp;
import com.buit.apply.response.OpZt02Resp;
import com.buit.apply.service.OpZt02Service;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.EntityDao;
import com.buit.commons.request.OpZt02AddReq;
import com.buit.drug.response.OpZt02YpjbxxResp;
import com.buit.drug.service.DrugService;
import com.buit.system.response.SysXtcsResp;
import com.buit.system.service.SysXtcsSer;
import com.buit.system.utill.ObjectToTypes;
import com.buit.utill.BeanUtil;
import com.buit.utill.RedisFactory;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 门诊_门诊医生组套明细<br>
 * @author 老花生
 */
@Service
public class OpZt02Ser extends BaseManagerImp<OpZt02,Integer> {
    static final Logger logger = LoggerFactory.getLogger(OpZt02Ser.class);

    @Autowired
    private RedisFactory redisFactory;
    @DubboReference
    private DrugService drugService;
    @DubboReference
    private OpZt02Service opZt02Service;
    @DubboReference
    private SysXtcsSer sysXtcsSer;


    /**
     * 按组套编号-返回列表(西药、成药、草要))
     * @param ztbh
     * @return
     */
    public List<OpZt02Resp> qeury(Integer ztbh, Integer ztlb, Integer jgid, String ksid) {
        OpZt02 query = new OpZt02();
        query.setZtbh(ztbh);
        List<OpZt02Resp> resp = opZt02Service.findByZtbh(ztbh);
        if(resp.isEmpty()){
            return resp;
        }
        SysXtcsResp sysXtcsResp = sysXtcsSer.load(ksid, jgid ,null);

        String yfbs = null;
        switch (ztlb){
            case 1:
                yfbs = sysXtcsResp.getXy();
                break;
            case 2:
                yfbs = sysXtcsResp.getZy();
                break;
            case 3:
                yfbs = sysXtcsResp.getCy();
                break;
            default:
                throw BaseException.create("ERROR_DCTWORK_OP_0064");
        }
        List<Integer> var1 = resp.stream().map(OpZt02Resp::getYpxh).collect(Collectors.toList());
        List<OpZt02YpjbxxResp> retCd = drugService.getLsjgCdmcYfdwYfgg(ObjectToTypes.parseInt(yfbs), var1);
        for(OpZt02Resp obj : resp){
            for(OpZt02YpjbxxResp cd : retCd){
                if(obj.getYpxh().intValue() == cd.getYpxh().intValue()){
                    obj.getCdList().add(BeanUtil.toBean(cd, OpZt02CdResp.class));
                }
            }
        }
        return resp;
    }

    /**
     * 按组套编号-返回列表(项目)
     * @param ztbh
     * @return
     */
    public List<OpZt02Resp> qeuryXm(Integer ztbh) {
        OpZt02 query = new OpZt02();
        query.setZtbh(ztbh);

        return opZt02Service.findByZtbhXm(ztbh);
    }

    /**
     * 新增组套明细
     * @param req
     */
    public void add(List<OpZt02AddReq> req) {
        if(req != null && !req.isEmpty()){
            Integer ztbh = req.get(0).getZtbh();
            opZt02Service.deleteByZtbh(ztbh);
        }
        for(OpZt02AddReq obj : req){
//            obj.setJlbh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_ZT02));
            if(obj.getXmsl() != null && obj.getXmsl().intValue() > 1){//项目组套
                obj.setYpsl(obj.getXmsl());
            }
            opZt02Service.insert(obj);
        }
    }

    @Override
    public EntityDao<OpZt02, Integer> getEntityMapper() {
        return null;
    }

    public void deleteById(Integer jlbh) {
        opZt02Service.deleteById(jlbh);
    }
}
