package Pedido;

import Produto.Produto;

import java.util.UUID;

public class PedidoService {
    private PedidoRepositorio pedidoRepositorio;

    public PedidoService(PedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
    }

    public void adicionarItem(UUID pedidoId, Produto produto, int quantidade, double precoVenda) {
        Pedido pedido = pedidoRepositorio.buscarPorId(pedidoId);
        if (pedido != null && pedido.getStatus() == StatusPedido.ABERTO) {
            pedido.getItens().add(new ItemPedido(produto, quantidade, precoVenda));
        }
    }

    public void removerItem(UUID pedidoId, UUID produtoId) {
        Pedido pedido = pedidoRepositorio.buscarPorId(pedidoId);
        if (pedido != null && pedido.getStatus() == StatusPedido.ABERTO) {
            pedido.getItens().removeIf(item -> item.getProduto().getId().equals(produtoId));
        }
    }

    public void alterarQuantidade(UUID pedidoId, UUID produtoId, int quantidade) {
        Pedido pedido = pedidoRepositorio.buscarPorId(pedidoId);
        if (pedido != null && pedido.getStatus() == StatusPedido.ABERTO) {
            for (ItemPedido item : pedido.getItens()) {
                if (item.getProduto().getId().equals(produtoId)) {
                    item.setQuantidade(quantidade);
                }
            }
        }
    }

    public void finalizarPedido(UUID pedidoId) {
        Pedido pedido = pedidoRepositorio.buscarPorId(pedidoId);
        if (pedido != null && !pedido.getItens().isEmpty()) {
            pedido.setStatus(StatusPedido.AGUARDANDO_PAGAMENTO);
            System.out.println("Pedido finalizado e aguardando pagamento. Email enviado para " + pedido.getCliente().getNome());
        }
    }

    public void pagarPedido(UUID pedidoId) {
        Pedido pedido = pedidoRepositorio.buscarPorId(pedidoId);
        if (pedido != null && pedido.getStatus() == StatusPedido.AGUARDANDO_PAGAMENTO) {
            pedido.setStatus(StatusPedido.PAGO);
            System.out.println("Pedido pago com sucesso. Email enviado para " + pedido.getCliente().getNome());
        }
    }

    public void entregarPedido(UUID pedidoId) {
        Pedido pedido = pedidoRepositorio.buscarPorId(pedidoId);
        if (pedido != null && pedido.getStatus() == StatusPedido.PAGO) {
            pedido.setStatus(StatusPedido.FINALIZADO);
            System.out.println("Pedido entregue ao cliente. Email enviado para " + pedido.getCliente().getNome());
        }
    }
}
