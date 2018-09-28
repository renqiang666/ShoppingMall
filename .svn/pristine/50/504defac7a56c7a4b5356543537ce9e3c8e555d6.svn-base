package com.hotelsystem.action.manager.display;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hotelsystem.bean.GuestBean;
import com.hotelsystem.bean.MenmbersBean;
import com.hotelsystem.service.manager.suppermanager.IMenmbersService;


@Controller(value="members2")
public class MenmbersAction {
	
	
	@Autowired
	private IMenmbersService iMenmbersService;
	
	
	
	/**
	 * 查询所有会员信息
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/MenmbersAction_findAll.action")
	public String findAllMenmbers(HttpServletRequest req){
		PageInfo page=iMenmbersService.checkAllMenmbers(1);
		req.setAttribute("page", page);
		return "/admin/menmbersdisplay.jsp";
	}

	@RequestMapping(value="/searchMenmbers.action")
	public @ResponseBody List<MenmbersBean> searchMenmbers(String select1,String condition){
		List<MenmbersBean> menmbers=new ArrayList<MenmbersBean>();
			if(select1.equals("forTel")){
				MenmbersBean menmber=iMenmbersService.checkIdByMenmbers(condition);
				if(menmber!=null){
					menmbers.add(menmber);
				}else{
					return null;
				}
			}else{
				menmbers=iMenmbersService.findMenmbersByName(condition);
			}
			return menmbers;
	}
	
	@RequestMapping(value="/pageMenmbers.action")
	public @ResponseBody PageInfo searchAllMenmbers(int pageNum){
		PageInfo page=iMenmbersService.checkAllMenmbers(pageNum);
		return page;
	}
	
}
