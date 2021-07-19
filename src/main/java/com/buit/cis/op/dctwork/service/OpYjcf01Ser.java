package com.buit.cis.op.dctwork.service;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.map.MapUtil;
import com.buit.apply.service.Cisjcsqd01Service;
import com.buit.apply.service.OpZt02Service;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.commons.dao.*;
import com.buit.commons.model.OpBrzd;
import com.buit.commons.request.*;
import com.buit.commons.response.*;
import com.buit.constans.TableName;
import com.buit.op.model.OpYjcf01;
import com.buit.op.model.OpYjcf02;
import com.buit.op.request.OpYjcf01Req;
import com.buit.op.request.OpYjcf02Req;
import com.buit.system.model.DicKszd;
import com.buit.system.model.FeeYlsfxmdjModel;
import com.buit.system.response.HrPersonnelModel;
import com.buit.system.response.YjQueryPageHelperResp;
import com.buit.system.service.*;
import com.buit.system.utill.MedicineUtils;
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

import java.math.BigDecimal;
import java.util.*;

/**
 * 门诊_门诊医技单<br>
 * @author 老花生
 */
@SuppressWarnings({"ALL", "AlibabaUndefineMagicConstant"})
@Service
public class OpYjcf01Ser extends BaseManagerImp<OpYjcf01,Integer> {

    static final Logger logger = LoggerFactory.getLogger(OpYjcf01Ser.class);

    @Autowired
    private OpYjcf01Dao opYjcf01Dao;
    @Autowired
    private OpYjcf02Dao opYjcf02Dao;
    @DubboReference
    private SysXtcsCacheSer sysXtcsCacheSer;
    @Autowired
    private OpGhmxDao opGhmxDao;
    @Autowired
    private WlKfdzDao wlKfdzDao;
    @Autowired
    private MzUtil mzUtil;
    @Autowired
    private FeeXmzxksDao feeXmzxksDao;
    @Autowired
    private WlWzkcDao wlWzkcDao;
    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    private OpYjcf02ZtDao opYj02ZtDao;
    @DubboReference
    private FeeYlsfxmOutSer feeYlsfxmOutSer;
    @Autowired
    private OpSbhyDao opSbhyDao;
    @DubboReference
    private Cisjcsqd01Service cisjcsqd01Service;
    @DubboReference
    private OpZt02Service opZt02Service;
    @DubboReference
    private FeeYlsfxmdjService feeYlsfxmdjService;
    @DubboReference
    private ExportFileSer exportFileSer;
    @Autowired
    private PubBrxzDao pubBrxzDao;
    @DubboReference
    private HrPersonnelService hrPersonnelService;
    @Autowired
    private DicYljgDao dicYljgDao;
    @Autowired
    private OpBrzdDao opBrzdDao;
    @DubboReference
    private DiccZlsfdzService diccZlsfdzService;
    @DubboReference
    private DicKszdOutSer dicKszdOutSer;

    @Override
    public OpYjcf01Dao getEntityMapper(){
        return opYjcf01Dao;
    }

