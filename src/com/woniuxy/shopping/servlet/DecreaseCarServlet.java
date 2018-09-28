package com.woniuxy.shopping.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.shopping.service.AddCarService;
import com.woniuxy.shopping.service.DecreaseCarService;

/**
 * Servlet implementation class DecreaseCarServlet
 */
@WebServlet("/DecreaseCarServlet")
public class DecreaseCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DecreaseCarServlet() {
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
		//获取客户端传来的登录信息
 	    String goodsid=request.getParameter("goodsid");
 	    Object account=request.getSession().getAttribute("account");
 	    //将参数传给Service进行逻辑验证
 	    DecreaseCarService service=new DecreaseCarService();
 	    String result=service.decreaseCarService(goodsid, account);
 	    //获取响应输出流，输出登录结果
     	ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(), result);
	}

}
