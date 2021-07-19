package com.buit.cis.op.dctwork.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;


/**
 * 类名称：PubBrxzResp<br>
 * 类描述：公用_病人性质 | 包括自费、公费、记帐等详情<br>
 * @author GONGFANGZHOU
 */
@ApiModel(value="公用_病人性质_Resp")
public class PubBrxzResp {

    @ApiModelProperty(value="性质代码")
    private Integer brxz;

    @ApiModelProperty(value="性质名称")
    private String xzmc;

    @ApiModelProperty(value="费用序号")
    private Integer fyxh;

    @ApiModelProperty(value="自负比例")
    private BigDecimal zfbl;

    @ApiModelProperty(value="费用限额")
    private BigDecimal fyxe;

    @ApiModelProperty(value="超限比例")
    private BigDecimal cxbl;

	public Integer getBrxz() {
		return brxz;
	}

	public void setBrxz(Integer brxz) {
		this.brxz = brxz;
	}

	public String getXzmc() {
		return xzmc;
	}

	public void setXzmc(String xzmc) {
		this.xzmc = xzmc;
	}

	public Integer getFyxh() {
		return fyxh;
	}

	public void setFyxh(Integer fyxh) {
		this.fyxh = fyxh;
	}

	public BigDecimal getZfbl() {
		return zfbl;
	}

	public void setZfbl(BigDecimal zfbl) {
		this.zfbl = zfbl;
	}

	public BigDecimal getFyxe() {
		return fyxe;
	}

	public void setFyxe(BigDecimal fyxe) {
		this.fyxe = fyxe;
	}

	public BigDecimal getCxbl() {
		return cxbl;
	}

	public void setCxbl(BigDecimal cxbl) {
		this.cxbl = cxbl;
	}

}
