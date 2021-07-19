package com.buit.cis.op.dctwork.service;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.buit.apply.service.Cisjcsqd01Service;
import com.buit.apply.service.OpZt02Service;
import com.buit.cis.op.dctwork.request.CzPrintData;
import com.buit.cis.op.dctwork.request.CzPrintRequest;
import com.buit.cis.op.dctwork.request.JySqdReq;
import com.buit.cis.op.dctwork.response.CzDetailResponse;
import com.buit.cis.op.dctwork.response.CzPrintResponse;
import com.buit.cis.op.dctwork.response.YjztDetailResp;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.commons.dao.*;
import com.buit.commons.enums.StatusEnum;
import com.buit.commons.model.CzData;
import com.buit.commons.model.OpBrzd;
import com.buit.commons.request.*;
import com.buit.commons.response.*;
import com.buit.constans.TableName;
import com.buit.file.IReportExportFileSer;
import com.buit.his.treatment.service.TreatmentApplyFormService;
import com.buit.op.model.OpYjcf01;
import com.buit.op.model.OpYjcf02;
import com.buit.op.model.OpYjcf02Zt;
import com.buit.op.request.OpYjcf01Req;
import com.buit.op.request.OpYjcf02Req;
import com.buit.op.service.OpYjcf02Service;
import com.buit.system.model.FeeYlsfxmdjModel;
import com.buit.system.response.DicKszdModel;
import com.buit.system.response.HrPersonnelModel;
import com.buit.system.response.YjQueryPageHelperResp;
import com.buit.system.service.*;
import com.buit.system.utill.MedicineUtils;
import com.buit.system.utill.ObjectToTypes;
import com.buit.utill.*;
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
import java.util.*;
import java.util.stream.Collectors;

/**
 * 门诊_门诊医技单<br>
 *
 * @author 老花生
 */
@SuppressWarnings({"ALL", "AlibabaUndefineMagicConstant"})
@Service
public class MzYjSer extends BaseManagerImp<OpYjcf01, Integer> {

    static final Logger logger = LoggerFactory.getLogger(MzYjSer.class);

    @Autowired
    private OpYjcf01Dao opYjcf01Dao;
    @Autowired
    private OpYjcf02Dao opYjcf02Dao;
    @DubboReference
    private SysXtcsCacheSer sysXtcsCacheSer;
    @Autowired
    private OpGhmxDao opGhmxDao;
    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    private OpYjcf02ZtDao opYj02ZtDao;
    @DubboReference
    private FeeYlsfxmOutSer feeYlsfxmOutSer;
    @Autowired
    private OpSbhyDao opSbhyDao;
    //    @Autowired
//    private CisJcsq01Dao cisJcsq01Dao;
    @DubboReference
    private OpZt02Service opZt02Service;
    //    @Autowired
//    private BSPHISUtil bSPHISUtil;
    @DubboReference
    private FeeYlsfxmdjService feeYlsfxmdjService;
    @Autowired
    MzUtil mzUtil;
    //    @Autowired
//    private ExportFileSer exportFileSer;
//    @Autowired
//    private DicKszdDao dicKszdDao;
//    @Autowired
//    private PubBrxzDao pubBrxzDao;
    @DubboReference
    private HrPersonnelService hrPersonnelService;
    //    @Autowired
//    private DicYljgDao dicYljgDao;
    @Autowired
    private OpBrzdDao opBrzdDao;
    @DubboReference
    private ExportFileSer exportFileSer;
    @DubboReference
    private DicKszdOutSer dicKszdOutSer;
    @DubboReference
    private PubBrxzOutSer pubBrxzOutSer;
    @DubboReference
    private DiccZlsfdzService diccZlsfdzOutSer;
    //    @Autowired
//    private DiccZlsfdzDao diccZlsfdzDao;
    @DubboReference
    private Cisjcsqd01Service cisjcsqd01Service;
    @Autowired
    private IReportExportFileSer iReportExportFileSer;
    @DubboReference
    private TreatmentApplyFormService treatmentApplyFormService;
    @DubboReference
    private OpYjcf02Service opYjcf02Service;

    @Override
    public OpYjcf01Dao getEntityMapper() {
        return opYjcf01Dao;
    }

