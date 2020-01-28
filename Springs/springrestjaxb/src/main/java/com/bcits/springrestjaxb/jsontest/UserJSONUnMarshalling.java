package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.UserInfoBean;

public class UserJSONUnMarshalling {
	
	public static void main(String[] args) {
		ObjectMapper mapper=new ObjectMapper();
		try {
			UserInfoBean userInfoBean=mapper.readValue(new File("userJson1.json"),UserInfoBean.class);
			
			System.out.println(userInfoBean);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
