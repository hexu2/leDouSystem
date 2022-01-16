package com.njwangbo.ledou.service;

import com.njwangbo.ledou.entity.Game;
import com.njwangbo.ledou.exception.LeDouException;


/**
 * 游戏
 * @author soft01
 *
 */
public interface GameService {

		/**
		 * 添加游戏
		 * 
		 * @param game
		 */
		void addGame(Game game) throws LeDouException;

		/**
		 * 删除游戏
		 * 
		 * @param no
		 */
		void deleteGame(int no)  throws LeDouException;

		/**
		 * 修改游戏
		 * 
		 * @param no
		 */
		void upDateGame(Game game, int no) throws LeDouException;

		/**
		 * 查询游戏
		 * 
		 * @return
		 */
		void selectAllGame();

		/**
		 * 查询游戏（单个）
		 * 
		 * @param typeId
		 * @return
		 */
		Game selectGame(int id);
		
		
	

}
