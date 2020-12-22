package com.petmet.web.controller.match;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/match/list")

public class ListController extends HttpServlet{
	//get vs post
//	MatchInfoService m = new MatchInfoService();
//	List<MatchInfoView> list = m.getViewList();
//	
//	for(MatchInfoView mi: list) 
//		System.out.println(mi);
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
}
