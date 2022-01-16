package com.njwangbo.ledou.dao.impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.njwangbo.ledou.dao.GameDao;
import com.njwangbo.ledou.entity.Game;
import com.njwangbo.ledou.util.JdbcTemplate;

public class GameDaoImpl implements GameDao {
	/**
	 * 添加游戏
	 */
	@Override
	public void addGame(Game game) throws SQLException {
		String sql = "insert into t_game(t_gameName,t_gameInfo,t_type,t_phonePrice,t_ledouPrice,t_createTime )values(?,?,?,?,?,now());";
		int count = JdbcTemplate.executeUpdate(sql, game.getGameName(), game
				.getGameInfo(), game.getGameType(), game.getPhonePrice(), game
				.getLedouPrice());
		if (count > 0) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
	}

	/**
	 * 删除游戏，根据id
	 */
	@Override
	public void deleteGame(int id) throws SQLException {
		String sql = "delete from t_game where t_id = ?";
		int count = JdbcTemplate.executeUpdate(sql, id);
		if (count > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}

	/**
	 * 修改游戏
	 */
	@Override
	public void updateGame(Game game, int id) throws SQLException {
		String sql = "update t_game set t_gameName =?,t_gameInfo = ?,t_type = ?,t_phonePrice = ?,t_ledouPrice = ?,t_createTime = now()  where t_id = ?";
		int count = JdbcTemplate.executeUpdate(sql, game.getGameName(), game
				.getGameInfo(), game.getGameType(), game.getPhonePrice(), game
				.getLedouPrice(), id);
		if (count > 0) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");
		}

	}

	/**
	 * 查询一个游戏，根据id
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Game selectGame(int id) throws SQLException {
		Game game = null;
		String sql = "select e1.t_id,e1.t_gameName,e1.t_gameInfo,e2.t_type,e1.t_phonePrice,e1.t_ledouPrice,e1.t_createTime from t_game e1 inner join t_gameType e2 on e1.t_type = e2.t_id and e1.t_id = ?";
		List<Game> gameList = JdbcTemplate.executeQuery(sql, new GameMapper(),
				id);
		if (gameList.size() > 0) {
			game = gameList.get(0);
		}
		return game;
	}

	/**
	 * 查询所有游戏
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void selectAllGame() throws SQLException {
		String sql = "select e1.t_id,e1.t_gameName,e1.t_gameInfo,e2.t_type,e1.t_phonePrice,e1.t_ledouPrice,e1.t_createTime from t_game e1 inner join t_gameType e2 on e1.t_type = e2.t_id";
		List<Game> gameList = JdbcTemplate.executeQuery(sql, new GameMapper(),
				new Object[] {});
		Iterator<Game> it = gameList.iterator();
		while (it.hasNext()) {
			Game game = it.next();
			System.out.println("\t\t" + game.getId() + "\t\t" + game.getGameName()
					+ "\t\t" + game.getGameInfo() + "\t\t" + game.getGameType() + "\t\t" + game.getPhonePrice()
					+ "\t\t" + game.getLedouPrice() + "\t\t" + game.getTime());
		}

	}

}
