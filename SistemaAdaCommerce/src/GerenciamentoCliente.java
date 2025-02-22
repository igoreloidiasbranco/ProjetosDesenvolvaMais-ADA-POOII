import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class GerenciamentoCliente {


    private static List<Cliente> listaClientes = new ArrayList<>();

    public static void cadastrarCliente(Cliente cliente) {
        listaClientes.add(cliente);
        System.out.println("Cliente cadastrado");
    }

    public static void listarCliente() {

        for (Cliente cliente : listaClientes) {
            System.out.println("Id do Cliente : " + cliente.getId());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Documento: " + cliente.getDocumento());
            System.out.println();
        }
    }

    public static void atualizarCliente (UUID idCliente) {
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
