package util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


public class ServletUtils {
	
	public static Cookie getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if (cookies[i].getName().equals(name)) {
				return (Cookie) cookies[i].clone();
			}
		}
		return null;
	}
}
