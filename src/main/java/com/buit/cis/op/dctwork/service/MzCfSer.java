package com.buit.cis.op.dctwork.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.StrUtil;
import com.buit.apply.response.OpZt02CdResp;
import com.buit.apply.service.OpZt02Service;
import com.buit.cis.op.dctwork.request.OpCfpsReq;
import com.buit.cis.op.dctwork.request.SaveKjywsqlyReq;
import com.buit.cis.op.dctwork.response.CfPrintResponse;
import com.buit.cis.op.dctwork.response.DrugDetailResponse;
import com.buit.cis.op.dctwork.response.FeeYlsfxmDetailResponse;
import com.buit.cis.op.dctwork.response.YpyfResponse;
import com.buit.cis.op.dctwork.ybtspost.service.YbtspostService;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.PageQuery;
import com.buit.commons.SysUser;
import com.buit.commons.dao.*;
import com.buit.commons.enums.StatusEnum;
import com.buit.commons.model.OpBrzd;
import com.buit.commons.model.OpCf01;
import com.buit.commons.model.OpCfdbr;
import com.buit.commons.request.*;
import com.buit.commons.response.*;
import com.buit.constans.TableName;
import com.buit.drug.request.*;
import com.buit.drug.response.DrugsTypkDetailResp;
import com.buit.drug.response.PharBaseInfoResp;
import com.buit.drug.response.QueryCfypxxResp;
import com.buit.drug.service.DrugService;
import com.buit.drug.service.DrugsTypkOutSer;
import com.buit.drug.service.PharBaseConfigService;
import com.buit.file.IReportExportFileSer;
import com.buit.his.op.reg.service.OpGhksSer;
import com.buit.mms.antimi.model.AmqcKjywsycs;
import com.buit.mms.antimi.response.OpCfKjywsqjlResp;
import com.buit.mms.antimi.service.AmqcKjywsycsService;
import com.buit.mms.antimi.service.OpCfKjywsqjlService;
import com.buit.op.model.OpYjcf01;
import com.buit.op.model.OpYjcf02;
import com.buit.op.model.mphis.response.MphisCfxqmxResponse;
import com.buit.op.model.mphis.response.MphisYspInfoResponse;
import com.buit.op.response.OpCf02;
import com.buit.op.service.OpYjcf02Service;
import com.buit.system.response.DicYljgOut;
import com.buit.system.response.HrPersonnelModel;
import com.buit.system.response.SysXtcs;
import com.buit.system.service.*;
import com.buit.system.utill.ObjectToTypes;
import com.buit.utill.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


/**
 * ??????_???????????????<br>
 * @author ?????????
 */
@SuppressWarnings("ALL")
@Service
public class MzCfSer extends BaseManagerImp<OpCf01,Integer> {

    static final Logger logger = LoggerFactory.getLogger(MzCfSer.class);

    @Autowired
    private OpCf01Dao opCf01Dao;
    @Autowired
    private OpCf02Dao opCf02Dao;
    @Autowired
    private OpYjcf02Dao opYjcf02Dao;
    @Autowired
    private OpYjcf01Dao opYjcf01Dao;
//    @Autowired
//    private PharYflbDao pharYflbDao;
    @Autowired
    private RedisFactory redisFactory;
//    @Autowired
//    private YsMzPsjlDao ysMzPsjlDao;
    @DubboReference
	private SysXtcsCacheSer sysXtcsCacheSer;
//    @Autowired
//    private MedicineCommonService medicineCommonService;
    @Autowired
    private OpGhksSer opGhksSer;
    @DubboReference
    private HrPersonnelService hrPersonnelSer;
    @DubboReference
    private DicYljgOutSer dicYljgOutSer;
//    @Autowired
//    private DrugsTypkDao drugsTypkDao;
    @Autowired
    private MzUtil mzUtil;
//    @Autowired
//    private DrugsKcmxDao drugsKcmxDao;
//
    @DubboReference
    private DrugService drugService;
    @DubboReference
    private DrugsTypkOutSer drugsTypkOutSer;
//    @Autowired
//    private DrugsCdybxxDao drugsCdybxxDao;
//    @Autowired
//    private PharYpxxDao pharypxxdao;
    @DubboReference
    private OpZt02Service opZt02Service;
//    @Autowired
//    private ExportFileSer exportFileSer;
//    @Autowired
//    private ImTbkkSer imTbkkSer;
    @Autowired
    private OpBrzdDao opBrzdDao;
    @DubboReference
    PharBaseConfigService pharBaseConfigService;
    @DubboReference
    private ExportFileSer exportFileSer;
    @Autowired
    private OpCfpsDao opCfpsDao;
    @DubboReference
    private AmqcKjywsycsService amqcKjywsycsService;
    @DubboReference
    private OpCfKjywsqjlService opCfKjywsqjlService;
    @Autowired
    private OpGhmxDao opGhmxDao;
    @Autowired
    private IReportExportFileSer iReportExportFileSer;
    @Autowired
    private FeeYlsfxmDao feeYlsfxmDao;
    @DubboReference
    private OpYjcf02Service opYjcf02Service;
    @Autowired
    private OpCfdbrDao opCfdbrDao;
    @DubboReference
    private DicGbsj02Service dicGbsj02Service;
    @Autowired
    private YbtspostService ybtspostService;
    @Autowired
    private OpYjcf02Ser opYjcf02Ser;

    @Override
    public OpCf01Dao getEntityMapper(){
        return opCf01Dao;
    }

    /**
     * ??????????????????
     * @param cfsb  ???????????????
     * @return
     */
    public List<PatientPrescriptionDetailsResp> queryPrescriptionDetails(Integer cfsb){
        List<Integer> cfsbs = new ArrayList<>();
        cfsbs.add(cfsb);
        return opCf01Dao.queryPrescriptionDetails(cfsbs);
    }

    /**
     * ??????????????????
     * @param opcf01
     */
    public List<OpCf01Resp> queryCfList(OpCf01Req opcf01){
        List<OpCf01> cfList = opCf01Dao.findByEntity(opcf01);
        if (CollUtil.isNotEmpty(cfList)){
            List<OpCf01Resp> collect = cfList.stream().map(o -> {
                OpCf01Resp resp = BeanUtil.toBean(o, OpCf01Resp.class);
                OpCfdbr opCfdbr = opCfdbrDao.queryByCfsb(o.getCfsb());
                if (opCfdbr != null) {
                    resp.setDbrxm(opCfdbr.getDbrxm());
                    resp.setDbrlxdh(opCfdbr.getDbrlxdh());
                    resp.setSfzm(opCfdbr.getSfzm());
                    resp.setBh(opCfdbr.getBh());
                }
                return resp;
            }).collect(Collectors.toList());
            return collect;
        }
        return new ArrayList<>();
    }

    /**
     * ????????????
     * @param req   ????????????
     */
    @Transactional(rollbackFor=Exception.class)
    public Integer save(MsCfSaveReq req, SysUser user) {
        //-2.??????????????????????????????
        checkCfIsFee(req.getOldCfsb());

        //-1.??????????????????
        checkKjyw(req, user);

        //0.????????????????????????cf01???cf02????????????????????????????????????
        if(req.getCf02List() == null || req.getCf02List().size() == 0){
            if(req.getOldCfsb() != null){//???cfsb?????????
                opCf01Dao.deleteById(req.getOldCfsb());//??????cf01
                opCf02Dao.deleteByCfsb(req.getOldCfsb());//??????cf02
                deleteCfps(req.getOldCfsb());//??????????????????
                deleteDjf(req.getOldCfsb());//????????????????????????
                opCfdbrDao.deleteByCfsb(req.getOldCfsb());//?????????????????????
                deleteFreezeYp(req.getOldCfsb(),user.getHospitalId());
                //drugService.frozenYpkc(req.getOldCfsb(), null);//????????????????????????????????????????????????????????????????????????
                return req.getOldCfsb();
            }else{//???cfsb?????????????????????????????????????????????id
                return redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CF01);
            }
        }else{
            if (req.getOldCfsb() != null){
                opCf01Dao.deleteById(req.getOldCfsb());//??????cf01
                opCf02Dao.deleteByCfsb(req.getOldCfsb());//??????cf02
                opCfdbrDao.deleteByCfsb(req.getOldCfsb());//?????????????????????
                deleteFreezeYp(req.getOldCfsb(),user.getHospitalId());//????????????
            }
        }

        //1.????????????
        checkYpkc(req, user.getHospitalId());

        //2.???????????????cf01
        OpCf01 cf01 = saveCf01(req, user);

        //3.???????????????cf02
        List<OpCf02> retCf02List = saveCf02(req, cf01, user);

        //4.??????????????????
        freezeYp(req, cf01.getCfsb(), user.getHospitalId(), retCf02List);

        //5.??????????????????bjhzs
        saveCfps(req, user, cf01);

        //6.??????????????? ????????????????????????
        saveDjf(req,user,cf01);

