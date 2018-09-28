package com.hotelsystem.action.manager.reserve;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotelsystem.service.manager.reserve.IDeleteReserveService;

@Controller
public class DeleteReserveAction {
	@Autowired
	private IDeleteReserveService service;
	
	@RequestMapping(value="/deleteMsgAboutReserve.action")
	public String deleteAll(String id,Integer reservePeopleId){
		boolean res = service.deleteReserveService(id,reservePeopleId);
		if(res==true){
			return "admin/show_reserve.jsp";
		}else{
			return "admin/error.jsp";
		}
	}
	@RequestMapping(value="/deletePersonByManager.action")
	public String deletePerson(int id,HttpServletRequest req){
		HttpSession session = req.getSession(true);
		String roomId=(String) session.getAttribute("reserveRoomId");
		String res = service.deleteCheckInPerson(id,roomId);
		if(res=="删除成功"){
			int peopleId=(int) session.getAttribute("reservePeopleId");
			return "redirect:showReserveMessageDetail.action?id="+roomId+"&reservePeopleId="+peopleId;
			
		}
		return "admin/error.jsp";
}
	
	@RequestMapping(value="/deleteNumberByManager.action")
	public String deleteNumber(int id,HttpServletRequest req){
		HttpSession session = req.getSession(true);
		String roomId=(String) session.getAttribute("reserveRoomId");
		String res = service.deleteReserveNumber(id,roomId);
		if(res=="删除成功"){
			
			int peopleId=(int) session.getAttribute("reservePeopleId");
			return "redirect:showReserveMessageDetail.action?id="+roomId+"&reservePeopleId="+peopleId;
			
		}
		return "admin/error.jsp";
	}
}
