package com.petmet.web.controller.admin.petPlace;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;
import com.petmet.web.entity.PetPlace;
import com.petmet.web.entity.PetPlaceCategory;
import com.petmet.web.service.PetPlaceCategoryService;
import com.petmet.web.service.PetPlaceService;

@WebServlet("/admin/petplace/reg")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class RegController extends HttpServlet {
	
	private PetPlaceService service;
	
	public RegController() {
		service = new PetPlaceService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PetPlaceCategoryService service = new PetPlaceCategoryService();
		List<PetPlaceCategory> list = service.getList();

		request.setAttribute("list", list);

		request.getRequestDispatcher("/admin/petplace/reg.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		String category
		String content = request.getParameter("content");
		

		Collection<Part> fileParts = request.getParts(); // 여러 개 파일 보낼 때

		String fileNames = "";

		for (Part p : fileParts) {
			if (p.getName().equals("file") && p.getSize() > 0) {
				Part filePart = p;

				String fileName = filePart.getSubmittedFileName();
				fileNames += fileName;
				fileNames += ",";

				int newId = service.getLastId() + 1;

				String pathTemp = request.getServletContext().getRealPath("/static/notice/2020/26/"); // context : 서블릿들이
																										// 필요로 하는 공동 자원

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

			Notice notice = new Notice(title, content);

			
			notice.setFiles(fileNames); // "img1.jpg, img2.png"
			notice.setWriterId("newlec");

			service.insert(notice);

			response.sendRedirect("list"); // list로 보냄

		}
	}

}
