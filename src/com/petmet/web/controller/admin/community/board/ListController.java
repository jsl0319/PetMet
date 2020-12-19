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
		
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String board_ = request.getParameter("b");
		String startDate_ = request.getParameter("sd");
		String endDate_ = request.getParameter("ed");
		String size_ = request.getParameter("s");
		String page_ = request.getParameter("p");
		
		String field = "title";
		if(field_ != null && !field_.equals(""))
			field = field_;
		
		String query = "";
		if(query_ != null && !query_.equals(""))
			query = query_;

		String board = "";
		if(board_ != null && !board_.equals("모든 게시판"))
			board = board_;
		
		String startDate = "01-01-01";
		if(startDate_ != null && !startDate_.equals(""))
			startDate = startDate_;
		
		String endDate = "30-12-31";
		if(endDate_ != null && !endDate_.equals(""))
			endDate = endDate_;
		
		int size = 20;
		if(size_ != null && !size_.equals(""))
			size = Integer.parseInt(size_);
		
		int page = 1;
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		
		BoardService service = new BoardService();
		List<BoardView> list = service.getViewList(field, query, board, startDate, endDate, page, size);
		List<BoardCategory> cList = service.getCategoryList();
		int totalPages = service.getTotalPage(field, query, board, startDate, endDate, page, size);
		
		request.setAttribute("tp", totalPages);
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
			// 카테고리 변경 값, 카테고리 변경 아이디
			String[] changed = request.getParameterValues("changed");
			String[] bIds = request.getParameterValues("changed-id");

			// 수정
			if (bIds != null) {
				List<Board> list = new ArrayList<Board>();

				for (int i = 0; i < changed.length; i++) {
					int id = Integer.parseInt(bIds[i]);
					int cid = Integer.parseInt(changed[i]);
					
					Board b = service.get(id);
					b.setCategoryId(cid);

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