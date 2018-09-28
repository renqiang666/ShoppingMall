package com.woniuxy.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.shopping.po.GoodsPO;

public class GoodsDAO {
	/**
	 * 获取当前页面商品信息
	 * @param con
	 * @param index
	 * @return
	 */
  public List<GoodsPO> getGoods(Connection con,int index){
	  //创建一个List用于接收查询传回的商品信息
	  List<GoodsPO> goods=new ArrayList<GoodsPO>();
	  //准备查询语句
	  String sql="SELECT * FROM goods LIMIT ?,6";
	  //预编译，创建状态
	  PreparedStatement state=null;
	  ResultSet set=null;
	  try {
		state=con.prepareStatement(sql);
		//设置参数
		state.setInt(1, index);
		//执行语句，并获取结果
		set=state.executeQuery();
		while(set.next()){
			GoodsPO po=new GoodsPO();
			po.setGoodsid(set.getInt("goodsid"));
			po.setGoodsname(set.getString("goodsname"));
			po.setPrice(set.getInt("price"));
			po.setGoodsbalance(set.getInt("goodsbalance"));
			po.setBriefintroduction(set.getString("briefintroduction"));
			po.setBrand(set.getString("brand"));
			po.setType(set.getString("type"));
			po.setImgsrc(set.getString("goodsimg"));
			//将查到的po装进goods里
			goods.add(po);
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
			}finally{
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
	  return goods;
  }
  /**
   * 获取goods总行数
   */
  public int getGoodsTotalRow(Connection con){
	  int totalRow=0;
	  //准备查询语句
	  String sql="SELECT COUNT(goodsid) AS C FROM goods";
	  //预编译，创建状态
	  PreparedStatement state=null;
	  ResultSet set=null;
	  try {
		state=con.prepareStatement(sql);
		//执行语句，并获取结果
	    set=state.executeQuery();
	    if(set.next()){
	    	totalRow=set.getInt("C");
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
	  return totalRow;
  }
  /**
   * 根据商品号来获取商品库里的此商品的PO
   * @param con
   * @param goodsid
   * @return
   */
  public GoodsPO getGoodsPO(Connection con,int goodsid){
	  //创建一个商品PO对象
	  GoodsPO po=new GoodsPO();
	  //准备查询语句
	  String sql="SELECT * FROM goods where goodsid=?";
	  //预编译，创建状态
	  PreparedStatement state=null;
	  ResultSet set=null;
	  try {
			state=con.prepareStatement(sql);
			//设置参数
			state.setInt(1, goodsid);
			//执行语句，并获取结果
		    set=state.executeQuery();
		    if(set.next()){
		    	po.setGoodsid(set.getInt("goodsid"));
				po.setGoodsname(set.getString("goodsname"));
				po.setPrice(set.getInt("price"));
				po.setGoodsbalance(set.getInt("goodsbalance"));
				po.setBriefintroduction(set.getString("briefintroduction"));
				po.setBrand(set.getString("brand"));
				po.setType(set.getString("type"));
				po.setImgsrc(set.getString("goodsimg"));
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
	  return po;
  }
  /**
   * 根据商品号来更新商品库里此商品的库存
   * @param con
   * @param goodsid
   * @param newCount
   * @return
   */
  public int updateGoodsCount(Connection con,int goodsid,int newCount){
	  int updateCount=0;
	  //准备更改货物库存语句
	  String sql="UPDATE goods SET goodsbalance=? where goodsid=?";
	  //预编译，创建状态
	  PreparedStatement state=null;
	  try {
			state=con.prepareStatement(sql);
			//设置参数
			state.setInt(1, newCount);
			state.setInt(2, goodsid);
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
