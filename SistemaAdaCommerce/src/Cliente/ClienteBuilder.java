package Cliente;

import java.util.Scanner;

public abstract class ClienteBuilder {

    public static Cliente criarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o documento do cliente: ");
        String documento = scanner.nextLine();
        return new Cliente(nome, documento);
    }

}
