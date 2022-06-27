package br.com.dbc.devland.main.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Usuario {

    private String id;

    public Usuario() {

        this.id = idUsuario();
    }

    public String getId() {
        return id;
    }

    public String idUsuario(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    @Override
    public String toString() {
        return "id='" + id;
    }

}
