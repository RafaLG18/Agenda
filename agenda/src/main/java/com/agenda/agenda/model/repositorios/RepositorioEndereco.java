package com.agenda.agenda.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agenda.agenda.model.entidades.Endereco;
public class RepositorioEndereco {
    
    public void inserir(Endereco endereco) throws SQLException {
        String sql="insert into endereco (cep, rua, numero, complemento) "+ "values(?,?,?,?)";
        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
        pstm.setString(1,endereco.getCep());
		pstm.setString(2,endereco.getRua());
		pstm.setInt(3,endereco.getNumero());
        pstm.setString(4,endereco.getComplemento());
        pstm.execute();
    }
    public String pesquisar(String coluna, String valor) throws SQLException {
        String sql="select "+coluna+" from endereco where "+coluna+"= ?";
        
        try(PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)){
            pstm.setString(1, valor);
            ResultSet query = pstm.executeQuery();
            while (query.next()) { 
                String resultado=query.getString(coluna);
                return resultado;
            }
        }
        return "";
    }
    public int pesquisarId(String coluna, String valor) throws SQLException {
        String sql="select id from endereco where "+coluna+"= ?";
        
        try(PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)){
            pstm.setString(1, valor);
            ResultSet query = pstm.executeQuery();
            while (query.next()) { 
                int resultado=query.getInt("id");
                return resultado;
            }
        }
        return -1;
    }
    public String pesquisarEndereco(int id) throws SQLException{
        String rua=this.pesquisarRua(id);
        String cep=this.pesquisarCep(id);
        String numero=this.pesquisarNumero(id);
        String complemento=this.pesquisarComplemento(id);
        String endereco=rua+","+cep+","+numero+","+complemento;
        
        return endereco;
    }
    private String pesquisarRua(int id) throws SQLException{
        String sql="select rua from endereco where id = ?";
        
        try(PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)){
            pstm.setInt(1, id);
            ResultSet query = pstm.executeQuery();
            while (query.next()) { 
                String resultado=query.getString("rua");
                return resultado;
            }
        }
        return "";
        
    }
    private String pesquisarCep(int id) throws SQLException{
        String sql="select cep from endereco where id = ?";
        
        try(PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)){
            pstm.setInt(1, id);
            ResultSet query = pstm.executeQuery();
            while (query.next()) { 
                String resultado=query.getString("cep");
                return resultado;
            }
        }
        return "";

    }
    private String pesquisarNumero(int id) throws SQLException{
        String sql="select numero from endereco where id = ?";
        
        try(PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)){
            pstm.setInt(1, id);
            ResultSet query = pstm.executeQuery();
            while (query.next()) { 
                String resultado=query.getString("numero");
                return resultado;
            }
        }
        return "";
        
    }
    private String pesquisarComplemento(int id) throws SQLException{
        String sql="select complemento from endereco where id = ?";
        
        try(PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)){
            pstm.setInt(1, id);
            ResultSet query = pstm.executeQuery();
            while (query.next()) { 
                String resultado=query.getString("complemento");
                return resultado;
            }
        }
        return "";
        
    }
    
}
