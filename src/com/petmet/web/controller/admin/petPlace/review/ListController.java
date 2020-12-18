package com.petmet.web.controller.admin.petPlace.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.PetPlaceView;
import com.petmet.web.service.PetPlaceService;

@WebServlet("/admin/petplace/review/list")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PetPlaceService service = new PetPlaceService();
		List<PetPlaceView> list = service.getList();

		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);

	}

}
