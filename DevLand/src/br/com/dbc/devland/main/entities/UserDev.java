package br.com.dbc.devland.main.entities;

import br.com.dbc.devland.main.interfaces.Impressao;
import br.com.dbc.devland.main.interfaces.Manipulacao;

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
        getListaDeUser().add(objeto);
    }

    @Override
    public void editar(Integer indice, UserDev objeto) {
        UserDev devProcurado = (UserDev) getListaDeUser().get(indice);
        devProcurado.setTelefone(objeto.getTelefone());
        devProcurado.setStack(objeto.getStack());
        devProcurado.setEmail(objeto.getEmail());
    }

    @Override
    public void remover(Integer indice) {
        getListaDeUser().remove(indice.intValue());
    }

    @Override
    public void listar() {
        for (int i = 0; i < getListaDeUser().size(); i++) {
            System.out.println("id=" + i + " | " + getListaDeUser());
        }
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

    @Override
    public String toString() {
        return "Nome: " + getNome() + '\'' + " | " +
                "E-Mail: " + getEmail() + '\'' + " | " +
                "Telefone: " + getTelefone() + '\'' + " | " +
                "CPF: " + cpf + '\'' + " | " +
                "Stack: " + stack + '\'';
    }
}
