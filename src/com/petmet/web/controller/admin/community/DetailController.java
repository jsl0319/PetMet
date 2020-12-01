package com.petmet.web.controller.admin.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.petmet.web.entity.Board;
import com.petmet.web.service.BoardService;

@WebServlet("/admin/community/menu1/detail")
public class DetailController extends HttpServlet{
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		BoardService service = new BoardService();
		Board b = service.get(id);
		
		request.setAttribute("b", b);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}
}
