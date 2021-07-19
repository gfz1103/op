
package com.buit.commons.request;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SaveCopyFphmReq<br>
 * 类描述：复制发票号码请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "复制发票号码请求")
public class SaveCopyFphmReq extends PageQuery {
	@ApiModelProperty(value = "发票号码 ")
	private String fphm;
	@ApiModelProperty(value = "门诊信息")
	private CopyFphmMzxxReq mzxx;
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	public CopyFphmMzxxReq getMzxx() {
		return mzxx;
	}

	public void setMzxx(CopyFphmMzxxReq mzxx) {
		this.mzxx = mzxx;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

}