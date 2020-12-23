package com.petmet.web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.petmet.web.service.AdminService;

@WebServlet("/admin/login")
public class LoginController extends HttpServlet{
	
	private AdminService adminService;
	
	public LoginController() {
		adminService = new AdminService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}
		
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aid = request.getParameter("aid");
		String pwd = request.getParameter("pwd");
	
	
		HttpSession session = request.getSession();
		System.out.println(aid);
		if(adminService.isVaild(aid,pwd)) {
			System.out.println("실행되야되는데");
			session.setAttribute("aid", aid);
			response.sendRedirect("index");
		}
	}

	
	
}