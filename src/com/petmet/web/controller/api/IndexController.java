package com.petmet.web.controller.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.petmet.web.entity.MatchInfoView;
import com.petmet.web.entity.ReviewView;
import com.petmet.web.service.AdminService;

@WebServlet("/api/index")
public class IndexController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminService service = new AdminService();
		List<MatchInfoView> mList = service.getMatchInfo();
		List<ReviewView> rList = service.getReview();
		
		String mJson = new Gson().toJson(mList);
		String rJson = new Gson().toJson(rList);
		
		String bothJson = "["+mJson+","+rJson+"]";
		response.getWriter().write(bothJson);
	}
	
}