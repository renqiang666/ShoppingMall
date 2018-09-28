package com.hotelsystem.action.manager.reserve;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hotelsystem.bean.CheckInPersonBean;
import com.hotelsystem.bean.ReserveNumberBean;
import com.hotelsystem.bean.RoomTypeBean;
import com.hotelsystem.service.manager.reserve.IFindReserveService;
import com.hotelsystem.service.manager.suppermanager.IRoomTypeService;
@Controller
public class ShowDetailAction {
	
	@Autowired
	private IFindReserveService service;
	@Autowired
	private IRoomTypeService roomTypeService;
	
	@RequestMapping(value="/showReservePeopleDetailByManager.action")
	public ModelAndView showReservePeople(int id){
		CheckInPersonBean bean = service.findPersonById(id);
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/edit_reserve_checkInPerson.jsp");
		model.addObject("bean", bean);
		return model;
	}
	
	@RequestMapping(value="/showReserveNumberDetailByManager.action")
	public ModelAndView showReserveNumber(int id){
		Map<String, Object> map = new HashMap<String, Object>();
		ModelAndView model = new ModelAndView();
		ReserveNumberBean  bean = service.findNumberById(id);
		List<RoomTypeBean> list =roomTypeService.findRoomType();
		map.put("bean", bean);
		map.put("list", list);
		model.setViewName("admin/edit_reserve_number.jsp");
		model.addObject("map", map);
		return model;
	}
}
