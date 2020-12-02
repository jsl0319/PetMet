package com.petmet.web.controller.admin.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.Board;
import com.petmet.web.service.BoardService;

@WebServlet("/admin/community/menu1/reg")
public class RegController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getMethod().equals("GET"))
			request.getRequestDispatcher("reg.jsp").forward(request, response);
		else if(request.getMethod().equals("POST")) {
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			BoardService service = new BoardService();
			Board b = new Board(title,content);
			
			service.insert(b);
			
			response.sendRedirect("list");
			
		}
	}
}
