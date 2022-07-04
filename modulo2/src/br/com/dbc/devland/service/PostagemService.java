package br.com.dbc.devland.service;

import br.com.dbc.devland.exceptions.BancoDeDadosException;
import br.com.dbc.devland.model.Postagem;
import br.com.dbc.devland.repository.PostagemRepository;
public class PostagemService {

    private PostagemRepository postagemRepository;

    public PostagemService() {
        postagemRepository = new PostagemRepository();
    }

    public void adicionar(Postagem postagem) {
        try{
             //Validacoes da postagem
            if(postagem.getTitulo() == null || postagem.getTitulo().length() < 5
                    || postagem.getTitulo().length() > 100){
                throw new Exception("Atributo título é obrigatório e deve ter no mínimo 5 e no máximo 100 caracteres.");
            }
            if(postagem.getDescricao() == null || postagem.getDescricao().length() < 5
                    || postagem.getDescricao().length() > 1000){
                throw new Exception("Atributo descrição é obrigatório e deve ter no mínimo 5 e no máximo 1000 caracteres!");
            }
            Postagem postagemAdicionada = postagemRepository.adicionar(postagem);
            System.out.println("Postagem adicionada com sucesso!" + postagemAdicionada);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    public void remover(Integer id){
        try{
            boolean conseguiuRemover = postagemRepository.remover(id);
            System.out.println("postagem removida? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void editar(Integer id, Postagem postagem){
        try {
            if(postagem.getTitulo() == null || postagem.getTitulo().length() < 5
                    || postagem.getTitulo().length() > 100){
                throw new Exception("Atributo título é obrigatório e deve ter no mínimo 5 e no máximo 100 caracteres.");
            }
            if(postagem.getDescricao() == null || postagem.getDescricao().length() < 5
                    || postagem.getDescricao().length() > 1000){
                throw new Exception("Atributo descrição é obrigatório e deve ter no mínimo 5 e no máximo 1000 caracteres!");
            }
            boolean conseguiuEditar = postagemRepository.editar(id, postagem);
            System.out.println("postagem editada? " + conseguiuEditar + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    public void listar(){
        try {
            postagemRepository.listar().forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void listarPostagemPorPessoa(Integer idPessoa){
        try {
            postagemRepository.listarPostagemPorPessoa(idPessoa).forEach(System.out::println);
        } catch (BancoDeDadosException e){
            e.printStackTrace();
        }
    }

    public void listarPorTipo(Integer tipo){
        try {
            postagemRepository.listarPorTipo(tipo).forEach(System.out::println);
        } catch (BancoDeDadosException e){
            e.printStackTrace();
        }
    }
}