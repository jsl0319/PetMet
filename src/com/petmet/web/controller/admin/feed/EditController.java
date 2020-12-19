package com.petmet.web.controller.admin.feed;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.FeedReport;
import com.petmet.web.service.FeedReportService;

@WebServlet("/admin/feed/edit")
public class EditController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
				
		FeedReportService service = new FeedReportService();
		FeedReport fr = service.get(id);
		
		request.setAttribute("fr", fr);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		
		FeedReport feedReport = new FeedReport(content);
		feedReport.setId(Integer.parseInt(id));
		
		FeedReportService service = new FeedReportService();
		service.update(feedReport);
		
		response.sendRedirect("detail?id="+id);
	}
}
