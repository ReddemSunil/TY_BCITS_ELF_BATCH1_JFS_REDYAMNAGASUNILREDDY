package com.bcits.springcoreannotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bcits.springcoreannotations.beans.Pet;
import com.bcits.springcoreannotations.config.PetConfig;

public class PetTest {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(PetConfig.class);
		Pet myPet=context.getBean(Pet.class);
		
		System.out.println("pet name = "+myPet.getName());
		myPet.getAnimal().eat();
		myPet.getAnimal().speak();
	}
}
