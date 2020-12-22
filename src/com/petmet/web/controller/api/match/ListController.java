package com.petmet.web.controller.api.match;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.petmet.web.entity.MatchInfoView;
import com.petmet.web.service.MatchInfoService;

@WebServlet("/api/match/list")
public class ListController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json; charset=UTF-8");
		
		MatchInfoService matchInfoService= new MatchInfoService();
		List<MatchInfoView> list = matchInfoService.getViewList();
		String json = "[";
	      
	      for(int i=0; i<list.size(); i++) {
	    	 MatchInfoView m = list.get(i);
	  
	         json += String.format("{\"id\":\"%s\",\"regDate\":\"%s\",\"pub\":\"%s\",\"matchContent\":\"%s\""
	         		+ ",\"name\":\"%s\",\"kind\":\"%s\",\"gender\":\"%s\",\"neut\":\"%s\""
	         		+ ",\"birth\":\"%s\",\"weight\":\"%s\",\"dogContent\":\"%s\",\"character\":\"%s\""
	         		+ ",\"files\":\"%s\",\"masterNickname\":\"%s\",\"masterGender\":\"%s\",\"address\":\"%s\"}"
	        		 , m.getId(), m.getRegDate(), m.getPub(),m.getMatchContent(),
	        		 m.getName(),m.getKind(),m.getGender(),m.getNeut(),
	        		 m.getBirth(),m.getWeight(),m.getDogContent(),m.getCharacter(),
	        		 m.getFiles(),m.getMasterNickname(),m.getMasterGender(),m.getAddress());
	         
	         if(list.size() > i+1)
	            json += ",";
	      }
	      
	      json += "]";
	      
	   

		response.getWriter().println(json);

	}
}
