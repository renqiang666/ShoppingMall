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
import com.woniuxy.shopping.po.UsersPO;
import com.woniuxy.shopping.service.ShowPersonInfoService;

/**
 * Servlet implementation class ShowPersonInfoServlet
 */
@WebServlet("/ShowPersonInfoServlet")
public class ShowPersonInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPersonInfoServlet() {
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
		//获取账户信息
		Object account=request.getSession().getAttribute("account");
		List<UsersPO> userPO=new ArrayList<UsersPO>();
		userPO=new ShowPersonInfoService().showPersonInfo(account);
		//创建一个map来存放Service响应的数据
 	    Map<String,Object> map=new HashMap<String,Object>();
 	    map.put("users",userPO);
 	    //获取响应输出流，输出登录结果
        ObjectMapper om=new ObjectMapper();
 	    om.writeValue(response.getOutputStream(), map); 
	}

}
