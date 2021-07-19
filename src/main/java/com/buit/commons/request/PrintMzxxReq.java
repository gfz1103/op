
package com.buit.commons.request;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：PrintMzxxReq<br>
 * 类描述：门诊信息发票打印请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "门诊信息发票打印请求")
public class PrintMzxxReq extends PageQuery {
	private static final long serialVersionUID = 4063321824105861295L;
	@ApiModelProperty(value = "发票号码")
	private String fphm;
	@ApiModelProperty(value = "是否医保")
	private boolean isYb;
	@ApiModelProperty(value = "真实发票号码")
	private String zsfphm;
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@ApiModelProperty(value = "机构名称")
	private String jgName;

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	public boolean isYb() {
		return isYb;
	}

	public void setYb(boolean isYb) {
		this.isYb = isYb;
	}

	public String getZsfphm() {
		return zsfphm;
	}

	public void setZsfphm(String zsfphm) {
		this.zsfphm = zsfphm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public String getJgName() {
		return jgName;
	}

	public void setJgName(String jgName) {
		this.jgName = jgName;
	}

}