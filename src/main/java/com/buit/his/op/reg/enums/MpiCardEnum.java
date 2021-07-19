package com.buit.his.op.reg.enums;

/**
 * 
 * @author wangyang
 *
 */
public enum MpiCardEnum {
	/**
	 * 正常
	 */
	NORMAL("0"),
	/**
	 * 挂失
	 */
	LOST("1"),
	/**
	 * 注销
	 */
	CANCEL("2"),
	/**
	 * 失效
	 */
	INVALID("3");

	private String code;

	MpiCardEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
