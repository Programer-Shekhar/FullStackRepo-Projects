package com.nit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookOperationsController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
}
