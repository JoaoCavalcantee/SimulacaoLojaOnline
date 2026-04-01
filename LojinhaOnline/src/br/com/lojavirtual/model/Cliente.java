package br.com.lojavirtual.model;

import java.util.List;

public class Cliente {

    public String nome;
    public String cliente_id;
    public String telefone;
    public String email;
    private List<Pedido> pedidos;

    public Cliente(String nome, String cliente_id, String telefone, String email) {
        this.nome = nome;
        this.cliente_id = cliente_id;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(String cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