    /**
     * 保存医技
     * @param yjReq
     * @param user
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer save(OpYjcf01Req yjReq, SysUser user){
        Integer yjxh = null;
        //已经保存的cf02
        List<OpYjcf02Req> oldList = new ArrayList<>();

        for(OpYjcf02Req yj02Req : yjReq.getBodys()){

            if (yj02Req.getYjxh() != null && yj02Req.getSbxh() != null) {//更新
                //跳过已收费
                Long l = opYjcf01Dao.getIsSfByYjxh(ParamUtil.instance().put("yjxh", yj02Req.getYjxh()));
                if (l > 0) {
                    continue;
                }

                //更新明细
                OpYjcf02 yj02 = com.buit.utill.BeanUtil.toBean(yj02Req, OpYjcf02.class);
                opYjcf02Dao.update(yj02);

                Map<String, Object> parameters = new HashMap<String, Object>(16);
                parameters.put("zxks",  yj02Req.getZxks());
                parameters.put("ksdm",  yj02Req.getKsdm());
                parameters.put("ysdm",  user.getUserId());
                parameters.put("yjxh",  yj02Req.getYjxh());

                //更新主表
                opYjcf01Dao.updateZxksYsdmKsdm(parameters);// 规定病种
            } else {//新增
                // 新插入的一条上一条做对比 如果相同就是同一组 把上一组的yjxh拿过来用
                for(OpYjcf02Req oldyj02 : oldList){
                    if(oldyj02.getYjzh() != null && oldyj02.getYjzh().equals(yj02Req.getYjzh())){
                        yj02Req.setYjxh(oldyj02.getYjxh());// 就设置上一条对应的主表的ID
                    }
                }

                if (yj02Req.getYjxh() == null) {// 如果当前条没有YJXH
                    // 保存主表
                    OpYjcf01 yj01 = new OpYjcf01();
                    yj01.setYjxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.OP_YJCF01));
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
                yj02.setSbxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.OP_YJCF02));
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

            if(yjxh == null){
                yjxh = yj02Req.getYjxh();
            }
        }
        return yjxh;
    }

    /**
     * 保存校验验证
     * @param opYjcf01    请求对象
     * @param user      登录对象
     */
    @SuppressWarnings("AlibabaUndefineMagicConstant")
    public void saveCheck(CheckProjectMaterialsReq req, SysUser user) {
        List<Map<String, Object>> bodys = MzUtil.ListObjToMap(req.getBodys());

        int ghgl = ObjectToTypes.parseInt(req.getGhgl());
        int mzzy = ObjectToTypes.parseInt(req.getMzzy());



        Integer hospitalId = user.getHospitalId();// 用户的机构ID
        String jgid = String.valueOf(user.getHospitalId());// 用户的机构ID

        // '物品计费标志'，'0'表示不启用，‘1’表示启用，默认是‘0’
        int wpjfbz = ObjectToTypes.parseInt(sysXtcsCacheSer.getCsz(hospitalId, "MZWPJFBZ"));

        // '物品计费标志'，'0'表示不启用，‘1’表示启用，默认是‘0’
        int wpjfbzzy = ObjectToTypes.parseInt(sysXtcsCacheSer.getCsz(hospitalId, "WPJFBZ"));

        // '门诊物资收费项目价格'，'0'表示不启用，‘1’表示启用，默认是‘0’
        int wzsfxmjg = ObjectToTypes.parseInt(sysXtcsCacheSer.getCsz(hospitalId, "WZSFXMJG"));

        // '住院物资收费项目价格'，'0'表示不启用，‘1’表示启用，默认是‘0’
        int wzsfxmjgzy = ObjectToTypes.parseInt(sysXtcsCacheSer.getCsz(hospitalId, "WZSFXMJGZY"));

        String hsql = ObjectToTypes.parseString(req.getMzks());// 护士权利。(门诊科室)
        List<Map<String, Object>> kcpdList = new ArrayList<Map<String, Object>>();

        // 如果是门诊mzzy=0 并且 门诊参数开启，如果是住院 mzzy=1 并且 住院参数开启 才能执行。
        boolean b1 = false;
        boolean b2 = false;
        if(wzsfxmjg == 1 && mzzy == 0 && wpjfbz == 1) {
            b1 = true;
        }
        if(wzsfxmjgzy == 1 && mzzy == 1 && wpjfbzzy == 1){
            b2 = true;
        }

        if (b1 || b2) {
            long ksdm = Long.parseLong(hsql);
            Map<String, Object> kfxhMap = new HashMap<String, Object>(16);
            kfxhMap.put("ksdm", ksdm);
            Map<String, Object> map = wlKfdzDao.findObjByMap(kfxhMap);
            if (map != null) {
                int kfxh = Integer.parseInt(map.get("kfxh") + "");
                for (int i = 0; i < bodys.size(); i++) {
                    // 门诊中如果项目收完费了 就不判断。
                    if (bodys.get(i).get("mzxh") != null
                            && bodys.get(i).get("mzxh") != "") {
                        continue;
                    }
                    if (bodys.get(i).get("sbxh") != null) {
                        mzUtil.deleteSupplies(hospitalId, Integer.parseInt(bodys.get(i).get("sbxh")+ ""));
                    }
                    if (bodys.get(i).get("jlxh") != null) {
                        mzUtil.deleteSuppliesZY(hospitalId, Integer.parseInt(bodys.get(i).get("jlxh")+ ""));
                    }
                    String wzmcTs = "";
                    int fyxh = ObjectToTypes.parseInt(bodys.get(i).get("ylxh"));
                    int ylsl = ObjectToTypes.parseInt(Math.round(ObjectToTypes.parseDouble(bodys.get(i).get("ylsl"))));// 数量
                    String fymc = bodys.get(i).get("fymc") + "";

                    Map<String, Object> parMap = new HashMap<String, Object>(16);
                    parMap.put("fyxh", fyxh);
                    parMap.put("jgid", jgid);
                    List<Map<String, Object>> resList = feeXmzxksDao.queryObj(parMap);
                    for (int j = 0; j < resList.size(); j++) {
                        Map<String, Object> kcpdMap = new HashMap<String, Object>(16);

                        int wzxh = ObjectToTypes.parseInt(resList.get(j).get("wzxh"));
                        BigDecimal wzsl = ObjectToTypes.parseBigDecimal(resList.get(j).get("WZSL"));
                        String wzmc1 = ObjectToTypes.parseString(resList.get(j).get("wzmc"));
                        parMap.clear();
                        parMap.put("wzxh", wzxh);
                        parMap.put("kfxh", kfxh);
                        List<Map<String, Object>> compList = wlWzkcDao.querySumNum(parMap);

                        if (compList.size() > 0) {
                            BigDecimal wzslRes = ObjectToTypes.parseBigDecimal(compList.get(0).get("wzsl"));
                            String ykslS = ObjectToTypes.parseString(compList.get(0).get("yksl"));
                            BigDecimal ykslRes = BigDecimal.ZERO;
                            if (ykslS != null) {
                                ykslRes = ObjectToTypes.parseBigDecimal(compList.get(0).get("yksl"));
                            }
                            String wzmc = ObjectToTypes.parseString(compList.get(0).get("wzmc"));
                            BigDecimal kykc = wzslRes.subtract(ykslRes);

                            if (kykc.compareTo(wzsl.multiply(new BigDecimal(ylsl))) == -1) {
                                if (wzmcTs.length() == 0) {
                                    wzmcTs = " " + wzmc;
                                } else {
                                    wzmcTs += "," + wzmc;
                                }
                            } else {
                                kcpdMap.put("wzxh", wzxh);
                                kcpdMap.put("wzsl", wzslRes);
                                kcpdMap.put("yksl", wzsl.multiply(new BigDecimal(ylsl)));
                                kcpdMap.put("wzmc", wzmc);
                                kcpdMap.put("fymc", fymc);
                                kcpdList.add(kcpdMap);
                            }
                        } else {
                            if (wzmcTs.length() == 0) {
                                wzmcTs = " " + wzmc1;
                            } else {
                                wzmcTs += "," + wzmc1;
                            }
                        }

                    }
                    if (wzmcTs.length() > 0) {
                        throw new RuntimeException("项目为：" + fymc
                                + "所对应的的物资名称：" + wzmcTs + "库存不足不能保存!");
                    }
                }
                BigDecimal ykslZ = BigDecimal.ZERO;
                for (int i = 0; i < kcpdList.size(); i++) {
                    int wzxh = ObjectToTypes.parseInt(kcpdList.get(i).get("wzxh"));
                    ykslZ = ObjectToTypes.parseBigDecimal(kcpdList.get(i).get("yksl"));
                    BigDecimal wzsl = ObjectToTypes.parseBigDecimal(kcpdList.get(i).get("wzsl"));
                    String wzmc = ObjectToTypes.parseString(kcpdList.get(i).get("wzmc"));
                    String fymc = ObjectToTypes.parseString(kcpdList.get(i).get("fymc"));

                    for (int j = i + 1; j < kcpdList.size(); j++) {
                        int wzxhj = ObjectToTypes.parseInt(kcpdList.get(j).get("wzxh"));
                        if (wzxh == wzxhj) {
                            fymc += "," + kcpdList.get(j).get("fymc");
                            ykslZ = ykslZ.add(ObjectToTypes.parseBigDecimal(kcpdList.get(j).get("yksl")));
                            if (wzsl.compareTo(ykslZ) == -1) {
                                throw BaseException.create("ERROR_DCTWORK_OP_0007");
                            } else {
                                kcpdList.remove(j);
                                j--;
                            }
                        }
                    }
                }
            }else{
                //throw new RuntimeException("请科室选择药库！");
                throw BaseException.create("ERROR_DCTWORK_OP_0041");
            }
        }
    }

