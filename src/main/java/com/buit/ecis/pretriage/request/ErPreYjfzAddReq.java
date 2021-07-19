
package com.buit.ecis.pretriage.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;


/**
 * 类名称：ErPreYjfz<br>
 * 类描述：急诊预检分诊<br>
 * @author 朱智
 */
@ApiModel(value="急诊预检分诊-新增-请求")
public class ErPreYjfzAddReq extends  PageQuery{
    @ApiModelProperty(value="急诊流水号")
    private Integer lsh;
    @ApiModelProperty(value="医疗机构代码")
    private Integer jgid;
    @ApiModelProperty(value="卡号")
    private String kh;
    @NotBlank(message = "姓名 不能为空")
    @ApiModelProperty(value="姓名")
    private String xm;
    @NotBlank(message = "性别 不能为空")
    @ApiModelProperty(value="性别")
    private String xb;
    @ApiModelProperty(value="出生日期(yyyy-MM-dd)")
    private String csny;
    @ApiModelProperty(value="年龄")
    private Integer nl;
    @ApiModelProperty(value="年龄单位")
    private String nldw;
    @ApiModelProperty(value="证件类型代码")
    private String zjlx;
    @ApiModelProperty(value="证件号码")
    private String zjhm;
    @ApiModelProperty(value="联系方式")
    private String lxfs;
    @ApiModelProperty(value="现住址(省)")
    private String xzzsf;
    @ApiModelProperty(value="现住址(市)")
    private String xzzs;
    @ApiModelProperty(value="现住址(县/区)")
    private String xzzx;
    @ApiModelProperty(value="详细住址")
    private String xxzz;
    @NotBlank(message = "来院方式 不能为空")
    @ApiModelProperty(value="来院方式")
    private String lyfs;
    @NotNull(message = "来诊时间 不能为空")
    @ApiModelProperty(value="来诊时间")
    private Timestamp lzsj;
    @NotNull(message = "体温 不能为空")
    @ApiModelProperty(value="体温")
    private Double tw;
    @NotNull(message = "脉搏 不能为空")
    @ApiModelProperty(value="脉搏")
    private Integer mb;
    @NotNull(message = "呼吸 不能为空")
    @ApiModelProperty(value="呼吸")
    private Integer hx;
    @NotNull(message = "血压（舒张压） 不能为空")
    @ApiModelProperty(value="血压（舒张压）")
    private Integer xyszy;
    @NotNull(message = "血压（收缩压） 不能为空")
    @ApiModelProperty(value="血压（收缩压）")
    private Integer xyssy;
    @NotNull(message = "血氧饱和度 不能为空")
    @ApiModelProperty(value="血氧饱和度")
    private Integer xybhd;
    @NotNull(message = "心率 不能为空")
    @ApiModelProperty(value="心率")
    private Integer xl;
    @NotBlank(message = "意识状态 不能为空")
    @ApiModelProperty(value="意识状态")
    private String yszt;
    @NotNull(message = "SEWS评分 不能为空")
    @ApiModelProperty(value="SEWS评分")
    private Integer sewspf;
    @NotNull(message = "疼痛评分 不能为空")
    @ApiModelProperty(value="疼痛评分")
    private Integer ttpf;
    @ApiModelProperty(value="系统评级1/2/3/4")
    private String xtpj;
    @NotBlank(message = "病人评级 不能为空")
    @ApiModelProperty(value="病人评级1/2/3/4")
    private String brpj;
    @NotNull(message = "分诊科室 不能为空")
    @ApiModelProperty(value="分诊科室代码")
    private Integer fzksdm;
    @ApiModelProperty(value="医生代码")
    private Integer ysdm;
    @ApiModelProperty(value="分诊护士代码")
    private Integer fzhsdm;
    @ApiModelProperty(value="离开时间")
    private Timestamp lksj;
    @ApiModelProperty(value="去向")
    private String qx;
    @ApiModelProperty(value="停留时间（分钟）")
    private Double tlsj;
    @ApiModelProperty(value="分诊时间")
    private Timestamp fzsj;
    @ApiModelProperty(value="状态：1 在院/2 离院/3 取消 4/挂号")
    private String zt;
    @ApiModelProperty(value="主诉")
    @NotBlank(message = "主诉不能为空")
    private String zs;
//    @NotNull(message = "主诉集合")
    @ApiModelProperty(value="主诉集合")
    private List<String> zsList;
    private String drzt;

