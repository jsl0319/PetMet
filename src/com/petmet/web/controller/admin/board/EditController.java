package com.petmet.web.controller.admin.board;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.petmet.web.service.NoticeService;
import com.petmet.web.entity.Notice;

@WebServlet("/admin/community/notice/edit")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class EditController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		NoticeService service = new NoticeService();
		Notice n =service.get(id);
		
		
		request.setAttribute("n", n);
		
		
		
		request.getRequestDispatcher("edit.jsp").forward(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int pub_ = Integer.parseInt(request.getParameter("pub"));
		boolean pub = true;
		if(pub_ ==1){
			pub = false;
		}
		
		Collection<Part> fileParts = request.getParts();

		String fileNames = "";

		for (Part part : fileParts) {
			if (part.getName().equals("file") && part.getSize() > 0) {
				Part filePart = part;

				String fileName = filePart.getSubmittedFileName();
				fileNames += fileName;
				fileNames += ",";

	//			int newId = service.getLastId() + 1;

				String pathTemp = request.getServletContext().getRealPath("/static/notice/2020/13/");

				File path = new File(pathTemp);
				if (!path.exists())
					path.mkdirs();

				String filePath = pathTemp + File.separator + filePart.getSubmittedFileName();

				InputStream fis = filePart.getInputStream();
				FileOutputStream fos = new FileOutputStream(filePath);

				byte[] buf = new byte[1024];
				int size = 0;
				while ((size = fis.read(buf)) != -1) {
					fos.write(buf, 0, size);
				}

				fos.close();
				fis.close();
			}
		}
		
		
		Notice notice = new Notice(id,title,content,pub,0,null,null,null);

		NoticeService service = new NoticeService();
		service.update(notice);
		

		
		response.sendRedirect("detail?id="+id);
	}
	

}
