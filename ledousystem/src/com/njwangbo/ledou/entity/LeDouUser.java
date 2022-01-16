package com.njwangbo.ledou.entity;

import java.util.Date;

/**
 * 乐豆用户表
 * @author Administrator
 *
 */
public class LeDouUser {
	/**
	 * 用户电话号码
	 */
	private String phoneNum;
	/**
	 * 用户密码
	 */
	private String pwd;
	/**
	 * 话费余额
	 */
	private double phoneMoney;
	/**
	 * 乐豆余额
	 */
	private double leDouMoney;
	/**
	 * 注册时间
	 */
	private Date registTime;
	
	
	public LeDouUser() {
		super();
	}


	public LeDouUser(String phoneNum, String pwd, double phoneMoney,
			double leDouMoney, Date registTime) {
		super();
		this.phoneNum = phoneNum;
		this.pwd = pwd;
		this.phoneMoney = phoneMoney;
		this.leDouMoney = leDouMoney;
		this.registTime = registTime;
	}


	public String getPhoneNum() {
		return phoneNum;
	}


	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public double getPhoneMoney() {
		return phoneMoney;
	}


	public void setPhoneMoney(double phoneMoney) {
		this.phoneMoney = phoneMoney;
	}


	public double getLeDouMoney() {
		return leDouMoney;
	}


	public void setLeDouMoney(double leDouMoney) {
		this.leDouMoney = leDouMoney;
	}


	public Date getRegistTime() {
		return registTime;
	}


	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}
	
	
	
	


}
