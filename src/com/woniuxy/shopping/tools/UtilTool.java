package com.woniuxy.shopping.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilTool {
public Connection getCon(){
	//关联数据库
    //创建驱动路径
	//设置数据库参数
    String url="jdbc:mysql://localhost:3306/shopping";
	String name="root";
	String pass="12345678";
	Connection con =null;
	try {
		con = DriverManager.getConnection(url,name,pass);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
}
public void closeCon(Connection con){
	if(con!=null){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
