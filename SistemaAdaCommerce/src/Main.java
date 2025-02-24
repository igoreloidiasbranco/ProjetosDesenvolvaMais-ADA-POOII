import Cliente.Cliente;
import Cliente.GerenciamentoCliente;
import Cliente.ClienteBuilder;
import Produto.Produto;
import Produto.ProdutoBuilder;
import Produto.GerenciamentoProduto;
import Utils.ValidacaoUUID;

import java.util.Locale;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void   main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        GerenciamentoCliente gerenciamentoCliente = new GerenciamentoCliente();
        GerenciamentoProduto gerenciamentoProduto = new GerenciamentoProduto();
        String operacao;
        String respostaUsuario;

        System.out.println("----------- Ada E-Commerce -------------\n");

        do {
            System.out.println("Operações do Sistema:");
            System.out.println("(1) - Cadastrar Cliente");
            System.out.println("(2) - Listar Clientes");
            System.out.println("(3) - Atualizar Cliente");
            System.out.println("(4) - Cadastrar Produto");
            System.out.println("(5) - Listar Produtos");
            System.out.println("(6) - Atualizar Produto");
            // implementar mais funcionalidades conforme for evoluindo o sistema

            System.out.print("Digite a operação desejada: ");

            while (!scanner.hasNextInt()) {

                System.out.print("Digite um número válido: ");
                scanner.next();
            }

            operacao = scanner.nextLine();

            switch (operacao) {
                case "1":
                    System.out.print("Nome do Cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Documento do Cliente: ");
                    String documentoCliente = scanner.nextLine();

                    Cliente cliente = new ClienteBuilder()
                            .comNome(nomeCliente)
                            .comDocumento(documentoCliente)
                            .construir();

                    gerenciamentoCliente.cadastrarCliente(cliente);
                    break;

                case "2":
                    gerenciamentoCliente.listarClientes();
                    break;

                case "3":
                    System.out.print("Digite o ID do Cliente: ");
                    UUID uuidCliente = ValidacaoUUID.validadorUUID();

                    System.out.print("Novo Nome do Cliente: ");
                    String novoNomeCliente = scanner.nextLine();
                    System.out.print("Novo Documento do Cliente: ");
                    String novoDocumentoCliente = scanner.nextLine();

                    gerenciamentoCliente.atualizarCliente(uuidCliente, novoNomeCliente, novoDocumentoCliente);
                    break;

                case "4":
                    System.out.print("Nome do Produto: ");
                    String nomeProduto = scanner.nextLine();
                    System.out.print("Preço do Produto: ");

                    while (!scanner.hasNextDouble()) {
                        System.out.print("Digite um valor de preço válido: ");
                        scanner.next();
                    }
                    double precoProduto = scanner.nextDouble();
                    scanner.nextLine();

                    Produto produto = new ProdutoBuilder()
                            .comNome(nomeProduto)
                            .comPreco(precoProduto)
                            .construir();

                    gerenciamentoProduto.cadastrarProduto(produto);
                    break;

                case "5":
                    gerenciamentoProduto.listarProdutos();
                    break;

                case "6":
                    System.out.print("Digite o ID do Produto: ");
                    UUID uuidProduto = ValidacaoUUID.validadorUUID();

                    System.out.print("Novo Nome do Produto: ");
                    String novoNomeProduto = scanner.nextLine();
                    System.out.print("Novo Preço do Produto: ");
                    double novoPrecoProduto = scanner.nextDouble();
                    scanner.nextLine();

                    gerenciamentoProduto.atualizarProduto(uuidProduto, novoNomeProduto, novoPrecoProduto);
                    break;

                default:
                    System.out.println("Digite uma operação válida");
                    break;
            }

            System.out.println("Deseja realizar uma nova operação?");
            do {

                System.out.print("Digite (sim) para continuar ou (não) para encerrar: ");


                respostaUsuario = scanner.nextLine().toLowerCase();
                System.out.println();
            } while (!(respostaUsuario.equals("sim") || (respostaUsuario.equals("não"))));


        } while (respostaUsuario.equals("sim"));

    }

}