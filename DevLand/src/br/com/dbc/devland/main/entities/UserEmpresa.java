package br.com.dbc.devland.main.entities;

import br.com.dbc.devland.main.interfaces.Impressao;
import br.com.dbc.devland.main.interfaces.Manipulacao;

public class UserEmpresa extends User implements Impressao, Manipulacao<UserEmpresa> {

    private static String tipo = "EMPRESA";
    private String cnpj;
    public UserEmpresa(Integer id, String nome, String email, String telefone, String cnpj) {
        super(id, nome, email, telefone);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public void imprimir() {

    }

    @Override
    public void adicionar(UserEmpresa objeto) {

    }

    @Override
    public void editar(Integer indice, UserEmpresa objeto) {

    }

    @Override
    public void remover(Integer indice) {

    }

    @Override
    public void listar() {

    }

}
