package com.njwangbo.ledou.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.njwangbo.ledou.dao.GameTypeDao;
import com.njwangbo.ledou.entity.GameType;
import com.njwangbo.ledou.util.JdbcTemplate;

public class GameTypeDaoImpl implements GameTypeDao{
	/**
	 * 添加新类型
	 */
	@Override
	public void add(GameType gameType) throws SQLException {
		String sql = "insert into t_gameType (t_type,t_createTime) values( ?,now())";
		try {
			int count = JdbcTemplate.executeUpdate(sql, gameType.getGameType());
			if(count>0){
				System.out.println("添加成功");
			}else{
				System.out.println("添加失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 	
	 * 修改游戏类型
	 *
	 */
	@Override
	public void updateGameType(GameType gameType,int id) throws SQLException {
		String sql = "update t_gameType set t_type = ? , t_createTime = now()  where t_id  = ?";
		try {
			int count = JdbcTemplate.executeUpdate(sql,gameType.getGameType(),id);
			if(count>0){
				System.out.println("修改成功");
			}else{
				System.out.println("修改失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 查询所有游戏类型
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<GameType> selectAllGameType() throws SQLException {
		String sql = "select t_id ,t_type ,t_createTime from t_gameType";
		List<GameType> gameTypeList = null;
		try {
			gameTypeList = JdbcTemplate.executeQuery(sql, new GameTypeMapper(), new Object[]{} );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gameTypeList;
		
	}
	
	
	/**
	 * 根据游戏类型编号返回一个游戏类型对象
	 */
	@SuppressWarnings("unchecked")
	@Override
	public GameType selectGameType(int id) throws SQLException {
		GameType gameType = null;
		String sql = "select t_id ,t_type , t_createTime from t_gameType where t_id = ?";
		try {
			List<GameType> gameTypeList = JdbcTemplate.executeQuery(sql, new GameTypeMapper(), id);
			if(gameTypeList.size() > 0){
				gameType = gameTypeList.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return gameType;
	}
	

}
