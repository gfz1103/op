package com.buit.commons.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * 类名称：DicGbsj02<br>
 * 类描述：标准数据值域记录<br>
 * @author 老花生
 */
@ApiModel(value="标准数据值域记录")
public class DicGbsj02 extends PageQuery {
	//@ApiModelProperty(value="数据值ID")
    /** 数据值ID */
    private Integer datavalueId;
	//@ApiModelProperty(value="数据版本")
    /** 数据版本 */
    private Integer dataVersion;
	//@ApiModelProperty(value="数据创建时间")
    /** 数据创建时间 */
    private Timestamp gmtCreate;
	//@ApiModelProperty(value="数据修改时间")
    /** 数据修改时间 */
    private Timestamp gmtModify;
	//@ApiModelProperty(value="医疗机构ID")
    /** 医疗机构ID */
    private Integer hospitalId;
	//@ApiModelProperty(value="版本数据ID")
    /** 版本数据ID */
    private Integer dataversionId;
	//@ApiModelProperty(value="序号")
    /** 序号 */
    private Integer serialNumber;
	//@ApiModelProperty(value="值")
    /** 值 */
    private String dataValue;
	//@ApiModelProperty(value="值含义")
    /** 值含义 */
    private String dataValueRemark;
	//@ApiModelProperty(value="上级数据值ID")
    /** 上级数据值ID */
    private Integer parentDatavalueId;
	//@ApiModelProperty(value="拼音码")
    /** 拼音码 */
    private String pyCode;
	//@ApiModelProperty(value="五笔码")
    /** 五笔码 */
    private String wbCode;
	//@ApiModelProperty(value="标准数据ID")
    /** 标准数据ID */
    private Integer primarydataId;
	//@ApiModelProperty(value="扩展属性")
    /** 扩展属性 */
    private String extInfo;
	//@ApiModelProperty(value="是否可扩展标记：FD000054")
    /** 是否可扩展标记：FD000054 */
    private String canExt;
    @ApiModelProperty(value="停用标识, 0启用,1:停用")
    private String stopFlag;
    @ApiModelProperty(value="查询条件")
    private String searchValue;
    /** 标准数据代码 */
    String primaryDataCode;
    /** 是否删除 0:否 1:删除 */
    private Integer deleted;

    /** 设置:数据值ID  */
    public void setDatavalueId(Integer value) {
        this.datavalueId = value;
    }
    /** 获取:数据值ID */
    public Integer getDatavalueId() {
        return datavalueId;
    }

    /** 设置:数据版本  */
    public void setDataVersion(Integer value) {
        this.dataVersion = value;
    }
    /** 获取:数据版本 */
    public Integer getDataVersion() {
        return dataVersion;
    }

    /** 设置:数据创建时间  */
    public void setGmtCreate(Timestamp value) {
        this.gmtCreate = value;
    }
    /** 获取:数据创建时间 */
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    /** 设置:数据修改时间  */
    public void setGmtModify(Timestamp value) {
        this.gmtModify = value;
    }
    /** 获取:数据修改时间 */
    public Timestamp getGmtModify() {
        return gmtModify;
    }

    /** 设置:医疗机构ID  */
    public void setHospitalId(Integer value) {
        this.hospitalId = value;
    }
    /** 获取:医疗机构ID */
    public Integer getHospitalId() {
        return hospitalId;
    }

    /** 设置:版本数据ID  */
    public void setDataversionId(Integer value) {
        this.dataversionId = value;
    }
    /** 获取:版本数据ID */
    public Integer getDataversionId() {
        return dataversionId;
    }

    /** 设置:序号  */
    public void setSerialNumber(Integer value) {
        this.serialNumber = value;
    }
    /** 获取:序号 */
    public Integer getSerialNumber() {
        return serialNumber;
    }

    /** 设置:值  */
    public void setDataValue(String value) {
        this.dataValue = value;
    }
    /** 获取:值 */
    public String getDataValue() {
        return dataValue;
    }

    /** 设置:值含义  */
    public void setDataValueRemark(String value) {
        this.dataValueRemark = value;
    }
    /** 获取:值含义 */
    public String getDataValueRemark() {
        return dataValueRemark;
    }

    /** 设置:上级数据值ID  */
    public void setParentDatavalueId(Integer value) {
        this.parentDatavalueId = value;
    }
    /** 获取:上级数据值ID */
    public Integer getParentDatavalueId() {
        return parentDatavalueId;
    }

    /** 设置:拼音码  */
    public void setPyCode(String value) {
        this.pyCode = value;
    }
    /** 获取:拼音码 */
    public String getPyCode() {
        return pyCode;
    }

    /** 设置:五笔码  */
    public void setWbCode(String value) {
        this.wbCode = value;
    }
    /** 获取:五笔码 */
    public String getWbCode() {
        return wbCode;
    }

    /** 设置:标准数据ID  */
    public void setPrimarydataId(Integer value) {
        this.primarydataId = value;
    }
    /** 获取:标准数据ID */
    public Integer getPrimarydataId() {
        return primarydataId;
    }

    /** 设置:扩展属性  */
    public void setExtInfo(String value) {
        this.extInfo = value;
    }
    /** 获取:扩展属性 */
    public String getExtInfo() {
        return extInfo;
    }

    /** 设置:是否可扩展标记：FD000054  */
    public void setCanExt(String value) {
        this.canExt = value;
    }
    /** 获取:是否可扩展标记：FD000054 */
    public String getCanExt() {
        return canExt;
    }

    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getPrimaryDataCode() {
        return primaryDataCode;
    }

    public void setPrimaryDataCode(String primaryDataCode) {
        this.primaryDataCode = primaryDataCode;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
