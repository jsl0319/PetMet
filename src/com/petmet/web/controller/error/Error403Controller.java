package com.petmet.web.controller.error;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/error403")
public class Error403Controller extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String returnURL = request.getParameter("return-url");
		request.setAttribute("returnUrl", returnURL);
		request.getRequestDispatcher("/error/error403/error403.jsp").forward(request, response);

	}
		
}