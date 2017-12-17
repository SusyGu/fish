package com.njupt.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.njupt.service.UserService;
import com.njupt.domain.User;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//1、获得用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserService userService = new UserService();
		User user = null;
		try {
			user = userService.login(username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//3、通过user是否为null判断用户名和密码是否正确
		if(user!=null){
			//用户名和密码正确
			//登录成功 跳转到网站的首页   重定向
			//response.sendRedirect(request.getContextPath()+"/index.jsp");
			response.sendRedirect(request.getContextPath());
		}else{
			//用户名或密码错误
			//跳回当前login.jsp
			//使用转发 转发到login.jsp  向request域中存储错误信息
			request.setAttribute("loginInfo", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}