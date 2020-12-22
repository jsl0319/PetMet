package com.petmet.web.controller.api.feed;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.petmet.web.entity.FeedReport;
import com.petmet.web.entity.ReportedFeedView;
import com.petmet.web.service.FeedReportService;

@WebServlet("/api/feed/list")

public class ListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청 결과 페이지 인코딩
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json; charset=UTF-8");
		
		String field = "reported_id";
		String query = "";
		
		int page = 1;
		int size = 10;
		
		String page_ = request.getParameter("p"); 
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		if(field_ != null && !field_.equals(""))
			field = field_;
		if(query_ != null && !query_.equals(""))
			query = query_;
		
		
		FeedReportService service = new FeedReportService();
		List<ReportedFeedView> list = service.getViewList("reportedId", "%%", page, size);
		
		
		//list를 변수에 담아서
		String json = new Gson().toJson(list);
		
		//결과 출력
		response.getWriter().println(json);
		
		
//		request.setAttribute("list", list);
//		request.setAttribute("count", count);
//		int count = service.getViewListCount(field, query);
		
//		request.getRequestDispatcher("list.jsp").forward(request, response);
		
		
		
		
		
		
		
		
	}
	

}
