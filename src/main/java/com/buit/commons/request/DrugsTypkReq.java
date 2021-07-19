   
package com.buit.commons.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类描述：公用_药品查询<br>
 * @author 神算子
 */
@ApiModel(value="公用_药品查询")
public class DrugsTypkReq{
    @NotNull(message = "药房识别不能为空")
    @ApiModelProperty(value="药房识别",required = true)
    private Integer yfsb;
    
    @NotNull(message = "处方类型不能为空 ")
    @ApiModelProperty(value="处方类型 药品类别 |如 西药,中成药,中草药",required = true)
    private Integer cflx;
  
    @ApiModelProperty(value="为1时查询 自备药,可为空")
    private String zfyp;    
    @ApiModelProperty(value="机构ID",hidden =  true)
    private Integer jgid;
    @NotNull(message = "搜索条件不能为空")
    @ApiModelProperty(value="搜索条件",required = true)
    private String pydm;
    @ApiModelProperty(value="1:显示归名称")
    private String showGb;
	@ApiModelProperty(value="药品数量",required = true)
    private Integer ypsl;
    
	public String getShowGb() {
		return showGb;
	}
	public void setShowGb(String showGb) {
		this.showGb = showGb;
	}

	public String getZfyp() {
		return zfyp;
	}

	public void setZfyp(String zfyp) {
		this.zfyp = zfyp;
	}

	public Integer getYfsb() {
		return yfsb;
	}

	public void setYfsb(Integer yfsb) {
		this.yfsb = yfsb;
	}

	public Integer getCflx() {
		return cflx;
	}

	public void setCflx(Integer cflx) {
		this.cflx = cflx;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public String getPydm() {
		return pydm;
	}

	public void setPydm(String pydm) {
		this.pydm = pydm;
	}

	public Integer getYpsl() {
		return ypsl;
	}

	public void setYpsl(Integer ypsl) {
		this.ypsl = ypsl;
	}
}
