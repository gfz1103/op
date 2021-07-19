package com.buit.commons.serviceImpl;

import cn.hutool.core.date.DateUtil;
import com.buit.commons.PageQuery;
import com.buit.commons.dao.OpCf01Dao;
import com.buit.commons.dao.OpCf02Dao;
import com.buit.op.dto.ICancelGrantDrugDto;
import com.buit.op.dto.ICfypDetailDto;
import com.buit.op.dto.IGrantDrugParamDto;
import com.buit.op.dto.IJmcfxxDto;
import com.buit.op.enums.IQueryConditionEnum;
import com.buit.op.request.*;
import com.buit.op.response.*;
import com.buit.op.service.OpCf01Service;
import com.buit.system.utill.ObjectToTypes;
import com.buit.utill.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/10/10 16:50
 */
@DubboService(timeout = 10000)
public class OpCf01ServiceImpl implements OpCf01Service {
    static final Logger logger = LoggerFactory.getLogger(OpCf01ServiceImpl.class);

    @Autowired
    private OpCf01Dao opCf01Dao;
    @Autowired
    private OpCf02Dao opCf02Dao;

    @Override
    public List<IQueryDispensingResp> doQueryDispensing(Integer yfsb, IQueryDispensingReq queryDispensingReq, List<IQueryConditionEnum> keys) {
        return opCf01Dao.doQueryDispensing(yfsb, queryDispensingReq, keys);
    }

    @Override
    public IQueryPrescribingInformationResp doQueryPrescribingInformation(Integer cfsb) {
        return opCf01Dao.doQueryPrescribingInformation(cfsb);
    }

    @Override
    public List<ICfypDetailDto> queryCfypDetailJoinOpCf02(Integer cfsb) {
        return opCf01Dao.queryCfypDetailJoinOpCf02(cfsb);
    }

    @Override
    public void updateFyxx(IOpCf01UpdateDto updateDto) {
        opCf01Dao.updateFyxx(updateDto);
    }

    @Override
    public ICancelDispensingCfDetailResp queryCancelDispensingCfDetailByCfsb(Integer cfsb) {
        return opCf01Dao.queryCancelDispensingCfDetailByCfsb(cfsb);
    }

    @Override
    public void updateFybzAndFyrqByCfsb(int fybz, Timestamp fyrq, Integer cfsb) {
        opCf01Dao.updateFybzAndFyrqByCfsb(fybz, fyrq, cfsb);
    }

