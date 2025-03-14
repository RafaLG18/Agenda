package com.agenda.agenda.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CadastroController {
    @GetMapping("/cadastro")
	//@RequestMapping({"/","","/*"})
	public String principal(Model m) {
		return "cadastro/cadastro";
		
	}
}