        //7.??????????????????
        ThreadUtil.execAsync(()->{
            logger.info("????????????????????????????????????????????????");
            try {
                ybtspostService.bccf(req.getJzlsh(),cf01.getCfsb(),user.getHospitalId(),req.getIp());
            }catch (Exception e){
                logger.error("????????????????????????????????????????????????:",e);
            }
            logger.info("????????????????????????????????????????????????");
        });
        return cf01.getCfsb();
    }

    /**
     * ???????????????
     * @param req
     * @param user
     * @param cf01
     */
    private void saveDjf(MsCfSaveReq req,SysUser user,OpCf01 cf01){
        //????????????????????????
        deleteDjf(req.getOldCfsb());

        if (req.getDjybz() != null && req.getDjybz() == 1 && req.getCflx().equals(StatusEnum.OpCflx.CY.getCode())){
            //1.???????????????
            String mzdjf = sysXtcsCacheSer.getByJGIdAndCsmc(user.getHospitalId(), StatusEnum.Xtcs.MZJYF.getCode()).getCsz();//?????????
            if (StrUtil.isBlank(mzdjf)){
                throw BaseException.create("ERROR_DCTWORK_OP_0073");
            }
            //2.??????????????????
            FeeYlsfxmDetailResponse djfxm = feeYlsfxmDao.getYlsfxmByFyxh(user.getHospitalId(), Integer.valueOf(mzdjf));
            if (djfxm == null){
                throw BaseException.create("ERROR_DCTWORK_OP_0074");
            }
            //3.??????yjcf01
            Integer maxYjzh = opYjcf02Service.getMaxYjzh(req.getJzlsh(), user.getHospitalId());//???????????????????????????
            OpYjcf01 yj01Save = new OpYjcf01();
            yj01Save.setYjxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJCF01));
            yj01Save.setJgid(user.getHospitalId());
            yj01Save.setBrid(cf01.getBrid());
            yj01Save.setBrxm(cf01.getBrxm());
            yj01Save.setKdrq(DateUtil.getCurrentTimestamp());
            yj01Save.setKsdm(cf01.getKsdm());
            yj01Save.setYsdm(String.valueOf(user.getUserId()));
            yj01Save.setZxks(djfxm.getZxks());
            yj01Save.setZxpb(0);
            yj01Save.setZfpb(0);
            yj01Save.setCfbz(0);
            yj01Save.setJzxh(req.getJzxh());
            yj01Save.setXmlx(StatusEnum.Xmlx.CY.getCode());//????????????(?????????)
            yj01Save.setDjly(StatusEnum.Djly.YSKD.getCode());//????????????
            yj01Save.setJzlsh(req.getJzlsh());
            yj01Save.setFjlb(StatusEnum.Fjlb.CFDJF.getCode());//????????????  3???????????????
            //yj01Save.setFjgl(yjxx.getYpzh());
            yj01Save.setDjzt(StatusEnum.Djzt.ZC.getCode());
            yj01Save.setJzkh(req.getJzkh());
            yj01Save.setCfsb(cf01.getCfsb());
            opYjcf01Dao.insert(yj01Save);

            OpYjcf02 yj02Save = new OpYjcf02();
            yj02Save.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJCF02));
            yj02Save.setJgid(user.getHospitalId());
            yj02Save.setYjxh(yj01Save.getYjxh());
            yj02Save.setYlxh(djfxm.getFyxh());
            yj02Save.setXmlx(djfxm.getXmlx());
            yj02Save.setYjzx(0);//????????????
            yj02Save.setYldj(djfxm.getFydj());
            yj02Save.setYlsl(new BigDecimal(req.getCfts()));
            //???????????????
            if (djfxm.getFydj() != null && req.getCfts() != null){
                BigDecimal zje = djfxm.getFydj().multiply(new BigDecimal(req.getCfts())).setScale(2, RoundingMode.HALF_UP);
                yj02Save.setHjje(zje);
            }
            yj02Save.setFygb(djfxm.getFygb());
            yj02Save.setZfbl(BigDecimal.ONE);
            yj02Save.setDzbl(BigDecimal.ONE);
            yj02Save.setYjzh(maxYjzh);//????????????
            yj02Save.setDjzt(StatusEnum.Djzt.ZC.getCode());
            yj02Save.setZxpb(0);//????????????
            yj02Save.setJzlsh(req.getJzlsh());
            opYjcf02Dao.insert(yj02Save);
        }
    }

    /**
     * ???????????????
     * @param cfsb
     */
    private void deleteDjf(Integer cfsb){
        if (cfsb == null){
            return;
        }

        List<OpYjcf01> yj01List = opYjcf01Dao.getCfFjxm(cfsb, StatusEnum.Fjlb.CFDJF.getCode());

        if (CollUtil.isEmpty(yj01List)){
            return;
        }
        for(OpYjcf01 yj01 : yj01List){
            //??????op_yjcf01
            opYjcf01Dao.deleteById(yj01.getYjxh());
            //??????op_yjcf02
            opYjcf01Dao.deleteByYjxh(ParamUtil.instance().put("yjxh", yj01.getYjxh()));
        }
    }

    /**
     * ??????????????????????????????
     * @param cfsb
     */
    private void checkCfIsFee(Integer cfsb){
        if (cfsb != null){
            OpCf01 opCf01 = opCf01Dao.getById(cfsb);
            //??????fphm??????????????????zfpb??????????????????????????????1??????zfpb???1??? ????????????????????????
            if (opCf01 != null && StrUtil.isNotBlank(opCf01.getFphm()) && opCf01.getZfpb() != 1){
                throw BaseException.create("ERROR_DCTWORK_OP_0061");
            }
        }
    }

    /**
     * ??????????????????
     * @param req
     * @param user
     */
    public void checkKjyw(MsCfSaveReq req,SysUser user){
        //????????????????????????
        AmqcKjywsycs kjywsycs = amqcKjywsycsService.getSycsById(user.getHospitalId());
        if (kjywsycs == null) {
            return;
        }
        if (CollUtil.isNotEmpty(req.getCf02List())){
            req.getCf02List().stream().forEach(o ->{
                //???????????????????????? ???????????????????????????????????????????????????1 ???????????? 0???null??????????????????
                if ("1".equals(o.getKsbz())){
                    //??????????????????????????????????????????
                    judgeDoctorOpenKjyw(o,req.getJzxh(),user,kjywsycs);
                }
            });
        }
    }

    /**
     * ?????????????????????????????????????????????????????????????????????
     */
    private void judgeDoctorOpenKjyw(OpCf02SaveReq req,Integer jzxh,SysUser user,AmqcKjywsycs kjywsycs){
        //??????????????????????????????

        DrugsTypkDetailResp drug = drugsTypkOutSer.getDrugsTypkById(req.getYpxh());
        if (drug == null){
            throw BaseException.create("ERROR_DCTWORK_OP_0056");
        }
        //??????????????????????????? ??????????????????????????????
        if (drug.getKsbz() != 1){
            return;
        }
        //A.????????????????????????????????????
        if (kjywsycs.getMzsfyxsykjyw() != 1){
            throw BaseException.create("ERROR_DCTWORK_OP_0051", new String[]{StrUtil.isBlank(req.getFymc())?"":req.getFymc()});
        }
        //B.???????????????????????????????????????????????????????????????
        if (drug.getKssdj() != null && drug.getKssdj() == 3){
            //????????????????????????????????????????????????????????????????????????
            if (kjywsycs.getMzsfyxsykjyw() != 1){
                throw BaseException.create("ERROR_DCTWORK_OP_0058");
            }
        }
        //C.??????????????????????????????
        HrPersonnelModel personnel = hrPersonnelSer.getPersonnelById(user.getUserId());
        if (personnel == null){
            throw BaseException.create("ERROR_DCTWORK_OP_0054");
        }
        //C1.?????????????????????????????????(1?????????????????? 0???null?????????????????????)
        if (!"1".equals(personnel.getAntibioticright())){
            //??????????????????
            judgeSpipping(req,jzxh,kjywsycs);
        }else{
            //C2.??????????????????????????????????????????????????????????????????(????????????????????????????????????????????????)
            if (drug.getKssdj() != null && (StrUtil.isBlank(personnel.getAntibioticlevel()) || !personnel.getAntibioticlevel().contains(String.valueOf(drug.getKssdj())))){
                //??????????????????
                judgeSpipping(req,jzxh,kjywsycs);
            }else {
                //??????????????????????????????????????????????????????
                if (req.getYyts() != null && req.getYyts() != 0 && req.getYyts() > kjywsycs.getMzyxsyzdts()){
                    //??????????????????
                    judgeOverDay(req,jzxh,kjywsycs);
                }
            }
        }
    }

    /**
     * ?????????????????????????????????
     * @param req
     * @param jzxh
     * @param kjywsycs
     */
    private void judgeOverDay(OpCf02SaveReq req,Integer jzxh,AmqcKjywsycs kjywsycs){
        judgeOpCfkjyw(req,jzxh,kjywsycs,1);
    }

    /**
     * ??????????????????????????????
     * @param req
     * @param jzxh
     * @param kjywsycs
     */
    private void judgeSpipping(OpCf02SaveReq req,Integer jzxh,AmqcKjywsycs kjywsycs){
        judgeOpCfkjyw(req,jzxh,kjywsycs,2);
    }

    /**
     * ????????????????????????
     * @param req
     * @param jzxh
     * @param kjywsycs
     * @param type  1 ????????????????????? 2????????????
     */
    private void judgeOpCfkjyw(OpCf02SaveReq req,Integer jzxh,AmqcKjywsycs kjywsycs,Integer type){
        //????????????????????????
        OpCfKjywsqjlResp opCfKjywsqjlResp = opCfKjywsqjlService.queryCfKjywjl(req.getYpxh(), jzxh);
        if (opCfKjywsqjlResp == null){
            if (type == 1){
                throw BaseException.create("ERROR_DCTWORK_OP_0052",new String[]{StrUtil.isBlank(req.getFymc())?"":req.getFymc(),String.valueOf(kjywsycs.getMzyxsyzdts())});
            }else {
                throw BaseException.create("ERROR_DCTWORK_OP_0060",new String[]{StrUtil.isBlank(req.getFymc())?"":req.getFymc()});
            }
        }
        //????????????????????????????????????
        if (opCfKjywsqjlResp.getZt() == 0 || opCfKjywsqjlResp.getZt() == 4){
            throw BaseException.create("ERROR_DCTWORK_OP_0053",new String[]{StrUtil.isBlank(req.getFymc())?"":req.getFymc()});
        }
        //????????????????????????????????????
        if (req.getYyts() != null && req.getYyts() != 0 && req.getYyts() > opCfKjywsqjlResp.getTs()){
            throw BaseException.create("ERROR_DCTWORK_OP_0059",new String[]{StrUtil.isBlank(req.getFymc())?"":req.getFymc()});
        }
    }

    /**
     * ??????????????????
     * @param cfsb
     */
    private void  deleteCfps(Integer cfsb){
        if(null == cfsb){
            return;
        }
        //?????????????????????????????????
//        ParamUtil param = ParamUtil.instance().put("cfsb", cfsb).put("fjlb",2);
//        List<OpYjcf01> yj01List = opYjcf01Dao.findByEntity(param);
        List<OpYjcf01> yj01List = opYjcf01Dao.getCfFjxm(cfsb, StatusEnum.Fjlb.CFPSXM.getCode());
        if (CollUtil.isEmpty(yj01List)){
            return;
        }
        for(OpYjcf01 yj01 : yj01List){
            //??????op_yjcf01
            opYjcf01Dao.deleteById(yj01.getYjxh());
            //??????op_yjcf02
            opYjcf01Dao.deleteByYjxh(ParamUtil.instance().put("yjxh", yj01.getYjxh()));
        }
    }

    /**
     * ??????????????????
     * @param req
     * @param user
     * @param cf01
     */
    private void saveCfps(MsCfSaveReq req, SysUser user, OpCf01 cf01) {
        //???????????????????????????
        deleteCfps(req.getOldCfsb());
        Integer maxYjzh = opYjcf02Ser.getMaxYjzh(req.getJzlsh(), user.getHospitalId());//????????????????????????
        //??????
        OpYjcf01 yj01Save = null;
        if (CollUtil.isNotEmpty(req.getCfpsList())){
            for (OpCfpsReq yjxx : req.getCfpsList()) {
                if (yj01Save == null) {
                    //??????yj01???yj02
                    yj01Save = new OpYjcf01();
                    yj01Save.setJgid(user.getHospitalId());
                    yj01Save.setBrid(cf01.getBrid());
                    yj01Save.setBrxm(cf01.getBrxm());
                    yj01Save.setKdrq(DateUtil.getCurrentTimestamp());
                    yj01Save.setKsdm(cf01.getKsdm());
                    yj01Save.setYsdm(String.valueOf(user.getUserId()));
                    yj01Save.setZxks(cf01.getKsdm());
                    yj01Save.setZxpb(0);
                    yj01Save.setZfpb(0);
                    yj01Save.setCfbz(0);
                    yj01Save.setJzxh(req.getJzxh());
                    //yj01Save.setFjgl(yjxx.getYpzh());
                    yj01Save.setFjlb(2);//???????????????????????????
                    yj01Save.setDjzt(0);
                    yj01Save.setJzkh(req.getJzkh());
                    yj01Save.setYjxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJCF01));
                    yj01Save.setJzlsh(req.getJzlsh());
                    yj01Save.setCfsb(cf01.getCfsb());
                    yj01Save.setDjly(1);
                    opYjcf01Dao.insert(yj01Save);
                }
                OpYjcf02 yj02Save = new OpYjcf02();
                yj02Save.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJCF02));
                yj02Save.setJgid(user.getHospitalId());
                yj02Save.setYjxh(yj01Save.getYjxh());
                yj02Save.setYlxh(0);
                yj02Save.setXmlx(0);
                yj02Save.setYjzx(0);
                yj02Save.setYldj(BigDecimal.ZERO);
                yj02Save.setYlsl(BigDecimal.ZERO);
                yj02Save.setHjje(yjxx.getPsje());
                yj02Save.setFygb(6);
                //Map<String, Object> payArgs = new HashMap<>(16);
                //payArgs.put("FYXH", yjxx.getYlxh());
                //payArgs.put("FYGB", yj02Save.getFygb());
                //payArgs.put("BRXZ", req.getBrxz());
                //payArgs.put("TYPE", 0);
                yj02Save.setZfbl(BigDecimal.ONE);
                yj02Save.setDzbl(BigDecimal.ZERO);
                yj02Save.setYjzh(maxYjzh);
                yj02Save.setJzlsh(req.getJzlsh());

                yj02Save.setPsid(yjxx.getPsid());
                yj02Save.setPsmc(yjxx.getPsmc());
                yj02Save.setPssl(yjxx.getPssl());
                yj02Save.setPsje(yjxx.getPsje());

                opYjcf02Dao.insert(yj02Save);
            }
        }


    }

