package com.buit.commons.dao;

import com.buit.commons.EntityDao;
import com.buit.system.response.FeeSfdlzfbl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 公用_自负比例<br>
 *
 * @author ZHOUHAISHENG
 */
@Mapper
public interface FeeSfdlzfblDao extends EntityDao<FeeSfdlzfbl, Integer> {

	/**
	 * 获取自负比例信息
	 *
	 * @author wy
	 * @param feeSfdlzfbl
	 * @return
	 */
	Map<String, Object> getZfblInfo(FeeSfdlzfbl feeSfdlzfbl);

	/**
	 * 获取自负比例信息 map方式的
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getZfblMap(Map<String, Object> map);

	/**
	 * 根据brxz、fyxm查询
	 *
	 * @param brxz
	 * @param fyxm
	 * @return
	 */
    FeeSfdlzfbl getByBrxzAndSfxm(@Param("brxz") Integer brxz, @Param("fyxm") Integer fyxm);

    /**
     * 获取病人性质
     * @Title: getBrxzInfo
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @return    设定文件
     * @return List<FeeSfdlzfbl>    返回类型
     * @author 龚方舟
     * @throws
     */
    List<FeeSfdlzfbl> getBrxzInfo();

	/**
	 * 中心维护-病人性质维护-自付比例修改
	 * @param brxz
	 * @param sfxm
	 */
	void updateZfbl(@Param("brxz") Integer brxz, @Param("sfxm") Integer sfxm);
}
