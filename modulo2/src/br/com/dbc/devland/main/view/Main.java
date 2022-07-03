package br.com.dbc.devland.main.view;

import br.com.dbc.devland.main.model.Postagem;
import br.com.dbc.devland.main.model.TipoPostagem;
import br.com.dbc.devland.main.service.PostagemService;

public class Main {
    public static void main(String[] args) {

        Postagem postagem = new Postagem();
        PostagemService post = new PostagemService();

//        postagem.setTipoPostagem(TipoPostagem.ofTema(3));
//        postagem.setTitulo("Teste adicionar postagem3");
//        postagem.setDescricao("Teste adicionar postagem 3");
//        post.adicionar(postagem);

        //remover
//        post.remover(5);

        //listar todas
//        post.listar();

//        postagem.setTipoPostagem(TipoPostagem.ofTema(2));
//        postagem.setTitulo("Teste edicao postagem2");
//        postagem.setDescricao("Teste edicao postagem 2 com data");
//        post.editar(4, postagem);

        post.listarPorTipo(2);
    }
}


