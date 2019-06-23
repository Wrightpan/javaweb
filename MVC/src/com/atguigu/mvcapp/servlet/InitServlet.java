package com.atguigu.mvcapp.servlet;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.atguigu.mvcapp.dao.factory.CustomerDAOFactory;

public class InitServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		CustomerDAOFactory.getInstance().setType("jdbc");
		
		//读取类路径下的 switch.properties 文件
		InputStream in = 
				getServletContext().getResourceAsStream("/WEB-INF/classes/switch.properties");
		Properties properties = new Properties();
		try {
			properties.load(in);
			//获取 switch.properties 的 type 属性值
			String type = properties.getProperty("type");
			//赋给了 CustomerDAOFactory 的 type 属性值
			CustomerDAOFactory.getInstance().setType(type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
