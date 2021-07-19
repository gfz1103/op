
package com.buit.commons.response;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OpYjcf02<br>
 * 类描述：门诊_门诊医技单明细表<br>
 * @author 老花生
 */
@ApiModel(value="门诊_门诊医技单明细表-返回")
public class OpYjcf02Resp  extends  PageQuery{
    @ApiModelProperty(value="识别序号")
    private Integer sbxh;
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
    @ApiModelProperty(value="划价金额")
    private BigDecimal hjje;
    @ApiModelProperty(value="费用归并")
    private Integer fygb;
    @ApiModelProperty(value="自负比例")
    private BigDecimal zfbl;
    @ApiModelProperty(value="备注信息")
    private String bzxx;
    @ApiModelProperty(value="打折比例")
    private BigDecimal dzbl;
    @ApiModelProperty(value="医技组号")
    private Integer yjzh;
    @ApiModelProperty(value="自负判别")
    private Integer zfpb;
    @ApiModelProperty(value="审批编号")
    private Integer spbh;
    @ApiModelProperty(value="yxms")
    private Integer yxms;
    @ApiModelProperty(value="djzt")
    private Integer djzt;
    @ApiModelProperty(value="组套编号")
    private Integer ztbh;
    @ApiModelProperty(value="执行判别")
    private Integer zxpb;
    @ApiModelProperty(value="申请单号")
    private Integer sqdh;
    @ApiModelProperty(value="xflsh")
    private String xflsh;
    @ApiModelProperty(value="组套标志(该条医嘱存是组套信息) 0非组套标志，1组套标志")
    private Integer ztbz;
    @ApiModelProperty(value="组套医嘱识别序号(OP_YJ02_ZT表SBXH)")
    private Integer ztyzsbxh;
    @ApiModelProperty(value="折扣比例")
    private BigDecimal zkbl;
    @ApiModelProperty(value="折扣金额")
    private BigDecimal zkje;
    @ApiModelProperty(value="折后金额")
    private BigDecimal zhje;
    /**
     * 设置:识别序号
     */
    public void setSbxh(Integer value) {
        this.sbxh = value;
    }
    /**
     * 获取:识别序号
     */
    public Integer getSbxh() {
        return sbxh;
    }
    /**
     * 设置:机构代码
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /**
     * 获取:机构代码
     */
    public Integer getJgid() {
        return jgid;
    }
    /**
     * 设置:医技序号
     */
    public void setYjxh(Integer value) {
        this.yjxh = value;
    }
    /**
     * 获取:医技序号
     */
    public Integer getYjxh() {
        return yjxh;
    }
    /**
     * 设置:医疗序号(关联FEE_YLSFXM费用序号FYXH字段)
     */
    public void setYlxh(Integer value) {
        this.ylxh = value;
    }
    /**
     * 获取:医疗序号(关联FEE_YLSFXM费用序号FYXH字段)
     */
    public Integer getYlxh() {
        return ylxh;
    }
    /**
     * 设置:项目类型
     */
    public void setXmlx(Integer value) {
        this.xmlx = value;
    }
    /**
     * 获取:项目类型
     */
    public Integer getXmlx() {
        return xmlx;
    }
    /**
     * 设置:医技主项
     */
    public void setYjzx(Integer value) {
        this.yjzx = value;
    }
    /**
     * 获取:医技主项
     */
    public Integer getYjzx() {
        return yjzx;
    }
    /**
     * 设置:医疗单价
     */
    public void setYldj(BigDecimal value) {
        this.yldj = value;
    }
    /**
     * 获取:医疗单价
     */
    public BigDecimal getYldj() {
        return yldj;
    }
    /**
     * 设置:医疗数量
     */
    public void setYlsl(BigDecimal value) {
        this.ylsl = value;
    }
    /**
     * 获取:医疗数量
     */
    public BigDecimal getYlsl() {
        return ylsl;
    }
    /**
     * 设置:划价金额
     */
    public void setHjje(BigDecimal value) {
        this.hjje = value;
    }
    /**
     * 获取:划价金额
     */
    public BigDecimal getHjje() {
        return hjje;
    }
    /**
     * 设置:费用归并
     */
    public void setFygb(Integer value) {
        this.fygb = value;
    }
    /**
     * 获取:费用归并
     */
    public Integer getFygb() {
        return fygb;
    }
    /**
     * 设置:自负比例
     */
    public void setZfbl(BigDecimal value) {
        this.zfbl = value;
    }
    /**
     * 获取:自负比例
     */
    public BigDecimal getZfbl() {
        return zfbl;
    }
    /**
     * 设置:备注信息
     */
    public void setBzxx(String value) {
        this.bzxx = value;
    }
    /**
     * 获取:备注信息
     */
    public String getBzxx() {
        return bzxx;
    }
    /**
     * 设置:打折比例
     */
    public void setDzbl(BigDecimal value) {
        this.dzbl = value;
    }
    /**
     * 获取:打折比例
     */
    public BigDecimal getDzbl() {
        return dzbl;
    }
    /**
     * 设置:医技组号
     */
    public void setYjzh(Integer value) {
        this.yjzh = value;
    }
    /**
     * 获取:医技组号
     */
    public Integer getYjzh() {
        return yjzh;
    }
    /**
     * 设置:自负判别
     */
    public void setZfpb(Integer value) {
        this.zfpb = value;
    }
    /**
     * 获取:自负判别
     */
    public Integer getZfpb() {
        return zfpb;
    }
    /**
     * 设置:审批编号
     */
    public void setSpbh(Integer value) {
        this.spbh = value;
    }
    /**
     * 获取:审批编号
     */
    public Integer getSpbh() {
        return spbh;
    }
    /**
     * 设置:yxms
     */
    public void setYxms(Integer value) {
        this.yxms = value;
    }
    /**
     * 获取:yxms
     */
    public Integer getYxms() {
        return yxms;
    }
    /**
     * 设置:djzt
     */
    public void setDjzt(Integer value) {
        this.djzt = value;
    }
    /**
     * 获取:djzt
     */
    public Integer getDjzt() {
        return djzt;
    }
    /**
     * 设置:组套编号
     */
    public void setZtbh(Integer value) {
        this.ztbh = value;
    }
    /**
     * 获取:组套编号
     */
    public Integer getZtbh() {
        return ztbh;
    }
    /**
     * 设置:执行判别
     */
    public void setZxpb(Integer value) {
        this.zxpb = value;
    }
    /**
     * 获取:执行判别
     */
    public Integer getZxpb() {
        return zxpb;
    }
    /**
     * 设置:申请单号
     */
    public void setSqdh(Integer value) {
        this.sqdh = value;
    }
    /**
     * 获取:申请单号
     */
    public Integer getSqdh() {
        return sqdh;
    }
    /**
     * 设置:xflsh
     */
    public void setXflsh(String value) {
        this.xflsh = value;
    }
    /**
     * 获取:xflsh
     */
    public String getXflsh() {
        return xflsh;
    }
    /**
     * 设置:组套标志(该条医嘱存是组套信息) 0非组套标志，1组套标志
     */
    public void setZtbz(Integer value) {
        this.ztbz = value;
    }
    /**
     * 获取:组套标志(该条医嘱存是组套信息) 0非组套标志，1组套标志
     */
    public Integer getZtbz() {
        return ztbz;
    }
    /**
     * 设置:组套医嘱识别序号(OP_YJ02_ZT表SBXH)
     */
    public void setZtyzsbxh(Integer value) {
        this.ztyzsbxh = value;
    }
    /**
     * 获取:组套医嘱识别序号(OP_YJ02_ZT表SBXH)
     */
    public Integer getZtyzsbxh() {
        return ztyzsbxh;
    }
    /**
     * 设置:折扣比例
     */
    public void setZkbl(BigDecimal value) {
        this.zkbl = value;
    }
    /**
     * 获取:折扣比例
     */
    public BigDecimal getZkbl() {
        return zkbl;
    }
    /**
     * 设置:折扣金额
     */
    public void setZkje(BigDecimal value) {
        this.zkje = value;
    }
    /**
     * 获取:折扣金额
     */
    public BigDecimal getZkje() {
        return zkje;
    }
    /**
     * 设置:折后金额
     */
    public void setZhje(BigDecimal value) {
        this.zhje = value;
    }
    /**
     * 获取:折后金额
     */
    public BigDecimal getZhje() {
        return zhje;
    }
}
