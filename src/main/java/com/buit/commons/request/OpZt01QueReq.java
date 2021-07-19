
package com.buit.commons.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OpZt01<br>
 * 类描述：门诊_门诊医生组套 | 输入法查询使用<br>
 * @author 神算子
 */
@ApiModel(value=" 输入法查询使用")
public class OpZt01QueReq  extends PageQuery {
    @ApiModelProperty(value="机构代码", hidden = true)
    private Integer jgid;
    @ApiModelProperty(value="员工代码", hidden = true)
    private Integer ygdm;
    @ApiModelProperty(value="拼音码,查询条件")
    private String pydm; 
    
    @NotNull(message = "组套类别 不能为空")
    @ApiModelProperty(value="组套类别 |来源字典 西药 中药 草药 项目")
    private Integer ztlb;
    @NotEmpty(message = "门诊科室代码 不能为空")
    @ApiModelProperty(value="门诊科室代码")
    private String ksdm;
    
    /**
     * 设置:组套类别 | 1.西药 2.中药 3.草药 4.项目
     */
    public void setZtlb(Integer value) {
        this.ztlb = value;
    }
    /**
     * 获取:组套类别 | 1.西药 2.中药 3.草药 4.项目
     */
    public Integer getZtlb() {
        return ztlb;
    }
    /**
     * 设置:所属类别 | 1.个人组套 2.科室组套 3.公用组套 4.个人常用药 5.科室常用 6.全院常用
     */
    
    /**
     * 设置:员工代码
     */
    public void setYgdm(Integer value) {
        this.ygdm = value;
    }
    /**
     * 获取:员工代码
     */
    public Integer getYgdm() {
        return ygdm;
    }
    /**
     * 设置:关联疾病
     */
   
    /**
     * 设置:拼音码
     */
    public void setPydm(String value) {
        this.pydm = value;
    }
    /**
     * 获取:拼音码
     */
    public String getPydm() {
        return pydm;
    }
   
    /**
     * 设置:机构代码
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /**
     * 获取:机构代码
     */
    public Integer getJgid() {
        return jgid;
    }
    /**
     * 设置:科室代码
     */
    public void setKsdm(String value) {
        this.ksdm = value;
    }
    /**
     * 获取:科室代码
     */
    public String getKsdm() {
        return ksdm;
    }
}
