package com.bcits.springsecurityrest.filter;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.bcits.springsecurityrest.beans.EmpInfoBean;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private EmpInfoBean empInfo;

	@Override
	protected String obtainUsername(HttpServletRequest request) {

		if (request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
			try {
				EmpInfoBean infoBean = getEmpInfo(request);
				return infoBean.getEmpId() + "";
			} catch (IOException e) {
				e.printStackTrace();
				return "";
			}

		} // end of if
		return super.obtainUsername(request);
	}// End of obtainUsername()

	@Override
	protected String obtainPassword(HttpServletRequest request) {
		if (request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
			try {
				EmpInfoBean infoBean = getEmpInfo(request);
				return infoBean.getPassword();
			} catch (IOException e) {
				e.printStackTrace();
				return "";
			}
		} // end of if
		return super.obtainPassword(request);
	}// End of obtainPassword()

	private EmpInfoBean getEmpInfo(HttpServletRequest request) throws IOException {
		if (empInfo != null) {
			ObjectMapper objectMapper = new ObjectMapper();

			String json = "";

			BufferedReader reader = request.getReader();
			while (reader.ready()) {
				json = json + reader.readLine();
			}
			empInfo = objectMapper.readValue(json, EmpInfoBean.class);
		}
		return empInfo;
	}// End of getEmpInfo()
}// End of filter
