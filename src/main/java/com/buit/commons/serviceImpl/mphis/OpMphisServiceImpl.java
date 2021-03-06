package com.buit.commons.serviceImpl.mphis;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.buit.cis.op.dctwork.service.MpUserConsultSer;
import com.buit.cis.op.dctwork.service.MzCfSer;
import com.buit.cis.op.dctwork.service.mkey.DoctorMkeyService;
import com.buit.commons.BaseException;
import com.buit.commons.dao.*;
import com.buit.commons.dto.MphisCfjsDto;
import com.buit.commons.dto.OpYspbZtDto;
import com.buit.commons.enums.MpPsxxZtEnum;
import com.buit.commons.model.*;
import com.buit.commons.request.*;
import com.buit.commons.response.*;
import com.buit.config.MphisConfig;
import com.buit.constans.MqRoutingKeyCst;
import com.buit.constans.TableName;
import com.buit.his.op.reg.enums.FkfsEnum;
import com.buit.his.op.reg.enums.OpPjlxEnum;
import com.buit.his.op.reg.service.OpGhksSer;
import com.buit.his.op.reg.service.OpMzxxSer;
import com.buit.his.op.reg.service.OpYspbSer;
import com.buit.mq.RabbitMqProducer;
import com.buit.op.model.OpGhmx;
import com.buit.op.model.mphis.entity.*;
import com.buit.op.model.mphis.request.*;
import com.buit.op.model.mphis.response.*;
import com.buit.op.request.BatchStatusRequest;
import com.buit.op.response.*;
import com.buit.op.service.mphis.MphisOpService;
import com.buit.op.service.mphis.OpMphisCode;
import com.buit.op.service.mphis.OpMphisProject;
import com.buit.op.service.mphis.OpMphisService;
import com.buit.system.response.HrPersonnelModel;
import com.buit.system.service.HrPersonnelService;
import com.buit.utill.BeanUtil;
import com.buit.utill.MphisUtil;
import com.buit.utill.MzUtil;
import com.buit.utill.RedisFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.curator.shaded.com.google.common.collect.ImmutableMap;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author sunjx
 * @Date 2021-01-14 14:27
 * @Description
 **/
@DubboService(timeout = 10000)
@ConditionalOnProperty(prefix = "mphis.hospital", name = "yljgdm")
public class OpMphisServiceImpl implements OpMphisService {
    static final Logger log = LoggerFactory.getLogger(OpMphisServiceImpl.class);

    @Autowired
    private OpGhksSer opGhksSer;
    @Autowired
    private OpMzxxSer opMzxxSer;
    @Autowired
    private HrPersonnelService hrPersonnelService;
    @Autowired
    private MpiCardDao mpiCardDao;
    @Autowired
    private OpYspbSer opYspbSer;
    @Autowired
    private OpGhmxDao opGhmxDao;
    @Autowired
    private OpYsJzlsDao opYsJzlsDao;
    @Autowired
    private MpiBrdaDao mpiBrdaDao;
    @Autowired
    private RabbitMqProducer rabbitMqProducer;
    @Autowired
    private OpBrzdDao opBrzdDao;
    @Autowired
    private MpHxzhDao mpHxzhDao;
    @Autowired
    private MpPsxxDao mpPsxxDao;

    @Autowired
    private OpCf01Dao opCf01Dao;

    @Autowired
    private OpCf02Dao opCf02Dao;
    @Autowired
    private MpEasemobUserDao mpEasemobUserDao;

    @Autowired
    private MpUserConsultSer mpUserConsultSer;
    @Autowired
    private MpUserConsultDao mpUserConsultDao;
    @Autowired
    private MzCfSer mzCfSer;
    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    private DoctorMkeyService doctorMkeyService;
    @DubboReference
    private MphisOpService mphisOpService;

    @Autowired
    private MphisConfig mphisConfig;
    @Autowired
    private MpBlackListDao mpBlackListDao;

    @Override
    public List<TbDicHospital> yyzd(Integer jgid) {
        return opGhksSer.getEntityMapper().yyzd(jgid);
    }

    @Override
    public List<TbDicDepartment> kszd(Integer jgid) {
        List<TbDicDepartment> tbDicDepartmentList = opGhksSer.getEntityMapper().kszd(jgid);
        tbDicDepartmentList.forEach( o -> {
            o.setCreateUserId(mphisConfig.getYgdm());
            o.setUpdateUserId(mphisConfig.getYgdm());
            o.setYljgdm(mphisConfig.getYljgdm());
            o.setWsjgdm(mphisConfig.getWsjgdm());
        });
        return tbDicDepartmentList;
    }

    @Override
    public List<TbDicPractitioner> ywryzd(Integer jgid) {
        List<TbDicPractitioner> tbDicPractitionerList = opGhksSer.getEntityMapper().ywryzd(jgid);
        tbDicPractitionerList.forEach( o -> {
            o.setCreateUserId(mphisConfig.getYgdm());
            o.setUpdateUserId(mphisConfig.getYgdm());
            o.setYljgdm(mphisConfig.getYljgdm());
            o.setWsjgdm(mphisConfig.getWsjgdm());

            //???????????????CA???????????????????????????????????????????????????
//            String cazsxlh = doctorMkeyService.getCazsxlh(o.getGh());
//            o.setCazsxlm(cazsxlh);
        });
        return tbDicPractitionerList;
    }

    @Override
    public List<TbDicMedicines> ypxx(Integer jgid) {
        List<TbDicMedicines> tbDicMedicinesList = opGhksSer.getEntityMapper().ypxx(jgid);
        tbDicMedicinesList.forEach( o -> {
            o.setCreateUserId(mphisConfig.getYgdm());
            o.setUpdateUserId(mphisConfig.getYgdm());
            o.setYljgdm(mphisConfig.getYljgdm());
            o.setWsjgdm(mphisConfig.getWsjgdm());
        });
        return tbDicMedicinesList;
    }

    @Override
    public List<TbTjHlwyyYwl> ywltj(Integer jgid) {
        List<TbTjHlwyyYwl> tbTjHlwyyYwlList = opGhksSer.getEntityMapper().ywltj(jgid, DateUtil.yesterday());
        tbTjHlwyyYwlList.forEach( o -> {
            o.setCreateUserId(mphisConfig.getYgdm());
            o.setUpdateUserId(mphisConfig.getYgdm());
            o.setYljgdm(mphisConfig.getYljgdm());
            o.setWsjgdm(mphisConfig.getWsjgdm());
        });
        return tbTjHlwyyYwlList;
    }

