package br.com.dbc.devland.main.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private Integer id;
    private String nome, email, telefone;
    private  static List<User> listaDeUser = new ArrayList<>();

    public User(Integer id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<User> getListaDeUser() {
        return listaDeUser;
    }

}
