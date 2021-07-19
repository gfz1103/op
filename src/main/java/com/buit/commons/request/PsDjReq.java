
package com.buit.commons.request;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SkinDjzb<br>
 * 类描述：<br>
 *
 * @author WY
 */
@ApiModel(value = "皮试登记分页查询请求")
public class PsDjReq extends PageQuery {
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@ApiModelProperty(value = "输液科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "状态：多个则以逗号分隔传  0:未开始 1:皮试中 2:皮试完成 ")
	private String zt;
	@ApiModelProperty(value = "登记时间-开始")
	private String djsj_ks;
	@ApiModelProperty(value = "登记时间-结束")
	private String djsj_js;


	public String getDjsj_ks() {
		return djsj_ks;
	}

	public void setDjsj_ks(String djsj_ks) {
		this.djsj_ks = djsj_ks;
	}

	public String getDjsj_js() {
		return djsj_js;
	}

	public void setDjsj_js(String djsj_js) {
		this.djsj_js = djsj_js;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

}