    @Override
    public List<TbTjHlwyyYwsr> ywsrtj(Integer jgid) {
        List<TbTjHlwyyYwsr> tbTjHlwyyYwsrList = opGhksSer.getEntityMapper().ywsrtj(jgid, DateUtil.yesterday());
        tbTjHlwyyYwsrList.forEach( o -> {
            o.setCreateUserId(mphisConfig.getYgdm());
            o.setUpdateUserId(mphisConfig.getYgdm());
            o.setYljgdm(mphisConfig.getYljgdm());
            o.setWsjgdm(mphisConfig.getWsjgdm());
        });
        return tbTjHlwyyYwsrList;
    }

    @Override
    public List<TbYlHlwyyFwsf> fwsf(Integer jgid) {
        List<TbYlHlwyyFwsf> tbYlHlwyyFwsfList = opGhksSer.getEntityMapper().fwsf(jgid, DateUtil.yesterday());
        tbYlHlwyyFwsfList.forEach( o -> {
            o.setCreateUserId(mphisConfig.getYgdm());
            o.setUpdateUserId(mphisConfig.getYgdm());
            o.setYljgdm(mphisConfig.getYljgdm());
            o.setWsjgdm(mphisConfig.getWsjgdm());
        });
        return tbYlHlwyyFwsfList;
    }

    @Override
    public List<TbYlHlwyyFwsfmx> fwsfmx(Integer jgid) {
        List<TbYlHlwyyFwsfmx> tbYlHlwyyFwsfmxList = opGhksSer.getEntityMapper().fwsfmx(jgid, DateUtil.yesterday());
        tbYlHlwyyFwsfmxList.forEach( o -> {
            o.setCreateUserId(mphisConfig.getYgdm());
            o.setUpdateUserId(mphisConfig.getYgdm());
            o.setYljgdm(mphisConfig.getYljgdm());
            o.setWsjgdm(mphisConfig.getWsjgdm());
        });
        return tbYlHlwyyFwsfmxList;
    }

    @Override
    public List<TbYlDzyzxx> dzyzxx(Integer jgid) {
        List<TbYlDzyzxx> tbYlDzyzxxList = opGhksSer.getEntityMapper().dzyzxx(jgid, DateUtil.yesterday());
        tbYlDzyzxxList.forEach( o -> {
            o.setCreateUserId(mphisConfig.getYgdm());
            o.setUpdateUserId(mphisConfig.getYgdm());
            o.setYljgdm(mphisConfig.getYljgdm());
            o.setWsjgdm(mphisConfig.getWsjgdm());
        });
        return tbYlDzyzxxList;
    }

    @Override
    public List<TbYlDzcfmx> dzcfmx(Integer jgid) {
        List<TbYlDzcfmx> tbYlDzcfmxList = opGhksSer.getEntityMapper().dzcfmx(jgid, DateUtil.yesterday());
        tbYlDzcfmxList.forEach( o -> {
            o.setCreateUserId(mphisConfig.getYgdm());
            o.setUpdateUserId(mphisConfig.getYgdm());
            o.setYljgdm(mphisConfig.getYljgdm());
        });
        return tbYlDzcfmxList;
    }

    @Override
    public List<TbYlGhdxx> ghdxx(Integer jgid) {
        List<TbYlGhdxx> tbYlGhdxxList = opGhksSer.getEntityMapper().ghdxx(jgid, DateUtil.yesterday());
        tbYlGhdxxList.forEach( o -> {
            o.setCreateUserId(mphisConfig.getYgdm());
            o.setUpdateUserId(mphisConfig.getYgdm());
            o.setYljgdm(mphisConfig.getYljgdm());
            o.setWsjgdm(mphisConfig.getWsjgdm());
        });
        return tbYlGhdxxList;
    }

    @Override
    public List<TbYlZxfzjl> zxfzjl(Integer jgid) {
        List<TbYlZxfzjl> tbYlZxfzjlList = opGhksSer.getEntityMapper().zxfzjl(jgid, DateUtil.yesterday());
        tbYlZxfzjlList.forEach( o -> {
            o.setCreateUserId(mphisConfig.getYgdm());
            o.setUpdateUserId(mphisConfig.getYgdm());
            o.setYljgdm(mphisConfig.getYljgdm());
            o.setWsjgdm(mphisConfig.getWsjgdm());
        });
        return tbYlZxfzjlList;
    }

    @Override
    public List<TbYlYppsxx> yppsxx(Integer jgid) {
        List<TbYlYppsxx> tbYlYppsxxList = opGhksSer.getEntityMapper().yppsxx(jgid, DateUtil.yesterday());
        tbYlYppsxxList.forEach( o -> {
            o.setCreateUserId(mphisConfig.getYgdm());
            o.setUpdateUserId(mphisConfig.getYgdm());
            o.setYljgdm(mphisConfig.getYljgdm());
            o.setWsjgdm(mphisConfig.getWsjgdm());
        });
        return tbYlYppsxxList;
    }

    @Override
    public PageInfo<MphisGhksResponse> getGhksList(MphisGhksRequest request) {
        PageInfo<OpGhks> pageInfo = PageHelper.startPage(request.getPageNum(), request.getPageSize())
                .doSelectPageInfo(() -> opGhksSer.getEntityMapper().getInternetGhks(request.getJgid(), request.getKeyword()));
        return new PageInfo<>(MphisUtil.copyListProperties(pageInfo.getList(), MphisGhksResponse::new));
    }

    @Override
    public PageInfo<MphisGhysResponse> getGhysList(MphisGhysRequest request) {
        PageInfo<MphisGhysResponse> pageInfo= PageHelper.startPage(request.getPageNum(), request.getPageSize())
                .doSelectPageInfo(() -> opGhksSer.getEntityMapper().
                        getInternetGhksPersonnel(request.getKsdm(), request.getJgid(), request.getKeyword()));

        List<MphisGhysResponse> mphisGhysResponseList = pageInfo.getList();
        List<Integer> ysdmList =mphisGhysResponseList.stream().map(MphisGhysResponse::getPersonid).collect(Collectors.toList());

        List<OpYspbZtDto> todayPb = opYspbSer.getEntityMapper().countYspbToday(ysdmList);

        List<OpYspbZtDto> futurePb = opYspbSer.getEntityMapper().countYspbFuture(ysdmList);

        mphisGhysResponseList.forEach(o -> {
            o.setWzzt("0");
            todayPb.forEach(t -> {
                if(o.getPersonid().equals(t.getYsdm())){
                    if(t.getCount() > 0){
                        o.setWzzt("1");
                    }
                }
            });

            futurePb.forEach(f -> {
                o.setGhzt("0");
                if(o.getPersonid().equals(f.getYsdm())){
                    if(f.getCount() > 0){
                        o.setGhzt("1");
                    }
                }
            });
        });
        return pageInfo;
    }

