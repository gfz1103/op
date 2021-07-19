
package com.buit.commons.request;

import com.buit.commons.PageQuery;
import com.buit.commons.model.YbGhjs;
import com.buit.op.model.OpPosmx;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MsRegisterAddReq<br>
 * 类描述：挂号请求<br>
 * 
 * @author wangyang
 */
@ApiModel(value = "挂号请求")
public class MsRegisterAddReq extends PageQuery {
	private static final long serialVersionUID = 3934412639564246809L;
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@JsonIgnore
	@ApiModelProperty(value = "ip")
	private String ip;
	@JsonIgnore
	@ApiModelProperty(value = "用户ID")
	private Integer ygdm;
	@JsonIgnore
	@ApiModelProperty(value = "用户名")
	private String ygxm;
	@ApiModelProperty(value = "挂号信息")
	private MsGhxxReq ghxx;
	@ApiModelProperty(value = "医保信息对象")
	private YbGhjs ybxx;

	@ApiModelProperty(value = "pos明细对象")
	private OpPosmx pos;

	@ApiModelProperty(value = "预约tag 前端根据业务逻辑给")
	private Integer yytag;

	@ApiModelProperty(value = "挂号预检")
	private boolean ghyj;

	@ApiModelProperty(value = "是否大病")
	private Integer isDb;

	@ApiModelProperty(value = "大病诊断编码")
	private Integer dbybDbbm;

	@ApiModelProperty(value = "医保大病姓名")
	private Integer dbybDbxm;

	@ApiModelProperty(value = "是否医保")
	private Integer isYb;

	@ApiModelProperty(value = "中心流水号")
	private Integer zxlsh;

	@ApiModelProperty(value = "是否工伤 || 1是 0否")
	private Integer isGs;

	@ApiModelProperty(value = "工伤认定号")
	private String gsrdh;

	@ApiModelProperty(value = "挂号时间")
	private String ghsj;

	public Integer getYytag() {
		return yytag;
	}

	public void setYytag(Integer yytag) {
		this.yytag = yytag;
	}

	public boolean isGhyj() {
		return ghyj;
	}

	public void setGhyj(boolean ghyj) {
		this.ghyj = ghyj;
	}

	public Integer getIsDb() {
		return isDb;
	}

	public void setIsDb(Integer isDb) {
		this.isDb = isDb;
	}

	public Integer getDbybDbbm() {
		return dbybDbbm;
	}

	public void setDbybDbbm(Integer dbybDbbm) {
		this.dbybDbbm = dbybDbbm;
	}

	public Integer getDbybDbxm() {
		return dbybDbxm;
	}

	public void setDbybDbxm(Integer dbybDbxm) {
		this.dbybDbxm = dbybDbxm;
	}

	public Integer getIsYb() {
		return isYb;
	}

	public void setIsYb(Integer isYb) {
		this.isYb = isYb;
	}

	public Integer getZxlsh() {
		return zxlsh;
	}

	public void setZxlsh(Integer zxlsh) {
		this.zxlsh = zxlsh;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getYgdm() {
		return ygdm;
	}

	public void setYgdm(Integer ygdm) {
		this.ygdm = ygdm;
	}

	public MsGhxxReq getGhxx() {
		return ghxx;
	}

	public void setGhxx(MsGhxxReq ghxx) {
		this.ghxx = ghxx;
	}

	public YbGhjs getYbxx() {
		return ybxx;
	}

	public void setYbxx(YbGhjs ybxx) {
		this.ybxx = ybxx;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getIsGs() {
		return isGs;
	}

	public void setIsGs(Integer isGs) {
		this.isGs = isGs;
	}

	public String getGsrdh() {
		return gsrdh;
	}

	public void setGsrdh(String gsrdh) {
		this.gsrdh = gsrdh;
	}

	public String getYgxm() {
		return ygxm;
	}

	public void setYgxm(String ygxm) {
		this.ygxm = ygxm;
	}

	public String getGhsj() {
		return ghsj;
	}

	public void setGhsj(String ghsj) {
		this.ghsj = ghsj;
	}

	public OpPosmx getPos() {
		return pos;
	}

	public void setPos(OpPosmx pos) {
		this.pos = pos;
	}
}
