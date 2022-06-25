package br.com.dbc.devland.main.entities;

import br.com.dbc.devland.main.interfaces.Impressao;
import br.com.dbc.devland.main.interfaces.Manipulacao;

public class UserDev extends User implements Impressao, Manipulacao<UserDev> {
    private static String tipo = "DEV";
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public void imprimir() {

    }

    @Override
    public void adicionar(UserDev objeto) {

    }

    @Override
    public void editar(Integer indice, UserDev objeto) {

    }

    @Override
    public void remover(Integer indice) {

    }

    @Override
    public void listar() {

    }
}
