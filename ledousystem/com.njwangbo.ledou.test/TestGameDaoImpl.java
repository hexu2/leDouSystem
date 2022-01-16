import java.sql.SQLException;
import java.util.Date;

import com.njwangbo.ledou.dao.impl.GameDaoImpl;
import com.njwangbo.ledou.entity.Game;


public class TestGameDaoImpl {
	public static void main(String[] args) throws SQLException {
		
		GameDaoImpl g = new GameDaoImpl();
		
		g.selectAllGame();//查询所有游戏
		
		//增加游戏
		Game game = new Game();
		game.setGameName("王者荣耀");
		game.setGameInfo("挺有意思");
		game.setGameType("1");
		game.setPhonePrice(50);
		game.setLedouPrice(30);
		
//		g.addGame(game);
		
		//删除游戏
//		g.deleteGame(4);game.getGameName(),game.getGameInfo(),game.getGameType(),game.getPhonePrice(),game.getLedouPrice()
		
		g.updateGame(game, 1);//

		
	}
}
