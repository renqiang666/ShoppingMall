package com.woniuxy.shopping.service;

import java.sql.Connection;

import com.woniuxy.shopping.dao.UsersDAO;
import com.woniuxy.shopping.tools.C3P0Utils;
import com.woniuxy.shopping.tools.MD5_Encoding;

public class ChangePassService {
	/**
	 * 验证修改密码账户是否合法
	 * @param account
	 * @param pass
	 * @param code
	 * @param orealCode
	 * @return
	 */
   public String changePassCheck(String account, String oldPass,String newPass,String rePass, String code,
			Object orealCode){
	   String result="修改密码失败！";
	   /**
		 * 数据非空验证
		 */
		if(account==null||oldPass==null||newPass==null||rePass==null||code==null || orealCode == null){
			return result;
		}
		/**
		 * 判断两次密码是否一致
		 */
		if(!newPass.equals(rePass)){
			result="两次密码不一致,修改密码失败！";
			return result;
		}
		/**
		 * 验证码验证
		 */
		String realCode=(String)orealCode;
		if(!realCode.equalsIgnoreCase(code)){
			result="验证码错误！";
			return result;
		}
		/**
		 * 判断账号是否为手机号
		 */
		if(!account.matches("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$")){
			result="账号格式不正确,请输入11位手机号码作为账号！";
			return result;
		}
		/**
		 * 判断密码是否合法
		 */
		if(!newPass.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$")){
			result="密码格式不正确！";
			return result;
		}
		if(oldPass.equals(newPass)){
			result="新旧密码不能一样，修改密码失败";
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
		//创建UsersDAO对象
		UsersDAO dao=new UsersDAO();
		//利用UsersDAO对数据库进行操作
		String realPass = dao.findPassByAccount(con,account);
		//判断账号是否存在
		if(realPass.length() <= 0){
			result="账号不存在，无法修改密码！";
			c3p0.close(con);
			return result;
		}else if(!realPass.equals(new MD5_Encoding().upperMD5(oldPass))){
			result="旧密码输入错误，无法修改密码！";
			c3p0.close(con);
			return result;
		}else{
			int updateCount=0;
			//获取插入结果
			updateCount=dao.updatePass(con, account, new MD5_Encoding().upperMD5(newPass));
			//关闭数据库链接
			c3p0.close(con);
				//对结果进行判断
				if(updateCount>0){
					result="修改密码成功！";
				}else{
					result="更新密码失败！";
				}
		}
	   return result;
   }
}
