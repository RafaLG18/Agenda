package com.agenda.agenda.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.agenda.agenda.model.entidades.Contato;

public class RepositorioContato {
    public void inserir(Contato contato) throws SQLException {
        String sql="insert into contato (nome, email, senha) "+ "values(?,?,?)";
        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
        pstm.setString(1,contato.getNome());
		pstm.setString(2,contato.getEmail());
		pstm.setString(3,contato.getSenha());
        pstm.execute();
    }
}
