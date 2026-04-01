package br.com.lojavirtual.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    public int id;
    public Cliente cliente;
    //Vetor q guardar os itens do pedido
    public List<ItemPedido> itens;
    public String status;
    public double valorTotal;

    private static int contador = 0;

    public Pedido( Cliente cliente) {
        this.id = contador++;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.status = "CRIADO";
        this.valorTotal = 0;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
        valorTotal += item.getSubtotal();
    }

    public double calcularTotal() {
        double total = 0;
        //soma todos os subtotais dos itens
        for (ItemPedido item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}