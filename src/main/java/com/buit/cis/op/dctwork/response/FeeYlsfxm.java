package com.buit.cis.op.dctwork.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 类名称：FeeYlsfxm<br> 
 * 类描述：公用_医疗收费
 * @author 老花生 
 * @ApiModel(value="公用_医疗收费")
 */
public class FeeYlsfxm extends PageQuery {
	@ApiModelProperty(value="费用序号")
    private Integer fyxh;
	@ApiModelProperty(value="费用名称")
    private String fymc;
	@ApiModelProperty(value="费用单位")
    private String fydw;
	@ApiModelProperty(value="费用归并")
    private Integer fygb;
	@ApiModelProperty(value="拼音代码")
    private String pydm;
	@ApiModelProperty(value="五笔代码")
    private String wbdm;
	@ApiModelProperty(value="角形代码")
    private String jxdm;
	@ApiModelProperty(value="其他代码")
    private String qtdm;
	@ApiModelProperty(value="fydj")
    private BigDecimal fydj;
	@ApiModelProperty(value="fyks")
    private Integer fyks;
	@ApiModelProperty(value="门诊使用")
    private Integer mzsy;
	@ApiModelProperty(value="住院使用")
    private Integer zysy;
	@ApiModelProperty(value="医技使用")
    private Integer yjsy;
	@ApiModelProperty(value="特殊检查")
    private Integer tjfy;
	@ApiModelProperty(value="特殊治疗")
    private Integer txzl;
	@ApiModelProperty(value="作废判别")
    private Integer zfpb;
	@ApiModelProperty(value="项目编码")
    private String xmbm;
	@ApiModelProperty(value="标准价格")
    private BigDecimal bzjg;
	@ApiModelProperty(value="项目类别 | 4.检验 5.检查 6.手术 7.治疗 8.护理 9.饮食 10.卫材 99.其他")
    private Integer xmlx;
	@ApiModelProperty(value="医技接口")
    private Integer yjjk;
	@ApiModelProperty(value="住院检查申请单")
    private Integer jcsq;
	@ApiModelProperty(value="门诊申请单")
    private Integer mzsq;
	@ApiModelProperty(value="特殊提示")
    private String tsts;
	@ApiModelProperty(value="LIS类型")
    private Integer lislx;
	@ApiModelProperty(value="dz")
    private String dz;
	@ApiModelProperty(value="rislx")
    private Integer rislx;
	@ApiModelProperty(value="mgh")
    private Integer mgh;
	@ApiModelProperty(value="报表归并")
    private Integer bbgb;
	@ApiModelProperty(value="dzbh")
    private String dzbh;
	@ApiModelProperty(value="项目分类 | 维护为GY_XMFLZD（项目分类字典）中的项目分类")
    private Integer xmfl;
	@ApiModelProperty(value="jxcs")
    private String jxcs;
	@ApiModelProperty(value="yjck")
    private Integer yjck;
	@ApiModelProperty(value="xmks")
    private Integer xmks;
	@ApiModelProperty(value="黄码编码")
    private String hmbm;
	@ApiModelProperty(value="ybxmjfbz")
    private String ybxmjfbz;
	@ApiModelProperty(value="blbz")
    private Integer blbz;
	@ApiModelProperty(value="医保编码")
    private String ybbm;
	@ApiModelProperty(value="医保名称")
    private String ybmc;
	@ApiModelProperty(value="医保单位")
    private String ybdw;
	@ApiModelProperty(value="医用品牌")
    private String yypp;
	@ApiModelProperty(value="注册证号")
    private String zczh;
	@ApiModelProperty(value="材料规格")
    private String yyclgg;
	@ApiModelProperty(value="明细标志")
    private Integer mxbz;
	@ApiModelProperty(value="总限额")
    private BigDecimal zjxe;
	@ApiModelProperty(value="材料标志")
    private Integer clbz;
	@ApiModelProperty(value="fylb")
    private Integer fylb;
	@ApiModelProperty(value="hlzx")
    private Integer hlzx;
	@ApiModelProperty(value="bbgb1")
    private Integer bbgb1;
	@ApiModelProperty(value="basyxm")
    private Integer basyxm;
	@ApiModelProperty(value="fyjmbm")
    private String fyjmbm;
	@ApiModelProperty(value="jxxmlb")
    private String jxxmlb;
	@ApiModelProperty(value="hlxmlb")
    private String hlxmlb;
	@ApiModelProperty(value="gnxh")
    private Integer gnxh;
	@ApiModelProperty(value="tsxmlx")
    private String tsxmlx;
	@ApiModelProperty(value="ssstj")
    private Integer ssstj;
	@ApiModelProperty(value="fyms")
    private String fyms;
	@ApiModelProperty(value="flzzf")
    private Integer flzzf;
	@ApiModelProperty(value="zyxmbz")
    private Integer zyxmbz;
	@ApiModelProperty(value="ylxz")
    private BigDecimal ylxz;
	@ApiModelProperty(value="笔画代码")
    private String bhdm;
	@ApiModelProperty(value="basygb")
    private Integer basygb;
	@ApiModelProperty(value="重复提醒标志")
    private Integer cftxbz;
	@ApiModelProperty(value="fyetjmbz")
    private String fyetjmbz;
	@ApiModelProperty(value="医技类型")
    private Integer yjlx;
	@ApiModelProperty(value="检查知情同意书")
    private String jczqtys;
	@ApiModelProperty(value="注意事项")
    private String zysx;
	@ApiModelProperty(value="执行科室")
    private Integer zxks;
	@ApiModelProperty(value="tsfy")
    private String tsfy;
	@ApiModelProperty(value="是否参与绩效分析")
    private Integer sfjxfx;
	@ApiModelProperty(value="材料项目分组合并 ")
    private String cldym;

