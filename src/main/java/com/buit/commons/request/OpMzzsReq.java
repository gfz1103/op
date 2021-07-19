
package com.buit.commons.request;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpMzzs<br>
 * 类描述：门诊诊室信息<br>
 * 
 * @author WY
 */
@ApiModel(value = "门诊诊室信息")
public class OpMzzsReq extends PageQuery {
	@JsonIgnore
	@ApiModelProperty(value = "识别序号")
	private Integer sbxh;
	@JsonIgnore
	@ApiModelProperty(value = "挂号科室")
	private Integer ghks;
	@ApiModelProperty(value = "诊室ID")
	private Integer zsid;
	@ApiModelProperty(value = "诊室名称")
	private String zsmc;
	@JsonIgnore
	@ApiModelProperty(value = "语音信息")
	private String yyxx;
	@JsonIgnore
	@ApiModelProperty(value = "屏幕ID")
	private String pmid;
	@JsonIgnore
	@ApiModelProperty(value = "是否叫号(1是,2否)")
	private String sfjh;
	@JsonIgnore
	@ApiModelProperty(value = "是否启用(1启用,2禁用)")
	private String sfqy;

	public Integer getSbxh() {
		return sbxh;
	}

	public void setSbxh(Integer sbxh) {
		this.sbxh = sbxh;
	}

	public Integer getGhks() {
		return ghks;
	}

	public void setGhks(Integer ghks) {
		this.ghks = ghks;
	}

	/**
	 * 设置:诊室ID
	 */
	public void setZsid(Integer value) {
		this.zsid = value;
	}

	/**
	 * 获取:诊室ID
	 */
	public Integer getZsid() {
		return zsid;
	}

	/**
	 * 设置:诊室名称
	 */
	public void setZsmc(String value) {
		this.zsmc = value;
	}

	/**
	 * 获取:诊室名称
	 */
	public String getZsmc() {
		return zsmc;
	}

	/**
	 * 设置:语音信息
	 */
	public void setYyxx(String value) {
		this.yyxx = value;
	}

	/**
	 * 获取:语音信息
	 */
	public String getYyxx() {
		return yyxx;
	}

	/**
	 * 设置:屏幕ID
	 */
	public void setPmid(String value) {
		this.pmid = value;
	}

	/**
	 * 获取:屏幕ID
	 */
	public String getPmid() {
		return pmid;
	}

	/**
	 * 设置:是否叫号(1是,2否)
	 */
	public void setSfjh(String value) {
		this.sfjh = value;
	}

	/**
	 * 获取:是否叫号(1是,2否)
	 */
	public String getSfjh() {
		return sfjh;
	}

	/**
	 * 设置:是否启用(1启用,2禁用)
	 */
	public void setSfqy(String value) {
		this.sfqy = value;
	}

	/**
	 * 获取:是否启用(1启用,2禁用)
	 */
	public String getSfqy() {
		return sfqy;
	}
}
