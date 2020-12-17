package com.petmet.web.controller.admin.petPlace;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.PetPlace;
import com.petmet.web.entity.PetPlaceCategory;
import com.petmet.web.service.PetPlaceCategoryService;
import com.petmet.web.service.PetPlaceService;

@WebServlet("/admin/petplace/edit")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class EditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// PetPlace
		int id = Integer.parseInt(request.getParameter("id"));
		PetPlaceService service = new PetPlaceService();
		PetPlace pp = service.get(id);

		request.setAttribute("pp", pp);
		
		//PetPlace Category
		PetPlaceCategoryService ppcService = new PetPlaceCategoryService();
		List<PetPlaceCategory> list = ppcService.getList();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/admin/petplace/edit.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String homepage = request.getParameter("homepage");
		String phone = request.getParameter("phone");
		String location = request.getParameter("location");
		String content = request.getParameter("content");
		String files = request.getParameter("files");
		int pub = Integer.parseInt(request.getParameter("pub")); 
		
		PetPlace pp = new PetPlace(id, categoryId, name, address, homepage, phone, location, content, files, pub);
		
		PetPlaceService service = new PetPlaceService();
		service.update(pp);
		
		response.sendRedirect("detail?id="+id);

	}
}
