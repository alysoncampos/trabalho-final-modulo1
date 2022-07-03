package br.com.dbc.devland.repository;

import br.com.dbc.devland.exceptions.BancoDeDadosException;
import br.com.dbc.devland.model.Postagem;
import br.com.dbc.devland.model.TemaPostagem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostagemRepository implements Repositorio<Integer, Postagem>{

    @Override
    public Integer getProximoId(Connection connection) throws BancoDeDadosException {
        try{
            String sql = "SELECT seq_postagem.nextval mysequence from DUAL";
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
    public Postagem adicionar(Postagem postagem) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            postagem.setIdPostagem(proximoId);

            String sql = "INSERT INTO POSTAGEM\n" +
                    "(ID_POSTAGEM, TITULO, DESCRICAO, TIPO)\n" +
                    "VALUES(?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, postagem.getIdPostagem());
            //stmt.setInt(2, postagem.getUsuario().getIdUsuario());
            stmt.setString(2, postagem.getTitulo());
            stmt.setString(3, postagem.getDescricao());
            stmt.setInt(4, postagem.getTemaPostagem().getTema());
            //stmt.setDate(5, postagem.getData());

            int res = stmt.executeUpdate();
            System.out.println("adicionarPostagem.res=" + res);
            return postagem;
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

            String sql = "DELETE FROM POSTAGEM WHERE id_postagem = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerPostagemPorId.res=" + res);

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
    public boolean editar(Integer id, Postagem postagem) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE POSTAGEM SET ");
            sql.append(" tipo = ?,");
            sql.append(" titulo = ?,");
            sql.append(" descricao = ? ");
            sql.append(" WHERE id_postagem = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setInt(1, postagem.getTemaPostagem().getTema());
            stmt.setString(2, postagem.getTitulo());
            stmt.setString(3, postagem.getDescricao());
            stmt.setInt(4, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("editarPostagem.res=" + res);

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
    public List<Postagem> listar() throws BancoDeDadosException {
        List<Postagem> postagens = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM POSTAGEM";

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Postagem postagem = getPostagemFromResultSet(res);
                postagens.add(postagem);
            }
            return postagens;
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

//    public List<Postagem> listarPostagemPorPessoa(Integer idPessoa) throws BancoDeDadosException {
//        List<Postagem> postagens = new ArrayList<>();
//        Connection con = null;
//        try {
//            con = ConexaoBancoDeDados.getConnection();
//
//            String sql = "SELECT P.*, " +
//                    "            U.NOME AS NOME_USUARIO " +
//                    "       FROM POSTAGEM P " +
//                    " INNER JOIN USUARIO U ON (P.ID_USUARIO = C.ID_USUARIO) " +
//                    "      WHERE P.ID_USUARIO = ? ";
//
//            // Executa-se a consulta
//            PreparedStatement stmt = con.prepareStatement(sql);
//            stmt.setInt(1, idPessoa);
//
//            ResultSet res = stmt.executeQuery();
//
//            while (res.next()) {
//                Postagem postagem = getPostagemFromResultSet(res);
//                postagens.add(postagem);
//            }
//            return postagens;
//        } catch (SQLException e) {
//            throw new BancoDeDadosException(e.getCause());
//        } finally {
//            try {
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }


//    public List<Postagem> listarPorTema(Integer tema) throws BancoDeDadosException {
//        List<Postagem> postagensTema = new ArrayList<>();
//        Connection con = null;
//
//        try{
//            con = ConexaoBancoDeDados.getConnection();
//
//            String sql = "SELECT * " +
//                    "       FROM POSTAGEM " +
//                    "      WHERE TIPO = ?";
//
//            PreparedStatement stmt = con.prepareStatement(sql);
//            stmt.setInt(1, tema);
//
//            ResultSet res = stmt.executeQuery(sql);
//
//            while (res.next()) {
//                Postagem postagem = getPostagemFromResultSet(res);
//                postagensTema.add(postagem);
//            }
//            return postagensTema;
//        } catch (SQLException e) {
//            throw new BancoDeDadosException(e.getCause());
//        } finally {
//            try {
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    private Postagem getPostagemFromResultSet(ResultSet res) throws SQLException {
        Postagem postagem = new Postagem();
        postagem.setIdPostagem(res.getInt("id_postagem"));
//        Usuario usuario = new Usuario();
//        usuario.setNome(res.getString("nome_usuario"));
//        usuario.setIdUsuario(res.getInt("id_usuario"));
//        postagem.setUsuario(usuario);
        postagem.setTemaPostagem(TemaPostagem.ofTema(res.getInt("tipo")));
        postagem.setTitulo(res.getString("titulo"));
        postagem.setDescricao(res.getString("descricao"));
        return postagem;
    }
}
