package com.sunil.assesment;
import java.util.Scanner;
class Test4
{
   public static void main(String[] args)
     {
       System.out.println("enter a number");
       Scanner scn=new Scanner(System.in);
       int n=scn.nextInt();
       for(int i=0;i<n;i++)
       {
          for(int j=0;j<n;j++)
            {
              if(i<=j)
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
