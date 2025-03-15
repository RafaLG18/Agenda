package com.agenda.agenda.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
@Controller
public class CadastroController {
	@Autowired
	private HttpServletRequest request;
    @GetMapping("/cadastro")
	public String principal(Model m) {
		return "cadastro/cadastro";

	}
	@PostMapping("/cadastro")
	public String cadastro(){

		String nome=request.getParameter("username");
		String email=request.getParameter("email");
		String senha=request.getParameter("password");

		return "redirect:/login";
	}
}
