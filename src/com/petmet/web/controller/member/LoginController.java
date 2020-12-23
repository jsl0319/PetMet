package com.petmet.web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.petmet.web.service.MemberService;

@WebServlet("/member/login")
public class LoginController extends HttpServlet{
	
	private MemberService memberService;
	
	public LoginController() {
		memberService = new MemberService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String returnURL = request.getParameter("return-url");
		request.setAttribute("returnUrl", returnURL);
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}
		
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid");
		String pwd = request.getParameter("pwd");
		String returnURL = request.getParameter("return-url");
	
		HttpSession session = request.getSession();
		
		if(memberService.isVaild(mid,pwd)) {
			String mNick = memberService.getNickname(mid);
			session.setAttribute("mid", mid);
			session.setAttribute("mn", mNick);
			if(returnURL != null && !(returnURL.equals(""))) {
				
				response.sendRedirect(returnURL);
			}
			else {
				response.sendRedirect("../index");
			}
			
		}
	}

	
	
}