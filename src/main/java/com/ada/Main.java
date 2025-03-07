package com.ada;

import com.ada.Cliente.Cliente;
import com.ada.Cliente.GerenciamentoCliente;
import com.ada.Pedido.Pedido;
import com.ada.Pedido.PedidoService;
import com.ada.Produto.Produto;
import com.ada.Produto.GerenciamentoProduto;
import com.ada.Utils.ValidacaoUUID;

import java.util.List;
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
        Pedido pedido = new Pedido(null);
        PedidoService pedidoService = new PedidoService();
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
                    gerenciamentoCliente.listarClientes();
                    UUID idCliente = validacaoUUID.validadorUUID();
                    try {
                        cliente = gerenciamentoCliente.buscarCliente(idCliente);
                        pedido = new Pedido(cliente);
                        System.out.println("Pedido criado com ID: " + pedido.getId() + " para o cliente " + cliente.getNome());
                    } catch (Exception e) {
                        System.out.println("Cliente com ID " + idCliente + " não encontrado.");
                    }

                    pedidoService.pedidoRepositorio().salvar(pedido);

                    break;

                case "8":
                    System.out.println("Digite o ID do pedido que deseja adicionar um produto?");
                    List<Pedido> pedidosAddList = pedidoService.pedidoRepositorio().listarTodos();
                    System.out.println("Lista de pedidos: ");
                    for (Pedido item : pedidosAddList) {
                        System.out.println(item.toString());
                    }

                    UUID idPedido = validacaoUUID.validadorUUID();
                    try {
                        pedido = pedidoService.pedidoRepositorio().buscarPorId(idPedido);
                        System.out.println("Pedido encontrado!");
                    } catch (Exception e) {
                        System.out.println("Pedido com ID " + idPedido + " não encontrado.");
                    }

                    System.out.println("Qual o ID do produto que deseja adicionar ao pedido?");
                    gerenciamentoProduto.listarProdutos();
                    UUID idProduto = validacaoUUID.validadorUUID();

                    try {
                        produto = gerenciamentoProduto.buscarProduto(idProduto);
                    } catch (Exception e) {
                        System.out.println("Produto não encontrado!.");
                        break;
                    }


                    System.out.print("Quantidade que deseja adicionar: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Valor de venda: ");
                    double valorVenda = scanner.nextDouble();

                    pedidoService.adicionarItem(idPedido, produto,quantidade, valorVenda);
                    System.out.println("Produto adicionado");

                    break;

                case "9":
                    System.out.println("Digite o ID do pedido que deseja remover um produto: ");
                    List<Pedido> pedidosRemoveList = pedidoService.pedidoRepositorio().listarTodos();
                    System.out.println("Lista de pedidos: ");
                    for (Pedido item : pedidosRemoveList) {
                        System.out.println(item.toString());
                    }

                    UUID idPedidoRemove = validacaoUUID.validadorUUID();
                    try {
                        pedido = pedidoService.pedidoRepositorio().buscarPorId(idPedidoRemove);
                        System.out.println("Pedido encontrado!");
                    } catch (Exception e) {
                        System.out.println("Pedido com ID " + idPedidoRemove + " não encontrado.");
                    }
                    System.out.println("Digite o ID do produto que deseja remover: ");
                    UUID idProdutoRemove = validacaoUUID.validadorUUID();
                    pedidoService.removerItem(idPedidoRemove, idProdutoRemove);
                    System.out.println("Produto removido");
                    break;

                case "10":
                    System.out.println("Digite o ID do pedido que deseja alterar a quantidade de um produto: ");
                    List<Pedido> pedidosQuantityList = pedidoService.pedidoRepositorio().listarTodos();
                    System.out.println("Lista de pedidos: ");
                    for (Pedido item : pedidosQuantityList) {
                        System.out.println(item.toString());
                    }

                    UUID idPedidoQuantity = validacaoUUID.validadorUUID();
                    try {
                        pedido = pedidoService.pedidoRepositorio().buscarPorId(idPedidoQuantity);
                        System.out.println("Pedido encontrado!");
                    } catch (Exception e) {
                        System.out.println("Pedido com ID " + idPedidoQuantity + " não encontrado.");
                    }

                    System.out.println("Digite o ID do produto que deseja alterar a quantidade: ");
                    UUID idProdutoQuantity = validacaoUUID.validadorUUID();

                    System.out.println("Digite a nova quantidade do produto: ");
                    int newQuantity = scanner.nextInt();
                    pedidoService.alterarQuantidade(idPedidoQuantity, idProdutoQuantity, newQuantity);

                    System.out.println("Produto removido");
                    break;


                case "11":
                    System.out.println("Digite o ID do pedido que deseja finalizar: ");
                    List<Pedido> pedidosFinishList = pedidoService.pedidoRepositorio().listarTodos();
                    System.out.println("Lista de pedidos: ");
                    for (Pedido item : pedidosFinishList) {
                        System.out.println(item.toString());
                    }

                    UUID idPedidoFinish = validacaoUUID.validadorUUID();
                    try {
                        pedido = pedidoService.pedidoRepositorio().buscarPorId(idPedidoFinish);
                        System.out.println("Pedido encontrado!");
                    } catch (Exception e) {
                        System.out.println("Pedido com ID " + idPedidoFinish + " não encontrado.");
                    }

                    pedidoService.finalizarPedido(idPedidoFinish);
                    System.out.println("Pedido finalizado");

                    break;

                case "12":
                    System.out.println("Digite o ID do pedido que deseja pagar: ");
                    List<Pedido> pedidoPayList = pedidoService.pedidoRepositorio().listarTodos();
                    System.out.println("Lista de pedidos: ");
                    for (Pedido item : pedidoPayList) {
                        System.out.println(item.toString());
                    }

                    UUID idPedidoPay = validacaoUUID.validadorUUID();
                    try {
                        pedido = pedidoService.pedidoRepositorio().buscarPorId(idPedidoPay);
                        System.out.println("Pedido encontrado!");
                    } catch (Exception e) {
                        System.out.println("Pedido com ID " + idPedidoPay + " não encontrado.");
                    }

                    pedidoService.pagarPedido(idPedidoPay);
                    System.out.println("Pedido pago");
                    break;

                case "13":
                    System.out.println("Digite o ID do pedido que deseja entregar: ");
                    List<Pedido> pedidoDeliveryList = pedidoService.pedidoRepositorio().listarTodos();
                    System.out.println("Lista de pedidos: ");
                    for (Pedido item : pedidoDeliveryList) {
                        System.out.println(item.toString());
                    }

                    UUID idPedidoDelivery = validacaoUUID.validadorUUID();
                    try {
                        pedido = pedidoService.pedidoRepositorio().buscarPorId(idPedidoDelivery);
                        System.out.println("Pedido encontrado!");
                    } catch (Exception e) {
                        System.out.println("Pedido com ID " + idPedidoDelivery + " não encontrado.");
                    }

                    pedidoService.entregarPedido(idPedidoDelivery);
                    System.out.println("Pedido entregue");
                    break;
                default:
                    System.out.println("Digite uma operação válida");
                    break;
            }
        }
    }
}