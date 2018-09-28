package com.hotelsystem.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hotelsystem.service.user.ILoginRegisterService;
import com.hotelsystem.service.user.ISendMessageCodeService;
import com.hotelsystem.utils.AesEncodeByteUtil;
import com.hotelsystem.utils.AesEncodeUtil;

@Controller
public class UserLoginAction {
	@Autowired
	private ILoginRegisterService lrService;
	@Autowired
	private ISendMessageCodeService smService;
	
	
	@RequestMapping("/accountLogin.action")
	public @ResponseBody String userLogin1(HttpServletRequest req,String account,String pass,String vercode){
		HttpSession session=req.getSession(true);
		String scount=(String)session.getAttribute("count");
		if(scount==null){
			session.setAttribute("count", "0");
		}else if(Integer.parseInt(scount)>=3){
			return "password error too many times";
		}
		String saccount="";
		String spass="";
		try {
			saccount=AesEncodeByteUtil.decryptAES(account).trim();
			spass=AesEncodeByteUtil.decryptAES(pass).trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String result="login failed";	
		String realCode=(String)session.getAttribute("randCheckCode");
		result=lrService.accountLogin(saccount, spass, realCode, vercode);
		//判断是否登陆成功
		if(result.equals("登陆成功")){
			//如果成功，session存入值
			session.setAttribute("account", saccount);	
			session.removeAttribute("count");
		}else if(result.equals("pass was wrong")){
			int count=Integer.parseInt((String)session.getAttribute("count"))+1;
			session.setAttribute("count", Integer.toString(count));
			result+=",you have "+(3-count)+" more chances" ;
		}
		return result;	
	}
	
	@RequestMapping("/loginCode.action")
	public @ResponseBody String loginCode(HttpServletRequest req,String account){
		String saccount="";	
		try {
			saccount=AesEncodeByteUtil.decryptAES(account).trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String result="code sending failed";
		result=smService.judgeAccount(saccount);
		if(result.equals("存在此账号")){
			//数据库存在此账号，发短信，存手机号与验证码，待验证
			String code=smService.loginCode(saccount);
			HttpSession session=req.getSession(true);
			session.setAttribute("realTel", saccount);
			session.setAttribute("realCode", code);
			result="sent code";
		}
		return result;	
	}
	
	
	@RequestMapping("/telLogin.action")
	public  @ResponseBody String userLogin2(HttpServletRequest req,String ifTel,String ifCode){
		String result="login failed";				
		HttpSession session=req.getSession(true);
		String realCode=(String) session.getAttribute("realCode");
		String realTel=(String) session.getAttribute("realTel");
		String sifTel="";	
		String sifCode="";
		try {
			sifTel=AesEncodeByteUtil.decryptAES(ifTel).trim();
			sifCode=AesEncodeByteUtil.decryptAES(ifCode).trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		result=lrService.telLogin(realTel, sifTel, realCode, sifCode);
		if(result.equals("登陆成功")){
			session.setAttribute("account", realTel);
		}		
		return result;	
	}

}
