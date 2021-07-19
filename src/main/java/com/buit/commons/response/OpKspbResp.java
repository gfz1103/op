package com.buit.commons.response;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpKspb<br>
 * 类描述：门诊_科室排班<br>
 * 
 * @author LAPTOP-VAONTPUB
 */
@ApiModel(value = "门诊_科室排班")
public class OpKspbResp extends PageQuery {
	@ApiModelProperty(value = "挂号日期")
	private Timestamp ghrq;
	@ApiModelProperty(value = "值班类别")
	private String zblb;
	@ApiModelProperty(value = "挂号科室")
	private String ghks;
	@ApiModelProperty(value = "机构代码")
	private Integer jgid;
	@ApiModelProperty(value = "就诊序号")
	private Integer jzxh;
	@ApiModelProperty(value = "挂号限额")
	private Integer ghxe;
	@ApiModelProperty(value = "已挂人数")
	private Integer ygrs;
	@ApiModelProperty(value = "预约人数")
	private Integer yyrs;
	@ApiModelProperty(value = "预约限额")
	private Integer yyxe;
	@ApiModelProperty(value = "停挂标志")
	private Integer tgbz;

	/**
	 * 设置:挂号日期
	 */
	public void setGhrq(Timestamp value) {
		this.ghrq = value;
	}

	/**
	 * 获取:挂号日期
	 */
	public Timestamp getGhrq() {
		return ghrq;
	}

	/**
	 * 设置:挂号科室
	 */
	public void setGhks(String value) {
		this.ghks = value;
	}

	/**
	 * 获取:挂号科室
	 */
	public String getGhks() {
		return ghks;
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
	 * 设置:就诊序号
	 */
	public void setJzxh(Integer value) {
		this.jzxh = value;
	}

	/**
	 * 获取:就诊序号
	 */
	public Integer getJzxh() {
		return jzxh;
	}

	/**
	 * 设置:挂号限额
	 */
	public void setGhxe(Integer value) {
		this.ghxe = value;
	}

	/**
	 * 获取:挂号限额
	 */
	public Integer getGhxe() {
		return ghxe;
	}

	/**
	 * 设置:已挂人数
	 */
	public void setYgrs(Integer value) {
		this.ygrs = value;
	}

	/**
	 * 获取:已挂人数
	 */
	public Integer getYgrs() {
		return ygrs;
	}

	/**
	 * 设置:预约人数
	 */
	public void setYyrs(Integer value) {
		this.yyrs = value;
	}

	/**
	 * 获取:预约人数
	 */
	public Integer getYyrs() {
		return yyrs;
	}

	/**
	 * 设置:预约限额
	 */
	public void setYyxe(Integer value) {
		this.yyxe = value;
	}

	/**
	 * 获取:预约限额
	 */
	public Integer getYyxe() {
		return yyxe;
	}

	public Integer getTgbz() {
		return tgbz;
	}

	public void setTgbz(Integer tgbz) {
		this.tgbz = tgbz;
	}

	public String getZblb() {
		return zblb;
	}

	public void setZblb(String zblb) {
		this.zblb = zblb;
	}

}
