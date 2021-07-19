
package com.buit.commons.request;

import java.sql.Date;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MsQryPersonReq<br>
 * 类描述：病人卡号查询请求<br>
 * 
 * @author wangyang
 */
@ApiModel(value = "病人卡号查询请求")
public class MsQryPersonReq extends PageQuery {
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "挂号日期, yyyy-MM-dd")
	private Date ghrq;
	@ApiModelProperty(value = "医保性质,暂时不用")
	private Integer ybxz;
	@ApiModelProperty(value = "预约标识")
	private Integer yytag;
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@JsonIgnore
	@ApiModelProperty(value = "员工代码")
	private Integer ygdm;
	@ApiModelProperty(value = "门诊号码")
	private String mzhm;
	@ApiModelProperty(value = "卡号码")
	private String cardNo;
	@ApiModelProperty(value = "选中的挂号管理")
	private Integer selectedGhgl;
	@ApiModelProperty(value = "useBy")
	private String useBy;
	@ApiModelProperty(value = "新病人标识")
	private Integer newPerson;
	@ApiModelProperty(value = "ip")
	private String ip;
	@ApiModelProperty(value = "是否已经读卡刷卡")
	private int isRead;

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

	public Date getGhrq() {
		return ghrq;
	}

	public void setGhrq(Date ghrq) {
		this.ghrq = ghrq;
	}

	public Integer getYbxz() {
		return ybxz;
	}

	public void setYbxz(Integer ybxz) {
		this.ybxz = ybxz;
	}

	public Integer getYytag() {
		return yytag;
	}

	public void setYytag(Integer yytag) {
		this.yytag = yytag;
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

	public String getMzhm() {
		return mzhm;
	}

	public void setMzhm(String mzhm) {
		this.mzhm = mzhm;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Integer getSelectedGhgl() {
		return selectedGhgl;
	}

	public void setSelectedGhgl(Integer selectedGhgl) {
		this.selectedGhgl = selectedGhgl;
	}

	public String getUseBy() {
		return useBy;
	}

	public void setUseBy(String useBy) {
		this.useBy = useBy;
	}

	public Integer getNewPerson() {
		return newPerson;
	}

	public void setNewPerson(Integer newPerson) {
		this.newPerson = newPerson;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getIsRead() {
		return isRead;
	}

	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}
}