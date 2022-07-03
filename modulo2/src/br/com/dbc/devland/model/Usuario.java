package br.com.dbc.devland.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public abstract class Usuario {

    private String nome, email, tipo, senha;
    private Integer id_usuario;

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private static ArrayList<Usuario> listaDeUsuarios = new ArrayList<>();
    private static ArrayList<Postagem> listaDePostagens = new ArrayList<>();

    public static ArrayList<Usuario> getListaDeUsuarios() {
        return listaDeUsuarios;
    }

    public static ArrayList<Postagem> getListaDePostagens() {
        return listaDePostagens;
    }

    public String idUsuario(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    //CRUD POSTAGEM

    public void publicar(Usuario usuario, String titulo, String mensagem) {
        Postagem postagem = new Postagem();
        postagem.setData(new Date());
        postagem.setTitulo(titulo);
        postagem.setDescricao(mensagem);
        postagem.setUsuario(usuario);

        this.getListaDePostagens().add(postagem);
    }

    public String toString() {
        return "{" +
                "Seu id=" + id_usuario +
                '}';
    }

    public void removerPostagemPorId(Integer indice){
        getListaDePostagens().remove(indice.intValue());
    }

    public void editarPostagem(Integer indice, Postagem postagem){
        Postagem postagemProcurada = getListaDePostagens().get(indice);
        postagemProcurada.setTitulo(postagem.getTitulo());
        postagemProcurada.setDescricao(postagem.getDescricao());
    }

    public void listarPostagens(){
        Integer indice = 0;
        System.out.println("Todas as Postagens:" );
        for (Postagem postagem : listaDePostagens){
            System.out.println("------------------------------");
            System.out.println("Id: "+ indice);
            System.out.println(postagem);
            System.out.println("------------------------------");
            indice++;
        }
    }
}
