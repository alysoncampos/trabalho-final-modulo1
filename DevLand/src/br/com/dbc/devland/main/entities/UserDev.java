package br.com.dbc.devland.main.entities;

import br.com.dbc.devland.main.interfaces.Impressao;
import br.com.dbc.devland.main.interfaces.Manipulacao;

import java.util.List;

public class UserDev extends User implements Impressao, Manipulacao<UserDev> {
    private static String tipo = "DEV";
    private String cpf, stack;

    public UserDev(Integer id, String nome, String email, String telefone, String cpf, String stack) {
        super(id, nome, email, telefone);
        this.cpf = cpf;
        this.stack = stack;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }
}
