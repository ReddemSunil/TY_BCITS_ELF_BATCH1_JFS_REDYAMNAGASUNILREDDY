package com.bcits.springmvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//@WebFilter(urlPatterns = "/*")
public class MyEmployeeFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		System.out.println("Inside Filter");
		System.out.println("URL => "+req.getRequestURL());
		System.out.println("URI => "+req.getRequestURI());
		
		chain.doFilter(request, response);
	}//End of doFilter()

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
