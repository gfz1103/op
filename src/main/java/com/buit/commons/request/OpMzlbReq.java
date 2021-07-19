
package com.buit.commons.request;

import javax.validation.constraints.NotBlank;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpMzlb<br>
 * 类描述：医保线路维护<br>
 * 
 * @author WY
 */
@ApiModel(value = "医保线路维护")
public class OpMzlbReq extends PageQuery {
	@ApiModelProperty(value = "门诊类别")
	private Integer mzlb;
	@ApiModelProperty(value = "机构代码", required = true)
	private Integer jgid;
	@ApiModelProperty(value = "门诊名称")
	private String mzmc;
	@NotBlank(message = "医保机构ID不能为空")
	@ApiModelProperty(value = "医保机构ID", required = true)
	private String ybjgid;
	@NotBlank(message = "医保线路ID不能为空")
	@ApiModelProperty(value = "医保线路ID", required = true)
	private String ybxlid;
	@ApiModelProperty(value = "是否启用")
	private String sfqy;
	@NotBlank(message = "月报名称不能为空")
	@ApiModelProperty(value = "月报名称", required = true)
	private String ybmc;
	@JsonIgnore
	@ApiModelProperty(value = "wsbz")
	private String wsbz;

	/**
	 * 设置:门诊类别
	 */
	public void setMzlb(Integer value) {
		this.mzlb = value;
	}

	/**
	 * 获取:门诊类别
	 */
	public Integer getMzlb() {
		return mzlb;
	}

	/**
	 * 设置:机构代码
	 */
	public void setJgid(Integer value) {
		this.jgid = value;
	}

	/**
	 * 获取:机构代码
	 */
	public Integer getJgid() {
		return jgid;
	}

	/**
	 * 设置:门诊名称
	 */
	public void setMzmc(String value) {
		this.mzmc = value;
	}

	/**
	 * 获取:门诊名称
	 */
	public String getMzmc() {
		return mzmc;
	}

	/**
	 * 设置:医保机构ID
	 */
	public void setYbjgid(String value) {
		this.ybjgid = value;
	}

	/**
	 * 获取:医保机构ID
	 */
	public String getYbjgid() {
		return ybjgid;
	}

	/**
	 * 设置:医保线路ID
	 */
	public void setYbxlid(String value) {
		this.ybxlid = value;
	}

	/**
	 * 获取:医保线路ID
	 */
	public String getYbxlid() {
		return ybxlid;
	}

	/**
	 * 设置:是否启用
	 */
	public void setSfqy(String value) {
		this.sfqy = value;
	}

	/**
	 * 获取:是否启用
	 */
	public String getSfqy() {
		return sfqy;
	}

	/**
	 * 设置:月报名称
	 */
	public void setYbmc(String value) {
		this.ybmc = value;
	}

	/**
	 * 获取:月报名称
	 */
	public String getYbmc() {
		return ybmc;
	}

	/**
	 * 设置:wsbz
	 */
	public void setWsbz(String value) {
		this.wsbz = value;
	}

	/**
	 * 获取:wsbz
	 */
	public String getWsbz() {
		return wsbz;
	}
}
