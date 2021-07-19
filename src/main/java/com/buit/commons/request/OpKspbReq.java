
package com.buit.commons.request;

import java.sql.Date;
import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpKspb<br>
 * 类描述：门诊_科室排班<br>
 * 
 * @author wangyang
 */
@ApiModel(value = "门诊_科室排班")
public class OpKspbReq extends PageQuery {
	@NotNull(message = "排班日期不能为空")
	@ApiModelProperty(value = "排班日期: 默认传当天日期 ,格式：yyyy-MM-dd ")
	private Date ghrq;
	@NotNull(message = "值班类别不能为空")
	@ApiModelProperty(value = "值班类别:上午：1 下午：2  默认传1修改为从op_basj表取时间段标识")
	private String zblb;
	@JsonIgnore
	@ApiModelProperty(value = "机构代码")
	private Integer jgid;
	@JsonIgnore
	@ApiModelProperty(value = "查询开始时间")
	private Timestamp beginOfDay;
	@JsonIgnore
	@ApiModelProperty(value = "查询结束时间")
	private Timestamp endOfDay;
	@ApiModelProperty(value = "关键字查询")
	private String keyword;

	public Date getGhrq() {
		return ghrq;
	}

	public void setGhrq(Date ghrq) {
		this.ghrq = ghrq;
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

	public Timestamp getBeginOfDay() {
		return beginOfDay;
	}

	public void setBeginOfDay(Timestamp beginOfDay) {
		this.beginOfDay = beginOfDay;
	}

	public Timestamp getEndOfDay() {
		return endOfDay;
	}

	public void setEndOfDay(Timestamp endOfDay) {
		this.endOfDay = endOfDay;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
