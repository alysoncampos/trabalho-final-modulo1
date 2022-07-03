package br.com.dbc.devland.service;

import br.com.dbc.devland.exceptions.BancoDeDadosException;
import br.com.dbc.devland.model.Contato;
import br.com.dbc.devland.repository.ContatoRepository;

public class ContatoService {

    private ContatoRepository contatoRepository;

    public ContatoService() {
        contatoRepository = new ContatoRepository();
    }

    public void adicionarContato(Contato contato) {
        try {
            Contato contatoAdicionado = contatoRepository.adicionar(contato);
            //System.out.println("contato adicinado com sucesso! " + contatoAdicionado);
            System.out.println("contato adicinado com sucesso!");
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
    public void remover(Integer id) {
        try {
            boolean conseguiuRemover = contatoRepository.remover(id);
            System.out.println("removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // atualiza��o de um objeto
    public void editar(Integer id, Contato contato) {
        try {
            boolean conseguiuEditar = contatoRepository.editar(id, contato);
            System.out.println("editado? " + conseguiuEditar + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // leitura
    public void listar() {
        try {
            contatoRepository.listar().forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    /*public void listarContatoPorCodigoDaPessoa(Integer idPessoa) {
        try {
            contatoRepository.listarContatosPorPessoa(idPessoa).forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }*/
}