    public String getCsny() {
        return csny;
    }

    public void setCsny(String csny) {
        this.csny = csny;
    }

    /**
     * 设置:医疗机构代码
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /**
     * 获取:医疗机构代码
     */
    public Integer getJgid() {
        return jgid;
    }
    /**
     * 设置:卡号
     */
    public void setKh(String value) {
        this.kh = value;
    }
    /**
     * 获取:卡号
     */
    public String getKh() {
        return kh;
    }
    /**
     * 设置:姓名
     */
    public void setXm(String value) {
        this.xm = value;
    }
    /**
     * 获取:姓名
     */
    public String getXm() {
        return xm;
    }
    /**
     * 设置:性别
     */
    public void setXb(String value) {
        this.xb = value;
    }
    /**
     * 获取:性别
     */
    public String getXb() {
        return xb;
    }
    /**
     * 设置:年龄
     */
    public void setNl(Integer value) {
        this.nl = value;
    }
    /**
     * 获取:年龄
     */
    public Integer getNl() {
        return nl;
    }
    /**
     * 设置:年龄单位
     */
    public void setNldw(String value) {
        this.nldw = value;
    }
    /**
     * 获取:年龄单位
     */
    public String getNldw() {
        return nldw;
    }
    /**
     * 设置:证件类型代码
     */
    public void setZjlx(String value) {
        this.zjlx = value;
    }
    /**
     * 获取:证件类型代码
     */
    public String getZjlx() {
        return zjlx;
    }
    /**
     * 设置:证件号码
     */
    public void setZjhm(String value) {
        this.zjhm = value;
    }
    /**
     * 获取:证件号码
     */
    public String getZjhm() {
        return zjhm;
    }
    /**
     * 设置:联系方式
     */
    public void setLxfs(String value) {
        this.lxfs = value;
    }
    /**
     * 获取:联系方式
     */
    public String getLxfs() {
        return lxfs;
    }
    /**
     * 设置:现住址(省)
     */
    public void setXzzsf(String value) {
        this.xzzsf = value;
    }
    /**
     * 获取:现住址(省)
     */
    public String getXzzsf() {
        return xzzsf;
    }
    /**
     * 设置:现住址(市)
     */
    public void setXzzs(String value) {
        this.xzzs = value;
    }
    /**
     * 获取:现住址(市)
     */
    public String getXzzs() {
        return xzzs;
    }
    /**
     * 设置:现住址(县/区)
     */
    public void setXzzx(String value) {
        this.xzzx = value;
    }
    /**
     * 获取:现住址(县/区)
     */
    public String getXzzx() {
        return xzzx;
    }
    /**
     * 设置:详细住址
     */
    public void setXxzz(String value) {
        this.xxzz = value;
    }
    /**
     * 获取:详细住址
     */
    public String getXxzz() {
        return xxzz;
    }
    /**
     * 设置:来院方式
     */
    public void setLyfs(String value) {
        this.lyfs = value;
    }
    /**
     * 获取:来院方式
     */
    public String getLyfs() {
        return lyfs;
    }
    /**
     * 设置:来诊时间
     */
    public void setLzsj(Timestamp value) {
        this.lzsj = value;
    }
    /**
     * 获取:来诊时间
     */
    public Timestamp getLzsj() {
        return lzsj;
    }
    /**
     * 设置:体温
     */
    public void setTw(Double value) {
        this.tw = value;
    }
    /**
     * 获取:体温
     */
    public Double getTw() {
        return tw;
    }
    /**
     * 设置:脉搏
     */
    public void setMb(Integer value) {
        this.mb = value;
    }
    /**
     * 获取:脉搏
     */
    public Integer getMb() {
        return mb;
    }
    /**
     * 设置:呼吸
     */
    public void setHx(Integer value) {
        this.hx = value;
    }
    /**
     * 获取:呼吸
     */
    public Integer getHx() {
        return hx;
    }
    /**
     * 设置:血压（舒张压）
     */
    public void setXyszy(Integer value) {
        this.xyszy = value;
    }
    /**
     * 获取:血压（舒张压）
     */
    public Integer getXyszy() {
        return xyszy;
    }
    /**
     * 设置:血压（收缩压）
     */
    public void setXyssy(Integer value) {
        this.xyssy = value;
    }
    /**
     * 获取:血压（收缩压）
     */
    public Integer getXyssy() {
        return xyssy;
    }
    /**
     * 设置:血氧饱和度
     */
    public void setXybhd(Integer value) {
        this.xybhd = value;
    }
    /**
     * 获取:血氧饱和度
     */
    public Integer getXybhd() {
        return xybhd;
    }
    /**
     * 设置:心率
     */
    public void setXl(Integer value) {
        this.xl = value;
    }
    /**
     * 获取:心率
     */
    public Integer getXl() {
        return xl;
    }
    /**
     * 设置:意识状态
     */
    public void setYszt(String value) {
        this.yszt = value;
    }
    /**
     * 获取:意识状态
     */
    public String getYszt() {
        return yszt;
    }
    /**
     * 设置:SEWS评分
     */
    public void setSewspf(Integer value) {
        this.sewspf = value;
    }
    /**
     * 获取:SEWS评分
     */
    public Integer getSewspf() {
        return sewspf;
    }
    /**
     * 设置:疼痛评分
     */
    public void setTtpf(Integer value) {
        this.ttpf = value;
    }
    /**
     * 获取:疼痛评分
     */
    public Integer getTtpf() {
        return ttpf;
    }
    /**
     * 设置:系统评级1/2/3/4
     */
    public void setXtpj(String value) {
        this.xtpj = value;
    }
    /**
     * 获取:系统评级1/2/3/4
     */
    public String getXtpj() {
        return xtpj;
    }
    /**
     * 设置:病人评级1/2/3/4
     */
    public void setBrpj(String value) {
        this.brpj = value;
    }
    /**
     * 获取:病人评级1/2/3/4
     */
    public String getBrpj() {
        return brpj;
    }
    /**
     * 设置:分诊科室代码
     */
    public void setFzksdm(Integer value) {
        this.fzksdm = value;
    }
    /**
     * 获取:分诊科室代码
     */
    public Integer getFzksdm() {
        return fzksdm;
    }
    /**
     * 设置:医生代码
     */
    public void setYsdm(Integer value) {
        this.ysdm = value;
    }
    /**
     * 获取:医生代码
     */
    public Integer getYsdm() {
        return ysdm;
    }
    /**
     * 设置:分诊护士代码
     */
    public void setFzhsdm(Integer value) {
        this.fzhsdm = value;
    }
    /**
     * 获取:分诊护士代码
     */
    public Integer getFzhsdm() {
        return fzhsdm;
    }
    /**
     * 设置:离开时间
     */
    public void setLksj(Timestamp value) {
        this.lksj = value;
    }
    /**
     * 获取:离开时间
     */
    public Timestamp getLksj() {
        return lksj;
    }
    /**
     * 设置:去向
     */
    public void setQx(String value) {
        this.qx = value;
    }
    /**
     * 获取:去向
     */
    public String getQx() {
        return qx;
    }
    /**
     * 设置:停留时间（分钟）
     */
    public void setTlsj(Double value) {
        this.tlsj = value;
    }
    /**
     * 获取:停留时间（分钟）
     */
    public Double getTlsj() {
        return tlsj;
    }
    /**
     * 设置:分诊时间
     */
    public void setFzsj(Timestamp value) {
        this.fzsj = value;
    }
    /**
     * 获取:分诊时间
     */
    public Timestamp getFzsj() {
        return fzsj;
    }
    /**
     * 设置:状态：1 在院/2 离院/3 取消 4/挂号
     */
    public void setZt(String value) {
        this.zt = value;
    }
    /**
     * 获取:状态：1 在院/2 离院/3 取消 4/挂号
     */
    public String getZt() {
        return zt;
    }
    /**
     * 设置:主诉
     */
    public void setZs(String value) {
        this.zs = value;
    }
    /**
     * 获取:主诉
     */
    public String getZs() {
        return zs;
    }

    public Integer getLsh() {
        return lsh;
    }

    public void setLsh(Integer lsh) {
        this.lsh = lsh;
    }

    public List<String> getZsList() {
        return zsList;
    }

    public void setZsList(List<String> zsList) {
        this.zsList = zsList;
    }

    public String getDrzt() {
        return drzt;
    }

    public void setDrzt(String drzt) {
        this.drzt = drzt;
    }
}
