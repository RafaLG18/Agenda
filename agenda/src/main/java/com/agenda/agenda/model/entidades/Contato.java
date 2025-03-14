package com.agenda.agenda.model.entidades;

public class Contato {
    public int idUsuario;
    public int idTelefone;
    public int idEndereco;
    
    public void setIdUsuario(int id){
        this.idUsuario=id;
    }
    public void setIdTelefone(int id){
        this.idTelefone=id;
    }
    public void setIdEndereco(int id){
        this.idEndereco=id;
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
