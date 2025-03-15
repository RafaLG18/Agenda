package com.agenda.agenda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @Autowired
	  private HttpServletRequest request;

    @GetMapping("/home")
    public String principal(Model m) {
        return "home/home";
    }

    @GetMapping("/logout")
    public String logout(Model m) {
        m.addAttribute("logado", "false");
        return "redirect:/";
    }

    @PostMapping("/add-contact")
    public String cadastrar(Model m) {
        String nome = request.getParameter("name");
        String telefone1 = request.getParameter("phone1");
        String telefone2 = request.getParameter("phone2");
        String telefone3 = request.getParameter("phone3");
        String rua = request.getParameter("street");
        String numero = (String)request.getParameter("number");
        String complemento = request.getParameter("complement");
        return "redirect:/home";
    }

    
}
