package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//java code to generate current system date&time(dynamic)
		Date date = new Date();
		
		//code for config parameter for servlets 
		ServletConfig config=getServletConfig();
		String myConfigParamval=config.getInitParameter("Servlet name");
		
		//code for context parameter for servlets
		ServletContext context=getServletContext();
		String myContext=context.getInitParameter("appName");
		
		//code to generate dynamic response
		resp.setContentType("text/html");
		resp.setHeader("refresh", "1" );
		
		
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1> Current System Date & Time is:-"+date+"</h1>");
		out.println("<h1> servletName = "+myConfigParamval+"</h1>");
		out.println("<h1> ApplicationName = "+myContext+"</h1>");
		out.println("</body>");
		out.println("</html>");
		
	
	}// end of doGet()
}//end of class
