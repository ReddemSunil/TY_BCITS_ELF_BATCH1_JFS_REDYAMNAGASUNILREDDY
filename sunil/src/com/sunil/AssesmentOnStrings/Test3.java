package com.sunil.AssesmentOnStrings;

import java.util.Scanner;

public class Test3 
{
	public static void main(String[] args) 
	{
		Scanner scn=new Scanner(System.in);
		System.out.println("enter a string on only odd words");
		String s1=scn.nextLine();
		String[] s=s1.split(" ");
		String[] s2=new String[s.length];
		for(int i=0;i<s.length;i++)
		{
			if(isEven(i))
			{
				if(i!=s.length-1)
					 s2[i+2]=s[i];
				else
					s2[0]=s[i];
				
			}
			else
				s2[i]=s[i];
		}
		String s3="";
		for(int i=0;i<s2.length;i++)
		{
			s3+=" "+s2[i];
		}
		s3=s3.trim();
		System.out.println(s3);
	}
	static boolean isEven(int i)
	{
		if(i%2==0)
			return true;
		else 
			return false;
	}

}
