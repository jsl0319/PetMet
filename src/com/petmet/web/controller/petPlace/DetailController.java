package com.petmet.web.controller.petPlace;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.PetPlaceView;
import com.petmet.web.entity.ReviewView;
import com.petmet.web.service.PetPlaceService;
import com.petmet.web.service.ReviewService;

@WebServlet("/petplace/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		PetPlaceService ppService = new PetPlaceService();
		PetPlaceView p = ppService.getView(id);
		
		ReviewService rService = new ReviewService();
		List<ReviewView> list = rService.getViewList(id);
		
		request.setAttribute("list", list);
		
		request.setAttribute("p", p);
		request.getRequestDispatcher("/petplace/detail.jsp").forward(request, response);

	}
}
