package br.com.dbc.devland.repository;

import br.com.dbc.devland.exceptions.BancoDeDadosException;
import br.com.dbc.devland.model.Contato;
import br.com.dbc.devland.model.TipoEnum;
import br.com.dbc.devland.model.UsuarioDev;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContatoRepository implements Repositorio<Integer, Contato> {
    @Override
    public Integer getProximoId(Connection connection) throws BancoDeDadosException {
        try {
            String sql = "SELECT seq_contato.nextval mysequence from DUAL";
            Statement stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery(sql);

            if (res.next()) {
                return res.getInt("mysequence");
            }

            return null;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        }
    }

    @Override
    public Integer getProximoIdDev(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public Contato adicionar(Contato contato) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            contato.setId_contato(proximoId);

            String sql = "INSERT INTO CONTATO\n" +
                    "(ID_CONTATO, ID_USUARIO, TIPO, NUMERO)\n" +
                    "VALUES(?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, contato.getId_contato());
            stmt.setInt(2, contato.getId_contato());
            stmt.setInt(3, contato.getTipoEnum().getTipo());
            stmt.setString(4, contato.getNumero());

            int res = stmt.executeUpdate();
            //System.out.println("adicionarContato.res=" + res);
            return contato;
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

            String sql = "DELETE FROM CONTATO WHERE ID_CONTATO = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerContatoPorId.res=" + res);

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
    public boolean editar(Integer id, Contato contato) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE Contato SET \n");

            //Usuario usuario = contato.getUsuario();

            /*if (contato.getId_contato() > 0) {
                    sql.append(" id_usuario = ?,");
            }*/


                sql.append(" tipo = ?,");


                sql.append(" numero = ?");


            //sql.deleteCharAt(sql.length() - 1); //remove o ultimo ','
            sql.append(" WHERE id_contato = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            //int index = 1;
           /* if (usuario != null) {
                if (usuario.getId_usuario() != null) {
                    stmt.setInt(index++, usuario.getId_usuario());
                }
            }*/

                stmt.setInt(1, contato.getTipoEnum().getTipo());


                stmt.setString(2, contato.getNumero());


            stmt.setInt(3, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            //System.out.println("editarContato.res=" + res);

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
    public List<Contato> listar() throws BancoDeDadosException {
        List<Contato> contatos = new ArrayList<>();
        Connection con = null;
        try {
            Scanner leia = new Scanner(System.in);
            UsuarioDev senha = new UsuarioDev();
            System.out.println("Digite sua senha: ");
            senha.setSenha(leia.nextLine());

            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT C.*, " +
                    "            U.*" +
                    "       FROM CONTATO C " +
                    "  INNER JOIN USUARIO U ON (U.ID_USUARIO = C.ID_USUARIO) WHERE SENHA = ?";

            // Executa-se a consulta

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, senha.getSenha());
            ResultSet res = pstm.executeQuery();

            //ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Contato contato = getContatoFromResultSet(res);
                contatos.add(contato);
            }
            return contatos;
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

    /*private Contato getContatoFromResultSet(ResultSet res) throws SQLException {
        Contato contato = new Contato();
        contato.setId_contato(res.getInt("id_contato"));
        UsuarioDev usuario = new UsuarioDev();
        usuario.setNome(res.getString("nome"));
        usuario.setId_usuario(res.getInt("id_usuario"));
        contato.setUsuario(usuario);
        contato.setTipoEnum(TipoEnum.ofTipo(res.getInt("tipo")));
        contato.setNumero(res.getString("numero"));
        return contato;
    }*/
    private Contato getContatoFromResultSet(ResultSet res) throws SQLException {
        Contato contato = new Contato();
        contato.setId_contato(res.getInt("id_contato"));
        UsuarioDev usuario = new UsuarioDev();
        usuario.setNome(res.getString("nome"));
        usuario.setId_usuario(res.getInt("id_usuario"));
        contato.setUsuario(usuario);
        contato.setTipoEnum(TipoEnum.ofTipo(res.getInt("tipo")));
        contato.setNumero(res.getString("numero"));
        return contato;
    }
}
