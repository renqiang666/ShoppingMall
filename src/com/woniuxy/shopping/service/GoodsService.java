package com.woniuxy.shopping.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.shopping.dao.GoodsDAO;
import com.woniuxy.shopping.po.GoodsPO;
import com.woniuxy.shopping.tools.C3P0Utils;

public class GoodsService {
	/**
	 * 获取GoodsPO类型的List
	 * @return
	 */
  public List<GoodsPO> getGoods(String page){
	  //把page装换成需要的数据库里的数据位置
	   int index=(Integer.parseInt(page)-1)*6;
	  //创建一个List用于接收DAO传回的商品信息
	  List<GoodsPO> goods=new ArrayList<GoodsPO>();
		//创建数据库连接池，建立数据库链接
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		C3P0Utils c3p0=new C3P0Utils();
		Connection con = c3p0.getCon();
		//创建UsersDAO对象
		GoodsDAO dao=new GoodsDAO();
		goods=dao.getGoods(con,index);
	    //关闭数据库链接
		c3p0.close(con);
	  return goods;
  }
	/**
	 * 获取总页码
	 * @return
	 */
public int getGoodsTotalPage(){
	  //创建一个int型totalPage存放总页码
	  int totalPage=0;
	  int totalRow=0;
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
		//创建数据库连接池，建立数据库链接
		C3P0Utils c3p0=new C3P0Utils();
		Connection con = c3p0.getCon();
		//创建UsersDAO对象
		GoodsDAO dao=new GoodsDAO();
		totalRow=dao.getGoodsTotalRow(con);
	    //关闭数据库链接
		c3p0.close(con);
		if(totalRow%6==0){
			totalPage=totalRow/6;
		}else{
			totalPage=totalRow/6+1;
		}
	  return totalPage;
}
}
