package com.agenda.agenda.model.entidades;

public class Telefones {
    public String telefone1;
    public String telefone2;
    public String telefone3;
    public Telefones(){
        this.telefone1="-";
        this.telefone2="-";
        this.telefone3="-";

    }
    // Metodos de inserir dados
    public void setTelefone1(String telefone){
        this.telefone1=telefone;
    }
    public void setTelefone2(String telefone){
        this.telefone2=telefone;
    }
    public void setTelefone3(String telefone){
        this.telefone3=telefone;
    }

    // Metodos de retornar valores
    public String getTelefone1(){
        return this.telefone1;
    }
    public String getTelefone2(){
        return this.telefone2;
    }
    public String getTelefone3(){
        return this.telefone3;
    }
}
