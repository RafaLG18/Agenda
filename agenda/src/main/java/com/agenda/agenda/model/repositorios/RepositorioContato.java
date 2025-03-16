package com.agenda.agenda.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agenda.agenda.model.entidades.Contato;

public class RepositorioContato {
    public void inserir(Contato contato) throws SQLException {
        String sql="insert into contato (nome_contato, usuario_id, telefone_id, endereco_id) "+ "values(?,?,?,?)";
        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
        pstm.setString(1,contato.getNome());
		pstm.setInt(2,contato.getIdUsuario());
		pstm.setInt(3,contato.getIdTelefone());
        pstm.setInt(4,contato.getIdEndereco());
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
        String sql="select id from contato where "+coluna+"= ?";
        
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
