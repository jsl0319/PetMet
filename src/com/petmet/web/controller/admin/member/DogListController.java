package com.petmet.web.controller.admin.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.Dog;
import com.petmet.web.service.DogService;

@WebServlet("/admin/member/doglist")
public class DogListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DogService dogService = new DogService();
		List<Dog> list = dogService.getList();
		request.setAttribute("doglist", list);

		request.getRequestDispatcher("dog-list.jsp").forward(request, response);
	}

}
