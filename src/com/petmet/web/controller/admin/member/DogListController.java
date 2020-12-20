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
		String page_ = request.getParameter("p");
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String query2_ = request.getParameter("q2");
		
		String field = "master_id";
		String query = "";
		String query2 = "";
		int page=1;
		int num=10;
		
		if(page_!= null && !page_.equals(""))
			page = Integer.parseInt(page_);
		if(field_ != null && !field_.equals(""))
			field = field_;
		if(query_ != null && !query_.equals(""))
			query = query_;
		if(query2_ != null && !query2_.equals(""))
			query2 = query2_;
		
		DogService dogService = new DogService();
		List<Dog> list = dogService.getList(field,query,query2,page,num);
		int count = dogService.getCount(field,query,query2);
		request.setAttribute("list", list);
		request.setAttribute("num", num);
		request.setAttribute("count", count);

		request.getRequestDispatcher("dog-list.jsp").forward(request, response);
	}

}
