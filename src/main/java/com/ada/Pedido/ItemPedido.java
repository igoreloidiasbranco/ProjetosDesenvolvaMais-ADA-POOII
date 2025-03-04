package com.ada.Pedido;

import com.ada.Produto.Produto;

public class ItemPedido {

    private Produto produto;
    private int quantidade;
    private double precoVenda;

    public ItemPedido(Produto produto, int quantidade, double precoVenda) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoVenda = precoVenda;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public double getPrecoVenda() {
        return this.precoVenda;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade; }
}

