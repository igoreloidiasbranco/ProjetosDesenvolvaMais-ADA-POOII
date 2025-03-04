package com.ada.Pedido;

import com.ada.Cliente.Cliente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Pedido {
    private UUID id;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private StatusPedido status;
    private Date dataCriacao;

    public Pedido(Cliente cliente) {
        this.id = UUID.randomUUID();
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.status = StatusPedido.ABERTO;
        this.dataCriacao = new Date();
    }

    public UUID getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
