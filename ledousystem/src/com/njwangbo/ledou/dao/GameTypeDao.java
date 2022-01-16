package com.njwangbo.ledou.dao;

import java.sql.SQLException;
import java.util.List;

import com.njwangbo.ledou.entity.Game;
import com.njwangbo.ledou.entity.GameType;
import com.njwangbo.ledou.exception.LeDouException;

/**
 * 对游戏类型数据操作
 * @author soft01
 *
 */
public interface GameTypeDao {
	/**
	 * 添加新类型
	 * @param type
	 * @throws LeDouException
	 */
	void add(GameType type) throws SQLException;
	/**
	 * 修改游戏类型
	 * @param id
	 * @throws LeDouException
	 */
	void updateGameType(GameType gameType ,int id) throws SQLException;
	/**
	 * 根据游戏类型编号返回一个游戏类型对象
	 * @param id
	 * @return
	 * @throws LeDouException
	 */
	GameType selectGameType(int id) throws SQLException;
	
	/**
	 * 查询所有游戏类型
	 * @throws SQLException
	 */
	List<GameType> selectAllGameType() throws SQLException;

}
