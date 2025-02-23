package Produto;

import java.util.Scanner;

public abstract class ProdutoBuilder {

    public static Produto criarProduto() {
        Scanner scanner = new Scanner(System.in);
        double preco;

        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o preço do produto: ");
        while (!scanner.hasNextDouble()) {

            System.out.print("Digite um valor de preço válido: ");
            scanner.next();
        }

        preco = scanner.nextDouble();

        return new Produto(nome, preco);
    }
}
