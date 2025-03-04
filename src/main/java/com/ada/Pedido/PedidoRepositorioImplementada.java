package com.ada.Pedido;

import java.util.*;

public class PedidoRepositorioImplementada implements PedidoRepositorio{

    private Map<UUID, Pedido> pedidos = new HashMap<>();

    @Override
    public void salvar(Pedido pedido) {
        pedidos.put(pedido.getId(), pedido);
    }

    @Override
    public Pedido buscarPorId(UUID id) {
        return pedidos.get(id);
    }

    @Override
    public List<Pedido> listarTodos() {
        return new ArrayList<>(pedidos.values());
    }

}
