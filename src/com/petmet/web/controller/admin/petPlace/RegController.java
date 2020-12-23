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

		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String homepage = request.getParameter("homepage");
		String phone = request.getParameter("phone");
		String location = request.getParameter("location");
		String content = request.getParameter("content");
		int pub = Integer.parseInt(request.getParameter("pub"));

		categoryId = (int) (Math.random() * 11 + 1);

		PetPlace p = new PetPlace(categoryId, name, address, homepage, phone, location, content, pub);

		// 파일등록
		Collection<Part> fileParts = request.getParts();

		String fileNames = "";

		for (Part part : fileParts) {
			if (part.getName().equals("file") && part.getSize() > 0) {
				Part filePart = part;

				String fileName = filePart.getSubmittedFileName();
				fileNames += fileName;
				fileNames += ",";

				int newId = service.getLastId() + 1;

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

		p.setFiles(fileNames);

		// null방지
		p.setWriterId(1);

		service.insert(p);

//		// 노가다용
//		for (int i = 101; i < 200; i++) {
//			int categoryId = (int) (Math.random() * 11 + 1);
//			String name = "펫플레이스" + (i + 1);
//			String address = "서울시 종로구" + (i + 1);
//			String homepage = "";
//			String phone = "";
//			String location = Math.random()*90 + "," + Math.random()*180;
//			String content = "";
//			int pub = 1;
//			PetPlace p2 = new PetPlace(categoryId, name, address, homepage, phone, location, content, pub);
//			p2.setWriterId(1);
//			service.insert(p2);
//		}

		response.sendRedirect("list");

	}
}