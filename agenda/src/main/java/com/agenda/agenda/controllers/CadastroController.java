package com.agenda.agenda.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.agenda.agenda.model.entidades.Usuario;
import com.agenda.agenda.model.repositorios.RepositorioUsuario;

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
	public String cadastro() throws SQLException{

		String nome=request.getParameter("username");
		String email=request.getParameter("email");
		String senha=request.getParameter("password");
		
		Usuario usuario= new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		
		RepositorioUsuario cadastro= new RepositorioUsuario();
		cadastro.inserir(usuario);

		return "redirect:/login";
	}
}
