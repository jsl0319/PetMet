package com.petmet.web.controller.admin.community.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.Board;
import com.petmet.web.entity.BoardCategory;
import com.petmet.web.entity.BoardReport;
import com.petmet.web.entity.BoardReportView;
import com.petmet.web.entity.BoardView;
import com.petmet.web.service.BoardReportService;
import com.petmet.web.service.BoardService;

@WebServlet("/admin/community/board/reported-detail")
public class ReportedDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String queryString_ = request.getQueryString();
		int equalIndex = queryString_.indexOf("=");
		String queryString = queryString_.substring(0, equalIndex);

		BoardReportService service = new BoardReportService();
		
		switch(queryString) {
		case "id":
			int boardId = Integer.parseInt(request.getParameter("id"));

			BoardView b = service.getBoardView(boardId);

			List<BoardReport> list = service.getListByBoardId(boardId);

			request.setAttribute("b", b);
			request.setAttribute("list", list);

			request.getRequestDispatcher("reported-detail.jsp").forward(request, response);
			
			break;

		case "prev":
			int prev = Integer.parseInt(request.getParameter("prev"));
			BoardReportView preBv = service.getPrev(prev);
			int prevId = preBv.getBoardId();
			
			response.sendRedirect("?id=" + prevId);
			break;
		
		case "next":
			int next = Integer.parseInt(request.getParameter("next"));
			BoardReportView nextBv = service.getNext(next);
			int nextId = nextBv.getBoardId();
			
			response.sendRedirect("?id=" + nextId);
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service = new BoardService();
		int id = Integer.parseInt(request.getParameter("id"));
		service.delete(id);
		
		response.sendRedirect("reported");
	}
	
}