    /**
     * 保存医技
     *
     * @param yjReq
     * @param user
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer save(OpYjcf01Req yjReq, SysUser user) {
        Integer yjxh = null;
        //已经保存的cf02
        List<OpYjcf02Req> oldList = new ArrayList<>();

        for (OpYjcf02Req yj02Req : yjReq.getBodys()) {

            if (yj02Req.getYjxh() != null && yj02Req.getSbxh() != null) {//更新
                //跳过已收费
                Long l = opYjcf01Dao.getIsSfByYjxh(ParamUtil.instance().put("yjxh", yj02Req.getYjxh()));
                if (l > 0) {
                    continue;
                }

                //更新明细
                OpYjcf02 yj02 = com.buit.utill.BeanUtil.toBean(yj02Req, OpYjcf02.class);
                yj02.setZfpb(0);//作废判别
                opYjcf02Dao.updateyJcf02(yj02);

                Map<String, Object> parameters = new HashMap<String, Object>(16);
                parameters.put("zxks", yj02Req.getZxks());
                parameters.put("ksdm", yj02Req.getKsdm());
                parameters.put("ysdm", user.getUserId());
                parameters.put("yjxh", yj02Req.getYjxh());

                //更新主表
                opYjcf01Dao.updateZxksYsdmKsdm(parameters);// 规定病种
            } else {//新增
                // 新插入的一条上一条做对比 如果相同就是同一组 把上一组的yjxh拿过来用
                for (OpYjcf02Req oldyj02 : oldList) {
                    if (oldyj02.getYjzh() != null && oldyj02.getYjzh().equals(yj02Req.getYjzh())) {
                        yj02Req.setYjxh(oldyj02.getYjxh());// 就设置上一条对应的主表的ID
                    }
                }

                if (yj02Req.getYjxh() == null) {// 如果当前条没有YJXH
                    // 保存主表
                    OpYjcf01 yj01 = new OpYjcf01();
                    yj01.setYjxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJCF01));
                    yj01.setKsdm(yj02Req.getKsdm());
                    yj01.setYsdm(String.valueOf(user.getUserId()));
                    yj01.setKdrq(DateUtil.getCurrentTimestamp());
                    yj01.setZfpb(0);
                    yj01.setZxpb(0);
                    yj01.setCfbz(0);
                    yj01.setDjzt(0);
                    yj01.setJgid(user.getHospitalId());
                    yj01.setZxks(yj02Req.getZxks());
                    yj01.setJzxh(yjReq.getClinicId());
                    yj01.setBrid(yjReq.getBrid());
                    yj01.setBrxm(yjReq.getBrxm());
                    yj01.setDjly(yjReq.getDjly());
                    yj01.setSqwh(ObjectToTypes.parseInt(yj02Req.getSqwh()));
                    yj01.setSssqid(yj02Req.getSssqid());// 保存手术的申请单号
                    yj01.setJzkh(yjReq.getJzkh());
                    yj01.setSqid(yjReq.getSqid());
                    yj01.setJzlsh(yjReq.getJzlsh());
                    yj01.setXmlx(yjReq.getLy());
                    yj01.setSqid(yj01.getYjxh());
                    opYjcf01Dao.insert(yj01);

                    yj02Req.setYjxh(yj01.getYjxh());
                }

                // 接着保存明细
                OpYjcf02 yj02 = BeanUtil.toBean(yj02Req, OpYjcf02.class);
                yj02.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJCF02));
                yj02.setZxzt("0");
                yj02.setZxcs(0);
                yj02.setJgid(user.getHospitalId());
                yj02.setJzlsh(yjReq.getJzlsh());
                yj02.setSqdh(yj02.getSbxh());
                opYjcf02Dao.insert(yj02);
            }

            //把已经保存的记录存下来，相同yjzh的记录yjxh相同
            OpYjcf02Req oldCf02 = new OpYjcf02Req();
            oldCf02.setYjzh(yj02Req.getYjzh());
            oldCf02.setYjxh(yj02Req.getYjxh());
            oldList.add(oldCf02);

            if (yjxh == null) {
                yjxh = yj02Req.getYjxh();
            }
        }
        return yjxh;
    }

    /**
     * 保存校验验证
     *
     * @param opYjcf01 请求对象
     * @param user     登录对象
     */
    @SuppressWarnings("AlibabaUndefineMagicConstant")
    public void saveCheck(CheckProjectMaterialsReq req, SysUser user) {
//        List<Map<String, Object>> bodys = BSPHISUtil.ListObjToMap(req.getBodys());
//
//        int ghgl = ObjectToTypes.parseInt(req.getGhgl());
//        int mzzy = ObjectToTypes.parseInt(req.getMzzy());
//
//
//
//        Integer hospitalId = user.getHospitalId();// 用户的机构ID
//        String jgid = String.valueOf(user.getHospitalId());// 用户的机构ID
//
//        // '物品计费标志'，'0'表示不启用，‘1’表示启用，默认是‘0’
//        int wpjfbz = ObjectToTypes.parseInt(sysXtcsCacheSer.getCsz(hospitalId, "MZWPJFBZ"));
//
//        // '物品计费标志'，'0'表示不启用，‘1’表示启用，默认是‘0’
//        int wpjfbzzy = ObjectToTypes.parseInt(sysXtcsCacheSer.getCsz(hospitalId, "WPJFBZ"));
//
//        // '门诊物资收费项目价格'，'0'表示不启用，‘1’表示启用，默认是‘0’
//        int wzsfxmjg = ObjectToTypes.parseInt(sysXtcsCacheSer.getCsz(hospitalId, "WZSFXMJG"));
//
//        // '住院物资收费项目价格'，'0'表示不启用，‘1’表示启用，默认是‘0’
//        int wzsfxmjgzy = ObjectToTypes.parseInt(sysXtcsCacheSer.getCsz(hospitalId, "WZSFXMJGZY"));
//
//        String hsql = ObjectToTypes.parseString(req.getMzks());// 护士权利。(门诊科室)
//        List<Map<String, Object>> kcpdList = new ArrayList<Map<String, Object>>();
//
//        // 如果是门诊mzzy=0 并且 门诊参数开启，如果是住院 mzzy=1 并且 住院参数开启 才能执行。
//        boolean b1 = false;
//        boolean b2 = false;
//        if(wzsfxmjg == 1 && mzzy == 0 && wpjfbz == 1) {
//            b1 = true;
//        }
//        if(wzsfxmjgzy == 1 && mzzy == 1 && wpjfbzzy == 1){
//            b2 = true;
//        }
//
//        if (b1 || b2) {
//            long ksdm = Long.parseLong(hsql);
//            Map<String, Object> kfxhMap = new HashMap<String, Object>(16);
//            kfxhMap.put("ksdm", ksdm);
//            Map<String, Object> map = wlKfdzDao.findObjByMap(kfxhMap);
//            if (map != null) {
//                int kfxh = Integer.parseInt(map.get("kfxh") + "");
//                for (int i = 0; i < bodys.size(); i++) {
//                    // 门诊中如果项目收完费了 就不判断。
//                    if (bodys.get(i).get("mzxh") != null
//                            && bodys.get(i).get("mzxh") != "") {
//                        continue;
//                    }
//                    if (bodys.get(i).get("sbxh") != null) {
//                        buhisUtil.deleteSupplies(hospitalId, Integer.parseInt(bodys.get(i).get("sbxh")+ ""));
//                    }
//                    if (bodys.get(i).get("jlxh") != null) {
//                        buhisUtil.deleteSuppliesZY(hospitalId, Integer.parseInt(bodys.get(i).get("jlxh")+ ""));
//                    }
//                    String wzmcTs = "";
//                    int fyxh = ObjectToTypes.parseInt(bodys.get(i).get("ylxh"));
//                    int ylsl = ObjectToTypes.parseInt(Math.round(ObjectToTypes.parseDouble(bodys.get(i).get("ylsl"))));// 数量
//                    String fymc = bodys.get(i).get("fymc") + "";
//
//                    Map<String, Object> parMap = new HashMap<String, Object>(16);
//                    parMap.put("fyxh", fyxh);
//                    parMap.put("jgid", jgid);
//                    List<Map<String, Object>> resList = feeXmzxksDao.queryObj(parMap);
//                    for (int j = 0; j < resList.size(); j++) {
//                        Map<String, Object> kcpdMap = new HashMap<String, Object>(16);
//
//                        int wzxh = ObjectToTypes.parseInt(resList.get(j).get("wzxh"));
//                        BigDecimal wzsl = ObjectToTypes.parseBigDecimal(resList.get(j).get("WZSL"));
//                        String wzmc1 = ObjectToTypes.parseString(resList.get(j).get("wzmc"));
//                        parMap.clear();
//                        parMap.put("wzxh", wzxh);
//                        parMap.put("kfxh", kfxh);
//                        List<Map<String, Object>> compList = wlWzkcDao.querySumNum(parMap);
//
//                        if (compList.size() > 0) {
//                            BigDecimal wzslRes = ObjectToTypes.parseBigDecimal(compList.get(0).get("wzsl"));
//                            String ykslS = ObjectToTypes.parseString(compList.get(0).get("yksl"));
//                            BigDecimal ykslRes = BigDecimal.ZERO;
//                            if (ykslS != null) {
//                                ykslRes = ObjectToTypes.parseBigDecimal(compList.get(0).get("yksl"));
//                            }
//                            String wzmc = ObjectToTypes.parseString(compList.get(0).get("wzmc"));
//                            BigDecimal kykc = wzslRes.subtract(ykslRes);
//
//                            if (kykc.compareTo(wzsl.multiply(new BigDecimal(ylsl))) == -1) {
//                                if (wzmcTs.length() == 0) {
//                                    wzmcTs = " " + wzmc;
//                                } else {
//                                    wzmcTs += "," + wzmc;
//                                }
//                            } else {
//                                kcpdMap.put("wzxh", wzxh);
//                                kcpdMap.put("wzsl", wzslRes);
//                                kcpdMap.put("yksl", wzsl.multiply(new BigDecimal(ylsl)));
//                                kcpdMap.put("wzmc", wzmc);
//                                kcpdMap.put("fymc", fymc);
//                                kcpdList.add(kcpdMap);
//                            }
//                        } else {
//                            if (wzmcTs.length() == 0) {
//                                wzmcTs = " " + wzmc1;
//                            } else {
//                                wzmcTs += "," + wzmc1;
//                            }
//                        }
//
//                    }
//                    if (wzmcTs.length() > 0) {
//                        throw new RuntimeException("项目为：" + fymc
//                                + "所对应的的物资名称：" + wzmcTs + "库存不足不能保存!");
//                    }
//                }
//                BigDecimal ykslZ = BigDecimal.ZERO;
//                for (int i = 0; i < kcpdList.size(); i++) {
//                    int wzxh = ObjectToTypes.parseInt(kcpdList.get(i).get("wzxh"));
//                    ykslZ = ObjectToTypes.parseBigDecimal(kcpdList.get(i).get("yksl"));
//                    BigDecimal wzsl = ObjectToTypes.parseBigDecimal(kcpdList.get(i).get("wzsl"));
//                    String wzmc = ObjectToTypes.parseString(kcpdList.get(i).get("wzmc"));
//                    String fymc = ObjectToTypes.parseString(kcpdList.get(i).get("fymc"));
//
//                    for (int j = i + 1; j < kcpdList.size(); j++) {
//                        int wzxhj = ObjectToTypes.parseInt(kcpdList.get(j).get("wzxh"));
//                        if (wzxh == wzxhj) {
//                            fymc += "," + kcpdList.get(j).get("fymc");
//                            ykslZ = ykslZ.add(ObjectToTypes.parseBigDecimal(kcpdList.get(j).get("yksl")));
//                            if (wzsl.compareTo(ykslZ) == -1) {
//                                throw BaseException.create("ERROR_DCTWORK_OP_0007");
//                            } else {
//                                kcpdList.remove(j);
//                                j--;
//                            }
//                        }
//                    }
//                }
//            }else{
//                //throw new RuntimeException("请科室选择药库！");
//                throw BaseException.create("ERROR_DCTWORK_OP_0041");
//            }
//        }
    }

    /**
     * 查询处置列表
     *
     * @param req
     */
    public List<QueryDisposalEntryListResp> queryDisposalEntryList(QueryDisposalEntryListReq req) {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>(); // 返回结果
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        Map<String, Object> query = new HashMap<>(16);
        query.put("brid", req.getBrid());
        query.put("jzxh", req.getJzxh());
        query.put("fjlb", req.getFjlb());
        data = opYjcf02Dao.queryDisposalEntryList(query);

        // 过滤掉是组套的明细数据，显示组套
        Map<String, Object> ZTYZSBXH = new HashMap<String, Object>();
        for (Map<String, Object> record : data) {
            if (record.get("ztbz") != null && record.get("ztbz").toString().equals("1")) {
                if (ZTYZSBXH.containsKey(MedicineUtils.parseString(record.get("ztyzsbxh")))) {
                    continue;
                }
                Map<String, Object> parm = ParamUtil.instance().put("sbxh", MedicineUtils.parseLong(record.get("ztyzsbxh")));
                record = opYj02ZtDao.getZtBySbxh(parm);
                ZTYZSBXH.put(MedicineUtils.parseString(record.get("ztyzsbxh")), record);
            }
            result.add(record);
        }
        List<QueryDisposalEntryListResp> resp = MzUtil.ListToResultSet(result, new QueryDisposalEntryListResp());

        //重排医技组号给前端做颜色展示
        if(!resp.isEmpty()) {
            int pxh = 1;
            Integer yjzh = resp.get(0).getYjzh();
            for (int i = 0; i < resp.size(); i++){
                if(!yjzh.equals(resp.get(i).getYjzh())){
                    yjzh = resp.get(i).getYjzh();
                    pxh++;
                }
                resp.get(i).setPxh(pxh);
            }
        }

        return resp;
    }

    /**
     * 查询医技组套详情
     * @param ztyzsbxh
     * @return
     */
    public List<YjztDetailResp> queryZtDetail(Integer ztyzsbxh){
        if (ztyzsbxh == null){
            return null;
        }
        return opYjcf02Dao.queryZtDetail(ztyzsbxh);
    }

    /**
     * 医技全部查询（助手方式）
     *
     * @param pydm
     * @param hospitalId
     * @return
     */
    public PageInfo<YjQueryPageHelperResp> queryPageHelper(YjQueryPageHelperReq req, Integer hospitalId) {
        HashMap<Object, Object> map = MapUtil.of(new Object[][]{
                {"jgid", hospitalId},
                {"pydm", req.getPydm()}
        });
        map.put("pageNum", req.getPageNum());
        map.put("pageSize", req.getPageSize());
        return feeYlsfxmOutSer.queryPageHelper(map);
    }

