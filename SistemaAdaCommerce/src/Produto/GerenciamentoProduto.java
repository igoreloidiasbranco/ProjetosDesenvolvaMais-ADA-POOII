package Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class GerenciamentoProduto {

    private static List<Produto> listaProdutos = new ArrayList<>();

    public static void cadastrarProduto(Produto produto) {
        listaProdutos.add(produto);
        System.out.println("Produto cadastrado");
    }

    public static void listarProduto() {

        for (Produto produto : listaProdutos) {
            System.out.println("Id do Produto: " + produto.getId());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println();
        }
    }

    public static void atualizarProduto (UUID idProduto) {
        for (Produto produto : listaProdutos) {
            if (produto.getId().equals(idProduto)) {
                listaProdutos.remove(produto);
            }
            else {
                System.out.println("Id não encontrado");
            }
            Produto produtoParaAtualizar = ProdutoBuilder.criarProduto();
            produtoParaAtualizar.setId(idProduto);
            listaProdutos.add(produtoParaAtualizar);
            System.out.println("Produto atualizado");
        }
    }
}
