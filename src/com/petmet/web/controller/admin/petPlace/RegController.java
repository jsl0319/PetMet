package com.petmet.web.controller.admin.petPlace;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.PetPlace;
import com.petmet.web.service.PetPlaceService;

@WebServlet("/admin/petplace/reg")
public class RegController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getMethod().equals("GET"))
			request.getRequestDispatcher("reg.jsp").forward(request, response);
		else if(request.getMethod().equals("POST")) {
			
			String categoryId = request.getParameter("categoryId");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String homepage = request.getParameter("homepage");
			String phone = request.getParameter("phone");
			String location = request.getParameter("location");
			String content = request.getParameter("content");
			String files = request.getParameter("files");
			PetPlace pp = new PetPlace(categoryId, name, address, homepage, phone, location, content, files);
			
			PetPlaceService service = new PetPlaceService();
			service.insert(pp);
			
			response.sendRedirect("list");
		}
	}
}