    /**
     * 处置明细删除
     *
     * @param pkey
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public void removeDisposalEntry(Integer sbxh,Integer ztsbxh,Integer ztbz,Integer yjzh,String type) {
        //1.判断处置是否已经收费，如果已经收费就不能删除
        CzData czData = judgeIsSf(sbxh, ztsbxh, ztbz);

        //2删除处置
        deleteYj(czData,yjzh,type,sbxh,ztsbxh,ztbz);
    }

    /**
     * 删除处置，检查申请，康复申请等
     * @param map  包含项目类型，各种申请单号，就诊流水号等数据
     * @param yjzh
     * @param type
     */
    private void deleteYj(CzData czData,Integer yjzh,String type,Integer sbxh,Integer ztsbxh,Integer ztbz){
        String jzlsh = czData.getJzlsh();
        if (StrUtil.isBlank(jzlsh)){
            throw BaseException.create("ERROR_DCTWORK_OP_0070");
        }
        Integer yjxh = czData.getYjxh();
        if (yjxh == null){
            throw BaseException.create("ERROR_DCTWORK_OP_0071");
        }
        List<Integer> beforeDeleteYjxh = opYjcf01Dao.getyjxhList(jzlsh, yjzh);
        //删除BEGIN
        if (ztbz != null && ztbz == 1){//删除组套
            //删除申请单(申请单 一个申请单对应一个医技)
            deleteSqd(czData,yjxh,yjzh,ztsbxh,type);
            if ("1".equals(type)){//删除同组
                //删除opyjcf02
                opYjcf02Dao.deleteByjzlshAndYjzh(jzlsh, yjzh);
                //删除组套opyj02zt
                opYj02ZtDao.deleteByJzlshAndYjzh(jzlsh,yjzh);
            }else {//删除当前
                //删除opyjcf02
                opYjcf02Dao.deleteByZtyzsbxh(ztsbxh);
                //删除组套opyj02zt
                opYj02ZtDao.deleteById(ztsbxh);
            }
            //删除opyjcf01
            deleteOpyJcf01OnNotSame(jzlsh,yjzh,beforeDeleteYjxh);
        }else {//删除非组套
            if ("1".equals(type)){//删除同组
                //查询同组的所有数据（为了获取其他数据是否存在组套）
                List<Integer> groupZt = opYjcf02Dao.getSameGroupZt(jzlsh, yjzh);
                if (CollUtil.isNotEmpty(groupZt)){
                    groupZt.stream().forEach(o ->{
                        //删除opyj02zt
                        opYj02ZtDao.deleteById(o);
                    });
                }
                //删除opyjcf02
                opYjcf02Dao.deleteByjzlshAndYjzh(jzlsh,yjzh);
            }else {//删除当前
                // 删除opyjcf02
                opYjcf02Dao.deleteById(sbxh);
            }
            //删除opyjcf01
            deleteOpyJcf01OnNotSame(jzlsh,yjzh,beforeDeleteYjxh);
        }
        //删除END
    }

//    /**
//     * 删除处置主表1（OpyJcf01）【判断是否存在不同组】
//     * @param yjxh
//     * @param yjzh
//     */
//    private void deleteOpyJcf01OnNotSameGroup(Integer yjxh,Integer yjzh){
//        //查询当前医技序号（yjxh）下是否存在处置数据（如果不存在则需要删除opyjcf01）
//        int notSameGroup = opYjcf01Dao.getNotSameGroup(yjxh, yjzh);
//        if (notSameGroup == 0){
//            opYjcf01Dao.deleteById(Integer.valueOf(yjxh));
//        }
//    }

    /**
     * 删除处置主表2（OpyJcf01）【判断是否存在不同数据】
     * @param yjxh
     * @param sbxh
     */
    private void deleteOpyJcf01OnNotSame(String jzlsh,Integer yjzh,List<Integer> beforeDeleteYjxh){
        //删除opyjcf01
        List<Integer> afterDeleteYjxh = opYjcf01Dao.getyjxhList(jzlsh, yjzh);
        if (CollUtil.isEmpty(afterDeleteYjxh)){
            beforeDeleteYjxh.stream().forEach(o ->{
                opYjcf01Dao.deleteById(o);
            });
        }else {
            beforeDeleteYjxh.removeIf(o ->afterDeleteYjxh.contains(o));
            beforeDeleteYjxh.stream().forEach(o ->{
                opYjcf01Dao.deleteById(o);
            });
        }
    }

//    public static void main(String[] args) {
//        List<Integer> integers1 = new ArrayList<>();
//        integers1.add(1);
//        integers1.add(2);
//        integers1.add(3);
//
//        List<Integer> integers2 = new ArrayList<>();
//        integers2.add(1);
//        integers2.add(2);
//
//        integers1.removeIf(o -> integers2.contains(o));
//
//        System.out.println(integers1);
//    }

    /**
     * 判断是否已收费
     * @param sbxh
     * @param ztsbxh
     * @param ztbz
     */
    private CzData judgeIsSf(Integer sbxh,Integer ztsbxh,Integer ztbz){
        CzData czData = new CzData();

        if (ztbz != null && ztbz == 1){
            //查询组套数据
            if (ztsbxh == null || ztsbxh == 0){
                throw BaseException.create("ERROR_DCTWORK_OP_0067");
            }
            Map<String, Object> paramZtSbxh = new HashMap<String, Object>();
            paramZtSbxh.put("sbxh", ztsbxh);
            czData = opYjcf02Dao.queryZtFphmZfbzBySbxh(paramZtSbxh);
        }else {
            //查询非组套数据
            if (sbxh == null || sbxh == 0){
                throw BaseException.create("ERROR_DCTWORK_OP_0068");
            }
            Map<String, Object> paramSbxh = new HashMap<String, Object>();
            paramSbxh.put("sbxh", sbxh);
            czData = opYjcf02Dao.queryFphmZfbzBySbxh(paramSbxh);
        }
        if (czData == null){
            throw BaseException.create("ERROR_DCTWORK_OP_0069");
        }
        // 如果根据主键查询得到的门诊序号（或者发票号码）有值【代表已收费】，就不能删除
        //1.判断处置是否已经收费，如果已经收费就不能删除
        if (StrUtil.isNotBlank(czData.getFphm()) && (czData.getZfbz() != null && "1".equals(czData.getZfbz()))) {
            if ("1".equals(czData.getZfbz())) {
                throw BaseException.create("ERROR_DCTWORK_OP_0037");
            } else {
                throw BaseException.create("ERROR_DCTWORK_OP_0036");
            }
        }
        return czData;
    }

    /**
     * 删除各种申请单
     * @param czData 处置数据
     * @param yjxh 医技序号
     * @param type 1删除同组 2删除当前条
     */
    private void deleteSqd(CzData czData,Integer yjxh,Integer yjzh,Integer ztsbxh,String type){
        Integer xmlx = czData.getXmlx();
        if (xmlx == null){
            throw BaseException.create("ERROR_DCTWORK_OP_0072");
        }
        //当xmlx为5检查时：删除检查申请相关表（cis_jcsq01,cis_jcsq02,cis_jcsq03）
        if (StatusEnum.Xmlx.JC.getCode().equals(xmlx)){
            deleteJcsq(czData.getSqid(),czData.getJgid(),yjxh,yjzh,ztsbxh,type);
        }

        //当xmlx为7康复时：删除康复申请相关表()
        if (StatusEnum.Xmlx.ZL.getCode().equals(xmlx)){
            deletekfzlsq(czData.getZlsqdid(),yjxh,yjzh,ztsbxh,type);
        }

        //当xmlx为6手术时：删除手术申请相关表()
        if (StatusEnum.Xmlx.SS.getCode().equals(xmlx)){
            // TODO: 2021/4/20 手术
        }
    }

    /**
     * 删除检查申请相关表
     * @param jcsqid
     * @param yjxh
     * @param yjzh
     * @param ztsbxh
     * @param type
     */
    private void deleteJcsq(Integer jcsqid,Integer jgid,Integer yjxh,Integer yjzh,Integer ztsbxh,String type){
        if (jcsqid == null){
            logger.error("当前处置为检查类型，但却未关联检查申请单,无法删除检查申请单数据");
        }else {
            if ("1".equals(type)){//删除同组时(对于检查申请删除同组相当于删除整个申请单)
                cisjcsqd01Service.deleteCzRelationJcsq(jcsqid,null,jgid);
            }else {//删除当前条（对于检查申请，删除单条相当于删除申请单中的单个项目）
                //查询opyj02zt获取ylxh对应cisjcsq02表的fyxh
                OpYjcf02Zt yjcf02Zt = opYj02ZtDao.getById(ztsbxh);
                if (yjcf02Zt != null){
                    if (yjcf02Zt.getYlxh() != null){
                        cisjcsqd01Service.deleteCzRelationJcsq(jcsqid,yjcf02Zt.getYlxh(),jgid);
                    }else {
                        logger.error("通过ztsbxh查询到组套数据中ylxh为空,无法删除检查申请单数据,ztsbxh：{}",ztsbxh);
                    }
                }else {
                    logger.error("未能通过ztsbxh查询到组套数据,无法删除检查申请单数据,ztsbxh:{}",ztsbxh);
                }
            }
        }
    }

    /**
     * 删除康复治疗相关表
     * @param kfzlsqid
     * @param yjxh
     * @param yjzh
     * @param ztsbxh
     * @param type
     */
    private void deletekfzlsq(Integer kfzlsqid,Integer yjxh,Integer yjzh,Integer ztsbxh,String type){
        if (kfzlsqid == null){
            logger.error("当前处置为康复治疗类型，但却未关联康复治疗申请单,无法删除康复治疗申请单数据");
        }else {
            if ("1".equals(type)){//删除同组时(对于康复治疗申请删除同组相当于删除整个申请单)
                treatmentApplyFormService.delete(kfzlsqid,null);
            }else {//删除当前条（对于康复治疗申请，删除单条相当于删除申请单中的单个项目）
                //查询opyj02zt获取ylxh对应cisjcsq02表的fyxh
                OpYjcf02Zt yjcf02Zt = opYj02ZtDao.getById(ztsbxh);
                if (yjcf02Zt != null){
                    if (yjcf02Zt.getYlxh() != null){
                        treatmentApplyFormService.delete(kfzlsqid,yjcf02Zt.getYlxh());
                    }else {
                        logger.error("通过ztsbxh查询到组套数据中ylxh为空,无法删除康复治疗申请单数据,ztsbxh：{}",ztsbxh);
                    }
                }else {
                    logger.error("未能通过ztsbxh查询到组套数据,无法删除康复治疗申请单数据,ztsbxh:{}",ztsbxh);
                }
            }
        }
    }