    @Override
    public List<MphisGhysResponse> getGhysListByYsdms(List<Integer> ysdms) {
        return opGhksSer.getEntityMapper().getGhysList(ysdms);
    }

    @Override
    public MphisGhysPbResponse getGhysPbList(MphisGhysPbRequest request) {
        OpYspb opYspb = new OpYspb();
        opYspb.setJgid(request.getJgid());
        opYspb.setYsdm(request.getYsdm().toString());
        opYspb.setKsdm(request.getKsdm());
        List<MphisGhysPbDto> mphisGhysPbDtoList = opYspbSer.getEntityMapper().getInternetYspbByCondition(opYspb, request.getPageSize());

        List<OpMphisProjectDto> opMphisProjectList = new ArrayList<>();
        for (OpMphisProject c : OpMphisProject.values()) {
            OpMphisProjectDto opMphisProjectDto = new OpMphisProjectDto();
            opMphisProjectDto.setCode(c.getCode());
            opMphisProjectDto.setName(c.getName());
            opMphisProjectDto.setPrice(c.getPrice());
            opMphisProjectList.add(opMphisProjectDto);
        }
        MphisGhysPbResponse mphisGhysPbResponse = new MphisGhysPbResponse();
        mphisGhysPbResponse.setMphisGhysPbDtoList(mphisGhysPbDtoList);
        mphisGhysPbResponse.setOpMphisProjectList(opMphisProjectList);
        return mphisGhysPbResponse;
    }

    /**
     * ????????????
     * @param request
     * @return
     */
    @Override
    public MphisFzypResponse fzyp(MphisFzypRequest request) {
        MphisFzypResponse response = new MphisFzypResponse();
        if (StrUtil.isBlank(request.getGhks())){
            throw BaseException.create(OpMphisCode.ERROR_HLWYY_0001.getCode());
        }
        if (request.getFzpdsx() == null || request.getFzpdsx() == 0){
            throw BaseException.create(OpMphisCode.ERROR_HLWYY_0002.getCode());
        }
        if (StrUtil.isBlank(request.getJzkh())){
            throw BaseException.create(OpMphisCode.ERROR_HLWYY_0003.getCode());
        }
        //??????n???????????????????????????????????????
        int fzyp = opYsJzlsDao.fzyp(request);
        if (fzyp > 0){
            //????????????
            response.setCode(OpMphisCode.SUCCESS.getCode());
        }else {
            //???????????????
            response.setCode(OpMphisCode.FAIL.getCode());
        }
        return response;
    }

    /**
     * ??????????????????
     * @param request
     * @return
     */
    @Override
    public MphisJzzpdResponse jzzpd(MphisJzzpdRequest request) {
        return opYsJzlsDao.queryJzzt(request.getJzlsh());
    }

    @Override
    public List<MphisGhfyResponse> ghfy(MphisGhfyRequest request) {

        //??????????????????
        OpGhks opGhks = opGhksSer.getEntityMapper().getById(request.getGhks());

        //?????????????????????
        MsQryRegisterReq msQryRegisterReq = new MsQryRegisterReq();
        msQryRegisterReq.setGhje(opGhks.getGhf());
        msQryRegisterReq.setZlje(opGhks.getZlf());
        msQryRegisterReq.setJzkh(request.getJzkh());
        msQryRegisterReq.setKsdm(request.getGhks());
        msQryRegisterReq.setCkje(BigDecimal.ZERO);
        msQryRegisterReq.setBlje(BigDecimal.ZERO);
        //0:????????????
        msQryRegisterReq.setGhlx(0);
        msQryRegisterReq.setSfmf(0);
        msQryRegisterReq.setIsDb(0);
        msQryRegisterReq.setIsGs(0);
        msQryRegisterReq.setFkfs(request.getFkfs());
        msQryRegisterReq.setJgid(opGhks.getJgid());

        //??????????????????
        MpiCard reqMpiCard = new MpiCard();
        reqMpiCard.setCardno(request.getJzkh());
        MpiCard mpiCard = mpiCardDao.getMpiCardInfo(reqMpiCard);
        msQryRegisterReq.setBrxz(mpiCard.getBrxz());


        //????????????
        msQryRegisterReq.setIsYb(isYb(mpiCard.getBrxz()));

        //?????????
        HrPersonnelModel hrPersonnelModel = hrPersonnelService.getPersonnelById(request.getGhys());
        if(Objects.nonNull(hrPersonnelModel) && Objects.nonNull(hrPersonnelModel.getExpertcost())) {
            msQryRegisterReq.setZjje(new BigDecimal(hrPersonnelModel.getExpertcost()));
        }else {
            msQryRegisterReq.setZjje(BigDecimal.ZERO);
        }

        MsQryRegisterResp msQryRegisterResp = opGhksSer.doQueryRegistSettle(msQryRegisterReq, null);

        List<MphisGhfyResponse> mphisGhfyResponseList = new ArrayList<>();

        //????????????
        if(Objects.isNull(request.getWzfs()) || OpMphisProject.GRAPHIC.getCode().equals(request.getWzfs())) {
            mphisGhfyResponseList.add(MphisUtil.resetMphisGhfy(msQryRegisterResp, OpMphisProject.GRAPHIC));
        }
        //????????????
        if(Objects.isNull(request.getWzfs()) || OpMphisProject.VOICE.getCode().equals(request.getWzfs())) {
            mphisGhfyResponseList.add(MphisUtil.resetMphisGhfy(msQryRegisterResp, OpMphisProject.VOICE));
        }
        //????????????
        if(Objects.isNull(request.getWzfs()) || OpMphisProject.VIDEO.getCode().equals(request.getWzfs())) {
            mphisGhfyResponseList.add(MphisUtil.resetMphisGhfy(msQryRegisterResp, OpMphisProject.VIDEO));
        }

        return mphisGhfyResponseList;
    }

