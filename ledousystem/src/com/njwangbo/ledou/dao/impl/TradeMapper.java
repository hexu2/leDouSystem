package com.njwangbo.ledou.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.njwangbo.ledou.entity.Trade;
import com.njwangbo.ledou.util.RowMapper;

public class TradeMapper implements RowMapper{

	@Override
	public Object mapperObject(ResultSet rs) throws SQLException {
		Trade trade = new Trade();
		trade.setGameName(rs.getString("t_gameName"));
		trade.setPhoneNum(rs.getString("t_phoneNo"));
		trade.setPayType(rs.getString("t_payType"));
		trade.setMoney(Double.valueOf(rs.getString("t_money")));
		trade.setLedou(Double.valueOf(rs.getString("t_ledou")));
		trade.setAddLedou(Double.valueOf(rs.getString("t_addLedou")));
		trade.setTadeTime(rs.getDate("t_downLoadTime"));
		
		return trade;
	}

}