    /** 设置:费用序号  */
    public void setFyxh(Integer value) {
        this.fyxh = value;
    }
    /** 获取:费用序号 */
    public Integer getFyxh() {
        return fyxh;
    }

    /** 设置:费用名称  */
    public void setFymc(String value) {
        this.fymc = value;
    }
    /** 获取:费用名称 */
    public String getFymc() {
        return fymc;
    }

    /** 设置:费用单位  */
    public void setFydw(String value) {
        this.fydw = value;
    }
    /** 获取:费用单位 */
    public String getFydw() {
        return fydw;
    }

    /** 设置:费用归并  */
    public void setFygb(Integer value) {
        this.fygb = value;
    }
    /** 获取:费用归并 */
    public Integer getFygb() {
        return fygb;
    }

    /** 设置:拼音代码  */
    public void setPydm(String value) {
        this.pydm = value;
    }
    /** 获取:拼音代码 */
    public String getPydm() {
        return pydm;
    }

    /** 设置:五笔代码  */
    public void setWbdm(String value) {
        this.wbdm = value;
    }
    /** 获取:五笔代码 */
    public String getWbdm() {
        return wbdm;
    }

    /** 设置:角形代码  */
    public void setJxdm(String value) {
        this.jxdm = value;
    }
    /** 获取:角形代码 */
    public String getJxdm() {
        return jxdm;
    }

    /** 设置:其他代码  */
    public void setQtdm(String value) {
        this.qtdm = value;
    }
    /** 获取:其他代码 */
    public String getQtdm() {
        return qtdm;
    }

    /** 设置:fydj  */
    public void setFydj(BigDecimal value) {
        this.fydj = value;
    }
    /** 获取:fydj */
    public BigDecimal getFydj() {
        return fydj;
    }

    /** 设置:fyks  */
    public void setFyks(Integer value) {
        this.fyks = value;
    }
    /** 获取:fyks */
    public Integer getFyks() {
        return fyks;
    }

    /** 设置:门诊使用  */
    public void setMzsy(Integer value) {
        this.mzsy = value;
    }
    /** 获取:门诊使用 */
    public Integer getMzsy() {
        return mzsy;
    }

    /** 设置:住院使用  */
    public void setZysy(Integer value) {
        this.zysy = value;
    }
    /** 获取:住院使用 */
    public Integer getZysy() {
        return zysy;
    }

