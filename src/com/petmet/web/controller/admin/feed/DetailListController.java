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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String page_ = request.getParameter("p");
		String query_ = request.getParameter("q");
		String field_ = request.getParameter("f");
		String startDate_ = request.getParameter("sd");
		String endDate_ = request.getParameter("ed");
		
		
		
		String field = "feed_id";
		String query = "";
		String startDate = "01-01-01";
		String endDate = "30-12-31";
		
		
		int page = 1;
		int size = 10;
		
		
		
		
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


		FeedReportService service = new FeedReportService();
		List<FeedReport> list = service.getList(field, query, startDate, endDate, page, size);
		
		int count = service.getListCount(field, query);
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		
		request.getRequestDispatcher("detail-list.jsp").forward(request, response);
	}
	
}
