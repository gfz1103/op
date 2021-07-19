package com.buit.commons.model;


import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：OpJzdlResult<br>
 * 类描述：资源排队情况<br>
 * @author wangyang
 */
@ApiModel(value = "资源排队情况")
public class OpJzdlResult extends PageQuery {
	@ApiModelProperty(value = "唯一ID,使用描述:新增时不可传递到后台，修改时必须传递到后台")
	/** 唯一ID,使用描述:新增时不可传递到后台，修改时必须传递到后台 */
	@JsonIgnore
	private Integer outpQueueId;
	@ApiModelProperty(value = "医疗机构ID")
	private Integer hospitalId;
	@ApiModelProperty(value = "挂号时间，使用描述：格式为yyyy-MM-dd HH:mm:ss")
	/** 挂号时间，使用描述：格式为yyyy-MM-dd HH:mm:ss */
	@JsonIgnore
	private Date regDate;
	@ApiModelProperty(value = "挂号时间开始，使用描述：格式为yyyy-MM-dd HH:mm:ss")
	/** 挂号时间，使用描述：格式为yyyy-MM-dd HH:mm:ss */
	@JsonIgnore
	private Date beginRegDate;
	@ApiModelProperty(value = "挂号时间结束，使用描述：格式为yyyy-MM-dd HH:mm:ss")
	/** 挂号时间，使用描述：格式为yyyy-MM-dd HH:mm:ss */
	@JsonIgnore
	private Date endRegDate;
	@ApiModelProperty(value = "科室id SYS_DICT_CONFIG ：1")
	/** 科室id */
	private Integer ksid;
	@ApiModelProperty(value = "科室名称")
	/** 科室id */
	private String deptName;
	@ApiModelProperty(value = "叫号诊室代码 SYS_DICT_CONFIG ：4")
	/** 叫号诊室代码 */
	private String queueConsultCode;
	@ApiModelProperty(value = "诊室名称")
	/** 叫号诊室代码 */
	private String roomName;
	@ApiModelProperty(value = "就诊序号")
	/** 就诊序号 */
	@JsonIgnore
	private Integer serailNo;
	@ApiModelProperty(value = "排队序号")
	/** 排队序号 */
	@JsonIgnore
	private Integer orderNo;
	@ApiModelProperty(value = "叫号时间，使用描述：格式为yyyy-MM-dd HH:mm:ss")
	/** 叫号时间，使用描述：格式为yyyy-MM-dd HH:mm:ss */
	@JsonIgnore
	private Timestamp queueDate;
	@ApiModelProperty(value = "就诊状态，使用描述：FD 0-待诊,1-诊中,2-诊毕")
	/** 就诊状态，使用描述：FD 0-待诊,1-诊中,2-诊毕 */
	@JsonIgnore
	private String status;
	@ApiModelProperty(value = "排队人数")
	/** 排队人数 */
	private Integer pdNums;
	@ApiModelProperty(value = "就诊人数")
	/** 就诊人数 */
	private Integer jzNums;
	@ApiModelProperty(value = "待诊人数")
	/** 待诊人数 */
	private Integer dzNums;
	@ApiModelProperty(value = "诊中人数")
	/** 诊中人数 */
	private Integer zzNums;
	@ApiModelProperty(value = "诊毕人数")
	/** 诊毕人数 */
	private Integer zbNums;
	@ApiModelProperty(value = "最大等待时间")
	/** 最大等待时间 */
	private Integer maxWaitTime;
	@ApiModelProperty(value = "最小等待时间")
	/** 最小等待时间 */
	private Integer minWaitTime;
	@ApiModelProperty(value = "平均等待时间")
	/** 平均等待时间 */
	private Integer avgWaitTime;
	@ApiModelProperty(value = "唯一key")
	/** 唯一key */
	private String unionKey;

	private List<OpJzdlResult> children = new ArrayList<OpJzdlResult>();

	/** 设置:唯一ID,使用描述:新增时不可传递到后台，修改时必须传递到后台 */
	public void setOutpQueueId(Integer value) {
		this.outpQueueId = value;
	}

	/** 获取:唯一ID,使用描述:新增时不可传递到后台，修改时必须传递到后台 */
	public Integer getOutpQueueId() {
		return outpQueueId;
	}

	public Date getBeginRegDate() {
		return beginRegDate;
	}

	public void setBeginRegDate(Date beginRegDate) {
		this.beginRegDate = beginRegDate;
	}

	public Date getEndRegDate() {
		return endRegDate;
	}

	public void setEndRegDate(Date endRegDate) {
		this.endRegDate = endRegDate;
	}

	/** 设置:就诊序号 */
	public void setSerailNo(Integer value) {
		this.serailNo = value;
	}

	/** 获取:就诊序号 */
	public Integer getSerailNo() {
		return serailNo;
	}

	/** 设置:排队序号 */
	public void setOrderNo(Integer value) {
		this.orderNo = value;
	}

	/** 获取:排队序号 */
	public Integer getOrderNo() {
		return orderNo;
	}

	/** 设置:叫号时间，使用描述：格式为yyyy-MM-dd HH:mm:ss */
	public void setQueueDate(Timestamp value) {
		this.queueDate = value;
	}

	/** 获取:叫号时间，使用描述：格式为yyyy-MM-dd HH:mm:ss */
	public Timestamp getQueueDate() {
		return queueDate;
	}

	/** 设置:叫号诊室代码 */
	public void setQueueConsultCode(String value) {
		this.queueConsultCode = value;
	}

	/** 获取:叫号诊室代码 */
	public String getQueueConsultCode() {
		return queueConsultCode;
	}

	/** 设置:就诊状态，使用描述：FD 0-待诊,1-诊中,2-诊毕 */
	public void setStatus(String value) {
		this.status = value;
	}

	/** 获取:就诊状态，使用描述：FD 0-待诊,1-诊中,2-诊毕 */
	public String getStatus() {
		return status;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Integer getPdNums() {
		return pdNums;
	}

	public void setPdNums(Integer pdNums) {
		this.pdNums = pdNums;
	}

	public Integer getJzNums() {
		return jzNums;
	}

	public void setJzNums(Integer jzNums) {
		this.jzNums = jzNums;
	}

	public Integer getDzNums() {
		return dzNums;
	}

	public void setDzNums(Integer dzNums) {
		this.dzNums = dzNums;
	}

	public Integer getZzNums() {
		return zzNums;
	}

	public void setZzNums(Integer zzNums) {
		this.zzNums = zzNums;
	}

	public Integer getZbNums() {
		return zbNums;
	}

	public void setZbNums(Integer zbNums) {
		this.zbNums = zbNums;
	}

	public Integer getMaxWaitTime() {
		return maxWaitTime;
	}

	public void setMaxWaitTime(Integer maxWaitTime) {
		this.maxWaitTime = maxWaitTime;
	}

	public Integer getMinWaitTime() {
		return minWaitTime;
	}

	public void setMinWaitTime(Integer minWaitTime) {
		this.minWaitTime = minWaitTime;
	}

	public Integer getAvgWaitTime() {
		return avgWaitTime;
	}

	public void setAvgWaitTime(Integer avgWaitTime) {
		this.avgWaitTime = avgWaitTime;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public List<OpJzdlResult> getChildren() {
		return children;
	}

	public void setChildren(List<OpJzdlResult> children) {
		this.children = children;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getUnionKey() {
		return unionKey;
	}

	public void setUnionKey(String unionKey) {
		this.unionKey = unionKey;
	}

	public Integer getKsid() {
		return ksid;
	}

	public void setKsid(Integer ksid) {
		this.ksid = ksid;
	}
}
