package com.buit.cis.op.dctwork.service;


import cn.hutool.core.map.CaseInsensitiveMap;
import cn.hutool.core.util.StrUtil;
import com.buit.cis.op.dctwork.response.OpZydjPageResp;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.commons.dao.MpiBrdaDao;
import com.buit.commons.dao.OpZydjDao;
import com.buit.commons.enums.StatusEnum;
import com.buit.commons.model.OpZydj;
import com.buit.commons.request.OpZydjPageReq;
import com.buit.commons.request.OpZydjSaveReq;
import com.buit.commons.request.OpZydjUpdateReq;
import com.buit.commons.response.RydjPrintDataResponse;
import com.buit.constans.TableName;
import com.buit.file.IReportExportFileSer;
import com.buit.op.request.OpZydjUpdateStatusReq;
import com.buit.op.response.MpiBrda;
import com.buit.op.response.OpZydjResp;
import com.buit.system.model.DicKszd;
import com.buit.system.response.HrPersonnelModel;
import com.buit.system.service.DicKszdOutSer;
import com.buit.system.service.DicXzqhService;
import com.buit.system.service.ExportFileSer;
import com.buit.system.service.HrPersonnelService;
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
import java.sql.Timestamp;
import java.util.*;

/**
 * <br>
 *
 * @author zhouhaisheng
 * 住院病人入院登记
 */
@Service
public class OpZydjSer extends BaseManagerImp<OpZydj, Integer> {

    static final Logger logger = LoggerFactory.getLogger(OpZydjSer.class);

    @Autowired
    private OpZydjDao opZydjDao;
    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    private MpiBrdaDao mpiBrdaDao;
    @DubboReference
    private ExportFileSer exportFileSer;
    @Autowired
    private MzUtil bSPHISUtil;
    @DubboReference
    private HrPersonnelService hrPersonnelService;
    @Autowired
    private MzUtil mzUtil;
    @DubboReference
    private DicKszdOutSer dicKszdOutSer;
    @Autowired
    private IReportExportFileSer iReportExportFileSer;
    @DubboReference
    private DicXzqhService dicXzqhService;

    @Override
    public OpZydjDao getEntityMapper() {
        return opZydjDao;
    }


    public ReturnEntity<String> add() {
        return ReturnEntityUtil.success();
    }

    /**
     * 门诊住院申请列表查询
     *
     * @param cardno
     * @return
     */
    public List<OpZydjResp> findMzzydj(String  cardno,String sqlx) {
        return opZydjDao.findMzzydj(cardno,sqlx);
    }

    /**
     * 查询住院登记单列表
     *
     * @param req
     * @param user
     * @return
     */
    public PageInfo<OpZydjPageResp> getHospitalizedRegisterList(OpZydjPageReq req, SysUser user) {
        Map<String, Object> par = ParamUtil.instance().put("mzys", user.getUserId()).put("mzhm", req.getMzhm())
                .put("sqlx",req.getSqlx()).put("jzlsh",req.getJzlsh());
        PageInfo<OpZydjPageResp> pageInfo = PageHelper.startPage(req.getPageNum(), req.getPageSize())
                .doSelectPageInfo(() -> opZydjDao.getHospitalizedRegisterList(par));
        return pageInfo;
    }

    /**
     * 新增住院登记单
     * @param req
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer saveHosReg(OpZydjSaveReq req) {
        //新增登记单时判断当前就诊是否已经存在有效的住院登记或者留观登记
        judgeIsExit(req.getJzlsh());

        OpZydj zydj = BeanUtil.toBean(req, OpZydj.class);
        zydj.setDjid(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_ZYDJ));
        zydj.setKdrq(new Timestamp(System.currentTimeMillis()));
        zydj.setJzlsh(req.getJzlsh());
        opZydjDao.insert(zydj);

        //需要在这里判断MPI_BRDA中的LXDZ   LXDH   LXRM字段是否存在信息，如果信息不存在，重新插入数据
        //先要根据病人SFZH获得页面上三个字段的信息，判断表中每一个字段信息是否为空
        Integer brid = req.getBrid();
        if(brid != null){
            MpiBrda brda = mpiBrdaDao.getById(brid);
            brda.setLxdz(req.getLxdz());
            brda.setLxdh(req.getLxdh());
            brda.setLxgx(StrUtil.isBlank(req.getLxrgx())?null:Integer.valueOf(req.getLxrgx()));
            brda.setLxrm(req.getLxrm());
            //更新 联系人地址    联系人电话    联系人姓名 联系人关系
            mpiBrdaDao.updateLxdzLxdhLxRm(brda);
        }
        return zydj.getDjid();
    }

    /**
     * 通过就诊流水号判断当前就诊是否重复开了住院/留观登记单
     * @param jzlsh
     */
    private void judgeIsExit(String jzlsh){
        OpZydj zydj = opZydjDao.findZydjByJzlsh(jzlsh);
        if (zydj != null){
            if (StatusEnum.Sqlx.ZYSQ.equals(zydj.getSqlx())){
                throw BaseException.create("ERROR_DCTWORK_OP_0062");
            }else {
                throw BaseException.create("ERROR_DCTWORK_OP_0063");
            }
        }
    }


    /**
     * 修改住院登记单
     * @param req
     */
    public void updateHosReg(OpZydjUpdateReq req) {
        OpZydj zydj = opZydjDao.getById(req.getDjid());
        if(zydj == null){
            throw BaseException.create("ERROR_DCTWORK_OP_00022");
        }
        cn.hutool.core.bean.BeanUtil.copyProperties(req, zydj);
        opZydjDao.update(zydj);
    }

