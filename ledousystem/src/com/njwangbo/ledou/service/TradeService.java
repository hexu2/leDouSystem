package com.njwangbo.ledou.service;

import java.util.List;

import com.njwangbo.ledou.entity.ChangeRule;
import com.njwangbo.ledou.entity.Game;
import com.njwangbo.ledou.entity.LeDouUser;
import com.njwangbo.ledou.entity.Trade;
import com.njwangbo.ledou.exception.LeDouException;

/**
 * 账单务事务层接口
 * @author soft01
 *
 */
public interface TradeService {

	/**
	 * 查询历史账单
	 * @return
	 * @throws LeDouException
	 */
	List<Trade> queryHistory(String phoneNum) throws LeDouException;
	
	
	/**
	 * 更新账户并添加账单
	 * 
	 * @param trade
	 * @throws LeException
	 */
	void addTradeAndUpdateDouUser(LeDouUser leDouUser, Trade trade) throws LeDouException;
}
