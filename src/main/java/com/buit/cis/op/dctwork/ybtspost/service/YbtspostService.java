package com.buit.cis.op.dctwork.ybtspost.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.buit.cis.op.dctwork.service.SysMacSer;
import com.buit.cis.op.dctwork.ybtspost.consts.YbConsts;
import com.buit.cis.op.dctwork.ybtspost.dao.YbtspostDao;
import com.buit.cis.op.dctwork.ybtspost.model.*;
import com.buit.cis.op.dctwork.ybtspost.request.*;
import com.buit.cis.op.dctwork.ybtspost.xml.YbXmlUtil;
import com.buit.commons.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author weijing
 * @Date 2021-04-08 10:11
 * @Description
 **/
@Service
public class YbtspostService {
    static final Logger logger = LoggerFactory.getLogger(YbtspostService.class);

    @Autowired
    private YbtspostDao ybtspostDao;
    @Autowired
    private AsyncService asyncService;
    @Autowired
    private SysMacSer sysMacSer;


    /**
     * 4.1门诊就诊
     * @param jzlsh
     * @param jgid
     * @param ip
     */
    public void mzjz(String jzlsh,Integer jgid,String ip){
        String mac = judgeIpAndMac(ip,jgid);//校验ip和mac
        //通过就诊流水号查询患者接诊数据
        PatientJzsj patientJzsj = getPatientJzsj(jzlsh, jgid);

        MzjzMain main = BeanUtil.toBean(patientJzsj, MzjzMain.class);
        main.setCFDDM(YbConsts.Cfddm.CFDDM_1.getCode());
        main.setAGENTIP(ip);
        main.setAGENTMAC(mac);

        String xml = YbXmlUtil.toXml(main, "YL_ACTIVE_ROOT");

        logger.info("4.1门诊就诊：{}",xml);
        String url="http://"+ip+":9500"+YbConsts.UrlEnum.url.getCode();
        logger.info("医保前置机服务地址:{}",url);
        Map<String , String> map = new HashMap<>();
        map.put("req",xml);
        asyncService.doPost(url,map);
    }

    /**
     * 4.2门诊诊断
     * @param jzlsh
     * @param jgid
     * @param ip
     */
    public void mzzd(String jzlsh,Integer jgid,String ip){
        String mac = judgeIpAndMac(ip,jgid);//校验ip和mac
        //通过就诊流水号查询患者接诊数据
        PatientJzsj patientJzsj = getPatientJzsj(jzlsh, jgid);

        MzzdMain main = BeanUtil.toBean(patientJzsj, MzzdMain.class);
        main.setCFDDM(YbConsts.Cfddm.CFDDM_2.getCode());
        main.setAGENTIP(ip);
        main.setAGENTMAC(mac);

        //查询门诊诊断
        List<Item<ZdItem>> mzzd = getMzzd(jzlsh, jgid);
        main.setZD(mzzd);

        String xml = YbXmlUtil.toXml(main, "YL_ACTIVE_ROOT");
        logger.info("4.2门诊诊断：{}",xml);
        String url="http://"+ip+":9500"+YbConsts.UrlEnum.url.getCode();
        logger.info("医保前置机服务地址:{}",url);
        Map<String , String> map = new HashMap<>();
        map.put("req",xml);
        asyncService.doPost(url,map);
    }

    /**
     * 4.3录入处方
     * @param request
     * @param jgid
     */
    public void lrcf(CfRequest request,Integer jgid,String ip){
        String mac = judgeIpAndMac(ip,jgid);//校验ip和mac
        //通过就诊流水号查询患者接诊数据
        PatientJzsj patientJzsj = getPatientJzsj(request.getJzlsh(), jgid);

        LrcfMain main = BeanUtil.toBean(patientJzsj, LrcfMain.class);
        main.setCFDDM(YbConsts.Cfddm.CFDDM_3.getCode());
        main.setAGENTIP(ip);
        main.setAGENTMAC(mac);

        //查询门诊诊断
        List<Item<ZdItem>> mzzd = getMzzd(request.getJzlsh(), jgid);
        main.setZD(mzzd);

        //查询药品
        List<Item<YpItem>> yp = getChooseYp(request, jgid);
        main.setYP(yp);

        //查询费用项目
        List<Item<FwxmItem>> fwxm = getFwxm(request.getJzlsh(),jgid);
        main.setFWXM(fwxm);

        //查询材料
        List<Item<YyclItem>> yycl = getYycl(request.getJzlsh(), jgid);
        main.setYYCL(yycl);

        String xml = YbXmlUtil.toXml(main, "YL_ACTIVE_ROOT");
        logger.info("4.3录入处方：{}",xml);
        String url="http://"+ip+":9500"+YbConsts.UrlEnum.url.getCode();
        logger.info("医保前置机服务地址:{}",url);
        Map<String , String> map = new HashMap<>();
        map.put("req",xml);
        asyncService.doPost(url,map);
    }

