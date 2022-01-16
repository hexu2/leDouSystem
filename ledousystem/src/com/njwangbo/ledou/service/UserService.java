package com.njwangbo.ledou.service;

import java.sql.SQLException;

import com.njwangbo.ledou.entity.ChangeRule;
import com.njwangbo.ledou.entity.Game;
import com.njwangbo.ledou.entity.LeDouUser;
import com.njwangbo.ledou.entity.Trade;
import com.njwangbo.ledou.exception.LeDouException;


/**
 * 乐豆用户事务处理接口
 * @author Administrator
 *
 */
public interface UserService {
	/**
	 * 注册
	 * 
	 * @param user
	 * @throws LeException
	 */
	void regist(LeDouUser douUser) throws LeDouException;

	/**
	 * 登陆
	 */
	LeDouUser login(String phoneNum, String pwd) throws LeDouException;

	/**
	 * 查询个人信息
	 */
	LeDouUser queryUser(String phoneNum)throws LeDouException;

	/**
	 * 解析cmcc.txt导入t_phoneUser表中
	 */
	void importPhoneUser() throws  LeDouException;

	


}
