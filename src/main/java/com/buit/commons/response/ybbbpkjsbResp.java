
package com.buit.commons.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类描述：贫困精神病<br>
 * 
 * @author beijunhua
 */
@ApiModel(value = "贫困精神病")
public class ybbbpkjsbResp extends PageQuery {
	@ApiModelProperty(value = "医疗证号")
	private String YLZH;
	@ApiModelProperty(value = "门诊号码")
	private String MZHM;
	@ApiModelProperty(value = "姓名")
	private String NAME;
	@ApiModelProperty(value = "病人性别")
	private String BRXB;
	@ApiModelProperty(value = "总费用")
	private String TOTFY;
	@ApiModelProperty(value = "挂号费")
	private String GHF;
	@ApiModelProperty(value = "诊疗费")
	private String ZLF;
	@ApiModelProperty(value = "药费")
	private String ZYF;
	@ApiModelProperty(value = "自负药费")
	private String ZFYF;
	@ApiModelProperty(value = "治疗费")
	private String ZLF_Z;
	@ApiModelProperty(value = "检验费")
	private String JYF;
	@ApiModelProperty(value = "检查费")
	private String JCF;
	@ApiModelProperty(value = "其他")
	private String QTF;

	public String getYLZH() {
		return YLZH;
	}

	public void setYLZH(String YLZH) {
		this.YLZH = YLZH;
	}

	public String getMZHM() {
		return MZHM;
	}

	public void setMZHM(String MZHM) {
		this.MZHM = MZHM;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String NAME) {
		this.NAME = NAME;
	}

	public String getBRXB() {
		return BRXB;
	}

	public void setBRXB(String BRXB) {
		this.BRXB = BRXB;
	}

	public String getTOTFY() {
		return TOTFY;
	}

	public void setTOTFY(String TOTFY) {
		this.TOTFY = TOTFY;
	}

	public String getGHF() {
		return GHF;
	}

	public void setGHF(String GHF) {
		this.GHF = GHF;
	}

	public String getZLF() {
		return ZLF;
	}

	public void setZLF(String ZLF) {
		this.ZLF = ZLF;
	}

	public String getZYF() {
		return ZYF;
	}

	public void setZYF(String ZYF) {
		this.ZYF = ZYF;
	}

	public String getZFYF() {
		return ZFYF;
	}

	public void setZFYF(String ZFYF) {
		this.ZFYF = ZFYF;
	}

	public String getZLF_Z() {
		return ZLF_Z;
	}

	public void setZLF_Z(String ZLF_Z) {
		this.ZLF_Z = ZLF_Z;
	}

	public String getJYF() {
		return JYF;
	}

	public void setJYF(String JYF) {
		this.JYF = JYF;
	}

	public String getJCF() {
		return JCF;
	}

	public void setJCF(String JCF) {
		this.JCF = JCF;
	}

	public String getQTF() {
		return QTF;
	}

	public void setQTF(String QTF) {
		this.QTF = QTF;
	}
}