    /**
     * 保存处方
     * @param jzlsh
     * @param jgid
     * @param ip
     */
    public void bccf(String jzlsh,Integer cfsb,Integer jgid,String ip){
        String mac = judgeIpAndMac(ip, jgid);//校验ip和mac
        //通过就诊流水号查询患者接诊数据
        PatientJzsj patientJzsj = getPatientJzsj(jzlsh, jgid);

        BccfMain main = BeanUtil.toBean(patientJzsj, BccfMain.class);
        main.setCFDDM(YbConsts.Cfddm.CFDDM_4.getCode());
        main.setAGENTIP(ip);
        main.setAGENTMAC(mac);

        //查询门诊诊断
        List<Item<ZdItem>> mzzd = getMzzd(jzlsh, jgid);
        main.setZD(mzzd);

        //查询药品
        List<Item<YpItem>> yp = getYp(cfsb, jgid);
        main.setYP(yp);

        //查询费用项目
        List<Item<FwxmItem>> fwxm = getFwxm(jzlsh, jgid);
        main.setFWXM(fwxm);

        //查询材料
        List<Item<YyclItem>> yycl = getYycl(jzlsh, jgid);
        main.setYYCL(yycl);

        String xml = YbXmlUtil.toXml(main, "YL_ACTIVE_ROOT");
        logger.info("4.4保存处方：{}",xml);
        String url="http://"+ip+":9500"+YbConsts.UrlEnum.url.getCode();
        logger.info("医保前置机服务地址:{}",url);
        Map<String , String> map = new HashMap<>();
        map.put("req",xml);
        asyncService.doPost(url,map);
    }

    /**
     * 通过就诊流水号查询患者接诊数据
     * @param jzlsh
     * @param jgid
     */
    private PatientJzsj getPatientJzsj(String jzlsh,Integer jgid){
        PatientJzsj patientJzsj = ybtspostDao.getPatientJzsj(jzlsh, jgid);
        if (patientJzsj == null){
            throw BaseException.create("ERROR_YBTS_POST_0001");
        }
        return patientJzsj;
    }

    /**
     * 查询诊断数据
     */
    private List<Item<ZdItem>> getMzzd(String jzlsh,Integer jgid){
        List<Mzzd> mzzd = ybtspostDao.getMzzd(jzlsh, jgid);
        if (CollUtil.isEmpty(mzzd)){
            throw BaseException.create("ERROR_YBTS_POST_0002");
        }

        List<Item<ZdItem>> collect = mzzd.stream().map(o -> {
            Item<ZdItem> item = new Item<>();
            item.setITEM(BeanUtil.toBean(o, ZdItem.class));
            return item;
        }).collect(Collectors.toList());
        return collect;
    }

    /**
     * 查询处方药品数据
     * @param cfsb
     * @param jgid
     * @return
     */
    private List<Item<YpItem>> getYp(Integer cfsb,Integer jgid){
        List<Drug> drug = ybtspostDao.getDrug(cfsb, jgid);
        if (CollUtil.isEmpty(drug)){
            return null;
        }

        List<Item<YpItem>> collect = drug.stream().map(o -> {
            Item<YpItem> item = new Item<>();
            item.setITEM(BeanUtil.toBean(o, YpItem.class));
            return item;
        }).collect(Collectors.toList());

        return collect;
    }

    /**
     * 查询录入药品信息
     * @param request
     * @param jgid
     */
    private List<Item<YpItem>> getChooseYp(CfRequest request,Integer jgid){
        //通过药品序号查询药品信息
        Drug drug = ybtspostDao.getDrugByYpxhAndYpcd(request.getYpxh(), request.getYpcd(), jgid);
        if (drug == null){
            logger.error("未查询到数据库中的药品信息 药品序号：{}",request.getYpxh());
            return null;
        }

        drug.setYPMC(request.getYpmc());
        drug.setYPGG(request.getYpgg());
        drug.setDCYPSL(request.getDcypsl());
        drug.setDCYPDW(request.getDcypdw());
        drug.setYYTJDM(request.getYytjdm());
        drug.setYYTJ(request.getYytj());
        drug.setYYPCDM(request.getYypcdm());
        drug.setYYPC(request.getYypc());
        drug.setFYSL(request.getFysl());
        drug.setFYSLDW(request.getFysldw());
        drug.setYYTS(request.getYyts());
        drug.setYPDJ(request.getYpdj());

        List<Item<YpItem>> items = new ArrayList<>();
        Item<YpItem> item = new Item<>();
        item.setITEM(BeanUtil.toBean(drug, YpItem.class));
        items.add(item);
        return items;
    }

