package com.hotelsystem.action.manager.checkin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotelsystem.bean.CheckInBean;
import com.hotelsystem.bean.GuestBean;
import com.hotelsystem.bean.HotelDiscountBean;
import com.hotelsystem.bean.MenmbersBean;
import com.hotelsystem.service.manager.checkin.ICheckInService;
import com.hotelsystem.service.manager.checkin.IGuestService;
import com.hotelsystem.service.manager.suppermanager.IHotelDiscountService;
import com.hotelsystem.service.manager.suppermanager.IMenmbersService;
import com.hotelsystem.service.manager.suppermanager.IOverTimeService;
import com.hotelsystem.utils.AesEncodeTUtil;

/**
 * @ClassName testAction
 * @Description TODO:
 * @Author Li Gen
 * @Date 2018年8月13日 下午3:21:57
 * @Version 1.0
 **/
@Controller
public class CheckInAction {
	@Autowired
	private IGuestService service;
	@Autowired
	private ICheckInService cservice;
	@Autowired
	private IOverTimeService oservice;
	@Autowired
	private IHotelDiscountService hotelDiscountService;
	@Autowired
	private IMenmbersService iMenmbersService;

	@RequestMapping("/addCheckIn.action")
	public ModelAndView addCheckIn(CheckInBean bean) {
		cservice.addCheckIn(bean);
		ModelAndView model = new ModelAndView();
		model.setViewName("/findAllByPage.action");
		return model;
	}

	@RequestMapping("/findAllByPage.action")
	public ModelAndView findAllByPage(
			@RequestParam(value = "page", defaultValue = "1") Integer page) {
		// 开始分页，page默认值是1，pageSize默认是10，意思是从第1页开始，每页显示10条记录。
		PageHelper.startPage(page, 10);
		List<CheckInBean> CheckInList = cservice.findAll();
		List<GuestBean> GuestList = service.findAll();
		PageInfo p = new PageInfo(CheckInList);
		ModelAndView model = new ModelAndView();
		model.addObject("page", p);
		model.addObject("CheckInList", CheckInList);
		model.addObject("GuestList", GuestList);
		model.setViewName("admin/right.jsp");
		return model;
	}

	@RequestMapping("/findCheckInByRid.action")
	public ModelAndView findCheckInByRid(
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			Integer rid) {
		// 开始分页，page默认值是1，pageSize默认是10，意思是从第1页开始，每页显示10条记录。
		PageHelper.startPage(page, 10);
		List CheckInList = cservice.findCheckInByRid(rid);
		List<GuestBean> GuestList = service.findAll();
		PageInfo p = new PageInfo(CheckInList);
		ModelAndView model = new ModelAndView();
		model.addObject("page", p);
		model.addObject("CheckInList", CheckInList);
		model.addObject("GuestList", GuestList);
		model.setViewName("admin/right.jsp");
		return model;
	}

	@RequestMapping("/CheckDetail.action")
	public ModelAndView checkDetail(@RequestParam String cid) {
		ModelAndView modelAndView = new ModelAndView();
		CheckInBean checkInBean = cservice.queryById(cid);
		if (checkInBean != null) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String a = df.format(checkInBean.getLeaveTime());
			Date expectDate = null;
			try {
				expectDate = df.parse(a);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			double money = oservice.countOverTimeFee(
					checkInBean.getLeaveTime(), new Date(), checkInBean
							.getRoom().getRoomType().getName(), 1);
			int overTime = oservice.countOverTime(expectDate, new Date());
			overTime = overTime / 2 + 1;
			HotelDiscountBean hotelDiscountBean = hotelDiscountService
					.findDiscountByDate();
			money = cservice.judgeMoeny(overTime, money, checkInBean,
					hotelDiscountBean);
			Map<String, Object> map = new HashMap<>();
			map.put("checkInBean", checkInBean);
			map.put("overTime", overTime);
			map.put("money", money);
			map.put("hotel", hotelDiscountBean);
			modelAndView.addObject("maps", map);
			modelAndView.setViewName("/admin/checkInDetail.jsp");
		} else {
			modelAndView.setViewName("/admin/error.jsp");
		}
		return modelAndView;
	}

	/**
	 * 查询会员折扣
	 */
	@RequestMapping("/VipCheck.action")
	public @ResponseBody Map<String, Object> vipCheck(
			@RequestParam String moneys, String phone) {
		String money = "";
		String res = "";
		double memberCount = 1;
		double vipLeve = 0;
		try {
			money = (AesEncodeTUtil.decryptAES(moneys)).trim();

		} catch (Exception e) {
			e.printStackTrace();
		}
		MenmbersBean menmbersBean = iMenmbersService.checkIdByMenmbers(phone);
		vipLeve = cservice.findLev(menmbersBean);
		System.out.println("vipLeve" + vipLeve);
		money = cservice.judgePaidMoney(menmbersBean, money, vipLeve);
		res = cservice.judgeRes(menmbersBean);
		Map<String, Object> maps = new HashMap<>();
		maps.put("money", money);
		maps.put("res", res);
		maps.put("memberCount", memberCount);
		maps.put("vipLeve", vipLeve);
		return maps;
	}

	@RequestMapping("/colPrice.action")
	public @ResponseBody Map<String, Object> colPrice(@RequestParam int roomId,
			int day) {
		double price = cservice.colPrice(roomId, day);
		String p = String.valueOf(price);
		String money = null;
		try {
			money = AesEncodeTUtil.encryptAES(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<>();
		map.put("price", money);
		return map;
	}

	@RequestMapping("/extendCheckIn.action")
	public ModelAndView extendCheckIn(CheckInBean bean) {
		cservice.extend(bean.getRoom().getId(), bean.getStayDays(),
				bean.getPaidMoney());
		ModelAndView model = new ModelAndView();
		model.setViewName("/findAllByPage.action");
		return model;

	}
}
