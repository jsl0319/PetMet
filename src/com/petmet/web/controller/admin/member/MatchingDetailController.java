package com.petmet.web.controller.admin.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.MatchingView;
import com.petmet.web.service.MatchingService;

@WebServlet("/admin/member/matchingdetail")
public class MatchingDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		MatchingService matchingService= new MatchingService();
		MatchingView matchingView = matchingService.get(id);
		
		request.setAttribute("mt", matchingView);
		request.getRequestDispatcher("matching-detail.jsp").forward(request, response);
	}
}
