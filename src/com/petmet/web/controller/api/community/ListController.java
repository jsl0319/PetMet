package com.petmet.web.controller.api.community;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.petmet.web.entity.BoardView;
import com.petmet.web.service.BoardService;


@WebServlet("/api/community/list")
public class ListController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json; charset=UTF-8");
		
		BoardService boardservice= new BoardService();
		List<BoardView> list = boardservice.getViewList();
//		String json = "[";
//	      
//	      for(int i=0; i<list.size(); i++) {
//	    	  BoardView b = list.get(i);
//	  
//	         json += String.format("{\"id\":\"%s\",\"title\":\"%s\",\"writerId\":\"%s\",\"cmtCnt\":\"%s\""
//	         		+ ",\"hit\":\"%s\",\"regDate\":\"%s\"}"
//	        		 , b.getId(), b.getTitle(), b.getWriterId(),b.getCmtCnt(),
//	        		 b.getHit(),b.getRegDate()
//	        		 );
//	         
//	         if(list.size() > i+1)
//	            json += ",";
//	      }
//	      
//	      json += "]";
//	      
	   
		String json = new Gson().toJson(list);
		response.getWriter().println(json);


	}

}
