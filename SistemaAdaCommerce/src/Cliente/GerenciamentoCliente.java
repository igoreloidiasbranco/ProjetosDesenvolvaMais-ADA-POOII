package Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GerenciamentoCliente {


    private List<Cliente> listaClientes = new ArrayList<>();

    public void cadastrarCliente(Cliente cliente) {
        listaClientes.add(cliente);
        System.out.println("Cliente cadastrado");
    }

    public void listarCliente() {

        for (Cliente cliente : listaClientes) {
            System.out.println("Id do Cliente: " + cliente.getId());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Documento: " + cliente.getDocumento());
            System.out.println();
        }
    }

    public void atualizarCliente (UUID idCliente) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getId().equals(idCliente)) {
                listaClientes.remove(cliente);
            }
            else {
                System.out.println("Id não encontrado");
            }
            Cliente clienteParaAtualizar = ClienteBuilder.criarCliente();
            clienteParaAtualizar.setId(idCliente);
            listaClientes.add(clienteParaAtualizar);
            System.out.println("Cliente atualizado");
        }
    }
}
