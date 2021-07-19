package com.buit.commons.request;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName CheckProjectMaterialsReq
 * @Description 医技--保存校验--请求
 * @Author 老花生
 * @Date 2020/7/22 19:36
 */
@ApiModel(value="医技--保存校验--请求")
public class CheckProjectMaterialsReq {
    @ApiModelProperty(value="挂号关联")
    private Integer ghgl;
    @ApiModelProperty(value="门诊住院")
    private Integer mzzy;
    @ApiModelProperty(value="门诊科室")
    private Integer mzks;
    private List<BodysBean> bodys;

    public static class BodysBean {
        @ApiModelProperty(value="医技接口")
        private Integer yjjk;
        @ApiModelProperty(value="医技组号")
        private Integer yjzh;
        @ApiModelProperty(value="机构代码")
        private Integer jgid;
        @ApiModelProperty(value="医技序号")
        private Integer yjxh;
        @ApiModelProperty(value="医疗序号(关联FEE_YLSFXM费用序号FYXH字段)")
        private Integer ylxh;
        @ApiModelProperty(value="项目类型")
        private Integer xmlx;
        @ApiModelProperty(value="医技主项")
        private Integer yjzx;
        @ApiModelProperty(value="医疗单价")
        private BigDecimal yldj;
        @ApiModelProperty(value="医疗数量")
        private BigDecimal ylsl;
        @ApiModelProperty(value="费用归并")
        private Integer fygb;
        @ApiModelProperty(value="自负比例")
        private BigDecimal zfbl;
        @ApiModelProperty(value="打折比例")
        private BigDecimal dzbl;
        @ApiModelProperty(value="组套标志(该条医嘱存是组套信息) 0非组套标志，1组套标志")
        private Integer ztbz;
        @ApiModelProperty(value="门诊科室")
        private Integer ksdm;
        @ApiModelProperty(value="附加处方")
        private Integer fjgl;
        @ApiModelProperty(value="费用单位")
        private String fydw;
        @ApiModelProperty(value="划价金额")
        private BigDecimal hjje;
        @ApiModelProperty(value="项目名称")
        private String fymc;

        public Integer getYjjk() {
            return yjjk;
        }

        public void setYjjk(Integer yjjk) {
            this.yjjk = yjjk;
        }

        public Integer getYjzh() {
            return yjzh;
        }

        public void setYjzh(Integer yjzh) {
            this.yjzh = yjzh;
        }

        public Integer getJgid() {
            return jgid;
        }

        public void setJgid(Integer jgid) {
            this.jgid = jgid;
        }

        public Integer getYjxh() {
            return yjxh;
        }

        public void setYjxh(Integer yjxh) {
            this.yjxh = yjxh;
        }

        public Integer getYlxh() {
            return ylxh;
        }

        public void setYlxh(Integer ylxh) {
            this.ylxh = ylxh;
        }

        public Integer getXmlx() {
            return xmlx;
        }

        public void setXmlx(Integer xmlx) {
            this.xmlx = xmlx;
        }

        public Integer getYjzx() {
            return yjzx;
        }

        public void setYjzx(Integer yjzx) {
            this.yjzx = yjzx;
        }

        public BigDecimal getYldj() {
            return yldj;
        }

        public void setYldj(BigDecimal yldj) {
            this.yldj = yldj;
        }

        public BigDecimal getYlsl() {
            return ylsl;
        }

        public void setYlsl(BigDecimal ylsl) {
            this.ylsl = ylsl;
        }

        public Integer getFygb() {
            return fygb;
        }

        public void setFygb(Integer fygb) {
            this.fygb = fygb;
        }

        public BigDecimal getZfbl() {
            return zfbl;
        }

        public void setZfbl(BigDecimal zfbl) {
            this.zfbl = zfbl;
        }

        public BigDecimal getDzbl() {
            return dzbl;
        }

        public void setDzbl(BigDecimal dzbl) {
            this.dzbl = dzbl;
        }

        public Integer getZtbz() {
            return ztbz;
        }

        public void setZtbz(Integer ztbz) {
            this.ztbz = ztbz;
        }

        public Integer getKsdm() {
            return ksdm;
        }

        public void setKsdm(Integer ksdm) {
            this.ksdm = ksdm;
        }

        public Integer getFjgl() {
            return fjgl;
        }

        public void setFjgl(Integer fjgl) {
            this.fjgl = fjgl;
        }

        public String getFydw() {
            return fydw;
        }

        public void setFydw(String fydw) {
            this.fydw = fydw;
        }

        public BigDecimal getHjje() {
            return hjje;
        }

        public void setHjje(BigDecimal hjje) {
            this.hjje = hjje;
        }

        public String getFymc() {
            return fymc;
        }

        public void setFymc(String fymc) {
            this.fymc = fymc;
        }
    }

    public Integer getGhgl() {
        return ghgl;
    }

    public void setGhgl(Integer ghgl) {
        this.ghgl = ghgl;
    }

    public Integer getMzzy() {
        return mzzy;
    }

    public void setMzzy(Integer mzzy) {
        this.mzzy = mzzy;
    }

    public List<BodysBean> getBodys() {
        return bodys;
    }

    public void setBodys(List<BodysBean> bodys) {
        this.bodys = bodys;
    }

    public Integer getMzks() {
        return mzks;
    }

    public void setMzks(Integer mzks) {
        this.mzks = mzks;
    }
}
