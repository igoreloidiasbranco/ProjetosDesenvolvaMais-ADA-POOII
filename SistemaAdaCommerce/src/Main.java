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

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        GerenciamentoCliente gerenciamentoCliente = new GerenciamentoCliente();
        GerenciamentoProduto gerenciamentoProduto = new GerenciamentoProduto();
        String sistemaPrincipal;
        String respostaUsuario;

        System.out.println("----------- Ada E-Commerce -------------\n");

        do {
            System.out.println("Operações do Sistema:");
            System.out.println("(1) - Gerenciar Cliente ");
            System.out.println("(2) - Gerenciar Produto");


            System.out.println("(3) - Gerenciar Vendas");

            System.out.print("Digite a operação desejada: ");
            sistemaPrincipal = scanner.nextLine();

            while (sistemaPrincipal != 1 || 2 || 3) {
                System.out.print("Digite um número válido: ");
                scanner.next();
            }

            switch (sistemaPrincipal) {
                case "1":
                    System.out.println("(1) - Cadastrar Cliente");
                    System.out.println("(2) - Listar Clientes");
                    System.out.println("(3) - Atualizar Cliente");
                    System.out.print("Digite a operação desejada: ");
                    String sistemaCliente = scanner.nextLine();
                    while (sistemaCliente != 1 || 2 || 3) {
                        System.out.print("Digite um número válido: ");
                        scanner.next();
                    }
                    switch (sistemaCliente) {
                        case "1":
                            System.out.print("Nome do Cliente: ");
                            String nomeCliente = scanner.nextLine();
                            System.out.print("Documento do Cliente: ");
                            String documentoCliente = scanner.nextLine();

                            Cliente cliente = new ClienteBuilder().comNome(nomeCliente).comDocumento(documentoCliente).construir();

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
                    }

                case "2":
                    System.out.println("(1) - Cadastrar Produto");
                    System.out.println("(2) - Listar Produtos");
                    System.out.println("(3) - Atualizar Produto");
                    String sistemaProduto = scanner.nextLine();
                    while (sistemaProduto < 1 || sistemaProduto > 3 ) {
                        System.out.print("Digite um número válido: ");
                        scanner.next();
                    }
                    switch (sistemaProduto) {
                        case "1":
                            System.out.print("Nome do Produto: ");
                            String nomeProduto = scanner.nextLine();
                            System.out.print("Preço do Produto: ");
                            while (!scanner.hasNextDouble()) {
                                System.out.print("Digite um valor de preço válido: ");
                                scanner.next();
                            }
                            double precoProduto = scanner.nextDouble();
                            scanner.nextLine();
                            Produto produto = new ProdutoBuilder().comNome(nomeProduto).comPreco(precoProduto).construir();

                            gerenciamentoProduto.cadastrarProduto(produto);
                            break;
                        case "2":
                            gerenciamentoProduto.listarProdutos();
                            break;
                        case "3":
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

                case "3":
                    System.out.println("(1) - Criar Nova Venda");
                    //Criar uma nova venda significa escolher um cliente para uma venda!
                    System.out.println("(2) - Listar Vendas");
                    System.out.println("(3) - Gerenciar Vendas");
                    String sistemaVenda = scanner.nextLine();
                    while (sistemaVenda < 1 || sistemaVenda > 3 ) {
                        System.out.print("Digite um número válido: ");
                        scanner.next();
                    }
                    switch (sistemaVenda) {
                        case '1':
                            System.out.print("Qual o Id do cliente que será efetuada a venda: ");
                        case '2':
                            //TODO Listar todas as vendas
                            break
                        case '3':
                            System.out.println("Qual o Id da venda que gostaria de gerenciar: ");
                           //TODO Verificar ID de venda para ver se existe
                            String vendaID = scanner.nextLine();

                            System.out.println("Operações de venda:")
                            System.out.println("(1) - Adicionar Produto");
                            //com quantidade e preço
                            System.out.println("(2) - Remover Produto");
                            System.out.println("(3) - Alterar quantidade do produto");
                            System.out.println("(4) - Realizar Pagamento");
                            System.out.println("(5) - Realizar Entrega");
                            String sistemaOperacaoVenda = scanner.nextLine();
                            while (sistemaOperacaoVenda < 1 || sistemaOperacaoVenda > 5) {
                                System.out.print("Digite um número válido: ");
                                scanner.next();
                            }
                            switch (sistemaOperacaoVenda){
                                case '1':
                                    //adicionar com quantidade e preço
                                case '2':
                                    //remover
                                case '3':
                                    //alterar quantidade
                                case '4':
                                    //mudar status de pedido
                                case '5':
                                    //mudar status de pedido
                                default:
                                    System.out.println("Digite uma operação válida");
                                    break;
                            }
                        default:
                            System.out.println("Digite uma operação válida");
                            break;
                    }

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