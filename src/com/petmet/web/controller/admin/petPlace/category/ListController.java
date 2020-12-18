package com.petmet.web.controller.admin.petPlace.category;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.PetPlaceCategoryView;
import com.petmet.web.service.PetPlaceCategoryService;

@WebServlet("/admin/petplace/category/list")
public class ListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PetPlaceCategoryService service = new PetPlaceCategoryService();
		List<PetPlaceCategoryView> list = service.getViewList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
	}
	
}
