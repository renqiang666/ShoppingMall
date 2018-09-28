package com.woniuxy.shopping.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.shopping.po.CarGoodsPO;
import com.woniuxy.shopping.po.GoodsPO;
import com.woniuxy.shopping.service.ShowCarService;

/**
 * Servlet implementation class showCarServlet
 */
@WebServlet("/ShowCarServlet")
public class ShowCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取当前登录账户信息
		 Object account=request.getSession().getAttribute("account");
		//创建一个CarGoodsPO型的List，用于接收购物车里的信息
		List<CarGoodsPO> carGoods=new ArrayList<CarGoodsPO>();
		carGoods=new ShowCarService().showCarService(account);
		//创建一个map来存放Service响应的数据
 	    Map<String,Object> map=new HashMap<String,Object>();
 	    map.put("goods",carGoods);
 	    //获取响应输出流，输出登录结果
        ObjectMapper om=new ObjectMapper();
 	    om.writeValue(response.getOutputStream(), map); 
	}

}
