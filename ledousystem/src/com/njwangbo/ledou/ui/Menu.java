package com.njwangbo.ledou.ui;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.njwangbo.ledou.dao.GameTypeDao;
import com.njwangbo.ledou.dao.impl.GameTypeDaoImpl;
import com.njwangbo.ledou.entity.ChangeRule;
import com.njwangbo.ledou.entity.Game;
import com.njwangbo.ledou.entity.GameType;
import com.njwangbo.ledou.entity.LeDouUser;
import com.njwangbo.ledou.entity.Trade;
import com.njwangbo.ledou.exception.LeDouException;
import com.njwangbo.ledou.service.GameService;
import com.njwangbo.ledou.service.GameTypeService;
import com.njwangbo.ledou.service.RuleService;
import com.njwangbo.ledou.service.TradeService;
import com.njwangbo.ledou.service.UserService;
import com.njwangbo.ledou.service.impl.GameServiceImpl;
import com.njwangbo.ledou.service.impl.GameTypeServiceImpl;
import com.njwangbo.ledou.service.impl.RuleServiceImpl;
import com.njwangbo.ledou.service.impl.TradeServiceImpl;
import com.njwangbo.ledou.service.impl.UserServiceImpl;

/**
 * 用户表示层
 * 
 * @author soft01
 * 
 */
public class Menu {
	private UserService userService = new UserServiceImpl();
	private GameService gameService = new GameServiceImpl();
	private RuleService ruleService = new RuleServiceImpl();
	private TradeService tradeService = new TradeServiceImpl();
	private GameTypeService gameTypeService = new GameTypeServiceImpl();
	private LeDouUser douUser;

	/**
	 * 主界面
	 */
	public void showLoginAndRegist() {
		System.out.println("\t\t欢迎使用乐豆游戏系统\n");
		System.out.println("\t1.注册\n");
		System.out.println("\t2.登陆\n");
		System.out.println("\t3.退出\n");
		System.out.print("\t请输入菜单号:");
		Scanner input = new Scanner(System.in);
		System.out.println();
		switch (input.nextInt()) {
		case 1:
			regist();// 注册页面
		case 2:
			login();// 登陆页面
		case 3:
			System.exit(1);// 退出
		default:
			showLoginAndRegist();

		}

	}

	/**
	 * 注册页面
	 */
	private void regist() {
		System.out.println("\t注册页面\n");
		System.out.print("\t请输入手机号码:");
		Scanner input = new Scanner(System.in);
		String phoneNum = input.next();
		System.out.print("\t请输入密码:");
		String pwd = input.next();
		LeDouUser douUser = new LeDouUser();
		douUser.setPhoneNum(phoneNum);
		douUser.setPwd(pwd);
		douUser.setPhoneMoney(0);
		douUser.setLeDouMoney(0);
		try {
			userService.regist(douUser);
			System.out.println("注册成功");
			login();
		} catch (LeDouException e) {
			System.err.println(e.getMessage());
			regist();
		}

	}

	/**
	 * 登陆页面
	 */
	private void login() {
		System.out.println("\t登陆页面\n");
		System.out.print("\t请输入手机号码：");
		Scanner input = new Scanner(System.in);
		String phoneNum = input.next();
		System.out.print("\t请输入密码：");
		String pwd = input.next();

		try {
			this.douUser = userService.login(phoneNum, pwd);
			if (this.douUser == null) {
				System.err.println("用户名或密码不正确");
				login();// 重新登陆
			} else {
				if ("admin".equals(this.douUser.getPhoneNum())
						&& "admin".equals(this.douUser.getPwd())) {
					showAdminCenter();// 转到管理员用户
				} else {
					showUserCenter();// 普通用户界面。。除管理员外
				}

			}
		} catch (LeDouException e) {
			System.out.println(e.getMessage());
			login();
		}
	}

