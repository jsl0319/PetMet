package com.petmet.web.controller.admin.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.Dog;
import com.petmet.web.service.DogService;

@WebServlet("/admin/member/dogdetail")
public class DogDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		DogService dogService= new DogService();
		Dog dog = dogService.get(id);
		
		request.setAttribute("d", dog);
		request.getRequestDispatcher("dog-detail.jsp").forward(request, response);
	}
}
