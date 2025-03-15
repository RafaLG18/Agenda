package com.agenda.agenda.model.entidades;

public class Contato {
    public int id;
    public String nome;
    public int idUsuario;
    public int idTelefone;
    public int idEndereco;
    
    public void setNome(String nome){
        this.nome=nome;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setIdUsuario(int id){
        this.idUsuario=id;
    }
    public void setIdTelefone(int id){
        this.idTelefone=id;
    }
    public void setIdEndereco(int id){
        this.idEndereco=id;
    }

    public String getNome(){
        return this.nome;
    }
    public int getId(){
        return this.id;
    }
    public int getIdUsuario(){
        return this.idUsuario;
    }
    public int getIdTelefone(){
        return this.idTelefone;
    }
    public int getIdEndereco(){
        return this.idEndereco;
    }
}
