package br.com.lojavirtual.singleton;

import br.com.lojavirtual.model.Pedido;

import java.util.Random;

public class PagamentoService {

    private static PagamentoService instancia;
    private Random random = new Random();

    // construtor privado pra garantir q só vai ter 1 instancia
    private PagamentoService() {
    }

    // metodo para acessar a única instância
    public static PagamentoService getInstancia() {
        if (instancia == null) {
            instancia = new PagamentoService();
        }
        return instancia;
    }

    // simulação do pagamento
    public boolean processarPagamento(Pedido pedido) {

        System.out.println("\n=== PROCESSANDO PAGAMENTO ===");
        System.out.println("Conectando ao sistema externo...");
        System.out.println("Pedido ID: " + pedido.id);
        System.out.println("Valor total: R$ " + pedido.calcularTotal());

        // simula sucesso ou falha (80% sucesso)
        boolean sucesso = random.nextInt(10) < 8;

        return sucesso;
    }
}