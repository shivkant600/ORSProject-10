package com.rays.common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class FrontCtl extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();

		System.out.println("FrontCtl => " + session.getId());

		response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", " Content-Type ");

		if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
			return false;
		}

		String path = request.getServletPath();

		if (!path.startsWith("/Auth/")) {

			if ((UserContext) session.getAttribute("userContext") == null) {
				response.setContentType("application/json");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

				PrintWriter out = response.getWriter();
				out.print("{\"success\":\"false\",\"error\":\"OOPS! Your session has been expired\"}");
				out.close();

				System.out.println("Session expired → returning false ");
				return false;
			}
		}

		return true;
	}


}