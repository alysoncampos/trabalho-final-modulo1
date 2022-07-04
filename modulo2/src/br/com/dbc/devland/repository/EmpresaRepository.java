package br.com.dbc.devland.repository;

import br.com.dbc.devland.exceptions.BancoDeDadosException;
import br.com.dbc.devland.model.UsuarioEmpresa;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmpresaRepository implements Repositorio<Integer, UsuarioEmpresa> {
    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public Integer getProximoIdDev(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public UsuarioEmpresa adicionar(UsuarioEmpresa object) throws BancoDeDadosException {
        return null;
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        return false;
    }

    @Override
    public boolean editar(Integer id, UsuarioEmpresa usuarioDev) throws BancoDeDadosException {
        return false;
    }

    @Override
    public List<UsuarioEmpresa> listar() throws BancoDeDadosException {
        return null;
    }
}
