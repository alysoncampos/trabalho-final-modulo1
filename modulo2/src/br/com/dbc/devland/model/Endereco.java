package br.com.dbc.devland.model;

import br.com.dbc.devland.repository.Impressao;

public class Endereco implements Impressao {

    private String logradouro;

    private String numero;

    private String cidade;

    private String estado;

    private String pais;

    private String complemento;

    private Integer id_endereco;

    public Integer getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(Integer id_endereco) {
        this.id_endereco = id_endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    private String cep;

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Endereco(){    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Endereço{" +
                "id: " + id_endereco + '\'' +
                "logradouro: '" + logradouro + '\'' +
                "complemento: '" + complemento + '\'' +
                ", numero: " + numero +
                ", cidade: ='" + cidade + '\'' +
                ", estado: ='" + estado + '\'' +
                ", pais: '" + pais + '\'' +
                '}';
    }
}
