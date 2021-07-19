
package com.buit.commons.response;

import java.util.ArrayList;
import java.util.List;

import com.buit.commons.model.SyJydjUser;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryUnSkinTestResp<br>
 * 类描述：查询病人已收费、未执行的皮试项目返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "查询病人已收费、未执行的皮试项目返回")
public class QueryUnSkinTestResp {
	@ApiModelProperty(value = "登记用户信息")
	private SyJydjUser syJydjUser;
	@ApiModelProperty(value = "皮试项目列表")
	private List<QueryUnPsxmResp> cfList = new ArrayList<QueryUnPsxmResp>();

	public SyJydjUser getSyJydjUser() {
		return syJydjUser;
	}

	public void setSyJydjUser(SyJydjUser syJydjUser) {
		this.syJydjUser = syJydjUser;
	}

	public List<QueryUnPsxmResp> getCfList() {
		return cfList;
	}

	public void setCfList(List<QueryUnPsxmResp> cfList) {
		this.cfList = cfList;
	}

}