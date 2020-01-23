package com.bcits.springcoreannotations;

import com.bcits.springcoreannotations.interfaces.Animal;

public class Goat implements Animal{

	@Override
	public void eat() {
		System.out.println("eating grass");
	}

	@Override
	public void speak() {
		System.out.println("mehh mehhh...");
	}
	
}//End of class
