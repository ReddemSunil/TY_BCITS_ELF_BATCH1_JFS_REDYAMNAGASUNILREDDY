package com.hackerRank.practise;

import java.util.Scanner;
import java.util.Stack;

public class Question4 {

	public static void main(String[] args) {
		
		
		Stack s=new Stack();
		System.out.println("enter a value to repeat ");
		Scanner scn=new Scanner(System.in);
		int i=Integer.parseInt(scn.nextLine());
		for(int j=1;j<=i;j++) {
		System.out.println("enter values to store in stack");
		String s1=scn.nextLine();
		s.push(s1);
		}
	}

}
