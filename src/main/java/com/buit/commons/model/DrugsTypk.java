package com.buit.commons.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 类名称：DrugsTypk<br> 
 * 类描述：药库_药品基本库<br>
 * @author "MLeo"
 */
public class DrugsTypk extends  PageQuery{
	@ApiModelProperty(value="药品序号 | 本代码为内部代码，用户不可见")
    /** 药品序号 | 本代码为内部代码，用户不可见 */
    private Integer ypxh;
	@ApiModelProperty(value="药品名称")
    /** 药品名称 */
    private String ypmc;
	@ApiModelProperty(value="药品规格")
    /** 药品规格 */
    private String ypgg;
	@ApiModelProperty(value="药房规格")
    /** 药房规格 */
    private String yfgg;
	@ApiModelProperty(value="病房规格")
    /** 病房规格 */
    private String bfgg;
	@ApiModelProperty(value="药品属性 | 剂型代码 对应DRUGS_YPSX.YPSX的代码")
    /** 药品属性 | 剂型代码 对应DRUGS_YPSX.YPSX的代码 */
    private Integer ypsx;
	@ApiModelProperty(value="特殊药品 | 对应GY_DMZD（DMSB=16）对应 1——麻醉、2——精神、3——贵重")
    /** 特殊药品 | 对应GY_DMZD（DMSB=16）对应 1——麻醉、2——精神、3——贵重 */
    private Integer tsyp;
	@ApiModelProperty(value="药品单位")
    /** 药品单位 */
    private String ypdw;
	@ApiModelProperty(value="最小单位")
    /** 最小单位 */
    private String zxdw;
	@ApiModelProperty(value="最小包装")
    /** 最小包装 */
    private Integer zxbz;
	@ApiModelProperty(value="药房包装")
    /** 药房包装 */
    private Integer yfbz;
	@ApiModelProperty(value="药房单位")
    /** 药房单位 */
    private String yfdw;
	@ApiModelProperty(value="病房包装")
    /** 病房包装 */
    private Integer bfbz;
	@ApiModelProperty(value="病房单位")
    /** 病房单位 */
    private String bfdw;
	@ApiModelProperty(value="作废判别")
    /** 作废判别 */
    private Integer zfpb;
	@ApiModelProperty(value="皮试判别 | 皮试药品需要做皮试 0：非皮试类药品 1：皮试药品")
    /** 皮试判别 | 皮试药品需要做皮试 0：非皮试类药品 1：皮试药品 */
    private Integer pspb;
	@ApiModelProperty(value="用量限制")
    /** 用量限制 */
    private BigDecimal ylxz;
	@ApiModelProperty(value="发药方式 |药房发药根据发药方式统计各个病区的药品数量发药，对应IM_FYFS.FYFS的代码")
    /** 发药方式 |药房发药根据发药方式统计各个病区的药品数量发药，对应IM_FYFS.FYFS的代码 */
    private Integer fyfs;
	@ApiModelProperty(value="拼音代码")
    /** 拼音代码 */
    private String pydm;
	@ApiModelProperty(value="五笔代码")
    /** 五笔代码 */
    private String wbdm;
	//@ApiModelProperty(value="角形代码")
    /** 角形代码 */
    private String jxdm;
	//@ApiModelProperty(value="其他码")
    /** 其他码 */
    private String qtdm;
	@ApiModelProperty(value="药品编号｜国标药品编码, 待用")
    /** 药品编号｜国标药品编码, 待用 */
    private String ypbh;
	@ApiModelProperty(value="定价级别")
    /** 定价级别 */
    private BigDecimal djjb;
	@ApiModelProperty(value="药品效期")
    /** 药品效期 */
    private Integer ypxq;
	@ApiModelProperty(value="给药方法 | 对应IM_DIC_YPYF")
    /** 给药方法 | 对应IM_DIC_YPYF */
    private Integer gyff;
	@ApiModelProperty(value="药品类别 | 1：西药 2：中成药 3：中草药")
    /** 药品类别 | 1：西药 2：中成药 3：中草药 */
    private Integer type;
	@ApiModelProperty(value="药品编码")
    /** 药品编码 */
    private String ypdm;
	@ApiModelProperty(value="药品档次 | 1.国产 2.合资 3.进口a ")
    /** 药品档次 | 1.国产 2.合资 3.进口 */
    private Integer ypdc;
	@ApiModelProperty(value="制剂判别")
    /** 制剂判别 */
    private Integer zjpb;
	@ApiModelProperty(value="急诊用药")
    /** 急诊用药 */
    private Integer jzyy;
	@ApiModelProperty(value="药品剂量")
    /** 药品剂量 */
    private BigDecimal ypjl;
	@ApiModelProperty(value="剂量单位")
    /** 剂量单位 */
    private String jldw;
	@ApiModelProperty(value="ABC类别")
    /** ABC类别 */
    private String abc;
	@ApiModelProperty(value="取整策略 | 0：每次发药数量取整  1: 每天发药数量  2: 不取整")
    /** 取整策略 | 0：每次发药数量取整  1: 每天发药数量  2: 不取整 */
    private Integer qzcl;
	@ApiModelProperty(value="自选产地")
    /** 自选产地 */
    private Integer zxcd;
	@ApiModelProperty(value="抗生素标志")
    /** 抗生素标志 */
    private Integer ksbz;
	@ApiModelProperty(value="一次用量")
    /** 一次用量 */
    private BigDecimal ycyl;
	@ApiModelProperty(value="基本药物标志")
    /** 基本药物标志 */
    private Integer jbywbz;
	@ApiModelProperty(value="运动员慎用")
    /** 运动员慎用 */
    private Integer ydysy;
	@ApiModelProperty(value="冰箱冷藏")
    /** 冰箱冷藏 */
    private Integer bxlc;
	@ApiModelProperty(value="处方用药备注")
    /** 处方用药备注 */
    private String yybz;
	//@ApiModelProperty(value="新增时间")
    /** 新增时间 */
    private Timestamp xzsj;
	@ApiModelProperty(value="药品贮藏")
    /** 药品贮藏 */
    private Integer ypzc;
	@ApiModelProperty(value="医保分类")
    /** 医保分类 */
    private Integer ybfl;
	@ApiModelProperty(value="处方药品")
    /** 处方药品 */
    private Integer cfyp;
	@ApiModelProperty(value="抗生素等级 固定为一级抗生素 二级抗生素 三级抗生素")
    /** 抗生素等级 固定为一级抗生素 二级抗生素 三级抗生素 */
    private Integer kssdj;
	@ApiModelProperty(value="DDD值")
    /** DDD值 */
    private BigDecimal dddz;
	@ApiModelProperty(value="通用名称 | 珠海医保专用")
    /** 通用名称 | 珠海医保专用 */
    private String tymc;
	@ApiModelProperty(value="药品说明")
    /** 药品说明 */
    private String mess;
	@ApiModelProperty(value="笔画代码")
    /** 笔画代码 */
    private String bhdm;
	@ApiModelProperty(value="zssf")
    /** zssf */
    private Integer zssf;
	@ApiModelProperty(value="基药类型 1.非基本药物,2国家基本药物,3.省基本药物,4.区自选")
    /** 基药类型 1.非基本药物,2国家基本药物,3.省基本药物,4.区自选 */
    private Integer jylx;
	@ApiModelProperty(value="抗菌药物越权使用方式 1：提醒 2禁止")
    /** 抗菌药物越权使用方式 1：提醒 2禁止 */
    private Integer yqsyfs;
	@ApiModelProperty(value="账簿类别,对应DIC_SFXMLB的 SFXM")
    /** 账簿类别,对应DIC_SFXMLB的 SFXM */
    private Integer zblb;
	@ApiModelProperty(value="抗菌药物是否需要审批 1：需要 2不需要")
    /** 抗菌药物是否需要审批 1：需要 2不需要 */
    private Integer sfsp;
	@ApiModelProperty(value="一次剂量")
    /** 一次剂量 */
    private BigDecimal ycjl;
	@ApiModelProperty(value="重复用药提醒")
    /** 重复用药提醒 */
    private Integer cfyytx;
	@ApiModelProperty(value="自备药标识")
    /** 自备药标识 */
    private Integer zfyp;
	@ApiModelProperty(value="药库作废")
    /** 药库作废 */
    private String ykzf;
	@ApiModelProperty(value="用药标识  | 1.高血压、2.糖尿病、3.精神病、4.胰岛素")
    /** 用药标识  | 1.高血压、2.糖尿病、3.精神病、4.胰岛素 */
    private Integer yybs;
	@ApiModelProperty(value="过敏药物类别  | 1.青霉素、2.磺胺、3.链霉素")
    /** 过敏药物类别  | 1.青霉素、2.磺胺、3.链霉素 */
    private Integer gmywlb;
	@ApiModelProperty(value="scbz")
    /** scbz */
    private String scbz;
	@ApiModelProperty(value="中成药用药限制,1是不限制,2是限制1周,3是限制2周")
    /** 中成药用药限制,1是不限制,2是限制1周,3是限制2周 */
    private Integer yyxz;
	@ApiModelProperty(value="批准文号")
    /** 批准文号 */
    private String pzwh;
	@ApiModelProperty(value="执行标准")
    /** 执行标准 */
    private String bzzx;
	@ApiModelProperty(value="橱柜号")
    /** 橱柜号 */
    private String cgh;
	@ApiModelProperty(value="备注")
    /** 备注 */
    private String bz;
	@ApiModelProperty(value="药品费别")
    /** 药品费别 */
    private Integer ypfb;
	@ApiModelProperty(value="中标类型")
    /** 中标类型 */
    private Integer zblx;
	@ApiModelProperty(value="支付,1甲类,2 10%,3 20%")
    /** 支付,1甲类,2 10%,3 20% */
    private Integer zf;
	@ApiModelProperty(value="抗菌药物管理分级 | 实现限制类抗菌药物以非限制类管理")
    /** 抗菌药物管理分级 | 实现限制类抗菌药物以非限制类管理 */
    private Integer glxz;
	@ApiModelProperty(value="jbbz")
    /** jbbz */
    private String jbbz;
	@ApiModelProperty(value="限定支付及备注")
    /** 限定支付及备注 */
    private String xdzfjbz;
	@ApiModelProperty(value="长处方药品")
    /** 长处方药品 */
    private Integer ccfyp;
	@ApiModelProperty(value="药品默认值")
    /** 药品默认值 */
    private Integer ypmrz;
	@ApiModelProperty(value="药品极限值")
    /** 药品极限值 */
    private Integer ypjxz;
	@ApiModelProperty(value="本地药品编码")
    /** 本地药品编码 */
    private String ypbm;
	@ApiModelProperty(value="英文名称")
    /** 英文名称 */
    private String ywmc;
	@ApiModelProperty(value="医保编码")
    /** 医保编码 */
    private String ybbm;
	@ApiModelProperty(value="药品极限值天数")
    /** 药品极限值天数 */
    private Integer dcypjxzts;
	@ApiModelProperty(value="药品极限值总数")
    /** 药品极限值总数 */
    private Integer dcypjxzzs;
    private Integer psid;
    private String cdrow;

