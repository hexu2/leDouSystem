package com.njwangbo.ledou.entity;

import java.util.Date;
/**
 * 手机用户实体
 * @author soft01
 *
 */
public class PhoneUser {
	/**
	 * 手机号码
	 */
	private String phoneNum;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 用户性别
	 */
	private String userSex;
	/**
	 * 用户家庭住址
	 */
	private String address;
	/**
	 * 话费
	 */
	private double phoneMoney;
	/**
	 * 注册时间
	 */
	private Date time;

	public PhoneUser() {
		super();
	}

	@Override
	public String toString() {
		return "PhoneUser [address=" + address + ", phoneMoney=" + phoneMoney
				+ ", phoneNum=" + phoneNum + ", time=" + time + ", userName="
				+ userName + ", userSex=" + userSex + "]";
	}

	public PhoneUser(String phoneNum, String userName, String userSex,
			String address, double phoneMoney, Date time) {
		super();
		this.phoneNum = phoneNum;
		this.userName = userName;
		this.userSex = userSex;
		this.address = address;
		this.phoneMoney = phoneMoney;
		this.time = time;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getPhoneMoney() {
		return phoneMoney;
	}

	public void setPhoneMoney(double phoneMoney) {
		this.phoneMoney = phoneMoney;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
