package com.njwangbo.ledou.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.njwangbo.ledou.dao.ChangeRuleDao;
import com.njwangbo.ledou.entity.ChangeRule;
import com.njwangbo.ledou.util.JdbcTemplate;


/**
 * 兑换比例数据操作实现类
 * @author soft01
 *
 */
public class ChangeRuleDaoImpl implements ChangeRuleDao{


	/**
	 * 修改兑换比例
	 * @throws SQLException 
	 */
	@Override
	public void updateRule(ChangeRule rule) throws SQLException {
		String sql = "update t_changeMethod set t_bili = ?;";
		@SuppressWarnings("unused")
		int count = JdbcTemplate.executeUpdate(sql, rule.getRatio());
		
	}

	
	/**
	 * 察看比例
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ChangeRule selectRule() throws SQLException {
		ChangeRule changeRule = null;
		String sql = "select t_bili from t_changeMethod";
		List<ChangeRule> ruleList = JdbcTemplate.executeQuery(sql, new ChangeRuleMapper(), new Object[]{});
		if(ruleList.size() > 0){
			changeRule = ruleList.get(0);
		}
		return changeRule;
	}

}
