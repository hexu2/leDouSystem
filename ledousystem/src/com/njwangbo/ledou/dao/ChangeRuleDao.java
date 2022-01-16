package com.njwangbo.ledou.dao;

import java.sql.SQLException;

import com.njwangbo.ledou.entity.ChangeRule;

/**
 * 乐豆兑换规则数据操作层接口
 * @author soft01
 *
 */
public interface ChangeRuleDao {
	/**
	 * 修改乐豆兑换规则
	 * @param rule
	 * @throws SQLException
	 */
	void updateRule(ChangeRule rule) throws SQLException ;
	/**
	 * 察看兑换比例
	 * @param rule
	 * @return
	 * @throws SQLException
	 */
	ChangeRule selectRule() throws SQLException;
	

}
