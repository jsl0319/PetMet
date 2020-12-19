package com.petmet.web.controller.admin.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.Matching;
import com.petmet.web.entity.MatchingView;
import com.petmet.web.service.MatchingService;

@WebServlet("/admin/member/matchinglist")
public class MatchingListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page_ = request.getParameter("p");
		String field_ = request.getParameter("f");
		String startDate_ = request.getParameter("sd");
		String endDate_ = request.getParameter("ed");
		
		int field = -1;
		String startDate = "01-01-01";
		String endDate = "30-12-31";
		int page=1;
		int num=10;
		
		if(page_!= null && !page_.equals(""))
			page = Integer.parseInt(page_);
		if(field_ != null && !field_.equals(""))
			field = Integer.parseInt(field_);
		if(startDate_ != null && !startDate_.equals(""))
			startDate = startDate_;
		if(endDate_ != null && !endDate_.equals(""))
			endDate = endDate_;

		MatchingService matchingService = new MatchingService();
		List<MatchingView> list = matchingService.getList(field,startDate,endDate,page,num);
		
		request.setAttribute("list", list);

		request.getRequestDispatcher("matching-list.jsp").forward(request, response);
	}

}