	/**
	 * 管理员用户中心
	 */
	private void showAdminCenter() {
		System.out.println("\t管理员中心\n");
		System.out.println("\t1.导入手机用户\n");
		System.out.println("\t2.游戏管理\n");
		System.out.println("\t3.游戏类别管理\n");
		System.out.println("\t4.兑换规则管理\n");
		System.out.println("\t5.退出\n");
		System.out.print("请输入菜单号：");
		Scanner input = new Scanner(System.in);
		switch (input.nextInt()) {
		case 1:
			importPhoneUser();// 进入导入手机用户界面
			break;
		case 2:
			showGameManage();// 进入游戏管理界面
			break;
		case 3:
			showGameTypeManage();// 进入游戏类别管理
			break;
		case 4:
			// 兑换规则管理
			showChangeRule();
		case 5:
			System.exit(1);

		}
	}

	/**
	 * 兑换规则管理
	 */
	private void showChangeRule() {
		System.out.println("\t\t乐豆兑换规则页面\n");
		System.out.println("\t1.查看乐豆兑换比例");
		System.out.println("\t2.修改乐豆兑换比例");
		System.out.println("\t3.返回\n");
		System.out.print("\t请选择菜单：");
		Scanner input = new Scanner(System.in);
		switch (input.nextInt()) {
		case 1:
			showRule();// 查看乐豆兑换比例
			break;
		case 2:
			updateRule();// 修改乐豆兑换比例
			break;
		case 3:
			showAdminCenter();// 返回
			break;
		}
	}

	/**
	 * 修改乐豆兑换比例
	 */
	private void updateRule() {

		System.out.print("请输入新的比例:");
		Scanner input = new Scanner(System.in);
		int ratio = input.nextInt();
		ruleService.updateRule(ratio);
		System.out.print("\n\t返回上一级输入0，退出输入1:");
		if (input.nextInt() == 0) {
			showChangeRule();
		} else {
			System.exit(1);
		}
	}

	/**
	 * 察看比例界面
	 */
	private void showRule() {
		ChangeRule changeRule = ruleService.selectRule();
		System.out.println("1元话费兑换" + changeRule.getRatio() + "乐豆");
		System.out.print("\n\t返回上一级输入0，退出输入1:");
		Scanner input = new Scanner(System.in);
		if (input.nextInt() == 0) {
			showChangeRule();
		} else {
			System.exit(1);
		}
	}

	/**
	 * 游戏类别管理界面
	 */
	private void showGameTypeManage() {
		System.out.println("\t游戏类别管理界面\n");
		System.out.println("\t1.查询所有游戏类别");
		System.out.println("\t2.添加游戏类别");
		System.out.println("\t3.修改游戏类别");
		System.out.println("\t4.返回管理员界面\n");
		System.out.print("\t请输入菜单号：");
		Scanner input = new Scanner(System.in);
		switch (input.nextInt()) {
		case 1:
			// 查询所有游戏类别
			showGameTypes();
			break;
		case 2:
			// 添加游戏类别
			showAddGameTypes();
			break;
		case 3:
			// 修改游戏类别
			showUpdateUpDateGameTypes();
			break;
		case 4:
			// 返回
			showAdminCenter();
			break;

		}
	}

	/**
	 * 修改游戏类别页面
	 */
	private void showUpdateUpDateGameTypes() {// 0000000000000000
		System.out.println("\t游戏类别修改页面");
		System.out.println("\t请输入需要修改的游戏类别的编号:");
		Scanner input = new Scanner(System.in);
		int id = input.nextInt();
		GameType gameType = gameTypeService.selectGameType(id);
		if (null != gameType) {
			System.out.println("即将修改下面的游戏类别");
			System.out.println("游戏编号" + "--" + "游戏类别名称" + "--" + "修改时间");
			System.out.println(gameType.getId() + "--" + gameType.getGameType()
					+ "" + gameType.getCreateTime());
			System.out.print("\t请输入游戏类型名称:");
			String gameTypeName = input.next();
			// 重新构造gameType
			gameType.setGameType(gameTypeName);
			System.out.print("\n\t确认修改输入0，返回输入1:");
			if (input.nextInt() == 0) {
				try {
					gameTypeService.upDateGameType(gameType, id);// 修改游戏，成功后返回游戏管理
					showGameTypeManage();
				} catch (LeDouException e) {
					e.printStackTrace();
				}
			} else {
				showGameTypeManage();

			}
		} else {
			System.out.println("该游戏类型编号不存在");
			showGameTypeManage();// 返回游戏管理界面
		}

	}

