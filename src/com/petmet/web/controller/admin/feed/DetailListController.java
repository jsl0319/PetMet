package com.petmet.web.controller.admin.feed;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.FeedReport;
import com.petmet.web.entity.ReportedFeedView;
import com.petmet.web.service.FeedReportService;


@WebServlet("/admin/feed/detail-list")
public class DetailListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		FeedReportService service = new FeedReportService();
		List<FeedReport> list = service.getList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("detail-list.jsp").forward(request, response);
	}
	
}
