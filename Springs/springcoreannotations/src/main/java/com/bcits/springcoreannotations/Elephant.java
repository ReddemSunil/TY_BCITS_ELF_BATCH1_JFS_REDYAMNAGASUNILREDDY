package com.bcits.springcoreannotations;

import com.bcits.springcoreannotations.interfaces.Animal;

public class Elephant implements Animal{

	@Override
	public void eat() {
		System.out.println("eat sugarcane");
	}

	@Override
	public void speak() {
		System.out.println("trumpeting ...");
	}

}
