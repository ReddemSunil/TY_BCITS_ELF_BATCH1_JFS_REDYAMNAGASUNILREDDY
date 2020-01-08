package com.hackerRank.practise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Question3 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter a no of numbers u want to store ");
		int n = Integer.parseInt(scn.nextLine());
		Map m = new LinkedHashMap<String, Integer>(n);

		for (int i = 1; i <= n; i++) {
			System.out.println("enter a person first name and last name at a time for record no is : " + i);
			String name = scn.nextLine();
			System.out.println("enter a person phone number");
			int phone = Integer.parseInt(scn.nextLine());
			m.put(name, phone);

		}
		System.out.println(m.toString());

		System.out.println("enter a name you get a phone number");
		String name1 = scn.nextLine();
		if (m.get(name1) != null) {
			System.out.println(name1 + "=" + m.get(name1));
		}
		else System.out.println("name not matched....");
	}
}
