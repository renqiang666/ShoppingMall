package com.woniuxy.shopping.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.shopping.service.LoginService;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String code=request.getParameter("code");
		//获取真实的验证码
		Object orealCode= request.getSession(true).getAttribute("randCheckCode");
		//将参数传给service进行逻辑验证
		String result=new LoginService().loginCheck(account, pass, code, orealCode);
		if(result.equals("登录成功！")){
			HttpSession session=request.getSession();
			session.setAttribute("account", account);
		}
		//获取响应输出流，输出登录结果
     	ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(), result);
	}

}
