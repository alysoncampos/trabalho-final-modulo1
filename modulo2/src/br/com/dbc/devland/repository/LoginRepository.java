package br.com.dbc.devland.repository;

import br.com.dbc.devland.exceptions.BancoDeDadosException;
import br.com.dbc.devland.model.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LoginRepository implements Repositorio <Integer, Usuario> {

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public Integer getProximoIdDev(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public Usuario adicionar(Usuario object) throws BancoDeDadosException {
        return null;
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        return false;
    }

    @Override
    public boolean editar(Integer id, Usuario usuario) throws BancoDeDadosException {
        return false;
    }

    @Override
    public List<Usuario> listar() throws BancoDeDadosException {
        return null;
    }
}
