package com.agenda.agenda.model.entidades;

public class Endereco {
    
    private String cep;
    private String rua;
    private int numero;
    private String complemento;

    // Metodos de atribuicao
    public void setCep(String cep){
        this.cep=cep;
    }
    public void setRua(String rua){
        this.rua=rua;
    }
    public void setNumero(int numero){
        this.numero=numero;
    }
    public void setComplemento(String complemento){
        this.complemento=complemento;
    }
    // Metodos de retorno
    public String getCep(){
        return cep;
    }
    public String getRua(){
        return rua;
    }
    public int getNumero(){
        return numero;
    }
    public String getComplemento(){
        return complemento;
    }
}
