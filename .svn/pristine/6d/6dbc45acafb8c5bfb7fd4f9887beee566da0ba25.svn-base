package com.hotelsystem.action.manager.reserve;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotelsystem.bean.CheckInPersonBean;
import com.hotelsystem.bean.ReservePeopleBean;
import com.hotelsystem.bean.ReserveRoomBean;
import com.hotelsystem.service.manager.reserve.IUpdateReserveService;

/**
 * 
 * @ClassName: UpdateReserveAction 
 * @Description: TODO
 * @author jhz
 * @date 2018年8月12日 下午3:06:19 
 * @version v1.0
 */
@Controller
public class UpdateReserveAction {
	@Autowired
	private IUpdateReserveService service;
	
	@RequestMapping(value="/updatePeopleByManager.action")
	public @ResponseBody String updateReservePeopleAction(@RequestBody ReservePeopleBean bean){
		String res = service.updateReservePeople(bean);
		return res;
	}
	@RequestMapping(value="/updateRoomByManager.action")
	public @ResponseBody String updateReserveRoomAction(@RequestBody ReserveRoomBean bean){
		String res=service.updateReserveRoom(bean);
		return res;
	}
	@RequestMapping(value="/updateNumberByManager.action")
	public @ResponseBody String updateReserveNumberAction(@RequestBody List<Map<String, Object>> list){
		String res = service.updateReserveNumber(list);
		return res;
	}
	@RequestMapping(value="/updatePersonByManager.action")
	public @ResponseBody String updateCheckInPersonAction(@RequestBody CheckInPersonBean bean){
		String res = service.updateCheckInPerson(bean);
		return res;
	}
}
