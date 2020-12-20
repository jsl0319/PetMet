package com.petmet.web.controller.admin.community.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.Board;
import com.petmet.web.entity.CommentView;
import com.petmet.web.entity.Comments;
import com.petmet.web.service.CommentsService;

@WebServlet("/admin/community/comment/detail")
public class DetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request
						, HttpServletResponse response) throws ServletException, IOException {
		
		String queryString_ = request.getQueryString();
		int equalIndex = queryString_.indexOf("=");
		String queryString = queryString_.substring(0, equalIndex);
		
		CommentsService service = new CommentsService();
		
		switch(queryString) {
		case "id":
			
			int bId = Integer.parseInt(request.getParameter("bId"));
			int id = Integer.parseInt(request.getParameter("id"));
			
			Board b = service.getBoard(bId);
			Comments c = service.get(id);
			
			request.setAttribute("b", b);
			request.setAttribute("c", c);
			request.getRequestDispatcher("detail.jsp").forward(request, response);
			
			break;

		case "prev":
			int prev = Integer.parseInt(request.getParameter("prev"));
			CommentView prevCv = service.getPrev(prev);
			int prevId = prevCv.getId();
			int prevBoardId = prevCv.getBoardId();
			
			response.sendRedirect("?id=" + prevId + "&bId=" + prevBoardId);
			break;
		
		case "next":
			int next = Integer.parseInt(request.getParameter("next"));
			CommentView nextCv = service.getNext(next);
			int nextId = nextCv.getId();
			int nextBoardId = nextCv.getBoardId();
			
			response.sendRedirect("?id=" + nextId + "&bId=" + nextBoardId);
			break;
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		CommentsService service = new CommentsService();
		service.delete(id);
		
		response.sendRedirect("list");
	}
}
