package com.bcits.discomusecase.test;

import java.util.Scanner;

import com.bcits.discomusecase.billtariff.BillTariff;

public class BillCalculating {
	public static void main(String[] args) {
		
		Scanner scn=new Scanner(System.in);
		System.out.println("enter the power consumption in KWH and type of consumer ");
		System.out.println("enter the power consumption");
		int consumption=Integer.parseInt(scn.nextLine());
		System.out.println("enter type of consumer \nresidential consumer or \ncommercial consumer or \nindustries consumer");
		String typeOfConsumer=scn.nextLine();
		Double billAmount=BillTariff.claculateBill(consumption, typeOfConsumer);
		System.out.println("your total bill amount  is "+billAmount+" /-");
	}
}
