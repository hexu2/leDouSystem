package com.njwangbo.ledou.entity;

import java.util.Date;


/**
 * 游戏类型实体
 * @author soft01
 *
 */
public class GameType {
	/**
	 * 类型码
	 */
	private int id;
	/**
	 * 游戏类型
	 */
	private String gameType;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	

	public GameType() {
		super();
	}



	public GameType(int id, String gameType, Date createTime) {
		super();
		this.id = id;
		this.gameType = gameType;
		this.createTime = createTime;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getGameType() {
		return gameType;
	}



	public void setGameType(String gameType) {
		this.gameType = gameType;
	}



	public Date getCreateTime() {
		return createTime;
	}



	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	

}
