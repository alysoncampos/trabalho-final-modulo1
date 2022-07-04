package br.com.dbc.devland.view;

import br.com.dbc.devland.model.*;
import br.com.dbc.devland.service.*;


import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        //Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        System.out.println("""


                __________________________________
                |     DEVLAND - SOCIAL NETWORK   |
                |   __________________________   |
                |   |                        |   |
                |   |           </>          |   |
                |   |                        |   |_____
                |   |________________________|   |     |
                |________________________________|     |
                               ****                    |
                              ******                   |
                 |==============================|    __|__
                 | Q  W  E  R  T  Y  U  I  O  P |    | | |
                 | A  S  D  F  G  H  J  K  L  Ç |    |___|
                 | Z  X  C  V  B  N  M  ,  .  ; |
                 |==============================|
                """);

        UsuarioDevService usuarioDevService = new UsuarioDevService();
        ContatoService contatoService = new ContatoService();
        EnderecoService enderecoService = new EnderecoService();

        String opcao = "";
        while (!opcao.equals("99")) {
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Você deseja realizar um Cadastro ou um Login?" +
                    ConsoleColors.YELLOW_BOLD_BRIGHT + "\n\n1-Cadastro de Desenvolvedor\n2-Cadastro de Empresa\n3-Login" +
                    ConsoleColors.RESET);
            opcao = scanner.nextLine();
            switch (opcao) {
                case "1" -> {
                    UsuarioDev usuarioDev = new UsuarioDev();
                    Contato contatoDev = new Contato();
                    Endereco enderecoDev = new Endereco();


                    System.out.println(ConsoleColors.WHITE_BOLD + "Qual o seu nome?");
                    usuarioDev.setNome(scanner.nextLine());
                    System.out.println(ConsoleColors.WHITE_BOLD + "Qual o seu E-Mail?");
                    usuarioDev.setEmail(scanner.nextLine());
                    System.out.println(ConsoleColors.WHITE_BOLD + "Qual o seu CPF?");
                    usuarioDev.setCpf(scanner.nextLine());
                    System.out.println(ConsoleColors.WHITE_BOLD + "Qual sua Stack?");
                    usuarioDev.setStack(scanner.nextLine());
                    System.out.println(ConsoleColors.WHITE_BOLD + "Qual o seu Telefone?");
                    contatoDev.setNumero(scanner.nextLine());
                    System.out.println("Digite o tipo (1-RESIDENCIAL 2-COMERCIAL): ");
                    int tipo = scanner.nextInt();
                    TipoEnum tipoContato = TipoEnum.ofTipo(tipo);
                    contatoDev.setTipoEnum(tipoContato);
                    scanner.nextLine();
                    System.out.println(ConsoleColors.PURPLE_BOLD + "\nAgora vamos cadastrar o seu Endereço!\n");
                    System.out.println(ConsoleColors.WHITE_BOLD + "Digite o seu Logradouro (rua/av./etc.)");
                    enderecoDev.setLogradouro(scanner.nextLine());
                    System.out.println(ConsoleColors.WHITE_BOLD + "Qual o número?");
                    enderecoDev.setNumero(scanner.nextLine());
                    System.out.println(ConsoleColors.WHITE_BOLD + "Qual o complemento?");
                    enderecoDev.setComplemento(scanner.nextLine());
                    System.out.println(ConsoleColors.WHITE_BOLD + "Qual o seu CEP?");
                    enderecoDev.setCep(scanner.nextLine());
                    System.out.println(ConsoleColors.WHITE_BOLD + "Qual a sua cidade?");
                    enderecoDev.setCidade(scanner.nextLine());
                    System.out.println(ConsoleColors.WHITE_BOLD + "Qual o seu Estado?");
                    enderecoDev.setEstado(scanner.nextLine());
                    System.out.println(ConsoleColors.WHITE_BOLD + "Qual o seu País?");
                    enderecoDev.setPais(scanner.nextLine());
                    System.out.println(ConsoleColors.PURPLE_BOLD + "\nUfa!!!! Estamos Acabando, por fim... Digite uma senha\n");
                    System.out.println(ConsoleColors.WHITE_BOLD + "Senha:");
                    usuarioDev.setSenha(scanner.nextLine());

                    enderecoService.adicionarEndereco(enderecoDev);
                    usuarioDevService.adicionarDev(usuarioDev);
                    contatoService.adicionarContato(contatoDev);
                }
                case "2" -> {
                    UsuarioEmpresa usuarioEmpresa = new UsuarioEmpresa();
                    Contato contatoEmpresa = new Contato();
                    Endereco enderecoEmpresa = new Endereco();


                    System.out.println(ConsoleColors.WHITE_BOLD + "Qual o seu nome?");
                    usuarioEmpresa.setNome(scanner.nextLine());
                    System.out.println(ConsoleColors.WHITE_BOLD + "Qual o seu E-Mail?");
                    usuarioEmpresa.setEmail(scanner.nextLine());
                    System.out.println(ConsoleColors.WHITE_BOLD + "Qual o seu CNPJ?");
                    usuarioEmpresa.setCnpj(scanner.nextLine());
                    System.out.println(ConsoleColors.WHITE_BOLD + "Qual sua Área de Atuação?");
                    usuarioEmpresa.setAreaDeAtuacao(scanner.nextLine());
                    System.out.println(ConsoleColors.WHITE_BOLD + "Qual o seu Telefone?");
                    contatoEmpresa.setNumero(scanner.nextLine());
                    System.out.println("Digite o tipo (1-RESIDENCIAL 2-COMERCIAL): ");
                    int tipo = scanner.nextInt();
                    TipoEnum tipoContato = TipoEnum.ofTipo(tipo);
                    contatoEmpresa.setTipoEnum(tipoContato);
                    scanner.nextLine();
                    System.out.println(ConsoleColors.PURPLE_BOLD + "\nAgora vamos cadastrar o seu Endereço!\n");
                    System.out.println(ConsoleColors.WHITE_BOLD + "Digite o seu Logradouro (rua/av./etc.)");
                    enderecoEmpresa.setLogradouro(scanner.nextLine());
                    System.out.println(ConsoleColors.WHITE_BOLD + "Qual o número?");
                    enderecoEmpresa.setNumero(scanner.nextLine());
                    System.out.println(ConsoleColors.WHITE_BOLD + "Qual o complemento?");
                    enderecoEmpresa.setComplemento(scanner.nextLine());
                    System.out.println(ConsoleColors.WHITE_BOLD + "Qual o seu CEP?");
                    enderecoEmpresa.setCep(scanner.nextLine());
                    System.out.println(ConsoleColors.WHITE_BOLD + "Qual a sua cidade?");
                    enderecoEmpresa.setCidade(scanner.nextLine());
                    System.out.println(ConsoleColors.WHITE_BOLD + "Qual o seu Estado?");
                    enderecoEmpresa.setEstado(scanner.nextLine());
                    System.out.println(ConsoleColors.WHITE_BOLD + "Qual o seu País?");
                    enderecoEmpresa.setPais(scanner.nextLine());
                    System.out.println(ConsoleColors.PURPLE_BOLD + "\nUfa!!!! Estamos Acabando, por fim... Digite uma senha\n");
                    System.out.println(ConsoleColors.WHITE_BOLD + "Senha:");
                    usuarioEmpresa.setSenha(scanner.nextLine());

                    /*enderecoService.adicionarEndereco(enderecoEmpresa);
                    usuarioDevService.adicionarDev(usuarioEmpresa);
                    contatoService.adicionarContato(contatoEmpresa);*/
                }
                case "3" -> {
                    try {
                        System.out.println(ConsoleColors.BLUE_BOLD + "CPF ou CNPJ");
                        String login = scanner.nextLine();

                        System.out.println(ConsoleColors.BLUE_BOLD + "Senha");
                        String senha = scanner.nextLine();

                        UsuarioDev objLoginDev = new UsuarioDev();

                        objLoginDev.setCpf(login);
                        objLoginDev.setSenha(senha);

                        LoginService objLoginService = new LoginService();
                        ResultSet rs = objLoginService.autenticacaoDev(objLoginDev);

                        if (rs.next()) {
                            System.out.println("Logado com sucesso! Seja Bem-Vindo");
                            String opcaoLoginDev = "";
                            while (!opcaoLoginDev.equals("99")) {
                                System.out.println("\nO que você gostaria de fazer hoje?\n\n1-Realizar uma Postagem\n2-Editar Cadastro\n3-Excluir Cadastro\n99-Deslogar");
                                opcaoLoginDev = scanner.nextLine();
                                switch (opcaoLoginDev) {
                                    case "1" -> {
                                        Postagem post = new Postagem();
                                        PostagemService postService = new PostagemService();
                                        String opcaoPostagem = "";
                                        int id;
                                        System.out.println("\nDigite uma opção:\n" +
                                                "\n1-Adicionar Postagem" +
                                                "\n2-Remover Postagem" +
                                                "\n3-Editar Postagem" +
                                                "\n4-Listar Postages" +
                                                "\n5-Listar Por Tipo");
                                        opcaoPostagem = scanner.nextLine();
                                        System.out.println("\nTipo da postagem:" +
                                                "\n1-Vagas" +
                                                "\n2-Programas" +
                                                "\n3-Pensamentos");
                                        post.setTipoPostagem(TipoPostagem.ofTema(scanner.nextInt()));
                                        scanner.nextLine();
                                        System.out.println("Título: ");
                                        post.setTitulo(scanner.nextLine());
                                        System.out.println("Texto: ");
                                        post.setDescricao(scanner.nextLine());
                                        post.setUsuario(usuarioPostagem);
                                        postService.adicionar(post);

                                        System.out.println("Qual postagem você deseja remover? ");
                                        postService.listar();
                                        id = scanner.nextInt();
                                        scanner.nextLine();
                                        postService.remover(id);
                                        System.out.print("Qual postagem você deseja editar? ");
                                        postService.listar();
                                        id = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.println("Digite o tipo (1-Vagas 2-Programas 3-Pensamento):");
                                        post.setTipoPostagem(TipoPostagem.ofTema(scanner.nextInt()));
                                        scanner.nextLine();
                                        System.out.println("Título: ");
                                        post.setTitulo(scanner.nextLine());
                                        System.out.println("Texto: ");
                                        post.setDescricao(scanner.nextLine());
                                        postService.editar(id, post);

                                        postService.listar();


                                        System.out.println("Digite o tipo que deseja ver as postagens\n" +
                                                " [1-Vagas | 2-Programas | 3-Pensamentos]:");
                                        int opcaoTipo = scanner.nextInt();
                                        scanner.nextLine();
                                        postService.listarPorTipo(opcaoTipo);
                                    }
                                    case "2" -> {
                                        String opcaoEditarDev = "";
                                        while (!opcaoEditarDev.equals("99")){
                                            System.out.println("Digite uma opção:\n\n1-Editar Cadastro\n2-Editar Contato\n3-Editar Endereço");
                                            opcaoEditarDev = scanner.nextLine();
                                            switch (opcaoEditarDev) {
                                                case "1" -> {
                                                    usuarioDevService.listarDev();
                                                    System.out.println("Digite seu id: ");
                                                    int index = scanner.nextInt();
                                                    scanner.nextLine();

                                                    UsuarioDev devNovo = new UsuarioDev();
                                                    System.out.println("Digite o novo nome: ");
                                                    devNovo.setNome(scanner.nextLine());

                                                    System.out.println("Digite a Stack");
                                                    devNovo.setStack(scanner.nextLine());

                                                    System.out.println("Digite o E-Mail");
                                                    devNovo.setEmail(scanner.nextLine());

                                                    usuarioDevService.editarDev(index, devNovo);
                                                }
                                                case "2" -> {
                                                    contatoService.listar();
                                                    System.out.println("Digite o seu id para continuar");
                                                    int id = scanner.nextInt();
                                                    scanner.nextLine();

                                                    Contato contato = new Contato();

                                                   /* System.out.println("Digite o codigo da pessoa para adicionar contato: ");
                                                    pessoaService.listarPessoas();
                                                    int index = scanner.nextInt();
                                                    scanner.nextLine();

                                                    Pessoa pessoaContato = new Pessoa();
                                                    pessoaContato.setIdPessoa(index);
                                                    contato.setPessoa(pessoaContato);*/

                                                    System.out.println("Digite o tipo (1-RESIDENCIAL 2-COMERCIAL): ");
                                                    int tipo = scanner.nextInt();
                                                    TipoEnum tipoContato = TipoEnum.ofTipo(tipo);
                                                    contato.setTipoEnum(tipoContato);
                                                    scanner.nextLine();

                                                    System.out.println("Digite o numero: ");
                                                    contato.setNumero(scanner.nextLine());

                                                    contatoService.editar(id, contato);
                                                }
                                                case "3" -> {
                                                    enderecoService.listar();
                                                    System.out.println("Digite o seu id para continuar");
                                                    int id = scanner.nextInt();
                                                    scanner.nextLine();

                                                    Endereco endereco = new Endereco();
                                                   /* System.out.println("Digite o codigo da pessoa para adicionar contato: ");
                                                    pessoaService.listarPessoas();
                                                    int index = scanner.nextInt();
                                                    scanner.nextLine();

                                                    Pessoa pessoaContato = new Pessoa();
                                                    pessoaContato.setIdPessoa(index);
                                                    contato.setPessoa(pessoaContato);*/

                                                    System.out.println("Digite o logradouro: ");
                                                    endereco.setLogradouro(scanner.nextLine());
                                                    System.out.println("Digite o numero: ");
                                                    endereco.setNumero(scanner.nextLine());
                                                    System.out.println("Digite o CEP: ");
                                                    endereco.setCep(scanner.nextLine());
                                                    System.out.println("Digite o complemento: ");
                                                    endereco.setComplemento(scanner.nextLine());
                                                    /*System.out.println("Digite o tipo (1-RESIDENCIAL 2-COMERCIAL): ");
                                                    int tipo = scanner.nextInt();
                                                    TipoEnum tipoEndereco = TipoEnum.ofTipo(tipo);
                                                    endereco.set(tipoEndereco);
                                                    scanner.nextLine();*/
                                                    System.out.println("Digite a cidade: ");
                                                    endereco.setCidade(scanner.nextLine());
                                                    System.out.println("Digite o Estado: ");
                                                    endereco.setEstado(scanner.nextLine());
                                                    System.out.println("Digite o País: ");
                                                    endereco.setPais(scanner.nextLine());

                                                    enderecoService.editar(id, endereco);
                                                }
                                                default -> {
                                                    System.err.println("Opção Inválida, digite novamente");
                                                }
                                            }
                                        }
                                    }
                                    case "3" -> {
                                        usuarioDevService.listarDev();
                                        System.out.println("Digite seu id: ");
                                        int id = scanner.nextInt();
                                        usuarioDevService.removerDev(id);
                                    }
                                }
                            }
                        }else {
                            System.err.println("Usuário ou Senha Inválidos");
                        }
                    } catch (SQLException erro) {
                        System.err.println("Falha na conexão." + erro);
                    }
                }
                default -> {
                    System.err.println("Opção Inválida, por favor digite novamente");
                }
            }
        }
    }
}


