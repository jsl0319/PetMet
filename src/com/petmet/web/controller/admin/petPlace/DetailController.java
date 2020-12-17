package com.petmet.web.controller.admin.petPlace;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.PetPlaceView;
import com.petmet.web.service.PetPlaceService;

@WebServlet("/admin/petplace/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		PetPlaceService service = new PetPlaceService();
		PetPlaceView p = service.get(id);

		request.setAttribute("p", p);
		request.getRequestDispatcher("/admin/petplace/detail.jsp").forward(request, response);

	}
}
