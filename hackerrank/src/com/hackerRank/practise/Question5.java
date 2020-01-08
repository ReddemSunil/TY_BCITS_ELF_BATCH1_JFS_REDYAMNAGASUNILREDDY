package com.hackerRank.practise;

import java.util.ArrayList;

public class Question5 {
	public static void main(String[] args) {
		ArrayList<Integer> a=new ArrayList<Integer>();
		a.add(10);
		a.add(20);
		a.add(30);
		a.add(40);
		a.add(50);
		System.out.println(a);
		ArrayList<String> s=new ArrayList<String>();
		s.add("sunil");
		s.add("nag");
		s.add("subbu");
		s.add("suresh");
		System.out.println(s);
		printArray(a, s);
	}
	static void printArray(ArrayList<Integer> a,ArrayList<String> s) {
		int length=a.size()+s.size();
		for(int i=0;i<length;i++) {
			if(i<a.size()) {
				System.out.println(a.get(i));
			}
			else 
				System.out.println(s.get(i-a.size()));
		}
		
	}
}
