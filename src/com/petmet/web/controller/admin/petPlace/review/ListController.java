package com.petmet.web.controller.admin.petPlace.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.PetPlaceCategoryView;
import com.petmet.web.entity.PetPlaceView;
import com.petmet.web.service.PetPlaceService;

@WebServlet("/admin/petplace/review/list")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String page_ = request.getParameter("p");
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		
		String field = "name";
		String query = "";
		
		int page = 1;
		int size = 10; //페이지에 표시할 레코드 개수
		
		if(page_!= null && !page_.equals(""))
			page = Integer.parseInt(page_);
		if(field_ != null && !field_.equals(""))
			field = field_;
		if(query_ != null && !query_.equals(""))
			query = query_;

		PetPlaceService service = new PetPlaceService();
//		List<PetPlaceView> list = service.getList();
		List<PetPlaceView> list = service.getViewList(field, query, page, size);
		int totalPages = service.getTotalPage(field, query, page, size);

		request.setAttribute("tp", totalPages);
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);

	}

}
