import Cliente.Cliente;
import Cliente.GerenciamentoCliente;
import Cliente.ClienteBuilder;
import Produto.Produto;
import Produto.ProdutoBuilder;
import Produto.GerenciamentoProduto;
import Utils.ValidacaoUUID;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String operacao;
        String respostaUsuario;
        UUID uuid;
        GerenciamentoCliente gerenciamentoCliente = new GerenciamentoCliente();

        System.out.println("----------- Ada E-Commerce -------------");
        System.out.println();
        do {
            System.out.printf(
                    "Operações do Sistema: \n" +
                            "(1) - Cadastrar Cliente \n" +
                            "(2) - Listar Clientes \n" +
                            "(3) - Atualizar Cliente \n" +
                            "(4) - Cadastrar Produto \n" +
                            "(5) - Listar Produtos \n" +
                            "(6) - Atualizar Produto \n" +
                            // implementar mais funcionalidades conforme for evoluindo o sistema
                            "Digite a operação que deseja realizar: ");

            while (!scanner.hasNextInt()) {

                System.out.print("Digite um número válido: ");
                scanner.next();
            }

            operacao = scanner.nextLine();

            switch (operacao) {
                case "1":
                    Cliente cliente = ClienteBuilder.criarCliente();
                    gerenciamentoCliente.cadastrarCliente(cliente);
                    break;

                case "2":
                    gerenciamentoCliente.listarCliente();
                    break;

                case "3":
                    uuid = ValidacaoUUID.validadorUUID();
                    gerenciamentoCliente.atualizarCliente(uuid);
                    break;

                case "4":
                    Produto produto = ProdutoBuilder.criarProduto();
                    GerenciamentoProduto.cadastrarProduto(produto);
                    break;

                case "5":
                    GerenciamentoProduto.listarProduto();
                    break;

                case "6":
                    uuid = ValidacaoUUID.validadorUUID();
                    GerenciamentoProduto.atualizarProduto(uuid);
                    break;

                default:
                    System.out.println("Digite uma operação válida");
                    break;
            }


            System.out.println("Deseja realizar uma nova operação?");
            do {

                System.out.print("Digite (sim) para continuar ou (não) para encerrar: ");


                respostaUsuario = scanner.nextLine().toLowerCase();
            } while (!(respostaUsuario.equals("sim") || (respostaUsuario.equals("não"))));


        } while (respostaUsuario.equals("sim"));

    }

}


