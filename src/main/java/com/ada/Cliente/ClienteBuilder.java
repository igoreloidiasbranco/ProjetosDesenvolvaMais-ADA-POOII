package com.ada.Cliente;

import java.util.UUID;

public class ClienteBuilder {

    private UUID id;
    private String nome;
    private String documento;

    public ClienteBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ClienteBuilder comDocumento(String documento) {
        this.documento = documento;
        return this;
    }

    public Cliente construir() {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        if (documento == null || documento.trim().isEmpty()) {
            throw new IllegalArgumentException("Documento não pode ser nulo ou vazio.");
        }
        return new Cliente(nome, documento);
    }
}
