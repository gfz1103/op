
package com.buit.commons.response;

import java.util.ArrayList;
import java.util.List;

import com.buit.commons.model.SyJydjUser;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：UnRegistResp<br>
 * 类描述：查询病人已收费、已发药、未输液的输液处方返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "查询病人已收费、已发药、未输液的输液处方返回")
public class UnRegistResp {
	@ApiModelProperty(value = "登记用户信息")
	private SyJydjUser syJydjUser;
	@ApiModelProperty(value = "未输液数据列表")
	private List<QueryUnRegistResp> resultList = new ArrayList<QueryUnRegistResp>();
//	private List<List<QueryUnRegistResp>> resultList = new ArrayList<List<QueryUnRegistResp>>();

	public SyJydjUser getSyJydjUser() {
		return syJydjUser;
	}

	public void setSyJydjUser(SyJydjUser syJydjUser) {
		this.syJydjUser = syJydjUser;
	}

	public List<QueryUnRegistResp> getResultList() {
		return resultList;
	}

	public void setResultList(List<QueryUnRegistResp> resultList) {
		this.resultList = resultList;
	}

}