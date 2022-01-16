package com.njwangbo.ledou.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.njwangbo.ledou.dao.LeDouUserDao;
import com.njwangbo.ledou.entity.ChangeRule;
import com.njwangbo.ledou.entity.Game;
import com.njwangbo.ledou.entity.LeDouUser;
import com.njwangbo.ledou.entity.PhoneUser;
import com.njwangbo.ledou.entity.Trade;
import com.njwangbo.ledou.util.JdbcTemplate;

public class LeDouUserDaoImpl implements LeDouUserDao{
	
	/**
	 * 添加乐豆用户
	 * @throws SQLException 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void add(LeDouUser leDouUser) throws SQLException {
		String sql="select t_phoneNo,t_userName,t_sex,t_address,t_phoneMony,t_time from t_phoneUser where t_phoneNo=?";
		List<PhoneUser> phoneUserList =JdbcTemplate.executeQuery(sql, new PhoneUserMapper(),leDouUser.getPhoneNum());
		PhoneUser phoneUser=phoneUserList.get(0);
		String sql2 = "insert into t_leDouUser(t_phoneNo ,t_pwd,t_phoneMony,t_leDouMony,t_registTime) values(?,?,?,?,now())" ;
		int count = JdbcTemplate.executeUpdate(sql2, leDouUser.getPhoneNum(),leDouUser.getPwd(),phoneUser.getPhoneMoney(),leDouUser.getLeDouMoney()) ;
		if(count > 0){
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
	}
	
	/**
	 * 注册时查询手机号码是否已存在乐豆用户表中
	 * 存在返回true，不存在返回false
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean queryByPhoneNum(String phoneNum) throws SQLException {
		boolean result = false;
		String sql = "select t_phoneNo,t_pwd,t_phoneMony,t_leDouMony,t_registTime from t_leDouUser where t_phoneNo = ?;";
		List<PhoneUser> phoneUserList = JdbcTemplate.executeQuery(sql, new LeDouUserMapper(), phoneNum);
		if(phoneUserList.size()>0){
			result = true;
		}
		return result;
	}
	
	/**
	 * 注册时验证手机号是否是移动用户
	 * 是移动用户返回具体的phoneUser，否则返回null
	 * @param phoneNum
	 * @return phoneUser   
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PhoneUser queryByPhoneUser(String phoneNum) throws SQLException {
		PhoneUser phoneUser = null;
		String sql = " select t_phoneNo,t_userName,t_sex,t_address,t_phoneMony,t_time from t_phoneUser where t_phoneNo = ? ";
		List<PhoneUser> phoneUserList = JdbcTemplate.executeQuery(sql, new PhoneUserMapper(), phoneNum);
		if(phoneUserList.size() > 0 ){
			phoneUser = phoneUserList.get(0);
		}
		return phoneUser;
	}
	/**
	 * 根据手机号和密码从乐豆表中返回用户
	 */
	@SuppressWarnings("unchecked")
	@Override
	public LeDouUser queryByPhoneNumAndPwd(String phoneNum, String pwd) throws SQLException {
		LeDouUser douUser = null;
		String sql = "select t_phoneNo,t_pwd,t_phoneMony,t_leDouMony,t_registTime from t_leDouUser where t_phoneNo = ? and t_pwd = ?";
		List<LeDouUser> douList= JdbcTemplate.executeQuery(sql, new LeDouUserMapper(), phoneNum,pwd);
		if(douList.size() > 0){
			douUser = douList.get(0);
		}
		return douUser;
	}
	
	/**
	 * 向手机表中插入用户
	 */
	@Override
	public void insertPoneUser(PhoneUser user) throws SQLException {
		String sql = "insert into t_phoneUser (t_phoneNo,t_userName,t_sex,t_address,t_phoneMony,t_time) values(?,?,?,?,?,?)";
		JdbcTemplate.executeUpdate(sql,user.getPhoneNum(),user.getUserName(),user.getUserSex(),user.getAddress(),user.getPhoneMoney(),user.getTime());
		
	}
	public LeDouUserDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 察看乐豆用户信息
	 */
	@Override
	public LeDouUser queryInfo(String phoneNum) throws SQLException {
		LeDouUser douUser = null;
		String sql="select t_phoneNo,t_pwd,t_phoneMony,t_leDouMony,t_registTime from t_leDouUser where t_phoneNo = ?";
		List<LeDouUser> userList=JdbcTemplate.executeQuery(sql,new LeDouUserMapper(), phoneNum);
		if(userList.size()>0){
			douUser=userList.get(0);
		}
		return douUser;
	}

	/**
	 * 更新乐豆账户信息
	 */
	@Override
	public void updateInfo(LeDouUser leDouUser,Trade trade) throws SQLException {
		leDouUser.setPhoneMoney(leDouUser.getPhoneMoney() - trade.getMoney());//扣话费
		leDouUser.setLeDouMoney(leDouUser.getLeDouMoney() + trade.getAddLedou());//加乐豆
		String sql = "update t_leDouUser set t_phoneMony = ?,t_leDouMony = ? where t_phoneNo = ?";
		JdbcTemplate.executeUpdate(sql, leDouUser.getPhoneMoney(),leDouUser.getLeDouMoney(),leDouUser.getPhoneNum());
		
	}
	


}
