package com.hackerRank.practise;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Question2 
{
	static Scanner scn=new Scanner(System.in);
	static ArrayList l=null;
    public static void main(String[] args)
    {
    	System.out.println("enter a length of list");
    	int n=Integer.parseInt(scn.nextLine());
    	l=new ArrayList(n);
    	for(int i=1;i<=n;i++)
    	{
    		System.out.println("enter a "+(i-1)+" th value in list");
    		int a=Integer.parseInt(scn.nextLine());
    		l.add(i-1, a);
    	}
    	System.out.println("enter a no of queries u want to perform");
    	int q=Integer.parseInt(scn.nextLine());
    	for(int i=1;i<=q;i++)
    	{
    		System.out.println("choose a query to insert/delete ");
        	String query=scn.nextLine();
        	 if(query.equalsIgnoreCase("INSERT"))
        	 {
        		 System.out.println("enter a index value for insertion");
        		 int x=Integer.parseInt(scn.nextLine());
        		 System.out.println("enter a value fot insertion");
        		 int y=Integer.parseInt(scn.nextLine());
        		 l.add(x, y);
        		 n++;
        	 }
        	 else if(query.equalsIgnoreCase("DELETE"))
        	 {
        		 System.out.println("enter a index value for deletion");
        		 int x=Integer.parseInt(scn.nextLine());
        		 l.remove(x);
        		 n--;
        	 }
        	 else {
        		 System.err.println("choose a valid query");
        	 }
    	}
    	System.out.println(l);
    	
    }
}
