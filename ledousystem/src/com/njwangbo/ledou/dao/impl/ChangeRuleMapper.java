package com.njwangbo.ledou.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.njwangbo.ledou.entity.ChangeRule;
import com.njwangbo.ledou.util.RowMapper;

/**
 * 兑换比例映射器
 * @author soft01
 *
 */
public class ChangeRuleMapper implements RowMapper{

	@Override
	public Object mapperObject(ResultSet rs) throws SQLException {
		ChangeRule rule = new ChangeRule();
		rule.setRatio(rs.getInt("t_biLi"));
		return rule;
	}

	
}
