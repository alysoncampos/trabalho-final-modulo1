package br.com.dbc.devland.service;

import br.com.dbc.devland.exceptions.BancoDeDadosException;
import br.com.dbc.devland.model.Endereco;
import br.com.dbc.devland.repository.EnderecoRepository;

public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    public EnderecoService() {
        enderecoRepository = new EnderecoRepository();
    }

    public void adicionarEndereco(Endereco endereco) {
        try {
            Endereco enderecoAdicionado = enderecoRepository.adicionar(endereco);
            //System.out.println("endereco adicinado com sucesso! " + enderecoAdicionado);
            System.out.println("endereco adicinado com sucesso!");
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
    public void remover(Integer id) {
        try {
            boolean conseguiuRemover = enderecoRepository.remover(id);
            System.out.println("removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // atualização de um objeto
    public void editar(Integer id, Endereco endereco) {
        try {
            boolean conseguiuEditar = enderecoRepository.editar(id, endereco);
            System.out.println("editado? " + conseguiuEditar + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // leitura
    public void listar() {
        try {
            enderecoRepository.listar().forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    /*public void listarContatoPorCodigoDaPessoa(Integer idPessoa) {
        try {
            enderecoRepository.listarContatosPorPessoa(idPessoa).forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }*/
}
