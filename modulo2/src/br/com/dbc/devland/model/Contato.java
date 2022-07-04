package br.com.dbc.devland.model;

public class Contato {

    private int id_contato;

    private String numero;

    private Usuario usuario;

    private TipoEnum tipoEnum;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoEnum getTipoEnum() {
        return tipoEnum;
    }

    public void setTipoEnum(TipoEnum tipoEnum) {
        this.tipoEnum = tipoEnum;
    }

    public int getId_contato() {
        return id_contato;
    }

    public void setId_contato(int id_contato) {
        this.id_contato = id_contato;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Endereço{" +
                "ID: " + id_contato + '\'' +
                "Número: '" + numero + '\'' +
                ", Tipo: " + tipoEnum +
                '}';
    }
}
