package com.buit.commons.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;


/**
 * 门诊住院登记分页查询请求
 * 类名称：OpZydjPageReq<br>
 * 类描述：<br>
 * @author 老花生
 */
@ApiModel(value="门诊住院登记分页查询请求")
public class OpZydjPageReq  extends PageQuery {
  @ApiModelProperty(value="门诊号码")
  private String mzhm;

  @ApiModelProperty(value="就诊流水号")
  private String jzlsh;

  @ApiModelProperty(value="申请类型：1住院申请、2留观申请")
  @NotBlank(message = "申请类型不能为空")
  private String sqlx;

  public String getJzlsh() {
    return jzlsh;
  }

  public void setJzlsh(String jzlsh) {
    this.jzlsh = jzlsh;
  }

  public String getMzhm() {
    return mzhm;
  }

  public void setMzhm(String mzhm) {
    this.mzhm = mzhm;
  }

  public String getSqlx() {
    return sqlx;
  }

  public void setSqlx(String sqlx) {
    this.sqlx = sqlx;
  }
}
