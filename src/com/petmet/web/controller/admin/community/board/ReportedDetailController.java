package com.petmet.web.controller.admin.community.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.Board;
import com.petmet.web.entity.BoardReport;
import com.petmet.web.service.BoardReportService;

@WebServlet("/admin/community/board/reported-detail")
public class ReportedDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request
							, HttpServletResponse response) throws ServletException, IOException {
		
		int boardId = Integer.parseInt(request.getParameter("id"));
		
		BoardReportService service = new BoardReportService();
		Board b = service.getBoard(boardId);
		List<BoardReport> list = service.getListByBoardId(boardId);
		
		request.setAttribute("b", b);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("reported-detail.jsp").forward(request, response);
	}
}
