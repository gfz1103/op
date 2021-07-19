
package com.buit.commons.response;

import java.sql.Timestamp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryPsDjListResp<br>
 * 类描述：皮试工作量统计每日输液数据返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "皮试工作量统计每日输液数据返回")
public class QueryPsDjListResp {
	@ApiModelProperty(value = "皮试序号")
	private Integer psxh;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "病人性别")
	private Integer brxb;
	@ApiModelProperty(value = "出生年月")
	private Timestamp csny;
	@ApiModelProperty(value = "年龄")
	private Integer age;
	@ApiModelProperty(value = "登记时间")
	private Timestamp djsj;
	@ApiModelProperty(value = "皮试项目名称")
	private String psmc;
	@ApiModelProperty(value = "开始时间")
	private Timestamp kssj;
	@ApiModelProperty(value = "皮试时长(分钟)")
	private Integer pssc;
	@ApiModelProperty(value = "结束时间")
	private Timestamp jssj;
	@ApiModelProperty(value = "实际皮试时长(分钟)")
	private Integer sjpssc;
	@ApiModelProperty(value = "皮试结果")
	private Integer psjg;
	@ApiModelProperty(value = "填写人代码")
	private String txrdm;
	@ApiModelProperty(value = "状态：0:未开始 1:皮试中 2:皮试完成")
	private String zt;

	public Integer getPsxh() {
		return psxh;
	}

	public void setPsxh(Integer psxh) {
		this.psxh = psxh;
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

	public Timestamp getDjsj() {
		return djsj;
	}

	public void setDjsj(Timestamp djsj) {
		this.djsj = djsj;
	}

	public String getPsmc() {
		return psmc;
	}

	public void setPsmc(String psmc) {
		this.psmc = psmc;
	}

	public Timestamp getKssj() {
		return kssj;
	}

	public void setKssj(Timestamp kssj) {
		this.kssj = kssj;
	}

	public Integer getPssc() {
		return pssc;
	}

	public void setPssc(Integer pssc) {
		this.pssc = pssc;
	}

	public Timestamp getJssj() {
		return jssj;
	}

	public void setJssj(Timestamp jssj) {
		this.jssj = jssj;
	}

	public Integer getSjpssc() {
		return sjpssc;
	}

	public void setSjpssc(Integer sjpssc) {
		this.sjpssc = sjpssc;
	}

	public Integer getPsjg() {
		return psjg;
	}

	public void setPsjg(Integer psjg) {
		this.psjg = psjg;
	}

	public String getTxrdm() {
		return txrdm;
	}

	public void setTxrdm(String txrdm) {
		this.txrdm = txrdm;
	}

	public Timestamp getCsny() {
		return csny;
	}

	public void setCsny(Timestamp csny) {
		this.csny = csny;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}
	
	

}