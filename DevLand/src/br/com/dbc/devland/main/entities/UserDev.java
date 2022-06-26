package br.com.dbc.devland.main.entities;

import br.com.dbc.devland.main.interfaces.Impressao;
import br.com.dbc.devland.main.interfaces.Manipulacao;

public class UserDev extends User implements Impressao, Manipulacao<UserDev> {
    private static String tipo = "DEV";
    private String cpf, stack, cv;

    public UserDev(String nome, String email, String telefone, String cpf, String stack, String cv) {
        super(nome, email, telefone);
        this.cpf = cpf;
        this.stack = stack;
        this.cv = cv;
    }

    public UserDev() {
        super();
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

    public void editarCV(Integer indice, UserDev objeto) {
        UserDev devProcurado = (UserDev) getListaDeUser().get(indice);
        if (objeto.cv == null) {
            devProcurado.cv = getCv();
        } else {
            devProcurado.setCv(objeto.getCv());
        }
    }

    @Override
    public void remover(Integer indice) {
        getListaDeUser().remove(indice.intValue());
    }

    @Override
    public void listar() {
        for (int i = 0; i < getListaDeUser().size(); i++) {
            System.out.println("id=" + i + " | " + getListaDeUser().get(i));
        }
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
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
        return "Nome da Empresa: " + getNome() + '\'' + " | " +
                "E-Mail: " + getEmail() + '\'' + " | " +
                "Telefone: " + getTelefone() + '\'' + " | " +
                "CPF: " + cpf + '\'' + " | " +
                "Stack: " + stack + '\'' + " | ";
    }

    @Override
    public void imprimir(Integer indice, Object objeto) {
        UserDev devProcurado = (UserDev) getListaDeUser().get(indice);
        System.out.println("\nSeu curriculo \n-----------------\n" + devProcurado.getCv()+"\n");
    }
}
