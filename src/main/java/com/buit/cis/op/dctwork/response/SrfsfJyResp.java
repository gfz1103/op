package com.buit.cis.op.dctwork.response;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 类描述：门诊收费 检验 输入法查询
 *
 * @author 神算子
 */
public class SrfsfJyResp {
	@ApiModelProperty(value="材料规格")
	private String yyclgg;
	@ApiModelProperty(value="医保编码")
	private String ybbm;
	@ApiModelProperty(value="门诊归并")
	private Integer mzgb ;
	@ApiModelProperty(value="收费名称")
	private String mcsx;
	@ApiModelProperty(value="费用序号")
    private Integer fyxh;
	@ApiModelProperty(value="费用名称")
    private String fymc;
	@ApiModelProperty(value="费用单位")
    private String fydw;
	@ApiModelProperty(value="标准价格")
    private BigDecimal bzjg;
	@ApiModelProperty(value="项目类别 | 4.检验 5.检查 6.手术 7.治疗 8.护理 9.饮食 10.卫材 99.其他")
    private Integer xmlx;
	@ApiModelProperty(value="费用单价")
    private BigDecimal fydj;
	@ApiModelProperty(value="费用科室")
    private Integer fyks;
	public String getYyclgg() {
		return yyclgg;
	}
	public void setYyclgg(String yyclgg) {
		this.yyclgg = yyclgg;
	}
	public String getYbbm() {
		return ybbm;
	}
	public void setYbbm(String ybbm) {
		this.ybbm = ybbm;
	}
	public Integer getMzgb() {
		return mzgb;
	}
	public void setMzgb(Integer mzgb) {
		this.mzgb = mzgb;
	}
	public String getMcsx() {
		return mcsx;
	}
	public void setMcsx(String mcsx) {
		this.mcsx = mcsx;
	}
	public Integer getFyxh() {
		return fyxh;
	}
	public void setFyxh(Integer fyxh) {
		this.fyxh = fyxh;
	}
	public String getFymc() {
		return fymc;
	}
	public void setFymc(String fymc) {
		this.fymc = fymc;
	}
	public String getFydw() {
		return fydw;
	}
	public void setFydw(String fydw) {
		this.fydw = fydw;
	}
	public BigDecimal getBzjg() {
		return bzjg;
	}
	public void setBzjg(BigDecimal bzjg) {
		this.bzjg = bzjg;
	}
	public Integer getXmlx() {
		return xmlx;
	}
	public void setXmlx(Integer xmlx) {
		this.xmlx = xmlx;
	}
	public BigDecimal getFydj() {
		return fydj;
	}
	public void setFydj(BigDecimal fydj) {
		this.fydj = fydj;
	}
	public Integer getFyks() {
		return fyks;
	}
	public void setFyks(Integer fyks) {
		this.fyks = fyks;
	}

}
