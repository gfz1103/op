package com.buit.commons.model;


import com.buit.commons.PageQuery;

/**
 * 类名称：LisJyztlx<br> 
 * 类描述：组套类型维护
 * @author 老花生
 * @ApiModel(value="组套类型维护")
 */
public class LisJyztlx  extends PageQuery {
	//@ApiModelProperty(value="ID")
    /** ID */
    private Integer id;
	//@ApiModelProperty(value="组套类型名称")
    /** 组套类型名称 */
    private String name;
	//@ApiModelProperty(value="注销标志(0=正常，1=注销)")
    /** 注销标志(0=正常，1=注销) */
    private String zxbz;

    /** 设置:ID  */
    public void setId(Integer value) {
        this.id = value;
    }
    /** 获取:ID */
    public Integer getId() {
        return id;
    }

    /** 设置:组套类型名称  */
    public void setName(String value) {
        this.name = value;
    }
    /** 获取:组套类型名称 */
    public String getName() {
        return name;
    }

    /** 设置:注销标志(0=正常，1=注销)  */
    public void setZxbz(String value) {
        this.zxbz = value;
    }
    /** 获取:注销标志(0=正常，1=注销) */
    public String getZxbz() {
        return zxbz;
    }


}
