
package com.buit.commons.response;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QuerySyptdyResp<br>
 * 类描述：输液瓶贴打印返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "输液瓶贴打印返回")
public class QuerySyptdyResp extends PageQuery {
	private static final long serialVersionUID = 8324768612085530176L;
	@ApiModelProperty(value = "登记时间")
	private Timestamp djsj;
	@ApiModelProperty(value = "病人ID")
	private Integer brid;
	@ApiModelProperty(value = "别人姓名")
	private String brxm;
	@ApiModelProperty(value = "病人性别")
	private Integer brxb;
	@ApiModelProperty(value = "病人年龄")
	private String ages;
	@ApiModelProperty(value = "出生年月")
	private Timestamp csny;
	@ApiModelProperty(value = "病人诊断")
	private String brzd;
	@ApiModelProperty(value = "核对者员工代码")
	private Integer hdygdm;
	@ApiModelProperty(value = "核对时间")
	private Timestamp hdsj;
	@ApiModelProperty(value = "加药者员工代码")
	private Integer jyygdm;
	@ApiModelProperty(value = "加药时间")
	private Timestamp jysj;
	@ApiModelProperty(value = "出生年月格式化")
	private String csnyStr;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "完成时间")
	private Timestamp wcsj;
	@ApiModelProperty(value = "药品信息列表")
	List<QueryUnRegistResp> lists = new ArrayList<QueryUnRegistResp>();
	@ApiModelProperty(value = "药品信息列表")
	Map<Integer, List<QueryUnRegistResp>> maps = new HashMap<Integer, List<QueryUnRegistResp>>();

	public String getBrzd() {
		return brzd;
	}

	public void setBrzd(String brzd) {
		this.brzd = brzd;
	}

	public Timestamp getDjsj() {
		return djsj;
	}

	public void setDjsj(Timestamp djsj) {
		this.djsj = djsj;
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

	public String getAges() {
		return ages;
	}

	public void setAges(String ages) {
		this.ages = ages;
	}

	public Timestamp getCsny() {
		return csny;
	}

	public void setCsny(Timestamp csny) {
		this.csny = csny;
	}

	public Integer getHdygdm() {
		return hdygdm;
	}

	public void setHdygdm(Integer hdygdm) {
		this.hdygdm = hdygdm;
	}

	public Timestamp getHdsj() {
		return hdsj;
	}

	public void setHdsj(Timestamp hdsj) {
		this.hdsj = hdsj;
	}

	public Integer getJyygdm() {
		return jyygdm;
	}

	public void setJyygdm(Integer jyygdm) {
		this.jyygdm = jyygdm;
	}

	public Timestamp getJysj() {
		return jysj;
	}

	public void setJysj(Timestamp jysj) {
		this.jysj = jysj;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<QueryUnRegistResp> getLists() {
		return lists;
	}

	public void setLists(List<QueryUnRegistResp> lists) {
		this.lists = lists;
	}

	public Integer getBrid() {
		return brid;
	}

	public void setBrid(Integer brid) {
		this.brid = brid;
	}

	public Map<Integer, List<QueryUnRegistResp>> getMaps() {
		return maps;
	}

	public void setMaps(Map<Integer, List<QueryUnRegistResp>> maps) {
		this.maps = maps;
	}

	public String getCsnyStr() {
		return csnyStr;
	}

	public void setCsnyStr(String csnyStr) {
		this.csnyStr = csnyStr;
	}

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

	public Timestamp getWcsj() {
		return wcsj;
	}

	public void setWcsj(Timestamp wcsj) {
		this.wcsj = wcsj;
	}

}