    @Override
    public Boolean ghyp(MphisGhypRequest request) throws BaseException{
//        if(opGhksSer.getEntityMapper().checkZyhz(request.getJzkh())){
//            throw BaseException.create("ERROR_REG_0098");
//        }
        try {
            //?????????????????????
            MpiCard reqMpiCard = new MpiCard();
            reqMpiCard.setCardno(request.getJzkh());
            MpiCard mpiCard = mpiCardDao.getMpiCardInfo(reqMpiCard);

            //????????????????????????????????????
            MsRegisterReq msRegisterReq = BeanUtil.toBean(request, MsRegisterReq.class);
            msRegisterReq.setBrid(mpiCard.getBrid());
            msRegisterReq.setKsdm(request.getGhks());
            Date date = new Date(DateTime.of(request.getGhsj(), DatePattern.NORM_DATE_PATTERN).getTime());
            msRegisterReq.setGhsj(date);
            opGhksSer.doCheckGhks(msRegisterReq);
        }catch (BaseException e){
            if("ERROR_REG_0019".equals(e.getCode())){
                throw BaseException.create(OpMphisCode.ERROR_HLWYY_0005.getCode());
            }else if("ERROR_REG_0085".equals(e.getCode())){
                throw BaseException.create(OpMphisCode.ERROR_HLWYY_0006.getCode());
            }
        }
        return true;
    }

    @Override
    public MphisGhResponse gh(MphisGhRequest request) {
        MphisGhResponse mphisGhResponse = new MphisGhResponse();
        try {
            //?????????????????????
            MpiCard reqMpiCard = new MpiCard();
            reqMpiCard.setCardno(request.getJzkh());
            MpiCard mpiCard = mpiCardDao.getMpiCardInfo(reqMpiCard);

            Date date = new Date(DateTime.of(request.getGhsj(), DatePattern.NORM_DATE_PATTERN).getTime());

            //????????????????????????
            MsGhxxReq msGhxxReq = BeanUtil.toBean(request, MsGhxxReq.class);
            msGhxxReq.setCkje(BigDecimal.ZERO);
            msGhxxReq.setBlje(BigDecimal.ZERO);
            msGhxxReq.setYsdm(request.getGhys().toString());
            msGhxxReq.setYybz(0);
            msGhxxReq.setYyxh(1);
            msGhxxReq.setXjje(request.getZfje());
            msGhxxReq.setKsdm(request.getGhks());
            msGhxxReq.setGhlx(0);
            msGhxxReq.setSfmf(0);
            msGhxxReq.setFphm(opGhksSer.getNotesNumberNotIncrement(mphisConfig.getYgdm().intValue(), request.getJgid(), 2));
            msGhxxReq.setGhsj(date);
            msGhxxReq.setGhrq(date);
            msGhxxReq.setGhlb(Integer.parseInt(request.getZblb()));
            msGhxxReq.setBrxz(mpiCard.getBrxz());
            msGhxxReq.setBrid(mpiCard.getBrid());
            OpFkxxReq opFkxxReq = new OpFkxxReq();
            opFkxxReq.setFkfs(FkfsEnum.WX.getKey());
            opFkxxReq.setFkje(msGhxxReq.getXjje());
            msGhxxReq.setFkxxList(Collections.singletonList(opFkxxReq));


            //??????????????????
            OpGhks opGhks = opGhksSer.getEntityMapper().getById(request.getGhks());
            msGhxxReq.setGhje(opGhks.getGhf());
            msGhxxReq.setZlje(opGhks.getZlf());

            //?????????
            HrPersonnelModel hrPersonnelModel = hrPersonnelService.getPersonnelById(request.getGhys());
            if(Objects.nonNull(hrPersonnelModel) && Objects.nonNull(hrPersonnelModel.getExpertcost())){
                msGhxxReq.setZjfy(new BigDecimal(hrPersonnelModel.getExpertcost()));
            }else {
                msGhxxReq.setZjfy(BigDecimal.ZERO);
            }

            MsRegisterAddReq msRegisterAddReq = new MsRegisterAddReq();
            msRegisterAddReq.setJgid(request.getJgid());
            //TODO ????????????
            msRegisterAddReq.setIp(mphisConfig.getYbip());
            msRegisterAddReq.setYgdm(mphisConfig.getYgdm().intValue());
            msRegisterAddReq.setYgxm(mphisConfig.getYgxm());

            msRegisterAddReq.setGhyj(false);
            msRegisterAddReq.setYytag(1);
            msRegisterAddReq.setGhxx(msGhxxReq);
            msRegisterAddReq.setYbxx(new YbGhjs());
            msRegisterAddReq.setGhsj(request.getGhsj());
            //????????????
            msRegisterAddReq.setIsYb(isYb(mpiCard.getBrxz()));

            MsRegisterResp msRegisterResp = opGhksSer.doSaveRegisteredManagement(msRegisterAddReq, true);
            OpGhmx reqOpGhmx = new OpGhmx();
            reqOpGhmx.setSbxh(msRegisterResp.getSbxh());
            OpGhmx opGhmx = opGhmxDao.getByConditions(reqOpGhmx);
            mphisGhResponse.setJzlsh(opGhmx.getJzlsh());
            //???????????????????????????????????????
            MpHxzh mpHxzh = BeanUtil.toBean(request, MpHxzh.class);
            mpHxzh.setWzfs(request.getWzfs());
            mpHxzh.setJzlsh(opGhmx.getJzlsh());
            mpHxzhDao.insert(mpHxzh);
        } catch (ParseException e) {

        }

        return mphisGhResponse;
    }

    @Override
    public MphisGhcxResponse ghcx(MphisGhcxRequest request) {
        OpGhmx opGhmx = BeanUtil.toBean(request, OpGhmx.class);
        opGhmx.setKsdm(request.getGhks());
        return BeanUtil.toBean(opGhmxDao.getByConditions(opGhmx), MphisGhcxResponse.class);
    }

    @Override
    public MphisYspInfoResponse yspInfo(String fzlsh) {
        return mzCfSer.getMeetingMsg(fzlsh);
    }

    @Override
    public MphisYspInfoResponse getEaseMobByUserId(Long userId) {
        MpEasemobUser easeMobUser = mpEasemobUserDao.getEaseMobUserByUserId(Long.valueOf(userId));
        if (easeMobUser == null){
            return  null;
        }
        MphisYspInfoResponse response = new MphisYspInfoResponse();
        response.setDocUserName(easeMobUser.getUsername());
        response.setDocPassWord(easeMobUser.getPassword());
        return response;
    }

    @Override
    public MphisCffyResponse cffy(MphisCffyRequest request) {
        MphisCfjsDto mphisCfjsDto = getCfjsDto(request.getCfh(), request.getJzlsh(), true);
        return BeanUtil.toBean(mphisCfjsDto.getQueryPaymentResp(), MphisCffyResponse.class);
    }

