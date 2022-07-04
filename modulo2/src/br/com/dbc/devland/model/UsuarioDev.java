package br.com.dbc.devland.model;

import br.com.dbc.devland.repository.Impressao;
import br.com.dbc.devland.repository.Manipulacao;

public class UsuarioDev extends Usuario implements Impressao, Manipulacao<UsuarioDev> {

    private static String tipo = "DEV";
    private String stack, cpf;

    private Integer id_dev;

    public Integer getId_dev() {
        return id_dev;
    }

    public void setId_dev(Integer id_dev) {
        this.id_dev = id_dev;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public void adicionar(UsuarioDev objeto) {
        getListaDeUsuarios().add(objeto);
    }

    @Override
    public void editar(Integer indice, UsuarioDev objeto) {

    }

    @Override
    public void remover(Integer indice) {
        getListaDeUsuarios().remove(indice.intValue());
    }

    @Override
    public void listar() {
        if (getListaDeUsuarios().size() < 1){
            System.out.println("Nenhum cadastro encontrado");
            System.exit(0);
        }else {
            for (int i = 0; i < getListaDeUsuarios().size(); i++) {
                System.out.println("------------------------------");
                System.out.println("id: " + i);
                System.out.println(getListaDeUsuarios().get(i));
                System.out.println("------------------------------");
            }
        }
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }
}
