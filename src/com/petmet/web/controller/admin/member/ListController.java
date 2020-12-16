package com.petmet.web.controller.admin.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.Member;
import com.petmet.web.service.MemberService;

@WebServlet("/admin/member/list")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemberService memberService = new MemberService();
		List<Member> list = memberService.getList();
		request.setAttribute("list", list);

		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

}
