package com.petmet.web.controller.admin.petPlace;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.PetPlace;
import com.petmet.web.service.PetPlaceService;

@WebServlet("/admin/petplace/edit")
public class EditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		PetPlaceService service = new PetPlaceService();
		PetPlace p = service.get(id);
		
		request.setAttribute("p", p);
		
		request.getRequestDispatcher("/admin/petplace/edit.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String categoryId = request.getParameter("categoryId");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String homepage = request.getParameter("homepage");
		String phone = request.getParameter("phone");
		String location = request.getParameter("location");
		String content = request.getParameter("content");
		String files = request.getParameter("files");
		
		PetPlace pp = new PetPlace(categoryId, name, address, homepage, phone, location, content, files);
		pp.setId(Integer.parseInt(id));
		
		PetPlaceService service = new PetPlaceService();
		service.update(pp);
		
		response.sendRedirect("detail?id="+id);

	}
}
