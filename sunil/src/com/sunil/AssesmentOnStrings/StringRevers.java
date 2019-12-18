package com.sunil.AssesmentOnStrings;

import java.util.Scanner;

public class StringRevers 
{
	public static void main(String[] args)
	{
		Scanner scn=new Scanner(System.in);
		System.out.println("enter a string");
		String s1=scn.nextLine();
		String s="";
		for(int i=s1.length()-1;i>=0;i--)
		{
			s+=s1.charAt(i);
		}
		System.out.println(s);
	}

}