    /**
     * 根据组套载入组套明细信息
     *
     * @param req
     */
    public List<YjLoadPersonalSetResp> loadPersonalSet(YjLoadPersonalSetReq req, SysUser user) {
        String jgid = user.getHospitalIdStr();
        List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();

        Map<String, Object> parameters = new HashMap<String, Object>(16);
        parameters.put("brxz", req.getBrxz());
        parameters.put("jgid", user.getHospitalId());
        parameters.put("ztbh", req.getZtbh());
        List<Map<String, Object>> meds = opZt02Service.queryYjZtMx(parameters);

        //查询打折比例
        Integer newYpzh = 1;
        Integer oldYpzh = 1;
        Integer index = 1;
        for (Map<String, Object> med : meds) {
            if (!"1".equals(med.get("mzsy") + "")) {
                med.put("errorMsg", "不存在!");
                res.add(med);
                continue;
            }
            if (req.getZt02Jlbh().size() > 0) { //部分明细调入
                Set<Integer> set = new HashSet<Integer>();
                set.addAll(req.getZt02Jlbh());
                Integer jlbh = ObjectToTypes.parseInt(med.get("jlbh"));
                if (!set.contains(jlbh)) {
                    continue;
                }
            }
            // add by yangl 判断是否限制使用
            if (med.get("xzsy") != null
                    && med.get("xzsy").toString().equals("1")) {
                Map<String, Object> ret = new HashMap<String, Object>();
                med.put("brid", req.getBrid());
                doQueryIsNeedVerify(med, ret, user);
                if (ret.get("body") != null
                        && ((Map<String, Object>) ret.get("body"))
                        .get("ylsl") != null) {
                    int sysl = Integer.parseInt(((Map<String, Object>) ret
                            .get("body")).get("ylsl").toString());
                    if (sysl >= (Integer) med.get("xzcs")) {
                        med.put("errorMsg", "已超过使用限制,不允许继续录入!");
                        res.add(med);
                        continue;
                    }
                }
            }

            // 获取组套中药品自负比例和库存数量
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("TYPE", 0);
            data.put("FYXH", med.get("fyxh"));
            data.put("BRXZ", req.getBrxz());
            data.put("FYGB", med.get("fygb"));
            Map<String, Object> zfblMap = mzUtil.getPayProportion(data);
            med.put("zfbl", zfblMap.get("ZFBL"));
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
            index++;
            res.add(med);
        }

        return MzUtil.ListToResultSet(res, new YjLoadPersonalSetResp());
    }

    public void doQueryIsNeedVerify(Map<String, Object> body, Map<String, Object> res, SysUser user) {
        String jgid = user.getHospitalIdStr();// 用户的机构ID
        long fyxh = 0L;
        long brid = 0L;
        int xzts = 0;
        if (body.containsKey("fyxh")) {
            fyxh = Long.parseLong(body.get("fyxh") + "");
        }
        if (body.containsKey("brid")) {
            brid = Long.parseLong(body.get("brid") + "");
        }
        if (body.containsKey("xzts")) {
            xzts = Integer.parseInt(body.get("xzts") + "");
        }
        String sql = "select sum(b.YLSL) as YLSL from OP_YJCF01 a,OP_YJCF02 b where a.yjxh=b.yjxh and a.brid=:BRID and a.jgid=:JGID and a.zfpb=0 and ylxh=:YLXH and a.KDRQ>sysdate-:XZTS";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("brid", brid);
        params.put("ylxh", fyxh);
        params.put("xzts", cn.hutool.core.date.DateUtil.offsetDay(new Date(), xzts));
        params.put("jgid", jgid);
        Map<String, Object> m = opYjcf02Dao.queryYlsl(params);

        res.put("body", m);

    }

    /**
     * 根据组套载入组套明细信息（全院-科室）
     *
     * @param req
     * @return
     */
    public Integer saveDisposalSet(SaveDisposalSetReq req, SysUser user) {
        Integer sbxh = null;

        Map<String, Object> detailsParameter = new HashMap<String, Object>();
        detailsParameter.put("ztbh", req.getZtbh());
        detailsParameter.put("brxz", req.getBrxz());
        List<Map<String, Object>> details = opZt02Service.queryXmbhYzmcFydj(detailsParameter);

        // 判断项目是否作废，若作废不能保存并给出提示
        String zfxmMC = "";
        String xmmc = "";//将项目名称拼接
        for (Map<String, Object> xm : details) {
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("fyxh", MedicineUtils.parseLong(xm.get("xmbh")));
            parameters.put("zfpb", 0);
            List<FeeYlsfxmdjModel> list = feeYlsfxmdjService.findByEntity(parameters);
            if (list == null || list.isEmpty()) {
                zfxmMC += MedicineUtils.parseString(xm.get("yzmc")) + ", ";
            }
            //xmmc += MedicineUtils.parseString(xm.get("yzmc")) + "+";
        }
        if (zfxmMC.length() > 0) {
            zfxmMC = zfxmMC.substring(0, zfxmMC.lastIndexOf(","));
            throw BaseException.create("ERROR_DCTWORK_OP_0039", new String[]{zfxmMC});
        }

        BigDecimal ypdj = BigDecimal.ZERO;
        for (Map<String, Object> xm : details) {
            ypdj = ypdj.add(ObjectToTypes.parseBigDecimal(xm.get("fydj")).multiply(ObjectToTypes.parseBigDecimal(xm.get("xmsl"))));
        }

        // 保存医嘱信息
        Map<String, Object> zt01 = new HashMap<String, Object>();

        // 组号 同一组套的项目全选时，医嘱存为同一组 默认是全选
        int YZZH_SHOW = 1;

        List<Integer> yzzt_ids = new ArrayList<Integer>();// 记录保存的组套id
        // 向OP_YJ02_ZT表中存储一条数据
        Map<String, Object> yzxx_zt = new HashMap<String, Object>();// 组套信息
        yzxx_zt.put("ztbz", 1); // 组套标志(该条医嘱存是组套信息) 0非组套标志，1组套标志
        yzxx_zt.put("jgid", user.getHospitalId()); // 机构ID
        yzxx_zt.put("yjxh", "1"); // 医技序号
        yzxx_zt.put("ylxh", req.getZtbh()); // 医疗序号=组套编号
        yzxx_zt.put("xmlx", 4); // 项目类型=检验
        yzxx_zt.put("yjzx", 0); // 项目主项
        yzxx_zt.put("yldj", ypdj); // 医疗单价
        yzxx_zt.put("ylsl", 1); // 医疗数量
        yzxx_zt.put("hjje", ypdj); // 划价金额
        yzxx_zt.put("fygb", 9); // 费用归并,取DIC_SFXMLB收费名称为化验费的值=9
        yzxx_zt.put("zfbl", 1); // 自负比例 组套不显示自负比例
        yzxx_zt.put("dzbl", 1); // 打折比例
        yzxx_zt.put("yjzh", req.getYjzh()); // 医技组号
        yzxx_zt.put("fymc", req.getZtmc());//费用名称
        //yzxx_zt.put("fymc", req.getZtmc()+"("+xmmc+")"); // 费用名称

        //公用主键获取
        List<HashMap<String, String>> rec = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> rule = new HashMap<String, String>();
        rule.put("name", "increaseId");
        rule.put("length", "18");
        rule.put("type", "increase");
        rec.add(rule);
        sbxh = redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJCF02);
        yzxx_zt.put("sbxh", sbxh);
        yzxx_zt.put("jzlsh", req.getJzlsh());
        opYj02ZtDao.insert(yzxx_zt);
        yzzt_ids.add(sbxh);
        for (Map<String, Object> xm : details) {
            zt01.put(xm.get("xmbh").toString(), sbxh);
        }

        // 处方组套明细保
        List<Map<String, Object>> jc02_list = new ArrayList<Map<String, Object>>();
        Map<String, Object> saveData = new HashMap<String, Object>();
        saveData.put("djly", 1);
        saveData.put("brxm", req.getBrxm());
        saveData.put("ghgl", req.getGhgl());
        saveData.put("brid", req.getBrid());
        saveData.put("clinicId", req.getJzxh());

        Map<String, Object> yj02 = null;// 组装处置明细数据
        for (int i = 0; i < details.size(); i++) {
            yj02 = new HashMap<String, Object>();// 医嘱信息
            yj02.put("_opStatus", "create");

            if (!zt01.containsKey(details.get(i).get("xmbh").toString())) {
                yj02.put("ztbz", 0);// 组套标志 非组套医嘱
                YZZH_SHOW += 1;
            } else {
                yj02.put("ztbz", 1);// 组套标志 组套医嘱
                yj02.put("ztyzsbxh", zt01.get(details.get(i).get("xmbh").toString()));
            }

            Map<String, Object> param = ParamUtil.instance().put("fyxh", ObjectToTypes.parseDouble(details.get(i).get("xmbh")));
            // 查询该组套下面的项目明细
            //判断病人性质是否是医保病人
            if (req.getBrxz() != null && "6024".equals(req.getBrxz())) {
                //商保病人
                param.put("type", "1");
            } else {
                //非商保病人
                param.put("type", "2");
            }
            Map<String, Object> fymx = feeYlsfxmOutSer.getBxInfo(param);


            yj02.put("yjzh", req.getYjzh());// 医技组号
            yj02.put("jgid", req.getJgid()); // 机构ID
            yj02.put("ylxh", MedicineUtils.parseLong(fymx.get("fyxh")));// 医疗序号=费用序号
            yj02.put("xmlx", 4);// 项目类型
            // 4检验,5检查,6手术,7治疗,8护理,9饮食,10卫材,99其他
            yj02.put("yldj", MedicineUtils.parseDouble(fymx.get("bzjg")));// 医疗单价=费用单价
            yj02.put("ylsl", 1);// 医疗数量
            yj02.put("yjzx", 0);// 医技主项
            yj02.put("ztbh",req.getZtbh());//组套编号

            // 获取病人自负比例
            Integer ypxh = MedicineUtils.parseInt(fymx.get("fyxh"));// 费用序号
            Integer fygb = mzUtil.getfygb(0, ypxh);// 获取费用归并
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("BRXZ", req.getBrxz());// 病人性质
            params.put("FYGB", fygb);// 费用归并
            params.put("TYPE", 0);// 药品类型 0=项目
            params.put("FYXH", ypxh);// 费用序号
            Map<String, Object> zfblMap = mzUtil.getPayProportion(params);
            double zfbl = MedicineUtils.parseDouble(zfblMap.get("ZFBL"));
            yj02.put("zfbl", zfbl);// 自负比例
            yj02.put("dzbl", 1);// 打折比例============================================
            yj02.put("ksdm", req.getKsdm());// 科室代码

            yj02.put("fjgl", "");// 附件处方===========================================
            yj02.put("fydw", MedicineUtils.parseString(fymx.get("fydw")));// 费用单位
            yj02.put("hjje", MedicineUtils.parseDouble(fymx.get("bzjg")));// 合计金额=============================
            yj02.put("fymc", MedicineUtils.parseString(fymx.get("fymc")));// 费用名称
            yj02.put("fygb", fygb);// 费用归并
            jc02_list.add(yj02);
        }