    public Integer getPsid() {
        return psid;
    }

    public void setPsid(Integer psid) {
        this.psid = psid;
    }

    /** 设置:药品序号 | 本代码为内部代码，用户不可见  */
    public void setYpxh(Integer value) {
        this.ypxh = value;
    }
    /** 获取:药品序号 | 本代码为内部代码，用户不可见 */
    public Integer getYpxh() {
        return ypxh;
    }

    /** 设置:药品名称  */
    public void setYpmc(String value) {
        this.ypmc = value;
    }
    /** 获取:药品名称 */
    public String getYpmc() {
        return ypmc;
    }

    /** 设置:药品规格  */
    public void setYpgg(String value) {
        this.ypgg = value;
    }
    /** 获取:药品规格 */
    public String getYpgg() {
        return ypgg;
    }

    /** 设置:药房规格  */
    public void setYfgg(String value) {
        this.yfgg = value;
    }
    /** 获取:药房规格 */
    public String getYfgg() {
        return yfgg;
    }

    /** 设置:病房规格  */
    public void setBfgg(String value) {
        this.bfgg = value;
    }
    /** 获取:病房规格 */
    public String getBfgg() {
        return bfgg;
    }

    /** 设置:药品属性 | 剂型代码 对应DRUGS_YPSX.YPSX的代码  */
    public void setYpsx(Integer value) {
        this.ypsx = value;
    }
    /** 获取:药品属性 | 剂型代码 对应DRUGS_YPSX.YPSX的代码 */
    public Integer getYpsx() {
        return ypsx;
    }

