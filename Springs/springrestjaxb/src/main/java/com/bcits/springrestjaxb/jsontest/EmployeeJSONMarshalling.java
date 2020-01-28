package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeJSONMarshalling {

	public static void main(String[] args) {
		EmployeeInfoBean employeeInfo = new EmployeeInfoBean();
		employeeInfo.setEmpId(111);
		employeeInfo.setBloodGroup("o+");
		employeeInfo.setDateOfBirth(new Date());
		employeeInfo.setDateOfJoining(new Date());
		employeeInfo.setDeptid(10);
		employeeInfo.setDesignation("ssd");
		employeeInfo.setManagerId(1);
		employeeInfo.setMobileno(9502774436l);
		employeeInfo.setName("sunil");
		employeeInfo.setOfficialMail("rnsunil1432@gmail.com");
		employeeInfo.setPassword("sunil");
		employeeInfo.setSalary(20000);

		ObjectMapper mapper = new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter();
		try {
			mapper.writeValue(new File("empJson2.json"), employeeInfo);
			mapper.writeValue(System.out, employeeInfo);

		} catch (IOException e) {
			e.printStackTrace();
		} // End of try-catch
	}// End of main()
}// End of class
