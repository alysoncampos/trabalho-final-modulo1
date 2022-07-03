package br.com.dbc.devland.repository;

import br.com.dbc.devland.exceptions.BancoDeDadosException;
import br.com.dbc.devland.model.UsuarioDev;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UsuarioDevRepository implements Repositorio<Integer, UsuarioDev> {

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {

        String sql = "SELECT seq_usuario.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");
        }
        return null;
    }

    @Override
    public Integer getProximoIdDev(Connection connection) throws SQLException {
        String sql = "SELECT seq_usuario_dev.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);


        if (res.next()) {
            return res.getInt("mysequence");
        }
        return null;
    }

    @Override
    public UsuarioDev adicionar(UsuarioDev usuarioDev) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            usuarioDev.setId_usuario(proximoId);

            String sql = "INSERT INTO USUARIO\n" +
                    "(ID_USUARIO, ID_ENDERECO, ID_CONTATO, NOME, EMAIL, SENHA)\n" +
                    "VALUES(?, ?, ?, ?, ?, ?)\n";

            Integer proximoIdDev = this.getProximoIdDev(con);
            usuarioDev.setId_dev(proximoIdDev);

            String sql2 = "INSERT INTO USUARIODEV\n" +
                    "(ID_DEV, ID_USUARIO, STACK, CPF)\n" +
                    "VALUES(?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);
            PreparedStatement stmt2 = con.prepareStatement(sql2);

            stmt.setInt(1, usuarioDev.getId_usuario());
            stmt.setInt(2, usuarioDev.getId_usuario());
            stmt.setInt(3, usuarioDev.getId_usuario());
            stmt.setString(4, usuarioDev.getNome());
            stmt.setString(5, usuarioDev.getEmail());
            stmt.setString(6, usuarioDev.getSenha());

            stmt2.setInt(1, usuarioDev.getId_dev());
            stmt2.setInt(2, usuarioDev.getId_usuario());
            stmt2.setString(3, usuarioDev.getStack());
            stmt2.setString(4, usuarioDev.getCpf());

            stmt.executeUpdate();
            stmt2.executeUpdate();

            return usuarioDev;

        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM USUARIODEV WHERE ID_DEV = ?";
            String sql4 = "DELETE FROM ENDERECO WHERE ID_ENDERECO = ?";
            String sql2 = "DELETE FROM USUARIO WHERE ID_USUARIO = ?";
            String sql3 = "DELETE FROM CONTATO WHERE ID_CONTATO = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            PreparedStatement stmt2 = con.prepareStatement(sql2);

            stmt2.setInt(1, id);

            PreparedStatement stmt3 = con.prepareStatement(sql3);

            stmt3.setInt(1, id);

            PreparedStatement stmt4 = con.prepareStatement(sql4);

            stmt4.setInt(1, id);

            int res = stmt.executeUpdate();
            int res3 = stmt3.executeUpdate();
            int res2 = stmt2.executeUpdate();
            int res4 = stmt4.executeUpdate();

            System.out.println("Cadastro Excluído");

            return res > 0;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean editar(Integer id, UsuarioDev dev) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE USUARIO SET ");
            sql.append(" NOME = ?, ");
            sql.append(" EMAIL = ? ");
            sql.append(" WHERE ID_USUARIO = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setString(1, dev.getNome());
            stmt.setString(2, dev.getEmail());
            stmt.setInt(3, id);

            StringBuilder sql2 = new StringBuilder();
            sql2.append("UPDATE USUARIODEV SET ");
            sql2.append(" STACK = ? ");
            sql2.append(" WHERE ID_DEV = ? ");

            PreparedStatement stmt2 = con.prepareStatement(sql2.toString());

            stmt2.setString(1, dev.getStack());
            stmt2.setInt(2, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            int res2 = stmt2.executeUpdate();

            return res > 0;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<UsuarioDev> listar() throws BancoDeDadosException {
        List<UsuarioDev> devs = new ArrayList<>();
        Connection con = null;
        try {
            Scanner leia = new Scanner(System.in);
            UsuarioDev senha = new UsuarioDev();
            System.out.println("Digite sua senha: ");
            senha.setSenha(leia.nextLine());

            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM USUARIO WHERE SENHA = ?";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, senha.getSenha());
            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                UsuarioDev dev = new UsuarioDev();
                dev.setId_usuario(res.getInt("id_usuario"));
                /*dev.setNome(res.getString("nome"));
                dev.setCpf(res.getString("cpf"));
                dev.setStack(res.getString("stack"));*/
                devs.add(dev);
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return devs;
    }
}
