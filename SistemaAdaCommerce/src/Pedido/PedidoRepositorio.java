package Pedido;


import java.util.List;
import java.util.UUID;

interface PedidoRepositorio {
        void salvar(Pedido pedido);
        Pedido buscarPorId(UUID id);
        List<Pedido> listarTodos();
}
