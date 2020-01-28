package com.bcits.springrestjaxb.appmarshaltest;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;
import com.bcits.springrestjaxb.beans.UserOtheInfoBean;

public class UserMarshallingTest {
	public static void main(String[] args) {

		UserInfoBean userInfo = new UserInfoBean();
		userInfo.setEmpId(111);
		userInfo.setBloodGroup("o+");
		userInfo.setDateOfBirth(new Date());
		userInfo.setDateOfJoining(new Date());
		userInfo.setDeptid(10);
		userInfo.setDesignation("ssd");
		userInfo.setManagerId(1);
		userInfo.setMobileno(9502774436l);
		userInfo.setName("sunil");
		userInfo.setOfficialMail("rnsunil1432@gmail.com");
		userInfo.setPassword("sunil");
		userInfo.setSalary(20000);

		UserOtheInfoBean userOtheInfo = new UserOtheInfoBean();
		userOtheInfo.setAdhar(236409918929l);
		userOtheInfo.setGender("male");

		userInfo.setUserOtherInfo(userOtheInfo);

		UserAddressBean addressBean = new UserAddressBean();
		addressBean.setHouseNum(11);
		addressBean.setAddressType('t');
		addressBean.setCity("banglore");
		addressBean.setStreet("murugeshpalya");

		UserAddressBean addressBean1 = new UserAddressBean();
		addressBean1.setHouseNum(51);
		addressBean1.setAddressType('p');
		addressBean1.setCity("pune");
		addressBean1.setStreet("marathalli");

		List<UserAddressBean> userAddressesList = new ArrayList<UserAddressBean>();
		userAddressesList.add(addressBean);
		userAddressesList.add(addressBean1);

		userInfo.setUserAddressesList(userAddressesList);

		try {
			JAXBContext context = JAXBContext.newInstance(UserInfoBean.class);

			Marshaller marshaller = context.createMarshaller();

			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(userInfo, new File("userInfo1.xml"));

			marshaller.marshal(userInfo, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
