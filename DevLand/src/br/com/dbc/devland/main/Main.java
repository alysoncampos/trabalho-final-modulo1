package br.com.dbc.devland.main;

import br.com.dbc.devland.main.entities.UserDev;
import br.com.dbc.devland.main.entities.UserEmpresa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserDev pessoa = new UserDev();
        UserDev pessoaNova = new UserDev();

        UserEmpresa empresa = new UserEmpresa();
        UserEmpresa empresaNova = new UserEmpresa();
        int opcao;
        do {
            System.out.println("Seja Bem-Vindo \n" +
                    "Deseja a area de Dev's ou de Empresas?" + "\n" + "Digite 1 para Dev / 2 - para Empregador / 10 - para fechar o sistema");
            int opcao2 = scanner.nextInt();
            opcao = opcao2;
            if (opcao == 1) {
                opcao = 0;
                while (opcao != 9) {
                    System.out.println("Digite 1 para criar pessoa");
                    System.out.println("Digite 2 para listar pessoas");
                    System.out.println("Digite 3 para editar uma pessoa");
                    System.out.println("Digite 4 para imprimir CV");
                    System.out.println("Digite 5 para editar CV");
                    System.out.println("Digite 6 para excluir pessoas");
                    System.out.println("Digite 7 para realizar uma postagem");
                    System.out.println("Digite 9 para sair");
                    opcao = scanner.nextInt();
                    scanner.nextLine();
                    switch (opcao) {
                        case 1:
                            pessoa = new UserDev();
                            System.out.println("Digite seu nome");
                            pessoa.setNome(scanner.nextLine());
                            System.out.println("Digite o CPF");
                            pessoa.setCpf(scanner.nextLine());
                            System.out.println("Digite o email");
                            pessoa.setEmail(scanner.nextLine());
                            System.out.println("Digite o seu telefone");
                            pessoa.setTelefone(scanner.nextLine());
                            System.out.println("Digite sua Stack ");
                            pessoa.setStack(scanner.nextLine());
                            System.out.println("Digite seu CV ");
                            pessoa.setCv(scanner.nextLine());
                            pessoa.adicionar(pessoa);
                            break;
                        case 2:
                            pessoa.listar();
                            break;
                        case 3:
                            System.out.println("Qual pessoa você deseja editar?");
                            pessoa.listar();
                            int index = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Digite seu Nome:");
                            pessoaNova.setNome(scanner.nextLine());
                            System.out.println("Digite sua nova Stack:");
                            pessoaNova.setStack(scanner.nextLine());
                            System.out.println("Digite seu novo E-Mail:");
                            pessoaNova.setEmail(scanner.nextLine());
                            System.out.println("Digite seu novo telefone:");
                            pessoaNova.setTelefone(scanner.nextLine());
                            pessoa.editar(index, pessoaNova);
                            break;
                        case 4:
                            System.out.println("Qual CV você deseja imprimir?");
                            pessoa.listar();
                            int index3 = scanner.nextInt();
                            scanner.nextLine();
                            pessoa.imprimir(index3, pessoaNova);
                            break;
                        case 5:
                            System.out.println("Qual CV você deseja editar?");
                            pessoa.listar();
                            int index2 = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Digite seu novo :");
                            pessoaNova.setCv(scanner.nextLine());
                            pessoa.editarCV(index2, pessoaNova);
                            break;
                        case 6:
                            System.out.println("Qual pessoa você deseja excluir?");
                            pessoa.listar();
                            int id = scanner.nextInt();
                            pessoa.remover(id);
                            break;
                        case 7:
                            /*System.out.println("Qual pessoa você deseja excluir?");
                            pessoa.listar();
                            int id = scanner.nextInt();
                            pessoa.remover(id);*/
                            break;
                        case 9:
                            break;
                        default:
                            System.err.println("opção inválida");
                            break;
                    }
                }
            } else if (opcao2 == 2) {
                opcao2 = 0;
                while (opcao2 != 9) {
                    System.out.println("Digite 1 para cadastrar uma Empresa");
                    System.out.println("Digite 2 para listar Empresas");
                    System.out.println("Digite 3 para editar uma Empresa");
                    System.out.println("Digite 4 para excluir uma Empresa");
                    System.out.println("Digite 5 para realizar uma postagem");
                    System.out.println("Digite 9 para sair");
                    opcao2 = scanner.nextInt();
                    scanner.nextLine();
                    switch (opcao2) {
                        case 1:
                            System.out.println("Digite seu nome");
                            empresa.setNome(scanner.nextLine());
                            System.out.println("Digite o CNPJ");
                            empresa.setCnpj(scanner.nextLine());
                            System.out.println("Digite o email");
                            empresa.setEmail(scanner.nextLine());
                            System.out.println("Digite o seu telefone");
                            empresa.setTelefone(scanner.nextLine());
                            empresa.adicionar(empresa);
                            break;
                        case 2:
                            empresa.listar();
                            break;
                        case 3:
                            System.out.println("Qual pessoa você deseja editar?");
                            empresa.listar();
                            int index = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Digite seu Nome:");
                            empresaNova.setNome(scanner.nextLine());
                            System.out.println("Digite seu novo E-Mail:");
                            empresaNova.setEmail(scanner.nextLine());
                            System.out.println("Digite seu novo telefone:");
                            empresaNova.setTelefone(scanner.nextLine());
                            empresa.editar(index, empresaNova);
                            break;
                        case 4:
                            System.out.println("Qual Empresa você deseja excluir?");
                            empresa.listar();
                            int id = scanner.nextInt();
                            empresa.remover(id);
                            break;
                        case 5:
                            /*System.out.println("Qual pessoa você deseja excluir?");
                            pessoa.listar();
                            int id = scanner.nextInt();
                            pessoa.remover(id);*/
                            break;
                        case 9:
                            break;
                        default:
                            System.err.println("opção inválida");
                            break;
                    }
                }
            }
        } while (opcao != 10);
    }
}

