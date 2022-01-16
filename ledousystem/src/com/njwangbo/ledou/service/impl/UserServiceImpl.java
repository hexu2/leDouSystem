package com.njwangbo.ledou.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.njwangbo.ledou.dao.LeDouUserDao;
import com.njwangbo.ledou.dao.impl.LeDouUserDaoImpl;
import com.njwangbo.ledou.dao.impl.LeDouUserMapper;
import com.njwangbo.ledou.entity.LeDouUser;
import com.njwangbo.ledou.entity.PhoneUser;
import com.njwangbo.ledou.exception.ErrorCode;
import com.njwangbo.ledou.exception.LeDouException;
import com.njwangbo.ledou.service.UserService;
import com.njwangbo.ledou.transaction.Transaction;
import com.njwangbo.ledou.transaction.impl.TransactionImpl;
import com.njwangbo.ledou.util.DateUtil;
import com.njwangbo.ledou.util.JdbcTemplate;
import com.njwangbo.ledou.util.StringUtil;

public class UserServiceImpl implements UserService {
	private LeDouUserDao douUserDao = new LeDouUserDaoImpl();
	private Transaction tx = new TransactionImpl();

	/**
	 * 注册乐豆用户
	 */
	@Override
	public void regist(LeDouUser douUser) throws LeDouException {

		if (StringUtil.isEmpty(douUser.getPhoneNum())) {// 手机号空验证
			throw new LeDouException(ErrorCode.PHONENUM_IS_EMPTY_ERROR,
					ErrorCode.PHONENUM_IS_EMPTY_ERROR_MSG);
		}
		if (!douUser.getPhoneNum().matches("^[1][0-9]{10}")) {// 手机号格式验证
			throw new LeDouException(ErrorCode.PHONENUM_IS_INVALID_ERROR,
					ErrorCode.PHONENUM_IS_INVALID_ERROR_MSG);
		}
		if (StringUtil.isEmpty(douUser.getPwd())) {
			throw new LeDouException(ErrorCode.PWD_IS_EMPTY_ERROR,
					ErrorCode.PWD_IS_EMPTY_ERROR_MSG);
		}
		if (!douUser.getPwd().matches("[a-zA-Z0-9]{4,12}")) {
			throw new LeDouException(ErrorCode.PWD_IS_INVALID_ERROR,
					ErrorCode.PWD_IS_INVALID_ERROR_MSG);
		}

		try {
			boolean flag = (false == douUserDao.queryByPhoneNum(douUser.getPhoneNum()) && (null != douUserDao.queryByPhoneUser(douUser.getPhoneNum())));
			if (flag) {

				tx.begin();// 开始事务
				douUserDao.add(douUser);
				tx.commit();// 提交事务
			} else {
				throw new LeDouException(ErrorCode.PHONENUM_IS_EXIST_ERROR,
						ErrorCode.PHONENUM_IS_EXIST_ERROR_MSG);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			tx.rollback();// 回滚事务
		}

	}

	/**
	 * 根据用户名和密码从乐豆表返回一个用户
	 */
	@Override
	public LeDouUser login(String phoneNum, String pwd) throws LeDouException {
		LeDouUser douUser = null;
		// 基础验证
		if (StringUtil.isEmpty(phoneNum)) {
			throw new LeDouException(ErrorCode.PHONENUM_IS_EMPTY_ERROR,
					ErrorCode.PHONENUM_IS_EMPTY_ERROR_MSG);
		}
		if (StringUtil.isEmpty(pwd)) {
			throw new LeDouException(ErrorCode.PWD_IS_EMPTY_ERROR,
					ErrorCode.PWD_IS_EMPTY_ERROR_MSG);
		}
		// 用户名密码验证
		try {
			douUser = douUserDao.queryByPhoneNumAndPwd(phoneNum, pwd);
			
			if (null == douUser) {
				throw new LeDouException(ErrorCode.PHONENUM_IS_EXIST_ERROR,
						ErrorCode.PHONENUM_IS_EXIST_ERROR_MSG);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return douUser;
	}

	/**
	 * 根据号码从乐豆表中查询一个乐豆用户
	 */
	@Override
	public LeDouUser queryUser(String phoneNum) throws LeDouException {
		LeDouUser leDouUser = null;
		try {
			leDouUser = douUserDao.queryInfo(phoneNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return leDouUser;
	}

	/**
	 * 解析cmmcc.txt文件并存入PhoneUser用户表
	 */
	@Override
	public void importPhoneUser() throws LeDouException {

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File("cmcc.txt")));
			String str = br.readLine();
			String[] strs = null;
			while (null != str) {
				strs = str.split("\\|");
				PhoneUser phoneUser = new PhoneUser();
				phoneUser.setPhoneNum(strs[0]);
				phoneUser.setUserName(strs[1]);
				phoneUser.setUserSex(strs[2]);
				phoneUser.setAddress(strs[3]);
				phoneUser.setPhoneMoney(Double.valueOf(strs[4]));
				phoneUser.setTime(DateUtil.str2Date(strs[5], "yyyy-MM-dd"));
//				phoneUser.setTime(Date.valueOf(strs[5]));
				
				
				
//				tx.begin();// 开启事务
				douUserDao.insertPoneUser(phoneUser);
//				tx.commit();
				str = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
