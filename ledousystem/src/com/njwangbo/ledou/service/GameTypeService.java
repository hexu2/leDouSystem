package com.njwangbo.ledou.service;

import java.util.List;

import com.njwangbo.ledou.entity.Game;
import com.njwangbo.ledou.entity.GameType;
import com.njwangbo.ledou.exception.LeDouException;

public interface GameTypeService {


	/**
	 * 添加游戏类型
	 * 
	 * @param game
	 */
	void addGameType(GameType gameType) throws LeDouException;


	/**
	 * 修改游戏类型
	 * 
	 * @param no
	 */
	void upDateGameType(GameType gameType, int no) throws LeDouException;

	/**
	 * 查询游戏类型
	 * 
	 * @return
	 */
	List<GameType> selectAllGameType();

	/**
	 * 查询游戏类型（单个）
	 * 
	 * @param typeId
	 * @return
	 */
	GameType selectGameType(int id);
}
