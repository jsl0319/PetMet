package com.petmet.web.controller.admin.feed;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.service.FeedReportService;

@WebServlet("/admin/feed/del")
public class DeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		FeedReportService service = new FeedReportService();
		int result = service.delete(id);
		response.sendRedirect("detail-list");
	}
	
}
