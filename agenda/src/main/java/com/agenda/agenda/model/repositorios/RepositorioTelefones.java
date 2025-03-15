package com.agenda.agenda.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.agenda.agenda.model.entidades.Telefones;
public class RepositorioTelefones {
    public void inserir(Telefones telefones) throws SQLException {
        String sql="insert into telefones (nome, email, senha) "+ "values(?,?,?)";
        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
        pstm.setString(1,telefones.getNome());
		pstm.setString(2,telefones.getEmail());
		pstm.setString(3,telefones.getSenha());
        pstm.execute();
    }
}
