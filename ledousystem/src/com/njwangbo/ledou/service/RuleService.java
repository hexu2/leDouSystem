package com.njwangbo.ledou.service;

import com.njwangbo.ledou.entity.ChangeRule;
import com.njwangbo.ledou.exception.LeDouException;
/**
 * 兑换比例事务层接口
 * @author soft01
 *
 */
public interface RuleService {
	/**
	 * 察看比例
	 * @throws LeDouException
	 */
	ChangeRule selectRule() ;
	
	/**
	 * 修改比例
	 * @throws LeDouException
	 */
	void updateRule(int ratio)  ;

}
