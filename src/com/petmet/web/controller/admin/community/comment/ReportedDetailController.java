package com.petmet.web.controller.admin.community.comment;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.CommentReport;
import com.petmet.web.entity.CommentReportView;
import com.petmet.web.entity.CommentView;
import com.petmet.web.entity.Comments;
import com.petmet.web.service.CommentReportService;
import com.petmet.web.service.CommentsService;

@WebServlet("/admin/community/comment/reported-detail")
public class ReportedDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request
						, HttpServletResponse response) throws ServletException, IOException {
		
		String queryString_ = request.getQueryString();
		int equalIndex = queryString_.indexOf("=");
		String queryString = queryString_.substring(0, equalIndex);
		
		CommentReportService service = new CommentReportService();
		
		switch(queryString) {
		case "id":
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			Comments c = service.getComment(id);
			List<CommentReport> list = service.getListByCommentId(id);
			
			request.setAttribute("c", c);
			request.setAttribute("list", list);
			request.getRequestDispatcher("reported-detail.jsp").forward(request, response);
			
			break;

		case "prev":
			int prev = Integer.parseInt(request.getParameter("prev"));
			CommentReportView prevCv = service.getPrev(prev);
			int prevId = prevCv.getId();
			
			response.sendRedirect("?id=" + prevId);
			break;
		
		case "next":
			int next = Integer.parseInt(request.getParameter("next"));
			CommentReportView nextCv = service.getNext(next);
			int nextId = nextCv.getId();
			
			response.sendRedirect("?id=" + nextId);
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		CommentsService service = new CommentsService();
		service.delete(id);
		
		response.sendRedirect("reported");
	}
}
