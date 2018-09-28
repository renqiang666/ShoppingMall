package com.woniuxy.shopping.service;

import java.sql.Connection;

import com.woniuxy.shopping.dao.UsersDAO;
import com.woniuxy.shopping.tools.C3P0Utils;
import com.woniuxy.shopping.tools.MD5_Encoding;



public class RegisterService {
	/**
	 * 验证注册账户是否合法
	 * @param account
	 * @param pass
	 * @param code
	 * @param orealCode
	 * @return
	 */
	public String registerCheck(String account, String pass,String repass, String code,
			Object orealCode) {
		String result="注册失败！";
		/**
		 * 数据非空验证
		 */
		if(account==null||pass==null||repass==null||code==null|| orealCode == null){
			return result;
		}
		/**
		 * 判断两次密码是否一致
		 */
		if(!pass.equals(repass)){
			result="两次密码不一致,注册失败！";
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
			result="注册账号格式不正确,请输入11位手机号码进行注册！";
			return result;
		}
		/**
		 * 判断密码是否合法
		 */
		if(!pass.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$")){
			result="注册密码格式不正确，请输入8~16位数字与字母的组合密码！";
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
		if(realPass.length() > 0){
			result="账号已被注册！请直接登录！";
			c3p0.close(con);
			return result;
			}else{
				int updateCount=0;
				//获取插入结果
				updateCount=dao.registerSql(con, account, new MD5_Encoding().upperMD5(pass));
				//关闭数据库链接
				c3p0.close(con);
					//对结果进行判断
					if(updateCount>0){
						result="注册成功！";
					}else{
						result="插入数据失败，注册失败！";
					}
				}
        return result;	
	}

}
