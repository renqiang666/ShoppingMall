package com.woniuxy.shopping.service;

import java.sql.Connection;

import com.woniuxy.shopping.dao.ShoppingCarDAO;
import com.woniuxy.shopping.po.CarGoodsPO;
import com.woniuxy.shopping.tools.C3P0Utils;

public class DecreaseCarService {
	public String decreaseCarService(String id,Object oAccount){
		String result="减少失败！";
		//非空判断
		if(oAccount == null || id == null){
			result="货号或账户为空，减少失败！";
			return result;
		}
		//数据转型
		int goodsid=Integer.parseInt(id);
		String account=(String)oAccount;
		//创建数据库连接池，建立数据库链接
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		C3P0Utils c3p0=new C3P0Utils();
		Connection con = c3p0.getCon();
		//创建购物车DAO对象
		ShoppingCarDAO car=new ShoppingCarDAO();
		//创建一个购物车PO
		CarGoodsPO carPO=new CarGoodsPO();
		//先获取购物车中该商品对象
		carPO=car.findCountByGoodsid(con, goodsid,account);
		//获取该PO在购物车中的数量
		 int goodsCountInCar=carPO.getGoodscount();
		 //如果购物车中此商品数量大于1，则可以直接减少其数量
		 if(goodsCountInCar>1){
			 int carUpdateCount=car.updateGoodsCount(con, goodsid,goodsCountInCar-1,account);
			 c3p0.close(con);
			 if(carUpdateCount>0){
				 result="减少成功！";
				 return result;
			 }else{
				 result="减少失败！";
				 return result;
			 }
		 }else{
			 //如果数量等于1，则直接从购物车里删除
			 int carUpdateCount=car.removeCarGoodsByAccountAndGoodSid(con, goodsid,account);
			 c3p0.close(con);
			 if(carUpdateCount>0){
				 result="减少成功！";
				 return result;
			 }else{
				 result="减少失败！";
				 return result;
			 }
		 }
	}
}
