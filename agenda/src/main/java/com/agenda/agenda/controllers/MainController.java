package com.agenda.agenda.controllers;
    

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
	
	@GetMapping("/")
	//@RequestMapping({"/","","/*"})
	public String principal(Model m) {
		return "index";
		
	}

}
