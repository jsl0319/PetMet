package com.petmet.web.controller.match;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.MatchInfoView;
import com.petmet.web.service.MatchInfoService;

@WebServlet("/match/list")
public class ListController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MatchInfoService m = new MatchInfoService();
	      List<MatchInfoView> list = m.getViewList();
	      for(MatchInfoView mi : list)
	         System.out.println(mi);
		
		request.getRequestDispatcher("list.jsp").forward(request, response);
	
		
			
	}
	
	
}
