package com.petmet.web.controller.admin.petPlace;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.PetPlaceView;
import com.petmet.web.service.PetPlaceService;

@WebServlet("/admin/petplace/list")
public class ListController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page_ = request.getParameter("p");
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String startDate_ = request.getParameter("sd");
		String endDate_ = request.getParameter("ed");
		
		String field = "name";
		String query = "";
		String startDate = "01-01-01";
		String endDate = "30-12-31";
		int page = 1;
		int size = 10; //페이지에 표시할 레코드 개수
		
		if(page_!= null && !page_.equals(""))
			page = Integer.parseInt(page_);
		if(field_ != null && !field_.equals(""))
			field = field_;
		if(query_ != null && !query_.equals(""))
			query = query_;
		if(startDate_ != null && !startDate_.equals(""))
			startDate = startDate_;
		if(endDate_ != null && !endDate_.equals(""))
			endDate = endDate_;
		
		//list 불러오기
		PetPlaceService service = new PetPlaceService();
//		List<PetPlace> list = service.getList();
//		List<PetPlaceView> list = service.getList();
		List<PetPlaceView> list = service.getViewList(field, query, startDate, endDate, page, size);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
	}

}
