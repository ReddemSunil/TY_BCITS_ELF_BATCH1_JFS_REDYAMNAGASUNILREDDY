package com.bcits.springrestjaxb.appmarshaltest;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeMarshallingTest {

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

		try {
			JAXBContext context = JAXBContext.newInstance(EmployeeInfoBean.class);
			Marshaller marshaller = context.createMarshaller();

			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// For formatted xml

			marshaller.marshal(employeeInfo, System.out);
			marshaller.marshal(employeeInfo, new File("employeeInfo.xml"));

		} catch (JAXBException e) {
			e.printStackTrace();
			System.out.println("\n\nUnable to Marshal!!");
		} // End of try-catch

	}// End of main()

}// End of class
