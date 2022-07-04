package br.com.dbc.devland.service;

import br.com.dbc.devland.exceptions.BancoDeDadosException;
import br.com.dbc.devland.model.UsuarioDev;
import br.com.dbc.devland.repository.UsuarioDevRepository;

import java.util.List;

public class UsuarioEmpresaService {

    private UsuarioDevRepository usuarioDevRepository;

    public UsuarioEmpresaService() { usuarioDevRepository = new UsuarioDevRepository(); }

    public void adicionarEmpresa(UsuarioDev usuarioDev) {
        try {
            usuarioDevRepository.adicionar(usuarioDev);
            System.out.println("Cadastro Efetuado com Sucesso");
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
    }

    public void listarEmpresa() {
        try {
            List<UsuarioDev> listar = usuarioDevRepository.listar();
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void removerEmpresa(Integer id) {
        try {
            boolean conseguiuRemover = usuarioDevRepository.remover(id);
            System.out.println("Dev removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void editarEmpresa(Integer id, UsuarioDev dev) {
        try {
            boolean conseguiuEditar = usuarioDevRepository.editar(id, dev);
            System.out.println("Cadastro Atualizado com Sucesso!");
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
}
