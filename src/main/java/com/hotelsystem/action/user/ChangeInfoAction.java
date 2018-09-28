package com.hotelsystem.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotelsystem.bean.UserInfoBean;
import com.hotelsystem.bean.UserLoginBean;
import com.hotelsystem.service.user.IChangeInfoService;
import com.hotelsystem.service.user.ISendMessageCodeService;
import com.hotelsystem.utils.AesEncodeByteUtil;



/**
 * @author Administrator
 *
 */
@Controller
public class ChangeInfoAction {
	@Autowired
	private IChangeInfoService ciService;
	@Autowired
	private ISendMessageCodeService smService;
	
	@RequestMapping("/changeMail.action")
	public @ResponseBody String changeMail(HttpServletRequest req,String mail){
		System.out.println("cnm");
		String result="change eamil failed";
		HttpSession session=req.getSession(true);
		//取得账户名（手机号）
		String account=(String) session.getAttribute("account");
		if(account==null){
			result="please log in first ";
		}else{
			result=ciService.changeMail(mail, account);
		}
		return result;
	}
	
	@RequestMapping("/showInfo.action")
	public @ResponseBody UserInfoBean showInfo(HttpServletRequest req){
		HttpSession session=req.getSession(true);
		//取得账户名（手机号）
		String result="";
		String account=(String) session.getAttribute("account");
		UserInfoBean bean=null;
		if(account!=null){
			bean=ciService.showInfo(account);
		}
		return bean;
	}
	
	@RequestMapping("/changePassCode.action")
	public @ResponseBody String changePassCode(HttpServletRequest req,String tel){
		String result="get code failed";
		HttpSession session=req.getSession(true);
		String account="";
		String stel="";
		if(tel!=null){
			try {
				stel=AesEncodeByteUtil.decryptAES(tel).trim();
				account=stel;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			account=(String) session.getAttribute("account");
		}
		if(tel==null && account==null){
			result="please enter tel first";
			return result;
		}	
		result=smService.judgeAccount(account);
		if(result.equals("存在此账号")){
			String changePassCode=smService.findPassCode(account);
			session.setAttribute("changePassCode", changePassCode);
			session.setAttribute("changePassTel", stel);
		}else{
			result="please register first";
		}
		return result;
	}

	@RequestMapping("/changePass.action")
	public @ResponseBody String changePass(HttpServletRequest req,String tel,String pass,String code){
		String result="change pass failed";
		HttpSession session=req.getSession(true);
		//取得账户名（手机号）
		String account=(String) session.getAttribute("changePassTel");
		String changePassCode=(String) session.getAttribute("changePassCode");
		String stel="";
		String spass="";
		String scode="";
		try {
			stel=AesEncodeByteUtil.decryptAES(tel).trim();
			spass=AesEncodeByteUtil.decryptAES(pass).trim();
			scode=AesEncodeByteUtil.decryptAES(code).trim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(account!=null && changePassCode!=null){
			if(account.equals(stel) && changePassCode.equals(scode)){
				result=ciService.changePass(spass, account);
			}else{
				result="code was wrong";
			}
		}else{
			result="please get code first";
		}
		return result;
	}
}
