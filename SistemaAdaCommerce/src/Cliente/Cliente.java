package Cliente;

import java.util.UUID;
import java.util.Objects;

public final class Cliente {

    private final UUID id;
    private String nome;
    private String documento;

    public Cliente(String nome, String documento) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        if (documento == null || documento.trim().isEmpty()) {
            throw new IllegalArgumentException("Documento não pode ser nulo ou vazio.");
        }

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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void atualizarDados(String nome, String documento) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        if (documento == null || documento.trim().isEmpty()) {
            throw new IllegalArgumentException("Documento não pode ser nulo ou vazio.");
        }

        this.nome = nome;
        this.documento = documento;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente cliente = (Cliente) obj;
        return id.equals(cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
