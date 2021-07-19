
package com.buit.commons.response;

import java.util.List;

import com.buit.commons.PageQuery;
import com.buit.commons.model.OpZt01;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OpZt01AllResp<br>
 * 类描述：住院药品组套
 * @author GONGFANGZHOU
 */
@ApiModel(value="住院药品组套_allResp")
public class OpZt01AllResp extends PageQuery{
	
    @ApiModelProperty(value="西药集合")
    private List<OpZt01> westernMedicineList;
    @ApiModelProperty(value="中成药集合")
    private List<OpZt01> chineseMedicineList;
    @ApiModelProperty(value="草药集合")
    private List<OpZt01> herbalMedicineList;
    @ApiModelProperty(value="项目集合")
    private List<OpZt01> projectList;
	public List<OpZt01> getWesternMedicineList() {
		return westernMedicineList;
	}
	public void setWesternMedicineList(List<OpZt01> westernMedicineList) {
		this.westernMedicineList = westernMedicineList;
	}
	public List<OpZt01> getChineseMedicineList() {
		return chineseMedicineList;
	}
	public void setChineseMedicineList(List<OpZt01> chineseMedicineList) {
		this.chineseMedicineList = chineseMedicineList;
	}
	public List<OpZt01> getHerbalMedicineList() {
		return herbalMedicineList;
	}
	public void setHerbalMedicineList(List<OpZt01> herbalMedicineList) {
		this.herbalMedicineList = herbalMedicineList;
	}
	public List<OpZt01> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<OpZt01> projectList) {
		this.projectList = projectList;
	}

    
}
