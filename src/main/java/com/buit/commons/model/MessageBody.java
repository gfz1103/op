package com.buit.commons.model;

import com.buit.commons.enums.MessageTypeEnum;
import com.buit.commons.enums.TradingChannelEnum;

import java.util.Date;

/**
 * 医保交易实体类
 * @author beijunhua
 */
public class MessageBody {

    /**
     * 交易时间
     */
    private Date jysj;

    /**
     * 消息类型码
     */
    private MessageTypeEnum xxlxm;

    /**
     * 交易返回码
     */
    private String xxfhm;

    /**
     * 交易返回信息
     */
    private String fhxx;

    /**
     * 交易版本号
     */
    private String bbh;

    /**
     * 报文 ID
     */
    private String msgid;

    /**
     * 发卡地行政区划代码
     */
    private String xzqhdm;

    /**
     * 协议机构编码
     */
    private String jgdm;

    /**
     * 操作员编码
     */
    private Integer czybm;

    /**
     * 操作员姓名
     */
    private String czyxm;

    /**
     * 消息内容
     */
    private Object xxnr;

    /**
     * 交易渠道
     */
    private TradingChannelEnum jyqd;

    /**
     * 交易验证码
     */
    private String jyyzm;

    /**
     * 终端设备识别码
     */
    private String zdjbhs;

    public Date getJysj() {
        return jysj;
    }

    public void setJysj(Date jysj) {
        this.jysj = jysj;
    }

    public MessageTypeEnum getXxlxm() {
        return xxlxm;
    }

    public void setXxlxm(MessageTypeEnum xxlxm) {
        this.xxlxm = xxlxm;
    }

    public String getXxfhm() {
        return xxfhm;
    }

    public void setXxfhm(String xxfhm) {
        this.xxfhm = xxfhm;
    }

    public String getFhxx() {
        return fhxx;
    }

    public void setFhxx(String fhxx) {
        this.fhxx = fhxx;
    }

    public String getBbh() {
        return bbh;
    }

    public void setBbh(String bbh) {
        this.bbh = bbh;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getXzqhdm() {
        return xzqhdm;
    }

    public void setXzqhdm(String xzqhdm) {
        this.xzqhdm = xzqhdm;
    }

    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    public Integer getCzybm() {
        return czybm;
    }

    public void setCzybm(Integer czybm) {
        this.czybm = czybm;
    }

    public String getCzyxm() {
        return czyxm;
    }

    public void setCzyxm(String czyxm) {
        this.czyxm = czyxm;
    }

    public Object getXxnr() {
        return xxnr;
    }

    public void setXxnr(Object xxnr) {
        this.xxnr = xxnr;
    }

    public TradingChannelEnum getJyqd() {
        return jyqd;
    }

    public void setJyqd(TradingChannelEnum jyqd) {
        this.jyqd = jyqd;
    }

    public String getJyyzm() {
        return jyyzm;
    }

    public void setJyyzm(String jyyzm) {
        this.jyyzm = jyyzm;
    }

    public String getZdjbhs() {
        return zdjbhs;
    }

    public void setZdjbhs(String zdjbhs) {
        this.zdjbhs = zdjbhs;
    }

    @Override
    public String toString() {
        return "MessageBody{" +
                "jysj=" + jysj +
                ", xxlxm=" + xxlxm +
                ", xxfhm=" + xxfhm +
                ", fhxx='" + fhxx + '\'' +
                ", bbh='" + bbh + '\'' +
                ", msgid='" + msgid + '\'' +
                ", xzqhdm='" + xzqhdm + '\'' +
                ", jgdm='" + jgdm + '\'' +
                ", czybm='" + czybm + '\'' +
                ", czyxm='" + czyxm + '\'' +
                ", xxnr=" + xxnr +
                ", jyqd=" + jyqd +
                ", jyyzm='" + jyyzm + '\'' +
                ", zdjbhs='" + zdjbhs + '\'' +
                '}';
    }
}
