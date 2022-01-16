package com.njwangbo.ledou.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.njwangbo.ledou.dao.GameTypeDao;
import com.njwangbo.ledou.dao.impl.GameTypeDaoImpl;
import com.njwangbo.ledou.entity.GameType;
import com.njwangbo.ledou.exception.ErrorCode;
import com.njwangbo.ledou.exception.LeDouException;
import com.njwangbo.ledou.service.GameTypeService;
import com.njwangbo.ledou.transaction.Transaction;
import com.njwangbo.ledou.transaction.impl.TransactionImpl;
import com.njwangbo.ledou.util.StringUtil;

public class GameTypeServiceImpl implements GameTypeService{
	private GameTypeDao gameTypeDao = new GameTypeDaoImpl();
	private Transaction tx = new TransactionImpl();
	/**
	 * 添加游戏类型
	 */
	@Override
	public void addGameType(GameType gameType) throws LeDouException {
		//基础数据校验
		if(StringUtil.isEmpty(gameType.getGameType())){//验证游戏类型是否为空
			throw new LeDouException(ErrorCode.GAMETYPE_NAME_IS_EMPTY_ERROR, ErrorCode.GAMETYPE_NAME_IS_EMPTY_ERROR_MSG);
		}
		try {
			tx.begin();
			gameTypeDao.add(gameType);
			tx.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			tx.rollback();
		}
		
	}

	
	/**
	 * 查询所有游戏类型
	 */
	@Override
	public List<GameType> selectAllGameType() {
		List<GameType> gameTypeList = null;
		try {
			tx.begin();
			gameTypeList = gameTypeDao.selectAllGameType();
			tx.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			tx.rollback();
		}
		return gameTypeList;
	}
	/**
	 * 查询游戏类别，根据id
	 */
	@Override
	public GameType selectGameType(int id) {
		GameType gameType = null;
		try {
			tx.begin();
			gameType = gameTypeDao.selectGameType(id);
			tx.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			tx.rollback();
			
		}
		return gameType;
	}
	/**
	 * 修改游戏类型
	 */
	@Override
	public void upDateGameType(GameType gameType, int no) throws LeDouException {
		//基础数据校验
		if(StringUtil.isEmpty(gameType.getGameType())){//验证游戏类型是否为空
			throw new LeDouException(ErrorCode.GAMETYPE_NAME_IS_EMPTY_ERROR, ErrorCode.GAMETYPE_NAME_IS_EMPTY_ERROR_MSG);
		}
		
		try {
			tx.begin();
			gameTypeDao.updateGameType(gameType, no);
			tx.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			tx.rollback();
		}
	}



}
