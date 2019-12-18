package com.sunil.assesment;

import java.util.Scanner;

public class Box
{
	public static void main(String[] args)
    {
    System.out.println("enter a number");
    Scanner scn=new Scanner(System.in);
    int a=scn.nextInt();
    for(int i=0;i<a;i++)
    {
       for(int j=0;j<a;j++)
         {
           if(i+j==a-1 || i==j ||i==a-1 || j==0 || j==a-1 || i==0 || i==a/2 || j==a/2)
            { 
               System.out.print("*"); 
            }
           else
               System.out.print(" ");
         }
       System.out.println();
    }
     
  }


}
