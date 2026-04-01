package br.com.lojavirtual.model;

public class ItemPedido {

    public Produto produto;
    public int quantidade;
    public double subtotal;

    public ItemPedido( Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        //calcula o valor subtotal automatico no momento da instancia
        this.subtotal = calcularSubtotal();
    }

    public double calcularSubtotal() {
        return produto.preco * quantidade;
    }

    public double getSubtotal() {
        return subtotal;
    }
}