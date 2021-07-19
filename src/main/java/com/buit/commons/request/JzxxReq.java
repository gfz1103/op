
package com.buit.commons.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：JzxxReq<br>
 * 类描述：结账请求<br>
 * 
 * @author bjh
 */
@ApiModel(value = "日结请求")
public class JzxxReq extends PageQuery {
	@ApiModelProperty(value = "收费日报标志  产生:0 ; 查询确认:传2")
	private String save;
	@ApiModelProperty(value = "结账日期")
	private String jzrq;
	@ApiModelProperty(value = "结账开始日期")
	private String jzksrq;
	@ApiModelProperty(value = "结账结束日期")
	private String jzjsrq;
	@ApiModelProperty(value = "门诊类别")
	private String mzlb;


	public String getSave() {
		return save;
	}

	public void setSave(String save) {
		this.save = save;
	}

	public String getJzrq() {
		return jzrq;
	}

	public void setJzrq(String jzrq) {
		this.jzrq = jzrq;
	}

	public String getJzksrq() {
		return jzksrq;
	}

	public void setJzksrq(String jzksrq) {
		this.jzksrq = jzksrq;
	}

	public String getJzjsrq() {
		return jzjsrq;
	}

	public void setJzjsrq(String jzjsrq) {
		this.jzjsrq = jzjsrq;
	}

	public String getMzlb() {
		return mzlb;
	}

	public void setMzlb(String mzlb) {
		this.mzlb = mzlb;
	}
}