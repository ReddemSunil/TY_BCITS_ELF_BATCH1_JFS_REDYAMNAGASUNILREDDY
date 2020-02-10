package com.bcits.springsecurityrest.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.bcits.springsecurityrest.beans.EmployeeResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MySimpleUrlAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setStatusCode(201);
		employeeResponse.setMessage("Success");
		employeeResponse.setDescription("Login Successfull");

		ObjectMapper mapper = new ObjectMapper();

		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.getWriter().write(mapper.writeValueAsString(employeeResponse));
		response.setStatus(200);

	}// End of onAuthenticationSuccess()
}// End of class