    /** 设置:医技使用  */
    public void setYjsy(Integer value) {
        this.yjsy = value;
    }
    /** 获取:医技使用 */
    public Integer getYjsy() {
        return yjsy;
    }

    /** 设置:特殊检查  */
    public void setTjfy(Integer value) {
        this.tjfy = value;
    }
    /** 获取:特殊检查 */
    public Integer getTjfy() {
        return tjfy;
    }

    /** 设置:特殊治疗  */
    public void setTxzl(Integer value) {
        this.txzl = value;
    }
    /** 获取:特殊治疗 */
    public Integer getTxzl() {
        return txzl;
    }

    /** 设置:作废判别  */
    public void setZfpb(Integer value) {
        this.zfpb = value;
    }
    /** 获取:作废判别 */
    public Integer getZfpb() {
        return zfpb;
    }

    /** 设置:项目编码  */
    public void setXmbm(String value) {
        this.xmbm = value;
    }
    /** 获取:项目编码 */
    public String getXmbm() {
        return xmbm;
    }

    /** 设置:标准价格  */
    public void setBzjg(BigDecimal value) {
        this.bzjg = value;
    }
    /** 获取:标准价格 */
    public BigDecimal getBzjg() {
        return bzjg;
    }

    /** 设置:项目类别 | 4.检验 5.检查 6.手术 7.治疗 8.护理 9.饮食 10.卫材 99.其他  */
    public void setXmlx(Integer value) {
        this.xmlx = value;
    }
    /** 获取:项目类别 | 4.检验 5.检查 6.手术 7.治疗 8.护理 9.饮食 10.卫材 99.其他 */
    public Integer getXmlx() {
        return xmlx;
    }

    /** 设置:医技接口  */
    public void setYjjk(Integer value) {
        this.yjjk = value;
    }
    /** 获取:医技接口 */
    public Integer getYjjk() {
        return yjjk;
    }

    /** 设置:住院检查申请单  */
    public void setJcsq(Integer value) {
        this.jcsq = value;
    }
    /** 获取:住院检查申请单 */
    public Integer getJcsq() {
        return jcsq;
    }

    /** 设置:门诊申请单  */
    public void setMzsq(Integer value) {
        this.mzsq = value;
    }
    /** 获取:门诊申请单 */
    public Integer getMzsq() {
        return mzsq;
    }

    /** 设置:特殊提示  */
    public void setTsts(String value) {
        this.tsts = value;
    }
    /** 获取:特殊提示 */
    public String getTsts() {
        return tsts;
    }

    /** 设置:LIS类型  */
    public void setLislx(Integer value) {
        this.lislx = value;
    }
    /** 获取:LIS类型 */
    public Integer getLislx() {
        return lislx;
    }

    /** 设置:dz  */
    public void setDz(String value) {
        this.dz = value;
    }
    /** 获取:dz */
    public String getDz() {
        return dz;
    }

    /** 设置:rislx  */
    public void setRislx(Integer value) {
        this.rislx = value;
    }
    /** 获取:rislx */
    public Integer getRislx() {
        return rislx;
    }

    /** 设置:mgh  */
    public void setMgh(Integer value) {
        this.mgh = value;
    }
    /** 获取:mgh */
    public Integer getMgh() {
        return mgh;
    }

    /** 设置:bbgb  */
    public void setBbgb(Integer value) {
        this.bbgb = value;
    }
    /** 获取:bbgb */
    public Integer getBbgb() {
        return bbgb;
    }

    /** 设置:dzbh  */
    public void setDzbh(String value) {
        this.dzbh = value;
    }
    /** 获取:dzbh */
    public String getDzbh() {
        return dzbh;
    }

    /** 设置:项目分类 | 维护为GY_XMFLZD（项目分类字典）中的项目分类  */
    public void setXmfl(Integer value) {
        this.xmfl = value;
    }
    /** 获取:项目分类 | 维护为GY_XMFLZD（项目分类字典）中的项目分类 */
    public Integer getXmfl() {
        return xmfl;
    }

