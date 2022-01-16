import java.util.Iterator;
import java.util.List;

import com.njwangbo.ledou.entity.Trade;
import com.njwangbo.ledou.exception.LeDouException;
import com.njwangbo.ledou.service.impl.TradeServiceImpl;


public class TestTradeDaoImpl {
	public static void main(String[] args) {
		Trade trade = null;
		List<Trade> tradeList = null;
		TradeServiceImpl i = new TradeServiceImpl();
		try {
			tradeList = i.queryHistory("15755843966");
			
		} catch (LeDouException e) {
			e.printStackTrace();
		}
		
		
		Iterator<Trade> it = tradeList.iterator();
		while(it.hasNext()){
			trade = it.next();
			System.out.println(trade.getId()+"\t"+trade.getGameName());
		}
	}
}
