package br.com.dbc.devland.main.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repositorio<CHAVE, OBJETO> {

    Integer getProximoId(Connection connection) throws SQLException;

    OBJETO adicionar(OBJETO objeto) throws BancoDeDadosException;

    boolean remover(CHAVE id) throws BancoDeDadosException;

    boolean editar(CHAVE id, OBJETO objeto) throws BancoDeDadosException;

    List<OBJETO> listar() throws BancoDeDadosException;
}
