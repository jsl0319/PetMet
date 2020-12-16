package com.petmet.web.controller.admin.community.category;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.BoardCategory;
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
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardCategoryService service = new BoardCategoryService();

		String button = request.getParameter("button");
		
		String[] dels = request.getParameterValues("del");
		String[] newNames = request.getParameterValues("new-name");
		String[] names = request.getParameterValues("name");
		
		// --------------------- 삭제 ---------------------
		if (dels != null) {
			int[] ids = new int[dels.length];

			for (int i = 0; i < dels.length; i++)
				ids[i] = Integer.parseInt(dels[i]);

			service.deleteList(ids);
		}
		
		// --------------------- 삽입 ---------------------
		if(newNames != null) {
			List<BoardCategory> list = new ArrayList<BoardCategory>();
			
			for (int i = 0; i < newNames.length; i++) {
				BoardCategory b = new BoardCategory(i, newNames[i]);
				list.add(b);
			}
			
			service.insertList(list);
		}
		
		// --------------------- 수정 ---------------------
		
		// --------------------- 요청 ---------------------
		response.sendRedirect("list");
	}
}
