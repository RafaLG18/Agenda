package com.agenda.agenda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@Controller
public class LoginController {
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;
	
	@Autowired
	private HttpSession session;

    @GetMapping("/login")
	public String principal(Model m) {
		return "login/login";	
	}
	@PostMapping("/login")
	public String login(Model m){
		
		String email=request.getParameter("email");
		String senha=request.getParameter("password");
		
		System.out.println(email);
		System.out.println(senha);
		return "redirect:/home";
	}
}

