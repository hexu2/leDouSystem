package com.njwangbo.ledou.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.njwangbo.ledou.entity.PhoneUser;
import com.njwangbo.ledou.util.RowMapper;

/**
 * 手机用户对象映射器
 * @author Administrator
 *
 */
public class PhoneUserMapper implements RowMapper{

	@Override
	public Object mapperObject(ResultSet rs) throws SQLException {
		PhoneUser user = new PhoneUser();
		user.setPhoneNum(rs.getString("t_phoneNo"));
		user.setUserName(rs.getString("t_userName"));
		user.setUserSex(rs.getString("t_sex"));
		user.setAddress(rs.getString("t_address"));
		user.setPhoneMoney(rs.getDouble("t_phoneMony"));
		user.setTime(rs.getDate("t_time"));
		return user;
	}
	

}
