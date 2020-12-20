package com.petmet.web.controller.admin.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.Matching;
import com.petmet.web.service.MatchingService;

@WebServlet("/admin/member/reportlist")
public class ReportListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page_ = request.getParameter("p");
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		
		
		String field = "rep_id";
		String query = "";
	
		int page=1;
		int num=10;
		
		if(page_!= null && !page_.equals(""))
			page = Integer.parseInt(page_);
		if(field_ != null && !field_.equals(""))
			field = field_;
		if(query_ != null && !query_.equals(""))
			query = query_;
		

		MatchingService matchingService = new MatchingService();
		List<Matching> list = matchingService.getReportList(field,query,page,num);
		int count = matchingService.getReportCount(field,query);
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.setAttribute("num", num);

		request.getRequestDispatcher("report-list.jsp").forward(request, response);
	}

}
