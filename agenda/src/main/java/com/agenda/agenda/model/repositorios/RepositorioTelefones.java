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

    public int pesquisarId(String coluna, String valor) throws SQLException {
        String sql="select id from telefones where "+coluna+"= ?";
        
        try(PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)){
            pstm.setString(1, valor);
            ResultSet query = pstm.executeQuery();
            while (query.next()) { 
                int resultado=query.getInt(coluna);
                return resultado;
            }
        }
        return -1;
    }
}