//    //??????????????????
//    private void saveFjxm(MsCfSaveReq req, SysUser user, OpCf01 cf01) {
//        // ??????????????????
//        for (OpYjcf02Req yjxx : req.getFjxxList()) {
//            OpYjcf01 yj01Save = new OpYjcf01();
//            yj01Save.setJgid(user.getHospitalId());
//            yj01Save.setBrid(cf01.getBrid());
//            yj01Save.setBrxm(cf01.getBrxm());
//            yj01Save.setKdrq(DateUtil.getCurrentTimestamp());
//            yj01Save.setKsdm(cf01.getKsdm());
//            yj01Save.setYsdm(String.valueOf(user.getUserId()));
//            yj01Save.setZxks(cf01.getKsdm());
//            yj01Save.setZxpb(0);
//            yj01Save.setZfpb(0);
//            yj01Save.setCfbz(cf01.getCfsb());
//            yj01Save.setJzxh(req.getJzxh());
//            yj01Save.setFjgl(yjxx.getYpzh());
//            yj01Save.setFjlb(2);
//            yj01Save.setDjzt(0);
//            yj01Save.setJzkh(req.getJzkh());
//            yj01Save.setYjxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJCF01));
//            yj01Save.setJzlsh(req.getJzlsh());
//            opYjcf01Dao.insert(yj01Save);
//        }
//    }

    //??????cf02
    private List<OpCf02> saveCf02(MsCfSaveReq req, OpCf01 cf01, SysUser user) {
        List<OpCf02> retCf02List = new ArrayList<>();
        //??????????????????????????????????????? ????????????????????????????????????
        if(req.getOldCfsb() != null && req.getOldCfsb().intValue() > 0){
            OpCf02 cf02 = new OpCf02();
            cf02.setCfsb(req.getOldCfsb());
            opCf02Dao.deleteByCfsb(req.getOldCfsb());
        }

        List<OpCf02SaveReq> cf02List = req.getCf02List();

        //????????????????????? ???????????????????????? ??????????????????????????????

        BigDecimal totalPrice = BigDecimal.ZERO;//??????????????????????????????
        for(OpCf02SaveReq cf02Req: cf02List) {
            OpCf02 cf02 = BeanUtil.toBean(cf02Req, OpCf02.class);
            cf02.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CF02));
            cf02.setJgid(user.getHospitalId());
            cf02.setCfsb(cf01.getCfsb());
            cf02.setXmlx(cf02Req.getType());
            cf02.setCfts(cf01.getCfts());
            BigDecimal hjje = cf02.getYpdj().multiply(cf02.getYpsl()).multiply(new BigDecimal(cf02.getCfts()));
            cf02.setHjje(hjje);
            cf02.setYcsl("0");
            cf02.setJzlsh(req.getJzlsh());
            cf02.setPsjg(cf02Req.getPsjg());// 2020/12/11 ?????????????????????????????????
            //??????????????????
            opCf02Dao.insert(cf02);

            retCf02List.add(cf02);

            BigDecimal decimal = hjje.multiply(cf02.getZfbl());
            totalPrice = totalPrice.add(decimal);
        }

        //??????????????????????????????????????????????????????????????????????????????
        saveCfDbr(req,cf01,user);

        //??????????????????????????????
        if (req.getCflx().equals(StatusEnum.OpCflx.CY.getCode())){
            String cyzdxe = sysXtcsCacheSer.getByJGIdAndCsmc(user.getHospitalId(), StatusEnum.Xtcs.MZDZCFZDXECY.getCode()).getCsz();
            if (StrUtil.isBlank(cyzdxe)){
                logger.error("???????????????????????????");
            }else {
                BigDecimal zdxe = new BigDecimal(cyzdxe);
                if (totalPrice.compareTo(zdxe) == 1){
                    throw BaseException.create("ERROR_DCTWORK_OP_0077",new String[]{cyzdxe});
                }
            }
        }else {
            String xyzdxe = sysXtcsCacheSer.getByJGIdAndCsmc(user.getHospitalId(), StatusEnum.Xtcs.MZDZCFZDXEXY.getCode()).getCsz();
            if (StrUtil.isBlank(xyzdxe)){
                logger.error("???????????????????????????");
            }else {
                BigDecimal zdxe = new BigDecimal(xyzdxe);
                if (totalPrice.compareTo(zdxe) == 1){
                    throw BaseException.create("ERROR_DCTWORK_OP_0076",new String[]{xyzdxe});
                }
            }
        }
        return retCf02List;
    }

    /**
     * ?????????????????????
     * @param req
     * @param cf01
     * @param user
     */
    private void saveCfDbr(MsCfSaveReq req, OpCf01 cf01, SysUser user){
        String cfdymjy = sysXtcsCacheSer.getByJGIdAndCsmc(user.getHospitalId(), StatusEnum.Xtcs.CFDYMJY.getCode()).getCsz();
        List<String> cfdymjyData = Arrays.stream(cfdymjy.split(",")).collect(Collectors.toList());

        //????????????????????????
        List<Integer> ypxhList = req.getCf02List().stream().map(o -> o.getYpxh()).collect(Collectors.toList());

        int mjy = opCf01Dao.getAppointTypeDrug(ypxhList, cfdymjyData);
        if (mjy > 0 && StrUtil.isNotBlank(req.getDbrxm())){
            OpCfdbr opCfdbr = new OpCfdbr();
            opCfdbr.setDbid(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CFDBR));
            opCfdbr.setCfsb(cf01.getCfsb());
            opCfdbr.setJgid(user.getHospitalId());
            opCfdbr.setDbrxm(req.getDbrxm());
            opCfdbr.setDbrlxdh(req.getDbrlxdh());
            opCfdbr.setSfzm(req.getSfzm());
            opCfdbr.setBh(req.getBh());
            opCfdbrDao.insert(opCfdbr);
        }else {
            logger.info("??????????????????????????????????????????????????????????????????????????????????????????????????????");
        }
    }

    //??????cf01
    private OpCf01 saveCf01(MsCfSaveReq req, SysUser user) {

        //?????????????????????????????????????????????
        String sjjg = null;//??????????????????
        Integer sjyf = null;//??????????????????
        PharBaseInfoReq yflb = new PharBaseInfoReq();
        yflb.setYfsb(req.getYfsb());
        List<PharBaseInfoResp> retYflb = pharBaseConfigService.findByEntity(yflb);
        if(!retYflb.isEmpty()){
            //??????????????????
            sjjg = retYflb.get(0).getSjjg();
            //??????????????????
            sjyf = retYflb.get(0).getSjyf();
        }

        OpCf01 cf01 = BeanUtil.toBean(req, OpCf01.class);
        cf01.setCfsb(req.getOldCfsb() != null? req.getOldCfsb():redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CF01));
        cf01.setSjjg(sjjg);
        cf01.setSjyf(sjyf);
        cf01.setSjfybz(0);
        cf01.setJgid(user.getHospitalId());
        cf01.setKsdm(req.getKsdm());
        cf01.setPybz(0);
        cf01.setTybz(0);
        cf01.setKfrq(DateUtil.getCurrentTimestamp());
        cf01.setFybz(0);
        cf01.setZfpb(0);
        cf01.setYxpb(0);
        cf01.setCfhm("h"+cf01.getCfsb());
        cf01.setYsdm(user.getUserIdStr());
        cf01.setFwblsh(ObjectToTypes.parseString(req.getZtbh()));// ??????????????????????????????????????????????????????FWBLSH
        cf01.setDjybz(req.getDjybz()==null ? 0:req.getDjybz());// ?????????????????????0
        cf01.setJzlsh(req.getJzlsh());
        opCf01Dao.insert(cf01);

        return cf01;
    }

    //??????????????????
    private void checkYpkc(MsCfSaveReq req, Integer jgid) {
        for(OpCf02SaveReq cf02Req: req.getCf02List()) {
            OpCf02 cf02 = BeanUtil.toBean(cf02Req, OpCf02.class);
            if(cf02.getZfyp() != null && cf02.getZfyp() != 1){//???????????????????????????
                // ????????????????????????
                QueryYpCkslReq queryYpCkslDto = new QueryYpCkslReq();
                queryYpCkslDto.setYfsb(req.getYfsb());
                queryYpCkslDto.setYpxh(cf02.getYpxh());
                queryYpCkslDto.setYpcd(cf02.getYpcd());
                queryYpCkslDto.setJgid(jgid);
                queryYpCkslDto.setJlxh(cf02.getSbxh());
                Double ypCount = drugService.curEnableYpKcsl(queryYpCkslDto);
                if ((new BigDecimal(ypCount).subtract(cf02.getYpsl().multiply(new BigDecimal(req.getCfts())))).intValue() < 0) {
                    throw BaseException.create("ERROR_DCTWORK_OP_0005", new String[]{cf02Req.getFymc()});
                }
            }
        }
    }

    /**
     * ?????????????????????????????????
     * @param cfsb
     * @param jgid
     */
    private void deleteFreezeYp(Integer cfsb,Integer jgid){
        int sfqyyfyfy = 0;// ????????????????????????
        int mzkcdjsj = 0;// ??????????????????
        SysXtcs sfqyyfyfyXtcs = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, BUHISSystemArgument.SFQYYFYFY);
        if(sfqyyfyfyXtcs != null){
            sfqyyfyfy = ObjectToTypes.toInt(sfqyyfyfyXtcs.getCsz());
        }
        SysXtcs mzkcdjsjXtcs = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, BUHISSystemArgument.MZKCDJSJ);
        if(mzkcdjsjXtcs != null){
            mzkcdjsj = ObjectToTypes.toInt(mzkcdjsjXtcs.getCsz());
        }