    @Override
    public MphisCfjsResponse cfjs(MphisCfjsRequest request) {
        MphisCfjsDto mphisCfjsDto = getCfjsDto(request.getCfh(), request.getJzlsh(), false);

        MpiCard mpiCard = mphisCfjsDto.getMpiCard();
        OpGhmx opGhmx = mphisCfjsDto.getOpGhmx();
        QueryPaymentResp queryPaymentResp = mphisCfjsDto.getQueryPaymentResp();
        List<QueryDjDetailResp> queryDjDetailRespList = mphisCfjsDto.getQueryDjDetailRespList();

        List<QueryPayReq> queryPayReqList = MphisUtil.copyListProperties(queryDjDetailRespList, QueryPayReq::new);
        DiscountInfoReq discountInfoReq = new DiscountInfoReq();
        discountInfoReq.setList(queryPayReqList);

        //??????????????????
        MpiBrda mpiBrda = mpiBrdaDao.getById(mpiCard.getBrid());
        //??????????????????
        opMzxxSer.doSaveDiscountInfo(discountInfoReq);


        OutpatientSettlementReq outpatientSettlementReq = new OutpatientSettlementReq();
        outpatientSettlementReq.setCardno(mpiCard.getCardno());
        outpatientSettlementReq.setList(queryPayReqList);
        outpatientSettlementReq.setJgid(mpiBrda.getJdjg());

        //????????????
        MzxxReq mzxxReq = BeanUtil.toBean(mpiBrda, MzxxReq.class);
        mzxxReq.setFkfs(1);
        mzxxReq.setGhgl(opGhmx.getSbxh());
        mzxxReq.setGhks(opGhmx.getKsdm());
        mzxxReq.setJjzf(0);
        mzxxReq.setJkje(queryPaymentResp.getYsk());
        mzxxReq.setJmje(queryPaymentResp.getJmje());
        mzxxReq.setJzkh(mpiBrda.getJzkh());
        mzxxReq.setJzlsh(opGhmx.getJzlsh());
        mzxxReq.setLpje(BigDecimal.ZERO);
        mzxxReq.setMpje(BigDecimal.ZERO);
        mzxxReq.setMxsave(false);
        mzxxReq.setFpzs(1);
        mzxxReq.setTzje(BigDecimal.ZERO);
        mzxxReq.setYsdm(Integer.parseInt(opGhmx.getYsdm()));
        mzxxReq.setYsk(queryPaymentResp.getYsk());

        mzxxReq.setZfje(queryPaymentResp.getZfje());
        mzxxReq.setZjje(queryPaymentResp.getZjje());

        OpFkxxReq opFkxxReq = new OpFkxxReq();
        opFkxxReq.setFkfs(FkfsEnum.WX.getKey());
        opFkxxReq.setFkje(mzxxReq.getYsk());
        outpatientSettlementReq.setFkxxList(Collections.singletonList(opFkxxReq));

        //????????????
        List<BrzdResp> brzd = opBrzdDao.getBrzdByJzlsh(opGhmx.getJzlsh());
        Optional<BrzdResp> brzdResp = brzd.stream().filter(o -> o.getZzbz() == 1).findFirst();
        brzdResp.ifPresent(resp -> mzxxReq.setZdxh(resp.getZdxh()));

        outpatientSettlementReq.setMzxxReq(mzxxReq);

        //TODO ????????????
        outpatientSettlementReq.setIp(mphisConfig.getYbip());
        outpatientSettlementReq.setYgdm(mphisConfig.getYgdm().intValue());
        outpatientSettlementReq.setYgxm(mphisConfig.getYgxm());

        //????????????
        outpatientSettlementReq.setIsYb(isYb(mpiBrda.getBrxz()));


        opMzxxSer.doSaveOutpatientSettlement(outpatientSettlementReq);


        queryPayReqList.stream()
                .filter(r->r.getCflx()==1||r.getCflx()==2||r.getCflx()==3)
                .forEach(r->
                        rabbitMqProducer.send(MqRoutingKeyCst.drugsAutoPrintList, ImmutableMap.of("consumerType", "autoPrintListConsumer", "payload", Collections.singletonMap("cfsb", r.getCfsb())))
                );

        List<OpCf01> opCf01List = opCf01Dao.queryCfByCfsbs(request.getCfh(), request.getJzlsh());
        MphisCfjsResponse mphisCfjsResponse = BeanUtil.toBean(opCf01List.get(0), MphisCfjsResponse.class);
        //????????????????????????
        if(Objects.nonNull(mphisCfjsResponse.getFphm())){
            queryPayReqList.forEach(o -> {
                MpPsxx mpPsxx = new MpPsxx();
                mpPsxx.setJgid(opGhmx.getJgid().toString());
                mpPsxx.setBrid(mpiCard.getBrid());
                mpPsxx.setGhks(opGhmx.getKsdm());
                mpPsxx.setJzlsh(opGhmx.getJzlsh());
                mpPsxx.setJzkh(opGhmx.getJzkh());
                mpPsxx.setCfhm(o.getCfhm());
                mpPsxx.setCjsj(DateUtil.date().toTimestamp());
                mpPsxx.setDdh(request.getDdh());
                if("1".equals(request.getPsfs().toString())){
                    mpPsxx.setShr(request.getShr());
                    mpPsxx.setShrdh(request.getShrdh());
                    mpPsxx.setPsdz(request.getPsdz().concat(request.getPsdzxx()));
                    mpPsxx.setPszt("0");
                }
                mpPsxx.setSbxh(o.getSbxh());
                mpPsxx.setPsfs(request.getPsfs().toString());
                mpPsxxDao.insert(mpPsxx);
            });
        }
        return mphisCfjsResponse;
    }

    @Override
    public MphisCfjscxResponse cfjscx(MphisCfjscxRequest request) {
        if(Objects.isNull(request.getCfh())){
            throw BaseException.create(OpMphisCode.ERROR_HLWYY_0011.getCode());
        }
        List<OpCf01> opCf01List = opCf01Dao.queryCfByCfsbs(request.getCfh(), request.getJzlsh());

        return BeanUtil.toBean(opCf01List.get(0), MphisCfjscxResponse.class);

    }

    /**
     * ??????????????????
     * @param request
     * @return
     */
    @Override
    public List<MphisCfxqResponse> cfxq(MphisCfxqRequest request) {
        if (StrUtil.isBlank(request.getJzlsh())){
            throw BaseException.create(OpMphisCode.ERROR_HLWYY_0004.getCode());
        }
        //??????????????????????????????????????????????????????
        List<MphisCfxqResponse> responses = opCf01Dao.queryCfxx(request.getJzlsh(), request.getCfh());
        if (CollUtil.isNotEmpty(responses)){
            responses.stream().forEach(o ->{
                //??????????????????
                List<MphisCfxqmxResponse> details = opCf02Dao.queryCfDetail(o.getFzlsh(), o.getYzbm());
                o.setCfmxs(details);
                o.setHjje(details.stream().map(MphisCfxqmxResponse::getHjje).reduce(BigDecimal.ZERO, BigDecimal::add));
            });
        }
        return responses;
    }

