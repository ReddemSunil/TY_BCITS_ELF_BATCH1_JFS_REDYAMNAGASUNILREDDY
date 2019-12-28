package com.bcits.myjavafile.myjavaapp;

import com.bcits.Calulator.basicCalculator.BasicCalculator;

public class Myjar {
	public static void main(String[] args) {
		BasicCalculator cal=new BasicCalculator();
		int sum=cal.add(10, 20);
		System.out.println(sum);
	}
}
