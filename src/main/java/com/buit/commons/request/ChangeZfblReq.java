
package com.buit.commons.request;

import java.util.ArrayList;
import java.util.List;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：ChangeZfblReq<br>
 * 类描述：根据病人性质改变自负比例<br>
 * 
 * @author WY
 */
@ApiModel(value = "根据病人性质改变自负比例")
public class ChangeZfblReq extends PageQuery {
	private static final long serialVersionUID = -5650405589869927739L;
	@ApiModelProperty(value = "自负比例")
	private List<ZfblReq> zfblList = new ArrayList<ZfblReq>();
	@ApiModelProperty(value = "病人性质 ")
	private Integer brxz;
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@ApiModelProperty(value = "发票查询")
	private String fpcx;

	public List<ZfblReq> getZfblList() {
		return zfblList;
	}

	public void setZfblList(List<ZfblReq> zfblList) {
		this.zfblList = zfblList;
	}

	public Integer getBrxz() {
		return brxz;
	}

	public void setBrxz(Integer brxz) {
		this.brxz = brxz;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public String getFpcx() {
		return fpcx;
	}

	public void setFpcx(String fpcx) {
		this.fpcx = fpcx;
	}

}