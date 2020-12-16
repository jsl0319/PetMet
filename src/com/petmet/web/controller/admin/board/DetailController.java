package com.petmet.web.controller.admin.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.Notice;
import com.petmet.web.service.NoticeService;



@WebServlet("/admin/community/notice/detail")
public class DetailController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));//아이디 가져오기

		NoticeService service = new NoticeService();
		Notice n =service.get(id);
		
		
		request.setAttribute("n", n);
		
		
		
		request.getRequestDispatcher("detail.jsp").forward(request,response);
	}

}