    /**
     * 查询服务项目
     * @param jzlsh
     * @param jgid
     * @return
     */
    private List<Item<FwxmItem>> getFwxm(String jzlsh,Integer jgid){
        List<Fwxm> fwxm = ybtspostDao.getFwxm(jzlsh, jgid,null);
        if (CollUtil.isEmpty(fwxm)){
            return null;
        }
        List<Item<FwxmItem>> fwxmItems = new ArrayList<>();

        Map<Integer, Object> ztMap = new HashMap<>();//避免重复
        for (Fwxm xm:fwxm){
            Item<FwxmItem> fwxmItem = new Item<>();

            if (xm.getZTBZ() != null && xm.getZTBZ() == 1){
                if (ztMap.containsKey(xm.getZTBH())){
                    continue;
                }

                Ztfwxm ztfwxm = ybtspostDao.getztFwxm(jzlsh, jgid, xm.getZTBH());
                if (ztfwxm == null){
                    throw BaseException.create("ERROR_YBTS_POST_0003");
                }

                FwxmItem item = new FwxmItem();
                item.setFWLB(ztfwxm.getFWLB());
                item.setBMLX(xm.getBMLX());
                item.setFYLB(xm.getFYLB());
                item.setYYXMDM(String.valueOf(ztfwxm.getYYXMDM()));//当项目为组套时，赋值为组套编号
                item.setYBXMDM(null);
                item.setXMSL(ztfwxm.getXMSL());//组套的数量
                item.setXMSLDW(xm.getXMSLDW());//组套对应的单位
                item.setJCBWBM(ztfwxm.getJCBWBM());
                item.setJCBW(ztfwxm.getJCBW());
                item.setZLBWBM(ztfwxm.getZLBWBM());
                item.setXMDJ(ztfwxm.getXMDJ());//组套单价
                //通过组套编号查询对应的组套项目
                List<Fwxm> fwxmList = ybtspostDao.getFwxm(jzlsh, jgid, xm.getZTBH());
                List<Item<XmmcItem>> itemArrayList = new ArrayList<>();
                if (CollUtil.isNotEmpty(fwxmList)){
                    fwxmList.stream().forEach(o ->{
                        Item<XmmcItem> xmmcItemItem = new Item<>();
                        XmmcItem xmmcItem = new XmmcItem();
                        xmmcItem.setZXFWDM(o.getYYXMDM());
                        xmmcItem.setJCBWZXDM(o.getJCBWBM());
                        xmmcItem.setJCBWZX(o.getJCBW());
                        xmmcItemItem.setITEM(xmmcItem);
                        itemArrayList.add(xmmcItemItem);
                    });
                }
                item.setXMMC(itemArrayList);

                fwxmItem.setITEM(item);

                ztMap.put(xm.getZTBH(),xm);
            }else {
                //不是组套的项目
                FwxmItem item = BeanUtil.toBean(xm, FwxmItem.class);
                fwxmItem.setITEM(item);
            }
            fwxmItems.add(fwxmItem);
        }
        return fwxmItems;
    }

    /**
     * 查询材料
     * @param jzlsh
     * @param jgid
     * @return
     */
    private List<Item<YyclItem>> getYycl(String jzlsh,Integer jgid){
        List<Yycl> yycl = ybtspostDao.getYycl(jzlsh, jgid);
        if (CollUtil.isEmpty(yycl)){
            return null;
        }

        List<Item<YyclItem>> collect1 = yycl.stream().map(o -> {
            Item<YyclItem> item = new Item<>();
            item.setITEM(BeanUtil.toBean(o, YyclItem.class));
            return item;
        }).collect(Collectors.toList());

        return collect1;
    }

    /**
     * 校验ip和mac
     * @param ip
     */
    private String judgeIpAndMac(String ip,Integer jgid){
        if (StrUtil.isBlank(ip)){
            logger.error("医保智能提醒失败:未获取到客户机ip地址");
            return null;
        }
        //通过ip获取mac
        String mac = sysMacSer.getMacMessage(ip, jgid);
        if (StrUtil.isBlank(mac)){
            logger.error("医保智能提醒失败:未获取到客户机mac地址");
            return null;
        }

        return mac;
    }
}