	/**
	 * 添加游戏类型界面
	 */
	private void showAddGameTypes() {
		System.out.println("\t\t添加游戏类别界面\n");
		Scanner input = new Scanner(System.in);
		System.out.print("\t请输入游戏类别名称:");
		String gameTypeName = input.next();

		// 构造gameType对象
		GameType gameType = new GameType();
		gameType.setGameType(gameTypeName);
		try {
			gameTypeService.addGameType(gameType);
			System.out.print("\t返回上一级别输入1，推出输入0：");
			if (input.nextInt() == 1) {
				showGameTypeManage();
			} else {
				System.exit(1);
			}
		} catch (LeDouException e) {
			System.out.println(e.getMsg());
			showAddGameTypes();
		}

	}

	/**
	 * 游戏类别查询所有界面
	 */
	private void showGameTypes() {// ***********************************
		GameType gameType = null;
		// 返回游戏类型集合
		List<GameType> gameTypeList = gameTypeService.selectAllGameType();
		// 遍历输出
		System.out.println("类型号\t游戏类型");
		Iterator<GameType> it = gameTypeList.iterator();
		while (it.hasNext()) {
			gameType = it.next();
			System.out
					.println(gameType.getId() + "\t" + gameType.getGameType());
		}
		Scanner input = new Scanner(System.in);
		System.out.print("\t返回上一级别输入1，退出输入0：");
		if (input.nextInt() == 1) {
			showGameTypeManage();
		} else {
			System.exit(1);
		}
	}

