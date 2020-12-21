package com.petmet.web.controller.admin.QnA;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.Answer;
import com.petmet.web.entity.BoardCategory;
import com.petmet.web.entity.BoardView;
import com.petmet.web.entity.Notice;
import com.petmet.web.entity.Question;
import com.petmet.web.service.AnswerService;
import com.petmet.web.service.BoardService;
import com.petmet.web.service.NoticeService;
import com.petmet.web.service.QuestionService;


@WebServlet("/admin/community/QnA/list")
public class ListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String query_ = request.getParameter("q");
		String startDate_ = request.getParameter("sd");
		String endDate_ = request.getParameter("ed");
		String page_ = request.getParameter("p");
		String size_ = request.getParameter("s");

		String query = "";
		String startDate = "01-01-01";
		String endDate = "22-12-31";
		int page = 1;
		int size = 10;

		if (query_ != null && !query_.equals(""))
			query = query_;

		if (page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);

		if (startDate_ != null && !startDate_.equals(""))
			startDate = startDate_;

		if (endDate_ != null && !endDate_.equals(""))
			endDate = endDate_;
		
	


		QuestionService qservice = new QuestionService();
		List<Question> qlist = qservice.getList(query, startDate, endDate, page, size);
		
		
		
		
		request.setAttribute("qlist",qlist);
		
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}


	
	
	
	
	

	}