    @Override
    public PageInfo<IPharmacyPdaResp> queryPdaByYfsbAndFyck(IPharmacyPdaReq req) {
        PageInfo<IPharmacyPdaResp> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> opCf01Dao.queryPdaByYfsbAndFyck(req)
        );
        return pageInfo;
    }

    @Override
    public PageInfo<ICancelDispensingResp> queryCancelList(ICancelDispensingReq req, List<IQueryConditionEnum> cond) {
        PageInfo<ICancelDispensingResp> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> opCf01Dao.queryCancelList(req, cond)
        );
        return pageInfo;
    }

    @Override
    public IGrantDrugParamDto queryPrintBrInfo(Integer cfsb, Integer jgid) {
        return opCf01Dao.queryPrintBrInfo(cfsb, jgid);
    }

    @Override
    public ICancelGrantDrugDto queryCancelGrantDrugPrintCfByCfsb(Integer cfsb) {
        return opCf01Dao.queryCancelGrantDrugPrintCfByCfsb(cfsb);
    }

    @Override
    public IJmcfxxDto queryJmcfxx(Integer cfsb) {
        return opCf01Dao.queryJmcfxx(cfsb);
    }

    @Override
    public List<Map<String, Object>> getJzxh(String cfsbs) {
        return opCf01Dao.getJzxh(cfsbs);
    }

    public ReturnEntity<List<OpCf01RespModel>> getCfList(OpCf01ReqModel req) {
        if (req.getKfrqBegin() != null) {
            req.setKfrqTimeBegin(DateUtil.beginOfDay(req.getKfrqBegin()).toTimestamp());
        }
        if (req.getKfrqEnd() != null) {
            req.setKfrqTimeEnd(DateUtil.endOfDay(req.getKfrqEnd()).toTimestamp());
        }
        List<OpCf01RespModel> cfList = opCf01Dao.apiGetList(req);
        for (OpCf01RespModel cf : cfList) {
            cf.setBrnl(MzUtil.getPersonAge(cf.getCsny(), null).get("age").toString());
        }
        return ReturnEntityUtil.success(cfList);
    }

    @Override
    public ReturnEntity<OpCf01RespModel> getCfByCfsb(Integer cfsb) {
        OpCf01ReqModel req = new OpCf01ReqModel();
        req.setCfsb(cfsb);
        List<OpCf01RespModel> cfList = opCf01Dao.apiGetList(req);
        if (cfList != null && !cfList.isEmpty()) {
            return ReturnEntityUtil.success(cfList.get(0));
        }
        return ReturnEntityUtil.success();
    }

    public ReturnEntity<List<IOpCf02Resp>> getCfDetails(Integer cfsb) {
        if (cfsb == null || cfsb.intValue() == 0) {
            return ReturnEntityUtil.error("I00001", "处方识别不能为空");
        }
        List<IOpCf02Resp> resp = opCf02Dao.getCfDetails(Collections.singletonList(cfsb));
        return ReturnEntityUtil.success(resp);
    }

    public ReturnEntity setShzt(Integer cfsb, String shzt, Integer userid, String userName) {
        if (cfsb == null || cfsb.intValue() == 0 || StringUtils.isBlank(shzt)) {
            return ReturnEntityUtil.error("I00002", "参数不能为空");
        }

        Map<String, Object> param = ParamUtil.instance()
                .put("cfsb", cfsb)
                .put("shzt", shzt)
                .put("shsj", LocalDateTime.now())
                .put("shys", userid)
                .put("shysxm", userName);

        try {
            opCf01Dao.updateShztByCfsb(param);
        } catch (Exception e) {
            logger.info("=====处方接口=====保存审核状态错误：" + e.getMessage());
            return ReturnEntityUtil.error("I00003", "更新失败");
        }
        return ReturnEntityUtil.success();
    }

    @Override
    public ReturnEntity<List<OpCf01RespModel>> extractCf(ExtractCfReq req) {
        ReturnEntity<List<OpCf01RespModel>> resp = new ReturnEntity<>();

        if (req.getKsrq() != null) {
            req.setKfrqTimeBegin(DateUtil.beginOfDay(req.getKsrq()).toTimestamp());
        }
        if (req.getJsrq() != null) {
            req.setKfrqTimeEnd(DateUtil.endOfDay(req.getJsrq()).toTimestamp());
        }
        List<OpCf01RespModel> cfList = null;

        //只有时间范围和数量的抽取
        if (req.getKescqbl() == null && req.getMkzscqs() == null
                && req.getYsscqbl() == null && req.getMyzscqs() == null) {
            req.setRand("rand()");
            cfList = opCf01Dao.extractCfByCount(req);
        } else if (req.getKescqbl() != null || req.getMkzscqs() != null) {//科室抽取比例（%）或者 每科室至少抽取数
            if (req.getKsfw() == null) {
                return ReturnEntityUtil.error("e0001", "科室范围不能为空！");
            }

            //int sum = 0;//抽取数
            List<Map<String, Object>> removeList = new ArrayList<>();//空记录删除
            //根据时间范围、科室范围查询每个科室符合的数量
            List<Map<String, Object>> ksNumList = opCf01Dao.getNumByDateKsfw(req);
            for (Map<String, Object> ksNum : ksNumList) {
                int num = ObjectToTypes.parseInt(ksNum.get("num"));
                if (req.getKescqbl() != null) {
                    num = num * req.getKescqbl() / 100;
                } else {
                    num = num < req.getMkzscqs() ? num : req.getMkzscqs();
                }

                //sum = sum + num;
                ksNum.put("kfrqTimeBegin", req.getKfrqTimeBegin());
                ksNum.put("kfrqTimeEnd", req.getKfrqTimeEnd());
                ksNum.put("tname", "t" + ksNum.get("ksdm"));
                ksNum.put("num", num);
                ksNum.put("ghlx", req.getGhlx());
                if (num == 0) {
                    removeList.add(ksNum);
                }
            }

            //删除空记录
            for (Map<String, Object> remove : removeList) {
                ksNumList.remove(remove);
            }

            //根据科室数量抽取
            cfList = opCf01Dao.extractCfByKsNum(ksNumList);

            if (req.getCysl() > cfList.size()) {//如果已抽取数量下雨要抽取数量，则需要抽取其他数据
                ExtractCfReq que = new ExtractCfReq();
                que.setKfrqTimeBegin(req.getKfrqTimeBegin());
                que.setKfrqTimeEnd(req.getKfrqTimeEnd());
                que.setNoksfw(req.getKsfw());
                que.setCysl(req.getCysl() - cfList.size());
                que.setRand("rand()");

                List<OpCf01RespModel> cfList2 = opCf01Dao.extractCfByCount(que);
                cfList.addAll(cfList2);
            } else if (req.getCysl() < cfList.size()) {
                Collections.shuffle(cfList);
                cfList = cfList.subList(0, req.getCysl());
            }
        } else if (req.getYsscqbl() != null || req.getMyzscqs() != null) {//医生抽取比例（%） 或 每医生至少抽取数
            if (req.getYsfw() == null) {
                return ReturnEntityUtil.error("e0001", "医生范围不能为空！");
            }

            //int sum = 0;//抽取数
            List<Map<String, Object>> removeList = new ArrayList<>();//空记录删除
            //根据时间范围、医生范围查询每个医生符合的数量
            List<Map<String, Object>> ysNumList = opCf01Dao.getNumByDateYsfw(req);
            for (Map<String, Object> ysNum : ysNumList) {
                int num = ObjectToTypes.parseInt(ysNum.get("num"));
                if (req.getYsscqbl() != null) {
                    num = num * req.getYsscqbl() / 100;
                } else {
                    num = num < req.getMyzscqs() ? num : req.getMyzscqs();
                }

                //sum = sum + num;
                ysNum.put("kfrqTimeBegin", req.getKfrqTimeBegin());
                ysNum.put("kfrqTimeEnd", req.getKfrqTimeEnd());
                ysNum.put("tname", "t" + ysNum.get("ysdm"));
                ysNum.put("num", num);
                ysNum.put("ghlx", req.getGhlx());
                if (num == 0) {
                    removeList.add(ysNum);
                }
            }

            //删除空记录
            for (Map<String, Object> remove : removeList) {
                ysNumList.remove(remove);
            }

            //根据科室数量抽取
            cfList = opCf01Dao.extractCfByYsNum(ysNumList);

            if (req.getCysl() > cfList.size()) {//如果已抽取数量下雨要抽取数量，则需要抽取其他数据
                ExtractCfReq que = new ExtractCfReq();
                que.setKfrqTimeBegin(req.getKfrqTimeBegin());
                que.setKfrqTimeEnd(req.getKfrqTimeEnd());
                que.setNoysfw(req.getYsfw());
                que.setCysl(req.getCysl() - cfList.size());
                que.setRand("rand()");

                List<OpCf01RespModel> cfList2 = opCf01Dao.extractCfByCount(que);
                cfList.addAll(cfList2);
            } else if (req.getCysl() < cfList.size()) {
                Collections.shuffle(cfList);
                cfList = cfList.subList(0, req.getCysl());
            }
        }

        //根据cf列表提取出cfsb列表
        List<Integer> cfsbList = new ArrayList<>();
        cfList.forEach(cf -> {
            cfsbList.add(cf.getCfsb());
        });

        //查询处方明细
        List<IOpCf02Resp> cf02List = opCf02Dao.getCfDetails(cfsbList);

        //循环把处方明细插入处方中
        for (OpCf01RespModel cf : cfList) {
            for (IOpCf02Resp cf02 : cf02List) {
                if (cf.getCfsb().intValue() == cf02.getCfsb().intValue()) {
                    cf.getCf02List().add(cf02);
                }
            }
        }

        resp.setData(cfList);
        return resp;
    }

    @Override
    public void updateKjywxx(List<IUpdateKjywxxReq> list) {
        for (IUpdateKjywxxReq req : list) {
            opCf01Dao.updateKjywxx(req);
        }
    }

    @Override
    public PageInfo<OpCf01RespModel> queryCfbyJzlsh(String jzlsh, PageQuery page) {
        PageInfo<OpCf01RespModel> pageInfo = PageUtil.getPageInfo(page.getPageNum(), page.getPageSize(), opCf01Dao.queryCfbyJzlsh(jzlsh));
        return pageInfo;
    }
}
