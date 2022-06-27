package br.com.dbc.devland.main.entities;

import br.com.dbc.devland.main.interfaces.Impressao;

import java.util.Date;

public class Postagem implements Impressao {

    private String titulo;
    private String descricao;
    private Date data;
    private Usuario usuario;

    public Postagem(){

    }

    public Postagem(String titulo, String descricao, Date data, Usuario usuario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.usuario = usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return  "Postagem\n" +
                "Usuário: " + getUsuario().getNome() + "\n" +
                "Título: " + titulo + "\n"+
                "Descricao:" + descricao + "\n" +
                "Data: " + data;
    }

}
