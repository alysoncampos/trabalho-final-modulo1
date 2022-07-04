package br.com.dbc.devland.model;

import br.com.dbc.devland.repository.Impressao;
import br.com.dbc.devland.repository.Manipulacao;

public class UsuarioDev extends Usuario implements Impressao, Manipulacao<UsuarioDev> {

    private static String tipo = "DEV";
    private String stack;

    public UsuarioDev() {

    }

    public UsuarioDev(String nome, String email, Endereco endereco, String stack) {
        super(nome, email, endereco);
        this.stack = stack;
    }

    public static String getTipo() {
        return tipo;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    @Override
    public void adicionar(UsuarioDev objeto) {
        getListaDeUsuarios().add(objeto);
    }

    @Override
    public void editar(Integer indice, UsuarioDev objeto) {
        UsuarioDev contaProcurada = (UsuarioDev) getListaDeUsuarios().get(indice);
        contaProcurada.setNome(objeto.getNome());
        contaProcurada.setEmail(objeto.getEmail());
        contaProcurada.setEndereco(objeto.getEndereco());
        contaProcurada.setStack(objeto.getStack());
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

    @Override
    public String toString() {
        return  "Nome: " + getNome() + "\n" +
                "Email: " + getEmail() + "\n" +
                "Cidade: " + getEndereco().getCidade() + "\n" +
                "Estado: " + getEndereco().getEstado() + "\n" +
                "Pais: " + getEndereco().getPais() + "\n" +
                "Stack: " + getStack() + "\n" +
                "Tipo da Conta: " + getTipo();
    }

}
