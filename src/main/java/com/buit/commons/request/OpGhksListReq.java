
package com.buit.commons.request;

import java.sql.Date;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpGhksListReq<br>
 * 类描述：挂号科室列表<br>
 * 
 * @author WY
 */
@ApiModel(value = "挂号科室列表")
public class OpGhksListReq extends PageQuery {
	private static final long serialVersionUID = 4955686865927775722L;
	@ApiModelProperty(value = "挂号日期")
	private Date ghrq;
	@ApiModelProperty(value = "预约标识")
	private Integer yytag;
	@ApiModelProperty(value = "值班类型")
	private String zblb;
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@JsonIgnore
	@ApiModelProperty(value = "本机ip")
	private String ip;
	@ApiModelProperty(value = "挂号类型（0：普通门诊 1:急诊）")
	private Integer ghlx;
	@ApiModelProperty(value = "大病项目")
	private String dbtype;
	@ApiModelProperty(value = "是否互联网科室 1是 0否")
	private String internet;

	public String getInternet() {
		return internet;
	}

	public void setInternet(String internet) {
		this.internet = internet;
	}

	public Date getGhrq() {
		return ghrq;
	}

	public void setGhrq(Date ghrq) {
		this.ghrq = ghrq;
	}

	public Integer getYytag() {
		return yytag;
	}

	public void setYytag(Integer yytag) {
		this.yytag = yytag;
	}

	public String getZblb() {
		return zblb;
	}

	public void setZblb(String zblb) {
		this.zblb = zblb;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getGhlx() {
		return ghlx;
	}

	public void setGhlx(Integer ghlx) {
		this.ghlx = ghlx;
	}

	public String getDbtype() {
		return dbtype;
	}

	public void setDbtype(String dbtype) {
		this.dbtype = dbtype;
	}
}
