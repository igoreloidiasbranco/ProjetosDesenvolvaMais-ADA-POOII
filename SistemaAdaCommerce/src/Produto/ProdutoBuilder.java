package Produto;

import java.util.UUID;

public class ProdutoBuilder {

    private UUID id;
    private String nome;
    private double preco;

    public ProdutoBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ProdutoBuilder comPreco(double preco) {
        this.preco = preco;
        return this;
    }

    public Produto construir() {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }

        return new Produto(nome, preco);
    }
}