    @Override
    public MphisWlxxResponse wlxx(MphisWlxxRequest request) {
        return null;
    }

    @Override
    @Transactional
    public MphisJzxxjyResponse jzxxjy(MphisJzxxjyRequest request) {
        MphisJzxxjyResponse mphisJzxxjyResponse = new MphisJzxxjyResponse();
        mphisJzxxjyResponse.setResult(false);
        if(mpiCardDao.checkCardInfo(request)){
            mphisJzxxjyResponse.setResult(true);
        }else {
            MpiCard mpiCard = mpiCardDao.getWnCardInfo(request);
            MpiBrda wnJzls = opYsJzlsDao.getWnJzls(request);
            if(Objects.nonNull(request.getSfz())) {
                MpiBrda hisMpiBrda = mpiBrdaDao.getBySfzh(request);
                MpiCard mpiCardReq = new MpiCard();
                mpiCardReq.setCardno(request.getJzkh());
                MpiCard hisMpiCard = mpiCardDao.getMpiCardInfo(mpiCardReq);
                if(Objects.nonNull(wnJzls)) {
                    if(Objects.nonNull(hisMpiCard) && hisMpiCard.getCardno().equals(wnJzls.getJzkh())){
                        throw BaseException.create(OpMphisCode.ERROR_HLWYY_0015.getCode());
                    }
                    MpiCard wnMpiCard = new MpiCard();
                    wnMpiCard.setCardno(request.getJzkh());
                    wnMpiCard.setBrxz(wnJzls.getBrxz());
                    wnMpiCard.setStatus("0");
                    wnMpiCard.setCardtypecode("01");
                    if(Objects.isNull(hisMpiBrda)){
                        insertMpiBrda(wnJzls, request.getJgid());
                        insertMpiCard(wnMpiCard, wnJzls);
                    }else {
                        insertMpiCard(wnMpiCard, hisMpiBrda);
                    }
                    mphisJzxxjyResponse.setResult(true);
                } else {
                    MpiBrda mpiBrda = mpiBrdaDao.getWnBrdaInfo(request);
                    if (Objects.nonNull(mpiBrda) && Objects.nonNull(mpiCard)) {
                        if (mpiBrda.getBrid().equals(mpiCard.getBrid())) {
                            if(Objects.nonNull(hisMpiCard)){
                                throw BaseException.create(OpMphisCode.ERROR_HLWYY_0015.getCode());
                            }
                            if (Objects.isNull(hisMpiBrda)) {
                                insertMpiBrda(mpiBrda, request.getJgid());
                                insertMpiCard(mpiCard, mpiBrda);
                            } else {
                                insertMpiCard(mpiCard, hisMpiBrda);
                            }
                            mphisJzxxjyResponse.setResult(true);
                        }
                    }
                }
            }else if(Objects.nonNull(mpiCard) || Objects.nonNull(wnJzls)){
                mphisJzxxjyResponse.setResult(true);
            }
        }
        return mphisJzxxjyResponse;
    }

    /**
     * ??????????????????????????????
     * @param mphisKszxRequest
     * @return
     */
    @Override
    public MphisKszxResponse kszx(MphisKszxRequest mphisKszxRequest) throws BaseException{
        log.info("??????????????????:{},{},{}",mphisKszxRequest.getZxrid(),mphisKszxRequest.getZxrxm(),mphisKszxRequest.getPhone());
        //??????????????????????????????????????????
        MphisKszxResponse kszx = isKszx(mphisKszxRequest);
        //?????????????????????????????????????????????????????????????????????????????????????????????????????????
        if (kszx != null){
            return kszx;
        }

        //1?????????????????????
        //1.1???????????????????????????
        List<MpEasemobUser> effectiveData = mpEasemobUserDao.getEffectiveData();
        //1.2???????????????????????????
        if (CollUtil.isEmpty(effectiveData)){
            throw BaseException.create(OpMphisCode.ERROR_HLWYY_0007.getCode());
        }
        List<String> userNames = effectiveData.stream().map(o -> o.getUsername()).collect(Collectors.toList());//??????????????????

        //2????????????????????????
        BatchStatusRequest request = new BatchStatusRequest();
        request.setUsernames(userNames);
        EasemobResponse<Object, List<Map<String, String>>> batchstatus = mphisOpService.batchstatus(request);
        List<Map<String, String>> data = batchstatus.getData();

        //3??????????????????????????????
        List<Map<String, String>> online = data.stream().filter(o -> o.containsValue("online")).collect(Collectors.toList());
        if (CollUtil.isEmpty(online)){
            throw BaseException.create(OpMphisCode.ERROR_HLWYY_0008.getCode());
        }

        //4??????????????????????????????
        List<String> onlineUser = online.stream().map(o -> o.keySet().iterator().next()).collect(Collectors.toList());
        //?????????????????????????????????????????????????????????????????????????????????
        List<OnlineConsultCount> counts = mpUserConsultSer.onlineConsultCount(onlineUser);

        OnlineConsultCount consultCount = counts.get(0);//????????????

        //5??????????????????
        MpUserConsult consult = mpUserConsultSer.addConsultCount(consultCount.getUserid(),
                mphisKszxRequest.getZxrid(),mphisKszxRequest.getZxrxm(),mphisKszxRequest.getPhone());

        //6????????????
        MphisKszxResponse response = new MphisKszxResponse();
        response.setKfgh(String.valueOf(consultCount.getUserid()));
        response.setEasemobUserName(consultCount.getUsername());
        response.setZxjlid(String.valueOf(consult.getId()));
        return response;
    }

    @Override
    public ConsultCountResp consultCount(Integer userid) {
        return mpUserConsultDao.consultCount(userid);
    }

    /**
     * ????????????????????????????????????????????????????????????????????????????????????
     * @param mphisKszxRequest
     */
    private MphisKszxResponse isKszx(MphisKszxRequest mphisKszxRequest){
        //??????????????????????????????
        MpUserConsult consult = mpUserConsultDao.selectzxjl(mphisKszxRequest.getZxrid());
        if (consult == null){
            return null;
        }
        //??????????????????????????????
        //1.?????????????????????????????????
        MpEasemobUser easeMobUser = mpEasemobUserDao.getEaseMobUserByUserId(Long.valueOf(consult.getUserid()));
        if (easeMobUser == null){
            log.error("???????????????????????????????????????,????????????id???{}",consult.getUserid());
            throw BaseException.create("ERROR_HLWYY_0012");
        }
        //???????????????????????????
        if (!"true".equals(easeMobUser.getActivated())){
            log.error("????????????????????????????????????,????????????id???{},??????????????????",consult.getUserid());
            throw BaseException.create("ERROR_HLWYY_0009");
        }
        //???????????????????????????
        EasemobResponse<Object, Map<String, String>> status = mphisOpService.status(easeMobUser.getUsername());
        if (status != null){
            Map<String, String> data = status.getData();
            if (data != null && data.containsValue("online")){
                //????????????
                MphisKszxResponse response = new MphisKszxResponse();
                response.setKfgh(String.valueOf(consult.getUserid()));
                response.setEasemobUserName(easeMobUser.getUsername());
                response.setZxjlid(String.valueOf(consult.getId()));
                return response;
            }
        }

        return null;
    }

