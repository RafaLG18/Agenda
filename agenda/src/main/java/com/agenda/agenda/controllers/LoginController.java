package com.agenda.agenda.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.agenda.agenda.model.repositorios.RepositorioUsuario;

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
	public String login(Model m) throws SQLException{

		RepositorioUsuario usuarios= new RepositorioUsuario();
		String email=request.getParameter("email");
		String senha=request.getParameter("password");
		
		String email_bd=usuarios.pesquisar("email", email);
		String senha_bd=usuarios.pesquisar("senha", senha);
		
		if (email.equals(email_bd) && senha.equals(senha_bd)) {
			m.addAttribute("logado","true");			
			return "redirect:/home";
		}else{
			m.addAttribute("msg","Erro no email ou senha");
			return "redirect:/login";
		}
		
	}
}

