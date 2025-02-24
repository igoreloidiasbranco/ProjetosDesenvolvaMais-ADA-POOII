package Pedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import Notificação.Notificacao;
import Produto.Produto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

    public class Pedido {
        private UUID id;
        private List<ItemPedido> itens;
        private LocalDate dataCriacao;
        private StatusPedido status;
        private Notificacao notificacao;

        public Pedido() {
            this.id = UUID.randomUUID();
            this.itens = new ArrayList<>();
            this.dataCriacao = LocalDate.now();
            this.status = StatusPedido.ABERTO;
            this.notificacao = new Notificacao();
        }

        public void adicionarItem(Produto produto, int quantidade) {
            if (status == StatusPedido.ABERTO) {
                itens.add(new ItemPedido(produto, quantidade));
            } else {
                System.out.println("Não é possível adicionar itens. O pedido não está mais aberto.");
            }
        }

        public void removerItem(Produto produto) {
            if (status == StatusPedido.ABERTO) {
                Iterator<ItemPedido> iterator = itens.iterator();
                while (iterator.hasNext()) {
                    ItemPedido item = iterator.next();
                    if (produto.equals(item.getProduto())) {
                        iterator.remove();
                        break;
                    }
                }
            } else {
                System.out.println("Não é possível remover itens. O pedido não está mais aberto.");
            }
        }

        public void alterarQuantidade(Produto produto, int novaQuantidade) {
            if (status == StatusPedido.ABERTO) {
                for (ItemPedido item : itens) {
                    if (produto.equals(item.getProduto())) {
                        item.setQuantidade(novaQuantidade);
                        break;
                    }
                }
            } else {
                System.out.println("Não é possível alterar a quantidade. O pedido não está mais aberto.");
            }
        }

        public void finalizarPedido(String emailCliente) {
            if (itens.isEmpty()) {
                System.out.println("O pedido não pode ser finalizado pois não possui itens.");
                return;
            }
            double total = itens.stream().mapToDouble(item -> item.getProduto().getPreco() * item.getQuantidade()).sum();
            if (total <= 0) {
                System.out.println("O pedido não pode ser finalizado pois o valor total é inválido.");
                return;
            }
            this.status = StatusPedido.AGUARDANDO_PAGAMENTO;
            notificacao.enviarEmail(emailCliente, "Seu pedido foi finalizado e está aguardando pagamento.");
        }

        public void realizarPagamento(String emailCliente) {
            if (this.status == StatusPedido.AGUARDANDO_PAGAMENTO) {
                this.status = StatusPedido.PAGO;
                notificacao.enviarEmail(emailCliente, "Pagamento recebido com sucesso. Seu pedido está sendo processado.");
            } else {
                System.out.println("Pagamento não pode ser realizado. O pedido não está aguardando pagamento.");
            }
        }

        public void entregar() {
            if (this.status == StatusPedido.PAGO) {
                this.status = StatusPedido.FINALIZADO;
            }
        }

        public List<ItemPedido> getItens() {
            return itens;
        }

        public LocalDate getDataCriacao() {
            return dataCriacao;
        }

        public StatusPedido getStatus() {
            return status;
        }
    }

