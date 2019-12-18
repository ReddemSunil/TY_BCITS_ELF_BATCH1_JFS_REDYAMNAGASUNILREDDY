package com.sunil.assesment;

import java.util.Scanner;
class Test1
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
              if(i+j<=a-1)
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