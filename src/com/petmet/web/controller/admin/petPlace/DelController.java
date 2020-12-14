package com.petmet.web.controller.admin.petPlace;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.service.PetPlaceService;

@WebServlet("/admin/petplace/del")
public class DelController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		PetPlaceService service = new PetPlaceService();
		int result = service.delete(id);

		response.sendRedirect("list");
	}
}
