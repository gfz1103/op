package com.buit.cis.op.dctwork.ybtspost.dao;

import com.buit.cis.op.dctwork.ybtspost.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *医保智能提醒
 */
@Mapper
public interface YbtspostDao {
    /**
     * 通过就诊流水号查询患者就诊的基本信息数据
     * @param jzlsh
     * @param jgid
     * @return
     */
    PatientJzsj getPatientJzsj(String jzlsh,Integer jgid);

    /**
     * 查询门诊诊断
     * @param jzlsh
     * @param jgid
     * @return
     */
    List<Mzzd> getMzzd(String jzlsh,Integer jgid);

    /**
     * 查询处方药品
     * @param cfsb
     * @param jgid
     * @return
     */
    List<Drug> getDrug(Integer cfsb,Integer jgid);

    /**
     * 通过药品序号和药品产地查询药品信息
     * @param ypxh
     * @param ypcd
     * @param jgid
     * @return
     */
    Drug getDrugByYpxhAndYpcd(Integer ypxh,Integer ypcd,Integer jgid);

    /**
     * 查询服务项目
     * @param jzlsh
     * @param jgid
     * @return
     */
    List<Fwxm> getFwxm(String jzlsh,Integer jgid,Integer ztbh);

    /**
     * 查询组套信息数据
     * @param jzlsh
     * @param jgid
     * @param ztbh
     * @return
     */
    Ztfwxm getztFwxm(String jzlsh, Integer jgid, Integer ztbh);

    /**
     * 查询材料
     * @param jzlsh
     * @param jgid
     * @return
     */
    List<Yycl> getYycl(String jzlsh,Integer jgid);
}
