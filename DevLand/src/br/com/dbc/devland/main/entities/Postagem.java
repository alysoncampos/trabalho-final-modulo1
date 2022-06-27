package br.com.dbc.devland.main.entities;

import java.util.Date;

public class Postagem {

    private Integer id;
    private String titulo;
    private String descricao;
    private Date data;
    private Usuario usuario;

    public Postagem(){
        this.id = id;
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
    public String toString() {
        return "Autor: " + getUsuario().getNome() + "\n" +
                "Data: " + data + "\n" +
                "Título: " + getTitulo() + "\n" +
                "Texto: " + getDescricao();
    }
}
