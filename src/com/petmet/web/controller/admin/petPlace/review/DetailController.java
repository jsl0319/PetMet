package com.petmet.web.controller.admin.petPlace.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.PetPlaceView;
import com.petmet.web.entity.Review;
import com.petmet.web.entity.ReviewView;
import com.petmet.web.service.PetPlaceService;
import com.petmet.web.service.ReviewService;

@WebServlet("/admin/petplace/review/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String page_ = request.getParameter("p");
		int id = Integer.parseInt(request.getParameter("id"));

		int page = 1;
		int size = 10;

		if (page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);

		ReviewService service = new ReviewService();
		List<ReviewView> list = service.getViewList(id);
		int totalPages = service.getTotalPage(id, page, size);

		request.setAttribute("tp", totalPages);
		request.setAttribute("list", list);
		request.getRequestDispatcher("detail.jsp").forward(request, response);

	}

	// 삭제용 post
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		ReviewService service = new ReviewService();

		String[] dels = request.getParameterValues("del");

		int[] ids = new int[dels.length];

		for (int i = 0; i < ids.length; i++) {
			ids[i] = Integer.parseInt(dels[i]);
			service.delete(ids[i]);
		}

		response.sendRedirect("list");

	}

}
