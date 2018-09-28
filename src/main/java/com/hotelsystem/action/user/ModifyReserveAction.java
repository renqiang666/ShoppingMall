package com.hotelsystem.action.user;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.hotelsystem.bean.ViewReserveRoomBean;
import com.hotelsystem.service.user.IReserveRoomService;

@Controller
public class ModifyReserveAction {
	@Autowired
	private IReserveRoomService service;

	@RequestMapping("/modifyReserve.action")
	public ModelAndView showReserveInfo(@RequestParam String reserveRoomId) {
		ModelAndView mav = new ModelAndView();
		List<ViewReserveRoomBean> views = service.showReserveInfo(reserveRoomId);
		mav.addObject("list", views);
		mav.setViewName("user/modifyReserve.jsp");

		return mav;

	}


}
