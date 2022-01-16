package com.njwangbo.ledou.entity;

import java.util.Date;

/**
 * 账单实体类
 * 
 * @author Administrator
 * 
 */
public class Trade {
	/**
	 * 交易编号
	 */
	private int id;
	/**
	 * 手机号
	 */
	private String phoneNum;
	/**
	 * 游戏名
	 */
	private String gameName;
	/**
	 * 支付类型
	 */
	private String payType;
	/**
	 * 消耗的话费
	 */
	private double money;
	/**
	 * 消耗的乐豆价格
	 * 
	 */
	private double ledou;
	/**
	 * 增加乐豆数
	 */
	private double addLedou;

	/**
	 * 交易时间
	 */
	private Date tadeTime;

	public Trade() {
		super();
	}

	public double getAddLedou() {
		return addLedou;
	}

	public void setAddLedou(double addLedou) {
		this.addLedou = addLedou;
	}

	public Trade(int id, String phoneNum, String gameName, String payType,
			double money, double ledou, double addLedou, Date tadeTime) {
		super();
		this.id = id;
		this.phoneNum = phoneNum;
		this.gameName = gameName;
		this.payType = payType;
		this.money = money;
		this.ledou = ledou;
		this.addLedou = addLedou;
		this.tadeTime = tadeTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTadeTime() {
		return tadeTime;
	}

	public void setTadeTime(Date tadeTime) {
		this.tadeTime = tadeTime;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public double getLedou() {
		return ledou;
	}

	public void setLedou(double ledou) {
		this.ledou = ledou;
	}

}
