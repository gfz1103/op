package com.buit.cis.op.dctwork.service;


import cn.hutool.core.util.StrUtil;
import com.buit.cis.op.dctwork.request.QueryMzYsFjReq;
import com.buit.cis.op.dctwork.response.FeeYlsfxm;
import com.buit.cis.op.dctwork.response.QueryMzYsFjResp;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.commons.dao.FeeYlsfxmDao;
import com.buit.commons.dao.OpZt01Dao;
import com.buit.commons.response.QueryMzYsFjZtResp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 公用_医疗收费<br>
 * @author 老花生
 */
@SuppressWarnings("ALL")
@Service
public class FeeYlsfxmSer extends BaseManagerImp<FeeYlsfxm,Integer> {

    static final Logger logger = LoggerFactory.getLogger(FeeYlsfxmSer.class);

    @Autowired
    private FeeYlsfxmDao feeYlsfxmDao;
    @Autowired
    private OpZt01Dao opZt01Dao;
    @Autowired
    private OptSsflSer optSsflSer;


    @Override
    public FeeYlsfxmDao getEntityMapper(){
        return feeYlsfxmDao;
    }

    /**
     * 门诊医生工作站-辅检查询
     * @param req
     * @param user
     * @return
     */
    public PageInfo<QueryMzYsFjResp> queryMzYsFj(QueryMzYsFjReq req, SysUser user) {
        Map<String, Object> res = new HashMap<>();
        String searchText = "";
        if (StrUtil.isNotBlank(req.getQuery())){
            searchText = req.getQuery().toUpperCase();
        }
        String syfs = req.getUseType();
        String brxz = req.getBrxz();
        String jgid = user.getHospitalIdStr();
        // 默认搜索方式为PYDM
//        String SEARCH_TYPE = "PYDM";
//        if (syfs == null || syfs.trim().equals("")) {
//            syfs = "MZSY";
//        }
//        if (StringUtil.containsChinese(searchText)) {
//            SEARCH_TYPE = "FYMC";
//        }
        //=======多查出一个医保编码,病人性质如果是医保病人,并且没有医保编码不能开处相应的处置单=======
        // 项目类型XMLX的nvl写法DB2下报错
//        String hql = "select distinct a.YBBM as YBBM,a.FYXH as FYXH,a.FYMC,a.FYDW,a.BZJG,a.XMLX,round(c.FYDJ,2) as FYDJ,a.FYGB,c.FYKS,c.XZSY,c.XZTS,c.XZCS from FEE_YLSFXM a,PUB_FYBM b,FEE_YLSFXMDJ c where a.FYXH=b.FYXH and a.FYXH=c.FYXH and c.ZFPB=0  and a.ZFPB=0 and c.JGID=:JGID and a."
//                + syfs
//                + "=1 and b."
//                + SEARCH_TYPE
//                + " LIKE :Search order by length(a.FYMC),a.FYMC";

        PageInfo<QueryMzYsFjResp> pageInfo ;

        Map<String, Object> queryfjxx = new HashMap<>();
        queryfjxx.put("jgid", jgid);
        queryfjxx.put("search", searchText);
        pageInfo = PageHelper.startPage(req.getPageNum(), req.getPageSize())
                .doSelectPageInfo(() -> feeYlsfxmDao.getfjxxyb(queryfjxx));

//        如果病人性质是商业保险
//        if(("6024").equals(brxz)){
//            Map<String, Object> queryfjxx = new HashMap<>();
//            queryfjxx.put("jgid", jgid);
//            queryfjxx.put("search", searchText);
//            pageInfo = PageHelper.startPage(req.getPageNum(), req.getPageSize())
//                    .doSelectPageInfo(() -> feeYlsfxmDao.getfjxxyb(queryfjxx));
//        }else{
//            Map<String, Object> queryfjxx = new HashMap<>();
//            queryfjxx.put("jgid", jgid);
//            queryfjxx.put("search", searchText);
//            pageInfo = PageHelper.startPage(req.getPageNum(), req.getPageSize())
//                    .doSelectPageInfo(() -> feeYlsfxmDao.getfjxx(queryfjxx));
//        }
        return pageInfo;
    }

    /**
     * 门诊医生工作站-辅检查询-组套
     * @param req
     * @param user
     * @return
     */
    public PageInfo<QueryMzYsFjZtResp> queryMzYsFjZt(QueryMzYsFjReq req, SysUser user) {
        Map<String, Object> res = new HashMap<>();
        String searchText = StrUtil.isNotBlank(req.getQuery())?req.getQuery().toUpperCase():"";
        String jgid = user.getHospitalIdStr();
        String ygdm = user.getUserIdStr();
        String mzks = req.getMzks();
        // 返回-1用以区分是组套数据

        Map<String, Object> queryZt = new HashMap<>(16);
        queryZt.put("jgid", jgid);
        queryZt.put("ygdm", ygdm);
        queryZt.put("ksdm", mzks);
        queryZt.put("search", searchText);

        PageInfo<QueryMzYsFjZtResp> pageInfo = PageHelper.startPage(req.getPageNum(), req.getPageSize())
                .doSelectPageInfo(() -> opZt01Dao.queryZtbhZtmcXmlxSslb(queryZt));

        return pageInfo;
    }


}
