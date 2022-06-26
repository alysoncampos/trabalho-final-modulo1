package br.com.dbc.devland.main.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Postagem {
    private User usuario;
    private String titulo, texto;

    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String date = formatterData.format(now);

    DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
    String time = formatterHora.format(now);

    public Postagem(){
        super();
    }
    public Postagem(User usuario, String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
        this.usuario = usuario;
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

    public String toString() {
        return "Autor: " + getUsuario().getNome() + "\n" +
                "Data: " + date + "Hora: " + time + "\n" +
                "Título: " + getTitulo() + "\n" +
                "Texto: " + getTexto();
    }
}
