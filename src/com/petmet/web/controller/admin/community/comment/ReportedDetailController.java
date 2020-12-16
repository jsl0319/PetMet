package com.petmet.web.controller.admin.community.comment;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.CommentReport;
import com.petmet.web.entity.Comments;
import com.petmet.web.service.CommentReportService;

@WebServlet("/admin/community/comment/reported-detail")
public class ReportedDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request
						, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		CommentReportService service = new CommentReportService();
		Comments c = service.getComment(id);
		List<CommentReport> list = service.getListByCommentId(id);
		
		request.setAttribute("c", c);
		request.setAttribute("list", list);
		request.getRequestDispatcher("reported-detail.jsp").forward(request, response);
	}
}
