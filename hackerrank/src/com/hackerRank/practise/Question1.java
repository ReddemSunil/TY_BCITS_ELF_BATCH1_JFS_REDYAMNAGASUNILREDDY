package com.hackerRank.practise;

import java.util.ArrayList;
import java.util.Scanner;

public class Question1 
{
	public static void main(String[] args)
	{
		Scanner scn=new Scanner(System.in);
		System.out.println("enter a no of lines");
		int n=scn.nextInt();
		ArrayList<ArrayList<Integer>> array=new ArrayList<ArrayList<Integer>>(n);
		ArrayList<Integer> array1=null;
		for(int i=1;i<=n;i++)
		{
			System.out.println("enter a length of line"+i);
			int d=scn.nextInt();
			array1=new ArrayList<Integer>(d);
			array1.add(0,d);
			for(int j=1;j<=d;j++)
			{
				System.out.println("enter a "+j+"th digit value");
				int x=scn.nextInt();
				array1.add(x);
			}
			System.out.println(array1.toString());
			array.add(array1);
		}
		System.out.println(array.toString());
		System.out.println("enter a no of queries u want to retrive");
		int q=scn.nextInt();
		for(int i=1;i<=q;i++)
		{
			System.out.println("enter a line no ");
			int x=scn.nextInt();
			System.out.println("enter a position");
			int y=scn.nextInt();
			if(y>array1.size()||x>array.size())
			{
				System.err.println("error");
				return;
			}
			System.out.println(array.get(x-1).get(y-1));
		}
		
	}

}
