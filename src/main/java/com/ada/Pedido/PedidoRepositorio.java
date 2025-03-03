package com.ada.Pedido;

import java.util.List;
import java.util.UUID;

public interface PedidoRepositorio {

        void salvar(Pedido pedido);
        Pedido buscarPorId(UUID id);
        List<Pedido> listarTodos();
}
