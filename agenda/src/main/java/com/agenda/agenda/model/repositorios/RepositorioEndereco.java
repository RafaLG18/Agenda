package com.agenda.agenda.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.agenda.agenda.model.entidades.Endereco;
public class RepositorioEndereco {
    public void inserir(Endereco endereco) throws SQLException {
        String sql="insert into endereco (nome, email, senha) "+ "values(?,?,?)";
        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
        pstm.setString(1,endereco.getNome());
		pstm.setString(2,endereco.getEmail());
		pstm.setString(3,endereco.getSenha());
        pstm.execute();
    }
}
