package com.woniuxy.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAO {
	/**
	 * 对USERS表根据账号查找密码
	 * @param con
	 * @param account
	 * @param password
	 * @return
	 */

	public String findPassByAccount(Connection con,String account) {
		PreparedStatement state=null;
		ResultSet set=null;
		String relPass="";
			//对数据库的login表根据输入账户进行密码数据查询
			//准备查询语句
			String sql="SELECT password FROM login WHERE account=?";
			//预编译查询语句
			try {
				state=con.prepareStatement(sql);
				//设置查询参数
				state.setString(1, account);
				//执行查询语句
				set=state.executeQuery();
				if(set.next()){
					relPass=set.getString("password");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			finally{
				if(set!=null){
					try {
						set.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
	                finally{
						if(state!=null){
							try {
								state.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
			return relPass;
	}
	/**
	 * 往login表里插入新注册用户信息
	 */
	public int registerSql(Connection con,String account,String pass){
		PreparedStatement state=null;
		int updateCount=0;
		//准备查询语句
		String sql="INSERT INTO login(account,password) VALUES(?,?) ";
		//预编译
		try {
			state=con.prepareStatement(sql);
			//设置参数
			state.setString(1, account);
			state.setString(2, pass);
			//执行语句
			updateCount=state.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//释放资源
			if(state!=null){
				try {
					state.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return updateCount;
	}
	public int updatePass(Connection con,String account,String newPass){
		PreparedStatement state=null;
		int updateCount=0;
		//准备查询语句
		String sql="UPDATE login  SET password=? WHERE account=? ";
		//预编译
		try {
			state=con.prepareStatement(sql);
			//设置参数
			state.setString(1, newPass);
			state.setString(2, account);
			//执行语句
			updateCount=state.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//释放资源
			if(state!=null){
				try {
					state.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return updateCount;
	}
}
