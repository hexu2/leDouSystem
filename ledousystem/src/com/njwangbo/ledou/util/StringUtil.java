package com.njwangbo.ledou.util;

/**
 * 字符串工具类
 * 
 * @author Administrator
 * 
 */
public class StringUtil {
	/**
	 * 
	 * @param string
	 * @return 如果字符串为null或者空串 返回true,否则返回false
	 */
	public static boolean isEmpty(String string) {
		if (null == string || "".equals(string.trim())) {
			return true;
		} else {
			return false;
		}
	}

}
