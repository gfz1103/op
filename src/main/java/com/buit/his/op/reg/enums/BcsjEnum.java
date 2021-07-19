package com.buit.his.op.reg.enums;

/**
 * 
 * @author wangyang
 *
 */
public enum BcsjEnum {
	/**
	 * 上午
	 */
	SW("1000006"),
	/**
	 * 下午
	 */
	XW("1000008"),
	/**
	 * 夜班
	 */
	YB("1000009"),
	/**
	 * 全天
	 */
	QT("1000010");

	private String code;

	BcsjEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
