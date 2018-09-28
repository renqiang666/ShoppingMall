package com.woniuxy.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.shopping.po.CarGoodsPO;

public class ShoppingCarDAO {
	/**
	 * 根据商品号来查询购物车——商品视图里的此商品的PO
	 * @param con
	 * @param goodsid
	 * @return
	 */
	public CarGoodsPO findCountByGoodsid(Connection con,int goodsid,String account){
		CarGoodsPO po=new CarGoodsPO();
		//准备查询购物车里货物数量语句
		String sql="SELECT * FROM showCar WHERE goodsid=? AND account=?";
		 //预编译，创建状态
		  PreparedStatement state=null;
		  ResultSet set=null;
		  try {
				state=con.prepareStatement(sql);
				//设置参数
				state.setInt(1, goodsid);
				state.setString(2, account);
				//执行语句，并获取结果
			    set=state.executeQuery();
			    if(set.next()){
			    	po.setAccount(set.getString("account"));
			    	po.setGoodsid(set.getInt("goodsid"));
			    	po.setGoodscount(set.getInt("goodscount"));
			    	po.setPrice(set.getInt("price"));
			    	po.setImgsrc(set.getString("goodsimg"));
			    	po.setGoodsname(set.getString("goodsname"));
			    	po.setGoodsbalance(set.getInt("goodsbalance"));
			    	po.setBrand(set.getString("brand"));
			    	po.setBriefintroduction(set.getString("briefintroduction"));
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
	 * 根据账号查看购物车——商品视图里的所有PO，并返回一个List
	 * @param con
	 * @param goodsid
	 * @return
	 */
	public List<CarGoodsPO> findAllCarGoodsByAccount(Connection con,String account){
		//创建一个装购物车PO的List
		List<CarGoodsPO> carGoods=new ArrayList<CarGoodsPO>();
		//准备查询购物车里货物数量语句
		String sql="SELECT * FROM showCar WHERE account=?";
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
			    	CarGoodsPO po=new CarGoodsPO();
			    	po.setAccount(set.getString("account"));
			    	po.setGoodsid(set.getInt("goodsid"));
			    	po.setGoodscount(set.getInt("goodscount"));
			    	po.setPrice(set.getInt("price"));
			    	po.setImgsrc(set.getString("goodsimg"));
			    	po.setGoodsname(set.getString("goodsname"));
			    	po.setGoodsbalance(set.getInt("goodsbalance"));
			    	po.setBrand(set.getString("brand"));
			    	po.setBriefintroduction(set.getString("briefintroduction"));
			    	carGoods.add(po);
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
		return carGoods;
	}
	/**
	   * 根据商品号来更新购物车里此商品的购物数量
	   * @param con
	   * @param goodsid
	   * @param newCount
	   * @return
	   */
  public int updateGoodsCount(Connection con,int goodsid,int newCount,String account){
	  int updateCount=0;
	  //准备更改货物库存语句
	  String sql="UPDATE shoppingcar SET goodscount=? WHERE goodsid=? AND account=?";
	  //预编译，创建状态
	  PreparedStatement state=null;
	  try {
			state=con.prepareStatement(sql);
			//设置参数
			state.setInt(1, newCount);
			state.setInt(2, goodsid);
			state.setString(3, account);
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
  
	/**
   * 往购物车库里添加新商品数据
   * @param con
   * @param goodsid
   * @param newCount
   * @return
   */
 public int addNewGoodsInfo(Connection con,String account,int goodsid,int price){
  int updateCount=0;
  //准备更改货物库存语句
  String sql="INSERT INTO shoppingcar(account,goodsid,goodscount) VALUES(?,?,?)";
  //预编译，创建状态
  PreparedStatement state=null;
  try {
		state=con.prepareStatement(sql);
		//设置参数
		state.setString(1, account);
		state.setInt(2, goodsid);
		state.setInt(3,1);
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
	/**
  * 通过商品ID和账号从购物车移除商品
  * @param con
  * @param goodsid
  * @param newCount
  * @return
  */
public int removeCarGoodsByAccountAndGoodSid(Connection con,int goodsid,String account){
 int updateCount=0;
 //准备更改货物库存语句
 String sql="DELETE FROM shoppingcar WHERE goodsid=? AND account=?";
 //预编译，创建状态
 PreparedStatement state=null;
 try {
		state=con.prepareStatement(sql);
		//设置参数
		state.setInt(1, goodsid);
		state.setString(2, account);
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
/**
* 通过账号删除该账号的购物车信息
* @param con
* @param goodsid
* @param newCount
* @return
*/
public int removeAllCarGoodsByAccount(Connection con,String account){
int updateCount=0;
//准备更改货物库存语句
String sql="DELETE FROM shoppingcar WHERE account=?";
//预编译，创建状态
PreparedStatement state=null;
try {
	state=con.prepareStatement(sql);
	//设置参数
	state.setString(1, account);
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
