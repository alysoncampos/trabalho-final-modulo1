package br.com.dbc.devland.view;

import br.com.dbc.devland.main.entities.Endereco;
import br.com.dbc.devland.main.entities.UsuarioDev;
import br.com.dbc.devland.main.entities.UsuarioEmpresa;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        String titulo;
        String texto;

        Endereco endereco = new Endereco();
        Endereco endereco2 = new Endereco("Rua Oliveira Fonseca", "254", "Recife", "Pernambuco", "Brasil");
        Endereco endereco3 = new Endereco("Av. Chico Mendes", "189", "São Paulo", "São Paulo", "Brasil");

        UsuarioDev usuarioDev = new UsuarioDev();
        UsuarioDev usuarioDev2 = new UsuarioDev("Alyson Campos", "alyson@gmail.com", endereco2, "Backend");
        UsuarioDev usuarioDev3 = new UsuarioDev("Cesar Bandeira", "cesar@gmail.com", endereco3, "Backend");

        usuarioDev2.adicionar(usuarioDev2);
        usuarioDev3.adicionar(usuarioDev3);

        usuarioDev2.publicar(usuarioDev2, "Eu sou um titulo","Eu sou uma mensagem");
        usuarioDev3.publicar(usuarioDev3, "Eu sou um titulo2","Eu sou uma mensagem2");

        UsuarioEmpresa usuarioEmpresa = new UsuarioEmpresa();
        UsuarioEmpresa empresaNova = new UsuarioEmpresa();
        int opcao;
        System.out.println("Seja Bem-Vindo à DevLand - O mundo Dev é aqui");
        opcao = 0;
        while (opcao != 9) {
            System.out.println("Digite 1 para criar usuário");
            System.out.println("Digite 2 para listar usuários");
            System.out.println("Digite 3 para editar usuário");
            System.out.println("Digite 4 para excluir usuario");
            System.out.println("Digite 5 para realizar uma postagem");
            System.out.println("Digite 6 para excluir uma postagem");
            System.out.println("Digite 7 para listar postagens");
            System.out.println("Digite 9 para sair");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o tipo da conta: ");
                    System.out.println("1. Dev");
                    System.out.println("2. Empresa");
                    System.out.print(">> ");
                    int tipoConta = scanner.nextInt();
                    scanner.nextLine();
                    switch (tipoConta) {
                        case 1:
                            usuarioDev = new UsuarioDev();
                            endereco = new Endereco();
                            System.out.println("Olá, Dev! Preencha o cadastro: ");
                            System.out.println("Nome: ");
                            usuarioDev.setNome(scanner.nextLine());
                            System.out.println("Email: ");
                            usuarioDev.setEmail(scanner.nextLine());
                            System.out.println("Stack: ");
                            usuarioDev.setStack(scanner.nextLine());
                            System.out.println("Rua: ");
                            endereco.setLogradouro(scanner.nextLine());
                            System.out.println("Numero: ");
                            endereco.setNumero(scanner.nextLine());
                            System.out.println("Cidade: ");
                            endereco.setCidade(scanner.nextLine());
                            System.out.println("Estado: ");
                            endereco.setEstado(scanner.nextLine());
                            System.out.println("País: ");
                            endereco.setPais(scanner.nextLine());
                            usuarioDev.setEndereco(endereco);
                            usuarioDev.adicionar(usuarioDev);
                            System.out.println("Cadastro efetuado com sucesso!");
                            break;
                        case 2 :
                            usuarioEmpresa = new UsuarioEmpresa();
                            endereco = new Endereco();
                            System.out.println("Olá, empresa parceira! Preencha o cadastro: ");
                            System.out.print("Nome: ");
                            usuarioEmpresa.setNome(scanner.nextLine());
                            System.out.print("Email: ");
                            usuarioEmpresa.setEmail(scanner.nextLine());
                            System.out.print("Area de Atuação: ");
                            usuarioEmpresa.setAreaDeAtuacao(scanner.nextLine());
                            System.out.print("Rua: ");
                            endereco.setLogradouro(scanner.nextLine());
                            System.out.print("Numero: ");
                            endereco.setNumero(scanner.nextLine());
                            scanner.nextLine();
                            System.out.print("Cidade: ");
                            endereco.setCidade(scanner.nextLine());
                            System.out.print("Estado: ");
                            endereco.setEstado(scanner.nextLine());
                            System.out.print("País: ");
                            endereco.setPais(scanner.nextLine());
                            usuarioEmpresa.setEndereco(endereco);
                            usuarioEmpresa.adicionar(usuarioEmpresa);
                            System.out.println("Cadastro efetuado com sucesso!");
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                    break;
                case 2:
                    usuarioDev.listar();
                    break;
                case 3:
                     System.out.println("Qual pessoa voc� deseja editar?");
                     usuarioDev.listar();
                     int index = scanner.nextInt();
                     scanner.nextLine();
                     UsuarioDev novoDev = new UsuarioDev();
                     System.out.println("Nome: ");
                     usuarioDev.setNome(scanner.nextLine());
                     System.out.println("Email: ");
                     usuarioDev.setEmail(scanner.nextLine());
                     System.out.println("Stack: ");
                     usuarioDev.setStack(scanner.nextLine());
                     System.out.println("Rua: ");
                     endereco.setLogradouro(scanner.nextLine());
                     System.out.println("Numero: ");
                     endereco.setNumero(scanner.nextLine());
                     System.out.println("Cidade: ");
                     endereco.setCidade(scanner.nextLine());
                     System.out.println("Estado: ");
                     endereco.setEstado(scanner.nextLine());
                     System.out.println("País: ");
                     endereco.setPais(scanner.nextLine());
                     usuarioDev.setEndereco(endereco);
                     usuarioDev.editar(index, usuarioDev);
                     System.out.println("Cadastro alterado com sucesso!");
                     break;
                case 4:
                    System.out.println("Qual pessoa voc� deseja excluir?");
                    usuarioDev.listar();
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    usuarioDev.remover(id);
                    break;
                case 5:
                    System.out.println("Post's");
                    System.out.print("Título: ");
                    titulo = scanner.nextLine();
                    System.out.println("Descrição: ");
                    texto = scanner.nextLine();
                    usuarioDev.publicar(usuarioDev, titulo, texto);
                    usuarioDev.listarPostagens();
                    break;
                case 6:
                    System.out.println("Excluir Postagem");
                    usuarioDev.listarPostagens();
                    System.out.print("Informe o ID da postagem: ");
                    int opId = scanner.nextInt();
                    scanner.nextLine();
                    usuarioDev.removerPostagemPorId(opId);
                    break;
                case 7:
                    usuarioDev.listarPostagens();
                    break;
                case 9:
                      break;
                default:
                      System.err.println("op��o inv�lida");
                      break;
            }
        }
    }
}


