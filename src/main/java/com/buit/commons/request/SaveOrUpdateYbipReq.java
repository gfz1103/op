
package com.buit.commons.request;

import java.util.ArrayList;
import java.util.List;

import com.buit.commons.PageQuery;
import com.buit.commons.model.OpYbip;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SaveOrUpdateYbipReq<br>
 * 类描述：医保ip新增或修改请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "医保ip新增或修改请求")
public class SaveOrUpdateYbipReq extends PageQuery {
	@ApiModelProperty(value = "医保IP数组")
	private List<OpYbip> ybIpList = new ArrayList<OpYbip>();

	public List<OpYbip> getYbIpList() {
		return ybIpList;
	}

	public void setYbIpList(List<OpYbip> ybIpList) {
		this.ybIpList = ybIpList;
	}

}
