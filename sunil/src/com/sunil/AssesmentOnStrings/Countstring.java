package com.sunil.AssesmentOnStrings;

import java.util.Scanner;

public class Countstring
{
	public static void main(String[] args)
	{
		Scanner scn=new Scanner(System.in);
		System.out.println("enter a string");
		String s1=scn.nextLine();
		String[] s=s1.split(" ");
		String s2="";
		for(int i=0;i<s.length;i++)
		{
			s2+=s[i]+count(s[i])+" ";
		}
		s2=s2.trim();
		System.out.println(s2);
	}
	static int count(String s)
	{
		return s.length();
	}

}
