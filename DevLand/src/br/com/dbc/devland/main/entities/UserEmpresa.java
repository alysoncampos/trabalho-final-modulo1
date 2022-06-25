package br.com.dbc.devland.main.entities;

public class UserEmpresa extends User{
    static String tipo = "EMPRESA";
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
