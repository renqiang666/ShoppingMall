package com.woniuxy.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.woniuxy.shopping.po.UsersPO;

public class UserInfoDAO {
	/**
	 * 通过账号来查询该账号个人信息
	 * @param con
	 * @param account
	 * @return
	 */
	public List<UsersPO> findUserInfoByAccount(Connection con,String account){
		List<UsersPO> userPO=new ArrayList<UsersPO>();
		//准备查询购物车里货物数量语句
				String sql="SELECT * FROM showPerson WHERE account=?";
				 //预编译，创建状态
				  PreparedStatement state=null;
				  ResultSet set=null;
				  try {
						state=con.prepareStatement(sql);
						//设置参数
						state.setString(1, account);
						//执行语句，并获取结果
					    set=state.executeQuery();
					    while(set.next()){
					    	UsersPO po=new UsersPO();
					    	po.setAccount(set.getString("account"));
					    	po.setName(set.getString("username"));
					    	po.setHeadImg(set.getString("headImg"));
					    	po.setBalance(set.getInt("balance"));
					    	po.setEmail(set.getString("email"));
					    	po.setReceiveName(set.getString("receivename"));
					    	po.setAddress(set.getString("address"));
					    	po.setPhone(set.getString("receivephone"));
					    	po.setReceiveID(set.getInt("receiveID"));
					    	userPO.add(po);
					    }
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally{
						if(set!=null){
							try {
								set.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}if(state!=null){
								try {
									state.close();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
		return userPO;
		
	}
	public int decreaseMoneyByAccount(Connection con,String account,int newBalance){
		int updateCount=0;
		//准备更新账户余额语句
		String sql="UPDATE users SET balance=? WHERE account=?";
		 //预编译，创建状态
		  PreparedStatement state=null;
		  ResultSet set=null;
		  try {
				state=con.prepareStatement(sql);
				//设置参数
				state.setInt(1, newBalance);
				state.setString(2, account);
				//执行语句，并获取结果
				updateCount=state.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				if(set!=null){
					try {
						set.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}if(state!=null){
						try {
							state.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		  return updateCount;
	}

}
