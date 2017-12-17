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

		//1������û���������
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserService userService = new UserService();
		User user = null;
		try {
			user = userService.login(username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//3��ͨ��user�Ƿ�Ϊnull�ж��û����������Ƿ���ȷ
		if(user!=null){
			//�û�����������ȷ
			//��¼�ɹ� ��ת����վ����ҳ   �ض���
			//response.sendRedirect(request.getContextPath()+"/index.jsp");
			response.sendRedirect(request.getContextPath());
		}else{
			//�û������������
			//���ص�ǰlogin.jsp
			//ʹ��ת�� ת����login.jsp  ��request���д洢������Ϣ
			request.setAttribute("loginInfo", "�û������������");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}