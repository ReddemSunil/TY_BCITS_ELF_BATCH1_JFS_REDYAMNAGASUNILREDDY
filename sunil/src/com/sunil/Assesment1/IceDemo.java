package com.sunil.Assesment1;

import java.util.Scanner;

public class IceDemo 
{
	public static void main(String[] args) 
	{
		System.out.println("select which icecream you want");
		System.out.println("1.vennela icecream\n2.chacobar");
		Scanner scn=new Scanner(System.in);
		int a=scn.nextInt();
		
		if(a==1)
		{
			Vennela v=new Vennela();
			v.recieve();
		}
		if(a==2)
		{
			Chacobar c=new Chacobar();
			c.recieve();
		}
	}

}
