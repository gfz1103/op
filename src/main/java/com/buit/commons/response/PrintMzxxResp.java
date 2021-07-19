
package com.buit.commons.response;

import java.util.ArrayList;
import java.util.List;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：PrintMzxxResp<br>
 * 类描述：门诊收费发票打印返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "门诊收费发票打印返回")
public class PrintMzxxResp extends PageQuery {
	private static final long serialVersionUID = 1721664665005870652L;
	@ApiModelProperty(value = "叫号号码")
	private String jhhm;
	@ApiModelProperty(value = "发票预览  0是直接打印，1是发票预览，默认为 0")
	private String fpyl;
	@ApiModelProperty(value = "门诊划价收费打印机名称")
	private String mzhjsfdyjmc;
	@ApiModelProperty(value = "门诊发票基本信息")
	private List<MzfpBaseResp> mzfpBaseResp;
	@ApiModelProperty(value = "收费项目列表")
	private List<MzfpSfxmResp> sfxmList = new ArrayList<MzfpSfxmResp>();
	@ApiModelProperty(value = "药品列表")
	private List<MzfpYpResp> ypList = new ArrayList<MzfpYpResp>();
	@ApiModelProperty(value = "一页打印数量")
	private Integer mzfpmxsl;
	@ApiModelProperty(value = "发票张数")
	private Integer fpzs;
	@ApiModelProperty(value = "挂号发票打印方式1-公立医院发票2-私立医院发票3-宏德医院样式")
	private String dyfs;
	@ApiModelProperty(value = "纳税人识别号")
	private String nsrsbh;

	public String getJhhm() {
		return jhhm;
	}

	public void setJhhm(String jhhm) {
		this.jhhm = jhhm;
	}

	public String getFpyl() {
		return fpyl;
	}

	public void setFpyl(String fpyl) {
		this.fpyl = fpyl;
	}

	public String getMzhjsfdyjmc() {
		return mzhjsfdyjmc;
	}

	public void setMzhjsfdyjmc(String mzhjsfdyjmc) {
		this.mzhjsfdyjmc = mzhjsfdyjmc;
	}

	public List<MzfpBaseResp> getMzfpBaseResp() {
		return mzfpBaseResp;
	}

	public void setMzfpBaseResp(List<MzfpBaseResp> mzfpBaseResp) {
		this.mzfpBaseResp = mzfpBaseResp;
	}

	public List<MzfpSfxmResp> getSfxmList() {
		return sfxmList;
	}

	public void setSfxmList(List<MzfpSfxmResp> sfxmList) {
		this.sfxmList = sfxmList;
	}

	public List<MzfpYpResp> getYpList() {
		return ypList;
	}

	public void setYpList(List<MzfpYpResp> ypList) {
		this.ypList = ypList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getMzfpmxsl() {
		return mzfpmxsl;
	}

	public void setMzfpmxsl(Integer mzfpmxsl) {
		this.mzfpmxsl = mzfpmxsl;
	}

	public Integer getFpzs() {
		return fpzs;
	}

	public void setFpzs(Integer fpzs) {
		this.fpzs = fpzs;
	}

	public String getDyfs() {
		return dyfs;
	}

	public void setDyfs(String dyfs) {
		this.dyfs = dyfs;
	}

	public String getNsrsbh() {
		return nsrsbh;
	}

	public void setNsrsbh(String nsrsbh) {
		this.nsrsbh = nsrsbh;
	}
}