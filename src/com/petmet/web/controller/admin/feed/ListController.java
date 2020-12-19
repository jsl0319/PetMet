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

@WebServlet("/admin/feed/list")
public class ListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page_ = request.getParameter("p");
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		
		
		String field = "reported_id";
		String query = "";
		
		int page = 1;
		int num = 13;
		
		
		if(page_!= null && !page_.equals(""))
			page = Integer.parseInt(page_);
		if(field_ != null && !field_.equals(""))
			field = field_;
		if(query_ != null && !query_.equals(""))
			query = query_;
		
		
		
		
		FeedReportService service = new FeedReportService();
		List<ReportedFeedView> list = service.getViewList(field,query,page,num);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
}
