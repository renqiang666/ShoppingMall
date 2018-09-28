package com.hotelsystem.action.manager.suppermanager;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hotelsystem.bean.ManagerLoginBean;
import com.hotelsystem.service.manager.suppermanager.IManagerLoginService;
import com.hotelsystem.service.manager.suppermanager.IManagerRecordService;

@Controller
public class ManageLoginAction {
	@Autowired
	private IManagerLoginService service;
	@Autowired
	private IManagerRecordService service1;
	@RequestMapping(value="/ManageLoginAction.action")
	public  @ResponseBody String loginAction(String uname,String upwd,HttpServletRequest req){
		String result=service.loginManager(uname,upwd);
		
		System.out.println(uname);
			if(result.equals("登录成功")){
			int identity =service.managerIdentity(uname);
			HttpSession session= req.getSession(true);
			
			session.setAttribute("uname",uname);
			System.out.println(session.getAttribute("uname"));
			if(session.getAttribute("uname")!=null){
				System.out.println(session.getAttribute("uname"));
				System.out.println("029310");
				int mrid=service1.punchIn(uname);
				session.setAttribute("mrid",mrid);
			}
			if(identity==1){
				result="超管登录";
			}
			if(identity==0){
				result="管理登录";
			}
		}
		return result;
	}
	@RequestMapping(value="/showManagerAction.action")
	public @ResponseBody PageInfo showManagerAction(Integer current){
		PageInfo page=service.allManager(current);
		return page;
	}
	@RequestMapping(value="/findManagerAction.action")
	public @ResponseBody PageInfo findManagerAction(Integer userid,Integer current){
		
		PageInfo page = service.findIdByManager(userid,current);
		
		
		return page;
	}
	@RequestMapping(value="/addManagerAction.action")
	public  @ResponseBody String addManagerAction(String uname,String upwd){
		String result=service.addManager(uname, upwd);
		return result;
	}
	@RequestMapping(value="/delManagerAction.action")
	public @ResponseBody String delManagerAction(Integer userid){
		String result=service.delManager(userid);
		return result;
	}
	@RequestMapping(value="/outLoginAction.action")
	public @ResponseBody String outLoginAction(HttpServletRequest req) {
		HttpSession	session=req.getSession(true);
		
		int id=(int)session.getAttribute("mrid");
		req.getSession(false);	
		String result=service1.punchOut(id);
		
		return result;
	}
	@RequestMapping(value="/managerIdentityActin.action")
	public @ResponseBody int managerIdentityAction(String uname){
		int idemtity=service.managerIdentity(uname);
		return idemtity;
		}
}
