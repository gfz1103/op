package com.buit.cis.op.dctwork.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName SaveClinicFinishReq
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/7/13 18:45
 */
@ApiModel(value="临床完成-请求")
public class SaveClinicFinishReq {

    @ApiModelProperty(value="就诊序号")
    private Integer jzxh;
    @ApiModelProperty(value="就诊状态 0：挂号、1：就诊中、2：暂挂、9：就诊结束")
    private Integer jzzt;
    @ApiModelProperty(value="病人ID")
    private String brid;
    @ApiModelProperty(value="病人去向 0：无、1：离院、2：留院、3：住院、4：死亡  默认传1")
    private Integer brqx=1;
    @ApiModelProperty(value="健康教育")
    private String jkjy;
    @ApiModelProperty(value="挂号类型")
    private Integer ghlx;
    @ApiModelProperty(value="挂号序号")
    private Integer sbxh;
    @ApiModelProperty(value="挂号科室")
    private Integer ghks;
    @ApiModelProperty(value="医生代码")
    private Integer ysdm;
    @ApiModelProperty(value="是否更新就诊医 0：不更新、1：更新")
    private Integer updatingDoctor = 0;
    @ApiModelProperty(value="用户ID", hidden = true)
    private Integer jzys;
    @ApiModelProperty(value="挂号科室", hidden = true)
    private Integer jzks;
    @ApiModelProperty(value="机构ID", hidden = true)
    private Integer jgid;
    @ApiModelProperty(value="病历类型", hidden = true)
    private Integer bllx;
    @ApiModelProperty(value="就诊流水号")
    private String jzlsh;

    public Integer getJzxh() {
        return jzxh;
    }

    public void setJzxh(Integer jzxh) {
        this.jzxh = jzxh;
    }

    public Integer getJzzt() {
        return jzzt;
    }

    public void setJzzt(Integer jzzt) {
        this.jzzt = jzzt;
    }

    public String getBrid() {
        return brid;
    }

    public void setBrid(String brid) {
        this.brid = brid;
    }

    public Integer getBrqx() {
        return brqx;
    }

    public void setBrqx(Integer brqx) {
        this.brqx = brqx;
    }

    public String getJkjy() {
        return jkjy;
    }

    public void setJkjy(String jkjy) {
        this.jkjy = jkjy;
    }

    public Integer getGhlx() {
        return ghlx;
    }

    public void setGhlx(Integer ghlx) {
        this.ghlx = ghlx;
    }

    public Integer getSbxh() {
        return sbxh;
    }

    public void setSbxh(Integer sbxh) {
        this.sbxh = sbxh;
    }

    public Integer getGhks() {
        return ghks;
    }

    public void setGhks(Integer ghks) {
        this.ghks = ghks;
    }

    public Integer getYsdm() {
        return ysdm;
    }

    public void setYsdm(Integer ysdm) {
        this.ysdm = ysdm;
    }

    public Integer getUpdatingDoctor() {
        return updatingDoctor;
    }

    public void setUpdatingDoctor(Integer updatingDoctor) {
        this.updatingDoctor = updatingDoctor;
    }

    public Integer getJzys() {
        return jzys;
    }

    public void setJzys(Integer jzys) {
        this.jzys = jzys;
    }

    public Integer getJzks() {
        return jzks;
    }

    public void setJzks(Integer jzks) {
        this.jzks = jzks;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getBllx() {
        return bllx;
    }

    public void setBllx(Integer bllx) {
        this.bllx = bllx;
    }

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }
}
