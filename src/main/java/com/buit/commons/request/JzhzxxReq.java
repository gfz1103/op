
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
@ApiModel(value = "日结汇总请求")
public class JzhzxxReq extends PageQuery {
	@ApiModelProperty(value = "收费汇总日报标志  产生:0 ; 查询 打印:传2")
	private String save;
	@ApiModelProperty(value = "汇总开始日期")
	private String hzksrq;
	@ApiModelProperty(value = "汇总结束日期")
	private String hzjsrq;
	@ApiModelProperty(value = "门诊类别")
	private int mzlb;


	public String getSave() {
		return save;
	}

	public void setSave(String save) {
		this.save = save;
	}

	public String getHzksrq() {
		return hzksrq;
	}

	public void setHzksrq(String hzksrq) {
		this.hzksrq = hzksrq;
	}

	public String getHzjsrq() {
		return hzjsrq;
	}

	public void setHzjsrq(String hzjsrq) {
		this.hzjsrq = hzjsrq;
	}

	public int getMzlb() {
		return mzlb;
	}

	public void setMzlb(int mzlb) {
		this.mzlb = mzlb;
	}
}