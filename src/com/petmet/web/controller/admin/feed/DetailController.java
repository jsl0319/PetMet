package com.petmet.web.controller.admin.feed;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.FeedReport;
import com.petmet.web.service.FeedReportService;

@WebServlet("/admin/feed/detail")
public class DetailController extends HttpServlet{
	
	  @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  int id = Integer.parseInt(request.getParameter("id"));
		 	
		    FeedReportService service = new FeedReportService();
		 	FeedReport fr = service.get(id);
		 	
		 	
		 	FeedReport next = service.getNext(id);
		 	FeedReport prev = service.getPrev(id);
		 			
		 	
		 	request.setAttribute("fr", fr);
		 	request.setAttribute("next", next);
		 	request.setAttribute("prev", prev);
		 	
		 	
		 	request.getRequestDispatcher("detail.jsp").forward(request, response);
		  
	}
}
