package Cliente;

import java.util.UUID;

public class Cliente {

    private UUID id;
    private String nome;
    private String documento;

    public Cliente(String nome, String documento) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.documento = documento;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
