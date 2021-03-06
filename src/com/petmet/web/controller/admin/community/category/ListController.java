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
		
		String page_ = request.getParameter("p");
		int page = 1;
		int size = 5;
		
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		
		BoardCategoryService service = new BoardCategoryService();
		List<BoardCategoryView> list = service.getViewList(page, size);
		int totalPage = service.getPageTotal(size);

		request.setAttribute("list", list);
		request.setAttribute("tp", totalPage);
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardCategoryService service = new BoardCategoryService();

		String button = request.getParameter("button");

		switch(button) {
		case "삭제":
			String[] dels = request.getParameterValues("del");

			if (dels != null) {

				int[] ids = new int[dels.length];

				for (int i = 0; i < ids.length; i++)
					ids[i] = Integer.parseInt(dels[i]);

				service.deleteList(ids);
			}
			
			break;
			
		case "저장":
			String[] newNames = request.getParameterValues("new-name");
			String[] changed = request.getParameterValues("changed");
			String[] changedIds = request.getParameterValues("changed-id");

			// 삽입
			if(newNames != null) {
				List<BoardCategory> list = new ArrayList<BoardCategory>();
				
				for (int i = 0; i < newNames.length; i++) {
					BoardCategory b = new BoardCategory(i, newNames[i]);
					list.add(b);
				}
				
				service.insertList(list);
			}
			
			// 수정
			if (changedIds != null) {
				List<BoardCategory> list = new ArrayList<BoardCategory>();

				for (int i = 0; i < changed.length; i++) {
					int id = Integer.parseInt(changedIds[i]);

					BoardCategory b = service.get(id);
					b.setName(changed[i]);

					list.add(b);
				}

				service.updateList(list);
			}
			break;
		}
		
		// --------------------- 요청 ---------------------
		response.sendRedirect("list");
		
	}
}
