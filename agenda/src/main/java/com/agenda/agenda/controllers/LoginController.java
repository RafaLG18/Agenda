package com.agenda.agenda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
	//@RequestMapping({"/","","/*"})
	public String principal(Model m) {
		return "login/login";
		
	}
}
