package com.agenda.agenda.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agenda.agenda.model.entidades.Usuario;
public class RepositorioUsuario {
    
    public void inserir(Usuario usuario) throws SQLException {
        String sql="insert into usuario (nome, email, senha) "+ "values(?,?,?)";
        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
        pstm.setString(1,usuario.getNome());
		pstm.setString(2,usuario.getEmail());
		pstm.setString(3,usuario.getSenha());
        pstm.execute();
    }
    public String pesquisar(String coluna, String valor) throws SQLException {
        String sql="select "+coluna+" from usuario where "+coluna+"= ?";
        
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
}
