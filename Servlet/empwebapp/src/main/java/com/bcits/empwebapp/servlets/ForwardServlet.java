package com.bcits.empwebapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward")
public class ForwardServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url="./DynamicDate";//dynamic resource
//		String url="./date.html";//static resource
		
		//String url="https://www.youtube.com";//404(we cannot forward to external resource)
		
		RequestDispatcher requestDispatcher=req.getRequestDispatcher(url);
		requestDispatcher.forward(req, resp);


	}
}
