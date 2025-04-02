package com.nit.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nit.entity.User;
import com.nit.repository.IUserRepository;
import com.nit.service.IUserMgmtService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserOperationsController {
	
	@Autowired
	private IUserMgmtService userService;
	
	@Autowired
	private IUserRepository userRepository;
	
	@ModelAttribute
	public void commenUser(Principal principal, Model model) {
		if(principal != null) {
			String email =	principal.getName();
			User user = userRepository.findByEmail(email);
			model.addAttribute("user", user);
		}
		
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/signin")
	public String login() {
		return "login";
	}
	
	@GetMapping("/user/profile")
	public String profile(Principal principal, Model model) {
		String email =	principal.getName();
		User user = userRepository.findByEmail(email);
		model.addAttribute("user", user);
		return "profile";
	}
	
	@GetMapping("/user/home")
	public String home() {
		return "home";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute User user, HttpSession session) {
		User savedUser = userService.saveUser(user);
		
		if(savedUser != null) {
			session.setAttribute("msg", "Registered Successfully...");
		}else {
			session.setAttribute("msg", "Somthing wrong on server...");
		}
		return "redirect:/register";
	}
}
