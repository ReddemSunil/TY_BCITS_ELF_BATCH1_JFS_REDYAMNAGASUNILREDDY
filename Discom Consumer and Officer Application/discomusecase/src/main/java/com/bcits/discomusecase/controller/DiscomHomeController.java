package com.bcits.discomusecase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DiscomHomeController {

	@GetMapping("/discomHome")
	public String discomHome() {
		return "discomHome";
	}// End of discomHome()
}// End of class