//        // ???????????????????????????,0????????????,1??????(????????????????????????)
//        int sfqyyfyfy = 0;
//        String sfqyyfyfy1 = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, "SFQYYFYFY").getCsz();
//        if (StrUtil.isBlank(sfqyyfyfy1)){
//            logger.error("??????????????????????????????????????????1:?????????");
//        }
//        sfqyyfyfy = Integer.parseInt(sfqyyfyfy1);
//
//        // ???????????????????????? 1?????????,2?????????(??????????????????)
//        int mzkcdjsj = 1;
//        String mzkcdjsj1 = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, "MZKCDJSJ").getCsz();
//        if (StrUtil.isBlank(mzkcdjsj1)){
//            logger.error("???????????????????????????????????????????????????1:???????????????");
//        }
//        mzkcdjsj = Integer.parseInt(mzkcdjsj1);

        if (sfqyyfyfy == 1 && mzkcdjsj == 1) {
            PharKcdjReq req = new PharKcdjReq();
            req.setDjlb(1);
            req.setCfsb(cfsb);
            drugService.removeKcdj(req);
            //drugService.frozenYpkc(cfsb, null);
        }
    }

    //??????????????????
    private void freezeYp(MsCfSaveReq req, Integer cfsb, Integer jgid, List<OpCf02> retCf02List) {
        int sfqyyfyfy = 0;// ????????????????????????
        int mzkcdjsj = 0;// ??????????????????
        SysXtcs sfqyyfyfyXtcs = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, BUHISSystemArgument.SFQYYFYFY);
        if(sfqyyfyfyXtcs != null){
            sfqyyfyfy = ObjectToTypes.toInt(sfqyyfyfyXtcs.getCsz());
        }
        SysXtcs mzkcdjsjXtcs = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, BUHISSystemArgument.MZKCDJSJ);
        if(mzkcdjsjXtcs != null){
            mzkcdjsj = ObjectToTypes.toInt(mzkcdjsjXtcs.getCsz());
        }
