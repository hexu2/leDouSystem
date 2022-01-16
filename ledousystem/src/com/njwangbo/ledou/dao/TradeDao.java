package com.njwangbo.ledou.dao;

import java.sql.SQLException;
import java.util.List;

import com.njwangbo.ledou.entity.Game;
import com.njwangbo.ledou.entity.LeDouUser;
import com.njwangbo.ledou.entity.Trade;
import com.njwangbo.ledou.exception.LeDouException;

/**
 * 对账单数据的操作
 * @author Administrator
 *
 */
public interface TradeDao {
	/**
	 * 查询历史账单
	 * @throws LeDouException
	 */
	List<Trade> equryHistoryTrade(String phoneNum) throws SQLException;
	
	
	/**
	 * 添加消费记录
	 */
	void addTrade(Trade trade)throws SQLException;

}
