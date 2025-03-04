package com.ada.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class GerenciamentoCliente {

    private final List<Cliente> listaClientes = new ArrayList<>();

    public void cadastrarCliente(Cliente cliente) {
        listaClientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso.");
    }

    public void listarClientes() {
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("Lista de Clientes:");
        for (Cliente cliente : listaClientes) {
            System.out.println("ID: " + cliente.getId());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Documento: " + cliente.getDocumento());
            System.out.println("------------------------");
        }
    }

    public void atualizarCliente(UUID idCliente, String novoNome, String novoDocumento) {
        Optional<Cliente> clienteOpt = listaClientes.stream()
                .filter(cliente -> cliente.getId().equals(idCliente))
                .findFirst();

        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            cliente.atualizarDados(novoNome, novoDocumento);
            System.out.println("Cliente atualizado com sucesso.");
        } else {
            System.out.println("Cliente com ID " + idCliente + " não encontrado.");
        }
    }

    public List<Cliente> getListaClientes() {
        return new ArrayList<>(listaClientes); // Retorna uma cópia para evitar modificações diretas.
    }
}
