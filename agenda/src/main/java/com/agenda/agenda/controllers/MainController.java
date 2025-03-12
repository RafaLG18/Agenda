package com.agenda.agenda.controllers;
    

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
	
	@RequestMapping({"/","","/*"})
	public String principal(Model m) {
		
		
		return "index";
		
	}

}
