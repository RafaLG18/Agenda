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
}
