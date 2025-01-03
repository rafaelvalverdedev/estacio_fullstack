package cadastropoo;

import model.*;

import java.util.Scanner;

public class CadastroPOO {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
            PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();
            
            int opcao = -1;
            
            while (opcao != 0) {
                System.out.println("==============================");
                System.out.println("1. Incluir Pessoa");
                System.out.println("2. Alterar Pessoa");
                System.out.println("3. Excluir Pessoa");
                System.out.println("4. Buscar pelo ID");
                System.out.println("5. Exibir todos");
                System.out.println("6. Persistir Dados");
                System.out.println("7. Recuperar Dados");
                System.out.println("0. Finalizar Programa");
                System.out.println("==============================");
                System.out.print("Escolha uma opcao: ");
                
                try {
                    opcao = Integer.parseInt(scanner.nextLine());
                    
                    switch (opcao) {
                        case 1: // Incluir
                            incluir(scanner, repoFisica, repoJuridica);
                            break;
                            
                        case 2: // Alterar
                            alterar(scanner, repoFisica, repoJuridica);
                            break;
                            
                        case 3: // Excluir
                            excluir(scanner, repoFisica, repoJuridica);
                            break;
                            
                        case 4: // Exibir pelo ID
                            exibirPorId(scanner, repoFisica, repoJuridica);
                            break;
                            
                        case 5: // Exibir todos
                            exibirTodos(scanner, repoFisica, repoJuridica);
                            break;
                            
                        case 6: // Salvar dados
                            salvar(scanner, repoFisica, repoJuridica);
                            break;
                            
                        case 7: // Recuperar dados
                            recuperar(scanner, repoFisica, repoJuridica);
                            break;
                            
                        case 0: // Sair
                            System.out.println("Encerrando o sistema...");
                            break;
                            
                        default:
                            System.out.println("Opcao invalida! Tente novamente.");
                    }
                    
                } catch (NumberFormatException e) {
                    System.out.println("Entrada invalida. Por favor, insira um numero.");
                }
            }
        }
    }

    private static void incluir(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("F - Pessoa Fisica | J - Pessoa Juridica:  ");
        String tipo = scanner.nextLine().toUpperCase();

        if (tipo.equals("F")) {
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Idade: ");
            int idade = Integer.parseInt(scanner.nextLine());

            repoFisica.inserir(new PessoaFisica(id, nome, cpf, idade));
            System.out.println("Pessoa Fisica incluida com sucesso!");

        } else if (tipo.equals("J")) {
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CNPJ: ");
            String cnpj = scanner.nextLine();

            repoJuridica.inserir(new PessoaJuridica(id, nome, cnpj));
            System.out.println("Pessoa Juridica incluida com sucesso!");

        } else {
            System.out.println("Tipo invalido!");
        }
    }

    private static void alterar(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("F - Pessoa Fisica | J - Pessoa Juridica: ");
        String tipo = scanner.nextLine().toUpperCase();

        if (tipo.equals("F")) {
            System.out.print("ID da pessoa a ser alterada: ");
            int id = Integer.parseInt(scanner.nextLine());
            PessoaFisica pessoa = repoFisica.obter(id);

            if (pessoa != null) {
                System.out.println("Dados atuais: " + pessoa);
                System.out.print("Novo Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Novo CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Nova Idade: ");
                int idade = Integer.parseInt(scanner.nextLine());

                repoFisica.alterar(new PessoaFisica(id, nome, cpf, idade));
                System.out.println("Pessoa Fisica alterada com sucesso!");
            } else {
                System.out.println("Pessoa nao encontrada.");
            }

        } else if (tipo.equals("J")) {
            System.out.print("ID da pessoa a ser alterada: ");
            int id = Integer.parseInt(scanner.nextLine());
            PessoaJuridica pessoa = repoJuridica.obter(id);

            if (pessoa != null) {
                System.out.println("Dados atuais: " + pessoa);
                System.out.print("Novo Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Novo CNPJ: ");
                String cnpj = scanner.nextLine();

                repoJuridica.alterar(new PessoaJuridica(id, nome, cnpj));
                System.out.println("Pessoa Juridica alterada com sucesso!");
            } else {
                System.out.println("Pessoa nao encontrada.");
            }
        } else {
            System.out.println("Tipo invalido!");
        }
    }

    private static void excluir(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("F - Pessoa Fisica | J - Pessoa Juridica: ");
        String tipo = scanner.nextLine().toUpperCase();

        if (tipo.equals("F")) {
            System.out.print("ID da pessoa a ser excluida: ");
            int id = Integer.parseInt(scanner.nextLine());
            repoFisica.excluir(id);
            System.out.println("Pessoa Fisica excluida com sucesso!");

        } else if (tipo.equals("J")) {
            System.out.print("ID da pessoa a ser excluida: ");
            int id = Integer.parseInt(scanner.nextLine());
            repoJuridica.excluir(id);
            System.out.println("Pessoa Juridica excluída com sucesso!");

        } else {
            System.out.println("Tipo invalido!");
        }
    }

    private static void exibirPorId(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("F - Pessoa Fisica | J - Pessoa Juridica: ");
        String tipo = scanner.nextLine().toUpperCase();

        if (tipo.equals("F")) {
            System.out.print("ID da pessoa: ");
            int id = Integer.parseInt(scanner.nextLine());
            PessoaFisica pessoa = repoFisica.obter(id);

            if (pessoa != null) {
                System.out.println("Dados: " + pessoa);
            } else {
                System.out.println("Pessoa nao encontrada.");
            }

        } else if (tipo.equals("J")) {
            System.out.print("ID da pessoa: ");
            int id = Integer.parseInt(scanner.nextLine());
            PessoaJuridica pessoa = repoJuridica.obter(id);

            if (pessoa != null) {
                System.out.println("Dados: " + pessoa);
            } else {
                System.out.println("Pessoa nao encontrada.");
            }
        } else {
            System.out.println("Tipo invalido!");
        }
    }

    private static void exibirTodos(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("F - Pessoa Fisica | J - Pessoa Juridica: ");
        String tipo = scanner.nextLine().toUpperCase();

        if (tipo.equals("F")) {
            repoFisica.obterTodos().forEach(System.out::println);

        } else if (tipo.equals("J")) {
            repoJuridica.obterTodos().forEach(System.out::println);

        } else {
            System.out.println("Tipo invalido!");
        }
    }

    private static void salvar(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("Digite o prefixo do arquivo: ");
        String prefixo = scanner.nextLine();

        try {
            repoFisica.persistir(prefixo + ".fisica.bin");
            repoJuridica.persistir(prefixo + ".juridica.bin");
            System.out.println("Dados salvos com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    private static void recuperar(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("Digite o prefixo do arquivo: ");
        String prefixo = scanner.nextLine();

        try {
            repoFisica.recuperar(prefixo + ".fisica.bin");
            repoJuridica.recuperar(prefixo + ".juridica.bin");
            System.out.println("Dados recuperados com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao recuperar os dados: " + e.getMessage());
        }
    }
}
