package com.njwangbo.ledou.exception;

public interface ErrorCode {
	/***************************用户异常     开始**********************************/
	public static final String PHONENUM_IS_EMPTY_ERROR = "10001";
	public static final String PHONENUM_IS_EMPTY_ERROR_MSG = "手机号不能为空";
	
	public static final String PHONENUM_IS_NOT_CMCC_ERROR="10002";
	public static final String PHONENUM_IS_NOT_CMCC_ERROR_MSG="手机号不是中国移动";
	
	public static final String PHONENUM_IS_EXIST_ERROR="10003";
	public static final String PHONENUM_IS_EXIST_ERROR_MSG="手机号不是中国移动或已经注册乐豆系统";
	
	public static final String PHONENUM_IS_INVALID_ERROR="10004";
	public static final String PHONENUM_IS_INVALID_ERROR_MSG="手机号必须为以1开头的11位纯数字";
	
	public static final String PWD_IS_EMPTY_ERROR="10005";
	public static final String PWD_IS_EMPTY_ERROR_MSG="密码不能为空";
	
	public static final String PWD_IS_INVALID_ERROR="10006";
	public static final String PWD_IS_INVALID_ERROR_MSG="密码只能为6到10为数字或者字母";
	/***************************用户异常    结束**********************************/
	
	
	
	
	/***************************游戏异常     开始**********************************/
	public static final String GAME_NAME_IS_EMPTY_ERROR="20001";
	public static final String GAME_NAME_IS_EMPTY_ERROR_MSG="游戏名不能为空";
	
	public static final String GAME_INTR_IS_EMPTY_ERROR="20002";
	public static final String GAME_INTR_IS_EMPTY_ERROR_MSG="游戏简介不能为空";
	
	public static final String GAME_TYPE_IS_EMPTY_ERROR="20003";
	public static final String GAME_TYPE_IS_EMPTY_ERROR_MSG="游戏类型不能为空";
	
	public static final String GAME_MILLSPRICE_IS_MINUS_ERROR="20004";
	public static final String GAME_MILLSPRICE_IS_MINUS_ERROR_MSG="游戏话费价格不能为空";
	
	public static final String GAME_BEANSPRICE_IS_MINUS_ERROR="20005";
	public static final String GAME_BEANSPRICE_IS_MINUS_ERROR_MSG="游戏乐豆价格不能为空";
	
	/***************************游戏异常    结束**********************************/
	
	
	
	
	
	
	/***************************游戏类型异常     开始**********************************/
	public static final String GAMETYPE_NAME_IS_EMPTY_ERROR="30001";
	public static final String GAMETYPE_NAME_IS_EMPTY_ERROR_MSG="游戏类型名不能为空";
	/***************************游戏类型异常     开始**********************************/
	
	/***************************游戏下载异常     开始**********************************/
	public static final String PHONEMONEY_IS_NOT_ENOUGH_ERROR="40001";
	public static final String PHONEMONEY_IS_NOT_ENOUGH_ERROR_MSG="话费不足";
	
	public static final String LEDOUMONEY_IS_NOT_ENOUGH_ERROR="40002";
	public static final String LEDOUMONEY_IS_NOT_ENOUGH_ERROR_MSG="乐豆不足";
	
	public static final String TRADE_IS_EXIST="40003";
	public static final String TRADE_IS_EXIST_MSG="该游戏已经下载过";
	
	/***************************游戏下载异常     开始**********************************/
	

}
