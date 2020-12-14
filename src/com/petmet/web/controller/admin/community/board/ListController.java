package com.petmet.web.controller.admin.community.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/community/board/list")
public class ListController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request
							, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		String category = request.getParameter("category");
		String startDate = request.getParameter("startDate");
		
		System.out.println(search);
		System.out.println(category);
		System.out.println(startDate);
	}
	
	@Override
	protected void doGet(HttpServletRequest request
							, HttpServletResponse response) throws ServletException, IOException {
		
	}
}