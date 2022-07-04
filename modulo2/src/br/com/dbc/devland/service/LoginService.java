package br.com.dbc.devland.service;

import br.com.dbc.devland.model.UsuarioDev;
import br.com.dbc.devland.repository.ConexaoBancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {

    Connection con;

    public ResultSet autenticacaoDev (UsuarioDev objLoginDev) throws SQLException {
        con = ConexaoBancoDeDados.getConnection();
        try {
            String sql = "SELECT U.SENHA,\n" +
                         "UD.CPF\n" +
                         "FROM USUARIO U\n" +
                         "INNER JOIN USUARIODEV UD ON (U.ID_USUARIO = UD.ID_USUARIO) WHERE CPF = ? AND SENHA = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, objLoginDev.getCpf());
            pstm.setString(2, objLoginDev.getSenha());

            ResultSet rs = pstm.executeQuery();

            return rs;
        } catch (SQLException erro) {
            System.out.println("Erro de autenticacao");
            return null;
        }

    }

}
