package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/mygenericServlet")
public class MyGenericServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String eNameVal=req.getParameter("eName");
		
		PrintWriter out=res.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1 style='color:navy'>welcome to generic servlet</h1>");
		out.println("<h2> employee Name = "+eNameVal+"</h2>");
		out.println("</body>");
		out.println("</html>");
	}
	
}
