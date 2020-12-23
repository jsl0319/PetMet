package com.petmet.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class PetmetSecurityFilter implements Filter {

	private final static String[] mAuthURLs = { "/match" };

	private final static String[] adminAuthURLs = { "/admin/index", "/admin/member", "/admin/feed", "/admin/community",
			"/admin/petplace" };

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		String uri = request.getRequestURI();
		HttpSession session = request.getSession();
		boolean requireAuth = false;

		if (uri.contains("admin")) {
			for (String authUrl : adminAuthURLs)
				if (uri.contains(authUrl)) {
					requireAuth = true;
					break;
				}

			
			if (requireAuth && session.getAttribute("aid") == null) {
				response.sendRedirect("/admin/login");
				return;
			}
		}

		else {
			for (String authUrl : mAuthURLs)
				if (uri.contains(authUrl)) {
					requireAuth = true;
					break;
				}

			
			if (requireAuth && session.getAttribute("mid") == null) {
				response.sendRedirect("/error403?return-url=" + uri);
				return;
			}
		}

		chain.doFilter(request, response);

	}

}