
package com.buit.commons.request;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MsQryPersonReq<br>
 * 类描述：挂号单据查询请求<br>
 * 
 * @author wangyang
 */
@ApiModel(value = "挂号单据查询请求")
public class MsQryGhdjReq extends PageQuery {
	@ApiModelProperty(value = "医保信息")
	private String ybxx;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "发票号码")
	private String fphm;
	@ApiModelProperty(value = "门诊号码")
	private String mzhm;
	@ApiModelProperty(value = "机构代码")
	private Integer jgid;
	@ApiModelProperty(value = "个人编号")
	private String grbh;

	public String getYbxx() {
		return ybxx;
	}

	public void setYbxx(String ybxx) {
		this.ybxx = ybxx;
	}

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	public String getMzhm() {
		return mzhm;
	}

	public void setMzhm(String mzhm) {
		this.mzhm = mzhm;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public String getGrbh() {
		return grbh;
	}

	public void setGrbh(String grbh) {
		this.grbh = grbh;
	}

}