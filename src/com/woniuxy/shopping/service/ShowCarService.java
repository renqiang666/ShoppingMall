package com.woniuxy.shopping.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.shopping.dao.ShoppingCarDAO;
import com.woniuxy.shopping.po.CarGoodsPO;
import com.woniuxy.shopping.tools.C3P0Utils;

public class ShowCarService {
	public List<CarGoodsPO> showCarService(Object oAccount){
		List<CarGoodsPO> carGoods=new ArrayList<CarGoodsPO>();
		//非空判断
		if(oAccount == null){
			return carGoods;
		}
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
		//创建购物车carDAO对象
		ShoppingCarDAO car=new ShoppingCarDAO();
		carGoods=car.findAllCarGoodsByAccount(con,account);
		//关闭数据库链接
		c3p0.close(con);
		return carGoods;
	}
}
