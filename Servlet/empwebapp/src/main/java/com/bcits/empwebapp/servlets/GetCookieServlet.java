package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getCookie")
public class GetCookieServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookie=req.getCookies();
		
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		for (Cookie cookie2 : cookie) {
			out.println("<h2>Cookie Name = "+cookie2.getName());
			out.println("<h2>Cookie value = "+cookie2.getValue());
		}
		out.println("</body>");
		out.println("</html>");
	}
}
