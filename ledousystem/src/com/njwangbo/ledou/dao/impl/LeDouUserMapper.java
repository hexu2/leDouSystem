package com.njwangbo.ledou.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.njwangbo.ledou.entity.LeDouUser;
import com.njwangbo.ledou.util.RowMapper;

public class LeDouUserMapper implements RowMapper{
	/**
	 * 乐豆用户对象映射器
	 */
	@Override
	public Object mapperObject(ResultSet rs) throws SQLException {
		LeDouUser douUser = new LeDouUser();
		douUser.setPhoneNum(rs.getString("t_phoneNo"));
		douUser.setPwd(rs.getString("t_pwd"));
		douUser.setPhoneMoney(rs.getDouble("t_phoneMony"));
		douUser.setLeDouMoney(rs.getDouble("t_leDouMony"));
		douUser.setRegistTime(rs.getDate("t_registTime"));
		return douUser;
	}

}
