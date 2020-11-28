package com.petmet.web.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.User;
import com.petmet.web.service.UserService;

// UI 위주
@WebServlet("/admin/user")
public class UserController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request
							, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		UserService service = new UserService();
		List<User> list = service.getList();

		PrintWriter out = response.getWriter();
		
		String html = "<table border = '1'>";

		for (User u : list) {
			html += "<tr>";
			html += "<td>" + u.getId() + "</td>";
			html += "<td>" + u.getName() + "</td>";
			html += "<td>" + u.getUid() + "</td>";
			html += "<td>" + u.getPwd() + "</td>";
			html += "<td>" + u.getBirthday() + "</td>";
			html += "</tr>";
		}
		
		html += "</table>";
		
		out.println(html);
	}
}
