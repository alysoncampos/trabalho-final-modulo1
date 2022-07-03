package br.com.dbc.devland.model;


import java.sql.Date;

public class Postagem {

    private Integer idPostagem;
    private TipoPostagem tipo; // VAGAS(1) PROGRAMAS(2) PENSAMENTOS(3)
    private String titulo;
    private String descricao;
    private Date data = new java.sql.Date(System.currentTimeMillis());
    //private Usuario usuario;

    public Integer getIdPostagem() {
        return idPostagem;
    }

    public void setIdPostagem(Integer idPostagem) {
        this.idPostagem = idPostagem;
    }

    public TipoPostagem getTipoPostagem() {
        return tipo;
    }

    public void setTipoPostagem(TipoPostagem tipo) {
        this.tipo = tipo;
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

//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }

    @Override
    public String toString() {
        return "Postagem{" +
                "idPostagem=" + idPostagem +
                //", idUsuario=" + (usuario != null ? usuario.getIdUsuario() : null) +
                //", nomeUsuario=" + (usuario != null ? usuario.getNome() : null) +
                ", tipo=" + tipo +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                '}';
    }
}
