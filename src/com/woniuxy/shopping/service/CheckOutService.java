package com.woniuxy.shopping.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.woniuxy.shopping.dao.GoodsDAO;
import com.woniuxy.shopping.dao.OrderListDAO;
import com.woniuxy.shopping.dao.ShoppingCarDAO;
import com.woniuxy.shopping.dao.UserInfoDAO;
import com.woniuxy.shopping.po.CarGoodsPO;
import com.woniuxy.shopping.po.UsersPO;
import com.woniuxy.shopping.tools.C3P0Utils;

public class CheckOutService {
   public String checkOutService(Object oAccount){
	   //先将account转为String类型
	   String result="结账失败！";
	   String account;
	   try {
		  account=(String)oAccount;
	    } catch (Exception e) {
		e.printStackTrace();
		return result;
	    }
 		//创建数据库连接池，建立数据库链接
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		C3P0Utils c3p0=new C3P0Utils();
 		Connection con = c3p0.getCon();
 		//关闭数据库自动提交
 		try {
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   //先获取当前账户的购物车信息，并为每一行创建一个PO，存在List中
	   List<CarGoodsPO> carPO=new ArrayList<CarGoodsPO>();
	   //创建购物车DAO对象
	   ShoppingCarDAO carDAO=new ShoppingCarDAO();
	   //创建商品DAO对象
	   GoodsDAO goodDAO=new GoodsDAO();
	   carPO=carDAO.findAllCarGoodsByAccount(con, account);
	   //定义时间格式
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   //获取时间
	   String date = sdf.format(new Date());
	   //判断每个购物车PO的库存数是否均能满足需求数
	   for(int i=0;i<carPO.size();i++){
		    //定义单类商品总花费金额
		   int totalMoney=0;
		   //如果需求数大于库存数，则结账失败！
		   if(carPO.get(i).getGoodscount()>carPO.get(i).getGoodsbalance()){
			   result="库存不足，结账失败！";
			   try {
				con.rollback();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   return result;
		   }else{
			   //如果满足需求，则根据货号减去其库存
			   int decreaseStore=goodDAO.updateGoodsCount(con, carPO.get(i).getGoodsid(), carPO.get(i).getGoodsbalance()-carPO.get(i).getGoodscount());
			   //给总花费加金额
			   totalMoney=totalMoney+carPO.get(i).getGoodscount()*carPO.get(i).getPrice();
			   if(decreaseStore<1){
				   result="去库存出现异常，结账失败！";
				   try {
						con.rollback();
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					   return result;
			   }
		   }
		   //去库存后，确认余额是否足够
		   //创建一个UserInfoDAO对象
		   UserInfoDAO userInfoDAO=new UserInfoDAO();
		   //通过UserInfoDAO对象获取当前账户的UsersPO对象的List
		   List<UsersPO> userPO=userInfoDAO.findUserInfoByAccount(con, account);
		   //先判断当前账户信息是否为空
		   if(userPO.get(0).getAccount()==null){
			   result="无当前账户信息，结账失败！";
			   try {
					con.rollback();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   return result;
		   }
		   //当前userPO的账户余额与所需金额比较
		   else if(userPO.get(0).getBalance()<totalMoney){
			   result="余额不足，结账失败！";
			   try {
					con.rollback();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   return result;
		   }else{
			   int updateCount=0;
			   updateCount=userInfoDAO.decreaseMoneyByAccount(con, account, userPO.get(0).getBalance()-totalMoney);
			   if(updateCount<1){
				   result="扣款失败，结账失败！";
				   try {
						con.rollback();
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					   return result;
			   }
		   }
		   //扣款成功后，删除当前账户购物车的所有信息
		   int updateCount=0;
		   updateCount=carDAO.removeCarGoodsByAccountAndGoodSid(con, carPO.get(i).getGoodsid(), account);
		   if( updateCount<1){
			   result="从购物车删除失败，结账失败！";
			   try {
					con.rollback();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   return result;
		   }
		 //购物车删除后添加订单信息
		   int updateOrder=0;
		   String orderid=date+account;
		   updateOrder=new OrderListDAO().insertOrderList(con, orderid, account, carPO.get(i).getGoodsid(), carPO.get(i).getGoodscount(), carPO.get(i).getPrice(), date);
		   if(updateOrder<1){
			   result="添加订单失败，结账失败！";
			   try {
					con.rollback();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   return result;
		   }   
	   }
		   result="结账成功！";
		   try {
			con.commit();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return result;
   }
   
}
