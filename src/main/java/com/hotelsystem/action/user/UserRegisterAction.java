package com.hotelsystem.action.user;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotelsystem.bean.UserInfoBean;
import com.hotelsystem.bean.UserLoginBean;
import com.hotelsystem.service.user.ILoginRegisterService;
import com.hotelsystem.service.user.ISendMessageCodeService;
import com.hotelsystem.utils.AesEncodeByteUtil;

@Controller
public class UserRegisterAction {
	@Autowired
	private ILoginRegisterService lrService;
	@Autowired
	private ISendMessageCodeService smService;
	
	@RequestMapping("/judgeAccount.action")
	public @ResponseBody String judgeAccount(HttpServletRequest req,String account){
		String result="have register";
		result=smService.judgeAccount(account);
		if(result.equals("This account does not exist")){
			result="ok";
		}else if(result.equals("存在此账号")){
			result="have already registered";
		}
		return result;
	}
	
	@RequestMapping("/registerCode.action")
	public @ResponseBody String registerCode(HttpServletRequest req,String account){
		String result="code sending failed";	
		String saccount="";
		try {
			saccount=AesEncodeByteUtil.decryptAES(account).trim();
		} catch (Exception e) {
			return result;
		}
		result=smService.judgeAccount(saccount);
		if(result.equals("This account does not exist")){
			//数据库不存在此账号，发短信，存手机号与验证码，待验证
			String code=smService.registerCode(saccount);
			HttpSession session=req.getSession(true);
			session.setAttribute("registerTel",saccount);
			session.setAttribute("registerCode", code);
			result="sent code";
		}
		System.out.println(result);
		return result;	
	}
	
	@RequestMapping("/userRegister.action")
	public @ResponseBody String userRegister(HttpServletRequest req,UserLoginBean bean1, UserInfoBean bean2,String code){
		String result="Verification code expiration";
		HttpSession session=req.getSession(true);
		String registerTel=(String) session.getAttribute("registerTel");
		String registerCode=(String) session.getAttribute("registerCode");
		String account=bean1.getAccount();
		String pass=bean1.getPass();
		String saccount="";
		String spass="";
		String scode="";
		try {
			saccount=AesEncodeByteUtil.decryptAES(account).trim();
			spass=AesEncodeByteUtil.decryptAES(pass).trim();
			scode=AesEncodeByteUtil.decryptAES(code).trim();
			bean1.setAccount(saccount);
			bean1.setPass(spass);
		} catch (Exception e) {
		
			result="pass was wrong";
			return result;
		}
		result=lrService.JuadgRegisterService(registerTel, bean1.getAccount(), registerCode, scode);
		
		if(result.equals("ok")){
			result=lrService.newUser(bean1, bean2);
			session.setAttribute("account", bean1.getAccount());
		}
		return result;
	}
	
	@RequestMapping("/logout.action")
	public void  userRegister(HttpServletRequest req,HttpServletResponse res){
		HttpSession session=req.getSession(true);
		session.removeAttribute("account");
		try {
			res.sendRedirect("roomtype.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
