package com.hotelsystem.action.user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotelsystem.bean.CheckInPersonBean;
import com.hotelsystem.bean.ReservePeopleBean;
import com.hotelsystem.bean.ReserveRoomBean;
import com.hotelsystem.bean.RoomTypeBean;
import com.hotelsystem.bean.UserInfoBean;
import com.hotelsystem.service.user.IChangeInfoService;
import com.hotelsystem.service.user.IReserveRoomService;

@Controller
public class ReserveRoomAction {
	@Autowired
	private IReserveRoomService reserveRoomService;
	@Autowired
	private IChangeInfoService ciService;
	@Autowired
	private Sid sid;

	@RequestMapping(value = "/reserveRoom.action")
	public @ResponseBody String addReserveRoom(@RequestBody List<Map<String, Object>> list, HttpServletRequest request){
		ObjectMapper mapper = new ObjectMapper();
/*		DeserializationConfig cfg = mapper.getDeserializationConfig();
		cfg.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		mapper.setDeserializationConfig(cfg);
		cfg.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		mapper.setDeserializationConfig(cfg);*/
		
		// 预订人
		ReservePeopleBean reservePeopleBean = mapper.convertValue(list.get(0).get("reservePeopleBean"),
						ReservePeopleBean.class);
		
		HttpSession session = request.getSession(true);
		// 获取登录人的信息
		// 登录人账号（手机号）
		String tel = (String) session.getAttribute("account");

		// 登录人姓名
		if (tel != null) {
			UserInfoBean userInfoBean = ciService.showInfo(tel);
			reservePeopleBean.setName(userInfoBean.getName());
			reservePeopleBean.setTel(tel);
		}
		
		// 房间预订信息
		ReserveRoomBean reserveRoomBean = mapper.convertValue(list.get(1).get("reserveRoomBean"),
				ReserveRoomBean.class);
		// 生成订单号
		String orderId = sid.nextShort();
		session.setAttribute("reserveRoomId", orderId);
		reserveRoomBean.setId(orderId);
		
		// 获取房间类型
		RoomTypeBean roomTypeBean = mapper.convertValue(list.get(2).get("roomTypeBean"),
				RoomTypeBean.class);
		
		
		// 入住人
		List<CheckInPersonBean> checkList = new ArrayList<CheckInPersonBean>();
		for (int i = 3; i < list.size(); i++) {
			CheckInPersonBean checkInPersonBean = mapper.convertValue(list.get(i).get("checkInPersonBean"),
					CheckInPersonBean.class);;
					checkList.add(checkInPersonBean);
		}

		String result = reserveRoomService.addRseerve(reservePeopleBean, reserveRoomBean, checkList ,roomTypeBean);
		return result;

	}
	@RequestMapping("/determineLogin.action")
	public @ResponseBody boolean determineIsLogin(HttpServletRequest req){
		String account = (String) req.getSession(true).getAttribute("account");
		if(account==null){
			return false;
		}else{
			return true;
		}
	}
}
