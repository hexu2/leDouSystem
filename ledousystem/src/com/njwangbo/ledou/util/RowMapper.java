package com.njwangbo.ledou.util;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 
 * @author soft01
 *
 */
public interface RowMapper {
	public abstract Object mapperObject(ResultSet rs)throws SQLException;
}
