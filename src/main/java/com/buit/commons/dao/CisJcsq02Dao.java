package com.buit.commons.dao;

import com.buit.apply.response.CisJcsq02ZlxmResp;
import com.buit.commons.EntityDao;
import com.buit.commons.model.CisJcsq02;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 检查申请单明细<br>
 * @author 老花生
 */
@Mapper
public interface CisJcsq02Dao extends EntityDao<CisJcsq02,Integer>{

	 /**
	  * 查询检查申请单诊疗项目信息
	  * @Title: queryYsJcDicZlxmInfo
	  * @Description: TODO(这里用一句话描述这个方法的作用)
	  * @param @param jcxh
	  * @param @param jgid
	  * @param @return    设定文件
	  * @return List<CisJcsq02ZlxmResp>    返回类型
	  * @author 龚方舟
	  * @throws
	  */
	 List<CisJcsq02ZlxmResp> queryYsJcDicZlxmInfo(@Param("jcxh") Integer jcxh, @Param("jgid") Integer jgid);
}
