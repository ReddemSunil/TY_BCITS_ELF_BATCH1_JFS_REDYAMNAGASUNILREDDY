package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchEmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String empIdval = req.getParameter("empId");

		// code for config parameter for servlets
		ServletConfig config = getServletConfig();
		String myConfigParamval = config.getInitParameter("Servlet name");

		// code for context parameter for servlets
		ServletContext context = getServletContext();
		String myContext = context.getInitParameter("appName");

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>Emp Id = " + empIdval + "</h1>");
		out.print("emp name = sunil <br>");
		out.print("emp sal = 20000 <br>");
		out.print("emp designation = software developer <br>");
		out.println("<h1> servletName = "+myConfigParamval+"</h1>");
		out.println("<h1> ApplicationName = "+myContext+"</h1>");
		out.print("</body>");
		out.print("</html>");

	}// end of doGet()

}// end of class
