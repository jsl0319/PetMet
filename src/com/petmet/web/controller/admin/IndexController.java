package com.petmet.web.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.Notice;
import com.petmet.web.entity.Question;
import com.petmet.web.service.NoticeService;
import com.petmet.web.service.QuestionService;

@WebServlet("/admin/index")
public class IndexController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int radio = 1;
		String query = "";
		String startDate = "01-01-01";
		String endDate = "22-12-31";
		int page = 1;
		int size = 10;
		
		NoticeService nService = new NoticeService();
		List<Notice> nList = nService.getList(query, startDate, endDate, page, size);
		
		QuestionService qService = new QuestionService();
		List<Question> qList = qService.getList(query, radio, startDate, endDate, page, size);
		
		request.setAttribute("nList", nList);
		request.setAttribute("qList", qList);
		request.getRequestDispatcher("index.jsp").forward(request,response);
		
	}
	
}