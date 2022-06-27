package br.com.dbc.devland.main.entities;

import java.util.ArrayList;
import java.util.Date;
public abstract class Conta {
    private Usuario usuario;
<<<<<<< HEAD
    private String nome;
=======

    private String nome;

>>>>>>> ec8aec511da4601c3e8cb3e8d1d509cb1c681e19
    private String email;
    private static ArrayList<Conta> listaContas = new ArrayList<>();
    private static ArrayList<Postagem> listaPostagens = new ArrayList<>();

    public Conta(Usuario usuario) {
        this.usuario = usuario;
    }

    public Conta() {}

    public Usuario getUsuario() {
        return usuario;
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

    public static ArrayList<Conta> getListaContas() {
        return listaContas;
    }

    public ArrayList<Postagem> getListaPostagens() {
        return listaPostagens;
    }

    //CRUD POSTAGEM

    public void publicar(Usuario usuario, String titulo, String mensagem) {
        Postagem postagem = new Postagem();
        postagem.setData(new Date());
        postagem.setTitulo(titulo);
        postagem.setDescricao(mensagem);
        postagem.setUsuario(usuario);

        this.getListaPostagens().add(postagem);
    }

    public void removerPostagemPorId(Integer indice){
        Postagem postagem = getListaPostagens().get(indice);
        if(getUsuario().getId().equals(postagem.getUsuario().getId())){
            getListaPostagens().remove(indice);
        }
        else {
            System.out.println("Erro! Você não pode deleter postagens dos coleguinhas!");
        }
    }

    public void editarPostagem(Integer indice, Postagem postagem){
        Postagem postagemProcurada = getListaPostagens().get(indice);
        if(getUsuario().getId().equals(postagem.getUsuario().getId())){
            postagemProcurada.setTitulo(postagem.getTitulo());
            postagemProcurada.setDescricao(postagem.getDescricao());
        }
    }

    public void listarPostagens(){
        Integer indice = 0;
        System.out.println("Todas as Postagens:" );
        for (Postagem postagem : listaPostagens){
            System.out.println("Id="+ indice + " " + postagem);
            indice++;
        }
    }

    public void listarMinhasPostagens() {
        System.out.println("Minhas Postagens: ");
        for (Postagem postagem : listaPostagens) {
            if (getUsuario().getId().equals(postagem.getUsuario().getId())) {
                System.out.println(postagem);
            }
        }
    }
}
