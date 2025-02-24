//package Pedido;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.UUID;
//
//import Notificação.Notificacao;
//import Produto.Produto;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.UUID;
//
//    public class Pedido {
//        private UUID id;
//        private List<ItemPedido> itens;
//        private LocalDate dataCriacao;
//        private StatusPedido status;
//        private Notificacao notificacao;
//
//        public Pedido() {
//            this.id = UUID.randomUUID();
//            this.itens = new ArrayList<>();
//            this.dataCriacao = LocalDate.now();
//            this.status = StatusPedido.ABERTO;
//            this.notificacao = new Notificacao();
//        }
//
//        public void adicionarItem(Produto produto, int quantidade) {
//            if (status == StatusPedido.ABERTO) {
//                itens.add(new ItemPedido(produto, quantidade));
//            } else {
//                System.out.println("Não é possível adicionar itens. O pedido não está mais aberto.");
//            }
//        }
//
//        public void removerItem(Produto produto) {
//            if (status == StatusPedido.ABERTO) {
//                Iterator<ItemPedido> iterator = itens.iterator();
//                while (iterator.hasNext()) {
//                    ItemPedido item = iterator.next();
//                    if (produto.equals(item.getProduto())) {
//                        iterator.remove();
//                        break;
//                    }
//                }
//            } else {
//                System.out.println("Não é possível remover itens. O pedido não está mais aberto.");
//            }
//        }
//
//        public void alterarQuantidade(Produto produto, int novaQuantidade) {
//            if (status == StatusPedido.ABERTO) {
//                for (ItemPedido item : itens) {
//                    if (produto.equals(item.getProduto())) {
//                        item.setQuantidade(novaQuantidade);
//                        break;
//                    }
//                }
//            } else {
//                System.out.println("Não é possível alterar a quantidade. O pedido não está mais aberto.");
//            }
//        }
//
//        public void finalizarPedido(String emailCliente) {
//            if (itens.isEmpty()) {
//                System.out.println("O pedido não pode ser finalizado pois não possui itens.");
//                return;
//            }
//            double total = itens.stream().mapToDouble(item -> item.getProduto().getPreco() * item.getQuantidade()).sum();
//            if (total <= 0) {
//                System.out.println("O pedido não pode ser finalizado pois o valor total é inválido.");
//                return;
//            }
//            this.status = StatusPedido.AGUARDANDO_PAGAMENTO;
//            notificacao.enviarEmail(emailCliente, "Seu pedido foi finalizado e está aguardando pagamento.");
//        }
//
//        public void realizarPagamento(String emailCliente) {
//            if (this.status == StatusPedido.AGUARDANDO_PAGAMENTO) {
//                this.status = StatusPedido.PAGO;
//                notificacao.enviarEmail(emailCliente, "Pagamento recebido com sucesso. Seu pedido está sendo processado.");
//            } else {
//                System.out.println("Pagamento não pode ser realizado. O pedido não está aguardando pagamento.");
//            }
//        }
//
//        public void entregar() {
//            if (this.status == StatusPedido.PAGO) {
//                this.status = StatusPedido.FINALIZADO;
//            }
//        }
//
//        public List<ItemPedido> getItens() {
//            return itens;
//        }
//
//        public LocalDate getDataCriacao() {
//            return dataCriacao;
//        }
//
//        public StatusPedido getStatus() {
//            return status;
//        }
//    }
//

package Pedido;

import Produto.Produto;
import Notificacao.Notificacao;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import Cliente.Cliente;

public class Pedido {
    private final UUID id;
    private final Cliente cliente;
    private final List<ItemPedido> itens;
    private StatusPedido status;
    private final LocalDate dataCriacao;
    private final Notificacao notificacao;


    public Pedido(Cliente cliente) {
        this.id = UUID.randomUUID();
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.dataCriacao = LocalDate.now();
        this.status = StatusPedido.ABERTO;
        this.notificacao = new Notificacao();
    }

    public void adicionarItem(Produto produto, int quantidade, double precoVenda) {
        if (status != StatusPedido.ABERTO) return;
        this.itens.add(new ItemPedido(produto, quantidade, precoVenda));
    }

    public void removerItem(UUID produtoId) {
        if (status != StatusPedido.ABERTO) return;
        this.itens.removeIf(item -> item.getProduto().getId().equals(produtoId));
    }

