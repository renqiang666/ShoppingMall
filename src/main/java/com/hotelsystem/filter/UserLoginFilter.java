package com.hotelsystem.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class UserLoginFilter
 */
@WebFilter("/*")
public class UserLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(true);
		String account = (String) session.getAttribute("account");
		String path = req.getRequestURL().toString();
		if((path.endsWith("changeMail.action") || path.endsWith("showInfo.action")
				|| path.endsWith("logout.action")|| path.endsWith("comment.action")
				|| path.endsWith("sendComment.action")|| path.endsWith("alipay.jsp")
				|| path.endsWith("alipaySuccess.jsp") || path.endsWith("contacts.jsp")
				|| path.endsWith("information.jsp") || path.endsWith("ModifyReserveInfo.jsp")
				|| path.endsWith("modifyReserve.jsp")|| path.endsWith("modifyReserve.action")
				|| path.endsWith("modifyReserveInfo.action")|| path.endsWith("ReserveInfo.action")
				|| path.endsWith("goAlipay.action")|| path.endsWith("alipayReturnNotice.action")
				|| path.endsWith("refundOrder.action")|| path.endsWith("reserveRoom.action")
				) && account==null){
			resp.sendRedirect("http://localhost:8080/HotelManagement/roomtype.action");
			}else{
				chain.doFilter(req, resp);
			}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
