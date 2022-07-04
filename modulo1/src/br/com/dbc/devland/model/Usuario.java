package br.com.dbc.devland.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public abstract class Usuario {

    private String id;

    private String nome;

    private String email;

    private Endereco endereco;

    private static ArrayList<Usuario> listaDeUsuarios = new ArrayList<>();
    private static ArrayList<Postagem> listaDePostagens = new ArrayList<>();

    public Usuario() {

    }

    public Usuario(String nome, String email, Endereco endereco) {
        this.id = idUsuario();
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

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

//    public void listarMinhasPostagens() {
//        System.out.println("Minhas Postagens: ");
//        for (Postagem postagem : listaDePostagens) {
//            if (getId().equals(postagem.getUsuario().getId())) {
//                System.out.println(postagem);
//            }
//        }
//    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
