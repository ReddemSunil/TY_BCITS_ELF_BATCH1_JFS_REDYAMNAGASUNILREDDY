package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/include")
public class IncludeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url="./DynamicDate";//dynamic resource
//		String url="./date.html";//static resource
		
		//String url="https://www.youtube.com";//404(we cannot forward to external resource)
		
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello User</h1>");
		out.println("</body>");
		out.println("</html>");
		
		RequestDispatcher requestDispatcher=req.getRequestDispatcher(url);
		requestDispatcher.include(req, resp);
	
	}
}
