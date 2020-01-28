package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeJSONUnMarshalling {
	public static void main(String[] args) {
		
		ObjectMapper mapper=new ObjectMapper();
		try {
			EmployeeInfoBean employeeInfoBean=mapper.readValue(new File("empjson.json"), EmployeeInfoBean.class);
			
			System.out.println("id = "+employeeInfoBean.getEmpId());
			System.out.println("name = "+employeeInfoBean.getName());
			System.out.println("doj = "+employeeInfoBean.getDateOfJoining());
			System.out.println("password = "+employeeInfoBean.getPassword());
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
