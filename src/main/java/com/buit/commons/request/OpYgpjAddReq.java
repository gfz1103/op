
package com.buit.commons.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpYgpjAddReq<br>
 * 类描述：票据号码维护<br>
 * 
 * @author WY
 */
@ApiModel(value = "票据号码维护")
public class OpYgpjAddReq extends PageQuery {
	@ApiModelProperty(value = "记录序号,修改时候必传")
	private Integer jlxh;
	@ApiModelProperty(value = "员工代码")
	private Integer ygdm;
	@ApiModelProperty(value = "领用日期")
	private Date lyrq;
	@NotNull(message = "票据类型不能为空")
	@ApiModelProperty(value = "票据类型：1-就诊号码维护;2-发票号码维护;3-档案号码维护;4-充值号码维护;")
	private Integer pjlx;
	@JsonIgnore
	@ApiModelProperty(value = "机构代码")
	private Integer jgid;
	@NotNull(message = "起始号码不能为空")
	@ApiModelProperty(value = "起始号码", required = true)
	private String qshm;
	@NotNull(message = "终止号码不能为空")
	@ApiModelProperty(value = "终止号码", required = true)
	private String zzhm;
	@NotNull(message = "使用号码不能为空")
	@ApiModelProperty(value = "使用号码", required = true)
	private String syhm;
	@JsonIgnore
	@ApiModelProperty(value = "使用判别")
	private Integer sypb;

	/**
	 * 设置:记录序号
	 */
	public void setJlxh(Integer value) {
		this.jlxh = value;
	}

	/**
	 * 获取:记录序号
	 */
	public Integer getJlxh() {
		return jlxh;
	}

	/**
	 * 设置:员工代码
	 */
	public void setYgdm(Integer value) {
		this.ygdm = value;
	}

	/**
	 * 获取:员工代码
	 */
	public Integer getYgdm() {
		return ygdm;
	}

	public Date getLyrq() {
		return lyrq;
	}

	public void setLyrq(Date lyrq) {
		this.lyrq = lyrq;
	}

	/**
	 * 设置:票据类型
	 */
	public void setPjlx(Integer value) {
		this.pjlx = value;
	}

	/**
	 * 获取:票据类型
	 */
	public Integer getPjlx() {
		return pjlx;
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
	 * 设置:使用判别
	 */
	public void setSypb(Integer value) {
		this.sypb = value;
	}

	/**
	 * 获取:使用判别
	 */
	public Integer getSypb() {
		return sypb;
	}

	public String getQshm() {
		return qshm;
	}

	public void setQshm(String qshm) {
		this.qshm = qshm;
	}

	public String getZzhm() {
		return zzhm;
	}

	public void setZzhm(String zzhm) {
		this.zzhm = zzhm;
	}

	public String getSyhm() {
		return syhm;
	}

	public void setSyhm(String syhm) {
		this.syhm = syhm;
	}

}