    /**
     * ??????????????????????????????????????????
     * @param mphisDzfddRequest
     * @return
     */
    @Override
    public PageInfo<MphisDzfddResponse> dzfdd(MphisDzfddRequest mphisDzfddRequest) {
        Dzfdd dzfdd = BeanUtil.toBean(mphisDzfddRequest, Dzfdd.class);

        PageInfo<Dzfdd> pageInfo = PageHelper.startPage(
                mphisDzfddRequest.getPageNo(), mphisDzfddRequest.getPageSize()).doSelectPageInfo(
                () -> opCf01Dao.queryNotCost(dzfdd)
        );
        return BeanUtil.toPage(pageInfo,MphisDzfddResponse.class);
    }

    @Override
    public List<String> yspdlb(Integer ysdm) {
        String value = redisFactory.getValue("waitingList:" + ysdm);
        if (StrUtil.isNotBlank(value)){
            List<String> list = JSONObject.parseArray(value, String.class);
            return list;
        }
        return null;
    }

    @Override
    public List<YsMessageResponse> getYsMessage(List<String> ysdmList) {
        List<YsMessageResponse> responses = opCf01Dao.getysMessage(ysdmList);
        return responses;
    }

    @Override
    public YsMessageResponse getYsMessageByJzlsh(String jzlsh) {
        return opCf01Dao.getYsMessageByJzlsh(jzlsh);
    }

    @Override
    public Boolean th(String jzlsh) {
        OpGhmx reqOpGhmx = new OpGhmx();
        reqOpGhmx.setJzlsh(jzlsh);
        OpGhmx opGhmx = opGhmxDao.getByConditions(reqOpGhmx);

        SaveRetireRegistReq req = new SaveRetireRegistReq();
        req.setJzkh(opGhmx.getJzkh());
        req.setFphm(opGhmx.getZsfphm());
        req.setXzdm(opGhmx.getBrxz());
        req.setSbxh(opGhmx.getSbxh());
        req.setJzlsh(opGhmx.getJzlsh());
        req.setIsYb(isYb(opGhmx.getBrxz()));
        req.setJgid(opGhmx.getJgid());

        //TODO ????????????
        req.setIp(mphisConfig.getYbip());
        req.setYgdm(mphisConfig.getYgdm().intValue());
        req.setYgxm(mphisConfig.getYgxm());

        opMzxxSer.doSaveRetireRegistered(req);
        return true;
    }

    @Override
    public Boolean tf(String fphm, Integer jgid) {
        List<QueryTf01Resp> resp = opMzxxSer.doQueryTf01(fphm, jgid);
        QueryTfFphmResp queryTfFphmResp = opMzxxSer.doQueryTfFphm(fphm, jgid, mphisConfig.getYgdm().intValue());//TODO ygdm????????????

        SaveRefundSettleReq req = new SaveRefundSettleReq();

        req.setFffs(1);//????????????
        SaveRefundSettleMzxxReq saveRefundSettleMzxxReq = BeanUtil.toBean(queryTfFphmResp.getMzxx(), SaveRefundSettleMzxxReq.class);

        List<TfPayTfxxReq> tfxx = MphisUtil.copyListProperties(resp, TfPayTfxxReq::new);
        saveRefundSettleMzxxReq.setTfxx(tfxx);


        req.setMzxx(saveRefundSettleMzxxReq);
        req.setJgid(jgid);
        //TODO ????????????
        req.setYgdm(mphisConfig.getYgdm().intValue());
        req.setIp(mphisConfig.getYbip());
        opMzxxSer.doSaveRefundSettle(req);

        //??????????????????
        List<Integer> cfsbList = resp.stream().map(QueryTf01Resp::getCfsb).collect(Collectors.toList());
        if(CollUtil.isNotEmpty(cfsbList)) {
            MpPsxx mpPsxx = new MpPsxx();
            mpPsxx.setPszt(MpPsxxZtEnum.YQX.getKey());
            mpPsxx.setXgsj(DateUtil.date().toTimestamp());
            mpPsxxDao.updateZtBycfsbList(cfsbList, mpPsxx);
        }

        return true;
    }

    @Override
    public Boolean checkRefund(String parma, String type, Integer jgid) {
        if(Objects.isNull(parma)){
            return false;
        }
        return opGhmxDao.checkRefund(parma, type, jgid);
    }

    @Override
    public MkeyRecord notify(String bizSn, String action, String cert, String signAlg, String signValue, String mkeyUserId, String ret, String msg) {
        return doctorMkeyService.notify(bizSn, action, cert, signAlg, signValue, mkeyUserId, ret, msg);
    }

    /**
     *??????????????????
     * @param jzlsh
     * @return
     */
    @Override
    public List<MphisCfxqmxResponse> getCfTextMessage(String jzlsh,String cfh) {
        return mzCfSer.getCfTextMessage(jzlsh,cfh);
    }

    /**
     * ???????????????????????????????????????
     * @param jzlsh
     * @return
     */
    @Override
    public List<String> getCfhListByJzlsh(String jzlsh) {
        return mzCfSer.getCfhListByJzlsh(jzlsh);
    }

    @Override
    public void qrsh(String fzlsh, List<String> cfhList) {
        List<OpCf01> opCf01List = opCf01Dao.queryCfByCfsbs(cfhList, fzlsh);
        List<Integer> cfsbList = opCf01List.stream().map(OpCf01::getCfsb).collect(Collectors.toList());
        if(CollUtil.isNotEmpty(cfsbList)) {
            MpPsxx mpPsxx = new MpPsxx();
            mpPsxx.setPszt(MpPsxxZtEnum.YQS.getKey());
            mpPsxx.setXgsj(DateUtil.date().toTimestamp());
            mpPsxx.setJssj(DateUtil.date().toString());
            mpPsxxDao.updateZtBycfsbList(cfsbList, mpPsxx);
        }
    }

