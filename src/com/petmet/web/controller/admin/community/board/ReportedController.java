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
		
		BoardReportService service = new BoardReportService();
		List<BoardReportView> list = service.getViewList();
		List<BoardCategory> cList = service.getCategoryList();
		
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

			service.deleteList(ids);
		}

		// --------------------- 요청 ---------------------
		response.sendRedirect("reported");
	}
}