    /**
     * 查询处置列表
     * @param req
     */
    public List<QueryDisposalEntryListResp> queryDisposalEntryList(QueryDisposalEntryListReq req) {
        List<Map<String, Object>> result = new ArrayList<Map<String,Object>>(); // 返回结果
        List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
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
                Map<String,Object> parm = ParamUtil.instance().put("sbxh", MedicineUtils.parseLong(record.get("ztyzsbxh")));
                record = opYj02ZtDao.getZtBySbxh(parm);
                ZTYZSBXH.put(MedicineUtils.parseString(record.get("sbxh")), record);
            }
            result.add(record);
        }
        List<QueryDisposalEntryListResp> resp = MzUtil.ListToResultSet(result, new QueryDisposalEntryListResp());
        return resp;
    }

    /**
     * 医技全部查询（助手方式）
     * @param pydm
     * @param hospitalId
     * @return
     */
    public PageInfo<YjQueryPageHelperResp> queryPageHelper(YjQueryPageHelperReq req, Integer hospitalId) {
        HashMap<Object, Object> map = MapUtil.of(new Object[][]{
                {"jgid", hospitalId},
                {"pydm", req.getPydm()}
        });

        PageInfo<YjQueryPageHelperResp> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> feeYlsfxmOutSer.queryPageHelper(map)
        );
        return pageInfo;
    }

