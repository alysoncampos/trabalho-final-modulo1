package br.com.dbc.devland.main.entities;

import br.com.dbc.devland.main.interfaces.Impressao;
import br.com.dbc.devland.main.interfaces.Manipulacao;

public class ContaDev extends Conta implements Impressao, Manipulacao<ContaDev> {

    private static String tipo = "DEV";
    private String cpf;
    private String stack;

    public ContaDev(){
        super();
    }

    public ContaDev(Usuario usuario, String cpf, String stack) {
        super(usuario);
        this.cpf = cpf;
        this.stack = stack;
    }

    public ContaDev() {
        super();
    }

    public static String getTipo() {
        return tipo;
    }

    public static void setTipo(String tipo) {
        ContaDev.tipo = tipo;
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
    public void adicionar(ContaDev objeto) {
        getListaContas().add(objeto);
    }

    @Override
    public void editar(Integer indice, ContaDev objeto) {
        ContaDev contaProcurada = (ContaDev) getListaContas().get(indice);
        contaProcurada.setEmail(objeto.getEmail());
        contaProcurada.setNome(objeto.getNome());
        contaProcurada.setStack(objeto.getStack());
        contaProcurada.setCpf(objeto.getCpf());
    }

    @Override
    public void remover(Integer indice) {
        getListaContas().remove(indice.intValue());
    }

    @Override
    public void listar() {
        if (getListaContas().size() < 1){
            System.out.println("Nenhum cadastro encontrado");
            System.exit(0);
        }else {
            for (int i = 0; i < getListaContas().size(); i++) {
                System.out.println("id=" + i + " | " + getListaContas().get(i));
            }
        }
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Dados do Usuário: \n" +
                "Nome: " + getNome() + "\n" +
                "E-Mail: " + getEmail() + "\n" +
                "CPF: " + getCpf() + "\n" +
                "Stack: " + getStack();
    }

}
