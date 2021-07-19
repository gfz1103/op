
package com.buit.commons.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 类名称：QueryUnPsxmResp<br>
 * 类描述：查询病人未执行的皮试项目列表返回<br>
 *
 * @author WY
 */
@ApiModel(value = "查询病人未执行的皮试项目列表返回")
public class QueryUnPsxmResp {
	@ApiModelProperty(value = "收费日期")
	private Date sfrq;
	@ApiModelProperty(value = "皮试项目ID")
	private Integer psid;
	@ApiModelProperty(value = "皮试项目名称")
	private String psmc;
	@JsonIgnore
	@ApiModelProperty(value = "药品数量")
	private Integer ypsl;
	@ApiModelProperty(value = "科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "医生代码")
	private Integer ysdm;
	@ApiModelProperty(value = "备注名称")
	private String bzmc;
	@JsonIgnore
	@ApiModelProperty(value = "开始时间")
	private Date beginDay;
	@JsonIgnore
	@ApiModelProperty(value = "结束时间")
	private Date endDay;
	@ApiModelProperty(value = "门诊序号")
	private Integer mzhm;
	@ApiModelProperty(value = "发票号码")
	private String fphm;
	@ApiModelProperty(value = "发药标志（1已发药 0未发药）")
	private Integer fybz;


	public Integer getFybz() {
		return fybz;
	}

	public void setFybz(Integer fybz) {
		this.fybz = fybz;
	}

	public Integer getPsid() {
		return psid;
	}

	public void setPsid(Integer psid) {
		this.psid = psid;
	}

	public String getPsmc() {
		return psmc;
	}

	public void setPsmc(String psmc) {
		this.psmc = psmc;
	}

	public Integer getYpsl() {
		return ypsl;
	}

	public void setYpsl(Integer ypsl) {
		this.ypsl = ypsl;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public Integer getYsdm() {
		return ysdm;
	}

	public void setYsdm(Integer ysdm) {
		this.ysdm = ysdm;
	}

	public String getBzmc() {
		return bzmc;
	}

	public void setBzmc(String bzmc) {
		this.bzmc = bzmc;
	}

	public Date getBeginDay() {
		return beginDay;
	}

	public void setBeginDay(Date beginDay) {
		this.beginDay = beginDay;
	}

	public Date getEndDay() {
		return endDay;
	}

	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}

	public Date getSfrq() {
		return sfrq;
	}

	public void setSfrq(Date sfrq) {
		this.sfrq = sfrq;
	}

	public Integer getMzhm() {
		return mzhm;
	}

	public void setMzhm(Integer mzhm) {
		this.mzhm = mzhm;
	}

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

}