    @Override
    public Boolean checkBlackList(String sfzh) {
        return mpBlackListDao.checkBlackList(sfzh);
    }

    /**
     * ??????????????????
     * @param jzlsh
     * @return
     */
    @Override
    public List<BrzdResp> getDisnosisList(String jzlsh) {
        return opBrzdDao.getBrzdByJzlsh(jzlsh);
    }

    @Override
    public List<Integer> getXxKsdmList(Integer ksdm) {
        return opGhksSer.getEntityMapper().getXxKsdmList(ksdm);
    }

    @Override
    public void tbBrdaAndCard(MphisTbBrdaAndCardRequest request) {
        MpiBrdaAndCardAddReq mpiBrdaAndCardAddReq = BeanUtil.toBean(request.getMpiBrda(), MpiBrdaAndCardAddReq.class);
        mpiBrdaAndCardAddReq.setYgdm(mphisConfig.getYgdm().intValue());
        mpiBrdaAndCardAddReq.setMpiCardList(MphisUtil.copyListProperties(request.getMpiCardList(), MpiCard::new));
        opGhksSer.doAddPerson(mpiBrdaAndCardAddReq);
    }

    private MphisCfjsDto getCfjsDto(List<String> cfh, String jzlsh, Boolean cx){
        if(Objects.isNull(cfh)){
            throw BaseException.create(OpMphisCode.ERROR_HLWYY_0011.getCode());
        }
        if(Objects.isNull(jzlsh)){
            throw BaseException.create(OpMphisCode.ERROR_HLWYY_0004.getCode());
        }
        List<ZfblReq> zfblReqList = new ArrayList<>();

        List<OpCf01> opCf01List = opCf01Dao.queryCfByCfsbs(cfh, jzlsh);
        opCf01List.forEach( o -> {
            ZfblReq zfblReq =new ZfblReq();
            zfblReq.setBllx(0);
            zfblReq.setCflx(o.getCflx());
            zfblReq.setCfsb(o.getCfsb());
            zfblReqList.add(zfblReq);
        });




        //??????????????????
        OpGhmx reqOpGhmx = new OpGhmx();
        reqOpGhmx.setJzlsh(jzlsh);
        OpGhmx opGhmx = opGhmxDao.getByConditions(reqOpGhmx);

        //?????????????????????
        MpiCard reqMpiCard = new MpiCard();
        reqMpiCard.setCardno(opGhmx.getJzkh());
        MpiCard mpiCard = mpiCardDao.getMpiCardInfo(reqMpiCard);

        //?????????????????????????????????????????????
        if(cx){
            ChangeZfblReq changeZfblReq = new ChangeZfblReq();
            changeZfblReq.setBrxz(mpiCard.getBrxz());
            changeZfblReq.setZfblList(zfblReqList);
            opMzxxSer.doChangeZfbl(changeZfblReq);
        }

        ChangeZfblReq changeZfblReq = new ChangeZfblReq();
        changeZfblReq.setBrxz(mpiCard.getBrxz());
        changeZfblReq.setFpcx("0");
        changeZfblReq.setJgid(opGhmx.getJgid());
        changeZfblReq.setZfblList(zfblReqList);
        List<QueryDjDetailResp> queryDjDetailRespList = opMzxxSer.doQueryDjDetails(changeZfblReq);

        if(queryDjDetailRespList.isEmpty()){
            throw BaseException.create(OpMphisCode.ERROR_HLWYY_0010.getCode());
        }

        List<QueryPayReq> queryPayReqList = MphisUtil.copyListProperties(queryDjDetailRespList, QueryPayReq::new);
        QueryPaymentReq queryPaymentReq = new QueryPaymentReq();
        queryPaymentReq.setBrid(mpiCard.getBrid());
        queryPaymentReq.setBrxz(mpiCard.getBrxz().toString());
        queryPaymentReq.setGhks(opGhmx.getKsdm().toString());
        queryPaymentReq.setJzkh(opGhmx.getJzkh());
        queryPaymentReq.setJgid(opGhmx.getJgid());
        queryPaymentReq.setQueryPayReqList(queryPayReqList);

        //????????????
        queryPaymentReq.setIsYb(isYb(mpiCard.getBrxz()));


        //TODO ????????????
        queryPaymentReq.setYgdm(mphisConfig.getYgdm().intValue());
        queryPaymentReq.setYgxm(mphisConfig.getYgxm());
        queryPaymentReq.setIp(mphisConfig.getYbip());

        QueryPaymentResp queryPaymentResp = opMzxxSer.doQueryPayment(queryPaymentReq);

        MphisCfjsDto mphisCfjsDto = new MphisCfjsDto();
        mphisCfjsDto.setMpiCard(mpiCard);
        mphisCfjsDto.setOpGhmx(opGhmx);
        mphisCfjsDto.setQueryDjDetailRespList(queryDjDetailRespList);
        mphisCfjsDto.setQueryPaymentResp(queryPaymentResp);
        return mphisCfjsDto;
    }

    private Integer isYb(Integer brxz){
        //??????????????????
        return 0;

//        Integer sjxz = opMzxxSer.querySjBrxz(brxz);
//        if(6021 == sjxz){
//           return 1;
//        }else {
//           return 0;
//        }
    }

    private void insertMpiBrda(MpiBrda mpiBrda, Integer jgid){
        mpiBrda.setBrid(redisFactory.getTableKey(TableName.DB_NAME, TableName.MPI_BRDA));
        mpiBrda.setJdr(mphisConfig.getYgdm().toString());
        mpiBrda.setJdsj(DateUtil.date().toTimestamp());
        mpiBrda.setJdjg(jgid);
        mpiBrda.setMzhm(opGhksSer.getNotesNumber(mphisConfig.getYgdm().intValue(), jgid, OpPjlxEnum.DAHM.getKey()));
        mpiBrda.setEmpiid(MzUtil.UUIDGenerator());
        mpiBrdaDao.insert(mpiBrda);
    }

    private void insertMpiCard(MpiCard mpiCard, MpiBrda mpiBrda){
        mpiCard.setCreateuser(mphisConfig.getYgdm().toString());
        mpiCard.setCreatetime(DateUtil.date().toTimestamp());
        mpiCard.setBrid(mpiBrda.getBrid());
        mpiCard.setCreateunit(mpiBrda.getJdjg().toString());
        mpiCard.setCardid(String.valueOf(redisFactory.getTableKey(TableName.DB_NAME, TableName.MPI_CARD)));
        mpiCard.setEmpiid(mpiBrda.getEmpiid());
        mpiCardDao.insert(mpiCard);
    }

}
