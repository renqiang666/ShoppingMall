package com.woniuxy.shopping.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.woniuxy.shopping.dao.GoodsDAO;
import com.woniuxy.shopping.dao.ShoppingCarDAO;
import com.woniuxy.shopping.po.CarGoodsPO;
import com.woniuxy.shopping.po.GoodsPO;
import com.woniuxy.shopping.tools.C3P0Utils;

public class AddCarService {
	public String addCarService(String id,Object oAccount){
		String result="添加失败！";
		//非空判断
		if(oAccount == null || id == null){
			result="请先登录，添加失败！";
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
		carPO=car.findCountByGoodsid(con, goodsid, account);
		//获取该PO在购物车中的数量
		 int goodsCountInCar=carPO.getGoodscount();
		//如果购物车里此物品数量大于等于1，说明购物车里有此物品，只需往数据库里添加其个数和金额；
		 if(goodsCountInCar>=1){
			 int carUpdateCount=car.updateGoodsCount(con, goodsid,goodsCountInCar+1,account);
			 c3p0.close(con);
			 if(carUpdateCount>0){
				 result="添加成功！";
				 return result;
			 }else{
				 result="添加失败！";
				 return result;
			 }
		 }else{
			//创建一个GoodsPO
			GoodsPO goodsPO=new GoodsPO();
			//根据goodsid查看该po的单价
			goodsPO=new GoodsDAO().getGoodsPO(con, goodsid);
			int singlePrice=goodsPO.getPrice();
			 int carUpdateCount=car.addNewGoodsInfo(con, account, goodsid,singlePrice);
			 c3p0.close(con);
			 if(carUpdateCount>0){
				 result="添加成功！";
				 return result;
			 }else{
				 result="添加失败！";
				 return result;
			 }
		 }
	}
}
