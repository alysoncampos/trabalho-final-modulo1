package br.com.dbc.devland.main;

import br.com.dbc.devland.main.entities.ContaDev;
import br.com.dbc.devland.main.entities.ContaEmpresa;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        Integer UserId = 1;
        Integer PostId = 1;

        ContaDev pessoa = new ContaDev();
        ContaDev pessoaNova = new ContaDev();

        ContaEmpresa empresa = new ContaEmpresa();
        //ContaEmpresa empresaNova = new ContaEmpresa();
        int opcao;
        System.out.println("Seja Bem-Vindo à DevLand - O mundo Dev é aqui");
        opcao = 0;
        while (opcao != 9) {
            System.out.println("Digite 1 para criar usuário");
            System.out.println("Digite 2 para listar usuários");
            System.out.println("Digite 3 para editar usuário");
            System.out.println("Digite 4 para excluir usuario");
            System.out.println("Digite 5 para realizar uma postagem");
            System.out.println("Digite 9 para sair");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o tipo da conta: ");
                    System.out.println("1. Dev");
                    System.out.println("2. Empresa");
                    System.out.println(">> ");
                    int tipoConta = scanner.nextInt();
                    scanner.nextLine();
                    switch (tipoConta) {
                        case 1:
                            pessoa = new ContaDev();
                            System.out.println("Olá, Dev! Preencha o cadastro: ");
                            System.out.println("Nome: ");
                            pessoa.setNome(scanner.nextLine());
                            System.out.println("CPF: ");
                            pessoa.setCpf(scanner.nextLine());
                            System.out.println("Email: ");
                            pessoa.setEmail(scanner.nextLine());
                            System.out.println("Stack: ");
                            pessoa.setStack(scanner.nextLine());
                            pessoa.adicionar(pessoa);
                            System.out.println("Cadastro efetuado com sucesso!");
                            break;
                        case 2 :
                            empresa = new ContaEmpresa();
                            System.out.println("Olá, empresa parceira! Preencha o cadastro: ");
                            System.out.println("Nome: ");
                            empresa.setNome(scanner.nextLine());
                            System.out.println("CNPJ");
                            empresa.setCnpj(scanner.nextLine());
                            System.out.println("E-Mail");
                            empresa.setEmail(scanner.nextLine());
                            empresa.adicionar(empresa);
                            System.out.println("Cadastro efetuado com sucesso!");
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                    break;
                case 2:
                    pessoa.listar();
                    break;
                case 3:
                     System.out.println("Qual pessoa voc� deseja editar?");
                     pessoa.listar();
                     int index = scanner.nextInt();
                     scanner.nextLine();
                     System.out.println("Digite seu Nome:");
                     pessoaNova.setNome(scanner.nextLine());
                     System.out.println("Digite sua nova Stack:");
                     pessoaNova.setStack(scanner.nextLine());
                     System.out.println("Digite seu novo E-Mail:");
                     pessoaNova.setEmail(scanner.nextLine());
                     pessoa.editar(index, pessoaNova);
                     break;
                case 4:
                    System.out.println("Qual pessoa voc� deseja excluir?");
                    pessoa.listar();
                    int id = scanner.nextInt();
                    pessoa.remover(id);
                    break;
                case 5:
                      //realizar postagem
                case 9:
                      break;
                default:
                      System.err.println("op��o inv�lida");
                      break;
            }
        }
    }
}


