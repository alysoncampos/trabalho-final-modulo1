package br.com.dbc.devland.main.entities;

import br.com.dbc.devland.main.interfaces.Impressao;
import br.com.dbc.devland.main.interfaces.Manipulacao;

public class UserDev extends User implements Impressao, Manipulacao<UserDev> {
    private static String tipo = "DEV";
    private String cpf, stack, cv;

    public UserDev(Integer id, String nome, String email, String telefone, String cpf, String stack, String cv) {
        super(id, nome, email, telefone);
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
        if (getListaDeUser().size() < 1){
            System.out.println("Nenhum cadastro encontrado");
            System.exit(0);
        }else {
            for (int i = 0; i < getListaDeUser().size(); i++) {
                System.out.println("id=" + i + " | " + getListaDeUser().get(i));
            }
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
        return "Nome do Dev: " + getNome() + '\'' + " | " +
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
