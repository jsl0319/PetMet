package com.petmet.web.controller.admin.community;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.Board;
import com.petmet.web.service.BoardService;

@WebServlet("/admin/community/menu1/list")
public class ListController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BoardService service = new BoardService();
		List<Board> list = service.getList();
					
		request.setAttribute("list", list);
		request.getRequestDispatcher("/admin/community/menu1/list.jsp").forward(request, response);
	}

}
