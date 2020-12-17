package com.petmet.web.controller.admin.community.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.Board;
import com.petmet.web.entity.BoardCategory;
import com.petmet.web.entity.BoardView;
import com.petmet.web.service.BoardService;

@WebServlet("/admin/community/board/list")
public class ListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request
							, HttpServletResponse response) throws ServletException, IOException {
		
		BoardService service = new BoardService();
		List<BoardView> list = service.getViewList();
		List<BoardCategory> cList = service.getCategoryList();
		
		request.setAttribute("list", list);
		request.setAttribute("cList", cList);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardService service = new BoardService();

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
			String[] names = request.getParameterValues("name");
			String[] bIds = request.getParameterValues("id");

			// 수정
			if (bIds != null) {
				List<Board> list = new ArrayList<Board>();

				for (int i = 0; i < bIds.length; i++) {
					int id = Integer.parseInt(bIds[i]);

					Board b = service.get(id);
					b.setCategoryId(names[i]);

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