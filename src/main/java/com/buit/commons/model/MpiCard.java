package com.buit.commons.model;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MpiCard<br> 
 * 类描述：EMPI个人基本信息(卡)
 * @author yueyu 
 * @ApiModel(value="EMPI个人基本信息(卡)")
 */
public class MpiCard  extends  PageQuery{
	@ApiModelProperty(value="编号")
    /** 编号 */
    private String cardid;
	@ApiModelProperty(value="EMPI")
    /** EMPI */
    private String empiid;
	@ApiModelProperty(value="卡类型 | 01=健康卡 02=市民卡 03=医保卡 09=其他卡")
    /** 卡类型 | 01=健康卡 02=市民卡 03=医保卡 09=其他卡 */
    private String cardtypecode;
	@ApiModelProperty(value="卡号")
    /** 卡号 */
    private String cardno;
	@ApiModelProperty(value="创建机构")
    /** 创建机构 */
    private String createunit;
	@ApiModelProperty(value="创建人")
    /** 创建人 */
    private String createuser;
	//@ApiModelProperty(value="状态 | 0=挂失 1=正常 2=注销")
    @ApiModelProperty(value="状态 | 0=正常1=挂失2=注销3=失效")
    /** 状态 | 0=挂失 1=正常 2=注销 */
    private String status;
	@ApiModelProperty(value="创建时间")
    /** 创建时间 */
    private Timestamp createtime;
	@ApiModelProperty(value="有效期")
    /** 有效期 */
    private Timestamp validtime;
	@ApiModelProperty(value="最后修改时间")
    /** 最后修改时间 */
    private Timestamp lastmodifytime;
	@ApiModelProperty(value="最后修改机构")
    /** 最后修改机构 */
    private String lastmodifyunit;
	@ApiModelProperty(value="最后修改人")
    /** 最后修改人 */
    private String lastmodifyuser;
	@ApiModelProperty(value="卡内码")
    /** 卡内码 */
    private String cardcode;
	@ApiModelProperty(value="上传标志")
    /** scbz */
    private String scbz;
	@ApiModelProperty(value="brid")
    /** brid */
    private Integer brid;
	@ApiModelProperty(value="病人性质")
    /** 病人性质 */
    private Integer brxz;
	@ApiModelProperty(value="行政区划代码")
    /** regioncode */
    private String regioncode;
    @ApiModelProperty(value="工伤认定号")
    /** scbz */
    private String gsrdh;

    /** 设置:编号  */
    public void setCardid(String value) {
        this.cardid = value;
    }
    /** 获取:编号 */
    public String getCardid() {
        return cardid;
    }

    /** 设置:EMPI  */
    public void setEmpiid(String value) {
        this.empiid = value;
    }
    /** 获取:EMPI */
    public String getEmpiid() {
        return empiid;
    }

    /** 设置:卡类型 | 01=健康卡 02=市民卡 03=医保卡 09=其他卡  */
    public void setCardtypecode(String value) {
        this.cardtypecode = value;
    }
    /** 获取:卡类型 | 01=健康卡 02=市民卡 03=医保卡 09=其他卡 */
    public String getCardtypecode() {
        return cardtypecode;
    }

    /** 设置:卡号  */
    public void setCardno(String value) {
        this.cardno = value;
    }
    /** 获取:卡号 */
    public String getCardno() {
        return cardno;
    }

    /** 设置:创建机构  */
    public void setCreateunit(String value) {
        this.createunit = value;
    }
    /** 获取:创建机构 */
    public String getCreateunit() {
        return createunit;
    }

    /** 设置:创建人  */
    public void setCreateuser(String value) {
        this.createuser = value;
    }
    /** 获取:创建人 */
    public String getCreateuser() {
        return createuser;
    }

    /** 设置:状态 | 0=挂失 1=正常 2=注销  */
    public void setStatus(String value) {
        this.status = value;
    }
    /** 获取:状态 | 0=挂失 1=正常 2=注销 */
    public String getStatus() {
        return status;
    }

    /** 设置:创建时间  */
    public void setCreatetime(Timestamp value) {
        this.createtime = value;
    }
    /** 获取:创建时间 */
    public Timestamp getCreatetime() {
        return createtime;
    }

    /** 设置:有效期  */
    public void setValidtime(Timestamp value) {
        this.validtime = value;
    }
    /** 获取:有效期 */
    public Timestamp getValidtime() {
        return validtime;
    }

    /** 设置:最后修改时间  */
    public void setLastmodifytime(Timestamp value) {
        this.lastmodifytime = value;
    }
    /** 获取:最后修改时间 */
    public Timestamp getLastmodifytime() {
        return lastmodifytime;
    }

    /** 设置:最后修改机构  */
    public void setLastmodifyunit(String value) {
        this.lastmodifyunit = value;
    }
    /** 获取:最后修改机构 */
    public String getLastmodifyunit() {
        return lastmodifyunit;
    }

    /** 设置:最后修改人  */
    public void setLastmodifyuser(String value) {
        this.lastmodifyuser = value;
    }
    /** 获取:最后修改人 */
    public String getLastmodifyuser() {
        return lastmodifyuser;
    }

    /** 设置:卡内码  */
    public void setCardcode(String value) {
        this.cardcode = value;
    }
    /** 获取:卡内码 */
    public String getCardcode() {
        return cardcode;
    }

    /** 设置:scbz  */
    public void setScbz(String value) {
        this.scbz = value;
    }
    /** 获取:scbz */
    public String getScbz() {
        return scbz;
    }

    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    /** 设置:病人性质  */
    public void setBrxz(Integer value) {
        this.brxz = value;
    }
    /** 获取:病人性质 */
    public Integer getBrxz() {
        return brxz;
    }

    /** 设置:regioncode  */
    public void setRegioncode(String value) {
        this.regioncode = value;
    }
    /** 获取:regioncode */
    public String getRegioncode() {
        return regioncode;
    }

    public String getGsrdh() {
        return gsrdh;
    }

    public void setGsrdh(String gsrdh) {
        this.gsrdh = gsrdh;
    }
}