import java.sql.SQLException;

import com.njwangbo.ledou.dao.impl.LeDouUserDaoImpl;
import com.njwangbo.ledou.entity.LeDouUser;
import com.njwangbo.ledou.entity.PhoneUser;
import com.njwangbo.ledou.util.DateUtil;


public class TestLeDouUserDaoImpl {
	
	public static void main(String[] args) throws SQLException {
		LeDouUserDaoImpl l = new LeDouUserDaoImpl();
/*		LeDouUser douUser =   l.queryByPhoneNumAndPwd("admin", "admin");
		if(douUser == null){
			System.out.println("null");
		} else {
			System.out.println("not null");
		}
		System.out.println(douUser.getPhoneNum() + douUser.getPwd());*/
		PhoneUser user = new PhoneUser();
		user.setPhoneNum("11111111111");
		user.setUserName("测试");
		user.setUserSex("男");
		user.setPhoneMoney(555);
		user.setAddress("njwangbo");
		user.setTime(DateUtil.str2Date("2016-08-06", "yyyy-MM-dd"));
		
		l.insertPoneUser(user);
	}

}
