package com.njwangbo.ledou.service.impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.njwangbo.ledou.dao.LeDouUserDao;
import com.njwangbo.ledou.dao.TradeDao;
import com.njwangbo.ledou.dao.impl.LeDouUserDaoImpl;
import com.njwangbo.ledou.dao.impl.TradeDaoImpl;
import com.njwangbo.ledou.dao.impl.TradeMapper;
import com.njwangbo.ledou.entity.ChangeRule;
import com.njwangbo.ledou.entity.Game;
import com.njwangbo.ledou.entity.LeDouUser;
import com.njwangbo.ledou.entity.Trade;
import com.njwangbo.ledou.exception.ErrorCode;
import com.njwangbo.ledou.exception.LeDouException;
import com.njwangbo.ledou.service.TradeService;
import com.njwangbo.ledou.transaction.Transaction;
import com.njwangbo.ledou.transaction.impl.TransactionImpl;
import com.njwangbo.ledou.util.JdbcTemplate;

/**
 * 
 * @author soft01
 *
 */
public class TradeServiceImpl implements TradeService{
	private TradeDao tradeDao = new TradeDaoImpl(); 
	private LeDouUserDao douUserDao = new LeDouUserDaoImpl();
	private Transaction tx = new TransactionImpl();

	/**
	 * 查询历史账单
	 */
	@Override
	public List<Trade> queryHistory(String phoneNum) throws LeDouException {
		//基础数据校验
		
		List<Trade> tradeList = null;
		try {
			tradeList = tradeDao.equryHistoryTrade(phoneNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tradeList;
	}

	/**
	 * 更新乐豆账户信息并添加账单
	 */
	@Override
	public void addTradeAndUpdateDouUser(LeDouUser leDouUser, Trade trade)throws LeDouException {
		//基础校验
		if("话费支付".equals(trade.getPayType()) && ( leDouUser.getPhoneMoney() < trade.getMoney() ) ){//话费是否够
			throw new LeDouException(ErrorCode.PHONEMONEY_IS_NOT_ENOUGH_ERROR, ErrorCode.PHONEMONEY_IS_NOT_ENOUGH_ERROR_MSG);
		}
		if("乐豆支付".equals(trade.getPayType()) && leDouUser.getLeDouMoney() < trade.getLedou()){//乐豆是否够
			throw new LeDouException(ErrorCode.LEDOUMONEY_IS_NOT_ENOUGH_ERROR, ErrorCode.LEDOUMONEY_IS_NOT_ENOUGH_ERROR_MSG);
		}

		try {
			tx.begin();
			douUserDao.updateInfo(leDouUser,trade);//更新用户信息
			tradeDao.addTrade(trade);//添加交易记录
			tx.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			tx.rollback();
		}

		
	}
	
	
	/**
	 * 更新乐豆账户信息并添加账单
	 */
	/*@Override
	public void add(ChangeRule changeRule, Game game, LeDouUser leDouUser,Trade trade) throws LeDouException {
		//基础校验
		if("话费支付".equals(trade.getPayType()) && ( leDouUser.getPhoneMoney() < game.getPhonePrice() ) ){//话费是否够
			throw new LeDouException(ErrorCode.PHONEMONEY_IS_NOT_ENOUGH_ERROR, ErrorCode.PHONEMONEY_IS_NOT_ENOUGH_ERROR_MSG);
		}
		if("乐豆支付".equals(trade.getPayType()) && leDouUser.getLeDouMoney() < game.getLedouPrice()){//乐豆是否够
			throw new LeDouException(ErrorCode.LEDOUMONEY_IS_NOT_ENOUGH_ERROR, ErrorCode.LEDOUMONEY_IS_NOT_ENOUGH_ERROR_MSG);
		}
		try {
			//遍历交易记录表
			List<Trade> tradeList = tradeDao.equryHistoryTrade(leDouUser.getPhoneNum());
			Iterator<Trade> it = tradeList.iterator();
			while(it.hasNext()){
				Trade tradeFdb = it.next();
				if(tradeFdb.equals(trade)){//该游戏已经存在
					throw new LeDouException(ErrorCode.TRADE_IS_EXIST, ErrorCode.TRADE_IS_EXIST_MSG);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			douUserDao.add(leDouUser);//
		} catch (SQLException e) {
			e.printStackTrace();
		}*/

	
	

	

}
