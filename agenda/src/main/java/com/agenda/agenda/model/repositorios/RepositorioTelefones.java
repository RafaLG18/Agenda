package com.agenda.agenda.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agenda.agenda.model.entidades.Telefones;
public class RepositorioTelefones {
    public void inserir(Telefones telefones) throws SQLException {
        String sql="insert into telefones (telefone1, telefone2, telefone3) "+ "values(?,?,?)";
        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
        pstm.setString(1,telefones.getTelefone1());
		pstm.setString(2,telefones.getTelefone2());
		pstm.setString(3,telefones.getTelefone3());
        pstm.execute();
    }

    public String pesquisar(String coluna, String valor) throws SQLException {
        String sql="select "+coluna+" from telefones where "+coluna+"= ?";
        
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
    public String pesquisarTelefoneById(int number_col,int telefone_id) throws SQLException {
        String sql="select telefone"+number_col+" from telefones where id = ?";
        
        try(PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)){
            pstm.setInt(1, telefone_id);
            ResultSet query = pstm.executeQuery();
            while (query.next()) { 
                String resultado=query.getString("telefone"+number_col);
                return resultado;
            }
        }
        return "";
    }

    public int pesquisarId(String coluna, String valor) throws SQLException {
        String sql="select id from telefones where "+coluna+"= ?";
        
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
