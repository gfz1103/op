package com.buit.commons.model;

import com.buit.commons.PageQuery;

/**
 * 类名称：OpCfdbr<br>
 * 类描述：处方代办信息表
 * @author 韦靖
 * @ApiModel(value="处方代办信息表")
 */
public class OpCfdbr  extends  PageQuery{
	//@ApiModelProperty(value="主键 代办ID")
    /** 主键 代办ID */
    private Integer dbid;
	//@ApiModelProperty(value="关联op_cf01表主键")
    /** 关联op_cf01表主键 */
    private Integer cfsb;
	//@ApiModelProperty(value="机构ID")
    /** 机构ID */
    private Integer jgid;
	//@ApiModelProperty(value="代办人姓名")
    /** 代办人姓名 */
    private String dbrxm;
	//@ApiModelProperty(value="代办人联系电话")
    /** 代办人联系电话 */
    private String dbrlxdh;
	//@ApiModelProperty(value="身份证明 对应证件类型")
    /** 身份证明 对应证件类型 */
    private String sfzm;
	//@ApiModelProperty(value="编号 ")
    /** 编号  */
    private String bh;

    /** 设置:主键 代办ID  */
    public void setDbid(Integer value) {
        this.dbid = value;
    }
    /** 获取:主键 代办ID */
    public Integer getDbid() {
        return dbid;
    }

    /** 设置:关联op_cf01表主键  */
    public void setCfsb(Integer value) {
        this.cfsb = value;
    }
    /** 获取:关联op_cf01表主键 */
    public Integer getCfsb() {
        return cfsb;
    }

    /** 设置:机构ID  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:机构ID */
    public Integer getJgid() {
        return jgid;
    }

    /** 设置:代办人姓名  */
    public void setDbrxm(String value) {
        this.dbrxm = value;
    }
    /** 获取:代办人姓名 */
    public String getDbrxm() {
        return dbrxm;
    }

    /** 设置:代办人联系电话  */
    public void setDbrlxdh(String value) {
        this.dbrlxdh = value;
    }
    /** 获取:代办人联系电话 */
    public String getDbrlxdh() {
        return dbrlxdh;
    }

    /** 设置:身份证明 对应证件类型  */
    public void setSfzm(String value) {
        this.sfzm = value;
    }
    /** 获取:身份证明 对应证件类型 */
    public String getSfzm() {
        return sfzm;
    }

    /** 设置:编号   */
    public void setBh(String value) {
        this.bh = value;
    }
    /** 获取:编号  */
    public String getBh() {
        return bh;
    }


}
