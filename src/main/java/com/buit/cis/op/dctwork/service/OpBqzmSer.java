package com.buit.cis.op.dctwork.service;


import com.buit.cis.op.dctwork.request.OpBqzmPageReq;
import com.buit.cis.op.dctwork.response.BqzmPrintResponse;
import com.buit.cis.op.dctwork.response.OpBqzmPageResp;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.commons.dao.OpBqzmDao;
import com.buit.commons.enums.StatusEnum;
import com.buit.commons.model.OpBqzm;
import com.buit.commons.request.OpBqzmSaveReq;
import com.buit.constans.TableName;
import com.buit.system.model.DicKszd;
import com.buit.system.response.HrPersonnelModel;
import com.buit.system.service.DicKszdOutSer;
import com.buit.system.service.ExportFileSer;
import com.buit.system.service.HrPersonnelService;
import com.buit.system.utill.ObjectToTypes;
import com.buit.utill.BeanUtil;
import com.buit.utill.MzUtil;
import com.buit.utill.ParamUtil;
import com.buit.utill.RedisFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 病区证明<br>
 * @author 老花生
 */
@Service
public class OpBqzmSer extends BaseManagerImp<OpBqzm,Integer> {

    static final Logger logger = LoggerFactory.getLogger(OpBqzmSer.class);

    @Autowired
    private OpBqzmDao opBqzmDao;
    @Autowired
    private RedisFactory redisFactory;
    @DubboReference
    private ExportFileSer exportFileSer;
    @Autowired
    private MzUtil bSPHISUtil;
    @DubboReference
    private HrPersonnelService hrPersonnelService;
    @DubboReference
    private DicKszdOutSer dicKszdOutSer;

    @Override
    public OpBqzmDao getEntityMapper(){
        return opBqzmDao;
    }

    /**
     * 查询病情证明单列表
     * @param req
     * @param user
     * @return
     */
    public PageInfo<OpBqzmPageResp> getDiseaseProofList(OpBqzmPageReq req, SysUser user) {
        req.setDjlx(StatusEnum.Djlx.BQZMD.getCode());//病情证明单
        OpBqzm bqzm = BeanUtil.toBean(req, OpBqzm.class);
        bqzm.setJzys(user.getUserId());
        bqzm.setSortColumns("BQID");
        PageInfo<OpBqzmPageResp> pageInfo = PageHelper.startPage(
            req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                    () -> opBqzmDao.findByEntity(bqzm)
            );
        return pageInfo;
    }

    /**
     * 新增病情证明单(更新病情证明单)
     * @param req
     */
    public Integer save(OpBqzmSaveReq req, SysUser user) {
        req.setDjlx(StatusEnum.Djlx.BQZMD.getCode());//病情证明单
        Integer bqid = req.getBqid();
        // 根据主键判断更新还是新增
        if(bqid == null){
            OpBqzm bqzm = BeanUtil.toBean(req, OpBqzm.class);
            bqid = redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_BQZM);
            bqzm.setBqid(bqid);
            bqzm.setJzys(user.getUserId());
            bqzm.setJzlsh(req.getJzlsh());
            bqzm.setKjzmsj(new Timestamp(System.currentTimeMillis()));
            opBqzmDao.insert(bqzm);
        }else{
            OpBqzm bqzm = BeanUtil.toBean(req, OpBqzm.class);
            bqzm.setJzys(user.getUserId());
            opBqzmDao.update(bqzm);
        }

        return bqid;
    }

    /**
     * @name: bqzmdPrint
     * @description: 病情证明单打印
     * @param pkey
     * @param lx
     * @return: java.lang.Object
     * @date: 2020/8/26 19:49
     * @auther: 老花生
     *
     */
    public String bqzmdPrint(Integer pkey, Integer lx, Integer hospitalId) {
        String jasperName = "DiseaseProofForm_MZ.jasper";
        Map<String, Object> params = getBqzmdPringParameters(pkey, lx, hospitalId);
        List<Map<String, Object>> list = new ArrayList<>();
        String url = exportFileSer.reportHtml(params, jasperName);
        return url;
    }

    private Map<String, Object> getBqzmdPringParameters(Integer pkey, Integer lx, Integer hospitalId) {
        Map<String, Object> result = MzUtil.caseInsensitiveMap(opBqzmDao.getById(pkey));

        // 病人性别
        if (result.get("BRXB") != null
                && !result.get("BRXB").toString().equals("")) {
            result.put("BRXB", bSPHISUtil.dictionaryConversion("LS0000000821",
                    ObjectToTypes.parseString(result.get("BRXB"))));

        }
        // 医生
        if (result.get("JZYS") != null
                && !result.get("JZYS").toString().equals("")) {
            HrPersonnelModel hrPersonnel = hrPersonnelService.getPersonnelById(Integer.valueOf(result.get("JZYS").toString()));
            String jzys = "";
            if(hrPersonnel != null ){
            	jzys =hrPersonnel.getPersonname();
			}
            result.put("JZYS", jzys);
        }
        // 科室
        if (result.get("JZKS") != null && !result.get("JZKS").toString().equals("")) {
            if (lx == 1) {
                Map<String, Object> param = ParamUtil.instance().put("organizcode", hospitalId)
                        .put("id", ObjectToTypes.parseInt(result.get("JZKS")));
                DicKszd ret = dicKszdOutSer.getById(ObjectToTypes.parseInt(result.get("JZKS")));
                //List<DicKszd> ret = dicKszdDao.findByEntity(param);
                String jzks = "";
                if(ret != null){
                    jzks = ret.getOfficename();
                }
                result.put("JZKS", jzks);
            } else {
//                result.put(
//                        "JZKS",
//                        DictionaryController.instance()
//                                .get("phis.dictionary.department_zy")
//                                .getText(result.get("JZKS") + ""));
            }

        }
        if ("1".equals(result.get("KSSXW").toString())) {
            result.put("KSSJ", result.get("KSSJ").toString() + "上午");
        } else {
            result.put("KSSJ", result.get("KSSJ").toString() + "下午");
        }
        if ("1".equals(result.get("JSSXW").toString())) {
            result.put("JSSJ", result.get("JSSJ").toString() + "上午");
        } else {
            result.put("JSSJ", result.get("JSSJ").toString() + "下午");
        }
        result.put("XXTS", result.get("XXTS").toString() + "天");

        return result;
    }

    /**
     * 病情证明打印数据
     * @param bqid
     * @return
     */
    public BqzmPrintResponse getBqzmPrintData(Integer bqid){
        if (bqid == null){
            return null;
        }
        BqzmPrintResponse bqzmPrintData = opBqzmDao.getBqzmPrintData(bqid);
        return bqzmPrintData;
    }
}
