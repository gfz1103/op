package com.buit.commons.response;//
//package com.buit.cis.op.dctwork.response;
//
//import java.sql.Timestamp;
//
//import com.buit.commons.PageQuery;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
//
///**
// * 类名称：OmrBl01<br> 
// * 类描述：病历01表<br>
// * @author 老花生
// */
//@ApiModel(value="病历01表")
//public class OmrBl01Resp  extends  PageQuery{
//    @ApiModelProperty(value="病历编号:流水号")
//    private Integer blbh;
//    @ApiModelProperty(value="就诊序号:标识一次就诊的流水号，对应OP_YS_JZLS.JZXH")
//    private Integer jzxh;
//    @ApiModelProperty(value="病人ID号:病人档案的ID号，对应MPI_BRDA.BRID")
//    private Integer brid;
//    @ApiModelProperty(value="病历类型:0病历 1病程")
//    private Integer bllx;
//    @ApiModelProperty(value="病历类别:一级病历分类，即FreamWorkCode,对应emr_kbm_bllb.lbbh(mlbz=1)")
//    private Integer bllb;
//    @ApiModelProperty(value="病历名称")
//    private String blmc;
//    @ApiModelProperty(value="段落类别:病程用，病历不填写")
//    private Integer dllb;
//    @ApiModelProperty(value="段落键:对应parakey")
//    private String dlj;
//    @ApiModelProperty(value="模板类别:二级病历分了，即emrtypecode")
//    private Integer mblb;
//    @ApiModelProperty(value="模板编号:对应的模板编号")
//    private Integer mbbh;
//    @ApiModelProperty(value="记录时间:医学意义上的记录时间，用户填写。")
//    private Timestamp jlsj;
//    @ApiModelProperty(value="创建时间:系统时间")
//    private Timestamp cjsj;
//    @ApiModelProperty(value="完成时间:病历完成时间")
//    private Timestamp wcsj;
//    @ApiModelProperty(value="书写医生")
//    private String sxys;
//    @ApiModelProperty(value="书写科室")
//    private Integer sxks;
//    @ApiModelProperty(value="病人科室")
//    private Integer brks;
//    @ApiModelProperty(value="病历状态:0书写 1完成 9注销 Dict150")
//    private Integer blzt;
//    @ApiModelProperty(value="审阅标志:1审阅")
//    private Integer sybz;
//    @ApiModelProperty(value="病种模板编号")
//    private Integer bzmbbh;
//    @ApiModelProperty(value="病历本标志:1表示打印到病历本上")
//    private Integer blbbz;
//    @ApiModelProperty(value="病历评分")
//    private Integer blpf;
//    @ApiModelProperty(value="自助打印后标记为1，未打印的标记为0")
//    private Integer zzdy;
//    @ApiModelProperty(value="私有模板ID")
//    private Integer ptid;
//    @ApiModelProperty(value="JGID")
//    private Integer jgid;
//    /**
//     * 设置:病历编号:流水号
//     */
//    public void setBlbh(Integer value) {
//        this.blbh = value;
//    }
//    /**
//     * 获取:病历编号:流水号
//     */
//    public Integer getBlbh() {
//        return blbh;
//    }
//    /**
//     * 设置:就诊序号:标识一次就诊的流水号，对应OP_YS_JZLS.JZXH
//     */
//    public void setJzxh(Integer value) {
//        this.jzxh = value;
//    }
//    /**
//     * 获取:就诊序号:标识一次就诊的流水号，对应OP_YS_JZLS.JZXH
//     */
//    public Integer getJzxh() {
//        return jzxh;
//    }
//    /**
//     * 设置:病人ID号:病人档案的ID号，对应MPI_BRDA.BRID
//     */
//    public void setBrid(Integer value) {
//        this.brid = value;
//    }
//    /**
//     * 获取:病人ID号:病人档案的ID号，对应MPI_BRDA.BRID
//     */
//    public Integer getBrid() {
//        return brid;
//    }
//    /**
//     * 设置:病历类型:0病历 1病程
//     */
//    public void setBllx(Integer value) {
//        this.bllx = value;
//    }
//    /**
//     * 获取:病历类型:0病历 1病程
//     */
//    public Integer getBllx() {
//        return bllx;
//    }
//    /**
//     * 设置:病历类别:一级病历分类，即FreamWorkCode,对应emr_kbm_bllb.lbbh(mlbz=1)
//     */
//    public void setBllb(Integer value) {
//        this.bllb = value;
//    }
//    /**
//     * 获取:病历类别:一级病历分类，即FreamWorkCode,对应emr_kbm_bllb.lbbh(mlbz=1)
//     */
//    public Integer getBllb() {
//        return bllb;
//    }
//    /**
//     * 设置:病历名称
//     */
//    public void setBlmc(String value) {
//        this.blmc = value;
//    }
//    /**
//     * 获取:病历名称
//     */
//    public String getBlmc() {
//        return blmc;
//    }
//    /**
//     * 设置:段落类别:病程用，病历不填写
//     */
//    public void setDllb(Integer value) {
//        this.dllb = value;
//    }
//    /**
//     * 获取:段落类别:病程用，病历不填写
//     */
//    public Integer getDllb() {
//        return dllb;
//    }
//    /**
//     * 设置:段落键:对应parakey
//     */
//    public void setDlj(String value) {
//        this.dlj = value;
//    }
//    /**
//     * 获取:段落键:对应parakey
//     */
//    public String getDlj() {
//        return dlj;
//    }
//    /**
//     * 设置:模板类别:二级病历分了，即emrtypecode
//     */
//    public void setMblb(Integer value) {
//        this.mblb = value;
//    }
//    /**
//     * 获取:模板类别:二级病历分了，即emrtypecode
//     */
//    public Integer getMblb() {
//        return mblb;
//    }
//    /**
//     * 设置:模板编号:对应的模板编号
//     */
//    public void setMbbh(Integer value) {
//        this.mbbh = value;
//    }
//    /**
//     * 获取:模板编号:对应的模板编号
//     */
//    public Integer getMbbh() {
//        return mbbh;
//    }
//    /**
//     * 设置:记录时间:医学意义上的记录时间，用户填写。
//     */
//    public void setJlsj(Timestamp value) {
//        this.jlsj = value;
//    }
//    /**
//     * 获取:记录时间:医学意义上的记录时间，用户填写。
//     */
//    public Timestamp getJlsj() {
//        return jlsj;
//    }
//    /**
//     * 设置:创建时间:系统时间
//     */
//    public void setCjsj(Timestamp value) {
//        this.cjsj = value;
//    }
//    /**
//     * 获取:创建时间:系统时间
//     */
//    public Timestamp getCjsj() {
//        return cjsj;
//    }
//    /**
//     * 设置:完成时间:病历完成时间
//     */
//    public void setWcsj(Timestamp value) {
//        this.wcsj = value;
//    }
//    /**
//     * 获取:完成时间:病历完成时间
//     */
//    public Timestamp getWcsj() {
//        return wcsj;
//    }
//    /**
//     * 设置:书写医生
//     */
//    public void setSxys(String value) {
//        this.sxys = value;
//    }
//    /**
//     * 获取:书写医生
//     */
//    public String getSxys() {
//        return sxys;
//    }
//    /**
//     * 设置:书写科室
//     */
//    public void setSxks(Integer value) {
//        this.sxks = value;
//    }
//    /**
//     * 获取:书写科室
//     */
//    public Integer getSxks() {
//        return sxks;
//    }
//    /**
//     * 设置:病人科室
//     */
//    public void setBrks(Integer value) {
//        this.brks = value;
//    }
//    /**
//     * 获取:病人科室
//     */
//    public Integer getBrks() {
//        return brks;
//    }
//    /**
//     * 设置:病历状态:0书写 1完成 9注销 Dict150
//     */
//    public void setBlzt(Integer value) {
//        this.blzt = value;
//    }
//    /**
//     * 获取:病历状态:0书写 1完成 9注销 Dict150
//     */
//    public Integer getBlzt() {
//        return blzt;
//    }
//    /**
//     * 设置:审阅标志:1审阅
//     */
//    public void setSybz(Integer value) {
//        this.sybz = value;
//    }
//    /**
//     * 获取:审阅标志:1审阅
//     */
//    public Integer getSybz() {
//        return sybz;
//    }
//    /**
//     * 设置:病种模板编号
//     */
//    public void setBzmbbh(Integer value) {
//        this.bzmbbh = value;
//    }
//    /**
//     * 获取:病种模板编号
//     */
//    public Integer getBzmbbh() {
//        return bzmbbh;
//    }
//    /**
//     * 设置:病历本标志:1表示打印到病历本上
//     */
//    public void setBlbbz(Integer value) {
//        this.blbbz = value;
//    }
//    /**
//     * 获取:病历本标志:1表示打印到病历本上
//     */
//    public Integer getBlbbz() {
//        return blbbz;
//    }
//    /**
//     * 设置:病历评分
//     */
//    public void setBlpf(Integer value) {
//        this.blpf = value;
//    }
//    /**
//     * 获取:病历评分
//     */
//    public Integer getBlpf() {
//        return blpf;
//    }
//    /**
//     * 设置:自助打印后标记为1，未打印的标记为0
//     */
//    public void setZzdy(Integer value) {
//        this.zzdy = value;
//    }
//    /**
//     * 获取:自助打印后标记为1，未打印的标记为0
//     */
//    public Integer getZzdy() {
//        return zzdy;
//    }
//    /**
//     * 设置:私有模板ID
//     */
//    public void setPtid(Integer value) {
//        this.ptid = value;
//    }
//    /**
//     * 获取:私有模板ID
//     */
//    public Integer getPtid() {
//        return ptid;
//    }
//    /**
//     * 设置:JGID
//     */
//    public void setJgid(Integer value) {
//        this.jgid = value;
//    }
//    /**
//     * 获取:JGID
//     */
//    public Integer getJgid() {
//        return jgid;
//    }
//}
