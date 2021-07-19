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
 * 门诊_门诊处方表<br>
 * @author 老花生
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
     * 查询处方明细
     * @param cfsb  处方识别码
     * @return
     */
    public List<PatientPrescriptionDetailsResp> queryPrescriptionDetails(Integer cfsb){
        List<Integer> cfsbs = new ArrayList<>();
        cfsbs.add(cfsb);
        return opCf01Dao.queryPrescriptionDetails(cfsbs);
    }

    /**
     * 查询处方列表
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
     * 保存处方
     * @param req   请求对象
     */
    @Transactional(rollbackFor=Exception.class)
    public Integer save(MsCfSaveReq req, SysUser user) {
        //-2.判断处方是否已经收费
        checkCfIsFee(req.getOldCfsb());

        //-1.抗菌药物判定
        checkKjyw(req, user);

        //0.如果明细空，删除cf01、cf02表数据（无明细保存情况）
        if(req.getCf02List() == null || req.getCf02List().size() == 0){
            if(req.getOldCfsb() != null){//有cfsb的集合
                opCf01Dao.deleteById(req.getOldCfsb());//删除cf01
                opCf02Dao.deleteByCfsb(req.getOldCfsb());//删除cf02
                deleteCfps(req.getOldCfsb());//删除皮试项目
                deleteDjf(req.getOldCfsb());//删除原有的代煎费
                opCfdbrDao.deleteByCfsb(req.getOldCfsb());//删除经办人数据
                deleteFreezeYp(req.getOldCfsb(),user.getHospitalId());
                //drugService.frozenYpkc(req.getOldCfsb(), null);//删除冻结库存（无需判断冻结方式，因为处方未收费）
                return req.getOldCfsb();
            }else{//无cfsb的集合，新集合返回一个新的处方id
                return redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CF01);
            }
        }else{
            if (req.getOldCfsb() != null){
                opCf01Dao.deleteById(req.getOldCfsb());//删除cf01
                opCf02Dao.deleteByCfsb(req.getOldCfsb());//删除cf02
                opCfdbrDao.deleteByCfsb(req.getOldCfsb());//删除经办人数据
                deleteFreezeYp(req.getOldCfsb(),user.getHospitalId());//释放库存
            }
        }

        //1.判断库存
        checkYpkc(req, user.getHospitalId());

        //2.新增和更新cf01
        OpCf01 cf01 = saveCf01(req, user);

        //3.新增和更新cf02
        List<OpCf02> retCf02List = saveCf02(req, cf01, user);

        //4.冻结药品库存
        freezeYp(req, cf01.getCfsb(), user.getHospitalId(), retCf02List);

        //5.保存皮试信息bjhzs
        saveCfps(req, user, cf01);

        //6.对于草药方 处置中添加代煎费
        saveDjf(req,user,cf01);

        //7.医保智能提醒
        ThreadUtil.execAsync(()->{
            logger.info("【保存处方】调用医保智能提醒开始");
            try {
                ybtspostService.bccf(req.getJzlsh(),cf01.getCfsb(),user.getHospitalId(),req.getIp());
            }catch (Exception e){
                logger.error("【保存处方】调用医保智能提醒失败:",e);
            }
            logger.info("【保存处方】调用医保智能提醒结束");
        });
        return cf01.getCfsb();
    }

    /**
     * 保存代煎费
     * @param req
     * @param user
     * @param cf01
     */
    private void saveDjf(MsCfSaveReq req,SysUser user,OpCf01 cf01){
        //删除原有的代煎费
        deleteDjf(req.getOldCfsb());

        if (req.getDjybz() != null && req.getDjybz() == 1 && req.getCflx().equals(StatusEnum.OpCflx.CY.getCode())){
            //1.查询代煎费
            String mzdjf = sysXtcsCacheSer.getByJGIdAndCsmc(user.getHospitalId(), StatusEnum.Xtcs.MZJYF.getCode()).getCsz();//代煎费
            if (StrUtil.isBlank(mzdjf)){
                throw BaseException.create("ERROR_DCTWORK_OP_0073");
            }
            //2.查询代煎项目
            FeeYlsfxmDetailResponse djfxm = feeYlsfxmDao.getYlsfxmByFyxh(user.getHospitalId(), Integer.valueOf(mzdjf));
            if (djfxm == null){
                throw BaseException.create("ERROR_DCTWORK_OP_0074");
            }
            //3.保存yjcf01
            Integer maxYjzh = opYjcf02Service.getMaxYjzh(req.getJzlsh(), user.getHospitalId());//获取最大的医技组号
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
            yj01Save.setXmlx(StatusEnum.Xmlx.CY.getCode());//费用来源(草药方)
            yj01Save.setDjly(StatusEnum.Djly.YSKD.getCode());//单据来源
            yj01Save.setJzlsh(req.getJzlsh());
            yj01Save.setFjlb(StatusEnum.Fjlb.CFDJF.getCode());//附加类别  3处方代煎费
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
            yj02Save.setYjzx(0);//医技主项
            yj02Save.setYldj(djfxm.getFydj());
            yj02Save.setYlsl(new BigDecimal(req.getCfts()));
            //计算总金额
            if (djfxm.getFydj() != null && req.getCfts() != null){
                BigDecimal zje = djfxm.getFydj().multiply(new BigDecimal(req.getCfts())).setScale(2, RoundingMode.HALF_UP);
                yj02Save.setHjje(zje);
            }
            yj02Save.setFygb(djfxm.getFygb());
            yj02Save.setZfbl(BigDecimal.ONE);
            yj02Save.setDzbl(BigDecimal.ONE);
            yj02Save.setYjzh(maxYjzh);//医技组号
            yj02Save.setDjzt(StatusEnum.Djzt.ZC.getCode());
            yj02Save.setZxpb(0);//执行判别
            yj02Save.setJzlsh(req.getJzlsh());
            opYjcf02Dao.insert(yj02Save);
        }
    }

    /**
     * 删除代煎费
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
            //删除op_yjcf01
            opYjcf01Dao.deleteById(yj01.getYjxh());
            //删除op_yjcf02
            opYjcf01Dao.deleteByYjxh(ParamUtil.instance().put("yjxh", yj01.getYjxh()));
        }
    }

    /**
     * 判断处方是否已经收费
     * @param cfsb
     */
    private void checkCfIsFee(Integer cfsb){
        if (cfsb != null){
            OpCf01 opCf01 = opCf01Dao.getById(cfsb);
            //判断fphm是否存在以及zfpb（作废判别）是否不为1【当zfpb为1时 其他状态均无效】
            if (opCf01 != null && StrUtil.isNotBlank(opCf01.getFphm()) && opCf01.getZfpb() != 1){
                throw BaseException.create("ERROR_DCTWORK_OP_0061");
            }
        }
    }

    /**
     * 抗菌药物判断
     * @param req
     * @param user
     */
    public void checkKjyw(MsCfSaveReq req,SysUser user){
        //查询抗菌药物规则
        AmqcKjywsycs kjywsycs = amqcKjywsycsService.getSycsById(user.getHospitalId());
        if (kjywsycs == null) {
            return;
        }
        if (CollUtil.isNotEmpty(req.getCf02List())){
            req.getCf02List().stream().forEach(o ->{
                //如果药品是抗生素 需要查询抗生素申请，并且已经审核【1 是抗生素 0或null不是抗生素】
                if ("1".equals(o.getKsbz())){
                    //判定医生是否具有开抗生素权限
                    judgeDoctorOpenKjyw(o,req.getJzxh(),user,kjywsycs);
                }
            });
        }
    }

    /**
     * 判断医生的抗生素权限和药品的抗生素权限是否匹配
     */
    private void judgeDoctorOpenKjyw(OpCf02SaveReq req,Integer jzxh,SysUser user,AmqcKjywsycs kjywsycs){
        //查询药品的抗生素等级

        DrugsTypkDetailResp drug = drugsTypkOutSer.getDrugsTypkById(req.getYpxh());
        if (drug == null){
            throw BaseException.create("ERROR_DCTWORK_OP_0056");
        }
        //如果药品不是抗生素 就直接不执行下面操作
        if (drug.getKsbz() != 1){
            return;
        }
        //A.判断门诊是否可以开抗生素
        if (kjywsycs.getMzsfyxsykjyw() != 1){
            throw BaseException.create("ERROR_DCTWORK_OP_0051", new String[]{StrUtil.isBlank(req.getFymc())?"":req.getFymc()});
        }
        //B.判断药物是否为特殊级（门诊不允许开特殊级）
        if (drug.getKssdj() != null && drug.getKssdj() == 3){
            //当抗生素等级为特殊级时需要判断门诊是否能开特殊级
            if (kjywsycs.getMzsfyxsykjyw() != 1){
                throw BaseException.create("ERROR_DCTWORK_OP_0058");
            }
        }
        //C.查询医生的抗生素权限
        HrPersonnelModel personnel = hrPersonnelSer.getPersonnelById(user.getUserId());
        if (personnel == null){
            throw BaseException.create("ERROR_DCTWORK_OP_0054");
        }
        //C1.当前医生没有抗生素权限(1有抗生素权限 0或null没有抗生素权限)
        if (!"1".equals(personnel.getAntibioticright())){
            //需要发起申请
            judgeSpipping(req,jzxh,kjywsycs);
        }else{
            //C2.医生有抗生素权限，判断是否满足抗生素开具条件(医生是否具有开当前药的抗生素等级)
            if (drug.getKssdj() != null && (StrUtil.isBlank(personnel.getAntibioticlevel()) || !personnel.getAntibioticlevel().contains(String.valueOf(drug.getKssdj())))){
                //需要发起申请
                judgeSpipping(req,jzxh,kjywsycs);
            }else {
                //判断开具天数是否超过门诊最大使用天数
                if (req.getYyts() != null && req.getYyts() != 0 && req.getYyts() > kjywsycs.getMzyxsyzdts()){
                    //需要发起申请
                    judgeOverDay(req,jzxh,kjywsycs);
                }
            }
        }
    }

    /**
     * 超天数使用抗菌药物申请
     * @param req
     * @param jzxh
     * @param kjywsycs
     */
    private void judgeOverDay(OpCf02SaveReq req,Integer jzxh,AmqcKjywsycs kjywsycs){
        judgeOpCfkjyw(req,jzxh,kjywsycs,1);
    }

    /**
     * 越级使用抗菌药物申请
     * @param req
     * @param jzxh
     * @param kjywsycs
     */
    private void judgeSpipping(OpCf02SaveReq req,Integer jzxh,AmqcKjywsycs kjywsycs){
        judgeOpCfkjyw(req,jzxh,kjywsycs,2);
    }

    /**
     * 抗菌药物申请判断
     * @param req
     * @param jzxh
     * @param kjywsycs
     * @param type  1 超门诊最大天数 2越级使用
     */
    private void judgeOpCfkjyw(OpCf02SaveReq req,Integer jzxh,AmqcKjywsycs kjywsycs,Integer type){
        //查询抗菌药物申请
        OpCfKjywsqjlResp opCfKjywsqjlResp = opCfKjywsqjlService.queryCfKjywjl(req.getYpxh(), jzxh);
        if (opCfKjywsqjlResp == null){
            if (type == 1){
                throw BaseException.create("ERROR_DCTWORK_OP_0052",new String[]{StrUtil.isBlank(req.getFymc())?"":req.getFymc(),String.valueOf(kjywsycs.getMzyxsyzdts())});
            }else {
                throw BaseException.create("ERROR_DCTWORK_OP_0060",new String[]{StrUtil.isBlank(req.getFymc())?"":req.getFymc()});
            }
        }
        //判断申请是否已经审核通过
        if (opCfKjywsqjlResp.getZt() == 0 || opCfKjywsqjlResp.getZt() == 4){
            throw BaseException.create("ERROR_DCTWORK_OP_0053",new String[]{StrUtil.isBlank(req.getFymc())?"":req.getFymc()});
        }
        //使用天数不能超过申请天数
        if (req.getYyts() != null && req.getYyts() != 0 && req.getYyts() > opCfKjywsqjlResp.getTs()){
            throw BaseException.create("ERROR_DCTWORK_OP_0059",new String[]{StrUtil.isBlank(req.getFymc())?"":req.getFymc()});
        }
    }

    /**
     * 删除皮试项目
     * @param cfsb
     */
    private void  deleteCfps(Integer cfsb){
        if(null == cfsb){
            return;
        }
        //删除已经保存的皮试项目
//        ParamUtil param = ParamUtil.instance().put("cfsb", cfsb).put("fjlb",2);
//        List<OpYjcf01> yj01List = opYjcf01Dao.findByEntity(param);
        List<OpYjcf01> yj01List = opYjcf01Dao.getCfFjxm(cfsb, StatusEnum.Fjlb.CFPSXM.getCode());
        if (CollUtil.isEmpty(yj01List)){
            return;
        }
        for(OpYjcf01 yj01 : yj01List){
            //删除op_yjcf01
            opYjcf01Dao.deleteById(yj01.getYjxh());
            //删除op_yjcf02
            opYjcf01Dao.deleteByYjxh(ParamUtil.instance().put("yjxh", yj01.getYjxh()));
        }
    }

    /**
     * 保存皮试信息
     * @param req
     * @param user
     * @param cf01
     */
    private void saveCfps(MsCfSaveReq req, SysUser user, OpCf01 cf01) {
        //删除原有的皮试项目
        deleteCfps(req.getOldCfsb());
        Integer maxYjzh = opYjcf02Ser.getMaxYjzh(req.getJzlsh(), user.getHospitalId());//获取最大医技组号
        //保存
        OpYjcf01 yj01Save = null;
        if (CollUtil.isNotEmpty(req.getCfpsList())){
            for (OpCfpsReq yjxx : req.getCfpsList()) {
                if (yj01Save == null) {
                    //保存yj01和yj02
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
                    yj01Save.setFjlb(2);//作为附加项目的区分
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

//    //保存附加项目
//    private void saveFjxm(MsCfSaveReq req, SysUser user, OpCf01 cf01) {
//        // 保存附加项目
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

    //保存cf02
    private List<OpCf02> saveCf02(MsCfSaveReq req, OpCf01 cf01, SysUser user) {
        List<OpCf02> retCf02List = new ArrayList<>();
        //删除处方明细（好像多此一举 在主方法中已经做过判断）
        if(req.getOldCfsb() != null && req.getOldCfsb().intValue() > 0){
            OpCf02 cf02 = new OpCf02();
            cf02.setCfsb(req.getOldCfsb());
            opCf02Dao.deleteByCfsb(req.getOldCfsb());
        }

        List<OpCf02SaveReq> cf02List = req.getCf02List();

        //处方完整性判断 暂未做放前端判断 后期如果需要可以添加

        BigDecimal totalPrice = BigDecimal.ZERO;//计算单张处方的总金额
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
            cf02.setPsjg(cf02Req.getPsjg());// 2020/12/11 皮试结果更改为界面获取
            //保存处方明细
            opCf02Dao.insert(cf02);

            retCf02List.add(cf02);

            BigDecimal decimal = hjje.multiply(cf02.getZfbl());
            totalPrice = totalPrice.add(decimal);
        }

        //判断处方是否为麻，精一处方，如果是需要处理代办人数据
        saveCfDbr(req,cf01,user);

        //单张处方最大限额判断
        if (req.getCflx().equals(StatusEnum.OpCflx.CY.getCode())){
            String cyzdxe = sysXtcsCacheSer.getByJGIdAndCsmc(user.getHospitalId(), StatusEnum.Xtcs.MZDZCFZDXECY.getCode()).getCsz();
            if (StrUtil.isBlank(cyzdxe)){
                logger.error("处方最大限额未设置");
            }else {
                BigDecimal zdxe = new BigDecimal(cyzdxe);
                if (totalPrice.compareTo(zdxe) == 1){
                    throw BaseException.create("ERROR_DCTWORK_OP_0077",new String[]{cyzdxe});
                }
            }
        }else {
            String xyzdxe = sysXtcsCacheSer.getByJGIdAndCsmc(user.getHospitalId(), StatusEnum.Xtcs.MZDZCFZDXEXY.getCode()).getCsz();
            if (StrUtil.isBlank(xyzdxe)){
                logger.error("处方最大限额未设置");
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
     * 保存处方代办人
     * @param req
     * @param cf01
     * @param user
     */
    private void saveCfDbr(MsCfSaveReq req, OpCf01 cf01, SysUser user){
        String cfdymjy = sysXtcsCacheSer.getByJGIdAndCsmc(user.getHospitalId(), StatusEnum.Xtcs.CFDYMJY.getCode()).getCsz();
        List<String> cfdymjyData = Arrays.stream(cfdymjy.split(",")).collect(Collectors.toList());

        //处方药品序号集合
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
            logger.info("当前处方的药品中没有包含麻精一的药品或者无代办人，无需保存代办人信息");
        }
    }

    //保存cf01
    private OpCf01 saveCf01(MsCfSaveReq req, SysUser user) {

        //获取上级发药机构和上级发药药房
        String sjjg = null;//上级发药机构
        Integer sjyf = null;//上级发药药房
        PharBaseInfoReq yflb = new PharBaseInfoReq();
        yflb.setYfsb(req.getYfsb());
        List<PharBaseInfoResp> retYflb = pharBaseConfigService.findByEntity(yflb);
        if(!retYflb.isEmpty()){
            //上级发药机构
            sjjg = retYflb.get(0).getSjjg();
            //上级发药药房
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
        cf01.setFwblsh(ObjectToTypes.parseString(req.getZtbh()));// 新增保存爱心卡套餐组套编号，表中字段FWBLSH
        cf01.setDjybz(req.getDjybz()==null ? 0:req.getDjybz());// 给代煎药默认值0
        cf01.setJzlsh(req.getJzlsh());
        opCf01Dao.insert(cf01);

        return cf01;
    }

    //校验药品库存
    private void checkYpkc(MsCfSaveReq req, Integer jgid) {
        for(OpCf02SaveReq cf02Req: req.getCf02List()) {
            OpCf02 cf02 = BeanUtil.toBean(cf02Req, OpCf02.class);
            if(cf02.getZfyp() != null && cf02.getZfyp() != 1){//自付药品不判断库存
                // 判断库存是否足够
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
     * 删除处方时释放冻结库存
     * @param cfsb
     * @param jgid
     */
    private void deleteFreezeYp(Integer cfsb,Integer jgid){
        int sfqyyfyfy = 0;// 是否启用库存冻结
        int mzkcdjsj = 0;// 库存冻结时间
        SysXtcs sfqyyfyfyXtcs = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, BUHISSystemArgument.SFQYYFYFY);
        if(sfqyyfyfyXtcs != null){
            sfqyyfyfy = ObjectToTypes.toInt(sfqyyfyfyXtcs.getCsz());
        }
        SysXtcs mzkcdjsjXtcs = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, BUHISSystemArgument.MZKCDJSJ);
        if(mzkcdjsjXtcs != null){
            mzkcdjsj = ObjectToTypes.toInt(mzkcdjsjXtcs.getCsz());
        }
//        // 是否启用药房预发药,0是不启用,1启用(是否启用库存冻结)
//        int sfqyyfyfy = 0;
//        String sfqyyfyfy1 = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, "SFQYYFYFY").getCsz();
//        if (StrUtil.isBlank(sfqyyfyfy1)){
//            logger.error("未设置药房预发药，这里默认为1:不启用");
//        }
//        sfqyyfyfy = Integer.parseInt(sfqyyfyfy1);
//
//        // 门诊库存冻结时间 1是开单,2是收费(库存冻结时间)
//        int mzkcdjsj = 1;
//        String mzkcdjsj1 = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, "MZKCDJSJ").getCsz();
//        if (StrUtil.isBlank(mzkcdjsj1)){
//            logger.error("未设置门诊库存冻结时间，这里默认为1:开单时冻结");
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

    //冻结药品库存
    private void freezeYp(MsCfSaveReq req, Integer cfsb, Integer jgid, List<OpCf02> retCf02List) {
        int sfqyyfyfy = 0;// 是否启用库存冻结
        int mzkcdjsj = 0;// 库存冻结时间
        SysXtcs sfqyyfyfyXtcs = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, BUHISSystemArgument.SFQYYFYFY);
        if(sfqyyfyfyXtcs != null){
            sfqyyfyfy = ObjectToTypes.toInt(sfqyyfyfyXtcs.getCsz());
        }
        SysXtcs mzkcdjsjXtcs = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, BUHISSystemArgument.MZKCDJSJ);
        if(mzkcdjsjXtcs != null){
            mzkcdjsj = ObjectToTypes.toInt(mzkcdjsjXtcs.getCsz());
        }
//        // 是否启用药房预发药,0是不启用,1启用(是否启用库存冻结)
//        int sfqyyfyfy = 0;
//        String sfqyyfyfy1 = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, "SFQYYFYFY").getCsz();
//        if (StrUtil.isBlank(sfqyyfyfy1)){
//            logger.error("未设置药房预发药，这里默认为1:不启用");
//        }
//        sfqyyfyfy = Integer.parseInt(sfqyyfyfy1);
//
//        // 门诊库存冻结时间 1是开单,2是收费(库存冻结时间)
//        int mzkcdjsj = 1;
//        String mzkcdjsj1 = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, "MZKCDJSJ").getCsz();
//        if (StrUtil.isBlank(mzkcdjsj1)){
//            logger.error("未设置门诊库存冻结时间，这里默认为1:开单时冻结");
//        }
//        mzkcdjsj = Integer.parseInt(mzkcdjsj1);

        // 如果启用库存冻结,并且在开单时冻结
        if (sfqyyfyfy == 1 && mzkcdjsj == 1) {
            List<PharKcdjReq> datas = new ArrayList();
            for (OpCf02 cf02: retCf02List) {
                //如果是自备药品（zfyp=1）不冻结
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
     * 获取处方录入模块公共信息参数
     * @param userId
     * @return
     */
    public LoadOutClinicInitParamsResp loadOutClinicInitParams(Integer userId) {
        HrPersonnelModel person = hrPersonnelSer.getPersonnelById(userId);
        LoadOutClinicInitParamsResp resp = new LoadOutClinicInitParamsResp();
        resp.setKcfq(person.getPrescriberight());//开处方权
        resp.setMzyq(person.getNarcoticright());//麻醉
        resp.setKssqx(person.getAntibioticlevel());//抗生素
        resp.setKjsy(person.getPsychotropicright());//精神
        resp.setYgxm(person.getPersonname());
        return resp;
    }

    /**
     * 载入附加项目
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
     * 检验处方拷贝信息
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

            if (meds.size() > 0) {// 取第一条记录
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

                // 获取组套中药品自负比例和库存数量
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
     * 校验库存信息
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
        if (kczl == null || kczl.compareTo(BigDecimal.ZERO) == 0){//当库存总量为空或者库存为0时返回
            resp.setKczl(BigDecimal.ZERO);
            resp.setSign(-1);
            return resp;
        }

        int sfqyyfyfy = 0;// 是否启用库存冻结
        SysXtcs sfqyyfyfyXtcs = sysXtcsCacheSer.getByJGIdAndCsmc(hospitalId, BUHISSystemArgument.SFQYYFYFY);
        if(sfqyyfyfyXtcs != null){
            sfqyyfyfy = ObjectToTypes.toInt(sfqyyfyfyXtcs.getCsz());
        }

        // 库存冻结代码
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
                kczl = kczl.subtract(kczl_new);//库存总量等于库存量-冻结的量
            }
        }
        // 库存冻结代码结束
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
     * 获取医保药品信息
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
     * 根据系统参数限制每张处方明细条数
     * @param user
     * @return
     */
    public SystemArgumentCfmxslResp querySystemArgumentCfmxsl(SysUser user) {
        SystemArgumentCfmxslResp resp = new SystemArgumentCfmxslResp();
        Integer jgid = user.getHospitalId();// 用户的机构ID
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
     * 查询全部药品
     * @param user
     * @return
     */
    public PageInfo<QueryCfypxxResp> queryCfAllYpxx(QueryCfypxxReq req, SysUser user) {
        QueryCfypxxReq queryCfypxxReq = new QueryCfypxxReq();
        queryCfypxxReq.setJgid(user.getHospitalId());
        //判断是否显示全部药品，0全部显示，1显示有库存药品(MZCFYPSFQBXS)
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
     * 根据组套载入组套明细信息
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
            //给前端展示颜色重新排序
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

                    if (meds.size() > 0) {// 取第一条记录
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
                        //zt_med.put("ypyf", zt_med.get("sypc"));(原程序，感觉错误)

                        // 获取组套中药品自负比例和库存数量
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
     * 根据药品序号获取药品信息（助手方式）
     * @param req
     * @return
     */
    public LoadMedcineInfoResp loadMedcineInfo(LoadMedcineInfoReq req) {
        Integer ypxh = req.getYpxh();
        // 发药药房 和 药品类别
        Integer pharmacyId = req.getPharmacyId();
        String tabId = req.getTabId();
        // 药品产地选择方式,库存序号
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


        if (meds.size() > 0) {// 多产地取第一条记录
            Map<String, Object> zt_med = meds.get(0);
            if ("clinicCommon".equals(tabId)) {
                zt_med.putAll(med);
            }
            // 获取组套中药品自负比例和库存数量
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
     * 删除处方
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

        // 删除附加信息
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

        // 删除皮试信息
        //ysMzPsjlDao.removeByEntity(params);

        //删除处方信息
        //opCf02Dao.removeByEntity(params);
        opCf02Dao.deleteByCfsb(cfsb);
        opCf01Dao.deleteById(cfsb);

        // 库存冻结代码
        int sfqyyfyfy = 0;// 是否启用库存冻结
        int mzkcdjsj = 0;// 库存冻结时间
        SysXtcs sfqyyfyfyXtcs = sysXtcsCacheSer.getByJGIdAndCsmc(hospitalId, BUHISSystemArgument.SFQYYFYFY);
        if(sfqyyfyfyXtcs != null){
            sfqyyfyfy = ObjectToTypes.toInt(sfqyyfyfyXtcs.getCsz());
        }
        SysXtcs mzkcdjsjXtcs = sysXtcsCacheSer.getByJGIdAndCsmc(hospitalId, BUHISSystemArgument.MZKCDJSJ);
        if(mzkcdjsjXtcs != null){
            mzkcdjsj = ObjectToTypes.toInt(mzkcdjsjXtcs.getCsz());
        }

        if (sfqyyfyfy == 1 && mzkcdjsj == 1) {// 如果启用库存冻结,并且在开单时冻结
            // 先删除过期的冻结库存
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
//     * 查询附加项目信息
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
//     * 获取药品皮试历史信息
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
     * @description: 处方打印
     * @param req
     * @param response
     * @return: void
     * @date: 2020/8/26 10:24
     * @auther: 老花生
     *
     */
    public String cfPrint(CfPrintReq req, SysUser user, HttpServletResponse response) {
        //String jasperName = "ReportForPrescriptionDetail.jasper";
        //Map<String, Object> params = getCfPringParameters(req, user);

        //改造的代码（未测试）
        Map<String, Object> params = getPrintData(req, user);
        String model = (String)params.get("MODEL");
        List<Map<String, Object>> list = getCfPringFields(req);
      // String url = exportFileSer.reportHtml(list, params, model);
        iReportExportFileSer.reportHtmlForStream(list, params, "jrxml/"+model, response);
        return "";
    }

    /**
     * @name: getCfPringFields
     * @description: 获取处方打印 列
     * @param req
     * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @date: 2020/8/26 10:28
     * @auther: 老花生
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
     * 处方打印数据
     * @param req
     * @param user
     * @return
     */
    private Map<String, Object> getPrintData(CfPrintReq req, SysUser user){
        //查询处方主表数据
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("cfsb", req.getCfsb());
        List<Map<String, Object>> list = opCf01Dao.getPrintData(parameters);
        if(list == null || list.isEmpty()){
            throw BaseException.create("ERROR_DCTWORK_OP_0042");
        }
        //构建处方打印参数
        Map<String, Object> result = list.get(0);

        //病人年龄
        Date csny = (Date)result.get("CSNY");
        if (csny != null){
            Map<String, Object> agMap = MzUtil.getPersonAge(csny, null);
            result.put("BRNL",agMap.get("ages").toString());
            result.put("BRNLDES",agMap.get("ages").toString());
        }

        //判断皮试结果
        String psjg = (String)result.get("PSJG");
        if (StrUtil.isBlank(psjg)){
            result.put("skinTest","无需皮试");
        }else {
            if (psjg.contains("3")){
                result.put("skinTest","阳性");
            }else if (psjg.contains("2")){
                result.put("skinTest","阴性");
            }else{
                result.put("skinTest","无需皮试");
            }
        }

        //判断处方类型（精二按药品类型，儿科按科室）
        result.put("DJLYMC","普");
        result.put("MODEL","PreNormal.jasper");
        int jeCf = opCf01Dao.getJeCf(req.getCfsb());
        if (jeCf > 0){
            result.put("DJLYMC","精二");
            result.put("MODEL","PreJe.jasper");
        }

        //判断科室类型是否为儿科  1002  todo 儿科判定更改
        Long KSID = (Long) result.get("KSID");
        if (KSID != null && KSID == 1002){
            result.put("DJLYMC","儿科");
            result.put("MODEL","PreEk.jasper");
        }
        return result;
    }

    /**
     * @name: getCfPringParameters
     * @description: 获取处方打印 熟悉
     * @param req
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @date: 2020/8/26 10:29
     * @auther: 老花生
     *
     */
    private Map<String, Object> getCfPringParameters(CfPrintReq req, SysUser user){
        //查询处方主表数据
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("cfsb", req.getCfsb());
        List<Map<String, Object>> list = opCf01Dao.getCfPringParameters(parameters);

        if(list == null || list.isEmpty()){
            throw BaseException.create("ERROR_DCTWORK_OP_0042");
        }
        //构建处方打印参数
        Map<String, Object> result = list.get(0);


        String DPY = result.get("DPY")+"";
        String MXB = result.get("MXB")+"";
        Date birth = (Date)result.get("BRNL");//将年份年龄修改为数字年龄
        if(birth != null) {
            int nowYear = new Date().getYear();
            result.put("BRNL", nowYear - birth.getYear());
            Calendar birthday=Calendar.getInstance();
            birthday.setTime(birth);
            Calendar now = Calendar.getInstance();
            int day = now.get(Calendar.DAY_OF_MONTH) - birthday.get(Calendar.DAY_OF_MONTH);
            int month = now.get(Calendar.MONTH) - birthday.get(Calendar.MONTH);
            int year = now.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
            //按照减法原理，先day相减，不够向month借；然后month相减，不够向year借；最后year相减。
            if(day<0){
                month -= 1;
                now.add(Calendar.MONTH, -1);//得到上一个月，用来得到上个月的天数。
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
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
            result.put("KFRQ", sdf.format(kfrq));
        }

        String BRID = result.get("BRID")==null ? "" : String.valueOf(result.get("BRID"));

        String MZHM = result.get("MZHM")==null ? null : String.valueOf(result.get("MZHM"));
        if(MZHM==null || "".equals(MZHM)) {
            MZHM = req.getJzkh();
            result.put("MZHM",MZHM);
        }

        //查询机构名称
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
        result.put("title2", "处方笺");
        Integer JGID = user.getHospitalId();
        String VIPBRXZ = sysXtcsCacheSer.getCsz(JGID, BUHISSystemArgument.VIPBRXZ);//获取VIP
        String[] VIPBRXZS =  VIPBRXZ.split(",");
        Boolean isVIP = false;//是否是VIP病人
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
            result.put("skinTest", "无需皮试");
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
                    result.put("skinTest", "阴性");
                }
                if(ps_psjg.equals("1")){
                    result.put("skinTest", "阳性");
                }
            }
            else{
                result.put("skinTest", "无需皮试");
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
        String DJLYMC =  "3".equals(TSCF) ?  "延" : "";
        result.put("DJLYMC", DJLYMC);

        if("1".equals(DPY)){
            result.put("DJLYMC", "代");	//代配药
        }

        result.put("DJLYMC2", "");	//代配药
        if("1".equals(MXB)){
            result.put("DJLYMC", "慢性病");	//代配药
            if("1".equals(DPY)){
                result.put("DJLYMC2", "代");	//代配药
            }
        }
        result.put("review", "");//审核人
        return result;
    }

    /**
     * 组装处方打印数据
     * @param cfsb
     * @return
     */
    public CfPrintResponse getCfPrintData(Integer cfsb,SysUser sysUser){
        if (cfsb == null){
            return null;
        }

        //查询处方打印基本信息数据
        CfPrintResponse printData = opCf01Dao.getCfPrintData(cfsb);
        if (printData == null){
            throw BaseException.create("ERROR_DCTWORK_OP_0065");
        }

        //计算年龄
        if (printData.getCsrq() != null){
            Map<String, Object> personAge = MzUtil.getPersonAge(printData.getCsrq(), new Date());
            printData.setHznl(personAge.get("ages").toString());
        }
        //必要字段翻译
        //needTransForm(printData);

        //是否为注射单
        boolean sfwzsd = sfwzsd(cfsb);
        if (sfwzsd){
            printData.setSfzsd("1");
        }else {
            printData.setSfzsd("0");
        }

        //判断处方类型
        pdCflx(printData,cfsb,sysUser);

        //处理皮试结果
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

        //当类型（lx=3）时，查询是否存在代煎费
        if (String.valueOf(StatusEnum.OpCflx.CY.getCode()).equals(printData.getLx()) && printData.getDjybz() == 1){
            OpYjcf02 djf = opYjcf02Ser.getDjf(cfsb, sysUser.getHospitalId());
            if (djf != null){
                printData.setDjfdj(djf.getYldj()!= null?String.valueOf(djf.getYldj()):"");
                printData.setDjfzje(djf.getHjje()!= null?String.valueOf(djf.getHjje()):"");
            }
        }
        //查询处方详情
        List<DrugDetailResponse> details = opCf02Dao.drugDetail(cfsb);
        if (CollUtil.isEmpty(details)){
            throw BaseException.create("ERROR_DCTWORK_OP_0066");
        }
        printData.setCfList(details);
        return printData;
    }

    /**
     * 处方打印必要字段翻译
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
     * 判断处方是否为注射单
     * @param cfsb
     * @return
     */
    private boolean sfwzsd(Integer cfsb){
        //判断当前处方是否为注射单
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
     * 判断处方类型
     *
     * @param cfsb
     */
    private void pdCflx(CfPrintResponse printData,Integer cfsb,SysUser sysUser){
        printData.setCflx(StatusEnum.Cflx.PT.getCode());
        //指定药品字典 0 普通 1麻醉 2精神一 3剧毒 4危险 5花试 6胰岛素 7精神二 8二类精神 9抗菌药物 10血液制剂 11抗肿瘤 12肠外营养 13高危药品 15高价药品
        //判断处方类型（精二 ,麻、精一按药品类型，儿科按科室）
        //判断精二
//        String cfdyje = sysXtcsCacheSer.getByJGIdAndCsmc(sysUser.getHospitalId(), StatusEnum.Xtcs.CFDYJE.getCode()).getCsz();
//        List<String> cfdyjeData = Arrays.stream(cfdyje.split(",")).collect(Collectors.toList());
//        int jeCf = opCf01Dao.getAppointTypeCf(cfsb, cfdyjeData);
//        //int jeCf = opCf01Dao.getJeCf(cfsb);
//        if (jeCf > 0){
//            printData.setCflx(StatusEnum.Cflx.JE.getCode());
//        }

        //判断麻、精一
        String cfdymjy = sysXtcsCacheSer.getByJGIdAndCsmc(sysUser.getHospitalId(), StatusEnum.Xtcs.CFDYMJY.getCode()).getCsz();
        List<String> cfdymjyData = Arrays.stream(cfdymjy.split(",")).collect(Collectors.toList());
        int mjyCf = opCf01Dao.getAppointTypeCf(cfsb, cfdymjyData);
        //int mjyCf = opCf01Dao.getMjyCf(cfsb);
        if (mjyCf > 0){
            printData.setCflx(StatusEnum.Cflx.MJY.getCode());
        }

        //判断科室类型是否为儿科
        Integer sfekks = opGhmxDao.sfekks(printData.getGhks());
        if (sfekks > 0){
            printData.setCflx(StatusEnum.Cflx.EK.getCode());
        }
    }

    /**
     * @name: saveKjywsqly
     * @description: 保存抗菌药物申请理由
     * @param saveKjywsqlyReqList
     * @return: void
     * @date: 2020/10/30 10:01
     * @auther: 老花生
     *
     */
    public void saveKjywsqly(List<SaveKjywsqlyReq> saveKjywsqlyReqList) {
        for(SaveKjywsqlyReq req : saveKjywsqlyReqList){
            opCf02Dao.updateKjywsqly(req);
        }
    }


    /**
     * 【互联网医院】获取音视频会话信息
     * @param jzlsh
     */
    public MphisYspInfoResponse getMeetingMsg(String jzlsh){
        //通过就诊流水号获取redis中的会议id（Meeting:'jzlsh'）
        //String value = redisFactory.getValue("InternetMeetingId:" + jzlsh);

        //获取医生的环信账号和密码
        MphisYspInfoResponse response = opCf01Dao.getNameByjzlsh(jzlsh);
        return response;
    }

    /**
     * 【互联网医院】发起会议存储会议ID到Redis
     * @param jzlsh
     * @param meetingId
     */
    public void saveMeetingIdToRedis(String jzlsh,String meetingId){
        redisFactory.setKey("InternetMeetingId:"+jzlsh,meetingId);
    }

    /**
     * 【互联网医院】查询会议id
     * @param jzlsh
     * @param meetingId
     */
    public String selectMeetingIdToRedis(String jzlsh){
        return redisFactory.getValue("InternetMeetingId:" + jzlsh);
    }

    /**
     * 【互联网医院】从Redis销毁会议Id
     * @param meetingId
     */
    public void destoryMeetingIdInRedis(String jzlsh){
        redisFactory.delete("InternetMeetingId:"+jzlsh);
    }

    /**
     * 【互联网医院】查询处方信息
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
     * 通过就诊流水号查询处方列表
     * @param jzlsh
     * @return
     */
    public List<String> getCfhListByJzlsh(String jzlsh){
        return opCf01Dao.getCfhListByJzlsh(jzlsh);
    }
}
