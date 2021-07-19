package com.buit.commons.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpSbbh<br>
 * 类描述：设备编号表
 * @author GONGFANGZHOU
 * @ApiModel(value="设备编号表")
 */
public class OpSbbh extends  PageQuery{
	@ApiModelProperty(value="编号ID")
    /** 编号ID */
    private Integer bhid;
	@ApiModelProperty(value="设备编号")
    /** 设备编号 */
    private String sbbh;
	@ApiModelProperty(value="设备名称")
    /** 设备名称 */
    private String sbmc;
	@ApiModelProperty(value="接口类型")
    /** 接口类型 */
    private String jklx;
	@ApiModelProperty(value="预约总数")
    /** 预约总数 */
    private Integer yyzs;
	@ApiModelProperty(value="上午开始时间")
    /** 上午开始时间 */
    private String swkssj;
	@ApiModelProperty(value="上午结束时间")
    /** 上午结束时间 */
    private String swjssj;
	@ApiModelProperty(value="上午间隔分钟")
    /** 上午间隔分钟 */
    private String swjgfz;
	@ApiModelProperty(value="下午开始时间")
    /** 下午开始时间 */
    private String xwkssj;
	@ApiModelProperty(value="下午结束时间")
    /** 下午结束时间 */
    private String xwjssj;
	@ApiModelProperty(value="下午间隔分钟")
    /** 下午间隔分钟 */
    private String xwjgfz;
	@ApiModelProperty(value="设备地址（三楼501）")
    /** 设备地址（三楼501） */
    private String sbdz;
	@ApiModelProperty(value="门诊使用")
    /** 门诊使用 */
    private String mzsy;
	@ApiModelProperty(value="住院使用")
    /** 住院使用 */
    private String zysy;
	@ApiModelProperty(value="体检使用")
    /** 体检使用 */
    private String tjsy;

    /** 设置:编号ID  */
    public void setBhid(Integer value) {
        this.bhid = value;
    }
    /** 获取:编号ID */
    public Integer getBhid() {
        return bhid;
    }

    /** 设置:设备编号  */
    public void setSbbh(String value) {
        this.sbbh = value;
    }
    /** 获取:设备编号 */
    public String getSbbh() {
        return sbbh;
    }

    /** 设置:设备名称  */
    public void setSbmc(String value) {
        this.sbmc = value;
    }
    /** 获取:设备名称 */
    public String getSbmc() {
        return sbmc;
    }

    /** 设置:接口类型  */
    public void setJklx(String value) {
        this.jklx = value;
    }
    /** 获取:接口类型 */
    public String getJklx() {
        return jklx;
    }

    /** 设置:预约总数  */
    public void setYyzs(Integer value) {
        this.yyzs = value;
    }
    /** 获取:预约总数 */
    public Integer getYyzs() {
        return yyzs;
    }

    /** 设置:上午开始时间  */
    public void setSwkssj(String value) {
        this.swkssj = value;
    }
    /** 获取:上午开始时间 */
    public String getSwkssj() {
        return swkssj;
    }

    /** 设置:上午结束时间  */
    public void setSwjssj(String value) {
        this.swjssj = value;
    }
    /** 获取:上午结束时间 */
    public String getSwjssj() {
        return swjssj;
    }

    /** 设置:上午间隔分钟  */
    public void setSwjgfz(String value) {
        this.swjgfz = value;
    }
    /** 获取:上午间隔分钟 */
    public String getSwjgfz() {
        return swjgfz;
    }

    /** 设置:下午开始时间  */
    public void setXwkssj(String value) {
        this.xwkssj = value;
    }
    /** 获取:下午开始时间 */
    public String getXwkssj() {
        return xwkssj;
    }

    /** 设置:下午结束时间  */
    public void setXwjssj(String value) {
        this.xwjssj = value;
    }
    /** 获取:下午结束时间 */
    public String getXwjssj() {
        return xwjssj;
    }

    /** 设置:下午间隔分钟  */
    public void setXwjgfz(String value) {
        this.xwjgfz = value;
    }
    /** 获取:下午间隔分钟 */
    public String getXwjgfz() {
        return xwjgfz;
    }

    /** 设置:设备地址（三楼501）  */
    public void setSbdz(String value) {
        this.sbdz = value;
    }
    /** 获取:设备地址（三楼501） */
    public String getSbdz() {
        return sbdz;
    }

    /** 设置:门诊使用  */
    public void setMzsy(String value) {
        this.mzsy = value;
    }
    /** 获取:门诊使用 */
    public String getMzsy() {
        return mzsy;
    }

    /** 设置:住院使用  */
    public void setZysy(String value) {
        this.zysy = value;
    }
    /** 获取:住院使用 */
    public String getZysy() {
        return zysy;
    }

    /** 设置:体检使用  */
    public void setTjsy(String value) {
        this.tjsy = value;
    }
    /** 获取:体检使用 */
    public String getTjsy() {
        return tjsy;
    }


}
