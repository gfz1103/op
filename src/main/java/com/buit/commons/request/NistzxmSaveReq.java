package com.buit.commons.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
* @ClassName: NistzxmSaveReq
* @Description: TODO 生命体征项目_保存
* @author 龚方舟
* @date 2020年6月3日 上午11:29:54
*/
@ApiModel(value="生命体征项目_saveReq")
public class NistzxmSaveReq {
	@ApiModelProperty(value="测量时间")		
	private Timestamp cjsj;	
	
	@ApiModelProperty(value="大便(次/日)")
	private String db;
	
	@ApiModelProperty(value="呼吸(次/分)")
	private Integer hx;
	
	@ApiModelProperty(value="脉搏(次/分)")
	private Integer mb;
	
	@ApiModelProperty(value="过敏药物")
	private String ps;
	
	@ApiModelProperty(value="出量(ml)")
	private BigDecimal qtcl;
	
	@ApiModelProperty(value="入量(ml)")
	private BigDecimal rl;

	@ApiModelProperty(value="身高(cm)")
	private BigDecimal sg;
	
	@ApiModelProperty(value="收缩压(mmHg)")
	private Integer ssy;
	
	@ApiModelProperty(value="舒张压(mmHg)")
	private Integer szy;
	
	@ApiModelProperty(value="体温(℃)")
	private BigDecimal tw;
	
	@ApiModelProperty(value="体重(kg)")
	private BigDecimal tz;
	
	@ApiModelProperty(value="尿量(ml)")
	private BigDecimal xb;
	
	@ApiModelProperty(value="心率(次/分)")
	private Integer xl;

	public Timestamp getCjsj() {
		return cjsj;
	}

	public void setCjsj(Timestamp cjsj) {
		this.cjsj = cjsj;
	}

	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public Integer getHx() {
		return hx;
	}

	public void setHx(Integer hx) {
		this.hx = hx;
	}

	public Integer getMb() {
		return mb;
	}

	public void setMb(Integer mb) {
		this.mb = mb;
	}

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}

	public BigDecimal getQtcl() {
		return qtcl;
	}

	public void setQtcl(BigDecimal qtcl) {
		this.qtcl = qtcl;
	}

	public BigDecimal getRl() {
		return rl;
	}

	public void setRl(BigDecimal rl) {
		this.rl = rl;
	}

	public BigDecimal getSg() {
		return sg;
	}

	public void setSg(BigDecimal sg) {
		this.sg = sg;
	}

	public Integer getSsy() {
		return ssy;
	}

	public void setSsy(Integer ssy) {
		this.ssy = ssy;
	}

	public Integer getSzy() {
		return szy;
	}

	public void setSzy(Integer szy) {
		this.szy = szy;
	}

	public BigDecimal getTw() {
		return tw;
	}

	public void setTw(BigDecimal tw) {
		this.tw = tw;
	}

	public BigDecimal getTz() {
		return tz;
	}

	public void setTz(BigDecimal tz) {
		this.tz = tz;
	}

	public BigDecimal getXb() {
		return xb;
	}

	public void setXb(BigDecimal xb) {
		this.xb = xb;
	}

	public Integer getXl() {
		return xl;
	}

	public void setXl(Integer xl) {
		this.xl = xl;
	}
	
}
