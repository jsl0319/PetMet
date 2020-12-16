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
public class ListController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NoticeService service = new NoticeService();
		List<Notice> list = service.getList();
		
		req.setAttribute("list",list);
		req.getRequestDispatcher("list.jsp").forward(req,resp);
		

	}
	
}