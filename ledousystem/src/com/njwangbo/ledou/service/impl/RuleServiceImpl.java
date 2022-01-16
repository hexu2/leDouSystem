package com.njwangbo.ledou.service.impl;

import java.sql.SQLException;

import com.njwangbo.ledou.dao.ChangeRuleDao;
import com.njwangbo.ledou.dao.impl.ChangeRuleDaoImpl;
import com.njwangbo.ledou.entity.ChangeRule;
import com.njwangbo.ledou.exception.LeDouException;
import com.njwangbo.ledou.service.RuleService;
import com.njwangbo.ledou.transaction.Transaction;
import com.njwangbo.ledou.transaction.impl.TransactionImpl;
import com.njwangbo.ledou.util.StringUtil;

/**
 * 
 * @author soft01
 *
 */
public class RuleServiceImpl implements RuleService{

	private ChangeRuleDao ruleDao = new ChangeRuleDaoImpl();
	private Transaction tx = new TransactionImpl();
	/**
	 * 查看赠送比例
	 */
	@Override
	public ChangeRule selectRule() {
		ChangeRule changeRule = null;
		try {
			changeRule = ruleDao.selectRule();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return changeRule;
	}

	/**
	 * 修改兑换规则
	 */
	@Override
	public void updateRule(int ratio){
		//构造新的兑换比例对象
		ChangeRule changeRule = new ChangeRule();
		changeRule.setRatio(ratio);
		try {
			tx.begin();
			ruleDao.updateRule(changeRule);
			tx.commit();
			System.out.println("修改成功");
		} catch (SQLException e) {
			e.printStackTrace();
			tx.rollback();
		}
		
	}

}
