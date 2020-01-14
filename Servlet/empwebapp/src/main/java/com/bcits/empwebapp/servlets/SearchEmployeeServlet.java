package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchEmployeeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String empIdval=req.getParameter("empId");
		
		resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>Emp Id = "+empIdval+"</h1>");
		out.print("emp name = sunil <br>");
		out.print("emp sal = 20000 <br>");
		out.print("emp designation = software developer <br>");
		out.print("</body>");
		out.print("</html>");
		
	
	}//end of doGet()
	
	
	
}//end of class
