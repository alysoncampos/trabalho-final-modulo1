package br.com.dbc.devland.repository;

import br.com.dbc.devland.exceptions.BancoDeDadosException;
import br.com.dbc.devland.model.Endereco;
import br.com.dbc.devland.model.UsuarioDev;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnderecoRepository implements Repositorio<Integer, Endereco>  {

    @Override
    public Integer getProximoId(Connection connection) throws BancoDeDadosException {
        try {
            String sql = "SELECT seq_endereco.nextval mysequence from DUAL";
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
        try {
            String sql = "SELECT seq_usuario.nextval mysequence from DUAL";
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
    public Endereco adicionar(Endereco endereco) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            endereco.setId_endereco(proximoId);

            String sql = "INSERT INTO ENDERECO\n" +
                    "(ID_ENDERECO, COMPLEMENTO, NUMERO, LOGRADOURO, CEP, ESTADO, CIDADE, PAIS)\n" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, endereco.getId_endereco());
            stmt.setString(2, endereco.getComplemento());
            stmt.setString(3, endereco.getNumero());
            stmt.setString(4, endereco.getLogradouro());
            stmt.setString(5, endereco.getCep());
            stmt.setString(6, endereco.getEstado());
            stmt.setString(7, endereco.getCidade());
            stmt.setString(8, endereco.getPais());

            int res = stmt.executeUpdate();
            //System.out.println("adicionarContato.res=" + res);
            return endereco;
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

            String sql = "DELETE FROM ENDERECO WHERE ID_ENDERECO = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerEnderecoPorId.res=" + res);

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
    public boolean editar(Integer id, Endereco endereco) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE Endereco SET \n");

            sql.append(" logradouro = ?,");
            sql.append(" numero = ?,");
            sql.append(" complemento = ?,");
            sql.append(" cep = ?,");
            sql.append(" estado = ?,");
            sql.append(" cidade = ?,");
            sql.append(" pais = ?");

            //sql.deleteCharAt(sql.length() - 1); //remove o ultimo ','
            sql.append(" WHERE id_endereco = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            /*int index = 1;
            if (endereco != null) {
                if (endereco.getId_endereco() != null) {
                    stmt.setInt(index++, endereco.getId_endereco());
                }
            }*/

            stmt.setString(1, endereco.getLogradouro());
            stmt.setString(2, endereco.getNumero());
            stmt.setString(3, endereco.getComplemento());
            stmt.setString(4, endereco.getCep());
            stmt.setString(5, endereco.getEstado());
            stmt.setString(6, endereco.getCidade());
            stmt.setString(7, endereco.getPais());
            stmt.setInt(8, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            //System.out.println("editarEndereco.res=" + res);

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
    public List<Endereco> listar() throws BancoDeDadosException {
        List<Endereco> enderecos = new ArrayList<>();
        Connection con = null;
        try {
            Scanner leia = new Scanner(System.in);
            UsuarioDev senha = new UsuarioDev();
            System.out.println("Digite sua senha: ");
            senha.setSenha(leia.nextLine());

            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT E.*, " +
                    "            U.*" +
                    "       FROM ENDERECO E " +
                    "  INNER JOIN USUARIO U ON (U.ID_USUARIO = E.ID_ENDERECO) WHERE SENHA = ?";

            // Executa-se a consulta
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, senha.getSenha());
            ResultSet res = pstm.executeQuery();

            //ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Endereco endereco = getEnderecoFromResultSet(res);
                enderecos.add(endereco);
            }
            return enderecos;
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

    public List<Endereco> listarEnderecosPorPessoa(Integer idPessoa) throws BancoDeDadosException {
        List<Endereco> enderecos = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();


            String sql = "SELECT E.*, " +
                    "            U.NOME AS NOME " +
                    "       FROM ENDERECO E " +
                    " INNER JOIN USUARIO U ON (P.ID_USUARIO = E.ID_USUARIO) " +
                    "      WHERE U.ID_USUARIO = ? ";

            // Executa-se a consulta
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idPessoa);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Endereco endereco = getEnderecoFromResultSet(res);
                enderecos.add(endereco);
            }
            return enderecos;
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

    private Endereco getEnderecoFromResultSet(ResultSet res) throws SQLException {
        Endereco endereco = new Endereco();
        endereco.setId_endereco(res.getInt("id_endereco"));
        UsuarioDev usuario = new UsuarioDev();
        usuario.setNome(res.getString("nome"));
        usuario.setId_usuario(res.getInt("id_usuario"));
        //endereco.setUsuario(usuario);
        //endereco.setTipoEnum(TipoEnum.ofTipo(res.getInt("tipo")));
        endereco.setNumero(res.getString("numero"));
        endereco.setLogradouro(res.getString("logradouro"));
        endereco.setCidade(res.getString("cidade"));
        endereco.setEstado(res.getString("estado"));
        endereco.setPais(res.getString("pais"));
        return endereco;
    }
}
