package br.com.dbc.devland.main.entities;

public class UserDev extends User {
    static String tipo = "DEV";
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
