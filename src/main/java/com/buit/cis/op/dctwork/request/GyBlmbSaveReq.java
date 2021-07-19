
package com.buit.cis.op.dctwork.request;

import com.buit.commons.request.PubPelplehealthteachMbSaveReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * 类名称：GyBlmb<br>
 * 类描述：公用_门诊病历模板<br>
 * @author 老花生
 */
@ApiModel(value="门诊病历模板-保存")
public class GyBlmbSaveReq {
    @NotNull
    @ApiModelProperty(value="记录序号 | 主键")
    private Integer jlxh;
    @ApiModelProperty(value="既往史")
    private String jws;
    @ApiModelProperty(value="体格检查")
    private String tgjc;
    @ApiModelProperty(value="现病史")
    private String xbs;
    @ApiModelProperty(value="主诉信息")
    private String zsxx;
    @ApiModelProperty(value="辅助检查")
    private String fzjc;
    @ApiModelProperty(value="健康教育集合")
    private List<PubPelplehealthteachMbSaveReq> mbList;

    public Integer getJlxh() {
        return jlxh;
    }

    public void setJlxh(Integer jlxh) {
        this.jlxh = jlxh;
    }

    public String getJws() {
        return jws;
    }

    public void setJws(String jws) {
        this.jws = jws;
    }

    public String getTgjc() {
        return tgjc;
    }

    public void setTgjc(String tgjc) {
        this.tgjc = tgjc;
    }

    public String getXbs() {
        return xbs;
    }

    public void setXbs(String xbs) {
        this.xbs = xbs;
    }

    public String getZsxx() {
        return zsxx;
    }

    public void setZsxx(String zsxx) {
        this.zsxx = zsxx;
    }

    public String getFzjc() {
        return fzjc;
    }

    public void setFzjc(String fzjc) {
        this.fzjc = fzjc;
    }

    public List<PubPelplehealthteachMbSaveReq> getMbList() {
        return mbList;
    }

    public void setMbList(List<PubPelplehealthteachMbSaveReq> mbList) {
        this.mbList = mbList;
    }
}
