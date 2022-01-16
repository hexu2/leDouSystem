package com.njwangbo.ledou.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.njwangbo.ledou.entity.Game;
import com.njwangbo.ledou.util.RowMapper;

public class GameMapper implements RowMapper{
	
	@Override
	public Object mapperObject(ResultSet rs) throws SQLException {
		Game game = new Game();
		
		game.setId(rs.getInt("t_id"));
		game.setGameName(rs.getString("t_gameName"));
		game.setGameInfo(rs.getString("t_gameInfo"));
		game.setGameType(rs.getString("t_type"));
		game.setPhonePrice(rs.getDouble("t_phonePrice"));
		game.setLedouPrice(rs.getDouble("t_ledouPrice"));
		game.setTime(rs.getDate("t_createTime"));
		
		return game;
	}

}
