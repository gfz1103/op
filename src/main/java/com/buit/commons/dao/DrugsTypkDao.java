package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.model.DrugsTypk;
import com.buit.commons.model.YpSimpleDto;
import com.buit.commons.request.DrugsTypkPackageSelfPageReq;
import com.buit.commons.request.DrugsTypkSelfPageReq;
import com.buit.commons.request.DrugsYpcdSelfPageReq;
import com.buit.commons.response.DrugsTypkPackagePageResp;
import com.buit.commons.response.DrugsTypkSelfPageResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 药库_药品基本库<br>
 *
 * @author "MLeo"
 */
@Mapper
public interface DrugsTypkDao extends EntityDao<DrugsTypk, Integer> {
    /**
     * 更新备注
     *
     * @param drugsTypk
     */
    void updateRemark(DrugsTypk drugsTypk);

    /**
     * 更新状态
     *
     * @param drugsTypk
     */
    void updateStatus(DrugsTypk drugsTypk);

    /**
     * 根据药房识别和机构id查询药品简要信息
     *
     * @param yfsb
     * @param jgid
     */
    List<YpSimpleDto> queryByYfsbAndJgid(@Param("yfsb") Integer yfsb, @Param("jgid")Integer jgid);

    /**
     * 私用药品信息
     * @param req
     * @return
     */
    List<DrugsTypkSelfPageResp> findSelfPage(DrugsTypkSelfPageReq req);

    /**
     * 查询私用药品信息
     * @param req
     */
    List<DrugsTypk> findSelfByEntity(DrugsYpcdSelfPageReq req);

    /**
     * 查询私用药品包装信息
     * @param req
     */
    List<DrugsTypkPackagePageResp> findPackageSelfByEntity(DrugsTypkPackageSelfPageReq req);

    /**
     * 根据药品序号查询药品基本信息
     * @param list
     */
    List<DrugsTypk> queryByYpxh(@Param("list") List<Integer> list);
    
	/**
	 * 查询药品名称
	 * 
	 * @author wy
	 * @param map
	 * @return
	 */
	Map<String, Object> getYpmc(Map<String, Object> map);

//    /**
//     * 查询出库药品明细数据
//     *
//     * @param req
//     * @return
//     */
//    List<OutStoreDrugDetailResp> queryOutStoreDrugDetail(OutStoreDrugDetailReq req);

    /**
     * 根据ypmc、ypdw、ypgg查询药品信息
     *
     * @param ypmc
     * @param ypdw
     * @param ypgg
     * @return
     */
    DrugsTypk getByYpmcAndYpdwAndYpgg(@Param("ypmc") String ypmc, @Param("ypdw") String ypdw, @Param("ypgg") String ypgg);
//    /**
//     * 门诊药品输入法查询
//     */
//    List<DrugsTypkResp> queryDrugsTypk(DrugsTypkReq req);
//    /**
//     * 自备药输入法查询
//     */
//    List<DrugsTypkResp> queryzibeiyao(DrugsTypkReq req);
//    /**
//	 * 其他入库  cszc 药品输入法查询
//	 */
//	List<SrfCszcResp> querycszc(QuerycszcReq req);
//	List<SrfCszcResp> querycgrk(QuerycszcReq req);
//
//    /**
//     *  药库角色 出库处理  新增  (出库方式:住院药房,门诊药房)
//     */
//    List<SrfCszcResp> queryTagykck(QueryYkckReq req);
//    /**
//     * 药库角色 出库处理  新增  (出库方式:科室领用,盘亏,盘亏出库,申领退药,平账出库,报损,药监局抽样,医药公司退药)
//     */
//    List<SrfTagykckNoyfResp> queryTagykckNoyf(QueryYkckNoyfReq req);
//    /**
//     * 药库角色 出库处理  新增  (出库方式:科室领用,盘亏,盘亏出库,申领退药,平账出库,报损,药监局抽样,医药公司退药)
//     */
//    List<SrfTagytjResp> queryTagtj(QueryYkckNoyfReq req);

    /**
     * 查询检验处方拷贝信息
     * @param params
     * @return
     */
    List<Map<String, Object>> qeuryPerscriptionCopyCheck(Map<String, Object> params);
    

	/**
	 * 过敏药物搜索结果
	 * @Title: queryAllergicDrugsInfo
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param pydm
	 * @param @return    设定文件
	 * @return List<DrugsTypkAllergicResp>    返回类型
	 * @author 龚方舟
	 * @throws
	 */
//	List<DrugsTypkAllergicResp> queryAllergicDrugsInfo(Map<String ,String> par);


    /**
     * 私用药品调入信息列表
     * @param req
     * @return
     * @author 卑军华
     */
    List<DrugsTypkSelfPageResp> findSelfCallinPages(DrugsTypkSelfPageReq req);

    long findCdxxCount(Object entity);

	/**
	 * 查询病区自备药输入法
	 * @Title: querySelfMedicineBq
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param drugsTypkSelfMedicineSrfReq
	 * @param @return    设定文件
	 * @return List<DrugsTypkSelfMedicineBqResp>    返回类型
	 * @author 龚方舟
	 * @throws
	 */
//	List<DrugsTypkSelfMedicineBqResp> querySelfMedicineBq(DrugsTypkSelfMedicineSrfReq drugsTypkSelfMedicineSrfReq);


//	List<SrfYpztResp> queryYpzt(Map<String ,Object> par);


