package br.com.lojavirtual.service;

import br.com.lojavirtual.model.*;
import br.com.lojavirtual.singleton.PagamentoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LojaService {

    private List<Cliente> clientes = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();

    private Random random = new Random();

    public LojaService() {

        // 5 clientes padrão
        clientes.add(new Cliente("João", "1", "(61) 99911-2233", "joao@gmail.com"));
        clientes.add(new Cliente("Maria", "2", "(61) 98822-3344", "maria@gmail.com"));
        clientes.add(new Cliente("Carlos", "3", "(61) 97733-4455", "carlos@gmail.com"));
        clientes.add(new Cliente("Ana", "4", "(61) 96644-5566", "ana@gmail.com"));
        clientes.add(new Cliente("Fernanda", "5", "(61) 95555-6677", "fernanda@gmail.com"));

        // produtos
        produtos.add(new Produto(1, "Notebook Dell Inspiron 15", 3899.90, 8, "Notebook 15.6'' com SSD e 8GB RAM"));
        produtos.add(new Produto(2, "Mouse Logitech M170", 79.90, 40, "Mouse sem fio com conexão USB"));
        produtos.add(new Produto(3, "Teclado Mecânico Redragon Kumara", 229.90, 25, "Teclado mecânico com iluminação LED"));
        produtos.add(new Produto(4, "Monitor LG 24'' Full HD", 899.90, 12, "Monitor IPS 24 polegadas Full HD"));
        produtos.add(new Produto(5, "Headset HyperX Cloud Stinger", 299.90, 18, "Headset gamer com microfone ajustável"));
        produtos.add(new Produto(6, "SSD Kingston 480GB", 279.90, 30, "SSD SATA para upgrade de desempenho"));
        produtos.add(new Produto(7, "HD Externo Seagate 1TB", 349.90, 20, "HD portátil USB 3.0"));
        produtos.add(new Produto(8, "Webcam Logitech C270", 199.90, 15, "Webcam HD 720p com microfone embutido"));
        produtos.add(new Produto(9, "Cadeira Gamer ThunderX3", 1199.90, 10, "Cadeira ergonômica com ajuste de altura"));
        produtos.add(new Produto(10, "Fonte Corsair 500W", 349.90, 22, "Fonte de alimentação 80 Plus Bronze"));
    }

    //  cliente aleatório
    public Cliente buscarCliente() {
        int indice = random.nextInt(clientes.size());
        return clientes.get(indice);
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    //pra verificar se o id do produto digitado existe msm
    public Produto buscarProduto(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) return p;
        }
        return null;
    }
    //cria o pedido dps de ser chamado la no switch do main
    public Pedido criarPedido( Cliente cliente) {
        Pedido pedido = new Pedido(cliente);
        pedidos.add(pedido);
        return pedido;
    }
    // Cria
    public void adicionarItem(Pedido pedido, Produto produto, int quantidade) {
        //cria o item, na craição do item ele ja calcula o valor subtotal automatico
        ItemPedido item = new ItemPedido(produto, quantidade);
        //adiciona ao vetor de itens do pedido
        pedido.adicionarItem(item);
    }

    public void finalizarPedido(Pedido pedido) {
        //cria uma instacia de pagamento
        PagamentoService pagamento = PagamentoService.getInstancia();

        //manda pra instancia q acabou de ser criada  pra ver se vai ser aceito ou nao
        boolean sucesso = pagamento.processarPagamento(pedido);

        if (sucesso) {
            pedido.setStatus("PAGO");
            System.out.println("Pagamento aprovado!");
        } else {
            pedido.setStatus("FALHOU");
            System.out.println("Pagamento recusado!");
        }
    }
}