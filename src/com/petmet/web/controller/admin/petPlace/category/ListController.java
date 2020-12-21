package com.petmet.web.controller.admin.petPlace.category;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.PetPlaceCategory;
import com.petmet.web.entity.PetPlaceCategoryView;
import com.petmet.web.service.PetPlaceCategoryService;

@WebServlet("/admin/petplace/category/list")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String page_ = request.getParameter("p");
		String query_ = request.getParameter("q");

		String query = "";

		int page = 1;
		int size = 5; // 페이지에 표시할 레코드 개수

		if (page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		if (query_ != null && !query_.equals(""))
			query = query_;

		PetPlaceCategoryService service = new PetPlaceCategoryService();
		// List<PetPlaceCategoryView> list = service.getViewList();
		List<PetPlaceCategoryView> list = service.getViewList(query, page, size);
		int totalPages = service.getTotalPage(query, page, size);

		request.setAttribute("tp", totalPages);
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PetPlaceCategoryService service = new PetPlaceCategoryService();

		String button = request.getParameter("button");

		switch (button) {
		case "선택 삭제":
			String[] check = request.getParameterValues("check");

			if (check != null && check.length != 0) {
				int[] ids = new int[check.length];

				for (int i = 0; i < check.length; i++) {
					ids[i] = Integer.parseInt(check[i]);
					service.delete(ids[i]);
				}
			}

			break;

		case "저장":
			String[] newNames = request.getParameterValues("new-name");
			String[] changed = request.getParameterValues("changed");
			String[] changedIds = request.getParameterValues("changed-id");
			
			for(String s : changedIds)
				System.out.println(s);
			
			
			// 삽입
			if (newNames != null) {
				List<PetPlaceCategory> list = new ArrayList<>();
				for (int i = 0; i < newNames.length; i++) {
					PetPlaceCategory p = new PetPlaceCategory(newNames[i]);
					list.add(p);
				}
				service.insertList(list);
			}

			// 수정
			else if (changedIds != null) {
				List<PetPlaceCategory> list = new ArrayList<>();

				for (int i = 0; i < changedIds.length; i++) {
					int id = Integer.parseInt(changedIds[i]);
					PetPlaceCategory p = service.get(id);
					p.setName(changed[i]);
					list.add(p);
				}
				service.updateList(list);
			}

			break;
		}

		response.sendRedirect("list");

	}

}
