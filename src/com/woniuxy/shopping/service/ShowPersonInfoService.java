package com.woniuxy.shopping.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.shopping.dao.UserInfoDAO;
import com.woniuxy.shopping.po.UsersPO;
import com.woniuxy.shopping.tools.C3P0Utils;

public class ShowPersonInfoService {
	public List<UsersPO> showPersonInfo(Object oAccount){
		List<UsersPO> userPO=new ArrayList<UsersPO>();
		String account=(String)oAccount;
				//创建数据库连接池，建立数据库链接
				C3P0Utils c3p0=new C3P0Utils();
				Connection con = c3p0.getCon();
				//创建购物车carDAO对象
				UserInfoDAO dao=new UserInfoDAO();
				userPO=dao.findUserInfoByAccount(con, account);
				//关闭数据库链接
				c3p0.close(con);
		return userPO;
	}

}
