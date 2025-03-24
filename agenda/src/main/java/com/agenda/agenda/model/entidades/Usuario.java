package com.agenda.agenda.model.entidades;

public class Usuario {
    
    public String nome;
    public String email;
    public String senha;

    public String getNome(){
        return this.nome;
    }
    public String getEmail(){
        return this.email;
    }
    public String getSenha(){
        return this.senha;
    }
    // Metodos de introducao de dados
    public void setNome(String nome){
        this.nome=nome;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setSenha(String senha){
        this.senha=senha;
    }
}
