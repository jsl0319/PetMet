package com.petmet.web.controller.api.petPlace;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.petmet.web.entity.PetPlaceView;
import com.petmet.web.service.PetPlaceService;

@WebServlet("/api/petplace/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		PetPlaceService service = new PetPlaceService();
		PetPlaceView p = service.getView(id);
		

		
		String[] location = p.getLocation().split(",");
		String json = "{\"longitude\":\""+location[0]+"\","+"\"latitude\":\""+location[1]+"\"}";
	

		response.getWriter().println(json);
		
		
				
				

	}
}
