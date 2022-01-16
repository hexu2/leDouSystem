package com.njwangbo.ledou.dao;

import java.sql.SQLException;

import com.njwangbo.ledou.entity.Game;

/**
 * 游戏数据操作接口
 * @author soft01
 *
 */
public interface GameDao {

	/**
	 * 增添游戏
	 */
	void addGame(Game game) throws SQLException;
	/**
	 * 删除游戏,更据编号
	 */
	void deleteGame(int id) throws SQLException;
	/**
	 * 修改游戏
	 * @param game
	 * @param no
	 * @throws SQLException
	 */
	void updateGame(Game game,int no) throws SQLException;
	/**
	 * 根据id查询单个游戏
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	Game selectGame(int id) throws SQLException;
	/**
	 * 查询所有游戏
	 * @throws SQLException
	 */
	void selectAllGame() throws SQLException;
	
	
	
	
}
