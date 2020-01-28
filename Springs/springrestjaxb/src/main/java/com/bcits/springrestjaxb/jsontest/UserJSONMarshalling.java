package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.appmarshaltest.UserAddressBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;
import com.bcits.springrestjaxb.beans.UserOtheInfoBean;

public class UserJSONMarshalling {
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
		
		UserOtheInfoBean otheInfoBean=new UserOtheInfoBean();
		otheInfoBean.setAdhar(12345678l);
		otheInfoBean.setGender("male");
		
		userInfo.setUserOtherInfo(otheInfoBean);
		
		
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

		
		ObjectMapper mapper=new ObjectMapper();
		try {
			mapper.writeValue(new File("userJson1.json"), userInfo);
			mapper.writeValue(System.out, userInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
