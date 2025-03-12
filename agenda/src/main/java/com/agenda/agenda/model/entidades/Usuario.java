package com.agenda.agenda.model.entidades;

public class Usuario {
    
    public String nome;
    public String email;
    public int senha;

    // Metodos de introducao de dados
    public void setNome(String nome){
        this.nome=nome;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setSenha(int senha){
        this.senha=senha;
    }
}
