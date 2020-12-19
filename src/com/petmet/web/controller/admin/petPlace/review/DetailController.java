package com.petmet.web.controller.admin.petPlace.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.ReviewView;
import com.petmet.web.service.ReviewService;

@WebServlet("/admin/petplace/review/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		ReviewService service = new ReviewService();
		List<ReviewView> list = service.getViewList(id);

		request.setAttribute("list", list);
		request.getRequestDispatcher("detail.jsp").forward(request, response);

	}

	// 삭제용 post
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