    /** 设置:特殊药品 | 对应GY_DMZD（DMSB=16）对应 1——麻醉、2——精神、3——贵重  */
    public void setTsyp(Integer value) {
        this.tsyp = value;
    }
    /** 获取:特殊药品 | 对应GY_DMZD（DMSB=16）对应 1——麻醉、2——精神、3——贵重 */
    public Integer getTsyp() {
        return tsyp;
    }

    /** 设置:药品单位  */
    public void setYpdw(String value) {
        this.ypdw = value;
    }
    /** 获取:药品单位 */
    public String getYpdw() {
        return ypdw;
    }

    /** 设置:最小单位  */
    public void setZxdw(String value) {
        this.zxdw = value;
    }
    /** 获取:最小单位 */
    public String getZxdw() {
        return zxdw;
    }

    /** 设置:最小包装  */
    public void setZxbz(Integer value) {
        this.zxbz = value;
    }
    /** 获取:最小包装 */
    public Integer getZxbz() {
        return zxbz;
    }

    /** 设置:药房包装  */
    public void setYfbz(Integer value) {
        this.yfbz = value;
    }
    /** 获取:药房包装 */
    public Integer getYfbz() {
        return yfbz;
    }

    /** 设置:药房单位  */
    public void setYfdw(String value) {
        this.yfdw = value;
    }
    /** 获取:药房单位 */
    public String getYfdw() {
        return yfdw;
    }