    public void alterarQuantidade(UUID produtoId, int quantidade) {
        if (status != StatusPedido.ABERTO) return;
        for (ItemPedido item : itens) {
            if (item.getProduto().getId().equals(produtoId)) {
                item.setQuantidade(quantidade);
            }
        }
    }


    public void finalizarPedido() {
        if (itens.isEmpty()) return;
        this.status = StatusPedido.AGUARDANDO_PAGAMENTO;
        System.out.println("Pedido finalizado e aguardando pagamento. Email enviado para " + cliente.getNome());
    }

    public void pagarPedido() {
        if (status != StatusPedido.AGUARDANDO_PAGAMENTO) return;
        this.status = StatusPedido.PAGO;
        System.out.println("Pedido pago com sucesso. Email enviado para " + cliente.getNome());
    }

    public void entregarPedido() {
        if (status != StatusPedido.PAGO) return;
        this.status = StatusPedido.FINALIZADO;
        System.out.println("Pedido entregue ao cliente. Email enviado para " + cliente.getNome());
    }


    public UUID getId() {
        return id;
    }

    public StatusPedido getStatus() {
        return status;
    }
}

//    public boolean adicionarItem(Produto produto, int quantidade, double precoVenda) {
//        if (status != StatusPedido.ABERTO) {
//            System.out.println("Não é possível adicionar itens. O pedido não está mais aberto.");
//            return false;
//        }
//        for (ItemPedido item : itens) {
//            if (item.getProduto().equals(produto)) {
//                item.setQuantidade(item.getQuantidade() + quantidade);
//                return true;
//            }
//        }
//        itens.add(new ItemPedido(produto, quantidade));
//        return true;
//    }
//
//    public boolean removerItem(Produto produto) {
//        if (status != StatusPedido.ABERTO) {
//            System.out.println("Não é possível remover itens. O pedido não está mais aberto.");
//            return false;
//        }
//        return itens.removeIf(item -> item.getProduto().equals(produto));
//    }
//
//    public boolean alterarQuantidade(Produto produto, int novaQuantidade) {
//        if (status != StatusPedido.ABERTO || novaQuantidade <= 0) {
//            System.out.println("Não é possível alterar a quantidade. O pedido não está mais aberto ou quantidade inválida.");
//            return false;
//        }
//        for (ItemPedido item : itens) {
//            if (item.getProduto().equals(produto)) {
//                item.setQuantidade(novaQuantidade);
//                return true;
//            }
//        }
//        return false;
//    }
//    public boolean finalizarPedido() {
//        if (itens.isEmpty()) {
//            System.out.println("O pedido não pode ser finalizado pois não possui itens.");
//            return false;
//        }
//        double total = itens.stream().mapToDouble(item -> item.getProduto().getPreco() * item.getQuantidade()).sum();
//        if (total <= 0) {
//            System.out.println("O pedido não pode ser finalizado pois o valor total é inválido.");
//            return false;
//        }
//        this.status = StatusPedido.AGUARDANDO_PAGAMENTO;
//        notificacao.enviarEmail(cliente.getEmail(),
//                "Seu pedido foi finalizado e está aguardando pagamento.");
//        return true;
//    }
//
//    public boolean realizarPagamento() {
//        if (this.status != StatusPedido.AGUARDANDO_PAGAMENTO) {
//            System.out.println("Pagamento não pode ser realizado. O pedido não está aguardando pagamento.");
//            return false;
//        }
//        this.status = StatusPedido.PAGO;
//        notificacao.enviarEmail(cliente.getEmail(), "Pagamento recebido com sucesso. Seu pedido está sendo processado.");
//        return true;
//    }
//
//    public boolean entregar() {
//        if (this.status != StatusPedido.PAGO) {
//            System.out.println("Entrega não pode ser realizada. O pedido não está pago.");
//            return false;
//        }
//        this.status = StatusPedido.FINALIZADO;
//        return true;
//    }
//
//    public UUID getId() {
//        return id;
//    }
//
//    public Cliente getCliente() {
//        return cliente;
//    }
//
//    public List<ItemPedido> getItens() {
//        return new ArrayList<>(itens);
//    }
//
//    public LocalDate getDataCriacao() {
//        return dataCriacao;
//    }
//
//    public StatusPedido getStatus() {
//        return status;
//    }
//
//}