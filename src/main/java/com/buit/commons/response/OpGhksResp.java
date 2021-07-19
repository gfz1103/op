//   
//package com.buit.his.op.reg..response;
//
//import java.sql.Timestamp;
//
//import com.his.commons.PageQuery;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
//
///**
// * 类名称：OpGhks<br> 
// * 类描述：门诊_挂号科室<br>
// * @author WY
// */
//@ApiModel(value="门诊_挂号科室")
//public class OpGhksResp  extends  PageQuery{
//    @ApiModelProperty(value="科室代码")
//    private Integer ksdm;
//    @ApiModelProperty(value="机构代码")
//    private Integer jgid;
//    @ApiModelProperty(value="科室名称")
//    private String ksmc;
//    @ApiModelProperty(value="挂号类别 | 与GY_DMZD (DMLB = 25)关联")
//    private Integer ghlb;
//    @ApiModelProperty(value="拼音代码")
//    private String pydm;
//    @ApiModelProperty(value="五笔代码")
//    private String wbdm;
//    @ApiModelProperty(value="角形代码")
//    private String jxdm;
//    @ApiModelProperty(value="其他代码")
//    private String qtdm;
//    @ApiModelProperty(value="挂号费")
//    private BigDecimal ghf;
//    @ApiModelProperty(value="诊疗费")
//    private BigDecimal zlf;
//    @ApiModelProperty(value="专家门诊 | 0.普通门诊    1.专家门诊")
//    private Integer zjmz;
//    @ApiModelProperty(value="挂号限额")
//    private Integer ghxe;
//    @ApiModelProperty(value="已挂人数")
//    private Integer ygrs;
//    @ApiModelProperty(value="预约人数")
//    private Integer yyrs;
//    @ApiModelProperty(value="挂号日期")
//    private Timestamp ghrq;
//    @ApiModelProperty(value="门诊科室 | 该挂号科室对应的门诊科室代码")
//    private Long mzks;
//    @ApiModelProperty(value="体检判别 | 0.非体检科室  1.体检科室 在体检挂号中自动挂TJPB=1的科室")
//    private Integer tjpb;
//    @ApiModelProperty(value="体验费")
//    private BigDecimal tjf;
//    @ApiModelProperty(value="门诊类别 | 0.门诊挂号科室  1.急诊挂号科室")
//    private Long mzlb;
//    @ApiModelProperty(value="就诊序号")
//    private Integer jzxh;
//    @ApiModelProperty(value="节假日挂号费")
//    private BigDecimal jjrghf;
//    @ApiModelProperty(value="门诊排列")
//    private String ddxx;
//    @ApiModelProperty(value="住院排列")
//    private String dddm;
//    @ApiModelProperty(value="sfqy")
//    private String sfqy;
//    @ApiModelProperty(value="录入疾控报卡")
//    private String lrjkbk;
//    @ApiModelProperty(value="老系统科室代码")
//    private String bsrunksdm;
//    @ApiModelProperty(value="数字代码")
//    private String szdm;
//    @ApiModelProperty(value="普通门诊")
//    private Integer ptmz;
//    @ApiModelProperty(value="专科门诊")
//    private Integer zkmz;
//    @ApiModelProperty(value="特需门诊")
//    private Integer txmz;
//    @ApiModelProperty(value="科室分机号")
//    private String ksfjh;
//    /**
//     * 设置:科室代码
//     */
//    public void setKsdm(Integer value) {
//        this.ksdm = value;
//    }
//    /**
//     * 获取:科室代码
//     */
//    public Integer getKsdm() {
//        return ksdm;
//    }
//    /**
//     * 设置:机构代码
//     */
//    public void setJgid(Integer value) {
//        this.jgid = value;
//    }
//    /**
//     * 获取:机构代码
//     */
//    public Integer getJgid() {
//        return jgid;
//    }
//    /**
//     * 设置:科室名称
//     */
//    public void setKsmc(String value) {
//        this.ksmc = value;
//    }
//    /**
//     * 获取:科室名称
//     */
//    public String getKsmc() {
//        return ksmc;
//    }
//    /**
//     * 设置:挂号类别 | 与GY_DMZD (DMLB = 25)关联
//     */
//    public void setGhlb(Integer value) {
//        this.ghlb = value;
//    }
//    /**
//     * 获取:挂号类别 | 与GY_DMZD (DMLB = 25)关联
//     */
//    public Integer getGhlb() {
//        return ghlb;
//    }
//    /**
//     * 设置:拼音代码
//     */
//    public void setPydm(String value) {
//        this.pydm = value;
//    }
//    /**
//     * 获取:拼音代码
//     */
//    public String getPydm() {
//        return pydm;
//    }
//    /**
//     * 设置:五笔代码
//     */
//    public void setWbdm(String value) {
//        this.wbdm = value;
//    }
//    /**
//     * 获取:五笔代码
//     */
//    public String getWbdm() {
//        return wbdm;
//    }
//    /**
//     * 设置:角形代码
//     */
//    public void setJxdm(String value) {
//        this.jxdm = value;
//    }
//    /**
//     * 获取:角形代码
//     */
//    public String getJxdm() {
//        return jxdm;
//    }
//    /**
//     * 设置:其他代码
//     */
//    public void setQtdm(String value) {
//        this.qtdm = value;
//    }
//    /**
//     * 获取:其他代码
//     */
//    public String getQtdm() {
//        return qtdm;
//    }
//    /**
//     * 设置:挂号费
//     */
//    public void setGhf(BigDecimal value) {
//        this.ghf = value;
//    }
//    /**
//     * 获取:挂号费
//     */
//    public BigDecimal getGhf() {
//        return ghf;
//    }
//    /**
//     * 设置:诊疗费
//     */
//    public void setZlf(BigDecimal value) {
//        this.zlf = value;
//    }
//    /**
//     * 获取:诊疗费
//     */
//    public BigDecimal getZlf() {
//        return zlf;
//    }
//    /**
//     * 设置:专家门诊 | 0.普通门诊    1.专家门诊
//     */
//    public void setZjmz(Integer value) {
//        this.zjmz = value;
//    }
//    /**
//     * 获取:专家门诊 | 0.普通门诊    1.专家门诊
//     */
//    public Integer getZjmz() {
//        return zjmz;
//    }
//    /**
//     * 设置:挂号限额
//     */
//    public void setGhxe(Integer value) {
//        this.ghxe = value;
//    }
//    /**
//     * 获取:挂号限额
//     */
//    public Integer getGhxe() {
//        return ghxe;
//    }
//    /**
//     * 设置:已挂人数
//     */
//    public void setYgrs(Integer value) {
//        this.ygrs = value;
//    }
//    /**
//     * 获取:已挂人数
//     */
//    public Integer getYgrs() {
//        return ygrs;
//    }
//    /**
//     * 设置:预约人数
//     */
//    public void setYyrs(Integer value) {
//        this.yyrs = value;
//    }
//    /**
//     * 获取:预约人数
//     */
//    public Integer getYyrs() {
//        return yyrs;
//    }
//    /**
//     * 设置:挂号日期
//     */
//    public void setGhrq(Timestamp value) {
//        this.ghrq = value;
//    }
//    /**
//     * 获取:挂号日期
//     */
//    public Timestamp getGhrq() {
//        return ghrq;
//    }
//    /**
//     * 设置:门诊科室 | 该挂号科室对应的门诊科室代码
//     */
//    public void setMzks(Long value) {
//        this.mzks = value;
//    }
//    /**
//     * 获取:门诊科室 | 该挂号科室对应的门诊科室代码
//     */
//    public Long getMzks() {
//        return mzks;
//    }
//    /**
//     * 设置:体检判别 | 0.非体检科室  1.体检科室 在体检挂号中自动挂TJPB=1的科室
//     */
//    public void setTjpb(Integer value) {
//        this.tjpb = value;
//    }
//    /**
//     * 获取:体检判别 | 0.非体检科室  1.体检科室 在体检挂号中自动挂TJPB=1的科室
//     */
//    public Integer getTjpb() {
//        return tjpb;
//    }
//    /**
//     * 设置:体验费
//     */
//    public void setTjf(BigDecimal value) {
//        this.tjf = value;
//    }
//    /**
//     * 获取:体验费
//     */
//    public BigDecimal getTjf() {
//        return tjf;
//    }
//    /**
//     * 设置:门诊类别 | 0.门诊挂号科室  1.急诊挂号科室
//     */
//    public void setMzlb(Long value) {
//        this.mzlb = value;
//    }
//    /**
//     * 获取:门诊类别 | 0.门诊挂号科室  1.急诊挂号科室
//     */
//    public Long getMzlb() {
//        return mzlb;
//    }
//    /**
//     * 设置:就诊序号
//     */
//    public void setJzxh(Integer value) {
//        this.jzxh = value;
//    }
//    /**
//     * 获取:就诊序号
//     */
//    public Integer getJzxh() {
//        return jzxh;
//    }
//    /**
//     * 设置:节假日挂号费
//     */
//    public void setJjrghf(BigDecimal value) {
//        this.jjrghf = value;
//    }
//    /**
//     * 获取:节假日挂号费
//     */
//    public BigDecimal getJjrghf() {
//        return jjrghf;
//    }
//    /**
//     * 设置:门诊排列
//     */
//    public void setDdxx(String value) {
//        this.ddxx = value;
//    }
//    /**
//     * 获取:门诊排列
//     */
//    public String getDdxx() {
//        return ddxx;
//    }
//    /**
//     * 设置:住院排列
//     */
//    public void setDddm(String value) {
//        this.dddm = value;
//    }
//    /**
//     * 获取:住院排列
//     */
//    public String getDddm() {
//        return dddm;
//    }
//    /**
//     * 设置:sfqy
//     */
//    public void setSfqy(String value) {
//        this.sfqy = value;
//    }
//    /**
//     * 获取:sfqy
//     */
//    public String getSfqy() {
//        return sfqy;
//    }
//    /**
//     * 设置:录入疾控报卡
//     */
//    public void setLrjkbk(String value) {
//        this.lrjkbk = value;
//    }
//    /**
//     * 获取:录入疾控报卡
//     */
//    public String getLrjkbk() {
//        return lrjkbk;
//    }
//    /**
//     * 设置:老系统科室代码
//     */
//    public void setBsrunksdm(String value) {
//        this.bsrunksdm = value;
//    }
//    /**
//     * 获取:老系统科室代码
//     */
//    public String getBsrunksdm() {
//        return bsrunksdm;
//    }
//    /**
//     * 设置:数字代码
//     */
//    public void setSzdm(String value) {
//        this.szdm = value;
//    }
//    /**
//     * 获取:数字代码
//     */
//    public String getSzdm() {
//        return szdm;
//    }
//    /**
//     * 设置:普通门诊
//     */
//    public void setPtmz(Integer value) {
//        this.ptmz = value;
//    }
//    /**
//     * 获取:普通门诊
//     */
//    public Integer getPtmz() {
//        return ptmz;
//    }
//    /**
//     * 设置:专科门诊
//     */
//    public void setZkmz(Integer value) {
//        this.zkmz = value;
//    }
//    /**
//     * 获取:专科门诊
//     */
//    public Integer getZkmz() {
//        return zkmz;
//    }
//    /**
//     * 设置:特需门诊
//     */
//    public void setTxmz(Integer value) {
//        this.txmz = value;
//    }
//    /**
//     * 获取:特需门诊
//     */
//    public Integer getTxmz() {
//        return txmz;
//    }
//    /**
//     * 设置:科室分机号
//     */
//    public void setKsfjh(String value) {
//        this.ksfjh = value;
//    }
//    /**
//     * 获取:科室分机号
//     */
//    public String getKsfjh() {
//        return ksfjh;
//    }
//}
