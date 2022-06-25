package br.com.dbc.devland.main.entities;

import br.com.dbc.devland.main.interfaces.Impressao;
import br.com.dbc.devland.main.interfaces.Manipulacao;

import java.util.Date;

public class Postagem implements Impressao, Manipulacao<Postagem> {
    private Integer id;
    private String titulo, texto;
    private Date data;
    private User usuario;

    @Override
    public void adicionar(Postagem objeto) {

    }

    @Override
    public void editar(Integer indice, Postagem objeto) {

    }

    @Override
    public void remover(Integer indice) {

    }

    @Override
    public void listar() {

    }

    @Override
    public void imprimir() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

}
