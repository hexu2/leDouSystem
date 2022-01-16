package com.njwangbo.ledou.entity;

/**
 * 兑换规则实体类
 * 
 * @author soft01
 * 
 */
public class ChangeRule {
	/**
	 * 话费兑换乐豆比例
	 */
	private int ratio;

	/**
	 * 无参构造
	 */
	public ChangeRule() {
		super();
	}


	public ChangeRule(int ratio) {
		super();
		this.ratio = ratio;
	}


	public int getInfo() {
		return this.ratio;
	}


	public int getRatio() {
		return ratio;
	}

	public void setRatio(int ratio) {
		this.ratio = ratio;
	}

}
