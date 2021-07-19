
package com.buit.commons.request;

import javax.validation.constraints.NotNull;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpMzzsAddReq<br>
 * 类描述：门诊诊室信息<br>
 * 
 * @author WY
 */
@ApiModel(value = "门诊诊室信息")
public class OpMzzsAddReq extends PageQuery {
	@ApiModelProperty(value = "识别序号 主键ID 新增时不传")
	private Integer sbxh;
	@NotNull(message = "挂号科室不能为空")
	@ApiModelProperty(value = "挂号科室", required = true)
	private Integer ghks;
	@NotNull(message = "诊室ID不能为空")
	@ApiModelProperty(value = "诊室ID", required = true)
	private Integer zsid;
	@NotNull(message = "诊室名称不能为空")
	@ApiModelProperty(value = "诊室名称", required = true)
	private String zsmc;
	@ApiModelProperty(value = "语音信息")
	private String yyxx;
	@ApiModelProperty(value = "屏幕ID")
	private String pmid;
	@NotNull(message = "叫号状态不能为空")
	@ApiModelProperty(value = "是否叫号(1是,2否) 标准：1:是 0：否", required = true)
	private String sfjh;
	@NotNull(message = "启用状态不能为空")
	@ApiModelProperty(value = "是否启用(1启用,2禁用) 标准：0:启用 1：停用", required = true)
	private String sfqy;
	@ApiModelProperty(value = "ip  逗号分割")
	private String ip;

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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
