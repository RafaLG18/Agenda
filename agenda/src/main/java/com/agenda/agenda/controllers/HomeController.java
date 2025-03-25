package com.agenda.agenda.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.agenda.agenda.model.entidades.Contato;
import com.agenda.agenda.model.entidades.ContatoAgenda;
import com.agenda.agenda.model.entidades.Endereco;
import com.agenda.agenda.model.entidades.Telefones;
import com.agenda.agenda.model.entidades.Usuario;
import com.agenda.agenda.model.repositorios.RepositorioContato;
import com.agenda.agenda.model.repositorios.RepositorioEndereco;
import com.agenda.agenda.model.repositorios.RepositorioTelefones;
import com.agenda.agenda.model.repositorios.RepositorioUsuario;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpSession session;

    @GetMapping("/home")
    public String principal(Model m) throws SQLException {

        if (this.verificaLogin() == 0) {
            return "redirect:/login";
        } else {
            List<ContatoAgenda> contatos = this.preencheContatos();
            m.addAttribute("contacts", contatos);
            return "home/home";
        }

    }

    @GetMapping("/logout")
    public String logout(Model m) {
        m.addAttribute("logado", "false");
        session.setAttribute("logado", "false");
        return "redirect:/";
    }

    @PostMapping("/update-profile")
    public String update() throws SQLException {
        if (this.verificaLogin() == 0) {
            return "redirect:/login";
        } else {
            session = request.getSession();
            String user_email = (String) session.getAttribute("user_email");
            
            String nome=request.getParameter("name");
            String email=request.getParameter("email");
            String password=request.getParameter("password");

            RepositorioUsuario usuario=new RepositorioUsuario();
            int usuario_id = usuario.pesquisarId("email", user_email);

            usuario.alterar(usuario_id, "nome", nome);
            usuario.alterar(usuario_id, "email", email);
            usuario.alterar(usuario_id, "senha", password);
        
        }
        return "redirect:/home";
    }

    @PostMapping("/add-contact")
    public String cadastrar(Model m) throws SQLException {
        if (this.verificaLogin() == 0) {
            return "redirect:/login";
        } else {

            session = request.getSession();

            String nome = request.getParameter("name");
            String telefone1 = request.getParameter("phone1");
            String telefone2 = request.getParameter("phone2");
            String telefone3 = request.getParameter("phone3");
            String rua = request.getParameter("street");
            int numero = Integer.parseInt(request.getParameter("number"));
            String cep = request.getParameter("cep");
            String complemento = request.getParameter("complement");

            // Adicionando informações no banco de dados: telefone
            Telefones phone = new Telefones();
            phone.setTelefone1(telefone1);
            phone.setTelefone2(telefone2);
            phone.setTelefone3(telefone3);

            RepositorioTelefones telefone = new RepositorioTelefones();
            telefone.inserir(phone);

            // Adicionando informações no banco de dados: endereco
            Endereco address = new Endereco();
            address.setRua(rua);
            address.setNumero(numero);
            address.setCep(cep);
            address.setComplemento(complemento);

            RepositorioEndereco endereco = new RepositorioEndereco();
            endereco.inserir(address);

            // Adicionando informações no banco de dados: contato 
            RepositorioUsuario usuario = new RepositorioUsuario();

            session = request.getSession();
            String user_email = (String) session.getAttribute("user_email");
            int telefone_id = telefone.pesquisarId("telefone1", telefone1);
            int endereco_id = endereco.pesquisarId("cep", cep);
            int usuario_id = usuario.pesquisarId("email", user_email);

            Contato contact = new Contato();
            contact.setNome(nome);
            contact.setIdUsuario(usuario_id);
            contact.setIdTelefone(telefone_id);
            contact.setIdEndereco(endereco_id);

            RepositorioContato contato = new RepositorioContato();
            contato.inserir(contact);

            return "redirect:/home";
        }
    }

    private int verificaLogin() {
        if (!session.getAttribute("logado").equals("true")) {
            return 0;
        } else {
            return 1;
        }
    }

    private List<ContatoAgenda> preencheContatos() throws SQLException {

        List<Contato> contatos = new ArrayList<Contato>();
        List<ContatoAgenda> contatosAgenda = new ArrayList<ContatoAgenda>();

        // Estratégia para pegar id do usuario logado
        String email = (String) session.getAttribute("user_email");
        RepositorioUsuario usuario = new RepositorioUsuario();
        int usuario_id = usuario.pesquisarId("email", email);

        // Pesquisar todos os contatos que tenho o usuario_id
        RepositorioContato contato = new RepositorioContato();
        contatos = contato.getContatos(usuario_id);

        RepositorioTelefones telefone = new RepositorioTelefones();
        RepositorioEndereco endereco = new RepositorioEndereco();
        for (Contato contact : contatos) {

            ContatoAgenda contatoAgenda = new ContatoAgenda();
            contatoAgenda.setNome(contact.getNome());
            contatoAgenda.setTelefone1(telefone.pesquisarTelefoneById(1, contact.getIdTelefone()));
            contatoAgenda.setTelefone2(telefone.pesquisarTelefoneById(2, contact.getIdTelefone()));
            contatoAgenda.setTelefone3(telefone.pesquisarTelefoneById(3, contact.getIdTelefone()));
            contatoAgenda.setEndereco(endereco.pesquisarEndereco(contact.getIdEndereco()));
            contatosAgenda.add(contatoAgenda);
        }
        return contatosAgenda;
    }
}
