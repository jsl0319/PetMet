package com.petmet.web.controller.api.petPlace;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.petmet.web.entity.PetPlaceView;
import com.petmet.web.service.PetPlaceService;

@WebServlet("/api/petplace/list")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json; charset=UTF-8");
		
		PetPlaceService service = new PetPlaceService();
		List<PetPlaceView> list = service.getViewList();
		
		String json = new Gson().toJson(list);
		response.getWriter().println(json);

	}

}