	/**
	 * 从cmcc.txt 向PhoneUser表中导入用户
	 */
	private void importPhoneUser() {
		try {
			userService.importPhoneUser();
			System.out.println("导入成功");
			showAdminCenter();
		} catch (LeDouException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * 游戏管理界面
	 */
	private void showGameManage() {
		System.out.println("\t游戏管理\n");
		System.out.println("\t1.查询所有游戏\n");
		System.out.println("\t2.增加游戏\n");
		System.out.println("\t3.修改游戏\n");
		System.out.println("\t4.删除游戏\n");
		System.out.println("\t5.返回管理中心\n");
		System.out.println("\t6.退出\n");
		System.out.print("请输入菜单号：");
		Scanner input = new Scanner(System.in);
		switch (input.nextInt()) {
		case 1:
			showGames();// 查询所有游戏
			break;
		case 2:
			showAddGame();// 增加游戏
			break;
		case 3:
			showUpdateGame();// 修改游戏
			break;
		case 4:
			showDeleteGame();// 删除游戏
			break;
		case 5:
			// 返回管理中心
			showAdminCenter();
			break;
		case 6:
			// 退出
			System.exit(1);

		}

	}

	/**
	 * 显示删除游戏界面
	 */
	private void showDeleteGame() {

		System.out.println("\t请输入要删除的游戏的编号:");
		Scanner input = new Scanner(System.in);
		int id = input.nextInt();// 得到需要删除的游戏id
		Game game = gameService.selectGame(id);// 通过Id找是不是存在该游戏
		if (null != game) {// 存在
			String typeId = game.getGameType();
			try {
				System.out.println("即将删除下面的游戏");
				System.out.println("游戏编号" + "--" + "游戏名称" + "--" + "游戏简介"
						+ "--t" + "游戏类型" + "--t" + "话费价格" + "--t" + "乐豆价格"
						+ "--t" + "上架时间");
				System.out.println(game.getId() + "--" + game.getGameName()
						+ "--" + game.getGameInfo() + "--" + game.getGameType()
						+ "--" + game.getPhonePrice() + "--"
						+ game.getLedouPrice() + "--" + game.getTime());
				System.out.print("\n\t确认删除输入0，返回输入1:");
				if (input.nextInt() == 0) {
					gameService.deleteGame(id);// 删除游戏，成功后返回游戏管理
					showGameManage();
				} else {
					showGameManage();
				}
			} catch (LeDouException e1) {
				System.err.println(e1.getMsg());
			}
		} else {
			System.out.println("该编号不存在");
			showGameManage();// 返回游戏管理界面
		}

	}

	/**
	 * 添加游戏界面
	 */
	private void showAddGame() {
		System.out.println("\t\t添加游戏界面\n");
		Scanner input = new Scanner(System.in);
		System.out.print("\t请输入游戏名称:");
		String gameName = input.next();
		System.out.print("\t请输入游戏介绍:");
		String gameInfo = input.next();
		System.out.print("\t请输入游戏类别:");
		String gameType = input.next();
		System.out.print("\t请输入话费价格:");
		double phonePrice = input.nextDouble();
		System.out.print("\t请输入乐豆价格:");
		double ledouPrice = input.nextDouble();
		// 构造game对象
		Game game = new Game();
		game.setGameInfo(gameInfo);
		game.setGameName(gameName);
		game.setGameType(gameType);
		game.setLedouPrice(ledouPrice);
		game.setPhonePrice(phonePrice);
		try {
			gameService.addGame(game);
			System.out.print("\t返回上一级别输入1，推出输入0：");
			if (input.nextInt() == 1) {
				showGameManage();
			} else {
				System.exit(1);
			}
		} catch (LeDouException e) {
			System.out.println(e.getMsg());
			showAddGame();
		}

	}

	/**
	 * 修改游戏页面
	 */
	private void showUpdateGame() {
		System.out.println("\t请输入要修改的游戏的编号:");
		Scanner input = new Scanner(System.in);
		int id = input.nextInt();
		Game game = gameService.selectGame(id);
		if (null != game) {
			System.out.println("即将修改下面的游戏");
			System.out
					.println("游戏编号" + "--" + "游戏名称" + "--" + "游戏简介" + "--t"
							+ "游戏类型" + "--t" + "话费价格" + "--t" + "乐豆价格" + "--t"
							+ "上架时间");
			System.out.println(game.getId() + "--" + game.getGameName() + "--"
					+ game.getGameInfo() + "--" + game.getGameType() + "--"
					+ game.getPhonePrice() + "--" + game.getLedouPrice() + "--"
					+ game.getTime());
			System.out.print("\t请输入游戏名称:");
			String gameName = input.next();
			System.out.print("\t请输入游戏介绍:");
			String gameInfo = input.next();
			System.out.print("\t请输入游戏类别:");
			String gameType1 = input.next();
			System.out.print("\t请输入话费价格:");
			double phonePrice = input.nextDouble();
			System.out.print("\t请输入乐豆价格:");
			double ledouPrice = input.nextDouble();
			// 重新构造game
			game.setGameName(gameName);
			game.setGameInfo(gameInfo);
			game.setGameType(gameType1);
			game.setPhonePrice(phonePrice);
			game.setLedouPrice(ledouPrice);
			System.out.print("\n\t确认修改输入0，返回输入1:");
			if (input.nextInt() == 0) {
				try {
					gameService.upDateGame(game, id);// 修改游戏，成功后返回游戏管理
					showGameManage();
				} catch (LeDouException e) {
					e.printStackTrace();
				}
			} else {
				showGameManage();

			}
		} else {
			System.out.println("该编号不存在");
			showGameManage();// 返回游戏管理界面
		}

	}

	/**
	 * 查询所有游戏
	 */
	private void showGames() {
		System.out.println("\n\t\t游戏编号" + "\t\t" + "游戏名称" + "\t\t" + "游戏简介"
				+ "\t\t" + "游戏类型" + "\t\t" + "话费价格" + "\t\t" + "乐豆价格" + "\t\t"
				+ "上架时间");
		gameService.selectAllGame();
		if ("admin".equals(douUser.getPhoneNum())) {// 察看游戏的是管理员用户
			System.out.print("\n\t返回上一级输入0，退出输入1:");
			Scanner input = new Scanner(System.in);
			if (input.nextInt() == 0) {
				showGameManage();// 游戏管理界面
			} else if (input.nextInt() == 1) {
				System.exit(1);
			} else {
				showGameManage();// 其他情况返回游戏管理界面
			}
		} else {// 察看游戏的是用户
			System.out.print("\n\t返回用户中心输入0，进入下载输入1:");
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			switch (choice) {
			case 0:
				showUserCenter();// 返回用户中心
				break;
			case 1:
				showDownLoad();// 进入下载页面
				break;
			default:
				System.out.println("输入不存在，请重新输入！");
				showGames();
			}

		}

	}

	/**
	 * 下载界面
	 */
	private void showDownLoad() {
		System.out.print("\t请输入要下载的游戏的编号:");
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();// 游戏编号
		Game game = gameService.selectGame(number);// 通过编号得到游戏****这里可以加控制如果找到怎么样，没找到怎么样
		String gameName = game.getGameName();
		if (null != game) {// 找到该编号的游戏

			/************* 获得下载免费条件开始 *****************/
			int count = 0;
			try {
				// 通过手机号查询操作记录集合
				List<Trade> tradeList = tradeService.queryHistory(this.douUser
						.getPhoneNum());
				Iterator<Trade> it = tradeList.iterator();
				Trade trade = null;
				while (it.hasNext()) {
					trade = it.next();
					if (trade.getGameName().equals(game.getGameName())) {
						count++;
					}
				}
			} catch (LeDouException e1) {
				System.err.println(e1.getMsg());
			}
			/********************* 获得下载条件结束 *****************************************/

			System.out.println("\t你需要下载的游戏信息如下\n");
			System.out.println("\t\t游戏编号" + "\t\t" + "游戏名称" + "\t\t" + "游戏简介"
					+ "\t\t" + "游戏类型" + "\t\t" + "话费价格" + "\t\t" + "乐豆价格"
					+ "\t\t" + "上架时间");
			System.out.println("\t\t" + game.getId() + "\t\t"
					+ game.getGameName() + "\t\t" + game.getGameInfo() + "\t\t"
					+ game.getGameType() + "\t\t" + game.getPhonePrice()
					+ "\t\t" + game.getLedouPrice() + "\t\t" + game.getTime());
			System.out.print("\t请选择支付类型：1.话费 2.乐豆:");
			String payType = null;

			switch (input.nextInt()) {
			case 1:// 话费支付=-=====================================================================shangweiwanshan
				payType = "话费支付";
				break;
			case 2:// 乐豆支付
				payType = "乐豆支付";
				break;
			default:
				System.out.println("暂不支持该类支付！");
				showDownLoad();// 跳回下载页面
			}
			ChangeRule changeRule = ruleService.selectRule();// 得到兑换比例对象
			// 构造一条交易记录
			Trade trade = new Trade();
			trade.setGameName(game.getGameName());
			trade.setPhoneNum(this.douUser.getPhoneNum());
			trade.setPayType(payType);

			if (count > 1) {// 已经下载过的可永久免费

				/*********** 根据消费类型构造trade对象开始 ************************/
				if ("话费支付".equals(payType)) {
					// 话费支付
					trade.setMoney(0);// 消耗话费数
					trade.setLedou(0);// 消耗乐豆数
					trade.setAddLedou(0);// 增加乐豆数
				} else if ("乐豆支付".equals(payType)) {
					// 乐豆支付
					trade.setMoney(0);// 消耗话费数
					trade.setLedou(0);// 消耗乐豆数
					trade.setAddLedou(0);// 增加乐豆数
				}
				/***************** 根据消费类型构造trade对象结束 **********************/

			} else {// 未下载过，或重新下载超过次数

				/*********** 根据消费类型构造trade对象开始 ************************/
				if ("话费支付".equals(payType)) {
					// 话费支付
					trade.setMoney(game.getPhonePrice());// 消耗话费数
					trade.setLedou(0);// 消耗乐豆数
					trade.setAddLedou(game.getPhonePrice()
							* changeRule.getRatio());// 增加乐豆数
				} else if ("乐豆支付".equals(payType)) {
					// 乐豆支付
					trade.setMoney(0);// 消耗话费数
					trade.setLedou(game.getLedouPrice());// 消耗乐豆数
					trade.setAddLedou(0);// 增加乐豆数
				}
				/***************** 根据消费类型构造trade对象结束 **********************/

			}

			try {
				tradeService.addTradeAndUpdateDouUser(douUser, trade);// 添加账单，并修改乐豆用户信息
				System.out.println("下载中---------------------------------------------------->ok!  下载成功");
				System.out.print("\n\t返回用户中心输入0，继续下载输入1，退出输入2:");
				int choice = input.nextInt();
				switch (choice) {
				case 0:
					showUserCenter();// 返回用户中心
					break;
				case 1:
					showDownLoad();// 进入下载页面
					break;
				case 2:
					System.exit(1);// 退出
				default:
					System.out.println("输入不存在，请重新输入！");
					showGames();
				}
			} catch (LeDouException e) {
				System.err.println(e.getMessage());
			}

		} else {
			System.out.println("该编号的游戏不存在");
			System.out.print("\t返回上一级别输入1，用户中心输入2，退出输入3：");
			switch (input.nextInt()) {
			case 1:
				// 返回下载页面
				showDownLoad();
				break;
			case 2:
				// 返回管理员中心
				showUserCenter();
				break;
			case 3:
				// 退出
				System.exit(1);
				break;
			default:
				showUserCenter();

			}

		}

	}

	/**
	 * 普通用户页面
	 */
	private void showUserCenter() {
		System.out.println("\t\t用户中心\n");
		System.out.println("\t1.查看游戏/下载游戏");
		System.out.println("\t2.查看个人账户信息");
		System.out.println("\t3.查看消费记录");
		System.out.println("\t4.退出\n");
		System.out.print("\t请输入菜单号：");
		Scanner input = new Scanner(System.in);
		switch (input.nextInt()) {
		case 1:
			// 查看游戏/下载游戏
			showGames();
			break;
		case 2:
			// 查看个人账户信息
			try {
				douUser = userService.queryUser(this.douUser.getPhoneNum());
				System.out.println("乐豆账户号\t\t密码\t\t话费余额\t\t乐豆余额");
				System.out.println(douUser.getPhoneNum() + "\t\t"
						+ douUser.getPwd() + "\t\t" + douUser.getPhoneMoney()
						+ "\t\t" + douUser.getLeDouMoney());
				System.out.print("\n\t返回用户中心输入0，退出输入1:");
				if (1 == input.nextInt()) {
					System.exit(1);
				} else {
					showUserCenter();// 返回用户中心
				}
			} catch (LeDouException e) {
				e.printStackTrace();
			}
			break;
		case 3:

			// 查看消费记录
			try {
				Trade trade = null;
				System.out.println("\t\t\t\t\t\t历史账单");
				System.out.println("手机号\t\t游戏名\t\t交易类型\t\t消耗话费\t\t消耗乐豆\t\t奖励乐豆\t\t交易时间");
				List<Trade> tadeList = tradeService.queryHistory(this.douUser
						.getPhoneNum());
				Iterator<Trade> it = tadeList.iterator();
				while (it.hasNext()) {
					trade = it.next();

					System.out.println(trade.getPhoneNum() + "\t"
							+ trade.getGameName() + "\t\t" + trade.getPayType()
							+ "\t\t" + trade.getMoney() + "\t\t"
							+ trade.getLedou() + "\t\t" + trade.getAddLedou()
							+ "\t\t" + trade.getTadeTime());
				}
				System.out.print("\t返回上一级别输入1，退出输入0：");
				if (input.nextInt() == 0) {
					System.exit(1);
				} else {
					showUserCenter();
				}
			} catch (LeDouException e) {
				System.err.println(e.getMsg());
			}
			break;
		case 4:
			System.exit(1);
		default:
			showUserCenter();

		}

	}

}
