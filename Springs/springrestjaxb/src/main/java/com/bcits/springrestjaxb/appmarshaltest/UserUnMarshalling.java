package com.bcits.springrestjaxb.appmarshaltest;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.bcits.springrestjaxb.beans.UserInfoBean;

public class UserUnMarshalling {
	public static void main(String[] args) {

		try {
			JAXBContext context = JAXBContext.newInstance(UserInfoBean.class);

			Unmarshaller unmarshaller = context.createUnmarshaller();
			UserInfoBean userInfoBean = (UserInfoBean) unmarshaller.unmarshal(new File("userInfo1.xml"));

			System.out.println("user name = " + userInfoBean.getName());
			System.out.println("user id = " + userInfoBean.getEmpId());
			System.out.println("adhar = " + userInfoBean.getUserOtherInfo().getAdhar());
			System.out.println("gender = " + userInfoBean.getUserOtherInfo().getGender());
			
			List<UserAddressBean>list= userInfoBean.getUserAddressesList();
			
			for (UserAddressBean userAddressBean : list) {
				System.out.println("addressType = "+userAddressBean.getAddressType());
				System.out.println("city = "+userAddressBean.getCity());
				System.out.println("houseno = "+userAddressBean.getHouseNum());
				System.out.println("-----------------------------------------------------");
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		} // End of try-catch 

	}// End of main
}// End of class
