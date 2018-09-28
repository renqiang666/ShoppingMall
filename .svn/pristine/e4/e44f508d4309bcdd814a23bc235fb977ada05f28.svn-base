package com.hotelsystem.action.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hotelsystem.bean.RoomTypeBean;
import com.hotelsystem.bean.ViewReserveRoomBean;
import com.hotelsystem.service.user.IRoomTypeService;



/**
 * 
 * @ClassName: Register 
 * @Description: TODO
 * @author jhz
 * @date 2018年8月4日 下午12:10:04 
 * @version v1.0
 */
@Controller
public class RoomTypeAction {
	@Autowired
	private IRoomTypeService roomTypeService;
	
	@RequestMapping("/roomtype.action")
	public ModelAndView showRoomType() {
	
		// 房间类型列表
		List<RoomTypeBean> roomTypeList = roomTypeService.getRoomType();
		ModelAndView model = new ModelAndView();
		model.setViewName("user/index.jsp");
		model.addObject("list", roomTypeList);
		return model;	
	}

	@RequestMapping("/roomTypeDetail.action")
	public ModelAndView showDiscount(Integer id) {
		Map<String, Object> priceMap = roomTypeService.getPriceMap(id);
		ModelAndView model = new ModelAndView();
		model.addObject("map", priceMap);
		model.setViewName("user/best-rooms-detail.jsp");
		return model;
		
	}
	
	@RequestMapping("/checkAvailable.action")
	public @ResponseBody String getTodayRest(@RequestBody ViewReserveRoomBean bean,HttpServletRequest req){ 	
		int res = roomTypeService.availableRoomNumber(bean);
		if(res > 0){
			req.getSession(true).setAttribute("reserveInfo", bean);
			return "showReserveByDate.action";
		}else{
			return "false";
		}	
	}
	@RequestMapping("/showReserveByDate.action")
	public ModelAndView showReserveInfo(HttpServletRequest req){
		ModelAndView model = new ModelAndView();
		HttpSession session = req.getSession(true);
		ViewReserveRoomBean bean = (ViewReserveRoomBean) session.getAttribute("reserveInfo");
		RoomTypeBean roomTypeBean = roomTypeService.getRoomType(bean.getRoomTypeId());
		model.setViewName("user/show-reserve-message.jsp");
		model.addObject("roomTypeBean", roomTypeBean);
		model.addObject("bean",bean);
		return model;
	}
}
