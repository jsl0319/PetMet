package com.petmet.web.controller.admin.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.service.NoticeService;
import com.petmet.web.entity.Notice;

@WebServlet("/admin/community/notice/edit")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class EditController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		NoticeService service = new NoticeService();
		Notice n =service.get(id);
		
		
		request.setAttribute("n", n);
		
		
		
		request.getRequestDispatcher("edit.jsp").forward(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		
		Notice notice = new Notice(title,content);
		notice.setId(Integer.parseInt(id));
		
		NoticeService service = new NoticeService();
		service.update(notice);
		
		response.sendRedirect("detail?id="+id);
	}
	

}