        OpYjcf01Req yjreq = new OpYjcf01Req();
        yjreq.setBodys(MzUtil.ListToResultSet(jc02_list, new OpYjcf02Req()));
        yjreq.setClinicId(req.getJzxh());
        yjreq.setBrid(req.getBrid());
        yjreq.setBrxm(req.getBrxm());
        yjreq.setDjly(1);
        yjreq.setGhgl(req.getGhgl());
        yjreq.setJzlsh(req.getJzlsh());
        yjreq.setJzkh(req.getJzkh());
        yjreq.setLy(11);
        Integer yjxh = save(yjreq, user);


        // 更新OP_YJ02_ZT的YJXH值

        Map<String, Object> param = ParamUtil.instance().put("yjxh", (yjxh)).put("sbxh", sbxh);
        opYj02ZtDao.updateYjxhBySbxh(param);

        return sbxh;
    }

    /**
     * 根据组装组套插入数据
     *
     * @param sbxh
     * @return
     */
    public InsertDisposalSetResp insertDisposalSet(Integer sbxh) {
        //组装返回的插入的数据
        Map<String, Object> map = opYj02ZtDao.getBySbxh(sbxh);
        return BeanUtil.fillBeanWithMapIgnoreCase(map, new InsertDisposalSetResp(), true);
    }

    /**
     * 判断是否需要审核
     *
     * @param fyxh
     * @param brid
     * @param xzts
     * @param hospitalId
     */
    public Long queryIsNeedVerify(Integer fyxh, Integer brid, Integer xzts, Integer hospitalId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("brid", brid);
        params.put("ylxh", fyxh);
        params.put("xzts", cn.hutool.core.date.DateUtil.offsetDay(new Date(), -xzts));
        params.put("jgid", hospitalId);

        return opYjcf01Dao.queryIsNeedVerify(params);
    }

    /**
     * @param req
     * @param response
     * @name: yjPrint
     * @description: 医技打印
     * @return: java.lang.String
     * @date: 2020/8/28 14:35
     * @auther: 老花生
     */
    public String yjPrint(YjPrintReq req, SysUser user, HttpServletResponse response) {
        String jasperName = "jrxml/Treatment.jasper";
        Map<String, Object> params = getCfPringParameters(req, user);
        List<Map<String, Object>> list = getCfPringFields(req);
        //String url = exportFileSer.reportHtml(list, params, jasperName);
        iReportExportFileSer.reportHtmlForStream(list,params,jasperName,response);
        return "url";
    }

    /**
     * 查询处置数据
     * @param req
     * @return
     */
    private List<Map<String, Object>> getCfPringFields(YjPrintReq req) {

        List<Map<String, Object>> records = new ArrayList<>();

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("JGID", req.getJgid());
        int n = 1;

        BigDecimal totalPrice = new BigDecimal("0.00");
        for (String yjxh : req.getYjxhList().split(",")) {
            Map<String, Object> parametersmx = new HashMap<String, Object>();
            //通过SBXH查询医技详情
            parametersmx.put("sbxh", yjxh);
            List<Map<String, Object>> cflist = opYjcf02Dao.queryFymcHjjeBySbxh(parametersmx);
            if (CollUtil.isEmpty(cflist)){
                //根据ZTYSSBXH查询项目(对于项目是组套的情况)
                cflist = opYjcf02Dao.queryFymcByZtysSbxh(parametersmx);
            }
            //parametersmx.put("YJXH", yjxh);
            //List<Map<String, Object>> cflist = opYjcf02Dao.queryFymcYldjHjjeByYjxh(parametersmx);
            for (int j = 0; j < cflist.size(); j++) {
                cflist.get(0).put("XH", n + "、");
                if (Double.parseDouble(cflist.get(j).get("ZFBL") + "") > 1) {
                    double YLDJ = Double.parseDouble(cflist.get(j).get("YLDJ") + "") * Double.parseDouble(cflist.get(j).get("ZFBL") + "");
                    double HJJE = Double.parseDouble(cflist.get(j).get("HJJE") + "") * Double.parseDouble(cflist.get(j).get("ZFBL") + "");

                    cflist.get(j).put("YLDJ", YLDJ);
                    cflist.get(j).put("HJJE", HJJE);
                }
                totalPrice = totalPrice.add(new BigDecimal(cflist.get(j).get("HJJE") + ""));
                cflist.get(j).put("YLCLF", totalPrice);
                records.add(cflist.get(j));
            }
            n++;
        }

        return records;
    }

    private Map<String, Object> getCfPringParameters(YjPrintReq req, SysUser user) {
        Map<String, Object> response = new HashMap<>();

        Integer brid = req.getBrid();
        Integer jzxh = req.getJzxh();
        Integer jgid = req.getJgid();
        Map<String, Object> parameters = new HashMap<String, Object>();
        Map<String, Object> parametersjzhm = new HashMap<String, Object>();
        parameters.put("BRBH", brid);
        parameters.put("JGID", jgid);
        parameters.put("JZXH", req.getJzxh());

        String sql3 = "select JZHM as JZHM from OP_GHMX where SBXH=:SBXH";

        List<Map<String, Object>> cfmap = opYjcf01Dao.queryYjPrintPatientInfo(parameters);

        if (cfmap.size() > 0) {
            Map<String, Object> cf = cfmap.get(0);
            if (cf.get("SBXH") != null) {
                Integer sbxh = Integer.parseInt(cf.get("SBXH").toString());
                response.put("JZHM", opGhmxDao.getById(sbxh).getJzhm());
            } else {
                response.put("JZHM", "");
            }


            String ksmc = "";
            if (cf.get("KSDM") != null) {
                Map<String, Object> param = ParamUtil.instance().put("organizcode", jgid)
                        .put("id", ObjectToTypes.parseInt(cf.get("KSDM")));
                List<DicKszdModel> ret = dicKszdOutSer.findByEntity(param);
                if (ret != null && !ret.isEmpty()) {
                    ksmc = ret.get(0).getOfficename();
                }
            }
            String xzmc = "";
            Boolean isVIP = false;//是否是VIP病人
            if (cf.get("BRXZ") != null) {
                xzmc = pubBrxzOutSer.getById(ObjectToTypes.parseInt(cf.get("BRXZ"))).getXzmc();

                //获取VIP
                String VIPBRXZ = sysXtcsCacheSer.getCsz(jgid, BUHISSystemArgument.VIPBRXZ);
                String[] VIPBRXZS = VIPBRXZ.split(",");
                for (int i = 0; i < VIPBRXZS.length; i++) {
                    if (VIPBRXZS[i].toString().equals(cf.get("BRXZ").toString())) {
                        isVIP = true;
                    }
                }
            }
            String ygxm = "";
            if (cf.get("YSDM") != null) {
                HrPersonnelModel hrPersonnel = hrPersonnelService.getPersonnelById(Integer.valueOf(cf.get("YSDM").toString()));
                if (hrPersonnel != null) {
                    ygxm = hrPersonnel.getPersonname();
                }
            }
            String brxb = "";
            if (cf.get("BRXB") != null) {
                brxb = mzUtil.dictionaryConversion("LS0000000821",
                        ObjectToTypes.parseString(cf.get("BRXB")));
            }
            String age = "";
            if (cf.get("CSNY") != null) {
                age = String.valueOf(cn.hutool.core.date.DateUtil.ageOfNow(cf.get("CSNY").toString()));
            }

            String jgname = user.getHospitalName();

            response.put("title", jgname);
            response.put("BRXM", cf.get("BRXM"));
            response.put("BRXB", brxb);
            response.put("BRXZ", xzmc);
            response.put("BRNL", age);
            response.put("KFRQ", cn.hutool.core.date.DateUtil.format(cn.hutool.core.date.DateUtil.date(),
                    DatePattern.NORM_DATE_PATTERN));
            response.put("KSMC", ksmc);
            response.put("JZHM", cf.get("JZKH"));
            response.put("MZHM", cf.get("MZHM"));
            Map<String, Object> zdparameters = new HashMap<String, Object>();
            zdparameters.put("jzxh", jzxh);
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
            response.put("ZDMC", str);
            response.put("YSDM", ygxm);
            String address = "";
            if (cf.get("ADDRESS") != null) {
                address = cf.get("ADDRESS") + "";
            }
            String mobilenumber = "";
            if (cf.get("MOBILENUMBER") != null) {
                mobilenumber = cf.get("MOBILENUMBER") + "";
            }
            response.put("ADDRESS", mobilenumber + "/" + address);
        }

        return response;
    }

    /**
     * @param req
     * @name: queryAuxiliaryReportList
     * @description: 查询辅助报告检验申请列表
     * @return: java.util.List<com.buit.cis.op.dctwork.response.QueryAuxiliaryReportListResp>
     * @date: 2020/9/2 16:08
     * @auther: 朱智
     */
    public List<QueryAuxiliaryReportListResp> queryAuxiliaryJyReportList(QueryDisposalEntryListReq req) {
        return opYjcf01Dao.queryAuxiliaryJyReportList(req);
    }

    /**
     * @param req
     * @name: queryAuxiliaryJyDetail
     * @description: 查询辅助报告检验明细信息
     * @return: java.util.List<com.buit.cis.op.dctwork.response.QueryAuxiliaryJyDetailResp>
     * @date: 2020/9/3 10:19
     * @auther: 朱智
     */
    public List<QueryAuxiliaryJyDetailResp> queryAuxiliaryJyDetail(QueryAuxiliaryJyDetailReq req) {
        return opYjcf01Dao.queryAuxiliaryJyDetail(req);
    }

    /**
     * @param yjxh
     * @name: delById
     * @description: 辅助报告检验删除
     * @return: void
     * @date: 2020/9/3 15:34
     * @auther: 朱智
     */
    @Transactional(rollbackFor = Exception.class)
    public void delById(Integer yjxh) {
        OpYjcf01 yj = opYjcf01Dao.getById(yjxh);
        if (yj == null || yj.getYjxh() == null) {
            throw BaseException.create("ERROR_DCTWORK_OP_0043");
        }
        opYjcf02Dao.removeByEntity(ParamUtil.instance().put("yjxh", yjxh));
        opYjcf01Dao.deleteById(yjxh);
    }

    /**
     * @param type
     * @param jzlsh
     * @param ylxhs
     * @param zlxmids
     * @param xmbhs
     * @name: checkAddYj
     * @description: 添加医技校验
     * @return: void
     * @date: 2020/9/14 10:31
     * @auther: 朱智
     */
    public Boolean checkAddYj(Integer type, String jzlsh, String ylxhs, String zlxmids, String xmbhs) {
        if (type.intValue() == 1 || type.intValue() == 7) {
            List<OpYjcf02> list = opYjcf02Dao.findByEntity(ParamUtil.instance().put("jzlsh", jzlsh));
            String[] ylxhList = ylxhs.split(",");
            for (OpYjcf02 yj : list) {
                for (String yjxh : ylxhList) {
                    if (yj.getYlxh().intValue() == ObjectToTypes.parseInt(yjxh)) {
                        return false;
                    }
                }
            }
        } else if (type.intValue() == 2) {
            List<OpYjcf02> list = opYjcf02Dao.findByEntity(ParamUtil.instance().put("jzlsh", jzlsh));
            List<Integer> fyxhList = diccZlsfdzOutSer.getListByZlxmidList(zlxmids.split(","));
            for (OpYjcf02 yj : list) {
                for (Integer yjxh : fyxhList) {
                    if (yj.getYlxh().intValue() == yjxh.intValue()) {
                        return false;
                    }
                }
            }
        } else if (type.intValue() == 3) {
            List<OpYjcf02> list = opYjcf02Dao.findByEntity(ParamUtil.instance().put("jzlsh", jzlsh));
            String[] ylxhList = xmbhs.split(",");
            for (OpYjcf02 yj : list) {
                for (String yjxh : ylxhList) {
                    if (yj.getYlxh().intValue() == ObjectToTypes.parseInt(yjxh)) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }


    /**
     * 保存门诊检验申请单
     * @param req
     * @param user
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveMzJySqd(JySqdReq req, SysUser user) {
        List<JySqdReqJyzt> jyzt = req.getJyzts();
        if (CollUtil.isEmpty(jyzt)){
            throw BaseException.create("ERROR_DCTWORK_OP_0083");
        }
        List<JySqdReqXmDetail> details = req.getXmDetails();

        // 判断项目是否作废，若作废不能保存并给出提示
        checkYz(details);

        //防重复提交项目
        checkRepeat(jyzt,req.getJzlsh());

        // 保存医嘱信息
        Map<String, Object> zt01 = new HashMap<>(16);
        // 组号 同一组套的项目全选时，医嘱存为同一组
        Integer maxYjzh= opYjcf02Service.getMaxYjzh(req.getJzlsh(), user.getHospitalId());//查询最大的医技组号

        //保存项目主表（op_yjcf01）
        Integer yjxh = saveYjcf01Bysq(req, user);

        Integer zxks = null;
        for (JySqdReqJyzt zt : jyzt) {
            //List<Integer> yzztIds = new ArrayList<>();// 记录保存的组套id
            //Integer brxz = req.getBrxz(); //获得病人性质
            List<Map<String, Object>> xmDetails;// 查询该组套下面的项目明细

            //查询组套明细项目
            Map<String, Object> param = ParamUtil.instance().put("ztbh", zt.getZtbh());
            xmDetails = opZt02Service.getJlbhXmbhXmslFydjFSb(param);
            if(CollUtil.isEmpty(xmDetails)){
                throw BaseException.create("ERROR_DCTWORK_OP_0085",new String[]{zt.getZtmc()});
            }

            //取执行科室
            if (zxks != null){
                zxks = ObjectToTypes.parseInt(xmDetails.get(0).get("fyks"));
            }

            //保存组套项目（op_yj02zt）
            Integer ztSbxh = saveYj02ZtBysq(zt, user, yjxh, maxYjzh, req.getJzlsh(),xmDetails);

            //保存项目明细（op_yjcf02）
            saveYjcf02Bysq(user,yjxh,ztSbxh,maxYjzh,req.getJzlsh(),zt.getZtbh(),xmDetails,details);

            //判断病人性质是否是医保病人
//            if(brxz != null&& brxz.intValue() == 6024){
//                //如果是商保病人，获取商保价格
//                Map<String, Object> param = ParamUtil.instance().put("ztbh", zt.getZtbh());
//                xmDetails = opZt02Service.getJlbhXmbhXmslFydjSb(param);
//            }else{
//                //非商保病人
//                Map<String, Object> param = ParamUtil.instance().put("ztbh", zt.getZtbh());
//                xmDetails = opZt02Service.getJlbhXmbhXmslFydjFSb(param);
//            }

            //判断组套信息是否全选
            //boolean hasZt = ztSelectAll(details, xmDetails);
            //非全选也存组套数据修改
//            boolean hasZt = true;
//
//            List<Map<String, Object>> newxmDetails =new ArrayList<Map<String,Object>>();
//            for (Map<String, Object> xm : xmDetails) {
//                for (JySqdReqXmDetail yz : details) {
//                    if (xm.get("jlbh").toString().equals(yz.getJlbh().toString())) {
//                        newxmDetails.add(xm);
//                        break;
//                    }
//                }
//            }
//
//            // 该组套的项目全部选中，新增组套信息表信息
//            if (hasZt) {
//                // 保存yjcf02Zt表
//                //OpYjcf02Zt yzxxZt = saveYjcf02Zt(user.getHospitalId(), zt.getZtbh(), yzzhShow, zt.getZtmc(), req.getJzlsh(), xmDetails);
//                OpYjcf02Zt yzxxZt = saveYjcf02Zt(user.getHospitalId(), zt.getZtbh(), yzzhShow, zt.getZtmc(), req.getJzlsh(), newxmDetails);
//                yzztIds.add(yzxxZt.getSbxh());
//                for (Map<String, Object> xm : xmDetails) {
//                    zt01.put(xm.get("jlbh").toString(), ObjectToTypes.parseLong(yzxxZt.getSbxh()));
//                }
//            }

            //保存组套（op_yj02zt）
//            OpYjcf02Zt yzxxZt = saveYjcf02Zt(user.getHospitalId(), zt.getZtbh(), yzzhShow, zt.getZtmc(), req.getJzlsh(), xmDetails);

            // 处方组套明细保存
//            List<OpYjcf02Req> jc02List = new ArrayList<>();
//            for(JySqdReqXmDetail detail : details){
//                //判断明细是否属于这个组套
//                boolean flag=true;
//                for(Map<String, Object> xm : xmDetails){
//                    if(xm.get("jlbh").toString().equals(detail.getJlbh().toString())){
//                        flag=false;
//                        break;
//                    }
//                }
//                if(flag){
//                    continue;
//                }
//
//                // 保存yjcf02
//                OpYjcf02Req yj02 = saveYjcf02(detail, yzzhShow, zt01, brxz, user.getHospitalId(), req.getBrks());
//
//                //医学检验科
//                jc02List.add(yj02);
//            }

            //调用保存医技
//            OpYjcf01Req yjReq = com.buit.utill.BeanUtil.toBean(req, OpYjcf01Req.class);
//            yjReq.setBodys(jc02List);
//            yjReq.setLy(4);
//            Integer yjxh = save(yjReq, user);
//
//            // 更新OP_YJ02_ZT的YJXH值
//            String inSql = "";
//            for (Integer id : yzztIds) {
//                inSql += "'" + id + "',";
//            }
//            int a = inSql.lastIndexOf(",");
//            //判断如果是组套全选的取跟新OP_YJ02_ZT，如果只开了组套中的某一项，则不用更新OP_YJ02_ZT
//            if(a!=-1){
//                opYj02ZtDao.updateYjxh(yzztIds, yjxh);
//            }

            //yzzhShow ++;
        }

        //更新主表的执行科室
        opYjcf01Dao.updateZxksByYjxh(yjxh,zxks);
    }

    /**
     * 防重复提交
     * @param jyzt
     * @param jzlsh
     */
    private void checkRepeat(List<JySqdReqJyzt> jyzt,String jzlsh) {

        StringBuffer buffer = new StringBuffer();
        jyzt.stream().forEach(o ->{
            int isExit = opYj02ZtDao.getByJzlshAndZtbh(jzlsh, o.getZtbh());
            if (isExit > 0){
                buffer.append(o.getZtmc()+";");
                //throw BaseException.create("ERROR_DCTWORK_OP_0084",new String[]{o.getZtmc()});
            }
        });
        String repeatData = buffer.toString();
        if (StrUtil.isNotBlank(repeatData)){
            throw BaseException.create("ERROR_DCTWORK_OP_0084",new String[]{repeatData.substring(0,repeatData.length()-1)});
        }
    }


    /**
     * 插入
     * @param req
     * @param user
     */
    private Integer saveYjcf01Bysq(JySqdReq req,SysUser user) {
        OpYjcf01 yj01 = new OpYjcf01();
        yj01.setYjxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJCF01));
        yj01.setKsdm(req.getBrks());
        yj01.setYsdm(String.valueOf(user.getUserId()));
        yj01.setKdrq(DateUtil.getCurrentTimestamp());
        yj01.setZfpb(StatusEnum.Zfpb.NO.getCode());//作废判别
        yj01.setZxpb(StatusEnum.Zxpb.WZX.getCode());//执行判别
        yj01.setCfbz(StatusEnum.Cfbz.NO.getCode());//处方标志
        yj01.setDjzt(StatusEnum.Djzt.ZC.getCode());//单据状态
        yj01.setJgid(user.getHospitalId());
//        yj01.setZxks(yj02Req.getZxks()); todo 执行科室取法
        yj01.setJzxh(req.getClinicId());//就诊序号
        yj01.setBrid(req.getBrid());
        yj01.setBrxm(req.getBrxm());
        yj01.setDjly(req.getDjly());//单据来源 1医生开单
        //yj01.setSqwh(ObjectToTypes.parseInt(yj02Req.getSqwh()));//申请文号
        //yj01.setSssqid(yj02Req.getSssqid());// 保存手术的申请单号
        yj01.setJzkh(req.getJzkh());
        //yj01.setSqid(yjReq.getSqid());
        yj01.setJzlsh(req.getJzlsh());
        yj01.setXmlx(StatusEnum.Xmlx.JY.getCode());//来源
        yj01.setSqid(yj01.getYjxh());//申请ID取主键值
        opYjcf01Dao.insert(yj01);
        return yj01.getYjxh();
    }

    /**
     * 保存组套详情
     * @param user
     * @param yjxh
     * @param ztSbxh
     * @param maxYjzh
     * @param jzlsh
     * @param xmDetails
     * @param details  入参保存的项目
     */
    private void saveYjcf02Bysq(SysUser user,Integer yjxh,Integer ztSbxh,Integer maxYjzh,String jzlsh,Integer ztbh,List<Map<String, Object>> xmDetails,List<JySqdReqXmDetail> details) {
        //过滤掉组套中未全选的项目 todo 现在组套默认全选
        //filterXm(xmDetails,details);

        for (Map<String, Object> xm : xmDetails){
            OpYjcf02 yj02Save = new OpYjcf02();
            yj02Save.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJCF02));
            yj02Save.setJgid(user.getHospitalId());
            yj02Save.setYjxh(yjxh);
            yj02Save.setYlxh(ObjectToTypes.parseInt(xm.get("xmbh")));
            yj02Save.setXmlx(ObjectToTypes.parseInt(xm.get("xmlx")));
            yj02Save.setYjzx(0);//医技主项
            yj02Save.setYldj(ObjectToTypes.parseBigDecimal(xm.get("fydj")));
            yj02Save.setYlsl(ObjectToTypes.parseBigDecimal(xm.get("fysl")));
            //计算总金额
            if (ObjectToTypes.parseBigDecimal(xm.get("fydj")) != null && ObjectToTypes.parseBigDecimal(xm.get("fysl")) != null){
                BigDecimal zje = ObjectToTypes.parseBigDecimal(xm.get("fydj")).multiply(ObjectToTypes.parseBigDecimal(xm.get("fysl")))
                        .setScale(2, RoundingMode.HALF_UP);
                yj02Save.setHjje(zje);
            }
            yj02Save.setFygb(ObjectToTypes.parseInt(xm.get("fygb")));
            yj02Save.setZfbl(BigDecimal.ONE);
            yj02Save.setDzbl(BigDecimal.ONE);
            yj02Save.setYjzh(maxYjzh);//医技组号
            yj02Save.setZtyzsbxh(ztSbxh);//组套表主键
            yj02Save.setDjzt(StatusEnum.Djzt.ZC.getCode());
            yj02Save.setZtbh(ztbh);
            yj02Save.setZxpb(StatusEnum.Zxpb.WZX.getCode());//执行判别
            yj02Save.setZfpb(StatusEnum.Zfpb.NO.getCode());//作废判别
            yj02Save.setZtbz(StatusEnum.Ztbz.YES.getCode());//组套标志
            yj02Save.setJzlsh(jzlsh);
            yj02Save.setZxzt(StatusEnum.Zxzt.WZX.getCode());//执行状态
            opYjcf02Dao.insert(yj02Save);
        }
    }

    /**
     * 过滤掉组套中未全选的项目
     * @param xmDetails
     * @param details
     * @return
     */
    private List<Map<String, Object>> filterXm(List<Map<String, Object>> xmDetails,List<JySqdReqXmDetail> details){
        List<Integer> xmbhList = details.stream().map(o -> o.getXmbh()).collect(Collectors.toList());
        List<Map<String, Object>> mapList = xmDetails.stream().filter(o -> xmbhList.contains(ObjectToTypes.parseInt(o.get("xmbh")))).collect(Collectors.toList());
        return mapList;
    }

    /**
     * 保存项目组套
     * @param zt
     * @param user
     * @param yjxh  医技序号(opyjcf01表主键)
     * @param maxYjzh 组号
     * @param jzlsh 就诊流水号
     * @return
     */
    private Integer saveYj02ZtBysq(JySqdReqJyzt zt,SysUser user,Integer yjxh,Integer maxYjzh,String jzlsh,List<Map<String, Object>> xmDetails) {
        BigDecimal ztxmdj = BigDecimal.ZERO;
        for (Map<String, Object> xm : xmDetails) {
            ztxmdj = ztxmdj.add(ObjectToTypes.parseBigDecimal(xm.get("fydj")).multiply(ObjectToTypes.parseBigDecimal(xm.get("fysl"))));
        }

        OpYjcf02Zt yzxxZt = new OpYjcf02Zt(); // 组套信息
        yzxxZt.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJ02_ZT)); // 主键
        yzxxZt.setJgid(user.getHospitalId()); // 机构ID
        yzxxZt.setYjxh(yjxh); // 医技序号(opyjcf01表主键)
        //op_yj02_zt表 YLXH 医疗序号(4检查对应dicc_zlsfdz表ZLXMID；5检验对应op_zt01表组套编号7康复治疗 对应到zl_sqdmx的jlxh)
        yzxxZt.setYlxh(zt.getZtbh()); // 医疗序号=组套编号
        yzxxZt.setXmlx(StatusEnum.Xmlx.JY.getCode()); // 项目类型=检验
        yzxxZt.setYjzx(0);//医技主项
        yzxxZt.setYldj(ztxmdj); // 医疗单价
        yzxxZt.setYlsl(BigDecimal.ONE); // 医疗数量
        yzxxZt.setHjje(ztxmdj.multiply(yzxxZt.getYlsl())); // 划价金额
        yzxxZt.setFygb(9); // 费用归并,取DIC_SFXMLB收费名称为化验费的值=9
        yzxxZt.setZfbl(BigDecimal.ONE); // 自负比例 组套不显示自负比例
        //yzxxZt.setBzxx(null);//备注信息
        yzxxZt.setDzbl(BigDecimal.ONE); // 打折比例
        yzxxZt.setYjzh(maxYjzh); // 医技组号
        yzxxZt.setZfpb(StatusEnum.Zfpb.NO.getCode());//作废判别
        //yzxxZt.setSpbh(null);//审批编号
        yzxxZt.setDjzt(StatusEnum.Djzt.ZC.getCode());//单据状态()
        yzxxZt.setZtbh(zt.getZtbh());//组套编号
        yzxxZt.setZxpb(StatusEnum.Zxpb.WZX.getCode());//执行判别
        //yzxxZt.setSqdh(null);//申请单号
        //yzxxZt.setXflsh(null);//
        yzxxZt.setZtbz(StatusEnum.Ztbz.YES.getCode());//组套标志
        yzxxZt.setFymc(zt.getZtmc());//组套名称
        yzxxZt.setJzlsh(jzlsh);//就诊流水号
        opYj02ZtDao.insert(yzxxZt);

        return yzxxZt.getSbxh();
    }

    //判断项目是否作废，若作废不能保存并给出提示
    private void checkYz(List<JySqdReqXmDetail> details) {
        String zfxmMc = "";
        for (JySqdReqXmDetail xm : details) {
            Map<String, Object> parameters = new HashMap<>(16);
            parameters.put("fyxh", xm.getXmbh());
            parameters.put("zfpb", 0);
            List<FeeYlsfxmdjModel> ylmxList = feeYlsfxmdjService.findByEntity(parameters);
            if (ylmxList.isEmpty()) {
                zfxmMc += ObjectToTypes.parseString(xm.getYzmc()) + ", ";
            }
        }
        if (zfxmMc.length() > 0) {
            throw BaseException.create("ERROR_DCTWORK_OP_0014", new String[]{zfxmMc});
        }
    }

    // 保存yjcf02
    private OpYjcf02Req saveYjcf02(JySqdReqXmDetail detail, int yzzhShow, Map<String, Object> zt01, Integer brxz, Integer jgid, Integer brks) {
        OpYjcf02Req yj02 = new OpYjcf02Req();

        if (!zt01.containsKey(detail.getJlbh().toString())) {
            yj02.setZtbz(0); // 组套标志 非组套医嘱
            yzzhShow += 1;
        } else {
            yj02.setZtbz(1);// 组套标志 组套医嘱
            yj02.setZtyzsbxh(ObjectToTypes.parseInt(zt01.get(detail.getJlbh().toString())));
        }

        //判断是否是商保病人====================================================
        Map<String, Object> param = ParamUtil.instance().put("fyxh", detail.getXmbh());
        // 查询该组套下面的项目明细
        //判断病人性质是否是医保病人
        if(brxz != null && "6024".equals(brxz.toString())){
            param.put("type", "1");//商保病人
        }else{
            param.put("type", "2");//非商保病人
        }
        Map<String, Object> fymx = feeYlsfxmOutSer.getBxInfo(param);

        yj02.setYjzh(yzzhShow);// 医技组号
        yj02.setJgid(jgid); // 机构ID
        yj02.setYlxh(ObjectToTypes.parseInt(fymx.get("fyxh")));// 医疗序号=费用序号
        yj02.setXmlx(4);// 项目类型 4检验,5检查,6手术,7治疗,8护理,9饮食,10卫材,99其他
        yj02.setYldj(ObjectToTypes.parseBigDecimal(fymx.get("bzjg")));// 医疗单价=费用单价
        yj02.setYlsl(new BigDecimal(detail.getFysl()));// 医疗数量
        yj02.setYjzx(0);// 医技主项
        yj02.setDzbl(BigDecimal.ONE);// 打折比例============================================
        yj02.setKsdm(brks);// 科室代码
        yj02.setFydw(ObjectToTypes.parseString(fymx.get("fydw")));// 费用单位
        yj02.setHjje(ObjectToTypes.parseBigDecimal(fymx.get("bzjg")).multiply(ObjectToTypes.parseBigDecimal(detail.getFysl())));// 合计金额=============================
        yj02.setFymc(ObjectToTypes.parseString(fymx.get("fymc")));// 费用名称
        yj02.setZtbh(detail.getZtbh());

        // 获取病人自负比例
        Integer ypxh = ObjectToTypes.parseInt(fymx.get("fyxh"));// 费用序号
        Integer fygb = mzUtil.getfygb(0, ypxh);// 获取费用归并
        Map<String, Object> zfblMap = mzUtil.getPayProportion(brxz, fygb, 0, ypxh);
        yj02.setZfbl(ObjectToTypes.parseBigDecimal(zfblMap.get("ZFBL")));// 自负比例
        yj02.setFygb(fygb);// 费用归并

        return yj02;
    }

    /**
     * 保存组套
     * @param jgid
     * @param ztbh
     * @param yzzhShow
     * @param ztmc
     * @param jzlsh
     * @param xmDetails
     * @return
     */
    private OpYjcf02Zt saveYjcf02Zt(Integer jgid, Integer ztbh, int yzzhShow, String ztmc, String jzlsh, List<Map<String, Object>> xmDetails) {
        BigDecimal ypdj = BigDecimal.ZERO;
        for (Map<String, Object> xm : xmDetails) {
            ypdj = ypdj.add(ObjectToTypes.parseBigDecimal(xm.get("fydj")).multiply(ObjectToTypes.parseBigDecimal(xm.get("fysl"))));
        }
//        for (JySqdReqXmDetail xm : xmDetails) {
//            ypdj = ypdj.add(ObjectToTypes.parseBigDecimal(xm.getFydj()).multiply(ObjectToTypes.parseBigDecimal(xm.getFysl())));
//        }
        OpYjcf02Zt yzxxZt = new OpYjcf02Zt(); // 组套信息
        yzxxZt.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJ02_ZT)); // 主键
        yzxxZt.setZtbz(1); // 组套标志(该条医嘱存是组套信息) 0非组套标志，1组套标志
        yzxxZt.setJgid(jgid); // 机构ID
        yzxxZt.setYjxh(1); // 医技序号
        yzxxZt.setYlxh(ztbh); // 医疗序号=组套编号
        yzxxZt.setXmlx(4); // 项目类型=检验
        yzxxZt.setYjzx(0); // 项目主项
        yzxxZt.setYldj(ypdj); // 医疗单价
        yzxxZt.setYlsl(BigDecimal.ONE); // 医疗数量
        yzxxZt.setHjje(ypdj); // 划价金额
        yzxxZt.setFygb(9); // 费用归并,取DIC_SFXMLB收费名称为化验费的值=9
        yzxxZt.setZfbl(BigDecimal.ONE); // 自负比例 组套不显示自负比例
        yzxxZt.setDzbl(BigDecimal.ONE); // 打折比例
        yzxxZt.setYjzh(yzzhShow); // 医技组号
        yzxxZt.setFymc(ztmc); // 费用名称
        yzxxZt.setJzlsh(jzlsh);
        opYj02ZtDao.insert(yzxxZt);

        return yzxxZt;
    }

    //判断组套信息是否全选
    private boolean ztSelectAll(List<JySqdReqXmDetail> details, List<Map<String, Object>> xmDetails) {
        boolean hasZt = true;// 该组套项目明细全选
        for (Map<String, Object> xm : xmDetails) {
            boolean hasXm = false;// 该明细项目被选中
            for (JySqdReqXmDetail yz : details) {
                if (ObjectToTypes.parseInt(xm.get("jlbh")) == yz.getJlbh()) {
                    hasXm = true;
                    break;
                }
            }
            if (!hasXm) {
                hasZt = false;
                break;
            }
        }
        return hasZt;
    }

    /**
     * 查询门诊检验申请单数据
     * @param req
     * @return
     */
    public List<QueryJysqdResp> queryJysqdMessage(QueryJysqdReq req,SysUser sysUser){
        if (req != null){
            req.setJgid(sysUser.getHospitalId());
        }
        return opYjcf02Dao.queryJysqdMessage(req);
    }

    /**
     * 查询处置打印数据
     * @param jzlsh
     * @param type 1打印全部 2打印同组 3打印选中
     */
    public CzPrintResponse getCzPrintData(CzPrintRequest request){
        CzPrintResponse czPrintData = opYjcf01Dao.getCzPrintData(request.getJzlsh());
        if (czPrintData == null){
            throw BaseException.create("ERROR_DCTWORK_OP_0079");
        }

        //计算年龄
        if (czPrintData.getCsrq() != null){
            Map<String, Object> personAge = MzUtil.getPersonAge(czPrintData.getCsrq(), new Date());
            czPrintData.setHznl(personAge.get("ages").toString());
        }

        //处理皮试结果
        String psjg = czPrintData.getPsjg();
        if (StrUtil.isBlank(psjg)){
            czPrintData.setPsjg("");
        }else {
            if (psjg.contains("3")){
                czPrintData.setPsjg(StatusEnum.Psjg.YANGX.getVal());
            }else if (psjg.contains("2")){
                czPrintData.setPsjg(StatusEnum.Psjg.YINX.getVal());
            }else{
                czPrintData.setPsjg("");
            }
        }

        //查询处置打印详情数据
        getCzPrintDetail(request,czPrintData);

        return czPrintData;
    }

    /**
     * 查询处置打印详情数据
     * @param request
     * @param czPrintData
     */
    private void getCzPrintDetail(CzPrintRequest request,CzPrintResponse czPrintData){
        if ("1".equals(request.getType())){//1打印全部
            List<CzDetailResponse> czDetails = opYjcf02Dao.getCzByJzlsh(request.getJzlsh());
            if (CollUtil.isEmpty(czDetails)){
                throw BaseException.create("ERROR_DCTWORK_OP_0080");
            }

            czPrintData.setCzDetail(czDetails);

            //计算总价
            calculateTotalPrice(czPrintData,czDetails);
        }else if ("2".equals(request.getType())){//2打印同组
            List<CzPrintData> printData = request.getCzPrintData();
            if (CollUtil.isEmpty(printData)){
                throw BaseException.create("ERROR_DCTWORK_OP_0081");
            }
            List<Integer> yjzhList = printData.stream().map(o -> o.getYjzh()).collect(Collectors.toList());

            List<CzDetailResponse> czDetails = opYjcf02Dao.getCzByYjzhAndJzlsh(yjzhList, request.getJzlsh());
            if (CollUtil.isEmpty(czDetails)){
                throw BaseException.create("ERROR_DCTWORK_OP_0080");
            }

            czPrintData.setCzDetail(czDetails);

            //计算总价
            calculateTotalPrice(czPrintData,czDetails);
        }else if ("3".equals(request.getType())){//3打印选中
            List<CzPrintData> printData = request.getCzPrintData();
            if (CollUtil.isEmpty(printData)){
                throw BaseException.create("ERROR_DCTWORK_OP_0081");
            }
            List<CzDetailResponse> czDetails = new ArrayList<>();
            printData.stream().forEach(o ->{
                //判断选中数据是否为组套
                if (o.getZtbz() != null && o.getZtbz() == 1){
                    //查询组套对应的详情数据
                    List<CzDetailResponse> details = opYjcf02Dao.getCzByztsbxhAndJzlsh(o.getZtsbxh(), request.getJzlsh());
                    czDetails.addAll(details);
                }else {
                    //查询单个详情数据
                    List<CzDetailResponse> details = opYjcf02Dao.getCzBySbxhAndJzlsh(o.getSbxh(), request.getJzlsh());
                    czDetails.addAll(details);
                }
            });
            czPrintData.setCzDetail(czDetails);

            //计算总价
            calculateTotalPrice(czPrintData,czDetails);
        }
    }

    /**
     * 计算总价
     * @param czPrintData
     * @param czDetails
     */
    private void calculateTotalPrice(CzPrintResponse czPrintData,List<CzDetailResponse> czDetails){
        BigDecimal reduce = czDetails.stream().map(o -> o.getHjje() == null ? BigDecimal.ZERO : o.getHjje())
                .reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2,BigDecimal.ROUND_UP);
        czPrintData.setYpje(reduce == null?"":String.valueOf(reduce));
    }
}
