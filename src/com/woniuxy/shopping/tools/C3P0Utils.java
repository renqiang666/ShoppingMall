package com.woniuxy.shopping.tools;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils{
	//创建一个连接池对象
	private static ComboPooledDataSource pool=null;
	static{
		pool = new ComboPooledDataSource();
		//配置连接池
		try {
			pool.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//数据库url配置
		pool.setJdbcUrl("jdbc:mysql://localhost:3306/shopping");
		//数据库用户名
		pool.setUser("root");
		//数据库密码
		pool.setPassword("12345678");
		//设置初始化连接数
		pool.setInitialPoolSize(8);
		//设置最小连接数
		pool.setMinPoolSize(3);
		//设置最大连接数
		pool.setMaxPoolSize(20);
	}
	public Connection getCon(){
		try {
			return pool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("开启链接");
		return null;
	}
	public void close(Connection con){
		try {
			if(con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

