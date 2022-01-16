package com.njwangbo.ledou.entity;

import java.sql.Date;

/**
 * 游戏实体
 * @author soft01
 *
 */
public class Game {
	/**
	 * 游戏编号
	 */
	private int id;
	/**
	 * 游戏名
	 */
	private String gameName;
	/**
	 * 游戏简介
	 */
	private String gameInfo;
	/**
	 * 游戏类型
	 */
	private String gameType;
	/**
	 * 花费价格
	 */
	private double phonePrice;
	/**
	 * 乐豆价格
	 */
	private double ledouPrice;
	/**
	 * 添加时间
	 */
	private Date time;
	public Game() {
		super();
	}
	public Game(int id, String gameName, String gameInfo, String gameType,
			double phonePrice, double ledouPrice, Date time) {
		super();
		this.id = id;
		this.gameName = gameName;
		this.gameInfo = gameInfo;
		this.gameType = gameType;
		this.phonePrice = phonePrice;
		this.ledouPrice = ledouPrice;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getGameInfo() {
		return gameInfo;
	}
	public void setGameInfo(String gameInfo) {
		this.gameInfo = gameInfo;
	}
	public String getGameType() {
		return gameType;
	}
	public void setGameType(String string) {
		this.gameType = string;
	}
	public double getPhonePrice() {
		return phonePrice;
	}
	public void setPhonePrice(double phonePrice) {
		this.phonePrice = phonePrice;
	}
	public double getLedouPrice() {
		return ledouPrice;
	}
	public void setLedouPrice(double ledouPrice) {
		this.ledouPrice = ledouPrice;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	

}
