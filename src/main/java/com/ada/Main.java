package com.ada;

import com.ada.Cliente.Cliente;
import com.ada.Cliente.GerenciamentoCliente;
import com.ada.Pedido.Pedido;
import com.ada.Produto.Produto;
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
        ValidacaoUUID validacaoUUID = new ValidacaoUUID();
        String operacao;
        boolean pararOperacao = true;


        System.out.println("----------- Ada E-Commerce -------------\n");

        while (pararOperacao) {
            System.out.println("Operações do Sistema:");
            System.out.println("(0) - Parar Sistema");
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
                case "0":
                    pararOperacao = false;
                    break;
                case "1":
                    System.out.print("Nome do Cliente: ");
                    scanner.nextLine();
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Documento do Cliente: ");
                    String documentoCliente = scanner.nextLine();

                    Cliente cliente = new Cliente(nomeCliente, documentoCliente);

                    gerenciamentoCliente.cadastrarCliente(cliente);
                    break;

                case "2":
                    gerenciamentoCliente.listarClientes();
                    break;

                case "3":
                    System.out.print("Qual o ID do cliente que deseja atualizar? ");

                    UUID uuidCliente = validacaoUUID.validadorUUID();

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

                    Produto produto = new Produto(nomeProduto, precoProduto);

                    gerenciamentoProduto.cadastrarProduto(produto);
                    break;

                case "5":
                    gerenciamentoProduto.listarProdutos();
                    break;

                case "6":

                    System.out.print("Qual o ID do produto que deseja atualizar? ");

                    UUID uuidProduto = validacaoUUID.validadorUUID();

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

                    System.out.println("Digite o ID do cliente que deseja criar o pedido: ");
                    UUID idCliente = validacaoUUID.validadorUUID();
                    try {
                        cliente = gerenciamentoCliente.buscarCliente(idCliente);
                        Pedido pedido = new Pedido(cliente);
                        System.out.println("Pedido criado para o cliente " + cliente.getNome() + " com ID " + pedido.getId());
                    } catch (Exception e) {
                        System.out.println("Cliente com ID " + idCliente + " não encontrado.");
                    }
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
        }
    }
}