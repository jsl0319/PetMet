package com.petmet.web.shop.controller.admin.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.shop.entity.Board;
import com.petmet.web.shop.service.BoardService;

@WebServlet("/admin/shop/board/notice")
public class BoardListController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardService service = new BoardService();
		List<Board> list = service.getList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("notice.jsp").forward(request, response);
		
	}

}