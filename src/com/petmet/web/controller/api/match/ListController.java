package com.petmet.web.controller.api.match;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmet.web.entity.MatchInfoView;
import com.petmet.web.service.MatchInfoService;
//jsp가 아닌 ajax 비동기적으로 데이터 가져오기
//전체 레코드 가져오기 V
//필터(쿼리)
//페이징
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
