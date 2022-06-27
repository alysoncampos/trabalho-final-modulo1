package br.com.dbc.devland.main.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Usuario {

    private String id;
    private String nome;
    private String email;

    public Usuario(String nome, String email) {
        this.id = idUsuario();
        this.nome = nome;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String idUsuario(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    @Override
    public String toString() {
        return "id='" + id +", "+ nome + '\'' +
                ", email='" + email;
    }
}
