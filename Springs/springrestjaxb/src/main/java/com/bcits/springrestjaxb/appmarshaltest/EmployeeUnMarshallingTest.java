package com.bcits.springrestjaxb.appmarshaltest;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeUnMarshallingTest {
	public static void main(String[] args) {

		try {
			JAXBContext context = JAXBContext.newInstance(EmployeeInfoBean.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();

			EmployeeInfoBean employeeInfo = (EmployeeInfoBean) unmarshaller
					.unmarshal(new File("employeeInfo2.xml"));

			System.out.println("emp id = " + employeeInfo.getEmpId());
			System.out.println("emp name = " + employeeInfo.getName());
			System.out.println("salary = " + employeeInfo.getSalary());
		} catch (JAXBException e) {
			e.printStackTrace();
		} // End of try-catch

	}// End of main()

}// End of class