	/**
	 * 查询病区医嘱病区药房包装药品
	 * @Title: queryBqyzYpInpatientWard
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件
	 * @return List<DrugsTypkBqyzYpResp>    返回类型
	 * @author 龚方舟
	 * @throws
	 */
//    List<DrugsTypkBqyzYpResp> queryBqyzYpInpatientWard(DrugsTypkBqyzYpSrfReq drugsTypkBqyzYpSrfReq);

	/**
	 * 查询病区医嘱药品信息包装药品
	 * @Title: queryBqyzYpDrugPackaging
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param drugsTypkBqyzYpSrfReq
	 * @param @return    设定文件
	 * @return List<DrugsTypkBqyzYpResp>    返回类型
	 * @author 龚方舟
	 * @throws
	 */
//	List<DrugsTypkBqyzYpResp> queryBqyzYpDrugPackaging(DrugsTypkBqyzYpSrfReq drugsTypkBqyzYpSrfReq);

	/**
	 * 获取信息
	 *
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getYktypkInfo(Map<String, Object> map);
	
	
	/**
	 * 查询病区医嘱药品和包装信息
	 * @Title: queryDrugInformation
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<Map<String,Object>>    返回类型
	 * @author 龚方舟
	 * @throws
	 */
    List<Map<String, Object>> queryDrugInformation(Map<String, Object> map);

    /**
     * 费用记账药品信息查询
     * @Title: queryDrugAccounting
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param map
     * @param @return    设定文件
     * @return List<DrugsTypkAccountingYpResp>    返回类型
     * @author 龚方舟
     * @throws
     */
//    List<DrugsTypkAccountingYpResp> queryDrugAccounting(Map<String, Object> map);

    long count(Map<String, Object> map );

	/**
	 * 药库转账获取产地信息
	 * @param yksb
	 * @param jgid
	 * @return
	 */
//	List<YkZzCdxxResp> queryZzcdxx(Integer yksb,Integer jgid);

	/**
	 * 药库转账获取库存明细
	 * @param map
	 * @return
	 */
//	DrugsKcmxResp queryZzJesl(Map<String, Object> map);
	List<Map<String,Object>> querySumJekc(Integer yksb,Integer jgid);
	List<Map<String,Object>> querySumKcmx(Integer yksb,Integer jgid);

	/**
	 * 根据药房药房识别、药品序号查询信息
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> findByYfsbYpxh(Map<String, Object> params);

	/**
	 * 根据药房药房识别、药品序号查询信息(药品)
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> findYpByYfsbYpxh(Map<String, Object> params);

	/**
	 * 库存明细查找
	 * @param map
	 * @return
	 */
	long countpharkcmx(Map<String, Object> map );
	long countdrugskcmx(Map<String, Object> map );
	void updateypxx(Map<String, Object> map);
	long countrk01(Map<String, Object> map );
	long countck01(Map<String, Object> map );
	long counttj01(Map<String, Object> map );
	long countpharkcmxs(Map<String, Object> map );
	long countdb01(Map<String, Object> map );
	long countdbrk(Map<String, Object> map );
	long countck02(Map<String, Object> map );
	long updatepharypxx(Map<String, Object> map );

	/**
	 * 私用信息作废
	 * @param map
	 * @return
	 */
	long countspharkcmx(Map<String, Object> map );

	/**
	 * 中心维护-病人性质维护-药品限制-药品输入法
	 * @param pydm
	 * @return
	 */
//	List<YpxzDicResp> queryBrxzYpDic(@Param("pydm") String pydm);

	/**
	 * 查询历史出库单药品详情转为退药处理单药品详情
	 * */
//    List<ImportHistoryDataResp> queryImportHistoryData(ImportHistoryDataReq req);

    /**
	 * 药库出库处理药品选择器
	 * */
//    List<OutStoreProcessResp> ckclSelector(@Param("join") boolean joinYf, @Param("cond") QueryConditionDto cond);
    
    /**
     * 查询病区医嘱药品多产地和包装信息
     * @Title: queryZyYpcdInfo
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @return    设定文件
     * @return List<CisHzyzCommonYpResp>    返回类型
     * @author 龚方舟
     * @throws
     */
//    List<CisHzyzCommonYpResp> queryZyYpcdInfo(Map<String, Object> parameters);
    
    /**
     * 查询病区草药医嘱输入法包装类型为2
     * @Title: queryCisHerbalInpatientWard
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param drugsTypkBqyzYpSrfReq
     * @param @return    设定文件
     * @return List<CisHzyzCommonYpResp>    返回类型
     * @author 龚方舟
     * @throws
     */
//    List<CisHzyzCommonYpResp> queryCisHerbalInpatientWard(DrugsTypkBqyzYpSrfReq drugsTypkBqyzYpSrfReq);
    

    /**
     * 查询病区草药医嘱输入法
     * @Title: queryCisHerbalDrugPackaging
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param drugsTypkBqyzYpSrfReq
     * @param @return    设定文件
     * @return List<CisHzyzCommonYpResp>    返回类型
     * @author 龚方舟
     * @throws
     */
//    List<CisHzyzCommonYpResp> queryCisHerbalDrugPackaging(DrugsTypkBqyzYpSrfReq drugsTypkBqyzYpSrfReq);

}
