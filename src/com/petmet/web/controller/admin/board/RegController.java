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

import com.petmet.web.entity.Notice;
import com.petmet.web.entity.PetPlace;
import com.petmet.web.service.NoticeService;



@WebServlet("/admin/community/notice/reg")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class RegController extends HttpServlet {

	private NoticeService service;

	public RegController() {
		service = new NoticeService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		

		

		request.getRequestDispatcher("/admin/notice/reg.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int pub = Integer.parseInt(request.getParameter("pub"));
	

		// 파일등록
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
		
		NoticeService service = new NoticeService();
		Notice notice = new Notice (title,content);
		notice.setFiles(fileNames);

		// null방지
		notice.setWriterId("관리자");

		service.insert(notice);

		

		response.sendRedirect("list");

	}

}