    /** 设置:jxcs  */
    public void setJxcs(String value) {
        this.jxcs = value;
    }
    /** 获取:jxcs */
    public String getJxcs() {
        return jxcs;
    }

    /** 设置:yjck  */
    public void setYjck(Integer value) {
        this.yjck = value;
    }
    /** 获取:yjck */
    public Integer getYjck() {
        return yjck;
    }

    /** 设置:xmks  */
    public void setXmks(Integer value) {
        this.xmks = value;
    }
    /** 获取:xmks */
    public Integer getXmks() {
        return xmks;
    }

    /** 设置:hmbm  */
    public void setHmbm(String value) {
        this.hmbm = value;
    }
    /** 获取:hmbm */
    public String getHmbm() {
        return hmbm;
    }

    /** 设置:ybxmjfbz  */
    public void setYbxmjfbz(String value) {
        this.ybxmjfbz = value;
    }
    /** 获取:ybxmjfbz */
    public String getYbxmjfbz() {
        return ybxmjfbz;
    }

    /** 设置:blbz  */
    public void setBlbz(Integer value) {
        this.blbz = value;
    }
    /** 获取:blbz */
    public Integer getBlbz() {
        return blbz;
    }

    /** 设置:ybbm  */
    public void setYbbm(String value) {
        this.ybbm = value;
    }
    /** 获取:ybbm */
    public String getYbbm() {
        return ybbm;
    }

    /** 设置:ybmc  */
    public void setYbmc(String value) {
        this.ybmc = value;
    }
    /** 获取:ybmc */
    public String getYbmc() {
        return ybmc;
    }

    /** 设置:ybdw  */
    public void setYbdw(String value) {
        this.ybdw = value;
    }
    /** 获取:ybdw */
    public String getYbdw() {
        return ybdw;
    }

    /** 设置:yypp  */
    public void setYypp(String value) {
        this.yypp = value;
    }
    /** 获取:yypp */
    public String getYypp() {
        return yypp;
    }

    /** 设置:zczh  */
    public void setZczh(String value) {
        this.zczh = value;
    }
    /** 获取:zczh */
    public String getZczh() {
        return zczh;
    }

    /** 设置:yyclgg  */
    public void setYyclgg(String value) {
        this.yyclgg = value;
    }
    /** 获取:yyclgg */
    public String getYyclgg() {
        return yyclgg;
    }

    /** 设置:mxbz  */
    public void setMxbz(Integer value) {
        this.mxbz = value;
    }
    /** 获取:mxbz */
    public Integer getMxbz() {
        return mxbz;
    }

    /** 设置:zjxe  */
    public void setZjxe(BigDecimal value) {
        this.zjxe = value;
    }
    /** 获取:zjxe */
    public BigDecimal getZjxe() {
        return zjxe;
    }

    /** 设置:clbz  */
    public void setClbz(Integer value) {
        this.clbz = value;
    }
    /** 获取:clbz */
    public Integer getClbz() {
        return clbz;
    }

    /** 设置:fylb  */
    public void setFylb(Integer value) {
        this.fylb = value;
    }
    /** 获取:fylb */
    public Integer getFylb() {
        return fylb;
    }

    /** 设置:hlzx  */
    public void setHlzx(Integer value) {
        this.hlzx = value;
    }
    /** 获取:hlzx */
    public Integer getHlzx() {
        return hlzx;
    }

    /** 设置:bbgb1  */
    public void setBbgb1(Integer value) {
        this.bbgb1 = value;
    }
    /** 获取:bbgb1 */
    public Integer getBbgb1() {
        return bbgb1;
    }

    /** 设置:basyxm  */
    public void setBasyxm(Integer value) {
        this.basyxm = value;
    }
    /** 获取:basyxm */
    public Integer getBasyxm() {
        return basyxm;
    }

    /** 设置:fyjmbm  */
    public void setFyjmbm(String value) {
        this.fyjmbm = value;
    }
    /** 获取:fyjmbm */
    public String getFyjmbm() {
        return fyjmbm;
    }

    /** 设置:jxxmlb  */
    public void setJxxmlb(String value) {
        this.jxxmlb = value;
    }
    /** 获取:jxxmlb */
    public String getJxxmlb() {
        return jxxmlb;
    }

