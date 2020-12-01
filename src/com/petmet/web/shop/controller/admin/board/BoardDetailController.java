package com.petmet.web.shop.controller.admin.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.shop.entity.Board;
import com.petmet.web.shop.service.BoardService;


@WebServlet("/admin/shop/post/detail")
public class BoardDetailController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		BoardService service = new BoardService();
		Board b = service.get(id);

		request.setAttribute("b", b);
		request.getRequestDispatcher("/admin/shop/post/detail.jsp").forward(request, response);

	}

}