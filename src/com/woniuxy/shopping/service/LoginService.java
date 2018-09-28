package com.woniuxy.shopping.service;

import java.sql.Connection;

import com.woniuxy.shopping.dao.UsersDAO;
import com.woniuxy.shopping.tools.C3P0Utils;
import com.woniuxy.shopping.tools.MD5_Encoding;
import com.woniuxy.shopping.tools.UtilTool;

public class LoginService {
	/**
	 * 验证登录账户是否合法
	 * @param account
	 * @param pass
	 * @param code
	 * @param orealCode
	 * @return
	 */

	public String loginCheck(String account, String pass, String code,
			Object orealCode) {
		String result="登陆失败！";
		//数据格式验证
		//非空判断
		if(account == null || pass == null || code == null || orealCode == null){
			return result;
		}
		//验证码验证
		String realCode=(String)orealCode;
		if(!realCode.equalsIgnoreCase(code)){
			result="验证码错误！";
			return result;
		}
		//账号格式验证
		if(!account.matches("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$")){
			result="账号不合法！请输入注册手机号！";
			return result;
		}
		//密码验证
		if(!pass.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$")){
			result="密码错误！";
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
		//利用UsersDAO对数据库进行操作
		String realPass = new UsersDAO().findPassByAccount(con,account);
		//判断账号是否存在
		if(realPass.length() <= 0){
			result="账号不存在！请注册！";
			//tool.closeCon(con);
			c3p0.close(con);
			return result;
		}
		//判断密码是否正确
		if(realPass.equals(new MD5_Encoding().upperMD5(pass))){
			result="登录成功！";
		}else{
			result="密码错误！";
		}
		//关闭数据库链接
		c3p0.close(con);
		//tool.closeCon(con);
		return result;
	}

}

