package com.buit.commons.model;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpYbip<br>
 * 类描述：
 * 
 * @author WY
 */
@ApiModel(value = "医保IP")
public class OpYbip extends PageQuery {
	@ApiModelProperty(value = "识别序号")
	private Integer sbxh;
	@ApiModelProperty(value = "门诊类别")
	private Integer mzlb;
	@ApiModelProperty(value = "机构ID")
	private String jgid;
	@ApiModelProperty(value = "绑定IP")
	private String ip;
	@ApiModelProperty(value = "创建标识")
	private String opStatus;

	/** 设置:识别序号 */
	public void setSbxh(Integer value) {
		this.sbxh = value;
	}

	/** 获取:识别序号 */
	public Integer getSbxh() {
		return sbxh;
	}

	/** 设置:门诊类别 */
	public void setMzlb(Integer value) {
		this.mzlb = value;
	}

	/** 获取:门诊类别 */
	public Integer getMzlb() {
		return mzlb;
	}

	/** 设置:机构ID */
	public void setJgid(String value) {
		this.jgid = value;
	}

	/** 获取:机构ID */
	public String getJgid() {
		return jgid;
	}

	/** 设置:绑定IP */
	public void setIp(String value) {
		this.ip = value;
	}

	/** 获取:绑定IP */
	public String getIp() {
		return ip;
	}

	public String getOpStatus() {
		return opStatus;
	}

	public void setOpStatus(String opStatus) {
		this.opStatus = opStatus;
	}

}
