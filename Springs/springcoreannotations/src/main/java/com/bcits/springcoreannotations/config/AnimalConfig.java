package com.bcits.springcoreannotations.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bcits.springcoreannotations.Elephant;
import com.bcits.springcoreannotations.Goat;

@Configuration
public class AnimalConfig {
	
	@Bean
	public Goat getAnimal() {
		return new Goat();
	}
	@Bean
	@Primary
	public Elephant getElephant() {
		return new Elephant();
	}
}
