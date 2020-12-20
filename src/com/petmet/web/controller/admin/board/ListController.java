package com.petmet.web.controller.admin.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.Notice;
import com.petmet.web.service.NoticeService;

@WebServlet("/admin/community/notice/list")
public class ListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String query_ = request.getParameter("q");
		String startDate_ = request.getParameter("sd");
		String endDate_ = request.getParameter("ed");
		String page_ = request.getParameter("p");

		String query = "";
		String startDate = "01-01-01";
		String endDate = "22-12-31";
		int page = 1;
		int num = 10;

		if (query_ != null && !query_.equals(""))
			query = query_;

		if (page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);

		if (startDate_ != null && !startDate_.equals(""))
			startDate = startDate_;

		if (endDate_ != null && !endDate_.equals(""))
			endDate = endDate_;
		


		NoticeService service = new NoticeService();
		
		

		List<Notice> list = service.getList(query, startDate, endDate, page, num);
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		//----------------------------------------------------
		NoticeService service = new NoticeService();

		String[] delIds = request.getParameterValues("del-id");

		if (delIds != null) {
			System.out.print(delIds);
			int[] ids = new int[delIds.length];
				
			for (int i = 0; i < delIds.length; i++)
				ids[i] = Integer.parseInt(delIds[i]);
			int result = service.delNoticeAll(ids);
			
		}


		response.sendRedirect("list");// 겟요청을 받기위해 재요청.

	}

}