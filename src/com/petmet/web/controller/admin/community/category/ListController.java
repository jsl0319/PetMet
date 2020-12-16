package com.petmet.web.controller.admin.community.category;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.BoardCategoryView;
import com.petmet.web.service.BoardCategoryService;

@WebServlet("/admin/community/category/list")
public class ListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request
							, HttpServletResponse response) throws ServletException, IOException {
		BoardCategoryService service = new BoardCategoryService();
		List<BoardCategoryView> list = service.getViewList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
}
