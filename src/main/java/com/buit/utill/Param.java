package com.buit.utill;

import java.util.HashMap;
import java.util.Map;

/**
 * 快速创建map并放入数据
 * @author 老花生
 *
 */
public class Param extends HashMap<String, Object>{
	private Param(){}
	public static final Param instance(){
		return new Param();
	}
	public static final Param instance(Map<String, Object> oldMap){
		Param p=instance();
		p.putAll(oldMap);
		return p;
	}

	@Override
	public Param put(String key, Object value){
		super.put(key, value);
		return this;
	}
	public Param remove(String key){
		super.remove(key);
		return this;
	}
}
