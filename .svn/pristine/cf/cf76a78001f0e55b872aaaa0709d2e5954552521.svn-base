package com.hotelsystem.action.manager.display;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotelsystem.bean.GuestBean;
import com.hotelsystem.service.manager.checkin.IGuestService;



@Controller(value="guest2")
public class GuestAction {
	
	@Autowired
	private IGuestService guestService;
	
	/**
	 * 对宾客的条件查询
	 * @param select1
	 * @param condition
	 * @return
	 */
	@RequestMapping("/searchGuest.action")
	public @ResponseBody List<GuestBean> findGuestById(String select1,String condition){
		List<GuestBean> guests=new ArrayList<GuestBean>();
		if(condition.equals("")){
			guests=guestService.findAll();
		}else{
			if(select1.equals("byId")){
				GuestBean guestBean=guestService.findGuestById(condition);
				if(guestBean!=null){
					guests.add(guestBean);
				}
			}else if(select1.equals("byName")){
				guests=guestService.findGuestByName(condition);
			}else{
				int id=Integer.parseInt(condition);
				guests=guestService.findGuestByRoomId(id);
			}
		}
		return guests;
	}
	
	/**
	 * 查询所有宾客
	 * @param req
	 * @return
	 */
	@RequestMapping("/GuestAction_findAll.action")
	public String findAllGuest(HttpServletRequest req){
		List<GuestBean> guestBeans=guestService.findAll();
		req.setAttribute("guests", guestBeans);
		return "/admin/guestsdisplay.jsp";
	}
	
	
}
