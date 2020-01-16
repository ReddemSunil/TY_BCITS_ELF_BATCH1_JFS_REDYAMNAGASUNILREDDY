package com.bcits.empwebapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet{
	 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String url="https://www.youtube.com";//to external resource 
		             //confirm we have to write the https:// other wise its search inside the empwebapp
		//String url="https://localhost:8080/empwebapp/date.html ";//to internal  resource(static)
		String url="https://localhost:8080/empwebapp/Dynamicdate ";//to internal resource(dynamic)
		resp.sendRedirect(url);
	}
}
