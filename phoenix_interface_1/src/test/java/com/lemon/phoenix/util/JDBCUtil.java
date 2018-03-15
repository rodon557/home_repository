package com.lemon.phoenix.util;


import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;

public class JDBCUtil {
	public static Properties properties;
	static{
		properties=new Properties();
		try {
			properties.load(JDBCUtil.class.getResourceAsStream("/jdbc.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 public static ResultSet query(String sql,Object ... values) throws ClassNotFoundException, SQLException {
	    	//加载驱动//sql语句传递的值类型不确定 用Object类，所有类的父类
			Class.forName("com.mysql.jdbc.Driver");
			//获取数据库连接
			String url=properties.getProperty("url");
			String user=properties.getProperty("user");
			String password=properties.getProperty("password");
			Connection connection=(Connection) DriverManager.getConnection(url, user, password);
			//获取PreparedStatement对象（防注入）
			PreparedStatement statement=connection.prepareStatement(sql);//预编译sql的功能，可以防止sql注入
			for (int i=1;i<=values.length;i++) {
				statement.setObject(i, values[i-1]);//i从1开始
			}
			ResultSet resultSet=statement.executeQuery();//执行查询，返回结果集
			return resultSet;
   }
}
