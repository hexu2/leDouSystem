package com.njwangbo.ledou.dao;

import java.sql.SQLException;

import com.njwangbo.ledou.entity.ChangeRule;
import com.njwangbo.ledou.entity.Game;
import com.njwangbo.ledou.entity.LeDouUser;
import com.njwangbo.ledou.entity.PhoneUser;
import com.njwangbo.ledou.entity.Trade;

public interface LeDouUserDao {
	/**
	 * 添加用户
	 * @param phoneUser
	 */
	void add(LeDouUser leDouUser) throws SQLException;
	 
	/**
	 * 判断号码是否存在
	 * @param phoneNum
	 * @return
	 * @throws SQLException
	 */
	boolean queryByPhoneNum(String phoneNum) throws SQLException;
	
	/**
	 * 查询是否在移动表中
	 * @param phoneNum
	 * @return  该手机号用户
	 * @throws SQLException
	 */
	PhoneUser queryByPhoneUser(String phoneNum) throws SQLException;


	/**
	 * 从cmmcc.txt插入手机用户
	 * @param phoneUser
	 * @throws SQLException
	 */
	void insertPoneUser(PhoneUser phoneUser) throws SQLException;
	/**
	 * 根据手机号和密码登陆
	 * @param phoneNum
	 * @param pwd
	 * @return
	 * @throws SQLException
	 */
	LeDouUser queryByPhoneNumAndPwd(String phoneNum,String pwd) throws SQLException;
	
	/**
	 * 查看账户信息
	 */
	LeDouUser queryInfo(String phoneNum) throws SQLException;
	
	/**
	 * 更新账户信息
	 */
	void updateInfo (LeDouUser leDouUser,Trade trade)throws SQLException;
	
	
}
