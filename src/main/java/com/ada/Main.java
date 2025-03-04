package com.ada;

import com.ada.Cliente.Cliente;
import com.ada.Cliente.GerenciamentoCliente;
import com.ada.Cliente.ClienteBuilder;
import com.ada.Produto.Produto;
import com.ada.Produto.ProdutoBuilder;
import com.ada.Produto.GerenciamentoProduto;
import com.ada.Utils.ValidacaoUUID;

import java.util.Locale;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
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
            System.out.println("(7) - Criar Pedido");
            System.out.println("(8) - Adicionar Item ao Pedido");
            System.out.println("(9) - Remover Item do Pedido");
            System.out.println("(10) - Alterar Quantidade do Item do Pedido");
            System.out.println("(11) - Finalizar Pedido");
            System.out.println("(12) - Pagar Pedido");
            System.out.println("(13) - Entregar Pedido");


            System.out.print("Digite a operação desejada: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Digite um número válido: ");
                scanner.next();
                System.out.println();
            }

            operacao = scanner.next();
            System.out.println();

            switch (operacao) {
                case "1":
                    System.out.print("Nome do Cliente: ");
                    scanner.nextLine();
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
                    scanner.nextLine();
                    String novoNomeCliente = scanner.nextLine();
                    System.out.print("Novo Documento do Cliente: ");
                    String novoDocumentoCliente = scanner.nextLine();

                    gerenciamentoCliente.atualizarCliente(uuidCliente, novoNomeCliente, novoDocumentoCliente);
                    break;

                case "4":
                    System.out.print("Nome do Produto: ");
                    scanner.nextLine();
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

                    UUID uuidProduto = ValidacaoUUID.validadorUUID();

                    System.out.print("Novo Nome do Produto: ");
                    scanner.nextLine();
                    String novoNomeProduto = scanner.nextLine();
                    System.out.print("Novo Preço do Produto: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.print("Digite um valor de preço válido: ");
                        scanner.next();
                    }
                    double novoPrecoProduto = scanner.nextDouble();
                    scanner.nextLine();

                    gerenciamentoProduto.atualizarProduto(uuidProduto, novoNomeProduto, novoPrecoProduto);
                    break;

                case "7":
                    //falta implementar
                    break;

                case "8":
                    //falta implementar
                    break;

                case "9":
                    //falta implementar
                    break;

                case "10":
                    //falta implementar
                    break;

                case "11":
                    //falta implementar
                    break;

                case "12":
                    //falta implementar
                    break;

                case "13":
                    //falta implementar
                    break;

                default:
                    System.out.println("Digite uma operação válida");
                    break;
            }

            System.out.println("Deseja realizar uma nova operação?");
            do {
                System.out.print("Digite (sim) para continuar ou (não) para encerrar: ");
                respostaUsuario = scanner.next().toLowerCase();
                System.out.println();
            } while (!(respostaUsuario.equals("sim") || (respostaUsuario.equals("não"))));

        } while (respostaUsuario.equals("sim"));
    }
}