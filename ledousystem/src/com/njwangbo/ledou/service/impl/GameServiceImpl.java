package com.njwangbo.ledou.service.impl;

import java.sql.SQLException;

import com.njwangbo.ledou.dao.GameDao;
import com.njwangbo.ledou.dao.impl.GameDaoImpl;
import com.njwangbo.ledou.entity.Game;
import com.njwangbo.ledou.exception.ErrorCode;
import com.njwangbo.ledou.exception.LeDouException;
import com.njwangbo.ledou.service.GameService;
import com.njwangbo.ledou.transaction.Transaction;
import com.njwangbo.ledou.transaction.impl.TransactionImpl;
import com.njwangbo.ledou.util.StringUtil;

public class GameServiceImpl implements GameService{
	private GameDao gameDao = new GameDaoImpl();
	private Transaction tx = new TransactionImpl();

	/**
	 * 添加游戏
	 */
	@Override
	public void addGame(Game game) throws LeDouException {
		//基础数据校验
		if(StringUtil.isEmpty(game.getGameName())){//验证游戏名是否为空
			throw new LeDouException(ErrorCode.GAME_NAME_IS_EMPTY_ERROR, ErrorCode.GAME_NAME_IS_EMPTY_ERROR_MSG);
		}
		if(StringUtil.isEmpty(game.getGameInfo())){//验证游戏简介是否为空
			throw new LeDouException(ErrorCode.GAME_NAME_IS_EMPTY_ERROR,ErrorCode.GAME_NAME_IS_EMPTY_ERROR_MSG);
		}
		if(StringUtil.isEmpty(String.valueOf(game.getLedouPrice()))){//验证游戏乐豆价格是否为空
			throw new LeDouException(ErrorCode.GAME_BEANSPRICE_IS_MINUS_ERROR,ErrorCode.GAME_BEANSPRICE_IS_MINUS_ERROR_MSG);
		}
		if(StringUtil.isEmpty(String.valueOf(game.getPhonePrice()))){//验证游戏话费价格是否为空
			throw new LeDouException(ErrorCode.GAME_MILLSPRICE_IS_MINUS_ERROR,ErrorCode.GAME_MILLSPRICE_IS_MINUS_ERROR_MSG);
		}
		
		try {
			tx.begin();
			gameDao.addGame(game);
			tx.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			tx.rollback();
		}
		
	}
	/**
	 * 删除游戏
	 */
	@Override
	public void deleteGame(int no) throws LeDouException {

		try {
			tx.begin();
			gameDao.deleteGame(no);
			tx.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	/**
	 * 查询所有游戏
	 */
	@Override
	public void selectAllGame() {
		try {
			gameDao.selectAllGame();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
    /**
     * 查询单个游戏
     */
	@Override
	public Game selectGame(int id) {
		Game game = null;
		try {
			game = gameDao.selectGame(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return game;
	}

	/**
	 * 修改游戏
	 */
	@Override
	public void upDateGame(Game game, int no) throws LeDouException {
		try {
			gameDao.selectGame(no);
			tx.begin();
			gameDao.updateGame(game, no);
			tx.commit();
		} catch (SQLException e1) {
			System.out.println("不存在用户编号为" + no +"的用户");
			tx.rollback();
		}
		
	}
	

}