    /**
     * 修改住院登记单状态
     * @param req
     */
    public void updateHosRegStatus(OpZydjUpdateStatusReq req) {
        opZydjDao.updateSqzt(req);
    }

    /**
     * @name: zydjPrint
     * @description: 住院登记打印
     * @param pkey
     * @param response
     * @return: java.lang.String
     * @date: 2020/8/27 15:40
     * @auther: 老花生
     *
     */
    public String zydjPrint(Integer pkey, Integer hospitalId, HttpServletResponse response) {
        String jasperName = "jrxml/HospitalizedRegisterForm.jasper";
        Map<String, Object> params = getZydjPringParameters(pkey, hospitalId);
        List<Map<String, Object>> list = new ArrayList<>();
        //String url = exportFileSer.reportHtml(list, params, jasperName);
        iReportExportFileSer.reportHtmlForStream(list,params,jasperName,response);
        return "url";
    }

    /**
     * 查询入院等打印数据（入院证）
     * @param djid
     */
    public RydjPrintDataResponse getRydjPrintData(Integer djid){
        RydjPrintDataResponse rydjPrintData = opZydjDao.getRydjPrintData(djid);
        if (rydjPrintData == null){
            return null;
        }
        //计算年龄
        if (rydjPrintData.getCsrq() != null){
            Map<String, Object> personAge = MzUtil.getPersonAge(rydjPrintData.getCsrq(), new Date());
            rydjPrintData.setNl(personAge.get("ages").toString());
        }
        //查询患者住址
        rydjPrintData.setZz(getZz(rydjPrintData.getShengbm(),rydjPrintData.getShibm(),rydjPrintData.getXianbm(),rydjPrintData.getXxdz()));

        return rydjPrintData;
    }

    /**
     * 地址
     * @param shengbm
     * @param shibm
     * @param xianbm
     * @param xxdz
     * @return
     */
    private String getZz(Integer shengbm,Integer shibm,Integer xianbm,String xxdz){
        String shengmc = "";
        String shimc = "";
        String xianmc = "";

        if (shengbm != null){
            shengmc = dicXzqhService.getSsxmc(shengbm);
        }
        if (shibm != null){
            shimc = dicXzqhService.getSsxmc(shibm);
        }
        if (xianbm != null){
            xianmc = dicXzqhService.getSsxmc(xianbm);
        }

        StringBuffer buffer = new StringBuffer();
        buffer.append(StrUtil.isBlank(shengmc)?"":shengmc);
        buffer.append(StrUtil.isBlank(shimc)?"":shimc);
        buffer.append(StrUtil.isBlank(xianmc)?"":xianmc);
        buffer.append(StrUtil.isBlank(xxdz)?"":xxdz);

        return buffer.toString();
    }

    private Map<String, Object> getZydjPringParameters(Integer pkey, Integer hospitalId) {
        Map<String, Object> map_par = new HashMap<String, Object>();
        map_par.put("pkey", pkey);

        Map<String, Object> result = new CaseInsensitiveMap(opZydjDao.getPrintInfo(map_par));

        // 病人性别
        if (result.get("BRXB") != null
                && !result.get("BRXB").toString().equals("")) {
            result.put("BRXB", mzUtil.dictionaryConversion("LS0000000821",
                    ObjectToTypes.parseString(result.get("BRXB"))));
        }
        // 医生
        if (result.get("MZYS") != null
                && !result.get("MZYS").toString().equals("")) {
        	String jzys = "";
            HrPersonnelModel hrPersonnel = hrPersonnelService.getPersonnelById(Integer.valueOf(result.get("MZYS").toString()));
			if(hrPersonnel != null ){
				jzys =hrPersonnel.getPersonname();
			}
            result.put("MZYS", jzys);
        }
        // 门诊科室
        if (result.get("MZKS") != null
                && !result.get("MZKS").toString().equals("")) {
//            Map<String, Object> param = ParamUtil.instance().put("organizcode", hospitalId)
//                    .put("id", ObjectToTypes.parseInt(result.get("MZKS")));
            DicKszd ret = dicKszdOutSer.getById(ObjectToTypes.parseInt(result.get("MZKS")));
            //List<DicKszd> ret = dicKszdDao.findByEntity(param);
            String jzks = "";
            if(ret != null){
                jzks = ret.getOfficename();
            }
            result.put("MZKS", jzks);
        }
        // 入院目的
        if (result.get("RYMD") != null
                && !result.get("RYMD").toString().equals("")) {
            result.put("RYMD", bSPHISUtil.dictionaryConversion("PD0000000729",
                    ObjectToTypes.parseString(result.get("RYMD"))));
        }
        // 登记类型
        if (result.get("DJLX") != null
                && !result.get("DJLX").toString().equals("")) {
            result.put("DJLX", bSPHISUtil.dictionaryConversion("PD0000000731",
                    ObjectToTypes.parseString(result.get("DJLX"))));
        }
        // 拟收治病区(住院科室：15)
        if (result.get("NSZBQ") != null
                && !result.get("NSZBQ").toString().equals("")) {
            Map<String, Object> param = ParamUtil.instance().put("organizcode", hospitalId)
                    .put("id", ObjectToTypes.parseInt(result.get("NSZBQ")));
            DicKszd ret = dicKszdOutSer.getById(ObjectToTypes.parseInt(result.get("NSZBQ")));
            //List<DicKszd> ret = dicKszdDao.findByEntity(param);
            String zyks = "";
            if(ret != null){
                zyks = ret.getOfficename();
            }
            result.put("NSZBQ", zyks);
        }

        return result;
    }
}
