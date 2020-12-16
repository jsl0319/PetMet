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
		
		String page_ = request.getParameter("p"); // null 
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String startDate_ = request.getParameter("sd");
		String endDate_ = request.getParameter("ed");
		
		String field = "nickname";
		String query = "";
		String startDate = "01-01-01";
		String endDate = "30-12-31";
		int page=1;
		int num=10;
		
		if(page_!= null && !page_.equals(""))
			page = Integer.parseInt(page_);
		if(field_ != null && !field_.equals(""))
			field = field_;
		if(query_ != null && !query_.equals(""))
			query = query_;
		if(startDate_ != null && !startDate_.equals(""))
			startDate = startDate_;
		if(endDate_ != null && !endDate_.equals(""))
			endDate = endDate_;

		MemberService memberService = new MemberService();
		List<Member> list = memberService.getList(field,query,startDate,endDate,page,num);
		request.setAttribute("list", list);

		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

}
