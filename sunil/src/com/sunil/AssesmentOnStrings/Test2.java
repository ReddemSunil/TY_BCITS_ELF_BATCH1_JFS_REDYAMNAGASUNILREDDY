package com.sunil.AssesmentOnStrings;

import java.util.Scanner;

public class Test2
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
			if(isEven(i))
			    s2+=" "+reverse(s[i]);
			else 
				s2+=" "+s[i];
			
		}
		s2=s2.trim();
		System.out.println(s2);
		
	}
	static String reverse(String s)
	{
		String s1="";
		for(int i=s.length()-1;i>=0;i--)
		{
			s1+=s.charAt(i);
		}
		return s1;
	}
	static boolean isEven(int i)
	{
		if(i%2==0)
			return true;
		else 
			return false;
	}


}
