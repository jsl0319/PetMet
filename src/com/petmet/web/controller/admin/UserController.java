package com.petmet.web.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.User;
import com.petmet.web.service.UserService;

@WebServlet("/hi")
public class UserController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserService service = new UserService();
			List<User> list = service.getList();
			
			for(int i=0; i<list.size(); i++) {
				User user = list.get(i);
				String name = user.getName();
				String birthday = user.getBirthday();
				System.out.println(name + birthday);
			}
			
//			User user = list.get(0);
//			User user1 = list.get(1);
//			User user2 = list.get(0); 
//			
//			String name = user.getName();
//			String birthday = user.getBirthday();
//			user.getBirthday();
//			user.getPwd();
			
			//list.get(0).getName();
//			System.out.println(name);
			
			
			
			
			
			
			
			
			
	}
}
