package com.petmet.web.controller.admin.QnA;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.petmet.web.entity.Answer;
import com.petmet.web.entity.Board;
import com.petmet.web.entity.Question;
import com.petmet.web.service.AnswerService;

import com.petmet.web.service.QuestionService;




	@WebServlet("/admin/community/QnA/detail")
	public class DetailController extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));//아이디 가져오기

			QuestionService qservice = new QuestionService();
			AnswerService aservice = new AnswerService();
			Question q =qservice.get(id);
			Answer a = aservice.get(id);
			
			
			request.setAttribute("q", q);
			request.setAttribute("a", a);
			
			
			
//			q.setAnDate(a.getRegDate());
//			qservice.update(q);
//			
		
			request.getRequestDispatcher("detail.jsp").forward(request,response);
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			int id = Integer.parseInt(request.getParameter("id"));//아이디 가져오기
			String content = request.getParameter("content");
//		
			
			
			
			AnswerService aservice = new AnswerService();
			QuestionService qservice = new QuestionService();
			
//			Answer a = aservice.get(id);
			
			Answer answer = new Answer(id,"관리자",content);
			
			Question q = qservice.get(id);
			
//			answer.setWriterId("관리자");
			
		System.out.print(q.getIsAnswer());
			if (q.getIsAnswer()==null) {
				aservice.insert(answer);
				Answer a = aservice.get(id);
				q.setIsAnswer("");
				qservice.updateAnswer(q);
				
				System.out.print(a.getRegDate());
				q.setAnDate(a.getRegDate());
				qservice.update(q);
				
			}

			else
				aservice.update(answer);
				
		

		
		
			
			response.sendRedirect("list");
		}


}
