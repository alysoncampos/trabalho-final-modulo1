package br.com.dbc.devland.main.entities;

import br.com.dbc.devland.main.interfaces.Impressao;
import br.com.dbc.devland.main.interfaces.Manipulacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Postagem implements Impressao, Manipulacao<Postagem> {
    private String titulo, texto;
    private User usuario;
    private List<Postagem> listaPostagens = new ArrayList<>();


    public Postagem(String titulo, String texto, User usuario) {
        this.titulo = titulo;
        this.texto = texto;
        this.usuario = usuario;
    }

    @Override
    public void adicionar(Postagem objeto) {
        getListaPostagens().add(objeto);
    }

    @Override
    public void editar(Integer indice, Postagem objeto) {
        Postagem postagemProcurada = (Postagem) getListaPostagens().get(indice);
        postagemProcurada.setTexto(objeto.getTexto());
        postagemProcurada.setTitulo(objeto.getTitulo());
    }

    @Override
    public void remover(Integer indice) {
        getListaPostagens().remove(indice.intValue());
    }

    @Override
    public void listar() {
        for (int i = 0; i < getListaPostagens().size(); i++){
            System.out.println("id=" + i + " | " + getListaPostagens().get(i));
        }
    }

    @Override
    public void imprimir() {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public List<Postagem> getListaPostagens() {
        return listaPostagens;
    }

    public String toString() {
        return "Título: " + getTitulo() + " Texto: " + getTexto() + " Empresa:  " + getUsuario().getNome();

    }

}
