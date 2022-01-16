import java.sql.SQLException;

import com.njwangbo.ledou.dao.impl.ChangeRuleDaoImpl;
import com.njwangbo.ledou.entity.ChangeRule;


public class TestChangeRuleDaoImpl {
	public static void main(String[] args) throws SQLException {
		ChangeRuleDaoImpl i = new ChangeRuleDaoImpl();
		ChangeRule rule = new ChangeRule();
		rule.setRatio(20);
		
		i.selectRule();
		System.out.println(i.selectRule().getRatio());
		i.updateRule(rule);
		System.out.println(i.selectRule().getRatio());
		i.selectRule();
		System.out.println(i.selectRule().getRatio());
	}

}
