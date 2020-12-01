package com.petmet.web.controller.admin.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.Board;
import com.petmet.web.service.BoardService;

@WebServlet
public class ListController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		BoardService service = new BoardService();
		Board b = service.get(id);

		request.setAttribute("b", b);
		request.getRequestDispatcher(".jsp").forward(request, response);
		
		System.out.println("hello");

	}

}
