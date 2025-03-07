package com.ada.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class GerenciamentoProduto {

    private final List<Produto> listaProdutos = new ArrayList<>();

    public void cadastrarProduto(Produto produto) {
        listaProdutos.add(produto);
        System.out.println("Produto cadastrado com sucesso.");
    }

    public void listarProdutos() {

        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        System.out.println("Lista de Produtos:");
        for (Produto produto : listaProdutos) {
            System.out.println("ID: " + produto.getId());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("------------------------");
        }
    }


    public Produto buscarProduto(UUID idProduto) {
        Optional<Produto> produtoOpt = listaProdutos.stream()
                .filter(produto -> produto.getId().equals(idProduto))
                .findFirst();

        if (produtoOpt.isPresent()) {
            Produto produto = produtoOpt.get();
            System.out.println("Produto com Id " + idProduto + " encontrado.");
            return produto;
        } else {
            return null;
        }
    }

    public void atualizarProduto(UUID idProduto, String novoNome, double novoPreco) {
        Optional<Produto> produtoOpt = listaProdutos.stream()
                .filter(produto -> produto.getId().equals(idProduto))
                .findFirst();

        if (produtoOpt.isPresent()) {
            Produto produto = produtoOpt.get();
            produto.atualizarDados(novoNome, novoPreco);
            System.out.println("Produto atualizado com sucesso.");
        } else {
            System.out.println("Produto com ID " + idProduto + " não encontrado.");
        }
    }
}
