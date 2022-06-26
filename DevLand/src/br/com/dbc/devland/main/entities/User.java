package br.com.dbc.devland.main.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class User {

    private Integer id;
    private String nome, email, telefone;
    private static List<User> listaDeUser = new ArrayList<>();
    private static List<Postagem> listaDePostagens = new ArrayList<>();

    public User() {
        this.id = getProximoId();
    }

    public User(String nome, String email, String telefone) {
        this.id = getProximoId();
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Integer getId() {
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<User> getListaDeUser() {
        return listaDeUser;
    }

    public List<Postagem> getListaDePostagens() {
        return listaDePostagens;
    }

    public Integer getProximoId(){
        if(getListaDeUser().size() == 0){
            return 1;
        }
        else {
            //pega a ultima da lista de user e adiciona +1 ao Id
            User userId = getListaDeUser().get(getListaDeUser().size() - 1);
            return userId.getId() + 1;
        }
    }

    //CRUD POSTAGEM
    public void adicionarPostagem(Postagem postagem){
        getListaDePostagens().add(postagem);
    }

    public void removerPostagemPorId(Integer index){
        Postagem postagem = getListaDePostagens().get(index);
        if(getId().equals(postagem.getUsuario().getId())){
            getListaDePostagens().remove(index);
        }
        else {
            System.out.println("A postagem não é sua.");
        }
    }

    public void editarPostagem(Integer index, Postagem postagem){
        Postagem postagemProcurada = getListaDePostagens().get(index);
        if(getId().equals(postagem.getUsuario().getId())){
            postagemProcurada.setTitulo(postagem.getTitulo());
            postagemProcurada.setTexto(postagem.getTexto());
        }
        else {
            System.out.println("A postagem não é sua.");
        }
    }

    public void listarTodasPostagens(){
        Integer index = 0;
        System.out.println("Todas as Postagens:" );
        for (Postagem postagem : listaDePostagens){
            System.out.println(postagem);
            index++;
        }
    }

    public void listarMinhasPostagens(){
        System.out.println("Minhas Postagens: ");
        for (Postagem postagem : listaDePostagens){
            if(getNome().equals(postagem.getUsuario().getNome())){
                System.out.println("Id: " + getId() + "\n" + postagem);
            }
        }
    }

}
