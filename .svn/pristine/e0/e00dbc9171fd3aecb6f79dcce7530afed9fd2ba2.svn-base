
package com.hotelsystem.action.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotelsystem.bean.CheckInPersonBean;
import com.hotelsystem.bean.ReservePeopleBean;
import com.hotelsystem.bean.ReserveRoomBean;
import com.hotelsystem.service.user.IReserveRoomService;

@Controller
public class ModifyReserveInfo {
	
	@Autowired
	private IReserveRoomService service;
	
	@RequestMapping("/ReserveInfo.action")
	public ModelAndView showReserveInfo(@RequestParam int page, HttpServletRequest req){
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ModelAndView mav = new ModelAndView();
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("account");
		//System.out.println(id);
		PageInfo pages = service.showPage(id,page);
		//List<ViewReserveRoomBean> views = service.showReserveInfo(id);
		//System.out.println(views);
		mav.addObject("pages", pages);
		//mav.addObject("views",views);
		System.out.println(pages);
		mav.setViewName("user/ModifyReserveInfo.jsp");
		//System.out.println(views);
		return mav;
		
	}

	@RequestMapping("/modifyReserveInfo.action")
	public @ResponseBody boolean modifyReserveInfo(@RequestBody List<Map<String, Object>> list){
		
		ObjectMapper mapper = new ObjectMapper();
/*		DeserializationConfig cfg= mapper.getDeserializationConfig();
		cfg.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		mapper.setDeserializationConfig(cfg);
		cfg.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		mapper.setDeserializationConfig(cfg);*/
		ReserveRoomBean room  = mapper.convertValue(list.get(0).get("reserveRoomBean"), ReserveRoomBean.class);
		CheckInPersonBean person  = mapper.convertValue(list.get(1).get("checkInPersonBean"), CheckInPersonBean.class);
		ReservePeopleBean people = mapper.convertValue(list.get(2).get("reservePeopleBean"), ReservePeopleBean.class);
		boolean flag = service.updateReserveInfo(person,  room, people);
		
		return flag;
	}
}