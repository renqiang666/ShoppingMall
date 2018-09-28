package com.woniuxy.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderListDAO {
	/**
	 * 往订单表插入订单
	 * @param con
	 * @param orderid
	 * @param account
	 * @param goodsid
	 * @param goodscount
	 * @param price
	 * @param time
	 * @return
	 */
     public int insertOrderList(Connection con,String orderid,String account,int goodsid,int goodscount,int price,String time){
    	 int updateCount=0;
    	  //准备更改货物库存语句
    	  String sql="INSERT INTO orderlist(orderid,account,goodsid,goodscount,price,time) VALUES(?,?,?,?,?,?)";
    	  //预编译，创建状态
    	  PreparedStatement state=null;
    	  try {
    			state=con.prepareStatement(sql);
    			//设置参数
    			state.setString(1, orderid);
    			state.setString(2, account);
    			state.setInt(3, goodsid);
    			state.setInt(4,goodscount);
    			state.setInt(5,price);
    			state.setString(6, time);
    			//执行语句，并获取结果
    			updateCount=state.executeUpdate();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} finally{
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
