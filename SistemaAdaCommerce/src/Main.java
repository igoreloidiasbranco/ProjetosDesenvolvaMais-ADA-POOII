import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String operacao;
        String respostaUsuario;
        UUID uuid = null;

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
                    GerenciamentoCliente.cadastrarCliente(cliente);
                    break;

                case "2":
                    GerenciamentoCliente.listarCliente();
                    break;

                case "3":
                    System.out.print("Digite o id do cliente: ");
                    while (uuid == null) {
                        String input = scanner.next();
                        try {
                            uuid = UUID.fromString(input);
                        } catch (IllegalArgumentException e) {
                            System.out.print("Entrada inválida. Digite um UUID válido: ");
                        }
                    }

                    GerenciamentoCliente.atualizarCliente(uuid);
                    break;

                case "4":
                    //implementar cadastro de produto
                    break;

                case "5":
                    //implementar listar produtos
                    break;

                case "6":
                    //implementar atualizar produto
                    break;

                default:
                    System.out.println("Digite uma operação válida");
                    break;
            }


            System.out.println("Deseja realizar uma nova operação?");
            do {

                System.out.print("Digite (S) para continuar ou (N) para sair: ");


                respostaUsuario = scanner.nextLine().toUpperCase();
            } while (!(respostaUsuario.equals("S") || (respostaUsuario.equals("N"))));


        } while (respostaUsuario.equals("S"));

    }

}