//    /**
//     * 处置明细删除
//     * @param pkey
//     * @return
//     */
//    @Transactional(rollbackFor=Exception.class)
//    public void removeDisposalEntry(Integer sbxh, String type) {
//
//        // 如果根据主键查询得到的门诊序号有值 就不能删除
//        Map<String, Object> parametersMZXH = new HashMap<String, Object>();
//        parametersMZXH.put("sbxh", sbxh);
//        Map<String, Object> mzxh = opYjcf02Dao.queryFphmZfbzBySbxh(parametersMZXH);
//
//        if(mzxh == null){
//            mzxh = opYjcf02Dao.queryZtFphmZfbzBySbxh(parametersMZXH);
//        }
//
//        if (mzxh.get("FPHM") != null && (mzxh.get("ZFBZ") != null && !mzxh.get("ZFBZ")
//                .toString().equals("1"))) {
//            if("1".equals(mzxh.get("ZFBZ").toString())){
//                throw BaseException.create("ERROR_DCTWORK_OP_0037");
//            }else{
//                throw BaseException.create("ERROR_DCTWORK_OP_0036");
//            }
//
//        }
//
//        int ztbz = ObjectToTypes.parseInt(mzxh.get("ztbz"));
//
//        // 组套数据
//        if (ztbz == 1) {
//            if ("1".equals(type)){// 本张医技单只有一条组套数据时，删除操作
//                // 删除OP_YJCF02表
//                opYjcf02Dao.removeByEntity(ParamUtil.instance().put("ztyzsbxh", mzxh.get("sbxh")));
//
//                // 删除OP_YJ02_ZT表
//                opYj02ZtDao.removeByEntity(ParamUtil.instance().put("sbxh", mzxh.get("sbxh")));
//
//                //放出CIS_JCSQ01占用的号源
//                opSbhyDao.updateSfyySfdjDjys(ParamUtil.instance().put("yjxh", mzxh.get("yjxh")));
//
//                // 删除CIS_JCSQ01表
//                cisjcsqd01Service.deleteByJcxh(ParamUtil.instance().put("yjxh", mzxh.get("yjxh")));
//
//                // 删除OP_YJCF01表
//                if(ObjectUtil.isNotEmpty(mzxh.get("yjxh"))){
//                    opYjcf01Dao.removeByEntity(ParamUtil.instance().put("yjxh", mzxh.get("yjxh")));
//                }
//
//            }else {// 本张医技单有多条组套数据时，删除操作
//                // 删除OP_YJCF02表
//                opYjcf02Dao.removeByEntity(ParamUtil.instance().put("ztyzsbxh", mzxh.get("sbxh")));
//
//                // 删除OP_YJ02_ZT表
//                opYj02ZtDao.removeByEntity(ParamUtil.instance().put("sbxh", mzxh.get("sbxh")));
//
//                //放出CIS_JCSQ01占用的号源
//                opSbhyDao.updateSfyySfdjDjys(ParamUtil.instance().put("yjxh", mzxh.get("yjxh")));
//
//                // 删除CIS_JCSQ01表
//                if(ObjectUtil.isNotEmpty(mzxh.get("yjxh"))){
//                    opYjcf01Dao.removeByEntity(ParamUtil.instance().put("yjxh", mzxh.get("yjxh")));
//                }
//            }
//        } else {// 非组套数据
//            opYjcf02Dao.removeByEntity(ParamUtil.instance().put("yjxh", mzxh.get("yjxh")));// 删明细
//            if ("1".equals(type)) {// 删除医技主项
//                opYjcf01Dao.deleteById(ObjectToTypes.parseInt(mzxh.get("yjxh")));// 删主表
//            }
//        }
//    }

    /**
     * 根据组套载入组套明细信息
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

        for (Map<String, Object> med : meds) {
            if (!"1".equals(med.get("mzsy") + "")) {
                med.put("errorMsg", "不存在!");
                res.add(med);
                continue;
            }
            if(req.getZt02Jlbh().size() > 0) { //部分明细调入
                Set<Integer> set=new HashSet<Integer>();
                set.addAll(req.getZt02Jlbh());
                Integer jlbh = ObjectToTypes.parseInt(med.get("jlbh"));
                if(!set.contains(jlbh)){
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

            res.add(med);
        }

        return MzUtil.ListToResultSet(res, new YjLoadPersonalSetResp());
    }

    public void doQueryIsNeedVerify(Map<String, Object> body, Map<String, Object> res, SysUser user){
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
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("brid", brid);
        params.put("ylxh", fyxh);
        params.put("xzts", cn.hutool.core.date.DateUtil.offsetDay(new Date(), xzts));
        params.put("jgid", jgid);
        Map<String,Object> m = opYjcf02Dao.queryYlsl(params);

        res.put("body", m);

    }

    /**
     * 根据组套载入组套明细信息（全院-科室）
     * @param req
     * @return
     */
    public Integer saveDisposalSet(SaveDisposalSetReq req, SysUser user) {
        Integer sbxh = null;

        Map<String, Object> detailsParameter = new  HashMap<String, Object>();
        detailsParameter.put("ztbh", req.getZtbh());
        detailsParameter.put("brxz", req.getBrxz());
        List<Map<String, Object>> details = opZt02Service.queryXmbhYzmcFydj(detailsParameter);

        // 判断项目是否作废，若作废不能保存并给出提示
        String zfxmMC = "";
        for (Map<String, Object> xm : details) {
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("fyxh", MedicineUtils.parseLong(xm.get("xmbh")));
            parameters.put("zfpb", 0);
            List<FeeYlsfxmdjModel> list = feeYlsfxmdjService.findByEntity(parameters);
            if(list == null || list.isEmpty()){
                zfxmMC += MedicineUtils.parseString(xm.get("yzmc")) + ", ";
            }
        }
        if (zfxmMC.length() > 0) {
            zfxmMC = zfxmMC.substring(0, zfxmMC.lastIndexOf(","));
            throw BaseException.create("ERROR_DCTWORK_OP_0039", new String[]{zfxmMC});
        }

        BigDecimal ypdj = BigDecimal.ZERO;
        for (Map<String, Object> xm : details) {
            ypdj = ypdj.add(ObjectToTypes.parseBigDecimal(xm.get("fydj")));
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
        yzxx_zt.put("fymc", req.getZtmc()); // 费用名称

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
            if(req.getBrxz() != null && "6024".equals(req.getBrxz())){
                //商保病人
                param.put("type", "1");
            }else{
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
     * @param fyxh
     * @param brid
     * @param xzts
     * @param hospitalId
     */
    public Long queryIsNeedVerify(Integer fyxh, Integer brid, Integer xzts, Integer hospitalId) {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("brid", brid);
        params.put("ylxh", fyxh);
        params.put("xzts", cn.hutool.core.date.DateUtil.offsetDay(new Date(), -xzts));
        params.put("jgid", hospitalId);

        return opYjcf01Dao.queryIsNeedVerify(params);
    }

    /**
     * @name: yjPrint
     * @description: 医技打印
     * @return: java.lang.String
     * @date: 2020/8/28 14:35
     * @auther: 老花生
     *
     * @param req
     */
    public String yjPrint(YjPrintReq req) {
        String jasperName = "Treatment.jasper";
        Map<String, Object> params = getCfPringParameters(req);
        List<Map<String, Object>> list = getCfPringFields(req);
        String url = exportFileSer.reportHtml(list, params, jasperName);
        return url;
    }

    private List<Map<String, Object>> getCfPringFields(YjPrintReq req) {

        List<Map<String, Object>> records = new ArrayList<>();

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("JGID", req.getJgid());
        int n = 1;

        BigDecimal totalPrice=new BigDecimal("0.00");
        for (String yjxh : req.getYjxhList().split(",")) {
            Map<String, Object> parametersmx = new HashMap<String, Object>();
            parametersmx.put("YJXH", yjxh);
            List<Map<String, Object>> cflist = opYjcf02Dao.queryFymcYldjHjjeByYjxh(parametersmx);
            for (int j = 0; j < cflist.size(); j++) {
                cflist.get(0).put("XH", n + "、");
                if(Double.parseDouble(cflist.get(j).get("ZFBL")+"")>1){
                    double YLDJ = Double.parseDouble(cflist.get(j).get("YLDJ")+"")*Double.parseDouble(cflist.get(j).get("ZFBL")+"");
                    double HJJE = Double.parseDouble(cflist.get(j).get("HJJE")+"")*Double.parseDouble(cflist.get(j).get("ZFBL")+"");

                    cflist.get(j).put("YLDJ", YLDJ);
                    cflist.get(j).put("HJJE", HJJE);
                }
                totalPrice=totalPrice.add(new BigDecimal(cflist.get(j).get("HJJE")+""));
                cflist.get(j).put("YLCLF", totalPrice);
                records.add(cflist.get(j));
            }
            n++;
        }

        return records;
    }

    private Map<String, Object> getCfPringParameters(YjPrintReq req) {
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
            } else{
                response.put("JZHM", "");
            }



            String ksmc = "";
            if (cf.get("KSDM") != null) {
//                Map<String, Object> param = ParamUtil.instance().put("organizcode", jgid)
//                        .put("id", ObjectToTypes.parseInt(cf.get("KSDM")));
                DicKszd ret = dicKszdOutSer.getById(ObjectToTypes.parseInt(cf.get("KSDM")));
//                List<DicKszd> ret = dicKszdDao.findByEntity(param);
                if(ret != null){
                    ksmc = ret.getOfficename();
                }
            }
            String xzmc = "";
            Boolean isVIP = false;//是否是VIP病人
            if (cf.get("BRXZ") != null) {
                xzmc = pubBrxzDao.getById(ObjectToTypes.toInt(cf.get("BRXZ"))).getXzmc();

                //获取VIP
                String VIPBRXZ = sysXtcsCacheSer.getCsz(jgid, BUHISSystemArgument.VIPBRXZ);
                String[] VIPBRXZS =  VIPBRXZ.split(",");
                for (int i=0;i<VIPBRXZS.length;i++) {
                    if(VIPBRXZS[i].toString().equals(cf.get("BRXZ").toString())){
                        isVIP=true;
                    }
                }
            }
            String ygxm = "";
            if (cf.get("YSDM") != null) {
                HrPersonnelModel hrPersonnel=hrPersonnelService.getPersonnelById(Integer.valueOf(cf.get("YSDM").toString()));
    			if(hrPersonnel != null ){
    				ygxm =hrPersonnel.getPersonname();
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

            String jgname = dicYljgDao.getById(jgid).getHospitalName();

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
            zdparameters.put("JZXH", jzxh);
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
     * @name: queryAuxiliaryReportList
     * @description: 查询辅助报告检验申请列表
     * @param req
     * @return: java.util.List<com.buit.cis.op.dctwork.response.QueryAuxiliaryReportListResp>
     * @date: 2020/9/2 16:08
     * @auther: 朱智
     *
     */
    public List<QueryAuxiliaryReportListResp> queryAuxiliaryJyReportList(QueryDisposalEntryListReq req) {
        return opYjcf01Dao.queryAuxiliaryJyReportList(req);
    }

    /**
     * @name: queryAuxiliaryJyDetail
     * @description: 查询辅助报告检验明细信息
     * @param req
     * @return: java.util.List<com.buit.cis.op.dctwork.response.QueryAuxiliaryJyDetailResp>
     * @date: 2020/9/3 10:19
     * @auther: 朱智
     *
     */
    public List<QueryAuxiliaryJyDetailResp> queryAuxiliaryJyDetail(QueryAuxiliaryJyDetailReq req) {
        return opYjcf01Dao.queryAuxiliaryJyDetail(req);
    }

    /**
     * @name: delById
     * @description: 辅助报告检验删除
     * @param yjxh
     * @return: void
     * @date: 2020/9/3 15:34
     * @auther: 朱智
     *
     */
    @Transactional(rollbackFor = Exception.class)
    public void delById(Integer yjxh) {
        OpYjcf01 yj = opYjcf01Dao.getById(yjxh);
        if(yj == null || yj.getYjxh() == null){
            throw BaseException.create("ERROR_DCTWORK_OP_0043");
        }
        opYjcf02Dao.removeByEntity(ParamUtil.instance().put("yjxh", yjxh));
        opYjcf01Dao.deleteById(yjxh);
    }

    /**
     * @name: checkAddYj
     * @description: 添加医技校验
     * @param type
     * @param jzlsh
     * @param ylxhs
     * @param zlxmids
     * @param xmbhs
     * @return: void
     * @date: 2020/9/14 10:31
     * @auther: 朱智
     *
     */
    public Boolean checkAddYj(Integer type, String jzlsh, String ylxhs, String zlxmids, String xmbhs) {
        if(type.intValue() == 1 || type.intValue() == 7){
            List<OpYjcf02> list = opYjcf02Dao.findByEntity(ParamUtil.instance().put("jzlsh", jzlsh));
            String[] ylxhList = ylxhs.split(",");
            for(OpYjcf02 yj : list){
                for(String yjxh : ylxhList){
                    if(yj.getYlxh().intValue() == ObjectToTypes.parseInt(yjxh)){
                        return false;
                    }
                }
            }
        }else if(type.intValue() == 2){
            List<OpYjcf02> list = opYjcf02Dao.findByEntity(ParamUtil.instance().put("jzlsh", jzlsh));
            List<Integer> fyxhList = diccZlsfdzService.getListByZlxmidList(zlxmids.split(","));
            for(OpYjcf02 yj : list){
                for(Integer yjxh : fyxhList){
                    if(yj.getYlxh().intValue() == yjxh.intValue()){
                        return false;
                    }
                }
            }
        }else if(type.intValue() == 3){
            List<OpYjcf02> list = opYjcf02Dao.findByEntity(ParamUtil.instance().put("jzlsh", jzlsh));
            String[] ylxhList = xmbhs.split(",");
            for(OpYjcf02 yj : list){
                for(String yjxh : ylxhList){
                    if(yj.getYlxh().intValue() == ObjectToTypes.parseInt(yjxh)){
                        return false;
                    }
                }
            }
        }else{
            return false;
        }
        return true;
    }

    /**
     * 通过手术申请id查询医技数据
     * @param sssqId
     * @return
     */
    public OpYjcf01 queryBysssqId(Integer sssqId){
        return opYjcf01Dao.queryBySssqId(sssqId);
    }
}
