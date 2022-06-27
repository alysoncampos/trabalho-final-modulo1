package br.com.dbc.devland.main.entities;

import br.com.dbc.devland.main.interfaces.Impressao;
import br.com.dbc.devland.main.interfaces.Manipulacao;

public class ContaEmpresa extends Conta implements Impressao, Manipulacao<ContaEmpresa> {

    private String cnpj;

    private static String tipo = "EMPRESA";

    public ContaEmpresa(Usuario usuario, String cnpj) {
        super(usuario);
        this.cnpj = cnpj;
    }

    public ContaEmpresa(){
        super();
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public static String getTipo() {
        return tipo;
    }

    public static void setTipo(String tipo) {
        ContaEmpresa.tipo = tipo;
    }

    @Override
    public void adicionar(ContaEmpresa objeto) {
        getListaContas().add(objeto);
    }

    @Override
    public void editar(Integer indice, ContaEmpresa objeto) {
        ContaEmpresa empresaProcurada = (ContaEmpresa) getListaContas().get(indice);
        empresaProcurada.setCnpj(objeto.getCnpj());
        empresaProcurada.setNome(objeto.getNome());
        empresaProcurada.setEmail(objeto.getEmail());
    }

    @Override
    public void remover(Integer indice) {
        getListaContas().remove(indice.intValue());
    }

    @Override
    public void listar() {
        for (int i = 0; i < getListaContas().size(); i++){
            System.out.println(getListaContas().get(i));
        }
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return  "Nome da Empresa: " + getNome() + '\'' + " | " +
                "E-Mail: " + getEmail() + '\'' + " | " +
                "CNPJ: " + cnpj + '\'' + " | ";
    }
}
