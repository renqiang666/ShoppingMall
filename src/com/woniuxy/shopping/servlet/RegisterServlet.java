package com.woniuxy.shopping.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.shopping.service.LoginService;
import com.woniuxy.shopping.service.RegisterService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
 	    String account=request.getParameter("account");
		String pass=request.getParameter("pass");
		String repass=request.getParameter("repass");
		String code=request.getParameter("code");
		//获取真实的验证码
		Object orealCode= request.getSession().getAttribute("randCheckCode");
		//将参数传给service进行逻辑验证
		String result=new RegisterService().registerCheck(account, pass, repass, code, orealCode);
		//获取响应输出流，输出登录结果
     	ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(), result);
	}

}
