
package com.buit.commons.response;

import java.sql.Date;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryYjfzbrResp<br>
 * 类描述：挂号管理查询分诊病人信息<br>
 * 
 * @author wy
 */
@ApiModel(value = "挂号管理查询分诊病人信息返回")
public class QueryYjfzbrResp extends PageQuery {
	private static final long serialVersionUID = 4351632017563703320L;
	@ApiModelProperty(value = "急诊流水号 分诊表主键")
	private Integer lsh;
	@ApiModelProperty(value = "分诊日期")
	private Date fzrq;
	@ApiModelProperty(value = "来诊时间")
	private String lzsj;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "病人性别")
	private Integer brxb;
	@ApiModelProperty(value = "病人年龄")
	private Integer brnl;
	@ApiModelProperty(value = "联系方式")
	private String lxfs;
	@ApiModelProperty(value = "主诉")
	private String zs;
	@ApiModelProperty(value = "分诊级别")
	private Integer fzjb;
	@ApiModelProperty(value = "分诊科室代码")
	private Integer fzksdm;
	@ApiModelProperty(value = "分诊医生代码")
	private Integer ysdm;
	@ApiModelProperty(value = "分诊护士代码")
	private Integer fzhsdm;

	public Integer getLsh() {
		return lsh;
	}

	public void setLsh(Integer lsh) {
		this.lsh = lsh;
	}

	public Date getFzrq() {
		return fzrq;
	}

	public void setFzrq(Date fzrq) {
		this.fzrq = fzrq;
	}

	public String getLzsj() {
		return lzsj;
	}

	public void setLzsj(String lzsj) {
		this.lzsj = lzsj;
	}

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

	public String getBrxm() {
		return brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	public Integer getBrxb() {
		return brxb;
	}

	public void setBrxb(Integer brxb) {
		this.brxb = brxb;
	}

	public Integer getBrnl() {
		return brnl;
	}

	public void setBrnl(Integer brnl) {
		this.brnl = brnl;
	}

	public String getLxfs() {
		return lxfs;
	}

	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}

	public String getZs() {
		return zs;
	}

	public void setZs(String zs) {
		this.zs = zs;
	}

	public Integer getFzjb() {
		return fzjb;
	}

	public void setFzjb(Integer fzjb) {
		this.fzjb = fzjb;
	}

	public Integer getFzksdm() {
		return fzksdm;
	}

	public void setFzksdm(Integer fzksdm) {
		this.fzksdm = fzksdm;
	}

	public Integer getYsdm() {
		return ysdm;
	}

	public void setYsdm(Integer ysdm) {
		this.ysdm = ysdm;
	}

	public Integer getFzhsdm() {
		return fzhsdm;
	}

	public void setFzhsdm(Integer fzhsdm) {
		this.fzhsdm = fzhsdm;
	}

}