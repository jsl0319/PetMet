package com.petmet.web.controller.admin.community.comment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.BoardCategory;
import com.petmet.web.entity.CommentView;
import com.petmet.web.service.BoardCategoryService;
import com.petmet.web.service.CommentsService;

@WebServlet("/admin/community/comment/list")
public class ListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request
						, HttpServletResponse response) throws ServletException, IOException {
		
		CommentsService service = new CommentsService();
		List<CommentView> list = service.getViewList();
		List<BoardCategory> cList = service.getCategoryList();
		
		request.setAttribute("list", list);
		request.setAttribute("cList", cList);
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CommentsService service = new CommentsService();

		// 삭제
		String[] dels = request.getParameterValues("del");

		if (dels != null) {
			int[] ids = new int[dels.length];

			for (int i = 0; i < ids.length; i++)
				ids[i] = Integer.parseInt(dels[i]);

			service.deleteList(ids);
		}

		// --------------------- 요청 ---------------------
		response.sendRedirect("list");
	}
}
