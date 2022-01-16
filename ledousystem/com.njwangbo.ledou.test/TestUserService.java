import com.njwangbo.ledou.entity.LeDouUser;
import com.njwangbo.ledou.exception.LeDouException;
import com.njwangbo.ledou.service.impl.UserServiceImpl;


public class TestUserService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		UserServiceImpl user=new UserServiceImpl();
		
//		try {
//			user.importPhoneUser();
//		} catch (LeDouException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			user.login("13965548512", "123456");
//		} catch (LeDouException e) {
//			e.printStackTrace();
//		}
		
		LeDouUser douUser=new LeDouUser();
		
		try {
			user.regist(douUser);
		} catch (LeDouException e) {
			e.printStackTrace();
		}
	}

}
