package com.njwangbo.ledou.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.njwangbo.ledou.entity.GameType;
import com.njwangbo.ledou.util.RowMapper;

public class GameTypeMapper implements RowMapper{
	@Override
	public Object mapperObject(ResultSet rs) throws SQLException {
		GameType gameType = new GameType();
		gameType.setId(rs.getInt("t_id"));
		gameType.setGameType(rs.getString("t_type"));
		gameType.setCreateTime(rs.getDate("t_createTime"));
		return gameType;
	} 

}
