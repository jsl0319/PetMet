package com.petmet.web.controller.admin.QnA;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.Answer;
import com.petmet.web.entity.Question;
import com.petmet.web.service.AnswerService;
import com.petmet.web.service.QuestionService;


@WebServlet("/admin/community/QnA/list")
public class ListController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionService qservice = new QuestionService();
		
		
		List<Question> qlist = qservice.getList();
		
		
		
		
		request.setAttribute("qlist",qlist);
		
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
	
		
	}

}
