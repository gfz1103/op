
package com.buit.commons.request;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.buit.commons.PageQuery;
import com.buit.his.shyb.source.entity.DetailsBill;
import com.buit.his.shyb.source.entity.DiagnosisInfo;
import com.buit.op.model.OpPosmx;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OutpatientSettlementReq<br>
 * 类描述：门诊结算请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "门诊结算请求")
public class OutpatientSettlementReq extends PageQuery {
	private static final long serialVersionUID = 3817496986431466636L;
	@ApiModelProperty(value = "付款信息")
	private List<OpFkxxReq> fkxxList;
	@ApiModelProperty(value = "卡号")
	private String cardno;
	@ApiModelProperty(value = "门诊信息")
	private MzxxReq mzxxReq = new MzxxReq();
	@ApiModelProperty(value = "结算数据列表")
	private List<QueryPayReq> list = new ArrayList<QueryPayReq>();
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@JsonIgnore
	@ApiModelProperty(value = "员工ID")
	private Integer ygdm;
	@JsonIgnore
	@ApiModelProperty(value = "员工姓名")
	private String ygxm;
	@ApiModelProperty(value = "结算类型 0 为窗口结算 1 为医生站结算 2 为自助机结算")
	private String issmk;
	@ApiModelProperty(value = "付款号码")
	private String fkhm;
	@JsonIgnore
	@ApiModelProperty(value = "ip")
	private String ip;
	@ApiModelProperty(value = "pos支付信息")
	private OpPosmx pos;
	@ApiModelProperty(value = "是否医保")
	private Integer isYb;
	@ApiModelProperty(value = "自负比例")
	private List<SaveSettleZfblDetailReq> details = new ArrayList<SaveSettleZfblDetailReq>();
	@ApiModelProperty(value = "自助机其他应收标识")
	private String zzjQtysFlag;
	@ApiModelProperty(value = "自助机其他应收")
	private BigDecimal zzjQtys;
	@ApiModelProperty(value = "自助机其他应收")
	private BigDecimal zzjZfje;
	@ApiModelProperty(value = "自助机货币误差")
	private BigDecimal zzjHbwc;
	@ApiModelProperty(value = "出库编号")
	private Integer ckbh;
	@ApiModelProperty(value = "临时Js未知数据")
	private String jsData;


	@ApiModelProperty(value = "工伤标志")
	private String gsbz;
	@ApiModelProperty(value = "工伤认定号")
	private String gsrdh;
	@ApiModelProperty(value = "大病项目代码")
	private String dbtype;


	@ApiModelProperty(value = "诊断列表")
	private List<DiagnosisInfo> diagnosisInfos = new ArrayList<DiagnosisInfo>();
	@ApiModelProperty(value = "明细账单")
	private List<DetailsBill> detailsBills = new ArrayList<DetailsBill>();

	public List<OpFkxxReq> getFkxxList() {
		return fkxxList;
	}

	public void setFkxxList(List<OpFkxxReq> fkxxList) {
		this.fkxxList = fkxxList;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public MzxxReq getMzxxReq() {
		return mzxxReq;
	}

	public void setMzxxReq(MzxxReq mzxxReq) {
		this.mzxxReq = mzxxReq;
	}

	public List<QueryPayReq> getList() {
		return list;
	}

	public void setList(List<QueryPayReq> list) {
		this.list = list;
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

	public String getIssmk() {
		return issmk;
	}

	public void setIssmk(String issmk) {
		this.issmk = issmk;
	}

	public String getFkhm() {
		return fkhm;
	}

	public void setFkhm(String fkhm) {
		this.fkhm = fkhm;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public OpPosmx getPos() {
		return pos;
	}

	public void setPos(OpPosmx pos) {
		this.pos = pos;
	}

	public Integer getIsYb() {
		return isYb;
	}

	public void setIsYb(Integer isYb) {
		this.isYb = isYb;
	}

	public List<SaveSettleZfblDetailReq> getDetails() {
		return details;
	}

	public void setDetails(List<SaveSettleZfblDetailReq> details) {
		this.details = details;
	}

	public String getZzjQtysFlag() {
		return zzjQtysFlag;
	}

	public void setZzjQtysFlag(String zzjQtysFlag) {
		this.zzjQtysFlag = zzjQtysFlag;
	}

	public BigDecimal getZzjQtys() {
		return zzjQtys;
	}

	public void setZzjQtys(BigDecimal zzjQtys) {
		this.zzjQtys = zzjQtys;
	}

	public BigDecimal getZzjZfje() {
		return zzjZfje;
	}

	public void setZzjZfje(BigDecimal zzjZfje) {
		this.zzjZfje = zzjZfje;
	}

	public BigDecimal getZzjHbwc() {
		return zzjHbwc;
	}

	public void setZzjHbwc(BigDecimal zzjHbwc) {
		this.zzjHbwc = zzjHbwc;
	}

	public Integer getCkbh() {
		return ckbh;
	}

	public void setCkbh(Integer ckbh) {
		this.ckbh = ckbh;
	}

	public String getJsData() {
		return jsData;
	}

	public void setJsData(String jsData) {
		this.jsData = jsData;
	}

	public String getGsbz() {
		return gsbz;
	}

	public void setGsbz(String gsbz) {
		this.gsbz = gsbz;
	}

	public String getGsrdh() {
		return gsrdh;
	}

	public void setGsrdh(String gsrdh) {
		this.gsrdh = gsrdh;
	}

	public String getDbtype() {
		return dbtype;
	}

	public void setDbtype(String dbtype) {
		this.dbtype = dbtype;
	}


	public List<DiagnosisInfo> getDiagnosisInfos() {
		return diagnosisInfos;
	}

	public void setDiagnosisInfos(List<DiagnosisInfo> diagnosisInfos) {
		this.diagnosisInfos = diagnosisInfos;
	}

	public List<DetailsBill> getDetailsBills() {
		return detailsBills;
	}

	public void setDetailsBills(List<DetailsBill> detailsBills) {
		this.detailsBills = detailsBills;
	}

	public String getYgxm() {
		return ygxm;
	}

	public void setYgxm(String ygxm) {
		this.ygxm = ygxm;
	}
}
