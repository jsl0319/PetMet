package com.petmet.web.controller.admin.community.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.Board;
import com.petmet.web.entity.Comments;
import com.petmet.web.service.CommentsService;

@WebServlet("/admin/community/comment/detail")
public class DetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request
						, HttpServletResponse response) throws ServletException, IOException {
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		CommentsService service = new CommentsService();
		Board b = service.getBoard(bId);
		Comments c = service.get(id);
		
		request.setAttribute("b", b);
		request.setAttribute("c", c);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}
}