//        // ???????????????????????????,0????????????,1??????(????????????????????????)
//        int sfqyyfyfy = 0;
//        String sfqyyfyfy1 = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, "SFQYYFYFY").getCsz();
//        if (StrUtil.isBlank(sfqyyfyfy1)){
//            logger.error("??????????????????????????????????????????1:?????????");
//        }
//        sfqyyfyfy = Integer.parseInt(sfqyyfyfy1);
//
//        // ???????????????????????? 1?????????,2?????????(??????????????????)
//        int mzkcdjsj = 1;
//        String mzkcdjsj1 = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, "MZKCDJSJ").getCsz();
//        if (StrUtil.isBlank(mzkcdjsj1)){
//            logger.error("???????????????????????????????????????????????????1:???????????????");
//        }
//        mzkcdjsj = Integer.parseInt(mzkcdjsj1);

        // ????????????????????????,????????????????????????
        if (sfqyyfyfy == 1 && mzkcdjsj == 1) {
            List<PharKcdjReq> datas = new ArrayList();
            for (OpCf02 cf02: retCf02List) {
                //????????????????????????zfyp=1????????????
                if(cf02.getZfyp() != null && cf02.getZfyp() != 1){
                    PharKcdjReq dj = new PharKcdjReq();
                    dj.setJgid(jgid);
                    dj.setYfsb(req.getYfsb());
                    dj.setCfsb(cfsb);
                    dj.setYpxh(cf02.getYpxh());
                    dj.setYpcd(cf02.getYpcd());
                    dj.setYpsl(cf02.getYpsl().multiply(new BigDecimal(cf02.getCfts()==null?0:cf02.getCfts()))
                            .setScale(2, RoundingMode.HALF_UP));
                    dj.setYfbz(cf02.getYfbz());
                    dj.setDjsj(DateUtil.getCurrentTimestamp());
                    dj.setJlxh(cf02.getSbxh());
                    dj.setDjlb(1);
                    dj.setLsjg(cf02.getYpdj());
                    dj.setJlxh(cf02.getSbxh());
                    dj.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.PHAR_KCDJ));
                    datas.add(dj);
                }
            }
            if(!datas.isEmpty()) {
                drugService.frozenYpkc(cfsb, datas);
            }
        }

    }

    /**
     * ??????????????????????????????????????????
     * @param userId
     * @return
     */
    public LoadOutClinicInitParamsResp loadOutClinicInitParams(Integer userId) {
        HrPersonnelModel person = hrPersonnelSer.getPersonnelById(userId);
        LoadOutClinicInitParamsResp resp = new LoadOutClinicInitParamsResp();
        resp.setKcfq(person.getPrescriberight());//????????????
        resp.setMzyq(person.getNarcoticright());//??????
        resp.setKssqx(person.getAntibioticlevel());//?????????
        resp.setKjsy(person.getPsychotropicright());//??????
        resp.setYgxm(person.getPersonname());
        return resp;
    }

    /**
     * ??????????????????
     * @param jzxh
     * @return
     */
    public PageInfo<LoadAdditionResp> loadAddition(Integer jzxh, PageQuery page) {
        PageInfo<LoadAdditionResp> pageInfo = PageHelper.startPage(
            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                    () -> opYjcf02Dao.loadAddition(jzxh)
            );
        return pageInfo;
    }

    /**
     * ????????????????????????
     * @param req
     */
    public PerscriptionCopyCheckResp perscriptionCopyCheck(PerscriptionCopyCheckReq req) {
        Map<String, Object> zt_med = new HashMap<>(16);
        List<Map<String, Object>> cf01_List = MzUtil.ListObjToMap(req.getCf01List());
        List<Map<String, Object>> cf02_List = MzUtil.ListObjToMap(req.getCf02List());
        for (Map<String, Object> med : cf02_List) {

            List<Map<String, Object>> meds = drugService.qeuryPerscriptionCopyCheck(
                    ObjectToTypes.parseInt(cf01_List.get(0).get("YFSB")),
                    ObjectToTypes.parseInt(med.get("YPXH")),
                    ObjectToTypes.parseInt(med.get("YPCD")));

            if (meds.size() > 0) {// ??????????????????
                zt_med = meds.get(0);
                zt_med.put("YCJL", med.get("YCJL"));
                zt_med.put("YYTS", med.get("YYTS"));
                zt_med.put("YPSL", med.get("YPSL"));
                zt_med.put("YPYF", med.get("YPYF"));
                zt_med.put("YPYF_text", med.get("YPYF_text"));
                zt_med.put("GYTJ", med.get("GYTJ"));
                zt_med.put("GYTJ_text", med.get("GYTJ_text"));
                zt_med.put("JF", med.get("JF"));
                zt_med.put("JF_text", med.get("JF_text"));
                zt_med.put("BZMC", med.get("BZMC"));
                zt_med.put("MRCS", med.get("MRCS"));
                zt_med.put("YPZH", med.get("YPZH"));

                // ????????????????????????????????????????????????
                Map<String, Object> data = new HashMap<>(16);
                data.put("TYPE", zt_med.get("TYPE"));
                data.put("FYXH", zt_med.get("YPXH"));
                data.put("BRXZ", req.getBrxz());
                data.put("FYGB", zt_med.get("FYGB"));
                Map<String, Object> zfbl = mzUtil.getPayProportion(data);
                zt_med.put("ZFBL", zfbl.get("ZFBL"));
                zt_med.put("YPYF", zt_med.get("SYPC"));
                zt_med.put("SYPC", med.get("YPYF"));
                zt_med.put("SYPC_text", med.get("YPYF_text"));
            } else {
                throw BaseException.create("ERROR_DCTWORK_OP_0023");
            }
        }
        PerscriptionCopyCheckResp resp = cn.hutool.core.bean.BeanUtil.fillBeanWithMapIgnoreCase(zt_med,
                new PerscriptionCopyCheckResp(),true);
        return resp;
    }

    /**
     * ??????????????????
     * @param req
     */
    public CheckInventoryResp checkInventory(CheckInventoryReq req, Integer hospitalId) {
        CheckInventoryResp resp = new CheckInventoryResp();

        int tag=0;
        if(req.getJc() != null){
            tag=1;
        }

        List<Map<String, Object>> list = drugService.getKczlAndLsjg(req.getPharmId(), req.getMedId(), req.getMedsource());

        if (list == null || list.size() == 0) {
            resp.setSign(-1);
            resp.setKczl(BigDecimal.ZERO);
            return resp;
        }
        Map<String, Object> map = (HashMap<String, Object>) list.get(0);
        BigDecimal kczl = new BigDecimal(map.get("kczl").toString());
        if (kczl == null || kczl.compareTo(BigDecimal.ZERO) == 0){//????????????????????????????????????0?????????
            resp.setKczl(BigDecimal.ZERO);
            resp.setSign(-1);
            return resp;
        }

        int sfqyyfyfy = 0;// ????????????????????????
        SysXtcs sfqyyfyfyXtcs = sysXtcsCacheSer.getByJGIdAndCsmc(hospitalId, BUHISSystemArgument.SFQYYFYFY);
        if(sfqyyfyfyXtcs != null){
            sfqyyfyfy = ObjectToTypes.toInt(sfqyyfyfyXtcs.getCsz());
        }

        // ??????????????????
        String kcdjts = sysXtcsCacheSer.getByJGIdAndCsmc(hospitalId,BUHISSystemArgument.KCDJTS).getCsz();
        if(tag==1){
            kcdjts = sysXtcsCacheSer.getByJGIdAndCsmc(hospitalId, BUHISSystemArgument.JCKCDJTS).getCsz();
        }
        if (sfqyyfyfy == 1) {
            SumDjslReq sumDjslReq = new SumDjslReq();
            sumDjslReq.setJlxh(req.getJlxh() == null ? 0 : req.getJlxh());
            sumDjslReq.setKcdjts(cn.hutool.core.date.DateUtil.offsetDay(cn.hutool.core.date.DateUtil.date(), - ObjectToTypes.parseInt(kcdjts)).toTimestamp());
            sumDjslReq.setYfsb(req.getPharmId());
            sumDjslReq.setYpxh(req.getMedId());
            sumDjslReq.setYpcd(req.getMedsource());

            BigDecimal kczl_new = drugService.getdjslBykcdjts(sumDjslReq);
            if (kczl_new != null){
                kczl = kczl.subtract(kczl_new);//???????????????????????????-????????????
            }
        }
        // ????????????????????????
        if (kczl == null || kczl.compareTo(req.getQuantity()) == -1) {
            if (kczl == null) {
                resp.setKczl(BigDecimal.ZERO);
            } else {
                resp.setKczl(kczl.setScale(2));
            }
            resp.setSign(-1);
        } else {
            resp.setSign(1);
            resp.setKczl(kczl);
        }
        return resp;
    }

    /**
     * ????????????????????????
     * @param ypcd
     * @param ypxh
     * @return
     */
    public List<QueryYbypxxResp> queryYbypxx(Integer ypcd, Integer ypxh) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ypxh", ypxh);
        parameters.put("ypcd", ypcd);
        List<QueryYbypxxResp> resp = opCf01Dao.findByYpxhYpcd(parameters);
        return resp;
    }

    /**
     * ????????????????????????????????????????????????
     * @param user
     * @return
     */
    public SystemArgumentCfmxslResp querySystemArgumentCfmxsl(SysUser user) {
        SystemArgumentCfmxslResp resp = new SystemArgumentCfmxslResp();
        Integer jgid = user.getHospitalId();// ???????????????ID
        Integer cfxyzymxsl = 0;
        Integer cfcymxsl = 0;

        SysXtcs xtcs1 = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, "CFXYZYMXSL");
        if(xtcs1 != null){
            cfxyzymxsl = Integer.parseInt(xtcs1.getCsz());
        }
        SysXtcs xtcs2 = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, "CFCYMXSL");
        if(xtcs2 != null){
            cfcymxsl = Integer.parseInt(xtcs2.getCsz());
        }

        resp.setCfcymxsl(cfcymxsl);
        resp.setCfxyzymxsl(cfxyzymxsl);
        return resp;
    }

    /**
     * ??????????????????
     * @param user
     * @return
     */
    public PageInfo<QueryCfypxxResp> queryCfAllYpxx(QueryCfypxxReq req, SysUser user) {
        QueryCfypxxReq queryCfypxxReq = new QueryCfypxxReq();
        queryCfypxxReq.setJgid(user.getHospitalId());
        //?????????????????????????????????0???????????????1?????????????????????(MZCFYPSFQBXS)
        SysXtcs xtcs = sysXtcsCacheSer.getByJGIdAndCsmc(user.getHospitalId(), "MZCFYPSFQBXS");
        if(xtcs != null && "1".equals(xtcs.getCsz())){
            queryCfypxxReq.setYpsl(BigDecimal.ONE);
        }
        queryCfypxxReq.setPageNum(req.getPageNum());
        queryCfypxxReq.setPageSize(req.getPageSize());
        queryCfypxxReq.setPydm(req.getPydm());
        queryCfypxxReq.setCflx(req.getCflx());
        PageInfo<QueryCfypxxResp> pageInfo = drugService.queryCfAllYpxx(queryCfypxxReq);
        return pageInfo;
    }

    /**
     * ????????????????????????????????????
     * @param req
     * @return
     */
    public List<LoadPersonalSetResp> loadPersonalSet(LoadPersonalSetReq req) {
        List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();
        Map<String, Object> par = new HashMap<>();
        par.put("ztbh", req.getZtbh());
        List<Map<String, Object>> list = opZt02Service.getYpZtInfoByZtbh(par);
        Integer newYpzh = 1;
        Integer oldYpzh = 1;
        Integer index = 1;
        for (Map<String, Object> med : list) {
            //?????????????????????????????????
            Integer currentYpzh = Integer.parseInt(med.get("ypzh").toString());
            if (index == 1) {
                med.replace("ypzh", newYpzh);
            }else if(!oldYpzh.equals(currentYpzh)) {
                newYpzh++;
                med.replace("ypzh", newYpzh);
            }else {
                med.replace("ypzh", newYpzh);
            }
            oldYpzh = currentYpzh;
            for(OpZt02CdResp cd : req.getCdList()){
                if(cd.getYpxh().intValue() == ObjectToTypes.parseInt(med.get("ypxh"))){
                    QueryDrugDetailReq queryDrugDetailReq = new QueryDrugDetailReq();
                    queryDrugDetailReq.setYfsb(req.getPharmacyId());
                    queryDrugDetailReq.setYpxh(cd.getYpxh());
                    queryDrugDetailReq.setCdmc(cd.getCdmc());
                    queryDrugDetailReq.setYfdw(cd.getYfdw());
                    queryDrugDetailReq.setLsjg(cd.getLsjg());
                    queryDrugDetailReq.setYfgg(cd.getYfgg());
                    List<Map<String, Object>> meds = drugService.findByYfsbYpxh(queryDrugDetailReq);

                    if (meds.size() > 0) {// ??????????????????
                        Map<String, Object> zt_med = meds.get(0);
                        zt_med.put("ybfl", med.get("ybfl"));
                        zt_med.put("ycjl", med.get("ycjl"));
                        zt_med.put("yyts", med.get("yyts"));
                        zt_med.put("ypsl", med.get("ypsl"));
                        zt_med.put("ypzh", med.get("ypzh"));
                        zt_med.put("ypyf", med.get("ypyf"));
                        zt_med.put("ypyf_text", med.get("ypyf_text"));
                        zt_med.put("gytj", med.get("gytj"));
                        zt_med.put("gytj_text", med.get("gytj_text"));
                        zt_med.put("bzmc", med.get("bzmc"));
                        zt_med.put("mrcs", med.get("mrcs"));
                        zt_med.put("sypc", med.get("sypc"));
                        zt_med.put("sypc_text", med.get("sypc_text"));
                        zt_med.put("jb",med.get("jb"));
                        zt_med.put("jz",med.get("jz"));
                        //zt_med.put("ypyf", zt_med.get("sypc"));(????????????????????????)

                        // ????????????????????????????????????????????????
                        Map<String, Object> data = new HashMap<String, Object>();
                        data.put("TYPE", zt_med.get("type"));
                        data.put("FYXH", zt_med.get("ypxh"));
                        data.put("BRXZ", req.getBrxz());
                        data.put("FYGB", zt_med.get("fygb"));
                        Map<String, Object> zfblMap = mzUtil.getPayProportion(data);
                        zt_med.put("zfbl", zfblMap.get("ZFBL"));

                        res.add(zt_med);
                    } else {
                        med.put("errorCode", "ERROR_DCTWORK_OP_0030");
                        res.add(med);
                    }
                    index ++;
                }
            }
        }

        return MzUtil.ListToResultSet(res, new LoadPersonalSetResp());
    }

    /**
     * ??????????????????????????????????????????????????????
     * @param req
     * @return
     */
    public LoadMedcineInfoResp loadMedcineInfo(LoadMedcineInfoReq req) {
        Integer ypxh = req.getYpxh();
        // ???????????? ??? ????????????
        Integer pharmacyId = req.getPharmacyId();
        String tabId = req.getTabId();
        // ????????????????????????,????????????
        Map<String, Object> med = null;
        if ("clinicCommon".equals(tabId)) {
            Map<String, Object> par = new HashMap<>();
            par.put("jlbh", req.getJlbh());
            List<Map<String, Object>> list = opZt02Service.getYpZtInfoByZtbh(par);

            if (list.size() > 0) {
                med = list.get(0);
            }
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("yfsb", pharmacyId);
        params.put("ypxh", ypxh);

        List<Map<String, Object>> meds = drugService.findYpByYfsbYpxh(pharmacyId, ypxh);


        if (meds.size() > 0) {// ???????????????????????????
            Map<String, Object> zt_med = meds.get(0);
            if ("clinicCommon".equals(tabId)) {
                zt_med.putAll(med);
            }
            // ????????????????????????????????????????????????
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("TYPE", req.getType());
            data.put("FYXH", req.getYpxh());
            data.put("BRXZ", req.getBrxz());
            data.put("FYGB", req.getFygb());
            Map<String, Object> zfblMap = mzUtil.getPayProportion(data);
            zt_med.put("zfbl", zfblMap.get("ZFBL"));
            return cn.hutool.core.bean.BeanUtil.fillBeanWithMapIgnoreCase(zt_med, new LoadMedcineInfoResp(), true);
        } else {
            throw BaseException.create("ERROR_DCTWORK_OP_0030");
        }
    }

    /**
     * ????????????
     * @param pkey
     * @param hospitalId
     * @return
     */
    public void removeClinicInfo(Integer cfsb, Integer hospitalId) {
        Map<String, Object> params = ParamUtil.instance().put("cfsb", cfsb);

        long l = opCf01Dao.queryChargeCount(params);
        if (l > 0) {
            throw BaseException.create("ERROR_DCTWORK_OP_0031");
        }

        // ??????????????????
        List<Integer> yjxhList = opYjcf02Dao.queryYjxhByCfsb(params);
        if(yjxhList != null && !yjxhList.isEmpty()){
            opYjcf02Dao.deleteBySbxhList(yjxhList);
        }

        List<OpCf02> cf02List = opCf02Dao.findByEntity(params);
        for (OpCf02 cf02 : cf02List) {
            List<OpYjcf01> yj01List = opYjcf01Dao.findByEntity(ParamUtil.instance().put("fjgl", cfsb));
            if (yj01List == null || yj01List.isEmpty()) {
                break;
            }
            OpYjcf01 yj01 = yj01List.get(0);
            opYjcf02Dao.removeByEntity(ParamUtil.instance().put("yjxh", yj01.getYjxh()));
            opYjcf01Dao.deleteById(yj01.getYjxh());
        }

        // ??????????????????
        //ysMzPsjlDao.removeByEntity(params);

        //??????????????????
        //opCf02Dao.removeByEntity(params);
        opCf02Dao.deleteByCfsb(cfsb);
        opCf01Dao.deleteById(cfsb);

        // ??????????????????
        int sfqyyfyfy = 0;// ????????????????????????
        int mzkcdjsj = 0;// ??????????????????
        SysXtcs sfqyyfyfyXtcs = sysXtcsCacheSer.getByJGIdAndCsmc(hospitalId, BUHISSystemArgument.SFQYYFYFY);
        if(sfqyyfyfyXtcs != null){
            sfqyyfyfy = ObjectToTypes.toInt(sfqyyfyfyXtcs.getCsz());
        }
        SysXtcs mzkcdjsjXtcs = sysXtcsCacheSer.getByJGIdAndCsmc(hospitalId, BUHISSystemArgument.MZKCDJSJ);
        if(mzkcdjsjXtcs != null){
            mzkcdjsj = ObjectToTypes.toInt(mzkcdjsjXtcs.getCsz());
        }

        if (sfqyyfyfy == 1 && mzkcdjsj == 1) {// ????????????????????????,????????????????????????
            // ??????????????????????????????
            // MedicineCommonModel model = new MedicineCommonModel(dao);
            // model.deleteKCDJ(manageUnit, ctx);
            //params.put("djlb", "1");
            PharKcdjReq req = new PharKcdjReq();
            req.setDjlb(1);
            req.setCfsb(cfsb);
            drugService.removeKcdj(req);
        }
    }

//
//    /**
//     * ????????????????????????
//     */
//    public void loadAppendAdvice(Integer jgid) {
////        UserRoleToken user = UserRoleToken.getCurrent();
////        String manageUnit = user.getManageUnitId();
////        Long ksdm = Long.parseLong(body.get("KSDM").toString());
////        Long fyxh = Long.parseLong(body.get("FYXH").toString());
////        Map<String, Object> params = new HashMap<String, Object>();
////        params.put("JGID", manageUnit);
////        params.put("XMXH", fyxh);
////        params.put("KSDM", ksdm);
////        Object mzsy = body.get("MZSY");
////        String sylb = "ZYSY";
////        if (mzsy != null && "1".equals(mzsy.toString())) {
////            sylb = "MZSY";
////        }
////        List<Map<String, Object>> res = dao
////                .doQuery(
////                        "select a.XMXH as XMXH,a.SYLB as SYLB,a.GLXH as YPXH,b.FYMC as YZMC,a.FYSL as FYSL,c.FYDJ as YPDJ,b.XMLX as XMLX,b.FYDW as FYDW,c.FYKS as FYKS,b.FYGB as FYGB from DICC_LDXMGL a,FEE_YLSFXM b,FEE_YLSFXMDJ c where a.GLXH=b.FYXH and a.GLXH=c.FYXH and c.JGID=:JGID and a.XMXH=:XMXH AND  (a.KSDM=0 OR KSDM=:KSDM) and a.JGID=:JGID and c.ZFPB=0 and b.ZFPB=0 and b."
////                                + sylb + "=1", params);
////        return res;
//    }
//
//    /**
//     * ??????????????????????????????
//     * @param brid
//     * @param ypxh
//     * @param hospitalId
//     * @return
//     */
//    public GetSkinTestResp getSkinTest(Integer brid, Integer ypxh, Integer hospitalId) {
//        Map<String, Object> param = ParamUtil.instance().put("brbh", brid).put("ypbh", ypxh);
//        List<Map<String, Object>> list = ysMzPsjlDao.queryByBrbhYpbh(param);
//        if(list == null || list.isEmpty()){
//            return null;
//        }else{
//            GetSkinTestResp resp = cn.hutool.core.bean.BeanUtil.fillBeanWithMapIgnoreCase(list.get(0), new GetSkinTestResp(), true);
//            return resp;
//        }
//    }

    /**
     * @name: cfPrint
     * @description: ????????????
     * @param req
     * @param response
     * @return: void
     * @date: 2020/8/26 10:24
     * @auther: ?????????
     *
     */
    public String cfPrint(CfPrintReq req, SysUser user, HttpServletResponse response) {
        //String jasperName = "ReportForPrescriptionDetail.jasper";
        //Map<String, Object> params = getCfPringParameters(req, user);

        //??????????????????????????????
        Map<String, Object> params = getPrintData(req, user);
        String model = (String)params.get("MODEL");
        List<Map<String, Object>> list = getCfPringFields(req);
      // String url = exportFileSer.reportHtml(list, params, model);
        iReportExportFileSer.reportHtmlForStream(list, params, "jrxml/"+model, response);
        return "";
    }

    /**
     * @name: getCfPringFields
     * @description: ?????????????????? ???
     * @param req
     * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @date: 2020/8/26 10:28
     * @auther: ?????????
     *
     */
    private List<Map<String, Object>> getCfPringFields(CfPrintReq req){
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("cfsb", req.getCfsb());
        List<Map<String, Object>> list = opCf01Dao.getCfPringFields(parameters);

        int dyYpzh=1;
        String ypzh="";
        for(int i =0;i<list.size();i++){
            Map<String,Object> cfmx = list.get(i);
            if(ypzh.equals(ObjectToTypes.parseString(cfmx.get("YPZH")))){
                cfmx.put("YPZH", "");
                continue;
            }else{
                ypzh= ObjectToTypes.parseString(cfmx.get("YPZH"));
                cfmx.put("YPZH", "    "+dyYpzh);
                dyYpzh++;
            }
        }

        return list;
    }

    /**
     * ??????????????????
     * @param req
     * @param user
     * @return
     */
    private Map<String, Object> getPrintData(CfPrintReq req, SysUser user){
        //????????????????????????
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("cfsb", req.getCfsb());
        List<Map<String, Object>> list = opCf01Dao.getPrintData(parameters);
        if(list == null || list.isEmpty()){
            throw BaseException.create("ERROR_DCTWORK_OP_0042");
        }
        //????????????????????????
        Map<String, Object> result = list.get(0);

        //????????????
        Date csny = (Date)result.get("CSNY");
        if (csny != null){
            Map<String, Object> agMap = MzUtil.getPersonAge(csny, null);
            result.put("BRNL",agMap.get("ages").toString());
            result.put("BRNLDES",agMap.get("ages").toString());
        }

        //??????????????????
        String psjg = (String)result.get("PSJG");
        if (StrUtil.isBlank(psjg)){
            result.put("skinTest","????????????");
        }else {
            if (psjg.contains("3")){
                result.put("skinTest","??????");
            }else if (psjg.contains("2")){
                result.put("skinTest","??????");
            }else{
                result.put("skinTest","????????????");
            }
        }

        //???????????????????????????????????????????????????????????????
        result.put("DJLYMC","???");
        result.put("MODEL","PreNormal.jasper");
        int jeCf = opCf01Dao.getJeCf(req.getCfsb());
        if (jeCf > 0){
            result.put("DJLYMC","??????");
            result.put("MODEL","PreJe.jasper");
        }

        //?????????????????????????????????  1002  todo ??????????????????
        Long KSID = (Long) result.get("KSID");
        if (KSID != null && KSID == 1002){
            result.put("DJLYMC","??????");
            result.put("MODEL","PreEk.jasper");
        }
        return result;
    }

    /**
     * @name: getCfPringParameters
     * @description: ?????????????????? ??????
     * @param req
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @date: 2020/8/26 10:29
     * @auther: ?????????
     *
     */
    private Map<String, Object> getCfPringParameters(CfPrintReq req, SysUser user){
        //????????????????????????
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("cfsb", req.getCfsb());
        List<Map<String, Object>> list = opCf01Dao.getCfPringParameters(parameters);

        if(list == null || list.isEmpty()){
            throw BaseException.create("ERROR_DCTWORK_OP_0042");
        }
        //????????????????????????
        Map<String, Object> result = list.get(0);


        String DPY = result.get("DPY")+"";
        String MXB = result.get("MXB")+"";
        Date birth = (Date)result.get("BRNL");//????????????????????????????????????
        if(birth != null) {
            int nowYear = new Date().getYear();
            result.put("BRNL", nowYear - birth.getYear());
            Calendar birthday=Calendar.getInstance();
            birthday.setTime(birth);
            Calendar now = Calendar.getInstance();
            int day = now.get(Calendar.DAY_OF_MONTH) - birthday.get(Calendar.DAY_OF_MONTH);
            int month = now.get(Calendar.MONTH) - birthday.get(Calendar.MONTH);
            int year = now.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
            //????????????????????????day??????????????????month????????????month??????????????????year????????????year?????????
            if(day<0){
                month -= 1;
                now.add(Calendar.MONTH, -1);//??????????????????????????????????????????????????????
                day = day + now.getActualMaximum(Calendar.DAY_OF_MONTH);
            }
            if(month<0){
                month = (month+12)%12;
                year--;
            }
            result.put("Y", year);
            result.put("M", month);
            result.put("D", day);
        }

        Date kfrq = (Date)result.get("KFRQ");
        if(kfrq!=null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy???MM???dd???");
            result.put("KFRQ", sdf.format(kfrq));
        }

        String BRID = result.get("BRID")==null ? "" : String.valueOf(result.get("BRID"));

        String MZHM = result.get("MZHM")==null ? null : String.valueOf(result.get("MZHM"));
        if(MZHM==null || "".equals(MZHM)) {
            MZHM = req.getJzkh();
            result.put("MZHM",MZHM);
        }

        //??????????????????
        String title = "";
        DicYljgOut yljg = dicYljgOutSer.getById(user.getHospitalId());
        if (yljg != null){
            title = yljg.getHospitalName();
        }
        //ReturnEntity<String> hospitalRet = new ReturnEntity<>();
        //hospitalRet.setData(user.getHospitalName());
        //String title = null;
//        if(hospitalRet.getData() != null){
//            title = hospitalRet.getData();
//        }
        result.put("title", title);
        result.put("title2", "?????????");
        Integer JGID = user.getHospitalId();
        String VIPBRXZ = sysXtcsCacheSer.getCsz(JGID, BUHISSystemArgument.VIPBRXZ);//??????VIP
        String[] VIPBRXZS =  VIPBRXZ.split(",");
        Boolean isVIP = false;//?????????VIP??????
        for (int i=0;i<VIPBRXZS.length;i++) {
            if(VIPBRXZS[i].toString().equals(result.get("BRXZ").toString())){
                isVIP=true;
            }
        }
        List<Map<String, Object>> cfList = opCf02Dao.queryPspbYpxhHjjeTsypZfblByCfsb(parameters);
        int tsyp = 0;
        int PSPB = 0;
        double je = 0 ;
        for (Map<String, Object> map : cfList) {
            if((map.get("PSPB")+"").equals("1")||(map.get("PSPB")+"").equals("2")){
                PSPB = 1;
            }
            if(isVIP){
                je += Double.parseDouble(map.get("HJJE") + "")*Double.parseDouble(map.get("ZFBL") + "");
            }else{
                je += Double.parseDouble(map.get("HJJE") + "");
            }
        }

        result.put("HJJE", String.format("%.2f", je));
        if(PSPB==0){
            result.put("skinTest", "????????????");
        }else{

            List<OpCf02> pslist = opCf02Dao.findByEntity(parameters);
            boolean isPslist = false;
            String ps_psjg = "";
            for (OpCf02 cf02 : pslist) {
                if((cf02.getPsjg()!=null)&&(cf02.getPsjg().toString()!=null) && false == cf02.getPsjg().toString().equals("0")){
                    isPslist = true;
                    ps_psjg=cf02.getPsjg()+"";
                    break;
                }
            }
            if(isPslist){
                if(ps_psjg.equals("-1")){
                    result.put("skinTest", "??????");
                }
                if(ps_psjg.equals("1")){
                    result.put("skinTest", "??????");
                }
            }
            else{
                result.put("skinTest", "????????????");
            }
        }
        Map<String, Object> zdparameters = new HashMap<String, Object>();
        if (result.get("JZXH") != null && result.get("JZXH") != "") {
            zdparameters.put("jzxh", Long.parseLong(result.get("JZXH") + ""));
        } else {
            zdparameters.put("jzxh", 0L);
        }
        StringBuffer sb = new StringBuffer("");
        String str = "";
        List<OpBrzd> zdlist = opBrzdDao.findByEntity(zdparameters);
        for (int i = 0; i < zdlist.size(); i++) {
            sb.append(zdlist.get(i).getZdmc());
            if (i + 1 != zdlist.size()) {
                sb.append(" ");
            }
        }
        if (sb.length() > 35) {
            str = sb.substring(0, 35);
            str = str + "...";
        } else {
            str = sb.toString();
        }
        result.put("JBMC", str);

        OpCf01 djlyMap = opCf01Dao.getById(req.getCfsb());
        String TSCF =  djlyMap !=null ? djlyMap.getTscf()+"" : "";
        String DJLYMC =  "3".equals(TSCF) ?  "???" : "";
        result.put("DJLYMC", DJLYMC);

        if("1".equals(DPY)){
            result.put("DJLYMC", "???");	//?????????
        }

        result.put("DJLYMC2", "");	//?????????
        if("1".equals(MXB)){
            result.put("DJLYMC", "?????????");	//?????????
            if("1".equals(DPY)){
                result.put("DJLYMC2", "???");	//?????????
            }
        }
        result.put("review", "");//?????????
        return result;
    }

    /**
     * ????????????????????????
     * @param cfsb
     * @return
     */
    public CfPrintResponse getCfPrintData(Integer cfsb,SysUser sysUser){
        if (cfsb == null){
            return null;
        }

        //????????????????????????????????????
        CfPrintResponse printData = opCf01Dao.getCfPrintData(cfsb);
        if (printData == null){
            throw BaseException.create("ERROR_DCTWORK_OP_0065");
        }

        //????????????
        if (printData.getCsrq() != null){
            Map<String, Object> personAge = MzUtil.getPersonAge(printData.getCsrq(), new Date());
            printData.setHznl(personAge.get("ages").toString());
        }
        //??????????????????
        //needTransForm(printData);

        //??????????????????
        boolean sfwzsd = sfwzsd(cfsb);
        if (sfwzsd){
            printData.setSfzsd("1");
        }else {
            printData.setSfzsd("0");
        }

        //??????????????????
        pdCflx(printData,cfsb,sysUser);

        //??????????????????
        String psjg = printData.getPsjg();
        if (StrUtil.isBlank(psjg)){
            printData.setPsjg("");
        }else {
            if (psjg.contains("3")){
                printData.setPsjg(StatusEnum.Psjg.YANGX.getVal());
            }else if (psjg.contains("2")){
                printData.setPsjg(StatusEnum.Psjg.YINX.getVal());
            }else{
                printData.setPsjg("");
            }
        }

        //????????????lx=3????????????????????????????????????
        if (String.valueOf(StatusEnum.OpCflx.CY.getCode()).equals(printData.getLx()) && printData.getDjybz() == 1){
            OpYjcf02 djf = opYjcf02Ser.getDjf(cfsb, sysUser.getHospitalId());
            if (djf != null){
                printData.setDjfdj(djf.getYldj()!= null?String.valueOf(djf.getYldj()):"");
                printData.setDjfzje(djf.getHjje()!= null?String.valueOf(djf.getHjje()):"");
            }
        }
        //??????????????????
        List<DrugDetailResponse> details = opCf02Dao.drugDetail(cfsb);
        if (CollUtil.isEmpty(details)){
            throw BaseException.create("ERROR_DCTWORK_OP_0066");
        }
        printData.setCfList(details);
        return printData;
    }

    /**
     * ??????????????????????????????
     * @param printData
     */
//    private void needTransForm(CfPrintResponse printData){
//        String sfzmmc = printData.getSfzmmc();
//        DicGbsj02Model model = new DicGbsj02Model();
//        //model.setPrimarydataId(StatusEnum.Djzt);
//        //dicGbsj02Service.queryDataValueList();
//
//    }

    /**
     * ??????????????????????????????
     * @param cfsb
     * @return
     */
    private boolean sfwzsd(Integer cfsb){
        //????????????????????????????????????
        List<YpyfResponse> sfwzsd = opCf01Dao.sfwzsd(cfsb);
        if (CollUtil.isEmpty(sfwzsd)){
            return false;
        }

        for (YpyfResponse re:sfwzsd){
            if (re == null || StrUtil.isBlank(re.getXmlb()) || !"3".equals(re.getXmlb())){
                return false;
            }

            if (StrUtil.isBlank(re.getKpdy()) || !"1".equals(re.getKpdy())){
                return false;
            }
        }

        return true;
    }

    /**
     * ??????????????????
     *
     * @param cfsb
     */
    private void pdCflx(CfPrintResponse printData,Integer cfsb,SysUser sysUser){
        printData.setCflx(StatusEnum.Cflx.PT.getCode());
        //?????????????????? 0 ?????? 1?????? 2????????? 3?????? 4?????? 5?????? 6????????? 7????????? 8???????????? 9???????????? 10???????????? 11????????? 12???????????? 13???????????? 15????????????
        //??????????????????????????? ,????????????????????????????????????????????????
        //????????????
//        String cfdyje = sysXtcsCacheSer.getByJGIdAndCsmc(sysUser.getHospitalId(), StatusEnum.Xtcs.CFDYJE.getCode()).getCsz();
//        List<String> cfdyjeData = Arrays.stream(cfdyje.split(",")).collect(Collectors.toList());
//        int jeCf = opCf01Dao.getAppointTypeCf(cfsb, cfdyjeData);
//        //int jeCf = opCf01Dao.getJeCf(cfsb);
//        if (jeCf > 0){
//            printData.setCflx(StatusEnum.Cflx.JE.getCode());
//        }

        //??????????????????
        String cfdymjy = sysXtcsCacheSer.getByJGIdAndCsmc(sysUser.getHospitalId(), StatusEnum.Xtcs.CFDYMJY.getCode()).getCsz();
        List<String> cfdymjyData = Arrays.stream(cfdymjy.split(",")).collect(Collectors.toList());
        int mjyCf = opCf01Dao.getAppointTypeCf(cfsb, cfdymjyData);
        //int mjyCf = opCf01Dao.getMjyCf(cfsb);
        if (mjyCf > 0){
            printData.setCflx(StatusEnum.Cflx.MJY.getCode());
        }

        //?????????????????????????????????
        Integer sfekks = opGhmxDao.sfekks(printData.getGhks());
        if (sfekks > 0){
            printData.setCflx(StatusEnum.Cflx.EK.getCode());
        }
    }

    /**
     * @name: saveKjywsqly
     * @description: ??????????????????????????????
     * @param saveKjywsqlyReqList
     * @return: void
     * @date: 2020/10/30 10:01
     * @auther: ?????????
     *
     */
    public void saveKjywsqly(List<SaveKjywsqlyReq> saveKjywsqlyReqList) {
        for(SaveKjywsqlyReq req : saveKjywsqlyReqList){
            opCf02Dao.updateKjywsqly(req);
        }
    }


    /**
     * ????????????????????????????????????????????????
     * @param jzlsh
     */
    public MphisYspInfoResponse getMeetingMsg(String jzlsh){
        //???????????????????????????redis????????????id???Meeting:'jzlsh'???
        //String value = redisFactory.getValue("InternetMeetingId:" + jzlsh);

        //????????????????????????????????????
        MphisYspInfoResponse response = opCf01Dao.getNameByjzlsh(jzlsh);
        return response;
    }

    /**
     * ?????????????????????????????????????????????ID???Redis
     * @param jzlsh
     * @param meetingId
     */
    public void saveMeetingIdToRedis(String jzlsh,String meetingId){
        redisFactory.setKey("InternetMeetingId:"+jzlsh,meetingId);
    }

    /**
     * ?????????????????????????????????id
     * @param jzlsh
     * @param meetingId
     */
    public String selectMeetingIdToRedis(String jzlsh){
        return redisFactory.getValue("InternetMeetingId:" + jzlsh);
    }

    /**
     * ????????????????????????Redis????????????Id
     * @param meetingId
     */
    public void destoryMeetingIdInRedis(String jzlsh){
        redisFactory.delete("InternetMeetingId:"+jzlsh);
    }

    /**
     * ???????????????????????????????????????
     * @param jzlsh
     */
    public List<MphisCfxqmxResponse> getCfTextMessage(String jzlsh,String cfh){
        if (StrUtil.isBlank(jzlsh)){
            return null;
        }

        List<MphisCfxqmxResponse> responses = opCf02Dao.queryCfDetail(jzlsh, cfh);
        return responses;
    }

    /**
     * ???????????????????????????????????????
     * @param jzlsh
     * @return
     */
    public List<String> getCfhListByJzlsh(String jzlsh){
        return opCf01Dao.getCfhListByJzlsh(jzlsh);
    }
}
