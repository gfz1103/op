
package com.buit.commons.response;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MsGhYspbResp<br>
 * 类描述：门诊_门诊医生排班<br>
 * 
 * @author wy
 */
@ApiModel(value = "挂号-医生排班列表")
public class MsGhYspbResp extends PageQuery {
	@ApiModelProperty(value = "挂号限额")
	private Integer ghxe;
	@ApiModelProperty(value = "已挂人数")
	private Integer ygrs;
	@ApiModelProperty(value = "医生代码")
	private String ysdm;
	@ApiModelProperty(value = "科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "停挂标志 | 用于导诊系统 0.可挂号 1.不可挂号")
	private Integer tgbz;
	@ApiModelProperty(value = "预约人数")
	private Integer yyrs;
	@ApiModelProperty(value = "值班类别 | 值班类别：1.上午  2.下午")
	private String zblb;
	@ApiModelProperty(value = "预约限额")
	private Integer yyxe;
	@ApiModelProperty(value = "拼音代码")
	private String pycode;
	@ApiModelProperty(value = "姓名")
	private String personname;
	@ApiModelProperty(value = "专家费用")
	private Integer expertcost;
	@ApiModelProperty(value = "专家判别 ")
	private String isexpert;
	@ApiModelProperty(value = "专家判别 名称")
	private String isexpertText;
	@ApiModelProperty(value = "开处方权")
	private String prescriberight;
	@ApiModelProperty(value = "暂挂人数")
	private Integer zgrs;
	@ApiModelProperty(value = "特需费用")
	private Integer specialcost;
	@ApiModelProperty(value = "特需判别")
	private String isspecial;
	@ApiModelProperty(value = "是否特需判别描述")
	private String isspecialText;
	@ApiModelProperty(value = "是否停诊(1是,0否)")
	private String sftz;
	@ApiModelProperty(value = "是否停诊描述")
	private String sftzText;
	@ApiModelProperty(value = "候诊人数")
	private Integer hzrs;
	@ApiModelProperty(value = "门诊科室")
	private Integer mzks;

	public Integer getGhxe() {
		return ghxe;
	}

	public void setGhxe(Integer ghxe) {
		this.ghxe = ghxe;
	}

	public Integer getYgrs() {
		return ygrs;
	}

	public void setYgrs(Integer ygrs) {
		this.ygrs = ygrs;
	}

	public String getYsdm() {
		return ysdm;
	}

	public void setYsdm(String ysdm) {
		this.ysdm = ysdm;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public Integer getTgbz() {
		return tgbz;
	}

	public void setTgbz(Integer tgbz) {
		this.tgbz = tgbz;
	}

	public Integer getYyrs() {
		return yyrs;
	}

	public void setYyrs(Integer yyrs) {
		this.yyrs = yyrs;
	}

	public String getZblb() {
		return zblb;
	}

	public void setZblb(String zblb) {
		this.zblb = zblb;
	}

	public Integer getYyxe() {
		return yyxe;
	}

	public void setYyxe(Integer yyxe) {
		this.yyxe = yyxe;
	}

	public String getPycode() {
		return pycode;
	}

	public void setPycode(String pycode) {
		this.pycode = pycode;
	}

	public String getPersonname() {
		return personname;
	}

	public void setPersonname(String personname) {
		this.personname = personname;
	}

	public String getIsexpert() {
		return isexpert;
	}

	public void setIsexpert(String isexpert) {
		this.isexpert = isexpert;
	}

	public String getIsexpertText() {
		return isexpertText;
	}

	public void setIsexpertText(String isexpertText) {
		this.isexpertText = isexpertText;
	}

	public Integer getExpertcost() {
		return expertcost;
	}

	public void setExpertcost(Integer expertcost) {
		this.expertcost = expertcost;
	}

	public String getPrescriberight() {
		return prescriberight;
	}

	public void setPrescriberight(String prescriberight) {
		this.prescriberight = prescriberight;
	}

	public Integer getZgrs() {
		return zgrs;
	}

	public void setZgrs(Integer zgrs) {
		this.zgrs = zgrs;
	}

	public Integer getSpecialcost() {
		return specialcost;
	}

	public void setSpecialcost(Integer specialcost) {
		this.specialcost = specialcost;
	}

	public String getIsspecial() {
		return isspecial;
	}

	public void setIsspecial(String isspecial) {
		this.isspecial = isspecial;
	}

	public String getIsspecialText() {
		return isspecialText;
	}

	public void setIsspecialText(String isspecialText) {
		this.isspecialText = isspecialText;
	}

	public String getSftz() {
		return sftz;
	}

	public void setSftz(String sftz) {
		this.sftz = sftz;
	}

	public String getSftzText() {
		return sftzText;
	}

	public void setSftzText(String sftzText) {
		this.sftzText = sftzText;
	}

	public Integer getHzrs() {
		return hzrs;
	}

	public void setHzrs(Integer hzrs) {
		this.hzrs = hzrs;
	}

	public Integer getMzks() {
		return mzks;
	}

	public void setMzks(Integer mzks) {
		this.mzks = mzks;
	}

}