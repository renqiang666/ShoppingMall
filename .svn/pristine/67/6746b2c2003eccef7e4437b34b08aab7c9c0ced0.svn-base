package com.hotelsystem.action.user;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.hotelsystem.bean.CommentBean;
import com.hotelsystem.bean.UserLoginBean;
import com.hotelsystem.service.user.ICommentService;



/**
 * 
 * @ClassName: Register 
 * @Description: TODO
 * @author jhz
 * @date 2018年8月4日 下午12:10:04 
 * @version v1.0
 */
@Controller
public class CommentAction {
	@Autowired
	private ICommentService commentService;				// 注解生成服务层对象
	
	@RequestMapping("/comment.action")					// 得到所有评论
	public ModelAndView showComment(@RequestParam(defaultValue = "1")Integer page) {
		ModelAndView model = new ModelAndView();
		PageInfo pageInfo = commentService.getAllComment(page);

		model.addObject("pageInfo", pageInfo);
		model.setViewName("user/about-us.jsp");
		return model;
		
	}

	@RequestMapping("/sendComment.action")				// 添加一条评论
	public @ResponseBody String  sendComment(HttpServletRequest req,CommentBean bean) {
		HttpSession session=req.getSession(true);
		String account=(String) session.getAttribute("account");
		String result="comment failed";
		if(account!=null){
			UserLoginBean loginBean=new UserLoginBean();
			loginBean.setAccount(account);
		
			bean.setDate(new Date());
			loginBean.setAccount(account);
			int i=commentService.isComment(account);
			if(i==1){
				result=commentService.appendComment(loginBean, bean);
			}else{
				result="You have no right to comment";
			}
		}else{
			result="please log in first!";
		}
		return result;
	}
	
}