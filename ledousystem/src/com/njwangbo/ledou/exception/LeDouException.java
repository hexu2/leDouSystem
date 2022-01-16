package com.njwangbo.ledou.exception;

@SuppressWarnings("serial")
public class LeDouException extends Exception{
	/**
	 * 错误码
	 */
	private String code;
	/**
	 * 错误信息
	 */
	private String msg;
	
	public LeDouException() {
		super();
	}

	public LeDouException(String code, String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	
	
	
	

}
