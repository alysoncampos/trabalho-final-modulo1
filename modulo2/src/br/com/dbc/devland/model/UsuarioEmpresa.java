package br.com.dbc.devland.model;

import br.com.dbc.devland.repository.Impressao;
import br.com.dbc.devland.repository.Manipulacao;

public class UsuarioEmpresa extends Usuario implements Impressao, Manipulacao<UsuarioEmpresa> {

    private static String tipo = "EMPRESA";
    private String areaDeAtuacao;

    public String getAreaDeAtuacao() {
        return areaDeAtuacao;
    }

    public void setAreaDeAtuacao(String areaDeAtuacao) {
        this.areaDeAtuacao = areaDeAtuacao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    private String cnpj;

    @Override
    public void adicionar(UsuarioEmpresa objeto) {
        getListaDeUsuarios().add(objeto);
    }

    @Override
    public void editar(Integer indice, UsuarioEmpresa objeto) {

    }

    /*@Override
    public void editar(Integer indice, UsuarioEmpresa objeto) {
        UsuarioEmpresa empresaProcurada = (UsuarioEmpresa) getListaDeUsuarios().get(indice);
        empresaProcurada.setNome(objeto.getNome());
        empresaProcurada.setEmail(objeto.getEmail());
        empresaProcurada.setEndereco(objeto.getEndereco());
        empresaProcurada.setAreaDeAtuacao(objeto.getAreaDeAtuacao());
    }*/

    @Override
    public void remover(Integer indice) {
        getListaDeUsuarios().remove(indice.intValue());
    }

    @Override
    public void listar() {
        if(getListaDeUsuarios().size() < 1){
            System.out.println("Nenhum cadastro encontrado");
            System.exit(0);
        }
        else {
            for (int i = 0; i < getListaDeUsuarios().size(); i++){
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
