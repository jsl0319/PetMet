package com.petmet.web.controller.admin.community.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.BoardCategory;
import com.petmet.web.entity.BoardReportView;
import com.petmet.web.service.BoardReportService;

@WebServlet("/admin/community/board/reported")
public class ReportedController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request
							, HttpServletResponse response) throws ServletException, IOException {
		
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String board_ = request.getParameter("b");
		String startDate_ = request.getParameter("sd");
		String endDate_ = request.getParameter("ed");
		String size_ = request.getParameter("s");
		String page_ = request.getParameter("p");
		
		String field = "title";
		if(field_ != null && !field_.equals(""))
			field = field_;
		
		String query = "";
		if(query_ != null && !query_.equals(""))
			query = query_;

		String board = "";
		if(board_ != null && !board_.equals("모든 게시판"))
			board = board_;
		
		String startDate = "01-01-01";
		if(startDate_ != null && !startDate_.equals(""))
			startDate = startDate_;
		
		String endDate = "30-12-31";
		if(endDate_ != null && !endDate_.equals(""))
			endDate = endDate_;
		
		int size = 20;
		if(size_ != null && !size_.equals(""))
			size = Integer.parseInt(size_);
		
		int page = 1;
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		
		BoardReportService service = new BoardReportService();
		List<BoardReportView> list = service.getViewList(field, query, board, startDate, endDate, page, size);
		List<BoardCategory> cList = service.getCategoryList();
		int totalPage = service.getTotalPage(field, query, board, startDate, endDate, page, size);
		
		request.setAttribute("tp", totalPage);
		request.setAttribute("list", list);
		request.setAttribute("cList", cList);
		request.getRequestDispatcher("reported.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardReportService service = new BoardReportService();

		// 삭제
		String[] dels = request.getParameterValues("del");
		
		if (dels != null) {
			int[] ids = new int[dels.length];

			for (int i = 0; i < ids.length; i++)
				ids[i] = Integer.parseInt(dels[i]);

			service.deleteBoardList(ids);
		}

		// --------------------- 요청 ---------------------
		response.sendRedirect("reported");
	}
}