    /** 设置:hlxmlb  */
    public void setHlxmlb(String value) {
        this.hlxmlb = value;
    }
    /** 获取:hlxmlb */
    public String getHlxmlb() {
        return hlxmlb;
    }

    /** 设置:gnxh  */
    public void setGnxh(Integer value) {
        this.gnxh = value;
    }
    /** 获取:gnxh */
    public Integer getGnxh() {
        return gnxh;
    }

    /** 设置:tsxmlx  */
    public void setTsxmlx(String value) {
        this.tsxmlx = value;
    }
    /** 获取:tsxmlx */
    public String getTsxmlx() {
        return tsxmlx;
    }

    /** 设置:ssstj  */
    public void setSsstj(Integer value) {
        this.ssstj = value;
    }
    /** 获取:ssstj */
    public Integer getSsstj() {
        return ssstj;
    }

    /** 设置:fyms  */
    public void setFyms(String value) {
        this.fyms = value;
    }
    /** 获取:fyms */
    public String getFyms() {
        return fyms;
    }

    /** 设置:flzzf  */
    public void setFlzzf(Integer value) {
        this.flzzf = value;
    }
    /** 获取:flzzf */
    public Integer getFlzzf() {
        return flzzf;
    }

    /** 设置:zyxmbz  */
    public void setZyxmbz(Integer value) {
        this.zyxmbz = value;
    }
    /** 获取:zyxmbz */
    public Integer getZyxmbz() {
        return zyxmbz;
    }

    /** 设置:ylxz  */
    public void setYlxz(BigDecimal value) {
        this.ylxz = value;
    }
    /** 获取:ylxz */
    public BigDecimal getYlxz() {
        return ylxz;
    }

    /** 设置:笔画代码  */
    public void setBhdm(String value) {
        this.bhdm = value;
    }
    /** 获取:笔画代码 */
    public String getBhdm() {
        return bhdm;
    }

    /** 设置:basygb  */
    public void setBasygb(Integer value) {
        this.basygb = value;
    }
    /** 获取:basygb */
    public Integer getBasygb() {
        return basygb;
    }

    /** 设置:重复提醒标志  */
    public void setCftxbz(Integer value) {
        this.cftxbz = value;
    }
    /** 获取:重复提醒标志 */
    public Integer getCftxbz() {
        return cftxbz;
    }

    /** 设置:fyetjmbz  */
    public void setFyetjmbz(String value) {
        this.fyetjmbz = value;
    }
    /** 获取:fyetjmbz */
    public String getFyetjmbz() {
        return fyetjmbz;
    }

    /** 设置:医技类型  */
    public void setYjlx(Integer value) {
        this.yjlx = value;
    }
    /** 获取:医技类型 */
    public Integer getYjlx() {
        return yjlx;
    }

    /** 设置:检查知情同意书  */
    public void setJczqtys(String value) {
        this.jczqtys = value;
    }
    /** 获取:检查知情同意书 */
    public String getJczqtys() {
        return jczqtys;
    }

    /** 设置:注意事项  */
    public void setZysx(String value) {
        this.zysx = value;
    }
    /** 获取:注意事项 */
    public String getZysx() {
        return zysx;
    }

    /** 设置:执行科室  */
    public void setZxks(Integer value) {
        this.zxks = value;
    }
    /** 获取:执行科室 */
    public Integer getZxks() {
        return zxks;
    }

    /** 设置:tsfy  */
    public void setTsfy(String value) {
        this.tsfy = value;
    }
    /** 获取:tsfy */
    public String getTsfy() {
        return tsfy;
    }

    /** 设置:是否参与绩效分析  */
    public void setSfjxfx(Integer value) {
        this.sfjxfx = value;
    }
    /** 获取:是否参与绩效分析 */
    public Integer getSfjxfx() {
        return sfjxfx;
    }

    /** 设置:材料项目分组合并   */
    public void setCldym(String value) {
        this.cldym = value;
    }
    /** 获取:材料项目分组合并  */
    public String getCldym() {
        return cldym;
    }


}
