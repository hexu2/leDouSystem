package com.njwangbo.ledou.dao.impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.njwangbo.ledou.dao.TradeDao;
import com.njwangbo.ledou.entity.Game;
import com.njwangbo.ledou.entity.LeDouUser;
import com.njwangbo.ledou.entity.Trade;
import com.njwangbo.ledou.exception.LeDouException;
import com.njwangbo.ledou.util.JdbcTemplate;

public class TradeDaoImpl implements TradeDao {

	/**
	 * 查看历史账单
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Trade> equryHistoryTrade(String phoneNum) throws SQLException {
		List<Trade> tradeList;
		String sql = "select t_id,t_phoneNo,t_gameName,t_payType,t_money,t_ledou,t_addLedou,t_downLoadTime from t_trade where t_phoneNo = ?";
		tradeList = JdbcTemplate.executeQuery(sql, new TradeMapper(), phoneNum);
		return tradeList;

	}

	/**
	 * 添加交易记录
	 */
	@Override
	public void addTrade(Trade trade) throws SQLException {
		String sql = "insert into t_trade( t_phoneNo,t_gameName,t_payType,t_money,t_ledou,t_addLedou,t_downLoadTime ) values(?,?,?,?,?,?,now())";
		JdbcTemplate.executeUpdate(sql, trade.getPhoneNum(),trade.getGameName(),trade.getPayType(),trade.getMoney(),trade.getLedou(),trade.getAddLedou());
		
	}

	
	



}
