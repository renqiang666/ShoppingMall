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
import com.woniuxy.shopping.po.GoodsPO;
import com.woniuxy.shopping.service.GoodsService;

/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet("/GoodsServlet")
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsServlet() {
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
 	    String page=request.getParameter("page");
 	    List<GoodsPO> goods=new ArrayList<GoodsPO>();
 	    int totalPage=0;
 	    //创建一个map来存放Service响应的数据
 	    Map<String,Object> map=new HashMap<String,Object>();
 	    //再把page传给Service
 	   /**
  	    * 获取当前页码的goods
  	    */
 	   GoodsService service=new GoodsService();
 	   goods=service.getGoods(page);
 	  /**
 	   * 获取总页数
 	   */
 	   totalPage=service.getGoodsTotalPage();
 	   //将商品信息和总页数存进map
 	   map.put("currentPage", Integer.parseInt(page));
 	   map.put("goods", goods);
 	   map.put("totalPage", totalPage);
 	   //获取响应输出流，输出登录结果
       ObjectMapper om=new ObjectMapper();
	   om.writeValue(response.getOutputStream(), map);  
	}

}
