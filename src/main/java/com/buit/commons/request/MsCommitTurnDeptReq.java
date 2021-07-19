package com.buit.commons.request;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MsCommitTurnDeptReq<br>
 * 类描述：转科确认请求
 * 
 * @author wangyang
 */
@ApiModel(value = "转科确认请求")
public class MsCommitTurnDeptReq extends PageQuery {
	@ApiModelProperty(value = "现挂科室")
	private Integer xgks;
	@ApiModelProperty(value = "转入科室")
	private Integer ksdm;
	@ApiModelProperty(value = "识别序号")
	private Integer sbxh;
	@ApiModelProperty(value = "挂号时间")
	private Timestamp ghsj;
	@ApiModelProperty(value = "转入医生")
	private Integer zrys;
	@ApiModelProperty(value = "转入诊室")
	private Integer zrzs;
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@JsonIgnore
	@ApiModelProperty(value = "用户ID")
	private Integer ygdm;
	@ApiModelProperty(value = "就诊流水号")
	private String jzlsh;

	public Integer getXgks() {
		return xgks;
	}

	public void setXgks(Integer xgks) {
		this.xgks = xgks;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public Integer getSbxh() {
		return sbxh;
	}

	public void setSbxh(Integer sbxh) {
		this.sbxh = sbxh;
	}

	public Timestamp getGhsj() {
		return ghsj;
	}

	public void setGhsj(Timestamp ghsj) {
		this.ghsj = ghsj;
	}

	public Integer getZrys() {
		return zrys;
	}

	public void setZrys(Integer zrys) {
		this.zrys = zrys;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public Integer getYgdm() {
		return ygdm;
	}

	public void setYgdm(Integer ygdm) {
		this.ygdm = ygdm;
	}

	public Integer getZrzs() {
		return zrzs;
	}

	public void setZrzs(Integer zrzs) {
		this.zrzs = zrzs;
	}

	public String getJzlsh() {
		return jzlsh;
	}

	public void setJzlsh(String jzlsh) {
		this.jzlsh = jzlsh;
	}

}