    /** 设置:病房包装  */
    public void setBfbz(Integer value) {
        this.bfbz = value;
    }
    /** 获取:病房包装 */
    public Integer getBfbz() {
        return bfbz;
    }

    /** 设置:病房单位  */
    public void setBfdw(String value) {
        this.bfdw = value;
    }
    /** 获取:病房单位 */
    public String getBfdw() {
        return bfdw;
    }

    /** 设置:作废判别  */
    public void setZfpb(Integer value) {
        this.zfpb = value;
    }
    /** 获取:作废判别 */
    public Integer getZfpb() {
        return zfpb;
    }

    /** 设置:皮试判别 | 皮试药品需要做皮试 0：非皮试类药品 1：皮试药品  */
    public void setPspb(Integer value) {
        this.pspb = value;
    }
    /** 获取:皮试判别 | 皮试药品需要做皮试 0：非皮试类药品 1：皮试药品 */
    public Integer getPspb() {
        return pspb;
    }

    /** 设置:用量限制  */
    public void setYlxz(BigDecimal value) {
        this.ylxz = value;
    }
    /** 获取:用量限制 */
    public BigDecimal getYlxz() {
        return ylxz;
    }

    /** 设置:发药方式 |药房发药根据发药方式统计各个病区的药品数量发药，对应IM_FYFS.FYFS的代码  */
    public void setFyfs(Integer value) {
        this.fyfs = value;
    }
    /** 获取:发药方式 |药房发药根据发药方式统计各个病区的药品数量发药，对应IM_FYFS.FYFS的代码 */
    public Integer getFyfs() {
        return fyfs;
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

    /** 设置:其他码  */
    public void setQtdm(String value) {
        this.qtdm = value;
    }
    /** 获取:其他码 */
    public String getQtdm() {
        return qtdm;
    }

    /** 设置:药品编号｜国标药品编码, 待用  */
    public void setYpbh(String value) {
        this.ypbh = value;
    }
    /** 获取:药品编号｜国标药品编码, 待用 */
    public String getYpbh() {
        return ypbh;
    }

    /** 设置:定价级别  */
    public void setDjjb(BigDecimal value) {
        this.djjb = value;
    }
    /** 获取:定价级别 */
    public BigDecimal getDjjb() {
        return djjb;
    }

    /** 设置:药品效期  */
    public void setYpxq(Integer value) {
        this.ypxq = value;
    }
    /** 获取:药品效期 */
    public Integer getYpxq() {
        return ypxq;
    }

    /** 设置:给药方法 | 对应IM_DIC_YPYF  */
    public void setGyff(Integer value) {
        this.gyff = value;
    }
    /** 获取:给药方法 | 对应IM_DIC_YPYF */
    public Integer getGyff() {
        return gyff;
    }

    /** 设置:药品类别 | 1：西药 2：中成药 3：中草药  */
    public void setType(Integer value) {
        this.type = value;
    }
    /** 获取:药品类别 | 1：西药 2：中成药 3：中草药 */
    public Integer getType() {
        return type;
    }

    /** 设置:药品编码  */
    public void setYpdm(String value) {
        this.ypdm = value;
    }
    /** 获取:药品编码 */
    public String getYpdm() {
        return ypdm;
    }

    /** 设置:药品档次 | 1.国产 2.合资 3.进口  */
    public void setYpdc(Integer value) {
        this.ypdc = value;
    }
    /** 获取:药品档次 | 1.国产 2.合资 3.进口 */
    public Integer getYpdc() {
        return ypdc;
    }

    /** 设置:制剂判别  */
    public void setZjpb(Integer value) {
        this.zjpb = value;
    }
    /** 获取:制剂判别 */
    public Integer getZjpb() {
        return zjpb;
    }

    /** 设置:急诊用药  */
    public void setJzyy(Integer value) {
        this.jzyy = value;
    }
    /** 获取:急诊用药 */
    public Integer getJzyy() {
        return jzyy;
    }

    /** 设置:药品剂量  */
    public void setYpjl(BigDecimal value) {
        this.ypjl = value;
    }
    /** 获取:药品剂量 */
    public BigDecimal getYpjl() {
        return ypjl;
    }

    /** 设置:剂量单位  */
    public void setJldw(String value) {
        this.jldw = value;
    }
    /** 获取:剂量单位 */
    public String getJldw() {
        return jldw;
    }

    /** 设置:ABC类别  */
    public void setAbc(String value) {
        this.abc = value;
    }
    /** 获取:ABC类别 */
    public String getAbc() {
        return abc;
    }

    /** 设置:取整策略 | 0：每次发药数量取整  1: 每天发药数量  2: 不取整  */
    public void setQzcl(Integer value) {
        this.qzcl = value;
    }
    /** 获取:取整策略 | 0：每次发药数量取整  1: 每天发药数量  2: 不取整 */
    public Integer getQzcl() {
        return qzcl;
    }

    /** 设置:自选产地  */
    public void setZxcd(Integer value) {
        this.zxcd = value;
    }
    /** 获取:自选产地 */
    public Integer getZxcd() {
        return zxcd;
    }

    /** 设置:抗生素标志  */
    public void setKsbz(Integer value) {
        this.ksbz = value;
    }
    /** 获取:抗生素标志 */
    public Integer getKsbz() {
        return ksbz;
    }

    /** 设置:一次用量  */
    public void setYcyl(BigDecimal value) {
        this.ycyl = value;
    }
    /** 获取:一次用量 */
    public BigDecimal getYcyl() {
        return ycyl;
    }

    /** 设置:基本药物标志  */
    public void setJbywbz(Integer value) {
        this.jbywbz = value;
    }
    /** 获取:基本药物标志 */
    public Integer getJbywbz() {
        return jbywbz;
    }

    /** 设置:运动员慎用  */
    public void setYdysy(Integer value) {
        this.ydysy = value;
    }
    /** 获取:运动员慎用 */
    public Integer getYdysy() {
        return ydysy;
    }

    /** 设置:冰箱冷藏  */
    public void setBxlc(Integer value) {
        this.bxlc = value;
    }
    /** 获取:冰箱冷藏 */
    public Integer getBxlc() {
        return bxlc;
    }

    /** 设置:处方用药备注  */
    public void setYybz(String value) {
        this.yybz = value;
    }
    /** 获取:处方用药备注 */
    public String getYybz() {
        return yybz;
    }

    /** 设置:新增时间  */
    public void setXzsj(Timestamp value) {
        this.xzsj = value;
    }
    /** 获取:新增时间 */
    public Timestamp getXzsj() {
        return xzsj;
    }

    /** 设置:药品贮藏  */
    public void setYpzc(Integer value) {
        this.ypzc = value;
    }
    /** 获取:药品贮藏 */
    public Integer getYpzc() {
        return ypzc;
    }

    /** 设置:医保分类  */
    public void setYbfl(Integer value) {
        this.ybfl = value;
    }
    /** 获取:医保分类 */
    public Integer getYbfl() {
        return ybfl;
    }

    /** 设置:处方药品  */
    public void setCfyp(Integer value) {
        this.cfyp = value;
    }
    /** 获取:处方药品 */
    public Integer getCfyp() {
        return cfyp;
    }

    /** 设置:抗生素等级 固定为一级抗生素 二级抗生素 三级抗生素  */
    public void setKssdj(Integer value) {
        this.kssdj = value;
    }
    /** 获取:抗生素等级 固定为一级抗生素 二级抗生素 三级抗生素 */
    public Integer getKssdj() {
        return kssdj;
    }

    /** 设置:DDD值  */
    public void setDddz(BigDecimal value) {
        this.dddz = value;
    }
    /** 获取:DDD值 */
    public BigDecimal getDddz() {
        return dddz;
    }

    /** 设置:通用名称 | 珠海医保专用  */
    public void setTymc(String value) {
        this.tymc = value;
    }
    /** 获取:通用名称 | 珠海医保专用 */
    public String getTymc() {
        return tymc;
    }

    /** 设置:药品说明  */
    public void setMess(String value) {
        this.mess = value;
    }
    /** 获取:药品说明 */
    public String getMess() {
        return mess;
    }

    /** 设置:笔画代码  */
    public void setBhdm(String value) {
        this.bhdm = value;
    }
    /** 获取:笔画代码 */
    public String getBhdm() {
        return bhdm;
    }

    /** 设置:zssf  */
    public void setZssf(Integer value) {
        this.zssf = value;
    }
    /** 获取:zssf */
    public Integer getZssf() {
        return zssf;
    }

    /** 设置:基药类型 1.非基本药物,2国家基本药物,3.省基本药物,4.区自选  */
    public void setJylx(Integer value) {
        this.jylx = value;
    }
    /** 获取:基药类型 1.非基本药物,2国家基本药物,3.省基本药物,4.区自选 */
    public Integer getJylx() {
        return jylx;
    }

    /** 设置:抗菌药物越权使用方式 1：提醒 2禁止  */
    public void setYqsyfs(Integer value) {
        this.yqsyfs = value;
    }
    /** 获取:抗菌药物越权使用方式 1：提醒 2禁止 */
    public Integer getYqsyfs() {
        return yqsyfs;
    }

    /** 设置:账簿类别,对应DIC_SFXMLB的 SFXM  */
    public void setZblb(Integer value) {
        this.zblb = value;
    }
    /** 获取:账簿类别,对应DIC_SFXMLB的 SFXM */
    public Integer getZblb() {
        return zblb;
    }

    /** 设置:抗菌药物是否需要审批 1：需要 2不需要  */
    public void setSfsp(Integer value) {
        this.sfsp = value;
    }
    /** 获取:抗菌药物是否需要审批 1：需要 2不需要 */
    public Integer getSfsp() {
        return sfsp;
    }

    /** 设置:一次剂量  */
    public void setYcjl(BigDecimal value) {
        this.ycjl = value;
    }
    /** 获取:一次剂量 */
    public BigDecimal getYcjl() {
        return ycjl;
    }

    /** 设置:重复用药提醒  */
    public void setCfyytx(Integer value) {
        this.cfyytx = value;
    }
    /** 获取:重复用药提醒 */
    public Integer getCfyytx() {
        return cfyytx;
    }

    /** 设置:自备药标识  */
    public void setZfyp(Integer value) {
        this.zfyp = value;
    }
    /** 获取:自备药标识 */
    public Integer getZfyp() {
        return zfyp;
    }

    /** 设置:药库作废  */
    public void setYkzf(String value) {
        this.ykzf = value;
    }
    /** 获取:药库作废 */
    public String getYkzf() {
        return ykzf;
    }

    /** 设置:用药标识  | 1.高血压、2.糖尿病、3.精神病、4.胰岛素  */
    public void setYybs(Integer value) {
        this.yybs = value;
    }
    /** 获取:用药标识  | 1.高血压、2.糖尿病、3.精神病、4.胰岛素 */
    public Integer getYybs() {
        return yybs;
    }

    /** 设置:过敏药物类别  | 1.青霉素、2.磺胺、3.链霉素  */
    public void setGmywlb(Integer value) {
        this.gmywlb = value;
    }
    /** 获取:过敏药物类别  | 1.青霉素、2.磺胺、3.链霉素 */
    public Integer getGmywlb() {
        return gmywlb;
    }

    /** 设置:scbz  */
    public void setScbz(String value) {
        this.scbz = value;
    }
    /** 获取:scbz */
    public String getScbz() {
        return scbz;
    }

    /** 设置:中成药用药限制,1是不限制,2是限制1周,3是限制2周  */
    public void setYyxz(Integer value) {
        this.yyxz = value;
    }
    /** 获取:中成药用药限制,1是不限制,2是限制1周,3是限制2周 */
    public Integer getYyxz() {
        return yyxz;
    }

    /** 设置:批准文号  */
    public void setPzwh(String value) {
        this.pzwh = value;
    }
    /** 获取:批准文号 */
    public String getPzwh() {
        return pzwh;
    }

    /** 设置:执行标准  */
    public void setBzzx(String value) {
        this.bzzx = value;
    }
    /** 获取:执行标准 */
    public String getBzzx() {
        return bzzx;
    }

    /** 设置:橱柜号  */
    public void setCgh(String value) {
        this.cgh = value;
    }
    /** 获取:橱柜号 */
    public String getCgh() {
        return cgh;
    }

    /** 设置:备注  */
    public void setBz(String value) {
        this.bz = value;
    }
    /** 获取:备注 */
    public String getBz() {
        return bz;
    }

    /** 设置:药品费别  */
    public void setYpfb(Integer value) {
        this.ypfb = value;
    }
    /** 获取:药品费别 */
    public Integer getYpfb() {
        return ypfb;
    }

    /** 设置:中标类型  */
    public void setZblx(Integer value) {
        this.zblx = value;
    }
    /** 获取:中标类型 */
    public Integer getZblx() {
        return zblx;
    }

    /** 设置:支付,1甲类,2 10%,3 20%  */
    public void setZf(Integer value) {
        this.zf = value;
    }
    /** 获取:支付,1甲类,2 10%,3 20% */
    public Integer getZf() {
        return zf;
    }

    /** 设置:抗菌药物管理分级 | 实现限制类抗菌药物以非限制类管理  */
    public void setGlxz(Integer value) {
        this.glxz = value;
    }
    /** 获取:抗菌药物管理分级 | 实现限制类抗菌药物以非限制类管理 */
    public Integer getGlxz() {
        return glxz;
    }

    /** 设置:jbbz  */
    public void setJbbz(String value) {
        this.jbbz = value;
    }
    /** 获取:jbbz */
    public String getJbbz() {
        return jbbz;
    }

    /** 设置:限定支付及备注  */
    public void setXdzfjbz(String value) {
        this.xdzfjbz = value;
    }
    /** 获取:限定支付及备注 */
    public String getXdzfjbz() {
        return xdzfjbz;
    }

    /** 设置:长处方药品  */
    public void setCcfyp(Integer value) {
        this.ccfyp = value;
    }
    /** 获取:长处方药品 */
    public Integer getCcfyp() {
        return ccfyp;
    }

    /** 设置:药品默认值  */
    public void setYpmrz(Integer value) {
        this.ypmrz = value;
    }
    /** 获取:药品默认值 */
    public Integer getYpmrz() {
        return ypmrz;
    }

    /** 设置:药品极限值  */
    public void setYpjxz(Integer value) {
        this.ypjxz = value;
    }
    /** 获取:药品极限值 */
    public Integer getYpjxz() {
        return ypjxz;
    }

    /** 设置:本地药品编码  */
    public void setYpbm(String value) {
        this.ypbm = value;
    }
    /** 获取:本地药品编码 */
    public String getYpbm() {
        return ypbm;
    }

    /** 设置:英文名称  */
    public void setYwmc(String value) {
        this.ywmc = value;
    }
    /** 获取:英文名称 */
    public String getYwmc() {
        return ywmc;
    }

    /** 设置:医保编码  */
    public void setYbbm(String value) {
        this.ybbm = value;
    }
    /** 获取:医保编码 */
    public String getYbbm() {
        return ybbm;
    }

    /** 设置:药品极限值天数  */
    public void setDcypjxzts(Integer value) {
        this.dcypjxzts = value;
    }
    /** 获取:药品极限值天数 */
    public Integer getDcypjxzts() {
        return dcypjxzts;
    }

    /** 设置:药品极限值总数  */
    public void setDcypjxzzs(Integer value) {
        this.dcypjxzzs = value;
    }
    /** 获取:药品极限值总数 */
    public Integer getDcypjxzzs() {
        return dcypjxzzs;
    }

    public String getCdrow() {
        return cdrow;
    }

    public void setCdrow(String cdrow) {
        this.cdrow = cdrow;
    }
}
